package svc.manager;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ClassListDAO;
import vo.ClassBean;

public class Mag_ClassListService {
   public int getClassListCount() throws Exception {
      int listCount = 0;
      Connection con = getConnection();
      ClassListDAO classlistDAO = ClassListDAO.getInstance();
      classlistDAO.setConnection(con);
      listCount = classlistDAO.selectClassListCount();
      close(con);
      return listCount;
   }

   public ArrayList<ClassBean> getClassList(int page, int limit) throws Exception {

      ArrayList<ClassBean> articleList = null;
      Connection con = getConnection();
      ClassListDAO classlistDAO = ClassListDAO.getInstance();
      classlistDAO.setConnection(con);
      articleList = classlistDAO.selectClassList(page, limit);
      close(con);
      
      return articleList;
   }
}