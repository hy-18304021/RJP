//���ׂĂ̍��ڂ���͂���Ă���̂��A�l�͐��������̂ł��邩�̔��f�������ł���B
//���肵��true,false�Œl��Ԃ��Btrue�ł����session�ɒl������Bfalse�ł����
//�s��������_���w�E����B
//���ڂ����͂���Ă��邩+�f�[�^�x�[�X�ɂ��邩�ǂ����𔻒肵�Ȃ��Ƃ����Ȃ�
//�������璼��OrackeDBA���g����悤�ɂ������B
package arugo;
import beans.Userbeans;
import arugo.OracleDBA;
import java.util.ArrayList;
public class Login{
	
	//���̃��\�b�h��userbeans�Ɏ������Ă��郍�O�C���̔����ς���+
	//�G���[���b�Z�[�W�������Ă���B�{���͂����œ��͕s�������邩�ǂ���
	//�����Əڂ����G���[���b�Z�[�W�����������B
	OracleDBA oracle=new OracleDBA();
	
	//������userbeans��hantei�ϐ���ς���B
	public void loginNull(Userbeans user){
		String username=user.getU_UserName();
		String password=user.getPassWord();
		
		if(username==null||username.length()==0){
			user.setHantei(false);
			user.addError("username�������Ă��܂���B");
		}
		if(password==null||password.length()==0){
			user.setHantei(false);
			user.addError("password�������Ă��܂���B");
		}
		if(username!=null&&password!=null&&username.length()!=0&&password.length()!=0){
			user.setHantei(true);
		}
	}
	
	public boolean login(Userbeans user){
		boolean loginkakunin=oracle.userSelect(user);
		return loginkakunin;
	}
	
	
}