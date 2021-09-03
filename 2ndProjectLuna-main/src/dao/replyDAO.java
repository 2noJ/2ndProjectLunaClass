package dao;

import static db.JdbcUtil.close;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.ClassBean;
import vo.recomment_bean;
import vo.Mag_replyBean;

public class replyDAO {

	DataSource ds;
	Connection con;
	private static replyDAO replyDAO;

	private replyDAO() {
		// TODO Auto-generated constructor stub
	}

	public static replyDAO getInstance(){
		if(replyDAO == null){
			replyDAO = new replyDAO();
		}
		return replyDAO;
	}

	public void setConnection(Connection con){
		this.con = con;
	}

	
		
	
	
	public ArrayList<Mag_replyBean> getCommentList(int page, int limit) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ArrayList<Mag_replyBean> list = new ArrayList<Mag_replyBean>();
		int startrow = (page - 1) * 5;
	
	try {
		String sql = "select CLQA_num, CLQA_CLASS ,CLQA_WRITER_ID , CLQA_CONTENT ,CLQA_REGDATE from class_qna order by CLQA_NUM desc limit ?,5";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,startrow);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			Mag_replyBean bean = new Mag_replyBean();	
			bean.setComment_num(rs.getInt("CLQA_num"));
			bean.setComment_id(rs.getString("CLQA_WRITER_ID"));
			bean.setComment_board(rs.getInt("CLQA_CLASS"));
			bean.setComment_content(rs.getString("CLQA_CONTENT"));
			bean.setComment_date(rs.getDate("CLQA_REGDATE"));
			
			String sql2 = "select CL_NAME,CL_WRITER_ID  from class where CL_ID = ?";
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1,rs.getInt("CLQA_CLASS"));
			rs2=pstmt.executeQuery();
			if(rs2.next()) {
				bean.setComment_class_name(rs2.getString("CL_NAME"));
				bean.setComment_class_writer_name(rs2.getString("CL_WRITER_ID"));
			}
		
			list.add(bean);
			
			
		}
		
		
	}catch(Exception e) {
		e.printStackTrace();
		rollback(con);
	}finally {
		close(rs2);
		close(rs);
		close(pstmt);
	}
	return list;
	}
	
	

	public void deletecomment(int comment_num) {
		PreparedStatement pstmt = null;

		String deleteContent= "관리자가 삭제한 댓글입니다";
		String sql = "update class_qna set CLQA_CONTENT= ?,CLQA_WRITER_ID='',CLQA_REGDATE=NULL where CLQA_num = ?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,deleteContent);
			pstmt.setInt(2,comment_num);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			rollback(con);
		}finally {
			close(pstmt);
		}
	}




	

	public ArrayList<recomment_bean> getCommentlist() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		 ArrayList<recomment_bean>  list = new ArrayList<recomment_bean>();
		 String sql = "select recomment_num,recomment_comment_num,recomment_content,recomment_id,recomment_date from recomment_qna order by recomment_num desc";
		 try {
			 pstmt = con.prepareStatement(sql);
			 rs=pstmt.executeQuery();
			 while(rs.next()) {
				 
				 	recomment_bean bean = new recomment_bean();
				 	bean.setRecomment_num(rs.getInt("recomment_num"));
					bean.setrecomment_comment_num(rs.getInt("recomment_comment_num"));
					bean.setRecomment_content(rs.getString("recomment_content"));
					bean.setRecomment_id(rs.getString("recomment_id"));
					bean.setRecomment_date(rs.getDate("recomment_date"));
					list.add(bean);
					
			 }
			 
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }finally {
			 close(rs);
			 close(pstmt);
		 }
		return list;
	}

	public void deleteRecomment(int recomment_num) {
		PreparedStatement pstmt = null;
	
		String deleteContent= "관리자가 삭제한 댓글입니다";
		String sql = "update recomment_qna set recomment_CONTENT= ?,RECOMMENT_ID='',RECOMMENT_DATE=NULL where recomment_num = ?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,deleteContent);
			pstmt.setInt(2,recomment_num);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			rollback(con);
		}finally {
			close(pstmt);
		}
		
	}
	

	
	public int selectCommentListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			pstmt = con.prepareStatement("SELECT count(*) FROM CLASS_QNA");
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

	
	
	

