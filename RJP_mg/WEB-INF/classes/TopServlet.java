//index�Ŏg���T�[�u���b�g

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import database.InsertTest;
import database.QueryTest;
import java.util.List;
import java.util.ArrayList;
import get.Thread;

public class TopServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
 		req.setCharacterEncoding("Windows-31J");
		
		//�X���b�h���ƃ��X�̎󂯎��
		String thread=req.getParameter("Thread");
		String res_con=req.getParameter("Res");
		
		System.out.println("�X���b�h���ƃ��X���󂯎����");
		
		List<String> list=new ArrayList<>();
		
		list.add(thread);
		list.add(res_con);
		
		System.out.println("list�ɓ����Ă���");
		req.setAttribute("threadKakunin",list);
		
		RequestDispatcher dis=req.getRequestDispatcher("/Threadkakunin");
		dis.forward(req,res);
		
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
		 req.setCharacterEncoding("Windows-31J");
		
		//�f�[�^�x�[�X���烊�X�g�����炢����
		List<Thread> plist=getList();
		
		
		//�p�����[�^��JSP�ɓ]����������
		req.setAttribute("threadindex",plist);
		
		//�]�����JSP���w��
		RequestDispatcher dis=req.getRequestDispatcher("/Topp");
		
		//�p�����[�^��JSP�ɓ]��
		dis.forward(req,res);
		
	}
	
	public List<Thread> getList(){
		List<Thread> plist=QueryTest.getThreadList();
		
		return plist;
	}
	
}