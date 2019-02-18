//TheadCreate�Ŏg��

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
		
		//�X���b�h�̃^�C�g���ƍŏ��̃��X�̍쐬
		String title=req.getParameter("");
		String res=req.getParameter("");
		String name=plist;
		
		if(title==null||title.length()==0){
			user.setHantei(false);
			user.addError("�^�C�g�������L��");
			System.out.println("�^�C�g��false");
			ikisaki="";
		}
		if(res==null||res.length()==0){
			user.setHantei(false);
			user.addError("���X�����L��");
			System.out.println("���Xfalse");
			ikisaki="";
		}
		InsertTest.insertThread(title,res);
		
		System.out.println("����");
		
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
	}
	
	public List<Thread> getList(){
		
		List<Thread> plist=QueryTest.getQueryList();
		
		return plist;
	}
}