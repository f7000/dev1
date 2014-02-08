/**
 * @(#) OutRcptMgtImpl.java
 *수정이력
 * 		- 2007. 4. 02 / 최초작성 / 최희경
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
 *  <P> 외래수납  Business Interface의 구현 Class</P>
 *  본 클래스는 외래수납을  관리하는 OutRcptMgt Interface의 구현클래스이다. 
 *  
 *  @author  최희경
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
	 * 사용할 DAO 인터페이스인 OutRcptDAO 객체를 설정하는 Setter Method 이다.
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
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getMdlAmtList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getMdlAmtList(ValueObject pVO) throws LiveException {
		
		//기관코드 조회
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//사용자 조회
		if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
			pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
		}
		
		return outrcptmngtDAO.getMdlAmtList(pVO);
	}
		
	
	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getCardAmtList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getCardAmtList(ValueObject pVO) throws LiveException {
		
		//기관코드 조회
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//사용자 조회
		if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
			pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
		}
		
		return outrcptmngtDAO.getCardAmtList(pVO);
	}

	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getCashAmtList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getCashAmtList(ValueObject pVO) throws LiveException {
		
		//기관코드 조회
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//사용자 조회
		if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
			pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
		}
		
		return outrcptmngtDAO.getCashAmtList(pVO);
	}
	
	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getOnlineAmtList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOnlineAmtList(ValueObject pVO) throws LiveException {
		
		//기관코드 조회
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//사용자 조회
		if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
			pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
		}
		
		return outrcptmngtDAO.getOnlineAmtList(pVO);
	}

	
	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getRcptNo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getRcptNo(ValueObject pVO) throws LiveException {
		
		//기관코드 조회
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//사용자 조회
		if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
			pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
		}
		
		return outrcptmngtDAO.getRcptNo(pVO);
	}
	
	
	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#insMdlAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insMdlAmt(ValueObject pVO) throws LiveException {
		
		//기관코드 조회
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//사용자 조회
		if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
			pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
		}
		
		//수납자 세팅
		pVO.set("rcptrid",pVO.getString("sessuserid"));
		
		return outrcptmngtDAO.insMdlAmt(pVO);
	}
	
	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#setRcptNo(kr.co.hit.live.vo.ValueObject)
	 */
	public int setRcptNo(ValueObject pVO) throws LiveException {

		//기관코드 조회
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//사용자 조회
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
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#setOutOrdAmtOscl(kr.co.hit.live.vo.ValueObject)
	 */
	public int setOutOrdAmtOsclOtpt(ValueObject pVO) throws LiveException {

		//기관코드 조회
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//사용자 조회
		if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
			pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
		}
		
		//등록내역에 적용할 값 세팅  
		ValueObject tOtpt = new ValueObject ();
		ValueObject tOtptVO = new ValueObject ();		
		ValueObject HoldListVO = new ValueObject();
		
		int iCount = 0;
		
		//계산내역에 수납정보 update
		iCount = outrcptmngtDAO.setOutOrdAmtOscl(pVO);
		
		//수납시 계산내역 Y 건이 0건이면 오류 발생한다.
		//
		if( iCount < 1 ){
		//	throw new LiveException("수납 중 계산내역 생성 오류 입니다. 재계산 후 다시 수납하세요.[OSCL CALCSTAT R->Y 업데이트 오류]");
		}
		
		tOtpt.set("otpt_pid"      ,pVO.getString("opmi_pid"));
		tOtpt.set("otpt_orddd"    ,pVO.getString("opmi_orddd"));
		tOtpt.set("otpt_cretno"   ,pVO.getString("opmi_cretno"));
		tOtpt.set("otpt_acptseqno",pVO.getString("opmi_acptseqno"));
		tOtpt.set("otpt_instcd"   ,pVO.getString("opmi_instcd"));

		tOtpt.set("sessinstcd"    ,pVO.getString("sessinstcd"));
		tOtpt.set("sessuserid"    ,pVO.getString("sessuserid"));
		tOtpt.set("otpt_histstat" ,pVO.getString("otpt_histstat"));  //R:접수  X:취소(물리치료,주사예약이면서 진찰료미산정이면 접수취소처리) 

		if (StringHelper.strEquals(pVO.getString("otpt_histstat"), "X")) {  //취소일때는 opmi생성안하므로 기존영수증번호 넣음
			tOtpt.set("otpt_rcptdd"   ,pVO.getString("opmi_rcptdd_org"));
			tOtpt.set("otpt_rcptno"   ,pVO.getString("opmi_rcptno_org"));
			tOtpt.set("otpt_rcptseqno",pVO.getString("opmi_rcptseqno_org"));		
		}else{
			tOtpt.set("otpt_rcptdd"   ,pVO.getString("opmi_rcptdd"));
			tOtpt.set("otpt_rcptno"   ,pVO.getString("opmi_rcptno"));
			tOtpt.set("otpt_rcptseqno",pVO.getString("opmi_rcptseqno"));
		}

		//수납처리시 Hold된 처방이 있으면  erchospath 칼럼에 hold 처리를 위함.		
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

		tOtpt.set("otpt_calcflag","N");								//Y:미계산, S:미수납, N:수납

		//외래등록내역에 수납정보 update
		return outrcptmngtDAO.setOutOrdAmtOtpt(tOtpt);
		
	}

	
	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#setOrdStat(kr.co.hit.live.vo.ValueObject)
	 */	
	public int setOutOrdStat(ValueObject pVO) throws LiveException {

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
    		
		//처방정보에 에 적용할 값 세팅  
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
		tOprcVO.set("prcpstatcd","230");			//처방진행상태코드(M0011)-230(외래수납)

		tOprcVO.set("etcordflag" ,pVO.getString("opmi_etcordflag"));
		
		tOprcVO.set("orddd"     ,pVO.getString("opmi_orddd"));

		//처방 테이블 2개 (외래처방테이블,실시처방테이블  MMOHOPRC, MMODEXOP)
		//외래등록내역에 수납정보 update 
		return outrcptmngtDAO.setOutOrdStat(tOprcVO);
		
	}

	
	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getOutRgstList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOutRgstList(ValueObject pVO) 	throws LiveException{

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

		return outrcptmngtDAO.getOutRgstList(pVO);
		
	}
	
	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getOutRgstList2(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOutRsgtList2(ValueObject pVO) 	throws LiveException{

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
		return outrcptmngtDAO.getOutRgstList2(pVO);
		
	}
	
	
	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getOtptList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOtptList(ValueObject pVO) 	throws LiveException{

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
		return outrcptmngtDAO.getOtptList(pVO);
		
	}
	
	
	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getUncoAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getUncoAmt(ValueObject pVO) throws LiveException{

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
		//return outrcptmngtDAO.getUncoAmt(pVO);

		pVO.set("ptbs_pid", pVO.getString("pid"));

		return etcOutRgst.getPatUnco(pVO);
		
	}

	
	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getKeepAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getKeepAmt(ValueObject pVO) throws LiveException{

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
		//return outrcptmngtDAO.getKeepAmt(pVO);

		return etcOutRgst.getPatKpam(pVO);
		
	}


	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getInsuInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getInsuInfo(ValueObject pVO) throws LiveException{

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
		return outrcptmngtDAO.getInsuInfo(pVO);
		
	}
	
	/*
	 * (비Javadoc)
	 * 중증정보 조회
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getSrdgInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getSrdgInfo(ValueObject pVO) throws LiveException{

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
		return outrcptmngtDAO.getSrdgInfo(pVO);

	}
	
	
	/*
	 * (비Javadoc)
	 * 자보보험정보 조회
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getAipmInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getAipmInfo(ValueObject pVO) throws LiveException{

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
		return outrcptmngtDAO.getAipmInfo(pVO);
		
	}

	/*
	 * (비Javadoc)
	 * 산재보험정보 조회
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getIcpmInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getIcpmInfo(ValueObject pVO) throws LiveException{

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
		return outrcptmngtDAO.getIcpmInfo(pVO);
		
	}
	
	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getOsclInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOsclInfo(ValueObject pVO) throws LiveException{

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        		
		return outrcptmngtDAO.getOsclInfo(pVO);
		
	}

	/*
	 * (비Javadoc)
	 * 원외처방존재여부 조회
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getOutOrdExist(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOutOrdExist(ValueObject pVO) throws LiveException{

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
		return outrcptmngtDAO.getOutOrdExist(pVO);
		
	}

	/*
	 * (비Javadoc)
	 * 장애인환자 여부 조회
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getHandicapYN(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getHandicapYN(ValueObject pVO) throws LiveException{

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
		return outrcptmngtDAO.getHandicapYN(pVO);
		
	}

	/*
	 * (비Javadoc)
	 * 연속처방 외래등록 또는 일반 외래등록의 원 ORDDD  조회 - 약국집계용
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getOrddd(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOrddd(ValueObject pVO) throws LiveException{

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
		return outrcptmngtDAO.getOrddd(pVO);
		
	}

		
	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getInsuRateInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getInsuRateInfo(ValueObject pVO) throws LiveException{

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
		//계산내역에 대한 진료비정보 조회		
		return outrcptmngtDAO.getInsuRateInfo(pVO);
	}
	
	
	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getOpmiInfoFromOscl(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOpmiInfoFromOscl(ValueObject pVO) throws LiveException{

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

		//계산내역에 대한 진료비정보 조회		
		return outrcptmngtDAO.getOpmiInfoFromOscl(pVO);
		
	}

	
	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getOpmiInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOpmiInfo(ValueObjectAssembler pVOs , String caller)  throws LiveException{

		//caller : 호출시점[접수선택,계산,0원수납]

		ValueObject otptVO = pVOs.get("otpt");
		ValueObject ptinVO = pVOs.get("ptin");
		ValueObject retopmiVO = new ValueObject();

        String sInstCd = "";
        String sUserId = "";

         //기관코드 조회
        if (StringHelper.strEquals(otptVO.getString("sessinstcd"), "")) {
            otptVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(otptVO.getString("sessuserid"), "")) {
            otptVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
            
        }

        sInstCd = otptVO.getString("sessinstcd");
        sUserId = otptVO.getString("sessuserid");		
		
		for (int i=0; i< otptVO.size() ; i++) {		
			//기관코드 세팅		
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
		//계산시에도 계산내역에 대한 진료비정보 조회가 필요하므로, 
		//로직은 app => mgr 로 이동
		
		//수납내역 view를 위한 진료비정보 조회 시, input VO Assembler 
		ValueObjectAssembler inpVOs = new ValueObjectAssembler();

		try {			
			
			//1. 보험정보 조회-외래정보에 있는 보험정보가 아닌, 새로입력된 보험정보로 적용
			insurateVO = getInsuRateInfo(ptinVO);			
			insurateVO.set("insu_insucd",ptinVO.getString("insucd"));
						
			
			//2. 전체 진료비 내역 
			//계산내역에 대한 진료비 정보 조회-계산내역전체에 대한 급여/비급여/선택진료비/CT/MRI/
			tempopmiVO = getOpmiInfoFromOscl(otptVO);
			
			//2-1.원외내역 존재여부 체크
			outordVO = getOutOrdExist(otptVO);
			
			if (outordVO.size() >0) {
				tempopmiVO.set("opmi_outordyn","Y");
			}
			else {
				tempopmiVO.set("opmi_outordyn","N");
			}
			
			tempopmiVO.set("opmi_handicapryn", otptVO.getString("handicaprbookpossnyn"));
			
			//2-3.보험정보 세팅
			tempopmiVO.set("opmi_insukind", ptinVO.getString("insukind"));
			tempopmiVO.set("opmi_suppkind", ptinVO.getString("suppkind"));
			
			//3. 수납내역 view를 위한 진료비정보 조회
			//보험유형 적용한 부담률 적용
			inpVOs.set("tempotpt",otptVO);					//외래등록정보
			inpVOs.set("insurate",insurateVO);				//보험유형별 부담률 정보
			inpVOs.set("tempopmi",tempopmiVO);				//계산내역에 대한 진료비정보
			
			opmiVO = getOpmiAmtInfo(inpVOs,caller);
			
			//2011-11-14 실시정산 희귀, 결핵 대불 계산			
//			if( StringHelper.strEquals("2", otptVO.getString("calcbaseflag"))){		//실시정산 체크
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
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getOpmiAmtInfo(kr.co.hit.live.vo.ValueObject)
	 */
    public ValueObject getOpmiAmtInfo(ValueObjectAssembler pVOs , String caller)  throws LiveException{
		//caller : 호출시점[접수선택,계산,0원수납]

        ValueObject potptVO   = pVOs.get("tempotpt");       //외래등록정보
        ValueObject pinsuVO   = pVOs.get("insurate");       //보험유형별 부담률정보  <- 쓰지말것! otpt에 필요한 정보 다있음 otpt것 쓸것! 조영상 090715
        ValueObject popmiVO   = pVOs.get("tempopmi");       //계산내역에 대한 진료비정보
        ValueObject retopmiVO = new ValueObject();

        String sInstCd = "";
        String sUserId = "";

         //기관코드 조회
        if (StringHelper.strEquals(potptVO.getString("sessinstcd"), "")) {
            potptVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(potptVO.getString("sessuserid"), "")) {
            potptVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

        sInstCd = potptVO.getString("sessinstcd");
        sUserId = potptVO.getString("sessuserid");  

        String SRcptdd    = potptVO.getString("rcptdd");    
        String SRcptno    = potptVO.getString("rcptno");      
        String SRcptSeqno = potptVO.getString("rcptseqno"); 
		String P0032_130  = "N";
        long   P0032_280  = 4000000;  //외래 상한제초과액
        
        //수납변수
        long lMedTotAmt =0;                 //진찰료                    
        long lMedOwnAmt = 0;                //진찰료본인                
        long lCtMriPetTotAmt =0;            //급여 CT/MRI/PET료         
        long lCtMriPetOwnAmt = 0;           //급여 CT/MRI/PET료 본인    
        long lSonoTotAmt =0;                //SONO료                    
        long lSonoOwnAmt =0;                //SONO료본인                
        long lDrugTotAmt    =0;             //급여약가총액료            
        long lDrugOwnAmt =0;                //급여약가총액료본인        
        long lTotAmt =0;                    //총진료비                  
        long lPayAmt =0;                    //급여                      
        long lNopyAmt =0;                   //비급여                    
        long lAllOwnBAmt =0;                //전액본인부담액(비보험액)      
        long lSpecAmt =0;                   //선택진료비                
        long lPayOwnBAmt =0;                //급여중 본인부담금액       
        long lPayInsuBAmt =0;               //급여중 보험자부담금액      
        long lNopyOwnBAmt =0;               //비급여중 본인부담액
        long lNopyInsuBAmt =0;              //비급여중 보험자부담액
        long lAllOwnOwnBAmt =0;             //전액본인 본인부담액
        long lAllOwnInsuBAmt =0;            //전액본인 보험자부담액
        long lSpecOwnBAmt =0;               //선택진료 본인부담액
        long lSpecInsuBAmt =0;              //선택진료 보험자부담액
        
        long lTotNopyOwnBAmt =0;            //비급여+전액본인 중 본인부담액
        long lTotNopyInsuBAmt =0;           //비급여+전액본인 중 보험자부담액
        //-------------------------------------------------
        long lTotOwnBAmt =0;                //총본인부담액             
        long lTotOwnBAmt2 =0;               //총본인부담액2 (잔전처리) 
        long lHandcapFund =0;               //장애인기금               
        long lSubtAmt =0;                   //대불액                   
        long lErSubtAmt =0;                 //응급대불액               
        long lProcSubtAmt =0;               //보호대불액               
        long lBlodDiscAmt =0;               //수혈대체액               
        long lReduAmt =0;                   //감액                     
        long lUncoAmt =0;                   //미수액                   
        long lPreCashAmt =0;                //기현금액                 
        long lPreMdlRcptAmt =0;             //기선수금                 
        long lPreCardAmt =0;                //기카드금액               
        long lPreOnlineAmt =0;              //기온라인금액             
        long lMdlRcptAmt =0;                //선수금                   
        long lRcptExptAmt =0;               //납부할 금액              
        long lRestAmt =0;                   //절사액                   
        long lCardAmt =0;                   //카드금액                 
        long lCashAmt =0;                   //현금금액                 
        long lOnlineAmt =0;                 //통장입금액               
        long lLabAmt =0;                    //임상연구금액             
        
        long lDiscAmt =0;                   //할인금액
        long lPayDiscAmt    =0;             //급여할인금액       
        long lNopyDiscAmt  =0;              //비급여할인금액     
        long lSpecDiscAmt  =0;              //선택진료할인금액  
                                                                       
        long lHeallifeamtclamAmt = 0;       //건강생활유지비청구액 
        long lPrepregdmndAmt = 0;           //기산전지원금차감액
        long lPregdmndAmt = 0;              //산전지원금차감액
        long lSuppamt = 0;                  //희귀난치환자지원금 
        
        //20090701 1.단수처리 고시적용
        long lPayInsuRestAmt = 0;           //100원미만 보험청구금액
        long lPayInsuRestAmt1 = 0;          //계산변수
        long lPayInsuRestAmt2 = 0;          //계산변수
        long lPayOwnBAmt100 =0;             //절사 처리한 본인부담액
        long lPayInsuBAmt100 =0;            //절사 처리한 보험자부담액
        long lTotOwnBAmt100 =0;             //절사 처리한 본인부담총액
        
        //20110624 미용성형 부가세 고시적용(7월)
        long iTaxAmt = 0;										//부가세
        
        boolean bDiscChk = false;
        
        //기수납내역 조회 : 정산일 경우, 기수납내역 조회, 건별 수납일 경우 조회안함
        ValueObject preOPMIVO = new ValueObject();
        
        //정산일 경우, 기수납내역 조회
        preOPMIVO = outrcptmngtDAO.getPreOpmiInfo(potptVO);
        
            if (preOPMIVO.size()>0) {
                lBlodDiscAmt         = Long.parseLong(preOPMIVO.getString("opmi_bloddiscamt"));           //수혈대체액
                lReduAmt             = Long.parseLong(preOPMIVO.getString("opmi_reduamt"));               //감액
                lUncoAmt             = Long.parseLong(preOPMIVO.getString("opmi_uncoamt"));               //미수액
                lPreCashAmt          = Long.parseLong(preOPMIVO.getString("opmi_precashamt"));            //기현금액(기현금액+현금수납액)
                lPreCardAmt          = Long.parseLong(preOPMIVO.getString("opmi_precardamt"));            //기카드금액(기카드액+카드수납액)
                lPreOnlineAmt        = Long.parseLong(preOPMIVO.getString("opmi_preonlineamt"));          //기온라인금액(기온라인금액+온라인금액)
                lPreMdlRcptAmt       = Long.parseLong(preOPMIVO.getString("opmi_premdlrcptamt"));         //기선수금(기선수금+선수금)
                lHeallifeamtclamAmt  = Long.parseLong(preOPMIVO.getString("opmi_heallifeamtclamamt"));    //기선수금(건강생활유지비청구액)
                lPrepregdmndAmt      = Long.parseLong(preOPMIVO.getString("opmi_prepregdmndamt"));        //기선수금(기산전지원금차감액)
                //lPregdmndAmt       = Long.parseLong(preOPMIVO.getString("opmi_pregdmndamt"));           //기선수금(산전지원금차감액)
            }
		
		//건강생활유지비청구액은 mmsg4에서 차감한걸로 가져온다.
		lHeallifeamtclamAmt = outrcptmngtDAO.getPreLifeAmt(potptVO).getInt("heallifeamtclamamt",0);
        
        //계산내역 구한 급여총액,비급여총액,전액본인부담액,선택진료총액 등을 변수에 세팅
        if (popmiVO.size()>0) {
            
            lDiscAmt        =  Long.parseLong(popmiVO.getString("opmi_discamt"));   
            lPayDiscAmt     =  Long.parseLong(popmiVO.getString("opmi_paydiscamt"));    
            lNopyDiscAmt    =  Long.parseLong(popmiVO.getString("opmi_nopydiscamt"));   
            lSpecDiscAmt    =  Long.parseLong(popmiVO.getString("opmi_specdiscamt"));   

            lPayAmt         =  Long.parseLong(popmiVO.getString("opmi_payamt"));          //급여액                
            lPayOwnBAmt     =  Long.parseLong(popmiVO.getString("opmi_payownbamt"));      //급여본인부담액        
            lPayInsuBAmt    =  Long.parseLong(popmiVO.getString("opmi_payinsubamt"));     //급여보험자부담액      
                                                                                                                      
            lNopyAmt        =  Long.parseLong(popmiVO.getString("opmi_nopyamt"));         //비급여액              
            lNopyOwnBAmt    =  Long.parseLong(popmiVO.getString("opmi_nopyownbamt"));     //비급여본인부담액      
            lNopyInsuBAmt   =  Long.parseLong(popmiVO.getString("opmi_nopyinsubamt"));    //비급여보험자부담액    
                                                                                                                      
            lAllOwnBAmt     =  Long.parseLong(popmiVO.getString("opmi_allownbamt"));      //전액본인부담액        
            lAllOwnOwnBAmt  =  Long.parseLong(popmiVO.getString("opmi_allownownbamt"));   //전액본인본인부담액    
            lAllOwnInsuBAmt =  Long.parseLong(popmiVO.getString("opmi_allowninsubamt"));  //전액본인보험자부담액  
                                                                                                                      
            lSpecAmt        =  Long.parseLong(popmiVO.getString("opmi_specamt"));         //선택진료비            
            lSpecOwnBAmt    =  Long.parseLong(popmiVO.getString("opmi_specownbamt"));     //선택진료비본인부담액  
            lSpecInsuBAmt   =  Long.parseLong(popmiVO.getString("opmi_specinsubamt"));    //선택진료비보험자부담액
            
            lTotNopyOwnBAmt   =  lNopyOwnBAmt  + lAllOwnOwnBAmt;                          //비급여+전액본인 중 본인부담액
            lTotNopyInsuBAmt  =  lNopyInsuBAmt + lAllOwnInsuBAmt;                         //비급여+전액본인 중 보험자부담액
            
			
            //환불 대상인건중 환불금은 미수,감면은 제외하고 본다 20091111 cys        
            if( StringHelper.strEquals(caller,"0원수납") || !StringHelper.strEquals(potptVO.getString("calcflag"),"N")) {

                //취소처리 케이스(refundyn이 Y인 케이스)
                if (this.getCnclCase_Chk(potptVO)) {
                        if(outrcptmngtDAO.getExopActList(potptVO).size() == 0) {
                            lReduAmt = 0;
                            lUncoAmt = 0;
                        }
                }
            }           

            //20090701급여할인과 급여본인이 같을 경우 100미만 단처리 하지 않음.
            if (lPayDiscAmt == lPayOwnBAmt) {
            	bDiscChk = true;
            }


           //본인부담상한제 20110407 cys
           //건강보험만 적용
           if (StringHelper.strEquals(popmiVO.getString("opmi_insukind"),"11")) { 
                
                //전액본인부담은 제외
                if (StringHelper.strEquals(popmiVO.getString("opmi_suppkind"),"01")) {               
                    //////
                //차상위이면서 장애인은 제외
                }else if(Integer.parseInt(popmiVO.getString("opmi_suppkind")) > 32 &&  
                         Integer.parseInt(popmiVO.getString("opmi_suppkind")) < 47 &&
                         StringHelper.strEquals(popmiVO.getString("opmi_handicapryn"),"Y"))
                {
                    /////
                }else{
           
                    P0032_280 = this.getPmcmCodeNm("P0032","280",sInstCd).getLong("cdnm",4000000);
                    
                    //400만원 넘는사람만 상한제 적용
                    if(lPayOwnBAmt > P0032_280){

                        lErSubtAmt   = lPayOwnBAmt  - P0032_280;
                        lPayInsuBAmt = lPayInsuBAmt + lErSubtAmt;
                        lPayOwnBAmt  = P0032_280;

                    }
                }
           }

            
           //20090701 1.단수처리 고시적용
           //2011-08-10 수탁검사의 경우 100미만 절사 하지 않는다.
           if  (bDiscChk == false && "20090701".compareTo(potptVO.getString("orddd")) <= 0 && "11".equals(popmiVO.getString("opmi_insukind")) 
            		&& !"01".equals(popmiVO.getString("opmi_suppkind")) && !"12".equals(popmiVO.getString("opmi_suppkind")) && !"13".equals(popmiVO.getString("opmi_suppkind"))) {
               
            	lPayInsuRestAmt1 =  Long.parseLong(NumericHelper.divide(String.valueOf(lPayOwnBAmt),String.valueOf("100"),  NumericHelper.ROUND_DOWN)) *100 ;
                lPayInsuRestAmt = lPayOwnBAmt - lPayInsuRestAmt1;
                
                lPayOwnBAmt100 = lPayOwnBAmt - lPayInsuRestAmt;
                lPayInsuBAmt100 = lPayInsuBAmt + lPayInsuRestAmt;
                
                if( log.isDebugEnabled() ){
                    
                    log.debug("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    log.debug("외래본인부담금 단수처리");
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
            //20090701 1.단수처리 고시적용------------------------
            
        }  

        //---계산에서 할 것인지 수납시 처리할 것인지 미결정------------------------------------------
        //자보한도액 체크 : 자보보험 && 본인부담100% 아닌 경우, 지불보증한도액,발생금액누계,보험구분 조회
        //산재체크
        //공상체크
        //--------------------------------------------------------------------------------------
                
		/////////////////////////////////////장애인기금/////////////////////////////////////////
        if(log.isDebugEnabled()){
        	log.debug("**----장애인정보 ------**  ");
        	log.debug("**----insukind => ------**  "         + popmiVO.getString("opmi_insukind"));
        	log.debug("**----opmi_handicapryn => ------**  " + popmiVO.getString("opmi_handicapryn")); 
        }
        //장애인기금 조건(의료급여2종+장애인환자)
        //보험유형 :의료급여2종, 
        //보조유형 :장애인,  장애인환자 내역 체크할 것인지 추후 판단 => 환자마스터의 장애인환자여부 로 체크
        //장애인이면, 급여본인부담은 모두 장애기금으로 처리
        
        //2011-11-14
        //실시정산일 때 희귀, 결핵 대불금 재계산
        //실시정산 구분 중 희귀구분 추가.
        if(StringHelper.strEquals(popmiVO.getString("opmi_handicapryn"),"Y")){
			//의료급여 2종일때
			if ( StringHelper.strEquals(popmiVO.getString("opmi_insukind"),"22")) { 
				lHandcapFund = lHandcapFund + lPayOwnBAmt;
				lDiscAmt = lNopyDiscAmt + lSpecDiscAmt;
			}
			//차상위 2종일때 끝
			if ( StringHelper.strEquals(popmiVO.getString("opmi_insukind"),"11") && Integer.parseInt(popmiVO.getString("opmi_suppkind")) > 32 &&  Integer.parseInt(popmiVO.getString("opmi_suppkind")) < 47) {
				//20090701 1.단수처리 고시적용
				lHandcapFund = lHandcapFund + lPayOwnBAmt100;
				lDiscAmt = lNopyDiscAmt + lSpecDiscAmt;
			}
        }
        //2013-05-23
        if(StringHelper.strEquals("2", potptVO.getString("calcbaseflag"))){ 		//실시정산 체크
    		ValueObject hcVO = new ValueObject();
    		hcVO = outrcptmngtDAO.getExeHandcapFund(potptVO); 						//장애기금  조회
        	
        	long ltempHandcapFund = 0;
        	lHandcapFund = 0;
        	if(hcVO.size() > 0){
        		for(int i=0; i< hcVO.size(); i++){
        			//의료급여 2종일때
        			if(StringHelper.strEquals(hcVO.getString(i, "insukind"), "22")){ 
        				ltempHandcapFund = ltempHandcapFund + hcVO.getLong(i, "handcapfund", 0);
        			}
        			//차상위 2종일때 끝
        			if(StringHelper.strEquals(hcVO.getString(i, "insukind"), "11") && Integer.parseInt(hcVO.getString(i, "suppkind")) > 32 &&  Integer.parseInt(hcVO.getString(i, "suppkind")) < 47){
        				ltempHandcapFund = ltempHandcapFund + hcVO.getLong(i, "handcapfund", 0);
        			}
        		}
        		lHandcapFund = ltempHandcapFund;
        		lDiscAmt = lNopyDiscAmt + lSpecDiscAmt;
        	}
        }
        if(log.isDebugEnabled()){
            log.debug("**----장애기금 처리 후 ------**  " 	+ String.valueOf(lHandcapFund));
            log.debug("**----장애기금 ------**  " 		+ String.valueOf(lHandcapFund));
            log.debug("**----급여본인부담금 ------**  " 	+ String.valueOf(lPayOwnBAmt));
        }
        /////////////////////////////////////장애인기금 끝/////////////////////////////////////////

        //응급대불, 공상 
        //보험유형:공상 또는 보조유형:응급대불인 경우 체크
        //급여 보험자부담금 = 급여 보험자부담금+ 급여 본인부담금
        
        //보조유형이 대불일 경우,
        //lSubtAmt = lSubtAmt + lPayOwnBAmt;
        //lPayOwnBAmt = 0;
        
        //보험유형이 공상이고, 보조유형이 본인부담100 아닐경우
        //lPayInsuBAmt = lPayInsuBAmt + lPayOwnBAmt;
        //lPayOwnBAmt = 0;
         
        //본인부담총액 = 비급여액+전액본인부담(비보험액)+선택진료료+급여본인부담금
        //컬럼추가로 인해 본인부담총액 계산방법 변경 = 비급여본인부담+전액본인 본인부담+ 선택진료본인부담+급여본인부담

        lTotOwnBAmt = lPayOwnBAmt + lNopyOwnBAmt + lAllOwnOwnBAmt + lSpecOwnBAmt;
        retopmiVO.set("opmi_totownbamt",lTotOwnBAmt);           //본인부담총액
        if ( log.isDebugEnabled() ) {log.debug("**----본인부담총액 ------**  " + String.valueOf(lTotOwnBAmt) );}
        
        //20090701 1.단수처리 고시적용
        lTotOwnBAmt100 = lPayOwnBAmt + lNopyOwnBAmt + lAllOwnOwnBAmt + lSpecOwnBAmt - lPayInsuRestAmt;      
        retopmiVO.set("opmi_totownbamt100",lTotOwnBAmt100);         //본인부담총액
        
        
        //잔전처리한 본인부담총액
        //20090701 1.단수처리 고시적용
        //lTotOwnBAmt2 =  Long.parseLong(NumericHelper.divide(String.valueOf(lTotOwnBAmt),String.valueOf("10"),  NumericHelper.ROUND_DOWN)) *10 ;       
        //retopmiVO.set("opmi_totownbamt2",lTotOwnBAmt2);           //본인부담총액2 -잔전처리
        lTotOwnBAmt2 =  Long.parseLong(NumericHelper.divide(String.valueOf(lTotOwnBAmt100),String.valueOf("10"),  NumericHelper.ROUND_DOWN)) *10 ;      
        retopmiVO.set("opmi_totownbamt2",lTotOwnBAmt2);         //본인부담총액2 -잔전처리
        
        //20110701 미용성형 부가세 고시 적용
        //보험유형 일반(51) 보조유형 미용목적성형(85) 일때 본인부담금의 10%를 부가세로 부가한다.
        if (StringHelper.strEquals(popmiVO.getString("opmi_insukind"),"51")
        			&& StringHelper.strEquals(popmiVO.getString("opmi_suppkind"),"85") ) { 
        	
        	iTaxAmt = (long)(lTotOwnBAmt / 10);
        }
        
        //임상환자(보험유형'71')이면 임상미수로 처리한다.(진찰료제외는 계산쪽에서 알아서 빼줌)
        if (StringHelper.strEquals(popmiVO.getString("opmi_insukind"),"71")) {
        	
        	//2013-03-04 임상일때 본인부담금 전액 미수가 아니라 입금금액을 제외한 나머지 금액만 미수처리
        	//(- lPreCashAmt - lPreCardAmt - lPreOnlineAmt - lPreMdlRcptAmt) 추가
            lLabAmt  = lTotOwnBAmt2 - lPayOwnBAmt - lPreCashAmt - lPreCardAmt - lPreOnlineAmt - lPreMdlRcptAmt;
            if( lLabAmt < 0 ){
            	lLabAmt = 0;
            }
            lUncoAmt = lLabAmt;
        }
        
        if ( log.isDebugEnabled() ) {log.debug("**----미수액(임상미수) ------** " + String.valueOf(lUncoAmt) );}
        
        //임상연구번호
        retopmiVO.set("opmi_uncoamt"         ,lUncoAmt);                        //미수금액                         
        retopmiVO.set("opmi_labamt"          ,lLabAmt);                         //임상금액                        
                                                                                                                  
        //기수납액                                                                                                
        retopmiVO.set("opmi_precashamt"      ,lPreCashAmt);                     //기현금액                        
        retopmiVO.set("opmi_precardamt"      ,lPreCardAmt);                     //기카드액                        
        retopmiVO.set("opmi_preonlineamt"    ,lPreOnlineAmt);                   //기온라인금액                    
        retopmiVO.set("opmi_premdlrcptamt"   ,lPreMdlRcptAmt);                  //기선수금                        
                                                                                                                  
        //변수 세팅                                                                                               
        retopmiVO.set("opmi_handcapfund"     , lHandcapFund);                   //장애기금                        
        retopmiVO.set("opmi_subtamt"         , lSubtAmt);                       //대불액                          
        retopmiVO.set("opmi_ersubtamt"       , lErSubtAmt);                     //응급대불액                      
        retopmiVO.set("opmi_procsubtamt"     , lProcSubtAmt);                   //보호대불액                      
                                                                                                                  
        retopmiVO.set("opmi_discamt"         ,lDiscAmt );                       //할인금액                        
        retopmiVO.set("opmi_reduamt"         ,lReduAmt );                       //감액금액                        
        retopmiVO.set("opmi_discreduamt"     ,lDiscAmt+lReduAmt);               //할인+감액                       
        retopmiVO.set("opmi_bloddiscamt"     ,lBlodDiscAmt);                    //수혈대체금액(헌혈증할인)        
                                                                                                                                                                                                             
        retopmiVO.set("opmi_payamt"          ,lPayAmt);                         //급여총액                        
        retopmiVO.set("opmi_payinsubamt"     ,lPayInsuBAmt);                    //급여보험자부담액                
        retopmiVO.set("opmi_payownbamt"      ,lPayOwnBAmt);                     //급여본인부담액                  
                                                                                                                  
        retopmiVO.set("opmi_nopyamt"         ,lNopyAmt);                        //비급여총액                      
        retopmiVO.set("opmi_nopyinsubamt"    ,lNopyInsuBAmt);                   //비급여본인부담액                
        retopmiVO.set("opmi_nopyownbamt"     ,lNopyOwnBAmt);                    //비급여보험자부담액              
                                                                                                                  
        retopmiVO.set("opmi_allownbamt"      ,lAllOwnBAmt);                     //전액본인부담금(비보험액)        
        retopmiVO.set("opmi_allowninsubamt"  ,lAllOwnInsuBAmt);                 //전액본인본인부담액              
        retopmiVO.set("opmi_allownownbamt"   ,lAllOwnOwnBAmt);                  //전액본인보험자부담액            
                                                                                                                  
        retopmiVO.set("opmi_specamt"         ,lSpecAmt);                        //선택진료비                      
        retopmiVO.set("opmi_specinsubamt"    ,lSpecInsuBAmt);                   //선택진료비본인부담액            
        retopmiVO.set("opmi_specownbamt"     ,lSpecOwnBAmt);                    //선택진료비보험자부담액          
                                                                                                                  
        retopmiVO.set("opmi_totnopyinsubamt" ,lTotNopyInsuBAmt);                //비급여+전액본인 중 보험자부담액 
        retopmiVO.set("opmi_totnopyownbamt"  ,lTotNopyOwnBAmt);                 //비급여+전액본인 중 본인부담액   
        retopmiVO.set("opmi_heallifeamtclamamt" ,lHeallifeamtclamAmt);          //건강생활유지비청구
        retopmiVO.set("opmi_prepregdmndamt"     ,lPrepregdmndAmt);              //기산전지원금차감액
        retopmiVO.set("opmi_pregdmndamt"        ,lPregdmndAmt);                 //산전지원금차감액
        
        //20090701 1.단수처리 고시적용
        retopmiVO.set("opmi_payinsurestamt" , lPayInsuRestAmt);     //100원미만 보험청구금액
        retopmiVO.set("opmi_payownbamt100"  , lPayOwnBAmt100);      //절사 처리한 본인부담액
        retopmiVO.set("opmi_payinsubamt100" , lPayInsuBAmt100);     //절사 처리한 보험자부담액
        
        //20110701 미용성형 부가세 고시적용
        retopmiVO.set("opmi_taxamt" 				, iTaxAmt);     				//부가세


        
        //희귀난치지원금과 장애기금은 동시에 받을수 없음
        if(StringHelper.strEquals(potptVO.getString("rareobstflag"), "H") && lHandcapFund == 0 ) {
            retopmiVO.set("opmi_suppamt" ,lPayOwnBAmt100);                          //희귀난치환자지원금
            lSuppamt = lPayOwnBAmt100;
        }else if(StringHelper.strEquals(potptVO.getString("rareobstflag"), "L") && lHandcapFund == 0 &&
                 (StringHelper.strEquals(popmiVO.getString("opmi_suppkind"),"50") || StringHelper.strEquals(popmiVO.getString("opmi_suppkind"),"51"))){                                                                                                   
            retopmiVO.set("opmi_suppamt" ,lPayOwnBAmt100 * 0.5);                    //결핵환자
            lSuppamt =  Long.parseLong(NumericHelper.divide(String.valueOf(lPayOwnBAmt100),"2", NumericHelper.ROUND_UP));
        }else{                                                                                                    
            retopmiVO.set("opmi_suppamt" ,0);                                   
            lSuppamt = 0;
        }
        retopmiVO.set("opmi_mdlrcptamt",lMdlRcptAmt);                              //중간금 대체

        //2011-11-14
        //실시정산일 때 희귀, 결핵 대불금 재계산
        //실시정산 구분 중 희귀구분 추가.
        if(StringHelper.strEquals("2", potptVO.getString("calcbaseflag"))){ 		//실시정산 체크
        	//결핵, 휘귀 지원금 설정 START
        	ValueObject ejVO = new ValueObject();
        	ejVO = outrcptmngtDAO.getExeSuppAmt(potptVO);
        	
        	long ltempSuppamt = 0;
    		lSuppamt = 0;
    		
        	if( ejVO.size() > 0 ){
        		for( int i=0; i< ejVO.size(); i++ ){
        			ltempSuppamt = ejVO.getLong(i, "suppamt", 0);
        			//100원미만 절사
	        		if  (bDiscChk == false && "20090701".compareTo(potptVO.getString("orddd")) <= 0 && "11".equals(popmiVO.getString("opmi_insukind")) 
	                		&& !"01".equals(popmiVO.getString("opmi_suppkind")) && !"12".equals(popmiVO.getString("opmi_suppkind")) && !"13".equals(popmiVO.getString("opmi_suppkind"))) {
	        			ltempSuppamt = Long.parseLong(NumericHelper.divide(String.valueOf(ltempSuppamt),String.valueOf("100"),  NumericHelper.ROUND_DOWN)) *100 ;
	        		}
	        		//결핵 50프로 지원
	        		if( StringHelper.strEquals("L", ejVO.getString(i, "rareobstflag"))){
	        			ltempSuppamt =  Long.parseLong(NumericHelper.divide(String.valueOf(ltempSuppamt),"2", NumericHelper.ROUND_UP));
	        		}
	        		lSuppamt = lSuppamt + ltempSuppamt;
        		}
        	}
    		retopmiVO.set("opmi_suppamt" , lSuppamt);
    		//결핵, 휘귀 지원금 설정 END
        }
        
        
		/*
        최종 현금 납부해야할 금액  = 본인부담총액 - 장애기금/대불액/상한초과액/의료급여대불액
                                                    수혈대체
                                                    의료급여승인
                                                    기산전/산전
                                                    희귀난치/계정감면
                                                    임의감면
                                                    미수액
                                                    기현금/기선수
                                                    기카드/기온라인
                                                    선수금
		*/
        
        //100원미만 절사로 인한 할인 환자 할인금이 납부할 금액이 많을 경우 수납 금액이 - 발생. (수납로직만 적용) 
        //납부할 금액에서 빼주고 절사에 더한다 (DiscRestAmt은  - 금액임)
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
            //20110701 미용성형 부가세 고시적용
            //납부할 금액에 부가세 포함.
            + iTaxAmt;
	        
        retopmiVO.set("opmi_rcptexptamt",lRcptExptAmt); //납부해야할 금액
		
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
        
        //현금수납액 => 납부할금액
        //납부할금액과 현금금액은 구분한다.

		
		/////////////////////////////////////////////절사처리 시작///////////////////////////////////////////////////
		//(-)금액 잔전나올경우, -56 원일경우, -60 원 처리하고, (+4)을 잔전처리한다, 원단위 금액이있는지 체크
		P0032_130 = this.getPmcmCodeNm("P0032","130",sInstCd).getString("cdnm","N");


		//10원 단위 절사
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
		
		//100원 단위 절사
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
            log.debug("절사처리");
            log.debug("절사전 : " + lRcptExptAmt);
            log.debug("절사후 : " + lCashAmt);
            log.debug("절사액 : " + (lRcptExptAmt - lCashAmt));
            log.debug("본인-할인 : " + DiscRestAmt);
            log.debug("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
		/////////////////////////////////////////////절사처리 끝///////////////////////////////////////////////////

        retopmiVO.set("opmi_cardamt"  ,lCardAmt);
        retopmiVO.set("opmi_onlineamt",lOnlineAmt);         
        
        //절사액
        //lRestAmt = lRcptExptAmt - lCashAmt;
        lRestAmt = lRcptExptAmt - lCashAmt - DiscRestAmt;
        retopmiVO.set("opmi_restamt",lRestAmt);
        
        //납부해야할 금액 재 세팅
        retopmiVO.set("opmi_rcptexptamt",lCashAmt);
        
        //총진료비 = 급여총액+비급여총액+전액본인부담액(비보험액)+선택진료료
        retopmiVO.set("opmi_totamt",Long.parseLong(retopmiVO.getString("opmi_payamt"))     + Long.parseLong(retopmiVO.getString("opmi_nopyamt")) +
                                    Long.parseLong(retopmiVO.getString("opmi_allownbamt")) + Long.parseLong(retopmiVO.getString("opmi_specamt"))                 
                                    );
        
        //비급여총액 = 비급여총액+전액본인부담액(비보험액)
        retopmiVO.set("opmi_totnopyamt",Long.parseLong(retopmiVO.getString("opmi_nopyamt")) + Long.parseLong(retopmiVO.getString("opmi_allownbamt")));

        //납입금 =납부할 금액 세팅
        retopmiVO.set("opmi_paydepoamt",retopmiVO.getInt("opmi_rcptexptamt"));
/*
        //서버에서 계산되어지는 납부할 금액
        retopmiVO.set("opmi_server_rcptamt", lTotOwnBAmt - lPreCardAmt - lPreCashAmt - lPreOnlineAmt - lPreMdlRcptAmt - lPrepregdmndAmt - lHandcapFund - lSubtAmt - lSuppamt - lDiscAmt - lRestAmt);

        //본인부담총액 - 장애기금/대불액/
                                수혈대체/의료급여승인/
                                기산전/산전/
                                희귀난치/계정감면/
                                기카드/기현금/기온라인/
                                기선수
        
        임의감면/미수액/선수금 제외
*/
        
        //20090701 1.단수처리 고시적용
        retopmiVO.set("opmi_server_rcptamt", lTotOwnBAmt100 - lHandcapFund - lSubtAmt 
											- lBlodDiscAmt     - lHeallifeamtclamAmt 
											- lPrepregdmndAmt  - lPregdmndAmt 
											- lSuppamt         - lDiscAmt
											- lPreCardAmt  - lPreCashAmt  - lPreOnlineAmt
											- lPreMdlRcptAmt 
											- lRestAmt
											//2011-07-01 미용고시 적용
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
        
        retopmiVO.set("opmi_rcptdd"        , SRcptdd);    //기본 수납키
        retopmiVO.set("opmi_rcptno"        , SRcptno);   
        retopmiVO.set("opmi_rcptseqno"     , SRcptSeqno);
        
        retopmiVO.set("opmi_orgrcptdd"     , SRcptdd);    //미수에서 쓰므로 외래수납에선 필요없으나 일단 넣어뒀음
        retopmiVO.set("opmi_orgrcptno"     , SRcptno);   
        retopmiVO.set("opmi_orgrcptseqno"  , SRcptSeqno);
        retopmiVO.set("opmi_orddd_org"     , potptVO.getString("orddd"));         //계산후 수납할떄 각 디테일 테이블들의 원래 수납키를 찾기위해 가져간다.
        retopmiVO.set("opmi_cretno_org"    , potptVO.getString("cretno"));
        retopmiVO.set("opmi_orddeptcd_org" , potptVO.getString("orddeptcd"));
        retopmiVO.set("opmi_orddrid_org"   , potptVO.getString("orddrid"));
        retopmiVO.set("opmi_rcptdd_org"    , SRcptdd);    
        retopmiVO.set("opmi_rcptno_org"    , SRcptno);   
        retopmiVO.set("opmi_rcptseqno_org" , SRcptSeqno);
        
        retopmiVO.set("pid"                , potptVO.getString("pid"));         //계산시점 디테일 테이블 조회시 사용
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


	/* 수납내역(OPMI) 생성 및 변경
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#insOutOrdAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insOutOrdAmt(ValueObject pVO) throws LiveException {

		int retCount = -1;
		int iCount = -1;
		
		ValueObject tmpOtpt = new ValueObject ();
		
		

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		try {
		
			//최초등록자/최종수정자/기관코드 세팅
			pVO.set("opmi_fstrgstrid" , pVO.getString("sessuserid"));
			pVO.set("opmi_lastupdtrid", pVO.getString("sessuserid"));
			pVO.set("opmi_instcd"     , pVO.getString("sessinstcd"));
			pVO.set("opmi_rcptrid"    , pVO.getString("sessuserid"));
			pVO.set("instcd"          , pVO.getString("sessinstcd"));
			
			//---------------------------------------
			//해당 외래등록내역의 정산구분이 정산이면, 
			//해당 외래등록내역의 정산구분이 건별이면, outrcptmngtDAO.insOutOrdAmt
			//---------------------------------------
			//외래수납내역 조건으로 외래등록내역 조회
			
			
			
			tmpOtpt = outrcptmngtDAO.getOtptInfo2(pVO);
			
			//정산이면, 기존내역 C update, 취소내역 D 생성		
			if (StringHelper.strEquals(tmpOtpt.getString("otpt_calcyn"),"Y")) {
				
				//OPMI
				if (outrcptmngtDAO.insOutOrdAmtDC(pVO) <0)	
					throw new LiveException("??  insOutOrdAmt  : insOutOrdAmtDC => opmi dc 생성 오류 ");	//D
				
				if (outrcptmngtDAO.setOutOrdAmtC(pVO) <0) 
					throw new LiveException("??  insOutOrdAmt  :  setOutOrdAmtC  => opmi y=>c 변경 오류 ");	//C
				
				if (outrcptmngtDAO.insOutOrdAmt(pVO) <=0) 
					throw new LiveException("??  insOutOrdAmt  :  insOutOrdAmt  => opmi y 내역 생성 오류 ");	//Y
				
				
				//해당 계산내역도 D 생성  - 계산로직에서 생성됨 
				/*
				retCount = -1;
				retCount = outrcptmngtDAO.insOSCLDC(pVO);
				if (retCount <0)	throw new LiveException("??  insOutOrdAmt  :  insOSCLDC  => oscl dc 생성 오류 ");
				*/

				//해당 계산내역 C 변경
				if (outrcptmngtDAO.setOSCLC(pVO) <0) throw new LiveException("??  insOutOrdAmt  :  setOSCLC  => oscl y=>c 변경 오류 ");
				
				//기존 디테일 수납정보 처리
				
				//DCGM 할인/감액
				outrcptmngtDAO.insDcgmAmtDC(pVO);	//D
				outrcptmngtDAO.setDcgmAmtC(pVO);	//C
				
				//UNCO 미수
				outrcptmngtDAO.insUncoAmtDC(pVO);	//D
				outrcptmngtDAO.setUncoAmtC(pVO);	//C
				
				//BLDC 헌혈증
				outrcptmngtDAO.insBldcAmtDC(pVO);	//D
				outrcptmngtDAO.setBldcAmtC(pVO);	//C
				
				
			}
			else if (StringHelper.strEquals(tmpOtpt.getString("otpt_calcyn"),"N")) {
				
				if (outrcptmngtDAO.insOutOrdAmt(pVO) <=0) 
					throw new LiveException("??  insOutOrdAmt  :  insOutOrdAmt  => opmi y 내역 생성 오류 ");
								
				//수납상태 계산상태 Y, 청구대상상태가 R인 것을 청구대상상태 C로 변경
				iCount = outrcptmngtDAO.setClamTrgtStat(pVO);
				if (outrcptmngtDAO.setClamTrgtStat(pVO) <0) 
					throw new LiveException("??  insOutOrdAmt  :  setClamTrgtStat  => calmtrgtstat 변경 오류 ");
								
			}
		
		
		} catch (LiveException le) {
            throw le;
        } catch (Exception e) {
            throw new LiveException("com.error.90000", e);
        }	
		
		
		return retCount;
		
	}
	
	/*
	 * (비Javadoc)
	 * 외래등록내역별 수납내역
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getOutRcptSpec(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOutRcptSpec(ValueObject pVO) throws LiveException {
		
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getOutRcptSpec(pVO);
	}

	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getMdlRemAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getMdlRemAmt(ValueObject pVO) throws LiveException {

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getMdlRemAmt(pVO);
	}

	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getMdlRemAmt2(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getMdlRemAmt2(ValueObject pVO) throws LiveException {

		ValueObject rVO = new ValueObject ();
		ValueObject bogjVO = new ValueObject ();
		ValueObject uncoVO = new ValueObject ();

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
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
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#insOnlineAmtCncl(kr.co.hit.live.vo.ValueObject)
	 */
	public int insOnlineAmtCncl(ValueObject pVO) throws LiveException {

		int iCount = -1;
		
		try { 

			 //기관코드 조회
			if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
				pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
			}
			
			//사용자 조회
			if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
				pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
			}
			
			//최초등록자/최종수정자/기관코드 세팅
			pVO.set("fstrgstrid", pVO.getString("sessuserid"));
			pVO.set("lastupdtrid", pVO.getString("sessuserid"));
			pVO.set("instcd",pVO.getString("sessinstcd"));
			
			//수납자 세팅
			pVO.set("rcptrid",pVO.getString("sessuserid"));
			
			iCount = -1;
			//수납취소내역 rcptstat :D 데이터 생성
			iCount = outrcptmngtDAO.insOnlineAmtCncl(pVO);
			
			if (iCount <= 0) {
				throw new LiveException("pam.error.15014");
				//throw new LiveException("외래선수금-통장입금 취소내역이 생성되지 않았습니다.[15014]");		
			}
			
			iCount = -1;
			//원 수납내역 Y => C로 수정
			iCount = outrcptmngtDAO.setOnlineAmt(pVO);
			
			if (iCount <= 0) {
				//throw new LiveException("pam.error.15015");
				throw new LiveException("외래선수금-통장입금 내역이 변경되지 않았습니다.[15015]");		
			}
		
		} catch (LiveException le) {
            throw le;
        } catch (Exception e) {
            throw new LiveException("com.error.90000", e);
        }	
		
		
		return iCount;
	}

	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#insMdlAmtCncl(kr.co.hit.live.vo.ValueObject)
	 */
	public int insMdlAmtCncl(ValueObject pVO) throws LiveException {
		
		int iCount = -1;
		
		try {
			 //기관코드 조회
			if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
				pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
			}
			
			//사용자 조회
			if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
				pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
			}
			
			pVO.set("fstrgstrid" , pVO.getString("sessuserid"));
			pVO.set("lastupdtrid", pVO.getString("sessuserid"));
			pVO.set("instcd"     , pVO.getString("sessinstcd"));
			pVO.set("rcptrid"    , pVO.getString("sessuserid"));
			
			//수납취소내역 rcptstat :D 데이터 생성
			iCount = -1;
			iCount = outrcptmngtDAO.insMdlAmtCncl(pVO);
			
			if (iCount <= 0) {
				//throw new LiveException("pam.error.15012");
				throw new LiveException("외래선수금 취소내역이 생성되지 않았습니다.[15012]");		
			}
			//내역 생성된 후, 취소 rcptseqno+100
			pVO.set("rcptseqno", Integer.valueOf(pVO.getString("rcptseqno"))+100  );
			
			//원 수납내역 Y => C로 수정
			iCount = -1;
			iCount=  outrcptmngtDAO.setMdlAmt(pVO);
			
			if (iCount <= 0) {
				//throw new LiveException("pam.error.15013");
				throw new LiveException("외래선수금 내역이 변경되지 않았습니다.[15013]");		
			}
		
		} catch (LiveException le) {
            throw le;
        } catch (Exception e) {
            throw new LiveException("com.error.90000", e);
        }	
		
		return iCount;
		
	}
	
	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#insChangeHist(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject insChangeHist(ValueObjectAssembler pVOs)  throws LiveException{

		ValueObject CheckinVO = pVOs.get("Checkin");
		ValueObject retOtptVO = new ValueObject ();
		
        String sInstCd = "";
        String sUserId = "";

         //기관코드 조회
        if (StringHelper.strEquals(CheckinVO.getString("sessinstcd"), "")) {
            CheckinVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(CheckinVO.getString("sessuserid"), "")) {
            CheckinVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID))); 
        }

        sInstCd = CheckinVO.getString("sessinstcd");
        sUserId = CheckinVO.getString("sessuserid");
		
		int iCheck = -1;
		if (StringHelper.strEquals(CheckinVO.getString("calcgubn"), "Y")) {

			//처방 hold건(execrcptstatcd ='210')이 있을시 otpt에 holdflag Y넣어준다.
			if(outrcptmngtDAO.getHoldExop(CheckinVO).size() > 0) {
				CheckinVO.set("holdflag" , "Y");
			}else{
				CheckinVO.set("holdflag" , "N");
			}
			//처방 hold 끝

			//외래등록 이력 추가(기존내역 histstat=C, 추가된이력 histstat=R)

			iCheck = outrcptmngtDAO.insOtptHistAdd(CheckinVO);

		}
		
		//외래등록 조회
		retOtptVO = outrcptmngtDAO.getLastOtpt(CheckinVO);	
		
		return retOtptVO;
		
	}

	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#insChangePtin(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject insChangePtin(ValueObjectAssembler pVOs)  throws LiveException{

		ValueObject CheckinVO = pVOs.get("Checkin");
		ValueObject PtinVO = pVOs.get("ptin");
		ValueObject retOtptVO = new ValueObject ();
		
        String sInstCd = "";
        String sUserId = "";

         //기관코드 조회
        if (StringHelper.strEquals(CheckinVO.getString("sessinstcd"), "")) {
            CheckinVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(CheckinVO.getString("sessuserid"), "")) {
            CheckinVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID))); 
        }

        sInstCd = CheckinVO.getString("sessinstcd");
        sUserId = CheckinVO.getString("sessuserid");
		
		int iCheck = -1;
		if (StringHelper.strEquals(CheckinVO.getString("calcgubn"), "Y")) {

			//보험정보 추가		
			PtinVO.set("ptin_pid"         , CheckinVO.getString("pid"));
			PtinVO.set("sessinstcd"       , sInstCd);
			PtinVO.set("sessuserid"       , sUserId);
			
			if (StringHelper.strEquals(PtinVO.getString("ptin_todd"),"") ) {
				PtinVO.set("ptin_todd","99991231");
			}

			String ptin_insukind = PtinVO.getString("ptin_insukind");
			
			//무인수납은 ptin이력변경 안합니다.
			if(!StringHelper.strEquals(ptin_insukind,"31") &&
			   !StringHelper.strEquals(ptin_insukind,"41") &&
			   !StringHelper.strEquals(ptin_insukind,"42") &&
			   !StringHelper.strEquals(sUserId,"PAM001")   &&
			   !StringHelper.strEquals(sUserId,"PAM")) {
					
					insPtinHistAdd(PtinVO);	

				}
			
		}
		
		//외래등록 조회
		retOtptVO = outrcptmngtDAO.getLastPtin(CheckinVO);
		return retOtptVO;
		
	}

	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getPatInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getPatInfo(ValueObject pVO) throws LiveException{
		
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getPatInfo(pVO);
		
	}
	
	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getPatDiag(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getPatDiag(ValueObject pVO) throws LiveException{
		
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
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
     * 외래수납 수가계산
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
        String sCalcActFlag    = otptVO.getString("otpt_calcactflag");    //화면에서 받아온 내역 따로 저장 2007.06.27
        String sCalcMthdFlag   = otptVO.getString("otpt_calcmthdflag");   //계산방법구분(P:정액,D:DRG,N:개별계산,산, O:인공신장)
        String calcgubn        = otptVO.getString("otpt_calcgubn");       //계산:Y     계산취소:N
        String calcstat        = "R";  //otptVO.getString("calcstat");    //수납화면:R 정산화면:Y
        String workgubn        = ptbsVO.getString("workgubn");            //수납화면:Y 정산화면:N 실시정산:E         
        String rcptdd_org      = otptVO.getString("otpt_rcptdd");
        String rcptno_org      = otptVO.getString("otpt_rcptno");
        String rcptseqno_org   = otptVO.getString("otpt_rcptseqno");
        String refundyn        = otptVO.getString("otpt_refundyn");      //환불여부
        String calcbaseflag    = otptVO.getString("otpt_calcbaseflag");  //실시정산구분
        String calcflag        = "S";                                    //계산구분
        String setbldccalc        = ptbsVO.getString("setbldccalc");            //수혈대체 적용으로 인한 재계산
        
        ValueObjectAssembler retVOs = new ValueObjectAssembler();       //계산 후 output VOs
        ValueObjectAssembler inpVOs = new ValueObjectAssembler();       //계산후 진료비금액 조회를 위한 input VOs
        ValueObjectAssembler chkVOs = new ValueObjectAssembler();       //예외처리 체크
        
        ValueObject pCalcVO = new ValueObject();  //계산로직 타기 위한 기본정보
        ValueObject osclVO  = new ValueObject();  //계산내역
        ValueObject opmiVO  = new ValueObject();  //진료비
        ValueObject earnVO  = new ValueObject();  //수익내역
        ValueObject cardVO  = new ValueObject();  //기카드
        ValueObject cashVO  = new ValueObject();  //기현금
        ValueObject onlnVO  = new ValueObject();  //기통장
        ValueObject bldcVO  = new ValueObject();  //기수혈대체
        ValueObject dcgmVO  = new ValueObject();  //기감면
        ValueObject uncoVO  = new ValueObject();  //기미수

       String sInstCd = "";
       String sUserId = "";

       //무인수납을 위해 코딩- 무인수납에선 instcdVo로 받고 일반수납은 서버에서 받음 
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
            throw new LiveException("다른사용자에 의해 등록내역이 변경된 환자입니다. 환자를 재조회하십시요");
        }

        //외래등록의 디테일 테이블 조회
        ValueObject otptDtlVO = this.getOtptDetailTB(otptVO);

        if (StringHelper.strEquals(otptDtlVO.getString("drcm_exop_cnt"),"1")) {

                otptVO.set("otpt_medamtestmyn"  , "N");
                otptVO.set("otpt_medamtfreeresn", "15");
        }

        if (StringHelper.strEquals(otptDtlVO.getString("hocm_exop_cnt"),"1")) {

                otptVO.set("otpt_medamtestmyn"  , "N");
                otptVO.set("otpt_medamtfreeresn", "16");
        }
        
                
        //외래등록일자별 감면정보 체크로직 추가  by 조중래 20130604
        //감면정보에 문제가 있는 경우 예외처리됨
        ValueObject dcucCheckVO = new ValueObject();
        dcucCheckVO.set("pid",          otptVO.getString("otpt_pid"));      //등록번호
        dcucCheckVO.set("disccd",       otptVO.getString("otpt_disccd"));   //감면코드
        dcucCheckVO.set("basedd",       otptVO.getString("otpt_orddd"));    //기준일자(진료일자)
        patInfoMngt.getCheckDCUC(dcucCheckVO);

        //2012-03-12 본인부담구분 점검
        //M006 일때 상병이 중증, 희귀일때만 수납가능하도록 수정.
        //재계산 돌릴 때마다 ownbflag 상태가 변경되어 쿼리단 → 로직단에서 체크하도록 수정 by 조중래 20130603
        //M005는 희귀난치상병이 아니더라도 본인부담면제 처리하도록 추가수정 by 조중래 20130605
        ValueObject ownbflagCheckVO = outrcptmngtDAO.getOwnbflagCheckInfo(otptVO);
        if( ownbflagCheckVO.size() > 0 && (StringHelper.strEquals("M006", otptVO.getString("otpt_ownbflag")))){
        	otptVO.set("otpt_ownbflag"  , "-");
        }
        
        if (StringHelper.strEquals(workgubn,"E") && actrVO.size() > 0) {

            this.delOutOrdActr(actrVO);
            if(StringHelper.strEquals(calcbaseflag,"2")){  //1: 정상건 정산 2:실시정산
                //실시정산일시 시행일자 테이블 넣어준다.
                for(int a=0; a < actrVO.size(); a++) {
                    this.setOutOrdActr(actrVO.getRowAsVo(a)); 
                }
            }
        }
        


        //계산에 영향을 주는 유형변경 사항 체크.
        ValueObjectAssembler CheckinVOs = new ValueObjectAssembler (); 
        
        ValueObject CheckinVO   = new ValueObject ();
        ValueObject CheckoutVO  = new ValueObject ();
        
        CheckinVO.set("userid"        , sUserId);
        CheckinVO.set("instcd"        , sInstCd);   
        CheckinVO.set("sessuserid"    , sUserId);
        CheckinVO.set("sessinstcd"    , sInstCd);   

        CheckinVO.set("insukind"           ,ptinVO.getString("ptin_insukind"));            //보험유형                   
        CheckinVO.set("suppkind"           ,ptinVO.getString("ptin_suppkind"));            //보조유형                   
        CheckinVO.set("insucd"             ,ptinVO.getString("ptin_insucd"));              //보험자코드                
        CheckinVO.set("suppkindresn"       ,ptinVO.getString("ptin_suppkindresn"));        //보조유형사유            
        CheckinVO.set("todd"               ,ptinVO.getString("ptin_todd"));                //종료일자                  
        CheckinVO.set("fromdd"             ,ptinVO.getString("ptin_fromdd"));              //시작일자                  
        CheckinVO.set("insuno"             ,ptinVO.getString("ptin_insuno"));              //보험증번호                
        CheckinVO.set("insdnm"             ,ptinVO.getString("ptin_insdnm"));              //피보험자명               
        CheckinVO.set("insdrrgstno1"       ,ptinVO.getString("ptin_insdrrgstno1"));        //피보험자주민번호1     
        CheckinVO.set("insdrrgstno2"       ,ptinVO.getString("ptin_insdrrgstno2"));        //피보험자주민번호2     
        CheckinVO.set("insdrela"           ,ptinVO.getString("ptin_insdrela"));            //피보험자관계            


        //할인정보                                                                                                                                                                  
        CheckinVO.set("disccd"                 ,otptVO.getString("otpt_disccd"));          //할인코드                                                                                                                    
        //외래등록정보                                                                                                                                                                                                              
        CheckinVO.set("histstat"               ,otptVO.getString("otpt_histstat"));        //접수정보                                                                                                                    
        CheckinVO.set("pid"                    ,otptVO.getString("otpt_pid"));             //등록번호                                                                                                                    
        CheckinVO.set("orddd"                  ,otptVO.getString("otpt_orddd"));           //진료일자                                                                                                                    
        CheckinVO.set("cretno"                 ,otptVO.getString("otpt_cretno"));          //생성번호
        CheckinVO.set("calcbaseflag"           ,calcbaseflag);                             //실시정산여부구분
        CheckinVO.set("acptseqno"              ,otptVO.getString("otpt_acptseqno"));       //등록일련번                                                                                                                 
        CheckinVO.set("specordyn"              ,otptVO.getString("otpt_specordyn"));                  //선택진료여부                                                                                                              
        CheckinVO.set("fsexamflag"             ,otptVO.getString("otpt_fsexamflag"));                 //초재진구분                                                                                                                 
        CheckinVO.set("fsexammanlyn"           ,otptVO.getString("otpt_fsexammanlyn"));               //초재진수동부여여부                                                                                                     
        CheckinVO.set("medamtestmyn"           ,otptVO.getString("otpt_medamtestmyn"));               //진찰료산정여부                                                                                                           
        CheckinVO.set("medamtpostyn"           ,otptVO.getString("otpt_medamtpostyn"));               //진찰료후불여부                                                                                                           
        CheckinVO.set("medamtfreeresn"         ,otptVO.getString("otpt_medamtfreeresn"));             //진찰료면제사유 진찰료 산정여부가 N=미산정,무료일때 미산정 사유(코드군 P1061 참조)         
        CheckinVO.set("etcordflag"             ,otptVO.getString("otpt_etcordflag"));                 //기타진료구분(코드군 P0022 참조) J:주사  M:물리치료, F:가족, N:가정간호                          
        CheckinVO.set("handicaprbookpossnyn"   ,otptVO.getString("otpt_handicaprbookpossnyn"));       //장애인수첩소지여부                                                                                                     
        CheckinVO.set("ordreqformflag"         ,otptVO.getString("otpt_ordreqformflag"));             //진료의뢰서제출구분                                                                                                     
        CheckinVO.set("clincstdyacptflag"      ,otptVO.getString("otpt_clincstdyacptflag"));          //임상구분                                                                                                                    
        CheckinVO.set("calcmthdflag"           ,sCalcMthdFlag);                                                                                                                                                                                  
        CheckinVO.set("calcgubn"               ,calcgubn);                                            //calcgubn 계산:Y      계산취소:N                                                                                     
        CheckinVO.set("calcstat"               ,calcstat);                                            //calcstat 수납화면:R  정산화면:Y                                                                                    
        CheckinVO.set("workgubn"               ,workgubn);                                            //workgubn 수납화면:Y  정산화면:N 실시정산: E                                                                  
        CheckinVO.set("hosoutexptresncd"       ,otptVO.getString("otpt_hosoutexptresncd"));           //원외예외사유코드
		CheckinVO.set("rsrvflag"			   ,otptVO.getString("otpt_rsrvflag"));					  //예약구분
        CheckinVO.set("rareobstflag"           ,otptVO.getString("otpt_rareobstflag"));               //희귀난치                                                                                                                   
        CheckinVO.set("ownbflag"               ,otptVO.getString("otpt_ownbflag"));                   //본인부담구분                                                                                                              
        CheckinVO.set("refundyn"               ,refundyn);                                            //환불여부                                                                                                                    
        CheckinVO.set("calcflag_org"           ,otptVO.getString("otpt_calcflag_org"));               //계산여부_org 롤백시 쓴다.                                                                                            

        //이동재20071206 계산구분(가계산 추가되면서 가계산은 접수변경하지않음)
        if (StringHelper.strEquals(calcgubn,"Y") || StringHelper.strEquals(calcgubn,"E")) {
            
            int iCount1=0; 
            
            CheckinVO.set("calcyn"      ,"Y");
            CheckinVO.set("calcflag"    , calcflag);   
            CheckinVOs.set("Checkin"    , CheckinVO);
            CheckinVOs.set("ptin"       , ptinVO);

            try {
                
                pCalcVO.set("brthdd"             , ptbsVO.getString("ptbs_brthdd"));              // 생년월일          
                pCalcVO.set("rrgstno1"           , ptbsVO.getString("ptbs_rrgstno1"));            // 주민번호1        
                pCalcVO.set("rrgstno2"           , ptbsVO.getString("ptbs_rrgstno2"));            // 주민번호2        
                                                                                                                
                pCalcVO.set("pid"                , ptbsVO.getString("ptbs_pid"));                 //등록번호                                                                         
                pCalcVO.set("orddd"              , otptVO.getString("otpt_orddd"));               //진료일자          
                pCalcVO.set("cretno"             , otptVO.getString("otpt_cretno"));              //생성번호           
                pCalcVO.set("acptseqno"          , otptVO.getString("otpt_acptseqno"));           //등록일련번호    
                pCalcVO.set("instcd"             , sInstCd);                                      //기관코드           
                pCalcVO.set("sessinstcd"        , sInstCd);                                                                                                
                pCalcVO.set("histstat"           , otptVO.getString("otpt_histstat"));            //이력상태           
                pCalcVO.set("orgorddd"           , otptVO.getString("otpt_orgorddd"));            //원진료일자       
                pCalcVO.set("orgcretno"          , otptVO.getString("otpt_orgcretno"));           //원진료생성번호
                pCalcVO.set("calcbaseflag"       , calcbaseflag);                                 //실시정산여부구분
                pCalcVO.set("calcyn"             , otptVO.getString("otpt_calcyn"));              //정산여부          
                                                                                                                
                pCalcVO.set("ordtm"              , otptVO.getString("otpt_ordtm"));               //진료시간           
                pCalcVO.set("orddeptcd"          , otptVO.getString("otpt_orddeptcd"));           //진료과코드        
                pCalcVO.set("orddrid"            , otptVO.getString("otpt_orddrid"));             //진료의ID           
                pCalcVO.set("dutdeptcd"          , otptVO.getString("otpt_dutdeptcd"));           //근무부서코드     
                                                                                                                
                pCalcVO.set("centcd"             , otptVO.getString("otpt_centcd"));              //센터코드           
                pCalcVO.set("supdeptcd"          , otptVO.getString("otpt_supdeptcd"));           //상위부서코드    
                pCalcVO.set("mskind"             , otptVO.getString("otpt_mskind"));              //주부유형           
                                                                                                                
                pCalcVO.set("insukind"          , ptinVO.getString("ptin_insukind"));             //보험유형          
                pCalcVO.set("suppkind"          , ptinVO.getString("ptin_suppkind"));             //보조유형          
                pCalcVO.set("insucd"            , ptinVO.getString("ptin_insucd"));               //보험자코드       
                pCalcVO.set("suppkindresn"      , ptinVO.getString("ptin_suppkindresn"));         //보조유형사유     
                pCalcVO.set("disccd"            , StringHelper.null2string(otptVO.getString("otpt_disccd"), "-"));               //할인코드          
                                                                                                  
                pCalcVO.set("specordyn"                    , otptVO.getString("otpt_specordyn"));               //선택진료여부                                                                                                       
                pCalcVO.set("fsexamflag"                   , otptVO.getString("otpt_fsexamflag"));              //초재진구분                                                                                                          
                pCalcVO.set("fsexammanlyn"                 , otptVO.getString("otpt_fsexammanlyn"));            //초재진수동부여여부                                                                                              
                pCalcVO.set("medamtestmyn"                 , otptVO.getString("otpt_medamtestmyn"));            //진찰료산정여부                                                                                                    
                pCalcVO.set("medamtpostyn"                 , otptVO.getString("otpt_medamtpostyn"));            //진찰료후불여부                                                                                                   
                pCalcVO.set("medamtfreeresn"               , otptVO.getString("otpt_medamtfreeresn"));          //진찰료면제사유 진찰료 산정여부가 N=미산정,무료일때 미산정 사유(코드군 P1061 참조)  
                pCalcVO.set("etcordflag"                   , otptVO.getString("otpt_etcordflag"));              //기타진료구분(코드군 P1072 참조) J:주사  M:물리치료, F:가족, N:가정간호                     
                pCalcVO.set("handicaprbookpossnyn"         , otptVO.getString("otpt_handicaprbookpossnyn"));    //장애인수첩소지여부        
                pCalcVO.set("ordreqformflag"               , otptVO.getString("otpt_ordreqformflag"));          //진료의뢰서제출구분    
                pCalcVO.set("clincstdyacptflag"            , otptVO.getString("otpt_clincstdyacptflag"));       //임상시험접수구분
                                                                                                  
                pCalcVO.set("holiflag"                     , otptVO.getString("otpt_holiflag"));                //공휴일구분                     
                pCalcVO.set("ordtype"                      , otptVO.getString("otpt_ordtype"));                 //진료형태                        
                pCalcVO.set("brateflag"                    , otptVO.getString("otpt_brateflag"));               //부담률구분                     
                pCalcVO.set("rsrvflag"                     , otptVO.getString("otpt_rsrvflag"));                //예약구분                        
                pCalcVO.set("hosoutexptresncd"             , otptVO.getString("otpt_hosoutexptresncd"));        //원외예외사유코드            
                pCalcVO.set("clincstdyno"                  , otptVO.getString("otpt_clincstdyno"));             //임상시험번호                  
                pCalcVO.set("chrtlendyn"                   , otptVO.getString("otpt_chrtlendyn"));              //챠트대출여부                  
                pCalcVO.set("specorddescyn"                , otptVO.getString("otpt_specorddescyn"));           //선택진료설명여부            
                pCalcVO.set("ordreqdescyn"                 , otptVO.getString("otpt_ordreqdescyn"));            //진료의뢰서설명여부         
                pCalcVO.set("ordreqhospgrde"               , otptVO.getString("otpt_ordreqhospgrde"));          //진료의뢰서설명병원등급   
                                                                                                                                                                              
                pCalcVO.set("insuchrgyn"                   , otptVO.getString("otpt_insuchrgyn"));              //보험회사담당자여부         
                pCalcVO.set("pamacptyn"                    , otptVO.getString("otpt_pamacptyn"));               //원무접수여부                  
                pCalcVO.set("pamacptdt"                    , otptVO.getString("otpt_pamacptdt"));               //원무접수일시                  
                pCalcVO.set("pamacptid"                    , otptVO.getString("otpt_pamacptid"));               //원무접수자ID                   
                pCalcVO.set("nursacptyn"                   , otptVO.getString("otpt_nursacptyn"));              //간호사접수여부               
                pCalcVO.set("nursacptdt"                   , otptVO.getString("otpt_nursacptdt"));              //간호사접수일시               
                pCalcVO.set("dracptyn"                     , otptVO.getString("otpt_dracptyn"));                //의사접수여부                  
                pCalcVO.set("dracptdt"                     , otptVO.getString("otpt_dracptdt"));                //의사접수일시                  
                pCalcVO.set("prcpgenryn"                   , otptVO.getString("otpt_prcpgenryn"));              //처방발생여부                  
                                                                                                                                  
                pCalcVO.set("prcpnotoccrresn"              , otptVO.getString("otpt_prcpnotoccrresn"));          //처방미발생사유코드            
                pCalcVO.set("estmspclappyn"                , otptVO.getString("otpt_estmspclappyn"));            //산정특례적용여부              
                //pCalcVO.set("calcflag"                   , otptVO.getString("otpt_calcflag"));               
                pCalcVO.set("calcflag"                     , calcflag);                                          //계산구분
                pCalcVO.set("calcmthdflag"                 , sCalcMthdFlag);                                     //계산방법구분
                pCalcVO.set("prcpgenryn"                   , otptVO.getString("otpt_prcpgenryn"));               //처방생성여부
                pCalcVO.set("rqsthospcd"                   , otptVO.getString("otpt_rqsthospcd"));               //협력의뢰의ID                  
                pCalcVO.set("ermngtamtcalcyn"              , otptVO.getString("otpt_ermngtamtcalcyn"));          //응급의학관리료산정여부        
                pCalcVO.set("erbrthflag"                   , otptVO.getString("otpt_erbrthflag"));               //응급분만구분                  
                pCalcVO.set("erchospath"                   , otptVO.getString("otpt_erchospath"));               //응급내원경로                  
                pCalcVO.set("erorddeptcd"                  , otptVO.getString("otpt_erorddeptcd"));              //응급진료과                    
                pCalcVO.set("erjudgstat"                   , otptVO.getString("otpt_erjudgstat"));               //응급심사상태                  
                                                                                                                                  
                pCalcVO.set("eroutrmnotidt"                , otptVO.getString("otpt_eroutrmnotidt"));          //응급퇴실통보일시              
                pCalcVO.set("eroutrmdt"                    , otptVO.getString("otpt_eroutrmdt"));              //응급퇴실일시                  
                pCalcVO.set("lastrcptendyn"                , otptVO.getString("otpt_lastrcptendyn"));          //최종수납완료여부              
                pCalcVO.set("tdayinyn"                     , otptVO.getString("otpt_tdayinyn"));               //당일입원여부                  
                pCalcVO.set("tranindd"                     , otptVO.getString("otpt_tranindd"));               //전환입원일자                  
                pCalcVO.set("rcptdd"                       , otptVO.getString("otpt_rcptdd"));                 //영수일자                      
                pCalcVO.set("rcptno"                       , otptVO.getString("otpt_rcptno"));                 //영수증번호                    
                pCalcVO.set("rcptseqno"                    , otptVO.getString("otpt_rcptseqno"));              //영수증일련번호                
                                                                                                                                  
                pCalcVO.set("telrsrvrem"                   , otptVO.getString("otpt_telrsrvrem"));           //전화예약참고사항              
                pCalcVO.set("bforddd"                      , otptVO.getString("otpt_bforddd"));              //이전진료일자                  
                pCalcVO.set("bfordtm"                      , otptVO.getString("otpt_bfordtm"));              //이전진료시간                  
                pCalcVO.set("bforddeptcd"                  , otptVO.getString("otpt_bforddeptcd"));          //이전진료과코드                
                pCalcVO.set("bforddrid"                    , otptVO.getString("otpt_bforddrid"));            //이전진료의ID                  
                pCalcVO.set("updtcnclresn"                 , otptVO.getString("otpt_updtcnclresn"));         //변경취소사유                  
                pCalcVO.set("fstacptid"                    , otptVO.getString("otpt_fstacptid"));            //최초접수자ID                  
                pCalcVO.set("fstacptdt"                    , otptVO.getString("otpt_fstacptdt"));            //최초접수일시                  
                pCalcVO.set("fstrgstrid"                   , otptVO.getString("otpt_fstrgstrid"));           //최초등록자ID                  
                pCalcVO.set("fstrgstdt"                    , otptVO.getString("otpt_fstrgstdt"));            //최초등록일시                  
                pCalcVO.set("lastupdtrid"                  , otptVO.getString("otpt_lastupdtrid"));          //최종수정자ID                  
                pCalcVO.set("lastupdtdt"                   , otptVO.getString("otpt_lastupdtdt"));           //최종수정일시                         
                pCalcVO.set("ownbflag"                     , otptVO.getString("otpt_ownbflag"));             //본인부담구분
                pCalcVO.set("tranflag"                     , otptVO.getString("otpt_tranflag"));             //입원외래덤프
                pCalcVO.set("rareobstflag"                 , otptVO.getString("otpt_rareobstflag"));         //희귀난치
                                                                                               
                pCalcVO.set("calcactflag"                  , sCalcActFlag );                                 //계산수행구분(1:접수, 2:진료후수납)                                                                    
                pCalcVO.set("sessuserid"                   , sUserId);                                       //수납자    

                pCalcVO.set("drcm_qualflag"                , otptDtlVO.getString("drcm_qualflag"));          //pmohdrcm 의사소견서 본인부담구분
                pCalcVO.set("hocm_qualflag"                , otptDtlVO.getString("hocm_qualflag"));          //pmohhocm 방문간호지시서 본인부담구분
                pCalcVO.set("workgubn"                     , workgubn);                                      //workgubn 수납화면:Y  정산화면:N
                pCalcVO.set("spclcd"                       , otptVO.getString("otpt_spclcd"));            	 //특례기호. 2011.05.03 syjung 추가

                //2013-01-18 수혈대체 감면내역 삭제여부
                //새로운 수혈대체 내역이 있거나, 수혈대체 재계산 플래그가 들어오면 
                //수가계산에선 수혈대체 감면적용 해제를 하지 않음.
                if( bldcVOS.size() > 0 || StringHelper.strEquals(setbldccalc, "Y")){
                	pCalcVO.set("bldcdiscamtdelyn"		, "N");						//수혈대체 감면금액 삭제여부
                }
                
                //if((StringHelper.strEquals(refundyn,"접수취소") &&  StringHelper.strEquals(otptVO.getString("otpt_prcpgenryn"),"1A"))) {
                //if((StringHelper.strEquals(refundyn,"접수취소"))) {
                int prcpCnt = outrcptmngtDAO.getExopActList(pCalcVO).size();
                if ( ((StringHelper.strEquals(pCalcVO.getString("etcordflag"),"M")  && StringHelper.strEquals(pCalcVO.getString("medamtestmyn"),"N")) ||

   	                 (StringHelper.strEquals(pCalcVO.getString("etcordflag"),"J")   && StringHelper.strEquals(pCalcVO.getString("medamtestmyn"),"N")) ||

   	                 (StringHelper.strEquals(pCalcVO.getString("etcordflag"),"T")   && StringHelper.strEquals(pCalcVO.getString("medamtestmyn"),"N")  && StringHelper.strEquals(pCalcVO.getString("orddeptcd"),"2170000000")) ||

   	                 (StringHelper.strEquals(pCalcVO.getString("rsrvflag"),"A")      && StringHelper.strEquals(pCalcVO.getString("medamtestmyn"),"N")  && StringHelper.strEquals(pCalcVO.getString("specordyn"),"N")) ||

   	                 (StringHelper.strEquals(refundyn ,"접수취소")) )
   	                 
   	                 && prcpCnt == 0
                ) {
                    outrcptmngtDAO.delOsclCancel(otptVO);
                    
                }else{

                    if(StringHelper.strEquals(otptVO.getString("otpt_calcbaseflag"),"1")){
                        osclVO = outcalc.OutCalculation(pCalcVO);    //외래계산
                    }
                    if(StringHelper.strEquals(otptVO.getString("otpt_calcbaseflag"),"2")){
                        osclVO = outcalc.exeOutCalc(pCalcVO);        //실시정산
                    }
                    
                    //수혈대체 내역 감면금액 삭제
                    if( bldcVOS.size() > 0 
                    	&& StringHelper.strEquals(pCalcVO.getString("bldcdiscamtdelyn"), "N") 
                    	&& !StringHelper.strEquals(pCalcVO.getString("disccd"), "-")){
                    	
                    	outcalc.delBldcDiscamt(bldcVOS);
                    }
                    
                }

                //계산시 oscl에 변화가 있어야 calcflag 업데이트 친다.
                if(osclVO.size() == 0 && StringHelper.strEquals(workgubn, "N")){ 
                    throw new LiveException("변경된 계산내역이 없습니다.");
                 }
                  
                //금액조회를 위한 input VO 
                ValueObject otptInVO = new ValueObject();
                ValueObject ptinInVO = new ValueObject();
   
                otptInVO.set("pid"                       , otptVO.getString("otpt_pid"));                                                                                           
                otptInVO.set("orddd"                     , otptVO.getString("otpt_orddd"));                                                                                       
                otptInVO.set("cretno"                    , otptVO.getString("otpt_cretno"));                                                                                      
                otptInVO.set("acptseqno"                 , otptVO.getString("otpt_acptseqno"));                                                                                 
                otptInVO.set("orgorddd"                  , otptVO.getString("otpt_orgorddd"));             //orgorddd ,orgcretno 로 기수납금 조회                  
                otptInVO.set("orgcretno"                 , otptVO.getString("otpt_orgcretno"));                                                                                  
                otptInVO.set("orddeptcd"                 , otptVO.getString("otpt_orddeptcd"));                                                                                 
                otptInVO.set("orddrid"                   , otptVO.getString("otpt_orddrid"));
                otptInVO.set("centcd"                    , otptVO.getString("otpt_centcd"));               //센터코드
                otptInVO.set("ordtype"                   , otptVO.getString("otpt_ordtype"));                                                                                     
                otptInVO.set("mskind"                    , otptVO.getString("otpt_mskind"));                                                                                      
                otptInVO.set("calcmthdflag"              , otptVO.getString("otpt_calcmthdflag"));                                                                              
                otptInVO.set("calcyn"                    , otptVO.getString("otpt_calcyn"));               //기수납금 조회 위해 필요                                   
                otptInVO.set("rareobstflag"              , otptVO.getString("otpt_rareobstflag"));                                                                               
                otptInVO.set("rcptdd"                    , otptVO.getString("otpt_rcptdd"));                                                                                      
                otptInVO.set("rcptno"                    , otptVO.getString("otpt_rcptno"));                                                                                      
                otptInVO.set("rcptseqno"                 , otptVO.getString("otpt_rcptseqno"));                                                                                  
                otptInVO.set("calcstat"                  , calcstat);                                      //calcstat 수납화면:R  정산화면:Y
                otptInVO.set("calcgubn"                  , calcgubn);                                      //calcgubn      계산:    Y 계산취소:N
                otptInVO.set("calcbaseflag"              , calcbaseflag);                                  //계산기준구분  1: 정산  2,3: 실시정산분리
                //otptInVO.set("calcflag"                , otptVO.getString("otpt_calcflag"));
                otptInVO.set("calcflag"                  , calcflag);                                      //계산구분      Y:미계산 S:계산 N:수납
                otptInVO.set("etcordflag"                , otptVO.getString("otpt_etcordflag"));                                                                                  
                otptInVO.set("sessinstcd"                , sInstCd);                                                                                                                     
                otptInVO.set("sessuserid"                , sUserId);                                                                                                                     
                otptInVO.set("workgubn"                  , workgubn);                                      //workgubn 수납화면:Y  정산화면:N 실시정산: E           
                otptInVO.set("specordyn"                 , otptVO.getString("otpt_specordyn"));                                                                                 
                otptInVO.set("rareobstflag"              , otptVO.getString("otpt_rareobstflag"));          //희귀난치                                                       
                otptInVO.set("ownbflag"                  , otptVO.getString("otpt_ownbflag"));              //본인부담구분                                                
                otptInVO.set("handicaprbookpossnyn"      , otptVO.getString("otpt_handicaprbookpossnyn"));  //장애인수첩소지여부
                otptInVO.set("refundyn"                  , refundyn);                                       //환불여부

                otptInVO.set("nursacptyn"                , otptVO.getString("otpt_nursacptyn"));            //간호접수여부
                otptInVO.set("dracptyn"                  , otptVO.getString("otpt_dracptyn"));              //의사접수여부
                otptInVO.set("prcpgenryn"                , otptVO.getString("otpt_prcpgenryn"));            //처방발생여부
                otptInVO.set("insukind"                  , ptinVO.getString("ptin_insukind"));              //보험유형          
                otptInVO.set("suppkind"                  , ptinVO.getString("ptin_suppkind"));              //보조유형          
                otptInVO.set("insucd"                    , ptinVO.getString("ptin_insucd"));                //보험자코드
                otptInVO.set("ordreqformflag"            , otptVO.getString("otpt_ordreqformflag"));        //수급절차
                otptInVO.set("estmspclappyn"             , otptVO.getString("otpt_estmspclappyn"));         //산정특례적용여부
                otptInVO.set("spclcd"                    , otptVO.getString("otpt_spclcd"));                //vcode
                otptInVO.set("subdeptcd"                 , otptVO.getString("otpt_subdeptcd"));             //세부과
                otptInVO.set("coopteamcd"                , otptVO.getString("otpt_coopteamcd"));            //협력팀코드
                otptInVO.set("medamtestmyn"              , otptVO.getString("otpt_medamtestmyn"));          //진찰료산정여부
                otptInVO.set("rsrvflag"                  , otptVO.getString("otpt_rsrvflag"));              //예약구분
                otptInVO.set("specordyn"                 , otptVO.getString("otpt_specordyn"));             //선택의적용여부
                otptInVO.set("disccd"                 	, otptVO.getString("otpt_disccd"));             //할인코드

                ptinInVO.set("insukind"                  , ptinVO.getString("ptin_insukind"));
                ptinInVO.set("suppkind"                  , ptinVO.getString("ptin_suppkind"));
                ptinInVO.set("insucd"                    , ptinVO.getString("ptin_insucd"));
                
                if ( log.isDebugEnabled() ) {           
                    log.debug("**----보험정보 확인 ------**  " );
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

                opmiVO = getOpmiInfo(inpVOs,"계산");             //수납할 금액 조회 
                earnVO = this.getEarnInfo2(otptInVO);            //계산정보로 수익내역 조회
                cardVO = this.getcardList(opmiVO);               //기카드
                cashVO = this.getcashList(opmiVO);               //기현금
                onlnVO = this.getonlnList(opmiVO);               //기통장   
                bldcVO = this.getbldcList(opmiVO);               //기수혈대체
                dcgmVO = this.getdcgmList(opmiVO);               //기감면
                uncoVO = this.getuncoList(opmiVO);               //기미수
                
                otptVO = insChangeHist(CheckinVOs);              //외래등록내역 상태변경,마지막 외래등록내역 읽어온다 서버부하로 뒤로뺐음

                ptinVO = insChangePtin(CheckinVOs);              //외래보험내역 상태변경,마지막 외래보험내역 읽어온다
                
                retVOs.set("oscl", outrcptmngtDAO.getOsclInfo(otptInVO));  //계산내역 조회
                retVOs.set("opmi", opmiVO);  //부담률 적용된 수납내역 view를 위한 진료비정보 세팅
                retVOs.set("earn", earnVO);  //수익정보
                retVOs.set("card", cardVO);  //기카드
                retVOs.set("cash", cashVO);  //기현금
                retVOs.set("onln", onlnVO);  //기통장
                retVOs.set("bldc", bldcVO);  //기수혈대체
                retVOs.set("dcgm", dcgmVO);  //기감면
                retVOs.set("unco", uncoVO);  //기미수

                //retVOs.set("otpt", otptInVO);
                retVOs.set("otpt", otptVO);
                retVOs.set("ptin", ptinVO);

                chkVOs.set("otpt",otptInVO);  
                chkVOs.set("oscl",osclVO); 
                chkVOs.set("bldc",bldcVO); 
                retVOs.set("msg", this.outOrd_Check(chkVOs ,"계산" , sInstCd , sUserId));  //외래수납 기본체크사항

                // 클라이언트에 전달할 정상 처리 메시지 설정.
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
                //신규 조회한 내역으로  otptVO 대체
                otptVO = CheckoutVO;
            }           
        }

        return retVOs;
    }
	
	
	/*
	 * (비Javadoc)
	 * 외래수납조회(외래등록키 조건으로)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getopmiList3(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getopmiList3(ValueObject pVO) throws LiveException{
		
        //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getopmiList3(pVO);
		
	}	
	
	
	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getOtptInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOtptInfo(ValueObject pVO) throws LiveException{
		
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getOtptInfo(pVO);
		
	}	

	
	/*
	 * (비Javadoc)
	 * 외래수납 처리
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#setOutOrdAmtRcpt(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObjectAssembler setOutOrdAmtRcpt(ValueObjectAssembler pVOs) throws LiveException {
		if ( log.isDebugEnabled() ) {
	   		 log.debug("**----외래 수납  mgt  start   setOutOrdAmtRcpt ------**  " ); 
		}
		
	   String otpt_histstat = "";
       String sInstCd = "";
       String sUserId = "";

       //무인수납을 위해 코딩- 무인수납에선 instcdVo로 받고 일반수납은 서버에서 받음 
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
		

        if(pVOs.isExist("otpt")) {  //환자기본정보 및 수납구분   
			otptVO = pVOs.get("otpt");     
		}

        if(pVOs.isExist("ptbs")) {  //환자기본정보 및 수납구분   
			ptbsVO = pVOs.get("ptbs");     
		}
        if(pVOs.isExist("opmi")) {  //수납내역(영수내역) 
			opmiVO = pVOs.get("opmi");      
			opmiVO.set("sessinstcd"  , sInstCd);
			opmiVO.set("sessuserid"  , sUserId);
		}
        if(pVOs.isExist("card")) { //카드수납내역  
			cardVO = pVOs.get("card");       
		}

        if(pVOs.isExist("cash")) {  //현금영수증내역    	
			cashVO = pVOs.get("cash");      
		}
        if(pVOs.isExist("onln")) { //통장입금내역   
			onlnVO = pVOs.get("onln");     
		}
        if(pVOs.isExist("unco")) {//미수내역       
			uncoVO = pVOs.get("unco");       
		}
        if(pVOs.isExist("dcgm")) {//할인/감면내역   
			dcgmVO = pVOs.get("dcgm");        
		}
        if(pVOs.isExist("bogj")) {//보증금대체내역   
			bogjVO = pVOs.get("bogj");       
		}
        if(pVOs.isExist("bldc")) {//헌혈증할인내역 
			bldcVO = pVOs.get("bldc");       
		}
        if(pVOs.isExist("opmi")) {//외래수납시 등록내역조회
			otptVO = outrcptmngtDAO.getRcptOtptList(opmiVO);    
			
			/**2012-08-27 추가
			*외래수납시 유형변경시 경증상병환자 특례코드 자동입력로직 추가
			*원무팀요청. 건보정상일때 특례코드 자동입력.
			*원무공통코드사용(PK009) 체크대상 보험유형(CDNM)/ 보조유형관리(DETLDESC)
			*공통코드테이블(PMCMCODE), 특례마스터(PICMESSC), 상병마스터(EMR.MMOHDIAG) 체크해서
			*맞는 조건이 있으면 해당 특례코드를 otpt에 업데이트 한다. 
			*/
			if( otptVO.size() > 0 ){
				outrcptmngtDAO.setSpclcd(otptVO);    
				
				//throw new LiveException("New Test")	;
			}
		}

		ValueObjectAssembler retVOs = new ValueObjectAssembler ();  //수납결과 return할 VOs
		ValueObject trcptnoVO = new ValueObject();                  //영수증번호 채번 위한 input para VO
		ValueObject rcptnoVO  = null;
		ValueObject tmpOtpt   = new ValueObject ();                 //정산구분 체크위한 외래등록내역 VO
		
		try {
			
			int iRcptNo = 0;			
			
			//영수증번호 채번 위한 input para 세팅
			trcptnoVO.set("rcptdd", opmiVO.getString("opmi_rcptdd"));
			trcptnoVO.set("instcd", sInstCd);
			//영수증번호 채번-조건:발생일자
			rcptnoVO = getRcptNo(trcptnoVO);
			iRcptNo =  Integer.parseInt(rcptnoVO.getString("rcptno"));  //채번로직 Sequence
			
			//외래진료비 영수증번호, 영수증 일련번호(수납시에는 일련번호 1)
			opmiVO.set("opmi_rcptno"      , iRcptNo);
			opmiVO.set("opmi_rcptseqno"   , "1");
			opmiVO.set("opmi_rcptrid"     , sUserId);
			opmiVO.set("opmi_fstrgstrid"  , sUserId);
			opmiVO.set("opmi_lastupdtrid" , sUserId);
			opmiVO.set("sessinstcd"       , sInstCd);							 
			opmiVO.set("sessuserid"       , sUserId);

			opmiVO.set("opmi_orgorddd"    , otptVO.getString("orgorddd"));
			opmiVO.set("opmi_etcordflag"  , otptVO.getString("etcordflag"));
			
			//의사접수N이면 미수정산구분에 1A 접수 , Y이면 1B 수납
			if(StringHelper.strEquals(otptVO.getString("dracptyn"),"N")){
				opmiVO.set("opmi_uncorcptflag"       , "1A");
			}else{
				opmiVO.set("opmi_uncorcptflag"       , otptVO.getString("prcpgenryn"));
			}

			//수납내역 생성
			//---------------------------------------
			//해당 외래등록내역의 정산구분이 정산이면, 
			//해당 외래등록내역의 정산구분이 건별이면, outrcptmngtDAO.insOutOrdAmt
			//---------------------------------------
			//외래수납내역 조건으로 외래등록내역 조회
			tmpOtpt = outrcptmngtDAO.getOtptInfo2(opmiVO);

			//취소처리 케이스(수납전체크로직,수납,0원수납)
			//1.물리치료,주사예약이면서 진찰료미산정이고 처방 없는 경우
			//2.방사선종양학과이면서 진찰료미산정이고 처방없는경우
			//3.수납에서 강제로 취소한경우
            if ( (StringHelper.strEquals(tmpOtpt.getString("otpt_etcordflag"),"M")  && StringHelper.strEquals(tmpOtpt.getString("otpt_medamtestmyn"),"N")) ||

                 (StringHelper.strEquals(tmpOtpt.getString("otpt_etcordflag"),"J")   && StringHelper.strEquals(tmpOtpt.getString("otpt_medamtestmyn"),"N")) ||

                 (StringHelper.strEquals(tmpOtpt.getString("otpt_etcordflag"),"T")   && StringHelper.strEquals(tmpOtpt.getString("otpt_medamtestmyn"),"N")  && StringHelper.strEquals(tmpOtpt.getString("otpt_orddeptcd"),"2170000000")) ||

                 (StringHelper.strEquals(tmpOtpt.getString("otpt_rsrvflag"),"A")      && StringHelper.strEquals(tmpOtpt.getString("otpt_medamtestmyn"),"N")  && StringHelper.strEquals(tmpOtpt.getString("otpt_specordyn"),"N")) ||

                 (StringHelper.strEquals(opmiVO.getString("opmi_refundyn") ,"접수취소"))

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

			//미수입금분을 정산할때, 미수발생분을 정산할때 통계를 위해서 refundyn에 S 넣어줌
			if (StringHelper.strEquals(otpt_histstat,"R")                     && 
				StringHelper.strEquals(opmiVO.getString("opmi_refundyn"),"")  &&
			    !StringHelper.strEquals(outrcptmngtDAO.getUncoStatYCnt(opmiVO).getString("cnt"),"0")
			) {
				opmiVO.set("opmi_refundyn" ,"S");
			}

			//OPMI C,D생성
			opmiVO.set("otpt_histstat" , otpt_histstat);

			if (outrcptmngtDAO.insOutOrdAmtDC(opmiVO) <0) throw new LiveException("??insOutOrdAmt:insOutOrdAmtDC => opmi dc 생성 오류 ");   //D	
			if (outrcptmngtDAO.setOutOrdAmtC(opmiVO) <0)  throw new LiveException("??insOutOrdAmt:setOutOrdAmtC  => opmi y=>c 변경 오류 "); //C
			
			//OSCL C,D생성
			if (outrcptmngtDAO.insOSCLDC(opmiVO)<0) throw new LiveException("??  insOutOrdAmt: insOSCLDC => oscl dc 생성 오류 ");
			if (outrcptmngtDAO.setOSCLC(opmiVO) <0) throw new LiveException("??  insOutOrdAmt: setOSCLC  => oscl y=>c 변경 오류 ");
			
			//DCGM 할인/감액
			outrcptmngtDAO.insDcgmAmtDC(opmiVO);	//D
			outrcptmngtDAO.setDcgmAmtC(opmiVO);		//C
			
			//UNCO 미수
			outrcptmngtDAO.insUncoAmtDC(opmiVO);	//D
			outrcptmngtDAO.setUncoAmtC(opmiVO);		//C
			
			//BLDC 헌혈증
			outrcptmngtDAO.insBldcAmtDC(opmiVO);	//D
			outrcptmngtDAO.setBldcAmtC(opmiVO);		//C
			
			//CARD 카드금액
			outrcptmngtDAO.insCardAmtDC(opmiVO);	//D
			outrcptmngtDAO.setCardAmtC(opmiVO);		//C
	
			//CASH 현금영수증금액
			outrcptmngtDAO.insCashAmtDC(opmiVO);	//D
			outrcptmngtDAO.setCashAmtC(opmiVO);		//C

			//ONLN 통장입금액
			outrcptmngtDAO.insOnlnAmtDC(opmiVO);	//D
			outrcptmngtDAO.setOnlnAmtC(opmiVO);		//C
			
			//BOGJ 중간금액  선수금은 CD 안칩니다. SUM대 SUM으로만 보고..CD치면 선수금화면에도 이상하게 보입니다.
			//outrcptmngtDAO.insBogjAmtDC(opmiVO);	//D
			//outrcptmngtDAO.setBogjAmtC(opmiVO);	//C

			/////////실시정산시 재수납///////////
			/*
			if ( ptbsVO.isExist("workgubn") && StringHelper.strEquals(ptbsVO.getString("workgubn","") , "E")) {

					outrcptmngtDAO.insPreCashAmt(opmiVO);	//CASH 기현금영수증 재수납
					outrcptmngtDAO.insPreCardAmt(opmiVO);	//CARD 기카드 재수납
					outrcptmngtDAO.insPreBogjAmt(opmiVO);	//BOGJ 기중간금액 재수납
					
			}
			*/
			/////////실시정산시 끝///////////

			//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
			if ( log.isDebugEnabled() )  log.debug("**----외래등록/계산에 수납정보 update  start----**  " ); 
					
			opmiVO.set("otpt_histstat",otpt_histstat);  //접수상태도 취소건이있을수있기떄문에 보내야함
			setOutOrdAmtOsclOtpt(opmiVO);
			
			if("X".equals(otpt_histstat)){
                //동의서 삭제 START
        		ValueObject ocrprntVO = new ValueObject();
        		ocrprntVO.set("pid" 		, StringHelper.null2void(opmiVO.getString("opmi_pid")));
        		ocrprntVO.set("orddd" 		, StringHelper.null2void(opmiVO.getString("opmi_orddd")));
        		ocrprntVO.set("cretno" 		, StringHelper.null2void(opmiVO.getString("opmi_cretno")));
        		ocrprntVO.set("orddeptcd" 	, StringHelper.null2void(opmiVO.getString("opmi_orddeptcd")));
        		ocrprntVO.set("orddrid" 	, StringHelper.null2void(opmiVO.getString("opmi_orddrid")));
        		etcOutRgst.delOcrprntInfo(ocrprntVO);
                //동의서 삭제 END
			}
			

			if ( log.isDebugEnabled() ) log.debug("**----외래등록/계산내역에 수납정보 update  end----**  " );
			//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


			if(StringHelper.strEquals(otpt_histstat,"R")) {
	
	
				if ( log.isDebugEnabled() ) log.debug("**---- 신규 OPMI 처리  START----**  " );	
					if (outrcptmngtDAO.insOutOrdAmt(opmiVO) <=0) throw new LiveException("??insOutOrdAmt:insOutOrdAmt=> opmi y 내역 생성 오류 ");//Y
				if ( log.isDebugEnabled() ) log.debug("**---- 신규 OPMI 내역 처리  END----**  " );
		
				//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				if ( log.isDebugEnabled() ) log.debug("**---- 신규 CARD 내역 처리  START----**  " );
				
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
								//throw new LiveException("외래수납-카드수납 내역이 생성되지 않았습니다.[15022]");
						}
					}
	
			
				if ( log.isDebugEnabled() ) log.debug("**---- 신규 CARD 내역 처리  END----**  " );
				//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				if ( log.isDebugEnabled() ) log.debug("**---- 신규 CASH 내역 처리 START----**  " );
				
					//현금영수증
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
									throw new LiveException("외래수납-현금영수증수납 내역이 생성되지 않았습니다.[15023]");			
							}
					}
				if ( log.isDebugEnabled() ) log.debug("**---- 신규 CASH 내역 처리 END----**  " );
				//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				if ( log.isDebugEnabled() ) log.debug("**---- 신규 ONLINE 처리  START----**  " );	
		
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
								throw new LiveException("외래수납-통장입금 내역이 생성되지 않았습니다.[15021]");
						}
					}
	
				if ( log.isDebugEnabled() ) log.debug("**---- 신규 ONLINE 내역 처리  END----**  " );
				//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				if ( log.isDebugEnabled() ) log.debug("**---- 신규 UNCO 내역 처리  START----**  " );
				
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
								throw new LiveException("외래수납-미수 내역이 생성되지 않았습니다.[15024]");	
						}
	
						//미수입금액 orgrcptdd,orgrcptno 변경처리
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
						//미수입금액 orgrcptdd,orgrcptno 변경처리 끝					
					}
	
	                outrcptmngtDAO.setUncoEndApprsn(opmiVO);   //기수납금 처리된 미수건 사유정보에 업데이트
	
				if ( log.isDebugEnabled() ) log.debug("**---- 신규 UNCO 내역 처리  END----**  " );
				//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				if ( log.isDebugEnabled() ) log.debug("**---- 신규 DCGM 내역 처리  START----**  " );
					//감면
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
								throw new LiveException("외래수납-할인/감액 내역이 생성되지 않았습니다.[15025]");
						}
									
					}
				if ( log.isDebugEnabled() ) log.debug("**---- 신규 DCGM 내역 처리  END----**  " );
				//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				if ( log.isDebugEnabled() ) log.debug("**---- 신규 BLDC 내역 처리  START----**  " );
					//혈액감면
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
							throw new LiveException("외래수납-감액 내역이 생성되지 않았습니다.[15025]");
						}
							
					}
				if ( log.isDebugEnabled() ) log.debug("**---- 신규 BLDC 내역 처리  END----**  " );		
				
				if ( log.isDebugEnabled() ) log.debug("**----외래처방 수납상태 update  start----**  " );
				//+++++++++++++++++++++++++++++++++++++++++++++++
				setOutOrdStat(opmiVO);
				
	            //수납과 동시에 액팅해야 하는 처방 업데이트
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
	            //수납과 동시에 액팅해야 하는 처방 업데이트 끝
	
				//+++++++++++++++++++++++++++++++++++++++++++++++	
				if ( log.isDebugEnabled() ) log.debug("**----외래처방 수납상태 update  end----**  " );
	
				//원무공통코드 P0022 170 Y 의뢰서 체크(여의도)
				if (!StringHelper.strEquals(this.getPmcmCodeNm("P0022","170").getString("cdnm"),"Y")) {
		            ////////////////////////////////진료의뢰서 입력/////////////////////////////////
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
	            ////////////////////////////////진료의뢰서 입력끝/////////////////////////////////
			}
            //환불시에 선수금 입력하는 경우가 있어서 아래로 옮겼음 CYS 20100106
            //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            if ( log.isDebugEnabled() ) log.debug("**---- 신규 BOGJ 내역 처리  START----**  " );
                //선수금
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

                    //대체처리이므로 (-) 금액으로 변경 2007.10.10
                    lcashamt =  Long.parseLong(bogjVO.getString("cashamt"));
                    bogjVO.set("cashamt",  String.valueOf(lcashamt * -1) );

                    if (insMdlAmt(bogjVO) <= 0)
                        throw new LiveException("외래수납-대체 내역이 생성되지 않았습니다.[15026]");
                }
            if ( log.isDebugEnabled() ) log.debug("**---- 신규 BOGJ 내역 처리  END----**  " );
            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
			trcptnoVO.set("rcptno", iRcptNo);	   //수납처리가 성공하면, 영수증번호 update	
			outrcptmngtDAO.delOutOrdSmsq(opmiVO);  //문자메세지 이력 테이블 삭제
			

            opmiVO.set("pid"     , opmiVO.getString("opmi_pid"));   
            opmiVO.set("orddd"   , opmiVO.getString("opmi_orddd"));   
            opmiVO.set("cretno"  , opmiVO.getString("opmi_cretno"));  
			outrcptmngtDAO.setOutOrdEndMjqu(opmiVO);    //0원수납 대상 테이블 종료처리
			
			outrcptmngtDAO.setOPCGStat(opmiVO);    //과거처방반환, 대체처방 내역 table 수납 여부 상태 처리 
			
			

			//카드 밴 체크 테이블 인서트
			if(pVOs.isExist("ptbs")){
				if(StringHelper.strEquals(ptbsVO.getString("opt_cardck"), "Y")) {
					ValueObject logVO = new ValueObject();
					logVO.set("pid"          , opmiVO.getString("opmi_pid"));
					logVO.set("rcptdd"       , DateHelper.getDay());
					logVO.set("rcptno"       , iRcptNo);
					logVO.set("rcptseqno"    , "1");
					logVO.set("rcptflag"     , "PAOHOPMI");	//수납관련 테이블
					logVO.set("cardcashflag" , "A");			//카드
					etcOutRgst.insRcptVanLog(logVO);
				}
			}
		
			//Hold처방 있을 경우, 외래등록내역 추가 생성
			if ( log.isDebugEnabled() ) {
		   		 log.debug("**----opmi_rcptno=>----**  " + opmiVO.getString("opmi_rcptno") ); 
			}
		
			//외래수납 기본체크사항
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

			this.outOrd_Check(pVOs ,"수납" , sInstCd , sUserId);
			//외래수납 기본체크사항 끝


			//환불건 영수증발행 처리(연속처방시 날짜를 통으로 옮기고 otpt x처리하는 경우가있어서 추가합니다!)
			if(StringHelper.strEquals(opmiVO.getString("otpt_histstat"), "X")) {
				 opmiVO.set("opmi_rcptdd"    , opmiVO.getString("opmi_rcptdd_org"));   
				 opmiVO.set("opmi_rcptno"    , opmiVO.getString("opmi_rcptno_org")); 
				 opmiVO.set("opmi_rcptseqno" , "101");
				 opmiVO.set("opmi_orddd"     , opmiVO.getString("opmi_orddd_org"));
			}


			ValueObject msgVO   = new ValueObject();  //리턴메세지
			ValueObject pharmVO = new ValueObject();  //약국집계용 VO
			ValueObjectAssembler pharmVOs    = new ValueObjectAssembler();   //약국집계용 VOs
			ValueObjectAssembler retpharmVOs = new ValueObjectAssembler();   //약국집계용 return VOs
			ValueObject InAutoAssignVO  = new ValueObject();	             //자동방배정 VO

			//--------------------------------------------------약국집계------------------------------------------------------

			/*
			 * @ 필요파라미터
				pid, 
				orddd(actingorddd 절대 아님), 
				cretno,
				orddeptcd,
				orddrid,
				instcd,
				ioflag(입원/외래구분(I/O), 여기서는 "O"로 넣어줌)
				prcpgenrflag(찾기 힘들면 "O"로 넣어줌)
			 */
            //예약은 처방없으므로, 조회건수 0
            if (this.getOrddd(opmiVO).size() > 0) {

                if(log.isDebugEnabled()){log.debug("**----약국집계 호출시작 exeOutSum ------**");}

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
					throw new LiveException("약번호 생성시 오류발생하였습니다.");						
				}
				
				if(!StringHelper.strEquals(retpharmVOs.get("result").getString("outDrugNoMsg"),"")) {
					 msgVO.set("outdrugnomsg", retpharmVOs.get("result").getString("outDrugNoMsg"));
				}

				if(log.isDebugEnabled()){log.debug("**----약국집계 호출종료 exeOutSum ------** ");}


				if(log.isDebugEnabled()){log.debug("**----원외처방전 출력 ------**");}

					pharmVO.set("sessinstcd" , sInstCd);
					drugVO = outrcptmngtDAO.getHosoOutOrderList(pharmVO);    

				if(log.isDebugEnabled()){log.debug("**----원외처방전 출력종료 ------** ");}
				
			}
			//--------------------------------------------------약국집계끝------------------------------------------------------

			//--------------------------------------------------자동방배정------------------------------------------------------
			if(log.isDebugEnabled()){log.debug("**----자동방배정 호출시작 setAutoRoomAssignIF ------**");}
			
				InAutoAssignVO.set("pid"      , opmiVO.getString("opmi_pid"));
				InAutoAssignVO.set("orddd"    , opmiVO.getString("opmi_orddd"));
				InAutoAssignVO.set("cretno"   , opmiVO.getString("opmi_cretno"));
				InAutoAssignVO.set("ioflag"   , opmiVO.getString("opmi_ordtype"));					
				InAutoAssignVO.set("instcd"   , sInstCd);
				InAutoAssignVO.set("userid"   , sUserId);
				
				InAutoAssignVO.set("workflag" , "N");
			
				autoasslib.setAutoRoomAssignIF(InAutoAssignVO);						
			
			if(log.isDebugEnabled()){log.debug("**----자동방배정 호출종료 setAutoRoomAssignIF ------**");}
			//--------------------------------------------------자동방배정끝------------------------------------------------------

			if(msgVO.size() > 0) {
				retVOs.set("msg",msgVO); //약국집계시 리턴메세지있을시 화면으로 전달
			}

			retVOs.set("opmi",opmiVO);   //영수증출력위해 영수내역 return

			if(drugVO.size() > 0) {
				retVOs.set("drug",drugVO);   //원외처방전 출력
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
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getEarnInfo2(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getEarnInfo2(ValueObject pVO) throws LiveException{
		
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getEarnInfo2(pVO);
		
		
	}	
	

	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getEarnInfo3(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getEarnInfo3(ValueObject pVO) throws LiveException{
		
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getEarnInfo3(pVO);
		
		
	}		
	
	
	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getEarnInfo2(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getEarnInfo4(ValueObject pVO) throws LiveException{
		
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getEarnInfo4(pVO);
		
		
	}


	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getOtptInfo2(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOtptInfo2(ValueObject pVO) throws LiveException{
		
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getOtptInfo2(pVO);
		
	}	

	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getOtptInfo3(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOtptInfo3(ValueObject pVO) throws LiveException{
		
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getOtptInfo3(pVO);
		
	}	
	

	/*
	 * (비Javadoc)
	 * 환자처방조회(외래수납화면-처방홀드위해 처방조회)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getprcpList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getprcpList2(ValueObject pVO) throws LiveException{
		
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getprcpList2(pVO);
		
	}	

	/*
	 * (비Javadoc)
	 * 환자처방조회(외래수납화면-처방홀드위해 처방조회)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getprcpList(kr.co.hit.live.vo.ValueObject)
	 */
	 /*
	public ValueObject getholdDDList(ValueObject pVO) throws LiveException{
		
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getholdDDList(pVO);
		
	}
	*/

	/*
	 * (비Javadoc)
	 * 환자처방조회(외래수납화면-처방홀드위해 처방조회)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getprcpList(kr.co.hit.live.vo.ValueObject)
	 */
	 /*
	public ValueObject getholdList(ValueObject pVO) throws LiveException{
		
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getholdList(pVO);
		
	}	
	*/
	
	/*
	 * (비Javadoc)
	 * 중간금 수납처리
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
			
			//영수증번호 채번-조건:발생일자
			rcptnoVO = getRcptNo(bogjVO);
			
			//채번로직 변경 (테이블 => Sequence)
			iRcptNo =  Integer.parseInt(rcptnoVO.getString("rcptno"));
			
			//외래선수금 영수증번호
			bogjVO.set("rcptno",iRcptNo);			
			//수납시에는 일련번호 1
			bogjVO.set("rcptseqno","1");
			
			iCount1 = insMdlAmt(bogjVO);
			
			if (iCount1 <= 0) {
				throw new LiveException("외래선수금 내역이 생성되지 않았습니다.[15003]");
				
			}
			
			//////////////////////////////////////////통장입금///////////////////////////////////////////
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
						throw new LiveException("외래선수금-통장입금 내역이 생성되지 않았습니다.[15004]");		
				}
			}

			//////////////////////////////////////////통장입금끝///////////////////////////////////////////
					
			//////////////////////////////////////////카드///////////////////////////////////////////
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
						throw new LiveException("외래선수금-카드수납 내역이 생성되지 않았습니다.[15005]");	
				}
			}
			//////////////////////////////////////////카드끝///////////////////////////////////////////

			//////////////////////////////////////////현금영수증///////////////////////////////////////////
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
						throw new LiveException("외래선수금-현금영수증수납 내역이 생성되지 않았습니다.[15006]");			
				}
			}
			//////////////////////////////////////////현금영수증끝///////////////////////////////////////////

			//카드 밴 체크 테이블 인서트
			if(StringHelper.strEquals(pVOs.get("option").getString("cardck"), "Y")) {
				ValueObject logVO = new ValueObject();
				logVO.set("pid"             , bogjVO.getString("pid"));
				logVO.set("rcptdd"         , DateHelper.getDay());
				logVO.set("rcptno"         , iRcptNo);
				logVO.set("rcptseqno"    , "1");
				logVO.set("rcptflag"       , "PAOHBOGJ");	//수납관련 테이블
				logVO.set("cardcashflag", "A");			//카드
				etcOutRgst.insRcptVanLog(logVO);
			}

			// 클라이언트에 전달할 정상 처리 메시지 설정.
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
	 * (비Javadoc)
	 * 카드수납내역 생성
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#insCardAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insCardAmt(ValueObject pVO) throws LiveException {
		String sUserId = "";
		String sInstCd = "";
		int iCount = -1;
		int iCount2 = -1;
		String sallotmm = "";
		
		try {

			 //기관코드 조회
			if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
				pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
			}
			
			//사용자 조회
			if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
				pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
				
			}

			sInstCd = pVO.getString("sessinstcd");
			sUserId = pVO.getString("sessuserid");
		
			//최초등록자/최종수정자/기관코드 세팅
			pVO.set("fstrgstrid" , sUserId);
			pVO.set("lastupdtrid", sUserId);
			pVO.set("instcd"     , sInstCd);
			if (StringHelper.strEquals(pVO.getString("rcptrid"), "")) pVO.set("rcptrid",sUserId);
			
	        //이동재20080114 할부개월수 한자리 체크하여 두자리로 체워줌.
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
	 * (비Javadoc)
	 * 현금영수증 수납내역 생성
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#insCashAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insCashAmt(ValueObject pVO) throws LiveException {

        String sInstCd = "";
        String sUserId = "";

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
            
        }

        sInstCd = pVO.getString("sessinstcd");
        sUserId = pVO.getString("sessuserid");
		if (StringHelper.strEquals(pVO.getString("rcptrid"), "")) pVO.set("rcptrid",sUserId);
		
		return outrcptmngtDAO.insCashAmt(pVO);
	}

	/*
	 * (비Javadoc)
	 * 통장입금내역 생성
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#insOnlineAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insOnlineAmt(ValueObject pVO) throws LiveException {

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		//최초등록자/최종수정자/기관코드 세팅
		pVO.set("fstrgstrid" , pVO.getString("sessuserid"));
		pVO.set("lastupdtrid", pVO.getString("sessuserid"));
		pVO.set("instcd"     , pVO.getString("sessinstcd"));
		
		if (StringHelper.strEquals(pVO.getString("rcptrid"), "")) pVO.set("rcptrid",pVO.getString("sessuserid"));
		
		return outrcptmngtDAO.insOnlineAmt(pVO);
	}

	/*
	 * (비Javadoc)
	 * 현금영수증 수납내역 생성
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#insUncoAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insUncoAmt(ValueObject pVO) throws LiveException {

        String sInstCd = "";
        String sUserId = "";

		ValueObject Oscl_clincstdyno = new ValueObject();

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
            
        }

        sInstCd = pVO.getString("sessinstcd");
        sUserId = pVO.getString("sessuserid");
        
		pVO.set("fstrgstrid"  , sUserId);
		pVO.set("lastupdtrid" , sUserId);
		pVO.set("instcd"      , sInstCd);
		if (StringHelper.strEquals(pVO.getString("rcptrid"), "")) pVO.set("rcptrid",sUserId);

		//임상연구번호가 oscl에 있으면 가져온다.
		Oscl_clincstdyno = outrcptmngtDAO.getOscl_clincstdyno(pVO);

		if(Oscl_clincstdyno.size() > 0) {
			pVO.set("clincstdyno",Oscl_clincstdyno.getString("clincstdyno"));
		}
		//임상연구번호가져오기 끝

		return outrcptmngtDAO.insUncoAmt(pVO);
	}

	/*
	 * (비Javadoc)
	 * 현금영수증 수납내역 생성
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#insUncoAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insDcgmAmt(ValueObject pVO) throws LiveException {

        String sInstCd = "";
        String sUserId = "";

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
            
        }

        sInstCd = pVO.getString("sessinstcd");
        sUserId = pVO.getString("sessuserid");
		
		//최초등록자/최종수정자/기관코드 세팅
        pVO.set("fstrgstrid"  ,sUserId);
        pVO.set("lastupdtrid" ,sUserId);
        pVO.set("sessinstcd"  ,sInstCd);                           
        pVO.set("sessuserid"  ,sUserId);
		if (StringHelper.strEquals(pVO.getString("rcptrid"), "")) pVO.set("rcptrid",sUserId);
        
		return outrcptmngtDAO.insDcgmAmt(pVO);
	}
	
	
	/*
	 * (비Javadoc)
	 * 중간금 수납취소처리
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

			 //기관코드 조회
			 bogjVO.set("sessinstcd",sInstCd);
			 bogjVO.set("sessuserid", sUserId);
						
			iCount1 = insMdlAmtCncl(bogjVO);

			if (iCount1 <= 0) {
				//throw new LiveException("pam.error.15008");
				throw new LiveException("외래선수금 취소 오류.[15008]");				
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
					throw new LiveException("외래선수금-카드수납 취소 오류.[15010]");					
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
					throw new LiveException("외래선수금-현금영수증수납 취소 오류.[15011]");				
				}			
			}

            //onln
            if (onlnVO.size() > 0  ) {

                onlnVO.set("sessinstcd",sInstCd);
                onlnVO.set("sessuserid",sUserId);

                iCount2 = 0;
                iCount2 = insOnlineAmtCncl(onlnVO);

                if (iCount2 <= 0) {
                    throw new LiveException("외래선수금-통장입금 취소 오류.[15011]");
                }
            }

            //카드 밴 체크 테이블 인서트
            if(StringHelper.strEquals(pVOs.get("option").getString("cardck"), "Y")) {
                ValueObject logVO = new ValueObject();
                logVO.set("pid"            , bogjVO.getString("pid"));
                logVO.set("rcptdd"         , bogjVO.getString("rcptdd"));
                logVO.set("rcptno"         , bogjVO.getString("rcptno"));
                logVO.set("rcptseqno"      , bogjVO.getString("rcptseqno"));
                logVO.set("rcptflag"       , "PAOHBOGJ");   //수납관련 테이블
                logVO.set("cardcashflag"   , "A");          //카드
                etcOutRgst.insRcptVanLog(logVO);
            }

			// 클라이언트에 전달할 정상 처리 메시지 설정.
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
	
	/* 카드수납 취소내역 생성
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#insCardAmtCncl(kr.co.hit.live.vo.ValueObject)
	 */
	public int insCardAmtCncl(ValueObject pVO) throws LiveException {
		String sUserId = "";
		String sInstCd = "";
		
		int iCount = -1;
		
		try {

			 //기관코드 조회
			if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
				pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
			}
			
			//사용자 조회
			if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
				pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
				
			}

			sInstCd = pVO.getString("sessinstcd");
			sUserId = pVO.getString("sessuserid");
			
			//최초등록자/최종수정자/기관코드 세팅
			pVO.set("fstrgstrid", sUserId);
			pVO.set("lastupdtrid", sUserId);
			pVO.set("instcd",sInstCd);
			
			//수납자 세팅
			pVO.set("rcptrid",sUserId);
			
			//수납취소내역 rcptstat :D 데이터 생성
			iCount = -1;
			iCount = outrcptmngtDAO.insCardAmtCncl(pVO);
			
			if (iCount <= 0) {
				//throw new LiveException("pam.error.15012");
				throw new LiveException("외래선수금-카드수납 취소내역이 생성되지 않았습니다.[15016]");		
			}
			
			//원 수납내역 Y => C로 수정.
			iCount = -1;
			iCount=  outrcptmngtDAO.setCardAmt(pVO);
			
			if (iCount <= 0) {
				//throw new LiveException("pam.error.15013");
				throw new LiveException("외래선수금-카드수납 내역이 변경되지 않았습니다.[15017]");		
			}
		
		} catch (LiveException le) {
            throw le;
        } catch (Exception e) {
            throw new LiveException("com.error.90000", e);
        }	
		
		
		return iCount;
		  
		
	}
	
	/* 현금영수증승인 수납취소 내역 생성
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#insCashAmtCncl(kr.co.hit.live.vo.ValueObject)
	 */
	public int insCashAmtCncl(ValueObject pVO) throws LiveException {
		String sUserId = "";
		String sInstCd = "";
		
		int iCount = -1;
		
		try {

			 //기관코드 조회
			if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
				pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
			}
			
			//사용자 조회
			if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
				pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
				
			}

			sInstCd = pVO.getString("sessinstcd");
			sUserId = pVO.getString("sessuserid");
			
			//최초등록자/최종수정자/기관코드 세팅
			pVO.set("fstrgstrid", sUserId);
			pVO.set("lastupdtrid", sUserId);
			pVO.set("instcd",sInstCd);
			
			//수납자 세팅
			pVO.set("rcptrid",sUserId);
			
			//수납취소내역 rcptstat :D 데이터 생성
			iCount = -1;
			iCount = outrcptmngtDAO.insCashAmtCncl(pVO);
			
			if (iCount <= 0) {
				//throw new LiveException("pam.error.15012");
				throw new LiveException("외래선수금-현금영수증수납  취소내역이 생성되지 않았습니다.[15018]");		
			}
			
			//원 수납내역 Y => C로 수정
			iCount = -1;
			iCount=  outrcptmngtDAO.setCashAmt(pVO);
			
			if (iCount <= 0) {
				//throw new LiveException("pam.error.15013");
				throw new LiveException("외래선수금-현금영수증수납 내역이 변경되지 않았습니다.[15019]");		
			}
		
		} catch (LiveException le) {
            throw le;
        } catch (Exception e) {
            throw new LiveException("com.error.90000", e);
        }	
        
		return iCount;
		  
		
	}
		
	/* 
	 * (비Javadoc)
	 * 보험정보 이력 생성
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

			 //기관코드 조회.
			if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
				pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
			}
			
			//사용자 조회
			if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
				pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
			}

			sInstCd = pVO.getString("sessinstcd");
			sUserId = pVO.getString("sessuserid");

			//키값이 같은 내역 조회			
			tempVO = outrcptmngtDAO.getPtin1(pVO);
			
			if (tempVO.size() <= 0) {
				
				//신규생성
				iCount = -1;
				iCount = outrcptmngtDAO.insPtinHist(pVO);				
				
			}else {
			
			for( int i = 0; i < tempVO.size(); i++ ){
				
					String sToday = DateHelper.getCurrentDateAsString();
					String sFromDD = StringHelper.null2string(pVO.getString("ptin_fromdd"), sToday);
																
					//기존 보험유형의 시작일자가 새로운 보험유형의 시작일자보다 이전 일 때
						if( sFromDD.compareTo( StringHelper.null2void(tempVO.getString(i, "ptin_fromdd"))) > 0){
								
							//기존 보험유형을 (sFromDD - 1) 일자로 종료시킨다.
							tempVO.set(i, "ptin_todd"    , DateHelper.addDays(sFromDD, -1));
							tempVO.set(i, "sessinstcd"   , sInstCd);
							tempVO.set(i, "sessuserid"   , sUserId);
							row = outrcptmngtDAO.setPatInsu(tempVO.getRowAsVo(i));
							if (row < 1)
								throw new LiveException("이전 보험유형 수정 오류입니다!");
																			
						}else{
							
							//기존 보험유형을 이력 종료시킨다.
							tempVO.set(i, "ptin_histstat", "C");
							tempVO.set(i, "sessinstcd"   , sInstCd);
							tempVO.set(i, "sessuserid"   , sUserId);
							row = outrcptmngtDAO.setPatInsu(tempVO.getRowAsVo(i));
							if (row < 1)
								throw new LiveException("이전 보험유형 수정 오류입니다!");
												
						}
			}
	        	
	        	//신규 보험유형 저장
    			row = outrcptmngtDAO.insPatInsu(pVO);
                if (row < 1)
                    throw new LiveException("환자보험정보 입력 오류입니다!");
                
	
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

			 //기관코드 조회
			if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
				pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
			}
			
			//사용자 조회
			if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
				pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
			}

			sInstCd = pVO.getString("sessinstcd");
			sUserId = pVO.getString("sessuserid");
/*
            pVO.set("pid"                 ,pVO.getString("ptin_pid"));
			pVO.set("insukind"            ,pVO.getString("ptin_insukind"));                //보험유형
			pVO.set("suppkind"            ,pVO.getString("ptin_suppkind"));                //보조유형
			pVO.set("insucd"              ,pVO.getString("ptin_insucd"));                  //보험자코드
			pVO.set("suppkindresn"        ,pVO.getString("ptin_suppkindresn"));            //보조유형사유
			pVO.set("todd"                ,pVO.getString("ptin_todd"));                    //종료일자
			pVO.set("fromdd"              ,pVO.getString("ptin_fromdd"));                  //시작일자
			pVO.set("insuno"              ,pVO.getString("ptin_insuno"));                  //보험증번호
			pVO.set("insdnm"              ,pVO.getString("ptin_insdnm"));                  //피보험자명
			pVO.set("insdrrgstno1"        ,pVO.getString("ptin_insdrrgstno1"));            //피보험자주민번호1
			pVO.set("insdrrgstno2"        ,pVO.getString("ptin_insdrrgstno2"));            //피보험자주민번호2
			pVO.set("insdrela"            ,pVO.getString("ptin_insdrela"));                //피보험자관계

			
			pVO.set("insukind_org"        ,pVO.getString("ptin_insukind_org"));                //보험유형
			pVO.set("suppkind_org"        ,pVO.getString("ptin_suppkind_org"));                //보조유형
			pVO.set("insucd_org"          ,pVO.getString("ptin_insucd_org"));                  //보험자코드
			pVO.set("suppkindresn_org"    ,pVO.getString("ptin_suppkindresn_org"));            //보조유형사유
			pVO.set("todd_org"            ,pVO.getString("ptin_todd_org"));                    //종료일자
			pVO.set("fromdd_org"          ,pVO.getString("ptin_fromdd_org"));                  //시작일자
			pVO.set("insuno_org"          ,pVO.getString("ptin_insuno_org"));                  //보험증번호
			pVO.set("insdnm_org"          ,pVO.getString("ptin_insdnm_org"));                  //피보험자명
			pVO.set("insdrrgstno1_org"    ,pVO.getString("ptin_insdrrgstno1_org"));            //피보험자주민번호1
			pVO.set("insdrrgstno2_org"    ,pVO.getString("ptin_insdrrgstno2_org"));            //피보험자주민번호2
			pVO.set("insdrela_org"        ,pVO.getString("ptin_insdrela_org"));                //피보험자관계
*/


			String today = DateHelper.getDay();          //DateHelper.getDay();
			String bfday = DateHelper.addDays(today,-1);
			String nxday = DateHelper.addDays(today,+1);

			pVO.set("today"        ,today);
			pVO.set("bfday"        ,bfday);
			pVO.set("nxday"        ,nxday);
			pVO.set("maxseqno"     ,outrcptmngtDAO.getPtin_maxseqno(pVO).getString("maxseqno","1"));

			//같은 내역 조회			
			ptinVO_key = outrcptmngtDAO.getPtin1(pVO);
	
			if (ptinVO_key.size() == 0) {
				//신규생성
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

						throw new LiveException("보험정보 시작일이 미래일자입니다! 보험정보 시작일을 수정하십시오.");
					
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
	
    
	/* 환자진료의뢰내역 입력
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#setCnst(kr.co.hit.live.vo.ValueObject)
	 */	
    
	public void setCnst(ValueObjectAssembler pVOs) throws LiveException { 
		
		//기관코드 조회
		String sInstCd = "";
		String sUserId = "";

        ValueObject pVO = new ValueObject();
        ValueObject h_cnst = new ValueObject();

		pVO = pVOs.get("pVO");
        h_cnst = pVOs.get("cnst");

        try {

            if (h_cnst != null) {
        	
            	if (h_cnst.size() > 0){

					//기관코드 조회
					if (StringHelper.strEquals(h_cnst.getString("sessinstcd"), "")) {
						h_cnst.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
					}
					
					//사용자 조회
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
  
	/* Hold/Release 처리
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#setHoldPrcpList(kr.co.hit.live.vo.ValueObject)
	 */	
	public int setHoldPrcpList(ValueObject pVO) throws LiveException {
		
		int iCount = 0;
		int iCount2 = 0;
		
		try {
			
			String sInstCd = "";
			String sUserId = "";

			 //기관코드 조회
			if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
				pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
			}
			
			//사용자 조회
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
						
						//처방내역에 Hold/Release 정보 update
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
					
					//외래등록정보 홀드상태로 변경
					outrcptmngtDAO.setOtptHoldFlag(pVO);
					*/


					//Release 처리 후, 외래등록 생성
					//여기서 생성할  것인지, 홀드처리후 계산시 생성할 것인지 확인 필요
						
					//기존처방상태가 홀드 ==> Release
					//계산 후, 홀드 처리시에는 재계산해야하므로, Release시에만 처리하면 안됨..(막혀있었음)
					//if (StringHelper.strEquals(pVO.getString("prcp_preprcpstatcd"),"210")) {
					
					//이동재20071231 Hold 건있는 진료일에 대해서 이력발생이 필요없을꺼 같다.
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
	
	/*무인수납 환자 체크(환자기본정보에 대한 체크)
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getCheckPatInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getCheckPatInfo(ValueObject pVO) throws LiveException{
		
		//return VO
		ValueObject retVO = new ValueObject();
		
        String sInstCd = "";
        String sUserId = "";

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
            
        }

        sInstCd = pVO.getString("sessinstcd");
        sUserId = pVO.getString("sessuserid");
		
		
		retVO.set("error", "0000");
		
		//1. 재원중인지 체크
		if (StringHelper.strEquals(pVO.getString("inhospyn"), "Y")){
			retVO.set("error", "0100");
			retVO.set("errortype", "PAM");
			retVO.set("errormsg", "현재 입원중인 환자입니다.");
		}
		
		return retVO;
		
		
	}

	/*무인수납 환자 체크(외래등록정보에 대한 체크)
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getCheckOTPTInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getCheckOTPTInfo(ValueObject pVO) throws LiveException{

		//return VO
		ValueObject retVO = new ValueObject();
		
        String sInstCd = "";
        String sUserId = "";

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
            
        }

        sInstCd = pVO.getString("sessinstcd");
        sUserId = pVO.getString("sessuserid");
		
		retVO.set("error", "0000");
		
		//보험정보 건강보험,일반 이외의 내용은 수납불가
		for (int i = 0; i< pVO.size(); i++ ) {	
			
			if ( !StringHelper.strEquals(pVO.getString("otpt_insukind"), "11" ) &&
			 	 !StringHelper.strEquals(pVO.getString("otpt_insukind"), "51" )  ) {
				
				retVO.set("error", "0200");
				retVO.set("errortype", "PAM");
				retVO.set("errormsg", "수납창구에서 수납하십시요.(보험확인)");
				break;
				
			}			
		}		
		
		return retVO;
		
	}

	
	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getonlycvanList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getonlycvanList(ValueObject pVO) throws LiveException{

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
            
        }
		
		return outrcptmngtDAO.getonlycvanList(pVO);
		
	}

	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getupdtrateList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getupdtrateList(ValueObject pVO) throws LiveException{
		
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getupdtrateList(pVO);
		
	}
	
	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getupdtrateList1(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getupdtrateList1(ValueObject pVO) throws LiveException{
		
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getupdtrateList1(pVO);
		
	}	
	
	/* 요울변경내역조회(외래수납/정산화면) 
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#setupdtrateList(kr.co.hit.live.vo.ValueObject)
	 */	
	public int setupdtrateList(ValueObject pVO) throws LiveException {
		
		int iCount = 0;
						
		try {
			
			 //기관코드 조회
			if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
				pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
			}
			
			//사용자 조회
			if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
				pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
			}

			//이동재20080103 주과여부추가
			pVO.set("suppkindsubyn","Y"); 
			//기존내역 Histstat : R => C
			//pVO.set("histstat","C");			
			
			//이동재20080103 외래이력생성
			iCount =  outrcptmngtDAO.setupdtrateList(pVO);					

			//이동재20080103 기존이력 취소처리
			//iCount =  outrcptmngtDAO.insOtptHistSuppkindAdd(pVO);	
	
		
		} catch (LiveException le) {
            throw le;
        } catch (Exception e) {
            throw new LiveException("com.error.90000", e);
        }   
		
		return iCount;		
		
	}
	
	
	/*
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getEarnOsclInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getEarnOsclInfo(ValueObject pVO) throws LiveException{
		
        //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

		String otptkey ="";

		String calcflag = "";
		String calcstat = "";
				

	
				//작업구분 추가				
				pVO.set("calcstat", calcstat);

        for (int a = 0; a < pVO.size(); a++) {

			calcflag = pVO.getString(a,"calcflag");

				if (StringHelper.strEquals(calcflag,"N")) calcstat = "Y";   //정산
				if (StringHelper.strEquals(calcflag,"S")) calcstat = "R";	//수납
				if (StringHelper.strEquals(calcflag,"N") && 
					StringHelper.strEquals(pVO.getString(a,"holdflag"),"Y")
				   ) calcstat = "Y"; //수납이지만 처방홀드건

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

		//기관코드 조회
        sInstCd = StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE));

		//사용자 조회
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
        				throw new LiveException("외래의사처방 급비정보변경 오류!");						
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
     * 환자진료의뢰서 입력
     * 
     * @author cys
     * @param pVO ValueObject
     * @return ValueObjectAssembler
     * @throws LiveException
     */
    public int setOutOrdCnst(ValueObject pVO) throws LiveException {

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

        int retVO = 0;
		
		//건보면 insuflag 1로 세팅 급여면 2로 세팅.
		if(StringHelper.strEquals(pVO.getString("insukind"),"11")) { pVO.set("insuflag", "1");}
		if(StringHelper.strEquals(pVO.getString("insukind"),"21")) { pVO.set("insuflag", "2");}
		if(StringHelper.strEquals(pVO.getString("insukind"),"22")) { pVO.set("insuflag", "2");}
		
		//수납화면에 기타구분이 의뢰이면 3 아닐경우 1
		if(StringHelper.strEquals(pVO.getString("etcordflag"),"H")) { 
			pVO.set("ordreqkind", "3");
		}else{
			pVO.set("ordreqkind", "1");
		}
		
		if(StringHelper.strEquals(pVO.getString("insukind"),"11") ||
		   StringHelper.strEquals(pVO.getString("insukind"),"21") ||
			StringHelper.strEquals(pVO.getString("insukind"),"22") 		
		) {
			outrcptmngtDAO.insOutOrdCnst(pVO);  //수가코드변경 저장시 시행부서도 변경
		}

        return retVO;
    }


	/*
     * 외래급비변경
     * 외래미시행처방 미시행 오더 조회
     * @author cys
     * @param pVO ValueObject
     * @return ValueObjectAssembler
     * @throws LiveException
     */
	public ValueObject getOutUnExecPrcpOrdRef(ValueObject pVO) throws LiveException {
		
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

		ValueObject retVO = new ValueObject(); //결과 VO
        
        retVO = outrcptmngtDAO.getOutUnExecPrcpOrdRef(pVO);
        
        if (log.isInfoEnabled()) {
            log.info("MGR : getOutUnExecPrcpOrdRef() end..");       
        }
        
		return retVO;
	}
	
	
	
	public ValueObject getInUnExecPrcpOrdRef(ValueObject pVO) throws LiveException {
		
        //기관코드 조회
       if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
           pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
       }
       
       //사용자 조회
       if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
           pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
       }

		ValueObject retVO = new ValueObject(); //결과 VO
       
       retVO = outrcptmngtDAO.getInUnExecPrcpOrdRef(pVO);
       
       if (log.isInfoEnabled()) {
           log.info("MGR : getInUnExecPrcpOrdRef() end..");       
       }
       
		return retVO;
	}


	/*
     * 외래급비변경 
     * 외래미시행처방 환자 조회
     * @author cys
     * @param pVO ValueObject
     * @return ValueObjectAssembler
     * @throws LiveException
     */ 
	public ValueObject getPayPatInfo(ValueObject pVO) throws LiveException {

        //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

		ValueObject retVO = new ValueObject(); //결과 VO
		        
        retVO = outrcptmngtDAO.getPayPatInfo(pVO);
        
        if (log.isInfoEnabled()) {
            log.info("MGR : getPayPatInfo() end..");       
        }
        
		return retVO;
	}


	/*
     * 외래급비변경 
     * 외래미시행 처방 내역 조회
     * @author cys
     * @param pVO ValueObject
     * @return ValueObjectAssembler
     * @throws LiveException
     */ 
	public ValueObject getOutUnExecPrcpRef(ValueObject pVO) throws LiveException {

        //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

		ValueObject retVO = new ValueObject(); //결과 VO    
                
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

        //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

		ValueObject retVO = new ValueObject(); //결과 VO    
                
        retVO = outrcptmngtDAO.getInUnExecPrcpRef(pVO);
        
        if (log.isInfoEnabled()) {
            log.info("MGR : getInUnExecPrcpRef() end..");       
        }
        
		return retVO;
	}


	/*
     * 외래급비변경 
     * 외래미시행처방 미시행 오더 통합심사 완료 여부를 변경
     * @author cys
     * @param pVO ValueObject
     * @return ValueObjectAssembler
     * @throws LiveException
     */ 
	public int setJudgEnd(ValueObject pVO) throws LiveException {

		//기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
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
     * 외래급비변경 
     * 외래미시행처방 - 처방 급비구분코드 변경 처리
     * @author cys
     * @param pVO ValueObject
     * @return ValueObjectAssembler
     * @throws LiveException
     */
	public int setOrdPayFlag(ValueObject pVO) throws LiveException {

        String sInstCd = "";
        String sUserId = "";

		//기관코드 조회
        sInstCd = StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE));

		//사용자 조회
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

		//기관코드 조회
        sInstCd = StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE));

		//사용자 조회
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
     * 외래급비변경 
     * 외래미시행처방 미시행 오더 특정 내역을 삭제
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
			delVO.set("sessinstcd", sinstcd);           		//소속기관 코드
			rVO.addRow(i, delVO.getRow(0));
		}
		
		int count = 0;
		count = outrcptmngtDAO.delOutClcj(rVO);
		return count;
	}


	/*
     * 외래급비변경 
     * 외래미시행처방 미시행 오더 특정 내역을 추가
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
			insVO.set("sessinstcd"  , sinstcd);            //소속기관 코드
			insVO.set("sessuserid"  , userId);             // 최종수정자 사번 추가
			rVO.addRow(i, insVO.getRow(0));
		}
		
		int count = 0;
		count = outrcptmngtDAO.insOutClcj(rVO);
		return count;
	}


	/*
     * 외래급비변경 
     * 외래미시행처방 - 처방 급비구분코드 수정 후, 외래환자 접수 이력정보를 생성한다.
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
		
		pVO.set("sessinstcd", instcd);              // 기관코드 추가			
		pVO.set("sessuserid", userId);             	// 최초등록자
		
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
		
		pVO.set("sessinstcd", instcd);              // 기관코드 추가			
		pVO.set("sessuserid", userId);             	// 최초등록자
		
		count = outrcptmngtDAO.setInPatInfoHist(pVO);
		
		return count;
	}


	/*
     * 외래수납 계산취소 
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

         //기관코드 조회
        if (StringHelper.strEquals(otptVO.getString("sessinstcd"), "")) {
            otptVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(otptVO.getString("sessuserid"), "")) {
            otptVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
            
        }

		int count = 0;

        String sInstCd	= otptVO.getString("sessinstcd");
        String sUserId	= otptVO.getString("sessuserid");
		String workgubn = ptbsVO.getString("workgubn");            //수납화면:Y 정산화면:N

		otptVO.set("otpt_calcflag", otptVO.getString("otpt_calcflag_org"));

		if (StringHelper.strEquals(otpt_calcflag_org, "Y") || StringHelper.strEquals(otpt_calcflag_org, "S")) {
				otptVO.set("otpt_calcflag", "Y");
		}

		if (StringHelper.strEquals(otpt_calcflag_org, "N")){
				otptVO.set("otpt_calcflag", "N");
		}

		//만약 otpt_calcflag_org 값이 없을시 실행 혹시나 해서 넣어둠.
		if (StringHelper.strEquals(otptVO.getString("otpt_calcflag_org"), "")) {
				if(StringHelper.strEquals(workgubn,"Y")) otptVO.set("otpt_calcflag", "Y");  //외래수납, 계산취소
				if(StringHelper.strEquals(workgubn,"N")) otptVO.set("otpt_calcflag", "N");  //외래정산, 계산취소
		}

		ValueObject PreOtptVO  = outrcptmngtDAO.getPreOtptHist(otptVO);
		
		//////미수납 처방유무검색//////////////

		outrcptmngtDAO.setRollBackExop(otptVO); //수납상태값을 영수번호를 기준으로 업뎃

		if (StringHelper.strEquals(otptVO.getString("otpt_calcflag"), "N")) {

				otptVO.set("pid"         , otptVO.getString("otpt_pid"));
				otptVO.set("orddd"       , otptVO.getString("otpt_orddd"));
				otptVO.set("cretno"      , otptVO.getString("otpt_cretno"));
				otptVO.set("sessinstcd"  , sInstCd);
				unrcptVO = outrcptmngtDAO.getUnRcptExop(otptVO);

				if(unrcptVO.size() > 0) {
					otptVO.set("otpt_calcflag", "Y");  //미수납 처방이 있으면 무조건 수납대기에 띄운다.
				}
		}
		//////미수납 처방유무검색끝//////////////

		if(PreOtptVO.size() > 0) {

			PreOtptVO.set("otpt_orddd_old"   , PreOtptVO.getString("otpt_orddd"));
			PreOtptVO.set("otpt_cretno_old"  , PreOtptVO.getString("otpt_cretno"));
			PreOtptVO.set("sess_userid"      , sUserId);
			PreOtptVO.set("sessuserid"       , sUserId);
			PreOtptVO.set("sessinstcd"       , sInstCd);
			PreOtptVO.set("otpt_calcflag"    , otptVO.getString("otpt_calcflag"));
			PreOtptVO.set("otpt_holdflag"    , otptVO.getString("otpt_holdflag"));  //holdflag는 처방롤백완성 전까진 컬럼 롤백안한다.

			etcOutRgst.setOutAcpt(PreOtptVO);
		}else{
			outrcptmngtDAO.setOtptCalcflag(otptVO);
		}

			outrcptmngtDAO.delOsclCancel(otptVO);

		return count;
		
	}


    /*
     * 외래수납 
     * 2007.07.04. updated by 조영상
     * 환자기초정보
     * @param pVOs ValueObjectAssembler {}
     * @return ValueObjectAssembler
     * @throws LiveException
     */
    public ValueObjectAssembler getPidInfo(ValueObject pVO) throws LiveException {

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
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
             cshb = outrcptmngtDAO.getPidInfoCshb(pVO);   //현금영수증 디폴트 승인번호

			if (StringHelper.strEquals(workgubn, "Y")) {
				//당일 타과 02 03 04 내역 체크
				
				// 20090703 타과 요율변경
				RooaVOs = this.fUpdtRate_check(pVO);
				//dtrate = outrcptmngtDAO.getupdtrateList1(pVO);   //인공신장투석 환자 - 당일투석진료내역
				//updtrate = outrcptmngtDAO.getupdtrateList(pVO);  //인공신장투석 환자 - 요율변경내역 조회
				updtrate = RooaVOs.get("updtratelist");
				dtrate = RooaVOs.get("dtratelist");
				
			}

			 emrcnst = pamMgt.getOrdCnstInfo(pVO);

			 famylist = patInfoMngt.getFamyList(pVO);

			 //cvan = outrcptmngtDAO.getEmtyVanCk(pVO);              //VAN 이중승인 여부 체크

			 //mjqu = outrcptmngtDAO.getPopupMjquList(pVO);            //연속처방 수납대상 팝업 - 조회
			
			 pVO.set("mjqu_stat"  , "R");
			 //mjex = outrcptmngtDAO.getPopupMjexList(pVO);            //연속처방 수납대상 팝업 - 조회

			 inpt = outrcptmngtDAO.getInptInfo(pVO);                 //재원여부

			 inptc = outrcptmngtDAO.getInptInfo_c(pVO);             //가퇴원여부

			 dupVO = etcOutRgst.getDuplRgstHist(pVO);                //접수비중복체크

			 aipmicpm = pamMgt.getCheckAutoInduInsu(pVO);            //자보,산재 등록내역 시작일자,종료일자 조회
			
			 mediexamVO = outrcptmngtDAO.getCheckMediExamInfo(pVO);  //건강검진 내역 조회
            
             erpatVO = outrcptmngtDAO.getCheckERInfo(pVO);           //응급실 내원내역 조회

			 actrVO = outrcptmngtDAO.getPopupActrList(pVO);          //실시정산 대상환자 조회 

			 certVO = outrcptmngtDAO.getChkCertList(pVO);            //당일 수납할 재증명 유무체크

			if(outrcptmngtDAO.getMmsg2Check(pVO).size() > 0) {       //당일 자격조회 유무 체크
				proc.set("opt_procyn" , "Y");
			}else{
				proc.set("opt_procyn" , "N");
			}
			
			
			//20120309 M005, M006 본인부담의 경우 상병이 중증/희귀가 아닐경우 '-'로 업데이트
			//calcflag in ('S', 'Y') -- 수납대기
			//dracptyn = 'Y' --진료완료
			//ownbflag in ('M006', 'M005') --본인부담 M005, M006
			outrcptmngtDAO.setOwnbflagCheck(pVO);
			
			//예약건 계산호출
			otptVO = outrcptmngtDAO.getCallCalc_Otpt(pVO);

			for( int a =0; a< otptVO.size() ; a++) {
				
				//오늘 이전 이력은 재계산 하지 않고 미계산 상태로 만든다
				if( ! StringHelper.strEquals(otptVO.getString(a, "dayflag"), "P") ){
					try{
						
						//수납인지 실시정산인지 체크해서 계산한다.
						if(StringHelper.strEquals(otptVO.getString(a,"calcbaseflag"),"1")){
							outcalc.OutCalculation(otptVO.getRowAsVo(a));    //외래계산
						}else if(StringHelper.strEquals(otptVO.getString(a,"calcbaseflag"),"2")){
							outcalc.exeOutCalc(otptVO.getRowAsVo(a));        //실시정산
						}
						
						//계산 정상 완료 시 미수납 상태로 업데이트 한다.
						otptVO.set(a, "otpt_calcflag"  , "S");
						otptVO.set(a, "sessuserid"     , pVO.getString("sessuserid"));
						otptVO.set(a, "otpt_pid"        , otptVO.getString(a, "pid"));
						otptVO.set(a, "otpt_orddd"     , otptVO.getString(a, "orddd"));
						otptVO.set(a, "otpt_cretno"    , otptVO.getString(a, "cretno"));
						otptVO.set(a, "sessinstcd"      , pVO.getString("sessinstcd"));
						outrcptmngtDAO.setOtptCalcflag(otptVO.getRowAsVo(a));
						
					}catch (LiveException le) {
						
						//계산 중 오류 발생 시 미계산 상태로 업데이트 한다.
						otptVO.set(a, "otpt_calcflag"  , "Y");
						otptVO.set(a, "sessuserid"     , pVO.getString("sessuserid"));
						otptVO.set(a, "otpt_pid"        , otptVO.getString(a, "pid"));
						otptVO.set(a, "otpt_orddd"     , otptVO.getString(a, "orddd"));
						otptVO.set(a, "otpt_cretno"    , otptVO.getString(a, "cretno"));
						otptVO.set(a, "sessinstcd"      , pVO.getString("sessinstcd"));
						outrcptmngtDAO.setOtptCalcflag(otptVO.getRowAsVo(a));
					}
					
				}else{
					
					//과거 내역은 미계산으로 업데이트 한다. 수납시 재계산하도록 하기 위함.
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
			
			//예약건 계산호출 끝

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
		retVOs.set("charity"            ,  charityVO);	 //자선환자정보 조회
		retVOs.set("cert"				,  certVO);
        return retVOs;
    }

	/*
	 * (비Javadoc)
	 * 의사소견서관리팝업 조회
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.getDrcmList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getDrcmList(ValueObject pVO) throws LiveException{

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
		return outrcptmngtDAO.getDrcmList(pVO);
		
	}


	/*
	 * (비Javadoc)
	 * 의사소견서관리팝업 저장
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

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

        sInstCd = pVO.getString("sessinstcd");
        sUserId = pVO.getString("sessuserid");

        if(StringHelper.strEquals(pVO.getString("flag"), "insert")) {

            outrcptmngtDAO.delDrcmList(pVO);

            cnt = outrcptmngtDAO.insDrcmList(pVO);
            
            //의사소견서 수가코드를 구해온다.
            pVO.set("detldesc"  , "의사소견서");
            tempVO = outrcptmngtDAO.getPmcmCode(pVO);
            calcscorcd_drcm = tempVO.getString("cdnm","");

			//등록내역조회
			pVO.set("opmi_pid"      , pVO.getString("pid"));
			pVO.set("opmi_orddd"    , pVO.getString("orddd"));
			pVO.set("opmi_cretno"   , pVO.getString("cretno"));
			otptVO = outrcptmngtDAO.getRcptOtptList(pVO);

            //처방조회
            exopVO = outrcptmngtDAO.getExopList(pVO);

			for (int a=0; a< exopVO.size(); a++) {	

				if(StringHelper.strEquals(exopVO.getString(a,"calcscorcd"), calcscorcd_drcm)) drcm_exist = true;
				
			}

			if(exopVO.size() > 0 ) {

				//의사소견서 단일처방시 진찰료 면제로 셋팅
				if(drcm_exist && exopVO.size() == 1) {

					pVO.set("medamtestmyn"   , "N");
					pVO.set("medamtfreeresn" , "15");
					outrcptmngtDAO.setOtpt_drcm(pVO);
				}  

				//분업예외사유 정신과환자는 무조건 진찰료면제
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

		//의사소견서 저장후에는 계산 다시돌림
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
     * 외래수납계산 
     * 2007.07.07. updated by 조영상
     * 외래수납 디테일 테이블 가져오기
     * @param pVOs ValueObjectAssembler {}
     * @return ValueObjectAssembler
     * @throws LiveException
     */
    public ValueObject getOtptDetailTB(ValueObject pVO) throws LiveException {

		ValueObject retVO = new ValueObject();

		//기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
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
			
			//의사소견서///////////////////////////////////////////////
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
			//의사소견서 끝///////////////////////////////////////////////

			//방문간호지시서///////////////////////////////////////////////
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
			//방문간호지시서 끝///////////////////////////////////////////////

        } catch (LiveException le) {
            throw le;
        } catch (Exception e) {
            throw new LiveException("com.error.90000", e);
        }

        return retVO;
    }


    /*
	 * (비Javadoc)
	 * 방문간호지시서팝업 조회
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.getHocmList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getHocmList(ValueObject pVO) throws LiveException{

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
		return outrcptmngtDAO.getHocmList(pVO);
		
	}


	/*
	 * (비Javadoc)
	 * 방문간호지시서팝업 저장
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

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

        sInstCd = pVO.getString("sessinstcd");
        sUserId = pVO.getString("sessuserid");

		if(StringHelper.strEquals(pVO.getString("flag"), "insert")) {

			outrcptmngtDAO.delHocmList(pVO);

			cnt = outrcptmngtDAO.insHocmList(pVO);

            //방문간호지시서 수가코드를 구해온다.
            pVO.set("detldesc"  , "방문간호지시서");
            tempVO = outrcptmngtDAO.getPmcmCode(pVO);
            calcscorcd_hocm = tempVO.getString("cdnm","");

            //처방조회
            exopVO = outrcptmngtDAO.getExopList(pVO);
			
			/*
            int hocm_cnt = 0;
            
            //방문간호지시서 수가코드개수 조회
            for(int a = 0; a < exopVO.size(); a++){
                if(StringHelper.strEquals(exopVO.getString(a,"calcscorcd"), calcscorcd_hocm)) {
                    hocm_cnt = hocm_cnt + 1;
                }
            }
			*/

            //방문간호지시서 단일처방시 진찰료 면제로 셋팅
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
     * 의사면허번호조회
     * 2007.07.07. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getUsrdlicnsno(ValueObject pVO) throws LiveException{

		return outrcptmngtDAO.getUsrdlicnsno(pVO);
		
	}


	/*
     * 외래수납 
     * 2007.07.05. updated by 조영상
     * 외래수납 필수 체크사항
     * @param pVOs ValueObjectAssembler {}
     * @return ValueObjectAssembler
     * @throws LiveException
     */
    public ValueObject outOrd_Check(ValueObjectAssembler pVOs , String caller , String instcd , String userId) throws LiveException {

		// caller : 호출시점[접수선택,계산,수납전체크,수납]
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
		
		//20111024 선천성기능이상검사 미수 추가
		String msg_inbornuncocd    = "";
		String msg_inborndiscccd    = "";
		String msg_inbornuncoamt   = "0";
		String msg_inborndiscamt   = "0";
		
		String msg_drcm           = "";
		String msg_hocm           = "";
        String msg_etcm           = "";

         //기관코드 조회
        if (StringHelper.strEquals(instcd, "")) {
            instcd = StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE));
        }
        
        //사용자 조회
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
		
		//20111024 선천성대사이상검사 추가
		ValueObject inbornVO = new ValueObject();
		
        ValueObject etcmVO = new ValueObject();

		otpt   = pVOs.get("otpt");					  //외래등록정보

	    
		if(pVOs.isExist("oscl")) {
			oscl_org = pVOs.get("oscl");		      //외래계산정보
		}else{
			oscl_org = outrcptmngtDAO.getOsclInfo(otpt);
		}

		exop   = outrcptmngtDAO.getExopList(otpt);  //외래처방정보

		bldc   = pVOs.get("bldc");	 //혈액감면조회 

		//--------------기초코드--------------------------------------------
		temp.set("detldesc"  , "의사소견서");
		temp.set("sessinstcd", instcd);

		temp = outrcptmngtDAO.getPmcmCode(temp);

		//소견서 단일처방일 경우
		if(temp.size() == 0 ) {
			throw new LiveException("의사소견서 코드가 없습니다. 개발팀에 문의해서 pmcmcode테이블에 의사소견서코드가 있는지 문의하십시요");
		}

		calcscorcd_drcm = temp.getString("cdnm","");
		temp.clear();	

        //-------------------------------------------------------------------

		temp.set("detldesc"  , "방문간호지시서");
		temp.set("sessinstcd", instcd);

		temp = outrcptmngtDAO.getPmcmCode(temp);

		//소견서 단일처방일 경우
		if(temp.size() == 0 ) {
			throw new LiveException("방문간호지시서 코드가 없습니다. 개발팀에 문의해서 pmcmcode테이블에 방문간호지시서코드가 있는지 문의하십시요");
		}

		calcscorcd_hocm = temp.getString("cdnm","");
		temp.clear();

		//문진코드(ACD0002)있으면 의사소견서,방문간호지시서 체크하는데 힘들어서 뻅니다. 
		for(int a=0; a < oscl_org.size(); a++) {
			if(!StringHelper.strEquals(oscl_org.getString(a, "snglcalcscorcd"),this.getPmcmCodeNm("P0032","181").getString("cdnm"))) {
				int iLastRow1 = oscl.size();					 
				Map<String, Object> pMap1 = oscl_org.getRow(a);
				oscl.addRow(iLastRow1, pMap1);
			}
		}


		//--------------기초코드 끝-------------------------------------
        try { 

			if(oscl.size() > 0){

				for(int a=0; a < oscl.size(); a++) {

					//의약품관리료(AL501)는 체크 통과
					if (StringHelper.strEquals(oscl.getString(a, "snglcalcscorcd"),this.getPmcmCodeNm("P0032","182").getString("cdnm"))) {
						continue;
					}
					
					oscl.set(a, "sessinstcd" ,instcd);
					oscl.set(a, "sessuserid" ,userId);

					//약 반환이고 원내약국일시(당일 원외처방은 조건에서 제외) 0:원외1:기본2:가산있는행위3:가산없는행위4:재료5:위탁6:약제
					// 08/11/26 조영상 matractflag까지 체크했을때 조건에 안맞아서 통과시키는 경우가있어 제외시킴
				    if (StringHelper.strEquals(oscl.getString(a, "execprcphistcd"),"E")) {

						String sngcl = oscl.getString(a, "snglcalcscorcd");

						throw new LiveException("반납의뢰처방[ "+sngcl+" ]이 발생하였습니다. 해당부서[약국]에 반납하시고, 수납하셔야 합니다.");
					}
					
////////////////////////의사소견서 처리////////////////////////////
					//소견서 단일처방일 경우
					
					if (StringHelper.strEquals(oscl.getString(a, "snglcalcscorcd"), calcscorcd_drcm) && oscl.size() == 2
					){
						ValueObject drcm = outrcptmngtDAO.getDrcmList(oscl);  //의사소견서관리팝업 조회

						if(drcm.size() == 0 ) {
							throw new LiveException("의사소견서 단일처방이있습니다. 의사소견서 관리번호, 본인부담구분을 입력해주세요.");
						}

						if(StringHelper.strEquals(caller,"수납전체크")) {

							if(!StringHelper.strEquals(otpt.getString("medamtestmyn")  , "N") ||
							   !StringHelper.strEquals(otpt.getString("medamtfreeresn"), "15")	
							)  {
								throw new LiveException("의사소견서 단일처방이므로 진찰료산정여부: 면제 사유:의사소견서발급으로 세팅합니다.");
							}
						}
					}

					//소견서 및 기타처방이있는 경우
					if (StringHelper.strEquals(oscl.getString(a, "snglcalcscorcd"),calcscorcd_drcm) && oscl.size() > 2
					){
						ValueObject drcm = outrcptmngtDAO.getDrcmList(oscl);  //의사소견서관리팝업 조회
						
						if(drcm.size() == 0 ) {
							throw new LiveException("의사소견서처방이 있습니다. 의사소견서 관리번호, 본인부담구분을 입력해주세요.");
						}

						if(StringHelper.strEquals(caller,"수납전체크")) {
							if(StringHelper.strEquals(otpt.getString("medamtestmyn")  , "N")){
								msg_drcm = "의사소견서 및 타처방도 같이있습니다. 진찰료여부: 산정으로 변경하시겠습니까?";
							}
						}

					}
////////////////////////의사소견서 처리끝////////////////////////////

////////////////////////방문간호지시서 처리////////////////////////////
					//지시서 단일처방일 경우
					if (StringHelper.strEquals(oscl.getString(a, "snglcalcscorcd"), calcscorcd_hocm) && oscl.size() == 2
					){
						ValueObject hocm = outrcptmngtDAO.getHocmList(oscl);  //방문간호지시서 팝업 조회
						
						if(hocm.size() == 0 ) {
							throw new LiveException("방문간호지시서 단일처방이있습니다. 방문간호지시서 발급번호, 본인부담구분을 입력해주세요.");
						}

						if(StringHelper.strEquals(caller,"수납전체크")) {

							if(!StringHelper.strEquals(otpt.getString("medamtestmyn")  , "N") ||
							   !StringHelper.strEquals(otpt.getString("medamtfreeresn"), "16")	
							)  {
								throw new LiveException("방문간호지시서 단일처방이므로 진찰료산정여부: 면제 사유:방문간호지시서발급으로 세팅합니다.");
							}
						}
					}

					//지시서 및 기타처방이있는 경우
					if (StringHelper.strEquals(oscl.getString(a, "snglcalcscorcd"),calcscorcd_hocm) && oscl.size() > 2
					){
						ValueObject hocm = outrcptmngtDAO.getHocmList(oscl);  //방문간호지시서 팝업 조회
						
						if(hocm.size() == 0 ) {
							throw new LiveException("방문간호지시서 처방이있습니다. 방문간호지시서 발급번호, 본인부담구분을 입력해주세요.");
						}
					
						if(StringHelper.strEquals(caller,"수납전체크")) {

							if(StringHelper.strEquals(otpt.getString("medamtestmyn")  , "N")){
								msg_hocm = "방문간호지시서 및 타처방도 같이있습니다. 진찰료여부: 산정으로 변경하시겠습니까?";
							}
						}
					
					}
////////////////////////방문간호지시서 처리끝////////////////////////////
				}
			}


///////////////////////혈액대체처방 존재확인///////////////////////////////
					ValueObject bldc_temp = new ValueObject();
					bldc_temp = pamMgt.getBldcCalcList(otpt).get("bldc");

					if(bldc_temp.size() > 0 && StringHelper.strEquals(caller,"접수선택")) {
						msg                = "혈액대체처방존재" + '\n' + msg;
						msg_bldc           = "혈액대체처방존재";
					}
///////////////////////혈액대체처방 존재확인끝///////////////////////////////	


///////////////////////혈액대체처방 변경확인///////////////////////////////
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

					if(StringHelper.strEquals(bldc_ck, "N") && StringHelper.strEquals(caller, "수납")) {
						throw new LiveException("혈액대체건중 변경내역이 있습니다.");
					}
				
				}
			}
