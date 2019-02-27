//ƒŒƒX‚ğ“Še‚·‚é‚Æ‚«‚É•K—v‚Èî•ñ‚ğŠi”[‚·‚é“ü‚ê•¨“I‚È–ğŠ„
package get;
import java.util.Date;
public class ResClreate{
	private int res_number;
	private int res_id;
	private String thread_name="";
	private String res_con="";
	//date‚ÍString‚É‚·‚é
	//private Date ResTime;
	private String res_cont_time=null;
	
	public void res_numberSet(int number){
		res_number=number;
	}
	
	public int res_numberGet(){
		return res_number;
	}
	
	public void res_idSet(int id){
		res_id=id;
	}
	
	public int res_idGet(){
		return res_id;
	}
	
	public void thread_nameSet(String name){
		thread_name=name;
	}
	
	public String thread_nameGet(){
		return thread_name;
	}
		
	public void res_conSet(String con){
		res_con=con;
	}
	
	public String res_conGet(){
		return res_con;
	}
	
	
	public void res_cont_timeSet(String time){
		res_cont_time=time;
	}
	
	public String res_cont_timeGet(){
		return res_cont_time;
	}
	
}