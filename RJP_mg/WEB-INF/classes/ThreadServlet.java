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

public class ThreadServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
 		req.setCharacterEncoding("Windows-31J");
		
		//�X���b�h�̃^�C�g���ƍŏ��̃��X�̍쐬
		String title=req.getParameter("");
		String new_res=req.getParameter("");
		
		if(title==null||title.length()==0){
			System.out.println("�^�C�g��false");
		}
		if(new_res==null||new_res.length()==0){
			System.out.println("���Xfalse");
		}
		InsertTest.insertThread(title,new_res);
		
		System.out.println("����");
		//�]�����JSP���w��
		RequestDispatcher dis=req.getRequestDispatcher("/tops");
		
		System.out.println("JSP����");
		//�p�����[�^��JSP�ɓ]��
		dis.forward(req,res);
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
	}
}