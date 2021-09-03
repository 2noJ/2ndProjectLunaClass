package action.customer.classes;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.customer.classes.ClassDetailService;
import svc.customer.classes.JjimDetailService;
import vo.ActionForward;
import vo.ClassBean;
import vo.Customer_bean;
import vo.JjimBean;
import vo.ReservationBean;
import vo.User;

public class JjimDetailAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
		HttpSession session = request.getSession();
		
		JjimDetailService jjimDetailService = new JjimDetailService();
		int CL_ID=Integer.parseInt(request.getParameter("CL_ID"));
		session.setAttribute("path1", "jjimDetail.do?CL_ID="+CL_ID);
	
		ClassDetailService classDetailService = new ClassDetailService();
		ArrayList<ReservationBean> reservationList = new ArrayList<ReservationBean>();
		ArrayList<Customer_bean> customerList = new ArrayList<Customer_bean>();
		User user = (User)session.getAttribute("authUser");
		String userId = null;
		if(session.getAttribute("authUser") == null) {
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter script = response.getWriter();

			script.println("<script>alert('로그인이 필요한 서비스입니다.'); location.href='login.do';</script>");

			script.flush();
			
			request.getRequestDispatcher("login.jsp").include(request, response);
			return null;
			
			
			
		}
		if((User)session.getAttribute("authUser") != null) {
			userId = (String)user.getId();
			
		}
		request.setAttribute("userId", userId);
		
		reservationList = classDetailService.getReservationList(CL_ID);
		customerList = classDetailService.getCustomerList(CL_ID);
		
		JjimBean jjimBean = jjimDetailService.getInsertJjimBean(CL_ID, userId);
		
		
				
		ClassBean article = classDetailService.getArticle(CL_ID);
		

		ActionForward forward = new ActionForward();
		
		request.setAttribute("jjimBean", jjimBean);
		request.setAttribute("reservationList", reservationList);
		request.setAttribute("customerList", customerList);
		request.setAttribute("article", article);
		forward.setPath("classDetail.do"); 
		return forward;
	}
}