package svc.customer.classes;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.SearchClassDAO;
import vo.ClassBean;

public class SearchClassListService {
	public ArrayList<Integer> getHeadCount(String CL_NAME, int page, int limit) throws Exception{
		
	      ArrayList<ClassBean> articleList = null;
	      Connection con = getConnection();
	      SearchClassDAO searchClassDAO = SearchClassDAO.getInstance();
	      searchClassDAO.setConnection(con);
	      articleList = searchClassDAO.selectSearchClassList(CL_NAME, page, limit);
	      ArrayList<Integer> headCounts = new ArrayList<Integer>();
	         
	      
	      for (int i = 0; i < articleList.size(); i++) {
	         headCounts.add(i,searchClassDAO.headCount(articleList.get(i).getCL_ID()));
	      }
	      close(con);
	      
	      
	      return headCounts;
	   }
	
	public ArrayList<Integer> getHeadCount(String CL_NAME, String CL_LOCATION, int page, int limit) throws Exception{
		
	      ArrayList<ClassBean> articleList = null;
	      Connection con = getConnection();
	      SearchClassDAO searchClassDAO = SearchClassDAO.getInstance();
	      searchClassDAO.setConnection(con);
	      articleList = searchClassDAO.selectSearchClassList(CL_NAME,CL_LOCATION, page, limit);
	      ArrayList<Integer> headCounts = new ArrayList<Integer>();
	      
	      for (int i = 0; i < articleList.size(); i++) {
	         headCounts.add(i,searchClassDAO.headCount(articleList.get(i).getCL_ID()));
	      }
	      close(con);
	      
	      
	      return headCounts;
	   }
	
	public int getSearchClassListCount(String CL_NAME) throws Exception {
      int listCount = 0;
      Connection con = getConnection();
      SearchClassDAO searchClassDAO = SearchClassDAO.getInstance();
      searchClassDAO.setConnection(con);
      listCount = searchClassDAO.selectSearchClassListCount(CL_NAME);
      close(con);
      return listCount;
   }
	
	public int getSearchClassListCount(String CL_NAME, String CL_LOCATION) throws Exception {
	      int listCount = 0;
	      Connection con = getConnection();
	      SearchClassDAO searchClassDAO = SearchClassDAO.getInstance();
	      searchClassDAO.setConnection(con);
	      listCount = searchClassDAO.selectSearchClassListCount(CL_NAME,CL_LOCATION);
	      close(con);
	      return listCount;
	   }

   public ArrayList<ClassBean> getSearchClassList(String CL_NAME,int page, int limit) throws Exception {

      ArrayList<ClassBean> searchArticleList = null;
      Connection con = getConnection();
      SearchClassDAO searchClassDAO = SearchClassDAO.getInstance();
      searchClassDAO.setConnection(con);
      searchArticleList = searchClassDAO.selectSearchClassList(CL_NAME, page, limit);
      close(con);
      return searchArticleList;
   }
   
   public ArrayList<ClassBean> getSearchClassList(String CL_NAME,String CL_LOCATION, int page, int limit) throws Exception {

	      ArrayList<ClassBean> searchArticleList = null;
	      Connection con = getConnection();
	      SearchClassDAO searchClassDAO = SearchClassDAO.getInstance();
	      searchClassDAO.setConnection(con);
	      searchArticleList = searchClassDAO.selectSearchClassList(CL_NAME, CL_LOCATION, page, limit);
	      close(con);
	      return searchArticleList;
	   }
}