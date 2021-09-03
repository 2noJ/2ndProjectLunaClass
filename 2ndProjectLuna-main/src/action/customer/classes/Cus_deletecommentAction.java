package action.customer.classes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.customer.classes.Cus_DeletecommentService;
import vo.ActionForward;

public class Cus_deletecommentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int CL_ID = Integer.parseInt(request.getParameter("CL_ID"));
		int comment_num = Integer.parseInt(request.getParameter("comment_num"));
		
		Cus_DeletecommentService delete = new Cus_DeletecommentService();
			delete.commentdelete(comment_num);
		ActionForward forward = new ActionForward();
		request.setAttribute("CL_ID", CL_ID);
			forward.setPath("classDetail.do");
			return forward;
	
	}

}
