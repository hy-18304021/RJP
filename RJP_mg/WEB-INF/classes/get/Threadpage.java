//スレッドを立てるために必要な情報を格納する入れ物的な役割
package get;

public class Threadpage{
	private int threadnumber;
	private String resid="";
	private String threadname="";
	private String threadcreatetime="";
	private String threadupdatetime="";
	
	public void thread_numberSet(int id){
		threadnumber=id;
	}
	
	public void res_idSet(String res){
		resid=res;
	}
	
	public void thread_nameSet(String title){
		threadname=title;
	}
	
	public void thread_create_timeSet(String time){
		threadcreatetime=time;
	}
	
	public void thread_update_timeSet(String time){
		threadupdatetime=time;
	}
	
	public int thread_numberGet(){
		return threadnumber;
	}
	
	public String res_idGet(){
		return resid;
	}
	
	public String thread_nameGet(){
		return threadname;
	}
	
	public String thread_create_timeGet(){
		return threadcreatetime;
	}
	
	public String thread_update_timeGet(){
		return threadupdatetime;
	}
}