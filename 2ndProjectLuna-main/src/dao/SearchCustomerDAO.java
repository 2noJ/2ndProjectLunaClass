package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.ClassBean;
import vo.Customer_bean;

public class SearchCustomerDAO {
	DataSource ds;
	Connection con;

	private static SearchCustomerDAO customerDAO;

	private SearchCustomerDAO() {
	}

	public static SearchCustomerDAO getInstance() {
		if (customerDAO == null) {
			customerDAO = new SearchCustomerDAO();
		}
		return customerDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int selectSearchCustomerListCount(String content, String search) {
		
		int listCount = 0;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {

			if(search.equals("전체")) {
				pstmt = con.prepareStatement(
						"SELECT count(*) FROM CUSTOMER");
				
				rs = pstmt.executeQuery();
			}else if(search.equals("아이디")) {
				pstmt = con.prepareStatement(
						"SELECT count(*) FROM CUSTOMER where cus_id like ?");
				pstmt.setString(1, "%" + content + "%");
				rs = pstmt.executeQuery();
			}else if(search.equals("이름")) {
				pstmt = con.prepareStatement(
						"SELECT count(*) FROM CUSTOMER where cus_name like ?");
				pstmt.setString(1, "%" + content + "%");
				rs = pstmt.executeQuery();
			}else if(search.equals("전화 번호")) {
				pstmt = con.prepareStatement(
						"SELECT count(*) FROM CUSTOMER where cus_tel like ?");
				pstmt.setString(1, "%" + content + "%");
				rs = pstmt.executeQuery();
			}else {
				pstmt = con.prepareStatement(
						"SELECT count(*) FROM CUSTOMER");
				rs = pstmt.executeQuery();
			}
			
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

	public ArrayList<Customer_bean> selectSearchCustomerList(String content, String search, int page, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		if(search.equals("전체")) {
			sql = "select * from CUSTOMER limit ?,5";
			ArrayList<Customer_bean> customerList = new ArrayList<Customer_bean>();
			Customer_bean customer1 = null;
			int startrow = (page - 1) * 5;
		
			try {
				
				
				pstmt = con.prepareStatement(sql);
			
				pstmt.setInt(1, startrow);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					customer1 = new Customer_bean();
					customer1.setCUS_ID(rs.getString("CUS_ID"));
					customer1.setCUS_PWD(rs.getString("CUS_PWD"));
					customer1.setCUS_NAME(rs.getString("CUS_NAME"));
					customer1.setCUS_ADDR(rs.getString("CUS_ADDR"));
					customer1.setCUS_TEL(rs.getString("CUS_TEL"));
					customer1.setCUS_REGDATE(rs.getDate("CUS_REGDATE"));
					customer1.setCUS_PROFILE_PATH(rs.getString("CUS_PROFILE_PATH"));
					
					customerList.add(customer1);
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
			return customerList;
			
		}else if(search.equals("아이디")) {
			sql = "select * from CUSTOMER where CUS_ID like ?  limit ?,5";
		}else if(search.equals("이름")) {
			sql = "select * from CUSTOMER where CUS_NAME like ? limit ?,5";
		}else if(search.equals("전화 번호")) {
			sql = "select * from CUSTOMER where CUS_TEL like ? limit ?,5";
		
		}
		
		ArrayList<Customer_bean> customerList = new ArrayList<Customer_bean>();
		Customer_bean customer1 = null;
		int startrow = (page - 1) * 5;
	
		try {
			
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + content + "%");
			pstmt.setInt(2, startrow);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				customer1 = new Customer_bean();
				customer1.setCUS_ID(rs.getString("CUS_ID"));
				customer1.setCUS_PWD(rs.getString("CUS_PWD"));
				customer1.setCUS_NAME(rs.getString("CUS_NAME"));
				customer1.setCUS_ADDR(rs.getString("CUS_ADDR"));
				customer1.setCUS_TEL(rs.getString("CUS_TEL"));
				customer1.setCUS_REGDATE(rs.getDate("CUS_REGDATE"));
				customer1.setCUS_PROFILE_PATH(rs.getString("CUS_PROFILE_PATH"));
				
				customerList.add(customer1);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return customerList;
	}
}
