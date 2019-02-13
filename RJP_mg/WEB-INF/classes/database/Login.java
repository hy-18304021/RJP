package database;

import get.user;
import java.util.ArrayList;

public class Login{
	
	public void Login(user id){
		
		String user=id.idGet();
		String pass=id.passGet();
		
		if(user==null||user.length()==0){
			user.setHantei(false);
			user.addError("username‚ª“ü‚Á‚Ä‚¢‚Ü‚¹‚ñB");
		}else if(pass==null||pass.length()==0){
			user.setHantei(false);
			user.addError("password‚ª“ü‚Á‚Ä‚¢‚Ü‚¹‚ñB");
		}else{
			user.setHantei(true);
		}
	}
	
	public boolean login(user user){
		boolean loginkakunin=oracle.userSelect(user);
		return loginkakunin;
	}
}