package action.customer.myPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.customer.myPage.MyInfoService;
import vo.ActionForward;
import vo.Customer_bean;
import vo.User;

public class MyPageAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User authUser = (User) request.getSession().getAttribute("authUser");
		MyInfoService myInfoService = new MyInfoService();
		Customer_bean myInfo = myInfoService.getMyInfo(authUser);
		request.setAttribute("myInfo", myInfo);
		ActionForward forward = new ActionForward();
		forward.setPath("/view/customer/myPage/myPage.jsp");
		return forward;

	}
}