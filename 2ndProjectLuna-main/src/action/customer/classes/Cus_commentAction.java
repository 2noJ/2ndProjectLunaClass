package action.customer.classes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.customer.classes.Cus_BoardComment;
import svc.customer.classes.Cus_reCommentService;
import vo.ActionForward;
import vo.replyBean;

public class Cus_commentAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		Cus_reCommentService recomment = new Cus_reCommentService();
		int CL_ID=Integer.parseInt(request.getParameter("CL_ID"));

		replyBean bean = new replyBean();
		Cus_BoardComment commentService = new Cus_BoardComment();

		
		bean.setComment_id(request.getParameter("comment_id"));
		bean.setComment_content(request.getParameter("comment_content"));
		bean.setComment_board((Integer.parseInt(request.getParameter("CL_ID"))));
		
		commentService.setComment(bean,CL_ID);
	
		forward.setRedirect(true);
		request.setAttribute("CL_ID", CL_ID);
		forward.setPath("classDetail.do?CL_ID="+CL_ID);
		return forward;
	}

}