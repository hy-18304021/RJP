//resで使うサーブレット

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

public class ResServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
 		req.setCharacterEncoding("Windows-31J");
		
		List<Res> plist=getList();
		
		//レスの作成
		String res=req.getParameter("");
		String name=plist;
		
		if(res==null||res.length()==0){
			user.setHantei(false);
			user.addError("レスが未記入");
			System.out.println("レスfalse");
			ikisaki="";
		}
		
		InsertTest.insertRes(res);
		
		System.out.println("成功");
		
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
	}
	
	public List<Res> getList(){
		
		List<Res> plist=QueryTest.getQueryList();
		
		return plist;
	}
}
}