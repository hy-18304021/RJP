//TheadCreateで使う

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import get.Thread;
import get.Res;
import database.InsertTest;
import database.QueryTest;
import java.util.List;

public class ThreadServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
 		req.setCharacterEncoding("Windows-31J");
		
		List<Thread> plist=getList();
		
		//スレッドのタイトルと最初のレスの作成
		String title=req.getParameter("");
		String res=req.getParameter("");
		String name=plist;
		
		if(title==null||title.length()==0){
			user.setHantei(false);
			user.addError("タイトルが未記入");
			System.out.println("タイトルfalse");
			ikisaki="";
		}
		if(res==null||res.length()==0){
			user.setHantei(false);
			user.addError("レスが未記入");
			System.out.println("レスfalse");
			ikisaki="";
		}
		InsertTest.insertThread(title,res);
		
		System.out.println("成功");
		
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
	}
	
	public List<Thread> getList(){
		
		List<Thread> plist=QueryTest.getQueryList();
		
		return plist;
	}
}