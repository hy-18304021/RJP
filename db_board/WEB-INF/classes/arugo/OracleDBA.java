//��������sql��������Ă��邪�A�������select�������郁�\�b�h�Ainsert�������郁�\�b�h�Ȃǂ�閽�߂��Ƃ�sql����
//�n���ē������\�b�h�����ق��������C�����Ă���B������ŏI�I�Ɏl���炢�Ɏ��߂�ꂽ��悢���ȁ[
//oracledba�̎�O��beans������Java�t�@�C����sql�������B����sql����OracleDBA�ɂ����OracleDBA�͂���sql���̖��߂�
//�����������Ă����ق����ǂ��Ǝv���B�̂��̂���낤�B
package arugo;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import beans.Userbeans;
import beans.Resbeans;
import beans.Thrbeans;
import java.text.SimpleDateFormat;
public class OracleDBA{
	private static Connection conn=null;
	private PreparedStatement st = null;
	private ResultSet rs=null;
	//sql���ŊY���������ʂ�beans�ɂ���Ă���ɂ���beans�����X�g�Ƃ��ĕԂ����߂̃��X�g�B
	//private ArrayList<Resbeans> resList=new ArrayList<Resbeans>();
	//private ArrayList<Thrbeans> thrList=new ArrayList<Thrbeans>();
	//���̃��X�g�ɂ͑������������Ȃ��B���O�C���ł��邩�ǂ����͂��̃��X�g�ɂ��̂�����������Ă��邩�ǂ����B
	
	
	
	//OracleDBA�t�@�C�����g���Ƃ���΂ɍŏ��ɂ���B
	//getConnection�͖��O��ς���BsetConnection�݂����Ȗ��O�ɂ���B
	public static void getConnection(){
		try{
			System.out.println("jdbc�h���C�o�̐ݒu");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","info","pro");
			System.out.println("�ڑ�����");
			//rs.close();
		}
		catch(Exception e){
			System.out.println("getConnection�̗�O�ł��B");
			e.printStackTrace();
		}
		
		
	}
	
	
	
