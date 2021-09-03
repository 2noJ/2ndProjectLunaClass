package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.ClassBean;

public class ClassListDAO {
	DataSource ds;
	Connection con;

	private static ClassListDAO customerDAO;

	private ClassListDAO() {
	}

	public static ClassListDAO getInstance() {
		if (customerDAO == null) {
			customerDAO = new ClassListDAO();
		}
		return customerDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public int headCount(int CL_ID) {
	      int headcount = 0;
	      
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      try {
	         pstmt = con.prepareStatement("select count(*) from RESERVATION where RESV_CL_NUM = ?");
	         pstmt.setInt(1, CL_ID);
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

	public int selectClassListCount() {
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
	
	public int selectClassListCount(String category) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;			

		try {
			sql = "SELECT count(*) FROM CLASS where CL_CATEGORY = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, category);
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
	
	public int selectLocClassListCount(String location) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;			

		try {
			sql = "SELECT count(*) FROM CLASS where CL_LOCATION = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, location);
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
	
	public int selectClassListCount(String category, String location) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;			
		
		try {
			sql = "select count(*) from class where cl_location=? and cl_category=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, location);
			pstmt.setString(2, category);
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

	public ArrayList<ClassBean> selectClassList(int page, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from CLASS order by CL_ID desc limit ?,6";
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
				class1.setCL_MODIFYCHECK(rs.getInt("CL_MODIFYCHECK"));
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
	
	public ArrayList<ClassBean> selectClassList(String CL_LOCATION, int page, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from CLASS where CL_LOCATION = ? order by CL_ID desc limit ?,6";
		ArrayList<ClassBean> classList = new ArrayList<ClassBean>();
		ClassBean class1 = null;
		int startrow = (page - 1) * 6;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, CL_LOCATION);
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
	public ArrayList<ClassBean> selectClassList(String CL_LOCATION, String CL_CATEGORY,int page, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from CLASS where CL_LOCATION = ? AND CL_CATEGORY = ? order by CL_ID desc limit ?,6";
		ArrayList<ClassBean> classList = new ArrayList<ClassBean>();
		ClassBean class1 = null;
		int startrow = (page - 1) * 6;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, CL_LOCATION);
			pstmt.setString(2, CL_CATEGORY);
			pstmt.setInt(3, startrow);

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
	
	public ArrayList<ClassBean> selectClassList(int page, int limit, String CL_CATEGORY) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from CLASS where CL_CATEGORY = ? order by CL_ID desc limit ?,6";
		ArrayList<ClassBean> classList = new ArrayList<ClassBean>();
		ClassBean class1 = null;
		int startrow = (page - 1) * 6;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, CL_CATEGORY);
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
	
	public ArrayList<ClassBean> magSelectClassList(int page, int limit, String cusid) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from CLASS where cl_writer_id='"+cusid+"' and CL_END_DATE >= now() order by CL_ID desc limit ?,6";
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
	public int magSelectClassListCount(String cusid) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		
			pstmt = con.prepareStatement("SELECT count(*) FROM CLASS where cl_writer_id ='"+cusid+"' and CL_END_DATE > now()");
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
}
