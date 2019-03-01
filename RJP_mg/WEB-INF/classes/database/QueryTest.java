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

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tuser","pass");
			System.out.println("接続完了");
			
			//select文
			String sql=
			"select thread_name,thread_create_time,MAX(thread_update_time) from thread_table GROUP BY thread_name,thread_create_time";

			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			ResultSet rs=st.executeQuery(sql);

			//カーソルを一行だけスクロールし、データをフェッチする
			while(rs.next()){
				Threadpage threadpage = new Threadpage();
				
				String Thread_Name = rs.getString(1);	//1列目のデータを取得
				String Thread_Create_Time = rs.getString(2);	//2列目のデータを取得
				String Thread_Update_Time = rs.getString(3);	//3列目のデータを取得
				
				threadpage.setThread_Name(Thread_Name);
				threadpage.setThread_Create_Time(Thread_Create_Time);
				threadpage.setThread_Update_Time(Thread_Update_Time);
				
				threadList.add(threadpage);
				
				//System.out.println("thread_name"+"\t"+"res_id"+"\t"+"create_time"+"\t"+"update_time"); //確認表示
				System.out.println(Thread_Name+"\t"+Thread_Create_Time+"\t"+Thread_Update_Time);				//確認その２
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
	
	public static List<ResClreate> getResList(String id){
		
		List<ResClreate> resList = new ArrayList<ResClreate>();
		System.out.println(id);
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tuser","pass");
			System.out.println("接続完了");
			
			//select文
			String sql="select res_number,res_time,res_con,thread_name from res_table where thread_name='"+id+"'";

			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			ResultSet rs=st.executeQuery(sql);

			//カーソルを一行だけスクロールし、データをフェッチする
			while(rs.next()){
				ResClreate res = new ResClreate();
				
				int number = rs.getInt(1);	//1列目のデータを取得
				String time = rs.getString(2);	//2列目のデータを取得
				String con = rs.getString(3);	//3列目のデータを取得
				String name = rs.getString(4);	//3列目のデータを取得
				res.setRes_Number(number);
				res.setRes_Time(time);
				res.setRes_Con(con);
				res.setThread_Name(name);
				
				resList.add(res);
				
				//System.out.println("username"+"\t"+"password"); //確認表示
				System.out.println(number+"\t"+time+"\t"+con+"\t"+name);				//確認その２
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