	//date
	public ArrayList<Thrbeans> thrInsert(Thrbeans thr){
		System.out.println("thrInsert50�s�ڊJ�n");
		boolean hantei=false;
		ArrayList<Thrbeans> thrList=new ArrayList<Thrbeans>();
		ArrayList<Thrbeans> popList=new ArrayList<Thrbeans>();
		getConnection();
		//select�ŉ����̃f�[�^�����o���Ă��邩
		int count=0;
		try{
			System.out.println("thrInsert��try��J�n");
			//�f�t�H���g�Ńf�[�^�x�[�X�ɍ��ꂽ���̎��Ԃ������Ă��邩�炱���ŃC���T�[�g���Ȃ��Ă��悢�B
			//String sql="insert into board_thread values(?,?,?,?,?,?,thread_seq.NEXTVAL,?)";
			
			String sql="insert into board_thread(T_Thread_id,ThreadName,ThreadSentence,T_UserName,CreatedDate,LastUpdate) values(thread_seq.NEXTVAL,?,?,?,?,?)";
			st=conn.prepareStatement(sql);//�������G���[
			System.out.println("thrInsert��st���܂������Ă���63�s��");
			
			//st.setInt(1,thr.getT_Thread_id());//���������͂��Ȃ��Ă�thread_seq.NEXTVAL�ŃC���T�[�g����Ă�Ǝv���B
			st.setString(1,thr.getThreadName());
			st.setString(2,thr.getThreadSentence());
			//st.setInt(3,thr.getResCount());
			//st.setString(5,thr.getCreatedDate());
			//st.setString(6,thr.getLastUpdate());
			st.setString(3,thr.getT_UserName());
			st.setString(4,thr.getCreatedDate());
			st.setString(5,thr.getLastUpdate());

			//st.setInt(4,thread_seq.NEXTVAL);
//			st.setInt(4,thr.getReply_nb());
			//st.setDate(6,thr.getCreated_date()); //�����ł�6�ڂ�?��sysdate���ꂽ��悢�����B
			//st.setDate(7,thr.getLast_update());//update�͂킩���B�f�t�H���g�ō�����������Ă����B���̌�ɕҏW�{�^���������ꂽ�炻���ɕҏW�������Ԃ�ǉ�������ė��ꂩ�ȁH
			System.out.println("thrInsert��set�n�I��p77�s��");
			int num=st.executeUpdate();
			if(num==1){
				System.out.println("�X���b�h��insert���������܂����B(thrInsert�̂��)�B80�s��");
			}
			sql="select * from board_thread where VISUAL = 'true' order by T_Thread_id desc";
			st=conn.prepareStatement(sql);
			System.out.println("thrInsert�̓��ڂ�st�������Bp84");
		
			rs=st.executeQuery();
			System.out.println("thrInsert��executeQuery()���J�n�Bp87");
			while(rs.next()){
				
				Thrbeans tb=new Thrbeans();
				tb.setT_Thread_id(rs.getInt("T_Thread_id"));
				tb.setThreadName(rs.getString("ThreadName"));
				tb.setThreadSentence(rs.getString("ThreadSentence"));
				tb.setResCount(rs.getInt("ResCount"));
				tb.setCreatedDate(rs.getString("CreatedDate"));
				tb.setLastUpdate(rs.getString("LastUpdate"));
				thrList.add(tb);
				count=count+1;
			}
			System.out.println("thrInsert select��"+count+"���f�[�^���擾�ł����Bp100");
			
			
			//�l�C����select
			sql="select * from board_Thread where VISUAL = 'true' order by RESCOUNT desc ";
			st=conn.prepareStatement(sql);
			System.out.println("popList��select���������� OracleDBA:105�s��");
			
			count = 0;
			rs=st.executeQuery();
			System.out.println("popList��executeQuery()���J�n�Bp108");
			while(rs.next()){
				
				Thrbeans ptb=new Thrbeans();
				ptb.setT_Thread_id(rs.getInt("T_Thread_id"));
				ptb.setThreadName(rs.getString("ThreadName"));
				ptb.setThreadSentence(rs.getString("ThreadSentence"));
				ptb.setResCount(rs.getInt("ResCount"));
				ptb.setCreatedDate(rs.getString("CreatedDate"));
				ptb.setLastUpdate(rs.getString("LastUpdate"));
				popList.add(ptb);
				count=count+1;
			}
			System.out.println("popList select��"+count+"���̃f�[�^���擾�ł����BOracleDBA122�s��");
			st.close();
			
		}catch(SQLException e){
			System.out.println("thrInsert�̗�O�ł��B");
			e.printStackTrace();
		}
		System.out.println("thrInsert���\�b�h�I��");
		return thrList;
	}

	
	//Login�t�@�C����login���\�b�h���g���Ƃ��Ɏg����B
	public boolean userSelect(Userbeans user){
		System.out.println("userSelect���\�b�h�J�n");
		boolean hasClient=false;
		getConnection();
		//private static Connection conn=null;
		//private PreparedStatement st = null;
		//private ResultSet rs=null;
		
		try{
			
			String sql="select * from board_user where U_UserName = ? and PassWord = ?";
		
			st=conn.prepareStatement(sql);
			
			System.out.println("userSelect��st�͂��܂�������p127");
			st.setString(1,user.getU_UserName());
			st.setString(2,user.getPassWord());
			System.out.println("userSelect��setString�����܂��������Bp130");
			rs=st.executeQuery();
			System.out.println("userSelect��rs�����܂�������p132");
			
			
			//���R�[�h���I������Ă��Ȃ��\��������B
			if(rs.next()){
				hasClient = true;
			}
			st.close();
		}catch(SQLException e){
			System.out.println("userSelect�̗�O�ł��B");
			e.printStackTrace();
			
		
		}
		System.out.println("userSelect���\�b�h�I��");
		return hasClient;
		
	}
	
