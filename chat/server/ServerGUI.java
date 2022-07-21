package chat.server;
 
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
 
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 
public class ServerGUI extends JFrame implements ActionListener{
    
    private static final long serialVersionUID =1L;
    private JTextArea jta = new JTextArea(40,25);
    private JTextField jtf = new JTextField(25);
    private ServerBackground server = new ServerBackground();
    
    public ServerGUI() throws IOException{
        
        add(jta, BorderLayout.CENTER);
        add(jtf, BorderLayout.SOUTH);
        jtf.addActionListener(this);  // 이벤트 연결
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(200, 100, 400, 600);
        setTitle("서버부분");
        server.setGui(this); 
         // ServerBackground class 에게 내 class의 정보( this )를 보내준다
         // why : ServerBackground class 에서 ServerGui 의 jta(textarea) 에 글자 추가해야함
         //       ServerBackground class 에서 ServerGui 의 Field나 method를 조작할 수 있다
        server.setting(); //GUI가 실행될때 서버도 같이 동작하도록..
    }
    
    public static void main(String[] args) throws IOException{
        new ServerGUI();
    }
    
    // JtextField 에 기본이벤트(keypress)가 발생하면
    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = "서버 : " +jtf.getText() + "\n";
        System.out.print(msg);
        server.sendMessage(msg); // ServerBackground 에 있는 sendMessage() 함수를 호출한다
        appendMsg(msg);          // textarea 에 msg 를 추가
        jtf.setText("");
    }
    
    public void appendMsg(String msg) {
        jta.append(msg);
    }
}




