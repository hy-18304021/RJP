package database;

import database.QueryTest;
import get.user;
import java.util.ArrayList;

public class Login{
	
	QueryTest oracle=new QueryTest();
	
	public void Login_id(user id){
		
		
		String user=id.idGet();
		String pass=id.passGet();
		
		if(user==null||user.length()==0){
			id.setHantei(false);
			id.addError("usernameが入っていません。");
		}else if(pass==null||pass.length()==0){
			id.setHantei(false);
			id.addError("passwordが入っていません。");
		}else{
			id.setHantei(true);
		}
	}
	
	public boolean login(user user){
		boolean loginkakunin=oracle.userSelect(user);
		return loginkakunin;
	}
}