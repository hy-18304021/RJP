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
	
	public static void main(String[] args){
		List<Threadpage> al=getThreadList();
		
		System.out.println();
		
		for(int i = 0; i < al.size();i++){
			Threadpage prof = al.get(i);
			System.out.println(prof.thread_nameGet()+"\t"+prof.thread_nameGet());
		
		}
	}
	
	public static List<Threadpage> getThreadList(){
		
		List<Threadpage> threadList = new ArrayList<>();
	
	
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","tuser","pass");
			System.out.println("接続完了");
			
			//select文
			String sql="select thread_name,res_id,thread_create_time,thread_update_time from thread_table";

			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			ResultSet rs=st.executeQuery(sql);

			//カーソルを一行だけスクロールし、データをフェッチする
			while(rs.next()){
				Threadpage threadpage = new Threadpage();
				
				String thread_name = rs.getString(1);	//1列目のデータを取得
				String res_id = rs.getString(2);	//2列目のデータを取得
				String thread_create_time = rs.getString(3);	//3列目のデータを取得
				String thread_update_time = rs.getString(4);	//4列目のデータを取得
				
				threadpage.thread_nameSet(thread_name);
				threadpage.res_idSet(res_id);
				threadpage.thread_create_timeSet(thread_create_time);
				threadpage.thread_update_timeSet(thread_update_time);
				
				threadList.add(threadpage);
				
				//System.out.println("thread_name"+"\t"+"res_id"+"\t"+"create_time"+"\t"+"update_time"); //確認表示
				System.out.println(thread_name+"\t"+res_id+"\t"+thread_create_time+"\t"+thread_update_time);				//確認その２
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
			String sql="select res_number,res_cont_time ,res_con from res_table";

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
				String time = rs.getString(2);	//1列目のデータを取得
				String name = rs.getString(3);	//1列目のデータを取得
				res.res_numberSet(number);
				res.res_cont_timeSet(name);
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