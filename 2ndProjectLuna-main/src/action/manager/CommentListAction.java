package action.manager;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.manager.CommentListService;
import svc.manager.reCommentService;
import vo.ActionForward;
import vo.Mag_replyBean;
import vo.PageInfo;
import vo.recomment_bean;

public class CommentListAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//User authUser = (User) request.getSession().getAttribute("authUser");
		int page = 1;
		int limit = 5;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		
		CommentListService commentListService = new CommentListService();
		int listCount = commentListService.getCustomerListCount();
		
		
	
		Mag_replyBean replybean = new Mag_replyBean();
		recomment_bean recommentbean = new recomment_bean();
		ArrayList<Mag_replyBean> bbeanList = commentListService.getList(page, limit);	
		ArrayList<recomment_bean> recommentList = reCommentService.getlist();
		
		
	
		request.setAttribute("commentList", bbeanList);		
		request.setAttribute("recommentList", recommentList);
	
		

		int maxPage = (int) ((double) listCount / limit + 0.9);
		int startPage = (((int) ((double) page / 5 + 0.8)) -1) * 5 + 1;
		int endPage = startPage + 5 - 1;
		
		if (endPage > maxPage)
			endPage = maxPage;
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		request.setAttribute("pageinfo", pageInfo);

		ActionForward forward = new ActionForward();


		forward.setPath("/view/manager/Mag_Comment.jsp"); 
		return forward;
				

	}
}
