package action.customer.myPage;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import svc.customer.myPage.ChangeInfoService;
import vo.ActionForward;
import vo.User;

public class ChangeInfoAction implements Action {
   private ChangeInfoService changeInfoService = new ChangeInfoService();

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
      forward.setPath("myPage.jsp");
      return forward;
   }

   private ActionForward processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
      User authUser = (User) req.getSession().getAttribute("authUser");
      boolean isModifySuccess = false;
      String col = (String) req.getAttribute("col");
      String newVal = null;

      if (col == "CUS_NAME") {
         newVal = (String)req.getParameter("name");

      } else if (col == "CUS_TEL") {
         newVal = req.getParameter("tel");

      }else if (col == "CUS_PIC") {
         newVal = (String)req.getParameter("");

      }else if (col == "CUS_ADDR") {
         newVal = req.getParameter("addr1")+"("+req.getParameter("addr2")+")|"+req.getParameter("addr3")+req.getParameter("addr4")+"("+req.getParameter("addr5")+") ";
         
      }
      isModifySuccess = changeInfoService.changeInfo(col, authUser, newVal);
      User user = changeInfoService.checkName(authUser);
      if (!isModifySuccess) {
         res.setContentType("text/html;charset=UTF-8");
         PrintWriter out = res.getWriter();
         out.println("<script>");
         out.println("alert('수정 실패');");
         out.println("history.back()");
         out.println("</script>");
      } else {
    	  req.getSession().removeAttribute("authUser");
    	  req.getSession().invalidate();
          req.getSession().setAttribute("authUser", user );
         forward = new ActionForward();
         forward.setRedirect(true);
         forward.setPath("myPage.do");
      }
      
      return forward;
   }
   
  

}