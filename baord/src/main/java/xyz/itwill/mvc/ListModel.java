package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.itwill.dao.BoardDAO;
import xyz.itwill.service.BoardService;

public class ListModel implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		try {
			request.setAttribute("boardList", BoardService.getService().getBoardList());
			
			actionForward.setForward(true);
			actionForward.setPath("/review/list.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			actionForward.setForward(false);
			actionForward.setPath("/error.do");		
		}
		return actionForward;
	}
}
