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
		
		System.out.println("����Ă��������username:"+username);
		//System.out.println(action);
		String ikisaki="/edit.jsp";
		
		if(action == null){
			System.out.println("Edit��action null�ɂ͂���܂����B");
			
			username=req.getParameter("editname");

			HttpSession session = req.getSession();

			//�����Ől�C���̃��X�g�����o�����������B�܂��������ĂȂ�
			//OracleDBA.startSQL�͂Ƃ肠�������ׂẴX���b�h����t���Ŏ��o���ă��N�G�X�g�X�R�[�v�ɓ��ꂽ�����B
			System.out.println("name�̒l��"+username);
			// ArrayList<String> list = OracleDBA.EditList(name);
			// System.out.println("list�̒��g��");
			// for(int i = 0; i<list.size(); i++){
				// System.out.println(list.get(i));
			// }
			
			session.setAttribute("EditList",OracleDBA.EditList(username));
			System.out.println("�Z�b�V�����X�R�[�v��EditList�����܂����B");
			RequestDispatcher dispatcher=req.getRequestDispatcher(ikisaki);
			dispatcher.forward(req,res);
		}
		
		else{
			System.out.println("Edit��action else�ɂ͂���܂����B");
			System.out.println(username);
			String id =req.getParameter("editTHREAD_ID");
			
			
			
			HttpSession session = req.getSession();
			OracleDBA.VisualThread(id);
			session.setAttribute("EditList",OracleDBA.EditList(username));
			session.setAttribute("thrList",OracleDBA.startSQL());
			System.out.println("else�̃Z�b�V�����X�R�[�v��EditList�����܂����B");
			//�܂��f�[�^�x�[�X��false�ɂ���B
			//true�̂�����\������������true�Ō���������
			//���̎�����Ă���̂̓X���b�h�������̃��X�g�B
			//���̃��X�g���Z�b�V������"EditList"�ɂ���čX�V��������B
			//edit.jsp��EditList�����o���B
			RequestDispatcher dispatcher=req.getRequestDispatcher(ikisaki);
			dispatcher.forward(req,res);
		
		}
	}
}