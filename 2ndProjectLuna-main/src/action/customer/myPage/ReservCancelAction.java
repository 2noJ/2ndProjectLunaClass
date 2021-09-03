package action.customer.myPage;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.customer.myPage.ReservCancelService;
import vo.ActionForward;
import vo.User;

public class ReservCancelAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		User authUser = (User) request.getSession().getAttribute("authUser");
		String classId = (String)request.getParameter("CL_ID");
		int classId2 =  Integer.parseInt(classId);
		boolean isCancelSuccess = false;

		ReservCancelService reservCancelService = new ReservCancelService();
		isCancelSuccess = reservCancelService.reservCancel(authUser, classId2);

		
		if (!isCancelSuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('취소 실패');");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("myParticipateList.do");
		}
		return forward;
}}
