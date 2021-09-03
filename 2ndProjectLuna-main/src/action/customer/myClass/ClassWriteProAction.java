package action.customer.myClass;


import static db.JdbcUtil.getConnection;

import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import dao.CustomerDAO;
import svc.customer.myClass.ClassWriteProService;
import vo.ActionForward;
import vo.ClassBean;
import vo.User;

public class ClassWriteProAction  implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		ClassBean classBean = null;
		Connection con= getConnection();
		CustomerDAO customerDAO=CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		
		String realFolder =  request.getSession().getServletContext().getRealPath("upload");
		//사진 저장 경로 (폴더경로에 따라 바뀔 수 있음):
		//C:>luna>.metadata>.plugins>org.eclipse.wst.server.core>tmp0>wtpwebapps>luna>upload
		String saveFolder = "/upload";
		int fileSize=5*1024*1024;
		ServletContext context = request.getServletContext();
		realFolder=context.getRealPath(saveFolder);   		
		MultipartRequest multi=new MultipartRequest(request, realFolder, fileSize,"UTF-8",new DefaultFileRenamePolicy());
		classBean = new ClassBean();
		User user = (User)request.getSession(false).getAttribute("authUser");
		classBean.setCL_WRITER_ID(user.getId());
		classBean.setCL_CATEGORY(multi.getParameter("CL_CATEGORY"));
		classBean.setCL_NAME(multi.getParameter("CL_NAME"));
		classBean.setCL_LOCATION(multi.getParameter("CL_LOCATION"));
		
		ClassWriteProService classWriteProService = new ClassWriteProService();
		
		java.sql.Date sqlStartDate = new java.sql.Date(classWriteProService.strToUtilDate(multi.getParameter("CL_START_DATE")).getTime());
		java.sql.Date sqlEndDate = new java.sql.Date(classWriteProService.strToUtilDate(multi.getParameter("CL_END_DATE")).getTime());
		
		classBean.setCL_START_DATE(sqlStartDate);
		classBean.setCL_END_DATE(sqlEndDate);
		
		classBean.setCL_CAPACITY(Integer.parseInt(multi.getParameter("CL_CAPACITY")));
		classBean.setCL_CONTENT(multi.getParameter("CL_CONTENT"));
		classBean.setCL_INTRODUCTION(multi.getParameter("CL_INTRODUCTION"));
		classBean.setCL_IMG_PATH(multi.getFilesystemName((String)multi.getFileNames().nextElement()));
	
		boolean isWriteSuccess = classWriteProService.registClass(classBean);

		if(!isWriteSuccess){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수업 등록에 실패하였습니다. 관리자에게 문의바랍니다')");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("myClassList.do");
		}
		return forward;
	}
}
