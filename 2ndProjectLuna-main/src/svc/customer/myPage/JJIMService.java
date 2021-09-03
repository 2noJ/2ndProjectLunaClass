package svc.customer.myPage;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.CustomerDAO;
import vo.ClassBean;
import vo.User;

public class JJIMService {
	public int getJJIMCount(User authUser) throws Exception {
		int listCount = 0;
		Connection con = getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		listCount = customerDAO.selectJJIMListCount(authUser);
		close(con);
		return listCount;

	}

	public ArrayList<ClassBean> getJJIMList(User authUser, int page, int limit) throws Exception {

		ArrayList<ClassBean> jJIMList = null;
		Connection con = getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		jJIMList = customerDAO.selectJJIMList(authUser, page, limit);
		close(con);
		return jJIMList;

	}
	
public ArrayList<Integer> getHeadCount(User authUser, int page, int limit) throws Exception{
		
		ArrayList<ClassBean> articleList = null;
		Connection con = getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		articleList = customerDAO.selectJJIMList(authUser, page, limit);
		ArrayList<Integer> headCounts = new ArrayList<Integer>();
			
		
		for (int i = 0; i < articleList.size(); i++) {
			headCounts.add(i,customerDAO.headCount(articleList.get(i).getCL_ID()));
		
		}
		close(con);
		
		
		return headCounts;
	}

}
