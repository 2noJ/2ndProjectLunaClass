package action.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.customer.classes.Cus_reCommentService;
import vo.ActionForward;
import vo.recomment_bean;

public class recommentAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		;
		ActionForward forward = new ActionForward();
		Cus_reCommentService recomment = new Cus_reCommentService();
		int CL_ID=Integer.parseInt(request.getParameter("CL_ID"));
		String page = request.getParameter("page");
		int comment_num = Integer.parseInt(request.getParameter("recomment_comment_num"));
		String writer_id =request.getParameter("comment_id");
		String recontent = request.getParameter("reCmtCnt");
			
		
		
		recomment_bean bean = new recomment_bean();
		bean.setrecomment_comment_num(Integer.parseInt(request.getParameter("recomment_comment_num")));
		bean.setRecomment_id(request.getParameter("comment_id"));
		bean.setRecomment_content(request.getParameter("reCmtCnt"));
		recomment.insertRecomment(bean);
		
		request.setAttribute("CL_ID", CL_ID);
		forward.setPath("detail.do");
		return forward;
	}

}
