//���X�𓊍e����Ƃ��ɕK�v�ȏ����i�[������ꕨ�I�Ȗ���
package get;
import java.util.Date;
public class Res{
	private int res_number;
	private int res_id;
	private String thread_name="";
	private String res_con="";
	//date��String�ɂ���
	//private Date ResTime;
	private String res_cont_time=null;
	private String user_name="";
	
	public void res_numberSet(int number){
		res_number=number;
	}
	
	public int res_numberGet(){
		return res_number;
	}
	
	public void res_idSet(int id){
		res_di=id;
	}
	
	public int res_idGet(){
		return res_id;
	}
	
	public void thread_nameSet(int name){
		thread_name=name;
	}
	
	public int thread_nameGet(){
		return thread_name;
	}
		
	public void res_conSet(int con){
		res_con=con;
	}
	
	public int res_conGet(){
		return res_con;
	}
	
	
	public void res_cont_timeSet(int time){
		res_cont_time=time;
	}
	
	public int res_cont_timeGet(){
		return res_cont_time;
	}
		
	public void user_nameSet(int name){
		user_name=name;
	}
	
	public int user_nameGet(){
		return user_name;
	}
	
}