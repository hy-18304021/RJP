//TheadCreate�Ŏg��

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import database.InsertTest;
import database.QueryTest;
import magcap.Threadpage;

public class ThreadServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
		req.setCharacterEncoding("Windows-31J");
		
		//�X���b�h�̃^�C�g���ƍŏ��̃��X�̍쐬
		String title=req.getParameter("Thread_name");
		String new_res=req.getParameter("Res");
		
		System.out.println("�󂯎�萬��");
		
		InsertTest.insertThread(title,new_res);
		
		System.out.println("����");
		
		
		//�]�����JSP���w��
		RequestDispatcher dis=req.getRequestDispatcher("/Topp");
		
		
		//�p�����[�^��JSP�ɓ]��
		dis.forward(req,res);
		System.out.println("JSP����");
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
	}
	
}