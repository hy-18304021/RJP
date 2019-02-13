//アカウント製作用

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import get.Profile;
import database.InsertTest;
import get.user;
import java.util.List;

public class UserCreateServlet extends HttpServlet{

	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
		user user=new user();
		
		//文字コード
		req.setCharacterEncoding("Windows-31J");
		
		//受け取り
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		String pass2 = req.getParameter("kacupass");
		
		if(name==null||name.length()==0){
			user.setHantei(false);
			user.addError("名前が未記入");
			System.out.println("名前false");
		}
		if(pass==null||pass.length()==0){
			user.setHantei(false);
			user.addError("パスワードが未記入");
			System.out.println("パスfalse");
		}
		
		if(pass==pass2||pass.length()==pass2.length()){
			//データベースに書き込みたい
			InsertTest.insertUser_Table(name,pass);
		
			System.out.println("成功");
		}else{
			//アカウント登録に戻りパスワードが一致していないと返す
			user.setHantei(false);
			user.addError("パスワードが一致していません");
			System.out.println("パス一致false");
		}
		
		String ikisaki="/Login.html";
		
		RequestDispatcher dispatcher=req.getRequestDispatcher(ikisaki);
		dispatcher.forward(req,res);
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
	}
}