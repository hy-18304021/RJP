package servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import java.io.*;
import java.util.ArrayList;
import beans.*;   
import arugo.*; 
import javax.servlet.http.HttpSession;
    
public class Logoutservlet extends HttpServlet{
				
	
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		req.setCharacterEncoding("Windows-31J");
		String ikisaki="/index.jsp";
		HttpSession session=req.getSession();
		session.removeAttribute("user");
		req.removeAttribute("loginlog");
		System.out.println("�Z�b�V������user�������܂����B");
		System.out.println("���O�A�E�g!!");
		req.setAttribute("logoutlogg","logoutlog");
		RequestDispatcher dispatcher=req.getRequestDispatcher(ikisaki);
		dispatcher.forward(req,res);
	}
	
}