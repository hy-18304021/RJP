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
			System.out.println("jdbcドライバの設置");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","info","pro");
			conn.setAutoCommit(false);
			System.out.println("接続完了");
			//rs.close();
		}
		catch(Exception e){
			System.out.println("getConnectionの例外です。");
			e.printStackTrace();
		}
		
		
	}
	
	//Loginファイルでloginメソッドを使うときに使われる。
	public boolean userSelect(user id){
		System.out.println("userSelectメソッド開始");
		boolean hasClient=false;
		getConnection();
		
		try{
			
			String sql="select * from user_table where user_name = ? and user_password = ?";
		
			st=conn.prepareStatement(sql);
			
			System.out.println("userSelectのstはうまくいったp127");
			st.setString(1,user.idGet());
			st.setString(2,user.passGet());
			System.out.println("userSelectのsetStringがうまくいった。p130");
			rs=st.executeQuery();
			System.out.println("userSelectのrsがうまくいったp132");
			
			
			//レコードが選択されていない可能性がある。
			if(rs.next()){
				hasClient = true;
			}
			st.close();
		}catch(SQLException e){
			System.out.println("userSelectの例外です。");
			e.printStackTrace();
			
		
		}
		System.out.println("userSelectメソッド終了");
		return hasClient;
		
	}
