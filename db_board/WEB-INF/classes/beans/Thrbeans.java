//�X���b�h�𗧂Ă邽�߂ɕK�v�ȏ����i�[������ꕨ�I�Ȗ���
package beans;
import java.util.Date;
import java.util.ArrayList;
public class Thrbeans{
	private int thread_id;
	//private String title="notitle";
	//private String titleSentence="";
	//private String creator="����������";
	//private int reply_nb; //���̃X���b�h�̃��X��
	//private Date created_date;
	//private Date last_update;
	//private boolean hantei=false;
	//private ArrayList<String> error=new ArrayList<String>();
//	private ArrayList<Resbeans> resList=new ArrayList<Resbeans>();
	
	private boolean hantei=false;
	private ArrayList<String> error=new ArrayList<String>();
	
	private int t_Thread_id;
	private String threadName="";
	private String threadSentence="";
	private int resCount;
	//date��string�łƂ邱�Ƃɂ���B
	//private Date CreatedDate=null;
	//private Date LastUpdate=null;
	private String createdDate=null;
	private String lastUpdate=null;
	private String t_UserName="";
	private String visual="";
	
	public void setT_Thread_id(int id){
		this.t_Thread_id=id;
	}
	
	public void setThreadName(String title){
		this.threadName=title;
	}
	
	public void setThreadSentence(String titlesentence){
		this.threadSentence=titlesentence;
	}
	
	public void setT_UserName(String creator){
		this.t_UserName=creator;
	}
	
	public void setResCount(int reply_nb){
		this.resCount=reply_nb;
	}
	
	public void setCreatedDate(String created_date){
		this.createdDate=created_date;
	}
	
	public void setLastUpdate(String last_update){
		this.lastUpdate=last_update;
	}
	
	public void setVisual(String visual){
		this.visual=visual;
	}
	
	public void setHantei(boolean hantei){
		this.hantei=hantei;
	}
	
	public void setError(ArrayList<String> list){
		this.error=list;
	}
	
	
	
	public int getT_Thread_id(){
		return t_Thread_id;
	}
	
	public String getThreadName(){
		return threadName;
	}
	
	public String getThreadSentence(){
		return threadSentence;
	}
	
	public String getT_UserName(){
		return t_UserName;
	}
	
	public int getResCount(){
		return resCount;
	}
	
	public String getCreatedDate(){
		return createdDate;
	}
	
	public String getLastUpdate(){
		return lastUpdate;
	}
	
	public String getVisual(){
		return visual;
	}
	
	public boolean getHantei(){
		return hantei;
	}
	
	public ArrayList<String> getError(){
		return error;
	}
	
	public void addError(String message){
		error.add(message);
	}
	
}