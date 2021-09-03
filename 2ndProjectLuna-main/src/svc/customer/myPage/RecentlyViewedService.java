package svc.customer.myPage;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.text.Format;
import java.util.ArrayList;

import javax.servlet.http.Cookie;

import dao.CustomerDAO;
import vo.ClassBean;
import vo.User;

public class RecentlyViewedService {
	
	
	public int getRecentlyViewedCount(Cookie[] cRecentlyVieweds) throws Exception {
		int listCount = 0;
		Connection con = getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		
		ArrayList<ClassBean> allClass = new ArrayList<ClassBean>();
		allClass = customerDAO.allClass();
		listCount = 0;
		for (int i = 0; i < cRecentlyVieweds.length; i++) {
			String str = cRecentlyVieweds[i].getName();
			for (int j = 0; j < allClass.size(); j++) {
				String str2 = Integer.toString(allClass.get(j).getCL_ID());
				if (str.equals(str2)) { 
					listCount++;
				}
			}
		}
		close(con);
		return listCount;

	}

	public ArrayList<ClassBean> getRecentlyViewed(Cookie[] cRecentlyVieweds, int page, int limit) throws Exception {

		ArrayList<ClassBean> recentlyVieweds = new ArrayList<ClassBean>();
		ClassBean recentlyViewed = null;
		Connection con = getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		String classId = null;

		ArrayList<ClassBean> allClass = new ArrayList<ClassBean>();
				allClass = customerDAO.allClass();

		for (int i = cRecentlyVieweds.length-1 ; i >= 0; i--) {
			String str = cRecentlyVieweds[i].getName();
			for (int j = 0; j < allClass.size(); j++) {
				String str2 = Integer.toString(allClass.get(j).getCL_ID());
				if (str.equals(str2)) {
					classId = cRecentlyVieweds[i].getValue();
					recentlyViewed = customerDAO.selectRecentlyViewed(classId, page, limit);
					recentlyVieweds.add(recentlyViewed);
				}
			}
		}
		close(con);
		return recentlyVieweds;

	}
	
public ArrayList<Integer> getHeadCount(Cookie[] cRecentlyVieweds, int page, int limit) throws Exception{
		
	ArrayList<ClassBean> recentlyVieweds = new ArrayList<ClassBean>();
	ClassBean recentlyViewed = null;
	Connection con = getConnection();
	CustomerDAO customerDAO = CustomerDAO.getInstance();
	customerDAO.setConnection(con);
	String classId = null;

	ArrayList<ClassBean> allClass = new ArrayList<ClassBean>();
			allClass = customerDAO.allClass();

	for (int i = cRecentlyVieweds.length-1 ; i >= 0; i--) {
		String str = cRecentlyVieweds[i].getName();
		for (int j = 0; j < allClass.size(); j++) {
			String str2 = Integer.toString(allClass.get(j).getCL_ID());
			if (str.equals(str2)) {
				classId = cRecentlyVieweds[i].getValue();
				recentlyViewed = customerDAO.selectRecentlyViewed(classId, page, limit);
				recentlyVieweds.add(recentlyViewed);
			}
		}
	}
	ArrayList<Integer> headCounts = new ArrayList<Integer>();
		
		for (int i = 0; i < recentlyVieweds.size(); i++) {
			headCounts.add(i,customerDAO.headCount(recentlyVieweds.get(i).getCL_ID()));
		
		}
		close(con);
		
		
		return headCounts;
	}

}
