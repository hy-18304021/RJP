package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import get.Profile;
import get.user;

public class QueryTest{
	private static Connection conn=null;
	private PreparedStatement st = null;
	private ResultSet rs=null;
	
	user user=new user();
	
	public static void getConnection(){
		try{
			System.out.println("jdbc�h���C�o�̐ݒu");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","info","pro");
			conn.setAutoCommit(false);
			System.out.println("�ڑ�����");
			//rs.close();
		}
		catch(Exception e){
			System.out.println("getConnection�̗�O�ł��B");
			e.printStackTrace();
		}
		
		
	}
	
	//Login�t�@�C����login���\�b�h���g���Ƃ��Ɏg����B
	public boolean userSelect(user id){
		System.out.println("userSelect���\�b�h�J�n");
		boolean hasClient=false;
		getConnection();
		
		try{
			
			String sql="select * from user_table where user_name = ? and user_password = ?";
		
			st=conn.prepareStatement(sql);
			
			System.out.println("userSelect��st�͂��܂�������p127");
			st.setString(1,user.idGet());
			st.setString(2,user.passGet());
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
