//�����ŃX���b�h�𗧂Ă�Ƃ��⃌�X�𓊍e����Ƃ��ɏ��͓��͂���Ă��邩�̊m�F�B
package arugo;
import beans.Thrbeans;
import beans.Resbeans;
import arugo.OracleDBA;
import java.util.ArrayList;

public class Buildlogic{
	OracleDBA oracle=new OracleDBA();
	
	public void resbuildNull(Resbeans res){
		
	}
	public void thrbuildNull(Thrbeans thr){
		String title=thr.getThreadName();
		if(title==null||title.length()==0){
			thr.setHantei(false);
			thr.addError("�薼���󗓂ł��B");
		}
		else{
			thr.setHantei(true);
		}
	}
	
	public ArrayList<Thrbeans> thrbuild(Thrbeans thr){
		//�����ŗ��Ă��X���b�h�̏����f�[�^�x�[�X�ɓo�^�B���̌��select��
		//�ŏI�ҏW���̎��Ԃŕ��בւ��Ă����Ɋi�[�B���̌ケ���\������B
		ArrayList<Thrbeans> thrList=oracle.thrInsert(thr);
		return thrList;
	}
	
	//�X���b�h�l�[���̌���
	public String thrnamesearch(int threadid){
		String name=oracle.thrsearch(threadid);
	
		return name;
	}
	
	//���ׂẴ��X����X���b�hid�̂���������o���B
	public ArrayList<Resbeans> ressearch(int threadid){
		ArrayList<Resbeans> resList=oracle.ressearch(threadid);
		return resList;
	}
	
	public void resInsert(Resbeans res,String id){
		oracle.resInsert(res,id);
	}
	
	public ArrayList<Resbeans> resSelect(int threadid){
		ArrayList<Resbeans> resList=oracle.resSelect(threadid);
		return resList;
	}
	
	public void createseq(){
		oracle.crethrseq();
	}
	public void createseq(Resbeans res){
		oracle.creresseq(res);
	}
	
	
	
	
	
}