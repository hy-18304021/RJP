//スレッドを立てるために必要な情報を格納する入れ物的な役割
package magcap;

public class Threadpage{
	private String thread_Number;
	private String res_Id="";
	private String thread_Name="";
	private String thread_Create_Time="";
	private String thread_Update_Time="";
	
	public void setThread_Number(String thread_Number){
		this.thread_Number=thread_Number;
	}
	
	public void setRes_Id(String res_Id){
		this.res_Id=res_Id;
	}
	
	public void setThread_Name(String thread_Name){
		this.thread_Name=thread_Name;
	}
	
	public void setThread_Create_Time(String thread_Create_Time){
		this.thread_Create_Time=thread_Create_Time;
	}
	
	public void setThread_Update_Time(String thread_Update_Time){
		this.thread_Update_Time=thread_Update_Time;
	}
	
	public String getThread_Number(){
		return thread_Number;
	}
	
	public String getRes_Id(){
		return res_Id;
	}
	
	public String getThread_Name(){
		return thread_Name;
	}
	
	public String getThread_Create_Time(){
		return thread_Create_Time;
	}
	
	public String getThread_Update_Time(){
		return thread_Update_Time;
	}
}