package servlet;

import beans.*;   
import arugo.*; 
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import java.io.*;
import java.util.ArrayList;

public class EditServlet extends HttpServlet{
	
	String username=null;
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		req.setCharacterEncoding("Windows-31J");
		String action = req.getParameter("action");
		String deletethr=req.getParameter("deletethr");
		req.setAttribute("deletethr",deletethr);
		
		System.out.println("取ってきた直後のusername:"+username);
		//System.out.println(action);
		String ikisaki="/edit.jsp";
		
		if(action == null){
			System.out.println("Editのaction nullにはいりました。");
			
			username=req.getParameter("editname");

			HttpSession session = req.getSession();

			//ここで人気順のリストを取り出す処理もやる。まだ実装してない
			//OracleDBA.startSQLはとりあえずすべてのスレッドを日付順で取り出してリクエストスコープに入れただけ。
			System.out.println("nameの値は"+username);
			// ArrayList<String> list = OracleDBA.EditList(name);
			// System.out.println("listの中身は");
			// for(int i = 0; i<list.size(); i++){
				// System.out.println(list.get(i));
			// }
			
			session.setAttribute("EditList",OracleDBA.EditList(username));
			System.out.println("セッションスコープにEditListを入れました。");
			RequestDispatcher dispatcher=req.getRequestDispatcher(ikisaki);
			dispatcher.forward(req,res);
		}
		
		else{
			System.out.println("Editのaction elseにはいりました。");
			System.out.println(username);
			String id =req.getParameter("editTHREAD_ID");
			
			
			
			HttpSession session = req.getSession();
			OracleDBA.VisualThread(id);
			session.setAttribute("EditList",OracleDBA.EditList(username));
			session.setAttribute("thrList",OracleDBA.startSQL());
			System.out.println("elseのセッションスコープにEditListを入れました。");
			//まずデータベースをfalseにする。
			//trueのやつだけ表示したいからtrueで検索かける
			//この時取ってくるのはスレッド名だけのリスト。
			//このリストをセッションの"EditList"にいれて更新をかける。
			//edit.jspでEditListを取り出す。
			RequestDispatcher dispatcher=req.getRequestDispatcher(ikisaki);
			dispatcher.forward(req,res);
		
		}
	}
}