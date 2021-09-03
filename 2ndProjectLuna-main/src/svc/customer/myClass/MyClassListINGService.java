package svc.customer.myClass;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.CustomerDAO;
import vo.ClassBean;
import vo.User;

public class MyClassListINGService {
	public int getClassListCount(User authUser) throws Exception {
		int listCount = 0;
		Connection con = getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		listCount = customerDAO.selectClassListINGCount(authUser);
		close(con);
		return listCount;

	}

	public ArrayList<ClassBean> getClassList(User authUser, int page, int limit) throws Exception {

		ArrayList<ClassBean> articleList = null;
		Connection con = getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		articleList = customerDAO.selectMyClassListING(authUser, page, limit);
		close(con);
		return articleList;

	}
	
public ArrayList<Integer> getHeadCount(User authUser, int page, int limit) throws Exception{
		
		ArrayList<ClassBean> articleList = null;
		Connection con = getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		articleList = customerDAO.selectMyClassListING(authUser, page, limit);
		ArrayList<Integer> headCounts = new ArrayList<Integer>();
			
		
		for (int i = 0; i < articleList.size(); i++) {
			headCounts.add(i,customerDAO.headCount(articleList.get(i).getCL_ID()));
		
		}
		close(con);
		
		
		return headCounts;
	}

}
