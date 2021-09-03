package action.customer.classes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.customer.classes.Cus_DeleteRecommentService;
import vo.ActionForward;

public class Cus_deleterecommentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int CL_ID=Integer.parseInt(request.getParameter("CL_ID"));
		int recomment_num =Integer.parseInt(request.getParameter("recomment_num"));
		
		Cus_DeleteRecommentService delete = new Cus_DeleteRecommentService();
		delete.recommentdelete(recomment_num);
		ActionForward forward = new ActionForward();
		request.setAttribute("CL_ID", CL_ID);
		
		forward.setPath("classDetail.do");
		return forward;
	}

}
