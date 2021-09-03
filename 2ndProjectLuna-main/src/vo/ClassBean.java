package vo;

import java.sql.Date;

public class ClassBean {
	private int CL_ID;
	private String CL_NAME;
	private String CL_WRITER_ID;
	private String CL_CATEGORY;
	private String CL_CONTENT;
	private String CL_INTRODUCTION;
	private Date CL_START_DATE;
	private Date CL_END_DATE;
	private String CL_LOCATION;
	private int CL_CAPACITY;
	private String CL_IMG_PATH;
	private int CL_VIEW;
	private Date CL_REGDATE;
	private Date CL_MODIFYDATE;
	private int CL_MODIFYCHECK;

	public int getCL_MODIFYCHECK() {
		return CL_MODIFYCHECK;
	}

	public void setCL_MODIFYCHECK(int cL_MODIFYCHECK) {
		CL_MODIFYCHECK = cL_MODIFYCHECK;
	}

	public Date getCL_MODIFYDATE() {
		return CL_MODIFYDATE;
	}

	public void setCL_MODIFYDATE(Date cL_MODIFYDATE) {
		CL_MODIFYDATE = cL_MODIFYDATE;
	}

	public Date getCL_REGDATE() {
		return CL_REGDATE;
	}

	public void setCL_REGDATE(Date cL_REGDATE) {
		CL_REGDATE = cL_REGDATE;
	}

	public String getCL_INTRODUCTION() {
		return CL_INTRODUCTION;
	}
	
	public void setCL_INTRODUCTION(String cL_INTRODUCTION) {
		CL_INTRODUCTION = cL_INTRODUCTION;
	}
	
	public String getCL_CATEGORY() {
		return CL_CATEGORY;
	}

	public void setCL_CATEGORY(String cL_CATEGORY) {
		CL_CATEGORY = cL_CATEGORY;
	}

	public int getCL_ID() {
		return CL_ID;
	}

	public void setCL_ID(int cL_ID) {
		CL_ID = cL_ID;
	}

	public String getCL_NAME() {
		return CL_NAME;
	}

	public void setCL_NAME(String cL_NAME) {
		CL_NAME = cL_NAME;
	}

	public String getCL_WRITER_ID() {
		return CL_WRITER_ID;
	}

	public void setCL_WRITER_ID(String cL_WRITER_ID) {
		CL_WRITER_ID = cL_WRITER_ID;
	}

	public String getCL_CONTENT() {
		return CL_CONTENT;
	}

	public void setCL_CONTENT(String cL_CONTENT) {
		CL_CONTENT = cL_CONTENT;
	}

	public Date getCL_START_DATE() {
		return CL_START_DATE;
	}

	public void setCL_START_DATE(Date cL_START_DATE) {
		CL_START_DATE = cL_START_DATE;
	}

	public Date getCL_END_DATE() {
		return CL_END_DATE;
	}

	public void setCL_END_DATE(Date cL_END_DATE) {
		CL_END_DATE = cL_END_DATE;
	}

	public String getCL_LOCATION() {
		return CL_LOCATION;
	}

	public void setCL_LOCATION(String cL_LOCATION) {
		CL_LOCATION = cL_LOCATION;
	}

	public int getCL_CAPACITY() {
		return CL_CAPACITY;
	}

	public void setCL_CAPACITY(int cL_CAPACITY) {
		CL_CAPACITY = cL_CAPACITY;
	}

	public String getCL_IMG_PATH() {
		return CL_IMG_PATH;
	}

	public void setCL_IMG_PATH(String cL_IMG_PATH) {
		CL_IMG_PATH = cL_IMG_PATH;
	}

	public int getCL_VIEW() {
		return CL_VIEW;
	}

	public void setCL_VIEW(int cL_VIEW) {
		CL_VIEW = cL_VIEW;
	}

}
