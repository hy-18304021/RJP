//user�Ɋւ���������邽�߂̓��ꕨ�I�Ȗ����B
//���̃t�@�C����session�ɓ����Ă��邩�ǂ����Ń��O�C�����Ă��邩�ǂ������܂�B
package beans;
import java.io.Serializable;
import java.util.ArrayList;
public class Userbeans implements Serializable{
	//private String username="";
	//private String password="";
	//private String mail_address="";
	private boolean hantei=false;
	private ArrayList<String> error=new ArrayList<String>();
	private String u_UserName="";
	private String passWord="";
	private String mail_Address="";
	
	//
	public void setU_UserName(String u_username){
		this.u_UserName=u_username;
	}
	public String getU_UserName(){
		return u_UserName;
	}
	public void setPassWord(String password){
		this.passWord=password;
	}
	public String getPassWord(){
		return passWord;
	}
	public void setMail_Address(String mail_address){
		this.mail_Address=mail_address;
	}
	public String getMail_Address(){
		return mail_Address;
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