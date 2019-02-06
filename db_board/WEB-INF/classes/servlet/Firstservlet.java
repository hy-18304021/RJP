package servlet;

import beans.*;   
import arugo.*; 
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import java.io.*;
import java.util.ArrayList;


public class Firstservlet extends HttpServlet{
			
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		req.setCharacterEncoding("Windows-31J");
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		req.setCharacterEncoding("Windows-31J");
	
		String ikisaki="/index.jsp";
		HttpSession session=req.getSession();
		//�����Ől�C���̃��X�g�����o�����������B�܂��������ĂȂ�
		//OracleDBA.startSQL�͂Ƃ肠�������ׂẴX���b�h����t���Ŏ��o���ă��N�G�X�g�X�R�[�v�ɓ��ꂽ�����B
		session.setAttribute("thrList",OracleDBA.startSQL());
		session.setAttribute("popList",OracleDBA.popularSQL());
		System.out.println("�Z�b�V�����X�R�[�v��thrList�����܂����B Firstservlet 30�s��");
		System.out.println("�Z�b�V�����X�R�[�v��popList�����܂����B Firstservlet 31�s��");
		RequestDispatcher dispatcher=req.getRequestDispatcher(ikisaki);
		dispatcher.forward(req,res);
		
	}
	
}
