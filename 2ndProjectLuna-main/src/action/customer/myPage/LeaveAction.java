package action.customer.myPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.customer.myPage.LeaveService;
import vo.ActionForward;
import vo.Customer_bean;
import vo.User;

public class LeaveAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User authUser = (User) request.getSession().getAttribute("authUser");
		LeaveService leaveService = new LeaveService();
		boolean isClassING = leaveService.checkClassING(authUser);
		boolean isParticlpateING = leaveService.checkParticlpateING(authUser);
		Customer_bean myInfo = leaveService.myPass(authUser);
		request.setAttribute("myInfo", myInfo);
		request.setAttribute("isClassING", isClassING);
		request.setAttribute("isParticlpateING", isParticlpateING);
		ActionForward forward = new ActionForward();
		forward.setPath("/view/customer/myPage/deleteUserForm.jsp");
		return forward;

	}
}
