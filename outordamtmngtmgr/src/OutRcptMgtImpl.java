/**
 * @(#) OutRcptMgtImpl.java
 *�����̷�
 * 		- 2007. 4. 02 / �����ۼ� / �����
 */
package himed.his.pam.outordamtmngtmgr.outrcptmgt;

import java.util.HashMap;
import java.util.Map;

import kr.co.hit.live.context.ContextAwareService;
import kr.co.hit.live.exception.LiveException;
import kr.co.hit.live.query.SqlQuery;
import kr.co.hit.live.resources.Messages;
import kr.co.hit.live.util.StringHelper;
import kr.co.hit.live.util.DateHelper;
import kr.co.hit.live.util.NumericHelper;
import kr.co.hit.live.vo.ValueObject;
import kr.co.hit.live.vo.ValueObjectAssembler;

import java.text.DecimalFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import himed.his.com.lib.Role;

import himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO;
import himed.his.pam.calcscorlib.calculation.Calculation;
import himed.his.pam.lib.etcoutrgst.EtcOutRgst;
import himed.his.pam.lib.scndsuptrgt.ScndSuptrgt;
import himed.his.pam.lib.patinfomngt.PatInfoMngt;
import himed.his.pam.pamcomnmgr.pamcomnmgt.PamComnMgt;
import himed.his.ast.soclworkmgr.soclworkcharityordmngtmgt.SoclWorkCharityOrdMngtMgt;
import himed.his.ast.pharmacyapplib.pharmacyapplib.PharmacyAppLib;
import himed.his.ast.astautoassignlib.autoassignmgt.AutoAssignMgt;


/**
 *  <P> �ܷ�����  Business Interface�� ���� Class</P>
 *  �� Ŭ������ �ܷ�������  �����ϴ� OutRcptMgt Interface�� ����Ŭ�����̴�. 
 *  
 *  @author  �����
 *  @version 1.0  2007. 4. 02
 */
public class OutRcptMgtImpl extends ContextAwareService implements  OutRcptMgt {

	protected OutRcptDAO  outrcptmngtDAO = null;
	protected Calculation outcalc = null;
	protected EtcOutRgst  etcOutRgst = null;
    protected ScndSuptrgt scndSuptrgt = null;
	protected PatInfoMngt patInfoMngt = null;
	protected PamComnMgt  pamMgt = null;
	protected SoclWorkCharityOrdMngtMgt charityMgt = null;
	protected PharmacyAppLib pharmlib = null;
	protected AutoAssignMgt autoasslib = null;
	

	protected static final Log log = LogFactory.getLog(OutRcptMgtImpl.class);
	
	/**
	 * ����� DAO �������̽��� OutRcptDAO ��ü�� �����ϴ� Setter Method �̴�.
	 * 
	 * @param dao
	 */
	public void setDao(OutRcptDAO dao) {		
		outrcptmngtDAO = dao;
	}
	
	public void setCalculation(Calculation calc) {		
		outcalc = calc;	
	}

	public void setEtcOutRgst(EtcOutRgst etc) {
		
		etcOutRgst = etc;
	}

	public void setScndSuptrgt(ScndSuptrgt etc2) {
		
		scndSuptrgt = etc2;
	}

	public void setPatInfoMngt(PatInfoMngt patInfo) {
		
		patInfoMngt = patInfo;
	}

	public void setPamComnMgt(PamComnMgt mgt) {		
		pamMgt = mgt;
	}

	public void setSoclWorkCharityOrdMngtMgt(SoclWorkCharityOrdMngtMgt charity){
		charityMgt = charity;
	}
	
 	public void setPharmacyAppLib(PharmacyAppLib pharm) {		
 		pharmlib = pharm;		
 	}
	
 	public void setAutoAssignMgt(AutoAssignMgt autoassign) {		
 		autoasslib = autoassign;		
		
 	}
	

	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getMdlAmtList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getMdlAmtList(ValueObject pVO) throws LiveException {
		
		//����ڵ� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//����� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
			pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
		}
		
		return outrcptmngtDAO.getMdlAmtList(pVO);
	}
		
	
	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getCardAmtList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getCardAmtList(ValueObject pVO) throws LiveException {
		
		//����ڵ� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//����� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
			pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
		}
		
		return outrcptmngtDAO.getCardAmtList(pVO);
	}

	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getCashAmtList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getCashAmtList(ValueObject pVO) throws LiveException {
		
		//����ڵ� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//����� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
			pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
		}
		
		return outrcptmngtDAO.getCashAmtList(pVO);
	}
	
	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getOnlineAmtList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOnlineAmtList(ValueObject pVO) throws LiveException {
		
		//����ڵ� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//����� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
			pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
		}
		
		return outrcptmngtDAO.getOnlineAmtList(pVO);
	}

	
	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getRcptNo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getRcptNo(ValueObject pVO) throws LiveException {
		
		//����ڵ� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//����� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
			pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
		}
		
		return outrcptmngtDAO.getRcptNo(pVO);
	}
	
	
	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#insMdlAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insMdlAmt(ValueObject pVO) throws LiveException {
		
		//����ڵ� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//����� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
			pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
		}
		
		//������ ����
		pVO.set("rcptrid",pVO.getString("sessuserid"));
		
		return outrcptmngtDAO.insMdlAmt(pVO);
	}
	
	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#setRcptNo(kr.co.hit.live.vo.ValueObject)
	 */
	public int setRcptNo(ValueObject pVO) throws LiveException {

		//����ڵ� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//����� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
			pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
		}

		if (("1").equals(pVO.getString("rcptno"))) {
			return outrcptmngtDAO.insRcptNo(pVO);
		}
		else {
			return outrcptmngtDAO.setRcptNo(pVO);
		}
	}
	
	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#setOutOrdAmtOscl(kr.co.hit.live.vo.ValueObject)
	 */
	public int setOutOrdAmtOsclOtpt(ValueObject pVO) throws LiveException {

		//����ڵ� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//����� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
			pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
		}
		
		//��ϳ����� ������ �� ����  
		ValueObject tOtpt = new ValueObject ();
		ValueObject tOtptVO = new ValueObject ();		
		ValueObject HoldListVO = new ValueObject();
		
		int iCount = 0;
		
		//��곻���� �������� update
		iCount = outrcptmngtDAO.setOutOrdAmtOscl(pVO);
		
		//������ ��곻�� Y ���� 0���̸� ���� �߻��Ѵ�.
		//
		if( iCount < 1 ){
		//	throw new LiveException("���� �� ��곻�� ���� ���� �Դϴ�. ���� �� �ٽ� �����ϼ���.[OSCL CALCSTAT R->Y ������Ʈ ����]");
		}
		
		tOtpt.set("otpt_pid"      ,pVO.getString("opmi_pid"));
		tOtpt.set("otpt_orddd"    ,pVO.getString("opmi_orddd"));
		tOtpt.set("otpt_cretno"   ,pVO.getString("opmi_cretno"));
		tOtpt.set("otpt_acptseqno",pVO.getString("opmi_acptseqno"));
		tOtpt.set("otpt_instcd"   ,pVO.getString("opmi_instcd"));

		tOtpt.set("sessinstcd"    ,pVO.getString("sessinstcd"));
		tOtpt.set("sessuserid"    ,pVO.getString("sessuserid"));
		tOtpt.set("otpt_histstat" ,pVO.getString("otpt_histstat"));  //R:����  X:���(����ġ��,�ֻ翹���̸鼭 ������̻����̸� �������ó��) 

		if (StringHelper.strEquals(pVO.getString("otpt_histstat"), "X")) {  //����϶��� opmi�������ϹǷ� ������������ȣ ����
			tOtpt.set("otpt_rcptdd"   ,pVO.getString("opmi_rcptdd_org"));
			tOtpt.set("otpt_rcptno"   ,pVO.getString("opmi_rcptno_org"));
			tOtpt.set("otpt_rcptseqno",pVO.getString("opmi_rcptseqno_org"));		
		}else{
			tOtpt.set("otpt_rcptdd"   ,pVO.getString("opmi_rcptdd"));
			tOtpt.set("otpt_rcptno"   ,pVO.getString("opmi_rcptno"));
			tOtpt.set("otpt_rcptseqno",pVO.getString("opmi_rcptseqno"));
		}

		//����ó���� Hold�� ó���� ������  erchospath Į���� hold ó���� ����.		
		tOtptVO.set("pid"           ,pVO.getString("opmi_pid"));
		tOtptVO.set("orddd"        ,pVO.getString("opmi_orddd"));
		tOtptVO.set("cretno"       ,pVO.getString("opmi_cretno"));
		tOtptVO.set("sessinstcd"  ,pVO.getString("sessinstcd"));
		tOtptVO.set("sessuserid"  ,pVO.getString("sessuserid"));
		
		HoldListVO = outrcptmngtDAO.getHoldExop(tOtptVO);
		
		if (HoldListVO.size() == 0) {
			tOtpt.set("otpt_holdflag", "N");	
		} else if (HoldListVO.size() > 0) {
			tOtpt.set("otpt_holdflag", "Y");	
		}		

		tOtpt.set("otpt_calcflag","N");								//Y:�̰��, S:�̼���, N:����

		//�ܷ���ϳ����� �������� update
		return outrcptmngtDAO.setOutOrdAmtOtpt(tOtpt);
		
	}

	
	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#setOrdStat(kr.co.hit.live.vo.ValueObject)
	 */	
	public int setOutOrdStat(ValueObject pVO) throws LiveException {

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
    		
		//ó�������� �� ������ �� ����  
		ValueObject tOprcVO = new ValueObject ();
				
		tOprcVO.set("pid"       ,pVO.getString("opmi_pid"));
		tOprcVO.set("orddd"     ,pVO.getString("opmi_orddd"));
		tOprcVO.set("cretno"    ,pVO.getString("opmi_cretno"));
		tOprcVO.set("acptseqno" ,pVO.getString("opmi_acptseqno"));
		
		tOprcVO.set("rcptno"    ,pVO.getString("opmi_rcptno"));
		tOprcVO.set("rcptseqno" ,pVO.getString("opmi_rcptseqno"));
		tOprcVO.set("rcptdd"    ,pVO.getString("opmi_rcptdd"));
		tOprcVO.set("rcptrid"   ,pVO.getString("opmi_rcptrid"));
		
		tOprcVO.set("sessinstcd",pVO.getString("sessinstcd"));
		tOprcVO.set("sessuserid",pVO.getString("sessuserid"));
		tOprcVO.set("prcpstatcd","230");			//ó����������ڵ�(M0011)-230(�ܷ�����)

		tOprcVO.set("etcordflag" ,pVO.getString("opmi_etcordflag"));
		
		tOprcVO.set("orddd"     ,pVO.getString("opmi_orddd"));

		//ó�� ���̺� 2�� (�ܷ�ó�����̺�,�ǽ�ó�����̺�  MMOHOPRC, MMODEXOP)
		//�ܷ���ϳ����� �������� update 
		return outrcptmngtDAO.setOutOrdStat(tOprcVO);
		
	}

	
	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getOutRgstList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOutRgstList(ValueObject pVO) 	throws LiveException{

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

		return outrcptmngtDAO.getOutRgstList(pVO);
		
	}
	
	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getOutRgstList2(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOutRsgtList2(ValueObject pVO) 	throws LiveException{

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
		return outrcptmngtDAO.getOutRgstList2(pVO);
		
	}
	
	
	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getOtptList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOtptList(ValueObject pVO) 	throws LiveException{

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
		return outrcptmngtDAO.getOtptList(pVO);
		
	}
	
	
	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getUncoAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getUncoAmt(ValueObject pVO) throws LiveException{

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
		//return outrcptmngtDAO.getUncoAmt(pVO);

		pVO.set("ptbs_pid", pVO.getString("pid"));

		return etcOutRgst.getPatUnco(pVO);
		
	}

	
	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getKeepAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getKeepAmt(ValueObject pVO) throws LiveException{

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
		//return outrcptmngtDAO.getKeepAmt(pVO);

		return etcOutRgst.getPatKpam(pVO);
		
	}


	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getInsuInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getInsuInfo(ValueObject pVO) throws LiveException{

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
		return outrcptmngtDAO.getInsuInfo(pVO);
		
	}
	
	/*
	 * (��Javadoc)
	 * �������� ��ȸ
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getSrdgInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getSrdgInfo(ValueObject pVO) throws LiveException{

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
		return outrcptmngtDAO.getSrdgInfo(pVO);

	}
	
	
	/*
	 * (��Javadoc)
	 * �ں��������� ��ȸ
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getAipmInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getAipmInfo(ValueObject pVO) throws LiveException{

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
		return outrcptmngtDAO.getAipmInfo(pVO);
		
	}

	/*
	 * (��Javadoc)
	 * ���纸������ ��ȸ
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getIcpmInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getIcpmInfo(ValueObject pVO) throws LiveException{

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
		return outrcptmngtDAO.getIcpmInfo(pVO);
		
	}
	
	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getOsclInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOsclInfo(ValueObject pVO) throws LiveException{

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        		
		return outrcptmngtDAO.getOsclInfo(pVO);
		
	}

	/*
	 * (��Javadoc)
	 * ����ó�����翩�� ��ȸ
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getOutOrdExist(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOutOrdExist(ValueObject pVO) throws LiveException{

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
		return outrcptmngtDAO.getOutOrdExist(pVO);
		
	}

	/*
	 * (��Javadoc)
	 * �����ȯ�� ���� ��ȸ
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getHandicapYN(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getHandicapYN(ValueObject pVO) throws LiveException{

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
		return outrcptmngtDAO.getHandicapYN(pVO);
		
	}

	/*
	 * (��Javadoc)
	 * ����ó�� �ܷ���� �Ǵ� �Ϲ� �ܷ������ �� ORDDD  ��ȸ - �౹�����
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getOrddd(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOrddd(ValueObject pVO) throws LiveException{

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
		return outrcptmngtDAO.getOrddd(pVO);
		
	}

		
	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getInsuRateInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getInsuRateInfo(ValueObject pVO) throws LiveException{

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
		//��곻���� ���� ��������� ��ȸ		
		return outrcptmngtDAO.getInsuRateInfo(pVO);
	}
	
	
	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getOpmiInfoFromOscl(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOpmiInfoFromOscl(ValueObject pVO) throws LiveException{

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

		//��곻���� ���� ��������� ��ȸ		
		return outrcptmngtDAO.getOpmiInfoFromOscl(pVO);
		
	}

	
	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getOpmiInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOpmiInfo(ValueObjectAssembler pVOs , String caller)  throws LiveException{

		//caller : ȣ�����[��������,���,0������]

		ValueObject otptVO = pVOs.get("otpt");
		ValueObject ptinVO = pVOs.get("ptin");
		ValueObject retopmiVO = new ValueObject();

        String sInstCd = "";
        String sUserId = "";

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(otptVO.getString("sessinstcd"), "")) {
            otptVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(otptVO.getString("sessuserid"), "")) {
            otptVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
            
        }

        sInstCd = otptVO.getString("sessinstcd");
        sUserId = otptVO.getString("sessuserid");		
		
		for (int i=0; i< otptVO.size() ; i++) {		
			//����ڵ� ����		
			otptVO.set(i, "sessinstcd",sInstCd);
			otptVO.set(i, "sessuserid",sUserId);
		}

		ValueObject tempopmiVO  = new ValueObject();
		ValueObject tempopmiVO1 = new ValueObject();
		
		ValueObject insurateVO  = null;
		ValueObject outordVO    = null;
		ValueObject handicapVO  = null;
		
		ValueObject opmiVO      = null;	//output VO
		
		//2007.05.16 hkchoi
		//���ÿ��� ��곻���� ���� ��������� ��ȸ�� �ʿ��ϹǷ�, 
		//������ app => mgr �� �̵�
		
		//�������� view�� ���� ��������� ��ȸ ��, input VO Assembler 
		ValueObjectAssembler inpVOs = new ValueObjectAssembler();

		try {			
			
			//1. �������� ��ȸ-�ܷ������� �ִ� ���������� �ƴ�, �����Էµ� ���������� ����
			insurateVO = getInsuRateInfo(ptinVO);			
			insurateVO.set("insu_insucd",ptinVO.getString("insucd"));
						
			
			//2. ��ü ����� ���� 
			//��곻���� ���� ����� ���� ��ȸ-��곻����ü�� ���� �޿�/��޿�/���������/CT/MRI/
			tempopmiVO = getOpmiInfoFromOscl(otptVO);
			
			//2-1.���ܳ��� ���翩�� üũ
			outordVO = getOutOrdExist(otptVO);
			
			if (outordVO.size() >0) {
				tempopmiVO.set("opmi_outordyn","Y");
			}
			else {
				tempopmiVO.set("opmi_outordyn","N");
			}
			
			tempopmiVO.set("opmi_handicapryn", otptVO.getString("handicaprbookpossnyn"));
			
			//2-3.�������� ����
			tempopmiVO.set("opmi_insukind", ptinVO.getString("insukind"));
			tempopmiVO.set("opmi_suppkind", ptinVO.getString("suppkind"));
			
			//3. �������� view�� ���� ��������� ��ȸ
			//�������� ������ �δ�� ����
			inpVOs.set("tempotpt",otptVO);					//�ܷ��������
			inpVOs.set("insurate",insurateVO);				//���������� �δ�� ����
			inpVOs.set("tempopmi",tempopmiVO);				//��곻���� ���� ���������
			
			opmiVO = getOpmiAmtInfo(inpVOs,caller);
			
			//2011-11-14 �ǽ����� ���, ���� ��� ���			
//			if( StringHelper.strEquals("2", otptVO.getString("calcbaseflag"))){		//�ǽ����� üũ
//				
//			}
			
		} catch (Exception ex) {
			setRollbackOnly();
			if (ex instanceof LiveException) {
				throw (LiveException) ex;
			} else {
				throw new LiveException("com.error.90000", ex);
			}
		}			
		
		return opmiVO;
		
	}
	
	
	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getOpmiAmtInfo(kr.co.hit.live.vo.ValueObject)
	 */
    public ValueObject getOpmiAmtInfo(ValueObjectAssembler pVOs , String caller)  throws LiveException{
		//caller : ȣ�����[��������,���,0������]

        ValueObject potptVO   = pVOs.get("tempotpt");       //�ܷ��������
        ValueObject pinsuVO   = pVOs.get("insurate");       //���������� �δ������  <- ��������! otpt�� �ʿ��� ���� ������ otpt�� ����! ������ 090715
        ValueObject popmiVO   = pVOs.get("tempopmi");       //��곻���� ���� ���������
        ValueObject retopmiVO = new ValueObject();

        String sInstCd = "";
        String sUserId = "";

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(potptVO.getString("sessinstcd"), "")) {
            potptVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(potptVO.getString("sessuserid"), "")) {
            potptVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

        sInstCd = potptVO.getString("sessinstcd");
        sUserId = potptVO.getString("sessuserid");  

        String SRcptdd    = potptVO.getString("rcptdd");    
        String SRcptno    = potptVO.getString("rcptno");      
        String SRcptSeqno = potptVO.getString("rcptseqno"); 
		String P0032_130  = "N";
        long   P0032_280  = 4000000;  //�ܷ� �������ʰ���
        
        //��������
        long lMedTotAmt =0;                 //������                    
        long lMedOwnAmt = 0;                //�����ẻ��                
        long lCtMriPetTotAmt =0;            //�޿� CT/MRI/PET��         
        long lCtMriPetOwnAmt = 0;           //�޿� CT/MRI/PET�� ����    
        long lSonoTotAmt =0;                //SONO��                    
        long lSonoOwnAmt =0;                //SONO�ẻ��                
        long lDrugTotAmt    =0;             //�޿��డ�Ѿ׷�            
        long lDrugOwnAmt =0;                //�޿��డ�Ѿ׷ẻ��        
        long lTotAmt =0;                    //�������                  
        long lPayAmt =0;                    //�޿�                      
        long lNopyAmt =0;                   //��޿�                    
        long lAllOwnBAmt =0;                //���׺��κδ��(�����)      
        long lSpecAmt =0;                   //���������                
        long lPayOwnBAmt =0;                //�޿��� ���κδ�ݾ�       
        long lPayInsuBAmt =0;               //�޿��� �����ںδ�ݾ�      
        long lNopyOwnBAmt =0;               //��޿��� ���κδ��
        long lNopyInsuBAmt =0;              //��޿��� �����ںδ��
        long lAllOwnOwnBAmt =0;             //���׺��� ���κδ��
        long lAllOwnInsuBAmt =0;            //���׺��� �����ںδ��
        long lSpecOwnBAmt =0;               //�������� ���κδ��
        long lSpecInsuBAmt =0;              //�������� �����ںδ��
        
        long lTotNopyOwnBAmt =0;            //��޿�+���׺��� �� ���κδ��
        long lTotNopyInsuBAmt =0;           //��޿�+���׺��� �� �����ںδ��
        //-------------------------------------------------
        long lTotOwnBAmt =0;                //�Ѻ��κδ��             
        long lTotOwnBAmt2 =0;               //�Ѻ��κδ��2 (����ó��) 
        long lHandcapFund =0;               //����α��               
        long lSubtAmt =0;                   //��Ҿ�                   
        long lErSubtAmt =0;                 //���޴�Ҿ�               
        long lProcSubtAmt =0;               //��ȣ��Ҿ�               
        long lBlodDiscAmt =0;               //������ü��               
        long lReduAmt =0;                   //����                     
        long lUncoAmt =0;                   //�̼���                   
        long lPreCashAmt =0;                //�����ݾ�                 
        long lPreMdlRcptAmt =0;             //�⼱����                 
        long lPreCardAmt =0;                //��ī��ݾ�               
        long lPreOnlineAmt =0;              //��¶��αݾ�             
        long lMdlRcptAmt =0;                //������                   
        long lRcptExptAmt =0;               //������ �ݾ�              
        long lRestAmt =0;                   //�����                   
        long lCardAmt =0;                   //ī��ݾ�                 
        long lCashAmt =0;                   //���ݱݾ�                 
        long lOnlineAmt =0;                 //�����Աݾ�               
        long lLabAmt =0;                    //�ӻ󿬱��ݾ�             
        
        long lDiscAmt =0;                   //���αݾ�
        long lPayDiscAmt    =0;             //�޿����αݾ�       
        long lNopyDiscAmt  =0;              //��޿����αݾ�     
        long lSpecDiscAmt  =0;              //�����������αݾ�  
                                                                       
        long lHeallifeamtclamAmt = 0;       //�ǰ���Ȱ������û���� 
        long lPrepregdmndAmt = 0;           //�����������������
        long lPregdmndAmt = 0;              //����������������
        long lSuppamt = 0;                  //��ͳ�ġȯ�������� 
        
        //20090701 1.�ܼ�ó�� �������
        long lPayInsuRestAmt = 0;           //100���̸� ����û���ݾ�
        long lPayInsuRestAmt1 = 0;          //��꺯��
        long lPayInsuRestAmt2 = 0;          //��꺯��
        long lPayOwnBAmt100 =0;             //���� ó���� ���κδ��
        long lPayInsuBAmt100 =0;            //���� ó���� �����ںδ��
        long lTotOwnBAmt100 =0;             //���� ó���� ���κδ��Ѿ�
        
        //20110624 �̿뼺�� �ΰ��� �������(7��)
        long iTaxAmt = 0;										//�ΰ���
        
        boolean bDiscChk = false;
        
        //��������� ��ȸ : ������ ���, ��������� ��ȸ, �Ǻ� ������ ��� ��ȸ����
        ValueObject preOPMIVO = new ValueObject();
        
        //������ ���, ��������� ��ȸ
        preOPMIVO = outrcptmngtDAO.getPreOpmiInfo(potptVO);
        
            if (preOPMIVO.size()>0) {
                lBlodDiscAmt         = Long.parseLong(preOPMIVO.getString("opmi_bloddiscamt"));           //������ü��
                lReduAmt             = Long.parseLong(preOPMIVO.getString("opmi_reduamt"));               //����
                lUncoAmt             = Long.parseLong(preOPMIVO.getString("opmi_uncoamt"));               //�̼���
                lPreCashAmt          = Long.parseLong(preOPMIVO.getString("opmi_precashamt"));            //�����ݾ�(�����ݾ�+���ݼ�����)
                lPreCardAmt          = Long.parseLong(preOPMIVO.getString("opmi_precardamt"));            //��ī��ݾ�(��ī���+ī�������)
                lPreOnlineAmt        = Long.parseLong(preOPMIVO.getString("opmi_preonlineamt"));          //��¶��αݾ�(��¶��αݾ�+�¶��αݾ�)
                lPreMdlRcptAmt       = Long.parseLong(preOPMIVO.getString("opmi_premdlrcptamt"));         //�⼱����(�⼱����+������)
                lHeallifeamtclamAmt  = Long.parseLong(preOPMIVO.getString("opmi_heallifeamtclamamt"));    //�⼱����(�ǰ���Ȱ������û����)
                lPrepregdmndAmt      = Long.parseLong(preOPMIVO.getString("opmi_prepregdmndamt"));        //�⼱����(�����������������)
                //lPregdmndAmt       = Long.parseLong(preOPMIVO.getString("opmi_pregdmndamt"));           //�⼱����(����������������)
            }
		
		//�ǰ���Ȱ������û������ mmsg4���� �����Ѱɷ� �����´�.
		lHeallifeamtclamAmt = outrcptmngtDAO.getPreLifeAmt(potptVO).getInt("heallifeamtclamamt",0);
        
        //��곻�� ���� �޿��Ѿ�,��޿��Ѿ�,���׺��κδ��,���������Ѿ� ���� ������ ����
        if (popmiVO.size()>0) {
            
            lDiscAmt        =  Long.parseLong(popmiVO.getString("opmi_discamt"));   
            lPayDiscAmt     =  Long.parseLong(popmiVO.getString("opmi_paydiscamt"));    
            lNopyDiscAmt    =  Long.parseLong(popmiVO.getString("opmi_nopydiscamt"));   
            lSpecDiscAmt    =  Long.parseLong(popmiVO.getString("opmi_specdiscamt"));   

            lPayAmt         =  Long.parseLong(popmiVO.getString("opmi_payamt"));          //�޿���                
            lPayOwnBAmt     =  Long.parseLong(popmiVO.getString("opmi_payownbamt"));      //�޿����κδ��        
            lPayInsuBAmt    =  Long.parseLong(popmiVO.getString("opmi_payinsubamt"));     //�޿������ںδ��      
                                                                                                                      
            lNopyAmt        =  Long.parseLong(popmiVO.getString("opmi_nopyamt"));         //��޿���              
            lNopyOwnBAmt    =  Long.parseLong(popmiVO.getString("opmi_nopyownbamt"));     //��޿����κδ��      
            lNopyInsuBAmt   =  Long.parseLong(popmiVO.getString("opmi_nopyinsubamt"));    //��޿������ںδ��    
                                                                                                                      
            lAllOwnBAmt     =  Long.parseLong(popmiVO.getString("opmi_allownbamt"));      //���׺��κδ��        
            lAllOwnOwnBAmt  =  Long.parseLong(popmiVO.getString("opmi_allownownbamt"));   //���׺��κ��κδ��    
            lAllOwnInsuBAmt =  Long.parseLong(popmiVO.getString("opmi_allowninsubamt"));  //���׺��κ����ںδ��  
                                                                                                                      
            lSpecAmt        =  Long.parseLong(popmiVO.getString("opmi_specamt"));         //���������            
            lSpecOwnBAmt    =  Long.parseLong(popmiVO.getString("opmi_specownbamt"));     //����������κδ��  
            lSpecInsuBAmt   =  Long.parseLong(popmiVO.getString("opmi_specinsubamt"));    //������������ںδ��
            
            lTotNopyOwnBAmt   =  lNopyOwnBAmt  + lAllOwnOwnBAmt;                          //��޿�+���׺��� �� ���κδ��
            lTotNopyInsuBAmt  =  lNopyInsuBAmt + lAllOwnInsuBAmt;                         //��޿�+���׺��� �� �����ںδ��
            
			
            //ȯ�� ����ΰ��� ȯ�ұ��� �̼�,������ �����ϰ� ���� 20091111 cys        
            if( StringHelper.strEquals(caller,"0������") || !StringHelper.strEquals(potptVO.getString("calcflag"),"N")) {

                //���ó�� ���̽�(refundyn�� Y�� ���̽�)
                if (this.getCnclCase_Chk(potptVO)) {
                        if(outrcptmngtDAO.getExopActList(potptVO).size() == 0) {
                            lReduAmt = 0;
                            lUncoAmt = 0;
                        }
                }
            }           

            //20090701�޿����ΰ� �޿������� ���� ��� 100�̸� ��ó�� ���� ����.
            if (lPayDiscAmt == lPayOwnBAmt) {
            	bDiscChk = true;
            }


           //���κδ������ 20110407 cys
           //�ǰ����踸 ����
           if (StringHelper.strEquals(popmiVO.getString("opmi_insukind"),"11")) { 
                
                //���׺��κδ��� ����
                if (StringHelper.strEquals(popmiVO.getString("opmi_suppkind"),"01")) {               
                    //////
                //�������̸鼭 ������� ����
                }else if(Integer.parseInt(popmiVO.getString("opmi_suppkind")) > 32 &&  
                         Integer.parseInt(popmiVO.getString("opmi_suppkind")) < 47 &&
                         StringHelper.strEquals(popmiVO.getString("opmi_handicapryn"),"Y"))
                {
                    /////
                }else{
           
                    P0032_280 = this.getPmcmCodeNm("P0032","280",sInstCd).getLong("cdnm",4000000);
                    
                    //400���� �Ѵ»���� ������ ����
                    if(lPayOwnBAmt > P0032_280){

                        lErSubtAmt   = lPayOwnBAmt  - P0032_280;
                        lPayInsuBAmt = lPayInsuBAmt + lErSubtAmt;
                        lPayOwnBAmt  = P0032_280;

                    }
                }
           }

            
           //20090701 1.�ܼ�ó�� �������
           //2011-08-10 ��Ź�˻��� ��� 100�̸� ���� ���� �ʴ´�.
           if  (bDiscChk == false && "20090701".compareTo(potptVO.getString("orddd")) <= 0 && "11".equals(popmiVO.getString("opmi_insukind")) 
            		&& !"01".equals(popmiVO.getString("opmi_suppkind")) && !"12".equals(popmiVO.getString("opmi_suppkind")) && !"13".equals(popmiVO.getString("opmi_suppkind"))) {
               
            	lPayInsuRestAmt1 =  Long.parseLong(NumericHelper.divide(String.valueOf(lPayOwnBAmt),String.valueOf("100"),  NumericHelper.ROUND_DOWN)) *100 ;
                lPayInsuRestAmt = lPayOwnBAmt - lPayInsuRestAmt1;
                
                lPayOwnBAmt100 = lPayOwnBAmt - lPayInsuRestAmt;
                lPayInsuBAmt100 = lPayInsuBAmt + lPayInsuRestAmt;
                
                if( log.isDebugEnabled() ){
                    
                    log.debug("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    log.debug("�ܷ����κδ�� �ܼ�ó��");
                    log.debug("lPayOwnBAmt : " + lPayOwnBAmt);
                    log.debug("lPayInsuRestAmt1 : " + lPayInsuRestAmt1);
                    log.debug("lPayInsuRestAmt2 : " + lPayInsuRestAmt2);
                    log.debug("lPayInsuRestAmt : " + lPayInsuRestAmt);
                    log.debug("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                }
            }
            
            if (lPayInsuRestAmt == 0) {
                lPayOwnBAmt100 = lPayOwnBAmt;
                lPayInsuBAmt100 = lPayInsuBAmt;
            }
            //20090701 1.�ܼ�ó�� �������------------------------
            
        }  

        //---��꿡�� �� ������ ������ ó���� ������ �̰���------------------------------------------
        //�ں��ѵ��� üũ : �ں����� && ���κδ�100% �ƴ� ���, ���Һ����ѵ���,�߻��ݾ״���,���豸�� ��ȸ
        //����üũ
        //����üũ
        //--------------------------------------------------------------------------------------
                
		/////////////////////////////////////����α��/////////////////////////////////////////
        if(log.isDebugEnabled()){
        	log.debug("**----��������� ------**  ");
        	log.debug("**----insukind => ------**  "         + popmiVO.getString("opmi_insukind"));
        	log.debug("**----opmi_handicapryn => ------**  " + popmiVO.getString("opmi_handicapryn")); 
        }
        //����α�� ����(�Ƿ�޿�2��+�����ȯ��)
        //�������� :�Ƿ�޿�2��, 
        //�������� :�����,  �����ȯ�� ���� üũ�� ������ ���� �Ǵ� => ȯ�ڸ������� �����ȯ�ڿ��� �� üũ
        //������̸�, �޿����κδ��� ��� ��ֱ������ ó��
        
        //2011-11-14
        //�ǽ������� �� ���, ���� ��ұ� ����
        //�ǽ����� ���� �� ��ͱ��� �߰�.
        if(StringHelper.strEquals(popmiVO.getString("opmi_handicapryn"),"Y")){
			//�Ƿ�޿� 2���϶�
			if ( StringHelper.strEquals(popmiVO.getString("opmi_insukind"),"22")) { 
				lHandcapFund = lHandcapFund + lPayOwnBAmt;
				lDiscAmt = lNopyDiscAmt + lSpecDiscAmt;
			}
			//������ 2���϶� ��
			if ( StringHelper.strEquals(popmiVO.getString("opmi_insukind"),"11") && Integer.parseInt(popmiVO.getString("opmi_suppkind")) > 32 &&  Integer.parseInt(popmiVO.getString("opmi_suppkind")) < 47) {
				//20090701 1.�ܼ�ó�� �������
				lHandcapFund = lHandcapFund + lPayOwnBAmt100;
				lDiscAmt = lNopyDiscAmt + lSpecDiscAmt;
			}
        }
        //2013-05-23
        if(StringHelper.strEquals("2", potptVO.getString("calcbaseflag"))){ 		//�ǽ����� üũ
    		ValueObject hcVO = new ValueObject();
    		hcVO = outrcptmngtDAO.getExeHandcapFund(potptVO); 						//��ֱ��  ��ȸ
        	
        	long ltempHandcapFund = 0;
        	lHandcapFund = 0;
        	if(hcVO.size() > 0){
        		for(int i=0; i< hcVO.size(); i++){
        			//�Ƿ�޿� 2���϶�
        			if(StringHelper.strEquals(hcVO.getString(i, "insukind"), "22")){ 
        				ltempHandcapFund = ltempHandcapFund + hcVO.getLong(i, "handcapfund", 0);
        			}
        			//������ 2���϶� ��
        			if(StringHelper.strEquals(hcVO.getString(i, "insukind"), "11") && Integer.parseInt(hcVO.getString(i, "suppkind")) > 32 &&  Integer.parseInt(hcVO.getString(i, "suppkind")) < 47){
        				ltempHandcapFund = ltempHandcapFund + hcVO.getLong(i, "handcapfund", 0);
        			}
        		}
        		lHandcapFund = ltempHandcapFund;
        		lDiscAmt = lNopyDiscAmt + lSpecDiscAmt;
        	}
        }
        if(log.isDebugEnabled()){
            log.debug("**----��ֱ�� ó�� �� ------**  " 	+ String.valueOf(lHandcapFund));
            log.debug("**----��ֱ�� ------**  " 		+ String.valueOf(lHandcapFund));
            log.debug("**----�޿����κδ�� ------**  " 	+ String.valueOf(lPayOwnBAmt));
        }
        /////////////////////////////////////����α�� ��/////////////////////////////////////////

        //���޴��, ���� 
        //��������:���� �Ǵ� ��������:���޴���� ��� üũ
        //�޿� �����ںδ�� = �޿� �����ںδ��+ �޿� ���κδ��
        
        //���������� ����� ���,
        //lSubtAmt = lSubtAmt + lPayOwnBAmt;
        //lPayOwnBAmt = 0;
        
        //���������� �����̰�, ���������� ���κδ�100 �ƴҰ��
        //lPayInsuBAmt = lPayInsuBAmt + lPayOwnBAmt;
        //lPayOwnBAmt = 0;
         
        //���κδ��Ѿ� = ��޿���+���׺��κδ�(�����)+���������+�޿����κδ��
        //�÷��߰��� ���� ���κδ��Ѿ� ����� ���� = ��޿����κδ�+���׺��� ���κδ�+ �������ẻ�κδ�+�޿����κδ�

        lTotOwnBAmt = lPayOwnBAmt + lNopyOwnBAmt + lAllOwnOwnBAmt + lSpecOwnBAmt;
        retopmiVO.set("opmi_totownbamt",lTotOwnBAmt);           //���κδ��Ѿ�
        if ( log.isDebugEnabled() ) {log.debug("**----���κδ��Ѿ� ------**  " + String.valueOf(lTotOwnBAmt) );}
        
        //20090701 1.�ܼ�ó�� �������
        lTotOwnBAmt100 = lPayOwnBAmt + lNopyOwnBAmt + lAllOwnOwnBAmt + lSpecOwnBAmt - lPayInsuRestAmt;      
        retopmiVO.set("opmi_totownbamt100",lTotOwnBAmt100);         //���κδ��Ѿ�
        
        
        //����ó���� ���κδ��Ѿ�
        //20090701 1.�ܼ�ó�� �������
        //lTotOwnBAmt2 =  Long.parseLong(NumericHelper.divide(String.valueOf(lTotOwnBAmt),String.valueOf("10"),  NumericHelper.ROUND_DOWN)) *10 ;       
        //retopmiVO.set("opmi_totownbamt2",lTotOwnBAmt2);           //���κδ��Ѿ�2 -����ó��
        lTotOwnBAmt2 =  Long.parseLong(NumericHelper.divide(String.valueOf(lTotOwnBAmt100),String.valueOf("10"),  NumericHelper.ROUND_DOWN)) *10 ;      
        retopmiVO.set("opmi_totownbamt2",lTotOwnBAmt2);         //���κδ��Ѿ�2 -����ó��
        
        //20110701 �̿뼺�� �ΰ��� ��� ����
        //�������� �Ϲ�(51) �������� �̿��������(85) �϶� ���κδ���� 10%�� �ΰ����� �ΰ��Ѵ�.
        if (StringHelper.strEquals(popmiVO.getString("opmi_insukind"),"51")
        			&& StringHelper.strEquals(popmiVO.getString("opmi_suppkind"),"85") ) { 
        	
        	iTaxAmt = (long)(lTotOwnBAmt / 10);
        }
        
        //�ӻ�ȯ��(��������'71')�̸� �ӻ�̼��� ó���Ѵ�.(���������ܴ� ����ʿ��� �˾Ƽ� ����)
        if (StringHelper.strEquals(popmiVO.getString("opmi_insukind"),"71")) {
        	
        	//2013-03-04 �ӻ��϶� ���κδ�� ���� �̼��� �ƴ϶� �Աݱݾ��� ������ ������ �ݾ׸� �̼�ó��
        	//(- lPreCashAmt - lPreCardAmt - lPreOnlineAmt - lPreMdlRcptAmt) �߰�
            lLabAmt  = lTotOwnBAmt2 - lPayOwnBAmt - lPreCashAmt - lPreCardAmt - lPreOnlineAmt - lPreMdlRcptAmt;
            if( lLabAmt < 0 ){
            	lLabAmt = 0;
            }
            lUncoAmt = lLabAmt;
        }
        
        if ( log.isDebugEnabled() ) {log.debug("**----�̼���(�ӻ�̼�) ------** " + String.valueOf(lUncoAmt) );}
        
        //�ӻ󿬱���ȣ
        retopmiVO.set("opmi_uncoamt"         ,lUncoAmt);                        //�̼��ݾ�                         
        retopmiVO.set("opmi_labamt"          ,lLabAmt);                         //�ӻ�ݾ�                        
                                                                                                                  
        //�������                                                                                                
        retopmiVO.set("opmi_precashamt"      ,lPreCashAmt);                     //�����ݾ�                        
        retopmiVO.set("opmi_precardamt"      ,lPreCardAmt);                     //��ī���                        
        retopmiVO.set("opmi_preonlineamt"    ,lPreOnlineAmt);                   //��¶��αݾ�                    
        retopmiVO.set("opmi_premdlrcptamt"   ,lPreMdlRcptAmt);                  //�⼱����                        
                                                                                                                  
        //���� ����                                                                                               
        retopmiVO.set("opmi_handcapfund"     , lHandcapFund);                   //��ֱ��                        
        retopmiVO.set("opmi_subtamt"         , lSubtAmt);                       //��Ҿ�                          
        retopmiVO.set("opmi_ersubtamt"       , lErSubtAmt);                     //���޴�Ҿ�                      
        retopmiVO.set("opmi_procsubtamt"     , lProcSubtAmt);                   //��ȣ��Ҿ�                      
                                                                                                                  
        retopmiVO.set("opmi_discamt"         ,lDiscAmt );                       //���αݾ�                        
        retopmiVO.set("opmi_reduamt"         ,lReduAmt );                       //���ױݾ�                        
        retopmiVO.set("opmi_discreduamt"     ,lDiscAmt+lReduAmt);               //����+����                       
        retopmiVO.set("opmi_bloddiscamt"     ,lBlodDiscAmt);                    //������ü�ݾ�(����������)        
                                                                                                                                                                                                             
        retopmiVO.set("opmi_payamt"          ,lPayAmt);                         //�޿��Ѿ�                        
        retopmiVO.set("opmi_payinsubamt"     ,lPayInsuBAmt);                    //�޿������ںδ��                
        retopmiVO.set("opmi_payownbamt"      ,lPayOwnBAmt);                     //�޿����κδ��                  
                                                                                                                  
        retopmiVO.set("opmi_nopyamt"         ,lNopyAmt);                        //��޿��Ѿ�                      
        retopmiVO.set("opmi_nopyinsubamt"    ,lNopyInsuBAmt);                   //��޿����κδ��                
        retopmiVO.set("opmi_nopyownbamt"     ,lNopyOwnBAmt);                    //��޿������ںδ��              
                                                                                                                  
        retopmiVO.set("opmi_allownbamt"      ,lAllOwnBAmt);                     //���׺��κδ��(�����)        
        retopmiVO.set("opmi_allowninsubamt"  ,lAllOwnInsuBAmt);                 //���׺��κ��κδ��              
        retopmiVO.set("opmi_allownownbamt"   ,lAllOwnOwnBAmt);                  //���׺��κ����ںδ��            
                                                                                                                  
        retopmiVO.set("opmi_specamt"         ,lSpecAmt);                        //���������                      
        retopmiVO.set("opmi_specinsubamt"    ,lSpecInsuBAmt);                   //����������κδ��            
        retopmiVO.set("opmi_specownbamt"     ,lSpecOwnBAmt);                    //������������ںδ��          
                                                                                                                  
        retopmiVO.set("opmi_totnopyinsubamt" ,lTotNopyInsuBAmt);                //��޿�+���׺��� �� �����ںδ�� 
        retopmiVO.set("opmi_totnopyownbamt"  ,lTotNopyOwnBAmt);                 //��޿�+���׺��� �� ���κδ��   
        retopmiVO.set("opmi_heallifeamtclamamt" ,lHeallifeamtclamAmt);          //�ǰ���Ȱ������û��
        retopmiVO.set("opmi_prepregdmndamt"     ,lPrepregdmndAmt);              //�����������������
        retopmiVO.set("opmi_pregdmndamt"        ,lPregdmndAmt);                 //����������������
        
        //20090701 1.�ܼ�ó�� �������
        retopmiVO.set("opmi_payinsurestamt" , lPayInsuRestAmt);     //100���̸� ����û���ݾ�
        retopmiVO.set("opmi_payownbamt100"  , lPayOwnBAmt100);      //���� ó���� ���κδ��
        retopmiVO.set("opmi_payinsubamt100" , lPayInsuBAmt100);     //���� ó���� �����ںδ��
        
        //20110701 �̿뼺�� �ΰ��� �������
        retopmiVO.set("opmi_taxamt" 				, iTaxAmt);     				//�ΰ���


        
        //��ͳ�ġ�����ݰ� ��ֱ���� ���ÿ� ������ ����
        if(StringHelper.strEquals(potptVO.getString("rareobstflag"), "H") && lHandcapFund == 0 ) {
            retopmiVO.set("opmi_suppamt" ,lPayOwnBAmt100);                          //��ͳ�ġȯ��������
            lSuppamt = lPayOwnBAmt100;
        }else if(StringHelper.strEquals(potptVO.getString("rareobstflag"), "L") && lHandcapFund == 0 &&
                 (StringHelper.strEquals(popmiVO.getString("opmi_suppkind"),"50") || StringHelper.strEquals(popmiVO.getString("opmi_suppkind"),"51"))){                                                                                                   
            retopmiVO.set("opmi_suppamt" ,lPayOwnBAmt100 * 0.5);                    //����ȯ��
            lSuppamt =  Long.parseLong(NumericHelper.divide(String.valueOf(lPayOwnBAmt100),"2", NumericHelper.ROUND_UP));
        }else{                                                                                                    
            retopmiVO.set("opmi_suppamt" ,0);                                   
            lSuppamt = 0;
        }
        retopmiVO.set("opmi_mdlrcptamt",lMdlRcptAmt);                              //�߰��� ��ü

        //2011-11-14
        //�ǽ������� �� ���, ���� ��ұ� ����
        //�ǽ����� ���� �� ��ͱ��� �߰�.
        if(StringHelper.strEquals("2", potptVO.getString("calcbaseflag"))){ 		//�ǽ����� üũ
        	//����, �ֱ� ������ ���� START
        	ValueObject ejVO = new ValueObject();
        	ejVO = outrcptmngtDAO.getExeSuppAmt(potptVO);
        	
        	long ltempSuppamt = 0;
    		lSuppamt = 0;
    		
        	if( ejVO.size() > 0 ){
        		for( int i=0; i< ejVO.size(); i++ ){
        			ltempSuppamt = ejVO.getLong(i, "suppamt", 0);
        			//100���̸� ����
	        		if  (bDiscChk == false && "20090701".compareTo(potptVO.getString("orddd")) <= 0 && "11".equals(popmiVO.getString("opmi_insukind")) 
	                		&& !"01".equals(popmiVO.getString("opmi_suppkind")) && !"12".equals(popmiVO.getString("opmi_suppkind")) && !"13".equals(popmiVO.getString("opmi_suppkind"))) {
	        			ltempSuppamt = Long.parseLong(NumericHelper.divide(String.valueOf(ltempSuppamt),String.valueOf("100"),  NumericHelper.ROUND_DOWN)) *100 ;
	        		}
	        		//���� 50���� ����
	        		if( StringHelper.strEquals("L", ejVO.getString(i, "rareobstflag"))){
	        			ltempSuppamt =  Long.parseLong(NumericHelper.divide(String.valueOf(ltempSuppamt),"2", NumericHelper.ROUND_UP));
	        		}
	        		lSuppamt = lSuppamt + ltempSuppamt;
        		}
        	}
    		retopmiVO.set("opmi_suppamt" , lSuppamt);
    		//����, �ֱ� ������ ���� END
        }
        
        
		/*
        ���� ���� �����ؾ��� �ݾ�  = ���κδ��Ѿ� - ��ֱ��/��Ҿ�/�����ʰ���/�Ƿ�޿���Ҿ�
                                                    ������ü
                                                    �Ƿ�޿�����
                                                    �����/����
                                                    ��ͳ�ġ/��������
                                                    ���ǰ���
                                                    �̼���
                                                    ������/�⼱��
                                                    ��ī��/��¶���
                                                    ������
		*/
        
        //100���̸� ����� ���� ���� ȯ�� ���α��� ������ �ݾ��� ���� ��� ���� �ݾ��� - �߻�. (���������� ����) 
        //������ �ݾ׿��� ���ְ� ���翡 ���Ѵ� (DiscRestAmt��  - �ݾ���)
        long DiscRestAmt = 0;
        if (lTotOwnBAmt100 < lDiscAmt) {
        	DiscRestAmt = lDiscAmt - lTotOwnBAmt100;
        }	
        	
        lRcptExptAmt = lTotOwnBAmt100 - lHandcapFund   //-lSubtAmt-lErSubtAmt-lProcSubtAmt
            -lBlodDiscAmt
            -lHeallifeamtclamAmt
            -lPrepregdmndAmt
            -lPregdmndAmt
            -lSuppamt-lDiscAmt
            -lReduAmt
            -lUncoAmt
            -lPreCardAmt-lCardAmt-lPreCashAmt-lCashAmt-lPreOnlineAmt-lOnlineAmt-lPreMdlRcptAmt-lMdlRcptAmt + DiscRestAmt
            //20110701 �̿뼺�� �ΰ��� �������
            //������ �ݾ׿� �ΰ��� ����.
            + iTaxAmt;
	        
        retopmiVO.set("opmi_rcptexptamt",lRcptExptAmt); //�����ؾ��� �ݾ�
		
        /*
        log.debug("instance test: -----------------------------------------------------------------------------");      
        log.debug("instance test:  lTotOwnBAmt100         :" + lTotOwnBAmt100        );
        log.debug("instance test:  lHandcapFund           :" + lHandcapFund          );
        log.debug("instance test:  lSubtAmt               :" + lSubtAmt              );
        log.debug("instance test:  lBlodDiscAmt           :" + lBlodDiscAmt          );
        log.debug("instance test:  lHeallifeamtclamAmt    :" + lHeallifeamtclamAmt   );
        log.debug("instance test:  lPrepregdmndAmt        :" + lPrepregdmndAmt       );
        log.debug("instance test:  lPregdmndAmt           :" + lPregdmndAmt          );
        log.debug("instance test:  lSuppamt               :" + lSuppamt              );
        log.debug("instance test:  lDiscAmt               :" + lDiscAmt              );
        log.debug("instance test:  lReduAmt               :" + lReduAmt              );
        log.debug("instance test:  lUncoAmt               :" + lUncoAmt              );
        log.debug("instance test:  lPreCardAmt            :" + lPreCardAmt           );
        log.debug("instance test:  lCardAmt               :" + lCardAmt              );
        log.debug("instance test:  lPreCashAmt            :" + lPreCashAmt           );
        log.debug("instance test:  lCashAmt               :" + lCashAmt              );
        log.debug("instance test:  lPreOnlineAmt          :" + lPreOnlineAmt         );
        log.debug("instance test:  lOnlineAmt             :" + lOnlineAmt            );
        log.debug("instance test:  lPreMdlRcptAmt         :" + lPreMdlRcptAmt        );
        log.debug("instance test:  lMdlRcptAmt            :" + lMdlRcptAmt           );
        log.debug("instance test:  lRcptExptAmt           :" + lRcptExptAmt          );
        log.debug("instance test: -----------------------------------------------------------------------------");
        */
        
        //���ݼ����� => �����ұݾ�
        //�����ұݾװ� ���ݱݾ��� �����Ѵ�.

		
		/////////////////////////////////////////////����ó�� ����///////////////////////////////////////////////////
		//(-)�ݾ� �������ð��, -56 ���ϰ��, -60 �� ó���ϰ�, (+4)�� ����ó���Ѵ�, ������ �ݾ����ִ��� üũ
		P0032_130 = this.getPmcmCodeNm("P0032","130",sInstCd).getString("cdnm","N");


		//10�� ���� ����
		if (!StringHelper.strEquals(P0032_130,"Y")) {
			if (lRcptExptAmt < 0) {             
				
				if (!StringHelper.strEquals(StringHelper.toSubString(String.valueOf(lRcptExptAmt) 
										  , StringHelper.getByteLength(String.valueOf(lRcptExptAmt))-1 
										  , StringHelper.getByteLength(String.valueOf(lRcptExptAmt))), "0")) {
					lCashAmt = Long.parseLong(NumericHelper.divide(String.valueOf(lRcptExptAmt),String.valueOf("10"),  NumericHelper.ROUND_DOWN)) *10 -10 ; 
				}else{  
					lCashAmt = lRcptExptAmt;
				}
				retopmiVO.set("opmi_cashamt",lCashAmt); 
				
			}else {
				
				lCashAmt = Long.parseLong(NumericHelper.divide(String.valueOf(lRcptExptAmt),String.valueOf("10"),  NumericHelper.ROUND_DOWN)) *10 ;
				retopmiVO.set("opmi_cashamt",lCashAmt);
			}
			
		}
		
		//100�� ���� ����
		if (StringHelper.strEquals(P0032_130,"Y")) {

			if (lRcptExptAmt < 0) {             
				
				if (!StringHelper.strEquals(StringHelper.toSubString(String.valueOf(lRcptExptAmt) 
										  , StringHelper.getByteLength(String.valueOf(lRcptExptAmt))-2 
										  , StringHelper.getByteLength(String.valueOf(lRcptExptAmt))), "00")) {
					lCashAmt = Long.parseLong(NumericHelper.divide(String.valueOf(lRcptExptAmt),String.valueOf("100"),  NumericHelper.ROUND_DOWN)) *100 -100 ; 
				}else{  
					lCashAmt = lRcptExptAmt;
				}
				retopmiVO.set("opmi_cashamt",lCashAmt); 
			}else {
				lCashAmt = Long.parseLong(NumericHelper.divide(String.valueOf(lRcptExptAmt),String.valueOf("100"),  NumericHelper.ROUND_DOWN)) *100 ;
				retopmiVO.set("opmi_cashamt",lCashAmt);
			}

		}
		if( log.isDebugEnabled() ){
            
            log.debug("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            log.debug("����ó��");
            log.debug("������ : " + lRcptExptAmt);
            log.debug("������ : " + lCashAmt);
            log.debug("����� : " + (lRcptExptAmt - lCashAmt));
            log.debug("����-���� : " + DiscRestAmt);
            log.debug("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
		/////////////////////////////////////////////����ó�� ��///////////////////////////////////////////////////

        retopmiVO.set("opmi_cardamt"  ,lCardAmt);
        retopmiVO.set("opmi_onlineamt",lOnlineAmt);         
        
        //�����
        //lRestAmt = lRcptExptAmt - lCashAmt;
        lRestAmt = lRcptExptAmt - lCashAmt - DiscRestAmt;
        retopmiVO.set("opmi_restamt",lRestAmt);
        
        //�����ؾ��� �ݾ� �� ����
        retopmiVO.set("opmi_rcptexptamt",lCashAmt);
        
        //������� = �޿��Ѿ�+��޿��Ѿ�+���׺��κδ��(�����)+���������
        retopmiVO.set("opmi_totamt",Long.parseLong(retopmiVO.getString("opmi_payamt"))     + Long.parseLong(retopmiVO.getString("opmi_nopyamt")) +
                                    Long.parseLong(retopmiVO.getString("opmi_allownbamt")) + Long.parseLong(retopmiVO.getString("opmi_specamt"))                 
                                    );
        
        //��޿��Ѿ� = ��޿��Ѿ�+���׺��κδ��(�����)
        retopmiVO.set("opmi_totnopyamt",Long.parseLong(retopmiVO.getString("opmi_nopyamt")) + Long.parseLong(retopmiVO.getString("opmi_allownbamt")));

        //���Ա� =������ �ݾ� ����
        retopmiVO.set("opmi_paydepoamt",retopmiVO.getInt("opmi_rcptexptamt"));
/*
        //�������� ���Ǿ����� ������ �ݾ�
        retopmiVO.set("opmi_server_rcptamt", lTotOwnBAmt - lPreCardAmt - lPreCashAmt - lPreOnlineAmt - lPreMdlRcptAmt - lPrepregdmndAmt - lHandcapFund - lSubtAmt - lSuppamt - lDiscAmt - lRestAmt);

        //���κδ��Ѿ� - ��ֱ��/��Ҿ�/
                                ������ü/�Ƿ�޿�����/
                                �����/����/
                                ��ͳ�ġ/��������/
                                ��ī��/������/��¶���/
                                �⼱��
        
        ���ǰ���/�̼���/������ ����
*/
        
        //20090701 1.�ܼ�ó�� �������
        retopmiVO.set("opmi_server_rcptamt", lTotOwnBAmt100 - lHandcapFund - lSubtAmt 
											- lBlodDiscAmt     - lHeallifeamtclamAmt 
											- lPrepregdmndAmt  - lPregdmndAmt 
											- lSuppamt         - lDiscAmt
											- lPreCardAmt  - lPreCashAmt  - lPreOnlineAmt
											- lPreMdlRcptAmt 
											- lRestAmt
											//2011-07-01 �̿��� ����
											+ iTaxAmt);

        retopmiVO.set("opmi_pid"           ,potptVO.getString("pid"));
        retopmiVO.set("opmi_orddd"         ,potptVO.getString("orddd"));
        retopmiVO.set("opmi_cretno"        ,potptVO.getString("cretno"));
        retopmiVO.set("opmi_acptseqno"     ,potptVO.getString("acptseqno"));        
        retopmiVO.set("opmi_instcd"        ,potptVO.getString("instcd"));                               
        retopmiVO.set("opmi_ordtype"       ,potptVO.getString("ordtype"));
        retopmiVO.set("opmi_orddeptcd"     ,potptVO.getString("orddeptcd"));
        retopmiVO.set("opmi_orddrid"       ,potptVO.getString("orddrid"));
        retopmiVO.set("opmi_mskind"        ,potptVO.getString("mskind"));
        retopmiVO.set("opmi_calcmthdflag"  ,potptVO.getString("calcmthdflag"));     
        retopmiVO.set("opmi_insukind"      ,potptVO.getString("insukind"));
        retopmiVO.set("opmi_suppkind"      ,potptVO.getString("suppkind"));
        retopmiVO.set("opmi_insucd"        ,potptVO.getString("insucd"));      
        
        retopmiVO.set("opmi_orgorddd"      ,potptVO.getString("orgorddd"));
        retopmiVO.set("opmi_orgcretno"     ,potptVO.getString("orgcretno"));
        
        retopmiVO.set("opmi_orddeptcdnm"   , popmiVO.getString("opmi_orddeptcdnm"));
        retopmiVO.set("opmi_orddridnm"     , popmiVO.getString("opmi_orddridnm"));
        
        retopmiVO.set("opmi_rcptdd"        , SRcptdd);    //�⺻ ����Ű
        retopmiVO.set("opmi_rcptno"        , SRcptno);   
        retopmiVO.set("opmi_rcptseqno"     , SRcptSeqno);
        
        retopmiVO.set("opmi_orgrcptdd"     , SRcptdd);    //�̼����� ���Ƿ� �ܷ��������� �ʿ������ �ϴ� �־����
        retopmiVO.set("opmi_orgrcptno"     , SRcptno);   
        retopmiVO.set("opmi_orgrcptseqno"  , SRcptSeqno);
        retopmiVO.set("opmi_orddd_org"     , potptVO.getString("orddd"));         //����� �����ҋ� �� ������ ���̺���� ���� ����Ű�� ã������ ��������.
        retopmiVO.set("opmi_cretno_org"    , potptVO.getString("cretno"));
        retopmiVO.set("opmi_orddeptcd_org" , potptVO.getString("orddeptcd"));
        retopmiVO.set("opmi_orddrid_org"   , potptVO.getString("orddrid"));
        retopmiVO.set("opmi_rcptdd_org"    , SRcptdd);    
        retopmiVO.set("opmi_rcptno_org"    , SRcptno);   
        retopmiVO.set("opmi_rcptseqno_org" , SRcptSeqno);
        
        retopmiVO.set("pid"                , potptVO.getString("pid"));         //������ ������ ���̺� ��ȸ�� ���
        retopmiVO.set("orddd"              , potptVO.getString("orddd"));   
        retopmiVO.set("cretno"             , potptVO.getString("cretno"));  
        retopmiVO.set("orddeptcd"          , potptVO.getString("orddeptcd"));
        retopmiVO.set("orddrid"            , potptVO.getString("orddrid"));
        retopmiVO.set("rcptdd"             , SRcptdd);     
        retopmiVO.set("rcptno"             , SRcptno);  
        retopmiVO.set("rcptseqno"          , SRcptSeqno);

        retopmiVO.set("opmi_refundyn"      , potptVO.getString("refundyn"));
        retopmiVO.set("opmi_centcd"        , potptVO.getString("centcd"));
        retopmiVO.set("opmi_subdeptcd"     , potptVO.getString("subdeptcd"));
        retopmiVO.set("opmi_coopteamcd"    , potptVO.getString("coopteamcd"));

        return retopmiVO;
	}	


	/* ��������(OPMI) ���� �� ����
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#insOutOrdAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insOutOrdAmt(ValueObject pVO) throws LiveException {

		int retCount = -1;
		int iCount = -1;
		
		ValueObject tmpOtpt = new ValueObject ();
		
		

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		try {
		
			//���ʵ����/����������/����ڵ� ����
			pVO.set("opmi_fstrgstrid" , pVO.getString("sessuserid"));
			pVO.set("opmi_lastupdtrid", pVO.getString("sessuserid"));
			pVO.set("opmi_instcd"     , pVO.getString("sessinstcd"));
			pVO.set("opmi_rcptrid"    , pVO.getString("sessuserid"));
			pVO.set("instcd"          , pVO.getString("sessinstcd"));
			
			//---------------------------------------
			//�ش� �ܷ���ϳ����� ���걸���� �����̸�, 
			//�ش� �ܷ���ϳ����� ���걸���� �Ǻ��̸�, outrcptmngtDAO.insOutOrdAmt
			//---------------------------------------
			//�ܷ��������� �������� �ܷ���ϳ��� ��ȸ
			
			
			
			tmpOtpt = outrcptmngtDAO.getOtptInfo2(pVO);
			
			//�����̸�, �������� C update, ��ҳ��� D ����		
			if (StringHelper.strEquals(tmpOtpt.getString("otpt_calcyn"),"Y")) {
				
				//OPMI
				if (outrcptmngtDAO.insOutOrdAmtDC(pVO) <0)	
					throw new LiveException("??  insOutOrdAmt  : insOutOrdAmtDC => opmi dc ���� ���� ");	//D
				
				if (outrcptmngtDAO.setOutOrdAmtC(pVO) <0) 
					throw new LiveException("??  insOutOrdAmt  :  setOutOrdAmtC  => opmi y=>c ���� ���� ");	//C
				
				if (outrcptmngtDAO.insOutOrdAmt(pVO) <=0) 
					throw new LiveException("??  insOutOrdAmt  :  insOutOrdAmt  => opmi y ���� ���� ���� ");	//Y
				
				
				//�ش� ��곻���� D ����  - ���������� ������ 
				/*
				retCount = -1;
				retCount = outrcptmngtDAO.insOSCLDC(pVO);
				if (retCount <0)	throw new LiveException("??  insOutOrdAmt  :  insOSCLDC  => oscl dc ���� ���� ");
				*/

				//�ش� ��곻�� C ����
				if (outrcptmngtDAO.setOSCLC(pVO) <0) throw new LiveException("??  insOutOrdAmt  :  setOSCLC  => oscl y=>c ���� ���� ");
				
				//���� ������ �������� ó��
				
				//DCGM ����/����
				outrcptmngtDAO.insDcgmAmtDC(pVO);	//D
				outrcptmngtDAO.setDcgmAmtC(pVO);	//C
				
				//UNCO �̼�
				outrcptmngtDAO.insUncoAmtDC(pVO);	//D
				outrcptmngtDAO.setUncoAmtC(pVO);	//C
				
				//BLDC ������
				outrcptmngtDAO.insBldcAmtDC(pVO);	//D
				outrcptmngtDAO.setBldcAmtC(pVO);	//C
				
				
			}
			else if (StringHelper.strEquals(tmpOtpt.getString("otpt_calcyn"),"N")) {
				
				if (outrcptmngtDAO.insOutOrdAmt(pVO) <=0) 
					throw new LiveException("??  insOutOrdAmt  :  insOutOrdAmt  => opmi y ���� ���� ���� ");
								
				//�������� ������ Y, û�������°� R�� ���� û�������� C�� ����
				iCount = outrcptmngtDAO.setClamTrgtStat(pVO);
				if (outrcptmngtDAO.setClamTrgtStat(pVO) <0) 
					throw new LiveException("??  insOutOrdAmt  :  setClamTrgtStat  => calmtrgtstat ���� ���� ");
								
			}
		
		
		} catch (LiveException le) {
            throw le;
        } catch (Exception e) {
            throw new LiveException("com.error.90000", e);
        }	
		
		
		return retCount;
		
	}
	
	/*
	 * (��Javadoc)
	 * �ܷ���ϳ����� ��������
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getOutRcptSpec(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOutRcptSpec(ValueObject pVO) throws LiveException {
		
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getOutRcptSpec(pVO);
	}

	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getMdlRemAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getMdlRemAmt(ValueObject pVO) throws LiveException {

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getMdlRemAmt(pVO);
	}

	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getMdlRemAmt2(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getMdlRemAmt2(ValueObject pVO) throws LiveException {

		ValueObject rVO = new ValueObject ();
		ValueObject bogjVO = new ValueObject ();
		ValueObject uncoVO = new ValueObject ();

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		bogjVO = outrcptmngtDAO.getMdlRemAmt2(pVO);
		uncoVO = outrcptmngtDAO.getUncoRemAmt(pVO);
		
		rVO.set("remamt"    , bogjVO.getString("remamt"));
		rVO.set("remamt2"   , bogjVO.getString("remamt2"));
        rVO.set("outuncoamt", uncoVO.getString("outuncoamt"));

		return rVO; 
	}


	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#insOnlineAmtCncl(kr.co.hit.live.vo.ValueObject)
	 */
	public int insOnlineAmtCncl(ValueObject pVO) throws LiveException {

		int iCount = -1;
		
		try { 

			 //����ڵ� ��ȸ
			if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
				pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
			}
			
			//����� ��ȸ
			if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
				pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
			}
			
			//���ʵ����/����������/����ڵ� ����
			pVO.set("fstrgstrid", pVO.getString("sessuserid"));
			pVO.set("lastupdtrid", pVO.getString("sessuserid"));
			pVO.set("instcd",pVO.getString("sessinstcd"));
			
			//������ ����
			pVO.set("rcptrid",pVO.getString("sessuserid"));
			
			iCount = -1;
			//������ҳ��� rcptstat :D ������ ����
			iCount = outrcptmngtDAO.insOnlineAmtCncl(pVO);
			
			if (iCount <= 0) {
				throw new LiveException("pam.error.15014");
				//throw new LiveException("�ܷ�������-�����Ա� ��ҳ����� �������� �ʾҽ��ϴ�.[15014]");		
			}
			
			iCount = -1;
			//�� �������� Y => C�� ����
			iCount = outrcptmngtDAO.setOnlineAmt(pVO);
			
			if (iCount <= 0) {
				//throw new LiveException("pam.error.15015");
				throw new LiveException("�ܷ�������-�����Ա� ������ ������� �ʾҽ��ϴ�.[15015]");		
			}
		
		} catch (LiveException le) {
            throw le;
        } catch (Exception e) {
            throw new LiveException("com.error.90000", e);
        }	
		
		
		return iCount;
	}

	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#insMdlAmtCncl(kr.co.hit.live.vo.ValueObject)
	 */
	public int insMdlAmtCncl(ValueObject pVO) throws LiveException {
		
		int iCount = -1;
		
		try {
			 //����ڵ� ��ȸ
			if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
				pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
			}
			
			//����� ��ȸ
			if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
				pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
			}
			
			pVO.set("fstrgstrid" , pVO.getString("sessuserid"));
			pVO.set("lastupdtrid", pVO.getString("sessuserid"));
			pVO.set("instcd"     , pVO.getString("sessinstcd"));
			pVO.set("rcptrid"    , pVO.getString("sessuserid"));
			
			//������ҳ��� rcptstat :D ������ ����
			iCount = -1;
			iCount = outrcptmngtDAO.insMdlAmtCncl(pVO);
			
			if (iCount <= 0) {
				//throw new LiveException("pam.error.15012");
				throw new LiveException("�ܷ������� ��ҳ����� �������� �ʾҽ��ϴ�.[15012]");		
			}
			//���� ������ ��, ��� rcptseqno+100
			pVO.set("rcptseqno", Integer.valueOf(pVO.getString("rcptseqno"))+100  );
			
			//�� �������� Y => C�� ����
			iCount = -1;
			iCount=  outrcptmngtDAO.setMdlAmt(pVO);
			
			if (iCount <= 0) {
				//throw new LiveException("pam.error.15013");
				throw new LiveException("�ܷ������� ������ ������� �ʾҽ��ϴ�.[15013]");		
			}
		
		} catch (LiveException le) {
            throw le;
        } catch (Exception e) {
            throw new LiveException("com.error.90000", e);
        }	
		
		return iCount;
		
	}
	
	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#insChangeHist(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject insChangeHist(ValueObjectAssembler pVOs)  throws LiveException{

		ValueObject CheckinVO = pVOs.get("Checkin");
		ValueObject retOtptVO = new ValueObject ();
		
        String sInstCd = "";
        String sUserId = "";

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(CheckinVO.getString("sessinstcd"), "")) {
            CheckinVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(CheckinVO.getString("sessuserid"), "")) {
            CheckinVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID))); 
        }

        sInstCd = CheckinVO.getString("sessinstcd");
        sUserId = CheckinVO.getString("sessuserid");
		
		int iCheck = -1;
		if (StringHelper.strEquals(CheckinVO.getString("calcgubn"), "Y")) {

			//ó�� hold��(execrcptstatcd ='210')�� ������ otpt�� holdflag Y�־��ش�.
			if(outrcptmngtDAO.getHoldExop(CheckinVO).size() > 0) {
				CheckinVO.set("holdflag" , "Y");
			}else{
				CheckinVO.set("holdflag" , "N");
			}
			//ó�� hold ��

			//�ܷ���� �̷� �߰�(�������� histstat=C, �߰����̷� histstat=R)

			iCheck = outrcptmngtDAO.insOtptHistAdd(CheckinVO);

		}
		
		//�ܷ���� ��ȸ
		retOtptVO = outrcptmngtDAO.getLastOtpt(CheckinVO);	
		
		return retOtptVO;
		
	}

	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#insChangePtin(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject insChangePtin(ValueObjectAssembler pVOs)  throws LiveException{

		ValueObject CheckinVO = pVOs.get("Checkin");
		ValueObject PtinVO = pVOs.get("ptin");
		ValueObject retOtptVO = new ValueObject ();
		
        String sInstCd = "";
        String sUserId = "";

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(CheckinVO.getString("sessinstcd"), "")) {
            CheckinVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(CheckinVO.getString("sessuserid"), "")) {
            CheckinVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID))); 
        }

        sInstCd = CheckinVO.getString("sessinstcd");
        sUserId = CheckinVO.getString("sessuserid");
		
		int iCheck = -1;
		if (StringHelper.strEquals(CheckinVO.getString("calcgubn"), "Y")) {

			//�������� �߰�		
			PtinVO.set("ptin_pid"         , CheckinVO.getString("pid"));
			PtinVO.set("sessinstcd"       , sInstCd);
			PtinVO.set("sessuserid"       , sUserId);
			
			if (StringHelper.strEquals(PtinVO.getString("ptin_todd"),"") ) {
				PtinVO.set("ptin_todd","99991231");
			}

			String ptin_insukind = PtinVO.getString("ptin_insukind");
			
			//���μ����� ptin�̷º��� ���մϴ�.
			if(!StringHelper.strEquals(ptin_insukind,"31") &&
			   !StringHelper.strEquals(ptin_insukind,"41") &&
			   !StringHelper.strEquals(ptin_insukind,"42") &&
			   !StringHelper.strEquals(sUserId,"PAM001")   &&
			   !StringHelper.strEquals(sUserId,"PAM")) {
					
					insPtinHistAdd(PtinVO);	

				}
			
		}
		
		//�ܷ���� ��ȸ
		retOtptVO = outrcptmngtDAO.getLastPtin(CheckinVO);
		return retOtptVO;
		
	}

	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getPatInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getPatInfo(ValueObject pVO) throws LiveException{
		
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getPatInfo(pVO);
		
	}
	
	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getPatDiag(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getPatDiag(ValueObject pVO) throws LiveException{
		
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

		if(outrcptmngtDAO.getChkOtptMJ(pVO).size() > 0) {
			pVO.set("mjyn","y");
		}else{
			pVO.set("mjyn","n");
		}

		return outrcptmngtDAO.getPatDiag(pVO);
		
	}	
	
    /*
     * �ܷ����� �������
     * 
     * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#setOutOrdAmtCalc(kr.co.hit.live.vo.ValueObject)
     */
    public ValueObjectAssembler setOutOrdAmtCalc(ValueObjectAssembler pVOs) throws LiveException {
    
        ValueObject ptbsVO = pVOs.get("ptbs");
        ValueObject otptVO = pVOs.get("otpt");
        ValueObject ptinVO = pVOs.get("ptin");
        ValueObject actrVO = pVOs.get("actr");
        ValueObject bldcVOS;

        if(pVOs.isExist("bldc")){
        	bldcVOS = pVOs.get("bldc");
        }else{
        	bldcVOS = new ValueObject();
        }
        String sCalcActFlag    = otptVO.getString("otpt_calcactflag");    //ȭ�鿡�� �޾ƿ� ���� ���� ���� 2007.06.27
        String sCalcMthdFlag   = otptVO.getString("otpt_calcmthdflag");   //���������(P:����,D:DRG,N:�������,��, O:�ΰ�����)
        String calcgubn        = otptVO.getString("otpt_calcgubn");       //���:Y     ������:N
        String calcstat        = "R";  //otptVO.getString("calcstat");    //����ȭ��:R ����ȭ��:Y
        String workgubn        = ptbsVO.getString("workgubn");            //����ȭ��:Y ����ȭ��:N �ǽ�����:E         
        String rcptdd_org      = otptVO.getString("otpt_rcptdd");
        String rcptno_org      = otptVO.getString("otpt_rcptno");
        String rcptseqno_org   = otptVO.getString("otpt_rcptseqno");
        String refundyn        = otptVO.getString("otpt_refundyn");      //ȯ�ҿ���
        String calcbaseflag    = otptVO.getString("otpt_calcbaseflag");  //�ǽ����걸��
        String calcflag        = "S";                                    //��걸��
        String setbldccalc        = ptbsVO.getString("setbldccalc");            //������ü �������� ���� ����
        
        ValueObjectAssembler retVOs = new ValueObjectAssembler();       //��� �� output VOs
        ValueObjectAssembler inpVOs = new ValueObjectAssembler();       //����� �����ݾ� ��ȸ�� ���� input VOs
        ValueObjectAssembler chkVOs = new ValueObjectAssembler();       //����ó�� üũ
        
        ValueObject pCalcVO = new ValueObject();  //������ Ÿ�� ���� �⺻����
        ValueObject osclVO  = new ValueObject();  //��곻��
        ValueObject opmiVO  = new ValueObject();  //�����
        ValueObject earnVO  = new ValueObject();  //���ͳ���
        ValueObject cardVO  = new ValueObject();  //��ī��
        ValueObject cashVO  = new ValueObject();  //������
        ValueObject onlnVO  = new ValueObject();  //������
        ValueObject bldcVO  = new ValueObject();  //�������ü
        ValueObject dcgmVO  = new ValueObject();  //�Ⱘ��
        ValueObject uncoVO  = new ValueObject();  //��̼�

       String sInstCd = "";
       String sUserId = "";

       //���μ����� ���� �ڵ�- ���μ������� instcdVo�� �ް� �Ϲݼ����� �������� ���� 
       if (pVOs.isExist("instcd")) {

           sInstCd = pVOs.get("instcd").getString("sessinstcd");
           sUserId = pVOs.get("instcd").getString("sessuserid");
       
       }else{

           sInstCd = StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE));
           sUserId = StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID));
           
       }

        otptVO.set("sessinstcd", sInstCd); 
        otptVO.set("sessuserid", sUserId); 

        if (!StringHelper.strEquals(workgubn,"E") && 
            !StringHelper.strEquals(otptVO.getString("otpt_acptseqno"), outrcptmngtDAO.getOtptMaxAcptseqno(otptVO).getString("otpt_acptseqno"))) 
        {
            throw new LiveException("�ٸ�����ڿ� ���� ��ϳ����� ����� ȯ���Դϴ�. ȯ�ڸ� ����ȸ�Ͻʽÿ�");
        }

        //�ܷ������ ������ ���̺� ��ȸ
        ValueObject otptDtlVO = this.getOtptDetailTB(otptVO);

        if (StringHelper.strEquals(otptDtlVO.getString("drcm_exop_cnt"),"1")) {

                otptVO.set("otpt_medamtestmyn"  , "N");
                otptVO.set("otpt_medamtfreeresn", "15");
        }

        if (StringHelper.strEquals(otptDtlVO.getString("hocm_exop_cnt"),"1")) {

                otptVO.set("otpt_medamtestmyn"  , "N");
                otptVO.set("otpt_medamtfreeresn", "16");
        }
        
                
        //�ܷ�������ں� �������� üũ���� �߰�  by ���߷� 20130604
        //���������� ������ �ִ� ��� ����ó����
        ValueObject dcucCheckVO = new ValueObject();
        dcucCheckVO.set("pid",          otptVO.getString("otpt_pid"));      //��Ϲ�ȣ
        dcucCheckVO.set("disccd",       otptVO.getString("otpt_disccd"));   //�����ڵ�
        dcucCheckVO.set("basedd",       otptVO.getString("otpt_orddd"));    //��������(��������)
        patInfoMngt.getCheckDCUC(dcucCheckVO);

        //2012-03-12 ���κδ㱸�� ����
        //M006 �϶� ���� ����, ����϶��� ���������ϵ��� ����.
        //���� ���� ������ ownbflag ���°� ����Ǿ� ������ �� �����ܿ��� üũ�ϵ��� ���� by ���߷� 20130603
        //M005�� ��ͳ�ġ���� �ƴϴ��� ���κδ���� ó���ϵ��� �߰����� by ���߷� 20130605
        ValueObject ownbflagCheckVO = outrcptmngtDAO.getOwnbflagCheckInfo(otptVO);
        if( ownbflagCheckVO.size() > 0 && (StringHelper.strEquals("M006", otptVO.getString("otpt_ownbflag")))){
        	otptVO.set("otpt_ownbflag"  , "-");
        }
        
        if (StringHelper.strEquals(workgubn,"E") && actrVO.size() > 0) {

            this.delOutOrdActr(actrVO);
            if(StringHelper.strEquals(calcbaseflag,"2")){  //1: ����� ���� 2:�ǽ�����
                //�ǽ������Ͻ� �������� ���̺� �־��ش�.
                for(int a=0; a < actrVO.size(); a++) {
                    this.setOutOrdActr(actrVO.getRowAsVo(a)); 
                }
            }
        }
        


        //��꿡 ������ �ִ� �������� ���� üũ.
        ValueObjectAssembler CheckinVOs = new ValueObjectAssembler (); 
        
        ValueObject CheckinVO   = new ValueObject ();
        ValueObject CheckoutVO  = new ValueObject ();
        
        CheckinVO.set("userid"        , sUserId);
        CheckinVO.set("instcd"        , sInstCd);   
        CheckinVO.set("sessuserid"    , sUserId);
        CheckinVO.set("sessinstcd"    , sInstCd);   

        CheckinVO.set("insukind"           ,ptinVO.getString("ptin_insukind"));            //��������                   
        CheckinVO.set("suppkind"           ,ptinVO.getString("ptin_suppkind"));            //��������                   
        CheckinVO.set("insucd"             ,ptinVO.getString("ptin_insucd"));              //�������ڵ�                
        CheckinVO.set("suppkindresn"       ,ptinVO.getString("ptin_suppkindresn"));        //������������            
        CheckinVO.set("todd"               ,ptinVO.getString("ptin_todd"));                //��������                  
        CheckinVO.set("fromdd"             ,ptinVO.getString("ptin_fromdd"));              //��������                  
        CheckinVO.set("insuno"             ,ptinVO.getString("ptin_insuno"));              //��������ȣ                
        CheckinVO.set("insdnm"             ,ptinVO.getString("ptin_insdnm"));              //�Ǻ����ڸ�               
        CheckinVO.set("insdrrgstno1"       ,ptinVO.getString("ptin_insdrrgstno1"));        //�Ǻ������ֹι�ȣ1     
        CheckinVO.set("insdrrgstno2"       ,ptinVO.getString("ptin_insdrrgstno2"));        //�Ǻ������ֹι�ȣ2     
        CheckinVO.set("insdrela"           ,ptinVO.getString("ptin_insdrela"));            //�Ǻ����ڰ���            


        //��������                                                                                                                                                                  
        CheckinVO.set("disccd"                 ,otptVO.getString("otpt_disccd"));          //�����ڵ�                                                                                                                    
        //�ܷ��������                                                                                                                                                                                                              
        CheckinVO.set("histstat"               ,otptVO.getString("otpt_histstat"));        //��������                                                                                                                    
        CheckinVO.set("pid"                    ,otptVO.getString("otpt_pid"));             //��Ϲ�ȣ                                                                                                                    
        CheckinVO.set("orddd"                  ,otptVO.getString("otpt_orddd"));           //��������                                                                                                                    
        CheckinVO.set("cretno"                 ,otptVO.getString("otpt_cretno"));          //������ȣ
        CheckinVO.set("calcbaseflag"           ,calcbaseflag);                             //�ǽ����꿩�α���
        CheckinVO.set("acptseqno"              ,otptVO.getString("otpt_acptseqno"));       //����Ϸù�                                                                                                                 
        CheckinVO.set("specordyn"              ,otptVO.getString("otpt_specordyn"));                  //�������Ῡ��                                                                                                              
        CheckinVO.set("fsexamflag"             ,otptVO.getString("otpt_fsexamflag"));                 //����������                                                                                                                 
        CheckinVO.set("fsexammanlyn"           ,otptVO.getString("otpt_fsexammanlyn"));               //�����������ο�����                                                                                                     
        CheckinVO.set("medamtestmyn"           ,otptVO.getString("otpt_medamtestmyn"));               //�������������                                                                                                           
        CheckinVO.set("medamtpostyn"           ,otptVO.getString("otpt_medamtpostyn"));               //�������ĺҿ���                                                                                                           
        CheckinVO.set("medamtfreeresn"         ,otptVO.getString("otpt_medamtfreeresn"));             //������������� ������ �������ΰ� N=�̻���,�����϶� �̻��� ����(�ڵ屺 P1061 ����)         
        CheckinVO.set("etcordflag"             ,otptVO.getString("otpt_etcordflag"));                 //��Ÿ���ᱸ��(�ڵ屺 P0022 ����) J:�ֻ�  M:����ġ��, F:����, N:������ȣ                          
        CheckinVO.set("handicaprbookpossnyn"   ,otptVO.getString("otpt_handicaprbookpossnyn"));       //����μ�ø��������                                                                                                     
        CheckinVO.set("ordreqformflag"         ,otptVO.getString("otpt_ordreqformflag"));             //�����Ƿڼ����ⱸ��                                                                                                     
        CheckinVO.set("clincstdyacptflag"      ,otptVO.getString("otpt_clincstdyacptflag"));          //�ӻ󱸺�                                                                                                                    
        CheckinVO.set("calcmthdflag"           ,sCalcMthdFlag);                                                                                                                                                                                  
        CheckinVO.set("calcgubn"               ,calcgubn);                                            //calcgubn ���:Y      ������:N                                                                                     
        CheckinVO.set("calcstat"               ,calcstat);                                            //calcstat ����ȭ��:R  ����ȭ��:Y                                                                                    
        CheckinVO.set("workgubn"               ,workgubn);                                            //workgubn ����ȭ��:Y  ����ȭ��:N �ǽ�����: E                                                                  
        CheckinVO.set("hosoutexptresncd"       ,otptVO.getString("otpt_hosoutexptresncd"));           //���ܿ��ܻ����ڵ�
		CheckinVO.set("rsrvflag"			   ,otptVO.getString("otpt_rsrvflag"));					  //���౸��
        CheckinVO.set("rareobstflag"           ,otptVO.getString("otpt_rareobstflag"));               //��ͳ�ġ                                                                                                                   
        CheckinVO.set("ownbflag"               ,otptVO.getString("otpt_ownbflag"));                   //���κδ㱸��                                                                                                              
        CheckinVO.set("refundyn"               ,refundyn);                                            //ȯ�ҿ���                                                                                                                    
        CheckinVO.set("calcflag_org"           ,otptVO.getString("otpt_calcflag_org"));               //��꿩��_org �ѹ�� ����.                                                                                            

        //�̵���20071206 ��걸��(����� �߰��Ǹ鼭 ������� ����������������)
        if (StringHelper.strEquals(calcgubn,"Y") || StringHelper.strEquals(calcgubn,"E")) {
            
            int iCount1=0; 
            
            CheckinVO.set("calcyn"      ,"Y");
            CheckinVO.set("calcflag"    , calcflag);   
            CheckinVOs.set("Checkin"    , CheckinVO);
            CheckinVOs.set("ptin"       , ptinVO);

            try {
                
                pCalcVO.set("brthdd"             , ptbsVO.getString("ptbs_brthdd"));              // �������          
                pCalcVO.set("rrgstno1"           , ptbsVO.getString("ptbs_rrgstno1"));            // �ֹι�ȣ1        
                pCalcVO.set("rrgstno2"           , ptbsVO.getString("ptbs_rrgstno2"));            // �ֹι�ȣ2        
                                                                                                                
                pCalcVO.set("pid"                , ptbsVO.getString("ptbs_pid"));                 //��Ϲ�ȣ                                                                         
                pCalcVO.set("orddd"              , otptVO.getString("otpt_orddd"));               //��������          
                pCalcVO.set("cretno"             , otptVO.getString("otpt_cretno"));              //������ȣ           
                pCalcVO.set("acptseqno"          , otptVO.getString("otpt_acptseqno"));           //����Ϸù�ȣ    
                pCalcVO.set("instcd"             , sInstCd);                                      //����ڵ�           
                pCalcVO.set("sessinstcd"        , sInstCd);                                                                                                
                pCalcVO.set("histstat"           , otptVO.getString("otpt_histstat"));            //�̷»���           
                pCalcVO.set("orgorddd"           , otptVO.getString("otpt_orgorddd"));            //����������       
                pCalcVO.set("orgcretno"          , otptVO.getString("otpt_orgcretno"));           //�����������ȣ
                pCalcVO.set("calcbaseflag"       , calcbaseflag);                                 //�ǽ����꿩�α���
                pCalcVO.set("calcyn"             , otptVO.getString("otpt_calcyn"));              //���꿩��          
                                                                                                                
                pCalcVO.set("ordtm"              , otptVO.getString("otpt_ordtm"));               //����ð�           
                pCalcVO.set("orddeptcd"          , otptVO.getString("otpt_orddeptcd"));           //������ڵ�        
                pCalcVO.set("orddrid"            , otptVO.getString("otpt_orddrid"));             //������ID           
                pCalcVO.set("dutdeptcd"          , otptVO.getString("otpt_dutdeptcd"));           //�ٹ��μ��ڵ�     
                                                                                                                
                pCalcVO.set("centcd"             , otptVO.getString("otpt_centcd"));              //�����ڵ�           
                pCalcVO.set("supdeptcd"          , otptVO.getString("otpt_supdeptcd"));           //�����μ��ڵ�    
                pCalcVO.set("mskind"             , otptVO.getString("otpt_mskind"));              //�ֺ�����           
                                                                                                                
                pCalcVO.set("insukind"          , ptinVO.getString("ptin_insukind"));             //��������          
                pCalcVO.set("suppkind"          , ptinVO.getString("ptin_suppkind"));             //��������          
                pCalcVO.set("insucd"            , ptinVO.getString("ptin_insucd"));               //�������ڵ�       
                pCalcVO.set("suppkindresn"      , ptinVO.getString("ptin_suppkindresn"));         //������������     
                pCalcVO.set("disccd"            , StringHelper.null2string(otptVO.getString("otpt_disccd"), "-"));               //�����ڵ�          
                                                                                                  
                pCalcVO.set("specordyn"                    , otptVO.getString("otpt_specordyn"));               //�������Ῡ��                                                                                                       
                pCalcVO.set("fsexamflag"                   , otptVO.getString("otpt_fsexamflag"));              //����������                                                                                                          
                pCalcVO.set("fsexammanlyn"                 , otptVO.getString("otpt_fsexammanlyn"));            //�����������ο�����                                                                                              
                pCalcVO.set("medamtestmyn"                 , otptVO.getString("otpt_medamtestmyn"));            //�������������                                                                                                    
                pCalcVO.set("medamtpostyn"                 , otptVO.getString("otpt_medamtpostyn"));            //�������ĺҿ���                                                                                                   
                pCalcVO.set("medamtfreeresn"               , otptVO.getString("otpt_medamtfreeresn"));          //������������� ������ �������ΰ� N=�̻���,�����϶� �̻��� ����(�ڵ屺 P1061 ����)  
                pCalcVO.set("etcordflag"                   , otptVO.getString("otpt_etcordflag"));              //��Ÿ���ᱸ��(�ڵ屺 P1072 ����) J:�ֻ�  M:����ġ��, F:����, N:������ȣ                     
                pCalcVO.set("handicaprbookpossnyn"         , otptVO.getString("otpt_handicaprbookpossnyn"));    //����μ�ø��������        
                pCalcVO.set("ordreqformflag"               , otptVO.getString("otpt_ordreqformflag"));          //�����Ƿڼ����ⱸ��    
                pCalcVO.set("clincstdyacptflag"            , otptVO.getString("otpt_clincstdyacptflag"));       //�ӻ������������
                                                                                                  
                pCalcVO.set("holiflag"                     , otptVO.getString("otpt_holiflag"));                //�����ϱ���                     
                pCalcVO.set("ordtype"                      , otptVO.getString("otpt_ordtype"));                 //��������                        
                pCalcVO.set("brateflag"                    , otptVO.getString("otpt_brateflag"));               //�δ������                     
                pCalcVO.set("rsrvflag"                     , otptVO.getString("otpt_rsrvflag"));                //���౸��                        
                pCalcVO.set("hosoutexptresncd"             , otptVO.getString("otpt_hosoutexptresncd"));        //���ܿ��ܻ����ڵ�            
                pCalcVO.set("clincstdyno"                  , otptVO.getString("otpt_clincstdyno"));             //�ӻ�����ȣ                  
                pCalcVO.set("chrtlendyn"                   , otptVO.getString("otpt_chrtlendyn"));              //íƮ���⿩��                  
                pCalcVO.set("specorddescyn"                , otptVO.getString("otpt_specorddescyn"));           //�������ἳ����            
                pCalcVO.set("ordreqdescyn"                 , otptVO.getString("otpt_ordreqdescyn"));            //�����Ƿڼ�������         
                pCalcVO.set("ordreqhospgrde"               , otptVO.getString("otpt_ordreqhospgrde"));          //�����Ƿڼ����������   
                                                                                                                                                                              
                pCalcVO.set("insuchrgyn"                   , otptVO.getString("otpt_insuchrgyn"));              //����ȸ�����ڿ���         
                pCalcVO.set("pamacptyn"                    , otptVO.getString("otpt_pamacptyn"));               //������������                  
                pCalcVO.set("pamacptdt"                    , otptVO.getString("otpt_pamacptdt"));               //���������Ͻ�                  
                pCalcVO.set("pamacptid"                    , otptVO.getString("otpt_pamacptid"));               //����������ID                   
                pCalcVO.set("nursacptyn"                   , otptVO.getString("otpt_nursacptyn"));              //��ȣ����������               
                pCalcVO.set("nursacptdt"                   , otptVO.getString("otpt_nursacptdt"));              //��ȣ�������Ͻ�               
                pCalcVO.set("dracptyn"                     , otptVO.getString("otpt_dracptyn"));                //�ǻ���������                  
                pCalcVO.set("dracptdt"                     , otptVO.getString("otpt_dracptdt"));                //�ǻ������Ͻ�                  
                pCalcVO.set("prcpgenryn"                   , otptVO.getString("otpt_prcpgenryn"));              //ó��߻�����                  
                                                                                                                                  
                pCalcVO.set("prcpnotoccrresn"              , otptVO.getString("otpt_prcpnotoccrresn"));          //ó��̹߻������ڵ�            
                pCalcVO.set("estmspclappyn"                , otptVO.getString("otpt_estmspclappyn"));            //����Ư�����뿩��              
                //pCalcVO.set("calcflag"                   , otptVO.getString("otpt_calcflag"));               
                pCalcVO.set("calcflag"                     , calcflag);                                          //��걸��
                pCalcVO.set("calcmthdflag"                 , sCalcMthdFlag);                                     //���������
                pCalcVO.set("prcpgenryn"                   , otptVO.getString("otpt_prcpgenryn"));               //ó���������
                pCalcVO.set("rqsthospcd"                   , otptVO.getString("otpt_rqsthospcd"));               //�����Ƿ���ID                  
                pCalcVO.set("ermngtamtcalcyn"              , otptVO.getString("otpt_ermngtamtcalcyn"));          //�������а������������        
                pCalcVO.set("erbrthflag"                   , otptVO.getString("otpt_erbrthflag"));               //���޺и�����                  
                pCalcVO.set("erchospath"                   , otptVO.getString("otpt_erchospath"));               //���޳������                  
                pCalcVO.set("erorddeptcd"                  , otptVO.getString("otpt_erorddeptcd"));              //���������                    
                pCalcVO.set("erjudgstat"                   , otptVO.getString("otpt_erjudgstat"));               //���޽ɻ����                  
                                                                                                                                  
                pCalcVO.set("eroutrmnotidt"                , otptVO.getString("otpt_eroutrmnotidt"));          //��������뺸�Ͻ�              
                pCalcVO.set("eroutrmdt"                    , otptVO.getString("otpt_eroutrmdt"));              //��������Ͻ�                  
                pCalcVO.set("lastrcptendyn"                , otptVO.getString("otpt_lastrcptendyn"));          //���������ϷῩ��              
                pCalcVO.set("tdayinyn"                     , otptVO.getString("otpt_tdayinyn"));               //�����Կ�����                  
                pCalcVO.set("tranindd"                     , otptVO.getString("otpt_tranindd"));               //��ȯ�Կ�����                  
                pCalcVO.set("rcptdd"                       , otptVO.getString("otpt_rcptdd"));                 //��������                      
                pCalcVO.set("rcptno"                       , otptVO.getString("otpt_rcptno"));                 //��������ȣ                    
                pCalcVO.set("rcptseqno"                    , otptVO.getString("otpt_rcptseqno"));              //�������Ϸù�ȣ                
                                                                                                                                  
                pCalcVO.set("telrsrvrem"                   , otptVO.getString("otpt_telrsrvrem"));           //��ȭ�����������              
                pCalcVO.set("bforddd"                      , otptVO.getString("otpt_bforddd"));              //������������                  
                pCalcVO.set("bfordtm"                      , otptVO.getString("otpt_bfordtm"));              //��������ð�                  
                pCalcVO.set("bforddeptcd"                  , otptVO.getString("otpt_bforddeptcd"));          //����������ڵ�                
                pCalcVO.set("bforddrid"                    , otptVO.getString("otpt_bforddrid"));            //����������ID                  
                pCalcVO.set("updtcnclresn"                 , otptVO.getString("otpt_updtcnclresn"));         //������һ���                  
                pCalcVO.set("fstacptid"                    , otptVO.getString("otpt_fstacptid"));            //����������ID                  
                pCalcVO.set("fstacptdt"                    , otptVO.getString("otpt_fstacptdt"));            //���������Ͻ�                  
                pCalcVO.set("fstrgstrid"                   , otptVO.getString("otpt_fstrgstrid"));           //���ʵ����ID                  
                pCalcVO.set("fstrgstdt"                    , otptVO.getString("otpt_fstrgstdt"));            //���ʵ���Ͻ�                  
                pCalcVO.set("lastupdtrid"                  , otptVO.getString("otpt_lastupdtrid"));          //����������ID                  
                pCalcVO.set("lastupdtdt"                   , otptVO.getString("otpt_lastupdtdt"));           //���������Ͻ�                         
                pCalcVO.set("ownbflag"                     , otptVO.getString("otpt_ownbflag"));             //���κδ㱸��
                pCalcVO.set("tranflag"                     , otptVO.getString("otpt_tranflag"));             //�Կ��ܷ�����
                pCalcVO.set("rareobstflag"                 , otptVO.getString("otpt_rareobstflag"));         //��ͳ�ġ
                                                                                               
                pCalcVO.set("calcactflag"                  , sCalcActFlag );                                 //�����౸��(1:����, 2:�����ļ���)                                                                    
                pCalcVO.set("sessuserid"                   , sUserId);                                       //������    

                pCalcVO.set("drcm_qualflag"                , otptDtlVO.getString("drcm_qualflag"));          //pmohdrcm �ǻ�Ұ߼� ���κδ㱸��
                pCalcVO.set("hocm_qualflag"                , otptDtlVO.getString("hocm_qualflag"));          //pmohhocm �湮��ȣ���ü� ���κδ㱸��
                pCalcVO.set("workgubn"                     , workgubn);                                      //workgubn ����ȭ��:Y  ����ȭ��:N
                pCalcVO.set("spclcd"                       , otptVO.getString("otpt_spclcd"));            	 //Ư�ʱ�ȣ. 2011.05.03 syjung �߰�

                //2013-01-18 ������ü ���鳻�� ��������
                //���ο� ������ü ������ �ְų�, ������ü ���� �÷��װ� ������ 
                //������꿡�� ������ü �������� ������ ���� ����.
                if( bldcVOS.size() > 0 || StringHelper.strEquals(setbldccalc, "Y")){
                	pCalcVO.set("bldcdiscamtdelyn"		, "N");						//������ü ����ݾ� ��������
                }
                
                //if((StringHelper.strEquals(refundyn,"�������") &&  StringHelper.strEquals(otptVO.getString("otpt_prcpgenryn"),"1A"))) {
                //if((StringHelper.strEquals(refundyn,"�������"))) {
                int prcpCnt = outrcptmngtDAO.getExopActList(pCalcVO).size();
                if ( ((StringHelper.strEquals(pCalcVO.getString("etcordflag"),"M")  && StringHelper.strEquals(pCalcVO.getString("medamtestmyn"),"N")) ||

   	                 (StringHelper.strEquals(pCalcVO.getString("etcordflag"),"J")   && StringHelper.strEquals(pCalcVO.getString("medamtestmyn"),"N")) ||

   	                 (StringHelper.strEquals(pCalcVO.getString("etcordflag"),"T")   && StringHelper.strEquals(pCalcVO.getString("medamtestmyn"),"N")  && StringHelper.strEquals(pCalcVO.getString("orddeptcd"),"2170000000")) ||

   	                 (StringHelper.strEquals(pCalcVO.getString("rsrvflag"),"A")      && StringHelper.strEquals(pCalcVO.getString("medamtestmyn"),"N")  && StringHelper.strEquals(pCalcVO.getString("specordyn"),"N")) ||

   	                 (StringHelper.strEquals(refundyn ,"�������")) )
   	                 
   	                 && prcpCnt == 0
                ) {
                    outrcptmngtDAO.delOsclCancel(otptVO);
                    
                }else{

                    if(StringHelper.strEquals(otptVO.getString("otpt_calcbaseflag"),"1")){
                        osclVO = outcalc.OutCalculation(pCalcVO);    //�ܷ����
                    }
                    if(StringHelper.strEquals(otptVO.getString("otpt_calcbaseflag"),"2")){
                        osclVO = outcalc.exeOutCalc(pCalcVO);        //�ǽ�����
                    }
                    
                    //������ü ���� ����ݾ� ����
                    if( bldcVOS.size() > 0 
                    	&& StringHelper.strEquals(pCalcVO.getString("bldcdiscamtdelyn"), "N") 
                    	&& !StringHelper.strEquals(pCalcVO.getString("disccd"), "-")){
                    	
                    	outcalc.delBldcDiscamt(bldcVOS);
                    }
                    
                }

                //���� oscl�� ��ȭ�� �־�� calcflag ������Ʈ ģ��.
                if(osclVO.size() == 0 && StringHelper.strEquals(workgubn, "N")){ 
                    throw new LiveException("����� ��곻���� �����ϴ�.");
                 }
                  
                //�ݾ���ȸ�� ���� input VO 
                ValueObject otptInVO = new ValueObject();
                ValueObject ptinInVO = new ValueObject();
   
                otptInVO.set("pid"                       , otptVO.getString("otpt_pid"));                                                                                           
                otptInVO.set("orddd"                     , otptVO.getString("otpt_orddd"));                                                                                       
                otptInVO.set("cretno"                    , otptVO.getString("otpt_cretno"));                                                                                      
                otptInVO.set("acptseqno"                 , otptVO.getString("otpt_acptseqno"));                                                                                 
                otptInVO.set("orgorddd"                  , otptVO.getString("otpt_orgorddd"));             //orgorddd ,orgcretno �� ������� ��ȸ                  
                otptInVO.set("orgcretno"                 , otptVO.getString("otpt_orgcretno"));                                                                                  
                otptInVO.set("orddeptcd"                 , otptVO.getString("otpt_orddeptcd"));                                                                                 
                otptInVO.set("orddrid"                   , otptVO.getString("otpt_orddrid"));
                otptInVO.set("centcd"                    , otptVO.getString("otpt_centcd"));               //�����ڵ�
                otptInVO.set("ordtype"                   , otptVO.getString("otpt_ordtype"));                                                                                     
                otptInVO.set("mskind"                    , otptVO.getString("otpt_mskind"));                                                                                      
                otptInVO.set("calcmthdflag"              , otptVO.getString("otpt_calcmthdflag"));                                                                              
                otptInVO.set("calcyn"                    , otptVO.getString("otpt_calcyn"));               //������� ��ȸ ���� �ʿ�                                   
                otptInVO.set("rareobstflag"              , otptVO.getString("otpt_rareobstflag"));                                                                               
                otptInVO.set("rcptdd"                    , otptVO.getString("otpt_rcptdd"));                                                                                      
                otptInVO.set("rcptno"                    , otptVO.getString("otpt_rcptno"));                                                                                      
                otptInVO.set("rcptseqno"                 , otptVO.getString("otpt_rcptseqno"));                                                                                  
                otptInVO.set("calcstat"                  , calcstat);                                      //calcstat ����ȭ��:R  ����ȭ��:Y
                otptInVO.set("calcgubn"                  , calcgubn);                                      //calcgubn      ���:    Y ������:N
                otptInVO.set("calcbaseflag"              , calcbaseflag);                                  //�����ر���  1: ����  2,3: �ǽ�����и�
                //otptInVO.set("calcflag"                , otptVO.getString("otpt_calcflag"));
                otptInVO.set("calcflag"                  , calcflag);                                      //��걸��      Y:�̰�� S:��� N:����
                otptInVO.set("etcordflag"                , otptVO.getString("otpt_etcordflag"));                                                                                  
                otptInVO.set("sessinstcd"                , sInstCd);                                                                                                                     
                otptInVO.set("sessuserid"                , sUserId);                                                                                                                     
                otptInVO.set("workgubn"                  , workgubn);                                      //workgubn ����ȭ��:Y  ����ȭ��:N �ǽ�����: E           
                otptInVO.set("specordyn"                 , otptVO.getString("otpt_specordyn"));                                                                                 
                otptInVO.set("rareobstflag"              , otptVO.getString("otpt_rareobstflag"));          //��ͳ�ġ                                                       
                otptInVO.set("ownbflag"                  , otptVO.getString("otpt_ownbflag"));              //���κδ㱸��                                                
                otptInVO.set("handicaprbookpossnyn"      , otptVO.getString("otpt_handicaprbookpossnyn"));  //����μ�ø��������
                otptInVO.set("refundyn"                  , refundyn);                                       //ȯ�ҿ���

                otptInVO.set("nursacptyn"                , otptVO.getString("otpt_nursacptyn"));            //��ȣ��������
                otptInVO.set("dracptyn"                  , otptVO.getString("otpt_dracptyn"));              //�ǻ���������
                otptInVO.set("prcpgenryn"                , otptVO.getString("otpt_prcpgenryn"));            //ó��߻�����
                otptInVO.set("insukind"                  , ptinVO.getString("ptin_insukind"));              //��������          
                otptInVO.set("suppkind"                  , ptinVO.getString("ptin_suppkind"));              //��������          
                otptInVO.set("insucd"                    , ptinVO.getString("ptin_insucd"));                //�������ڵ�
                otptInVO.set("ordreqformflag"            , otptVO.getString("otpt_ordreqformflag"));        //��������
                otptInVO.set("estmspclappyn"             , otptVO.getString("otpt_estmspclappyn"));         //����Ư�����뿩��
                otptInVO.set("spclcd"                    , otptVO.getString("otpt_spclcd"));                //vcode
                otptInVO.set("subdeptcd"                 , otptVO.getString("otpt_subdeptcd"));             //���ΰ�
                otptInVO.set("coopteamcd"                , otptVO.getString("otpt_coopteamcd"));            //�������ڵ�
                otptInVO.set("medamtestmyn"              , otptVO.getString("otpt_medamtestmyn"));          //�������������
                otptInVO.set("rsrvflag"                  , otptVO.getString("otpt_rsrvflag"));              //���౸��
                otptInVO.set("specordyn"                 , otptVO.getString("otpt_specordyn"));             //���������뿩��
                otptInVO.set("disccd"                 	, otptVO.getString("otpt_disccd"));             //�����ڵ�

                ptinInVO.set("insukind"                  , ptinVO.getString("ptin_insukind"));
                ptinInVO.set("suppkind"                  , ptinVO.getString("ptin_suppkind"));
                ptinInVO.set("insucd"                    , ptinVO.getString("ptin_insucd"));
                
                if ( log.isDebugEnabled() ) {           
                    log.debug("**----�������� Ȯ�� ------**  " );
                    log.debug("**----insukind ------**  "   + ptinInVO.getString("insukind"));
                    log.debug("**----suppkind ------**  "   + ptinInVO.getString("suppkind"));
                    log.debug("**----insucd ------**    "   + ptinInVO.getString("insucd"));
                    
                    log.debug("**----ptin_insukind ------**  "  + ptinVO.getString("ptin_insukind"));
                    log.debug("**----ptin_suppkind ------**  "  + ptinVO.getString("ptin_suppkind"));
                    log.debug("**----ptin_insucd ------**    "  + ptinVO.getString("ptin_insucd"));
                }
                
                ptinInVO.set("orddd", otptVO.getString("otpt_orddd"));
                ptinInVO.set("sessinstcd", sInstCd);
                ptinInVO.set("sessuserid", sUserId);   
                            
                inpVOs.set("otpt", otptInVO);
                inpVOs.set("ptin", ptinInVO);

                opmiVO = getOpmiInfo(inpVOs,"���");             //������ �ݾ� ��ȸ 
                earnVO = this.getEarnInfo2(otptInVO);            //��������� ���ͳ��� ��ȸ
                cardVO = this.getcardList(opmiVO);               //��ī��
                cashVO = this.getcashList(opmiVO);               //������
                onlnVO = this.getonlnList(opmiVO);               //������   
                bldcVO = this.getbldcList(opmiVO);               //�������ü
                dcgmVO = this.getdcgmList(opmiVO);               //�Ⱘ��
                uncoVO = this.getuncoList(opmiVO);               //��̼�
                
                otptVO = insChangeHist(CheckinVOs);              //�ܷ���ϳ��� ���º���,������ �ܷ���ϳ��� �о�´� �������Ϸ� �ڷλ���

                ptinVO = insChangePtin(CheckinVOs);              //�ܷ����賻�� ���º���,������ �ܷ����賻�� �о�´�
                
                retVOs.set("oscl", outrcptmngtDAO.getOsclInfo(otptInVO));  //��곻�� ��ȸ
                retVOs.set("opmi", opmiVO);  //�δ�� ����� �������� view�� ���� ��������� ����
                retVOs.set("earn", earnVO);  //��������
                retVOs.set("card", cardVO);  //��ī��
                retVOs.set("cash", cashVO);  //������
                retVOs.set("onln", onlnVO);  //������
                retVOs.set("bldc", bldcVO);  //�������ü
                retVOs.set("dcgm", dcgmVO);  //�Ⱘ��
                retVOs.set("unco", uncoVO);  //��̼�

                //retVOs.set("otpt", otptInVO);
                retVOs.set("otpt", otptVO);
                retVOs.set("ptin", ptinVO);

                chkVOs.set("otpt",otptInVO);  
                chkVOs.set("oscl",osclVO); 
                chkVOs.set("bldc",bldcVO); 
                retVOs.set("msg", this.outOrd_Check(chkVOs ,"���" , sInstCd , sUserId));  //�ܷ����� �⺻üũ����

                // Ŭ���̾�Ʈ�� ������ ���� ó�� �޽��� ����.
                getServiceContext().setMessage(
                        Messages.getMessages().getMessage(
                                "com.info.00007",
                                new Integer[] { Integer.valueOf(osclVO.size())}));
                
                } catch (Exception ex) {
                    
                    setRollbackOnly();
                    
                    if (ex instanceof LiveException) {
                        throw (LiveException) ex;
                    } else {
                        throw new LiveException("com.error.90000", ex);
                    }
                }

        } else {
            CheckinVOs.set("Checkin", CheckinVO);
            CheckinVOs.set("ptin", ptinVO);     
            
            CheckoutVO = insChangeHist(CheckinVOs);
            
            if (CheckoutVO.size() > 0) {
                //�ű� ��ȸ�� ��������  otptVO ��ü
                otptVO = CheckoutVO;
            }           
        }

        return retVOs;
    }
	
	
	/*
	 * (��Javadoc)
	 * �ܷ�������ȸ(�ܷ����Ű ��������)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getopmiList3(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getopmiList3(ValueObject pVO) throws LiveException{
		
        //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getopmiList3(pVO);
		
	}	
	
	
	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getOtptInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOtptInfo(ValueObject pVO) throws LiveException{
		
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getOtptInfo(pVO);
		
	}	

	
	/*
	 * (��Javadoc)
	 * �ܷ����� ó��
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#setOutOrdAmtRcpt(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObjectAssembler setOutOrdAmtRcpt(ValueObjectAssembler pVOs) throws LiveException {
		if ( log.isDebugEnabled() ) {
	   		 log.debug("**----�ܷ� ����  mgt  start   setOutOrdAmtRcpt ------**  " ); 
		}
		
	   String otpt_histstat = "";
       String sInstCd = "";
       String sUserId = "";

       //���μ����� ���� �ڵ�- ���μ������� instcdVo�� �ް� �Ϲݼ����� �������� ���� 
       if (pVOs.isExist("instcd")) {
           sInstCd = pVOs.get("instcd").getString("sessinstcd");
           sUserId = pVOs.get("instcd").getString("sessuserid");
       }else{
           sInstCd = StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE));
           sUserId = StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID));
       }

		ValueObject ptbsVO  = new ValueObject();
		ValueObject otptVO  = new ValueObject();	
		ValueObject opmiVO  = new ValueObject();	
		ValueObject cardVO  = new ValueObject();	
		ValueObject cashVO  = new ValueObject();	
		ValueObject onlnVO  = new ValueObject(); 	
		ValueObject uncoVO  = new ValueObject();	
		ValueObject dcgmVO 	= new ValueObject();    
		ValueObject bogjVO  = new ValueObject(); 	
		ValueObject bldcVO  = new ValueObject();
		ValueObject codeVO  = new ValueObject();
		ValueObject drugVO  = new ValueObject();
		

        if(pVOs.isExist("otpt")) {  //ȯ�ڱ⺻���� �� ��������   
			otptVO = pVOs.get("otpt");     
		}

        if(pVOs.isExist("ptbs")) {  //ȯ�ڱ⺻���� �� ��������   
			ptbsVO = pVOs.get("ptbs");     
		}
        if(pVOs.isExist("opmi")) {  //��������(��������) 
			opmiVO = pVOs.get("opmi");      
			opmiVO.set("sessinstcd"  , sInstCd);
			opmiVO.set("sessuserid"  , sUserId);
		}
        if(pVOs.isExist("card")) { //ī���������  
			cardVO = pVOs.get("card");       
		}

        if(pVOs.isExist("cash")) {  //���ݿ���������    	
			cashVO = pVOs.get("cash");      
		}
        if(pVOs.isExist("onln")) { //�����Աݳ���   
			onlnVO = pVOs.get("onln");     
		}
        if(pVOs.isExist("unco")) {//�̼�����       
			uncoVO = pVOs.get("unco");       
		}
        if(pVOs.isExist("dcgm")) {//����/���鳻��   
			dcgmVO = pVOs.get("dcgm");        
		}
        if(pVOs.isExist("bogj")) {//�����ݴ�ü����   
			bogjVO = pVOs.get("bogj");       
		}
        if(pVOs.isExist("bldc")) {//���������γ��� 
			bldcVO = pVOs.get("bldc");       
		}
        if(pVOs.isExist("opmi")) {//�ܷ������� ��ϳ�����ȸ
			otptVO = outrcptmngtDAO.getRcptOtptList(opmiVO);    
			
			/**2012-08-27 �߰�
			*�ܷ������� ��������� ������ȯ�� Ư���ڵ� �ڵ��Է·��� �߰�
			*��������û. �Ǻ������϶� Ư���ڵ� �ڵ��Է�.
			*���������ڵ���(PK009) üũ��� ��������(CDNM)/ ������������(DETLDESC)
			*�����ڵ����̺�(PMCMCODE), Ư�ʸ�����(PICMESSC), �󺴸�����(EMR.MMOHDIAG) üũ�ؼ�
			*�´� ������ ������ �ش� Ư���ڵ带 otpt�� ������Ʈ �Ѵ�. 
			*/
			if( otptVO.size() > 0 ){
				outrcptmngtDAO.setSpclcd(otptVO);    
				
				//throw new LiveException("New Test")	;
			}
		}

		ValueObjectAssembler retVOs = new ValueObjectAssembler ();  //������� return�� VOs
		ValueObject trcptnoVO = new ValueObject();                  //��������ȣ ä�� ���� input para VO
		ValueObject rcptnoVO  = null;
		ValueObject tmpOtpt   = new ValueObject ();                 //���걸�� üũ���� �ܷ���ϳ��� VO
		
		try {
			
			int iRcptNo = 0;			
			
			//��������ȣ ä�� ���� input para ����
			trcptnoVO.set("rcptdd", opmiVO.getString("opmi_rcptdd"));
			trcptnoVO.set("instcd", sInstCd);
			//��������ȣ ä��-����:�߻�����
			rcptnoVO = getRcptNo(trcptnoVO);
			iRcptNo =  Integer.parseInt(rcptnoVO.getString("rcptno"));  //ä������ Sequence
			
			//�ܷ������ ��������ȣ, ������ �Ϸù�ȣ(�����ÿ��� �Ϸù�ȣ 1)
			opmiVO.set("opmi_rcptno"      , iRcptNo);
			opmiVO.set("opmi_rcptseqno"   , "1");
			opmiVO.set("opmi_rcptrid"     , sUserId);
			opmiVO.set("opmi_fstrgstrid"  , sUserId);
			opmiVO.set("opmi_lastupdtrid" , sUserId);
			opmiVO.set("sessinstcd"       , sInstCd);							 
			opmiVO.set("sessuserid"       , sUserId);

			opmiVO.set("opmi_orgorddd"    , otptVO.getString("orgorddd"));
			opmiVO.set("opmi_etcordflag"  , otptVO.getString("etcordflag"));
			
			//�ǻ�����N�̸� �̼����걸�п� 1A ���� , Y�̸� 1B ����
			if(StringHelper.strEquals(otptVO.getString("dracptyn"),"N")){
				opmiVO.set("opmi_uncorcptflag"       , "1A");
			}else{
				opmiVO.set("opmi_uncorcptflag"       , otptVO.getString("prcpgenryn"));
			}

			//�������� ����
			//---------------------------------------
			//�ش� �ܷ���ϳ����� ���걸���� �����̸�, 
			//�ش� �ܷ���ϳ����� ���걸���� �Ǻ��̸�, outrcptmngtDAO.insOutOrdAmt
			//---------------------------------------
			//�ܷ��������� �������� �ܷ���ϳ��� ��ȸ
			tmpOtpt = outrcptmngtDAO.getOtptInfo2(opmiVO);

			//���ó�� ���̽�(������üũ����,����,0������)
			//1.����ġ��,�ֻ翹���̸鼭 ������̻����̰� ó�� ���� ���
			//2.��缱�����а��̸鼭 ������̻����̰� ó����°��
			//3.�������� ������ ����Ѱ��
            if ( (StringHelper.strEquals(tmpOtpt.getString("otpt_etcordflag"),"M")  && StringHelper.strEquals(tmpOtpt.getString("otpt_medamtestmyn"),"N")) ||

                 (StringHelper.strEquals(tmpOtpt.getString("otpt_etcordflag"),"J")   && StringHelper.strEquals(tmpOtpt.getString("otpt_medamtestmyn"),"N")) ||

                 (StringHelper.strEquals(tmpOtpt.getString("otpt_etcordflag"),"T")   && StringHelper.strEquals(tmpOtpt.getString("otpt_medamtestmyn"),"N")  && StringHelper.strEquals(tmpOtpt.getString("otpt_orddeptcd"),"2170000000")) ||

                 (StringHelper.strEquals(tmpOtpt.getString("otpt_rsrvflag"),"A")      && StringHelper.strEquals(tmpOtpt.getString("otpt_medamtestmyn"),"N")  && StringHelper.strEquals(tmpOtpt.getString("otpt_specordyn"),"N")) ||

                 (StringHelper.strEquals(opmiVO.getString("opmi_refundyn") ,"�������"))

              ) {

					otptVO.set("sessinstcd" , sInstCd);

                    if(outrcptmngtDAO.getExopActList(otptVO).size() == 0) {
                        otpt_histstat = "X";
                        opmiVO.set("opmi_refundyn" , "Y");
                    }else{
                        otpt_histstat = "R";
                        opmiVO.set("opmi_refundyn" , "");
                    }

			} else {
				otpt_histstat = "R";
			}

			//�̼��Աݺ��� �����Ҷ�, �̼��߻����� �����Ҷ� ��踦 ���ؼ� refundyn�� S �־���
			if (StringHelper.strEquals(otpt_histstat,"R")                     && 
				StringHelper.strEquals(opmiVO.getString("opmi_refundyn"),"")  &&
			    !StringHelper.strEquals(outrcptmngtDAO.getUncoStatYCnt(opmiVO).getString("cnt"),"0")
			) {
				opmiVO.set("opmi_refundyn" ,"S");
			}

			//OPMI C,D����
			opmiVO.set("otpt_histstat" , otpt_histstat);

			if (outrcptmngtDAO.insOutOrdAmtDC(opmiVO) <0) throw new LiveException("??insOutOrdAmt:insOutOrdAmtDC => opmi dc ���� ���� ");   //D	
			if (outrcptmngtDAO.setOutOrdAmtC(opmiVO) <0)  throw new LiveException("??insOutOrdAmt:setOutOrdAmtC  => opmi y=>c ���� ���� "); //C
			
			//OSCL C,D����
			if (outrcptmngtDAO.insOSCLDC(opmiVO)<0) throw new LiveException("??  insOutOrdAmt: insOSCLDC => oscl dc ���� ���� ");
			if (outrcptmngtDAO.setOSCLC(opmiVO) <0) throw new LiveException("??  insOutOrdAmt: setOSCLC  => oscl y=>c ���� ���� ");
			
			//DCGM ����/����
			outrcptmngtDAO.insDcgmAmtDC(opmiVO);	//D
			outrcptmngtDAO.setDcgmAmtC(opmiVO);		//C
			
			//UNCO �̼�
			outrcptmngtDAO.insUncoAmtDC(opmiVO);	//D
			outrcptmngtDAO.setUncoAmtC(opmiVO);		//C
			
			//BLDC ������
			outrcptmngtDAO.insBldcAmtDC(opmiVO);	//D
			outrcptmngtDAO.setBldcAmtC(opmiVO);		//C
			
			//CARD ī��ݾ�
			outrcptmngtDAO.insCardAmtDC(opmiVO);	//D
			outrcptmngtDAO.setCardAmtC(opmiVO);		//C
	
			//CASH ���ݿ������ݾ�
			outrcptmngtDAO.insCashAmtDC(opmiVO);	//D
			outrcptmngtDAO.setCashAmtC(opmiVO);		//C

			//ONLN �����Աݾ�
			outrcptmngtDAO.insOnlnAmtDC(opmiVO);	//D
			outrcptmngtDAO.setOnlnAmtC(opmiVO);		//C
			
			//BOGJ �߰��ݾ�  �������� CD ��Ĩ�ϴ�. SUM�� SUM���θ� ����..CDġ�� ������ȭ�鿡�� �̻��ϰ� ���Դϴ�.
			//outrcptmngtDAO.insBogjAmtDC(opmiVO);	//D
			//outrcptmngtDAO.setBogjAmtC(opmiVO);	//C

			/////////�ǽ������ �����///////////
			/*
			if ( ptbsVO.isExist("workgubn") && StringHelper.strEquals(ptbsVO.getString("workgubn","") , "E")) {

					outrcptmngtDAO.insPreCashAmt(opmiVO);	//CASH �����ݿ����� �����
					outrcptmngtDAO.insPreCardAmt(opmiVO);	//CARD ��ī�� �����
					outrcptmngtDAO.insPreBogjAmt(opmiVO);	//BOGJ ���߰��ݾ� �����
					
			}
			*/
			/////////�ǽ������ ��///////////

			//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
			if ( log.isDebugEnabled() )  log.debug("**----�ܷ����/��꿡 �������� update  start----**  " ); 
					
			opmiVO.set("otpt_histstat",otpt_histstat);  //�������µ� ��Ұ����������ֱ⋚���� ��������
			setOutOrdAmtOsclOtpt(opmiVO);
			
			if("X".equals(otpt_histstat)){
                //���Ǽ� ���� START
        		ValueObject ocrprntVO = new ValueObject();
        		ocrprntVO.set("pid" 		, StringHelper.null2void(opmiVO.getString("opmi_pid")));
        		ocrprntVO.set("orddd" 		, StringHelper.null2void(opmiVO.getString("opmi_orddd")));
        		ocrprntVO.set("cretno" 		, StringHelper.null2void(opmiVO.getString("opmi_cretno")));
        		ocrprntVO.set("orddeptcd" 	, StringHelper.null2void(opmiVO.getString("opmi_orddeptcd")));
        		ocrprntVO.set("orddrid" 	, StringHelper.null2void(opmiVO.getString("opmi_orddrid")));
        		etcOutRgst.delOcrprntInfo(ocrprntVO);
                //���Ǽ� ���� END
			}
			

			if ( log.isDebugEnabled() ) log.debug("**----�ܷ����/��곻���� �������� update  end----**  " );
			//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


			if(StringHelper.strEquals(otpt_histstat,"R")) {
	
	
				if ( log.isDebugEnabled() ) log.debug("**---- �ű� OPMI ó��  START----**  " );	
					if (outrcptmngtDAO.insOutOrdAmt(opmiVO) <=0) throw new LiveException("??insOutOrdAmt:insOutOrdAmt=> opmi y ���� ���� ���� ");//Y
				if ( log.isDebugEnabled() ) log.debug("**---- �ű� OPMI ���� ó��  END----**  " );
		
				//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				if ( log.isDebugEnabled() ) log.debug("**---- �ű� CARD ���� ó��  START----**  " );
				
					if (cardVO.size() > 0) {			
						
						for( int i =0; i< cardVO.size() ; i++) {				
							
							ValueObject rowVO = cardVO.getRowAsVo(i);
							rowVO.set("rcptdd"     , DateHelper.getDay());
							rowVO.set("rcptexecdd" , DateHelper.getDay());
							rowVO.set("rcpttm"     , opmiVO.getString("opmi_rcpttm"));
							rowVO.set("rcptno"     , iRcptNo);
							rowVO.set("rcptseqno"  , "1");
							rowVO.set("sessinstcd" , sInstCd);							 
							rowVO.set("sessuserid" , sUserId);
							rowVO.set("orddd"      , opmiVO.getString("opmi_orddd"));
							rowVO.set("cretno"     , opmiVO.getString("opmi_cretno"));				
							
							if (insCardAmt(rowVO) <= 0) 
								throw new LiveException("pam.error.15022");
								//throw new LiveException("�ܷ�����-ī����� ������ �������� �ʾҽ��ϴ�.[15022]");
						}
					}
	
			
				if ( log.isDebugEnabled() ) log.debug("**---- �ű� CARD ���� ó��  END----**  " );
				//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				if ( log.isDebugEnabled() ) log.debug("**---- �ű� CASH ���� ó�� START----**  " );
				
					//���ݿ�����
					if (cashVO.size() > 0) {
	
							for( int i =0; i< cashVO.size() ; i++) {	
								
								ValueObject rowVO = cashVO.getRowAsVo(i);
								
								rowVO.set("rcptdd"     , DateHelper.getDay());
								rowVO.set("rcptexecdd" , DateHelper.getDay());
								rowVO.set("rcpttm"     , opmiVO.getString("opmi_rcpttm"));
								rowVO.set("rcptno"     , iRcptNo);
								rowVO.set("rcptseqno"  , "1");	
								rowVO.set("sessinstcd" , sInstCd);							 
								rowVO.set("sessuserid" , sUserId);
								rowVO.set("orddd"      , opmiVO.getString("opmi_orddd"));
								rowVO.set("cretno"     , opmiVO.getString("opmi_cretno"));	
															
								if (insCashAmt(rowVO) <= 0) 
									//throw new LiveException("pam.error.15023");
									throw new LiveException("�ܷ�����-���ݿ��������� ������ �������� �ʾҽ��ϴ�.[15023]");			
							}
					}
				if ( log.isDebugEnabled() ) log.debug("**---- �ű� CASH ���� ó�� END----**  " );
				//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				if ( log.isDebugEnabled() ) log.debug("**---- �ű� ONLINE ó��  START----**  " );	
		
					if (onlnVO.size() > 0 ) {
	
						for( int i =0; i< onlnVO.size() ; i++) {	
							
							ValueObject rowVO = onlnVO.getRowAsVo(i);
							rowVO.set("rcptdd"     , DateHelper.getDay());
							rowVO.set("rcptexecdd" , DateHelper.getDay());
							rowVO.set("rcpttm"     , opmiVO.getString("opmi_rcpttm"));
							rowVO.set("rcptno"     , iRcptNo);
							rowVO.set("rcptseqno"  , "1");
							rowVO.set("sessinstcd" , sInstCd);							 
							rowVO.set("sessuserid" , sUserId);	
							rowVO.set("orddd"      , opmiVO.getString("opmi_orddd"));
							rowVO.set("cretno"     , opmiVO.getString("opmi_cretno"));
							
							if (insOnlineAmt(rowVO) <= 0) 
								//throw new LiveException("pam.error.15021");
								throw new LiveException("�ܷ�����-�����Ա� ������ �������� �ʾҽ��ϴ�.[15021]");
						}
					}
	
				if ( log.isDebugEnabled() ) log.debug("**---- �ű� ONLINE ���� ó��  END----**  " );
				//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				if ( log.isDebugEnabled() ) log.debug("**---- �ű� UNCO ���� ó��  START----**  " );
				
					if (Integer.parseInt(opmiVO.getString("opmi_uncoamt")) != 0 ) {							
						
						for( int i =0; i< uncoVO.size() ; i++) {	
							
							ValueObject rowVO = uncoVO.getRowAsVo(i);
	
								rowVO.set("rcptdd"     , DateHelper.getDay());
								rowVO.set("rcptexecdd" , DateHelper.getDay());
								rowVO.set("rcpttm"     , opmiVO.getString("opmi_rcpttm"));
								rowVO.set("rcptno"     , iRcptNo);
								rowVO.set("rcptseqno"  , "1");
								rowVO.set("sessinstcd" , sInstCd);							 
								rowVO.set("sessuserid" , sUserId);
								rowVO.set("orddd"      , opmiVO.getString("opmi_orddd"));
								rowVO.set("cretno"     , opmiVO.getString("opmi_cretno"));						
							
							if (insUncoAmt(rowVO) <= 0) 
								throw new LiveException("�ܷ�����-�̼� ������ �������� �ʾҽ��ϴ�.[15024]");	
						}
	
						//�̼��Աݾ� orgrcptdd,orgrcptno ����ó��
						ValueObject unco_tempVO = new ValueObject();
	
						unco_tempVO.set("pid"            ,opmiVO.getString("opmi_pid"));
						unco_tempVO.set("instcd"         ,sInstCd);
						unco_tempVO.set("userid"         ,sUserId);
						unco_tempVO.set("old_rcptdd"     ,opmiVO.getString("opmi_orgrcptdd"));
						unco_tempVO.set("old_rcptno"     ,opmiVO.getString("opmi_orgrcptno"));
						unco_tempVO.set("old_rcptseqno"  ,opmiVO.getString("opmi_orgrcptseqno"));
						unco_tempVO.set("new_rcptdd"     ,DateHelper.getDay());
						unco_tempVO.set("new_rcptno"     ,iRcptNo);
						unco_tempVO.set("new_rcptseqno"  ,"1");	
						etcOutRgst.setUNCO(unco_tempVO);
						//�̼��Աݾ� orgrcptdd,orgrcptno ����ó�� ��					
					}
	
	                outrcptmngtDAO.setUncoEndApprsn(opmiVO);   //������� ó���� �̼��� ���������� ������Ʈ
	
				if ( log.isDebugEnabled() ) log.debug("**---- �ű� UNCO ���� ó��  END----**  " );
				//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				if ( log.isDebugEnabled() ) log.debug("**---- �ű� DCGM ���� ó��  START----**  " );
					//����
					if (Integer.parseInt(opmiVO.getString("opmi_reduamt")) != 0 || Integer.parseInt(opmiVO.getString("opmi_discamt")) != 0 ) {							
						
						for( int i =0; i< dcgmVO.size() ; i++) {	
							
							ValueObject rowVO = dcgmVO.getRowAsVo(i);
							
							rowVO.set("rcptdd"     , DateHelper.getDay());
							rowVO.set("rcptexecdd" , DateHelper.getDay());
							rowVO.set("rcpttm"     , opmiVO.getString("opmi_rcpttm"));
							rowVO.set("rcptno"     , iRcptNo);
							rowVO.set("rcptseqno"  , "1");	
							rowVO.set("rcptrid"    , sUserId);
							rowVO.set("fstrgstrid" , sUserId);
							rowVO.set("lastupdtrid", sUserId);
							rowVO.set("sessinstcd" , sInstCd);							 
							rowVO.set("sessuserid" , sUserId);
							rowVO.set("orddd"      , opmiVO.getString("opmi_orddd"));
							rowVO.set("cretno"     , opmiVO.getString("opmi_cretno"));					
							
							if (outrcptmngtDAO.insDcgmAmt(rowVO) <= 0) 
								//throw new LiveException("pam.error.15025");
								throw new LiveException("�ܷ�����-����/���� ������ �������� �ʾҽ��ϴ�.[15025]");
						}
									
					}
				if ( log.isDebugEnabled() ) log.debug("**---- �ű� DCGM ���� ó��  END----**  " );
				//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				if ( log.isDebugEnabled() ) log.debug("**---- �ű� BLDC ���� ó��  START----**  " );
					//���װ���
					if (Integer.parseInt(opmiVO.getString("opmi_bloddiscamt")) != 0 ) {							
						
						for( int i =0; i< bldcVO.size() ; i++) {	
							
							ValueObject rowVO = bldcVO.getRowAsVo(i);
							
							rowVO.set("rcptdd"     , DateHelper.getDay());
							rowVO.set("rcptexecdd" , DateHelper.getDay());
							rowVO.set("rcpttm"     , opmiVO.getString("opmi_rcpttm"));
							rowVO.set("rcptno"     , iRcptNo);
							rowVO.set("rcptseqno"  , "1");	
							rowVO.set("rcptrid"    , sUserId);
							rowVO.set("sessinstcd" , sInstCd);							 
							rowVO.set("sessuserid" , sUserId);	
							rowVO.set("fstrgstrid" , sUserId);
							rowVO.set("lastupdtrid", sUserId);
							rowVO.set("orddd"      , opmiVO.getString("opmi_orddd"));
							rowVO.set("cretno"     , opmiVO.getString("opmi_cretno"));
										
						if (outrcptmngtDAO.insBldcAmt(rowVO) <= 0) 
							//throw new LiveException("pam.error.15025");
							throw new LiveException("�ܷ�����-���� ������ �������� �ʾҽ��ϴ�.[15025]");
						}
							
					}
				if ( log.isDebugEnabled() ) log.debug("**---- �ű� BLDC ���� ó��  END----**  " );		
				
				if ( log.isDebugEnabled() ) log.debug("**----�ܷ�ó�� �������� update  start----**  " );
				//+++++++++++++++++++++++++++++++++++++++++++++++
				setOutOrdStat(opmiVO);
				
	            //������ ���ÿ� �����ؾ� �ϴ� ó�� ������Ʈ
	            ValueObject tempVO = new ValueObject();
	
	            tempVO.set("pid"            , opmiVO.getString("opmi_pid"));   
	            tempVO.set("orddd"          , opmiVO.getString("opmi_orddd"));   
	            tempVO.set("cretno"         , opmiVO.getString("opmi_cretno"));  
	            tempVO.set("execdd"         , DateHelper.getDay());      
	            tempVO.set("exectm"         , opmiVO.getString("opmi_rcpttm"));      
	            tempVO.set("execrid"        , sUserId);
	            tempVO.set("sessuserid"     , sUserId);  
	            tempVO.set("sessinstcd"     , sInstCd);  
	
	            etcOutRgst.getActingRcptOscl(tempVO);
	            //������ ���ÿ� �����ؾ� �ϴ� ó�� ������Ʈ ��
	
				//+++++++++++++++++++++++++++++++++++++++++++++++	
				if ( log.isDebugEnabled() ) log.debug("**----�ܷ�ó�� �������� update  end----**  " );
	
				//���������ڵ� P0022 170 Y �Ƿڼ� üũ(���ǵ�)
				if (!StringHelper.strEquals(this.getPmcmCodeNm("P0022","170").getString("cdnm"),"Y")) {
		            ////////////////////////////////�����Ƿڼ� �Է�/////////////////////////////////
		            if(StringHelper.strEquals(tmpOtpt.getString("otpt_ordreqformflag"),"3")) {
		                ValueObject cnstVO = new ValueObject();
		                cnstVO.set("pid"                , opmiVO.getString("opmi_pid"));   
		                cnstVO.set("orddd"              , opmiVO.getString("opmi_orddd"));   
		                cnstVO.set("cretno"             , opmiVO.getString("opmi_cretno"));  
		                cnstVO.set("orddeptcd"          , opmiVO.getString("opmi_orddeptcd"));  
		                cnstVO.set("insukind"           , opmiVO.getString("opmi_insukind")); 
						cnstVO.set("etcordflag"         , tmpOtpt.getString("otpt_etcordflag")); 
		                cnstVO.set("ordreqkind"         , "1");  
		                cnstVO.set("sessuserid"         , sUserId);  
		                cnstVO.set("sessinstcd"         , sInstCd);  
		                this.setOutOrdCnst(cnstVO);
		            }
				}
	            ////////////////////////////////�����Ƿڼ� �Է³�/////////////////////////////////
			}
            //ȯ�ҽÿ� ������ �Է��ϴ� ��찡 �־ �Ʒ��� �Ű��� CYS 20100106
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if ( log.isDebugEnabled() ) log.debug("**---- �ű� BOGJ ���� ó��  START----**  " );
                //������
                if (Integer.parseInt(opmiVO.getString("opmi_mdlrcptamt")) != 0 ) {
                    long lcashamt = 0;

                    bogjVO.set("rcptdd"    , DateHelper.getDay());
                    bogjVO.set("rcptexecdd", DateHelper.getDay());
                    bogjVO.set("rcptno"    , iRcptNo);
                    bogjVO.set("rcptseqno" , "1");
                    bogjVO.set("paydepoamt", "0");
                    bogjVO.set("paypsnflag", "1");
                    bogjVO.set("rcptrid"   , sUserId);
                    bogjVO.set("sessinstcd", sInstCd);
                    bogjVO.set("sessuserid", sUserId);

                    //��üó���̹Ƿ� (-) �ݾ����� ���� 2007.10.10
                    lcashamt =  Long.parseLong(bogjVO.getString("cashamt"));
                    bogjVO.set("cashamt",  String.valueOf(lcashamt * -1) );

                    if (insMdlAmt(bogjVO) <= 0)
                        throw new LiveException("�ܷ�����-��ü ������ �������� �ʾҽ��ϴ�.[15026]");
                }
            if ( log.isDebugEnabled() ) log.debug("**---- �ű� BOGJ ���� ó��  END----**  " );
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
			trcptnoVO.set("rcptno", iRcptNo);	   //����ó���� �����ϸ�, ��������ȣ update	
			outrcptmngtDAO.delOutOrdSmsq(opmiVO);  //���ڸ޼��� �̷� ���̺� ����
			

            opmiVO.set("pid"     , opmiVO.getString("opmi_pid"));   
            opmiVO.set("orddd"   , opmiVO.getString("opmi_orddd"));   
            opmiVO.set("cretno"  , opmiVO.getString("opmi_cretno"));  
			outrcptmngtDAO.setOutOrdEndMjqu(opmiVO);    //0������ ��� ���̺� ����ó��
			
			outrcptmngtDAO.setOPCGStat(opmiVO);    //����ó���ȯ, ��üó�� ���� table ���� ���� ���� ó�� 
			
			

			//ī�� �� üũ ���̺� �μ�Ʈ
			if(pVOs.isExist("ptbs")){
				if(StringHelper.strEquals(ptbsVO.getString("opt_cardck"), "Y")) {
					ValueObject logVO = new ValueObject();
					logVO.set("pid"          , opmiVO.getString("opmi_pid"));
					logVO.set("rcptdd"       , DateHelper.getDay());
					logVO.set("rcptno"       , iRcptNo);
					logVO.set("rcptseqno"    , "1");
					logVO.set("rcptflag"     , "PAOHOPMI");	//�������� ���̺�
					logVO.set("cardcashflag" , "A");			//ī��
					etcOutRgst.insRcptVanLog(logVO);
				}
			}
		
			//Holdó�� ���� ���, �ܷ���ϳ��� �߰� ����
			if ( log.isDebugEnabled() ) {
		   		 log.debug("**----opmi_rcptno=>----**  " + opmiVO.getString("opmi_rcptno") ); 
			}
		
			//�ܷ����� �⺻üũ����
			ValueObject otptVO_ck = new ValueObject();

		    otptVO_ck.set("pid"           ,opmiVO.getString("opmi_pid"));
			otptVO_ck.set("orddd"         ,opmiVO.getString("opmi_orddd"));
			otptVO_ck.set("cretno"        ,opmiVO.getString("opmi_cretno"));
			otptVO_ck.set("calcstat"      ,"Y");
			otptVO_ck.set("sessinstcd"    ,sInstCd);
			otptVO_ck.set("sessuserid"    , sUserId);
			
			otptVO_ck.set("medamtestmyn"   , otptVO.getString("medamtestmyn"));	
			otptVO_ck.set("medamtfreeresn" , otptVO.getString("medamtfreeresn"));	
			otptVO_ck.set("orddrid"        , otptVO.getString("orddrid"));
			otptVO_ck.set("specordyn"      , otptVO.getString("specordyn"));
			otptVO_ck.set("insukind"       , otptVO.getString("insukind"));
			otptVO_ck.set("suppkind"       , otptVO.getString("suppkind"));

			pVOs.set("otpt",otptVO_ck); 

			this.outOrd_Check(pVOs ,"����" , sInstCd , sUserId);
			//�ܷ����� �⺻üũ���� ��


			//ȯ�Ұ� ���������� ó��(����ó��� ��¥�� ������ �ű�� otpt xó���ϴ� ��찡�־ �߰��մϴ�!)
			if(StringHelper.strEquals(opmiVO.getString("otpt_histstat"), "X")) {
				 opmiVO.set("opmi_rcptdd"    , opmiVO.getString("opmi_rcptdd_org"));   
				 opmiVO.set("opmi_rcptno"    , opmiVO.getString("opmi_rcptno_org")); 
				 opmiVO.set("opmi_rcptseqno" , "101");
				 opmiVO.set("opmi_orddd"     , opmiVO.getString("opmi_orddd_org"));
			}


			ValueObject msgVO   = new ValueObject();  //���ϸ޼���
			ValueObject pharmVO = new ValueObject();  //�౹����� VO
			ValueObjectAssembler pharmVOs    = new ValueObjectAssembler();   //�౹����� VOs
			ValueObjectAssembler retpharmVOs = new ValueObjectAssembler();   //�౹����� return VOs
			ValueObject InAutoAssignVO  = new ValueObject();	             //�ڵ������ VO

			//--------------------------------------------------�౹����------------------------------------------------------

			/*
			 * @ �ʿ��Ķ����
				pid, 
				orddd(actingorddd ���� �ƴ�), 
				cretno,
				orddeptcd,
				orddrid,
				instcd,
				ioflag(�Կ�/�ܷ�����(I/O), ���⼭�� "O"�� �־���)
				prcpgenrflag(ã�� ����� "O"�� �־���)
			 */
            //������ ó������Ƿ�, ��ȸ�Ǽ� 0
            if (this.getOrddd(opmiVO).size() > 0) {

                if(log.isDebugEnabled()){log.debug("**----�౹���� ȣ����� exeOutSum ------**");}

                if (StringHelper.strEquals(this.getPmcmCodeNm("P0032","-").getString("cdnm"),"Y")) {
                    pharmVO = this.getOrddd(opmiVO);
                }else{
                    pharmVO.set("pid"         , opmiVO.getString("opmi_pid"));
                    pharmVO.set("orddd"       , opmiVO.getString("opmi_orddd"));
                    pharmVO.set("cretno"      , opmiVO.getString("opmi_cretno"));
                    pharmVO.set("orddeptcd"   , opmiVO.getString("opmi_orddeptcd"));
                    pharmVO.set("orddrid"     , opmiVO.getString("opmi_orddrid"));
                    pharmVO.set("instcd"      , sInstCd);
                    pharmVO.set("ioflag"      , "O");
                    pharmVO.set("prcpgenrflag", "O");
                }

                pharmVOs.set("req", pharmVO);
				retpharmVOs = pharmlib.exeOutSum(pharmVOs);	

				if (retpharmVOs.size() < 0) {
					throw new LiveException("���ȣ ������ �����߻��Ͽ����ϴ�.");						
				}
				
				if(!StringHelper.strEquals(retpharmVOs.get("result").getString("outDrugNoMsg"),"")) {
					 msgVO.set("outdrugnomsg", retpharmVOs.get("result").getString("outDrugNoMsg"));
				}

				if(log.isDebugEnabled()){log.debug("**----�౹���� ȣ������ exeOutSum ------** ");}


				if(log.isDebugEnabled()){log.debug("**----����ó���� ��� ------**");}

					pharmVO.set("sessinstcd" , sInstCd);
					drugVO = outrcptmngtDAO.getHosoOutOrderList(pharmVO);    

				if(log.isDebugEnabled()){log.debug("**----����ó���� ������� ------** ");}
				
			}
			//--------------------------------------------------�౹���賡------------------------------------------------------

			//--------------------------------------------------�ڵ������------------------------------------------------------
			if(log.isDebugEnabled()){log.debug("**----�ڵ������ ȣ����� setAutoRoomAssignIF ------**");}
			
				InAutoAssignVO.set("pid"      , opmiVO.getString("opmi_pid"));
				InAutoAssignVO.set("orddd"    , opmiVO.getString("opmi_orddd"));
				InAutoAssignVO.set("cretno"   , opmiVO.getString("opmi_cretno"));
				InAutoAssignVO.set("ioflag"   , opmiVO.getString("opmi_ordtype"));					
				InAutoAssignVO.set("instcd"   , sInstCd);
				InAutoAssignVO.set("userid"   , sUserId);
				
				InAutoAssignVO.set("workflag" , "N");
			
				autoasslib.setAutoRoomAssignIF(InAutoAssignVO);						
			
			if(log.isDebugEnabled()){log.debug("**----�ڵ������ ȣ������ setAutoRoomAssignIF ------**");}
			//--------------------------------------------------�ڵ��������------------------------------------------------------

			if(msgVO.size() > 0) {
				retVOs.set("msg",msgVO); //�౹����� ���ϸ޼��������� ȭ������ ����
			}

			retVOs.set("opmi",opmiVO);   //������������� �������� return

			if(drugVO.size() > 0) {
				retVOs.set("drug",drugVO);   //����ó���� ���
			}

			getServiceContext().setMessage(Messages.getMessages().getMessage("com.info.00007",new Integer[] { Integer.valueOf(opmiVO.size())}));

		} catch (Exception ex) {
			
			setRollbackOnly();
			
			if (ex instanceof LiveException) {
				throw (LiveException) ex;
			} else {
				throw new LiveException("com.error.90000", ex);
			}
		}
		
		
		if ( log.isDebugEnabled() ) {
	   		 log.debug("**----end   setOutOrdAmtRcpt ------**  " );	 
		}
		
		return retVOs;

	}
	
	
	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getEarnInfo2(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getEarnInfo2(ValueObject pVO) throws LiveException{
		
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getEarnInfo2(pVO);
		
		
	}	
	

	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getEarnInfo3(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getEarnInfo3(ValueObject pVO) throws LiveException{
		
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getEarnInfo3(pVO);
		
		
	}		
	
	
	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getEarnInfo2(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getEarnInfo4(ValueObject pVO) throws LiveException{
		
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getEarnInfo4(pVO);
		
		
	}


	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getOtptInfo2(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOtptInfo2(ValueObject pVO) throws LiveException{
		
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getOtptInfo2(pVO);
		
	}	

	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getOtptInfo3(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOtptInfo3(ValueObject pVO) throws LiveException{
		
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getOtptInfo3(pVO);
		
	}	
	

	/*
	 * (��Javadoc)
	 * ȯ��ó����ȸ(�ܷ�����ȭ��-ó��Ȧ������ ó����ȸ)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getprcpList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getprcpList2(ValueObject pVO) throws LiveException{
		
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getprcpList2(pVO);
		
	}	

	/*
	 * (��Javadoc)
	 * ȯ��ó����ȸ(�ܷ�����ȭ��-ó��Ȧ������ ó����ȸ)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getprcpList(kr.co.hit.live.vo.ValueObject)
	 */
	 /*
	public ValueObject getholdDDList(ValueObject pVO) throws LiveException{
		
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getholdDDList(pVO);
		
	}
	*/

	/*
	 * (��Javadoc)
	 * ȯ��ó����ȸ(�ܷ�����ȭ��-ó��Ȧ������ ó����ȸ)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getprcpList(kr.co.hit.live.vo.ValueObject)
	 */
	 /*
	public ValueObject getholdList(ValueObject pVO) throws LiveException{
		
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getholdList(pVO);
		
	}	
	*/
	
	/*
	 * (��Javadoc)
	 * �߰��� ����ó��
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#setMdlAmtRcpt(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObjectAssembler setMdlAmtRcpt(ValueObjectAssembler pVOs) throws LiveException {

		String sInstCd = StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE));
		String sUserId = StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID));
		
		ValueObject bogjVO 	  = pVOs.get("bogj");
		ValueObject cardVO 	  = pVOs.get("card");
		ValueObject cashVO 	  = pVOs.get("cash");
		ValueObject onlnVO  = pVOs.get("online");

		ValueObject rcptnoVO = null;
		ValueObjectAssembler retVOs = new ValueObjectAssembler();

         bogjVO.set("sessinstcd",sInstCd);
		 bogjVO.set("sessuserid",sUserId);
        
		try {
			
			int iRcptNo = 0;
			int iCount1 = 0;
			int iCount2 = 0;
			int iCount = 0;
			
			//��������ȣ ä��-����:�߻�����
			rcptnoVO = getRcptNo(bogjVO);
			
			//ä������ ���� (���̺� => Sequence)
			iRcptNo =  Integer.parseInt(rcptnoVO.getString("rcptno"));
			
			//�ܷ������� ��������ȣ
			bogjVO.set("rcptno",iRcptNo);			
			//�����ÿ��� �Ϸù�ȣ 1
			bogjVO.set("rcptseqno","1");
			
			iCount1 = insMdlAmt(bogjVO);
			
			if (iCount1 <= 0) {
				throw new LiveException("�ܷ������� ������ �������� �ʾҽ��ϴ�.[15003]");
				
			}
			
			//////////////////////////////////////////�����Ա�///////////////////////////////////////////
			if (bogjVO.getDouble("onlineamt") != 0 ) {

				for( int i =0; i< onlnVO.size() ; i++) {	
					ValueObject rowVO = onlnVO.getRowAsVo(i);
					rowVO.set("rcptdd"     , DateHelper.getDay());
					rowVO.set("rcptexecdd" , DateHelper.getDay());
					rowVO.set("rcpttm"     , bogjVO.getString("rcpttm"));
					rowVO.set("rcptno"     , iRcptNo);
					rowVO.set("rcptseqno"  , "1");
					rowVO.set("sessinstcd" , sInstCd);							 
					rowVO.set("sessuserid" , sUserId);	
					rowVO.set("orddd"      , "00000000");							 
					rowVO.set("cretno"     , "0");	
					
					if (insOnlineAmt(rowVO) <= 0) 
						throw new LiveException("�ܷ�������-�����Ա� ������ �������� �ʾҽ��ϴ�.[15004]");		
				}
			}

			//////////////////////////////////////////�����Աݳ�///////////////////////////////////////////
					
			//////////////////////////////////////////ī��///////////////////////////////////////////
			if (cardVO.size() > 0) {
			//if (bogjVO.getDouble("cardamt") != 0 ) {	
				for( int i =0; i< cardVO.size() ; i++) {				
					ValueObject rowVO = cardVO.getRowAsVo(i);
					rowVO.set("rcptdd"     , DateHelper.getDay());
					rowVO.set("rcptexecdd" , DateHelper.getDay());
					rowVO.set("rcpttm"     , bogjVO.getString("rcpttm"));
					rowVO.set("rcptno"     , iRcptNo);
					rowVO.set("rcptseqno"  , "1");
					rowVO.set("sessinstcd" , sInstCd);							 
					rowVO.set("sessuserid" , sUserId);
					rowVO.set("orddd"      , "00000000");							 
					rowVO.set("cretno"     , "0");					
					
					if (insCardAmt(rowVO) <= 0) 
						throw new LiveException("�ܷ�������-ī����� ������ �������� �ʾҽ��ϴ�.[15005]");	
				}
			}
			//////////////////////////////////////////ī�峡///////////////////////////////////////////

			//////////////////////////////////////////���ݿ�����///////////////////////////////////////////
			if (cashVO.size() > 0) {
			//if (bogjVO.getDouble("cashamt") != 0 ) {
				for( int i =0; i< cashVO.size() ; i++) {	
					ValueObject rowVO = cashVO.getRowAsVo(i);					
					rowVO.set("rcptdd"    , DateHelper.getDay());   
					rowVO.set("rcptexecdd", DateHelper.getDay());
					rowVO.set("rcpttm"    , bogjVO.getString("rcpttm"));
					rowVO.set("rcptno"    , iRcptNo);
					rowVO.set("rcptseqno" , "1");	
					rowVO.set("sessinstcd" , sInstCd);							 
					rowVO.set("sessuserid" , sUserId);
					rowVO.set("orddd"      , "00000000");							 
					rowVO.set("cretno"     , "0");					
				
					if (insCashAmt(rowVO) <= 0) 
						throw new LiveException("�ܷ�������-���ݿ��������� ������ �������� �ʾҽ��ϴ�.[15006]");			
				}
			}
			//////////////////////////////////////////���ݿ�������///////////////////////////////////////////

			//ī�� �� üũ ���̺� �μ�Ʈ
			if(StringHelper.strEquals(pVOs.get("option").getString("cardck"), "Y")) {
				ValueObject logVO = new ValueObject();
				logVO.set("pid"             , bogjVO.getString("pid"));
				logVO.set("rcptdd"         , DateHelper.getDay());
				logVO.set("rcptno"         , iRcptNo);
				logVO.set("rcptseqno"    , "1");
				logVO.set("rcptflag"       , "PAOHBOGJ");	//�������� ���̺�
				logVO.set("cardcashflag", "A");			//ī��
				etcOutRgst.insRcptVanLog(logVO);
			}

			// Ŭ���̾�Ʈ�� ������ ���� ó�� �޽��� ����.
			getServiceContext().setMessage(
					Messages.getMessages().getMessage(
							"com.info.00007",
							new Integer[] { Integer.valueOf(iCount)}));


		} catch (Exception ex) {
			
			setRollbackOnly();
			
			if (ex instanceof LiveException) {
				throw (LiveException) ex;
			} else {
				throw new LiveException("com.error.90000", ex);
			}
		}
		
		retVOs.set("bogj", bogjVO);
		return retVOs;

	
	}	
	
	
	/*
	 * (��Javadoc)
	 * ī��������� ����
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#insCardAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insCardAmt(ValueObject pVO) throws LiveException {
		String sUserId = "";
		String sInstCd = "";
		int iCount = -1;
		int iCount2 = -1;
		String sallotmm = "";
		
		try {

			 //����ڵ� ��ȸ
			if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
				pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
			}
			
			//����� ��ȸ
			if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
				pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
				
			}

			sInstCd = pVO.getString("sessinstcd");
			sUserId = pVO.getString("sessuserid");
		
			//���ʵ����/����������/����ڵ� ����
			pVO.set("fstrgstrid" , sUserId);
			pVO.set("lastupdtrid", sUserId);
			pVO.set("instcd"     , sInstCd);
			if (StringHelper.strEquals(pVO.getString("rcptrid"), "")) pVO.set("rcptrid",sUserId);
			
	        //�̵���20080114 �Һΰ����� ���ڸ� üũ�Ͽ� ���ڸ��� ü����.
        	if (StringHelper.getByteLength(StringHelper.null2void(pVO.getString("allotmm"))) == 0 ||
        			StringHelper.strEquals(pVO.getString("allotmm"), "")) {
        		sallotmm = "00";
        	} else if (StringHelper.getByteLength(StringHelper.null2void(pVO.getString("allotmm"))) == 1){
        		sallotmm = "0" + pVO.getString("allotmm");		
        	} else {
        		sallotmm = pVO.getString("allotmm");		        		
        	}
    		pVO.set("allotmm",sallotmm);

			iCount = outrcptmngtDAO.insCardAmt(pVO);	
		
		} catch (Exception ex) {
			
			setRollbackOnly();
			
			if (ex instanceof LiveException) {
				throw (LiveException) ex;
			} else {
				throw new LiveException("com.error.90000", ex);
			}
		}
		
		return  iCount;
	}

	
	/*
	 * (��Javadoc)
	 * ���ݿ����� �������� ����
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#insCashAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insCashAmt(ValueObject pVO) throws LiveException {

        String sInstCd = "";
        String sUserId = "";

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
            
        }

        sInstCd = pVO.getString("sessinstcd");
        sUserId = pVO.getString("sessuserid");
		if (StringHelper.strEquals(pVO.getString("rcptrid"), "")) pVO.set("rcptrid",sUserId);
		
		return outrcptmngtDAO.insCashAmt(pVO);
	}

	/*
	 * (��Javadoc)
	 * �����Աݳ��� ����
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#insOnlineAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insOnlineAmt(ValueObject pVO) throws LiveException {

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		//���ʵ����/����������/����ڵ� ����
		pVO.set("fstrgstrid" , pVO.getString("sessuserid"));
		pVO.set("lastupdtrid", pVO.getString("sessuserid"));
		pVO.set("instcd"     , pVO.getString("sessinstcd"));
		
		if (StringHelper.strEquals(pVO.getString("rcptrid"), "")) pVO.set("rcptrid",pVO.getString("sessuserid"));
		
		return outrcptmngtDAO.insOnlineAmt(pVO);
	}

	/*
	 * (��Javadoc)
	 * ���ݿ����� �������� ����
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#insUncoAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insUncoAmt(ValueObject pVO) throws LiveException {

        String sInstCd = "";
        String sUserId = "";

		ValueObject Oscl_clincstdyno = new ValueObject();

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
            
        }

        sInstCd = pVO.getString("sessinstcd");
        sUserId = pVO.getString("sessuserid");
        
		pVO.set("fstrgstrid"  , sUserId);
		pVO.set("lastupdtrid" , sUserId);
		pVO.set("instcd"      , sInstCd);
		if (StringHelper.strEquals(pVO.getString("rcptrid"), "")) pVO.set("rcptrid",sUserId);

		//�ӻ󿬱���ȣ�� oscl�� ������ �����´�.
		Oscl_clincstdyno = outrcptmngtDAO.getOscl_clincstdyno(pVO);

		if(Oscl_clincstdyno.size() > 0) {
			pVO.set("clincstdyno",Oscl_clincstdyno.getString("clincstdyno"));
		}
		//�ӻ󿬱���ȣ�������� ��

		return outrcptmngtDAO.insUncoAmt(pVO);
	}

	/*
	 * (��Javadoc)
	 * ���ݿ����� �������� ����
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#insUncoAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insDcgmAmt(ValueObject pVO) throws LiveException {

        String sInstCd = "";
        String sUserId = "";

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
            
        }

        sInstCd = pVO.getString("sessinstcd");
        sUserId = pVO.getString("sessuserid");
		
		//���ʵ����/����������/����ڵ� ����
        pVO.set("fstrgstrid"  ,sUserId);
        pVO.set("lastupdtrid" ,sUserId);
        pVO.set("sessinstcd"  ,sInstCd);                           
        pVO.set("sessuserid"  ,sUserId);
		if (StringHelper.strEquals(pVO.getString("rcptrid"), "")) pVO.set("rcptrid",sUserId);
        
		return outrcptmngtDAO.insDcgmAmt(pVO);
	}
	
	
	/*
	 * (��Javadoc)
	 * �߰��� �������ó��
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#setMdlAmtRcptCncl(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObjectAssembler setMdlAmtRcptCncl(ValueObjectAssembler pVOs) throws LiveException {
		
		ValueObject bogjVO = pVOs.get("bogj");
		ValueObject cardVO = pVOs.get("card");
		ValueObject cashVO = pVOs.get("cash");
		ValueObject onlnVO = pVOs.get("onln");
		
		ValueObjectAssembler retVOs = new ValueObjectAssembler();

		String sInstCd = StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE));
		String sUserId = StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID));

		

		try {
			
			int iRcptSeqNo = 0;
			int iCount1 = 0;
			int iCount2 = 0;

			 //����ڵ� ��ȸ
			 bogjVO.set("sessinstcd",sInstCd);
			 bogjVO.set("sessuserid", sUserId);
						
			iCount1 = insMdlAmtCncl(bogjVO);

			if (iCount1 <= 0) {
				//throw new LiveException("pam.error.15008");
				throw new LiveException("�ܷ������� ��� ����.[15008]");				
			}
		
			//card
			/*
			if (bogjVO.getDouble("cardamt") != 0  &&  StringHelper.strEquals(pVOs.get("option").getString("cardck"), "N")) {
				
				cardVO.set("sessinstcd",sInstCd);
				cardVO.set("sessuserid",sUserId);
				iCount2 = 0;
				iCount2 = insCardAmtCncl(cardVO);
				
				if (iCount2 <= 0) {
					//throw new LiveException("pam.error.15010");
					throw new LiveException("�ܷ�������-ī����� ��� ����.[15010]");					
				}			
			}
			*/
		
			//cash
			if (cashVO.size() > 0  ) {
				
				cashVO.set("sessinstcd",sInstCd); 
				cashVO.set("sessuserid",sUserId); 
				
				iCount2 = 0;
				iCount2 = insCashAmtCncl(cashVO);
				
				if (iCount2 <= 0) {
					//throw new LiveException("pam.error.15011");
					throw new LiveException("�ܷ�������-���ݿ��������� ��� ����.[15011]");				
				}			
			}

            //onln
            if (onlnVO.size() > 0  ) {

                onlnVO.set("sessinstcd",sInstCd);
                onlnVO.set("sessuserid",sUserId);

                iCount2 = 0;
                iCount2 = insOnlineAmtCncl(onlnVO);

                if (iCount2 <= 0) {
                    throw new LiveException("�ܷ�������-�����Ա� ��� ����.[15011]");
                }
            }

            //ī�� �� üũ ���̺� �μ�Ʈ
            if(StringHelper.strEquals(pVOs.get("option").getString("cardck"), "Y")) {
                ValueObject logVO = new ValueObject();
                logVO.set("pid"            , bogjVO.getString("pid"));
                logVO.set("rcptdd"         , bogjVO.getString("rcptdd"));
                logVO.set("rcptno"         , bogjVO.getString("rcptno"));
                logVO.set("rcptseqno"      , bogjVO.getString("rcptseqno"));
                logVO.set("rcptflag"       , "PAOHBOGJ");   //�������� ���̺�
                logVO.set("cardcashflag"   , "A");          //ī��
                etcOutRgst.insRcptVanLog(logVO);
            }

			// Ŭ���̾�Ʈ�� ������ ���� ó�� �޽��� ����.
			getServiceContext().setMessage(
					Messages.getMessages().getMessage(
							"com.info.00007",
							new Integer[] { Integer.valueOf(iCount1)}));

		} catch (Exception ex) {
			
			setRollbackOnly();
			
			if (ex instanceof LiveException) {
				throw (LiveException) ex;
			} else {
				throw new LiveException("com.error.90000", ex);
			}
		}
		
		retVOs.set("bogj",bogjVO);	
		return retVOs;
	
	}	
	
	/* ī����� ��ҳ��� ����
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#insCardAmtCncl(kr.co.hit.live.vo.ValueObject)
	 */
	public int insCardAmtCncl(ValueObject pVO) throws LiveException {
		String sUserId = "";
		String sInstCd = "";
		
		int iCount = -1;
		
		try {

			 //����ڵ� ��ȸ
			if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
				pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
			}
			
			//����� ��ȸ
			if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
				pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
				
			}

			sInstCd = pVO.getString("sessinstcd");
			sUserId = pVO.getString("sessuserid");
			
			//���ʵ����/����������/����ڵ� ����
			pVO.set("fstrgstrid", sUserId);
			pVO.set("lastupdtrid", sUserId);
			pVO.set("instcd",sInstCd);
			
			//������ ����
			pVO.set("rcptrid",sUserId);
			
			//������ҳ��� rcptstat :D ������ ����
			iCount = -1;
			iCount = outrcptmngtDAO.insCardAmtCncl(pVO);
			
			if (iCount <= 0) {
				//throw new LiveException("pam.error.15012");
				throw new LiveException("�ܷ�������-ī����� ��ҳ����� �������� �ʾҽ��ϴ�.[15016]");		
			}
			
			//�� �������� Y => C�� ����.
			iCount = -1;
			iCount=  outrcptmngtDAO.setCardAmt(pVO);
			
			if (iCount <= 0) {
				//throw new LiveException("pam.error.15013");
				throw new LiveException("�ܷ�������-ī����� ������ ������� �ʾҽ��ϴ�.[15017]");		
			}
		
		} catch (LiveException le) {
            throw le;
        } catch (Exception e) {
            throw new LiveException("com.error.90000", e);
        }	
		
		
		return iCount;
		  
		
	}
	
	/* ���ݿ��������� ������� ���� ����
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#insCashAmtCncl(kr.co.hit.live.vo.ValueObject)
	 */
	public int insCashAmtCncl(ValueObject pVO) throws LiveException {
		String sUserId = "";
		String sInstCd = "";
		
		int iCount = -1;
		
		try {

			 //����ڵ� ��ȸ
			if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
				pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
			}
			
			//����� ��ȸ
			if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
				pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
				
			}

			sInstCd = pVO.getString("sessinstcd");
			sUserId = pVO.getString("sessuserid");
			
			//���ʵ����/����������/����ڵ� ����
			pVO.set("fstrgstrid", sUserId);
			pVO.set("lastupdtrid", sUserId);
			pVO.set("instcd",sInstCd);
			
			//������ ����
			pVO.set("rcptrid",sUserId);
			
			//������ҳ��� rcptstat :D ������ ����
			iCount = -1;
			iCount = outrcptmngtDAO.insCashAmtCncl(pVO);
			
			if (iCount <= 0) {
				//throw new LiveException("pam.error.15012");
				throw new LiveException("�ܷ�������-���ݿ���������  ��ҳ����� �������� �ʾҽ��ϴ�.[15018]");		
			}
			
			//�� �������� Y => C�� ����
			iCount = -1;
			iCount=  outrcptmngtDAO.setCashAmt(pVO);
			
			if (iCount <= 0) {
				//throw new LiveException("pam.error.15013");
				throw new LiveException("�ܷ�������-���ݿ��������� ������ ������� �ʾҽ��ϴ�.[15019]");		
			}
		
		} catch (LiveException le) {
            throw le;
        } catch (Exception e) {
            throw new LiveException("com.error.90000", e);
        }	
        
		return iCount;
		  
		
	}
		
	/* 
	 * (��Javadoc)
	 * �������� �̷� ����
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#insPtinHistAdd(kr.co.hit.live.vo.ValueObject)
	 */
	public int insPtinHistAdd(ValueObject pVO) throws LiveException{

/*
		String sUserId = "";
		String sInstCd = "";

		ValueObject tempVO = new ValueObject ();
		
		int iCount = -1;
		int row;
		
		try {

			 //����ڵ� ��ȸ.
			if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
				pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
			}
			
			//����� ��ȸ
			if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
				pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
			}

			sInstCd = pVO.getString("sessinstcd");
			sUserId = pVO.getString("sessuserid");

			//Ű���� ���� ���� ��ȸ			
			tempVO = outrcptmngtDAO.getPtin1(pVO);
			
			if (tempVO.size() <= 0) {
				
				//�űԻ���
				iCount = -1;
				iCount = outrcptmngtDAO.insPtinHist(pVO);				
				
			}else {
			
			for( int i = 0; i < tempVO.size(); i++ ){
				
					String sToday = DateHelper.getCurrentDateAsString();
					String sFromDD = StringHelper.null2string(pVO.getString("ptin_fromdd"), sToday);
																
					//���� ���������� �������ڰ� ���ο� ���������� �������ں��� ���� �� ��
						if( sFromDD.compareTo( StringHelper.null2void(tempVO.getString(i, "ptin_fromdd"))) > 0){
								
							//���� ���������� (sFromDD - 1) ���ڷ� �����Ų��.
							tempVO.set(i, "ptin_todd"    , DateHelper.addDays(sFromDD, -1));
							tempVO.set(i, "sessinstcd"   , sInstCd);
							tempVO.set(i, "sessuserid"   , sUserId);
							row = outrcptmngtDAO.setPatInsu(tempVO.getRowAsVo(i));
							if (row < 1)
								throw new LiveException("���� �������� ���� �����Դϴ�!");
																			
						}else{
							
							//���� ���������� �̷� �����Ų��.
							tempVO.set(i, "ptin_histstat", "C");
							tempVO.set(i, "sessinstcd"   , sInstCd);
							tempVO.set(i, "sessuserid"   , sUserId);
							row = outrcptmngtDAO.setPatInsu(tempVO.getRowAsVo(i));
							if (row < 1)
								throw new LiveException("���� �������� ���� �����Դϴ�!");
												
						}
			}
	        	
	        	//�ű� �������� ����
    			row = outrcptmngtDAO.insPatInsu(pVO);
                if (row < 1)
                    throw new LiveException("ȯ�ں������� �Է� �����Դϴ�!");
                
	
			}			
			
		} catch (LiveException le) {
            throw le;
        } catch (Exception e) {
            throw new LiveException("com.error.90000", e);
        }	
        
		
		return iCount;		

*/


		String sUserId = "";
		String sInstCd = "";

		ValueObject ptinVO_key = new ValueObject ();
		ValueObject ptinVO_chk = new ValueObject ();
		
		int iCount = -1;
		
		try {

			 //����ڵ� ��ȸ
			if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
				pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
			}
			
			//����� ��ȸ
			if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
				pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
			}

			sInstCd = pVO.getString("sessinstcd");
			sUserId = pVO.getString("sessuserid");
/*
            pVO.set("pid"                 ,pVO.getString("ptin_pid"));
			pVO.set("insukind"            ,pVO.getString("ptin_insukind"));                //��������
			pVO.set("suppkind"            ,pVO.getString("ptin_suppkind"));                //��������
			pVO.set("insucd"              ,pVO.getString("ptin_insucd"));                  //�������ڵ�
			pVO.set("suppkindresn"        ,pVO.getString("ptin_suppkindresn"));            //������������
			pVO.set("todd"                ,pVO.getString("ptin_todd"));                    //��������
			pVO.set("fromdd"              ,pVO.getString("ptin_fromdd"));                  //��������
			pVO.set("insuno"              ,pVO.getString("ptin_insuno"));                  //��������ȣ
			pVO.set("insdnm"              ,pVO.getString("ptin_insdnm"));                  //�Ǻ����ڸ�
			pVO.set("insdrrgstno1"        ,pVO.getString("ptin_insdrrgstno1"));            //�Ǻ������ֹι�ȣ1
			pVO.set("insdrrgstno2"        ,pVO.getString("ptin_insdrrgstno2"));            //�Ǻ������ֹι�ȣ2
			pVO.set("insdrela"            ,pVO.getString("ptin_insdrela"));                //�Ǻ����ڰ���

			
			pVO.set("insukind_org"        ,pVO.getString("ptin_insukind_org"));                //��������
			pVO.set("suppkind_org"        ,pVO.getString("ptin_suppkind_org"));                //��������
			pVO.set("insucd_org"          ,pVO.getString("ptin_insucd_org"));                  //�������ڵ�
			pVO.set("suppkindresn_org"    ,pVO.getString("ptin_suppkindresn_org"));            //������������
			pVO.set("todd_org"            ,pVO.getString("ptin_todd_org"));                    //��������
			pVO.set("fromdd_org"          ,pVO.getString("ptin_fromdd_org"));                  //��������
			pVO.set("insuno_org"          ,pVO.getString("ptin_insuno_org"));                  //��������ȣ
			pVO.set("insdnm_org"          ,pVO.getString("ptin_insdnm_org"));                  //�Ǻ����ڸ�
			pVO.set("insdrrgstno1_org"    ,pVO.getString("ptin_insdrrgstno1_org"));            //�Ǻ������ֹι�ȣ1
			pVO.set("insdrrgstno2_org"    ,pVO.getString("ptin_insdrrgstno2_org"));            //�Ǻ������ֹι�ȣ2
			pVO.set("insdrela_org"        ,pVO.getString("ptin_insdrela_org"));                //�Ǻ����ڰ���
*/


			String today = DateHelper.getDay();          //DateHelper.getDay();
			String bfday = DateHelper.addDays(today,-1);
			String nxday = DateHelper.addDays(today,+1);

			pVO.set("today"        ,today);
			pVO.set("bfday"        ,bfday);
			pVO.set("nxday"        ,nxday);
			pVO.set("maxseqno"     ,outrcptmngtDAO.getPtin_maxseqno(pVO).getString("maxseqno","1"));

			//���� ���� ��ȸ			
			ptinVO_key = outrcptmngtDAO.getPtin1(pVO);
	
			if (ptinVO_key.size() == 0) {
				//�űԻ���
				//pVO.set("ptin_fromdd" , today);
				outrcptmngtDAO.insPtinHist(pVO);				
			}

			if (ptinVO_key.size() > 0) {
				pVO.set("ptin_fromdd" , pVO.getString("ptin_fromdd"));
				ptinVO_chk = outrcptmngtDAO.getPtin2(pVO);

				if(ptinVO_chk.size() > 0) {
					return iCount;
				}

				if(ptinVO_chk.size() == 0) {

					if (Integer.parseInt(pVO.getString("ptin_todd_org")) < Integer.parseInt(today)) {
							return iCount;
					}

					else if (StringHelper.strEquals(pVO.getString("ptin_fromdd_org"), today)) {
						outrcptmngtDAO.setPtinUpdate(pVO);	
						return iCount;
					}

					else if (Integer.parseInt(pVO.getString("ptin_fromdd_org")) < Integer.parseInt(today)) {
					
						outrcptmngtDAO.setPtinPreHist(pVO);
						
						pVO.set("ptin_fromdd" , today);
						outrcptmngtDAO.insPtinHist(pVO);

						return iCount;

					}else{

						throw new LiveException("�������� �������� �̷������Դϴ�! �������� �������� �����Ͻʽÿ�.");
					
					}

				}

			}

			
		} catch (LiveException le) {
            throw le;
        } catch (Exception e) {
            throw new LiveException("com.error.90000", e);
        }	
        
		
		return iCount;


	}
	
    
	/* ȯ�������Ƿڳ��� �Է�
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#setCnst(kr.co.hit.live.vo.ValueObject)
	 */	
    
	public void setCnst(ValueObjectAssembler pVOs) throws LiveException { 
		
		//����ڵ� ��ȸ
		String sInstCd = "";
		String sUserId = "";

        ValueObject pVO = new ValueObject();
        ValueObject h_cnst = new ValueObject();

		pVO = pVOs.get("pVO");
        h_cnst = pVOs.get("cnst");

        try {

            if (h_cnst != null) {
        	
            	if (h_cnst.size() > 0){

					//����ڵ� ��ȸ
					if (StringHelper.strEquals(h_cnst.getString("sessinstcd"), "")) {
						h_cnst.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
					}
					
					//����� ��ȸ
					if (StringHelper.strEquals(h_cnst.getString("sessuserid"), "")) {
						h_cnst.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
						
					}

					sInstCd = h_cnst.getString("sessinstcd");
					sUserId = h_cnst.getString("sessuserid");
            		
            		for (int i = 0; i < h_cnst.size(); i++) {
                        ValueObject rowVO = h_cnst.getRowAsVo(i);
                        rowVO.set("cnst_stat","I");
                        rowVO.set("sessinstcd",sInstCd);
                        rowVO.set("sessuserid",sUserId);
                			
                        int row = outrcptmngtDAO.setCNST(rowVO);                        
                    }
                }
            }
           
        } catch (LiveException le) {
            throw le;
        } catch (Exception e) {
            throw new LiveException("com.error.90000", e);
        }        

        return;
    }
  
	/* Hold/Release ó��
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#setHoldPrcpList(kr.co.hit.live.vo.ValueObject)
	 */	
	public int setHoldPrcpList(ValueObject pVO) throws LiveException {
		
		int iCount = 0;
		int iCount2 = 0;
		
		try {
			
			String sInstCd = "";
			String sUserId = "";

			 //����ڵ� ��ȸ
			if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
				pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
			}
			
			//����� ��ȸ
			if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
				pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
				
			}

			sInstCd = pVO.getString("sessinstcd");
			sUserId = pVO.getString("sessuserid");
			
			if (pVO != null) {
				
				if ( pVO.size() > 0 ) {
				
					for (int i = 0; i< pVO.size(); i++ ) {
						
						ValueObject rowVO = pVO.getRowAsVo(i);
						rowVO.set("sessinstcd", sInstCd);
						rowVO.set("sessuserid", sUserId);
						
						//ó�泻���� Hold/Release ���� update
						int row = outrcptmngtDAO.setHoldPrcpList(rowVO);
												
						iCount = iCount+1;
					}

					/*
					
					ValueObject HoldList = new ValueObject();
					
					pVO.set("pid"       , pVO.getString("prcp_pid"));
					pVO.set("orddd"   , pVO.getString("prcp_actorddd"));	
					pVO.set("cretno"  , pVO.getString("prcp_actcretno"));	
										
					HoldList = outrcptmngtDAO.getHoldExop(pVO);

					if (HoldList.size() == 0) {
						pVO.set("holdflag", "N");
					} else if (HoldList.size() > 0) {
						pVO.set("holdflag", "Y");
					}
					
					//�ܷ�������� Ȧ����·� ����
					outrcptmngtDAO.setOtptHoldFlag(pVO);
					*/


					//Release ó�� ��, �ܷ���� ����
					//���⼭ ������  ������, Ȧ��ó���� ���� ������ ������ Ȯ�� �ʿ�
						
					//����ó����°� Ȧ�� ==> Release
					//��� ��, Ȧ�� ó���ÿ��� �����ؾ��ϹǷ�, Release�ÿ��� ó���ϸ� �ȵ�..(�����־���)
					//if (StringHelper.strEquals(pVO.getString("prcp_preprcpstatcd"),"210")) {
					
					//�̵���20071231 Hold ���ִ� �����Ͽ� ���ؼ� �̷¹߻��� �ʿ������ ����.
					//iCount2 = outrcptmngtDAO.setAddOTPTFromHold(pVO);
					//}
					
				}
				
			}
		
		} catch (LiveException le) {
            throw le;
        } catch (Exception e) {
            throw new LiveException("com.error.90000", e);
        }   
		
		return iCount;
		
		
	}
	
	/*���μ��� ȯ�� üũ(ȯ�ڱ⺻������ ���� üũ)
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getCheckPatInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getCheckPatInfo(ValueObject pVO) throws LiveException{
		
		//return VO
		ValueObject retVO = new ValueObject();
		
        String sInstCd = "";
        String sUserId = "";

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
            
        }

        sInstCd = pVO.getString("sessinstcd");
        sUserId = pVO.getString("sessuserid");
		
		
		retVO.set("error", "0000");
		
		//1. ��������� üũ
		if (StringHelper.strEquals(pVO.getString("inhospyn"), "Y")){
			retVO.set("error", "0100");
			retVO.set("errortype", "PAM");
			retVO.set("errormsg", "���� �Կ����� ȯ���Դϴ�.");
		}
		
		return retVO;
		
		
	}

	/*���μ��� ȯ�� üũ(�ܷ���������� ���� üũ)
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getCheckOTPTInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getCheckOTPTInfo(ValueObject pVO) throws LiveException{

		//return VO
		ValueObject retVO = new ValueObject();
		
        String sInstCd = "";
        String sUserId = "";

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
            
        }

        sInstCd = pVO.getString("sessinstcd");
        sUserId = pVO.getString("sessuserid");
		
		retVO.set("error", "0000");
		
		//�������� �ǰ�����,�Ϲ� �̿��� ������ �����Ұ�
		for (int i = 0; i< pVO.size(); i++ ) {	
			
			if ( !StringHelper.strEquals(pVO.getString("otpt_insukind"), "11" ) &&
			 	 !StringHelper.strEquals(pVO.getString("otpt_insukind"), "51" )  ) {
				
				retVO.set("error", "0200");
				retVO.set("errortype", "PAM");
				retVO.set("errormsg", "����â������ �����Ͻʽÿ�.(����Ȯ��)");
				break;
				
			}			
		}		
		
		return retVO;
		
	}

	
	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getonlycvanList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getonlycvanList(ValueObject pVO) throws LiveException{

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
            
        }
		
		return outrcptmngtDAO.getonlycvanList(pVO);
		
	}

	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getupdtrateList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getupdtrateList(ValueObject pVO) throws LiveException{
		
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getupdtrateList(pVO);
		
	}
	
	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getupdtrateList1(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getupdtrateList1(ValueObject pVO) throws LiveException{
		
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getupdtrateList1(pVO);
		
	}	
	
	/* ��ﺯ�泻����ȸ(�ܷ�����/����ȭ��) 
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#setupdtrateList(kr.co.hit.live.vo.ValueObject)
	 */	
	public int setupdtrateList(ValueObject pVO) throws LiveException {
		
		int iCount = 0;
						
		try {
			
			 //����ڵ� ��ȸ
			if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
				pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
			}
			
			//����� ��ȸ
			if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
				pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
			}

			//�̵���20080103 �ְ������߰�
			pVO.set("suppkindsubyn","Y"); 
			//�������� Histstat : R => C
			//pVO.set("histstat","C");			
			
			//�̵���20080103 �ܷ��̷»���
			iCount =  outrcptmngtDAO.setupdtrateList(pVO);					

			//�̵���20080103 �����̷� ���ó��
			//iCount =  outrcptmngtDAO.insOtptHistSuppkindAdd(pVO);	
	
		
		} catch (LiveException le) {
            throw le;
        } catch (Exception e) {
            throw new LiveException("com.error.90000", e);
        }   
		
		return iCount;		
		
	}
	
	
	/*
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getEarnOsclInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getEarnOsclInfo(ValueObject pVO) throws LiveException{
		
        //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

		String otptkey ="";

		String calcflag = "";
		String calcstat = "";
				

	
				//�۾����� �߰�				
				pVO.set("calcstat", calcstat);

        for (int a = 0; a < pVO.size(); a++) {

			calcflag = pVO.getString(a,"calcflag");

				if (StringHelper.strEquals(calcflag,"N")) calcstat = "Y";   //����
				if (StringHelper.strEquals(calcflag,"S")) calcstat = "R";	//����
				if (StringHelper.strEquals(calcflag,"N") && 
					StringHelper.strEquals(pVO.getString(a,"holdflag"),"Y")
				   ) calcstat = "Y"; //���������� ó��Ȧ���

            otptkey = pVO.getString(a, "orddd") + pVO.getString(a, "cretno") + calcstat + "','" + otptkey;
        }

        pVO = pVO.getRowAsVo(0);
        pVO.set("otptkey" , otptkey);

		return outrcptmngtDAO.getEarnOsclInfo(pVO);
		
		
	}	
	
	
	
//******************************************************************************************************//
         
	public ValueObject setOprcPayFlag(ValueObject pVOs)  throws LiveException{

        String sInstCd = "";
        String sUserId = "";

		//����ڵ� ��ȸ
        sInstCd = StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE));

		//����� ��ȸ
        sUserId = StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID));

		int count = -1;
		ValueObject pVO = new ValueObject();
		
		try {
			
        	if (pVOs.size() > 0){
        		
        		for (int i = 0; i < pVOs.size(); i++) {
                    ValueObject rowVO = pVOs.getRowAsVo(i);
                    rowVO.set("prcp_instcd",sInstCd);
                    
        			count = outrcptmngtDAO.setOprcPayFlag(rowVO);	  
        			
        			if (count < 0) {
        				throw new LiveException("�ܷ��ǻ�ó�� �޺��������� ����!");						
        			}                         
                }
            }
			
		} catch (LiveException le) {
	        throw le;
	    } catch (Exception e) {
	        throw new LiveException("com.error.90000", e);
	    }		
		
		
		return pVOs;
	}
	

	/*
     * ȯ�������Ƿڼ� �Է�
     * 
     * @author cys
     * @param pVO ValueObject
     * @return ValueObjectAssembler
     * @throws LiveException
     */
    public int setOutOrdCnst(ValueObject pVO) throws LiveException {

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

        int retVO = 0;
		
		//�Ǻ��� insuflag 1�� ���� �޿��� 2�� ����.
		if(StringHelper.strEquals(pVO.getString("insukind"),"11")) { pVO.set("insuflag", "1");}
		if(StringHelper.strEquals(pVO.getString("insukind"),"21")) { pVO.set("insuflag", "2");}
		if(StringHelper.strEquals(pVO.getString("insukind"),"22")) { pVO.set("insuflag", "2");}
		
		//����ȭ�鿡 ��Ÿ������ �Ƿ��̸� 3 �ƴҰ�� 1
		if(StringHelper.strEquals(pVO.getString("etcordflag"),"H")) { 
			pVO.set("ordreqkind", "3");
		}else{
			pVO.set("ordreqkind", "1");
		}
		
		if(StringHelper.strEquals(pVO.getString("insukind"),"11") ||
		   StringHelper.strEquals(pVO.getString("insukind"),"21") ||
			StringHelper.strEquals(pVO.getString("insukind"),"22") 		
		) {
			outrcptmngtDAO.insOutOrdCnst(pVO);  //�����ڵ庯�� ����� ����μ��� ����
		}

        return retVO;
    }


	/*
     * �ܷ��޺񺯰�
     * �ܷ��̽���ó�� �̽��� ���� ��ȸ
     * @author cys
     * @param pVO ValueObject
     * @return ValueObjectAssembler
     * @throws LiveException
     */
	public ValueObject getOutUnExecPrcpOrdRef(ValueObject pVO) throws LiveException {
		
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

		ValueObject retVO = new ValueObject(); //��� VO
        
        retVO = outrcptmngtDAO.getOutUnExecPrcpOrdRef(pVO);
        
        if (log.isInfoEnabled()) {
            log.info("MGR : getOutUnExecPrcpOrdRef() end..");       
        }
        
		return retVO;
	}
	
	
	
	public ValueObject getInUnExecPrcpOrdRef(ValueObject pVO) throws LiveException {
		
        //����ڵ� ��ȸ
       if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
           pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
       }
       
       //����� ��ȸ
       if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
           pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
       }

		ValueObject retVO = new ValueObject(); //��� VO
       
       retVO = outrcptmngtDAO.getInUnExecPrcpOrdRef(pVO);
       
       if (log.isInfoEnabled()) {
           log.info("MGR : getInUnExecPrcpOrdRef() end..");       
       }
       
		return retVO;
	}


	/*
     * �ܷ��޺񺯰� 
     * �ܷ��̽���ó�� ȯ�� ��ȸ
     * @author cys
     * @param pVO ValueObject
     * @return ValueObjectAssembler
     * @throws LiveException
     */ 
	public ValueObject getPayPatInfo(ValueObject pVO) throws LiveException {

        //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

		ValueObject retVO = new ValueObject(); //��� VO
		        
        retVO = outrcptmngtDAO.getPayPatInfo(pVO);
        
        if (log.isInfoEnabled()) {
            log.info("MGR : getPayPatInfo() end..");       
        }
        
		return retVO;
	}


	/*
     * �ܷ��޺񺯰� 
     * �ܷ��̽��� ó�� ���� ��ȸ
     * @author cys
     * @param pVO ValueObject
     * @return ValueObjectAssembler
     * @throws LiveException
     */ 
	public ValueObject getOutUnExecPrcpRef(ValueObject pVO) throws LiveException {

        //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

		ValueObject retVO = new ValueObject(); //��� VO    
                
        retVO = outrcptmngtDAO.getOutUnExecPrcpRef(pVO);
        
        if (log.isInfoEnabled()) {
            log.info("MGR : getOutUnExecPrcpRef() end..");       
        }
        
		return retVO;
	}
	
	
	
	/* (non-Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.OutRcptMgt#getInUnExecPrcpRef(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getInUnExecPrcpRef(ValueObject pVO) throws LiveException {

        //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

		ValueObject retVO = new ValueObject(); //��� VO    
                
        retVO = outrcptmngtDAO.getInUnExecPrcpRef(pVO);
        
        if (log.isInfoEnabled()) {
            log.info("MGR : getInUnExecPrcpRef() end..");       
        }
        
		return retVO;
	}


	/*
     * �ܷ��޺񺯰� 
     * �ܷ��̽���ó�� �̽��� ���� ���սɻ� �Ϸ� ���θ� ����
     * @author cys
     * @param pVO ValueObject
     * @return ValueObjectAssembler
     * @throws LiveException
     */ 
	public int setJudgEnd(ValueObject pVO) throws LiveException {

		//����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		ValueObject setVO = null;
		
		int count = 0;
		
		for (int i = 0; i < pVO.size(); i++) {
			
			setVO = pVO.getRowAsVo(i);
			
			pVO.setRow(i, setVO.getRow());
			
			count += outrcptmngtDAO.setJudgEnd(setVO);
		}

		
		return count;
	}


	/*
     * �ܷ��޺񺯰� 
     * �ܷ��̽���ó�� - ó�� �޺񱸺��ڵ� ���� ó��
     * @author cys
     * @param pVO ValueObject
     * @return ValueObjectAssembler
     * @throws LiveException
     */
	public int setOrdPayFlag(ValueObject pVO) throws LiveException {

        String sInstCd = "";
        String sUserId = "";

		//����ڵ� ��ȸ
        sInstCd = StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE));

		//����� ��ȸ
        sUserId = StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID));
		
		ValueObject setVO = null;	

		int count = 0;
		
		for (int i = 0; i < pVO.size(); i++) {
			
			setVO = pVO.getRowAsVo(i);
			setVO.set("sessinstcd" , sInstCd);
			setVO.set("sessuserid" , sUserId);
			pVO.setRow(i, setVO.getRow());
			
			count += outrcptmngtDAO.setOrdPayFlag(setVO);
		}

		return count;
	}
	
	
	
	/* (non-Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.OutRcptMgt#setInOrdPayFlag(kr.co.hit.live.vo.ValueObject)
	 */
	public int setInOrdPayFlag(ValueObject pVO) throws LiveException {

        String sInstCd = "";
        String sUserId = "";

		//����ڵ� ��ȸ
        sInstCd = StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE));

		//����� ��ȸ
        sUserId = StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID));
		
		ValueObject setVO = null;	

		int count = 0;
		
		for (int i = 0; i < pVO.size(); i++) {
			
			setVO = pVO.getRowAsVo(i);
			setVO.set("sessinstcd" , sInstCd);
			setVO.set("sessuserid" , sUserId);
			pVO.setRow(i, setVO.getRow());
			
			count += outrcptmngtDAO.setInOrdPayFlag(setVO);
		}

		return count;
	}


	/*
     * �ܷ��޺񺯰� 
     * �ܷ��̽���ó�� �̽��� ���� Ư�� ������ ����
     * @author cys
     * @param pVO ValueObject
     * @return ValueObjectAssembler
     * @throws LiveException
     */
	public int delOutClcj(ValueObject pVO) throws LiveException {

		String userId  = StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID));
		String sinstcd = StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE));

		ValueObject rVO = new ValueObject();

		for (int i = 0; i < pVO.size(); i++) {
			ValueObject delVO = pVO.getRowAsVo(i);
			delVO.set("sessinstcd", sinstcd);           		//�Ҽӱ�� �ڵ�
			rVO.addRow(i, delVO.getRow(0));
		}
		
		int count = 0;
		count = outrcptmngtDAO.delOutClcj(rVO);
		return count;
	}


	/*
     * �ܷ��޺񺯰� 
     * �ܷ��̽���ó�� �̽��� ���� Ư�� ������ �߰�
     * @author cys
     * @param pVO ValueObject
     * @return ValueObjectAssembler
     * @throws LiveException
     */
	public int insOutClcj(ValueObject pVO) throws LiveException {

		String userId  = StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID));
		String sinstcd = StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE));
		ValueObject rVO = new ValueObject();

		for (int i = 0; i < pVO.size(); i++) {
			ValueObject insVO = pVO.getRowAsVo(i);
			insVO.set("sessinstcd"  , sinstcd);            //�Ҽӱ�� �ڵ�
			insVO.set("sessuserid"  , userId);             // ���������� ��� �߰�
			rVO.addRow(i, insVO.getRow(0));
		}
		
		int count = 0;
		count = outrcptmngtDAO.insOutClcj(rVO);
		return count;
	}


	/*
     * �ܷ��޺񺯰� 
     * �ܷ��̽���ó�� - ó�� �޺񱸺��ڵ� ���� ��, �ܷ�ȯ�� ���� �̷������� �����Ѵ�.
     * @author cys
     * @param pVO ValueObject
     * @return ValueObjectAssembler
     * @throws LiveException
     */
	public int setOutPatInfoHist(ValueObject pVO) throws LiveException {
		
		ValueObject setVO = null;
		
		String userId = StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID));
		String instcd = StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE));		

		int count = 0;
		
		pVO.set("sessinstcd", instcd);              // ����ڵ� �߰�			
		pVO.set("sessuserid", userId);             	// ���ʵ����
		
		count = outrcptmngtDAO.setOutPatInfoHist(pVO);
		
		return count;
	}
	
	
	/* (non-Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.OutRcptMgt#setInPatInfoHist(kr.co.hit.live.vo.ValueObject)
	 */
	public int setInPatInfoHist(ValueObject pVO) throws LiveException {
		
		ValueObject setVO = null;
		
		String userId = StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID));
		String instcd = StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE));		

		int count = 0;
		
		pVO.set("sessinstcd", instcd);              // ����ڵ� �߰�			
		pVO.set("sessuserid", userId);             	// ���ʵ����
		
		count = outrcptmngtDAO.setInPatInfoHist(pVO);
		
		return count;
	}


	/*
     * �ܷ����� ������ 
     * 
     * @author cys
     * @param pVO ValueObject
     * @return ValueObjectAssembler
     * @throws LiveException
     */
	public int setOutOrdCalcCancel(ValueObjectAssembler pVOs) throws LiveException{
		
		ValueObject retVO = new ValueObject();
		ValueObject otptVO = new ValueObject();
		ValueObject ptbsVO = new ValueObject();
		ValueObject unrcptVO = new ValueObject();

		ptbsVO = pVOs.get("ptbs");
		otptVO = pVOs.get("otpt");	

		String otpt_calcflag_org = otptVO.getString("otpt_calcflag_org");

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(otptVO.getString("sessinstcd"), "")) {
            otptVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(otptVO.getString("sessuserid"), "")) {
            otptVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
            
        }

		int count = 0;

        String sInstCd	= otptVO.getString("sessinstcd");
        String sUserId	= otptVO.getString("sessuserid");
		String workgubn = ptbsVO.getString("workgubn");            //����ȭ��:Y ����ȭ��:N

		otptVO.set("otpt_calcflag", otptVO.getString("otpt_calcflag_org"));

		if (StringHelper.strEquals(otpt_calcflag_org, "Y") || StringHelper.strEquals(otpt_calcflag_org, "S")) {
				otptVO.set("otpt_calcflag", "Y");
		}

		if (StringHelper.strEquals(otpt_calcflag_org, "N")){
				otptVO.set("otpt_calcflag", "N");
		}

		//���� otpt_calcflag_org ���� ������ ���� Ȥ�ó� �ؼ� �־��.
		if (StringHelper.strEquals(otptVO.getString("otpt_calcflag_org"), "")) {
				if(StringHelper.strEquals(workgubn,"Y")) otptVO.set("otpt_calcflag", "Y");  //�ܷ�����, ������
				if(StringHelper.strEquals(workgubn,"N")) otptVO.set("otpt_calcflag", "N");  //�ܷ�����, ������
		}

		ValueObject PreOtptVO  = outrcptmngtDAO.getPreOtptHist(otptVO);
		
		//////�̼��� ó�������˻�//////////////

		outrcptmngtDAO.setRollBackExop(otptVO); //�������°��� ������ȣ�� �������� ����

		if (StringHelper.strEquals(otptVO.getString("otpt_calcflag"), "N")) {

				otptVO.set("pid"         , otptVO.getString("otpt_pid"));
				otptVO.set("orddd"       , otptVO.getString("otpt_orddd"));
				otptVO.set("cretno"      , otptVO.getString("otpt_cretno"));
				otptVO.set("sessinstcd"  , sInstCd);
				unrcptVO = outrcptmngtDAO.getUnRcptExop(otptVO);

				if(unrcptVO.size() > 0) {
					otptVO.set("otpt_calcflag", "Y");  //�̼��� ó���� ������ ������ ������⿡ ����.
				}
		}
		//////�̼��� ó�������˻���//////////////

		if(PreOtptVO.size() > 0) {

			PreOtptVO.set("otpt_orddd_old"   , PreOtptVO.getString("otpt_orddd"));
			PreOtptVO.set("otpt_cretno_old"  , PreOtptVO.getString("otpt_cretno"));
			PreOtptVO.set("sess_userid"      , sUserId);
			PreOtptVO.set("sessuserid"       , sUserId);
			PreOtptVO.set("sessinstcd"       , sInstCd);
			PreOtptVO.set("otpt_calcflag"    , otptVO.getString("otpt_calcflag"));
			PreOtptVO.set("otpt_holdflag"    , otptVO.getString("otpt_holdflag"));  //holdflag�� ó��ѹ�ϼ� ������ �÷� �ѹ���Ѵ�.

			etcOutRgst.setOutAcpt(PreOtptVO);
		}else{
			outrcptmngtDAO.setOtptCalcflag(otptVO);
		}

			outrcptmngtDAO.delOsclCancel(otptVO);

		return count;
		
	}


    /*
     * �ܷ����� 
     * 2007.07.04. updated by ������
     * ȯ�ڱ�������
     * @param pVOs ValueObjectAssembler {}
     * @return ValueObjectAssembler
     * @throws LiveException
     */
    public ValueObjectAssembler getPidInfo(ValueObject pVO) throws LiveException {

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

		pVO.set("fromdd", DateHelper.addMonths(DateHelper.getCurrentDateAsString(), -2));
		pVO.set("todd", DateHelper.getCurrentDateAsString());
		pVO.set("checkdd", DateHelper.getCurrentDateAsString());

        ValueObjectAssembler retVOs = new ValueObjectAssembler();

        ValueObject cshb     = null;
		ValueObject dtrate    = null;
		ValueObject updtrate = null;
		ValueObject emrcnst  = null;
		ValueObject famylist  = null;
		ValueObject cvan     = null;
		ValueObject otptVO  = null;
		ValueObject mjqu  = null;
		ValueObject mjex  = null;
		ValueObject inpt  = null;
		ValueObject inptc  = null;
		ValueObject dupVO  = null;
		ValueObject aipmicpm  = null;
		ValueObject proc = new ValueObject();
		ValueObject mediexamVO = null;
		ValueObject erpatVO = null;
		ValueObject actrVO = null;
		ValueObject charityVO = null;
		ValueObject certVO = null;
	
		ValueObjectAssembler RooaVOs = new ValueObjectAssembler();
		
		String workgubn = pVO.getString("workgubn");

        try {
             cshb = outrcptmngtDAO.getPidInfoCshb(pVO);   //���ݿ����� ����Ʈ ���ι�ȣ

			if (StringHelper.strEquals(workgubn, "Y")) {
				//���� Ÿ�� 02 03 04 ���� üũ
				
				// 20090703 Ÿ�� ��������
				RooaVOs = this.fUpdtRate_check(pVO);
				//dtrate = outrcptmngtDAO.getupdtrateList1(pVO);   //�ΰ��������� ȯ�� - �����������᳻��
				//updtrate = outrcptmngtDAO.getupdtrateList(pVO);  //�ΰ��������� ȯ�� - �������泻�� ��ȸ
				updtrate = RooaVOs.get("updtratelist");
				dtrate = RooaVOs.get("dtratelist");
				
			}

			 emrcnst = pamMgt.getOrdCnstInfo(pVO);

			 famylist = patInfoMngt.getFamyList(pVO);

			 //cvan = outrcptmngtDAO.getEmtyVanCk(pVO);              //VAN ���߽��� ���� üũ

			 //mjqu = outrcptmngtDAO.getPopupMjquList(pVO);            //����ó�� ������� �˾� - ��ȸ
			
			 pVO.set("mjqu_stat"  , "R");
			 //mjex = outrcptmngtDAO.getPopupMjexList(pVO);            //����ó�� ������� �˾� - ��ȸ

			 inpt = outrcptmngtDAO.getInptInfo(pVO);                 //�������

			 inptc = outrcptmngtDAO.getInptInfo_c(pVO);             //���������

			 dupVO = etcOutRgst.getDuplRgstHist(pVO);                //�������ߺ�üũ

			 aipmicpm = pamMgt.getCheckAutoInduInsu(pVO);            //�ں�,���� ��ϳ��� ��������,�������� ��ȸ
			
			 mediexamVO = outrcptmngtDAO.getCheckMediExamInfo(pVO);  //�ǰ����� ���� ��ȸ
            
             erpatVO = outrcptmngtDAO.getCheckERInfo(pVO);           //���޽� �������� ��ȸ

			 actrVO = outrcptmngtDAO.getPopupActrList(pVO);          //�ǽ����� ���ȯ�� ��ȸ 

			 certVO = outrcptmngtDAO.getChkCertList(pVO);            //���� ������ ������ ����üũ

			if(outrcptmngtDAO.getMmsg2Check(pVO).size() > 0) {       //���� �ڰ���ȸ ���� üũ
				proc.set("opt_procyn" , "Y");
			}else{
				proc.set("opt_procyn" , "N");
			}
			
			
			//20120309 M005, M006 ���κδ��� ��� ���� ����/��Ͱ� �ƴҰ�� '-'�� ������Ʈ
			//calcflag in ('S', 'Y') -- �������
			//dracptyn = 'Y' --����Ϸ�
			//ownbflag in ('M006', 'M005') --���κδ� M005, M006
			outrcptmngtDAO.setOwnbflagCheck(pVO);
			
			//����� ���ȣ��
			otptVO = outrcptmngtDAO.getCallCalc_Otpt(pVO);

			for( int a =0; a< otptVO.size() ; a++) {
				
				//���� ���� �̷��� ���� ���� �ʰ� �̰�� ���·� �����
				if( ! StringHelper.strEquals(otptVO.getString(a, "dayflag"), "P") ){
					try{
						
						//�������� �ǽ��������� üũ�ؼ� ����Ѵ�.
						if(StringHelper.strEquals(otptVO.getString(a,"calcbaseflag"),"1")){
							outcalc.OutCalculation(otptVO.getRowAsVo(a));    //�ܷ����
						}else if(StringHelper.strEquals(otptVO.getString(a,"calcbaseflag"),"2")){
							outcalc.exeOutCalc(otptVO.getRowAsVo(a));        //�ǽ�����
						}
						
						//��� ���� �Ϸ� �� �̼��� ���·� ������Ʈ �Ѵ�.
						otptVO.set(a, "otpt_calcflag"  , "S");
						otptVO.set(a, "sessuserid"     , pVO.getString("sessuserid"));
						otptVO.set(a, "otpt_pid"        , otptVO.getString(a, "pid"));
						otptVO.set(a, "otpt_orddd"     , otptVO.getString(a, "orddd"));
						otptVO.set(a, "otpt_cretno"    , otptVO.getString(a, "cretno"));
						otptVO.set(a, "sessinstcd"      , pVO.getString("sessinstcd"));
						outrcptmngtDAO.setOtptCalcflag(otptVO.getRowAsVo(a));
						
					}catch (LiveException le) {
						
						//��� �� ���� �߻� �� �̰�� ���·� ������Ʈ �Ѵ�.
						otptVO.set(a, "otpt_calcflag"  , "Y");
						otptVO.set(a, "sessuserid"     , pVO.getString("sessuserid"));
						otptVO.set(a, "otpt_pid"        , otptVO.getString(a, "pid"));
						otptVO.set(a, "otpt_orddd"     , otptVO.getString(a, "orddd"));
						otptVO.set(a, "otpt_cretno"    , otptVO.getString(a, "cretno"));
						otptVO.set(a, "sessinstcd"      , pVO.getString("sessinstcd"));
						outrcptmngtDAO.setOtptCalcflag(otptVO.getRowAsVo(a));
					}
					
				}else{
					
					//���� ������ �̰������ ������Ʈ �Ѵ�. ������ �����ϵ��� �ϱ� ����.
					otptVO.set(a, "otpt_calcflag"  , "Y");
					otptVO.set(a, "sessuserid"     , pVO.getString("sessuserid"));
					otptVO.set(a, "otpt_pid"        , otptVO.getString(a, "pid"));
					otptVO.set(a, "otpt_orddd"     , otptVO.getString(a, "orddd"));
					otptVO.set(a, "otpt_cretno"    , otptVO.getString(a, "cretno"));
					otptVO.set(a, "sessinstcd"      , pVO.getString("sessinstcd"));
					outrcptmngtDAO.setOtptCalcflag(otptVO.getRowAsVo(a));
				}
			}

			/*
			for( int a =0; a< otptVO.size() ; a++) {	
				otptVO.set(a, "otpt_calcflag"  , "S");
				otptVO.set(a, "sessuserid"     , pVO.getString("sessuserid"));
				otptVO.set(a, "otpt_pid"        , otptVO.getString(a, "pid"));
				otptVO.set(a, "otpt_orddd"     , otptVO.getString(a, "orddd"));
				otptVO.set(a, "otpt_cretno"    , otptVO.getString(a, "cretno"));
				otptVO.set(a, "sessinstcd"      , pVO.getString("sessinstcd"));
				outrcptmngtDAO.setOtptCalcflag(otptVO.getRowAsVo(a));
			}
			*/
			
			//����� ���ȣ�� ��

			charityVO = charityMgt.reqGetCharityYN(pVO);

        } catch (LiveException le) {
            throw le;
        } catch (Exception e) {
            throw new LiveException("com.error.90000", e);
        }
/*
		retVOs = pamMgt.getComCD(pVO);

		retVOs.set("P0034"      , this.getZbcmCode("P0034",""));
		retVOs.set("amtdispkind", this.getPmcmCodeNm("P0022","90"));
		retVOs.set("kioskyn"    , this.getPmcmCodeNm("P0029","%"));
		retVOs.set("P0071"      , this.getPmcmCodeNm("P0071","%"));
		retVOs.set("P0032"      , this.getPmcmCodeNm("P0032","%"));
*/
        retVOs.set("cshb"				,  cshb);
		retVOs.set("dtratelist"			,  dtrate);
		retVOs.set("updtratelist"		,  updtrate);
		retVOs.set("emrcnst"			,  emrcnst);
		retVOs.set("famylist"			,  famylist);
		retVOs.set("cvan"				,  cvan);
		retVOs.set("mjqu"				,  mjqu);
		retVOs.set("mjex"				,  mjex);
		retVOs.set("inpt"				,  inpt);
		retVOs.set("inptc"				,  inptc);
		retVOs.set("otptduplhist"		,  dupVO);
		retVOs.set("aipmicpm"			,  aipmicpm);
		retVOs.set("proc"				,  proc);
		retVOs.set("mediexam"			,  mediexamVO);
		retVOs.set("erpat"				,  erpatVO);
		retVOs.set("actr"				,  actrVO);
		retVOs.set("charity"            ,  charityVO);	 //�ڼ�ȯ������ ��ȸ
		retVOs.set("cert"				,  certVO);
        return retVOs;
    }

	/*
	 * (��Javadoc)
	 * �ǻ�Ұ߼������˾� ��ȸ
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.getDrcmList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getDrcmList(ValueObject pVO) throws LiveException{

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
		return outrcptmngtDAO.getDrcmList(pVO);
		
	}


	/*
	 * (��Javadoc)
	 * �ǻ�Ұ߼������˾� ����
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;setDrcmList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject setDrcmList(ValueObject pVO) throws LiveException{
		
        ValueObject retVO  = new ValueObject();
        ValueObject tempVO = new ValueObject();
        ValueObject exopVO = new ValueObject();
		ValueObject otptVO = new ValueObject();
        
        String sInstCd = "";
        String sUserId = "";
        String calcscorcd_drcm = "";
		String otptkey = "";

        int cnt = -1;
		Boolean drcm_exist = false;

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

        sInstCd = pVO.getString("sessinstcd");
        sUserId = pVO.getString("sessuserid");

        if(StringHelper.strEquals(pVO.getString("flag"), "insert")) {

            outrcptmngtDAO.delDrcmList(pVO);

            cnt = outrcptmngtDAO.insDrcmList(pVO);
            
            //�ǻ�Ұ߼� �����ڵ带 ���ؿ´�.
            pVO.set("detldesc"  , "�ǻ�Ұ߼�");
            tempVO = outrcptmngtDAO.getPmcmCode(pVO);
            calcscorcd_drcm = tempVO.getString("cdnm","");

			//��ϳ�����ȸ
			pVO.set("opmi_pid"      , pVO.getString("pid"));
			pVO.set("opmi_orddd"    , pVO.getString("orddd"));
			pVO.set("opmi_cretno"   , pVO.getString("cretno"));
			otptVO = outrcptmngtDAO.getRcptOtptList(pVO);

            //ó����ȸ
            exopVO = outrcptmngtDAO.getExopList(pVO);

			for (int a=0; a< exopVO.size(); a++) {	

				if(StringHelper.strEquals(exopVO.getString(a,"calcscorcd"), calcscorcd_drcm)) drcm_exist = true;
				
			}

			if(exopVO.size() > 0 ) {

				//�ǻ�Ұ߼� ����ó��� ������ ������ ����
				if(drcm_exist && exopVO.size() == 1) {

					pVO.set("medamtestmyn"   , "N");
					pVO.set("medamtfreeresn" , "15");
					outrcptmngtDAO.setOtpt_drcm(pVO);
				}  

				//�о����ܻ��� ���Ű�ȯ�ڴ� ������ ���������
				if (drcm_exist && StringHelper.strEquals(otptVO.getString("hosoutexptresncd") , "13")) {

					pVO.set("medamtestmyn"   , "N");
					pVO.set("medamtfreeresn" , "15");
					outrcptmngtDAO.setOtpt_drcm(pVO);
					
				} 
			
			}
		}

        if(StringHelper.strEquals(pVO.getString("flag"), "delete")) {
            outrcptmngtDAO.delDrcmList(pVO);
        }

		//�ǻ�Ұ߼� �����Ŀ��� ��� �ٽõ���
		/////////////////////////////////
        otptkey = pVO.getString( "orddd") + "_" + pVO.getString("cretno") + "','" + otptkey;

		pVO.set("otptkey" , otptkey);

		otptVO = outrcptmngtDAO.getIFOAmtZeroOtpt(pVO);

		outcalc.OutCalculation(otptVO); 		

		otptVO.set( "otpt_calcflag"  , "S");
		otptVO.set( "sessuserid"     , pVO.getString("sessuserid"));
		otptVO.set( "otpt_pid"        , otptVO.getString( "pid"));
		otptVO.set( "otpt_orddd"     , otptVO.getString( "orddd"));
		otptVO.set( "otpt_cretno"    , otptVO.getString("cretno"));
		otptVO.set( "sessinstcd"      , pVO.getString("sessinstcd"));
		outrcptmngtDAO.setOtptCalcflag(otptVO);
		/////////////////////////////////


        retVO.set("cnt", cnt);
        
        return retVO;
		
	}


	/*
     * �ܷ�������� 
     * 2007.07.07. updated by ������
     * �ܷ����� ������ ���̺� ��������
     * @param pVOs ValueObjectAssembler {}
     * @return ValueObjectAssembler
     * @throws LiveException
     */
    public ValueObject getOtptDetailTB(ValueObject pVO) throws LiveException {

		ValueObject retVO = new ValueObject();

		//����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

			pVO.set("pid"      , pVO.getString("otpt_pid"));          
			pVO.set("orddd"    , pVO.getString("otpt_orddd"));          
			pVO.set("cretno"   , pVO.getString("otpt_cretno"));          
			pVO.set("instcd"   , pVO.getString("otpt_instcd"));          
			pVO.set("ordtype"  , pVO.getString("otpt_ordtype"));

		try {

			ValueObject drcm = outrcptmngtDAO.getDrcmList(pVO);
			ValueObject hocm = outrcptmngtDAO.getHocmList(pVO);

			if(drcm.size() == 0) {drcm.set("temp", "temp");}
			if(hocm.size() == 0) {hocm.set("temp", "temp");}
			
			//�ǻ�Ұ߼�///////////////////////////////////////////////
			retVO.set("drcm_pid"         , drcm.getString("drcm_pid"));          
			retVO.set("drcm_orddd"       , drcm.getString("drcm_orddd"));       
			retVO.set("drcm_cretno"      , drcm.getString("drcm_cretno"));      
			retVO.set("drcm_instcd"      , drcm.getString("drcm_instcd"));      
			retVO.set("drcm_ordtype"     , drcm.getString("drcm_ordtype"));     
			retVO.set("drcm_mngtno"      , drcm.getString("drcm_mngtno"));      
			retVO.set("drcm_qualflag"    , drcm.getString("drcm_qualflag"));    
			retVO.set("drcm_fstrgstrid"  , drcm.getString("drcm_fstrgstrid"));  
			retVO.set("drcm_fstrgstdt"   , drcm.getString("drcm_fstrgstdt"));   
			retVO.set("drcm_lastupdtrid" , drcm.getString("drcm_lastupdtrid")); 
			retVO.set("drcm_lastupdtdt"  , drcm.getString("drcm_lastupdtdt"));
			retVO.set("drcm_exop_cnt"    , hocm.getString("drcm_exop_cnt"));
			//�ǻ�Ұ߼� ��///////////////////////////////////////////////

			//�湮��ȣ���ü�///////////////////////////////////////////////
			retVO.set("hocm_instcd"      , hocm.getString("hocm_instcd"));      
			retVO.set("hocm_pid"		 , hocm.getString("hocm_pid"));         
			retVO.set("hocm_orddd"		 , hocm.getString("hocm_orddd"));       
			retVO.set("hocm_cretno"		 , hocm.getString("hocm_cretno"));      
			retVO.set("hocm_ordtype"	 , hocm.getString("hocm_ordtype"));     
			retVO.set("hocm_mngtno"		 , hocm.getString("hocm_mngtno"));      
			retVO.set("hocm_qualflag"	 , hocm.getString("hocm_qualflag"));    
			retVO.set("hocm_licnsno"	 , hocm.getString("hocm_licnsno"));     
			retVO.set("hocm_inhosflag"	 , hocm.getString("hocm_inhosflag"));   
			retVO.set("hocm_claimstat"	 , hocm.getString("hocm_claimstat"));   
			retVO.set("hocm_fstrgstrid"	 , hocm.getString("hocm_fstrgstrid"));  
			retVO.set("hocm_fstrgstdt"	 , hocm.getString("hocm_fstrgstdt"));   
			retVO.set("hocm_lastupdtrid" , hocm.getString("hocm_lastupdtrid")); 
			retVO.set("hocm_lastupdtdt"  , hocm.getString("hocm_lastupdtdt"));  
			retVO.set("hocm_exop_cnt"    , hocm.getString("hocm_exop_cnt"));
			//�湮��ȣ���ü� ��///////////////////////////////////////////////

        } catch (LiveException le) {
            throw le;
        } catch (Exception e) {
            throw new LiveException("com.error.90000", e);
        }

        return retVO;
    }


    /*
	 * (��Javadoc)
	 * �湮��ȣ���ü��˾� ��ȸ
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.getHocmList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getHocmList(ValueObject pVO) throws LiveException{

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
		return outrcptmngtDAO.getHocmList(pVO);
		
	}


	/*
	 * (��Javadoc)
	 * �湮��ȣ���ü��˾� ����
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;setHocmList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject setHocmList(ValueObject pVO) throws LiveException{
		
		ValueObject retVO = new ValueObject();
        ValueObject tempVO = new ValueObject();
        ValueObject exopVO = new ValueObject();
		
        String sInstCd = "";
        String sUserId = "";
		String calcscorcd_hocm = "";
		int cnt = -1;

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

        sInstCd = pVO.getString("sessinstcd");
        sUserId = pVO.getString("sessuserid");

		if(StringHelper.strEquals(pVO.getString("flag"), "insert")) {

			outrcptmngtDAO.delHocmList(pVO);

			cnt = outrcptmngtDAO.insHocmList(pVO);

            //�湮��ȣ���ü� �����ڵ带 ���ؿ´�.
            pVO.set("detldesc"  , "�湮��ȣ���ü�");
            tempVO = outrcptmngtDAO.getPmcmCode(pVO);
            calcscorcd_hocm = tempVO.getString("cdnm","");

            //ó����ȸ
            exopVO = outrcptmngtDAO.getExopList(pVO);
			
			/*
            int hocm_cnt = 0;
            
            //�湮��ȣ���ü� �����ڵ尳�� ��ȸ
            for(int a = 0; a < exopVO.size(); a++){
                if(StringHelper.strEquals(exopVO.getString(a,"calcscorcd"), calcscorcd_hocm)) {
                    hocm_cnt = hocm_cnt + 1;
                }
            }
			*/

            //�湮��ȣ���ü� ����ó��� ������ ������ ����
			if(exopVO.size() > 0 ) {
				if(StringHelper.strEquals(exopVO.getString("calcscorcd"), calcscorcd_hocm) && exopVO.size() == 1) {
					pVO.set("medamtestmyn"   , "N");
					pVO.set("medamtfreeresn" , "16");
					outrcptmngtDAO.setOtpt_drcm(pVO);
				}

			}

		}

		if(StringHelper.strEquals(pVO.getString("flag"), "delete")) {

			outrcptmngtDAO.delHocmList(pVO);

		}

		retVO.set("cnt", cnt);
		
		return retVO;
			
	}


    /*
     * �ǻ�����ȣ��ȸ
     * 2007.07.07. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getUsrdlicnsno(ValueObject pVO) throws LiveException{

		return outrcptmngtDAO.getUsrdlicnsno(pVO);
		
	}


	/*
     * �ܷ����� 
     * 2007.07.05. updated by ������
     * �ܷ����� �ʼ� üũ����
     * @param pVOs ValueObjectAssembler {}
     * @return ValueObjectAssembler
     * @throws LiveException
     */
    public ValueObject outOrd_Check(ValueObjectAssembler pVOs , String caller , String instcd , String userId) throws LiveException {

		// caller : ȣ�����[��������,���,������üũ,����]
		String msg                = "";
		String msg_type           = "";
		String bldc_ck            = "";
		String calcscorcd_drcm    = "";
		String calcscorcd_hocm    = "";
		String msg_vtclck         = "";
		String msg_vtclck_uncoamt = "0";
		String msg_vtclck_uncocd  = "";
		String msg_vtclck_unconm  = "";
        String msg_bldc           = "";
		String msg_compare_oscl   = "";
		String msg_specordyn      = "";
		String msg_mental         = "";
		String msg_estm           = "";
		String msg_proc           = "";
		String msg_prvntmedccd    = "";
		String msg_prvntmeddiscccd    = "";
		String msg_prvntmedcamt   = "0";
		String msg_prvntmedcdiscamt   = "0";
		
		//20111024 ��õ������̻�˻� �̼� �߰�
		String msg_inbornuncocd    = "";
		String msg_inborndiscccd    = "";
		String msg_inbornuncoamt   = "0";
		String msg_inborndiscamt   = "0";
		
		String msg_drcm           = "";
		String msg_hocm           = "";
        String msg_etcm           = "";

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(instcd, "")) {
            instcd = StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(userId, "")) {
            userId = StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID));
        }

		ValueObject retVO = new ValueObject();
		ValueObject otpt  = new ValueObject();
        ValueObject oscl_org  = new ValueObject();
		ValueObject oscl  = new ValueObject();
		ValueObject exop  = new ValueObject();
		ValueObject temp  = new ValueObject();
		ValueObject bldc  = new ValueObject();
		ValueObject opmi  = new ValueObject();
		ValueObject prvntmedVO = new ValueObject();
		
		//20111024 ��õ������̻�˻� �߰�
		ValueObject inbornVO = new ValueObject();
		
        ValueObject etcmVO = new ValueObject();

		otpt   = pVOs.get("otpt");					  //�ܷ��������

	    
		if(pVOs.isExist("oscl")) {
			oscl_org = pVOs.get("oscl");		      //�ܷ��������
		}else{
			oscl_org = outrcptmngtDAO.getOsclInfo(otpt);
		}

		exop   = outrcptmngtDAO.getExopList(otpt);  //�ܷ�ó������

		bldc   = pVOs.get("bldc");	 //���װ�����ȸ 

		//--------------�����ڵ�--------------------------------------------
		temp.set("detldesc"  , "�ǻ�Ұ߼�");
		temp.set("sessinstcd", instcd);

		temp = outrcptmngtDAO.getPmcmCode(temp);

		//�Ұ߼� ����ó���� ���
		if(temp.size() == 0 ) {
			throw new LiveException("�ǻ�Ұ߼� �ڵ尡 �����ϴ�. �������� �����ؼ� pmcmcode���̺� �ǻ�Ұ߼��ڵ尡 �ִ��� �����Ͻʽÿ�");
		}

		calcscorcd_drcm = temp.getString("cdnm","");
		temp.clear();	

        //-------------------------------------------------------------------

		temp.set("detldesc"  , "�湮��ȣ���ü�");
		temp.set("sessinstcd", instcd);

		temp = outrcptmngtDAO.getPmcmCode(temp);

		//�Ұ߼� ����ó���� ���
		if(temp.size() == 0 ) {
			throw new LiveException("�湮��ȣ���ü� �ڵ尡 �����ϴ�. �������� �����ؼ� pmcmcode���̺� �湮��ȣ���ü��ڵ尡 �ִ��� �����Ͻʽÿ�");
		}

		calcscorcd_hocm = temp.getString("cdnm","");
		temp.clear();

		//�����ڵ�(ACD0002)������ �ǻ�Ұ߼�,�湮��ȣ���ü� üũ�ϴµ� ���� �N�ϴ�. 
		for(int a=0; a < oscl_org.size(); a++) {
			if(!StringHelper.strEquals(oscl_org.getString(a, "snglcalcscorcd"),this.getPmcmCodeNm("P0032","181").getString("cdnm"))) {
				int iLastRow1 = oscl.size();					 
				Map<String, Object> pMap1 = oscl_org.getRow(a);
				oscl.addRow(iLastRow1, pMap1);
			}
		}


		//--------------�����ڵ� ��-------------------------------------
        try { 

			if(oscl.size() > 0){

				for(int a=0; a < oscl.size(); a++) {

					//�Ǿ�ǰ������(AL501)�� üũ ���
					if (StringHelper.strEquals(oscl.getString(a, "snglcalcscorcd"),this.getPmcmCodeNm("P0032","182").getString("cdnm"))) {
						continue;
					}
					
					oscl.set(a, "sessinstcd" ,instcd);
					oscl.set(a, "sessuserid" ,userId);

					//�� ��ȯ�̰� �����౹�Ͻ�(���� ����ó���� ���ǿ��� ����) 0:����1:�⺻2:�����ִ�����3:�����������4:���5:��Ź6:����
					// 08/11/26 ������ matractflag���� üũ������ ���ǿ� �ȸ¾Ƽ� �����Ű�� ��찡�־� ���ܽ�Ŵ
				    if (StringHelper.strEquals(oscl.getString(a, "execprcphistcd"),"E")) {

						String sngcl = oscl.getString(a, "snglcalcscorcd");

						throw new LiveException("�ݳ��Ƿ�ó��[ "+sngcl+" ]�� �߻��Ͽ����ϴ�. �ش�μ�[�౹]�� �ݳ��Ͻð�, �����ϼž� �մϴ�.");
					}
					
////////////////////////�ǻ�Ұ߼� ó��////////////////////////////
					//�Ұ߼� ����ó���� ���
					
					if (StringHelper.strEquals(oscl.getString(a, "snglcalcscorcd"), calcscorcd_drcm) && oscl.size() == 2
					){
						ValueObject drcm = outrcptmngtDAO.getDrcmList(oscl);  //�ǻ�Ұ߼������˾� ��ȸ

						if(drcm.size() == 0 ) {
							throw new LiveException("�ǻ�Ұ߼� ����ó�����ֽ��ϴ�. �ǻ�Ұ߼� ������ȣ, ���κδ㱸���� �Է����ּ���.");
						}

						if(StringHelper.strEquals(caller,"������üũ")) {

							if(!StringHelper.strEquals(otpt.getString("medamtestmyn")  , "N") ||
							   !StringHelper.strEquals(otpt.getString("medamtfreeresn"), "15")	
							)  {
								throw new LiveException("�ǻ�Ұ߼� ����ó���̹Ƿ� �������������: ���� ����:�ǻ�Ұ߼��߱����� �����մϴ�.");
							}
						}
					}

					//�Ұ߼� �� ��Ÿó�����ִ� ���
					if (StringHelper.strEquals(oscl.getString(a, "snglcalcscorcd"),calcscorcd_drcm) && oscl.size() > 2
					){
						ValueObject drcm = outrcptmngtDAO.getDrcmList(oscl);  //�ǻ�Ұ߼������˾� ��ȸ
						
						if(drcm.size() == 0 ) {
							throw new LiveException("�ǻ�Ұ߼�ó���� �ֽ��ϴ�. �ǻ�Ұ߼� ������ȣ, ���κδ㱸���� �Է����ּ���.");
						}

						if(StringHelper.strEquals(caller,"������üũ")) {
							if(StringHelper.strEquals(otpt.getString("medamtestmyn")  , "N")){
								msg_drcm = "�ǻ�Ұ߼� �� Ÿó�浵 �����ֽ��ϴ�. �����Ῡ��: �������� �����Ͻðڽ��ϱ�?";
							}
						}

					}
////////////////////////�ǻ�Ұ߼� ó����////////////////////////////

////////////////////////�湮��ȣ���ü� ó��////////////////////////////
					//���ü� ����ó���� ���
					if (StringHelper.strEquals(oscl.getString(a, "snglcalcscorcd"), calcscorcd_hocm) && oscl.size() == 2
					){
						ValueObject hocm = outrcptmngtDAO.getHocmList(oscl);  //�湮��ȣ���ü� �˾� ��ȸ
						
						if(hocm.size() == 0 ) {
							throw new LiveException("�湮��ȣ���ü� ����ó�����ֽ��ϴ�. �湮��ȣ���ü� �߱޹�ȣ, ���κδ㱸���� �Է����ּ���.");
						}

						if(StringHelper.strEquals(caller,"������üũ")) {

							if(!StringHelper.strEquals(otpt.getString("medamtestmyn")  , "N") ||
							   !StringHelper.strEquals(otpt.getString("medamtfreeresn"), "16")	
							)  {
								throw new LiveException("�湮��ȣ���ü� ����ó���̹Ƿ� �������������: ���� ����:�湮��ȣ���ü��߱����� �����մϴ�.");
							}
						}
					}

					//���ü� �� ��Ÿó�����ִ� ���
					if (StringHelper.strEquals(oscl.getString(a, "snglcalcscorcd"),calcscorcd_hocm) && oscl.size() > 2
					){
						ValueObject hocm = outrcptmngtDAO.getHocmList(oscl);  //�湮��ȣ���ü� �˾� ��ȸ
						
						if(hocm.size() == 0 ) {
							throw new LiveException("�湮��ȣ���ü� ó�����ֽ��ϴ�. �湮��ȣ���ü� �߱޹�ȣ, ���κδ㱸���� �Է����ּ���.");
						}
					
						if(StringHelper.strEquals(caller,"������üũ")) {

							if(StringHelper.strEquals(otpt.getString("medamtestmyn")  , "N")){
								msg_hocm = "�湮��ȣ���ü� �� Ÿó�浵 �����ֽ��ϴ�. �����Ῡ��: �������� �����Ͻðڽ��ϱ�?";
							}
						}
					
					}
////////////////////////�湮��ȣ���ü� ó����////////////////////////////
				}
			}


///////////////////////���״�üó�� ����Ȯ��///////////////////////////////
					ValueObject bldc_temp = new ValueObject();
					bldc_temp = pamMgt.getBldcCalcList(otpt).get("bldc");

					if(bldc_temp.size() > 0 && StringHelper.strEquals(caller,"��������")) {
						msg                = "���״�üó������" + '\n' + msg;
						msg_bldc           = "���״�üó������";
					}
///////////////////////���״�üó�� ����Ȯ�γ�///////////////////////////////	


///////////////////////���״�üó�� ����Ȯ��///////////////////////////////
			if(pVOs.isExist("bldc")){
				
				bldc_ck = "N";
				for(int b=0; b < bldc.size(); b++) {

					for(int a=0; a < exop.size(); a++) {

						if (StringHelper.strEquals(bldc.getString(b, "grupcalcscorcd")    , exop.getString(a, "calcscorcd"))   &&
							StringHelper.strEquals(bldc.getString(b, "prcpdd")            , exop.getString(a, "prcpdd"))       &&
							StringHelper.strEquals(bldc.getString(b, "prcpno")            , exop.getString(a, "prcpno"))       &&
							StringHelper.strEquals(bldc.getString(b, "prcphistno")        , exop.getString(a, "prcphistno"))    
						){
							bldc_ck = "Y";
							break;
						}else{
							bldc_ck = "N";
						}
					}

					if(StringHelper.strEquals(bldc_ck, "N") && StringHelper.strEquals(caller, "����")) {
						throw new LiveException("���״�ü���� ���泻���� �ֽ��ϴ�.");
					}
				
				}
			}
///////////////////////���״�üó�� ����Ȯ�� ��///////////////////////////////

///////////////////////ASIS_TOBE �ݾ׺�///////////////////////////////
		if(pVOs.isExist("oscl") && oscl.size() > 0 && StringHelper.strEquals(caller,"��������")){

			if(!StringHelper.strEquals(oscl.getString("asistobe"), null) && 
			   !StringHelper.strEquals(oscl.getString("asistobe"), "0")) {

				msg_compare_oscl = "ASIS ���κδ� :" + oscl.getString("asisamt") + " ,TOBE ���κδ� :" + oscl.getString("tobeamt") + 
								   " ���� :" + oscl.getString("asistobe") + '\n' + "��������Ͻðڽ��ϱ�?";
				msg_type         = "Q";
			}
		}
///////////////////////ASIS_TOBE �ݾ׺� ��///////////////////////////////

///////////////////////�Ϲ���-Ư���� ���濩��///////////////////////////////
		if(StringHelper.strEquals(caller,"��������")) {

			boolean spec_chk = true;

			if(StringHelper.strEquals(otpt.getString("medamtestmyn"),"N")) {
					spec_chk = false;
			}

			if(StringHelper.strEquals(otpt.getString("rsrvflag"),"E") && StringHelper.strEquals(otpt.getString("suppkind"),"02")) {
					spec_chk = false;
			}

			if(spec_chk) {

					ValueObject OrdChngVO  = new ValueObject();

					otpt.set("otpt_orddrid"     , otpt.getString("orddrid"));
					otpt.set("otpt_specordyn"   , otpt.getString("specordyn"));
					otpt.set("instcd"           , instcd);
					otpt.set("otpt_instcd"      , instcd);
					otpt.set("otpt_orddeptcd"   , otpt.getString("orddeptcd"));

					OrdChngVO = etcOutRgst.getSpecOrdChngYN(otpt);

					if(StringHelper.strEquals(OrdChngVO.getString("specordchngyn"), "Y")) {

						if(StringHelper.strEquals(otpt.getString("specordyn"), "N")){
							msg_specordyn ="�ش��ǻ簡 �Ϲ��ǻ翡�� Ư���ǻ�� ����Ǿ����ϴ�. �ұ�ó���Ͻʽÿ�.";
						}
						if(StringHelper.strEquals(otpt.getString("specordyn"), "Y")){
							msg_specordyn ="�ش��ǻ簡 Ư���ǻ翡�� �Ϲ��ǻ�� ����Ǿ����ϴ�. �ұ�ó���Ͻʽÿ�.";
						}
					}
			}
			
		}
///////////////////////�Ϲ���-Ư���� ���濩�� ��///////////////////////////////

///////////////////////������� ���� �´��� üũ///////////////////////////////
		if(StringHelper.strEquals(caller,"���")) {

//			if(StringHelper.strEquals(otpt.getString("refundyn"),"�������") &&  StringHelper.strEquals(otpt.getString("prcpgenryn"),"1A")) {
/*			if ( (StringHelper.strEquals(otpt.getString("etcordflag"),"M")  && StringHelper.strEquals(otpt.getString("medamtestmyn"),"N")) ||

	                 (StringHelper.strEquals(otpt.getString("etcordflag"),"J")   && StringHelper.strEquals(otpt.getString("medamtestmyn"),"N")) ||

	                 (StringHelper.strEquals(otpt.getString("etcordflag"),"T")   && StringHelper.strEquals(otpt.getString("medamtestmyn"),"N")  && StringHelper.strEquals(otpt.getString("orddeptcd"),"2170000000")) ||

	                 (StringHelper.strEquals(otpt.getString("rsrvflag"),"A")      && StringHelper.strEquals(otpt.getString("medamtestmyn"),"N")  && StringHelper.strEquals(otpt.getString("specordyn"),"N")) ||

	                 (StringHelper.strEquals(otpt.getString("refundyn") ,"�������"))
	        ) {*/
			if(StringHelper.strEquals(otpt.getString("refundyn"),"�������")) {

						 if( StringHelper.strEquals(otpt.getString("nursacptyn") , "Y")  ||   //��ȣ��������
							 StringHelper.strEquals(otpt.getString("dracptyn")   , "Y")       //�ǻ���������
						 ) {
							 throw new LiveException("��������Ҽ� �����ϴ�. ��ȣ��������[ "+otpt.getString("nursacptyn")+" ],�ǻ���������[ "+otpt.getString("dracptyn")+" ]");
						 }
			}
		}
///////////////////////������� ���� �´��� üũ///////////////////////////////


///////////////////////���Ű� ȯ�� ���������� �������� �ȸ´� ���̽� üũ//////////////////////////////
		if(StringHelper.strEquals(caller,"��������")) {

			String  msg_mental1 ="";
			String  msg_mental2 ="";
			String  msg_mental3 ="";

			if(StringHelper.strEquals(otpt.getString("orddeptcd"),"2030000000")) {


						if(StringHelper.strEquals(otpt.getString("insukind"),"21") ||
						   StringHelper.strEquals(otpt.getString("insukind"),"22"))  {

								if(StringHelper.strEquals(otpt.getString("suppkind"),"00") &&
								   StringHelper.strEquals(otpt.getString("ordreqformflag"),"3")){ 
										
										msg_mental1 = otpt.getString("orddd") +" "+ msg_mental1;
								}

								if(StringHelper.strEquals(otpt.getString("suppkind"),"14") &&
								  !StringHelper.strEquals(otpt.getString("ordreqformflag"),"3")){ 
										
										msg_mental2 = otpt.getString("orddd") +" "+ msg_mental2;
								}
						}

			}


			if(!StringHelper.strEquals(otpt.getString("orddeptcd"),"2030000000")) {

						if(StringHelper.strEquals(otpt.getString("insukind"),"21") ||
						   StringHelper.strEquals(otpt.getString("insukind"),"22"))  {

								if(StringHelper.strEquals(otpt.getString("suppkind"),"14")) {
										msg_mental3 = otpt.getString("orddd") +" "+ msg_mental3;
								}
						}
			}

			if(!StringHelper.strEquals(msg_mental1,"")) {
					msg_mental = "���Ű� ����ȯ���ε� �������� �������� �Ǿ� �ֽ��ϴ�. ���Ű� �������� �����ϼž� �մϴ�.\n�������� :" + msg_mental1 + "";
			}

			if(!StringHelper.strEquals(msg_mental2,"")) {
					msg_mental = "���Ű� ���� ��� ȯ�ڰ� �ƴմϴ�. �������� 01 ���׺��κδ����� �����ϼž� �մϴ�.\n�������� :" + msg_mental2 + "";
			}

			if(!StringHelper.strEquals(msg_mental3,"")) {
					msg_mental = "���Ű� ���� ��� ȯ�ڰ� �ƴմϴ�. ���������� �����ϼž� �մϴ�.\n�������� :" + msg_mental3 + "";
			}

		}
///////////////////////���Ű� ȯ�� ���������� �������� �ȸ´� ���̽� üũ ��//////////////////////////////
		
		
		//�̹��� ����ó�� ���� üũ msg ó�� start
        //�౹���� ���� ȣ��
		/*
		 * @ �ʿ��Ķ����
			pid, 
			orddd(actingorddd ���� �ƴ�), 
			cretno,
			orddeptcd,
			orddrid,
			instcd,
			ioflag(�Կ�/�ܷ�����(I/O), ���⼭�� "O"�� �־���)
			prcpgenrflag(ã�� ����� "O"�� �־���)
			
		*/
        String sToDay = DateHelper.getCurrentDateAsString();
        String sDrugMsg = "";
        //���� ���ڰ͸� üũ �ϸ� �ɵ���!
        if (sToDay.compareTo(otpt.getString("orddd")) > 0) {
			ValueObject tmpPharmVO = new ValueObject();
			ValueObject drugVO = new ValueObject();
			ValueObjectAssembler drugVOs = new ValueObjectAssembler();
			ValueObjectAssembler retDrugVOs = new ValueObjectAssembler();
			ValueObject aaVO = new ValueObject();
	
			drugVO.set("opmi_pid"       , otpt.getString("pid"));
	        drugVO.set("opmi_orddd"     , otpt.getString("orddd"));
	        drugVO.set("opmi_cretno"    , otpt.getString("cretno"));
	        drugVO.set("sessinstcd"    , instcd);
	        
            //ActingOrddd �� �ƴ�, Orddd ���ϱ�
            //input : opmi_pid, opmi_orddd, opmi_cretno
            //tmpPharmVO = outrcptmngtDAO.getOrddd(drugVO);
            //if (tmpPharmVO.size() > 0) {

            //������ ó������Ƿ�, ��ȸ�Ǽ� 0
            if (this.getOrddd(drugVO).size() > 0) {

                if (StringHelper.strEquals(this.getPmcmCodeNm("P0032","-").getString("cdnm"),"Y")) {
                    drugVO = this.getOrddd(drugVO);
                }else{
                    drugVO.set("pid"         , otpt.getString("pid"));
                    drugVO.set("orddd"       , otpt.getString("orddd"));
                    drugVO.set("cretno"      , otpt.getString("cretno"));
                    drugVO.set("orddeptcd"   , otpt.getString("orddeptcd"));
                    drugVO.set("orddrid"     , otpt.getString("orddeptcd"));
                    drugVO.set("instcd"      , instcd);
                    drugVO.set("ioflag"      , "O");
                    drugVO.set("prcpgenrflag", "O");
                }

				if ( log.isDebugEnabled() ) {
			   		 log.debug("**----�౹ ó�� �Ⱓ üũ msg getOutDrugMsg Start------**  " );
				}
				
				drugVOs.set("req", drugVO);
				retDrugVOs = pharmlib.getOutDrugMsg(drugVOs);
				
				aaVO = retDrugVOs.get("result");
				
				
				if (aaVO.size() > 0) {
					if(!StringHelper.strEquals(StringHelper.null2void(aaVO.getString("outdrugmsg")),"")) {
						sDrugMsg = aaVO.getString("outdrugmsg");
					}
				}
				//sDrugMsg="����ΰ��� ���� ��ȯ�ϴ��� Ȧ���ϰ� ����ó�� �ϻ�.";
				
				if ( log.isDebugEnabled() ) {
					log.debug("**---- �౹ ó�� �Ⱓ üũ msg_drugmsg >" +  sDrugMsg);
			   		log.debug("**---- �౹ ó�� �Ⱓ üũ msg getOutDrugMsg End------**  " );
				}
			}
        }
		//�̹��� ����ó�� ���� üũ msg ó�� end
		


       ///////////�ܱ��� ���� üũ//////////////
        String msg_oecdyn="";
        if(StringHelper.strEquals(caller,"��������")) {
	        if(StringHelper.strEquals(otpt.getString("insukind"),"51") || StringHelper.strEquals(otpt.getString("insukind"),"61")) {
		        if (StringHelper.strEquals(caller,"��������")) { 
		        	if (StringHelper.strEquals(this.getPmcmCodeNm("P0032","160").getString("cdnm"),"Y")) {
		        		ValueObject oecdVO  = outrcptmngtDAO.getPatOectChk(otpt);
		        		if (oecdVO.size() > 0) {
		        			String SNatiNM = StringHelper.null2void(oecdVO.getString("natinm"));
			        		if (StringHelper.strEquals(StringHelper.null2void(oecdVO.getString("oecdyn")),"Y")) {
			        			msg_oecdyn = SNatiNM + " OECD ȸ�����Դϴ�. [61.�ܱ���]�������� ����ó�� �Ͻʽÿ�.";
			        		} else {
			        			msg_oecdyn = SNatiNM + " OECD ��ȸ�����Դϴ�. [51.�Ϲ�]�������� ���� �� [61.�ܱ���]�������� ���� ����ó�� �Ͻʽÿ�.";
			        		}
		        		}
		        	}
		        }
	        }
        }
        if ( log.isDebugEnabled() ) {
			log.debug("**---- caller >" +  caller);
	   		log.debug("**---- msg_oecdyn >"  + msg_oecdyn);
		}
       ///////////�ܱ��� ���� üũ end//////////////

///////////////////////����ȯ���̰� ������ȣ ������ üũ///////////////////////////////  �Ƿ�޿��� üũ????

		if(StringHelper.strEquals(caller,"����")) {

				if(StringHelper.strEquals(otpt.getString("insukind"),"21") || StringHelper.strEquals(otpt.getString("insukind"),"22")) {
						
					if(StringHelper.strEquals(otpt.getString("suppkind"),"06")) {

							ValueObject srdgVO = new ValueObject();
							otpt.set( "sessinstcd" ,instcd);

                            srdgVO = outrcptmngtDAO.getSrdg(otpt);

                             if(srdgVO.size() == 0){
								  throw new LiveException("����������ε� ������ȣ�� �����ϴ�. ������ȣ�� Ȯ���Ͻʽÿ�.");
							 }

                             if(StringHelper.strEquals(srdgVO.getString("srdg_seridiagno","")  , "0")) {
                                  throw new LiveException("����������ε� ������ȣ�� �����ϴ�. ������ȣ�� Ȯ���Ͻʽÿ�.");
                             }
                             
					}
				}
		}
///////////////////////����ȯ���̰� ������ȣ ������ üũ ��///////////////////////////////

///////////////////////����Ư�� ����̸鼭 �������� �޿�������ȯ�� �˸��޼���/////////////////////////////// ��ͳ�ġ������Ư�� �������� ���� ����Ư�� �ǹ̰� ������.
		if(StringHelper.strEquals(caller,"���")) {

				if( StringHelper.strEquals(otpt.getString("insukind"),"11")        &&
				    (StringHelper.strEquals(otpt.getString("suppkind"),"00") || StringHelper.strEquals(otpt.getString("suppkind"),"01")) &&
					StringHelper.strEquals(otpt.getString("ordreqformflag"),"3")  &&
					StringHelper.strEquals(otpt.getString("estmspclappyn"),"Y") &&
					!StringHelper.strEquals(otpt.getString("spclcd"),"-") 

				) {
					//msg_estm = "����Ư�ʴ���� �Դϴ�. ���������� ����Ư�ʷ� �����Ͻðڽ��ϱ�?";
				}
		}
///////////////////////����Ư�� ����̸鼭 �������� �޿�������ȯ�� �˸��޼���///////////////////////////////


///////////////////���������� ����100%�̸� ���������� ���׺��κδ㸸 �ȴ�.///////////////////////////////////
		if(StringHelper.strEquals(caller,"������üũ")) {

				if( StringHelper.strEquals(otpt.getString("insukind"),"11") ||
                    StringHelper.strEquals(otpt.getString("insukind"),"21") ||
                    StringHelper.strEquals(otpt.getString("insukind"),"22")) {

                    if(StringHelper.strEquals(otpt.getString("ordreqformflag"),"2")) {

                        if(!StringHelper.strEquals(otpt.getString("suppkind"),"01")) {
                            throw new LiveException("���������� �������100%�϶� ���������� 01 ���׺��κδ㸸 ������ �˴ϴ�.[������:"+otpt.getString("orddd")+"]");
                        }  
                    }
                }
		}
///////////////////���������� ����100%�̸� ���������� ���׺��κδ�üũ ��///////////////////////////////////


///////////////////////������ ����sum üũ///////////////////////////////

		if(StringHelper.strEquals(caller,"����")) {

				if(StringHelper.strEquals(this.getPmcmCodeNm("P0032","40").getString("cdnm"),"Y")) {

					opmi= pVOs.get("opmi");	

					int payownbamt          =  Integer.parseInt(opmi.getString("opmi_payownbamt"));
					int nopyownbamt         =  Integer.parseInt(opmi.getString("opmi_nopyownbamt"));
					int specownbamt         =  Integer.parseInt(opmi.getString("opmi_specownbamt"));
					int allownownbamt       =  Integer.parseInt(opmi.getString("opmi_allownownbamt"));
					int precashamt          =  Integer.parseInt(opmi.getString("opmi_precashamt"));
					int cashamt             =  Integer.parseInt(opmi.getString("opmi_cashamt"));
					int preonlineamt        =  Integer.parseInt(opmi.getString("opmi_preonlineamt"));
					int onlineamt           =  Integer.parseInt(opmi.getString("opmi_onlineamt"));
					int precardamt          =  Integer.parseInt(opmi.getString("opmi_precardamt"));
					int cardamt             =  Integer.parseInt(opmi.getString("opmi_cardamt"));
					int premdlrcptamt       =  Integer.parseInt(opmi.getString("opmi_premdlrcptamt"));
					int mdlrcptamt          =  Integer.parseInt(opmi.getString("opmi_mdlrcptamt"));
					int restamt             =  Integer.parseInt(opmi.getString("opmi_restamt"));
					int heallifeamtclamamt  =  Integer.parseInt(opmi.getString("opmi_heallifeamtclamamt"));
					int uncoamt             =  Integer.parseInt(opmi.getString("opmi_uncoamt"));
					int discamt             =  Integer.parseInt(opmi.getString("opmi_discamt"));
					int reduamt             =  Integer.parseInt(opmi.getString("opmi_reduamt"));
					int bloddiscamt         =  Integer.parseInt(opmi.getString("opmi_bloddiscamt"));
					int handcapfund         =  Integer.parseInt(opmi.getString("opmi_handcapfund"));
					int suppamt             =  Integer.parseInt(opmi.getString("opmi_suppamt"));
					int prePregdmndAmt      =  Integer.parseInt(opmi.getString("opmi_prepregdmndamt"));
					int PregdmndAmt         =  Integer.parseInt(opmi.getString("opmi_pregdmndamt"));

					int totamt = payownbamt + nopyownbamt + specownbamt + allownownbamt ;

					int rcptamt = precashamt           
									+ cashamt               
									+ preonlineamt          
									+ onlineamt              
									+ precardamt            
									+ cardamt                
									+ premdlrcptamt        
									+ mdlrcptamt            
									+ restamt                 
									+ heallifeamtclamamt  
									+ uncoamt               
									+ discamt                
									+ reduamt                
									+ bloddiscamt           
									+ handcapfund         
									+ suppamt               
									+ prePregdmndAmt    
									+ PregdmndAmt;        

					if(totamt != rcptamt) {
							throw new LiveException("�����ݰ� �Ѻ��κδ�ݿ� �հ谡 �����ʽ��ϴ�. �������� �����Ͻʽÿ�.");
					}

				}
		}
///////////////////////������ ����sum üũ ��///////////////////////////////////



////////////////////////B�� �������� ó��(��ϴ� ������ 20110401 cys)///////////////////////////////////////
/*
        ValueObject vtclck = new ValueObject();
        vtclck = outrcptmngtDAO.getVtcltrsCheck(otpt);  //���������ڵ� pmcmcode P0005

        if(vtclck.size() > 0 && StringHelper.strEquals(caller,"��������")) {
            msg_vtclck         = "B����������";
            msg_vtclck_uncoamt = vtclck.getString("vtclck_uncoamt");
            msg_vtclck_uncocd  = vtclck.getString("vtclck_uncocd");
            msg_vtclck_unconm  = vtclck.getString("vtclck_unconm");
            msg                = "B����������" + '\n' + msg;

        }
*/
////////////////////////B�� �������� ó����/////////////////////////////////////

///////////////////////�������� ���������̼� üũ///////////////////////////////

		if(!StringHelper.strEquals(caller,"����")) {

			prvntmedVO = outrcptmngtDAO.getPrvntMedc(otpt);
			if (prvntmedVO.size() > 0) {
				msg_prvntmedcamt = prvntmedVO.getString("discamt");	    //�̼�
				msg_prvntmedcdiscamt = prvntmedVO.getString("reduamt");	//����

				if(!StringHelper.strEquals(msg_prvntmedcamt,"0")) {
					msg_prvntmedccd  = this.getPmcmCodeNm("P0072","10").getString("cdnm");
				}

				if(!StringHelper.strEquals(msg_prvntmedcdiscamt,"0")) {
					msg_prvntmeddiscccd  = this.getPmcmCodeNm("P0072","20").getString("cdnm");
				}
			}

		}
///////////////////////�������� ���������̼� üũ ��///////////////////////////////
		
///////////////////////��뺴�� ��õ������̻�˻� �̼� üũ///////////////////////////////
//2011-10-21 ���� �̼��� ������ ��û����
		if(!StringHelper.strEquals(caller,"����")) {
		
			inbornVO = outrcptmngtDAO.getInbornError(otpt);
			if (inbornVO.size() > 0) {
				msg_inbornuncoamt = inbornVO.getString("discamt");	    //�̼�
				msg_inborndiscamt = inbornVO.getString("reduamt");	//����
			
				if(!StringHelper.strEquals(msg_inbornuncoamt,"0")) {
					msg_inbornuncocd  = this.getPmcmCodeNm("P0104","10").getString("cdnm");
				}
			
				if(!StringHelper.strEquals(msg_inborndiscamt,"0")) {
					msg_inborndiscccd  = this.getPmcmCodeNm("P0104","20").getString("cdnm");
				}
			}
		
		}
///////////////////////��뺴�� ��õ������̻�˻� �̼� üũ///////////////////////////////

///////////////////////��Ȱ���а� �̿���ȯ�� ���޼��� üũ///////////////////////////////
		if(StringHelper.strEquals(caller,"��������") || StringHelper.strEquals(caller,"������üũ")) {

			etcmVO = outrcptmngtDAO.getChkEtcM(otpt);
			if (etcmVO.size() > 0) {
                    msg_etcm =  "[�������� :" + etcmVO.getString("actorddd") + " ó���� :" + etcmVO.getString("prcpdd") + " ����ġ�� ������ ������]" + '\n' +
                    "\n�ݵ�� ġ���(��Ȱġ���, ���ġ���)���� ������ ������ �� ������ �� �ֵ��� �ȳ��Ͻʽÿ�\n";
			}
		}
///////////////////////��Ȱ���а� �̿���ȯ�� ���޼��� üũ��///////////////////////////////

        retVO.set("msg"                   ,  msg);
        retVO.set("msg_type"              ,  msg_type);
        retVO.set("msg_vtclck"            ,  msg_vtclck);
        retVO.set("msg_vtclck_uncoamt"    ,  msg_vtclck_uncoamt);
        retVO.set("msg_vtclck_uncocd"     ,  msg_vtclck_uncocd);
        retVO.set("msg_vtclck_unconm"     ,  msg_vtclck_unconm);
        retVO.set("msg_bldc"              ,  msg_bldc);
        retVO.set("msg_compare_oscl"      ,  msg_compare_oscl);
        retVO.set("msg_specordyn"         ,  msg_specordyn);
        retVO.set("msg_mental"            ,  msg_mental);
        retVO.set("msg_estm"              ,  msg_estm);
        retVO.set("msg_proc"              ,  msg_proc);
        retVO.set("msg_prvntmedccd"       ,  msg_prvntmedccd);
        retVO.set("msg_prvntmedcamt"      ,  msg_prvntmedcamt);
        retVO.set("msg_prvntmeddiscccd"   ,  msg_prvntmeddiscccd);
        retVO.set("msg_prvntmedcdiscamt"  ,  msg_prvntmedcdiscamt);
        
        //20111024 ��õ������̻�˻� �̼� �߰�
        retVO.set("msg_inbornuncocd"       ,  msg_inbornuncocd);
        retVO.set("msg_inbornuncoamt"      ,  msg_inbornuncoamt);
        retVO.set("msg_inborndiscccd"   ,  msg_inborndiscccd);
        retVO.set("msg_inborndiscamt"  ,  msg_inborndiscamt);
        
        retVO.set("msg_drcm"              ,  msg_drcm);
        retVO.set("msg_hocm"              ,  msg_hocm);
        retVO.set("msg_drugmsg"           ,  sDrugMsg);
        retVO.set("msg_oecdyn"            ,  msg_oecdyn);
        retVO.set("msg_etcm"              ,  msg_etcm);
		
		
        } catch (LiveException le) {
            throw le;
        } catch (Exception e) {
            throw new LiveException("com.error.90000", e);
        }

        return retVO ;
    }


    /*
     * �ں��ѵ�ȯ�ںи��˾�
     * �ܷ���ϳ�����ȸ.
     * @author cys
     * @param pVOs ValueObject
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getOtptCarInsu(ValueObject pVO) throws LiveException{

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

		//��곻���� ���� ��������� ��ȸ		
		return outrcptmngtDAO.getOtptCarInsu(pVO);
		
	}


    /*
     * �ں��ѵ�ȯ�ںи��˾�
     * ó�泻����ȸ
     * @author cys
     * @param pVOs ValueObject
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getOprcCarInsu(ValueObject pVO) throws LiveException{

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
	
		return outrcptmngtDAO.getOprcCarInsu(pVO);
		
	}

    /*
     * �ں��ѵ�ȯ�ںи��˾�
     * ó�泻���и�
     * @author cys
     * @param pVOs ValueObject
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject setOprcCarInsu(ValueObject pVO) throws LiveException{

		String sessinstcd = StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE));
		String sessuserid = StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID));

		for(int a=0; a< pVO.size(); a++) {
			
			pVO.set(a, "sessinstcd" , sessinstcd);
			pVO.set(a, "sessuserid" , sessuserid);

		}

		outrcptmngtDAO.setOprcCarInsu(pVO); //�ܷ�ó�� ������ �и�

		outrcptmngtDAO.setOtptCarFlag(pVO); //�ܷ���� �̰����·� ����

		return pVO;
		
	}

	/**
	 * �ܷ����� 2008/1/23 ������
	 * ���� �������� Ŭ���� ����������ȸ
	 * @author cys
	 * @param pVOs ValueObject
	 * @return ValueObject
	 * @throws LiveException
	 */
    public ValueObject getOutJOpmiList(ValueObject pVO) throws LiveException{
        
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
        String OtptKey = "";
		
		//vo�迭 2�̻� �Ͻ� OtptKey ����
		if(pVO.size() > 1) {
			for (int a = 0; a < pVO.size(); a++) {
				OtptKey = pVO.getString(a, "orddd") + pVO.getString(a, "orddrid")+ "','" + OtptKey;
			}

		pVO = pVO.getRowAsVo(0);
        pVO.set("OtptKey" , OtptKey);

		}
		//OtptKey ���� ��
  
        return outrcptmngtDAO.getOutJOpmiList(pVO);

    }

	/* �ٸ� ����ڿ����� �����Ͱ� �������� �������
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getEarnInfo2(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOtptMaxAcptseqno(ValueObject pVO) throws LiveException{
		
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getOtptMaxAcptseqno(pVO);
		
	}

	/**
	 * �ܷ����� 2008/9/17 ������
	 * �ǰ���Ȱ��������ȸ
	 * @author cys
	 * @param pVOs ValueObjectAssembler
	 * @return ValueObjectAssembler
	 * @throws LiveException
	 */
	public ValueObject getMsg4LifeAmt(ValueObject pVO) throws LiveException{
		
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

        String otptkey = "";

        for (int a = 0; a < pVO.size(); a++) {
            otptkey = pVO.getString(a, "orddd") + "_" + pVO.getString(a, "cretno") + "','" + otptkey;
        }
        
        pVO.set("otptkey" , otptkey);
        
        return outrcptmngtDAO.getMsg4LifeAmt(pVO);
		
	}

	/*ī��������� ��ȸ
	 * (��Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getcardList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getcardList(ValueObject pVO) throws LiveException {

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
            
        }
		
		return outrcptmngtDAO.getcardList(pVO);
	}

	/*
	 * (��Javadoc)
	 * ���ݿ����� �������� ��ȸ
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getcashList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getcashList(ValueObject pVO) throws LiveException {
		
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getcashList(pVO);
	}

	/*
	 * (��Javadoc)
	 * �����Ա�(�¶��μ���) ���� ��ȸ
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getonlnList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getonlnList(ValueObject pVO) throws LiveException {
		
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getonlnList(pVO);
	}
	

	/*
	 * (��Javadoc)
	 * ������ü(�������ü) ���� ��ȸ
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getbldcList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getbldcList(ValueObject pVO) throws LiveException {
		
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getbldcList(pVO);
	}

	/*
	 * (��Javadoc)
	 * �� ���鳻����ȸ
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getdcgmList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getdcgmList(ValueObject pVO) throws LiveException {
		
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getdcgmList(pVO);
	}

	/*
	 * (��Javadoc)
	 * �� �̼�������ȸ
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getdcgmList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getuncoList(ValueObject pVO) throws LiveException {
		
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getuncoList(pVO);
	}

	/**
	 * �ܷ����� 2008/9/22 ������
	 * ȯ���������
	 * @author cys
	 * @param pVOs ValueObject
	 * @return ValueObject
	 * @throws LiveException
	 */
	 /*
	public ValueObject getInptInfo(ValueObject pVO) throws LiveException {
		
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getInptInfo(pVO);
	}
	*/

	/*
     * �ܷ����� ������ ������������
     * 2008.09.23. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int setOtptSrdg(ValueObject pVO) throws LiveException {
		

        for (int a = 0; a < pVO.size(); a++) {

            //����ڵ� ��ȸ
            if (StringHelper.strEquals(pVO.getString(a, "sessinstcd"), "")) {
                pVO.set(a, "sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
            }
            
            //����� ��ȸ
            if (StringHelper.strEquals(pVO.getString(a, "sessuserid"), "")) {
                pVO.set(a, "sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
            }

        }
		
		return outrcptmngtDAO.setOtptSrdg(pVO);
	}

	/*
     * �ܷ����� ����Ư�ʽ� ������������
     * 2008.09.23. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int setOtptEstm(ValueObject pVO) throws LiveException {
		

        for (int a = 0; a < pVO.size(); a++) {

            //����ڵ� ��ȸ
            if (StringHelper.strEquals(pVO.getString(a, "sessinstcd"), "")) {
                pVO.set(a, "sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
            }
            
            //����� ��ȸ
            if (StringHelper.strEquals(pVO.getString(a, "sessuserid"), "")) {
                pVO.set(a, "sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
            }

        }
		
		return outrcptmngtDAO.setOtptEstm(pVO);
	}

	/*
     * �ܷ����� ȯ�� �������� ����
     * 2008.11.20. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int setPtbsInfo(ValueObject pVO) throws LiveException {
		
		//����ڵ� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//����� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
			pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
		}
		
		return outrcptmngtDAO.setPtbsInfo(pVO);
	}

	/* ó�溯�泻����ȸ �˾� 
     * OSCL�� Y(����),R(���) ���� ��ȸ 
     * @author �̼��� 
     * @param pVOs ValueObject
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getOsclRY(ValueObject pVO) throws LiveException {
		//����ڵ� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}

		return outrcptmngtDAO.getOsclRY(pVO);
	}

	//0�� ���� �������̽� - �����0������ üũ
	public int getIFOAmtZeroCheck(ValueObject pVO) throws LiveException {

		String otptkey = "";
		String calc_run_flag = "true";


		//boolean bl_trn = true ;
		int sum_opmi = 0; 

		ValueObject otptVO            = new ValueObject();
		ValueObjectAssembler pVOs = new ValueObjectAssembler();  
		ValueObject opmiVO           = new ValueObject();
		ValueObject ptinVO             = new ValueObject();
		ValueObject tempVO            = new ValueObject();

		//����ڵ� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//����� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
			pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
		}

		ptinVO.set("temp","");

		calc_run_flag = pVO.getString("calc_run_flag");

		for (int a = 0; a < pVO.size(); a++) {
            otptkey = pVO.getString(a, "orddd") + "_" + pVO.getString(a, "cretno") + "','" + otptkey;
        }
		
		pVO.set("otptkey" , otptkey);

		otptVO = outrcptmngtDAO.getIFOAmtZeroOtpt(pVO);

		if (!StringHelper.strEquals(calc_run_flag, "false")) {

				for( int a =0; a< otptVO.size() ; a++) {	

					if(StringHelper.strEquals(otptVO.getString(a,"calcbaseflag"),"1")){
						outcalc.OutCalculation(otptVO.getRowAsVo(a));    //�ܷ����
					}
					if(StringHelper.strEquals(otptVO.getString(a,"calcbaseflag"),"2")){
						outcalc.exeOutCalc(otptVO.getRowAsVo(a));        //�ǽ�����
					}
				}
		}

		//�Կ��������� ȣ�� - 2���̻� opmi�� �ϳ��� ��ġ������ ���� Y���� R�� ����
		if (StringHelper.strEquals(calc_run_flag, "false")) {
		
			for( int a =0; a< otptVO.size() ; a++) {	
					outrcptmngtDAO.delOsclCancel(otptVO);      // ��꿡�� ������ R�� ����
					outrcptmngtDAO.setOsclY_dump(otptVO);    // ���� Y���� R�� �����
			}
		
		}

		for( int a =0; a< otptVO.size() ; a++) {
			
			ptinVO.set("insukind"   , otptVO.getString(a,"insukind"));
			ptinVO.set("suppkind"   , otptVO.getString(a,"suppkind"));
			ptinVO.set("insucd"     , otptVO.getString(a,"insucd"));
			
			pVOs.set("ptin" , ptinVO);
			pVOs.set("otpt" , otptVO.getRowAsVo(a));

			tempVO = getOpmiInfo(pVOs,"0������");     //������ �ݾ� ��ȸ 

			Map<String, Object> pMap1 = tempVO.getRow(0);
			opmiVO.addRow(opmiVO.size(), pMap1);
		}

		for( int a =0; a< opmiVO.size() ; a++) {
			sum_opmi = Integer.parseInt( opmiVO.getString(a, "opmi_rcptexptamt") ) + sum_opmi ;
		}

			//if(sum_opmi != 0) { bl_trn = false; }

		return sum_opmi;
	}

	//0�� ���� �������̽� - 0�� ����ó��
	public int setIFOAmtZeroRcpt(ValueObject pVO , String sUserId) throws LiveException {

	   String sInstCd = StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE));   //����ڵ� ��ȸ
       
	    //����� ��ȸ 
	   if(StringHelper.strEquals(sUserId,"")) { 
		   sUserId = StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)); 
	   }
	    
	   String sUserId_real = StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)); 

	   String otptkey = "";
	   String otpt_histstat = "";
	   String opmi_refundyn = "";
	   int    dcgmVO_size   = 0;

        //�ܷ����
        //ValueObject otptinVO     = new ValueObject();
		ValueObjectAssembler pVOs = new ValueObjectAssembler();  
        
		ValueObject ptinVO   = new ValueObject();
		ValueObject tempVO  = new ValueObject();


        try {

            for (int a = 0 ; a< pVO.size(); a++ ) {
      
                ValueObject otptVO = pVO.getRowAsVo(a);

				otptkey = pVO.getString(a, "orddd") + "_" + pVO.getString(a, "cretno");

				otptVO.set("otptkey"     , otptkey);
				otptVO.set("sessinstcd" , sInstCd);

				otptVO = outrcptmngtDAO.getIFOAmtZeroOtpt(otptVO);
				
				if(otptVO.size() == 0) { continue;}
				otptVO.set("sessinstcd" , sInstCd);


            //���ó�� ���̽�(������üũ����,����,0������)
            //1.����ġ��,�ֻ翹���̸鼭 ������̻����̰� ó�� ���� ���
            //2.��缱�����а��̸鼭 ������̻����̰� ó����°��
            if ( (StringHelper.strEquals(otptVO.getString("etcordflag"),"M") && StringHelper.strEquals(otptVO.getString("medamtestmyn"),"N")) ||
                 
                 (StringHelper.strEquals(otptVO.getString("etcordflag"),"J")  && StringHelper.strEquals(otptVO.getString("medamtestmyn"),"N")) ||
                 
                 (StringHelper.strEquals(otptVO.getString("etcordflag"),"T")  && StringHelper.strEquals(otptVO.getString("medamtestmyn"),"N")  && StringHelper.strEquals(otptVO.getString("orddeptcd"),"2170000000")) ||

                 (StringHelper.strEquals(otptVO.getString("rsrvflag"),"A")     && StringHelper.strEquals(otptVO.getString("medamtestmyn"),"N")  && StringHelper.strEquals(otptVO.getString("specordyn"),"N"))

              ) {

					if(outrcptmngtDAO.getExopActList(otptVO).size() == 0) {
						otpt_histstat = "X";
                        opmi_refundyn = "Y";
					}else{
				        otpt_histstat = "R";
						opmi_refundyn = "";
					}

			} else {
				otpt_histstat = "R";
				opmi_refundyn = "";
			}

				otptVO.set("otpt_histstat"   ,otpt_histstat);                         
				otptVO.set("opmi_rcptexecdd" ,DateHelper.getCurrentDateAsString());
				otptVO.set("opmi_rcpttm"     ,DateHelper.getCurrentTimeAsString());
				otptVO.set("opmi_rcptrid"    ,sUserId);
				otptVO.set("opmi_refundyn"   ,opmi_refundyn);                       
				otptVO.set("opmi_pid"        ,otptVO.getString("pid"));
				otptVO.set("opmi_orddd"      ,otptVO.getString("orddd"));
				otptVO.set("opmi_cretno"     ,otptVO.getString("cretno"));
				otptVO.set("sessinstcd"      ,sInstCd);
				otptVO.set("sessuserid"      ,sUserId_real);
 
			//�������� ä��
			int iRcptNo = 0;		

			ValueObject rcptnoVO = getRcptNo(otptVO);
			otptVO.set("rcptno_new" , (rcptnoVO.getInt("rcptno")));    
			ptinVO.set("temp"       ,"");
            ptinVO.set("insukind"   , otptVO.getString("insukind"));
            ptinVO.set("suppkind"   , otptVO.getString("suppkind"));
            ptinVO.set("insucd"     , otptVO.getString("insucd"));

			pVOs.set("otpt" , otptVO);
			pVOs.set("ptin" , ptinVO); 	

			tempVO = getOpmiInfo(pVOs,"0������");     //������ �ݾ� ��ȸ
			
			//�ǻ�����N�̸� �̼����걸�п� 1A ���� , Y�̸� 1B ����
			if(StringHelper.strEquals(otptVO.getString("dracptyn"),"N")){
				tempVO.set("opmi_uncorcptflag"       , "1A");
			}else{
				tempVO.set("opmi_uncorcptflag"       , otptVO.getString("prcpgenryn"));
			}

			tempVO.set("sessinstcd"        , sInstCd); 
			tempVO.set("sessuserid"        , sUserId_real);
			
			
			//�̼��Աݺ��� �����Ҷ�, �̼��߻����� �����Ҷ� ��踦 ���ؼ� refundyn�� S �־���
			if (StringHelper.strEquals(otpt_histstat,"R") && 
				StringHelper.strEquals(opmi_refundyn,"")  &&
				!StringHelper.strEquals(outrcptmngtDAO.getUncoStatYCnt(tempVO).getString("cnt"),"0")
			) {
				opmi_refundyn = "S";
			}			

			tempVO.set("opmi_rcptstat"     , "Y"); 
			tempVO.set("opmi_insukind"     , otptVO.getString("insukind")); 
			tempVO.set("opmi_suppkind"     , otptVO.getString("suppkind")); 
			tempVO.set("opmi_insucd"       , otptVO.getString("insucd")); 
			tempVO.set("opmi_remfact"      , ""); 
			tempVO.set("opmi_paypsnflag"   , ""); 
			tempVO.set("opmi_paypsnrem"    , ""); 
			tempVO.set("opmi_rcptexecdd"   , DateHelper.getCurrentDateAsString()); 
			tempVO.set("opmi_rcpttm"	   , DateHelper.getCurrentTimeAsString()); 
			tempVO.set("opmi_rcptrid"      , sUserId);
			
			tempVO.set("opmi_rcptdd"       , DateHelper.getCurrentDateAsString()); 
			tempVO.set("opmi_rcptno"       , rcptnoVO.getInt("rcptno")); 
			tempVO.set("opmi_rcptseqno"    , "1");
			
			tempVO.set("otpt_histstat"     , otpt_histstat); 
			tempVO.set("opmi_refundyn"     , opmi_refundyn); 
			tempVO.set("sessinstcd"        , sInstCd); 
			tempVO.set("sessuserid"        , sUserId_real);

			if(tempVO.getString("opmi_cashamt") == "0") {

				tempVO.set("opmi_remfact"      , "0������");
			}else{
				tempVO.set("opmi_remfact"      , "��������ȯ��");
			}


			ValueObject cardVO  = new ValueObject();
			cardVO = outrcptmngtDAO.getcardList(tempVO);

			ValueObject cashVO  = new ValueObject();
			cashVO = outrcptmngtDAO.getcashList(tempVO);

            ValueObject onlnVO  = new ValueObject();    
            onlnVO = outrcptmngtDAO.getonlnList(tempVO);

			ValueObject uncoVO  = new ValueObject();
			uncoVO = outrcptmngtDAO.getuncoList2(tempVO);

			//���ǰ���
			ValueObject dcgmVO  = new ValueObject();
			dcgmVO = outrcptmngtDAO.getdcgmList(tempVO);
			//dcgmVO = outrcptmngtDAO.getdcgmList_zero(tempVO);  //��������, ���ǰ��� ���о��� �ֱ����� ���

			//��������
			ValueObject dcgmVO_dc  = new ValueObject();
			dcgmVO_size = dcgmVO.size();

			if(!StringHelper.strEquals(tempVO.getString("opmi_discamt"),"0")){

				dcgmVO.set(dcgmVO_size , "pid"              , tempVO.getString("opmi_pid"));
				dcgmVO.set(dcgmVO_size , "orddd"            , tempVO.getString("opmi_orddd"));
				dcgmVO.set(dcgmVO_size , "cretno"           , tempVO.getString("opmi_cretno"));
				dcgmVO.set(dcgmVO_size , "rcptdd"           , tempVO.getString("opmi_rcptdd"));
				dcgmVO.set(dcgmVO_size , "rcptno"           , tempVO.getString("opmi_rcptno"));
				dcgmVO.set(dcgmVO_size , "seqno"            , tempVO.getString("opmi_seqno"));
				dcgmVO.set(dcgmVO_size , "rcptseqno"        , tempVO.getString("opmi_rcptseqno"));
				dcgmVO.set(dcgmVO_size , "instcd"           , tempVO.getString("opmi_instcd"));
				dcgmVO.set(dcgmVO_size , "rcptstat"         , tempVO.getString("opmi_rcptstat"));
				dcgmVO.set(dcgmVO_size , "ordtype"          , tempVO.getString("opmi_ordtype"));
				dcgmVO.set(dcgmVO_size , "discreduflag"     , "D");
				dcgmVO.set(dcgmVO_size , "discreducd"       , otptVO.getString("disccd"));
				dcgmVO.set(dcgmVO_size , "discreduamt"      , tempVO.getString("opmi_discamt"));
				dcgmVO.set(dcgmVO_size , "apprsn"           , "");
				dcgmVO.set(dcgmVO_size , "rcptexecdd"       , tempVO.getString("opmi_rcptexecdd"));
				dcgmVO.set(dcgmVO_size , "rcpttm"           , tempVO.getString("opmi_rcpttm"));
				dcgmVO.set(dcgmVO_size , "rcptrid"          , tempVO.getString("opmi_rcptrid"));
				dcgmVO.set(dcgmVO_size , "remfact"          , "");
				dcgmVO.set(dcgmVO_size , "fstrgstrid"       , "");
				dcgmVO.set(dcgmVO_size , "fstrgstdt"        , "");
				dcgmVO.set(dcgmVO_size , "lastupdtrid"      , "");
				dcgmVO.set(dcgmVO_size , "lastupdtdt"       , "");
				dcgmVO.set(dcgmVO_size , "orddd_org"        , tempVO.getString("opmi_orddd_org"));
				dcgmVO.set(dcgmVO_size , "cretno_org"       , tempVO.getString("opmi_cretno_org"));
				dcgmVO.set(dcgmVO_size , "orddeptcd_org"    , tempVO.getString("opmi_orddeptcd_org"));
				dcgmVO.set(dcgmVO_size , "orddrid_org"      , tempVO.getString("opmi_orddrid_org"));
				dcgmVO.set(dcgmVO_size , "rcptdd_org"       , tempVO.getString("opmi_rcptdd_org"));
				dcgmVO.set(dcgmVO_size , "rcptno_org"       , tempVO.getString("opmi_rcptno_org"));
				dcgmVO.set(dcgmVO_size , "rcptseqno_org"    , tempVO.getString("opmi_rcptseqno_org"));

			}
			//�������� ��

			ValueObject bldcVO  = new ValueObject();
			bldcVO = outrcptmngtDAO.getbldcList(tempVO);


			//OPMI C,D����
			if (outrcptmngtDAO.insOutOrdAmtDC(tempVO) <0) throw new LiveException("??insOutOrdAmt:insOutOrdAmtDC => opmi dc ���� ���� ");   //D	
			if (outrcptmngtDAO.setOutOrdAmtC(otptVO) <0)  throw new LiveException("??insOutOrdAmt:setOutOrdAmtC  => opmi y=>c ���� ���� "); //C
			
			//OSCL C,D����
			if (outrcptmngtDAO.insOSCLDC(otptVO)<0) throw new LiveException("??  insOutOrdAmt: insOSCLDC => oscl dc ���� ���� ");
			if (outrcptmngtDAO.setOSCLC(otptVO) <0) throw new LiveException("??  insOutOrdAmt: setOSCLC  => oscl y=>c ���� ���� ");

			//CARD ī��ݾ�
			outrcptmngtDAO.insCardAmtDC(otptVO);	  //D
			outrcptmngtDAO.setCardAmtC(otptVO);		  //C

			//CASH ���ݿ������ݾ�
			outrcptmngtDAO.insCashAmtDC(otptVO);	  //D
			outrcptmngtDAO.setCashAmtC(otptVO);		  //C

            //ONLN �����Աݾ�
            outrcptmngtDAO.insOnlnAmtDC(otptVO);       //D
            outrcptmngtDAO.setOnlnAmtC(otptVO);        //C

			//UNCO �̼�
			outrcptmngtDAO.insUncoAmtDC(otptVO);	   //D
			outrcptmngtDAO.setUncoAmtC(otptVO);	       //C

			//DCGM ����/����
			outrcptmngtDAO.insDcgmAmtDC(otptVO);	   //D
			outrcptmngtDAO.setDcgmAmtC(otptVO);	       //C

			//BLDC ������
			outrcptmngtDAO.insBldcAmtDC(otptVO);	   //D
			outrcptmngtDAO.setBldcAmtC(otptVO);		   //C

			//OSCL Y����
			//outrcptmngtDAO.setOutOrdAmtOscl(tempVO);  
			setOutOrdAmtOsclOtpt(tempVO);

	if(!StringHelper.strEquals(otpt_histstat,"X")){

			//OPMI Y����
			if (outrcptmngtDAO.insOutOrdAmt(tempVO) <=0) throw new LiveException("??insOutOrdAmt:insOutOrdAmt=> opmi y ���� ���� ���� ");//Y
			
			//CARD ī��ݾ�
			for (int c = 0 ; c< cardVO.size(); c++ ) {
						cardVO.set(c,"rcptdd"         ,DateHelper.getCurrentDateAsString()); 
						cardVO.set(c,"rcptno"         ,rcptnoVO.getInt("rcptno")); 
						cardVO.set(c,"rcptseqno"      ,"1"); 
						cardVO.set(c,"rcptrid"        ,sUserId); 
						cardVO.set(c,"sessinstcd"     ,sInstCd); 
						cardVO.set(c,"sessuserid"     ,sUserId_real); 
						cardVO.set(c,"rcptexecdd"     ,tempVO.getString("opmi_rcptexecdd"));
						cardVO.set(c,"rcpttm"         ,tempVO.getString("opmi_rcpttm"));
				insCardAmt(cardVO.getRowAsVo(c));			
			}
			
			//CASH ���ݿ������ݾ�
			for (int c = 0 ; c< cashVO.size(); c++ ) {
						cashVO.set(c,"rcptdd"         ,DateHelper.getCurrentDateAsString()); 
						cashVO.set(c,"rcptno"         ,rcptnoVO.getInt("rcptno")); 
						cashVO.set(c,"rcptseqno"      ,"1"); 
						cashVO.set(c,"rcptrid"        ,sUserId); 
						cashVO.set(c,"sessinstcd"     ,sInstCd);
						cashVO.set(c,"sessuserid"     ,sUserId_real);
						cashVO.set(c,"rcptexecdd"     ,tempVO.getString("opmi_rcptexecdd"));
						cashVO.set(c,"rcpttm"         ,tempVO.getString("opmi_rcpttm"));
				insCashAmt(cashVO.getRowAsVo(c));			
			}

            //ONLN �����Աݾ�
            for (int c = 0 ; c< onlnVO.size(); c++ ) {
                        onlnVO.set(c,"rcptdd"         ,DateHelper.getCurrentDateAsString()); 
                        onlnVO.set(c,"rcptno"         ,rcptnoVO.getInt("rcptno")); 
                        onlnVO.set(c,"rcptseqno"      ,"1"); 
                        onlnVO.set(c,"rcptrid"        ,sUserId); 
                        onlnVO.set(c,"sessinstcd"     ,sInstCd);
                        onlnVO.set(c,"sessuserid"     ,sUserId_real);
						onlnVO.set(c,"rcptexecdd"     ,tempVO.getString("opmi_rcptexecdd"));
						onlnVO.set(c,"rcpttm"         ,tempVO.getString("opmi_rcpttm"));
                insOnlineAmt(onlnVO.getRowAsVo(c));         
            }

			//UNCO �̼�
			for (int c = 0 ; c< uncoVO.size(); c++ ) {
						uncoVO.set(c,"rcptdd"         ,DateHelper.getCurrentDateAsString()); 
						uncoVO.set(c,"rcptno"         ,rcptnoVO.getInt("rcptno")); 
						uncoVO.set(c,"rcptseqno"      ,"1"); 
						uncoVO.set(c,"rcptrid"        ,sUserId); 
						uncoVO.set(c,"sessinstcd"     ,sInstCd); 
						uncoVO.set(c,"sessuserid"     ,sUserId_real); 
						uncoVO.set(c,"rcptexecdd"     ,tempVO.getString("opmi_rcptexecdd"));
						uncoVO.set(c,"rcpttm"         ,tempVO.getString("opmi_rcpttm"));
				insUncoAmt(uncoVO.getRowAsVo(c));			
			}

			//DCGM ����/����
			for (int c = 0 ; c< dcgmVO.size(); c++ ) {
						dcgmVO.set(c,"rcptdd"         ,DateHelper.getCurrentDateAsString()); 
						dcgmVO.set(c,"rcptno"         ,rcptnoVO.getInt("rcptno")); 
						dcgmVO.set(c,"rcptseqno"      ,"1"); 
						dcgmVO.set(c,"rcptrid"        ,sUserId); 
						dcgmVO.set(c,"sessinstcd"     ,sInstCd); 
						dcgmVO.set(c,"sessuserid"     ,sUserId_real);
						dcgmVO.set(c,"rcptexecdd"     ,tempVO.getString("opmi_rcptexecdd"));
						dcgmVO.set(c,"rcpttm"         ,tempVO.getString("opmi_rcpttm"));

				outrcptmngtDAO.insDcgmAmt(dcgmVO.getRowAsVo(c));			
			}
			
			//BLDC ������
			for (int c = 0 ; c< bldcVO.size(); c++ ) {
						bldcVO.set(c,"rcptdd"         ,DateHelper.getCurrentDateAsString()); 
						bldcVO.set(c,"rcptno"         ,rcptnoVO.getInt("rcptno")); 
						bldcVO.set(c,"rcptseqno"      ,"1"); 
						bldcVO.set(c,"rcptrid"        ,sUserId); 
						bldcVO.set(c,"sessinstcd"     ,sInstCd); 
						bldcVO.set(c,"sessuserid"     ,sUserId_real); 
						bldcVO.set(c,"rcptexecdd"     ,tempVO.getString("opmi_rcptexecdd"));
						bldcVO.set(c,"rcpttm"         ,tempVO.getString("opmi_rcpttm"));
				outrcptmngtDAO.insBldcAmt(bldcVO.getRowAsVo(c));			
			}
			
            if ( log.isDebugEnabled() ) log.debug("**----�ܷ�ó�� �������� update  start----**  " );
            //+++++++++++++++++++++++++++++++++++++++++++++++
            setOutOrdStat(tempVO);
            
            //������ ���ÿ� �����ؾ� �ϴ� ó�� ������Ʈ
            ValueObject tempVO2 = new ValueObject();

            tempVO2.set("pid"            , tempVO.getString("opmi_pid"));   
            tempVO2.set("orddd"          , tempVO.getString("opmi_orddd"));   
            tempVO2.set("cretno"         , tempVO.getString("opmi_cretno"));  
            tempVO2.set("execdd"         , DateHelper.getDay());      
            tempVO2.set("exectm"         , tempVO.getString("opmi_rcpttm"));      
            tempVO2.set("execrid"        , sUserId);
            tempVO2.set("sessuserid"     , sUserId);  
            tempVO2.set("sessinstcd"     , sInstCd);  

            etcOutRgst.getActingRcptOscl(tempVO2);
            //������ ���ÿ� �����ؾ� �ϴ� ó�� ������Ʈ ��

            //+++++++++++++++++++++++++++++++++++++++++++++++   
            if ( log.isDebugEnabled() ) log.debug("**----�ܷ�ó�� �������� update  end----**  " );


	}

			/////////////////////////////////////////0������ ��� ���̺� ����ó��//////////////////////////////////
			outrcptmngtDAO.setOutOrdEndMjqu(otptVO);  
			/////////////////////////////////////////0������ ��� ���̺� ����ó�� ��///////////////////////////////
			

			//��������ó��
			ValueObjectAssembler chkVOs = new ValueObjectAssembler();
			chkVOs.set("otpt", otptVO);
			this.outOrd_Check(chkVOs , "����" ,sInstCd , sUserId);  //�ܷ����� �⺻���� üũ



			ValueObject msgVO   = new ValueObject();  //���ϸ޼���
			ValueObject pharmVO = new ValueObject();  //�౹����� VO
			ValueObjectAssembler pharmVOs    = new ValueObjectAssembler();   //�౹����� VOs
			ValueObjectAssembler retpharmVOs = new ValueObjectAssembler();   //�౹����� return VOs
			ValueObject InAutoAssignVO  = new ValueObject();	             //�ڵ������ VO

			//--------------------------------------------------�౹����------------------------------------------------------

            /*
             * @ �ʿ��Ķ����
                pid,
                orddd(actingorddd ���� �ƴ�),
                cretno,
                orddeptcd,
                orddrid,
                instcd,
                ioflag(�Կ�/�ܷ�����(I/O), ���⼭�� "O"�� �־���)
                prcpgenrflag(ã�� ����� "O"�� �־���)
             */
            //������ ó������Ƿ�, ��ȸ�Ǽ� 0
            if (this.getOrddd(tempVO).size() > 0) {

                if (StringHelper.strEquals(this.getPmcmCodeNm("P0032","-").getString("cdnm"),"Y")) {
                    pharmVO = this.getOrddd(tempVO);
                }else{
                    pharmVO.set("pid"         , tempVO.getString("opmi_pid"));
                    pharmVO.set("orddd"       , tempVO.getString("opmi_orddd"));
                    pharmVO.set("cretno"      , tempVO.getString("opmi_cretno"));
                    pharmVO.set("orddeptcd"   , tempVO.getString("opmi_orddeptcd"));
                    pharmVO.set("orddrid"     , tempVO.getString("opmi_orddrid"));
                    pharmVO.set("instcd"      , sInstCd);
                    pharmVO.set("ioflag"      , "O");
                    pharmVO.set("prcpgenrflag", "O");
                }

				if(log.isDebugEnabled()){log.debug("**----�౹���� ȣ����� exeOutSum ------**");}
				
				pharmVOs.set("req", pharmVO);
				retpharmVOs = pharmlib.exeOutSum(pharmVOs);	

				if (retpharmVOs.size() < 0) {
					throw new LiveException("���ȣ ������ �����߻��Ͽ����ϴ�.");						
				}
				
				if(!StringHelper.strEquals(retpharmVOs.get("result").getString("outDrugNoMsg"),"")) {
					 msgVO.set("outdrugnomsg", retpharmVOs.get("result").getString("outDrugNoMsg"));
				}
				
				if(log.isDebugEnabled()){log.debug("**----�౹���� ȣ������ exeOutSum ------** ");}
				
			}
			//--------------------------------------------------�౹���賡------------------------------------------------------

			//--------------------------------------------------�ڵ������------------------------------------------------------
			if(log.isDebugEnabled()){log.debug("**----�ڵ������ ȣ����� setAutoRoomAssignIF ------**");}
			
				InAutoAssignVO.set("pid"      , tempVO.getString("opmi_pid"));
				InAutoAssignVO.set("orddd"    , tempVO.getString("opmi_orddd"));
				InAutoAssignVO.set("cretno"   , tempVO.getString("opmi_cretno"));
				InAutoAssignVO.set("ioflag"   , tempVO.getString("opmi_ordtype"));					
				InAutoAssignVO.set("instcd"   , sInstCd);
				InAutoAssignVO.set("userid"   , sUserId);
				InAutoAssignVO.set("workflag" , "N");
			
				autoasslib.setAutoRoomAssignIF(InAutoAssignVO);						
			
			if(log.isDebugEnabled()){log.debug("**----�ڵ������ ȣ������ setAutoRoomAssignIF ------**");}
			//--------------------------------------------------�ڵ��������------------------------------------------------------


				/*      
				//////////////////////////////////////////�ܷ�������� ������Ʈ//////////////////////////////////////
				otptVO.set( "otpt_rcptdd"       , tempVO.getString( "opmi_rcptdd"));
				otptVO.set( "otpt_rcptno"       , tempVO.getString( "opmi_rcptno"));
				otptVO.set( "otpt_rcptseqno"    , tempVO.getString( "opmi_rcptseqno"));
				otptVO.set( "otpt_calcflag"     , "N");
				otptVO.set( "otpt_histstat"     , otpt_histstat);
				otptVO.set( "sessuserid"        , sUserId);
				otptVO.set( "otpt_pid"          , otptVO.getString( "pid"));
				otptVO.set( "otpt_orddd"        , otptVO.getString( "orddd"));
				otptVO.set( "otpt_cretno"       , otptVO.getString( "cretno"));
				otptVO.set( "sessinstcd"        , sInstCd);
				outrcptmngtDAO.setOutOrdAmtOtpt(otptVO);
				//////////////////////////////////////////�ܷ�������� ������Ʈ ��//////////////////////////////////////

                //�̼��� �������� ó������ �߰�
            	ValueObject uncoRcptVO = new ValueObject();
            	uncoRcptVO.set("pid", StringHelper.null2void(otptinVO.getString("otpt_pid")));
            	uncoRcptVO.set("instcd", StringHelper.null2void(otptinVO.getString("otpt_instcd")));
            	uncoRcptVO.set("userid", StringHelper.null2void(otptinVO.getString("sess_userid")));
            	uncoRcptVO.set("old_rcptdd", StringHelper.null2void(otptinVO.getString("rcptdd")));
            	uncoRcptVO.set("old_rcptno", StringHelper.null2void(otptinVO.getString("rcptno")));
            	uncoRcptVO.set("old_rcptseqno", StringHelper.null2void(otptinVO.getString("rcptseqno")));
            	uncoRcptVO.set("new_rcptdd", StringHelper.null2void(otptinVO.getString("rcptdd_new")));
            	uncoRcptVO.set("new_rcptno", StringHelper.null2void(otptinVO.getString("rcptno_new")));
            	uncoRcptVO.set("new_rcptseqno", StringHelper.null2void(otptinVO.getString("rcptseqno_new")));            	
            	setUNCO(uncoRcptVO);               
				*/



            }
             
        } catch (LiveException le) {
            throw le;
        } catch (Exception e) {
            throw new LiveException("com.error.90000", e);
        }        

        return  pVO.size();
	}

	//0�� ���� �������̽� - 0������ ��� ����ġ�� ����Ʈ ��������
	public ValueObject getMjquList(ValueObject pVO) throws LiveException {

		//����ڵ� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//����� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
			pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
		}

		return outrcptmngtDAO.getMjquList(pVO);
	}


	//0�� ���� �������̽� - ����
	public int setIFOAmtZeroRun(ValueObject pVO , String sUserId) throws LiveException {

		int sum_opmi = 0;
		int sum_opmi_array = 0;

		//����ڵ� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//����� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
			pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
		}
		
		sum_opmi = this.getIFOAmtZeroCheck(pVO);

		if(sum_opmi == 0) {  
			this.setIFOAmtZeroRcpt(pVO , sUserId);  
			
		}else{

//			 for (int a = 0; a < pVO.size(); a++) {
//					sum_opmi_array = this.getIFOAmtZeroCheck(pVO.getRowAsVo(a));
//					if(sum_opmi_array == 0) {
//						this.setIFOAmtZeroRcpt(pVO.getRowAsVo(a) , sUserId);  
//					}
//			 }

			// ����� 0���� �ƴմϴ�. 
			//throw new LiveException("����� 0���� �ƴմϴ�.");
			//bl_trn = false;
		}

		ValueObject paramVO = new ValueObject();
		paramVO.set("pid"           , pVO.getString("pid"));
		paramVO.set("sessinstcd"   , pVO.getString("sessinstcd"));
		paramVO.set("acptdd"      , DateHelper.getCurrentDateAsString());
		paramVO.set("grouppid"   , "M");  // �ֻ���� 'J' ����

		paramVO = outrcptmngtDAO.getMjquList(paramVO);
				
		return paramVO.size();
	}


	//0�� ���� �������̽� - ������ ȯ��
	public int setIFOAmtZeroRun_refund(ValueObject pVO , String sUserId) throws LiveException {

		ValueObject bogjVO = new ValueObject ();
		int sum_opmi = 0;

		//����ڵ� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//����� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
			pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
		}

		sum_opmi = this.getIFOAmtZeroCheck(pVO);

		if(sum_opmi <= 0) {  
			this.setIFOAmtZeroRcpt(pVO , sUserId);  
		}else{
			// ȯ�ұ��� ���̳ʽ��� �ƴմϴ�.
			//throw new LiveException("ȯ�ұ��� ���̳ʽ��� �ƴմϴ�.");
			//bl_trn = false;
		}
		
		//������ ȯ��
		if(sum_opmi < 0){

			bogjVO.set("pid"        ,pVO.getString("pid"));             
			bogjVO.set("rcptdd"		,DateHelper.getDay());       
			bogjVO.set("rcptno"		,this.getRcptNo(pVO).getString("rcptno"));       
			bogjVO.set("rcptseqno"	,1);    
			bogjVO.set("sessinstcd"	,pVO.getString("sessinstcd"));   
			bogjVO.set("rcptstat"	,"Y");     
			bogjVO.set("ordtype"	,"O");      
			bogjVO.set("rcptflag"	,"A01");     
			bogjVO.set("cashamt"	,sum_opmi * -1);      
			bogjVO.set("cardamt"	,0);      
			bogjVO.set("onlineamt"	,0);    
			bogjVO.set("rcptexecdd"	,DateHelper.getDay());   
			bogjVO.set("rcpttm"		,DateHelper.getCurrentTimeAsString());       
			bogjVO.set("rcptrid"	,sUserId);      
			bogjVO.set("remfact"	,"��������ȯ��");      
			bogjVO.set("orddeptcd"	,pVO.getString("orddeptcd"));    
			bogjVO.set("paypsnflag"	,"1");   
			bogjVO.set("paydepoamt"	,sum_opmi * -1);   
			bogjVO.set("paypsnrem"	,"");    

			this.insMdlAmt(bogjVO);
		}

		return sum_opmi;
	}

	//����ó�� ������� �˾� - ��ȸ
	public ValueObjectAssembler getPopupMjquList(ValueObject pVO) throws LiveException{
		
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

		ValueObject mjqu  = null;
		ValueObject mjex  = null;
		ValueObjectAssembler retVOs = new ValueObjectAssembler();

        if (!StringHelper.strEquals(pVO.getString("mjqu_orddd"), "")) {
            pVO.set("mjqu_stat", "SELECT");
        }

		 mjqu = outrcptmngtDAO.getPopupMjquList(pVO);     //����ó�� ������� �˾� - ��ȸ
		 mjex = outrcptmngtDAO.getPopupMjexList(pVO);     //����ó�� ������� �˾� - ��ȸ

		retVOs.set("mjqu"   , mjqu);
		retVOs.set("mjex"   , mjex);
		
		return retVOs;
		
	}

	/**
     * <p>����üũ</p>
     * 
     * @param pVOs ValueObject
     * <p>req : �Էµ�����.
     * <ul>
     * <li>pid ��Ϲ�ȣ 
     * </ul>
     * @return ValueObject
     * <p>
     * <ul>
     * <li>     
     * </ul>
     * @throws LiveException
     */
	public ValueObject fSrdgInfoVeri_check(ValueObject pVO , String code, ValueObject srdgVO) throws LiveException {

		ValueObject retVO = new ValueObject();
		if(srdgVO.size() == 0){  srdgVO.set("temp", "temp");  }

		String msg_srdg = "";
		String msg_type = "";

		String vpid        = pVO.getString("pid");
		int vOrddd         = Integer.parseInt(pVO.getString("orddd"));
		String vcretno     = pVO.getString("cretno");
		String vinsukindcd = pVO.getString("insukind");
		String vsuppkindcd = pVO.getString("suppkind");
		String vinsuno     = pVO.getString("insuno");
		String vinsucd     = pVO.getString("insucd");
		String vcode       = code;

		//�������� �ȳѾ�ý� ����ó��
		if ( StringHelper.strEquals(vinsuno , "")  || StringHelper.strEquals(vinsuno , null)) {
			vinsuno = "0";
		}

		if ( StringHelper.strEquals(vinsucd , "")  || StringHelper.strEquals(vinsucd , null)) {
			vinsucd = "0";
		}

		int vgenrdd 		     = Integer.parseInt(srdgVO.getString("srdg_genrdd" ,"0"));

		String vgenrddtext       = StringHelper.toSubString(srdgVO.getString("srdg_genrdd"), 4, 6) + "��" + StringHelper.toSubString(srdgVO.getString("srdg_genrdd"), 6, 8) + "��";	
		String vdiagno           = srdgVO.getString("srdg_seridiagno");
		String vsignyn           = srdgVO.getString("srdg_signyn");
		String vcancer           = "V193";
		int vsrdgfromdd          = Integer.parseInt(srdgVO.getString("srdg_fromdd" ,"0"));
		int vsrdgtodd	         = Integer.parseInt(srdgVO.getString("srdg_todd" ,"0"));
		String vanohosprgstflag  = srdgVO.getString("srdg_anohosprgstflag");

		//������ȯ�� Ư��ó�� - �������� �������� �ǰ������� ������������ �ӽ÷� �ٲ㼭 ����üũ�� �Ѵ�.
		if( (Integer.parseInt(vsuppkindcd) > 32)  && (Integer.parseInt(vsuppkindcd) < 46)) {
				vsuppkindcd = this.getChgScnd(pVO).getString("final_suppkind");
		}
		//������ȯ�� Ư��ó�� ��


		// �ǰ������̸鼭 ���׺����� ���ܴ����
		if (StringHelper.strEquals(vinsukindcd , "11")  && !StringHelper.strEquals(vsuppkindcd , "01")) {

			  // �̹� ������ ����Ǿ��� ������ ������ �������� check�ؾ� ��
				if ( StringHelper.strEquals(vsuppkindcd , "06") || StringHelper.strEquals(vsuppkindcd , "11") ){
							
							// �������� �ƴϸ� �ȵ�
							if ( !StringHelper.strEquals(vcode , vcancer) ){
									msg_srdg = "���� �����Ҽ� ���� ���Դϴ�![2-1-1-��]";
									retVO.set("msg_srdg" , msg_srdg);
									retVO.set("msg_type" , "E");
								    return retVO;			
							}
							
							// ������ȣ ������ ��û�����̰� 
							if (StringHelper.strEquals(vdiagno , "0")){
								  
								  // ������ ��������
								  if(StringHelper.strEquals(vinsuno.substring(0,1) , "6") &&  StringHelper.strEquals(vinsucd , "32000110")) {
											msg_srdg = "�������ٹ����̹Ƿ� �ݵ�� ������ȣ�� �־�� �մϴ�.[2-1-1-��-��]";	
											retVO.set("msg_srdg" , msg_srdg);
											retVO.set("msg_type" , "E");
											return retVO;	
									}
	
								    // ������ ����.
									if ( StringHelper.strEquals(vsignyn , "Y")){
										  // ��û���� check
										    /* 08/09/23 ������ ���̽��߻��Ҽ������� �����
											if ( vgenrdd == vOrddd ){
													msg_srdg = "���� Signȯ���Դϴ�. �������� �����Ͻðڽ��ϱ�?[2-1-1-��-��-A]";					
													retVO.set("msg_srdg" , msg_srdg);
													retVO.set("msg_type" , "Q");
													return retVO;
											}
										    */
											if ( vgenrdd != vOrddd ){
													msg_srdg = vgenrddtext + " Signȯ���Դϴ�.[2-1-1-��-��-B]";					
													retVO.set("msg_srdg" , msg_srdg);
													retVO.set("msg_type" , "I");
													return retVO;
											}
								     }
									 
									 // ���ξ�����
									 if ( !StringHelper.strEquals(vsignyn , "Y")){ 

											if (StringHelper.strEquals(vanohosprgstflag , "Y")){
													msg_srdg = "Ÿ���� ������� ȯ�� �Դϴ�.�ڰ��� Ȯ���ϼ���![2-1-1-��-��-A]";
													retVO.set("msg_srdg" , msg_srdg);
													retVO.set("msg_type" , "E");
													return retVO;
											}

											if (StringHelper.strEquals(vanohosprgstflag , "N")){

													msg_srdg = "�����Ƿڼ� ���� �� �������� �����մϴ�. \n�Ƿڼ� ������ �Ͻ� �� �������ּ���!![���������-����ȯ�ڵ��]";
													retVO.set("msg_srdg"      , msg_srdg);
													retVO.set("msg_type"      , "E");
													return retVO;

											}

								     }	

							}
							
							// ������ȣ ������ �Ⱓ�� check��
							if (!StringHelper.strEquals(vdiagno , "0") && !StringHelper.strEquals(vdiagno , null)){ 
									if (vOrddd < vsrdgfromdd || vOrddd > vsrdgtodd ) {			   
										msg_srdg = "�������ڰ� �����Ⱓ ������ ���Ե��� �ʽ��ϴ�.[2-1-1-��]";	
										retVO.set("msg_srdg" , msg_srdg);
										retVO.set("msg_type" , "E");
										return retVO;
									}
							}
				}
				
				// ������ ������Ǿ��� ������ ������ �������� check�ؾ� ��
				if ( !StringHelper.strEquals(vsuppkindcd , "06") && !StringHelper.strEquals(vsuppkindcd , "11")){


						 // ������ �ش��ϴ� ���̸�
						if ( StringHelper.strEquals(vcode , vcancer)){
							
								// ������ȣ ������ ��û�����̰� sign�� �Ǿ����� ������. �� �������� �ƴҰ��
								if (StringHelper.strEquals(vdiagno , "0")){ 

									//Ÿ�������� üũ
									if (StringHelper.strEquals(vanohosprgstflag , "Y")){
											msg_srdg = "Ÿ���� ������� ȯ�� �Դϴ�.�ڰ��� Ȯ���ϼ���![2-1-2-��-��]";
											retVO.set("msg_srdg" , msg_srdg);
											retVO.set("msg_type" , "E");
											return retVO;	
									}

									if (StringHelper.strEquals(vanohosprgstflag , "N")){

											if (StringHelper.strEquals(vsignyn , "Y")){ // ���εǾ��� �������� �ƴϸ� ��������
												
												if(StringHelper.strEquals(vinsuno.substring(0,1) , "6") && StringHelper.strEquals(vinsucd, "32000110")) {
													//
												}else{

													if ( vgenrdd == vOrddd ){
														msg_srdg = "���� Signȯ���Դϴ�. �������� �����Ͻðڽ��ϱ�?[2-1-2-��-��-B-A]";	
														retVO.set("msg_srdg" , msg_srdg);
														retVO.set("msg_type" , "Q");
														return retVO;
													}
												
													if ( vgenrdd != vOrddd ){
														msg_srdg = "�������� �����Ͻðڽ��ϱ�?[2-1-2-��-��-B-B]";	
														retVO.set("msg_srdg" , msg_srdg);
														retVO.set("msg_type" , "Q");
														return retVO;
													}									
												
												}
											}
											
											// ���ξȵǾ����� guide�Ѵ�.
											if (!StringHelper.strEquals(vsignyn , "Y")){ 
													msg_srdg = "�����Ƿڼ��� �ۼ��Ǿ����ϴ�, �Ƿڼ� ������ �Ͻʽÿ�.\n�������� �ʰ� ������ ��� �����Ͻðڽ��ϱ�?";
													retVO.set("msg_srdg"      , msg_srdg);
													retVO.set("msg_type" , "Q");
													return retVO;
											}
									}

								}


								// ������ȣ �����鼭 �Ⱓ�� ������ ����������
								if (!StringHelper.strEquals(vdiagno , "0") && !StringHelper.strEquals(vdiagno , null) ){  
										if ( vOrddd >= vsrdgfromdd && vOrddd <= vsrdgtodd ) {			   
												    msg_srdg = "�������� �����Ͻðڽ��ϱ�?[2-1-2-��]";	
													retVO.set("msg_srdg" , msg_srdg);
													retVO.set("msg_type" , "Q");
													return retVO;
										}
								}
						}

				}
		
		}
		
		// �޿��̸鼭 ���׺����� ���ܴ����
		if ((StringHelper.strEquals(vinsukindcd ,"21") || StringHelper.strEquals(vinsukindcd ,"22")) && !StringHelper.strEquals(vsuppkindcd , "01")){
			  
			  // �̹� ������ ����Ǿ��� ������ ������ �������� check�ؾ� ��
				if (StringHelper.strEquals(vsuppkindcd ,"06") || StringHelper.strEquals(vsuppkindcd ,"11")){
							
							// �������� �ƴϸ� �ȵ�
							if (!StringHelper.strEquals(vcode ,vcancer)){
								  msg_srdg = "[����] �����Ҽ� ���� ���Դϴ�![2-2-1-��]";					
								  retVO.set("msg_srdg" , msg_srdg);
								  retVO.set("msg_type" , "E");
								  return retVO;			
							}
							
							// ������ȣ ������ ��û�����̰� 
							if (StringHelper.strEquals(vdiagno ,"0")){
								
									if (StringHelper.strEquals(vanohosprgstflag ,"Y")){
											msg_srdg = "Ÿ���� ������� ȯ�� �Դϴ�.�ڰ��� Ȯ���ϼ���![2-2-1-��-A]";
											retVO.set("msg_srdg" , msg_srdg);
											retVO.set("msg_type" , "E");
											return retVO;
									}

									//2012-12-06
									if (!StringHelper.strEquals(vsignyn , "Y")){ 
										msg_srdg = vgenrddtext + " �����Ƿڼ��� �ۼ��Ǿ����ϴ�, \n�Ƿڼ� ������ �Ͻ� �� �������ּ���!![���������-����ȯ�ڵ��]";
										retVO.set("msg_srdg"      , msg_srdg);
										retVO.set("msg_type" , "E");
										return retVO;
									}
									
									if (StringHelper.strEquals(vanohosprgstflag ,"N")){
											msg_srdg = "������ȣ�� �����ϴ�. ��ȣ�� ���ι޾ƾ� [����]������ �����մϴ�.[2-2-1-��-B]"; 
											retVO.set("msg_srdg"      , msg_srdg);
											retVO.set("msg_type" , "E");
											return retVO;
									}
									
									
							}

							if (!StringHelper.strEquals(vdiagno ,"0") && !StringHelper.strEquals(vdiagno ,null)) { // ������ȣ ������ �Ⱓ�� check��
									//�������ڴ� ������, �������� ������ �ƴ�
									if ( vOrddd < vsrdgfromdd || vOrddd > vsrdgtodd ) {			   
										msg_srdg = "�������ڰ� [����]�Ⱓ ������ ���Ե��� �ʽ��ϴ�.[2-2-1-��]";	
										retVO.set("msg_srdg" , msg_srdg);
										retVO.set("msg_type" , "E");
										return retVO;
									}
							}
				}
				
				// ������ ������Ǿ��� ������ ������ �������� check�ؾ� ��
				if (!StringHelper.strEquals(vsuppkindcd ,"06") && !StringHelper.strEquals(vsuppkindcd ,"11")){

						// ������ �ش��ϴ� ���̸�
						if (StringHelper.strEquals(vcode ,vcancer)){

								// ������ȣ ������ ��û�����̰� sign�� �Ǿ����� ������. �� �������� �ƴҰ��
								if (!StringHelper.strEquals(vdiagno ,"0") && !StringHelper.strEquals(vdiagno ,null)) {
									
								        // ������ȣ �����鼭 �Ⱓ�� ������ ����������
										if (vOrddd >= vsrdgfromdd && vOrddd <= vsrdgtodd ) {			   
												msg_srdg = "[����]���� �����Ͻðڽ��ϱ�?[2-2-2-��]";	
												retVO.set("msg_srdg" , msg_srdg);
												retVO.set("msg_type" , "Q");
												return retVO;
										}
								}
								
								if (StringHelper.strEquals(vanohosprgstflag , "N")){

									// ���ξȵǾ����� guide�Ѵ�.
									if (!StringHelper.strEquals(vsignyn , "Y")){ 
											msg_srdg = vgenrddtext + " �����Ƿڼ��� �ۼ��Ǿ����ϴ�, \n�Ƿڼ� ������ �Ͻ� �� �������ּ���!![���������-����ȯ�ڵ��]";
											retVO.set("msg_srdg"      , msg_srdg);
											retVO.set("msg_type" , "E");
											return retVO;
									}
							}
						}
				}
		}

		retVO.set("msg_srdg" , msg_srdg);
		return retVO;

	}
	
	public ValueObject fRooaInfoVeri_check(ValueObject pVO , String code, String suppkind, String srchflag, ValueObject rooaVO) throws LiveException {

		ValueObject retVO = new ValueObject();
		if(rooaVO.size() == 0){  rooaVO.set("temp", "temp");  }

		String msg_rooa = "";
		String msg_type = "";

		String vpid        = pVO.getString("pid");
		int vOrddd         = Integer.parseInt(pVO.getString("orddd"));
		String vcretno     = pVO.getString("cretno");
		String vinsukindcd = pVO.getString("insukind");
		String vsuppkindcd = pVO.getString("suppkind");
		String vinsuno     = pVO.getString("insuno");
		String vinsucd     = pVO.getString("insucd");
		String vcode       = code;
		String popsuppkind = suppkind;
		
		//�������� �ȳѾ�ý� ����ó��
		if ( StringHelper.strEquals(vinsuno , "")  || StringHelper.strEquals(vinsuno , null)) {
			vinsuno = "0";
		}
		if ( StringHelper.strEquals(vinsucd , "")  || StringHelper.strEquals(vinsucd , null)) {
			vinsucd = "0";
		}

		int vgenrdd 		     = Integer.parseInt(rooaVO.getString("rooa_genrdd" ,"0"));

		String vgenrddtext       = StringHelper.toSubString(rooaVO.getString("rooa_genrdd"), 4, 6) + "��" + StringHelper.toSubString(rooaVO.getString("rooa_genrdd"), 6, 8) + "��";	
		String vdiagno           = rooaVO.getString("rooa_rareobstno");
		String vsignyn           = rooaVO.getString("rooa_signyn");
		String vcancer           = "V027";
		int vsrdgfromdd          = Integer.parseInt(rooaVO.getString("rooa_fromdd" ,"0"));
		int vsrdgtodd	         = Integer.parseInt(rooaVO.getString("rooa_todd" ,"0"));
		String vanohosprgstflag  = rooaVO.getString("rooa_anohosprgstflag");

		//������ȯ�� Ư��ó�� - �������� �������� �ǰ������� ������������ �ӽ÷� �ٲ㼭 ����üũ�� �Ѵ�.
		if( (Integer.parseInt(vsuppkindcd) > 32)  && (Integer.parseInt(vsuppkindcd) < 46)) {
				vsuppkindcd = this.getChgScnd(pVO).getString("final_suppkind");
		}
		//������ȯ�� Ư��ó�� ��


		// �ǰ������̸鼭 ���׺����� ���ܴ����
		// 2010.12.02 syjung �Ƿ�޿� 1,2�� ��ͳ�ġ�� ����Ư�� �߰�(2010.12.01 ��� ����)
		if ((StringHelper.strEquals(vinsukindcd , "11")  && !StringHelper.strEquals(vsuppkindcd , "01")) || 
			(StringHelper.strEquals(vinsukindcd , "21")  && !StringHelper.strEquals(vsuppkindcd , "01"))) {

		 	// �̹� ��ͻ�Ư�� ����Ǿ��� ������ ������ �������� check�ؾ� ��
			if ( StringHelper.strEquals(vsuppkindcd , "50") || StringHelper.strEquals(vsuppkindcd , "51") || StringHelper.strEquals(vsuppkindcd , "46") 		//��ͳ�ġ����Ư��
				 || StringHelper.strEquals(vsuppkindcd , "02") || StringHelper.strEquals(vsuppkindcd , "03") || StringHelper.strEquals(vsuppkindcd , "04")	//����Ư��(����,����,����̽�)
				 || StringHelper.strEquals(vsuppkindcd , "61") || StringHelper.strEquals(vsuppkindcd , "62") || StringHelper.strEquals(vsuppkindcd , "63") || StringHelper.strEquals(vsuppkindcd , "64")	//����ȭ��
				 || StringHelper.strEquals(vsuppkindcd , "87") || StringHelper.strEquals(vsuppkindcd , "88") || StringHelper.strEquals(vsuppkindcd , "89")	//���η��������Ʋ��
			
			){
						
				//V027�� ��ͻ�Ư ����
				if (StringHelper.strEquals(vcode , vcancer) ){
					msg_rooa = "��ͳ�ġ������Ư�� �����Ҽ� ���� Ư���ڵ��Դϴ�.[V027][3]";
					retVO.set("msg_rooa" , msg_rooa);
					retVO.set("msg_type" , "E");
				    return retVO;			
				}
				
				// ��ͻ�Ư��ȣ ������ ��û����,  7/1~9/30 �����Ⱓ�� ��� ���θ� üũ���� ����. 10/1�Ϻ��� üũ��.
				if (StringHelper.strEquals(vdiagno , "0") && "20091001".compareTo(pVO.getString("orddd")) <= 0 
						&& !StringHelper.strEquals(srchflag , "A") && !StringHelper.strEquals(srchflag , "B") && !StringHelper.strEquals(srchflag , "F")){

					// ������ ����.
					//if ( StringHelper.strEquals(vsignyn , "Y")){
					//	if ( vgenrdd != vOrddd ){
					//		msg_rooa = vgenrddtext + " ��ͳ�ġ������Ư�� Signȯ���Դϴ�.[4]";					
					//		retVO.set("msg_rooa" , msg_rooa);
					//		retVO.set("msg_type" , "I");
					//		return retVO;
					//	}
				    //}
					 
					 // ���ξ�����
					 if ( !StringHelper.strEquals(vsignyn , "Y")){ 

						//if (StringHelper.strEquals(vanohosprgstflag , "Y")){
						//	msg_rooa = "Ÿ���� ��ͳ�ġ������Ư�ʵ�� ȯ�� �Դϴ�.�ڰ��� Ȯ���ϼ���![5]";
						//	retVO.set("msg_rooa" , msg_rooa);
						//	retVO.set("msg_type" , "E");
						//	return retVO;
						//}

						if (StringHelper.strEquals(vanohosprgstflag , "N")){
							msg_rooa = "��ͳ�ġ����Ư�� �Ƿڼ� ������ ���� �ʾҽ��ϴ�. \n�Ƿڼ� ���� �� ��ͳ�ġ������Ư�� ���� �����մϴ�. \n���� �� ���������� �ּ���[���������-��ͳ�ġȯ�ڵ��][6]";
							retVO.set("msg_rooa"      , msg_rooa);
							retVO.set("msg_type"      , "E");
							return retVO;
						}

				     }	

				}
				
				// ��ͳ�ġ������Ư�� ������ �Ⱓ�� check��
				if (!StringHelper.strEquals(vdiagno , "0") && !StringHelper.strEquals(vdiagno , null) && "20091001".compareTo(pVO.getString("orddd")) <= 0 
						&& !StringHelper.strEquals(srchflag , "A") && !StringHelper.strEquals(srchflag , "B") && !StringHelper.strEquals(srchflag , "F")){ 
					if (vOrddd < vsrdgfromdd || vOrddd > vsrdgtodd ) {			   
						msg_rooa = "�������ڰ� ��ͳ�ġ������Ư�� ������ ���Ե��� �ʽ��ϴ�.[7]";	
						retVO.set("msg_rooa" , msg_rooa);
						retVO.set("msg_type" , "E");
						return retVO;
					}
				}
				
				//���� ������ Ʋ�ϴ� Ÿ������ ���� �Ұ�
				if( StringHelper.strEquals(vsuppkindcd , "87") || StringHelper.strEquals(vsuppkindcd , "88") || StringHelper.strEquals(vsuppkindcd , "89") ){
					
					//Ÿ���� ��û
					if (StringHelper.strEquals(vanohosprgstflag , "Y")){
						
						msg_rooa = "Ÿ���� ���� ������ ���� Ʋ�� ��û�� ȯ���Դϴ�. \n�������� �Ұ��մϴ�. �Ϲ��������� �����ϼ���[8]";
						retVO.set("msg_rooa"      , msg_rooa);
						retVO.set("msg_type"      , "E");
						return retVO;
					}
				}
			}
			
			//��ͳ�ġ������Ư�ʰ� ������Ǿ��� ������ ������ �������� check�ؾ� ��
			//������ȣ ���μ��� Ȯ�� �ʿ�.
//			if (!StringHelper.strEquals(vsuppkindcd , "50") && !StringHelper.strEquals(vsuppkindcd , "51")
//				&& !StringHelper.strEquals(vsuppkindcd , "46") && !StringHelper.strEquals(vsuppkindcd , "02") && !StringHelper.strEquals(vsuppkindcd , "03") 
//				&& !StringHelper.strEquals(vsuppkindcd , "04") && !StringHelper.strEquals(vsuppkindcd , "10") && !StringHelper.strEquals(vsuppkindcd , "37")) {
			if( StringHelper.strEquals(vsuppkindcd , "00")				//���� 
					|| StringHelper.strEquals(vsuppkindcd , "32")		//������1��
					|| StringHelper.strEquals(vsuppkindcd , "33") ){		//������2�� ����
				
				if ( log.isDebugEnabled() ) {
			   		 log.debug("**----��ͳ�ġ������Ư�� ------**  " );
			   		 log.debug("vcode :" + vcode);
			   		 log.debug("popsuppkind :" + popsuppkind);
			   		 log.debug("vdiagno :" + vdiagno);
			   		 log.debug("vsignyn :" + vsignyn);
			   		 log.debug("vsuppkindcd :" + vsuppkindcd);
			   		 log.debug("orddd : " + pVO.getString("orddd"));
				}
				
				 // ��ͳ�ġ������Ư�ʿ� �ش��ϴ� ���̸�
				if (!StringHelper.strEquals(vcode , vcancer)){
					
					// ��ͳ�ġ������Ư�ʹ�ȣ ������ ��û�����̰� sign�� �Ǿ����� ������.
					if (StringHelper.strEquals(vdiagno , "0") && "20091001".compareTo(pVO.getString("orddd")) <= 0) { 

						//Ÿ�������� üũ
						if (StringHelper.strEquals(vanohosprgstflag , "Y")){
							msg_rooa = "Ÿ���� ��ͳ�ġ������Ư�� ȯ�� �Դϴ�. �ڰ��� Ȯ���Ͻʽÿ�.[8]";
							retVO.set("msg_rooa" , msg_rooa);
							retVO.set("msg_type" , "E");
							return retVO;	
						}

						if (StringHelper.strEquals(vanohosprgstflag , "N")){

							if (StringHelper.strEquals(vsignyn , "Y")){ // ����

								if ( vgenrdd == vOrddd ){
									msg_rooa = "���� Signȯ���Դϴ�. ��ͳ�ġ������Ư�ʷ� �����Ͻðڽ��ϱ�?[9]";	
									retVO.set("msg_rooa" , msg_rooa);
									retVO.set("msg_type" , "Q");
									retVO.set("msg_suppkind", popsuppkind);
									return retVO;
								}
							
								if ( vgenrdd != vOrddd ){
									msg_rooa = "��ͳ�ġ������Ư�ʷ� �����Ͻðڽ��ϱ�?[10]";	
									retVO.set("msg_rooa" , msg_rooa);
									retVO.set("msg_type" , "Q");
									retVO.set("msg_suppkind", popsuppkind);
									return retVO;
								}									

							}
							
							// ���ξȵǾ����� guide�Ѵ�.
							if (!StringHelper.strEquals(vsignyn , "Y") && "20091001".compareTo(pVO.getString("orddd")) <= 0){ 
								//msg_rooa = "��ͳ�ġ������Ư�� �Ƿڼ��� �ۼ��Ǿ����ϴ�, �Ƿ����������� Sign�Ͻʽÿ�. �����Ͻðڽ��ϱ�?[11]";
								//retVO.set("msg_rooa"      , msg_rooa);
								//retVO.set("msg_type" , "Q");
								//2012-12-06
								if( StringHelper.strEquals(vinsukindcd , "21") ){
									msg_rooa = "��ͳ�ġ������Ư�� �Ƿڼ��� �ۼ��Ǿ����ϴ�, \n�Ƿڼ� ������ �Ͻ� �� �������ּ���!![���������-��ͳ�ġȯ�ڵ��]";
									retVO.set("msg_rooa"      , msg_rooa);
									retVO.set("msg_type" , "E");
								}else{
									msg_rooa = "��ͳ�ġ������Ư�� �Ƿڼ��� �ۼ��Ǿ����ϴ�, \n�Ƿڼ� ������ �Ͻʽÿ�.\n�������� �ʰ� ������ ��� �����Ͻðڽ��ϱ�?\n[Yes : ����, No : ����]";
									retVO.set("msg_rooa"      , msg_rooa);
									retVO.set("msg_type" , "Q");
								}
								
								retVO.set("msg_suppkind", popsuppkind);
								return retVO;
							}
						}

					}

					// ��ͳ�ġ������Ư�ʹ�ȣ �����鼭 �Ⱓ�� ������ ������
					if (!StringHelper.strEquals(vdiagno , "0") && !StringHelper.strEquals(vdiagno , null) && "20091001".compareTo(pVO.getString("orddd")) <= 0){  
						if ( vOrddd >= vsrdgfromdd && vOrddd <= vsrdgtodd ) {			   
							msg_rooa = "��ͳ�ġ������Ư�ʷ� �����Ͻðڽ��ϱ�?[12]";	
							retVO.set("msg_rooa" , msg_rooa);
							retVO.set("msg_type" , "Q");
							retVO.set("msg_suppkind", popsuppkind);
							return retVO;
						}
					}
					
					//Ư���ڵ尡 �����ϸ� 7/1~9/30���� Ư���ڵ�θ� üũ
					if (vcode != "" && vcode != "-" &&  vcode != "V193" && "20090701".compareTo(pVO.getString("orddd")) <= 0 && "20090930".compareTo(pVO.getString("orddd")) >= 0) {
						msg_rooa = "��ͳ�ġ������Ư�ʷ� �����Ͻðڽ��ϱ�?[13]";	
						retVO.set("msg_rooa" , msg_rooa);
						retVO.set("msg_type" , "Q");
						retVO.set("msg_suppkind", popsuppkind);
						return retVO;
					}
					
					//Ư���ڵ尡 �����ϸ� 10/1 ~ Ư���ڵ�θ� üũ
					if (vcode != "" && vcode != "-" &&  vcode != "V193" && "20091001".compareTo(pVO.getString("orddd")) <= 0
						&& StringHelper.strEquals(srchflag , "A") && StringHelper.strEquals(srchflag , "B")) {
						msg_rooa = "��ͳ�ġ������Ư�ʷ� �����Ͻðڽ��ϱ�?[13]";	
						retVO.set("msg_rooa" , msg_rooa);
						retVO.set("msg_type" , "Q");
						retVO.set("msg_suppkind", popsuppkind);
						return retVO;
					}
					
				}
			}
		}
		//�Ƿ�޿�2���̸鼭 Ư�ʴ��ȯ���̸� �����ϰ� ���ö�� �˸� �޼��� ��ϴ�. 20101202 cys
		if ((StringHelper.strEquals(vinsukindcd , "22")  && StringHelper.strEquals(vsuppkindcd , "00"))) {

			// ��ͳ�ġ������Ư�ʿ� �ش��ϴ� ���̸�
			if (!StringHelper.strEquals(vcode , vcancer)){

				// ��ͳ�ġ������Ư�ʹ�ȣ ������ ��û�����̰� sign�� �Ǿ����� ������.
				if (StringHelper.strEquals(vdiagno , "0") && vgenrdd == vOrddd ) {
					
					//Ÿ��������
					if (StringHelper.strEquals(vanohosprgstflag , "N")){
						
						//���ο���
						if (!StringHelper.strEquals(vsignyn , "Y")){

								msg_rooa = "��ͳ�ġ������Ư�� �Ƿڼ��� �ۼ��Ǿ����ϴ�. \n�Ƿڼ� ������ �Ͻ� �� ������ ��� �����ϼ���!" + '\n' +
										   "(�޿�2��ȯ�ڴ� ���ܿ��� ��͹�ȣ ������ �޿�1�� Ư�ʷ� �ڰ��� �ٲ�ϴ�.[12])";
		                        retVO.set("msg_rooa" , msg_rooa);
								//retVO.set("msg_type" , "I");
								//2012-12-06
		                        retVO.set("msg_type" , "E");
		                        return retVO;
	                     }
					}
				}
			}

		}

		retVO.set("msg_rooa" , msg_rooa);
		return retVO;

	}

    /*
     * ���� �����ڵ� ��ȸ
     * 2009.02.05. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getHospcd(ValueObject pVO) throws LiveException{

		return outrcptmngtDAO.getHospcd(pVO);
		
	}

	//����vip �������ȸ
	public ValueObject getVipStandList(ValueObject pVO) throws LiveException {

        //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

		ValueObject retVO = new ValueObject(); //��� VO    
                
        retVO = outrcptmngtDAO.getVipStandList(pVO);
        
		return retVO;
	}

    /*
     * ���� �ڰ���ȸ ���� üũ
     * 2009.03.16. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getMmsg2Check(ValueObject pVO) throws LiveException{

        //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

		return outrcptmngtDAO.getMmsg2Check(pVO);
		
	}

    /*
     * (��Javadoc)
     * ������ȯ�� ��ȯó��
     * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getChgScnd(kr.co.hit.live.vo.ValueObject)
     */
    public ValueObject getChgScnd(ValueObject pVO) throws LiveException{
        
        ValueObject scndVO = new ValueObject();
        ValueObject retVO = new ValueObject();

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

        scndVO.set("instcd"      , pVO.getString("instcd"));
        scndVO.set("pid"          , pVO.getString("pid"));
        scndVO.set("orddd"      , pVO.getString("orddd"));
        scndVO.set("cretno"     , pVO.getString("cretno"));
        scndVO.set("insukind"   , pVO.getString("insukind"));
        scndVO.set("suppkind"  , pVO.getString("suppkind"));
        scndVO.set("updtyn"     , "N");
        scndVO.set("chckpass"  , "Y");

		retVO = scndSuptrgt.setScndSuptrgt(scndVO);
        //"final_suppkind"

        return retVO;
    }   

    /*
     * (��Javadoc)
     * ������ȯ�� ����üũ
     * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getChgScnd(kr.co.hit.live.vo.ValueObject)
     */
    public ValueObject getChkScnd(ValueObject pVO) throws LiveException{
        
        ValueObject scndVO = new ValueObject();
        ValueObject retVO = new ValueObject();

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

        scndVO.set("instcd"     , pVO.getString("instcd"));
        scndVO.set("pid"        , pVO.getString("pid"));
        scndVO.set("orddd"      , pVO.getString("orddd"));
        scndVO.set("cretno"     , pVO.getString("cretno"));
        scndVO.set("insukind"   , pVO.getString("insukind"));
        scndVO.set("suppkind"   , pVO.getString("suppkind"));
        scndVO.set("updtyn"     , "N");
        //scndVO.set("chckpass"  , "Y");

		retVO = scndSuptrgt.setScndSuptrgt(scndVO);
        //"final_suppkind"

        return retVO;
    }  


    /*
     * (��Javadoc)
     * ������ȯ�� ��ȯó��(������Ʈ ����)
     * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#setOtptScnd(kr.co.hit.live.vo.ValueObject)
     */
    public int setOtptScnd(ValueObject pVO) throws LiveException{

        String sUserId = "";

        sUserId = StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID));
        
        ValueObject scndVO = new ValueObject();
        ValueObject retVO = new ValueObject();
		int cnt = 0;

		 for (int a = 0; a < pVO.size(); a++) {

			scndVO.set("instcd"      , pVO.getString(a,"instcd"));
			scndVO.set("pid"          , pVO.getString(a,"pid"));
			scndVO.set("orddd"      , pVO.getString(a,"orddd"));
			scndVO.set("cretno"     , pVO.getString(a,"cretno"));
			scndVO.set("insukind"   , pVO.getString(a,"insukind"));
			scndVO.set("suppkind"  , pVO.getString(a,"suppkind"));
			scndVO.set("updtyn"     , "Y");
			scndVO.set("userid"     , sUserId);
			
			//scndVO.set("chckpass"  , "Y");

			retVO = scndSuptrgt.setScndSuptrgt(scndVO);

			if(retVO.getString("suppkind") !=  retVO.getString("final_suppkind")) {
				cnt = cnt+ 1;
			}

		 }

        return cnt;
    } 


    //����ó�� ���� üũ
    public ValueObject getChkOtptMJ(ValueObject pVO) throws LiveException{
        
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
        return outrcptmngtDAO.getChkOtptMJ(pVO);
        
    }

    //�������
    public ValueObject setSumOrdAmt(ValueObject pVO) throws LiveException{
        
			ValueObject opmiVO      = new ValueObject();

			ValueObject sum_opmiVO  = new ValueObject();

			opmiVO = pVO;

			int vopmi_count           = opmiVO.size();
			int vopmi_totamt          = 0;
			int vopmi_payamt          = 0;
			int vopmi_nopyamt         = 0;
			int vopmi_allownbamt      = 0;    
			int vopmi_totnopyamt      = 0;
			int vopmi_totnopyownbamt  = 0;
			int vopmi_totnopyinsubamt = 0;
			int vopmi_payownbamt      = 0;
			int vopmi_payinsubamt     = 0;
			int vopmi_handcapfund     = 0;
			int vopmi_ersubtamt       = 0;
			int vopmi_procsubtamt     = 0;
			int vopmi_subtamt         = 0;
			int vopmi_specamt         = 0;
			int vopmi_discreduamt     = 0;
			int vopmi_discamt         = 0;
			int vopmi_reduamt         = 0;
			int vopmi_bloddiscamt     = 0;
			int vopmi_totownbamt      = 0;
			int vopmi_totownbamt2     = 0;    //�Ѻ��κδ�ݿ��� ����ó���� �ݾ�
			int vopmi_precashamt      = 0;
			int vopmi_premdlrcptamt   = 0;
			int vopmi_precardamt      = 0;
			int vopmi_preonlineamt    = 0;
			int vopmi_mdlrcptamt      = 0;
			int vopmi_uncoamt         = 0;
			int vopmi_cardamt         = 0;
			int vopmi_cashamt         = 0;
			int vopmi_onlineamt       = 0;
			int vopmi_rcptexptamt     = 0;    
			int vopmi_restamt         = 0;
			int vopmi_paydepoamt      = 0;
			int vopmi_nopyownbamt     = 0;
			int vopmi_nopyinsubamt    = 0;
			int vopmi_allownownbamt   = 0;
			int vopmi_allowninsubamt  = 0;
			int vopmi_specownbamt     = 0;
			int vopmi_specinsubamt    = 0;
			
			int vopmi_heallifeamtclamamt = 0;
			int vopmi_prepregdmndamt  = 0;
			int vopmi_pregdmndamt  = 0;
			int vopmi_suppamt         = 0;
			
			int vopmi_labamt          = 0;

			int vopmi_server_rcptamt  = 0;
			
		    //20090701 1.�ܼ�ó�� �������
			int vopmi_payinsurestamt  = 0;
			int vopmi_payownbamt100  = 0;
			int vopmi_payinsubamt100  = 0;
			int vopmi_totownbamt100  = 0;
			
			//20110701 �̿뼺�� �ΰ��� ��� ����
			int vopmi_taxamt = 0;
			
			String vopmi_clincstdyno     = "";

				if  (opmiVO.size() > 0) {							
					for (int i=0 ; i< opmiVO.size() ; i++) {
					
						//------------------------------------------------------------------------------------------------------------------------------------------                                                                                     
						//�������, �ѱ޿���, �Ѻ�޿���, �����׺δ��, �Ѽ��������
						vopmi_totamt 			= vopmi_totamt			+ opmiVO.getInt(i, "opmi_totamt");
						vopmi_payamt			= vopmi_payamt			+ opmiVO.getInt(i, "opmi_payamt");
						vopmi_nopyamt			= vopmi_nopyamt			+ opmiVO.getInt(i, "opmi_nopyamt");
						vopmi_allownbamt		= vopmi_allownbamt		+ opmiVO.getInt(i, "opmi_allownbamt");
						vopmi_specamt			= vopmi_specamt			+ opmiVO.getInt(i, "opmi_specamt");
						//------------------------------------------------------------------------------------------------------------------------------------------                                                                                     
						//��޿��� = ��޿���+���׺��κδ�� (��޿����� = ��޿�����+���׺��� ���� /  ��޿����� = ��޿�����+���׺��� ����)									
						vopmi_totnopyamt		= vopmi_totnopyamt		+ opmiVO.getInt(i, "opmi_totnopyamt");
						vopmi_totnopyownbamt	= vopmi_totnopyownbamt 	+ opmiVO.getInt(i, "opmi_nopyownbamt")  + opmiVO.getInt(i, "opmi_allownownbamt");
						vopmi_totnopyinsubamt	= vopmi_totnopyinsubamt + opmiVO.getInt(i, "opmi_nopyinsubamt") + opmiVO.getInt(i, "opmi_allowninsubamt");
						//------------------------------------------------------------------------------------------------------------------------------------------                                                                                     
						//�������� ���� / ������
						vopmi_specownbamt   	= vopmi_specownbamt 	+ opmiVO.getInt(i, "opmi_specownbamt");
						vopmi_specinsubamt      = vopmi_specinsubamt 	+ opmiVO.getInt(i, "opmi_specinsubamt");
						//------------------------------------------------------------------------------------------------------------------------------------------                                                                                     
						//�޿� ����/������
						vopmi_payownbamt		= vopmi_payownbamt		+ opmiVO.getInt(i, "opmi_payownbamt");
						vopmi_payinsubamt		= vopmi_payinsubamt		+ opmiVO.getInt(i, "opmi_payinsubamt");
						//------------------------------------------------------------------------------------------------------------------------------------------                                                                                     
						//����α��, ���޴�Ҿ�,��ȣ��Ҿ�,����Ѿ�
						vopmi_handcapfund		= vopmi_handcapfund		+ opmiVO.getInt(i, "opmi_handcapfund");
						vopmi_ersubtamt		    = vopmi_ersubtamt		+ opmiVO.getInt(i, "opmi_ersubtamt");
						vopmi_procsubtamt		= vopmi_procsubtamt		+ opmiVO.getInt(i, "opmi_procsubtamt");
						vopmi_subtamt			= vopmi_subtamt			+ opmiVO.getInt(i, "opmi_subtamt");
						//------------------------------------------------------------------------------------------------------------------------------------------                                                                                     
						//�����Ѿ�, ���ξ�, ����, ���װ���
						vopmi_discreduamt		= vopmi_discreduamt		+ opmiVO.getInt(i, "opmi_discreduamt");
						vopmi_discamt			= vopmi_discamt			+ opmiVO.getInt(i, "opmi_discamt");
						vopmi_reduamt			= vopmi_reduamt			+ opmiVO.getInt(i, "opmi_reduamt");
						vopmi_bloddiscamt		= vopmi_bloddiscamt		+ opmiVO.getInt(i, "opmi_bloddiscamt");
						//------------------------------------------------------------------------------------------------------------------------------------------                                                                                     
						//�Ѻ��κδ��, �Ѻ��κδ��2(����ó��)	
						vopmi_totownbamt		= vopmi_totownbamt		+ opmiVO.getInt(i, "opmi_totownbamt");
						vopmi_totownbamt2		= vopmi_totownbamt2		+ opmiVO.getInt(i, "opmi_totownbamt2");
						//------------------------------------------------------------------------------------------------------------------------------------------                                                                                     
						//�������
						vopmi_precashamt		= vopmi_precashamt		+ opmiVO.getInt(i, "opmi_precashamt");
						vopmi_premdlrcptamt	    = vopmi_premdlrcptamt	+ opmiVO.getInt(i, "opmi_premdlrcptamt");
						vopmi_precardamt		= vopmi_precardamt		+ opmiVO.getInt(i, "opmi_precardamt");
						vopmi_preonlineamt		= vopmi_preonlineamt	+ opmiVO.getInt(i, "opmi_preonlineamt");
						//------------------------------------------------------------------------------------------------------------------------------------------                                                                                     
						vopmi_mdlrcptamt		= vopmi_mdlrcptamt		+ opmiVO.getInt(i, "opmi_mdlrcptamt");
						vopmi_uncoamt			= vopmi_uncoamt			+ opmiVO.getInt(i, "opmi_uncoamt");
						vopmi_cardamt			= vopmi_cardamt			+ opmiVO.getInt(i, "opmi_cardamt");
						vopmi_cashamt			= vopmi_cashamt			+ opmiVO.getInt(i, "opmi_cashamt");
						vopmi_onlineamt		    = vopmi_onlineamt		+ opmiVO.getInt(i, "opmi_onlineamt");
						vopmi_rcptexptamt		= vopmi_rcptexptamt		+ opmiVO.getInt(i, "opmi_rcptexptamt");
						vopmi_restamt			= vopmi_restamt			+ opmiVO.getInt(i, "opmi_restamt");
						vopmi_paydepoamt		= vopmi_paydepoamt		+ opmiVO.getInt(i, "opmi_paydepoamt");
						vopmi_heallifeamtclamamt= vopmi_heallifeamtclamamt	+ opmiVO.getInt(i, "opmi_heallifeamtclamamt");
						vopmi_prepregdmndamt     = vopmi_prepregdmndamt	   + opmiVO.getInt(i, "opmi_prepregdmndamt");
						vopmi_pregdmndamt     = vopmi_pregdmndamt	   + opmiVO.getInt(i, "opmi_pregdmndamt");

						vopmi_suppamt           = vopmi_suppamt			+ opmiVO.getInt(i, "opmi_suppamt");
						vopmi_labamt			= vopmi_labamt			+ opmiVO.getInt(i, "opmi_labamt");

						vopmi_server_rcptamt = vopmi_server_rcptamt + opmiVO.getInt(i, "opmi_server_rcptamt");
						
					    //20090701 1.�ܼ�ó�� �������
						vopmi_payinsurestamt = vopmi_payinsurestamt + opmiVO.getInt(i, "opmi_payinsurestamt");
						vopmi_payownbamt100 = vopmi_payownbamt100 + opmiVO.getInt(i, "opmi_payownbamt100");
						vopmi_payinsubamt100 = vopmi_payinsubamt100 + opmiVO.getInt(i, "opmi_payinsubamt100");
						vopmi_totownbamt100 = vopmi_totownbamt100 + opmiVO.getInt(i, "opmi_totownbamt100");
						
						//20110701 �̿뼺�� �ΰ��� ��� ����
						vopmi_taxamt = vopmi_taxamt + opmiVO.getInt(i, "opmi_taxamt");
					}
				}

			sum_opmiVO.set("totamt"             , vopmi_totamt); 			
			sum_opmiVO.set("payamt"       	    , vopmi_payamt);			
			sum_opmiVO.set("payownbamt"   	    , vopmi_payownbamt);
			sum_opmiVO.set("payinsubamt"  	    , vopmi_payinsubamt);
			sum_opmiVO.set("totnopyamt"   	    , vopmi_totnopyamt);
			//sum_opmiVO.set("nopyinsubamt" 	   , 0); 
			//sum_opmiVO.set("nopyownbamt"  	   , 0); 
			sum_opmiVO.set("specamt"      	    , vopmi_specamt);
			sum_opmiVO.set("specinsubamt" 	    , vopmi_specinsubamt);
			sum_opmiVO.set("specownbamt"  	    , vopmi_specownbamt);
			sum_opmiVO.set("totownbamt"   	    , vopmi_totownbamt);
			sum_opmiVO.set("totownbamt2"  	    , vopmi_totownbamt2);
			sum_opmiVO.set("handcapfund"  	    , vopmi_handcapfund);
			
            sum_opmiVO.set("ersubtamt"      	, vopmi_ersubtamt);
            sum_opmiVO.set("procsubtamt"      	, vopmi_procsubtamt);
            sum_opmiVO.set("subtamt"      	    , vopmi_subtamt);

			sum_opmiVO.set("bloddiscamt"  	    , vopmi_bloddiscamt);
			sum_opmiVO.set("discamt"      	    , vopmi_discamt);
			sum_opmiVO.set("reduamt"      	    , vopmi_reduamt);
			sum_opmiVO.set("uncoamt"      	    , vopmi_uncoamt);
			sum_opmiVO.set("precashamt"   	    , vopmi_precashamt);
			sum_opmiVO.set("premdlrcptamt"	    , vopmi_premdlrcptamt);
			sum_opmiVO.set("precardamt"   	    , vopmi_precardamt);
			sum_opmiVO.set("preonlineamt" 	    , vopmi_preonlineamt);
			sum_opmiVO.set("mdlrcptamt"   	    , vopmi_mdlrcptamt);
			sum_opmiVO.set("rcptexptamt"  	    , vopmi_rcptexptamt);
			sum_opmiVO.set("cardamt"      	    , vopmi_cardamt);
			sum_opmiVO.set("cashamt"      	    , vopmi_cashamt);
			sum_opmiVO.set("onlineamt"    	    , vopmi_onlineamt);
			sum_opmiVO.set("paypsnflag"   	    , "1");
			sum_opmiVO.set("paypsnrem"    	    , "");
			sum_opmiVO.set("paydepoamt"   	    , vopmi_paydepoamt);
			sum_opmiVO.set("totnopyinsubamt"    , vopmi_totnopyinsubamt);
			sum_opmiVO.set("totnopyownbamt"     , vopmi_totnopyownbamt );
			sum_opmiVO.set("heallifeamtclamamt" , vopmi_heallifeamtclamamt);
			sum_opmiVO.set("prepregdmndamt"		, vopmi_prepregdmndamt);
			sum_opmiVO.set("pregdmndamt"		, vopmi_pregdmndamt);
			sum_opmiVO.set("suppamt"            , vopmi_suppamt);
			sum_opmiVO.set("clincstdyno"        , "");
			sum_opmiVO.set("labamt"             , vopmi_labamt);
			sum_opmiVO.set("server_rcptamt"     , vopmi_server_rcptamt);
			
		    //20090701 1.�ܼ�ó�� �������
			sum_opmiVO.set("payinsurestamt"     , vopmi_payinsurestamt);
			sum_opmiVO.set("payownbamt100"      , vopmi_payownbamt100);
			sum_opmiVO.set("payinsubamt100"     , vopmi_payinsubamt100);
			sum_opmiVO.set("totownbamt100"      , vopmi_totownbamt100);
			
			//20110701 �̿뼺�� �ΰ��� ��� ����
			sum_opmiVO.set("taxamt"      				, vopmi_taxamt);

      return sum_opmiVO;
        
    }

	/*(��Javadoc) �������� ��� ���θ� ��ȸ
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getSpecOrdAppYN(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getSpecOrdAppYN(ValueObject pVO) throws LiveException {
		
		ValueObject chkVO = etcOutRgst.getSpecOrdAppAutoYN(pVO);
		
		if ("Y".equals(chkVO.getString("autoyn"))) { //���������ڵ� P0051 Y�� ��츸 �ڵ���ȸ
			pVO.set("opatyn", "N");	//��� Y, ���� N	
			return etcOutRgst.getSpecOrdAppRgstRef(pVO);
		} else {
			ValueObject retVO = new ValueObject();
			retVO.set("rgstyn", "-");	
			return retVO;
		}
		
	}

	//���������ڵ� (desc��ȸ)
	public ValueObject getPmcmCode(ValueObject pVO) throws LiveException {

		//����ڵ� ��ȸ
		pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		
		//����� ��ȸ
		pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));

		return outrcptmngtDAO.getPmcmCode(pVO);
	}

	//���������ڵ� (cdid��ȸ)
	public ValueObject getPmcmCodeNm(String cdid) throws LiveException {

		ValueObject pVO = new ValueObject();
		ValueObject retVO = new ValueObject();

		//����ڵ� ��ȸ
		pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		
		//����� ��ȸ
		pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
		
		pVO.set("cdid" , cdid);
		
		retVO = outrcptmngtDAO.getPmcmCodeNm(pVO);

		if(retVO.size() == 0) {
			retVO.set("cdgrupid" , "");
			retVO.set("cdid"       , "");
			retVO.set("cdnm"      , "");
		}

		return retVO;
	}

	//���������ڵ� (cdid��ȸ)
	public ValueObject getPmcmCodeNm(String cdgrupid , String cdid) throws LiveException {

		ValueObject pVO = new ValueObject();
		ValueObject retVO = new ValueObject();

		//����ڵ� ��ȸ
		pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		
		//����� ��ȸ
		pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
		
		pVO.set("cdgrupid" , cdgrupid);
		pVO.set("cdid" , cdid);

		retVO = outrcptmngtDAO.getPmcmCodeNm(pVO);

		if(retVO.size() == 0) {
			retVO.set("cdgrupid" , "");
			retVO.set("cdid"       , "");
			retVO.set("cdnm"      , "");
		}

		return retVO;
	}

	//���������ڵ� (cdid��ȸ)
	public ValueObject getPmcmCodeNm(String cdgrupid , String cdid  , String sessinstcd) throws LiveException {

		ValueObject pVO = new ValueObject();
		ValueObject retVO = new ValueObject();

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(sessinstcd, "")) {
			sessinstcd = StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE));
        }
        
		//����� ��ȸ
		pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));

		
		pVO.set("cdgrupid" , cdgrupid);
		pVO.set("cdid" , cdid);
		pVO.set("sessinstcd" , sessinstcd);


		retVO = outrcptmngtDAO.getPmcmCodeNm(pVO);

		if(retVO.size() == 0) {
			retVO.set("cdgrupid" , "");
			retVO.set("cdid"       , "");
			retVO.set("cdnm"      , "");
		}

		return retVO;
	}

    //ZBCMCODE �����ڵ���ȸ
    public ValueObject getZbcmCode(String cdgrupid , String cdid) throws LiveException {

        ValueObject pVO = new ValueObject();
        ValueObject retVO = new ValueObject();

        //����ڵ� ��ȸ
        pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        
        //����� ��ȸ
        pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        
        pVO.set("cdgrupid" , cdgrupid);
        pVO.set("cdid" , cdid);

        retVO = outrcptmngtDAO.getZbcmCode(pVO);

        if(retVO.size() == 0) {
            retVO.set("cdgrupid" , "");
            retVO.set("cdid"       , "");
            retVO.set("cdnm"      , "");
        }

        return retVO;
    }

    //�ں� , ���� ���� ��ȸ
    public ValueObject checkJaboSanjaeInfo(ValueObject pVO) throws LiveException {

        ValueObject retVO = new ValueObject();

        //����ڵ� ��ȸ
        pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        //����� ��ȸ
        pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));

        retVO = etcOutRgst.checkJaboSanjaeInfo(pVO);
        
        return retVO;
        
    }
    
    /* �Ǻ�, �Ǻ� �ڰ����� üũ
     * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.OutRcptMgt#checkInsuInfo(kr.co.hit.live.vo.ValueObject)
     */
    public ValueObject checkInsuInfo(ValueObject pVO) throws LiveException {

        ValueObject retVO = new ValueObject();

        //����ڵ� ��ȸ
        pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        //����� ��ȸ
        pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));

        retVO = outrcptmngtDAO.checkInsuInfo(pVO);
        
        return retVO;
        
    }

    //����üũ (���μ���,�ܷ� ������ư������ ���)
    public ValueObject getChk_Srdg(ValueObject pVO) throws LiveException {

            ValueObject esscVO = new ValueObject();
            ValueObject srdgVO = new ValueObject();
            ValueObject msgVO_srdg  = new ValueObject();

            String vinsukind      = "";
            String vsuppkind      = "";
            String vsuppkindsubyn = "";
            String vprcpgenryn    = "";
            String vdracptyn      = "";

             for (int a = 0; a < pVO.size(); a++) {

                vinsukind      = pVO.getString(a,"insukind");
                vsuppkind      = pVO.getString(a,"suppkind"); 
                vsuppkindsubyn = pVO.getString(a,"suppkindsubyn");  //���������� �ΰ����� �ְ� N, �ΰ� Y(�ְ��϶��� üũ�Ѵ�)
                vprcpgenryn    = pVO.getString(a,"prcpgenryn");
                vdracptyn      = pVO.getString(a,"dracptyn");

                //������ȯ�� Ư��ó�� - �������� �������� �ǰ������� ������������ �ӽ÷� �ٲ㼭 ����üũ�� �Ѵ�.
                if( (Integer.parseInt(vsuppkind) > 32)  && (Integer.parseInt(vsuppkind) < 46)) {
                    vsuppkind = this.getChgScnd(pVO.getRowAsVo(a)).getString("final_suppkind");
                }
                //������ȯ�� Ư��ó�� ��

                //���׺��κδ��ϰ�� ����Ư�ʷ��� ��Ÿ���ؾ���.
                if ((StringHelper.strEquals(vinsukind , "11") || StringHelper.strEquals(vinsukind , "21") || StringHelper.strEquals(vinsukind , "22")) &&
                    !StringHelper.strEquals(vsuppkind , "01") && !StringHelper.strEquals(vsuppkind , "12") &&
                    !StringHelper.strEquals(vsuppkind , "13") && !StringHelper.strEquals(vsuppkind , "32") &&
                     StringHelper.strEquals(vsuppkindsubyn , "N")
                 ) {

                        ValueObject tempVO = new ValueObject();

                        tempVO.set("pid"       , pVO.getString(a,"pid"));
                        tempVO.set("orddd"     , pVO.getString(a,"orddd"));
                        tempVO.set("orddeptcd" , pVO.getString(a,"orddeptcd"));
                        tempVO.set("mskind"    , pVO.getString(a,"mskind"));
                        tempVO.set("insukind"  , pVO.getString(a,"insukind"));
                        tempVO.set("cretno"    , pVO.getString(a,"cretno"));
                        tempVO.set("instcd"    , pVO.getString(a,"instcd"));

                        //2012-11-01 ����ó���̶� �ϴ��� ������ ����Ư�� ������ �ǽ����� �������� �����Ѵ�.
                        //üũ���� �ּ�ó��
                        //����ó���ϰ�� ���������� �� ���ϱ�
//                        if( StringHelper.strEquals(pVO.getString(a,"etcordflag") , "M") || StringHelper.strEquals(pVO.getString(a,"etcordflag") , "J") ) {
//                                ValueObject otpt_MJ_VO = new ValueObject();
//                                otpt_MJ_VO = this.getChkOtptMJ(tempVO);
//
//                                if(otpt_MJ_VO.size() > 0) {
//                                    tempVO.set("orddd"     , otpt_MJ_VO.getString("orddd"));
//                                    tempVO.set("cretno"     , otpt_MJ_VO.getString("cretno"));
//                                }
//                        }
                        //����ó���ϰ�� ���������� �� ���ϱⳡ

                        esscVO = pamMgt.getEssc(tempVO);
                        srdgVO = pamMgt.getPatSrdgInfo(tempVO).get("srdg");

                        if( esscVO.size() == 0    &&
                            !StringHelper.strEquals(vprcpgenryn ,"1A")  &&
                            StringHelper.strEquals(vdracptyn , "Y")     &&
                            (Integer.parseInt(tempVO.getString("orddd")) <= Integer.parseInt(DateHelper.getDay())) &&
                            (StringHelper.strEquals(vsuppkind , "06") || StringHelper.strEquals(vsuppkind , "11"))
                            
                        ) {
                            msgVO_srdg.set("msg_srdg" , "���� �����Ҽ� ���� ���Դϴ�![0]");
                            msgVO_srdg.set("msg_type" , "E");
                            break;
                        }

                        if( srdgVO.size() == 0 &&
                            ((Integer.parseInt(tempVO.getString("orddd")) <= Integer.parseInt(DateHelper.getDay())) ||
                             (Integer.parseInt(tempVO.getString("orddd")) >  Integer.parseInt(DateHelper.getDay()) && StringHelper.strEquals(vdracptyn,"Y"))) &&	
						    (StringHelper.strEquals(vsuppkind , "06") || StringHelper.strEquals(vsuppkind , "11"))
						  ){
                            msgVO_srdg.set("msg_srdg" , "�ش�ȯ�ڴ� ������ȣ�� �����Ƿ�, [����]���� ������ �� �����ϴ�.[1]");
                            msgVO_srdg.set("msg_type" , "E");
                            break;
                        }

                        for (int b = 0; b < esscVO.size(); b++) {
                            msgVO_srdg = this.fSrdgInfoVeri_check(pVO.getRowAsVo(a) , esscVO.getString(b, "vcode") , srdgVO);
                            if(!StringHelper.strEquals(msgVO_srdg.getString("msg_srdg") , "")) break;
                        }

                    }

             }

             return msgVO_srdg;
    }
    
    //20090701 2.��ͳ�ġ������Ư�� ������� sFlag S ����, K ���μ���
    public ValueObject getChk_Rooa(ValueObject pVO, String sFlag) throws LiveException {

            ValueObject rooaVO1 = new ValueObject();
            ValueObject rooaVO  = new ValueObject();
            ValueObject msgVO_srdg  = new ValueObject();

            String vinsukind        = "";
            String vsuppkind        = "";
            String vsuppkindsubyn   = "";
            String vprcpgenryn      = "";
            String vdracptyn        = "";

             for (int a = 0; a < pVO.size(); a++) {

                vinsukind        = pVO.getString(a,"insukind");
                vsuppkind        = pVO.getString(a,"suppkind"); 
                vsuppkindsubyn   = pVO.getString(a,"suppkindsubyn");  //���������� �ΰ����� �ְ� N, �ΰ� Y(�ְ��϶��� üũ�Ѵ�)
                vprcpgenryn      = pVO.getString(a,"prcpgenryn");
                vdracptyn        = pVO.getString(a,"dracptyn");

                //������ȯ�� Ư��ó�� - �������� �������� �ǰ������� ������������ �ӽ÷� �ٲ㼭 ����üũ�� �Ѵ�.
                if( (Integer.parseInt(vsuppkind) > 32)  && (Integer.parseInt(vsuppkind) < 46)) {
                    vsuppkind = this.getChgScnd(pVO.getRowAsVo(a)).getString("final_suppkind");
                }
                //������ȯ�� Ư��ó�� ��

                //���׺��κδ��ϰ�� ����Ư�ʷ��� ��Ÿ���ؾ���

				//�Ƿ�޿�1,2�� ��ͳ�ġ����Ư���߰� 2010/12/01 ��� cys
                if ((StringHelper.strEquals(vinsukind , "11") || StringHelper.strEquals(vinsukind , "21")) &&
                    !StringHelper.strEquals(vsuppkind , "01") && !StringHelper.strEquals(vsuppkind , "12") &&
                    !StringHelper.strEquals(vsuppkind , "13") && !StringHelper.strEquals(vsuppkind , "32") &&
                     StringHelper.strEquals(vsuppkindsubyn , "N")
                 ) {

                    ValueObject tempVO = new ValueObject();

                    tempVO.set("pid"        , pVO.getString(a,"pid"));
                    tempVO.set("orddd"      , pVO.getString(a,"orddd"));
                    tempVO.set("orddeptcd"  , pVO.getString(a,"orddeptcd"));
                    tempVO.set("mskind"     , pVO.getString(a,"mskind"));
                    tempVO.set("insukind"   , pVO.getString(a,"insukind"));
                    tempVO.set("cretno"     , pVO.getString(a,"cretno"));
                    tempVO.set("instcd"     , pVO.getString(a,"instcd"));

                    //2012-11-01 ����ó���̶� �ϴ��� ������ ����Ư�� ������ �ǽ����� �������� �����Ѵ�.
                    //üũ���� �ּ�ó��
                    //����ó���ϰ�� ���������� �� ���ϱ�
//                    if( StringHelper.strEquals(pVO.getString(a,"etcordflag") , "M") || StringHelper.strEquals(pVO.getString(a,"etcordflag") , "J") ) {
//                            ValueObject otpt_MJ_VO = new ValueObject();
//                            otpt_MJ_VO = this.getChkOtptMJ(tempVO);
//
//                            if(otpt_MJ_VO.size() > 0) {
//                                tempVO.set("orddd"  , otpt_MJ_VO.getString("orddd"));
//                                tempVO.set("cretno" , otpt_MJ_VO.getString("cretno"));
//                            }
//                    }
                    //����ó���ϰ�� ���������� �� ���ϱⳡ

                    rooaVO1 = pamMgt.getRooa(tempVO);	
                    //rooaVO = pamMgt.getPatRooaInfo(tempVO).get("rooa");
                	
                	if (rooaVO1.size() == 0 && 
            			!StringHelper.strEquals(vprcpgenryn ,"1A") &&
                        StringHelper.strEquals(vdracptyn , "Y") &&
                        (Integer.parseInt(tempVO.getString("orddd")) <= Integer.parseInt(DateHelper.getDay())) &&
                		(StringHelper.strEquals(vsuppkind , "50") || StringHelper.strEquals(vsuppkind , "51") ||
						 StringHelper.strEquals(vsuppkind , "46") || StringHelper.strEquals(vsuppkind , "02") ||
						 StringHelper.strEquals(vsuppkind , "03") || StringHelper.strEquals(vsuppkind , "04")))
					{
                		msgVO_srdg.set("msg_rooa" , "��ͳ�ġ������Ư�ʸ� �����Ҽ� ���� ���Դϴ�![1]");
                		msgVO_srdg.set("msg_type" , "E");
    					break;
    					
    				}else if (rooaVO1.size() == 0 && 
                			!StringHelper.strEquals(vprcpgenryn ,"1A") &&
                            StringHelper.strEquals(vdracptyn , "Y") &&
                            (Integer.parseInt(tempVO.getString("orddd")) <= Integer.parseInt(DateHelper.getDay())) &&
                            (StringHelper.strEquals(vsuppkind , "87") || StringHelper.strEquals(vsuppkind , "88") ||
       						 StringHelper.strEquals(vsuppkind , "89"))) 
    				{
                    		msgVO_srdg.set("msg_rooa" , "���� ������ ���� Ʋ�ϸ� �����Ҽ� ���� ���Դϴ�![1]");
                    		msgVO_srdg.set("msg_type" , "E");
        					break;
        					
    				}else if (rooaVO1.size() == 0 && 
                			!StringHelper.strEquals(vprcpgenryn ,"1A") &&
                            StringHelper.strEquals(vdracptyn , "Y") &&
                            (Integer.parseInt(tempVO.getString("orddd")) <= Integer.parseInt(DateHelper.getDay())) &&
                            (StringHelper.strEquals(vsuppkind , "61") || StringHelper.strEquals(vsuppkind , "62") ||
       						 StringHelper.strEquals(vsuppkind , "63") || StringHelper.strEquals(vsuppkind , "64")) ) 
    				{
                    		msgVO_srdg.set("msg_rooa" , "����ȭ���� �����Ҽ� ���� ���Դϴ�![1]");
                    		msgVO_srdg.set("msg_type" , "E");
        					break;
    				}
                	
                	boolean CheckSuppkind = false;
                	StringBuffer sSuppkind = new StringBuffer();
                	String sSpclflag = null;
                	String sRgstkindcd = null;
                	
                	for (int b = 0; b < rooaVO1.size(); b++) {
                		rooaVO.clear();
                		sSpclflag = rooaVO1.getString(b, "spclflag");
                		if( StringHelper.strEquals(sSpclflag, "10") || StringHelper.strEquals(sSpclflag, "14")){
                			//��ͳ�ġ����Ư��
                			sRgstkindcd = "01";
                		}else if( StringHelper.strEquals(sSpclflag, "12")){
                			//����ȭ��
                			sRgstkindcd = "02";
                		}else if( StringHelper.strEquals(sSpclflag, "17")){
                			//���� ������ ���� Ʋ�� ���
                			sRgstkindcd = "03";
                		}else if( StringHelper.strEquals(sSpclflag, "18")){
                			//���� ������ ���� Ʋ�� �Ͼ�
                			sRgstkindcd = "04";
                		}else{
                			//��ͳ�ġ����Ư��
                			sRgstkindcd = "01";
                		}
                		tempVO.set("rgstkindcd", sRgstkindcd);
                		rooaVO = pamMgt.getPatRooaInfo(tempVO).get("rooa");
                		
                    	if (rooaVO.size() == 0 &&
							!StringHelper.strEquals(rooaVO1.getString(b, "srchflag") ,"A") &&
							!StringHelper.strEquals(rooaVO1.getString(b, "srchflag") ,"B") &&
							(StringHelper.strEquals(vsuppkind , "50") || StringHelper.strEquals(vsuppkind , "51") ||
							 StringHelper.strEquals(vsuppkind , "46") || StringHelper.strEquals(vsuppkind , "02") ||
							 StringHelper.strEquals(vsuppkind , "03") || StringHelper.strEquals(vsuppkind , "04"))) 
						{
                    		msgVO_srdg.set("msg_rooa" , "�ش�ȯ�ڴ� ��ͳ�ġ������Ư�ʹ�ȣ�� �����Ƿ�, [��ͳ�ġ������Ư��]�� ������ �� �����ϴ�.[2]");
                    		msgVO_srdg.set("msg_type" , "E");
                            break;
                        
						}else if (rooaVO.size() == 0 &&
    							!StringHelper.strEquals(rooaVO1.getString(b, "srchflag") ,"A") &&
    							!StringHelper.strEquals(rooaVO1.getString(b, "srchflag") ,"B") &&
    							(StringHelper.strEquals(vsuppkind , "61") || StringHelper.strEquals(vsuppkind , "62") ||
    							 StringHelper.strEquals(vsuppkind , "63") || StringHelper.strEquals(vsuppkind , "64"))) 
    					{
                        	msgVO_srdg.set("msg_rooa" , "�ش�ȯ�ڴ� ����ȭ���ȣ�� �����Ƿ�, [����ȭ��]���� ������ �� �����ϴ�.[2]");
                        	msgVO_srdg.set("msg_type" , "E");
                            break;
                        
    					}else if (rooaVO.size() == 0 &&
    							!StringHelper.strEquals(rooaVO1.getString(b, "srchflag") ,"A") &&
    							!StringHelper.strEquals(rooaVO1.getString(b, "srchflag") ,"B") &&
    							(StringHelper.strEquals(vsuppkind , "87") || StringHelper.strEquals(vsuppkind , "88") ||
    							 StringHelper.strEquals(vsuppkind , "89"))) 
    					{
                        	msgVO_srdg.set("msg_rooa" , "�ش�ȯ�ڴ� ���η��������Ʋ�� ��û��ȣ�� �����Ƿ�, [���η��������Ʋ��]�� ������ �� �����ϴ�.[2]");
                        	msgVO_srdg.set("msg_type" , "E");
                            break;
                        }
                    	
                		msgVO_srdg = this.fRooaInfoVeri_check(pVO.getRowAsVo(a) , rooaVO1.getString(b, "vcode"), rooaVO1.getString(b, "suppkind") , rooaVO1.getString(b, "srchflag"), rooaVO);
						
						if ( log.isDebugEnabled() ) {
						 log.debug("**----mgr Impl ��ͳ�ġ������Ư��msg------**  " );
						 log.debug("msg_rooa :" + msgVO_srdg.getString("msg_rooa"));
						 log.debug("popsuppkind :" + msgVO_srdg.getString("msg_suppkind"));
						}

                        if(!StringHelper.strEquals(msgVO_srdg.getString("msg_rooa") , "")) break;
                        
                        //���μ����� ��츸 üũ
                        if ("K".equals(sFlag)) {
                        	if (rooaVO.size() > 0 && rooaVO1.size() > 0) {
	    	                	if ("N".equals(rooaVO.getString("rooa_anohosprgstflag")) && "N".equals(rooaVO.getString("rooa_signyn")) &&
	    	                		"20090701".compareTo(tempVO.getString("orddd")) <= 0 && "20090930".compareTo(tempVO.getString("orddd")) >= 0) {
	    	                		String vgenrddtext       = StringHelper.toSubString(rooaVO.getString("rooa_genrdd"), 4, 6) + "��" + StringHelper.toSubString(rooaVO.getString("rooa_genrdd"), 6, 8) + "��";
	    	                		msgVO_srdg.set("msg_rooa" , vgenrddtext + " ��ͳ�ġ������Ư�� ��û�� �ۼ� ȯ���Դϴ�. Sign������ �����ϴ�.[14]");
	    	                		msgVO_srdg.set("msg_type" , "I");
	    	                	}
	                    	}
                        }
                        
                        //���������� ��ġ�ϴ� ��ͳ�ġ������Ư�� üũ
                        if( StringHelper.strEquals(vsuppkind, rooaVO1.getString(b, "suppkind"))){
                        	
                        	CheckSuppkind = true;                        	
                        }else{
                        	
                        	sSuppkind.append(" " + rooaVO1.getString(b, "suppkind") + " ");
                        }
                    }
                	
                	/*
                	 * if( CheckSuppkind == false		//�������� �����׸� ����
                			&& rooaVO1.size() > 0		//����Ư�ʴ�� ��
                			//����Ư�� �ٸ� ���� ���� �� ����
                			&& ( msgVO_srdg.size() < 1 || StringHelper.strEquals(msgVO_srdg.getString("msg_rooa") , "") ) 
                			//����Ư�� ���� ���������� üũ
                			&& ( StringHelper.strEquals(vsuppkind , "50") || StringHelper.strEquals(vsuppkind , "51") ||
       							   StringHelper.strEquals(vsuppkind , "46") || StringHelper.strEquals(vsuppkind , "02") ||
    							   StringHelper.strEquals(vsuppkind , "03") || StringHelper.strEquals(vsuppkind , "04"))){
                		
//                		msgVO_srdg.set("msg_rooa" , "���� ������������ ����Ư�� ������ �� �����ϴ�."
//                											+ "\n�󺴰� ���������� Ȯ���Ͻ� �� �����ϼ���!"
//                											+ "\n���� ���� ��������["+ sSuppkind.toString() + "]");
//                		msgVO_srdg.set("msg_type" , "E");
                	}
                	*/
                }
             }

             return msgVO_srdg;
    }

	//view�� ��� �����ڵ� üũ[_,= ��������]
	public ValueObject getViewCalcChk(ValueObject pVO) throws LiveException {

		//����ڵ� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//����� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
			pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
		}

		return outrcptmngtDAO.getViewCalcChk(pVO);
	}

	/*
	 * (��Javadoc)
	 * �ǽ������ �ǽ��������̺� �Է�
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#insCashAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int setOutOrdActr(ValueObject pVO) throws LiveException {

        String sInstCd = StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE));
        String sUserId = StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID));
        
		ValueObject tempVO = new ValueObject();

		for (int i = 0; i < pVO.size(); i++) {

			if(StringHelper.strEquals(pVO.getString(i,"actr_actfromdd"), "")) continue;
			
			pVO.set(i,"sessinstcd",sInstCd);
			pVO.set(i,"sessuserid",sUserId);

			tempVO.addRow(pVO.getRow(i));
		}
		return outrcptmngtDAO.setOutOrdActr(tempVO);
	}

	public int delOutOrdActr(ValueObject pVO) throws LiveException {

        String sInstCd = "";
        String sUserId = "";

         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		return outrcptmngtDAO.delOutOrdActr(pVO);
	}

	//�ǽ������������ ó�渮��Ʈ
	public ValueObjectAssembler getPopupActrList(ValueObject pVO) throws LiveException{
		
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

		ValueObject actr  = null;
		ValueObject exop  = null;
		ValueObjectAssembler retVOs = new ValueObjectAssembler();

		actr = outrcptmngtDAO.getPopupActrList(pVO);         //�ǽ������������
		exop = outrcptmngtDAO.getPopupActrExopList(pVO);     //�ǽ������������ ó�渮��Ʈ

		retVOs.set("actr"   , actr);
		retVOs.set("exop"   , exop);
		
		return retVOs;
		
	}
	
	//���μ��� üũ �ǽ������������ ó�渮��Ʈ
	public ValueObject getPopupActrKiosk(ValueObject pVO) throws LiveException{
		
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

        return outrcptmngtDAO.getPopupActrList(pVO);         //�ǽ������������
		
	}
	
	
    // 20090703 Ÿ�� ��������
    public ValueObjectAssembler fUpdtRate_check(ValueObject pVO) throws LiveException {

        ValueObject otptVO = new ValueObject();
        ValueObject rooaVO = new ValueObject();
        ValueObject rooaVO1 = new ValueObject();
        ValueObject rcvVO1 = new ValueObject();
        ValueObject rcvVO2 = new ValueObject();
        ValueObject msgVO_srdg  = new ValueObject();
        ValueObjectAssembler rcvVOs = new ValueObjectAssembler();

        String vinsukind           = "";
        String vsuppkind          = "";
        String vsuppkindsubyn  = "";
        String vdracptyn	= "";
        
        boolean bAppFlag = false;
        boolean bAppFlag1 = false;
        
        int iRow = 0;
        
        otptVO = outrcptmngtDAO.getOrdOTPTRef(pVO); 
        
        if (otptVO.size() > 1) {	//�ΰ� �̻��� ��츸....
            for (int a = 0; a < otptVO.size(); a++) {
            	vinsukind          = StringHelper.null2void(otptVO.getString(a,"insukind"));
                vsuppkind         = StringHelper.null2void(otptVO.getString(a,"suppkind")); 
                vsuppkindsubyn = StringHelper.null2void(otptVO.getString(a,"suppkindsubyn"));  //���������� �ΰ����� �ְ� N, �ΰ� Y(�ְ��϶��� üũ�Ѵ�) ?????
                vdracptyn         = StringHelper.null2void(otptVO.getString(a,"dracptyn"));
                
            	if ((StringHelper.strEquals(vinsukind , "11") || StringHelper.strEquals(vinsukind , "21")) &&
            			!StringHelper.strEquals(vsuppkind , "06") && !StringHelper.strEquals(vsuppkind , "11") &&
                        !StringHelper.strEquals(vsuppkind , "38") && !StringHelper.strEquals(vsuppkind , "40") &&
                        !StringHelper.strEquals(vsuppkind , "01") && !StringHelper.strEquals(vsuppkind , "12") &&
                        !StringHelper.strEquals(vsuppkind , "13") && !StringHelper.strEquals(vsuppkind , "32")) {
            		
            		if (StringHelper.strEquals(vsuppkind , "02") || StringHelper.strEquals(vsuppkind , "03") ||
	                     StringHelper.strEquals(vsuppkind , "04") || StringHelper.strEquals(vsuppkind , "34") ||
	                     StringHelper.strEquals(vsuppkind , "35") || StringHelper.strEquals(vsuppkind , "36")) {
            	
            			if ("Y".equals(vdracptyn) && "N".equals(vsuppkindsubyn)) {	//������
			                //������ȯ�� Ư��ó�� - �������� �������� �ǰ������� ������������ �ӽ÷� �ٲ㼭 ����üũ�� �Ѵ�.
			                if( (Integer.parseInt(vsuppkind) > 32)  && (Integer.parseInt(vsuppkind) < 46)) {
			                    vsuppkind = this.getChgScnd(otptVO.getRowAsVo(a)).getString("final_suppkind");
			                }
			                //������ȯ�� Ư��ó�� ��
			                
			                
			                ValueObject tempVO = new ValueObject();
		
		                    tempVO.set("pid"          , StringHelper.null2void(otptVO.getString(a,"pid")));
		                    tempVO.set("orddd"       , StringHelper.null2void(otptVO.getString(a,"orddd")));
		                    tempVO.set("orddeptcd" , StringHelper.null2void(otptVO.getString(a,"orddeptcd")));
		                    tempVO.set("mskind"     , StringHelper.null2void(otptVO.getString(a,"mskind")));
		                    tempVO.set("insukind"   , StringHelper.null2void(otptVO.getString(a,"insukind")));
		                    tempVO.set("cretno"     , otptVO.getString(a,"cretno"));
		                    tempVO.set("instcd"      , StringHelper.null2void(otptVO.getString(a,"instcd")));
		                    
		                    //2012-11-01 ����ó���̶� �ϴ��� ������ ����Ư�� ������ �ǽ����� �������� �����Ѵ�.
	                        //üũ���� �ּ�ó��
		                    //����ó���ϰ�� ���������� �� ���ϱ�
//		                    if( StringHelper.strEquals(otptVO.getString(a,"etcordflag") , "M") || StringHelper.strEquals(otptVO.getString(a,"etcordflag") , "J") ) {
//		                            ValueObject otpt_MJ_VO = new ValueObject();
//		                            otpt_MJ_VO = this.getChkOtptMJ(tempVO);
//		
//		                            if(otpt_MJ_VO.size() > 0) {
//		                                tempVO.set("orddd"     , otpt_MJ_VO.getString("orddd"));
//		                                tempVO.set("cretno"     , otpt_MJ_VO.getString("cretno"));
//		                            }
//		                    }
		                    
		                    rooaVO1 = pamMgt.getRooa(tempVO);	
		                    //rooaVO = pamMgt.getPatRooaInfo(tempVO).get("rooa");
		                	
		                	if (rooaVO1.size() > 0) {
			                	for (int b = 0; b < rooaVO1.size(); b++) {
			                		
			                		rooaVO.clear();
			                		tempVO.set("spclflag", rooaVO1.getString(b, "spclflag"));
			                		rooaVO = pamMgt.getPatRooaInfo(tempVO).get("rooa");
			                		
			                		msgVO_srdg = this.fRooaInfoVeri_check(otptVO.getRowAsVo(a) , rooaVO1.getString(b, "vcode"), rooaVO1.getString(b, "suppkind") 
			                																			, rooaVO1.getString(b, "srchflag"), rooaVO);
			                		
							        if ( log.isDebugEnabled() ) {
									 log.debug("**----mgr Impl Ÿ�� ��������msg------**  " );
									 log.debug("msg_rooa :" + msgVO_srdg.getString("msg_rooa"));
									 log.debug("popsuppkind :" + msgVO_srdg.getString("msg_suppkind"));
							        }
							        
			                        if (StringHelper.strEquals(msgVO_srdg.getString("msg_rooa") , "")) {
			                        	bAppFlag1 = true;
			                        	rcvVO2.set("pid", StringHelper.null2void(otptVO.getString(a,"pid")));
				                		rcvVO2.set("orddd", StringHelper.null2void(otptVO.getString(a,"orddd")));
				                		rcvVO2.set("insukind", StringHelper.null2void(otptVO.getString(a,"insukind")));
				                		rcvVO2.set("suppkind", StringHelper.null2void(otptVO.getString(a,"suppkind")));
				                		rcvVO2.set("insucd", StringHelper.null2void(otptVO.getString(a,"insucd")));
				                		rcvVO2.set("cretno", otptVO.getString(a,"cretno"));
				                		rcvVO2.set("acptseqno", otptVO.getString(a,"acptseqno"));
				                		rcvVO2.set("orddeptcd", StringHelper.null2void(otptVO.getString(a,"orddeptcd")));
				                		rcvVO2.set("orddrid", StringHelper.null2void(otptVO.getString(a,"orddrid")));
				                		if ("S".equals(StringHelper.null2void(otptVO.getString(a,"calcflag")))) {
				                			rcvVO2.set("calcflaggubn", "�̼���");
				                		} else if ("Y".equals(StringHelper.null2void(otptVO.getString(a,"calcflag")))) {
				                			rcvVO2.set("calcflaggubn", "�̰��");
				                		} else if ("N".equals(StringHelper.null2void(otptVO.getString(a,"calcflag")))) {
				                			rcvVO2.set("calcflaggubn", "��   ��");
				                		}
				                		rcvVO2.set("spclcd", StringHelper.null2void(otptVO.getString(a,"spclcd")));
			                		}
			                    }
		                	}
            			} //if ("Y".equals(vdracptyn)) {
            		} else {
            			if ( log.isDebugEnabled() ) {
							 log.debug("**----mgr Impl Ÿ�� �������� bAppFlag = true; ------**  " );
							 log.debug("**----iRow"  + iRow);
					    }
            			bAppFlag = true;
                		rcvVO1.set(iRow, "chkgubn", "-");
                		rcvVO1.set(iRow, "pid", StringHelper.null2void(otptVO.getString(a,"pid")));
                		rcvVO1.set(iRow, "orddd", StringHelper.null2void(otptVO.getString(a,"orddd")));
                		rcvVO1.set(iRow, "insukind", StringHelper.null2void(otptVO.getString(a,"insukind")));
                		rcvVO1.set(iRow, "suppkind", StringHelper.null2void(otptVO.getString(a,"suppkind")));
                		rcvVO1.set(iRow, "insucd", StringHelper.null2void(otptVO.getString(a,"insucd")));
                		rcvVO1.set(iRow, "cretno", otptVO.getString(a,"cretno"));
                		rcvVO1.set(iRow, "acptseqno", otptVO.getString(a,"acptseqno"));
                		rcvVO1.set(iRow, "orddeptcd", StringHelper.null2void(otptVO.getString(a,"orddeptcd")));
                		rcvVO1.set(iRow, "orddrid", StringHelper.null2void(otptVO.getString(a,"orddrid")));
                		rcvVO1.set(iRow, "tosuppkind", "-");
                		rcvVO1.set(iRow, "tospclcd", "-");
                		iRow++;
            		}
            	}//�������� üũ
            }	//for end
            
            if (bAppFlag1 == true && bAppFlag == true) {
            	if (rcvVO1.size() > 0) {
            		boolean bFlag = false;
            		for (int c = 0; c < rcvVO1.size(); c++) {
	            		if (rcvVO1.getString(c, "suppkind").equals(rcvVO2.getString("suppkind"))) {
	            			rcvVO1.set(c, "chkgubn", "N");
	            			rcvVO1.set(c, "tosuppkind", rcvVO2.getString("suppkind"));
	            			rcvVO1.set(c, "tospclcd", rcvVO2.getString("spclcd"));
	            		} else {
	            			bFlag = true;
	            			rcvVO1.set(c, "chkgubn", "Y");
	            			rcvVO1.set(c, "tosuppkind", rcvVO2.getString("suppkind"));
	            			rcvVO1.set(c, "tospclcd", rcvVO2.getString("spclcd"));
	            		}
	            		if (bFlag == true){
	            			rcvVOs.set("updtratelist", rcvVO1);
	            			rcvVOs.set("dtratelist", rcvVO2);
	            		}
	            		
	            		if (bFlag == false) {
	            			rcvVO1.clear();
	                    	rcvVO2.clear();
	                    	rcvVOs.set("updtratelist", rcvVO1);
	            			rcvVOs.set("dtratelist", rcvVO2);
	            		}
            		}
            	} 
            } else {
            	rcvVO1.clear();
            	rcvVO2.clear();
            	rcvVOs.set("updtratelist", rcvVO1);
    			rcvVOs.set("dtratelist", rcvVO2);
            } //if (bAppFlag1 == true && bAppFlag1 == true) {
            
        } //if (otptVO.size() > 0) {
        
        if (rcvVO2.size() > 0) {
	        if ( log.isDebugEnabled() ) {
			 log.debug("**----mgr Ÿ�� �������� return value------**  " );
			 log.debug("rcvVO1_size :" + rcvVO1.size());
			 log.debug("rcvVO1_chkgubn :" + rcvVO1.getString("chkgubn"));
			 log.debug("rcvVO1_pid :" + rcvVO1.getString("pid"));
			 log.debug("rcvVO1_orddd :" + rcvVO1.getString("orddd"));
			 log.debug("rcvVO1_insukind :" + rcvVO1.getString("insukind"));
			 log.debug("rcvVO1_suppkind :" + rcvVO1.getString("suppkind"));
			 log.debug("rcvVO1_insucd :" + rcvVO1.getString("insucd"));
			 log.debug("rcvVO1_cretno :" + rcvVO1.getString("cretno"));
			 log.debug("rcvVO1_acptseqno :" + rcvVO1.getString("acptseqno"));
			 log.debug("rcvVO1_orddeptcd :" + rcvVO1.getString("orddeptcd"));
			 log.debug("rcvVO1_orddrid :" + rcvVO1.getString("orddrid"));
			 log.debug("rcvVO1_tosuppkind :" + rcvVO1.getString("tosuppkind"));
			 log.debug("rcvVO1_tospclcd :" + rcvVO1.getString("tospclcd"));
			 
			 log.debug("**----mgr Ÿ�� �������� return value------**  " );
			 log.debug("rcvVO2_size :" + rcvVO2.size());
			 log.debug("rcvVO2_pid :" + rcvVO2.getString("pid"));
			 log.debug("rcvVO2_orddd :" + rcvVO2.getString("orddd"));
			 log.debug("rcvVO2_insukind :" + rcvVO2.getString("insukind"));
			 log.debug("rcvVO2_suppkind :" + rcvVO2.getString("suppkind"));
			 log.debug("rcvVO2_insucd :" + rcvVO2.getString("insucd"));
			 log.debug("rcvVO2_cretno :" + rcvVO2.getString("cretno"));
			 log.debug("rcvVO2_acptseqno :" + rcvVO2.getString("acptseqno"));
			 log.debug("rcvVO2_orddeptcd :" + rcvVO2.getString("orddeptcd"));
			 log.debug("rcvVO2_orddrid :" + rcvVO2.getString("orddrid"));
			 log.debug("rcvVO2_calcflaggubn :" + rcvVO2.getString("calcflaggubn"));
			 log.debug("rcvVO2_spclcd :" + rcvVO2.getString("spclcd"));
	        }
        }
   //     if(rcvVO2.size() < 1000 ) {
 	//	   throw new LiveException("�̹� ���õ� ������ �����°� �ٸ� ��쿡�� ������ �����Ҽ������ϴ�.");
 	//	 }
         return rcvVOs;
    }


    /**
     * �ܷ����� 2009/7/17 ������
     * ����μ�ø�������� üũ
     * @author cys
     * @param pVOs ValueObjectAssembler
     * @return ValueObjectAssembler
     * @throws LiveException
     */
    public ValueObject getHndcCnt(ValueObject pVO) throws LiveException{
        
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

        String otptkey = "";

        for (int a = 0; a < pVO.size(); a++) {
            otptkey = pVO.getString(a, "orddd") + "_" + pVO.getString(a, "cretno") + "','" + otptkey;
        }
        
        pVO.set("otptkey" , otptkey);
        
        return outrcptmngtDAO.getHndcCnt(pVO);
        
    }


    //ȯ�ڿ���ó�泻����ȸ cys 20091015
    public ValueObject getExopActList(ValueObject pVO) throws LiveException{
        
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

        return outrcptmngtDAO.getExopActList(pVO);
        
    }
    
    
    /* ����̽� ȯ�� ���� ��ȸ
     * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.OutRcptMgt#getTranInfo(kr.co.hit.live.vo.ValueObject)
     */
    public ValueObject getTranInfo(ValueObject pVO) throws LiveException{
        
        //����ڵ� ��ȸ
       if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
           pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
       }
       
       //����� ��ȸ
       if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
           pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
       }

       return outrcptmngtDAO.getTranInfo(pVO);
       
   }


    //���ó�� ���̽� üũ cys 20091110
    public boolean getCnclCase_Chk(ValueObject pVO) throws LiveException{
        
        boolean bl_rtn = false;

        //���ó�� ���̽�(������üũ����,����,0������)
        //1.����ġ��,�ֻ翹���̸鼭 ������̻����̰� ó�� ���� ���
        //2.��缱�����а��̸鼭 ������̻����̰� ó����°��
        //3.�������� ������ ����Ѱ��
        if ( (StringHelper.strEquals(pVO.getString("etcordflag"),"M") && StringHelper.strEquals(pVO.getString("medamtestmyn"),"N")) ||
             
             (StringHelper.strEquals(pVO.getString("etcordflag"),"J")  && StringHelper.strEquals(pVO.getString("medamtestmyn"),"N")) ||
             
             (StringHelper.strEquals(pVO.getString("etcordflag"),"T")  && StringHelper.strEquals(pVO.getString("medamtestmyn"),"N")  && StringHelper.strEquals(pVO.getString("orddeptcd"),"2170000000")) ||

             (StringHelper.strEquals(pVO.getString("rsrvflag"),"A")     && StringHelper.strEquals(pVO.getString("medamtestmyn"),"N")  && StringHelper.strEquals(pVO.getString("specordyn"),"N"))){

                bl_rtn = true;

             }

        return bl_rtn;
        
    }
    
	//�ܷ� ȯ�ұ� ������ ó��
	public int insRtnBogj(ValueObject pVO) throws LiveException {

		ValueObject bogjVO = new ValueObject ();
		int bogjAmt = 0;

		bogjAmt  =  Integer.parseInt(pVO.getString("cashamt")) * -1;
		 
		//������ ȯ��
		if(bogjAmt > 0){

			bogjVO.set("pid"        ,pVO.getString("pid"));             
			bogjVO.set("rcptdd"		,DateHelper.getDay());       
			bogjVO.set("rcptno"		,this.getRcptNo(pVO).getString("rcptno"));       
			bogjVO.set("rcptseqno"	,1);    
			bogjVO.set("sessinstcd"	,pVO.getString("sessinstcd"));   
			bogjVO.set("rcptstat"	,pVO.getString("rcptstat"));   
			bogjVO.set("ordtype"	,pVO.getString("ordtype"));   
			bogjVO.set("rcptflag"	,pVO.getString("rcptflag"));   
			bogjVO.set("cashamt"	,bogjAmt);      
			bogjVO.set("cardamt"	,0);      
			bogjVO.set("onlineamt"	,0);    
			bogjVO.set("rcptexecdd"	,DateHelper.getDay());   
			bogjVO.set("rcpttm"		,DateHelper.getCurrentTimeAsString());       
			bogjVO.set("rcptrid"	, pVO.getString("sessuserid"));         
			bogjVO.set("remfact"	,pVO.getString("remfact"));   
			bogjVO.set("orddeptcd"	,pVO.getString("orddeptcd"));    
			bogjVO.set("paypsnflag"	,pVO.getString("paypsnflag"));   
			bogjVO.set("paydepoamt"	,bogjAmt);   
			bogjVO.set("paypsnrem"	,pVO.getString("paypsnrem"));   

			this.insMdlAmt(bogjVO);
		}

		return bogjAmt;
	}

    //�౹�� �������̽� ȣ�� 20100202 cys
    public ValueObjectAssembler getCallPharmlib(ValueObject pVO) throws LiveException{
        
		ValueObject pharmInVO = new ValueObject();		
		ValueObjectAssembler pharmInVOs = new ValueObjectAssembler ();
		ValueObjectAssembler pharmOutVOs = new ValueObjectAssembler ();

       /*  �ʿ��Ķ����
           pid,
           orddd(actingorddd ���� �ƴ�),
           cretno,
           orddeptcd,
           orddrid,
           instcd,
           ioflag(�Կ�/�ܷ�����(I/O), ���⼭�� "O"�� �־���)
           prcpgenrflag(ã�� ����� "O"�� �־���)
        */

        pharmInVO.set("pid"         , pVO.getString("pid"));
        pharmInVO.set("orddd"       , pVO.getString("orddd"));
        pharmInVO.set("cretno"      , pVO.getString("cretno"));
        pharmInVO.set("orddeptcd"   , pVO.getString("orddeptcd"));
        pharmInVO.set("orddrid"     , pVO.getString("orddrid"));
        pharmInVO.set("instcd"      , pVO.getString("instcd"));
        pharmInVO.set("ioflag"      , "O");
        pharmInVO.set("prcpgenrflag", "O");

        pharmInVOs.set("req", pharmInVO);
        pharmOutVOs = pharmlib.exeOutSum(pharmInVOs);

        return pharmOutVOs;
        
    }
    
    
    /*
     * �����Ƿڳ��� ��ȸ
     * �������� �̵��� �߰� �����Ƿڼ� ��ȸ������ ������.
     * @param pVO ValueObject
	 * @return ValueObject
	 * @throws LiveException
	 */
    public ValueObject getCnst(ValueObject pVO) throws LiveException {        

        ValueObject resultCNST = new ValueObject();
        try {
        	resultCNST = outrcptmngtDAO.getCNST1(pVO);
        } catch (LiveException le) {
            throw le;
        } catch (Exception e) {
            throw new LiveException("com.error.90000", e);
        }        

        return resultCNST;
    }    

	//������������ ����ó���� ��±��
	public ValueObject getHosoOutOrderList(ValueObject pVO) throws LiveException {
		
         //����ڵ� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //����� ��ȸ
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getHosoOutOrderList(pVO);
	}
    
	/*
	 * (��Javadoc)
	 * Ÿ���� ���� ó��
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.OutRcptMgt#setSuppkindsubyn(kr.co.hit.live.vo.ValueObject)
	 */
	public int setSuppkindsubyn(ValueObject pVO) throws LiveException {

		int iCount = 0;
		
		//����ڵ� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//����� ��ȸ
		if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
			pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
		}

		iCount = outrcptmngtDAO.setSuppkindsubyn(pVO);
		
		return iCount;
	}
    
    //ó��Ư������ N���� ���� 20110401 cys
	public int setChngSpecN(ValueObject pVO) throws LiveException {

		int iCount = 0;

        String sInstCd = StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE));
        String sUserId = StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID));
		
        for (int a = 0; a < pVO.size(); a++) {

            pVO.set(a,"sessinstcd" , sInstCd);
			pVO.set(a,"sessuserid" , sUserId);

        }

		iCount = outrcptmngtDAO.setChngSpecN(pVO);
		
		return iCount;
	}

    //ó��Ư������ ���� 20110401 cys
	public int setChngSpecR(ValueObject pVO) throws LiveException {

		int iCount = 0;

        String sInstCd = StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE));
        String sUserId = StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID));
		
        for (int a = 0; a < pVO.size(); a++) {

            pVO.set(a,"sessinstcd" , sInstCd);
			pVO.set(a,"sessuserid" , sUserId);

        }

		iCount = outrcptmngtDAO.setChngSpecR(pVO);


        //�������ᰨ�� ��û�� ����Ʈ ����(ó��)
        outrcptmngtDAO.setDelSpltList1(pVO);
		
		return iCount;
	}
	
    public ValueObject getUncoAmtSMSDetlSpec(ValueObject pVO) throws LiveException {

        return outrcptmngtDAO.getUncoAmtSMSDetlSpec(pVO);
    }
    
    public ValueObject getUncoAmtSMSMsg(ValueObject pVO) throws LiveException {

        return outrcptmngtDAO.getUncoAmtSMSMsg(pVO);
    }
    
    public ValueObject getUncoAmtSMSSpec(ValueObject pVO) throws LiveException {

        return outrcptmngtDAO.getUncoAmtSMSSpec(pVO);
    }
    
    public ValueObject getUncoAmtSMSTrsmSpec(ValueObject pVO) throws LiveException {

        return outrcptmngtDAO.getUncoAmtSMSTrsmSpec(pVO);
    }
    
    public int setUncoAmtSMSTrsm(ValueObject pVO) throws LiveException {

        return outrcptmngtDAO.setUncoAmtSMSTrsm(pVO);
    }
    
    public ValueObject getDiscListChk(ValueObject pVO) throws LiveException{
    	return outrcptmngtDAO.getDiscListChk(pVO);
    }
    
    public ValueObject getCheckWorkUpDiag(ValueObject pVO) throws LiveException {
    
        return outrcptmngtDAO.getCheckWorkUpDiag(pVO);
    }
}
