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
		
		String n_r="";	//ローカル変数を宣言、初期値を入れる
		
		while(true){	//無限ループにする
			if(new_res.indexOf("\r\n")>=0){	//改行があった場合ifにはいる
				n_r=new_res.replace("\r\n","<br>");	//ローカル変数にreplaceメソッドで置き換えた文字列を入れる
				System.out.println(n_r+"aaaa");
			}else{
				n_r=new_res;	//改行がなければそのまま
			}
			break;
		}
		
		
		InsertTest.insertThread(title,n_r);
		
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