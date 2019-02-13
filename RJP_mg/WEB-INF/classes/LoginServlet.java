//Loginで使うサーブレット

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import get.user;
import database.Login;

import java.util.List;

public class LoginServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
 		req.setCharacterEncoding("Windows-31J");
		
		String id=req.getParameter("name");
		String pass=req.getParameter("pass");
		String ikisaki="";
		HttpSession session=req.getSession();
		user user=new user();
		Login login=new Login();
		
		user.idSet(id);
		user.passSet(pass);
		
		login.Login(user);
		
		//ログイン判定
		if(user.getHantei()==true){
			if(login.==true){
				ikisaki="/index.jsp";
				session.setAttribute("user",user);
			}
			else{
				userbeans.addError("名前またはパスワードが間違っています。");
				session.setAttribute("errors",userbeans.getError());
			}
		}else{
			req.setAttribute("errors",user.getError());
		}
		
		RequestDispatcher dispatcher=req.getRequestDispatcher(ikisaki);
		dispatcher.forward(req,res);
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
		
	}
}