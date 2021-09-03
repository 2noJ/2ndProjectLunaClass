package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.Notice_bean;

public class NoticeDAO {
	DataSource ds;
	Connection con;

	private static NoticeDAO noticeDAO;

	private NoticeDAO() {
	}

	public static NoticeDAO getInstance() {
		if (noticeDAO == null) {
			noticeDAO = new NoticeDAO();
		}
		return noticeDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}
	

	public int selectNoticeListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
	
			
		
			pstmt = con.prepareStatement("SELECT count(*) FROM notice");
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
	
	public ArrayList<Notice_bean> selectNoticeList(int page, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from NOTICE order by NOTICE_regdate desc, NOTICE_id desc limit ?,5";
		ArrayList<Notice_bean> noticeList = new ArrayList<Notice_bean>();
		Notice_bean notice = null;
		int startrow = (page - 1) * 5;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				notice = new Notice_bean();
				notice.setNOTICE_ID(rs.getInt("Notice_ID"));
				notice.setNOTICE_TITLE(rs.getString("Notice_TITLE"));
				notice.setNOTICE_CONTENT(rs.getString("Notice_CONTENT"));
				notice.setNOTICE_REGDATE(rs.getDate("Notice_REGDATE"));
				notice.setNOTICE_VIEWCOUNT(rs.getInt("Notice_VIEWCOUNT"));
				noticeList.add(notice);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return noticeList;

	}
	
	public int updateViewCount(int notice_id) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "update notice set notice_viewcount = notice_viewcount + 1 "
				+ " where notice_id = " + notice_id;
		try {
			pstmt = con.prepareStatement(sql);
			updateCount = pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(pstmt);
	}
		return updateCount;
	}
	
	public Notice_bean selectNotice(int notice_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Notice_bean notice_bean = null;
		try {
			pstmt = con.prepareStatement("select * from notice "
					+ " where notice_id = ?");
			pstmt.setInt(1, notice_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				notice_bean = new Notice_bean();
				notice_bean.setNOTICE_ID(rs.getInt("NOTICE_ID"));
				notice_bean.setNOTICE_TITLE(rs.getString("Notice_TITLE"));
				notice_bean.setNOTICE_CONTENT(rs.getString("Notice_CONTENT"));
				notice_bean.setNOTICE_REGDATE(rs.getDate("Notice_REGDATE"));
				notice_bean.setNOTICE_VIEWCOUNT(rs.getInt("Notice_VIEWCOUNT"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs); 		close(pstmt);
		}
		return notice_bean;
	}
	
	public int insertMagNoticeList(String notice_title, String notice_content) {

		PreparedStatement pstmt = null;
		int insertCount=0;
		
		try {
		String sql = "insert into notice (notice_title, notice_content) values (?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, notice_title);
			pstmt.setString(2, notice_content);
			insertCount=pstmt.executeUpdate();
			

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(pstmt);
			}
			return insertCount;
		}
	
	public int deleteMagNoticeList(int notice_id) {
		
		PreparedStatement pstmt = null;
		int deleteCount=0;
		
		try {
			String sql = "delete from notice where notice_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, notice_id);
			deleteCount=pstmt.executeUpdate();
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(pstmt);
		}
		return deleteCount;
	}
	
	public int updateMagNoticeList(String notice_title, String notice_content, int notice_id) {
		
		PreparedStatement pstmt = null;
		int updateCount=0;
		
		String sql = "update notice set notice_title = ?, notice_content = ? where notice_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, notice_title);
			pstmt.setString(2, notice_content);
			pstmt.setInt(3, notice_id);
			updateCount=pstmt.executeUpdate();
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(pstmt);
		}
		return updateCount;
	}
	
	
	
	public ArrayList<Notice_bean> selectNoticeList() {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from NOTICE order by NOTICE_regdate desc, NOTICE_id desc limit 0,3";
		ArrayList<Notice_bean> noticeList = new ArrayList<Notice_bean>();
		Notice_bean notice = null;


		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				notice = new Notice_bean();
				notice.setNOTICE_ID(rs.getInt("Notice_ID"));
				notice.setNOTICE_TITLE(rs.getString("Notice_TITLE"));
				notice.setNOTICE_CONTENT(rs.getString("Notice_CONTENT"));
				notice.setNOTICE_REGDATE(rs.getDate("Notice_REGDATE"));
				notice.setNOTICE_VIEWCOUNT(rs.getInt("Notice_VIEWCOUNT"));
				noticeList.add(notice);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return noticeList;

	}
	
	
	
	
	}








//	public int insertMagQnAList(String mag_content, int notice_id) {
//
//		PreparedStatement pstmt = null;
//		int updateCount=0;
//		
//		String sql = "update notice set NOTICE_MAG_CONTENT='"+mag_content+"', QA_ANSWER=1 where NOTICE_ID='"+notice_id+"'";
//		
//
//		try {
//			pstmt = con.prepareStatement(sql);
//			
//
//			updateCount=pstmt.executeUpdate();
//			
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		} finally {
//		
//			close(pstmt);
//			return updateCount;
//		}
//
//
//	}
	
