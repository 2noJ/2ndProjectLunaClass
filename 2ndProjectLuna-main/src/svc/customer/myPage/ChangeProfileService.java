package svc.customer.myPage;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import com.oreilly.servlet.MultipartRequest;

import dao.CustomerDAO;
import dao.SignInDAO;
import vo.Customer_bean;
import vo.User;

public class ChangeProfileService {

	
	public boolean changeProfilePic(User authUser, MultipartRequest multi) throws Exception {
		boolean isProfileChanged = false;
		Connection con = getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		con.setAutoCommit(false);
		
		
		String name = multi.getOriginalFileName((String)multi.getFileNames().nextElement());
		
		String body = null;
		String ext = null;
		String filname = null;
		if(name !=null) {
		int dot = name.lastIndexOf(".");
		if (dot != -1) {
			body = name.substring(0, dot);
			ext = name.substring(dot);
		}
		filname = authUser.getId()+ext;
		}
		
		
		int count = customerDAO.profilePicUpdate(authUser, filname);
		if (count > 0) {
			con.commit();
			isProfileChanged = true;
		} else {
			con.rollback();
		}
		close(con);
		return isProfileChanged;
	}
	public String deleteProfilePic(User authUser) throws Exception {
		String filname = null;
		Connection con = getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		Customer_bean member = customerDAO.selectById(authUser.getId());
		filname = member.getCUS_PROFILE_PATH();		
		close(con);
		return filname;
	}
}
