package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.CustomerDAO;
import dao.NoticeDAO;
import vo.ClassBean;
import vo.Notice_bean;

public class IndexService {

	
	
	public ArrayList<Notice_bean> getNotice() throws Exception {
		ArrayList<Notice_bean> noticeList = new ArrayList<Notice_bean>();
		Connection con = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstance();
		noticeDAO.setConnection(con);
		noticeList = noticeDAO.selectNoticeList();
		
		
		close(con);
		
		return noticeList;
	}
	
	
	public ArrayList<ClassBean> getclassList() throws Exception {
		ArrayList<ClassBean> classList = new ArrayList<ClassBean>();
		Connection con = getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		ClassBean artClass = new ClassBean();
		ClassBean lifeClass = new ClassBean();
		ClassBean healthClass = new ClassBean();
		ClassBean developmentClass = new ClassBean();
		ClassBean therapyClass = new ClassBean();
		ClassBean etcClass = new ClassBean();
		
		
		artClass = customerDAO.getOneClass("art");
		lifeClass = customerDAO.getOneClass("life");
		healthClass = customerDAO.getOneClass("health");
		developmentClass = customerDAO.getOneClass("development");
		therapyClass = customerDAO.getOneClass("therapy");
		etcClass = customerDAO.getOneClass("etc");
		
		classList.add(artClass);
		classList.add(lifeClass);
		classList.add(healthClass);
		classList.add(developmentClass);
		classList.add(therapyClass);
		classList.add(etcClass);
		
		close(con);
		return classList;
	}
	
	
	
	
	
	public int countClass() {
		int countClass=0;
		Connection con = getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		countClass = customerDAO.getCountClass();
		close(con);
		return countClass;
	}
	public int countCustomer() {
		int countCustomer=0;
		Connection con = getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		countCustomer = customerDAO.getCountCustomer();
		close(con);
		return countCustomer;
	}
	public int countClassING() {
		int countClassING=0;
		Connection con = getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		countClassING = customerDAO.getCountClassING();
		close(con);
		return countClassING;
	}
}
