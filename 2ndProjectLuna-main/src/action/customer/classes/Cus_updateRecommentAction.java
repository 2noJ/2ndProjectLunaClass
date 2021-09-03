package action.customer.classes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.customer.classes.Cus_updateCommentService;
import vo.ActionForward;
import vo.recomment_bean;

public class Cus_updateRecommentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		recomment_bean bean = new recomment_bean();
		bean.setRecomment_content(request.getParameter("reFixCmtCnt"));
		bean.setRecomment_num(Integer.parseInt(request.getParameter("recomment_num")));
		int CL_ID= Integer.parseInt(request.getParameter("CL_ID"));
		

		Cus_updateCommentService update = new Cus_updateCommentService();
		int check  = update.updateRecomment(bean);
		ActionForward forward = new ActionForward();
		if(check >0) {
			request.setAttribute("CL_ID",CL_ID);
			forward.setPath("classDetail.do");
		}
		else {
			forward.setPath("fail.jsp");
		}
		return forward;
	}
	
}
