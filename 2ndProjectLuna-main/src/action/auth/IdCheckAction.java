package action.auth;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import dao.SignInDAO;
import vo.ActionForward;

public class IdCheckAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
 
        String id = request.getParameter("id");
        SignInDAO dao = SignInDAO.getInstance();
        
        boolean result = dao.idCheck(id);
        
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
 
        if(result)    out.println("0"); // 아이디 중복
        else        out.println("1");
        
        out.close();
        
        return null;
    }
}