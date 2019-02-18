//スレッドを立てるために必要な情報を格納する入れ物的な役割
package get;
import java.util.Date;
import java.util.ArrayList;
public class Thread{
	private int thread_number;
	private int res_id;
	private String thread_name="";
	//dateはstringでとることにする。
	//private Date CreatedDate=null;
	//private Date LastUpdate=null;
	private String thread_create_time=null;
	private String thread_update_time=null;
	private String user_name="";
	
	public void thread_numberSet(int id){
		thread_number=id;
	}
	
	public void res_idSet(int res){
		res_id=res;
	}
	
	public void thread_nameSet(String title){
		thread_name=title;
	}
	
	public void thread_create_timeSet(String time){
		thread_create_time=time;
	}
	
	public voidthread_update_timeSet(String time){
		thread_update_time=time;
	}
	public void user_nameSet(String name){
		user_name=name;
	}
	
	public int thread_numberGet(){
		return thread_number;
	}
	
	public int res_idGet(){
		return res_id;
	}
	
	public String thread_nameGet(){
		return thread_name;
	}
	
	public String thread_create_timeGet(){
		return thread_create_time;
	}
	
	public String thread_update_timeGet(){
		return thread_update_time;
	}
	public Stringuser_nameGet(){
		return user_name;
	}
	
}