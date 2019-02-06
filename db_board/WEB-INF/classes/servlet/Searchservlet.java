package servlet;


import java.io.IOException;

import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import arugo.*;
import beans.*;

public class Searchservlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
		req.setCharacterEncoding("Windows-31J");
		//OracleDBA��Search���\�b�h�Ɏ���Ă����l�������ɓn���B
		//���̂���Search���\�b�h��ArrayList<Thrbeans>��߂�����
		//��������邽�߂̕ϐ���p�ӂ���B
		//���̂��Ƃ��̕ϐ���jsp�ŕ\�������邽�߂�session�ɂ��̕ϐ���n���B
		//���̂��Ƃ��̕ϐ���jsp���Ŏ��o���B
		
		HttpSession session=req.getSession();
		
		String s=req.getParameter("serch");
		//������jsp����p�����[�^������Ă�
		System.out.println("Searchservlet�̒��̌������[�h:"+s);
		
		//oracle��"word"���킽��
		
		//�����Ă����l�� list�ƂłƂ��Ă�
		
		ArrayList<Thrbeans> result = OracleDBA.Search(s);
		//�����Œl���Ƃ��Ă���
		
		
		session.setAttribute("result",result);

		
		RequestDispatcher dispatcher=
		req.getRequestDispatcher("result.jsp");
		
		dispatcher.forward(req,res);
	}
}