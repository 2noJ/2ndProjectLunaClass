package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import db.JdbcUtil;
import vo.ClassBean;
import vo.Customer_bean;
import vo.Reservation_bean;
import vo.User;

public class CustomerDAO {
	DataSource ds;
	Connection con;

	private static CustomerDAO customerDAO;

	private CustomerDAO() {
	}

	public static CustomerDAO getInstance() {
		if (customerDAO == null) {
			customerDAO = new CustomerDAO();
		}
		return customerDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int selectClassListCount(User authUser) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement("SELECT count(*) FROM CLASS WHERE CL_WRITER_ID = ?");
			pstmt.setString(1, authUser.getId());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("getListCount : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}

	public int selectClassListCount(String cus_id) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement("SELECT count(*) FROM CLASS WHERE CL_WRITER_ID = ?");
			pstmt.setString(1, cus_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("getListCount : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}
	
	public int selectClassListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			System.out.println("getConnection");
			pstmt = con.prepareStatement("SELECT count(*) FROM CLASS");
			rs = pstmt.executeQuery();
			if(rs.next()){
				listCount=rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("getListCount : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}

	public ArrayList<ClassBean> selectMyClassList(User authUser, int page, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from CLASS  where CL_WRITER_ID = ? order by CL_ID desc limit ?,5";
		ArrayList<ClassBean> MyClassList = new ArrayList<ClassBean>();
		ClassBean class1 = null;
		int startrow = (page - 1) * 5;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, authUser.getId());
			pstmt.setInt(2, startrow);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				class1 = new ClassBean();
				class1.setCL_ID(rs.getInt("CL_ID"));
				class1.setCL_NAME(rs.getString("CL_NAME"));
				class1.setCL_WRITER_ID(rs.getString("CL_WRITER_ID"));
				class1.setCL_CATEGORY(rs.getString("CL_CATEGORY"));
				class1.setCL_CONTENT(rs.getString("CL_CONTENT"));
				class1.setCL_INTRODUCTION(rs.getString("CL_INTRODUCTION"));
				class1.setCL_START_DATE(rs.getDate("CL_START_DATE"));
				class1.setCL_END_DATE(rs.getDate("CL_END_DATE"));
				class1.setCL_LOCATION(rs.getString("CL_LOCATION"));
				class1.setCL_CAPACITY(rs.getInt("CL_CAPACITY"));
				class1.setCL_IMG_PATH(rs.getString("CL_IMG_PATH"));
				class1.setCL_VIEW(rs.getInt("CL_VIEW"));
				class1.setCL_REGDATE(rs.getDate("CL_REGDATE"));
				class1.setCL_MODIFYDATE(rs.getDate("CL_MODIFYDATE"));
				MyClassList.add(class1);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return MyClassList;

	}

	public int selectClassListINGCount(User authUser) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement("SELECT count(*) FROM CLASS WHERE CL_WRITER_ID = ? and CL_END_DATE > now()");
			pstmt.setString(1, authUser.getId());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("getListCount : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}

	public ArrayList<ClassBean> selectMyClassListING(User authUser, int page, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from CLASS  where CL_WRITER_ID = ? and CL_END_DATE > now() order by CL_ID desc limit ?,5";
		ArrayList<ClassBean> MyClassList = new ArrayList<ClassBean>();
		ClassBean class1 = null;
		int startrow = (page - 1) * 5;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, authUser.getId());
			pstmt.setInt(2, startrow);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				class1 = new ClassBean();
				class1.setCL_ID(rs.getInt("CL_ID"));
				class1.setCL_NAME(rs.getString("CL_NAME"));
				class1.setCL_WRITER_ID(rs.getString("CL_WRITER_ID"));
				class1.setCL_CATEGORY(rs.getString("CL_CATEGORY"));
				class1.setCL_CONTENT(rs.getString("CL_CONTENT"));
				class1.setCL_INTRODUCTION(rs.getString("CL_INTRODUCTION"));
				class1.setCL_START_DATE(rs.getDate("CL_START_DATE"));
				class1.setCL_END_DATE(rs.getDate("CL_END_DATE"));
				class1.setCL_LOCATION(rs.getString("CL_LOCATION"));
				class1.setCL_CAPACITY(rs.getInt("CL_CAPACITY"));
				class1.setCL_IMG_PATH(rs.getString("CL_IMG_PATH"));
				class1.setCL_VIEW(rs.getInt("CL_VIEW"));
				class1.setCL_REGDATE(rs.getDate("CL_REGDATE"));
				class1.setCL_MODIFYDATE(rs.getDate("CL_MODIFYDATE"));
				MyClassList.add(class1);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return MyClassList;

	}

	public int selectClassListEndCount(User authUser) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement("SELECT count(*) FROM CLASS WHERE CL_WRITER_ID = ? and CL_END_DATE < now()");
			pstmt.setString(1, authUser.getId());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("getListCount : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}

	public ArrayList<ClassBean> selectMyClassListEnd(User authUser, int page, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from CLASS  where CL_WRITER_ID = ? and CL_END_DATE < now() order by CL_ID desc limit ?,5";
		ArrayList<ClassBean> MyClassList = new ArrayList<ClassBean>();
		ClassBean class1 = null;
		int startrow = (page - 1) * 5;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, authUser.getId());
			pstmt.setInt(2, startrow);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				class1 = new ClassBean();
				class1.setCL_ID(rs.getInt("CL_ID"));
				class1.setCL_NAME(rs.getString("CL_NAME"));
				class1.setCL_WRITER_ID(rs.getString("CL_WRITER_ID"));
				class1.setCL_CATEGORY(rs.getString("CL_CATEGORY"));
				class1.setCL_CONTENT(rs.getString("CL_CONTENT"));
				class1.setCL_INTRODUCTION(rs.getString("CL_INTRODUCTION"));
				class1.setCL_START_DATE(rs.getDate("CL_START_DATE"));
				class1.setCL_END_DATE(rs.getDate("CL_END_DATE"));
				class1.setCL_LOCATION(rs.getString("CL_LOCATION"));
				class1.setCL_CAPACITY(rs.getInt("CL_CAPACITY"));
				class1.setCL_IMG_PATH(rs.getString("CL_IMG_PATH"));
				class1.setCL_VIEW(rs.getInt("CL_VIEW"));
				class1.setCL_REGDATE(rs.getDate("CL_REGDATE"));
				class1.setCL_MODIFYDATE(rs.getDate("CL_MODIFYDATE"));
				MyClassList.add(class1);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return MyClassList;

	}

	public int selectParticipateListEndCount(String cus_id) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement("select count(*) from CLASS join RESERVATION  on Class.CL_ID  = "
					+ " RESERVATION.RESV_CL_NUM where RESERVATION.RESV_USER_ID = ? and Class.CL_END_DATE < now() ");
			pstmt.setString(1, cus_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("getListCount : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}
	
	public int selectParticipateListCount(User authUser) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement("select count(*) from CLASS join RESERVATION  on Class.CL_ID  = "
					+ " RESERVATION.RESV_CL_NUM where RESERVATION.RESV_USER_ID = ? and Class.CL_END_DATE > now() ");
			pstmt.setString(1, authUser.getId());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("getListCount : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}
	
	public int selectParticipateListCount(String cus_d) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement("select count(*) from CLASS join RESERVATION  on Class.CL_ID  = "
					+ " RESERVATION.RESV_CL_NUM where RESERVATION.RESV_USER_ID = ? and Class.CL_END_DATE > now() ");
			pstmt.setString(1, cus_d);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("getListCount : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}

	public ArrayList<ClassBean> selectMyParticipateList(User authUser, int page, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select CLASS.* from CLASS join RESERVATION  on Class.CL_ID  = "
				+ " RESERVATION.RESV_CL_NUM where RESERVATION.RESV_USER_ID = ? and Class.CL_END_DATE > now() "
				+ " order by Class.CL_ID desc limit ?,5";
		ArrayList<ClassBean> MyClassList = new ArrayList<ClassBean>();
		ClassBean class1 = null;
		int startrow = (page - 1) * 5;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, authUser.getId());
			pstmt.setInt(2, startrow);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				class1 = new ClassBean();
				class1.setCL_ID(rs.getInt("CL_ID"));
				class1.setCL_NAME(rs.getString("CL_NAME"));
				class1.setCL_WRITER_ID(rs.getString("CL_WRITER_ID"));
				class1.setCL_CATEGORY(rs.getString("CL_CATEGORY"));
				class1.setCL_CONTENT(rs.getString("CL_CONTENT"));
				class1.setCL_INTRODUCTION(rs.getString("CL_INTRODUCTION"));
				class1.setCL_START_DATE(rs.getDate("CL_START_DATE"));
				class1.setCL_END_DATE(rs.getDate("CL_END_DATE"));
				class1.setCL_LOCATION(rs.getString("CL_LOCATION"));
				class1.setCL_CAPACITY(rs.getInt("CL_CAPACITY"));
				class1.setCL_IMG_PATH(rs.getString("CL_IMG_PATH"));
				class1.setCL_VIEW(rs.getInt("CL_VIEW"));
				class1.setCL_REGDATE(rs.getDate("CL_REGDATE"));
				class1.setCL_MODIFYDATE(rs.getDate("CL_MODIFYDATE"));
				class1.setCL_MODIFYCHECK(rs.getInt("CL_MODIFYCHECK"));
				MyClassList.add(class1);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return MyClassList;

	}
	
	public ArrayList<ClassBean> selectMyParticipateList(String cus_id, int page, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="select CLASS.* from CLASS join RESERVATION  on Class.CL_ID  = "
				+ " RESERVATION.RESV_CL_NUM where RESERVATION.RESV_USER_ID = ? and Class.CL_END_DATE > now() "
				+ " order by Class.CL_ID desc limit ?,5";
		ArrayList<ClassBean> MyClassList = new ArrayList<ClassBean>();
		ClassBean class1 = null;
		int startrow = (page - 1) * 5;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cus_id);
			pstmt.setInt(2, startrow);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				class1 = new ClassBean();
				class1.setCL_ID(rs.getInt("CL_ID"));
				class1.setCL_NAME(rs.getString("CL_NAME"));
				class1.setCL_WRITER_ID(rs.getString("CL_WRITER_ID"));
				class1.setCL_CATEGORY(rs.getString("CL_CATEGORY"));
				class1.setCL_CONTENT(rs.getString("CL_CONTENT"));
				class1.setCL_INTRODUCTION(rs.getString("CL_INTRODUCTION"));
				class1.setCL_START_DATE(rs.getDate("CL_START_DATE"));
				class1.setCL_END_DATE(rs.getDate("CL_END_DATE"));
				class1.setCL_LOCATION(rs.getString("CL_LOCATION"));
				class1.setCL_CAPACITY(rs.getInt("CL_CAPACITY"));
				class1.setCL_IMG_PATH(rs.getString("CL_IMG_PATH"));
				class1.setCL_VIEW(rs.getInt("CL_VIEW"));
				class1.setCL_REGDATE(rs.getDate("CL_REGDATE"));
				class1.setCL_MODIFYDATE(rs.getDate("CL_MODIFYDATE"));
				MyClassList.add(class1);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return MyClassList;

	}
	
	public int selectParticipateListEndCount(User authUser) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement("select count(*) from CLASS join RESERVATION  on Class.CL_ID  = "
					+ " RESERVATION.RESV_CL_NUM where RESERVATION.RESV_USER_ID = ? and Class.CL_END_DATE < now() ");
			pstmt.setString(1, authUser.getId());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("getListCount : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}

	public ArrayList<ClassBean> selectMyParticipateListEnd(User authUser, int page, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select CLASS.* from CLASS join RESERVATION  on Class.CL_ID  = "
				+ " RESERVATION.RESV_CL_NUM where RESERVATION.RESV_USER_ID = ? and Class.CL_END_DATE < now() "
				+ " order by Class.CL_ID desc limit ?,5";
		ArrayList<ClassBean> MyClassList = new ArrayList<ClassBean>();
		ClassBean class1 = null;
		int startrow = (page - 1) * 5;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, authUser.getId());
			pstmt.setInt(2, startrow);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				class1 = new ClassBean();
				class1.setCL_ID(rs.getInt("CL_ID"));
				class1.setCL_NAME(rs.getString("CL_NAME"));
				class1.setCL_WRITER_ID(rs.getString("CL_WRITER_ID"));
				class1.setCL_CATEGORY(rs.getString("CL_CATEGORY"));
				class1.setCL_CONTENT(rs.getString("CL_CONTENT"));
				class1.setCL_INTRODUCTION(rs.getString("CL_INTRODUCTION"));
				class1.setCL_START_DATE(rs.getDate("CL_START_DATE"));
				class1.setCL_END_DATE(rs.getDate("CL_END_DATE"));
				class1.setCL_LOCATION(rs.getString("CL_LOCATION"));
				class1.setCL_CAPACITY(rs.getInt("CL_CAPACITY"));
				class1.setCL_IMG_PATH(rs.getString("CL_IMG_PATH"));
				class1.setCL_VIEW(rs.getInt("CL_VIEW"));
				class1.setCL_REGDATE(rs.getDate("CL_REGDATE"));
				class1.setCL_MODIFYDATE(rs.getDate("CL_MODIFYDATE"));
				MyClassList.add(class1);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return MyClassList;

	}

	public Customer_bean getMyInfo(User authUser) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from customer where CUS_ID =? ";
		Customer_bean myInfo = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, authUser.getId());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				myInfo = new Customer_bean();
				myInfo.setCUS_ID(rs.getString("CUS_ID"));
				myInfo.setCUS_PWD(rs.getString("CUS_PWD"));
				myInfo.setCUS_NAME(rs.getString("CUS_NAME"));
				myInfo.setCUS_ADDR(rs.getString("CUS_ADDR"));
				myInfo.setCUS_TEL(rs.getString("CUS_TEL"));
				myInfo.setCUS_REGDATE(rs.getDate("CUS_REGDATE"));
				myInfo.setCUS_PROFILE_PATH(rs.getString("CUS_PROFILE_PATH"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return myInfo;
	}
	
	public Customer_bean getCustomerInfo(String cus_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from customer where CUS_ID =? ";
		Customer_bean cusInfo = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cus_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cusInfo = new Customer_bean();
				cusInfo.setCUS_ID(rs.getString("CUS_ID"));
				cusInfo.setCUS_PWD(rs.getString("CUS_PWD"));
				cusInfo.setCUS_NAME(rs.getString("CUS_NAME"));
				cusInfo.setCUS_ADDR(rs.getString("CUS_ADDR"));
				cusInfo.setCUS_TEL(rs.getString("CUS_TEL"));
				cusInfo.setCUS_REGDATE(rs.getDate("CUS_REGDATE"));
				cusInfo.setCUS_PROFILE_PATH(rs.getString("CUS_PROFILE_PATH"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return cusInfo;
	}

	public int profilePicUpdate(User authUser, String filname) {
		PreparedStatement pstmt = null;
		String sql = "update CUSTOMER set CUS_PROFILE_PATH = ? WHERE CUS_ID = ?";
		int count = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, filname);
			pstmt.setString(2, authUser.getId());

			count = pstmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(pstmt);
		}
		return count;
	}
	
	public int profilePicUpdate(String userID, String filname) {
		PreparedStatement pstmt = null;
		String sql = "update CUSTOMER set CUS_PROFILE_PATH = ? WHERE CUS_ID = ?";
		int count = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, filname);
			pstmt.setString(2, userID);

			count = pstmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(pstmt);
		}
		return count;
	}
	
	public int passUpdate(String newPass, User authUser) {
		PreparedStatement pstmt = null;
		String sql = "update CUSTOMER set CUS_PWD = ? WHERE CUS_ID = ?";
		int count = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newPass);
			pstmt.setString(2, authUser.getId());

			count = pstmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(pstmt);
		}
		return count;
	}
	
	@SuppressWarnings("resource")
	public int deleteMember(User authUser, String pwd) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbpw = "";
		int count = 0;
		String sql = "";
		try {
			con.setAutoCommit(false);
			sql = "SELECT CUS_PWD FROM CUSTOMER WHERE CUS_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, authUser.getId());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dbpw = rs.getString("CUS_PWD");
				if (dbpw.equals(pwd)) {
					sql = "DELETE FROM CUSTOMER WHERE CUS_ID=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, authUser.getId());
					pstmt.executeUpdate();
					con.commit();
					count = 1; // 삭제성공
				}
			}
		} catch (Exception ex) {
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ex.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return count;
	}

	public int infoUpdate(String col, User authUser, String newVal) {
		Statement stmt = null;
		String sql = "update CUSTOMER set " + col + " = '" + newVal + "' WHERE CUS_ID = '" + authUser.getId() + "'";
		int count = 0;
		try {
			stmt = con.createStatement();
			count = stmt.executeUpdate(sql);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(stmt);
		}

		return count;
	}

	public int insertClass(ClassBean singleClass) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		String sql = "";
		int insertCount = 0;
		try {
			pstmt = con.prepareStatement("select max(CL_ID) from class");
			rs = pstmt.executeQuery();
			if(rs.next()) num=rs.getInt(1) + 1;
			else num = 1;
			close(pstmt);
			sql = "insert into class (CL_ID, CL_NAME, CL_WRITER_ID, CL_CATEGORY, CL_CONTENT, CL_INTRODUCTION, CL_START_DATE, CL_END_DATE, "+
					"CL_LOCATION, CL_CAPACITY, CL_IMG_PATH) values(?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, singleClass.getCL_NAME());
			pstmt.setString(3, singleClass.getCL_WRITER_ID());
			pstmt.setString(4, singleClass.getCL_CATEGORY());
			pstmt.setString(5, singleClass.getCL_CONTENT());
			pstmt.setString(6, singleClass.getCL_INTRODUCTION());
			pstmt.setDate(7, singleClass.getCL_START_DATE());
			pstmt.setDate(8, singleClass.getCL_END_DATE());
			pstmt.setString(9, singleClass.getCL_LOCATION());
			pstmt.setInt(10, singleClass.getCL_CAPACITY());
			pstmt.setString(11, singleClass.getCL_IMG_PATH());
			
			insertCount = pstmt.executeUpdate();
		} catch(Exception ex) {
			System.out.println("classInsert : " + ex);
		} finally {
			close(rs); close(pstmt);
		}
		return insertCount;
	}

	public ArrayList<ClassBean> allClass() {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from CLASS";
		ArrayList<ClassBean> classes = new ArrayList<ClassBean>();
		ClassBean class1;
		try {
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				class1 = new ClassBean();
				class1.setCL_ID(rs.getInt("CL_ID"));
				classes.add(class1);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return classes;

	}

	public ClassBean selectRecentlyViewed(String classId, int page, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from CLASS  where CL_ID = ? ";
		ClassBean class1 = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, classId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				class1 = new ClassBean();
				class1.setCL_ID(rs.getInt("CL_ID"));
				class1.setCL_NAME(rs.getString("CL_NAME"));
				class1.setCL_WRITER_ID(rs.getString("CL_WRITER_ID"));
				class1.setCL_CATEGORY(rs.getString("CL_CATEGORY"));
				class1.setCL_CONTENT(rs.getString("CL_CONTENT"));
				class1.setCL_INTRODUCTION(rs.getString("CL_INTRODUCTION"));
				class1.setCL_START_DATE(rs.getDate("CL_START_DATE"));
				class1.setCL_END_DATE(rs.getDate("CL_END_DATE"));
				class1.setCL_LOCATION(rs.getString("CL_LOCATION"));
				class1.setCL_CAPACITY(rs.getInt("CL_CAPACITY"));
				class1.setCL_IMG_PATH(rs.getString("CL_IMG_PATH"));
				class1.setCL_VIEW(rs.getInt("CL_VIEW"));
				class1.setCL_REGDATE(rs.getDate("CL_REGDATE"));
				class1.setCL_MODIFYDATE(rs.getDate("CL_MODIFYDATE"));

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return class1;

	}

	public int selectJJIMListCount(User authUser) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(
					"select count(*) from CLASS join JJIM on Class.CL_ID  = JJIM.JJIM_CL_ID where JJIM.JJIM_CUS_ID = ?");
			pstmt.setString(1, authUser.getId());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("getListCount : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}

	public ArrayList<ClassBean> selectJJIMList(User authUser, int page, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select CLASS.* from CLASS join JJIM on Class.CL_ID  = JJIM.JJIM_CL_ID "
				+ "where JJIM.JJIM_CUS_ID = ? order by JJIM.JJIM_REGDATE desc limit ?,5 ";
		ArrayList<ClassBean> MyClassList = new ArrayList<ClassBean>();
		ClassBean class1 = null;
		int startrow = (page - 1) * 5;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, authUser.getId());
			pstmt.setInt(2, startrow);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				class1 = new ClassBean();
				class1.setCL_ID(rs.getInt("CL_ID"));
				class1.setCL_NAME(rs.getString("CL_NAME"));
				class1.setCL_WRITER_ID(rs.getString("CL_WRITER_ID"));
				class1.setCL_CATEGORY(rs.getString("CL_CATEGORY"));
				class1.setCL_CONTENT(rs.getString("CL_CONTENT"));
				class1.setCL_INTRODUCTION(rs.getString("CL_INTRODUCTION"));
				class1.setCL_START_DATE(rs.getDate("CL_START_DATE"));
				class1.setCL_END_DATE(rs.getDate("CL_END_DATE"));
				class1.setCL_LOCATION(rs.getString("CL_LOCATION"));
				class1.setCL_CAPACITY(rs.getInt("CL_CAPACITY"));
				class1.setCL_IMG_PATH(rs.getString("CL_IMG_PATH"));
				class1.setCL_VIEW(rs.getInt("CL_VIEW"));
				class1.setCL_REGDATE(rs.getDate("CL_REGDATE"));
				class1.setCL_MODIFYDATE(rs.getDate("CL_MODIFYDATE"));
				MyClassList.add(class1);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return MyClassList;

	}

	public int headCount(int classId) {
		int headcount = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement("select count(*) from RESERVATION where RESV_CL_NUM = ?");
			pstmt.setInt(1, classId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				headcount = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("getListCount : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return headcount;
	}

	public int reservCancel(String userId, int classId) {
		int cancelCount = 0;
		PreparedStatement pstmt = null;
		String sql = "delete from RESERVATION where RESV_USER_ID=? and RESV_CL_NUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2, classId);

			cancelCount = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return cancelCount;
	}

	public Customer_bean selectById(String id) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("select * from CUSTOMER where CUS_ID = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			Customer_bean member = null;
			if (rs.next()) {
				member = new Customer_bean();

				member.setCUS_ID(rs.getString("CUS_ID"));
				member.setCUS_NAME(rs.getString("CUS_NAME"));
				member.setCUS_PROFILE_PATH(rs.getString("CUS_PROFILE_PATH"));

			}
			return member;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public int checkClassING(User authUser) throws SQLException {
		int countclass = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("select * from CLASS where CL_WRITER_ID  = ? and CL_END_DATE > now()");
			pstmt.setString(1, authUser.getId());
			rs = pstmt.executeQuery();
			ArrayList<ClassBean> MyClassList = new ArrayList<ClassBean>();
			ClassBean class1 = null;
			if (rs.next()) {
				class1 = new ClassBean();
				class1.setCL_ID(rs.getInt("CL_ID"));
				MyClassList.add(class1);
			}
			countclass = MyClassList.size();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return countclass;
	}

	public int checkParticlpateING(User authUser) throws SQLException {
		int countclass = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select CLASS.* from CLASS join RESERVATION  on Class.CL_ID  = "
				+ " RESERVATION.RESV_CL_NUM where RESERVATION.RESV_USER_ID = ? and Class.CL_END_DATE > now() ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, authUser.getId());
			rs = pstmt.executeQuery();
			ArrayList<ClassBean> MyClassList = new ArrayList<ClassBean>();
			ClassBean class1 = null;
			if (rs.next()) {
				class1 = new ClassBean();
				class1.setCL_ID(rs.getInt("CL_ID"));
				MyClassList.add(class1);
			}
			countclass = MyClassList.size();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return countclass;
	}

	public void leaveUp(User authUser) {
		PreparedStatement pstmtQnA = null;
		PreparedStatement pstmtRev = null;
		PreparedStatement pstmtCl = null;
		PreparedStatement pstmtRec = null;
		PreparedStatement pstmtClQnA = null;
		String QnASql = "update QnA set qa_writer_id = '탈퇴한회원' WHERE qa_writer_id = ?";
		String RevSql = "update RESERVATION set RESV_USER_ID  = '탈퇴한회원' WHERE RESV_USER_ID  = ?";
		String ClSql = "update CLASS set CL_WRITER_ID  = '탈퇴한회원' WHERE CL_WRITER_ID  = ?";
		String RecSql = "update recomment_qna set recomment_id = '탈퇴한회원' WHERE recomment_id = ?";
		String ClQnASql = "update CLASS_QNA set CLQA_WRITER_ID = '탈퇴한회원' WHERE CLQA_WRITER_ID = ?";
		try {
			
			pstmtQnA = con.prepareStatement(QnASql);
			pstmtRev = con.prepareStatement(RevSql);
			pstmtCl = con.prepareStatement(ClSql);
			pstmtRec = con.prepareStatement(RecSql);
			pstmtClQnA = con.prepareStatement(ClQnASql);
			pstmtQnA.setString(1, authUser.getId());
			pstmtRev.setString(1, authUser.getId());
			pstmtCl.setString(1, authUser.getId());
			pstmtRec.setString(1, authUser.getId());
			pstmtClQnA.setString(1, authUser.getId());
			pstmtQnA.executeUpdate();
			pstmtRev.executeUpdate();
			pstmtCl.executeUpdate();
			pstmtRec.executeUpdate();
			pstmtClQnA.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JdbcUtil.commit(con);
			close(pstmtClQnA);
			close(pstmtRec);
			close(pstmtCl);
			close(pstmtRev);
			close(pstmtQnA);
			
		}

	}

	public ArrayList<Customer_bean> selectCustomerList(int page, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from customer order by CUS_ID desc limit ?,5";
		ArrayList<Customer_bean> CustomerList = new ArrayList<Customer_bean>();
		Customer_bean class1 = null;
		int startrow = (page - 1) * 5;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				class1 = new Customer_bean();
				class1.setCUS_ID(rs.getString("CUS_ID"));
				class1.setCUS_PWD(rs.getString("CUS_PWD"));
				class1.setCUS_NAME(rs.getString("CUS_NAME"));
				class1.setCUS_ADDR(rs.getString("CUS_ADDR"));
				class1.setCUS_TEL(rs.getString("CUS_TEL"));
				class1.setCUS_REGDATE(rs.getDate("CUS_REGDATE"));
				class1.setCUS_PROFILE_PATH(rs.getString("CUS_PROFILE_PATH"));
				CustomerList.add(class1);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return CustomerList;

	}
		
	public int passUpdate(String cus_pwd, String cus_id) {
		PreparedStatement pstmt = null;
		String sql = "update CUSTOMER set CUS_PWD = ? WHERE CUS_ID = ?";
		int count = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cus_pwd);
			pstmt.setString(2, cus_id);
			
			count = pstmt.executeUpdate();
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(pstmt);
		}
		return count;
	}
	
	public int nameUpdate(String cus_name, String cus_id) {
		PreparedStatement pstmt = null;
		String sql = "update CUSTOMER set CUS_NAME = ? WHERE CUS_ID = ?";
		int count = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cus_name);
			pstmt.setString(2, cus_id);
			
			count = pstmt.executeUpdate();
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(pstmt);
		}
		return count;
	}
	
	public int addrUpdate(String cus_addr, String cus_id) {
		PreparedStatement pstmt = null;
		String sql = "update CUSTOMER set CUS_ADDR = ? WHERE CUS_ID = ?";
		int count = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cus_addr);
			pstmt.setString(2, cus_id);
			
			count = pstmt.executeUpdate();
		
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(pstmt);
		}
		return count;
	}
	
	public int telUpdate(String cus_tel, String cus_id) {
		PreparedStatement pstmt = null;
		String sql = "update CUSTOMER set CUS_TEL = ? WHERE CUS_ID = ?";
		int count = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cus_tel);
			pstmt.setString(2, cus_id);
		
			count = pstmt.executeUpdate();
		
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(pstmt);
		}
		return count;
	}
	
	public ArrayList<ClassBean> selectCustomerClassList(String cus_id, int page, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from CLASS where CL_order by CL_ID desc limit ?,6";
		ArrayList<ClassBean> classList = new ArrayList<ClassBean>();
		ClassBean class1 = null;
		int startrow = (page - 1) * 6;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				class1 = new ClassBean();
				class1.setCL_ID(rs.getInt("CL_ID"));
				class1.setCL_NAME(rs.getString("CL_NAME"));
				class1.setCL_WRITER_ID(rs.getString("CL_WRITER_ID"));
				class1.setCL_CATEGORY(rs.getString("CL_CATEGORY"));
				class1.setCL_CONTENT(rs.getString("CL_CONTENT"));
				class1.setCL_INTRODUCTION(rs.getString("CL_INTRODUCTION"));
				class1.setCL_START_DATE(rs.getDate("CL_START_DATE"));
				class1.setCL_END_DATE(rs.getDate("CL_END_DATE"));
				class1.setCL_LOCATION(rs.getString("CL_LOCATION"));
				class1.setCL_CAPACITY(rs.getInt("CL_CAPACITY"));
				class1.setCL_IMG_PATH(rs.getString("CL_IMG_PATH"));
				class1.setCL_VIEW(rs.getInt("CL_VIEW"));
				class1.setCL_REGDATE(rs.getDate("CL_REGDATE"));
				class1.setCL_MODIFYDATE(rs.getDate("CL_MODIFYDATE"));
				classList.add(class1);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return classList;
	}
	
	public ArrayList<ClassBean> selectCusParticipateListEnd(String cus_id, int page, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="select CLASS.* from CLASS join RESERVATION  on Class.CL_ID  = "
				+ " RESERVATION.RESV_CL_NUM where RESERVATION.RESV_USER_ID = ? and Class.CL_END_DATE < now() "
				+ " order by Class.CL_ID desc limit ?,5";
		ArrayList<ClassBean> MyClassList = new ArrayList<ClassBean>();
		ClassBean class1 = null;
		int startrow = (page - 1) * 5;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cus_id);
			pstmt.setInt(2, startrow);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				class1 = new ClassBean();
				class1.setCL_ID(rs.getInt("CL_ID"));
				class1.setCL_NAME(rs.getString("CL_NAME"));
				class1.setCL_WRITER_ID(rs.getString("CL_WRITER_ID"));
				class1.setCL_CATEGORY(rs.getString("CL_CATEGORY"));
				class1.setCL_CONTENT(rs.getString("CL_CONTENT"));
				class1.setCL_INTRODUCTION(rs.getString("CL_INTRODUCTION"));
				class1.setCL_START_DATE(rs.getDate("CL_START_DATE"));
				class1.setCL_END_DATE(rs.getDate("CL_END_DATE"));
				class1.setCL_LOCATION(rs.getString("CL_LOCATION"));
				class1.setCL_CAPACITY(rs.getInt("CL_CAPACITY"));
				class1.setCL_IMG_PATH(rs.getString("CL_IMG_PATH"));
				class1.setCL_VIEW(rs.getInt("CL_VIEW"));
				class1.setCL_REGDATE(rs.getDate("CL_REGDATE"));
				class1.setCL_MODIFYDATE(rs.getDate("CL_MODIFYDATE"));
				MyClassList.add(class1);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return MyClassList;

	}
	
	public int selectCustomerListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement("SELECT count(*) FROM CUSTOMER");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("getListCount : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}
	


	public ClassBean getOneClass(String categoty) {
		ClassBean oneclass = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			pstmt = con.prepareStatement(
					"select * from class where CL_CATEGORY = ? and CL_END_DATE > now() order by CL_VIEW desc limit 0,1 ");
			pstmt.setString(1, categoty);
			rs= pstmt.executeQuery();
			oneclass = new ClassBean();
			if(rs.next()){
				
				
				oneclass.setCL_ID(rs.getInt("CL_ID"));
				oneclass.setCL_NAME(rs.getString("CL_NAME"));
				oneclass.setCL_WRITER_ID(rs.getString("CL_WRITER_ID"));
				oneclass.setCL_CATEGORY(rs.getString("CL_CATEGORY"));
				oneclass.setCL_CONTENT(rs.getString("CL_CONTENT"));
				oneclass.setCL_INTRODUCTION(rs.getString("CL_INTRODUCTION"));
				oneclass.setCL_START_DATE(rs.getDate("CL_START_DATE"));
				oneclass.setCL_END_DATE(rs.getDate("CL_END_DATE"));
				oneclass.setCL_LOCATION(rs.getString("CL_LOCATION"));
				oneclass.setCL_CAPACITY(rs.getInt("CL_CAPACITY"));
				oneclass.setCL_IMG_PATH(rs.getString("CL_IMG_PATH"));
				oneclass.setCL_VIEW (rs.getInt("CL_VIEW"));
				
			}else {oneclass.setCL_NAME("");}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			close(rs);
			close(pstmt);
		}
		
		
		
		
		return oneclass;
		
	}
	
	public int checkClassING(String cusid) throws SQLException {
		int countclass = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("select * from CLASS where CL_WRITER_ID  = ? and CL_END_DATE > now()");
			pstmt.setString(1, cusid);
			rs = pstmt.executeQuery();
			ArrayList<ClassBean> MyClassList = new ArrayList<ClassBean>();
			ClassBean class1 = null;
			if (rs.next()) {
				class1 = new ClassBean();
				class1.setCL_ID(rs.getInt("CL_ID"));
				MyClassList.add(class1);
			}
			countclass = MyClassList.size();
		
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return countclass;
	}

	public int checkParticlpateING(String cusid) throws SQLException {
		int countclass = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select CLASS.* from CLASS join RESERVATION  on Class.CL_ID  = "
				+ " RESERVATION.RESV_CL_NUM where RESERVATION.RESV_USER_ID = ? and Class.CL_END_DATE > now() ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cusid);
			rs = pstmt.executeQuery();
			ArrayList<ClassBean> MyClassList = new ArrayList<ClassBean>();
			ClassBean class1 = null;
			if (rs.next()) {
				class1 = new ClassBean();
				class1.setCL_ID(rs.getInt("CL_ID"));
				MyClassList.add(class1);
			}
			countclass = MyClassList.size();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return countclass;
	}
	
	public void leaveUp(String cusid) {
		PreparedStatement pstmtQnA = null;
		PreparedStatement pstmtRev = null;
		PreparedStatement pstmtCl = null;
		PreparedStatement pstmtRec = null;
		PreparedStatement pstmtClQnA = null;
		String QnASql = "update QnA set qa_writer_id = '탈퇴한회원' WHERE qa_writer_id = ?";
		String RevSql = "update RESERVATION set RESV_USER_ID  = '탈퇴한회원' WHERE RESV_USER_ID  = ?";
		String ClSql = "update CLASS set CL_WRITER_ID  = '탈퇴한회원' WHERE CL_WRITER_ID  = ?";
		String RecSql = "update recomment_qna set recomment_id = '탈퇴한회원' WHERE recomment_id = ?";
		String ClQnASql = "update CLASS_QNA set CLQA_WRITER_ID = '탈퇴한회원' WHERE CLQA_WRITER_ID = ?";
		try {
			
			pstmtQnA = con.prepareStatement(QnASql);
			pstmtRev = con.prepareStatement(RevSql);
			pstmtCl = con.prepareStatement(ClSql);
			pstmtRec = con.prepareStatement(RecSql);
			pstmtClQnA = con.prepareStatement(ClQnASql);
			pstmtQnA.setString(1, cusid);
			pstmtRev.setString(1, cusid);
			pstmtCl.setString(1, cusid);
			pstmtRec.setString(1, cusid);
			pstmtClQnA.setString(1, cusid);
			pstmtQnA.executeUpdate();
			pstmtRev.executeUpdate();
			pstmtCl.executeUpdate();
			pstmtRec.executeUpdate();
			pstmtClQnA.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JdbcUtil.commit(con);
			close(pstmtClQnA);
			close(pstmtRec);
			close(pstmtCl);
			close(pstmtRev);
			close(pstmtQnA);
		}

	}
	
	public int deleteMember(String cusid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int count = 0;
		String sql = "";
		try {
			con.setAutoCommit(false);
			
					sql = "DELETE FROM CUSTOMER WHERE CUS_ID=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, cusid);
					pstmt.executeUpdate();
					con.commit();
					count = 1; // 삭제성공
				
			
		} catch (Exception ex) {
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return count;
	}
	
	public ClassBean getClassInfo(int CL_ID) {	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from CLASS where CL_ID = ? ";
		ClassBean updateClass = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, CL_ID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				updateClass = new ClassBean();
				updateClass.setCL_ID(rs.getInt("CL_ID"));
				updateClass.setCL_NAME(rs.getString("CL_NAME"));
				updateClass.setCL_WRITER_ID(rs.getString("CL_WRITER_ID"));
				updateClass.setCL_CATEGORY(rs.getString("CL_CATEGORY"));
				updateClass.setCL_CONTENT(rs.getString("CL_CONTENT"));
				updateClass.setCL_INTRODUCTION(rs.getString("CL_INTRODUCTION"));
				updateClass.setCL_START_DATE(rs.getDate("CL_START_DATE"));
				updateClass.setCL_END_DATE(rs.getDate("CL_END_DATE"));
				updateClass.setCL_LOCATION(rs.getString("CL_LOCATION"));
				updateClass.setCL_CAPACITY(rs.getInt("CL_CAPACITY"));
				updateClass.setCL_IMG_PATH(rs.getString("CL_IMG_PATH"));
				updateClass.setCL_VIEW(rs.getInt("CL_VIEW"));
				updateClass.setCL_REGDATE(rs.getDate("CL_REGDATE"));
				updateClass.setCL_MODIFYDATE(rs.getDate("CL_MODIFYDATE"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return updateClass;

		
	}
	
	public int updateClass(ClassBean singleClass) {
		PreparedStatement pstmt = null;
		String sql = "";
		int insertCount = 0;
		try {
			sql = "update class set CL_NAME = ?, CL_CATEGORY = ? ,CL_CONTENT = ? , CL_INTRODUCTION = ? , CL_START_DATE = ? , CL_END_DATE= ? , "+
					"CL_LOCATION = ? , CL_CAPACITY = ? , CL_IMG_PATH = ? , CL_MODIFYDATE = now(), CL_MODIFYCHECK = 1 where CL_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, singleClass.getCL_NAME());
			pstmt.setString(2, singleClass.getCL_CATEGORY());
			pstmt.setString(3, singleClass.getCL_CONTENT());
			pstmt.setString(4, singleClass.getCL_INTRODUCTION());
			pstmt.setDate(5, singleClass.getCL_START_DATE());
			pstmt.setDate(6, singleClass.getCL_END_DATE());
			pstmt.setString(7, singleClass.getCL_LOCATION());
			pstmt.setInt(8, singleClass.getCL_CAPACITY());
			pstmt.setString(9, singleClass.getCL_IMG_PATH());
			pstmt.setInt(10, singleClass.getCL_ID());
			
			insertCount = pstmt.executeUpdate();
		} catch(Exception ex) {
			System.out.println("classInsert : " + ex);
		} finally {
			close(pstmt);
		}
		return insertCount;
	
	
}
	public int updateClassNoPic(ClassBean singleClass) {
		PreparedStatement pstmt = null;
		String sql = "";
		int insertCount = 0;
		try {
			sql = "update class set CL_NAME = ?, CL_CATEGORY = ? ,CL_CONTENT = ? , CL_INTRODUCTION = ? , CL_START_DATE = ? , CL_END_DATE= ? , "+
					"CL_LOCATION = ? , CL_CAPACITY = ? , CL_MODIFYDATE = now(), CL_MODIFYCHECK = 1 where CL_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, singleClass.getCL_NAME());
			pstmt.setString(2, singleClass.getCL_CATEGORY());
			pstmt.setString(3, singleClass.getCL_CONTENT());
			pstmt.setString(4, singleClass.getCL_INTRODUCTION());
			pstmt.setDate(5, singleClass.getCL_START_DATE());
			pstmt.setDate(6, singleClass.getCL_END_DATE());
			pstmt.setString(7, singleClass.getCL_LOCATION());
			pstmt.setInt(8, singleClass.getCL_CAPACITY());
			pstmt.setInt(9, singleClass.getCL_ID());
			
			insertCount = pstmt.executeUpdate();
		} catch(Exception ex) {
			System.out.println("classInsert : " + ex);
		} finally {
			close(pstmt);
		}
		return insertCount;
	
	
}
	
	public int getCountClass() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("SELECT count(*) FROM CLASS");
			rs = pstmt.executeQuery();
			if(rs.next()){
				listCount=rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("getListCount : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
		
	}
	
	public int getCountCustomer() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("SELECT count(*) FROM customer");
			rs = pstmt.executeQuery();
			if(rs.next()){
				listCount=rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("getListCount : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
		
	}
	public int getCountClassING() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("SELECT count(*) FROM CLASS where CL_START_DATE > now()");
			rs = pstmt.executeQuery();
			if(rs.next()){
				listCount=rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("getListCount : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
		
	}
	
	
	public String getWriter(int CL_ID) {
		String writer = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select cus_name  from customer join class on class.cl_writer_id = customer.cus_id where class.cl_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, CL_ID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				writer = rs.getString("cus_name");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return writer;

	}
}
