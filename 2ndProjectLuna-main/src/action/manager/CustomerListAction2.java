package action.manager;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.manager.CustomerListService;
import svc.manager.SearchCustomerListService;
import vo.ActionForward;
import vo.Customer_bean;
import vo.PageInfo;

 public class CustomerListAction2 implements Action {
	 
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
		
	
		 ArrayList<Customer_bean> customerList = new ArrayList<Customer_bean>();
		 
			int page = 1;
			int limit = 5;
			String search= (String)request.getParameter("search");
			
			String content = (String) request.getParameter("content");
		
			if (request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}
			
			
			
			if(search==null||content==null) {
				System.out.println("들어왔니??");
			CustomerListService customerListService = new CustomerListService();
			int listCount = customerListService.getCustomerListCount();
			System.out.println(listCount);
			customerList = customerListService.getCustomerList(page, limit);
			System.out.println(customerList);

			

			
			
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
			request.setAttribute("customerList", customerList);
			request.setAttribute("search", search);
			request.setAttribute("content", content);
			
			ActionForward forward = new ActionForward();
			
			forward.setPath("/view/manager/Mag_CustomerList.jsp");
			
			return forward;
			}
			
			
			
			
			else {
				SearchCustomerListService searchCustomerListService = new SearchCustomerListService();
				
				
				int listCount = searchCustomerListService.getSearchCustomerListCount(content,search);
				System.out.println(listCount);
				
				customerList = searchCustomerListService.getSearchCustomerList(content,search, page, limit);
				
				
				int maxPage = (int) ((double) listCount / limit + 0.9);
				int startPage = (((int) ((double) page / 5 + 0.8)) - 1) * 5 + 1;
				int endPage = startPage + 5 - 1;
				System.out.println(listCount);
				if (endPage > maxPage)
					endPage = maxPage;
				
				PageInfo pageInfo = new PageInfo();
				pageInfo.setEndPage(endPage);
				pageInfo.setListCount(listCount);
				pageInfo.setMaxPage(maxPage);
				pageInfo.setPage(page);
				pageInfo.setStartPage(startPage);
				request.setAttribute("pageInfo", pageInfo);
				request.setAttribute("customerList", customerList);
				request.setAttribute("search", search);
				request.setAttribute("content", content);
				
				ActionForward forward = new ActionForward();
				forward.setPath("/view/manager/Mag_CustomerList.jsp");
				return forward;
			}

   	
	 }
	 
}