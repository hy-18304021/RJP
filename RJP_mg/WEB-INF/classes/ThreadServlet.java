//TheadCreateで使う

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
		
		//スレッドのタイトルと最初のレスの作成
		String title=req.getParameter("Thread_name");
		String new_res=req.getParameter("Res");
		
		System.out.println("受け取り成功");
		
		InsertTest.insertThread(title,new_res);
		
		System.out.println("成功");
		
		
		//転送先のJSPを指定
		RequestDispatcher dis=req.getRequestDispatcher("/Topp");
		
		
		//パラメータをJSPに転送
		dis.forward(req,res);
		System.out.println("JSP成功");
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
	}
	
}