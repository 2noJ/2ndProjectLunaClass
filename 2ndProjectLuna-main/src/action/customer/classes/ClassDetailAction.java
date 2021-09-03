package action.customer.classes;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.customer.classes.ClassDetailService;
import svc.customer.classes.Cus_BoardComment;
import svc.customer.classes.Cus_reCommentService;
import svc.customer.classes.JjimDetailService;
import vo.ActionForward;
import vo.ClassBean;
import vo.Customer_bean;
import vo.JjimBean;
import vo.ReservationBean;
import vo.User;
import vo.recomment_bean;
import vo.replyBean;

public class ClassDetailAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
		HttpSession session = request.getSession();

		int CL_ID=Integer.parseInt(request.getParameter("CL_ID"));
		ClassDetailService classDetailService = new ClassDetailService();
		JjimDetailService jjimDetailService = new JjimDetailService();
		ArrayList<ReservationBean> reservationList = new ArrayList<ReservationBean>();
		ArrayList<Customer_bean> customerList = new ArrayList<Customer_bean>();
		User user = (User)session.getAttribute("authUser");
		String userId = null;
		if((User)session.getAttribute("authUser") != null) {
			userId = (String)user.getId();
			request.setAttribute("userId", userId);
		}

		JjimBean jjimBean = new JjimBean();
		jjimBean = jjimDetailService.getSelectJjimBean(CL_ID, userId);

		reservationList = classDetailService.getReservationList(CL_ID);
		customerList = classDetailService.getCustomerList(CL_ID);


		ClassBean article = classDetailService.getArticle(CL_ID);
		ActionForward forward = new ActionForward();
		Cus_BoardComment commentService = new Cus_BoardComment();
		String writer = classDetailService.getWriter(CL_ID);
		ArrayList<replyBean> bbeanList = commentService.getList(CL_ID);
		ArrayList<recomment_bean> recommentList = Cus_reCommentService.getlist();
		request.setAttribute("CL_ID", CL_ID);
		request.setAttribute("commentList", bbeanList);
		request.setAttribute("recommentList", recommentList);
		request.setAttribute("jjimBean", jjimBean);
		request.setAttribute("reservationList", reservationList);
		request.setAttribute("customerList", customerList);
		request.setAttribute("article", article);
		request.setAttribute("writer", writer);
		forward.setPath("/view/customer/class/classDetail.jsp"); 
		return forward;

	}

}