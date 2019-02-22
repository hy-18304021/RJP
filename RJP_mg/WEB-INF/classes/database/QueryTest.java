package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import get.Threadpage;
import get.ResClreate;
import java.util.List;
import java.util.ArrayList;

public class QueryTest{
	
	public static List<Threadpage> getThreadList(){
		
		List<Threadpage> threadList = new ArrayList<>();
	
	
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracle�ɐڑ�����
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tuser","pass");
			System.out.println("�ڑ�����");
			
			//select��
			String sql="select thread_name,count(res_id),thread_create_time,thread_update_time from thread_table GROUP BY thread_name,thread_create_time,thread_update_time";

			//Statement�C���^�[�t�F�C�X����������N���X���C���X�^���X������
			Statement st=cn.createStatement();

			//select�������s��
			//ResultSet�C���^�[�t�F�C�X�����������N���X��
			//�C���X�^���X���Ԃ�
			ResultSet rs=st.executeQuery(sql);

			//�J�[�\������s�����X�N���[�����A�f�[�^���t�F�b�`����
			while(rs.next()){
				Threadpage threadpage = new Threadpage();
				
				String name = rs.getString(1);	//1��ڂ̃f�[�^���擾
				int res_count = rs.getInt(2);	//2��ڂ̃f�[�^���擾
				String create_time = rs.getString(3);	//3��ڂ̃f�[�^���擾
				String update_time = rs.getString(4);	//4��ڂ̃f�[�^���擾
				threadpage.thread_nameSet(name);
				threadpage.res_idSet(res_count);
				threadpage.thread_create_timeSet(create_time);
				threadpage.thread_update_timeSet(update_time);
				
				threadList.add(threadpage);
				
				//System.out.println("username"+"\t"+"password"); //�m�F�\��
				//System.out.println(name+"\t"+pass);				//�m�F���̂Q
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
	
	public static List<ResClreate> getResList(){
		
		List<ResClreate> resList = new ArrayList<ResClreate>();
	
	
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracle�ɐڑ�����
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tuser","pass");
			System.out.println("�ڑ�����");
			
			//select��
			String sql="select res_number,res_cont_time ,res_con from res_table";

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
				String time = rs.getString(2);	//1��ڂ̃f�[�^���擾
				String name = rs.getString(3);	//1��ڂ̃f�[�^���擾
				res.res_numberSet(number);
				res.res_cont_timeSet(name);
				res.res_conSet(name);
				
				resList.add(res);
				
				//System.out.println("username"+"\t"+"password"); //�m�F�\��
				//System.out.println(name+"\t"+pass);				//�m�F���̂Q
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