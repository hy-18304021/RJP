//�A�J�E���g����p

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import get.Profile;
import database.InsertTest;
import get.user;
import java.util.List;

public class UserCreateServlet extends HttpServlet{

	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
		user user=new user();
		
		//�����R�[�h
		req.setCharacterEncoding("Windows-31J");
		
		//�󂯎��
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		String pass2 = req.getParameter("kacupass");
		
		if(name==null||name.length()==0){
			user.setHantei(false);
			user.addError("���O�����L��");
			System.out.println("���Ofalse");
		}
		if(pass==null||pass.length()==0){
			user.setHantei(false);
			user.addError("�p�X���[�h�����L��");
			System.out.println("�p�Xfalse");
		}
		
		if(pass==pass2||pass.length()==pass2.length()){
			//�f�[�^�x�[�X�ɏ������݂���
			InsertTest.insertUser_Table(name,pass);
		
			System.out.println("����");
		}else{
			//�A�J�E���g�o�^�ɖ߂�p�X���[�h����v���Ă��Ȃ��ƕԂ�
			user.setHantei(false);
			user.addError("�p�X���[�h����v���Ă��܂���");
			System.out.println("�p�X��vfalse");
		}
		
		String ikisaki="/Login.html";
		
		RequestDispatcher dispatcher=req.getRequestDispatcher(ikisaki);
		dispatcher.forward(req,res);
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
	}
}