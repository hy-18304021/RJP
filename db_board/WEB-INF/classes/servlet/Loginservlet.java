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


public class Loginservlet extends HttpServlet{
			
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		req.setCharacterEncoding("Windows-31J");

		String username=req.getParameter("username");
		String password=req.getParameter("password");
		//javascript�Ń��b�Z�[�W���o�����߂Ɏ��o���l
		String loginlog=req.getParameter("loginlog");
		System.out.println("Loginservlet��loginlog�̒l��:"+loginlog);
		//���̕ϐ��ōs��������߂�B
		String ikisaki="/login.jsp";
		HttpSession session=req.getSession();
		req.setAttribute("loginlogg",loginlog);
		System.out.println("Loginservlet�̒��̃Z�b�V�����ɓ��ꂽloginlog�̒l��"+session.getAttribute("loginlog"));
		
		Userbeans userbeans=new Userbeans();
		Login login=new Login();
		
		//userbeans.setUsername(username);
		//userbeans.setPassword(password);
		userbeans.setU_UserName(username);
		userbeans.setPassWord(password);
		
		
		login.loginNull(userbeans);
		//�����ŃZ�b�V�����ɓ���Ă���͈̂��L��������f�[�^�������Ă��܂��Ƃ���
		//��Ԃ�h�����߁B���O�C���~�X���Ă��f�[�^���c��悤�ɁB
		session.setAttribute("userlog",userbeans);
		
		if(userbeans.getHantei()==true){
			//�����Ń��O�C�����Ă���B
			
			if(login.login(userbeans)==true){
				ikisaki="/index.jsp";
				//"user"�̒l�����邩�ǂ����Ń��O�C�����Ă��邩�ǂ��������߂�B
				session.setAttribute("user",userbeans);
			}
			else{
				userbeans.addError("���O�܂��̓p�X���[�h���Ԉ���Ă��܂��B");
				session.setAttribute("errors",userbeans.getError());
				//System.out.println("�ɒl�����܂����B");
				//ikisaki="kakunin.jsp";
			}
		}
		else{
			//21�����V
			req.setAttribute("errors",userbeans.getError());
		}
		
		RequestDispatcher dispatcher=req.getRequestDispatcher(ikisaki);
		dispatcher.forward(req,res);
		
		
		
	}
	
	
	
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		req.setCharacterEncoding("Windows-31J");
		
	}
}


