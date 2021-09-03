package action.manager;


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
import svc.customer.myClass.ClassUpdateService;
import vo.ActionForward;
import vo.ClassBean;

public class MagClassUpdateAction  implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		ClassBean classBean = null;
		Connection con= getConnection();
		CustomerDAO customerDAO=CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		
		
		String realFolder =  request.getSession().getServletContext().getRealPath("upload");
		String saveFolder = "/upload";
		int fileSize=5*1024*1024;
		ServletContext context = request.getServletContext();
		realFolder=context.getRealPath(saveFolder);   		
		MultipartRequest multi=new MultipartRequest(request, realFolder, fileSize,"UTF-8",new DefaultFileRenamePolicy());
		classBean = new ClassBean();
		classBean.setCL_ID(Integer.parseInt(multi.getParameter("CL_ID")));
		classBean.setCL_CATEGORY(multi.getParameter("CL_CATEGORY"));
		classBean.setCL_NAME(multi.getParameter("CL_NAME"));
		classBean.setCL_LOCATION(multi.getParameter("CL_LOCATION"));
		String page=multi.getParameter("page");
	
		
		ClassUpdateService classUpdateService = new ClassUpdateService();
		
		java.sql.Date sqlStartDate = new java.sql.Date(classUpdateService.strToUtilDate(multi.getParameter("CL_START_DATE")).getTime());
		java.sql.Date sqlEndDate = new java.sql.Date(classUpdateService.strToUtilDate(multi.getParameter("CL_END_DATE")).getTime());
		
		classBean.setCL_START_DATE(sqlStartDate);
		classBean.setCL_END_DATE(sqlEndDate);
		
		classBean.setCL_CAPACITY(Integer.parseInt(multi.getParameter("CL_CAPACITY")));
		classBean.setCL_CONTENT(multi.getParameter("CL_CONTENT"));
		classBean.setCL_INTRODUCTION(multi.getParameter("CL_INTRODUCTION"));
		
		boolean isWriteSuccess = false;
	
		if(multi.getParameter("whichPic").equals("기존사진")) {
			 isWriteSuccess = classUpdateService.updateClassNoPic(classBean);
		}else if(multi.getParameter("whichPic") == "기본사진") {
			classBean.setCL_IMG_PATH(null);
			 isWriteSuccess = classUpdateService.updateClass(classBean);
		} else {
			classBean.setCL_IMG_PATH(multi.getFilesystemName((String)multi.getFileNames().nextElement()));
			 isWriteSuccess = classUpdateService.updateClass(classBean);
		}

		
			if(!isWriteSuccess){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정 실패하였습니다!')");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("Mag_classDetail.do?CL_ID="+classBean.getCL_ID()+"&page="+page);
		}
		return forward;
	}
}
