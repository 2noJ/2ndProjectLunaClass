package action.customer.cusService;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import filter.LoginCheckFilter;
import svc.customer.cusService.QnAInsertService;
import vo.ActionForward;



public class QnAInsertAction implements Action{
   
   private static final String FORM_VIEW = "QnAlist.do";

   ActionForward forward = new ActionForward();
   QnAInsertService qnaInsertService=new QnAInsertService();
   LoginCheckFilter logcheck = new LoginCheckFilter();
   
   
   

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
	   
	   
	   String qna_writer_id = trim(req.getParameter("qa_writer_id"));
      String qna_title = trim(req.getParameter("qa_title"));
      String qna_content = trim(req.getParameter("qa_content"));
     
      
      Map<String, Boolean> errors = new HashMap<>();
      req.setAttribute("errors", errors);
      
      
      try {
    	  qnaInsertService.insertQnA(qna_writer_id,qna_title,qna_content);
    	  forward = new ActionForward();
			forward.setRedirect(true);
    	  forward.setPath("QnAlist.do");
         
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