import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import info.Profile;
import database.InsertTest;
import database.QueryTest;
import java.util.List;

public class Servlet extends HttpServlet{

	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
		//�p�����[�^���󂯎�肽��
		
		//�����R�[�h
		req.setCharacterEncoding("Windows-31J");
		
		//�󂯎��
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		
		//�f�[�^�x�[�X�ɏ������݂���
		InsertTest.insertPuser_Table(name,pass);
		
		//�f�[�^�x�[�X���烊�X�g�����炢����
		List<Profile> plist=getList();
		
		
		//�p�����[�^��JSP�ɓ]����������
		
		req.setAttribute("users",plist);
		
		//�]�����JSP���w��
		RequestDispatcher dis=req.getRequestDispatcher("/list");
		
		//�p�����[�^��JSP�ɓ]��
		dis.forward(req,res);
		
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		//�f�[�^�x�[�X���烊�X�g�����炢����
		List<Profile> plist=getList();
		
		
		//�p�����[�^��JSP�ɓ]����������
		
		req.setAttribute("users",plist);
		
		//�]�����JSP���w��
		RequestDispatcher dis=req.getRequestDispatcher("/list");
		
		//�p�����[�^��JSP�ɓ]��
		dis.forward(req,res);
	}
	
	public List<Profile> getList(){
		List<Profile> plist=QueryTest.getQueryList();
		
		
		return plist;
	}

}