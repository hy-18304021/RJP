//���X�𓊍e����Ƃ��ɕK�v�ȏ����i�[������ꕨ�I�Ȗ���
package beans;
import java.util.Date;
public class Resbeans{
	//private String username="";
	//private String coment="";
	//private Date comenttime=new Date();
	//private int comentnumber;
	//private String threadname=""; //�ǂ̃X���b�h�̃R�����g�Ȃ̂��̔��ʂ��邽�߂̕ϐ�
	//private int like; �������˂Ƃ�����̂ł���ΕK�v
	//private int thread_id;
	private int r_Thread_id;
	private int res_id;
	private String r_UserName;
	private String res;
	//date��String�ɂ���
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