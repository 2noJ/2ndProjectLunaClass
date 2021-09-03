package svc.auth;

import java.sql.Connection;
import java.sql.SQLException;

import dao.SignInDAO;
import db.JdbcUtil;
import vo.Customer_bean;
import vo.User;

public class Mag_LoginService {

   private SignInDAO signinDao = SignInDAO.getInstance();
   
   public User login(String id, String password) {
      try (Connection conn = JdbcUtil.getConnection()) {
    	  signinDao.setConnection(conn);
         Customer_bean member = signinDao.selectById(id);
         if (member == null) {
            throw new RuntimeException();
         }
         if (!member.matchPassword(password)) {
            throw new RuntimeException();
         }
         return new User(member.getCUS_ID(), member.getCUS_NAME());
      } catch (SQLException e) {
         throw new RuntimeException(e);
      }
   }
   
}