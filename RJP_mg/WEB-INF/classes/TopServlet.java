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
		
		System.out.println(list);
		req.setAttribute("ThreadRes",list);
		
		RequestDispatcher dis=req.getRequestDispatcher("/Threadkakunin");
		dis.forward(req,res);
		
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		

	}
	
}