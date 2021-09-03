package action.customer.myPage;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.customer.myPage.DeleteUserService;
import vo.ActionForward;
import vo.User;

public class DeleteUserAction implements Action {
   private DeleteUserService deleteUserService = new DeleteUserService();
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
      forward.setPath("index.do");
      return forward;
   }

   private ActionForward processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
      User authUser = (User) req.getSession().getAttribute("authUser");
      String pwd = trim(req.getParameter("deletePwd"));
      boolean isDeleteSuccess = false;

      isDeleteSuccess=deleteUserService.deleteUserAction(authUser, pwd);
      if (!isDeleteSuccess) {
         res.setContentType("text/html;charset=UTF-8");
         PrintWriter out = res.getWriter();
         out.println("<script>");
         out.println("alert('삭제 실패');");
         out.println("history.back()");
         out.println("</script>");
      } else {
         HttpSession session = req.getSession(false);
         if (session != null) {
               session.invalidate();
            } 
         forward = new ActionForward();
         forward.setRedirect(true);
         forward.setPath("index.do");
      }
      
      return forward;
   }
   
   private String trim(String str) {
      return str == null ? null : str.trim();
   }
}