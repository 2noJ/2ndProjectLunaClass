package svc.customer.classes;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import dao.ClassListDAO;
import vo.ClassBean;

public class ClassListService {
	
	public ArrayList<Integer> getHeadCount(int page, int limit) throws Exception{
		
	      ArrayList<ClassBean> classList = null;
	      Connection con = getConnection();
	      ClassListDAO classListDAO = ClassListDAO.getInstance();
	      classListDAO.setConnection(con);
	      classList = classListDAO.selectClassList(page, limit);

	      ArrayList<Integer> headCounts = new ArrayList<Integer>();
	         
	      
	      for (int i = 0; i < classList.size(); i++) {
	         headCounts.add(i,classListDAO.headCount(classList.get(i).getCL_ID()));
	      
	      }
	      close(con);
	      
	      
	      return headCounts;
	   }
	
	public ArrayList<Integer> getHeadCount(String CL_LOCATION, int page, int limit) throws Exception{
		
	      ArrayList<ClassBean> classList = null;
	      Connection con = getConnection();
	      ClassListDAO classListDAO = ClassListDAO.getInstance();
	      classListDAO.setConnection(con);
	      classList = classListDAO.selectClassList(CL_LOCATION, page, limit);
	      ArrayList<Integer> headCounts = new ArrayList<Integer>();
	         
	      
	      for (int i = 0; i < classList.size(); i++) {
	         headCounts.add(i,classListDAO.headCount(classList.get(i).getCL_ID()));
	      }
	      close(con);
	      return headCounts;
	   }
	
	public ArrayList<Integer> getHeadCount(String CL_LOCATION, String CL_CATEGORY, int page, int limit) throws Exception{
		
	      ArrayList<ClassBean> classList = null;
	      Connection con = getConnection();
	      ClassListDAO classListDAO = ClassListDAO.getInstance();
	      classListDAO.setConnection(con);
	      classList = classListDAO.selectClassList(CL_LOCATION,CL_CATEGORY, page, limit);
	      ArrayList<Integer> headCounts = new ArrayList<Integer>();
	      for (int i = 0; i < classList.size(); i++) {
	         headCounts.add(i,classListDAO.headCount(classList.get(i).getCL_ID()));
	      }
	      close(con);
	      
	      
	      return headCounts;
	   }
	
	public ArrayList<Integer> getHeadCount(int page, int limit, String CL_CATEGORY) throws Exception{
		
	      ArrayList<ClassBean> classList = null;
	      Connection con = getConnection();
	      ClassListDAO classListDAO = ClassListDAO.getInstance();
	      classListDAO.setConnection(con);
	      classList = classListDAO.selectClassList(page, limit, CL_CATEGORY);
	      ArrayList<Integer> headCounts = new ArrayList<Integer>();  
	      for (int i = 0; i < classList.size(); i++) {
	         headCounts.add(i,classListDAO.headCount(classList.get(i).getCL_ID()));
	      }
	      close(con);
	      return headCounts;
	   }
	
	public int getClassListCount() throws Exception {
      int listCount = 0;
      Connection con = getConnection();
      ClassListDAO classListDAO = ClassListDAO.getInstance();
      classListDAO.setConnection(con);
      listCount = classListDAO.selectClassListCount();
      close(con);
      return listCount;
   }
	
	public int getClassListCount(String category) throws Exception {
	      int listCount = 0;
	      Connection con = getConnection();
	      ClassListDAO classListDAO = ClassListDAO.getInstance();
	      classListDAO.setConnection(con);
	      listCount = classListDAO.selectClassListCount(category);
	      close(con);
	      return listCount;
	   }
	
	public int getLocClassListCount(String location) throws Exception {
	      int listCount = 0;
	      Connection con = getConnection();
	      ClassListDAO classListDAO = ClassListDAO.getInstance();
	      classListDAO.setConnection(con);
	      listCount = classListDAO.selectLocClassListCount(location);
	      close(con);
	      return listCount;
	   }
	
	public int getClassListCount(String category, String location) throws Exception {
	      int listCount = 0;
	      Connection con = getConnection();
	      ClassListDAO classListDAO = ClassListDAO.getInstance();
	      classListDAO.setConnection(con);
	      listCount = classListDAO.selectClassListCount(category, location);
	      close(con);
	      return listCount;
	   }

   public ArrayList<ClassBean> getClassList(int page, int limit) throws Exception {

      ArrayList<ClassBean> classList = null;
      Connection con = getConnection();
      ClassListDAO classListDAO = ClassListDAO.getInstance();
      classListDAO.setConnection(con);
      classList = classListDAO.selectClassList(page, limit);
      close(con);
      
      return classList;
   }
   public ArrayList<ClassBean> getClassList(String CL_LOCATION, int page, int limit) throws Exception {

	      ArrayList<ClassBean> classList = null;
	      Connection con = getConnection();
	      ClassListDAO classListDAO = ClassListDAO.getInstance();
	      classListDAO.setConnection(con);
	      classList = classListDAO.selectClassList(CL_LOCATION, page, limit);
	      close(con);
	      
	      return classList;
	}
   
   public ArrayList<ClassBean> getClassList(String CL_LOCATION, String CL_CATEGORY, int page, int limit) throws Exception {

	      ArrayList<ClassBean> classList = null;
	      Connection con = getConnection();
	      ClassListDAO classListDAO = ClassListDAO.getInstance();
	      classListDAO.setConnection(con);
	      classList = classListDAO.selectClassList(CL_LOCATION, CL_CATEGORY, page, limit);
	      close(con);
	      
	      return classList;
	}
   
   public ArrayList<ClassBean> getClassList(int page, int limit, String CL_CATEGORY) throws Exception {

	      ArrayList<ClassBean> classList = null;
	      Connection con = getConnection();
	      ClassListDAO classListDAO = ClassListDAO.getInstance();
	      classListDAO.setConnection(con);
	      classList = classListDAO.selectClassList(page, limit, CL_CATEGORY);
	      close(con);
	      return classList;
	}
}