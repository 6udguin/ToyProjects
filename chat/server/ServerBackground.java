package chat.server;
 
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
 
import javax.sound.midi.Receiver;
 
public class ServerBackground {
 
    private ServerSocket serverSocket; // 서버 소켓
    private Socket socket; // 받아올 소켓 저장
    private ServerGUI gui;
    private String msg;
    /** XXX 03. 사용자들의 정보를 저장하는 맵 */ 
    private Map<String, DataOutputStream> clientMap 
        = new HashMap<String, DataOutputStream>();
 
    public void setGui(ServerGUI gui) {
        this.gui = gui;
    }
 
    public static void main(String[] args) {
       // ServerBackground serverBackground = new ServerBackground();
       // serverBackground.setting();
    }
    //서버가 생성될때 셋팅해주는 함수 
    public void setting() {
        
        try {            
            Collections.synchronizedMap(clientMap);
              //교통정리를 해준다.( clientMap을 네트워크 처리해주는것 ) 
            serverSocket = new ServerSocket(7777); // port : 7777  bind 역활 수행
 
            while (true) {
                /** XXX 01.서버가 할일 : 방문자를 계속 받아서, 쓰레드 리시버를 계속 생성 */
                
                System.out.println("대기중.....");
                socket = serverSocket.accept(); // 여기서 클라이언트 받음
                System.out.println(socket.getInetAddress() + "에서 접속했습니다.");
                
                //여기서 새로운 사용자 스레드 클래스를 생성해서 소켓 정보를 넣어줘야한다.
                //  Receiver 처리를 위한 Thread 를 시작( start() )한다
                Receiver receiver = new Receiver(socket);
                receiver.start();   // thread 실행
            }
 
        } catch (IOException e) {
           // e.printStackTrace();
        }
    }
    
    //맵의내용(클라이언트) 저장과 삭제 
    public void addClient(String nick, DataOutputStream out) throws IOException{
        String message=nick + "님이 접속하셨습니다.\n";
        sendMessage(message);
        gui.appendMsg(message);  // ServerGui 에 있는 함수를 호출( appendMsg() )
        clientMap.put(nick, out);  // 클라이언트 정보를 Map 에 저장
        
    }
    
    public void removeClient(String nick){
        String message=nick + "님이 나가셨습니다. \n";
        sendMessage(message);
        gui.appendMsg(message);
        clientMap.remove(nick);
    }
    
    //메세지 내용 전파 - 연결된 클라이언트 전부에게 
    public void sendMessage (String msg){
        Iterator<String> iterator = clientMap.keySet().iterator(); //key셋으로 반복자지정
        String key = "";
        
        while(iterator.hasNext()){
            key = iterator.next();// 반복자에서 하나하나 키를 빼온다.
            try{
                clientMap.get(key).writeUTF(msg);
            } catch(IOException e){
               // e.printStackTrace();
            }
        }
    }
    
    // ------------------리시버---------------------------
    class Receiver extends Thread {
        /** XXX 리시버가 할일 : 네트워크 소켓을 받아서 계속듣고 보내는 일. */
        private DataInputStream  in; // 데이터 입력 스트림
        private DataOutputStream out; // 데이터 아웃풋 스트림
        private String nick;
 
        // 생성자
        public Receiver(Socket socket) {
            try {
                out = new DataOutputStream(socket.getOutputStream());
                in = new DataInputStream(socket.getInputStream());
                nick = in.readUTF();   // client 가 보내준 정보
                addClient(nick,out);
            } catch (IOException e) {
               // e.printStackTrace();
            }
        }
 
        @Override
        public void run() {
 
            try {
                while (in != null) {
                    msg = in.readUTF(); // UTF로 읽어들인다.
                    sendMessage(msg);     // 연결된 클라이언트 전부에게 메세지을 보낸다
                    gui.appendMsg(msg); // gui 에 추가한다 메세지
                }
            } catch (Exception e) {
                //사용접속종료시 여기서 에러발생. 
                removeClient(nick);
            }
        }
    }
 
}
 