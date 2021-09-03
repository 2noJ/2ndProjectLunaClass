package action.manager;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.manager.Mag_cusResListService;
import vo.ActionForward;
import vo.CusRes_bean;
import vo.PageInfo;

public class Mag_CusresListAction implements Action {

public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<CusRes_bean> cusResList = new ArrayList<CusRes_bean>();
		int page = 1;
		int limit = 5;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		Mag_cusResListService cusResListService = new Mag_cusResListService();
		int listCount = cusResListService.getCusResListCount();

		cusResList = cusResListService.getCusResList(page, limit);

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
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("cusResList", cusResList);
		ActionForward forward = new ActionForward();
		forward.setPath("/view/manager/Mag_Customer_reservation.jsp");
		return forward;
	}
}

