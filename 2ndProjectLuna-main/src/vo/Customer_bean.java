package vo;

import java.util.Date;

public class Customer_bean {
	private String CUS_ID;
	private String CUS_PWD;
	private String CUS_NAME;
	private String CUS_ADDR;
	private String CUS_TEL;
	private Date CUS_REGDATE;
	private String CUS_PROFILE_PATH;
	
	
	public String getCUS_PROFILE_PATH() {
		return CUS_PROFILE_PATH;
	}

	public void setCUS_PROFILE_PATH(String cUS_PROFILE_PATH) {
		CUS_PROFILE_PATH = cUS_PROFILE_PATH;
	}

	public Customer_bean() {
		
	}
	
	public Customer_bean(String cUS_ID, String cUS_PWD, String cUS_NAME, String cUS_ADDR, String cUS_TEL,
			Date cUS_REGDATE) {
		CUS_ID = cUS_ID;
		CUS_PWD = cUS_PWD;
		CUS_NAME = cUS_NAME;
		CUS_ADDR = cUS_ADDR;
		CUS_TEL = cUS_TEL;
		CUS_REGDATE = cUS_REGDATE;
	}
	
	public Customer_bean(String cUS_ID, String cUS_PWD, String cUS_NAME, String cUS_PROFILE_PATH, String cUS_ADDR, String cUS_TEL,
			Date cUS_REGDATE) {
		CUS_ID = cUS_ID;
		CUS_PWD = cUS_PWD;
		CUS_NAME = cUS_NAME;
		CUS_ADDR = cUS_ADDR;
		CUS_TEL = cUS_TEL;
		CUS_REGDATE = cUS_REGDATE;
		CUS_PROFILE_PATH = cUS_PROFILE_PATH;
	}
	
	
	public String getCUS_ID() {
		return CUS_ID;
	}
	public void setCUS_ID(String cUS_ID) {
		CUS_ID = cUS_ID;
	}
	public String getCUS_PWD() {
		return CUS_PWD;
	}
	public void setCUS_PWD(String cUS_PWD) {
		CUS_PWD = cUS_PWD;
	}
	public String getCUS_NAME() {
		return CUS_NAME;
	}
	public void setCUS_NAME(String cUS_NAME) {
		CUS_NAME = cUS_NAME;
	}
	public String getCUS_ADDR() {
		return CUS_ADDR;
	}
	public void setCUS_ADDR(String cUS_ADDR) {
		CUS_ADDR = cUS_ADDR;
	}
	public String getCUS_TEL() {
		return CUS_TEL;
	}
	public void setCUS_TEL(String cUS_TEL) {
		CUS_TEL = cUS_TEL;
	}
	public Date getCUS_REGDATE() {
		return CUS_REGDATE;
	}
	public void setCUS_REGDATE(Date cUS_REGDATE) {
		CUS_REGDATE = cUS_REGDATE;
	}
	
	public boolean matchPassword(String pwd) {
		
		return CUS_PWD.equals(pwd);
		
	}
	public void changePassword(String newPwd) {
		this.CUS_PWD = newPwd;
	}
	
	
}
