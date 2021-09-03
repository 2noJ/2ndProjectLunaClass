package vo;

import java.util.Map;

public class Join_bean {
	private String CUS_ID;
	private String CUS_PWD;
	private String CUS_NAME;
	private String CUS_ADDR;
	private String CUS_TEL;
	private String CUS_CONFIRMPASSWORD;
	
	
	public Join_bean() {};
	public Join_bean(String cUS_ID, String cUS_PWD, String cUS_NAME, String cUS_ADDR, String cUS_TEL,
			String cUS_CONFIRMPASSWORD) {
		CUS_ID = cUS_ID;
		CUS_PWD = cUS_PWD;
		CUS_NAME = cUS_NAME;
		CUS_ADDR = cUS_ADDR;
		CUS_TEL = cUS_TEL;
		CUS_CONFIRMPASSWORD = cUS_CONFIRMPASSWORD;
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
	public String getCUS_CONFIRMPASSWORD() {
		return CUS_CONFIRMPASSWORD;
	}
	public void setCUS_CONFIRMPASSWORD(String cUS_CONFIRMPASSWORD) {
		CUS_CONFIRMPASSWORD = cUS_CONFIRMPASSWORD;
	}
	
	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors, CUS_ID, "id");
		checkEmpty(errors, CUS_PWD, "password");
		checkEmpty(errors, CUS_NAME, "name");
		checkEmpty(errors, CUS_TEL, "tel");
		checkEmpty(errors, CUS_CONFIRMPASSWORD, "confirmpassword");
		if (!errors.containsKey("confirmPassword")) {
			if (!isPasswordEqualToConfirm()) {
				errors.put("notMatch", Boolean.TRUE);
			}
		}
	}
	
	public boolean isPasswordEqualToConfirm() {
		return CUS_PWD != null && CUS_PWD.equals(CUS_CONFIRMPASSWORD);
	}
	private void checkEmpty(Map<String, Boolean> errors,
			String value, String fieldName) {
		if (value == null || value.isEmpty())
			errors.put(fieldName, Boolean.TRUE);
	}
}
