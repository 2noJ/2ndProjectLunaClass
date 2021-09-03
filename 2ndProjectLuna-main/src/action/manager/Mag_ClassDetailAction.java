package action.manager;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.customer.classes.ClassDetailService;
import svc.manager.Mag_ClassDetailService;
import vo.ActionForward;
import vo.ClassBean;
import vo.Customer_bean;
import vo.ReservationBean;
import vo.User;

public class Mag_ClassDetailAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
		HttpSession session = request.getSession();
		
		int CL_ID=Integer.parseInt(request.getParameter("CL_ID"));
		int page=Integer.parseInt(request.getParameter("page"));
		String cusid=(String)request.getParameter("cusid");
		String path=(String)request.getParameter("path");
		
		Mag_ClassDetailService magclassDetailService = new Mag_ClassDetailService();

		ArrayList<ReservationBean> reservationList = new ArrayList<ReservationBean>();
		ArrayList<Customer_bean> customerList = new ArrayList<Customer_bean>();
		User user = (User)session.getAttribute("authUser");
		String userId = null;
		if((User)session.getAttribute("authUser") != null) {
			userId = (String)user.getId();
			request.setAttribute("userId", userId);
		}

		reservationList = magclassDetailService.getReservationList(CL_ID);
		customerList = magclassDetailService.getCustomerList(CL_ID);
		ClassBean article = magclassDetailService.getArticle(CL_ID);
		ClassDetailService classDetailService= new ClassDetailService();
		String writer = classDetailService.getWriter(CL_ID);

		ActionForward forward = new ActionForward();
		

		request.setAttribute("reservationList", reservationList);
		request.setAttribute("customerList", customerList);
		request.setAttribute("article", article);
		request.setAttribute("page", page);
		request.setAttribute("cusid", cusid);
		request.setAttribute("path", path);
		request.setAttribute("writer", writer);
		forward.setPath("/view/manager/Mag_Class_Detail.jsp"); 
		return forward;

	}

}