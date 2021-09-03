package dao;

import static db.JdbcUtil.close;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.recomment_bean;
import vo.replyBean;

public class CusReplyDAO {
	DataSource ds;
	Connection con;
	private static CusReplyDAO replyDAO;

	private CusReplyDAO() {
		// TODO Auto-generated constructor stub
	}

	public static CusReplyDAO getInstance(){
		if(replyDAO == null){
			replyDAO = new CusReplyDAO();
		}
		return replyDAO;
	}

	public void setConnection(Connection con){
		this.con = con;
	}
	
	public int inserComend(replyBean bean,int CL_ID) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int iscount = 0;
		String sql=null;
		 sql = "insert into class_qna(CLQA_CLASS,CLQA_WRITER_ID,CLQA_CONTENT,CLQA_REGDATE) values(?,?,?,sysdate())";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,CL_ID);
			pstmt.setString(2, bean.getComment_id());
			pstmt.setString(3, bean.getComment_content());
			iscount = pstmt.executeUpdate();
			if(iscount > 0) {
				iscount=1;
			}	
		}catch (Exception e)   {
			e.printStackTrace();
			rollback(con);
		}finally {
			close(pstmt);
		}
		return iscount;
	}
	
		
	
	
	public ArrayList<replyBean> getCommentList(int CL_ID) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<replyBean> list = new ArrayList<replyBean>();
	
	try {
		String sql = "select CLQA_num, CLQA_CLASS , CLQA_WRITER_ID , CLQA_CONTENT ,CLQA_REGDATE, customer.cus_profile_path from class_qna "
				+ "left join customer on class_qna.CLQA_WRITER_ID = customer.cus_id where class_qna.clqa_class = ? "
				+ "order by class_qna.CLQA_num desc";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, CL_ID);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			replyBean bean = new replyBean();	
			bean.setComment_num(rs.getInt("CLQA_num"));
			bean.setComment_id(rs.getString("CLQA_WRITER_ID"));
			bean.setComment_board(rs.getInt("CLQA_CLASS"));
			bean.setComment_content(rs.getString("CLQA_CONTENT"));
			bean.setComment_date((rs.getTimestamp("CLQA_REGDATE")));
			bean.setComment_profile(rs.getString("cus_profile_path"));
			list.add(bean);
			
		}
	}catch(Exception e) {
		e.printStackTrace();
		rollback(con);
	}finally {
		close(rs);
		close(pstmt);
	}
	return list;
	}
	
	public void deletecomment(int comment_num) {
	      PreparedStatement pstmt = null;
	      String deleteContent= "삭제된 댓글입니다";
	      String sql = "update class_qna set CLQA_CONTENT= ?, CLQA_WRITER_ID = '',CLQA_REGDATE = null where CLQA_num = ?";
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

	public int updateCommend(replyBean bean) {
		int iscount = 0;
		PreparedStatement pstmt = null;
		String sql ="update class_qna set CLQA_CONTENT= ? where CLQA_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getComment_content());
			pstmt.setInt(2, bean.getComment_num());
			pstmt.executeUpdate();
			iscount = 1;
		}catch(Exception e) {
			e.printStackTrace();
			rollback(con);
		}finally {
			close(pstmt);
		}
		return iscount;
	}

	public int updateRecomment(recomment_bean bean) {
		int iscount = 0;
		PreparedStatement pstmt = null;
		String sql ="update recomment_qna set recomment_content= ? where recomment_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getRecomment_content());
			pstmt.setInt(2, bean.getRecomment_num());
			pstmt.executeUpdate();
			iscount = 1;
		}catch(Exception e) {
			e.printStackTrace();
			rollback(con);
		}finally {
			close(pstmt);
		}
		return iscount;
	}
	public int insertRecomment(recomment_bean bean) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = null;
		 sql= "insert into recomment_qna(recomment_comment_num,recomment_content,recomment_id,recomment_date) values(?,?,?,sysdate())";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bean.getrecomment_comment_num());
			pstmt.setString(2, bean.getRecomment_content());
			pstmt.setString(3, bean.getRecomment_id());
			pstmt.executeUpdate();
			insertCount = 1;
		}catch(Exception e) {
			e.printStackTrace();
			rollback(con);
		}finally {
			close(pstmt);
		}
		return insertCount;
	}

	public ArrayList<recomment_bean> getCommentlist() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		 ArrayList<recomment_bean>  list = new ArrayList<recomment_bean>();
		 String sql = "select recomment_num,recomment_comment_num,recomment_content,recomment_id,recomment_date, customer.cus_profile_path from recomment_qna "
		 		+ "left join customer on recomment_qna.recomment_id = customer.cus_id";
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
					bean.setRecomment_profile(rs.getString("cus_profile_path"));
					list.add(bean);
					
			 }
			 
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return list;
	}

	public void deleteRecomment(int recomment_num) {
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		
		String sql = "delete from recomment_qna where recomment_num = ?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,recomment_num);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			rollback(con);
		}finally {
			close(pstmt);
		}
		
	}


}

	
	
	

