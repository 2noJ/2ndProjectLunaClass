package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.FNQ_bean;
import vo.QNA_bean;

public class QnADAO {
	DataSource ds;
	Connection con;

	private static QnADAO qnaDAO;

	private QnADAO() {
	}

	public static QnADAO getInstance() {
		if (qnaDAO == null) {
			qnaDAO = new QnADAO();
		}
		return qnaDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}
	

	public int selectQnAListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
		
			
		
			pstmt = con.prepareStatement("SELECT count(*) FROM QNA");
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
	
	public ArrayList<QNA_bean> selectQnAList(int page, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from QNA order by qa_regdate desc, qa_id desc limit ?,5";
		ArrayList<QNA_bean> qnaList = new ArrayList<QNA_bean>();
		QNA_bean qna = null;
		int startrow = (page - 1) * 5;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				qna = new QNA_bean();
				qna.setQA_ID(rs.getInt("QA_ID"));
				qna.setQA_WRITER_ID(rs.getString("QA_WRITER_ID"));
				qna.setQA_TITLE(rs.getString("QA_TITLE"));
				qna.setQA_CONTENT(rs.getString("QA_CONTENT"));
				qna.setQA_REGDATE(rs.getDate("QA_REGDATE"));
				qna.setQA_MAG_CONTENT(rs.getString("QA_MAG_CONTENT"));
				qna.setQA_ANSWER(rs.getBoolean("QA_ANSWER"));
				qna.setQA_MAG_REGDATE(rs.getDate("QA_MAG_REGDATE"));
				qnaList.add(qna);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return qnaList;

	}
	
	public int insertMagQnAList(String mag_content, int qa_id) {

		PreparedStatement pstmt = null;
		int updateCount=0;
		
		String sql = "update qna set QA_MAG_CONTENT='"+mag_content+"', QA_ANSWER=1, QA_MAG_REGDATE=now() where QA_ID='"+qa_id+"'";
		

		try {
			pstmt = con.prepareStatement(sql);
			

			updateCount=pstmt.executeUpdate();
			

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
		
			close(pstmt);
			
		}

		return updateCount;
	}
	
	public int deleteMagAList(int qa_id) {

		PreparedStatement pstmt = null;
		int deleteCount=0;
		
		String sql = "update qna set QA_MAG_CONTENT=NULL, QA_ANSWER=0, QA_MAG_REGDATE=NULL where QA_ID="+qa_id;
		

		try {
			pstmt = con.prepareStatement(sql);
			

			deleteCount=pstmt.executeUpdate();
			

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
		
			close(pstmt);
			
		}
		return deleteCount;

	}
	
	public int deleteQList(int qa_id) {

		PreparedStatement pstmt = null;
		int deleteCount=0;
		
		String sql = "delete from qna where QA_ID="+qa_id;
		

		try {
			pstmt = con.prepareStatement(sql);
			

			deleteCount=pstmt.executeUpdate();
			

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
		
			close(pstmt);
			
		}

		return deleteCount;
	}
	
	public int insertQnAList(String qna_writer_id, String qna_title, String qna_content) {

		PreparedStatement pstmt = null;
		int insertCount=0;
		
		String sql = "insert into qna(QA_WRITER_ID, QA_TITLE, QA_CONTENT) VALUES('"+qna_writer_id+"', '"+qna_title+"', '"+qna_content+"')";
		

		try {
			pstmt = con.prepareStatement(sql);
			insertCount=pstmt.executeUpdate();
			

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
		
			close(pstmt);
			
		}

		return insertCount;
	}
	
	public int selectFNQListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
	
			
		
			pstmt = con.prepareStatement("SELECT count(*) FROM FNQ");
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
	
	public ArrayList<FNQ_bean> selectFnQList(int page, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from FNQ order by fnq_id desc limit ?,5";
		ArrayList<FNQ_bean> fnqList = new ArrayList<FNQ_bean>();
		FNQ_bean fnq = null;
		int startrow = (page - 1) * 5;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				fnq = new FNQ_bean();
				fnq.setFNQ_ID(rs.getInt("FNQ_ID"));
				fnq.setFNQ_TITLE(rs.getString("FNQ_TITLE"));
				fnq.setFNQ_CONTENT(rs.getString("FNQ_CONTENT"));
				
				fnqList.add(fnq);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return fnqList;

	}
	
	public int insertFnQList(String fnq_title, String fnq_content) {

		PreparedStatement pstmt = null;
		int insertCount=0;
		
		String sql = "insert into fnq(FNQ_TITLE, FNQ_CONTENT) VALUES('"+fnq_title+"', '"+fnq_content+"')";
		

		try {
			pstmt = con.prepareStatement(sql);
			insertCount=pstmt.executeUpdate();
			

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
		
			close(pstmt);
			
		}
		return insertCount;

	}
	
	public int modifyFnQList(String fnq_title, String fnq_content, int fnq_id) {

		PreparedStatement pstmt = null;
		int updateCount=0;
		
		String sql = "update fnq set FNQ_TITLE ='"+fnq_title+"', FNQ_CONTENT='"+fnq_content+"' where FNQ_ID="+fnq_id;
		

		try {
			pstmt = con.prepareStatement(sql);
			

			updateCount=pstmt.executeUpdate();
			

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
		
			close(pstmt);
			
		}
		return updateCount;

	}
	
	public int deleteFnQList(int fnq_id) {

		PreparedStatement pstmt = null;
		int deleteCount=0;
		
		String sql = "delete from fnq where FNQ_ID="+fnq_id;
		

		try {
			pstmt = con.prepareStatement(sql);
			

			deleteCount=pstmt.executeUpdate();
			

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
		
			close(pstmt);
			
		}

		return deleteCount;
	}
	
	
}
