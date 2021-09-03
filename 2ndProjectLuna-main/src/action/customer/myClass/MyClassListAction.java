package action.customer.myClass;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.customer.myClass.MyClassListService;
import vo.ActionForward;
import vo.ClassBean;
import vo.PageInfo;
import vo.User;

public class MyClassListAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User authUser = (User) request.getSession().getAttribute("authUser");
		ArrayList<ClassBean> myClassList = new ArrayList<ClassBean>();
		int page = 1;
		int limit = 5;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		MyClassListService myClassListService = new MyClassListService();
		int listCount = myClassListService.getClassListCount(authUser);
		myClassList = myClassListService.getClassList(authUser, page, limit);
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
		headCount = myClassListService.getHeadCount(authUser, page, limit);
		request.setAttribute("headCount",headCount);
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("myClassList", myClassList);
		ActionForward forward = new ActionForward();
		forward.setPath("/view/customer/myClass/myClassList.jsp");
		return forward;

	}
}