///////////////////////혈액대체처방 변경확인 끝///////////////////////////////

///////////////////////ASIS_TOBE 금액비교///////////////////////////////
		if(pVOs.isExist("oscl") && oscl.size() > 0 && StringHelper.strEquals(caller,"접수선택")){

			if(!StringHelper.strEquals(oscl.getString("asistobe"), null) && 
			   !StringHelper.strEquals(oscl.getString("asistobe"), "0")) {

				msg_compare_oscl = "ASIS 본인부담 :" + oscl.getString("asisamt") + " ,TOBE 본인부담 :" + oscl.getString("tobeamt") + 
								   " 차액 :" + oscl.getString("asistobe") + '\n' + "계속진행하시겠습니까?";
				msg_type         = "Q";
			}
		}
///////////////////////ASIS_TOBE 금액비교 끝///////////////////////////////

///////////////////////일반의-특진의 변경여부///////////////////////////////
		if(StringHelper.strEquals(caller,"접수선택")) {

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
							msg_specordyn ="해당의사가 일반의사에서 특진의사로 변경되었습니다. 소급처리하십시오.";
						}
						if(StringHelper.strEquals(otpt.getString("specordyn"), "Y")){
							msg_specordyn ="해당의사가 특진의사에서 일반의사로 변경되었습니다. 소급처리하십시오.";
						}
					}
			}
			
		}
