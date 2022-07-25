package com.boardK.recomm.vo;

public class RecommVo {
	// Fields
	private String comcont;
	private String userid;
	private String menu_id;
	private int idx;
	private String indate;

	// Constructor
	public RecommVo() {
	}

	public RecommVo(String comcont, String userid, String menu_id, int idx, String indate) {
		super();
		this.comcont = comcont;
		this.userid = userid;
		this.menu_id = menu_id;
		this.idx = idx;
		this.indate = indate;
	}

	// Getter, Setter
	public String getComcont() {
		return comcont;
	}

	public void setComcont(String comcont) {
		this.comcont = comcont;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	// toString
	@Override
	public String toString() {
		return "RecommVo [comcont=" + comcont + ", userid=" + userid + ", menu_id=" + menu_id + ", idx=" + idx
				+ ", indate=" + indate + "]";
	}

}
