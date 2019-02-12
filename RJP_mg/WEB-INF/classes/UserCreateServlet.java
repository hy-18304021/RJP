//アカウント製作用

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
		//パラメータを受け取りたい
		
		//文字コード
		req.setCharacterEncoding("Windows-31J");
		
		//受け取り
		String name = req.getParameter("user_name");
		String pass = req.getParameter("user_pass");
		String pass2 = req.getParameter("user_pass_2");
		
		if(pass==pas2){
			//データベースに書き込みたい
			InsertTest.insertPuser_Table(name,pass);
		
			//データベースからリストをもらいたい
			List<Profile> plist=getList();
		
			//パラメータをJSPに転送したい↓
			req.setAttribute("magsers",plist);
		
			//転送先のJSPを指定
			RequestDispatcher dis=req.getRequestDispatcher("");
		
			//パラメータをJSPに転送
			dis.forward(req,res);
		}else{
			//アカウント登録に戻りパスワードが一致していないと返す
			
		}
		
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		//データベースからリストをもらいたい
		List<Profile> plist=getList();
		
		
		//パラメータをJSPに転送したい↓
		req.setAttribute("users",plist);
		
		//転送先のJSPを指定
		RequestDispatcher dis=req.getRequestDispatcher("");
		
		//パラメータをJSPに転送
		dis.forward(req,res);
	}
	
	public List<Profile> getList(){
		List<Profile> plist=QueryTest.getQueryList();
		
		
		return plist;
	}

}