	public boolean userInsert(Userbeans user){
		System.out.println("userInsert���\�b�h�J�n");
		boolean hantei=false;
		try{
			getConnection();
			String sql="insert into board_user values(?, ?)";
			st=conn.prepareStatement(sql);
			System.out.println("userInsert��st�͂��܂��������B158�s��");
			st.setString(1,user.getU_UserName());
			st.setString(2,user.getPassWord());
			System.out.println("userInsert��st�����܂��������B162�s��");
			int num=st.executeUpdate();
			//System.out.println("���ʂ��Ԃ��Ă����B");
			System.out.println("executeUpdate�����܂��������B165�s��");
				
			if(num==1){
				hantei=true;
			}

			st.close();
		}
		catch(SQLException e){
			System.out.println("userInsert�̗�O�ł��B");
			e.printStackTrace();
			
		}
		System.out.println("userInsert���\�b�h�I��");
		return hantei;
		
	}
	
	
	public static ArrayList<Thrbeans> startSQL(){
		System.out.println("startSQL���\�b�h�J�n");
		ArrayList<Thrbeans> thrList=new ArrayList<Thrbeans>();
		try{
			String sql="select * from board_Thread where VISUAL = 'true' order by CreatedDate desc ";
			getConnection();
			
			PreparedStatement st=conn.prepareStatement(sql);
			System.out.println("startSQL��st�����܂��������B192�s��");
			ResultSet rs=st.executeQuery();
			System.out.println("startSQL��rs�Ɍ��ʂ��������Bp194�s��");
			while(rs.next()){
				Thrbeans tb=new Thrbeans();
				tb.setT_Thread_id(rs.getInt("T_Thread_id"));
				tb.setThreadName(rs.getString("ThreadName"));
				tb.setThreadSentence(rs.getString("ThreadSentence"));
				tb.setResCount(rs.getInt("ResCount"));
				tb.setCreatedDate(rs.getString("CreatedDate"));
				tb.setLastUpdate(rs.getString("LastUpdate"));
				tb.setT_UserName(rs.getString("T_UserName"));
				tb.setVisual(rs.getString("Visual"));
				thrList.add(tb);
				
			}
			System.out.println("startSQL��thrList��Ԃ��B208�s��");
			st.close();
		}catch(SQLException e){
			System.out.println("startSQL�̗�O�ł��B");
			e.printStackTrace();
		}
		System.out.println("startSQL���\�b�h�I��");
		return thrList;
	}
	
