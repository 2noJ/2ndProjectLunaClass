package action.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.manager.MagNoticeUpdateService;
import vo.ActionForward;

public class MagNoticeUpdateAction implements Action {
	
private static final String FORM_VIEW = "MagNoticeList.do";
   private MagNoticeUpdateService magNoticeUpdateService = new MagNoticeUpdateService();
   ActionForward forward = new ActionForward();

   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
     
	   if (request.getMethod().equalsIgnoreCase("GET")) {
         return processForm(request, response);
      } else if (request.getMethod().equalsIgnoreCase("POST")) {
         return processSubmit(request, response);
      } else {
         response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
         return null;
      }
   }

   private ActionForward processForm(HttpServletRequest req, HttpServletResponse res) {
		
		forward.setPath(FORM_VIEW);
		return forward;
	     
	   }
   private ActionForward processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
	  String notice_title = req.getParameter("notice_title");
      String notice_content = req.getParameter("notice_content");
      int notice_id = Integer.parseInt(req.getParameter("notice_id"));

      try {
    	  magNoticeUpdateService.updateNotice(notice_title, notice_content, notice_id);
         forward.setPath("MagNoticeList.do");
         
         return forward;
      } catch (Exception e) {
         
         forward.setPath(FORM_VIEW);
     	return forward;
      }
   }
   
}