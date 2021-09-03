package action.customer.myPage;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.customer.myPage.MyParticipateListService;
import vo.ActionForward;
import vo.ClassBean;
import vo.PageInfo;
import vo.User;

public class MyParticipateListAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User authUser = (User) request.getSession().getAttribute("authUser");
		ArrayList<ClassBean> myParticipateList = new ArrayList<ClassBean>();
		int page = 1;
		int limit = 5;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		MyParticipateListService myParticipateListService = new MyParticipateListService();
		int listCount = myParticipateListService.getParticipateListCount(authUser);
		myParticipateList = myParticipateListService.getParticipateList(authUser, page, limit);
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
		ArrayList<Integer> headCount = new ArrayList<Integer>();
		headCount = myParticipateListService.getHeadCount(authUser, page, limit);
		request.setAttribute("headCount",headCount);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("myParticipateList", myParticipateList);
		ActionForward forward = new ActionForward();
		forward.setPath("/view/customer/myPage/myParticipateList.jsp");
		return forward;

	}
}
