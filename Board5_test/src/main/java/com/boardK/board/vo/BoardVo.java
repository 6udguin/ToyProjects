package com.boardK.board.vo;

public class BoardVo {
	// Fields
	private int idx;
	private String menu_id;
	private String title;
	private String cont;
	private String writer;
	private String status;
	private String creat_date;
	private String update_date;
	private String delete_date;

	// Constructor
	public BoardVo() {
	}

	public BoardVo(int idx, String menu_id, String title, String cont, String writer, String status, String creat_date,
			String update_date, String delete_date) {
		super();
		this.idx = idx;
		this.menu_id = menu_id;
		this.title = title;
		this.cont = cont;
		this.writer = writer;
		this.status = status;
		this.creat_date = creat_date;
		this.update_date = update_date;
		this.delete_date = delete_date;
	}

	// Getter, Setter
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCont() {
		return cont;
	}

	public void setCont(String cont) {
		this.cont = cont;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreat_date() {
		return creat_date;
	}

	public void setCreat_date(String creat_date) {
		this.creat_date = creat_date;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	public String getDelete_date() {
		return delete_date;
	}

	public void setDelete_date(String delete_date) {
		this.delete_date = delete_date;
	}

	// toString
	@Override
	public String toString() {
		return "BoardVo [idx=" + idx + ", menu_id=" + menu_id + ", title=" + title + ", cont=" + cont + ", writer="
				+ writer + ", status=" + status + ", creat_date=" + creat_date + ", update_date=" + update_date
				+ ", delete_date=" + delete_date + "]";
	}

}
