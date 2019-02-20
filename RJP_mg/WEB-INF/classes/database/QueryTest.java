package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import get.Thread;
import get.ResClreate;
import java.util.List;
import java.util.ArrayList;

public class QueryTest{
	
	public static List<Thread> getThreadList(){
		
		List<Thread> threadList = new ArrayList<Thread>();
	
	
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracle�ɐڑ�����
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tuser","pass");
			System.out.println("�ڑ�����");
			
			//select��
			String sql="select thread from thread_table";

			//Statement�C���^�[�t�F�C�X����������N���X���C���X�^���X������
			Statement st=cn.createStatement();

			//select�������s��
			//ResultSet�C���^�[�t�F�C�X�����������N���X��
			//�C���X�^���X���Ԃ�
			ResultSet rs=st.executeQuery(sql);

			//�J�[�\������s�����X�N���[�����A�f�[�^���t�F�b�`����
			while(rs.next()){
				Thread thread = new Thread();
				
				String name = rs.getString(1);	//1��ڂ̃f�[�^���擾
				thread.thread_nameSet(name);
				
				threadList.add(thread);
				
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
			String sql="select res_con from res_table";

			//Statement�C���^�[�t�F�C�X����������N���X���C���X�^���X������
			Statement st=cn.createStatement();

			//select�������s��
			//ResultSet�C���^�[�t�F�C�X�����������N���X��
			//�C���X�^���X���Ԃ�
			ResultSet rs=st.executeQuery(sql);

			//�J�[�\������s�����X�N���[�����A�f�[�^���t�F�b�`����
			while(rs.next()){
				ResClreate res = new ResClreate();
				
				String name = rs.getString(1);	//1��ڂ̃f�[�^���擾
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