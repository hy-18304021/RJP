//TheadCreate�Ŏg��

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import database.InsertTest;
import database.QueryTest;

public class ThreadServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
		req.setCharacterEncoding("Windows-31J");
		
		//�X���b�h�̃^�C�g���ƍŏ��̃��X�̍쐬
		String title=req.getParameter("Thread_name");
		String new_res=req.getParameter("Res");
		
		System.out.println("�󂯎�萬��");
		
		if(title==null||title.length()==0){
			System.out.println("�^�C�g��false");
			RequestDispatcher dis1=req.getRequestDispatcher("/Topp");
			dis1.forward(req,res);
		}
		if(new_res==null||new_res.length()==0){
			System.out.println("���Xfalse");
			RequestDispatcher dis2=req.getRequestDispatcher("/Topp");
			dis2.forward(req,res);
		}
		InsertTest.insertThread(title,new_res);
		
		System.out.println("����");
		//�]�����JSP���w��
		RequestDispatcher dis3=req.getRequestDispatcher("/Topp");
		
		System.out.println("JSP����");
		//�p�����[�^��JSP�ɓ]��
		dis3.forward(req,res);
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
	}
}