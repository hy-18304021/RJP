import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import database.QueryTest;
import magcap.Threadpage;

public class AllThreadServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
		req.setCharacterEncoding("Windows-31J");
		
		//データベースからリストをもらいたい
		List<Threadpage> threadlist=getList();
		
		//パラメータをJSPに転送したい↓
		req.setAttribute("threadindex",threadlist);
		
		//転送先のJSPを指定
		RequestDispatcher dis=req.getRequestDispatcher("/SetAllThread");
		
		System.out.println("行けます");
		
		//パラメータをJSPに転送
		dis.forward(req,res);
		}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
	}
	
	public List<Threadpage> getList(){
		List<Threadpage> threadlist=QueryTest.getThreadList();
		
		
		return threadlist;
	}
	
}