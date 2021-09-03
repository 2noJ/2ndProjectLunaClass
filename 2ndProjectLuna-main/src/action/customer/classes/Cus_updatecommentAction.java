package action.customer.classes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.customer.classes.Cus_updateCommentService;
import vo.ActionForward;
import vo.replyBean;

public class Cus_updatecommentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		replyBean bean = new replyBean();
		bean.setComment_content(request.getParameter("fixcmtCnt"));
		bean.setComment_num(Integer.parseInt(request.getParameter("comment_num")));
		bean.setComment_board(Integer.parseInt(request.getParameter("CL_ID")));
		
		Cus_updateCommentService update = new Cus_updateCommentService();
		int check  = update.updatecommet(bean);
		ActionForward forward = new ActionForward();
		if(check >0) {
			request.setAttribute("CL_ID", bean.getComment_board());
			forward.setPath("classDetail.do");
		}
		else {
			forward.setPath("fail.jsp");
		}
		return forward;
	}

}