///////////////////////일반의-특진의 변경여부 끝///////////////////////////////

///////////////////////접수취소 조건 맞는지 체크///////////////////////////////
		if(StringHelper.strEquals(caller,"계산")) {

//			if(StringHelper.strEquals(otpt.getString("refundyn"),"접수취소") &&  StringHelper.strEquals(otpt.getString("prcpgenryn"),"1A")) {
/*			if ( (StringHelper.strEquals(otpt.getString("etcordflag"),"M")  && StringHelper.strEquals(otpt.getString("medamtestmyn"),"N")) ||

	                 (StringHelper.strEquals(otpt.getString("etcordflag"),"J")   && StringHelper.strEquals(otpt.getString("medamtestmyn"),"N")) ||

	                 (StringHelper.strEquals(otpt.getString("etcordflag"),"T")   && StringHelper.strEquals(otpt.getString("medamtestmyn"),"N")  && StringHelper.strEquals(otpt.getString("orddeptcd"),"2170000000")) ||

	                 (StringHelper.strEquals(otpt.getString("rsrvflag"),"A")      && StringHelper.strEquals(otpt.getString("medamtestmyn"),"N")  && StringHelper.strEquals(otpt.getString("specordyn"),"N")) ||

	                 (StringHelper.strEquals(otpt.getString("refundyn") ,"접수취소"))
	        ) {*/
			if(StringHelper.strEquals(otpt.getString("refundyn"),"접수취소")) {

						 if( StringHelper.strEquals(otpt.getString("nursacptyn") , "Y")  ||   //간호접수여부
							 StringHelper.strEquals(otpt.getString("dracptyn")   , "Y")       //의사접수여부
						 ) {
							 throw new LiveException("접수취소할수 없습니다. 간호접수여부[ "+otpt.getString("nursacptyn")+" ],의사접수여부[ "+otpt.getString("dracptyn")+" ]");
						 }
			}
		}
