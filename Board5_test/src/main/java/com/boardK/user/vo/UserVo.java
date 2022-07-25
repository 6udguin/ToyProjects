package com.boardK.user.vo;

public class UserVo {
	// Fields
	private String userid;
	private String passwd;
	private String username;
	private String phoneNum;
	private String post;
	private String birth;
	private String indate;
	private String gender;
	private String intro;
	private String usertype;

	// Constructor
	public UserVo() {
	}

	public UserVo(String userid, String passwd, String username, String phoneNum, String post, String birth,
			String indate, String gender, String intro, String usertype) {
		super();
		this.userid = userid;
		this.passwd = passwd;
		this.username = username;
		this.phoneNum = phoneNum;
		this.post = post;
		this.birth = birth;
		this.indate = indate;
		this.gender = gender;
		this.intro = intro;
		this.usertype = usertype;
	}

	// Getter Setter
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	// toString
	@Override
	public String toString() {
		return "UserVo [userid=" + userid + ", passwd=" + passwd + ", username=" + username + ", phoneNum=" + phoneNum
				+ ", post=" + post + ", birth=" + birth + ", indate=" + indate + ", gender=" + gender + ", intro="
				+ intro + ", usertype=" + usertype + "]";
	}

}
