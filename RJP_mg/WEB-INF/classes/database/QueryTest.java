package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import magcap.Threadpage;
import magcap.ResClreate;
import java.util.List;
import java.util.ArrayList;

public class QueryTest{
	
	public static void main(String[] args){
		List<Threadpage> al=getThreadList();
		
		System.out.println();
		
		for(int i = 0; i < al.size();i++){
			Threadpage prof = al.get(i);
			System.out.println(prof.getThread_Name());
		
		}
	}
	
	public static List<Threadpage> getThreadList(){
		
		List<Threadpage> threadList = new ArrayList<Threadpage>();
		
	
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracle�ɐڑ�����
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tuser","pass");
			System.out.println("�ڑ�����");
			
			//select��
			String sql=
			"select thread_name,thread_create_time,MAX(thread_update_time) from thread_table GROUP BY thread_name,thread_create_time";

			//Statement�C���^�[�t�F�C�X����������N���X���C���X�^���X������
			Statement st=cn.createStatement();

			//select�������s��
			//ResultSet�C���^�[�t�F�C�X�����������N���X��
			//�C���X�^���X���Ԃ�
			ResultSet rs=st.executeQuery(sql);

			//�J�[�\������s�����X�N���[�����A�f�[�^���t�F�b�`����
			while(rs.next()){
				Threadpage threadpage = new Threadpage();
				
				String Thread_Name = rs.getString(1);	//1��ڂ̃f�[�^���擾
				String Thread_Create_Time = rs.getString(2);	//2��ڂ̃f�[�^���擾
				String Thread_Update_Time = rs.getString(3);	//3��ڂ̃f�[�^���擾
				
				threadpage.setThread_Name(Thread_Name);
				threadpage.setThread_Create_Time(Thread_Create_Time);
				threadpage.setThread_Update_Time(Thread_Update_Time);
				
				threadList.add(threadpage);
				
				//System.out.println("thread_name"+"\t"+"res_id"+"\t"+"create_time"+"\t"+"update_time"); //�m�F�\��
				System.out.println(Thread_Name+"\t"+Thread_Create_Time+"\t"+Thread_Update_Time);				//�m�F���̂Q
			}

			
			//Oracle����ؒf����
			cn.close();

			System.out.println("�ؒf����");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("�N���X���Ȃ��݂����B");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL�֘A�̗�O�݂����B");
		}catch(Exception e){
			e.printStackTrace();
		}
		return threadList;
		
	}
	
	public static List<ResClreate> getResList(String id){
		
		List<ResClreate> resList = new ArrayList<ResClreate>();
		System.out.println(id);
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracle�ɐڑ�����
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tuser","pass");
			System.out.println("�ڑ�����");
			
			//select��
			String sql="select res_number,res_time,res_con,thread_name from res_table where thread_name='"+id+"'";

			//Statement�C���^�[�t�F�C�X����������N���X���C���X�^���X������
			Statement st=cn.createStatement();

			//select�������s��
			//ResultSet�C���^�[�t�F�C�X�����������N���X��
			//�C���X�^���X���Ԃ�
			ResultSet rs=st.executeQuery(sql);

			//�J�[�\������s�����X�N���[�����A�f�[�^���t�F�b�`����
			while(rs.next()){
				ResClreate res = new ResClreate();
				
				int number = rs.getInt(1);	//1��ڂ̃f�[�^���擾
				String time = rs.getString(2);	//2��ڂ̃f�[�^���擾
				String con = rs.getString(3);	//3��ڂ̃f�[�^���擾
				String name = rs.getString(4);	//3��ڂ̃f�[�^���擾
				res.setRes_Number(number);
				res.setRes_Time(time);
				res.setRes_Con(con);
				res.setThread_Name(name);
				
				resList.add(res);
				
				//System.out.println("username"+"\t"+"password"); //�m�F�\��
				System.out.println(number+"\t"+time+"\t"+con+"\t"+name);				//�m�F���̂Q
			}

			
			//Oracle����ؒf����
			cn.close();

			System.out.println("�ؒf����");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("�N���X���Ȃ��݂����B");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL�֘A�̗�O�݂����B");
		}catch(Exception e){
			e.printStackTrace();
		}
		return resList;
		
	}
	
}