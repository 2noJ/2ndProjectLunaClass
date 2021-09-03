package svc.manager;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.SearchCustomerDAO;
import vo.Customer_bean;

public class SearchCustomerListService {
   public int getSearchCustomerListCount(String content, String search) throws Exception {
      int listCount = 0;
      Connection con = getConnection();
      SearchCustomerDAO searchCustomerDAO = SearchCustomerDAO.getInstance();
      searchCustomerDAO.setConnection(con);
      listCount = searchCustomerDAO.selectSearchCustomerListCount(content, search);
      close(con);
      return listCount;
   }

   public ArrayList<Customer_bean> getSearchCustomerList(String content, String search,int page, int limit) throws Exception {

      ArrayList<Customer_bean> searchArticleList = null;
      Connection con = getConnection();
      SearchCustomerDAO searchCustomerDAO = SearchCustomerDAO.getInstance();
      searchCustomerDAO.setConnection(con);
      searchArticleList = searchCustomerDAO.selectSearchCustomerList(content, search, page, limit);
      close(con);
      return searchArticleList;
   }
}