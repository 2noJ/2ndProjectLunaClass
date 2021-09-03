package action.manager;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.manager.FnQInsertService;
import vo.ActionForward;


public class FnQInsertAction implements Action{
   
   private static final String FORM_VIEW = "FnQList.do";
   private FnQInsertService fnqInsertService = new FnQInsertService();
   ActionForward forward = new ActionForward();
   
   
   
   

   @Override
public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
	   
	  
	      if (req.getMethod().equalsIgnoreCase("GET")) {
		         return processForm(req, res);
		      } else if (req.getMethod().equalsIgnoreCase("POST")) {
		         return processSubmit(req, res);
		      } else { 
		         res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		      return null;
		   }

}


private ActionForward processForm(HttpServletRequest req, HttpServletResponse res) {
	
	forward.setPath(FORM_VIEW);
	return forward;
     
   }
   
   private ActionForward processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
	
      String fnq_title = trim(req.getParameter("fnq_title"));
      String fnq_content = trim(req.getParameter("fnq_content"));
     
      
      Map<String, Boolean> errors = new HashMap<>();
      req.setAttribute("errors", errors);
      
      
      try {
    	  fnqInsertService.insertFnQ(fnq_title,fnq_content);
    	  forward = new ActionForward();
			forward.setRedirect(true);
         forward.setPath("FnQList.do");
         
         return forward;
      } catch (Exception e) {
         
         forward.setPath(FORM_VIEW);
     	return forward;
      }
   }
   
   private String trim(String str) {
      return str == null ? null : str.trim();
   }
}