///////////////////////접수취소 조건 맞는지 체크///////////////////////////////


///////////////////////정신과 환자 보조유형과 수급절차 안맞는 케이스 체크//////////////////////////////
		if(StringHelper.strEquals(caller,"접수선택")) {

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
					msg_mental = "정신과 정액환자인데 보조유형 정상으로 되어 있습니다. 정신과 정액으로 변경하셔야 합니다.\n진료일자 :" + msg_mental1 + "";
			}

			if(!StringHelper.strEquals(msg_mental2,"")) {
					msg_mental = "정신과 정액 대상 환자가 아닙니다. 보조유형 01 전액본인부담으로 변경하셔야 합니다.\n진료일자 :" + msg_mental2 + "";
			}

			if(!StringHelper.strEquals(msg_mental3,"")) {
					msg_mental = "정신과 정액 대상 환자가 아닙니다. 보조유형을 변경하셔야 합니다.\n진료일자 :" + msg_mental3 + "";
			}

		}
///////////////////////정신과 환자 보조유형과 수급절차 안맞는 케이스 체크 끝//////////////////////////////
		
		
		//미발행 원외처방 내역 체크 msg 처리 start
        //약국집계 로직 호출
		/*
		 * @ 필요파라미터
			pid, 
			orddd(actingorddd 절대 아님), 
			cretno,
			orddeptcd,
			orddrid,
			instcd,
			ioflag(입원/외래구분(I/O), 여기서는 "O"로 넣어줌)
			prcpgenrflag(찾기 힘들면 "O"로 넣어줌)
			
		*/
        String sToDay = DateHelper.getCurrentDateAsString();
        String sDrugMsg = "";
        //과거 일자것만 체크 하면 될듯함!
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
	        
            //ActingOrddd 가 아닌, Orddd 구하기
            //input : opmi_pid, opmi_orddd, opmi_cretno
            //tmpPharmVO = outrcptmngtDAO.getOrddd(drugVO);
            //if (tmpPharmVO.size() > 0) {

            //예약은 처방없으므로, 조회건수 0
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
			   		 log.debug("**----약국 처방 기간 체크 msg getOutDrugMsg Start------**  " );
				}
				
				drugVOs.set("req", drugVO);
				retDrugVOs = pharmlib.getOutDrugMsg(drugVOs);
				
				aaVO = retDrugVOs.get("result");
				
				
				if (aaVO.size() > 0) {
					if(!StringHelper.strEquals(StringHelper.null2void(aaVO.getString("outdrugmsg")),"")) {
						sDrugMsg = aaVO.getString("outdrugmsg");
					}
				}
				//sDrugMsg="진료로가서 약을 반환하던지 홀드하고 수납처리 하삼.";
				
				if ( log.isDebugEnabled() ) {
					log.debug("**---- 약국 처방 기간 체크 msg_drugmsg >" +  sDrugMsg);
			   		log.debug("**---- 약국 처방 기간 체크 msg getOutDrugMsg End------**  " );
				}
			}
        }
		//미발행 원외처방 내역 체크 msg 처리 end
		


       ///////////외국인 국적 체크//////////////
        String msg_oecdyn="";
        if(StringHelper.strEquals(caller,"접수선택")) {
	        if(StringHelper.strEquals(otpt.getString("insukind"),"51") || StringHelper.strEquals(otpt.getString("insukind"),"61")) {
		        if (StringHelper.strEquals(caller,"접수선택")) { 
		        	if (StringHelper.strEquals(this.getPmcmCodeNm("P0032","160").getString("cdnm"),"Y")) {
		        		ValueObject oecdVO  = outrcptmngtDAO.getPatOectChk(otpt);
		        		if (oecdVO.size() > 0) {
		        			String SNatiNM = StringHelper.null2void(oecdVO.getString("natinm"));
			        		if (StringHelper.strEquals(StringHelper.null2void(oecdVO.getString("oecdyn")),"Y")) {
			        			msg_oecdyn = SNatiNM + " OECD 회원국입니다. [61.외국인]유형으로 수납처리 하십시오.";
			        		} else {
			        			msg_oecdyn = SNatiNM + " OECD 비회원국입니다. [51.일반]유형으로 재계산 후 [61.외국인]유형으로 차액 감면처리 하십시오.";
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
       ///////////외국인 국적 체크 end//////////////

///////////////////////중증환자이고 중증번호 없는지 체크///////////////////////////////  의료급여만 체크????

		if(StringHelper.strEquals(caller,"수납")) {

				if(StringHelper.strEquals(otpt.getString("insukind"),"21") || StringHelper.strEquals(otpt.getString("insukind"),"22")) {
						
					if(StringHelper.strEquals(otpt.getString("suppkind"),"06")) {

							ValueObject srdgVO = new ValueObject();
							otpt.set( "sessinstcd" ,instcd);

                            srdgVO = outrcptmngtDAO.getSrdg(otpt);

                             if(srdgVO.size() == 0){
								  throw new LiveException("중증대상자인데 중증번호가 없습니다. 중증번호를 확인하십시요.");
							 }

                             if(StringHelper.strEquals(srdgVO.getString("srdg_seridiagno","")  , "0")) {
                                  throw new LiveException("중증대상자인데 중증번호가 없습니다. 중증번호를 확인하십시요.");
                             }
                             
					}
				}
		}
///////////////////////중증환자이고 중증번호 없는지 체크 끝///////////////////////////////

///////////////////////산정특례 대상이면서 수급절차 급여가능인환자 알림메세지/////////////////////////////// 희귀난치성산정특례 적용으로 기존 산정특례 의미가 없어짐.
		if(StringHelper.strEquals(caller,"계산")) {

				if( StringHelper.strEquals(otpt.getString("insukind"),"11")        &&
				    (StringHelper.strEquals(otpt.getString("suppkind"),"00") || StringHelper.strEquals(otpt.getString("suppkind"),"01")) &&
					StringHelper.strEquals(otpt.getString("ordreqformflag"),"3")  &&
					StringHelper.strEquals(otpt.getString("estmspclappyn"),"Y") &&
					!StringHelper.strEquals(otpt.getString("spclcd"),"-") 

				) {
					//msg_estm = "산정특례대상자 입니다. 보조유형을 산정특례로 변경하시겠습니까?";
				}
		}
///////////////////////산정특례 대상이면서 수급절차 급여가능인환자 알림메세지///////////////////////////////


///////////////////수급절차가 본인100%이면 보조유형은 전액본인부담만 된다.///////////////////////////////////
		if(StringHelper.strEquals(caller,"수납전체크")) {

				if( StringHelper.strEquals(otpt.getString("insukind"),"11") ||
                    StringHelper.strEquals(otpt.getString("insukind"),"21") ||
                    StringHelper.strEquals(otpt.getString("insukind"),"22")) {

                    if(StringHelper.strEquals(otpt.getString("ordreqformflag"),"2")) {

                        if(!StringHelper.strEquals(otpt.getString("suppkind"),"01")) {
                            throw new LiveException("수급절차가 본인희망100%일때 보조유형은 01 전액본인부담만 수납이 됩니다.[진료일:"+otpt.getString("orddd")+"]");
                        }  
                    }
                }
		}
///////////////////수급절차가 본인100%이면 보조유형은 전액본인부담체크 끝///////////////////////////////////


///////////////////////수납시 가로sum 체크///////////////////////////////

		if(StringHelper.strEquals(caller,"수납")) {

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
							throw new LiveException("수납금과 총본인부담금에 합계가 맞지않습니다. 개발팀에 문의하십시오.");
					}

				}
		}
///////////////////////수납시 가로sum 체크 끝///////////////////////////////////



////////////////////////B형 수직감염 처리(경북대 사용안함 20110401 cys)///////////////////////////////////////
/*
        ValueObject vtclck = new ValueObject();
        vtclck = outrcptmngtDAO.getVtcltrsCheck(otpt);  //원무공통코드 pmcmcode P0005

        if(vtclck.size() > 0 && StringHelper.strEquals(caller,"접수선택")) {
            msg_vtclck         = "B형수직감염";
            msg_vtclck_uncoamt = vtclck.getString("vtclck_uncoamt");
            msg_vtclck_uncocd  = vtclck.getString("vtclck_uncocd");
            msg_vtclck_unconm  = vtclck.getString("vtclck_unconm");
            msg                = "B형수직감염" + '\n' + msg;

        }
*/
////////////////////////B형 수직감염 처리끝/////////////////////////////////////

///////////////////////성가병원 예방접종미수 체크///////////////////////////////

		if(!StringHelper.strEquals(caller,"수납")) {

			prvntmedVO = outrcptmngtDAO.getPrvntMedc(otpt);
			if (prvntmedVO.size() > 0) {
				msg_prvntmedcamt = prvntmedVO.getString("discamt");	    //미수
				msg_prvntmedcdiscamt = prvntmedVO.getString("reduamt");	//감면

				if(!StringHelper.strEquals(msg_prvntmedcamt,"0")) {
					msg_prvntmedccd  = this.getPmcmCodeNm("P0072","10").getString("cdnm");
				}

				if(!StringHelper.strEquals(msg_prvntmedcdiscamt,"0")) {
					msg_prvntmeddiscccd  = this.getPmcmCodeNm("P0072","20").getString("cdnm");
				}
			}

		}
///////////////////////성가병원 예방접종미수 체크 끝///////////////////////////////
		
///////////////////////경대병원 선천성대사이상검사 미수 체크///////////////////////////////
//2011-10-21 원무 이선희 선생님 요청사항
		if(!StringHelper.strEquals(caller,"수납")) {
		
			inbornVO = outrcptmngtDAO.getInbornError(otpt);
			if (inbornVO.size() > 0) {
				msg_inbornuncoamt = inbornVO.getString("discamt");	    //미수
				msg_inborndiscamt = inbornVO.getString("reduamt");	//감면
			
				if(!StringHelper.strEquals(msg_inbornuncoamt,"0")) {
					msg_inbornuncocd  = this.getPmcmCodeNm("P0104","10").getString("cdnm");
				}
			
				if(!StringHelper.strEquals(msg_inborndiscamt,"0")) {
					msg_inborndiscccd  = this.getPmcmCodeNm("P0104","20").getString("cdnm");
				}
			}
		
		}
///////////////////////경대병원 선천성대사이상검사 미수 체크///////////////////////////////

///////////////////////재활의학과 미예약환자 경고메세지 체크///////////////////////////////
		if(StringHelper.strEquals(caller,"접수선택") || StringHelper.strEquals(caller,"수납전체크")) {

			etcmVO = outrcptmngtDAO.getChkEtcM(otpt);
			if (etcmVO.size() > 0) {
                    msg_etcm =  "[진료일자 :" + etcmVO.getString("actorddd") + " 처방일 :" + etcmVO.getString("prcpdd") + " 물리치료 예약일 미지정]" + '\n' +
                    "\n반드시 치료실(재활치료실, 언어치료실)에서 예약을 잡으신 후 수납할 수 있도록 안내하십시오\n";
			}
		}
///////////////////////재활의학과 미예약환자 경고메세지 체크끝///////////////////////////////

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
        
        //20111024 선천성대사이상검사 미수 추가
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
     * 자보한도환자분리팝업
     * 외래등록내역조회.
     * @author cys
     * @param pVOs ValueObject
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getOtptCarInsu(ValueObject pVO) throws LiveException{

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

		//계산내역에 대한 진료비정보 조회		
		return outrcptmngtDAO.getOtptCarInsu(pVO);
		
	}


    /*
     * 자보한도환자분리팝업
     * 처방내역조회
     * @author cys
     * @param pVOs ValueObject
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getOprcCarInsu(ValueObject pVO) throws LiveException{

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
	
		return outrcptmngtDAO.getOprcCarInsu(pVO);
		
	}

    /*
     * 자보한도환자분리팝업
     * 처방내역분리
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

		outrcptmngtDAO.setOprcCarInsu(pVO); //외래처방 부유형 분리

		outrcptmngtDAO.setOtptCarFlag(pVO); //외래등록 미계산상태로 변경

		return pVO;
		
	}

	/**
	 * 외래수납 2008/1/23 조영상
	 * 정산 수납내역 클릭시 수납내역조회
	 * @author cys
	 * @param pVOs ValueObject
	 * @return ValueObject
	 * @throws LiveException
	 */
    public ValueObject getOutJOpmiList(ValueObject pVO) throws LiveException{
        
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
        String OtptKey = "";
		
		//vo배열 2이상 일시 OtptKey 추출
		if(pVO.size() > 1) {
			for (int a = 0; a < pVO.size(); a++) {
				OtptKey = pVO.getString(a, "orddd") + pVO.getString(a, "orddrid")+ "','" + OtptKey;
			}

		pVO = pVO.getRowAsVo(0);
        pVO.set("OtptKey" , OtptKey);

		}
		//OtptKey 추출 끝
  
        return outrcptmngtDAO.getOutJOpmiList(pVO);

    }

	/* 다른 사용자에의해 데이터가 변했으면 실행취소
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getEarnInfo2(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOtptMaxAcptseqno(ValueObject pVO) throws LiveException{
		
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getOtptMaxAcptseqno(pVO);
		
	}

	/**
	 * 외래수납 2008/9/17 조영상
	 * 건강생활유지비조회
	 * @author cys
	 * @param pVOs ValueObjectAssembler
	 * @return ValueObjectAssembler
	 * @throws LiveException
	 */
	public ValueObject getMsg4LifeAmt(ValueObject pVO) throws LiveException{
		
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
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

	/*카드수납내역 조회
	 * (비Javadoc)
	 * 
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getcardList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getcardList(ValueObject pVO) throws LiveException {

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
            
        }
		
		return outrcptmngtDAO.getcardList(pVO);
	}

	/*
	 * (비Javadoc)
	 * 현금영수증 수납내역 조회
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getcashList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getcashList(ValueObject pVO) throws LiveException {
		
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getcashList(pVO);
	}

	/*
	 * (비Javadoc)
	 * 통장입금(온라인수납) 내역 조회
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getonlnList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getonlnList(ValueObject pVO) throws LiveException {
		
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getonlnList(pVO);
	}
	

	/*
	 * (비Javadoc)
	 * 수혈대체(기수혈대체) 내역 조회
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getbldcList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getbldcList(ValueObject pVO) throws LiveException {
		
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getbldcList(pVO);
	}

	/*
	 * (비Javadoc)
	 * 기 감면내역조회
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getdcgmList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getdcgmList(ValueObject pVO) throws LiveException {
		
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getdcgmList(pVO);
	}

	/*
	 * (비Javadoc)
	 * 기 미수내역조회
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getdcgmList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getuncoList(ValueObject pVO) throws LiveException {
		
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getuncoList(pVO);
	}

	/**
	 * 외래수납 2008/9/22 조영상
	 * 환자재원정보
	 * @author cys
	 * @param pVOs ValueObject
	 * @return ValueObject
	 * @throws LiveException
	 */
	 /*
	public ValueObject getInptInfo(ValueObject pVO) throws LiveException {
		
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getInptInfo(pVO);
	}
	*/

	/*
     * 외래수납 중증시 보조유형변경
     * 2008.09.23. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int setOtptSrdg(ValueObject pVO) throws LiveException {
		

        for (int a = 0; a < pVO.size(); a++) {

            //기관코드 조회
            if (StringHelper.strEquals(pVO.getString(a, "sessinstcd"), "")) {
                pVO.set(a, "sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
            }
            
            //사용자 조회
            if (StringHelper.strEquals(pVO.getString(a, "sessuserid"), "")) {
                pVO.set(a, "sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
            }

        }
		
		return outrcptmngtDAO.setOtptSrdg(pVO);
	}

	/*
     * 외래수납 산정특례시 보조유형변경
     * 2008.09.23. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int setOtptEstm(ValueObject pVO) throws LiveException {
		

        for (int a = 0; a < pVO.size(); a++) {

            //기관코드 조회
            if (StringHelper.strEquals(pVO.getString(a, "sessinstcd"), "")) {
                pVO.set(a, "sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
            }
            
            //사용자 조회
            if (StringHelper.strEquals(pVO.getString(a, "sessuserid"), "")) {
                pVO.set(a, "sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
            }

        }
		
		return outrcptmngtDAO.setOtptEstm(pVO);
	}

	/*
     * 외래수납 환자 인적정보 변경
     * 2008.11.20. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int setPtbsInfo(ValueObject pVO) throws LiveException {
		
		//기관코드 조회
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//사용자 조회
		if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
			pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
		}
		
		return outrcptmngtDAO.setPtbsInfo(pVO);
	}

	/* 처방변경내역조회 팝업 
     * OSCL의 Y(수납),R(계산) 내역 조회 
     * @author 이성인 
     * @param pVOs ValueObject
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getOsclRY(ValueObject pVO) throws LiveException {
		//기관코드 조회
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}

		return outrcptmngtDAO.getOsclRY(pVO);
	}

	//0원 수납 인터페이스 - 진료비0원인지 체크
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

		//기관코드 조회
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//사용자 조회
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
						outcalc.OutCalculation(otptVO.getRowAsVo(a));    //외래계산
					}
					if(StringHelper.strEquals(otptVO.getString(a,"calcbaseflag"),"2")){
						outcalc.exeOutCalc(otptVO.getRowAsVo(a));        //실시정산
					}
				}
		}

		//입원덤프에서 호출 - 2개이상에 opmi를 하나로 합치기위해 기존 Y건을 R로 생성
		if (StringHelper.strEquals(calc_run_flag, "false")) {
		
			for( int a =0; a< otptVO.size() ; a++) {	
					outrcptmngtDAO.delOsclCancel(otptVO);      // 계산에서 생성된 R건 삭제
					outrcptmngtDAO.setOsclY_dump(otptVO);    // 기존 Y건을 R로 재생성
			}
		
		}

		for( int a =0; a< otptVO.size() ; a++) {
			
			ptinVO.set("insukind"   , otptVO.getString(a,"insukind"));
			ptinVO.set("suppkind"   , otptVO.getString(a,"suppkind"));
			ptinVO.set("insucd"     , otptVO.getString(a,"insucd"));
			
			pVOs.set("ptin" , ptinVO);
			pVOs.set("otpt" , otptVO.getRowAsVo(a));

			tempVO = getOpmiInfo(pVOs,"0원수납");     //수납할 금액 조회 

			Map<String, Object> pMap1 = tempVO.getRow(0);
			opmiVO.addRow(opmiVO.size(), pMap1);
		}

		for( int a =0; a< opmiVO.size() ; a++) {
			sum_opmi = Integer.parseInt( opmiVO.getString(a, "opmi_rcptexptamt") ) + sum_opmi ;
		}

			//if(sum_opmi != 0) { bl_trn = false; }

		return sum_opmi;
	}

	//0원 수납 인터페이스 - 0원 수납처리
	public int setIFOAmtZeroRcpt(ValueObject pVO , String sUserId) throws LiveException {

	   String sInstCd = StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE));   //기관코드 조회
       
	    //사용자 조회 
	   if(StringHelper.strEquals(sUserId,"")) { 
		   sUserId = StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)); 
	   }
	    
	   String sUserId_real = StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)); 

	   String otptkey = "";
	   String otpt_histstat = "";
	   String opmi_refundyn = "";
	   int    dcgmVO_size   = 0;

        //외래등록
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


            //취소처리 케이스(수납전체크로직,수납,0원수납)
            //1.물리치료,주사예약이면서 진찰료미산정이고 처방 없는 경우
            //2.방사선종양학과이면서 진찰료미산정이고 처방없는경우
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
 
			//수납순번 채번
			int iRcptNo = 0;		

			ValueObject rcptnoVO = getRcptNo(otptVO);
			otptVO.set("rcptno_new" , (rcptnoVO.getInt("rcptno")));    
			ptinVO.set("temp"       ,"");
            ptinVO.set("insukind"   , otptVO.getString("insukind"));
            ptinVO.set("suppkind"   , otptVO.getString("suppkind"));
            ptinVO.set("insucd"     , otptVO.getString("insucd"));

			pVOs.set("otpt" , otptVO);
			pVOs.set("ptin" , ptinVO); 	

			tempVO = getOpmiInfo(pVOs,"0원수납");     //수납할 금액 조회
			
			//의사접수N이면 미수정산구분에 1A 접수 , Y이면 1B 수납
			if(StringHelper.strEquals(otptVO.getString("dracptyn"),"N")){
				tempVO.set("opmi_uncorcptflag"       , "1A");
			}else{
				tempVO.set("opmi_uncorcptflag"       , otptVO.getString("prcpgenryn"));
			}

			tempVO.set("sessinstcd"        , sInstCd); 
			tempVO.set("sessuserid"        , sUserId_real);
			
			
			//미수입금분을 정산할때, 미수발생분을 정산할때 통계를 위해서 refundyn에 S 넣어줌
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

				tempVO.set("opmi_remfact"      , "0원수납");
			}else{
				tempVO.set("opmi_remfact"      , "요율변경환불");
			}


			ValueObject cardVO  = new ValueObject();
			cardVO = outrcptmngtDAO.getcardList(tempVO);

			ValueObject cashVO  = new ValueObject();
			cashVO = outrcptmngtDAO.getcashList(tempVO);

            ValueObject onlnVO  = new ValueObject();    
            onlnVO = outrcptmngtDAO.getonlnList(tempVO);

			ValueObject uncoVO  = new ValueObject();
			uncoVO = outrcptmngtDAO.getuncoList2(tempVO);

			//임의감면
			ValueObject dcgmVO  = new ValueObject();
			dcgmVO = outrcptmngtDAO.getdcgmList(tempVO);
			//dcgmVO = outrcptmngtDAO.getdcgmList_zero(tempVO);  //계정감면, 임의감면 구분없이 넣기위해 사용

			//계정감면
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
			//계정감면 끝

			ValueObject bldcVO  = new ValueObject();
			bldcVO = outrcptmngtDAO.getbldcList(tempVO);


			//OPMI C,D생성
			if (outrcptmngtDAO.insOutOrdAmtDC(tempVO) <0) throw new LiveException("??insOutOrdAmt:insOutOrdAmtDC => opmi dc 생성 오류 ");   //D	
			if (outrcptmngtDAO.setOutOrdAmtC(otptVO) <0)  throw new LiveException("??insOutOrdAmt:setOutOrdAmtC  => opmi y=>c 변경 오류 "); //C
			
			//OSCL C,D생성
			if (outrcptmngtDAO.insOSCLDC(otptVO)<0) throw new LiveException("??  insOutOrdAmt: insOSCLDC => oscl dc 생성 오류 ");
			if (outrcptmngtDAO.setOSCLC(otptVO) <0) throw new LiveException("??  insOutOrdAmt: setOSCLC  => oscl y=>c 변경 오류 ");

			//CARD 카드금액
			outrcptmngtDAO.insCardAmtDC(otptVO);	  //D
			outrcptmngtDAO.setCardAmtC(otptVO);		  //C

			//CASH 현금영수증금액
			outrcptmngtDAO.insCashAmtDC(otptVO);	  //D
			outrcptmngtDAO.setCashAmtC(otptVO);		  //C

            //ONLN 통장입금액
            outrcptmngtDAO.insOnlnAmtDC(otptVO);       //D
            outrcptmngtDAO.setOnlnAmtC(otptVO);        //C

			//UNCO 미수
			outrcptmngtDAO.insUncoAmtDC(otptVO);	   //D
			outrcptmngtDAO.setUncoAmtC(otptVO);	       //C

			//DCGM 할인/감액
			outrcptmngtDAO.insDcgmAmtDC(otptVO);	   //D
			outrcptmngtDAO.setDcgmAmtC(otptVO);	       //C

			//BLDC 헌혈증
			outrcptmngtDAO.insBldcAmtDC(otptVO);	   //D
			outrcptmngtDAO.setBldcAmtC(otptVO);		   //C

			//OSCL Y생성
			//outrcptmngtDAO.setOutOrdAmtOscl(tempVO);  
			setOutOrdAmtOsclOtpt(tempVO);

	if(!StringHelper.strEquals(otpt_histstat,"X")){

			//OPMI Y생성
			if (outrcptmngtDAO.insOutOrdAmt(tempVO) <=0) throw new LiveException("??insOutOrdAmt:insOutOrdAmt=> opmi y 내역 생성 오류 ");//Y
			
			//CARD 카드금액
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
			
			//CASH 현금영수증금액
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

            //ONLN 통장입금액
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

			//UNCO 미수
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

			//DCGM 할인/감액
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
			
			//BLDC 헌혈증
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
			
            if ( log.isDebugEnabled() ) log.debug("**----외래처방 수납상태 update  start----**  " );
            //+++++++++++++++++++++++++++++++++++++++++++++++
            setOutOrdStat(tempVO);
            
            //수납과 동시에 액팅해야 하는 처방 업데이트
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
            //수납과 동시에 액팅해야 하는 처방 업데이트 끝

            //+++++++++++++++++++++++++++++++++++++++++++++++   
            if ( log.isDebugEnabled() ) log.debug("**----외래처방 수납상태 update  end----**  " );


	}

			/////////////////////////////////////////0원수납 대상 테이블 종료처리//////////////////////////////////
			outrcptmngtDAO.setOutOrdEndMjqu(otptVO);  
			/////////////////////////////////////////0원수납 대상 테이블 종료처리 끝///////////////////////////////
			

			//서버예외처리
			ValueObjectAssembler chkVOs = new ValueObjectAssembler();
			chkVOs.set("otpt", otptVO);
			this.outOrd_Check(chkVOs , "수납" ,sInstCd , sUserId);  //외래수납 기본사항 체크



			ValueObject msgVO   = new ValueObject();  //리턴메세지
			ValueObject pharmVO = new ValueObject();  //약국집계용 VO
			ValueObjectAssembler pharmVOs    = new ValueObjectAssembler();   //약국집계용 VOs
			ValueObjectAssembler retpharmVOs = new ValueObjectAssembler();   //약국집계용 return VOs
			ValueObject InAutoAssignVO  = new ValueObject();	             //자동방배정 VO

			//--------------------------------------------------약국집계------------------------------------------------------

            /*
             * @ 필요파라미터
                pid,
                orddd(actingorddd 절대 아님),
                cretno,
                orddeptcd,
                orddrid,
                instcd,
                ioflag(입원/외래구분(I/O), 여기서는 "O"로 넣어줌)
                prcpgenrflag(찾기 힘들면 "O"로 넣어줌)
             */
            //예약은 처방없으므로, 조회건수 0
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

				if(log.isDebugEnabled()){log.debug("**----약국집계 호출시작 exeOutSum ------**");}
				
				pharmVOs.set("req", pharmVO);
				retpharmVOs = pharmlib.exeOutSum(pharmVOs);	

				if (retpharmVOs.size() < 0) {
					throw new LiveException("약번호 생성시 오류발생하였습니다.");						
				}
				
				if(!StringHelper.strEquals(retpharmVOs.get("result").getString("outDrugNoMsg"),"")) {
					 msgVO.set("outdrugnomsg", retpharmVOs.get("result").getString("outDrugNoMsg"));
				}
				
				if(log.isDebugEnabled()){log.debug("**----약국집계 호출종료 exeOutSum ------** ");}
				
			}
			//--------------------------------------------------약국집계끝------------------------------------------------------

			//--------------------------------------------------자동방배정------------------------------------------------------
			if(log.isDebugEnabled()){log.debug("**----자동방배정 호출시작 setAutoRoomAssignIF ------**");}
			
				InAutoAssignVO.set("pid"      , tempVO.getString("opmi_pid"));
				InAutoAssignVO.set("orddd"    , tempVO.getString("opmi_orddd"));
				InAutoAssignVO.set("cretno"   , tempVO.getString("opmi_cretno"));
				InAutoAssignVO.set("ioflag"   , tempVO.getString("opmi_ordtype"));					
				InAutoAssignVO.set("instcd"   , sInstCd);
				InAutoAssignVO.set("userid"   , sUserId);
				InAutoAssignVO.set("workflag" , "N");
			
				autoasslib.setAutoRoomAssignIF(InAutoAssignVO);						
			
			if(log.isDebugEnabled()){log.debug("**----자동방배정 호출종료 setAutoRoomAssignIF ------**");}
			//--------------------------------------------------자동방배정끝------------------------------------------------------


				/*      
				//////////////////////////////////////////외래등록정보 업데이트//////////////////////////////////////
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
				//////////////////////////////////////////외래등록정보 업데이트 끝//////////////////////////////////////

                //미수금 수납내역 처리로직 추가
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

	//0원 수납 인터페이스 - 0원수납 대상 물리치료 리스트 가져오기
	public ValueObject getMjquList(ValueObject pVO) throws LiveException {

		//기관코드 조회
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//사용자 조회
		if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
			pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
		}

		return outrcptmngtDAO.getMjquList(pVO);
	}


	//0원 수납 인터페이스 - 실행
	public int setIFOAmtZeroRun(ValueObject pVO , String sUserId) throws LiveException {

		int sum_opmi = 0;
		int sum_opmi_array = 0;

		//기관코드 조회
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//사용자 조회
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

			// 진료비가 0원이 아닙니다. 
			//throw new LiveException("진료비가 0원이 아닙니다.");
			//bl_trn = false;
		}

		ValueObject paramVO = new ValueObject();
		paramVO.set("pid"           , pVO.getString("pid"));
		paramVO.set("sessinstcd"   , pVO.getString("sessinstcd"));
		paramVO.set("acptdd"      , DateHelper.getCurrentDateAsString());
		paramVO.set("grouppid"   , "M");  // 주사실은 'J' 세팅

		paramVO = outrcptmngtDAO.getMjquList(paramVO);
				
		return paramVO.size();
	}


	//0원 수납 인터페이스 - 선수금 환불
	public int setIFOAmtZeroRun_refund(ValueObject pVO , String sUserId) throws LiveException {

		ValueObject bogjVO = new ValueObject ();
		int sum_opmi = 0;

		//기관코드 조회
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//사용자 조회
		if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
			pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
		}

		sum_opmi = this.getIFOAmtZeroCheck(pVO);

		if(sum_opmi <= 0) {  
			this.setIFOAmtZeroRcpt(pVO , sUserId);  
		}else{
			// 환불금이 마이너스가 아닙니다.
			//throw new LiveException("환불금이 마이너스가 아닙니다.");
			//bl_trn = false;
		}
		
		//선수금 환불
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
			bogjVO.set("remfact"	,"요율변경환불");      
			bogjVO.set("orddeptcd"	,pVO.getString("orddeptcd"));    
			bogjVO.set("paypsnflag"	,"1");   
			bogjVO.set("paydepoamt"	,sum_opmi * -1);   
			bogjVO.set("paypsnrem"	,"");    

			this.insMdlAmt(bogjVO);
		}

		return sum_opmi;
	}

	//연속처방 수납대상 팝업 - 조회
	public ValueObjectAssembler getPopupMjquList(ValueObject pVO) throws LiveException{
		
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

		ValueObject mjqu  = null;
		ValueObject mjex  = null;
		ValueObjectAssembler retVOs = new ValueObjectAssembler();

        if (!StringHelper.strEquals(pVO.getString("mjqu_orddd"), "")) {
            pVO.set("mjqu_stat", "SELECT");
        }

		 mjqu = outrcptmngtDAO.getPopupMjquList(pVO);     //연속처방 수납대상 팝업 - 조회
		 mjex = outrcptmngtDAO.getPopupMjexList(pVO);     //연속처방 수납대상 팝업 - 조회

		retVOs.set("mjqu"   , mjqu);
		retVOs.set("mjex"   , mjex);
		
		return retVOs;
		
	}

	/**
     * <p>중증체크</p>
     * 
     * @param pVOs ValueObject
     * <p>req : 입력데이터.
     * <ul>
     * <li>pid 등록번호 
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

		//보험정보 안넘어올시 예외처리
		if ( StringHelper.strEquals(vinsuno , "")  || StringHelper.strEquals(vinsuno , null)) {
			vinsuno = "0";
		}

		if ( StringHelper.strEquals(vinsucd , "")  || StringHelper.strEquals(vinsucd , null)) {
			vinsucd = "0";
		}

		int vgenrdd 		     = Integer.parseInt(srdgVO.getString("srdg_genrdd" ,"0"));

		String vgenrddtext       = StringHelper.toSubString(srdgVO.getString("srdg_genrdd"), 4, 6) + "월" + StringHelper.toSubString(srdgVO.getString("srdg_genrdd"), 6, 8) + "일";	
		String vdiagno           = srdgVO.getString("srdg_seridiagno");
		String vsignyn           = srdgVO.getString("srdg_signyn");
		String vcancer           = "V193";
		int vsrdgfromdd          = Integer.parseInt(srdgVO.getString("srdg_fromdd" ,"0"));
		int vsrdgtodd	         = Integer.parseInt(srdgVO.getString("srdg_todd" ,"0"));
		String vanohosprgstflag  = srdgVO.getString("srdg_anohosprgstflag");

		//차상위환자 특별처리 - 보조유형 차상위를 건강보험의 보조유형으로 임시로 바꿔서 중증체크를 한다.
		if( (Integer.parseInt(vsuppkindcd) > 32)  && (Integer.parseInt(vsuppkindcd) < 46)) {
				vsuppkindcd = this.getChgScnd(pVO).getString("final_suppkind");
		}
		//차상위환자 특별처리 끝


		// 건강보험이면서 전액본인은 제외대상임
		if (StringHelper.strEquals(vinsukindcd , "11")  && !StringHelper.strEquals(vsuppkindcd , "01")) {

			  // 이미 중증이 적용되어져 있으면 적용이 가능한지 check해야 함
				if ( StringHelper.strEquals(vsuppkindcd , "06") || StringHelper.strEquals(vsuppkindcd , "11") ){
							
							// 중증상병이 아니면 안됨
							if ( !StringHelper.strEquals(vcode , vcancer) ){
									msg_srdg = "중증 적용할수 없는 상병입니다![2-1-1-가]";
									retVO.set("msg_srdg" , msg_srdg);
									retVO.set("msg_type" , "E");
								    return retVO;			
							}
							
							// 중증번호 없으시 신청당일이고 
							if (StringHelper.strEquals(vdiagno , "0")){
								  
								  // 국정원 예외적용
								  if(StringHelper.strEquals(vinsuno.substring(0,1) , "6") &&  StringHelper.strEquals(vinsucd , "32000110")) {
											msg_srdg = "국정원근무자이므로 반드시 중증번호가 있어야 합니다.[2-1-1-나-ㄱ]";	
											retVO.set("msg_srdg" , msg_srdg);
											retVO.set("msg_type" , "E");
											return retVO;	
									}
	
								    // 사인은 했음.
									if ( StringHelper.strEquals(vsignyn , "Y")){
										  // 신청당일 check
										    /* 08/09/23 윤영옥 케이스발생할수가없는 경우임
											if ( vgenrdd == vOrddd ){
													msg_srdg = "당일 Sign환자입니다. 중증으로 정산하시겠습니까?[2-1-1-나-ㄴ-A]";					
													retVO.set("msg_srdg" , msg_srdg);
													retVO.set("msg_type" , "Q");
													return retVO;
											}
										    */
											if ( vgenrdd != vOrddd ){
													msg_srdg = vgenrddtext + " Sign환자입니다.[2-1-1-나-ㄴ-B]";					
													retVO.set("msg_srdg" , msg_srdg);
													retVO.set("msg_type" , "I");
													return retVO;
											}
								     }
									 
									 // 사인안했음
									 if ( !StringHelper.strEquals(vsignyn , "Y")){ 

											if (StringHelper.strEquals(vanohosprgstflag , "Y")){
													msg_srdg = "타병원 중증등록 환자 입니다.자격을 확인하세요![2-1-1-나-ㄷ-A]";
													retVO.set("msg_srdg" , msg_srdg);
													retVO.set("msg_type" , "E");
													return retVO;
											}

											if (StringHelper.strEquals(vanohosprgstflag , "N")){

													msg_srdg = "중증의뢰서 서명 후 중증적용 가능합니다. \n의뢰서 사인을 하신 후 수납해주세요!![제증명관리-중증환자등록]";
													retVO.set("msg_srdg"      , msg_srdg);
													retVO.set("msg_type"      , "E");
													return retVO;

											}

								     }	

							}
							
							// 중증번호 있으면 기간만 check함
							if (!StringHelper.strEquals(vdiagno , "0") && !StringHelper.strEquals(vdiagno , null)){ 
									if (vOrddd < vsrdgfromdd || vOrddd > vsrdgtodd ) {			   
										msg_srdg = "적용일자가 중증기간 범위에 포함되지 않습니다.[2-1-1-다]";	
										retVO.set("msg_srdg" , msg_srdg);
										retVO.set("msg_type" , "E");
										return retVO;
									}
							}
				}
				
				// 중증이 미적용되어져 있으면 적용이 가능한지 check해야 함
				if ( !StringHelper.strEquals(vsuppkindcd , "06") && !StringHelper.strEquals(vsuppkindcd , "11")){


						 // 중증에 해당하는 상병이면
						if ( StringHelper.strEquals(vcode , vcancer)){
							
								// 중증번호 없으시 신청당일이고 sign이 되었으면 가능함. 단 국정원이 아닐경우
								if (StringHelper.strEquals(vdiagno , "0")){ 

									//타병원유무 체크
									if (StringHelper.strEquals(vanohosprgstflag , "Y")){
											msg_srdg = "타병원 중증등록 환자 입니다.자격을 확인하세요![2-1-2-가-ㄱ]";
											retVO.set("msg_srdg" , msg_srdg);
											retVO.set("msg_type" , "E");
											return retVO;	
									}

									if (StringHelper.strEquals(vanohosprgstflag , "N")){

											if (StringHelper.strEquals(vsignyn , "Y")){ // 사인되었고 국정원이 아니면 산정가능
												
												if(StringHelper.strEquals(vinsuno.substring(0,1) , "6") && StringHelper.strEquals(vinsucd, "32000110")) {
													//
												}else{

													if ( vgenrdd == vOrddd ){
														msg_srdg = "당일 Sign환자입니다. 중증으로 정산하시겠습니까?[2-1-2-가-ㄴ-B-A]";	
														retVO.set("msg_srdg" , msg_srdg);
														retVO.set("msg_type" , "Q");
														return retVO;
													}
												
													if ( vgenrdd != vOrddd ){
														msg_srdg = "중증으로 정산하시겠습니까?[2-1-2-가-ㄴ-B-B]";	
														retVO.set("msg_srdg" , msg_srdg);
														retVO.set("msg_type" , "Q");
														return retVO;
													}									
												
												}
											}
											
											// 사인안되었으면 guide한다.
											if (!StringHelper.strEquals(vsignyn , "Y")){ 
													msg_srdg = "중증의뢰서가 작성되었습니다, 의뢰서 사인을 하십시오.\n사인하지 않고 수납을 계속 진행하시겠습니까?";
													retVO.set("msg_srdg"      , msg_srdg);
													retVO.set("msg_type" , "Q");
													return retVO;
											}
									}

								}


								// 중증번호 있으면서 기간이 맞으면 중증가능함
								if (!StringHelper.strEquals(vdiagno , "0") && !StringHelper.strEquals(vdiagno , null) ){  
										if ( vOrddd >= vsrdgfromdd && vOrddd <= vsrdgtodd ) {			   
												    msg_srdg = "중증으로 정산하시겠습니까?[2-1-2-나]";	
													retVO.set("msg_srdg" , msg_srdg);
													retVO.set("msg_type" , "Q");
													return retVO;
										}
								}
						}

				}
		
		}
		
		// 급여이면서 전액본인은 제외대상임
		if ((StringHelper.strEquals(vinsukindcd ,"21") || StringHelper.strEquals(vinsukindcd ,"22")) && !StringHelper.strEquals(vsuppkindcd , "01")){
			  
			  // 이미 중증이 적용되어져 있으면 적용이 가능한지 check해야 함
				if (StringHelper.strEquals(vsuppkindcd ,"06") || StringHelper.strEquals(vsuppkindcd ,"11")){
							
							// 중증상병이 아니면 안됨
							if (!StringHelper.strEquals(vcode ,vcancer)){
								  msg_srdg = "[중증] 적용할수 없는 상병입니다![2-2-1-가]";					
								  retVO.set("msg_srdg" , msg_srdg);
								  retVO.set("msg_type" , "E");
								  return retVO;			
							}
							
							// 중증번호 없으면 신청당일이고 
							if (StringHelper.strEquals(vdiagno ,"0")){
								
									if (StringHelper.strEquals(vanohosprgstflag ,"Y")){
											msg_srdg = "타병원 중증등록 환자 입니다.자격을 확인하세요![2-2-1-나-A]";
											retVO.set("msg_srdg" , msg_srdg);
											retVO.set("msg_type" , "E");
											return retVO;
									}

									//2012-12-06
									if (!StringHelper.strEquals(vsignyn , "Y")){ 
										msg_srdg = vgenrddtext + " 중증의뢰서가 작성되었습니다, \n의뢰서 사인을 하신 후 수납해주세요!![제증명관리-중증환자등록]";
										retVO.set("msg_srdg"      , msg_srdg);
										retVO.set("msg_type" , "E");
										return retVO;
									}
									
									if (StringHelper.strEquals(vanohosprgstflag ,"N")){
											msg_srdg = "중증번호가 없습니다. 번호를 승인받아야 [중증]적용이 가능합니다.[2-2-1-나-B]"; 
											retVO.set("msg_srdg"      , msg_srdg);
											retVO.set("msg_type" , "E");
											return retVO;
									}
									
									
							}

							if (!StringHelper.strEquals(vdiagno ,"0") && !StringHelper.strEquals(vdiagno ,null)) { // 중증번호 있으면 기간만 check함
									//적용일자는 있으나, 적용일자 범위가 아님
									if ( vOrddd < vsrdgfromdd || vOrddd > vsrdgtodd ) {			   
										msg_srdg = "적용일자가 [중증]기간 범위에 포함되지 않습니다.[2-2-1-다]";	
										retVO.set("msg_srdg" , msg_srdg);
										retVO.set("msg_type" , "E");
										return retVO;
									}
							}
				}
				
				// 중증이 미적용되어져 있으면 적용이 가능한지 check해야 함
				if (!StringHelper.strEquals(vsuppkindcd ,"06") && !StringHelper.strEquals(vsuppkindcd ,"11")){

						// 중증에 해당하는 상병이면
						if (StringHelper.strEquals(vcode ,vcancer)){

								// 중증번호 없으시 신청당일이고 sign이 되었으면 가능함. 단 국정원이 아닐경우
								if (!StringHelper.strEquals(vdiagno ,"0") && !StringHelper.strEquals(vdiagno ,null)) {
									
								        // 중증번호 있으면서 기간이 맞으면 중증가능함
										if (vOrddd >= vsrdgfromdd && vOrddd <= vsrdgtodd ) {			   
												msg_srdg = "[중증]으로 정산하시겠습니까?[2-2-2-나]";	
												retVO.set("msg_srdg" , msg_srdg);
												retVO.set("msg_type" , "Q");
												return retVO;
										}
								}
								
								if (StringHelper.strEquals(vanohosprgstflag , "N")){

									// 사인안되었으면 guide한다.
									if (!StringHelper.strEquals(vsignyn , "Y")){ 
											msg_srdg = vgenrddtext + " 중증의뢰서가 작성되었습니다, \n의뢰서 사인을 하신 후 수납해주세요!![제증명관리-중증환자등록]";
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
		
		//보험정보 안넘어올시 예외처리
		if ( StringHelper.strEquals(vinsuno , "")  || StringHelper.strEquals(vinsuno , null)) {
			vinsuno = "0";
		}
		if ( StringHelper.strEquals(vinsucd , "")  || StringHelper.strEquals(vinsucd , null)) {
			vinsucd = "0";
		}

		int vgenrdd 		     = Integer.parseInt(rooaVO.getString("rooa_genrdd" ,"0"));

		String vgenrddtext       = StringHelper.toSubString(rooaVO.getString("rooa_genrdd"), 4, 6) + "월" + StringHelper.toSubString(rooaVO.getString("rooa_genrdd"), 6, 8) + "일";	
		String vdiagno           = rooaVO.getString("rooa_rareobstno");
		String vsignyn           = rooaVO.getString("rooa_signyn");
		String vcancer           = "V027";
		int vsrdgfromdd          = Integer.parseInt(rooaVO.getString("rooa_fromdd" ,"0"));
		int vsrdgtodd	         = Integer.parseInt(rooaVO.getString("rooa_todd" ,"0"));
		String vanohosprgstflag  = rooaVO.getString("rooa_anohosprgstflag");

		//차상위환자 특별처리 - 보조유형 차상위를 건강보험의 보조유형으로 임시로 바꿔서 중증체크를 한다.
		if( (Integer.parseInt(vsuppkindcd) > 32)  && (Integer.parseInt(vsuppkindcd) < 46)) {
				vsuppkindcd = this.getChgScnd(pVO).getString("final_suppkind");
		}
		//차상위환자 특별처리 끝


		// 건강보험이면서 전액본인은 제외대상임
		// 2010.12.02 syjung 의료급여 1,2종 희귀난치성 산정특례 추가(2010.12.01 고시 적용)
		if ((StringHelper.strEquals(vinsukindcd , "11")  && !StringHelper.strEquals(vsuppkindcd , "01")) || 
			(StringHelper.strEquals(vinsukindcd , "21")  && !StringHelper.strEquals(vsuppkindcd , "01"))) {

		 	// 이미 희귀산특이 적용되어져 있으면 적용이 가능한지 check해야 함
			if ( StringHelper.strEquals(vsuppkindcd , "50") || StringHelper.strEquals(vsuppkindcd , "51") || StringHelper.strEquals(vsuppkindcd , "46") 		//희귀난치산정특례
				 || StringHelper.strEquals(vsuppkindcd , "02") || StringHelper.strEquals(vsuppkindcd , "03") || StringHelper.strEquals(vsuppkindcd , "04")	//산정특례(투석,복막,장기이식)
				 || StringHelper.strEquals(vsuppkindcd , "61") || StringHelper.strEquals(vsuppkindcd , "62") || StringHelper.strEquals(vsuppkindcd , "63") || StringHelper.strEquals(vsuppkindcd , "64")	//중증화상
				 || StringHelper.strEquals(vsuppkindcd , "87") || StringHelper.strEquals(vsuppkindcd , "88") || StringHelper.strEquals(vsuppkindcd , "89")	//노인레진상완전틀니
			
			){
						
				//V027은 희귀산특 제외
				if (StringHelper.strEquals(vcode , vcancer) ){
					msg_rooa = "희귀난치성산정특례 적용할수 없는 특례코드입니다.[V027][3]";
					retVO.set("msg_rooa" , msg_rooa);
					retVO.set("msg_type" , "E");
				    return retVO;			
				}
				
				// 희귀산특번호 없으시 신청당일,  7/1~9/30 유예기간은 등록 여부를 체크하지 않음. 10/1일부터 체크함.
				if (StringHelper.strEquals(vdiagno , "0") && "20091001".compareTo(pVO.getString("orddd")) <= 0 
						&& !StringHelper.strEquals(srchflag , "A") && !StringHelper.strEquals(srchflag , "B") && !StringHelper.strEquals(srchflag , "F")){

					// 사인은 했음.
					//if ( StringHelper.strEquals(vsignyn , "Y")){
					//	if ( vgenrdd != vOrddd ){
					//		msg_rooa = vgenrddtext + " 희귀난치성산정특례 Sign환자입니다.[4]";					
					//		retVO.set("msg_rooa" , msg_rooa);
					//		retVO.set("msg_type" , "I");
					//		return retVO;
					//	}
				    //}
					 
					 // 사인안했음
					 if ( !StringHelper.strEquals(vsignyn , "Y")){ 

						//if (StringHelper.strEquals(vanohosprgstflag , "Y")){
						//	msg_rooa = "타병원 희귀난치성산정특례등록 환자 입니다.자격을 확인하세요![5]";
						//	retVO.set("msg_rooa" , msg_rooa);
						//	retVO.set("msg_type" , "E");
						//	return retVO;
						//}

						if (StringHelper.strEquals(vanohosprgstflag , "N")){
							msg_rooa = "희귀난치산정특례 의뢰서 서명을 하지 않았습니다. \n의뢰서 사인 후 희귀난치성산정특례 적용 가능합니다. \n서명 후 수납진행해 주세요[제증명관리-희귀난치환자등록][6]";
							retVO.set("msg_rooa"      , msg_rooa);
							retVO.set("msg_type"      , "E");
							return retVO;
						}

				     }	

				}
				
				// 희귀난치성산정특례 있으면 기간만 check함
				if (!StringHelper.strEquals(vdiagno , "0") && !StringHelper.strEquals(vdiagno , null) && "20091001".compareTo(pVO.getString("orddd")) <= 0 
						&& !StringHelper.strEquals(srchflag , "A") && !StringHelper.strEquals(srchflag , "B") && !StringHelper.strEquals(srchflag , "F")){ 
					if (vOrddd < vsrdgfromdd || vOrddd > vsrdgtodd ) {			   
						msg_rooa = "적용일자가 희귀난치성산정특례 범위에 포함되지 않습니다.[7]";	
						retVO.set("msg_rooa" , msg_rooa);
						retVO.set("msg_type" , "E");
						return retVO;
					}
				}
				
				//노인 레진상 틀니는 타병원은 적용 불가
				if( StringHelper.strEquals(vsuppkindcd , "87") || StringHelper.strEquals(vsuppkindcd , "88") || StringHelper.strEquals(vsuppkindcd , "89") ){
					
					//타병원 신청
					if (StringHelper.strEquals(vanohosprgstflag , "Y")){
						
						msg_rooa = "타병원 노인 레진상 완전 틀니 신청된 환자입니다. \n보험적용 불가합니다. 일반유형으로 수납하세요[8]";
						retVO.set("msg_rooa"      , msg_rooa);
						retVO.set("msg_type"      , "E");
						return retVO;
					}
				}
			}
			
			//희귀난치성산정특례가 미적용되어져 있으면 적용이 가능한지 check해야 함
			//가정간호 프로세스 확인 필요.
//			if (!StringHelper.strEquals(vsuppkindcd , "50") && !StringHelper.strEquals(vsuppkindcd , "51")
//				&& !StringHelper.strEquals(vsuppkindcd , "46") && !StringHelper.strEquals(vsuppkindcd , "02") && !StringHelper.strEquals(vsuppkindcd , "03") 
//				&& !StringHelper.strEquals(vsuppkindcd , "04") && !StringHelper.strEquals(vsuppkindcd , "10") && !StringHelper.strEquals(vsuppkindcd , "37")) {
			if( StringHelper.strEquals(vsuppkindcd , "00")				//정상 
					|| StringHelper.strEquals(vsuppkindcd , "32")		//차상위1종
					|| StringHelper.strEquals(vsuppkindcd , "33") ){		//차상위2종 정상
				
				if ( log.isDebugEnabled() ) {
			   		 log.debug("**----희귀난치성산정특례 ------**  " );
			   		 log.debug("vcode :" + vcode);
			   		 log.debug("popsuppkind :" + popsuppkind);
			   		 log.debug("vdiagno :" + vdiagno);
			   		 log.debug("vsignyn :" + vsignyn);
			   		 log.debug("vsuppkindcd :" + vsuppkindcd);
			   		 log.debug("orddd : " + pVO.getString("orddd"));
				}
				
				 // 희귀난치성산정특례에 해당하는 상병이면
				if (!StringHelper.strEquals(vcode , vcancer)){
					
					// 희귀난치성산정특례번호 없을시 신청당일이고 sign이 되었으면 가능함.
					if (StringHelper.strEquals(vdiagno , "0") && "20091001".compareTo(pVO.getString("orddd")) <= 0) { 

						//타병원유무 체크
						if (StringHelper.strEquals(vanohosprgstflag , "Y")){
							msg_rooa = "타병원 희귀난치성산정특례 환자 입니다. 자격을 확인하십시오.[8]";
							retVO.set("msg_rooa" , msg_rooa);
							retVO.set("msg_type" , "E");
							return retVO;	
						}

						if (StringHelper.strEquals(vanohosprgstflag , "N")){

							if (StringHelper.strEquals(vsignyn , "Y")){ // 사인

								if ( vgenrdd == vOrddd ){
									msg_rooa = "당일 Sign환자입니다. 희귀난치성산정특례로 정산하시겠습니까?[9]";	
									retVO.set("msg_rooa" , msg_rooa);
									retVO.set("msg_type" , "Q");
									retVO.set("msg_suppkind", popsuppkind);
									return retVO;
								}
							
								if ( vgenrdd != vOrddd ){
									msg_rooa = "희귀난치성산정특례로 정산하시겠습니까?[10]";	
									retVO.set("msg_rooa" , msg_rooa);
									retVO.set("msg_type" , "Q");
									retVO.set("msg_suppkind", popsuppkind);
									return retVO;
								}									

							}
							
							// 사인안되었으면 guide한다.
							if (!StringHelper.strEquals(vsignyn , "Y") && "20091001".compareTo(pVO.getString("orddd")) <= 0){ 
								//msg_rooa = "희귀난치성산정특례 의뢰서가 작성되었습니다, 의료정보팀에서 Sign하십시오. 진행하시겠습니까?[11]";
								//retVO.set("msg_rooa"      , msg_rooa);
								//retVO.set("msg_type" , "Q");
								//2012-12-06
								if( StringHelper.strEquals(vinsukindcd , "21") ){
									msg_rooa = "희귀난치성산정특례 의뢰서가 작성되었습니다, \n의뢰서 사인을 하신 후 수납해주세요!![제증명관리-희귀난치환자등록]";
									retVO.set("msg_rooa"      , msg_rooa);
									retVO.set("msg_type" , "E");
								}else{
									msg_rooa = "희귀난치성산정특례 의뢰서가 작성되었습니다, \n의뢰서 사인을 하십시오.\n사인하지 않고 수납을 계속 진행하시겠습니까?\n[Yes : 수납, No : 중지]";
									retVO.set("msg_rooa"      , msg_rooa);
									retVO.set("msg_type" , "Q");
								}
								
								retVO.set("msg_suppkind", popsuppkind);
								return retVO;
							}
						}

					}

					// 희귀난치성산정특례번호 있으면서 기간이 맞으면 가능함
					if (!StringHelper.strEquals(vdiagno , "0") && !StringHelper.strEquals(vdiagno , null) && "20091001".compareTo(pVO.getString("orddd")) <= 0){  
						if ( vOrddd >= vsrdgfromdd && vOrddd <= vsrdgtodd ) {			   
							msg_rooa = "희귀난치성산정특례로 정산하시겠습니까?[12]";	
							retVO.set("msg_rooa" , msg_rooa);
							retVO.set("msg_type" , "Q");
							retVO.set("msg_suppkind", popsuppkind);
							return retVO;
						}
					}
					
					//특례코드가 존재하면 7/1~9/30까진 특례코드로만 체크
					if (vcode != "" && vcode != "-" &&  vcode != "V193" && "20090701".compareTo(pVO.getString("orddd")) <= 0 && "20090930".compareTo(pVO.getString("orddd")) >= 0) {
						msg_rooa = "희귀난치성산정특례로 정산하시겠습니까?[13]";	
						retVO.set("msg_rooa" , msg_rooa);
						retVO.set("msg_type" , "Q");
						retVO.set("msg_suppkind", popsuppkind);
						return retVO;
					}
					
					//특례코드가 존재하면 10/1 ~ 특례코드로만 체크
					if (vcode != "" && vcode != "-" &&  vcode != "V193" && "20091001".compareTo(pVO.getString("orddd")) <= 0
						&& StringHelper.strEquals(srchflag , "A") && StringHelper.strEquals(srchflag , "B")) {
						msg_rooa = "희귀난치성산정특례로 정산하시겠습니까?[13]";	
						retVO.set("msg_rooa" , msg_rooa);
						retVO.set("msg_type" , "Q");
						retVO.set("msg_suppkind", popsuppkind);
						return retVO;
					}
					
				}
			}
		}
		//의료급여2종이면서 특례대상환자이면 사인하고 가시라고 알림 메세지 뜹니다. 20101202 cys
		if ((StringHelper.strEquals(vinsukindcd , "22")  && StringHelper.strEquals(vsuppkindcd , "00"))) {

			// 희귀난치성산정특례에 해당하는 상병이면
			if (!StringHelper.strEquals(vcode , vcancer)){

				// 희귀난치성산정특례번호 없을시 신청당일이고 sign이 되었으면 가능함.
				if (StringHelper.strEquals(vdiagno , "0") && vgenrdd == vOrddd ) {
					
					//타병원여부
					if (StringHelper.strEquals(vanohosprgstflag , "N")){
						
						//사인여부
						if (!StringHelper.strEquals(vsignyn , "Y")){

								msg_rooa = "희귀난치성산정특례 의뢰서가 작성되었습니다. \n의뢰서 사인을 하신 후 수납을 계속 진행하세요!" + '\n' +
										   "(급여2종환자는 공단에서 희귀번호 받은후 급여1종 특례로 자격이 바뀝니다.[12])";
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
     * 병원 정보코드 조회
     * 2009.02.05. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getHospcd(ValueObject pVO) throws LiveException{

		return outrcptmngtDAO.getHospcd(pVO);
		
	}

	//수납vip 대기자조회
	public ValueObject getVipStandList(ValueObject pVO) throws LiveException {

        //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

		ValueObject retVO = new ValueObject(); //결과 VO    
                
        retVO = outrcptmngtDAO.getVipStandList(pVO);
        
		return retVO;
	}

    /*
     * 당일 자격조회 유무 체크
     * 2009.03.16. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getMmsg2Check(ValueObject pVO) throws LiveException{

        //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

		return outrcptmngtDAO.getMmsg2Check(pVO);
		
	}

    /*
     * (비Javadoc)
     * 차상위환자 변환처리
     * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getChgScnd(kr.co.hit.live.vo.ValueObject)
     */
    public ValueObject getChgScnd(ValueObject pVO) throws LiveException{
        
        ValueObject scndVO = new ValueObject();
        ValueObject retVO = new ValueObject();

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
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
     * (비Javadoc)
     * 차상위환자 여부체크
     * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getChgScnd(kr.co.hit.live.vo.ValueObject)
     */
    public ValueObject getChkScnd(ValueObject pVO) throws LiveException{
        
        ValueObject scndVO = new ValueObject();
        ValueObject retVO = new ValueObject();

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
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
     * (비Javadoc)
     * 차상위환자 변환처리(업데이트 포함)
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


    //연속처방 유무 체크
    public ValueObject getChkOtptMJ(ValueObject pVO) throws LiveException{
        
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
        
        return outrcptmngtDAO.getChkOtptMJ(pVO);
        
    }

    //진료비계산
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
			int vopmi_totownbamt2     = 0;    //총본인부담금에서 잔전처리한 금액
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
			
		    //20090701 1.단수처리 고시적용
			int vopmi_payinsurestamt  = 0;
			int vopmi_payownbamt100  = 0;
			int vopmi_payinsubamt100  = 0;
			int vopmi_totownbamt100  = 0;
			
			//20110701 미용성형 부가세 고시 적용
			int vopmi_taxamt = 0;
			
			String vopmi_clincstdyno     = "";

				if  (opmiVO.size() > 0) {							
					for (int i=0 ; i< opmiVO.size() ; i++) {
					
						//------------------------------------------------------------------------------------------------------------------------------------------                                                                                     
						//총진료비, 총급여액, 총비급여액, 총전액부담액, 총선택진료비
						vopmi_totamt 			= vopmi_totamt			+ opmiVO.getInt(i, "opmi_totamt");
						vopmi_payamt			= vopmi_payamt			+ opmiVO.getInt(i, "opmi_payamt");
						vopmi_nopyamt			= vopmi_nopyamt			+ opmiVO.getInt(i, "opmi_nopyamt");
						vopmi_allownbamt		= vopmi_allownbamt		+ opmiVO.getInt(i, "opmi_allownbamt");
						vopmi_specamt			= vopmi_specamt			+ opmiVO.getInt(i, "opmi_specamt");
						//------------------------------------------------------------------------------------------------------------------------------------------                                                                                     
						//비급여액 = 비급여액+전액본인부담액 (비급여본인 = 비급여본인+전액본인 본인 /  비급여보험 = 비급여보험+전액본인 보험)									
						vopmi_totnopyamt		= vopmi_totnopyamt		+ opmiVO.getInt(i, "opmi_totnopyamt");
						vopmi_totnopyownbamt	= vopmi_totnopyownbamt 	+ opmiVO.getInt(i, "opmi_nopyownbamt")  + opmiVO.getInt(i, "opmi_allownownbamt");
						vopmi_totnopyinsubamt	= vopmi_totnopyinsubamt + opmiVO.getInt(i, "opmi_nopyinsubamt") + opmiVO.getInt(i, "opmi_allowninsubamt");
						//------------------------------------------------------------------------------------------------------------------------------------------                                                                                     
						//선택진료 본인 / 보험자
						vopmi_specownbamt   	= vopmi_specownbamt 	+ opmiVO.getInt(i, "opmi_specownbamt");
						vopmi_specinsubamt      = vopmi_specinsubamt 	+ opmiVO.getInt(i, "opmi_specinsubamt");
						//------------------------------------------------------------------------------------------------------------------------------------------                                                                                     
						//급여 본인/보험자
						vopmi_payownbamt		= vopmi_payownbamt		+ opmiVO.getInt(i, "opmi_payownbamt");
						vopmi_payinsubamt		= vopmi_payinsubamt		+ opmiVO.getInt(i, "opmi_payinsubamt");
						//------------------------------------------------------------------------------------------------------------------------------------------                                                                                     
						//장애인기금, 응급대불액,보호대불액,대불총액
						vopmi_handcapfund		= vopmi_handcapfund		+ opmiVO.getInt(i, "opmi_handcapfund");
						vopmi_ersubtamt		    = vopmi_ersubtamt		+ opmiVO.getInt(i, "opmi_ersubtamt");
						vopmi_procsubtamt		= vopmi_procsubtamt		+ opmiVO.getInt(i, "opmi_procsubtamt");
						vopmi_subtamt			= vopmi_subtamt			+ opmiVO.getInt(i, "opmi_subtamt");
						//------------------------------------------------------------------------------------------------------------------------------------------                                                                                     
						//감면총액, 할인액, 감액, 혈액감액
						vopmi_discreduamt		= vopmi_discreduamt		+ opmiVO.getInt(i, "opmi_discreduamt");
						vopmi_discamt			= vopmi_discamt			+ opmiVO.getInt(i, "opmi_discamt");
						vopmi_reduamt			= vopmi_reduamt			+ opmiVO.getInt(i, "opmi_reduamt");
						vopmi_bloddiscamt		= vopmi_bloddiscamt		+ opmiVO.getInt(i, "opmi_bloddiscamt");
						//------------------------------------------------------------------------------------------------------------------------------------------                                                                                     
						//총본인부담금, 총본인부담금2(잔전처리)	
						vopmi_totownbamt		= vopmi_totownbamt		+ opmiVO.getInt(i, "opmi_totownbamt");
						vopmi_totownbamt2		= vopmi_totownbamt2		+ opmiVO.getInt(i, "opmi_totownbamt2");
						//------------------------------------------------------------------------------------------------------------------------------------------                                                                                     
						//기수납금
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
						
					    //20090701 1.단수처리 고시적용
						vopmi_payinsurestamt = vopmi_payinsurestamt + opmiVO.getInt(i, "opmi_payinsurestamt");
						vopmi_payownbamt100 = vopmi_payownbamt100 + opmiVO.getInt(i, "opmi_payownbamt100");
						vopmi_payinsubamt100 = vopmi_payinsubamt100 + opmiVO.getInt(i, "opmi_payinsubamt100");
						vopmi_totownbamt100 = vopmi_totownbamt100 + opmiVO.getInt(i, "opmi_totownbamt100");
						
						//20110701 미용성형 부가세 고시 적용
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
			
		    //20090701 1.단수처리 고시적용
			sum_opmiVO.set("payinsurestamt"     , vopmi_payinsurestamt);
			sum_opmiVO.set("payownbamt100"      , vopmi_payownbamt100);
			sum_opmiVO.set("payinsubamt100"     , vopmi_payinsubamt100);
			sum_opmiVO.set("totownbamt100"      , vopmi_totownbamt100);
			
			//20110701 미용성형 부가세 고시 적용
			sum_opmiVO.set("taxamt"      				, vopmi_taxamt);

      return sum_opmiVO;
        
    }

	/*(비Javadoc) 선택진료 등록 여부를 조회
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt;.OutRcptMgt#getSpecOrdAppYN(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getSpecOrdAppYN(ValueObject pVO) throws LiveException {
		
		ValueObject chkVO = etcOutRgst.getSpecOrdAppAutoYN(pVO);
		
		if ("Y".equals(chkVO.getString("autoyn"))) { //원무공통코드 P0051 Y일 경우만 자동조회
			pVO.set("opatyn", "N");	//등록 Y, 수납 N	
			return etcOutRgst.getSpecOrdAppRgstRef(pVO);
		} else {
			ValueObject retVO = new ValueObject();
			retVO.set("rgstyn", "-");	
			return retVO;
		}
		
	}

	//원무공통코드 (desc조회)
	public ValueObject getPmcmCode(ValueObject pVO) throws LiveException {

		//기관코드 조회
		pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		
		//사용자 조회
		pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));

		return outrcptmngtDAO.getPmcmCode(pVO);
	}

	//원무공통코드 (cdid조회)
	public ValueObject getPmcmCodeNm(String cdid) throws LiveException {

		ValueObject pVO = new ValueObject();
		ValueObject retVO = new ValueObject();

		//기관코드 조회
		pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		
		//사용자 조회
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

	//원무공통코드 (cdid조회)
	public ValueObject getPmcmCodeNm(String cdgrupid , String cdid) throws LiveException {

		ValueObject pVO = new ValueObject();
		ValueObject retVO = new ValueObject();

		//기관코드 조회
		pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		
		//사용자 조회
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

	//원무공통코드 (cdid조회)
	public ValueObject getPmcmCodeNm(String cdgrupid , String cdid  , String sessinstcd) throws LiveException {

		ValueObject pVO = new ValueObject();
		ValueObject retVO = new ValueObject();

         //기관코드 조회
        if (StringHelper.strEquals(sessinstcd, "")) {
			sessinstcd = StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE));
        }
        
		//사용자 조회
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

    //ZBCMCODE 공통코드조회
    public ValueObject getZbcmCode(String cdgrupid , String cdid) throws LiveException {

        ValueObject pVO = new ValueObject();
        ValueObject retVO = new ValueObject();

        //기관코드 조회
        pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        
        //사용자 조회
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

    //자보 , 산재 정보 조회
    public ValueObject checkJaboSanjaeInfo(ValueObject pVO) throws LiveException {

        ValueObject retVO = new ValueObject();

        //기관코드 조회
        pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        //사용자 조회
        pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));

        retVO = etcOutRgst.checkJaboSanjaeInfo(pVO);
        
        return retVO;
        
    }
    
    /* 건보, 의보 자격정보 체크
     * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.OutRcptMgt#checkInsuInfo(kr.co.hit.live.vo.ValueObject)
     */
    public ValueObject checkInsuInfo(ValueObject pVO) throws LiveException {

        ValueObject retVO = new ValueObject();

        //기관코드 조회
        pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        //사용자 조회
        pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));

        retVO = outrcptmngtDAO.checkInsuInfo(pVO);
        
        return retVO;
        
    }

    //중증체크 (무인수납,외래 수납버튼누를시 사용)
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
                vsuppkindsubyn = pVO.getString(a,"suppkindsubyn");  //보조유형의 부과여부 주과 N, 부과 Y(주과일때만 체크한다)
                vprcpgenryn    = pVO.getString(a,"prcpgenryn");
                vdracptyn      = pVO.getString(a,"dracptyn");

                //차상위환자 특별처리 - 보조유형 차상위를 건강보험의 보조유형으로 임시로 바꿔서 중증체크를 한다.
                if( (Integer.parseInt(vsuppkind) > 32)  && (Integer.parseInt(vsuppkind) < 46)) {
                    vsuppkind = this.getChgScnd(pVO.getRowAsVo(a)).getString("final_suppkind");
                }
                //차상위환자 특별처리 끝

                //전액본인부담일경우 산정특례로직 안타게해야함.
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

                        //2012-11-01 연속처방이라 하더라도 중증및 산정특례 적용은 실시일자 기준으로 적용한다.
                        //체크로직 주석처리
                        //연속처방일경우 원진료일자 상병 구하기
//                        if( StringHelper.strEquals(pVO.getString(a,"etcordflag") , "M") || StringHelper.strEquals(pVO.getString(a,"etcordflag") , "J") ) {
//                                ValueObject otpt_MJ_VO = new ValueObject();
//                                otpt_MJ_VO = this.getChkOtptMJ(tempVO);
//
//                                if(otpt_MJ_VO.size() > 0) {
//                                    tempVO.set("orddd"     , otpt_MJ_VO.getString("orddd"));
//                                    tempVO.set("cretno"     , otpt_MJ_VO.getString("cretno"));
//                                }
//                        }
                        //연속처방일경우 원진료일자 상병 구하기끝

                        esscVO = pamMgt.getEssc(tempVO);
                        srdgVO = pamMgt.getPatSrdgInfo(tempVO).get("srdg");

                        if( esscVO.size() == 0    &&
                            !StringHelper.strEquals(vprcpgenryn ,"1A")  &&
                            StringHelper.strEquals(vdracptyn , "Y")     &&
                            (Integer.parseInt(tempVO.getString("orddd")) <= Integer.parseInt(DateHelper.getDay())) &&
                            (StringHelper.strEquals(vsuppkind , "06") || StringHelper.strEquals(vsuppkind , "11"))
                            
                        ) {
                            msgVO_srdg.set("msg_srdg" , "중증 적용할수 없는 상병입니다![0]");
                            msgVO_srdg.set("msg_type" , "E");
                            break;
                        }

                        if( srdgVO.size() == 0 &&
                            ((Integer.parseInt(tempVO.getString("orddd")) <= Integer.parseInt(DateHelper.getDay())) ||
                             (Integer.parseInt(tempVO.getString("orddd")) >  Integer.parseInt(DateHelper.getDay()) && StringHelper.strEquals(vdracptyn,"Y"))) &&	
						    (StringHelper.strEquals(vsuppkind , "06") || StringHelper.strEquals(vsuppkind , "11"))
						  ){
                            msgVO_srdg.set("msg_srdg" , "해당환자는 중증번호가 없으므로, [중증]으로 적용할 수 없습니다.[1]");
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
    
    //20090701 2.희귀난치성산정특례 고시적용 sFlag S 수납, K 무인수납
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
                vsuppkindsubyn   = pVO.getString(a,"suppkindsubyn");  //보조유형의 부과여부 주과 N, 부과 Y(주과일때만 체크한다)
                vprcpgenryn      = pVO.getString(a,"prcpgenryn");
                vdracptyn        = pVO.getString(a,"dracptyn");

                //차상위환자 특별처리 - 보조유형 차상위를 건강보험의 보조유형으로 임시로 바꿔서 중증체크를 한다.
                if( (Integer.parseInt(vsuppkind) > 32)  && (Integer.parseInt(vsuppkind) < 46)) {
                    vsuppkind = this.getChgScnd(pVO.getRowAsVo(a)).getString("final_suppkind");
                }
                //차상위환자 특별처리 끝

                //전액본인부담일경우 산정특례로직 안타게해야함

				//의료급여1,2종 희귀난치산정특례추가 2010/12/01 고시 cys
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

                    //2012-11-01 연속처방이라 하더라도 중증및 산정특례 적용은 실시일자 기준으로 적용한다.
                    //체크로직 주석처리
                    //연속처방일경우 원진료일자 상병 구하기
//                    if( StringHelper.strEquals(pVO.getString(a,"etcordflag") , "M") || StringHelper.strEquals(pVO.getString(a,"etcordflag") , "J") ) {
//                            ValueObject otpt_MJ_VO = new ValueObject();
//                            otpt_MJ_VO = this.getChkOtptMJ(tempVO);
//
//                            if(otpt_MJ_VO.size() > 0) {
//                                tempVO.set("orddd"  , otpt_MJ_VO.getString("orddd"));
//                                tempVO.set("cretno" , otpt_MJ_VO.getString("cretno"));
//                            }
//                    }
                    //연속처방일경우 원진료일자 상병 구하기끝

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
                		msgVO_srdg.set("msg_rooa" , "희귀난치성산정특례를 적용할수 없는 상병입니다![1]");
                		msgVO_srdg.set("msg_type" , "E");
    					break;
    					
    				}else if (rooaVO1.size() == 0 && 
                			!StringHelper.strEquals(vprcpgenryn ,"1A") &&
                            StringHelper.strEquals(vdracptyn , "Y") &&
                            (Integer.parseInt(tempVO.getString("orddd")) <= Integer.parseInt(DateHelper.getDay())) &&
                            (StringHelper.strEquals(vsuppkind , "87") || StringHelper.strEquals(vsuppkind , "88") ||
       						 StringHelper.strEquals(vsuppkind , "89"))) 
    				{
                    		msgVO_srdg.set("msg_rooa" , "노인 레진상 완전 틀니를 적용할수 없는 상병입니다![1]");
                    		msgVO_srdg.set("msg_type" , "E");
        					break;
        					
    				}else if (rooaVO1.size() == 0 && 
                			!StringHelper.strEquals(vprcpgenryn ,"1A") &&
                            StringHelper.strEquals(vdracptyn , "Y") &&
                            (Integer.parseInt(tempVO.getString("orddd")) <= Integer.parseInt(DateHelper.getDay())) &&
                            (StringHelper.strEquals(vsuppkind , "61") || StringHelper.strEquals(vsuppkind , "62") ||
       						 StringHelper.strEquals(vsuppkind , "63") || StringHelper.strEquals(vsuppkind , "64")) ) 
    				{
                    		msgVO_srdg.set("msg_rooa" , "중증화상을 적용할수 없는 상병입니다![1]");
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
                			//희귀난치산정특례
                			sRgstkindcd = "01";
                		}else if( StringHelper.strEquals(sSpclflag, "12")){
                			//중증화상
                			sRgstkindcd = "02";
                		}else if( StringHelper.strEquals(sSpclflag, "17")){
                			//노인 레진상 완전 틀니 상악
                			sRgstkindcd = "03";
                		}else if( StringHelper.strEquals(sSpclflag, "18")){
                			//노인 레진상 완전 틀니 하악
                			sRgstkindcd = "04";
                		}else{
                			//희귀난치산정특례
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
                    		msgVO_srdg.set("msg_rooa" , "해당환자는 희귀난치성산정특례번호가 없으므로, [희귀난치성산정특례]로 적용할 수 없습니다.[2]");
                    		msgVO_srdg.set("msg_type" , "E");
                            break;
                        
						}else if (rooaVO.size() == 0 &&
    							!StringHelper.strEquals(rooaVO1.getString(b, "srchflag") ,"A") &&
    							!StringHelper.strEquals(rooaVO1.getString(b, "srchflag") ,"B") &&
    							(StringHelper.strEquals(vsuppkind , "61") || StringHelper.strEquals(vsuppkind , "62") ||
    							 StringHelper.strEquals(vsuppkind , "63") || StringHelper.strEquals(vsuppkind , "64"))) 
    					{
                        	msgVO_srdg.set("msg_rooa" , "해당환자는 중증화상번호가 없으므로, [중증화상]으로 적용할 수 없습니다.[2]");
                        	msgVO_srdg.set("msg_type" , "E");
                            break;
                        
    					}else if (rooaVO.size() == 0 &&
    							!StringHelper.strEquals(rooaVO1.getString(b, "srchflag") ,"A") &&
    							!StringHelper.strEquals(rooaVO1.getString(b, "srchflag") ,"B") &&
    							(StringHelper.strEquals(vsuppkind , "87") || StringHelper.strEquals(vsuppkind , "88") ||
    							 StringHelper.strEquals(vsuppkind , "89"))) 
    					{
                        	msgVO_srdg.set("msg_rooa" , "해당환자는 노인레진상완전틀니 신청번호가 없으므로, [노인레진상완전틀니]로 적용할 수 없습니다.[2]");
                        	msgVO_srdg.set("msg_type" , "E");
                            break;
                        }
                    	
                		msgVO_srdg = this.fRooaInfoVeri_check(pVO.getRowAsVo(a) , rooaVO1.getString(b, "vcode"), rooaVO1.getString(b, "suppkind") , rooaVO1.getString(b, "srchflag"), rooaVO);
						
						if ( log.isDebugEnabled() ) {
						 log.debug("**----mgr Impl 희귀난치성산정특례msg------**  " );
						 log.debug("msg_rooa :" + msgVO_srdg.getString("msg_rooa"));
						 log.debug("popsuppkind :" + msgVO_srdg.getString("msg_suppkind"));
						}

                        if(!StringHelper.strEquals(msgVO_srdg.getString("msg_rooa") , "")) break;
                        
                        //무인수납일 경우만 체크
                        if ("K".equals(sFlag)) {
                        	if (rooaVO.size() > 0 && rooaVO1.size() > 0) {
	    	                	if ("N".equals(rooaVO.getString("rooa_anohosprgstflag")) && "N".equals(rooaVO.getString("rooa_signyn")) &&
	    	                		"20090701".compareTo(tempVO.getString("orddd")) <= 0 && "20090930".compareTo(tempVO.getString("orddd")) >= 0) {
	    	                		String vgenrddtext       = StringHelper.toSubString(rooaVO.getString("rooa_genrdd"), 4, 6) + "월" + StringHelper.toSubString(rooaVO.getString("rooa_genrdd"), 6, 8) + "일";
	    	                		msgVO_srdg.set("msg_rooa" , vgenrddtext + " 희귀난치성산정특례 신청서 작성 환자입니다. Sign내역이 없습니다.[14]");
	    	                		msgVO_srdg.set("msg_type" , "I");
	    	                	}
	                    	}
                        }
                        
                        //보조유형과 일치하는 희귀난치성산정특례 체크
                        if( StringHelper.strEquals(vsuppkind, rooaVO1.getString(b, "suppkind"))){
                        	
                        	CheckSuppkind = true;                        	
                        }else{
                        	
                        	sSuppkind.append(" " + rooaVO1.getString(b, "suppkind") + " ");
                        }
                    }
                	
                	/*
                	 * if( CheckSuppkind == false		//보조유형 일지항목 없음
                			&& rooaVO1.size() > 0		//산정특례대상 상병
                			//산정특례 다른 오류 없을 때 적용
                			&& ( msgVO_srdg.size() < 1 || StringHelper.strEquals(msgVO_srdg.getString("msg_rooa") , "") ) 
                			//산정특례 적용 보조유형만 체크
                			&& ( StringHelper.strEquals(vsuppkind , "50") || StringHelper.strEquals(vsuppkind , "51") ||
       							   StringHelper.strEquals(vsuppkind , "46") || StringHelper.strEquals(vsuppkind , "02") ||
    							   StringHelper.strEquals(vsuppkind , "03") || StringHelper.strEquals(vsuppkind , "04"))){
                		
//                		msgVO_srdg.set("msg_rooa" , "현재 보조유형으로 산정특례 적용할 수 없습니다."
//                											+ "\n상병과 보조유형을 확인하신 후 수납하세요!"
//                											+ "\n수납 가능 보조유형["+ sSuppkind.toString() + "]");
//                		msgVO_srdg.set("msg_type" , "E");
                	}
                	*/
                }
             }

             return msgVO_srdg;
    }

	//view인 대상 수가코드 체크[_,= 문자포함]
	public ValueObject getViewCalcChk(ValueObject pVO) throws LiveException {

		//기관코드 조회
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//사용자 조회
		if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
			pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
		}

		return outrcptmngtDAO.getViewCalcChk(pVO);
	}

	/*
	 * (비Javadoc)
	 * 실시정산용 실시일자테이블 입력
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

         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		return outrcptmngtDAO.delOutOrdActr(pVO);
	}

	//실시정산수납대상건 처방리스트
	public ValueObjectAssembler getPopupActrList(ValueObject pVO) throws LiveException{
		
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

		ValueObject actr  = null;
		ValueObject exop  = null;
		ValueObjectAssembler retVOs = new ValueObjectAssembler();

		actr = outrcptmngtDAO.getPopupActrList(pVO);         //실시정산수납대상건
		exop = outrcptmngtDAO.getPopupActrExopList(pVO);     //실시정산수납대상건 처방리스트

		retVOs.set("actr"   , actr);
		retVOs.set("exop"   , exop);
		
		return retVOs;
		
	}
	
	//무인수납 체크 실시정산수납대상건 처방리스트
	public ValueObject getPopupActrKiosk(ValueObject pVO) throws LiveException{
		
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

        return outrcptmngtDAO.getPopupActrList(pVO);         //실시정산수납대상건
		
	}
	
	
    // 20090703 타과 요율변경
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
        
        if (otptVO.size() > 1) {	//두건 이상일 경우만....
            for (int a = 0; a < otptVO.size(); a++) {
            	vinsukind          = StringHelper.null2void(otptVO.getString(a,"insukind"));
                vsuppkind         = StringHelper.null2void(otptVO.getString(a,"suppkind")); 
                vsuppkindsubyn = StringHelper.null2void(otptVO.getString(a,"suppkindsubyn"));  //보조유형의 부과여부 주과 N, 부과 Y(주과일때만 체크한다) ?????
                vdracptyn         = StringHelper.null2void(otptVO.getString(a,"dracptyn"));
                
            	if ((StringHelper.strEquals(vinsukind , "11") || StringHelper.strEquals(vinsukind , "21")) &&
            			!StringHelper.strEquals(vsuppkind , "06") && !StringHelper.strEquals(vsuppkind , "11") &&
                        !StringHelper.strEquals(vsuppkind , "38") && !StringHelper.strEquals(vsuppkind , "40") &&
                        !StringHelper.strEquals(vsuppkind , "01") && !StringHelper.strEquals(vsuppkind , "12") &&
                        !StringHelper.strEquals(vsuppkind , "13") && !StringHelper.strEquals(vsuppkind , "32")) {
            		
            		if (StringHelper.strEquals(vsuppkind , "02") || StringHelper.strEquals(vsuppkind , "03") ||
	                     StringHelper.strEquals(vsuppkind , "04") || StringHelper.strEquals(vsuppkind , "34") ||
	                     StringHelper.strEquals(vsuppkind , "35") || StringHelper.strEquals(vsuppkind , "36")) {
            	
            			if ("Y".equals(vdracptyn) && "N".equals(vsuppkindsubyn)) {	//원유형
			                //차상위환자 특별처리 - 보조유형 차상위를 건강보험의 보조유형으로 임시로 바꿔서 중증체크를 한다.
			                if( (Integer.parseInt(vsuppkind) > 32)  && (Integer.parseInt(vsuppkind) < 46)) {
			                    vsuppkind = this.getChgScnd(otptVO.getRowAsVo(a)).getString("final_suppkind");
			                }
			                //차상위환자 특별처리 끝
			                
			                
			                ValueObject tempVO = new ValueObject();
		
		                    tempVO.set("pid"          , StringHelper.null2void(otptVO.getString(a,"pid")));
		                    tempVO.set("orddd"       , StringHelper.null2void(otptVO.getString(a,"orddd")));
		                    tempVO.set("orddeptcd" , StringHelper.null2void(otptVO.getString(a,"orddeptcd")));
		                    tempVO.set("mskind"     , StringHelper.null2void(otptVO.getString(a,"mskind")));
		                    tempVO.set("insukind"   , StringHelper.null2void(otptVO.getString(a,"insukind")));
		                    tempVO.set("cretno"     , otptVO.getString(a,"cretno"));
		                    tempVO.set("instcd"      , StringHelper.null2void(otptVO.getString(a,"instcd")));
		                    
		                    //2012-11-01 연속처방이라 하더라도 중증및 산정특례 적용은 실시일자 기준으로 적용한다.
	                        //체크로직 주석처리
		                    //연속처방일경우 원진료일자 상병 구하기
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
									 log.debug("**----mgr Impl 타과 요율변경msg------**  " );
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
				                			rcvVO2.set("calcflaggubn", "미수납");
				                		} else if ("Y".equals(StringHelper.null2void(otptVO.getString(a,"calcflag")))) {
				                			rcvVO2.set("calcflaggubn", "미계산");
				                		} else if ("N".equals(StringHelper.null2void(otptVO.getString(a,"calcflag")))) {
				                			rcvVO2.set("calcflaggubn", "수   납");
				                		}
				                		rcvVO2.set("spclcd", StringHelper.null2void(otptVO.getString(a,"spclcd")));
			                		}
			                    }
		                	}
            			} //if ("Y".equals(vdracptyn)) {
            		} else {
            			if ( log.isDebugEnabled() ) {
							 log.debug("**----mgr Impl 타과 요율변경 bAppFlag = true; ------**  " );
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
            	}//보험유형 체크
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
			 log.debug("**----mgr 타과 요율변경 return value------**  " );
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
			 
			 log.debug("**----mgr 타과 요율변경 return value------**  " );
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
 	//	   throw new LiveException("이미 선택된 내역과 계산상태가 다를 경우에는 내역을 선택할수없습니다.");
 	//	 }
         return rcvVOs;
    }


    /**
     * 외래수납 2009/7/17 조영상
     * 장애인수첩소지여부 체크
     * @author cys
     * @param pVOs ValueObjectAssembler
     * @return ValueObjectAssembler
     * @throws LiveException
     */
    public ValueObject getHndcCnt(ValueObject pVO) throws LiveException{
        
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
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


    //환자연속처방내역조회 cys 20091015
    public ValueObject getExopActList(ValueObject pVO) throws LiveException{
        
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }

        return outrcptmngtDAO.getExopActList(pVO);
        
    }
    
    
    /* 장기이식 환자 정보 조회
     * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.OutRcptMgt#getTranInfo(kr.co.hit.live.vo.ValueObject)
     */
    public ValueObject getTranInfo(ValueObject pVO) throws LiveException{
        
        //기관코드 조회
       if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
           pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
       }
       
       //사용자 조회
       if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
           pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
       }

       return outrcptmngtDAO.getTranInfo(pVO);
       
   }


    //취소처리 케이스 체크 cys 20091110
    public boolean getCnclCase_Chk(ValueObject pVO) throws LiveException{
        
        boolean bl_rtn = false;

        //취소처리 케이스(수납전체크로직,수납,0원수납)
        //1.물리치료,주사예약이면서 진찰료미산정이고 처방 없는 경우
        //2.방사선종양학과이면서 진찰료미산정이고 처방없는경우
        //3.수납에서 강제로 취소한경우
        if ( (StringHelper.strEquals(pVO.getString("etcordflag"),"M") && StringHelper.strEquals(pVO.getString("medamtestmyn"),"N")) ||
             
             (StringHelper.strEquals(pVO.getString("etcordflag"),"J")  && StringHelper.strEquals(pVO.getString("medamtestmyn"),"N")) ||
             
             (StringHelper.strEquals(pVO.getString("etcordflag"),"T")  && StringHelper.strEquals(pVO.getString("medamtestmyn"),"N")  && StringHelper.strEquals(pVO.getString("orddeptcd"),"2170000000")) ||

             (StringHelper.strEquals(pVO.getString("rsrvflag"),"A")     && StringHelper.strEquals(pVO.getString("medamtestmyn"),"N")  && StringHelper.strEquals(pVO.getString("specordyn"),"N"))){

                bl_rtn = true;

             }

        return bl_rtn;
        
    }
    
	//외래 환불금 선수금 처리
	public int insRtnBogj(ValueObject pVO) throws LiveException {

		ValueObject bogjVO = new ValueObject ();
		int bogjAmt = 0;

		bogjAmt  =  Integer.parseInt(pVO.getString("cashamt")) * -1;
		 
		//선수금 환불
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

    //약국용 인터페이스 호출 20100202 cys
    public ValueObjectAssembler getCallPharmlib(ValueObject pVO) throws LiveException{
        
		ValueObject pharmInVO = new ValueObject();		
		ValueObjectAssembler pharmInVOs = new ValueObjectAssembler ();
		ValueObjectAssembler pharmOutVOs = new ValueObjectAssembler ();

       /*  필요파라미터
           pid,
           orddd(actingorddd 절대 아님),
           cretno,
           orddeptcd,
           orddrid,
           instcd,
           ioflag(입원/외래구분(I/O), 여기서는 "O"로 넣어줌)
           prcpgenrflag(찾기 힘들면 "O"로 넣어줌)
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
     * 진료의뢰내역 조회
     * 세종병원 이동재 추가 진료의뢰서 조회쿼리가 없었음.
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

	//원무수납에서 원외처방전 출력기능
	public ValueObject getHosoOutOrderList(ValueObject pVO) throws LiveException {
		
         //기관코드 조회
        if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
            pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
        }
        
        //사용자 조회
        if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
            pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
        }
		
		return outrcptmngtDAO.getHosoOutOrderList(pVO);
	}
    
	/*
	 * (비Javadoc)
	 * 타병원 투석 처리
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.OutRcptMgt#setSuppkindsubyn(kr.co.hit.live.vo.ValueObject)
	 */
	public int setSuppkindsubyn(ValueObject pVO) throws LiveException {

		int iCount = 0;
		
		//기관코드 조회
		if (StringHelper.strEquals(pVO.getString("sessinstcd"), "")) {
			pVO.set("sessinstcd",StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE)));
		}
		
		//사용자 조회
		if (StringHelper.strEquals(pVO.getString("sessuserid"), "")) {
			pVO.set("sessuserid",StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID)));
		}

		iCount = outrcptmngtDAO.setSuppkindsubyn(pVO);
		
		return iCount;
	}
    
    //처방특진여부 N으로 변경 20110401 cys
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

    //처방특진여부 원복 20110401 cys
	public int setChngSpecR(ValueObject pVO) throws LiveException {

		int iCount = 0;

        String sInstCd = StringHelper.null2void((String) getServiceContext().getRole(Role.DUTY_PLACE_INST_CODE));
        String sUserId = StringHelper.null2void((String) getServiceContext().getRole(Role.USER_ID));
		
        for (int a = 0; a < pVO.size(); a++) {

            pVO.set(a,"sessinstcd" , sInstCd);
			pVO.set(a,"sessuserid" , sUserId);

        }

		iCount = outrcptmngtDAO.setChngSpecR(pVO);


        //선택진료감면 신청한 리스트 삭제(처방)
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
