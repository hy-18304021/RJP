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
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Threadservlet extends HttpServlet{
			
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		req.setCharacterEncoding("Windows-31J");

		String title=req.getParameter("title");
		String titleSentence=req.getParameter("titleSentence");
		String creator=req.getParameter("creator");
		String createthr=req.getParameter("createthr");
		req.setAttribute("createthr",createthr);
		String day=null;
		Calendar cl=Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy�NMM��dd��HH��mm��");
		try{
			day=sdf.format(cl.getTime());
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		System.out.println("thrservlet����day�̒l��"+day);
		
		
		
		HttpSession session=req.getSession();
		//���̕ϐ��ōs��������߂�B
		String ikisaki="/createboard.jsp";
		System.out.println("�X���b�h�T�[�u���b�g��title��"+title);
		System.out.println("�X���b�h�T�[�u���b�g��titleSentence��"+titleSentence);
		System.out.println("�X���b�h�T�[�u���b�g��creator��"+creator);
		System.out.println("�X���b�h�T�[�u���b�g��day��"+day);
		
		Thrbeans thrbeans = new Thrbeans();
		Buildlogic buildlogic=new Buildlogic();
		
		thrbeans.setThreadName(title);
		thrbeans.setThreadSentence(titleSentence);
		thrbeans.setT_UserName(creator);
		thrbeans.setCreatedDate(day);
		thrbeans.setLastUpdate(day);
		//System.out.println("�r�[���ɓ��ꂽ��̃X���b�h�T�[�u���b�g��title��"+thrbeans.getTitle());
		//System.out.println("�r�[���ɓ��ꂽ��X���b�h�T�[�u���b�g��titleSentence��"+thrbeans.getTitleSentence());
		//System.out.println("�r�[���ɓ��ꂽ��X���b�h�T�[�u���b�g��creator��"+thrbeans.getCreator());
		
		buildlogic.thrbuildNull(thrbeans);
		if(thrbeans.getHantei()==true){
			////////////�薼�������Ă�����index.jsp�ɖ߂�悤�ɂȂ�B
			//������index.jsp�ɖ߂�̂ł͂Ȃ��āAthread.jsp�ɍs���悤�ɂ���B
			//ikisaki="/index.jsp";
			ikisaki="/thread.jsp";
			//�����ł̓X���b�h�̏����C���T�[�g���Ă��ׂẴX���b�h�������o���Ă���B
			//�����ŃV�[�P���X���ƃC���T�[�g����B�ŁAid�����o���Ă܂�Thrbeans�ɓ����B
			
			//������index.jsp�ŕ\��������ׂ����X�g���X�V�B��������������X���b�h���܂ރ��X�g��ς���B
			ArrayList<Thrbeans> thrList=buildlogic.thrbuild(thrbeans);
			String id=OracleDBA.searchId(creator);
			System.out.println("Threadservle�Ŏ��o����id:"+id);
			//�����őO�ɓ��e�����Ƃ��̒l���������߂�resList�������B
			session.removeAttribute("resList");
			session.setAttribute("thread_id",id);//
			session.setAttribute("threadname",title);
			session.setAttribute("titleSentence",titleSentence);//
			session.setAttribute("thrList",thrList);//
			session.setAttribute("threadTime",day);//
			session.setAttribute("threadusername",creator);
			System.out.println("thrList���Z�b�V�����ɓ���܂����B�X���b�h�̓o�^�A���̌�̃f�[�^�̎擾�����܂������܂����B");//�����łƂ��Ă����V�����̃X���b�h�̃��X�g���Z�b�V�����ɓ���Ă���B
										
			
		}
		else{
			session.setAttribute("errors",thrbeans.getError());
		}
		
		
		RequestDispatcher dispatcher=req.getRequestDispatcher(ikisaki);
		dispatcher.forward(req,res);
		
		
		
	}
	
	
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		req.setCharacterEncoding("Windows-31J");
		
	}
		
	
	
}
