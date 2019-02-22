//res�Ŏg���T�[�u���b�g

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import database.QueryTest;
import java.util.List;
import database.InsertTest;
import get.ResClreate;

public class ResServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
 		req.setCharacterEncoding("Windows-31J");
		
		//�X���b�h�̖��O���󂯎��
		String title=req.getParameter("");
		
		
		//���X�̍쐬
		String new_res=req.getParameter("res");
		
		if(new_res==null||new_res.length()==0){
			System.out.println("���Xfalse");
		}
		
		InsertTest.insertRes(title,new_res);
		//�]�����JSP���w��
		RequestDispatcher dis=req.getRequestDispatcher("/Thread");
		
		System.out.println("����");
		//�p�����[�^��JSP�ɓ]��
		dis.forward(req,res);
	}
	
	//���X�y�[�W�Ƀ��X�𑗂肽��
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
		req.setCharacterEncoding("Windows-31J");
		
		//�f�[�^�x�[�X���烊�X�g�����炢����
		List<ResClreate> plist=getList();
		
		
		//�p�����[�^��JSP�ɓ]����������
		
		req.setAttribute("resindx",plist);
		
		//�]�����JSP���w��
		RequestDispatcher dis=req.getRequestDispatcher("/Thread");
		
		//�p�����[�^��JSP�ɓ]��
		dis.forward(req,res);
		
		
	}
	public List<ResClreate> getList(){
		List<ResClreate> plist=QueryTest.getResList();
		
		return plist;
	}
	
}