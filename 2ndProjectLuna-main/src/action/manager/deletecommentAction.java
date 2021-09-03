package action.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.manager.DeletecommentService;
import vo.ActionForward;

public class deletecommentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int CL_ID = Integer.parseInt(request.getParameter("comment_board"));
		int comment_num = Integer.parseInt(request.getParameter("comment_num"));
		
		DeletecommentService delete = new DeletecommentService();
			delete.commentdelete(comment_num);
		ActionForward forward = new ActionForward();
		request.setAttribute("comment_board", CL_ID);
			forward.setPath("commentList.do");
			return forward;
	
	}

}
