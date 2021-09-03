package action.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.manager.DeleteRecommentService;
import vo.ActionForward;

public class deleterecommentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int CL_ID=Integer.parseInt(request.getParameter("comment_board"));
		int recomment_num =Integer.parseInt(request.getParameter("recomment_num"));
		
		DeleteRecommentService delete = new DeleteRecommentService();
		delete.recommentdelete(recomment_num);
		ActionForward forward = new ActionForward();
		request.setAttribute("comment_board", CL_ID);
		
		forward.setPath("commentList.do");
		return forward;
	}

}
