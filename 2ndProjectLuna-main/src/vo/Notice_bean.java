package vo;

import java.util.Date;

public class Notice_bean {
	private int NOTICE_ID;
	private String NOTICE_TITLE;
	private String NOTICE_CONTENT;
	private Date NOTICE_REGDATE;
	private int NOTICE_VIEWCOUNT;
	
	public int getNOTICE_ID() {
		return NOTICE_ID;
	}
	public void setNOTICE_ID(int nOTICE_ID) {
		NOTICE_ID = nOTICE_ID;
	}
	public String getNOTICE_TITLE() {
		return NOTICE_TITLE;
	}
	public void setNOTICE_TITLE(String nOTICE_TITLE) {
		NOTICE_TITLE = nOTICE_TITLE;
	}
	public String getNOTICE_CONTENT() {
		return NOTICE_CONTENT;
	}
	public void setNOTICE_CONTENT(String nOTICE_CONTENT) {
		NOTICE_CONTENT = nOTICE_CONTENT;
	}
	public Date getNOTICE_REGDATE() {
		return NOTICE_REGDATE;
	}
	public void setNOTICE_REGDATE(Date nOTICE_REGDATE) {
		NOTICE_REGDATE = nOTICE_REGDATE;
	}
	public int getNOTICE_VIEWCOUNT() {
		return NOTICE_VIEWCOUNT;
	}
	public void setNOTICE_VIEWCOUNT(int nOTICE_VIEWCOUNT) {
		NOTICE_VIEWCOUNT = nOTICE_VIEWCOUNT;
	}

}

