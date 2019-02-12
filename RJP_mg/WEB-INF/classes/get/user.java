package get;

import java.util.ArrayList;


public class user{
	private boolean hantei=false;
	private ArrayList<String> error=new ArrayList<String>();
	private String id="";
	private String pass="";
	
	public void idSet(String id){
		this.id=id;
	}
	
	public String idGet(){
		return id;
	}
	
	public void passSet(String pass){
		this.pass=pass;
	}
	
	public String passGet(){
		return pass;
	}
	
	public void setHantei(boolean hantei){
		this.hantei=hantei;
	}
	
	public boolean getHantei(){
		return hantei;
	}
	
	public void setError(ArrayList<String> error){
		this.error=error;
	}
	public void addError(String errormessage){
		error.add(errormessage);
	}
	public ArrayList<String> getError(){
		return error;
	}
}