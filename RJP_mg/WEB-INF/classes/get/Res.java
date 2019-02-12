//ƒŒƒX‚ğ“Še‚·‚é‚Æ‚«‚É•K—v‚Èî•ñ‚ğŠi”[‚·‚é“ü‚ê•¨“I‚È–ğŠ„
package get;
import java.util.Date;
public class Res{
	private int r_Thread_id;
	private int res_id;
	private String r_UserName;
	private String res;
	//date‚ÍString‚É‚·‚é
	//private Date ResTime;
	private String resTime=null;
	
	public void setR_UserName(String username){
		this.r_UserName=username;
	}
	public void setRes(String coment){
		this.res=coment;
	}
	public void setResTime(String comenttime){
		this.resTime=comenttime;
	}
	public void setRes_id(int comentnumber){
		this.res_id=comentnumber;
	}
	
	public void setR_Thread_id(int thread_id){
		this.r_Thread_id=thread_id;
	}
	
	public String getR_UserName(){
		return this.r_UserName;
	}
	public String getRes(){
		return this.res;
	}
	public String getResTime(){
		return this.resTime;
	}
	public int getRes_id(){
		return this.res_id;
	}
	
	public int getR_Thread_id(){
		return this.r_Thread_id;
	}
}