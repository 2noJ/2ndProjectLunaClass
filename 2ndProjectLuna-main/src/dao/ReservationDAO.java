package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import db.JdbcUtil;
import vo.ClassBean;
import vo.ReservationBean;

public class ReservationDAO {

	DataSource ds;
	Connection con;
	private static ReservationDAO reservationDAO;

	private ReservationDAO() {
		// TODO Auto-generated constructor stub
	}

	public static ReservationDAO getInstance(){
		if(reservationDAO == null){
			reservationDAO = new ReservationDAO();
		}
		return reservationDAO;
	}

	public void setConnection(Connection con){
		this.con = con;
	}
	
	
	
	
	
	
	public ClassBean selectClassInfo(int CL_ID) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from class where CL_ID = ?";
		ClassBean classInfoBean = null;

		try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, CL_ID);

				rs = pstmt.executeQuery();
				
			while (rs.next()) {
				classInfoBean = new ClassBean();
				classInfoBean.setCL_ID(rs.getInt("CL_ID"));
				classInfoBean.setCL_NAME(rs.getString("CL_NAME"));
				classInfoBean.setCL_WRITER_ID(rs.getString("CL_WRITER_ID"));
				classInfoBean.setCL_CATEGORY(rs.getString("CL_CATEGORY"));
				classInfoBean.setCL_CONTENT(rs.getString("CL_CONTENT"));
				classInfoBean.setCL_INTRODUCTION(rs.getString("CL_INTRODUCTION"));
				classInfoBean.setCL_START_DATE(rs.getDate("CL_START_DATE"));
				classInfoBean.setCL_END_DATE(rs.getDate("CL_END_DATE"));
				classInfoBean.setCL_LOCATION(rs.getString("CL_LOCATION"));
				classInfoBean.setCL_CAPACITY(rs.getInt("CL_CAPACITY"));
				classInfoBean.setCL_IMG_PATH(rs.getString("CL_IMG_PATH"));
				classInfoBean.setCL_VIEW(rs.getInt("CL_VIEW"));
				
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return classInfoBean;
	}
	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<ReservationBean> resvCheckNum(String userId) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select RESV_CL_NUM from reservation where RESV_USER_ID = ?";
		ArrayList<ReservationBean> RevCheckNumList = new ArrayList<ReservationBean>();
		ReservationBean reservationBean = null;

		try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userId);

				rs = pstmt.executeQuery();
			
			while (rs.next()) {
				reservationBean = new ReservationBean();
				reservationBean.setRESV_CL_NUM(rs.getInt("RESV_CL_NUM"));
				
				RevCheckNumList.add(reservationBean);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return RevCheckNumList;
	}
	
	

	
	
	public ReservationBean selectReservationBean(String userId, int CL_ID) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from reservation where RESV_USER_ID = ? and RESV_CL_NUM = ?";
		ArrayList<ReservationBean> ReservationList = new ArrayList<ReservationBean>();
		ReservationBean reservation1 = null;

		try {
			/*if(CL_CATEGORY == null) {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, CL_LOCATION);
				pstmt.setInt(2, startrow);

				rs = pstmt.executeQuery();
			}*/
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userId);
				pstmt.setInt(2, CL_ID);
				rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				reservation1 = new ReservationBean();
				reservation1.setRESV_USER_ID(rs.getString("RESV_USER_ID"));
				reservation1.setRESV_CL_NUM(rs.getInt("RESV_CL_NUM"));
				reservation1.setRESV_CL_NAME(rs.getString("RESV_CL_NAME"));
				reservation1.setRESV_WRITER_ID(rs.getString("RESV_WRITER_ID"));
				reservation1.setRESV_REGDATE(rs.getString("RESV_REGDATE"));
				
			}

			

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return reservation1;
	}
	
	
	
	public ClassBean insertArticle(String userId, int CL_ID, String CL_NAME, String CL_WRITER_ID){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ClassBean article = null;
		int count = 0;
		try{
			
			pstmt = con.prepareStatement(
					"insert into reservation(RESV_USER_ID, RESV_CL_NUM, RESV_CL_NAME, RESV_WRITER_ID)"
					+"values(?, ?, ?, ?)");
					
					//"select * from class where CL_ID = ?");
			
			pstmt.setString(1, userId);
			pstmt.setInt(2, CL_ID);
			pstmt.setString(3, CL_NAME);
			pstmt.setString(4, CL_WRITER_ID);
			count = pstmt.executeUpdate();
			
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			 if(count>0) {
		         JdbcUtil.commit(con);
		         
		      }else {
		    	  JdbcUtil.rollback(con);
		      }
			close(pstmt);
		}
		return article;
	}
	
	
	
	public int updateReadCount(int CL_ID){

		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql="update class set CL_VIEW = "+
				"CL_VIEW+1 where CL_ID = "+CL_ID;

		try{
			pstmt=con.prepareStatement(sql);
			updateCount = pstmt.executeUpdate();
		}catch(SQLException ex){
			System.out.println("setReadCountUpdate ���� : "+ex);
		}
		finally{
			close(pstmt);

		}

		return updateCount;

	}

}
