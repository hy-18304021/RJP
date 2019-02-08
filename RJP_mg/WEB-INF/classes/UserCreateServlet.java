//�A�J�E���g����p

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import database.Profile;
import database.InsertTest;
import database.QueryTest;
import java.util.List;

public class UserCreateServlet extends HttpServlet{

	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		//�p�����[�^���󂯎�肽��
		
		//�����R�[�h
		req.setCharacterEncoding("Windows-31J");
		
		//�󂯎��
		String name = req.getParameter("user_name");
		String pass = req.getParameter("user_pass");
		String pass2 = req.getParameter("user_pass_2");
		
		if(pass==pas2){
			//�f�[�^�x�[�X�ɏ������݂���
			InsertTest.insertPuser_Table(name,pass);
		
			//�f�[�^�x�[�X���烊�X�g�����炢����
			List<Profile> plist=getList();
		
			//�p�����[�^��JSP�ɓ]����������
			req.setAttribute("magsers",plist);
		
			//�]�����JSP���w��
			RequestDispatcher dis=req.getRequestDispatcher("");
		
			//�p�����[�^��JSP�ɓ]��
			dis.forward(req,res);
		}else{
			//�A�J�E���g�o�^�ɖ߂�p�X���[�h����v���Ă��Ȃ��ƕԂ�
			
		}
		
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		//�f�[�^�x�[�X���烊�X�g�����炢����
		List<Profile> plist=getList();
		
		
		//�p�����[�^��JSP�ɓ]����������
		req.setAttribute("users",plist);
		
		//�]�����JSP���w��
		RequestDispatcher dis=req.getRequestDispatcher("");
		
		//�p�����[�^��JSP�ɓ]��
		dis.forward(req,res);
	}
	
	public List<Profile> getList(){
		List<Profile> plist=QueryTest.getQueryList();
		
		
		return plist;
	}

}