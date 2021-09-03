package vo;

import java.util.Date;

public class Mag_replyBean {
	private int comment_num;
    private String comment_id;       
    private Date comment_date;       
    private String comment_content;
    private int comment_board;
    private String comment_class_name;
    private String comment_class_writer_name;
 
    
    
    
	public String getComment_class_writer_name() {
		return comment_class_writer_name;
	}
	public void setComment_class_writer_name(String comment_class_writer_name) {
		this.comment_class_writer_name = comment_class_writer_name;
	}
	public String getComment_class_name() {
		return comment_class_name;
	}
	public void setComment_class_name(String comment_class_name) {
		this.comment_class_name = comment_class_name;
	}
	public int getComment_board() {
		return comment_board;
	}
	public void setComment_board(int comment_board) {
		this.comment_board = comment_board;
	}
	public String getComment_id() {
		return comment_id;
	}
	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}
	public Date getComment_date() {
		return comment_date;
	}
	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}
	
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public int getComment_num() {
		return comment_num;
	}
	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}
	
	

}
