package action.manager;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.customer.cusService.QnAListService;
import vo.ActionForward;
import vo.ClassBean;
import vo.PageInfo;
import vo.QNA_bean;
import vo.User;

public class MagQnAListAction implements Action{
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<QNA_bean> qnaList = new ArrayList<QNA_bean>();
		int page = 1;
		int limit = 5;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}


		QnAListService qnaListService = new QnAListService();
		int listCount = qnaListService.getQnAListCount();

		qnaList = qnaListService.getQnAList(page, limit);

		int maxPage = (int) ((double) listCount / limit + 0.9);
		int startPage = (((int) ((double) page / 5 + 0.8)) - 1) * 5 + 1;
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
		request.setAttribute("qnaList", qnaList);
		ActionForward forward = new ActionForward();
		forward.setPath("/view/manager/Mag_QnA_List.jsp");
		return forward;

	}
}
