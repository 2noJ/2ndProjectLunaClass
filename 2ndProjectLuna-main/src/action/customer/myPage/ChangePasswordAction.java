package action.customer.myPage;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.manager.ChangePasswordService;
import vo.ActionForward;
import vo.User;

public class ChangePasswordAction implements Action {
	private ChangePasswordService changePasswordService = new ChangePasswordService();
	ActionForward forward = new ActionForward();

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			return processForm(request, response);
		} else if (request.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private ActionForward processForm(HttpServletRequest req, HttpServletResponse res) {

		forward.setPath("myPage.jsp");
		return forward;

	}

	private ActionForward processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		User authUser = (User) req.getSession().getAttribute("authUser");
		String curPass = trim(req.getParameter("curPass"));
		String newPass = trim(req.getParameter("newPass"));
		String newPassC = trim(req.getParameter("newPassC"));
		boolean isModifySuccess = false;
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		if (!newPass.equals(newPassC)) {
			errors.put("notMatchPass", Boolean.TRUE);
		}
		if (!errors.isEmpty()) {
			forward.setPath("myPage.do");
			res.setContentType("text/html;charset=UTF-8");
			return forward;
		}
		isModifySuccess = changePasswordService.changePassword(authUser, curPass, newPassC);
		if (!isModifySuccess) {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('수정 실패');");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("myPage.do");
		}
		return forward;
	}

	private String trim(String str) {
		return str == null ? null : str.trim();
	}
}
