//resで使うサーブレット

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import database.QueryTest;
import java.util.List;
import database.InsertTest;
import get.ResClreate;

public class ResServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
 		req.setCharacterEncoding("Windows-31J");
		
		//スレッドの名前を受け取る
		String title=req.getParameter("");
		
		
		//レスの作成
		String new_res=req.getParameter("res");
		
		if(new_res==null||new_res.length()==0){
			System.out.println("レスfalse");
		}
		
		InsertTest.insertRes(title,new_res);
		//転送先のJSPを指定
		RequestDispatcher dis=req.getRequestDispatcher("/Thread");
		
		System.out.println("成功");
		//パラメータをJSPに転送
		dis.forward(req,res);
	}
	
	//レスページにレスを送りたい
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
		req.setCharacterEncoding("Windows-31J");
		
		//データベースからリストをもらいたい
		List<ResClreate> plist=getList();
		
		
		//パラメータをJSPに転送したい↓
		
		req.setAttribute("resindx",plist);
		
		//転送先のJSPを指定
		RequestDispatcher dis=req.getRequestDispatcher("/Thread");
		
		//パラメータをJSPに転送
		dis.forward(req,res);
		
		
	}
	public List<ResClreate> getList(){
		List<ResClreate> plist=QueryTest.getResList();
		
		return plist;
	}
	
}