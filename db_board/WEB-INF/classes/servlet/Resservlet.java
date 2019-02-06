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


public class Resservlet extends HttpServlet{
			
	//���������X���b�h������������̂�B
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		req.setCharacterEncoding("Windows-31J");
		String action=req.getParameter("action");
		HttpSession session=req.getSession();
			System.out.println("doget�n�܂���");
			//thread_id��t�������Ƃɂ��s�v�Bthread_id�ŃX���b�h������������B
			
			String thread_id=req.getParameter("thread_id");
			int threadid=Integer.parseInt(thread_id);
			ArrayList<Resbeans> resList=new ArrayList<Resbeans>();
			Buildlogic buildlogic=new Buildlogic();
			String ikisaki="/thread.jsp";
			session.setAttribute("thread_id",thread_id);
			session.setAttribute("threadname",req.getParameter("threadname"));
			session.setAttribute("threadusername",req.getParameter("creator"));
			//������titleSentence���������ăZ�b�V�����ɓ���Ă����Ȃ��Ƃ����Ȃ��B
			//�����ō��ꂽ���t���������ăZ�b�V�����ɓ���Ă����Ȃ��Ƃ����Ȃ��B
			session.setAttribute("titleSentence",OracleDBA.searchSent(threadid));
			session.setAttribute("threadTime",OracleDBA.searchDay(threadid));
			
			
			
			System.out.println("title��creator�̎擾�̓���͂���Ă���B");
			
		
			
			//������threadid(thread_id��int�^�ɂ������)�𒼐ڂ���Č�������B
			resList=buildlogic.ressearch(threadid);
			session.setAttribute("resList",resList);
			
			
			RequestDispatcher dispatcher=req.getRequestDispatcher(ikisaki);
			dispatcher.forward(req,res);
			
		
	
			
		
		
	}
	
	//�����������e������̂�B
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		req.setCharacterEncoding("Windows-31J");
		String ikisaki="/thread.jsp";
		String username=req.getParameter("username");
		String coment=req.getParameter("coment");
		String thread_id=req.getParameter("thread_id");
		
		//�����œ��e�ł������ǂ����̊m�F���邽�߂̒l���i�[
		req.setAttribute("toko",req.getParameter("toko"));
		System.out.println("Resservlet�ł�toko�̒l:"+req.getParameter("toko"));
		
		int threadid=Integer.parseInt(thread_id);
		HttpSession session=req.getSession();
		String restime=null;
		//Calendar cl=Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy�NMM��dd��HH��mm��");
		try{
			restime=sdf.format(new Date());//cl.getTime());
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		
		
		//System.out.println("Resservlet����otamesi�̒l��"+otamesi);
		System.out.println("Resservlet����restime�̒l��"+restime);
		coment=coment.replaceAll("\n","<br>");
		coment=coment.replaceAll("\r","");
		coment=coment.replaceAll("\t","&nbsp");
		
		
		Resbeans resbeans=new Resbeans();
		Buildlogic buildlogic=new Buildlogic();
		
		
		resbeans.setR_UserName(username);
		resbeans.setRes(coment);
		resbeans.setR_Thread_id(threadid);
		resbeans.setResTime(restime);
		//res�̃e�[�u����threadname����Ȃ���������resbeans�ł��l��ێ����Ȃ��ق��ɂ��Ă���B
		//resbeans.setThreadname(threadname);
		
		////////�����ŃV�[�P���X���Ȃ�������쐬�B�������牽�����Ȃ��B
		/////buildlogic.createseq(resbeans);
		
		//���̃X���b�h�Ɋւ���board_thread��rescount�̒l�̍ő�l�����o���B
		//
		String rescount=OracleDBA.rescountSearch(thread_id);
		System.out.println("Resservlet�̍���res����:"+rescount+"aaaaaaaaaaaaaaaaaaaaaaaaa");
		
		
		
		
		
		
		//���ׂĐ������Ԃ��Ă��邩��A���Ă��������������ɓn���Ă��̒l��board_res��Res_id��insert����B
		
		
		
		
		//�����ŃX���b�h�ɑ΂���R�����g��ǉ��B����ɒǉ���̃��X���X�g��Ԃ���
		//���̌ナ�N�G�X�g�X�R�[�v�ɓ����thread.jsp�ŕ\��
		buildlogic.resInsert(resbeans,rescount);
		
		ArrayList<Resbeans> resList=buildlogic.resSelect(threadid);
		//index�ŕ\��������thread�̏��������ōX�V�B
		ArrayList<Thrbeans> thrList=OracleDBA.startSQL();
		
		
		if(resList.size()!=0){
			ikisaki="/thread.jsp";
			session.setAttribute("resList",resList);
			session.setAttribute("thrList",thrList);
			System.out.println("���N�G�X�g�X�R�[�v�ɓ���邱�Ƃ��ł����B");
		}
		else{
			//�ق�Ƃ̓G���[���b�Z�[�W�̗����jsp�ɗ��������B
			ikisaki="/thread.jsp";
		}
		
		
		
		
		RequestDispatcher dispatcher=req.getRequestDispatcher(ikisaki);
		dispatcher.forward(req,res);
		
		
		
	}
	
	
		
	
	
}


