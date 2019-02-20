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

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tuser","pass");
			System.out.println("接続完了");
			
			//select文
			String sql="select thread_name,count(res_id),thread_create_time,thread_update_time from thread_table GROUP BY thread_name,thread_create_time,thread_update_time";

			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			ResultSet rs=st.executeQuery(sql);

			//カーソルを一行だけスクロールし、データをフェッチする
			while(rs.next()){
				Thread thread = new Thread();
				
				String name = rs.getString(1);	//1列目のデータを取得
				int res_count = rs.getInt(2);	//2列目のデータを取得
				String create_time = rs.getString(3);	//3列目のデータを取得
				String update_time = rs.getString(4);	//4列目のデータを取得
				thread.thread_nameSet(name);
				thread.res_idSet(res_count);
				thread.thread_create_timeSet(create_time);
				thread.thread_update_timeSet(update_time);
				
				threadList.add(thread);
				
				//System.out.println("username"+"\t"+"password"); //確認表示
				//System.out.println(name+"\t"+pass);				//確認その２
			}

			
			//Oracleから切断する
			cn.close();

			System.out.println("切断完了");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("クラスがないみたい。");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL関連の例外みたい。");
		}catch(Exception e){
			e.printStackTrace();
		}
		return threadList;
		
	}
	
	public static List<ResClreate> getResList(){
		
		List<ResClreate> resList = new ArrayList<ResClreate>();
	
	
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tuser","pass");
			System.out.println("接続完了");
			
			//select文
			String sql="select res_con from res_table";

			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			ResultSet rs=st.executeQuery(sql);

			//カーソルを一行だけスクロールし、データをフェッチする
			while(rs.next()){
				ResClreate res = new ResClreate();
				
				String name = rs.getString(1);	//1列目のデータを取得
				res.res_conSet(name);
				
				resList.add(res);
				
				//System.out.println("username"+"\t"+"password"); //確認表示
				//System.out.println(name+"\t"+pass);				//確認その２
			}

			
			//Oracleから切断する
			cn.close();

			System.out.println("切断完了");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("クラスがないみたい。");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL関連の例外みたい。");
		}catch(Exception e){
			e.printStackTrace();
		}
		return resList;
		
	}
	
}