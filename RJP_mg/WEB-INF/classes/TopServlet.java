//indexで使うサーブレット

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
		
		//スレッド名とレスの受け取り
		String thread=req.getParameter("Thread");
		String res_con=req.getParameter("Res");
		
		System.out.println("スレッド名とレスを受け取った");
		
		List<String> list=new ArrayList<>();
		
		list.add(thread);
		list.add(res_con);
		
		System.out.println("listに入っている");
		req.setAttribute("threadKakunin",list);
		
		RequestDispatcher dis=req.getRequestDispatcher("/Threadkakunin");
		dis.forward(req,res);
		
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
		 req.setCharacterEncoding("Windows-31J");
		
		//データベースからリストをもらいたい
		List<Thread> plist=getList();
		
		
		//パラメータをJSPに転送したい↓
		req.setAttribute("threadindex",plist);
		
		//転送先のJSPを指定
		RequestDispatcher dis=req.getRequestDispatcher("/Topp");
		
		//パラメータをJSPに転送
		dis.forward(req,res);
		
	}
	
	public List<Thread> getList(){
		List<Thread> plist=QueryTest.getThreadList();
		
		return plist;
	}
	
}