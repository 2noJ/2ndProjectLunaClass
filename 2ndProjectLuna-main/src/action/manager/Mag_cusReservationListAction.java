package action.manager;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.manager.Mag_cusReservationListService;
import vo.ActionForward;
import vo.CusRes_bean;
import vo.PageInfo;

public class Mag_cusReservationListAction implements Action {

public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	String cusid = (String) request.getParameter("cusid");

		ArrayList<CusRes_bean> cusResList = new ArrayList<CusRes_bean>();
		int page = 1;
		int limit = 5;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		Mag_cusReservationListService cusReservationListService = new Mag_cusReservationListService();
		int listCount = cusReservationListService.getCusResListCount(cusid);
	
		cusResList = cusReservationListService.getCusResList(page, limit,cusid);
	
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
		request.setAttribute("cusid", cusid);
		ActionForward forward = new ActionForward();
		forward.setPath("/view/manager/Mag_cusReservationList.jsp");
		return forward;
	}
}