	//�ق�Ƃ͂����̓X���b�h��id�Ō�������Έꔭ�����Ǎ��̎��_��
	//���܂�id��t������@��������Ȃ�����Ƃ肠����title��creator��
	//�����������Ă���B
	//���̃��\�b�h�K�v�Ȃ��Ȃ邩���B
	public String thrsearch(int T_Thread_id){
		System.out.println("thrsearch���\�b�h�J�n");
		String ThreadName="";
		try{
			getConnection();
			String sql="select ThreadName from board_thread where T_Thread_id=? and VISUAL = 'true'";
			st=conn.prepareStatement(sql);
			st.setInt(1,T_Thread_id);
			System.out.println("thrsearch��st�����܂��������B230�s��");
			rs=st.executeQuery();
			System.out.println("thrsearch��rs�����܂��������B232�s��");
			if(rs.next()){
				ThreadName=rs.getString("ThreadName");
				System.out.println("thrsearch�ŃX���b�h���擾�ł����B235�s��");
			}
			
			st.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		System.out.println("thrsearch���\�b�h�I��");
		return ThreadName;
		
	}
	
	public ArrayList<Resbeans> ressearch(int threadid){
		System.out.println("ressearch���\�b�h�J�n");
		ArrayList<Resbeans> resList=new ArrayList<Resbeans>();
		
		try{
			getConnection();
			String sql="select * from board_res where R_Thread_id =? order by Res_id  desc";
			st=conn.prepareStatement(sql);
			System.out.println("ressearch��st�����܂��������B255�s��");
			st.setInt(1,threadid);
			rs=st.executeQuery();
			System.out.println("ressearch��rs�����܂��������B258�s��");
			while(rs.next()){
				Resbeans res=new Resbeans();
				res.setR_Thread_id(rs.getInt("R_Thread_id"));
				res.setRes_id(rs.getInt("Res_id"));
				res.setR_UserName(rs.getString("R_UserName"));
				res.setRes(rs.getString("Res"));
				res.setResTime(rs.getString("ResTime"));
				resList.add(res);
			}
			st.close();
		}catch(SQLException e){
			System.out.println("ressearch�̗�O�ł��B");
			e.printStackTrace();
		}
		System.out.println("ressearch���\�b�h�I��");
		return resList;
		
	}
	
	//�����œ��e���ꂽ���X��ǉ���A�ǉ���̃��X�����ׂĂƂ��Ă���B
	//�Ƃ肠����comentnumber�͖���
	public void resInsert(Resbeans res,String resnumber){
		System.out.println("resInsert���\�b�h�J�n");
		int threadid=res.getR_Thread_id();
		int number=Integer.parseInt(resnumber);
		String restime=res.getResTime();
		System.out.println("resInsert����restime��"+restime+"287�s��");
		++number;
		try{
			getConnection();
			
			//res.getR_ThreadName() Res���C���T�[�g����Ƃ���id��Thread.jsp���瑗����悤�ɂ���B
			//String sql="insert into board_res values(?,?,?,"+res.getR_Thread_id()+"_seq.NEXTVAL"+",?,?)";
			System.out.println("insert����Ƃ���number��"+number+"�ł��B");
			String sql="insert into board_res(R_Thread_id,Res_id,R_UserName,Res,ResTime) values(?,"+number+",?,?,?)";
			//sql2�̓C���T�[�g�������ResCount�̍X�V��sql;
			String sql2="update board_thread set ResCount="+number+"where T_Thread_id="+threadid;
			
			st=conn.prepareStatement(sql);
			System.out.println("resinsert��st�������Ă���B292�s��");
			st.setInt(1,res.getR_Thread_id());
			//���Xid�̓V�[�P���X�����̂܂܃C���T�[�g����B
			//st.setInt(2,res.getRes_id());
			st.setString(2,res.getR_UserName());
			st.setString(3,res.getRes());
			st.setString(4,res.getResTime());
			//st.setString(5,res.getResTime());
			int num=st.executeUpdate();
			System.out.println(" resinsert��executeUpdate�����܂��������B300�s��");
			
			if(num==1){
				System.out.println("resinsert ���e�ł����Binsert���� 303�s��");
			}
			else{
				System.out.println("resinsert ���e�ł��܂���ł����Binsert���s 306�s��");
			}
			st=conn.prepareStatement(sql2);
			System.out.println("T_Thread_id��st�����B315�s��");
			int num2=st.executeUpdate();
			if(num2==1){
				System.out.println("���e���thread�\��rescount�̍X�V�ɐ����B318�s��");
			}else{
				System.out.println("���e���rescount�̍X�V�Ɏ��s���Ă���B320�s��");
			}
			updateLasttime(threadid,restime);
			
			st.close();
		}catch(SQLException e){
			System.out.println("resInsert�̗�O�ł��B");
			e.printStackTrace();

		}
		System.out.println("resInsert���\�b�h�I��");
		
	}
	
	//���̃X���b�h�Ɋւ���V�[�P���X�����邩�ǂ����𔻒�B
	//�Ȃ�������X���b�h��.seq�Ƃ����V�[�P���X�����B
	//�������炻�̂܂܃V�[�P���X���g���B
	//��������resbeans�������Ɏ��B
	//
	//���̃��\�b�h�͂�߂�B�V�[�P���X�̘A�Ԃ̓C���N�������g�ł���B
	public void creresseq(Resbeans res){
		try{
			getConnection();
			String sql="select max(Res_id) from board_res where R_Thread_id=?";
			st=conn.prepareStatement(sql);
			System.out.println("creresseq conn.prepareStatement�͂��܂������Ă���B330�s��");
			st.setInt(1,res.getR_Thread_id());
			rs=st.executeQuery();
			System.out.println("st.executeQuery�͂��܂������Ă���B333�s��");
			rs.next();
			System.out.println("rs.next�͂��܂������Ă���B335�s��");
			
			int hantei=rs.getInt(1);
			System.out.println("creresseq ����̒��g��"+hantei+"338�s��");
			if(hantei==0){
				System.out.println("�V�[�P���X�̔��f�̂��߂̔��肪���܂��������B");
				sql="CREATE SEQUENCE "+res.getR_Thread_id()+"_seq START WITH 1 INCREMENT BY 1 NOMAXVALUE";
				st=conn.prepareStatement(sql);
				System.out.println("if���̒���prepareStatemenet�����܂��������B");
				st.executeUpdate(sql);
				System.out.println("�V�[�P���X���쐬���邱�Ƃ��ł����B");
			}else{
				System.out.println("creresseq�쐬���s");
				System.out.println(res.getR_Thread_id()+"_seq�͂��łɑ��݂��Ă��܂��B");
			}
			st.close();
		}catch(SQLException e){
			System.out.println("creresseq�̗�O�ł��B");
			e.printStackTrace();
		}
		System.out.println("creresseq���\�b�h�I��");
	}
	
	//���̃��\�b�h����߂Ă������ق����ǂ��̂�������Ȃ��B
	//���炩���߃f�[�^�x�[�X�Ɏ����ō���Ă����Ƃ悢�����B
	//�X���b�h���Ƃɖ��񂱂̔��f����̂͌����������B
	public void crethrseq(){
		try{
			getConnection();
			String sql="select max(T_Thread_id) from board_thread";
			st=conn.prepareStatement(sql);
			rs=st.executeQuery();
			
			rs.next();
			//thr.setThread_id(rs.getInt(1));
			
			int hantei=rs.getInt(1);
			System.out.println("�V�[�P���X�̔��f�̂��߂̔��肪���܂��������B");
			System.out.println("����̒��g��"+hantei);
			if(hantei==0){
				System.out.println("�V�[�P���X�̔��f�̂��߂�if���J�n");
				sql="CREATE SEQUENCE thread_seq START WITH 1 INCREMENT BY 1 NOMAXVALUE";
				st=conn.prepareStatement(sql);
				System.out.println("if���̒���prepareStatemenet�����܂��������B");
				st.executeUpdate(sql);
				System.out.println("�V�[�P���X���쐬���邱�Ƃ��ł����B");
			}
			else{
				System.out.println("���ł�thread_seq�͑��݂��܂��B");
			}
			
			st.close();
		}catch(SQLException e){
			System.out.println("crethrseq�̗�O�ł��B");
			e.printStackTrace();
		}
		System.out.println("crethrseq���\�b�h�I��");
	}

	public ArrayList<Resbeans> resSelect(int R_Thread_id){
		System.out.println("resSelect���\�b�h�J�n");
		ArrayList<Resbeans> resList=new ArrayList<Resbeans>();
		try{
			getConnection();
			String sql="select * from board_res where R_Thread_id =? order by Res_id desc ";
			st=conn.prepareStatement(sql);
			System.out.println("resSelect��st�����܂������Ă���B401�s��");
			st.setInt(1,R_Thread_id);
			rs=st.executeQuery();
			System.out.println("resSelect��executequery�����܂������Ă��� 404�s��");
			while(rs.next()){
				Resbeans rb=new Resbeans();
				rb.setR_UserName(rs.getString("R_UserName"));
				rb.setRes(rs.getString("Res"));
				rb.setResTime(rs.getString("ResTime"));
				rb.setRes_id(rs.getInt("Res_id"));
				//System.out.println("comentnumber�̒l:"+rb.getRes_id());
				rb.setR_Thread_id(rs.getInt("R_Thread_id"));
//				rb.setThreadname(rs.getString("threadname"));	board_res�\�ɂ�ThreadName�͖��� index��ς��悤�B
				
				resList.add(rb);
			}
			st.close();
		}catch(SQLException e){
			System.out.println("resSelect�̗�O�ł��B");
			e.printStackTrace();
		}
		System.out.println("resSelect���\�b�h�I��");
		return resList;
	}
	
	
	public static ArrayList<Thrbeans> EditList(String ThreadName){
		System.out.println("EditList���\�b�h�J�n");
		ArrayList<Thrbeans> edit=new ArrayList<Thrbeans>();
		try{
			//
			String sql="select ThreadName,T_Thread_id,ResCount,CreatedDate from board_thread where T_UserName=? and VISUAL = 'true' order by T_Thread_id desc";
			getConnection();
			
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1,ThreadName);
			System.out.println("EditList��st�����܂������Ă���B436�s��");
			ResultSet rs=st.executeQuery();
			System.out.println("EditList��executeQuery�����܂������Ă���B438�s��");
			int count=0;
			while(rs.next()){
				Thrbeans tb=new Thrbeans();
				tb.setThreadName(rs.getString("ThreadName"));
				System.out.println("EditList����ThreadName�̒l:"+rs.getString("ThreadName"));
				tb.setT_Thread_id(rs.getInt("T_Thread_id"));
				tb.setResCount(rs.getInt("ResCount"));
				tb.setCreatedDate(rs.getString("CreatedDate"));
				edit.add(tb);
				count++;
				
			}
			System.out.println("EditList�ł�"+count+"��J��Ԃ��Ă���B448�s��");
			st.close();
		}catch(SQLException e){
			System.out.println("EditList�̗�O�ł��B");
			e.printStackTrace();
		}	
		System.out.println("EditList���\�b�h�I��");
	
		return edit;
	}
	public static void VisualThread(String T_Thread_id){
		System.out.println("VisualThread���\�b�h�J�n");
		try{
			String sql = "update board_thread set Visual = 'false' where T_Thread_id =?";
			getConnection();
	
			PreparedStatement st=conn.prepareStatement(sql);
			System.out.println("VisualThread��st�����܂������Ă���B465�s��");
			st.setString(1,T_Thread_id);
	
			int num=st.executeUpdate();
			System.out.println("VisualThread��executeUpdate�����܂������Ă���B469�s��");
			System.out.println("VisualThread�Ō��ʂ��Ԃ��Ă����B440�s��");
				
			if(num==1){
				System.out.println("VisualThread fales�ɂ����Bupdate�����B473�s��");
			}
			else{
				System.out.println("VisualThread true�̂܂܁Bupdate���Ȃ��B476�s��");
			}
			conn.commit();
			st.close();
		}catch(SQLException e){
			System.out.println("VisualThread�̗�O�ł��B");
			e.printStackTrace();

		}
		
		System.out.println("VisualThread���\�b�h�I��");
	}
	
	
	//�X���b�hid�������������郁�\�b�h
	public static String searchId(String name){
		String number=null;
		System.out.println("searchId���\�b�h�J�n");
		try{
			getConnection();
			String sql="select max(T_Thread_id) from board_thread where T_UserName=? ";
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1,name);
			ResultSet rs=st.executeQuery();	
			rs.next();
			number=rs.getString(1);
			if(number!=null||number.length()!=0){
				System.out.println("�X���b�hid�������ł��܂����Bp501");
			}
			else{
				System.out.println("�X���b�h�̌����Ɏ��s���܂����Bp504");
			}
		}catch(SQLException e){
			System.out.println("searchId�̗�O�ł��B");
			e.printStackTrace();
		}
		System.out.println("searchId���\�b�h�I��");
		return number;
		
	}
	//�e�X�g�ł��܂������Ȃ�������C���X�^���X���\�b�h�ɂ���B
	public static String rescountSearch(String id){
		System.out.println("insertid�J�n");
		String number=null;
		
		try{
			getConnection();
			String sql="select max(ResCount) from board_thread where T_Thread_id=?";
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1,id);
			ResultSet rs=st.executeQuery();	
			rs.next();
			number=rs.getString(1);
			if(number!=null||number.length()!=0){
				System.out.println("board_thread����ResCount�������ł��܂����Bp530");
			}
			else{
				System.out.println("board_thread����ResCount�������ł��܂���ł����Bp533");
			}
			
		}catch(SQLException e){
			System.out.println("insertid�̗�O�ł��B");
			e.printStackTrace();
		}
		return number;
		
	}
	
	//boardthread�̍X�V���Ԃ��X�V���鏈��
	//resinsert�Ɏg����B
	public static void updateLasttime(int threadid,String restime){
		System.out.println("updateLasttime���J�n����B563�s��");
		System.out.println("�X�V����ׂ����ԁF"+restime);
		String sql="update board_thread set LastUpdate ="+"'"+restime+"'"+"where T_Thread_id ="+threadid;
		String day=null;
		try{
			
			PreparedStatement st=conn.prepareStatement(sql);
			System.out.println("st�����܂������Ă���B"+"574�s��");
			int num=st.executeUpdate();
			System.out.println("executeUpdate�����܂������Ă���B"+"576�s��");
			
			if(num==1){
				System.out.println("�ŏI�X�V���Ԃ��X�V�ł��܂����B578�s��");
			}else{
				System.out.println("�ŏI�X�V���Ԃ��X�V�ł��܂���ł����B580�s��");
			}
			conn.commit();
			
		}catch(SQLException e){
			System.out.println("updateLasttime�̗�O�B585�s��");
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	public static String searchSent(int id){
		String threadsent=null;
		System.out.println("searchSent���\�b�h�J�n");
		try{
			getConnection();
			String sql="select ThreadSentence from board_thread where T_Thread_id="+id;
			PreparedStatement st=conn.prepareStatement(sql);
			ResultSet rs=st.executeQuery();	
			rs.next();
			threadsent=rs.getString(1);
			if(threadsent!=null||threadsent.length()!=0){
				System.out.println("threadsentence�������ł��܂����Bp610");
			}
			else{
				System.out.println("threadsentence�����Ɏ��s���܂����Bp613");
			}
		}catch(SQLException e){
			System.out.println("searchSent�̗�O�ł��B");
			e.printStackTrace();
		}
		System.out.println("searchSent���\�b�h�I��");
		return threadsent;
		
	}
	
	public static String searchDay(int id){
		String day=null;
		System.out.println("searDay���\�b�h�J�n");
		try{
			getConnection();
			String sql="select CreatedDate from board_thread where T_Thread_id="+id;
			PreparedStatement st=conn.prepareStatement(sql);
			ResultSet rs=st.executeQuery();	
			rs.next();
			day=rs.getString(1);
			if(day!=null||day.length()!=0){
				System.out.println("day�������ł��܂����Bp501");
			}
			else{
				System.out.println("day�̌����Ɏ��s���܂����Bp504");
			}
		}catch(SQLException e){
			System.out.println("searchDay�̗�O�ł��B");
			e.printStackTrace();
		}
		System.out.println("searchDay���\�b�h�I��");
		return day;
		
	}
	
	public static String searchThreadname(int id){
		String threadname=null;
		System.out.println("searchThreadname���\�b�h�J�n");
		try{
			getConnection();
			String sql="select ThreadName from board_thread where T_Thread_id="+id;
			PreparedStatement st=conn.prepareStatement(sql);
			ResultSet rs=st.executeQuery();	
			rs.next();
			threadname=rs.getString(1);
			if(threadname!=null||threadname.length()!=0){
				System.out.println("threadname�������ł��܂����Bp660");
			}
			else{
				System.out.println("�X���b�h�̌����Ɏ��s���܂����Bp663");
			}
		}catch(SQLException e){
			System.out.println("searchThreadname�̗�O�ł��B");
			e.printStackTrace();
		}
		System.out.println("searchThreadname���\�b�h�I��");
		return threadname;
		
	}
	
	public static String searchThrUser(int id){
		String thruser=null;
		System.out.println("searchThrUser���\�b�h�J�n");
		try{
			getConnection();
			String sql="select T_UserName from board_thread where T_Thread_id="+id;
			PreparedStatement st=conn.prepareStatement(sql);
			ResultSet rs=st.executeQuery();	
			rs.next();
			thruser=rs.getString(1);
			if(thruser!=null||thruser.length()!=0){
				System.out.println("thruser�������ł��܂����Bp685");
			}
			else{
				System.out.println("thruser�̌����Ɏ��s���܂����Bp688");
			}
		}catch(SQLException e){
			System.out.println("searchThrUser�̗�O�ł��B");
			e.printStackTrace();
		}
		System.out.println("searchThrUser���\�b�h�I��");
		return thruser;
		
	}
	
	
	public static String searchRescount(int id){
		String rescount=null;
		System.out.println("searchResnumber���\�b�h�J�n");
		try{
			getConnection();
			String sql="select ResCount from board_thread where T_Thread_id="+id;
			PreparedStatement st=conn.prepareStatement(sql);
			ResultSet rs=st.executeQuery();	
			rs.next();
			rescount=rs.getString(1);
			if(rescount!=null||rescount.length()!=0){
				System.out.println("rescount�������ł��܂����Bp685");
			}
			else{
				System.out.println("rescount�̌����Ɏ��s���܂����Bp688");
			}
		}catch(SQLException e){
			System.out.println("searchRescount�̗�O�ł��B");
			e.printStackTrace();
		}
		System.out.println("searchRescount���\�b�h�I��");
		return rescount;
		
	}
	
	//�l�C����select	
	public static ArrayList<Thrbeans> popularSQL(){
		System.out.println("popularSQL���\�b�h�J�n");
		ArrayList<Thrbeans> popList=new ArrayList<Thrbeans>();
		try{
			String sql="select * from board_Thread where VISUAL = 'true' order by RESCOUNT desc ";
			getConnection();
			
			PreparedStatement st=conn.prepareStatement(sql);
			System.out.println("popularSQL��st�����܂��������B566�s��");
			ResultSet rs=st.executeQuery();
			System.out.println("popularSQL��rs�Ɍ��ʂ��������Bp568�s��");
			while(rs.next()){
				Thrbeans tb=new Thrbeans();
				tb.setT_Thread_id(rs.getInt("T_Thread_id"));
				tb.setThreadName(rs.getString("ThreadName"));
				tb.setThreadSentence(rs.getString("ThreadSentence"));
				tb.setResCount(rs.getInt("ResCount"));
				tb.setCreatedDate(rs.getString("CreatedDate"));
				tb.setLastUpdate(rs.getString("LastUpdate"));
				tb.setT_UserName(rs.getString("T_UserName"));
				tb.setVisual(rs.getString("Visual"));
				popList.add(tb);
				
			}
			System.out.println("popularSQL��popList��Ԃ��B582�s��");
			
			int size = popList.size();
			System.out.println("popList��size : "+size);
				
			st.close();
		}catch(SQLException e){
			System.out.println("popularSQL�̗�O�ł��B");
			e.printStackTrace();
		}
		System.out.println("popularSQL���\�b�h�I��");
		return popList;
	}
	
	
	
	public static ArrayList<Thrbeans> Search(String word){
		ArrayList<Thrbeans> thrList=new ArrayList<Thrbeans>();
		try{
			getConnection();
			String sql="SELECT * FROM board_thread WHERE ThreadName LIKE '%"+word+"%'";
			PreparedStatement st=conn.prepareStatement(sql);
			//st.setString(1,word);
			ResultSet rs=st.executeQuery();
			System.out.println("while���܂ł͐������Ă���B");
			while(rs.next()){
				Thrbeans th=new Thrbeans();				
				th.setT_Thread_id(rs.getInt("T_Thread_id"));
				th.setThreadName(rs.getString("ThreadName"));
				th.setThreadSentence(rs.getString("ThreadSentence"));
				th.setResCount(rs.getInt("ResCount"));
				th.setCreatedDate(rs.getString("CreatedDate"));
				th.setLastUpdate(rs.getString("LastUpdate"));
				th.setT_UserName(rs.getString("T_UserName"));
				th.setVisual(rs.getString("Visual"));

				
				thrList.add(th);
			}
			st.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return thrList;
	}
	
	

}
