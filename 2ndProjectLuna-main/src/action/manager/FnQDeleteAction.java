package action.manager;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.manager.FnQDeleteService;
import vo.ActionForward;


public class FnQDeleteAction implements Action{
   
   private static final String FORM_VIEW = "FnQList.do";
   private FnQDeleteService fnqDeleteService = new FnQDeleteService();
   ActionForward forward = new ActionForward();
  
   
   
   

   @Override
public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
	   
	  
	      if (req.getMethod().equalsIgnoreCase("GET")) {
		         return processSubmit(req, res);
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
    
      int fnq_id = Integer.parseInt(trim(req.getParameter("fnq_id")));
     
     
    
     
    
    
      
      Map<String, Boolean> errors = new HashMap<>();
      req.setAttribute("errors", errors);
      
      
      try {
    	  fnqDeleteService.deleteFnQ(fnq_id);
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