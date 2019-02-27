import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import database.QueryTest;
import get.Threadpage;

public class AllThreadServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
		req.setCharacterEncoding("Windows-31J");
		
		//�f�[�^�x�[�X���烊�X�g�����炢����
		List<Threadpage> plist=getList();
		
		//�p�����[�^��JSP�ɓ]����������
		req.setAttribute("threadindex",plist);
		
		//�]�����JSP���w��
		RequestDispatcher dis=req.getRequestDispatcher("/SetAllThread");
		
		System.out.println("�s���܂�");
		
		//�p�����[�^��JSP�ɓ]��
		dis.forward(req,res);
		}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
	}
	
	public List<Threadpage> getList(){
		List<Threadpage> plist=QueryTest.getThreadList();
		
		
		return plist;
	}
	
}