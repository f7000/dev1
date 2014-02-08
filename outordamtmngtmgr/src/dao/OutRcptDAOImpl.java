/**
 * @(#) OutRcptDAOImpl.java
 *수정이력
 * 		- 2007. 4. 02 / 최초작성 / 최희경
 */
package himed.his.pam.outordamtmngtmgr.outrcptmgt.dao;

import kr.co.hit.live.dao.JdbcQueryDAO;
import kr.co.hit.live.context.ContextAwareService;
import kr.co.hit.live.exception.LiveException;
import kr.co.hit.live.query.SqlQuery;
import kr.co.hit.live.query.SqlQueryPage;
import kr.co.hit.live.util.StringHelper;
import kr.co.hit.live.vo.ValueObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 *  <P> 외래수납 DAO Interface의 구현 Class</P>
 *  본 클래스는 외래수납을 관리하는 OutRcptDAO Interface의 구현클래스이다. 
 *  
 *  @author  최희경
 *  @version 1.0  2007. 4. 02
 */
public class OutRcptDAOImpl extends JdbcQueryDAO implements OutRcptDAO {

	private SqlQueryPage sqlPage = null;

	protected static final Log log = LogFactory.getLog(OutRcptDAOImpl.class);
	
	/**
	 * 사용할 SQL 문이 정의된 SQL XML 파일 경로를 설정하는
	 * Setter Method
	 * @param path SQL XML 파일의 상대 경로
	 */
	public void setSql(String path) {
		sqlPage = getQueryPage(path);
	}

	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getMdlAmtList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getMdlAmtList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getMdlAmtList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getCardAmtList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getCardAmtList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getCardAmtList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getCashAmtList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getCashAmtList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getCashAmtList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getOnlineAmtList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOnlineAmtList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOnlineAmtList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getMdlRemAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getMdlRemAmt(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getMdlRemAmt");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getMdlRemAmt2(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getMdlRemAmt2(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getMdlRemAmt2");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getRcptNo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getRcptNo(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getRcptNo");
				
		getVO = executeQuery(sql, pVO);
		
		return getVO;
	}

	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insMdlAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insMdlAmt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insMdlAmt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insOnlineAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insOnlineAmt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insOnlineAmt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}
	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setMdlAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int setOnlineAmt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setOnlineAmt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setRcptNo(kr.co.hit.live.vo.ValueObject)
	 */
	public int setRcptNo(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setRcptNo");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insRcptNo(kr.co.hit.live.vo.ValueObject)
	 */
	public int insRcptNo(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insRcptNo");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setOutOrdAmtOscl(kr.co.hit.live.vo.ValueObject)
	 */
	public int setOutOrdAmtOscl(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setOutOrdAmtOscl");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}
	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setOutOrdAmtOtpt(kr.co.hit.live.vo.ValueObject)
	 */
	public int setOutOrdAmtOtpt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setOutOrdAmtOtpt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}
	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setOutOrdStat(kr.co.hit.live.vo.ValueObject)
	 */
	public int setOutOrdStat(ValueObject pVO) throws LiveException {		

		int retCount1 = -1;
		int retCount2 = -1;
		int retCount3 = -1;
		int retCount4 = -1;
		
		//MMOHOPRC, MMODEXOP
		SqlQuery sql = sqlPage.getQuery("setOutOprcStat");		
		retCount1 = executeUpdate(sql,pVO);
		
		SqlQuery sql2 = sqlPage.getQuery("setOutExopStat");
		retCount2 = executeUpdate(sql2,pVO);
		
		SqlQuery sql3 = sqlPage.getQuery("setOutOprcHoldStat");		
		retCount3 = executeUpdate(sql3,pVO);

		SqlQuery sql4 = sqlPage.getQuery("setOutExopHoldStat");		
		retCount4 = executeUpdate(sql4,pVO);

		return retCount1;

	}
	
	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getOutRgstList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOutRgstList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOutRgstList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getOutRgstList2(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOutRgstList2(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOutRgstList2");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	
	/* 보험정보조회
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getInsuInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getInsuInfo(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getInsuInfo");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	
	/* 중증정보조회
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getSrdgInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getSrdgInfo(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getSrdgInfo");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}


	/* 자보자격정보 조회
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getAipmInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getAipmInfo(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getAipmInfo");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	/* 산재자격정보 조회
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getIcpmInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getIcpmInfo(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getIcpmInfo");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getOsclInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOsclInfo(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOsclInfo");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	/* 원외약존재여부 조회
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getOutOrdExist(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOutOrdExist(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOutOrdExist");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	/* 장애인환자여부 조회
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getHandicapYN(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getHandicapYN(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getHandicapYN");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	/* 연속처방 외래등록 또는 일반 외래등록의 원 ORDDD  조회 - 약국집계용
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getHandicapYN(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOrddd(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOrddd");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getInsuRateInf(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getInsuRateInfo(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getInsuRateInfo");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getOpmiInfoFromOscl(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOpmiInfoFromOscl(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOpmiInfoFromOscl");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getPreOpmiInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getPreOpmiInfo(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getPreOpmiInfo");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}


	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setMdlAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int setMdlAmt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setMdlAmt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}
	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insMdlAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insOutOrdAmt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insOutOrdAmt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}
	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getChangelist(kr.co.hit.live.vo.ValueObject)
	 */
	 /*
	public ValueObject getChangelist(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getChangelist");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}	
	*/

	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insMdlAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insOtptHistAdd(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		
		/*
		//외래등록 이력추가.
		SqlQuery sql = sqlPage.getQuery("insOtptHist");
		retCount = executeUpdate(sql,pVO);

		//기존내역 Histstat : R => C
		SqlQuery sql2 = sqlPage.getQuery("setOtptPreHist");
		retCount = executeUpdate(sql2,pVO);
		*/

		//외래등록 이력추가
		SqlQuery sql2 = sqlPage.getQuery("setOtptAddHist");
		retCount = executeUpdate(sql2,pVO);

		return retCount;

	}
	
	
	/* M005, M006 본인부담의 경우 상병이 중증/희귀가 아닐경우 체크
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getOwnbflagCheckInfo(ValueObject)
	 */
	public ValueObject getOwnbflagCheckInfo(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOwnbflagCheckInfo");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insMdlAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insOtptHistAddCancel(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		
		if (StringHelper.strEquals(pVO.getString("workgubn"),"Y")) {	
			
			/*
			//외래등록 이력추가
			SqlQuery sql = sqlPage.getQuery("insOtptHistCancel");
			retCount = executeUpdate(sql,pVO);
	
			if (retCount == 0) {
				pVO.set("histstat","R");								
				SqlQuery sql1 = sqlPage.getQuery("setOtptPreHistCancel");
				retCount = executeUpdate(sql1,pVO);			
				
			} else if (retCount > 0) {
				//기존내역 Histstat : R => C
				pVO.set("histstat","C");									
				SqlQuery sql2 = sqlPage.getQuery("setOtptPreHist");
				retCount = executeUpdate(sql2,pVO);
			}
			*/
				pVO.set("histstat","R");								
				SqlQuery sql1 = sqlPage.getQuery("setOtptPreHistCancel");
				retCount = executeUpdate(sql1,pVO);	

		} else {
			//외래등록 이력추가

//			System.out.println("-----이동재20080123--calcstat--->"+pVO.getString("calcstat"));	
//			System.out.println("-----이동재20080123--pid--->"+pVO.getString("pid"));			
//			System.out.println("-----이동재20080123--calcstat--->"+pVO.getString("orddd"));			
//			System.out.println("-----이동재20080123--calcstat--->"+pVO.getString("cretno"));
//			System.out.println("-----이동재20080123--calcstat--->"+pVO.getString("acptseqno"));
//			System.out.println("-----이동재20080123--calcstat--->"+pVO.getString("instcd"));		
			
			SqlQuery sql = sqlPage.getQuery("setOtptJudgHistCancel");
			retCount = executeUpdate(sql,pVO);
	
			if (retCount > 0) {						
				SqlQuery sql1 = sqlPage.getQuery("delOtptJudg");
				retCount = executeUpdate(sql1,pVO);			
										
				SqlQuery sql2 = sqlPage.getQuery("delOsclJudg");
				retCount = executeUpdate(sql2,pVO);
			}			
		}
		
		return retCount;

	}	

	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getLastOtpt(kr.co.hit.live.vo.ValueObject)
	 * 
	 */
	public ValueObject getLastOtpt(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getLastOtpt");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	
	
	
	public int insPtinHistAdd(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		ValueObject getVO = null;
		//작성중
		//보험정보 이력추가
		ValueObject insVO 		= pVO;	//신규
		ValueObject preinsVO 	= pVO;	//기존내역 신규생성
		ValueObject presetVO 	= pVO;	//기존내역 C update
		
		//System.out.println("------정산시,보험정보 입력 테스트 1111-----------");
		
		//기존내역 중 적용기간에 포함되는 대한 내역이 있는지 체크
		//있으면, add할 필요없음, 없으면,add
		 SqlQuery sql = sqlPage.getQuery("getPtinHist");		
		 getVO = executeQuery(sql, pVO);
		 
		 //System.out.println("------정산시,보험정보 입력 테스트 2222-----------");
		 if (getVO.size()>0) {
			 
			 //System.out.println("------정산시,보험정보 입력 테스트 AAAA-----------");
		 	
		 	//현재 R 인내역 Copy 하되, 일자 종료시킴 - (fromdd-1)기존내역에 종료일 update 시키는 insert
			preinsVO.set("ptin_histstat","Y"); 	
			SqlQuery sql2 = sqlPage.getQuery("insPtinPreHist");
		 	retCount = executeUpdate(sql2,preinsVO);
		 	
		 	//System.out.println("------정산시,보험정보 입력 테스트 CCCC-----------");
		 	
		 	//기존내역 R->C
		 	SqlQuery sql1 = sqlPage.getQuery("setPtinPreHist");
		 	presetVO.set("ptin_histstat","C");
		 	retCount = executeUpdate(sql1,presetVO);
		 	//System.out.println("------정산시,보험정보 입력 테스트 DDDD-----------");
		 	
		 	//신규내역 insert
		 	//변경정보로 insert
		 	 insVO.set("ptin_histstat","Y"); 	
		 	SqlQuery sql3 = sqlPage.getQuery("insPtinHist");
		 	retCount = executeUpdate(sql3,insVO);
		 	//System.out.println("------정산시,보험정보 입력 테스트 EEEE-----------");
		 	
		 
		 }
		 else {
			 
			 //System.out.println("------정산시,보험정보 입력 테스트 BBBB-----------");
			 insVO.set("ptin_histstat","Y"); 	
		 	SqlQuery sql2 = sqlPage.getQuery("insPtinHist");
		 	retCount = executeUpdate(sql2,insVO);
		 
		 } 
		  
		
		//기존내역 Histstat : R => C
		//같은 보험유형에 대해, 기존내역이 있을 경우, Y=>C update
		 //SqlQuery sql2 = sqlPage.getQuery("setPtinPreHist");
		 //retCount = executeUpdate(sql2,pVO);
		
		 //SqlQuery sql = sqlPage.getQuery("insPtinHist");
		 //retCount = executeUpdate(sql,pVO);
		
		
		return retCount;

	}

	public int insPtdcHistAdd(ValueObject pVO) throws LiveException {		
		int retCount = -1;
//		작성중
		/*
		//감면정보 이력추가
		SqlQuery sql = sqlPage.getQuery("insOtptHist");
		retCount = executeUpdate(sql,pVO);
		
		//기존내역 Histstat : R => C
		SqlQuery sql2 = sqlPage.getQuery("setOtptPreHist");
		retCount = executeUpdate(sql2,pVO);
		*/
		return retCount;

	}

	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getPatInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getPatInfo(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getPatInfo");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getPatDiag(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getPatDiag(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getPatDiag");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}


	/* 외래수납내역 조회- 외래등록키 조건으로
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getopmiList3(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getopmiList3(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getopmiList3");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getOtptInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOtptInfo(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOtptInfo");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getEarnInfo2(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getEarnInfo2(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getEarnInfo2");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getEarnInfo3(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getEarnInfo3(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getEarnInfo3");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}	
	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getEarnInfo2(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getEarnInfo4(ValueObject pVO) throws LiveException {		
		ValueObject getVO = new ValueObject();
		ValueObject tmpVO = new ValueObject();
		
		//SqlQuery sql = sqlPage.getQuery("getEarnInfo4");
		
		//2013-02-12 외래등록 속도 튜닝! 원무키로 조회해서 금액을 합하도록 수정.
		SqlQuery sql = sqlPage.getQuery("getEarnInfo4New");
		
		for(int i=0; i < pVO.size(); i++ ){
			
			tmpVO = executeQuery(sql, pVO.getRowAsVo(i));
			
			if( i == 0 ){
				for ( int j=0; j < tmpVO.size(); j++ ){
					
					getVO.set(j, "earn_rcptcls", tmpVO.getString(j, "earn_rcptcls"));
					getVO.set(j, "earn_rcptclsnm", tmpVO.getString(j, "earn_rcptclsnm"));
					getVO.set(j, "earn_payamt", tmpVO.getInt(j, "earn_payamt"));
					getVO.set(j, "earn_nopyamt", tmpVO.getInt(j, "earn_nopyamt"));
					getVO.set(j, "earn_specamt", tmpVO.getInt(j, "earn_specamt"));
				}
			}else{
				
				for ( int k=0; k < getVO.size(); k++ ){
					
					for ( int j=0; j < tmpVO.size(); j++ ){
						
						if( StringHelper.strEquals(getVO.getString(k, "earn_rcptcls"), tmpVO.getString(j, "earn_rcptcls"))){
							
							getVO.set(k, "earn_payamt", tmpVO.getInt(j, "earn_payamt") + getVO.getInt(k, "earn_payamt"));
							getVO.set(k, "earn_nopyamt", tmpVO.getInt(j, "earn_nopyamt") + getVO.getInt(k, "earn_nopyamt"));
							getVO.set(k, "earn_specamt", tmpVO.getInt(j, "earn_specamt") + getVO.getInt(k, "earn_specamt"));
							
							j = tmpVO.size();
						}
					}
					
				}
			}
		}
		
		//getVO = executeQuery(sql, pVO);

		return getVO;
	}

	
	/* 외래 수납 DC 내역 생성
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insMdlAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insOutOrdAmtDC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insOutOrdAmtDC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}
	
	/* 외래 계산내역  DC 내역 생성
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insMdlAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insOSCLDC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insOSCLDC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	
	/* 기존 외래수납 [변경]상태로 세팅
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insMdlAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int setOutOrdAmtC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setOutOrdAmtC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}
	
	/* 기존 외래계산 [변경]내역 
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insMdlAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int setOSCLC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setOSCLC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}	

	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getOtptInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOtptInfo2(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOtptInfo2");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getOtptInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOtptInfo3(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOtptInfo3");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	
	/* 처방 조회(처방홀드 위해 처방조회-외래수납화면)
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getprcpList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getprcpList2(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getprcpList2");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	/* 처방 조회(처방홀드 위해 처방조회-외래수납화면)
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getprcpList(kr.co.hit.live.vo.ValueObject)
	 */
	 /*
	public ValueObject getholdDDList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getholdDDList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	*/

	/* 처방 조회(처방홀드 위해 처방조회-외래수납화면)
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getprcpList(kr.co.hit.live.vo.ValueObject)
	 */
	 /*
	public ValueObject getholdList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getholdList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	*/
	
	
	/* 청구대상상태 [변경] 
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insMdlAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int setClamTrgtStat(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setClamTrgtStat");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}	
	
	/* 카드수납내역 생성
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insOnlineAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insCardAmt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insCardAmt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	
	/* 현금영수증수납내역 생성
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insCashAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insCashAmt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insCashAmt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}
	
	
	/* 미수내역 생성
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insUncoAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insUncoAmt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insUncoAmt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}	
	
	/* DC 미수내역 생성  
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insUncoAmtDC(kr.co.hit.live.vo.ValueObject)
	 */
	public int insUncoAmtDC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insUncoAmtDC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}	

	/* 미수내역 변경
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insUncoAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int setUncoAmtC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setUncoAmtC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}	
	
	
	/* 할인,감액내역 생성
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insDcgmAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insDcgmAmt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insDcgmAmt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}		

	/* DC 할인,감액내역 생성
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insDcgmAmtDC(kr.co.hit.live.vo.ValueObject)
	 */
	public int insDcgmAmtDC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insDcgmAmtDC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	/* 할인,감액내역 변경
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setDcgmAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int setDcgmAmtC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setDcgmAmtC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}		

	/* 헌혈증 할인,감액내역 생성
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insBldcAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insBldcAmt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insBldcAmt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}		

	/* DC 헌혈증 할인,감액내역 생성
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insBldcAmtDC(kr.co.hit.live.vo.ValueObject)
	 */
	public int insBldcAmtDC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insBldcAmtDC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	/* 헌혈증 할인,감액내역 생성
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setBldcAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int setBldcAmtC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setBldcAmtC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}		
	
	/* 카드 DC 내역 생성(정산시)
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insCardAmtDC(kr.co.hit.live.vo.ValueObject)
	 */
	public int insCardAmtDC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insCardAmtDC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	/* 카드 내역 변경
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setCardAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int setCardAmtC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setCardAmtC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}		

	/* 기 카드 내역 생성(정산시)
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insPreCardAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insPreCardAmt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insPreCardAmt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}
	
	
	/* 현금영수증 DC 내역 생성(정산시)
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insCashAmtDC(kr.co.hit.live.vo.ValueObject)
	 */
	public int insCashAmtDC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insCashAmtDC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	/* 현금영수증 내역 변경
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setCashAmtC(kr.co.hit.live.vo.ValueObject)
	 */
	public int setCashAmtC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setCashAmtC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}		

	/* 중간금 DC 내역 생성(정산시)
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insBogjAmtDC(kr.co.hit.live.vo.ValueObject)
	 */
	public int insBogjAmtDC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insBogjAmtDC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	/* 중간금 내역 변경
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setBogjAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int setBogjAmtC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setBogjAmtC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}		
	
	
	/* 외래선수금 취소내역 생성
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insMdlAmtCncl(kr.co.hit.live.vo.ValueObject)
	 */
	public int insMdlAmtCncl(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insMdlAmtCncl");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}
	
	/* 카드수납취소내역 생성
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insCardAmtCncl(kr.co.hit.live.vo.ValueObject)
	 */
	public int insCardAmtCncl(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insCardAmtCncl");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	
	/* 현금영수증수납취소내역 생성
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insCashAmtCncl(kr.co.hit.live.vo.ValueObject)
	 */
	public int insCashAmtCncl(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insCashAmtCncl");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	/* 카드수납내역 변경
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setCardAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int setCardAmt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setCardAmt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	
	/* 현금영수증승인수납내역 변경
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setCashAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int setCashAmt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setCashAmt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}
	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insOnlineAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insOnlineAmtCncl(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insOnlineAmtCncl");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}
	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getPtin1(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getPtin1(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getPtin1");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insPtinHist(kr.co.hit.live.vo.ValueObject)
	 */
	public int insPtinHist(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		
		//보험정보 이력추가
		SqlQuery sql = sqlPage.getQuery("insPtinHist");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setPtinPreHist(kr.co.hit.live.vo.ValueObject)
	 */
	public int setPtinPreHist(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		
		//보험정보 이력추가
		SqlQuery sql = sqlPage.getQuery("setPtinPreHist");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}
	
    /**
     * 진료의뢰환자 관리
     *
     * @param pVO ValueObject
	 * @return Integer
	 * @throws LiveException
	 */
    public int setCNST(ValueObject pVO) throws LiveException {      
        
        int retCount = -1;
        SqlQuery sql = null;
        
        String cnst_stat = StringHelper.null2void(pVO.getString("cnst_stat"));
        
        if (StringHelper.strEquals(cnst_stat, "I")){
        	sql = sqlPage.getQuery("insCNST1");
        	retCount = executeUpdate(sql,pVO);
        }
        else if (StringHelper.strEquals(cnst_stat, "U")) {           
        	sql = sqlPage.getQuery("setCNST1");       	
        	retCount = executeUpdate(sql,pVO);
        	
        	if (retCount > 0){
	        	sql = sqlPage.getQuery("insCNST1");
	        	retCount = executeUpdate(sql,pVO);
        	}
        }
        else if (StringHelper.strEquals(cnst_stat, "D")){
        	sql = sqlPage.getQuery("delCNST1");
        	retCount = executeUpdate(sql,pVO);
        }
		
		return retCount;
    }
    
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setHoldPrcpList(kr.co.hit.live.vo.ValueObject)
	 */
	public int setHoldPrcpList(ValueObject pVO) throws LiveException {		

		int retCount1 = -1;
		//int retCount2 = -1;	
		
		int retCount3 = -1;
		int retCount4 = -1;

		//PAOHEXOP
		//SqlQuery sql1 = sqlPage.getQuery("InsExopTriger");		
		//retCount1 = executeUpdate(sql1,pVO);
		
		//SqlQuery sql4 = sqlPage.getQuery("setOutExopHold");
		//retCount4 = executeUpdate(sql4,pVO);


		
		//MMOHOPRC, MMODEXOP
		//SqlQuery sql3 = sqlPage.getQuery("setOutOprcHold");		
		//retCount3 = executeUpdate(sql3,pVO);
		
		SqlQuery sql4 = sqlPage.getQuery("setOutExopHold");
		retCount4 = executeUpdate(sql4,pVO);
		
		return retCount1;
	}
	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setAddOTPTFromHold(kr.co.hit.live.vo.ValueObject)
	 */
	public int setAddOTPTFromHold(ValueObject pVO) throws LiveException {		
		int retCount1 = -1;
		int retCount2 = -1;
		
		//Release 시 외래등록 추가
		SqlQuery sql = sqlPage.getQuery("setAddOTPTFromHold");		
		retCount1 = executeUpdate(sql,pVO);
		
		//기존 외래등록내역 C Update
		SqlQuery sql2 = sqlPage.getQuery("setCOTPTFromHold");		
		retCount2 = executeUpdate(sql2,pVO);		
			
		return retCount1;
	}

	/*
	 *  (비Javadoc)외래등록조
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getOtptList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOtptList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOtptList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	
	/* 환자상세내역조회_외래등록리스트_수납내역리스트  조회
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#GetOutRcptSpec(kr.co.hit.live.vo.ValueObject)
	 * 
	 */
	public ValueObject getOutRcptSpec(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOutRcptSpec");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}


	/*
	 *  (비Javadoc) 수납시점의 액팅처리(혈액은행 혈액료-수혈,헌혈
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setActing(kr.co.hit.live.vo.ValueObject)
	 */
	public int setActing(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setActing");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	/*
	 *  (비Javadoc) 수납시점의 계산내역 액팅처리(혈액은행 혈액료-수혈,헌혈
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setActing(kr.co.hit.live.vo.ValueObject)
	 */
	public int setActingOscl(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setActingOscl");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	
	/* VAN승인정보만 있는 카드내역 조회
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getprcpList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getonlycvanList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getonlycvanList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	

	/* 요율변경내역 조회
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getupdtrateList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getupdtrateList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getupdtrateList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	

	/* 당일투석진료내역
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getupdtrateList1(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getupdtrateList1(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getupdtrateList1");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}	
	
	/* 요율변경내역 변경
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setupdtrateList(kr.co.hit.live.vo.ValueObject)
	 */
	public int setupdtrateList(ValueObject pVO) throws LiveException {		
		
		int retCount = -1;
		int retCount2 = -1;
		
		SqlQuery sql = sqlPage.getQuery("setupdtrateList");
		retCount = executeUpdate(sql,pVO);
		
		/*
		SqlQuery sql2 = sqlPage.getQuery("setOtptPreHist");
		retCount2 = executeUpdate(sql2,pVO);
		*/
		
		return retCount;	
	}	

	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getEarnOsclInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getEarnOsclInfo(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getEarnOsclInfo");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}		
	
	
	/**
	 * 외래처방내역에 처방급비정보변경 Update
	 * @author 이동재
	 * @param pVO ValueObject
	 * @return Integer
	 * @throws LiveException
	 */
	public int setOprcPayFlag(ValueObject pVO) throws LiveException {
		int retCount = -1;

		SqlQuery sql = sqlPage.getQuery("setOprcPayFlag");  
  	    retCount = executeUpdate(sql,pVO);
		return retCount;
	}			
		
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insMdlAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insOtptHistSuppkindAdd(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		
		//기존내역 Histstat : R => C
		SqlQuery sql2 = sqlPage.getQuery("setOtptPreHist");
		retCount = executeUpdate(sql2,pVO);
		
		return retCount;
	}	
	

	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getMultiChangelist(kr.co.hit.live.vo.ValueObject)
	 */
	 /*
	public ValueObject getMultiChangelist(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getMultiChangelist");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}	
	*/
	
	
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insMultiOtptHistAdd(kr.co.hit.live.vo.ValueObject)
	 */
	public int insMultiOtptHistAdd(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		
		//외래등록 이력추가
		SqlQuery sql = sqlPage.getQuery("insMultiOtptHist");
		retCount = executeUpdate(sql,pVO);

		//기존내역 Histstat : R => C
		SqlQuery sql2 = sqlPage.getQuery("setOtptPreHist");
		retCount = executeUpdate(sql2,pVO);
		
		return retCount;
	}	
	
	
     /**
     * 기현금영수증내역생성
     * 2008.03.19. updated by 조영상
     * 실시정산 수납
     * @param pVO ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int insPreCashAmt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insPreCashAmt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;
	}
	

     /**
     * 기중간금액 내역생성
     * 2008.03.19. updated by 조영상
     * 실시정산 수납
     * @param pVO ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int insPreBogjAmt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insPreBogjAmt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}


     /**
     * 환자진료의뢰서 입력.
     * 2008.05.20. updated by 조영상
     * 
     * @param pVO ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int insOutOrdCnst(ValueObject pVO) throws LiveException {
		
		int retCount = -1;
		
		//cnst테이블 중복체크
		SqlQuery sql1 = sqlPage.getQuery("getOutOrdCnst");
		retCount = executeUpdate(sql1,pVO);
		
		//cnst테이블 데이터 저장
		if(retCount == 0) {
			SqlQuery sql2 = sqlPage.getQuery("insOutOrdCnst");
			retCount = executeUpdate(sql2,pVO);
		}

		return retCount;
	}


    /**
     * 외래급비변경
     * 외래미시행처방 미시행 오더 조회
     * 2008.06.26. updated by 조영상
     * @param pVO ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getOutUnExecPrcpOrdRef(ValueObject pVO) throws LiveException {
		ValueObject getVO = null;

        SqlQuery sql = sqlPage.getQuery("getoutunexecprcpordref");
		getVO = executeQuery(sql, pVO);

	    return getVO;
	}
	
	
	
	/* (non-Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getInUnExecPrcpOrdRef(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getInUnExecPrcpOrdRef(ValueObject pVO) throws LiveException {
		ValueObject getVO = null;

        SqlQuery sql = sqlPage.getQuery("getInUnExecPrcpOrdRef");
		getVO = executeQuery(sql, pVO);

	    return getVO;
	}


    /**
     * 외래급비변경
     * 외래미시행처방 환자 조회
     * 2008.06.26. updated by 조영상
     * @param pVO ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getPayPatInfo(ValueObject pVO) throws LiveException {
		
		ValueObject getVO = null;

        SqlQuery sql = sqlPage.getQuery("getPayPatInfo");
		getVO = executeQuery(sql, pVO);

	    return getVO;
	}


    /**
     * 외래급비변경
     * 외래미시행 처방 내역 조회
     * 2008.06.26. updated by 조영상
     * @param pVO ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getOutUnExecPrcpRef(ValueObject pVO) throws LiveException {
		ValueObject getVO = null;

        SqlQuery sql = sqlPage.getQuery("getoutunexecprcpref");
		getVO = executeQuery(sql, pVO);

	    return getVO;
	}
	
	
	/* (non-Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getInUnExecPrcpRef(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getInUnExecPrcpRef(ValueObject pVO) throws LiveException {
		ValueObject getVO = null;

        SqlQuery sql = sqlPage.getQuery("getInUnExecPrcpRef");
		getVO = executeQuery(sql, pVO);

	    return getVO;
	}


    /**
     * 외래급비변경
     * 외래미시행처방 미시행 통합심사 완료 여부를 변경
     * 2008.06.26. updated by 조영상
     * @param pVO ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int setJudgEnd(ValueObject pVO) throws LiveException {
		int retCounts = 0;

		SqlQuery sql = sqlPage.getQuery("setjudgend");
		retCounts = executeUpdate(sql,pVO);
		
		return retCounts;
	}


    /**
     * 외래급비변경
     * 외래미시행처방 - 처방 급비구분코드 변경 처리
     * 2008.06.26. updated by 조영상
     * @param pVO ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int setOrdPayFlag(ValueObject pVO) throws LiveException {
		int retCounts = 0;
		
		// 1.PAM.PIJHOPRC 삭제
		SqlQuery sql1 = sqlPage.getQuery("delordpayflag1");
		retCounts = executeUpdate(sql1,pVO);
		
		// 2. EMR.MMOHOPRC 원데이터의 급비구분코드를 수정한다.		
		SqlQuery sql2 = sqlPage.getQuery("setordpayflag2");
		retCounts = executeUpdate(sql2,pVO);
		
		//no charge 처리
		if( StringHelper.strEquals(pVO.getString("calcflag"), pVO.getString("calcflag_old"))){
			SqlQuery sql3 = sqlPage.getQuery("setordpayflag4");
			retCounts = executeUpdate(sql3,pVO);
		}
		
		// 3. EMR.MMOHOPRC 의 수정된 데이터를 PAM.PIJHOPRC 히스토리 테이블에 백업저장한다. 
		SqlQuery sql3 = sqlPage.getQuery("setordpayflag3");
		retCounts = executeUpdate(sql3,pVO);
		
		return retCounts;
	}
	
	
	
	/* (non-Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setInOrdPayFlag(kr.co.hit.live.vo.ValueObject)
	 */
	public int setInOrdPayFlag(ValueObject pVO) throws LiveException {
		int retCounts = 0;
		
		// 1.PAM.PIJHIPRC 삭제
//		SqlQuery sql1 = sqlPage.getQuery("delInordpayflag1");
//		retCounts = executeUpdate(sql1,pVO);
		
		// 2. EMR.MMOHIPRC 원데이터의 급비구분코드를 수정한다.
		SqlQuery sql2 = sqlPage.getQuery("setInordpayflag2");
		retCounts = executeUpdate(sql2,pVO);
		
		// 3. EMR.MMOHIPRC 의 수정된 데이터를 PAM.PIJHIPRC 히스토리 테이블에 백업저장한다. 
//		SqlQuery sql3 = sqlPage.getQuery("setInordpayflag3");
//		retCounts = executeUpdate(sql3,pVO);
		
		return retCounts;
	}


    /**
     * 외래급비변경
     * 외래미시행처방 미시행 오더 특정 내역을 삭제
     * 2008.06.26. updated by 조영상
     * @param pVO ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int delOutClcj(ValueObject pVO) throws LiveException {

		int[] retCounts = null;
		SqlQuery sql = sqlPage.getQuery("deloutclcj");
		retCounts = executeBatch(sql,pVO);
		
		return retCounts.length;
	}


    /**
     * 외래급비변경
     * 외래미시행처방 미시행 오더 특정 내역을 추가
     * 2008.06.26. updated by 조영상
     * @param pVO ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int insOutClcj(ValueObject pVO) throws LiveException {
		
		int retCounts = 0;
		SqlQuery sql = sqlPage.getQuery("insoutclcj");
		
		for(int i = 0; i < pVO.size(); i++) {
			retCounts = executeUpdate(sql,pVO.getRowAsVo(i));
		}
		
		return retCounts;
		
		
		/*int[] retCounts = null;
		SqlQuery sql = sqlPage.getQuery("insoutclcj");
		retCounts = executeBatch(sql,pVO);
		
		return retCounts.length;*/
	}


    /**
     * 외래급비변경
     * 외래미시행처방 - 처방 급비구분코드 수정 후, 외래환자 접수 이력정보를 생성한다.
     * 2008.06.26. updated by 조영상
     * @param pVO ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int setOutPatInfoHist(ValueObject pVO) throws LiveException {

		int retCounts = 0;
		
		// 1. PAM.PMOHOTPT 원데이터를 복사하여 추가한다
		//SqlQuery sql1 = sqlPage.getQuery("setoutpatinfohist1");
		//retCounts = executeUpdate(sql1,pVO);
		
		// 2. PAM.PMOHOTPT 원데이터의 HISTSTAT 와 CALCFLAG 를 변경한다.
		//SqlQuery sql2 = sqlPage.getQuery("setoutpatinfohist2");
		//retCounts = executeUpdate(sql2,pVO);

		// 3. PAM.PMOHOTPT CALCFLAG 를 변경한다.
		SqlQuery sql3 = sqlPage.getQuery("setoutpatinfohist3");
		retCounts = executeUpdate(sql3,pVO);


		return retCounts;
	}
	
	
	
	/* (non-Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setInPatInfoHist(kr.co.hit.live.vo.ValueObject)
	 */
	public int setInPatInfoHist(ValueObject pVO) throws LiveException {

		int retCounts = 0;
		
		SqlQuery sql3 = sqlPage.getQuery("setInPatInfoHist");
		retCounts = executeUpdate(sql3,pVO);


		return retCounts;
	}


    /**
     * 외래수납
     * 계산취소시 마지막 otpt를 hist테이블에서 구한다.
     * 2008.06.26. updated by 조영상
     * @param pVO ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getPreOtptHist(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getPreOtptHist");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}


	/**
     * 외래수납
     * 외래수납 계산취소 OTPT에 계산구분 변경
     * 2008.06.26. updated by 조영상
     * @param pVO ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int setOtptCalcflag(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setOtptCalcflag");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}


	/**
     * 외래수납
     * 외래수납 계산취소 OSCL 삭제
     * 2008.07.01. updated by 조영상
     * @param pVO ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int delOsclCancel(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("delOsclCancel");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}


    /*
     * 현금영수증 디폴트 승인번호
     * 2007.07.04. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getPidInfoCshb(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getPidInfoCshb");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}


    /*
     * 의사소견서관리팝업 조회
     * 2007.07.07. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getDrcmList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getDrcmList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}


    /*
     * 의사소견서관리팝업 저장
     * 2007.07.07. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int insDrcmList(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insDrcmList");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}


    /*
     * 의사소견서관리팝업 삭제
     * 2007.07.07. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int delDrcmList(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("delDrcmList");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}


    /*
     * 환자처방내역조회
     * 2007.07.08. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getExopList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getExopList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	/*
     * 계산내역 조회
     * 2008.07.14. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getOsclList(ValueObject pVO ) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOsclList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	/*
     * 외래수납시 등록내역조회
     * 2008.07.23. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getRcptOtptList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getRcptOtptList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}


    /*
     * 방문간호지시서팝업 조회
     * 2007.07.07. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getHocmList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getHocmList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	

    /*
     * 방문간호지시서팝업 저장
     * 2007.07.07. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int insHocmList(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insHocmList");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}


    /*
     * 방문간호지시서팝업 삭제
     * 2007.07.07. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int delHocmList(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("delHocmList");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}


    /*
     * 의사면허번호조회
     * 2007.07.07. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getUsrdlicnsno(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getUsrdlicnsno");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}


    /*
     * 임상연구번호 가져오기
     * 2007.07.28. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getOscl_clincstdyno(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOscl_clincstdyno");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}


    /*
     * 계산시 홀드처방 유무 확인
     * 2007.08.01. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getHoldExop(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getHoldExop");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

    /*
     * 계산시 미수납 처방 유무 확인
     * 2009.04.01. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getUnRcptExop(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getUnRcptExop");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	/*
     * B형 수직감염 처리
     * 2007.08.04. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getVtcltrsCheck(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getVtcltrsCheck");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}


    /*
     * 자보한도환자분리팝업
     * 외래등록내역조회
     * @author cys
     * @param pVOs ValueObject
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getOtptCarInsu(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOtptCarInsu");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

    /*
     * 자보한도환자분리팝업
     * 처방내역조회
     * @author cys
     * @param pVOs ValueObject
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getOprcCarInsu(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOprcCarInsu");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

    /*
     * 자보한도환자분리팝업
     * 외래처방 부유형 분리
     * @author cys
     * @param pVOs ValueObject
     * @return ValueObject
     * @throws LiveException
     */
	public int setOprcCarInsu(ValueObject pVO) throws LiveException {

		int[] retCounts = null;
		SqlQuery sql = sqlPage.getQuery("setOprcCarInsu");
		retCounts = executeBatch(sql,pVO);
		
		return retCounts.length;
	}

    /*
     * 자보한도환자분리팝업
     * 외래등록 미계산상태로 변경
     * @author cys
     * @param pVOs ValueObject
     * @return ValueObject
     * @throws LiveException
     */
	public int setOtptCarFlag(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setOtptCarFlag");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

    /**
     * 외래수납
     * 외래수납시 문자메세지 이력테이블 삭제.
     * 2008.06.26. updated by 조영상
     * @param pVO ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int delOutOrdSmsq(ValueObject pVO) throws LiveException {

		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("delOutOrdSmsq");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;
	}

	/**
	 * 외래수납 2008/1/23 조영상
	 * 정산 수납내역 클릭시 수납내역조회
	 * @author cys
	 * @param pVOs ValueObject
	 * @return ValueObject
	 * @throws LiveException
	 */
	public ValueObject getOutJOpmiList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOutJOpmiList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}


	/**
	 * 외래수납
	 * 최대생성순번구하기
	 * @author cys
	 * @param pVOs ValueObject
	 * @return ValueObject
	 * @throws LiveException
	 */
	public ValueObject getOtptMaxAcptseqno(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOtptMaxAcptseqno");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	/**
	 * 건강생활유지비조회
	 * 수납화면에서 불러오기
	 * @author cys
	 * @param pVOs ValueObjectAssembler
	 * @return ValueObjectAssembler
	 * @throws LiveException
	 */
	public ValueObject getMsg4LifeAmt(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getMsg4LifeAmt");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	/**
	 * 건강생활유지비조회
	 * 수납서버에서 불러오기
	 * @author cys
	 * @param pVOs ValueObjectAssembler
	 * @return ValueObjectAssembler
	 * @throws LiveException
	 */
	public ValueObject getPreLifeAmt(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getPreLifeAmt");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	
	/* 실시정산 지원금 조회
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getExeSuppAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getExeSuppAmt(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getExeSuppAmt");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	/* 장애기금  조회
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getExeHandcapFund(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getExeHandcapFund(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getExeHandcapFund");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	/*카드수납내역 조회
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getcardList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getcardList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getcardList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	
	/*현금영수증승인 수납내역 조회
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getcashList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getcashList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getcashList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	/*통장입금 수납내역 조회
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getonlnList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getonlnList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getonlnList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	/* 기 수혈대체
	 * (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getbldcList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getbldcList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getbldcList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
 
	/* 기 감면내역조회
	 * (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getdcgmList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getdcgmList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getdcgmList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	/* 기 감면내역조회 0원수납용
	 * (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getdcgmList_zero(kr.co.hit.live.vo.ValueObject)
	 */
	 /*
	public ValueObject getdcgmList_zero(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getdcgmList_zero");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	*/

	/* 기 미수내역조회
	 * (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getuncoList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getuncoList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getuncoList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}


	/*
     * 일반의-특진의 변경
     * 2008.09.22 updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int setSpecOrdChng(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setSpecOrdChng");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	/*
     * 외래수납 환자재원정보
     * 2008.09.22. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getInptInfo(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getInptInfo");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	/*
     * 외래수납 환자 가퇴원정보
     * 2009.07.01. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getInptInfo_c(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getInptInfo_c");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	/*
     * 외래수납 중증시 보조유형변경
     * 2008.09.23. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int setOtptSrdg(ValueObject pVO) throws LiveException {

		int[] retCounts = null;
		SqlQuery sql = sqlPage.getQuery("setOtptSrdg");
		retCounts = executeBatch(sql,pVO);
		
		return retCounts.length;
	}

	/*
     * 외래수납 산정특례시 보조유형변경
     * 2009.03.04. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int setOtptEstm(ValueObject pVO) throws LiveException {

		int[] retCounts = null;
		SqlQuery sql = sqlPage.getQuery("setOtptEstm");
		retCounts = executeBatch(sql,pVO);
		
		return retCounts.length;
	}

	/*
     * 의사소견서 단일처방시 진찰료면제
     * 2008.09.28. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int setOtpt_drcm(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setOtpt_drcm");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}


	//공단조회
	public int setPatInsu(ValueObject pVO) throws LiveException {
		int retCount = -1;

		SqlQuery sql = sqlPage.getQuery("setPatInsu");  
		retCount = executeUpdate(sql,pVO);
		return retCount;
	}

	//공단조회
	public int insPatInsu(ValueObject pVO) throws LiveException {
		int retCount = -1;

		SqlQuery sql = sqlPage.getQuery("insPatInsu");  
		retCount = executeUpdate(sql,pVO);
		return retCount;
	}

	/*
     * VAN 이중승인 여부 체크
     * 2008.10.14. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public ValueObject getEmtyVanCk(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getEmtyVanCk");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}


    /*
     * 환자연속처방내역조회
     * 2008.10.15. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getExopActList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getExopActList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	
	/* 장기이식환자 정보 조회
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getTranInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getTranInfo(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getTranInfo");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}


	/*
	 *  환자보험정보조회  키값이 같은내역
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getPtin1(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getPtin2(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getPtin2");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}


    /*
     * 보험정보 max키구해오기
     * 2008.10.15. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getPtin_maxseqno(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getPtin_maxseqno");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}


    /*
     * 보험정보 변경
     * 2008.10.15. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int setPtinUpdate(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		
		//보험정보 이력추가
		SqlQuery sql = sqlPage.getQuery("setPtinUpdate");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}


	//외래등록정보 홀드상태로 변경
	public int setOtptHoldFlag(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		
		//보험정보 이력추가
		SqlQuery sql = sqlPage.getQuery("setOtptHoldFlag");
		retCount = executeUpdate(sql,pVO);
		return retCount;

	}


    /*
     * 외래보험내역 상태변경
     * 2008.10.16. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getLastPtin(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getLastPtin");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}


    /*
     * 기수납금 처리된 미수건 사유정보에 업데이트
     * 2008.11.12. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int setUncoEndApprsn(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		
		//보험정보 이력추가
		SqlQuery sql = sqlPage.getQuery("setUncoEndApprsn");
		retCount = executeUpdate(sql,pVO);
		return retCount;

	}


    /*
     * 외래수납 환자 인적정보 변경
     * 2008.11.20. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int setPtbsInfo(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		
		SqlQuery sql = sqlPage.getQuery("setPtbsInfo");
		retCount = executeUpdate(sql,pVO);
		return retCount;

	}

    /*
     * 외래수납 예약건 계산호출
     * 2008.11.25. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getCallCalc_Otpt(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getCallCalc_Otpt");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	/* 처방변경내역조회 팝업 
     * OSCL의 Y(수납),R(계산) 내역 조회 
     * @author 이성인 
     * @param pVOs ValueObject
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getOsclRY(ValueObject pVO) throws LiveException {
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOsclRY");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

    //0원 수납 인터페이스 - 대상 otpt가져오기
	public ValueObject getIFOAmtZeroOtpt(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getIFOAmtZeroOtpt");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

    //0원 수납 인터페이스 - 진찰료 sum
	public ValueObject getIFOAmtZeroOscl(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getIFOAmtZeroOscl");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

   //0원 수납 인터페이스 - 0원수납 대상 물리치료 리스트 가져오기
	public ValueObject getMjquList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getMjquList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	//0원 수납 인터페이스 - 0원수납 대상 테이블 종료처리
	public int setOutOrdEndMjqu(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		
		SqlQuery sql = sqlPage.getQuery("setOutOrdEndMjqu");
		retCount = executeUpdate(sql,pVO);
		return retCount;

	}
	
	//과거처방반환, 대체처방 내역 table 수납 여부 상태 처리 
	public int setOPCGStat(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		
		SqlQuery sql = sqlPage.getQuery("setOPCGStat");
		retCount = executeUpdate(sql,pVO);
		return retCount;

	}

	//연속처방 수납대상 팝업 - 조회
	public ValueObject getPopupMjquList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getPopupMjquList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	//계산취소 외래처방테이블 상태값 롤백
	public int setRollBackExop(ValueObject pVO) throws LiveException {		

		int retCount1 = -1;
		int retCount2 = -1;
		
		//MMOHOPRC, MMODEXOP
		//SqlQuery sql = sqlPage.getQuery("setRollBackOprc");		
		//retCount1 = executeUpdate(sql,pVO);
		
		SqlQuery sql2 = sqlPage.getQuery("setRollBackExop");
		retCount2 = executeUpdate(sql2,pVO);
		
		return retCount1;

	}

	//환자별 중증 조회
	public ValueObject getSrdg(ValueObject pVO) throws LiveException {

		ValueObject rVO = new ValueObject();

		SqlQuery sql = sqlPage.getQuery("getSrdg");
		rVO = executeQuery(sql,pVO);
		return rVO;
	}

	/* 0원수납용 미수 수납내역 조회
	 * (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getuncoList2(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getuncoList2(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getuncoList2");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	//병원 정보코드 조회
	public ValueObject getHospcd(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getHospcd");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	//수납vip 대기자조회
	public ValueObject getVipStandList(ValueObject pVO) throws LiveException {

		ValueObject rVO = new ValueObject();

		SqlQuery sql = sqlPage.getQuery("getVipStandList");
		rVO = executeQuery(sql,pVO);
		return rVO;
	}

	//당일 자격조회 유무 체크
	public ValueObject getMmsg2Check(ValueObject pVO) throws LiveException {

		ValueObject rVO = new ValueObject();

		SqlQuery sql = sqlPage.getQuery("getMmsg2Check");
		rVO = executeQuery(sql,pVO);
		return rVO;
	}

	//연속처방 수납대상 팝업 - 처방리스트
	public ValueObject getPopupMjexList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getPopupMjexList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	//연속처방 유무 체크
	public ValueObject getChkOtptMJ(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getChkOtptMJ");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

    //원무공통코드 (desc조회)
	public ValueObject getPmcmCode(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getPmcmCode");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

   //원무공통코드 (cdid조회)
	public ValueObject getPmcmCodeNm(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getPmcmCodeNm");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

   //ZBCMCODE 공통코드조회
    public ValueObject getZbcmCode(ValueObject pVO) throws LiveException {      
        ValueObject getVO = null;
        
        SqlQuery sql = sqlPage.getQuery("getZbcmCode");
        
        getVO = executeQuery(sql, pVO);

        return getVO;
    }


    /*
     *  (비Javadoc)
     * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getCheckMediExamInfo(kr.co.hit.live.vo.ValueObject)
     * 건강검진 내역 조회
     */
    public ValueObject getCheckMediExamInfo(ValueObject pVO) throws LiveException {  
    	ValueObject getVO = null;
 
    	SqlQuery sql = sqlPage.getQuery("getCheckMediExamInfo");
 
    	getVO = executeQuery(sql, pVO);
    	return getVO;
    } 

    /*
     *  (비Javadoc)
     * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getCheckERInfo(kr.co.hit.live.vo.ValueObject)
     * 응급실 내역 조회
     */
    public ValueObject getCheckERInfo(ValueObject pVO) throws LiveException {  
    	ValueObject getVO = null;
     
    	SqlQuery sql = sqlPage.getQuery("getCheckERInfo");
     
    	getVO = executeQuery(sql, pVO);
    	return getVO;
    } 

	//view인 대상 수가코드 체크[_,= 문자포함]
	public ValueObject getViewCalcChk(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getViewCalcChk");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	//oscl이 Y인건 조회해서 R로 만든다
	public int setOsclY_dump(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		
		SqlQuery sql = sqlPage.getQuery("setOsclY_dump");
		retCount = executeUpdate(sql,pVO);
		return retCount;

	}

    //실시정산용 실시일자테이블 입력
	
	public int setOutOrdActr(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		
		SqlQuery sql = sqlPage.getQuery("setOutOrdActr");
		retCount = executeUpdate(sql,pVO);
		return retCount;

	}
	/*
	public int setOutOrdActr(ValueObject pVO) throws LiveException {

		int[] retCounts = null;
		SqlQuery sql = sqlPage.getQuery("setOutOrdActr");
		retCounts = executeBatch(sql,pVO);
		return retCounts.length;
	}
	*/

	public int delOutOrdActr(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		
		SqlQuery sql = sqlPage.getQuery("delOutOrdActr");
		retCount = executeUpdate(sql,pVO);
		return retCount;

	}

	//실시정산 대상환자 조회
	public ValueObject getPopupActrList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getPopupActrList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	//실시정산 대상환자 팝업 - 처방리스트
	public ValueObject getPopupActrExopList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getPopupActrExopList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	//성가병원 예방접종미수 체크
	public ValueObject getPrvntMedc(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getPrvntMedc");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	
	/* 선천성대사이상검사 선천성대사이상 [inborn errors of metabolism] 미수 평생1회
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getInbornError(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getInbornError(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getInbornError");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
    /*
     *  (비Javadoc)
     * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getOrdOTPTRef(kr.co.hit.live.vo.ValueObject)
     * 타과 유형변경 관련 otpt 조회
     */
    public ValueObject getOrdOTPTRef(ValueObject pVO) throws LiveException {  
    	ValueObject getVO = null;
     
    	SqlQuery sql = sqlPage.getQuery("getOrdOTPTRef");
     
    	getVO = executeQuery(sql, pVO);
    	return getVO;
    } 

    //장애인수첩소지여부 체크
    public ValueObject getHndcCnt(ValueObject pVO) throws LiveException {       
        ValueObject getVO = null;
        
        SqlQuery sql = sqlPage.getQuery("getHndcCnt");
        
        getVO = executeQuery(sql, pVO);

        return getVO;
    }

    //미수 입금여부 체크
    public ValueObject getUncoStatYCnt(ValueObject pVO) throws LiveException {       
        ValueObject getVO = null;
        
        SqlQuery sql = sqlPage.getQuery("getUncoStatYCnt");
        
        getVO = executeQuery(sql, pVO);

        return getVO;
    }

    //수납할 재증명 유무 체크
    public ValueObject getChkCertList(ValueObject pVO) throws LiveException {       
        ValueObject getVO = null;
        
        SqlQuery sql = sqlPage.getQuery("getChkCertList");
        
        getVO = executeQuery(sql, pVO);

        return getVO;
    }

    //수납시 ONLN 통장입금액 CD생성
    public int insOnlnAmtDC(ValueObject pVO) throws LiveException {     
        int retCount = -1;
        SqlQuery sql = sqlPage.getQuery("insOnlnAmtDC");
        retCount = executeUpdate(sql,pVO);
        
        return retCount;

    }

    //수납시 ONLN 통장입금액 CD생성
    public int setOnlnAmtC(ValueObject pVO) throws LiveException {      
        int retCount = -1;
        SqlQuery sql = sqlPage.getQuery("setOnlnAmtC");
        retCount = executeUpdate(sql,pVO);
        
        return retCount;

    }   
    
    /*
     *  (비Javadoc)
     * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getPatOectChk(kr.co.hit.live.vo.ValueObject)
     * 환자 외국인 oecd 여부
     */
    public ValueObject getPatOectChk(ValueObject pVO) throws LiveException {  
    	ValueObject getVO = null;
 
    	SqlQuery sql = sqlPage.getQuery("getPatOectChk");
 
    	getVO = executeQuery(sql, pVO);
    	return getVO;
    } 
  
	/*
	 * 진료의뢰내역 조회
	 * 
	 * @param pVO ValueObject
	 * @return ValueObject
	 * @throws LiveException
	 */
	public ValueObject getCNST1(ValueObject pVO) throws LiveException {
		ValueObject rVO = new ValueObject();

		SqlQuery sql = sqlPage.getQuery("getCNST1");  
		rVO = executeQuery(sql,pVO);
		return rVO;
	}    

	/*
	 * 원외처방전 출력
	 * 2010/06/11 cys
	 * @param pVO ValueObject
	 * @return ValueObject
	 * @throws LiveException
	 */
	public ValueObject getHosoOutOrderList(ValueObject pVO) throws LiveException {
		ValueObject rVO = new ValueObject();

		SqlQuery sql = sqlPage.getQuery("getHosoOutOrderList");  
		rVO = executeQuery(sql,pVO);
		return rVO;
	} 
	/*
	 *  (비Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setSuppkindsubyn(kr.co.hit.live.vo.ValueObject)
	 * 타병원 투석 처리
	 */
	public int setSuppkindsubyn(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setSuppkindsubyn");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	//외래선수금화면 미수잔액 가져오기 20110127 cys
	public ValueObject getUncoRemAmt(ValueObject pVO) throws LiveException {
		ValueObject rVO = new ValueObject();

		SqlQuery sql = sqlPage.getQuery("getUncoRemAmt");  
		rVO = executeQuery(sql,pVO);
		return rVO;
	}

    //처방특진여부 N으로 변경 20110401 cys
	public int setChngSpecN(ValueObject pVO) throws LiveException {
		
		int[] retCounts = null;
		SqlQuery sql = sqlPage.getQuery("setChngSpecN");
		retCounts = executeBatch(sql,pVO);
		
		return retCounts.length;
	}

    //처방특진여부 원복 20110401 cys
	public int setChngSpecR(ValueObject pVO) throws LiveException {
		
		int[] retCounts = null;
		SqlQuery sql = sqlPage.getQuery("setChngSpecR");
		retCounts = executeBatch(sql,pVO);
		
		return retCounts.length;
	}

	//특진여부 원복시 취소대장 삭제20110415 cys
	public int setDelSpltList1(ValueObject pVO) throws LiveException {
        
        int retCount = 0;
        SqlQuery sql = sqlPage.getQuery("setDelSpltList1");
        retCount = executeUpdate(sql,pVO);

		return retCount;
	}

	//재활의학과 미예약환자 경고메세지 체크 20110426 cys
	public ValueObject getChkEtcM(ValueObject pVO) throws LiveException {
		ValueObject rVO = new ValueObject();

		SqlQuery sql = sqlPage.getQuery("getChkEtcM");  
		rVO = executeQuery(sql,pVO);
		return rVO;
	}


	/* 건보, 의보 자격 정보 조회
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#checkInsuInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject checkInsuInfo(ValueObject pVO) throws LiveException {
		ValueObject rVO = new ValueObject();
		
		//1. 당일 자격조회 정보 조회
		SqlQuery sql = sqlPage.getQuery("getMsg2Info");  
		ValueObject msgVO = executeQuery(sql,pVO);
		
		//2. 당일 자격조회 하지 않음! 오류!!
		if( msgVO.size() < 1 ){
			rVO.set("errortype", "A");
			rVO.set("errormsg", "오늘 자격조회를 하지 않았습니다. 자격 조회를 하신 후 수납하세요!");
		}else{
			
			//에러메세지 처리시 Q/E 구분여부
			String sMsgtype = msgVO.getString("errortype");
			
			//보험유형 정보 체크
			String sInsukind;
			if( StringHelper.strEquals(msgVO.getString("qualflag"), "7")){			//의료급여 1종
				sInsukind = "21";
			}else if( StringHelper.strEquals(msgVO.getString("qualflag"), "8")){	//의료급여 2종
				sInsukind = "22";
			}else{
				sInsukind = "11";
			}
			
		//3.1 보험 유형 일치 여부 체크
			if( ! StringHelper.strEquals(pVO.getString("insukind"), sInsukind)){
				rVO.set("errortype", sMsgtype);
				rVO.set("errormsg", "보험유형이 공단 자격과 일치 하지 않습니다! 확인 후 다시 수납하세요!");
				return rVO;
			}
		//3.2 급여제한일자 체크
			if( StringHelper.strEquals(msgVO.getString("paylimityn"), "Y")){
				rVO.set("errortype", sMsgtype);
				rVO.set("errormsg", "급여제한일자를 확인하세요! ["+ msgVO.getString("paylimdd")+"] 부터 급여제한된 환자입니다!");
				return rVO;
			}
		//3.3 출국자여부 체크
			if( StringHelper.strEquals(msgVO.getString("dcntrypsnyn"), "Y")){
				rVO.set("errortype", sMsgtype);
				rVO.set("errormsg", "출국여부를 확인하세요! 출국 등으로 인한 급여 정지 대상자입니다!");
				return rVO;
			}
		//4. 중증자격 체크.
			if( StringHelper.strEquals(pVO.getString("suppkind"), "06")				//등록암
					|| StringHelper.strEquals(pVO.getString("suppkind"), "11")			//가정간호 등록암
					|| StringHelper.strEquals(pVO.getString("suppkind"), "38")			//차상위2종 가정간호 등록암
					|| StringHelper.strEquals(pVO.getString("suppkind"), "40")	){		//차상위2종 등록암
				
				// 중증자격이 없고, 당일 중증신청내역도 없을 경우
				if( ! StringHelper.strEquals(msgVO.getString("srdgyn"), "Y") && ! StringHelper.strEquals(msgVO.getString("srdgtdaygenyn"), "Y")){
					rVO.set("errortype", sMsgtype);
					rVO.set("errormsg", "중증자격이 없는 환자입니다! 중증 신청여부를 확인하세요!");
					return rVO;
				}
			}
		//AIDS 환자는 특례신청이 없어 체크가 되면 수납이 안됨.
		//5. 희귀난치산정특례 체크
			if( StringHelper.strEquals(pVO.getString("suppkind"), "50")				//희귀난치성산정특례
					|| StringHelper.strEquals(pVO.getString("suppkind"), "51")			//가정간호 희귀난치성산정특례
					|| StringHelper.strEquals(pVO.getString("suppkind"), "46")){		//차상위2종 희귀난치성산정특례
				
				// 희귀자격이 없고, 당일 희귀신청내역도 없을 경우
				if( ! StringHelper.strEquals(msgVO.getString("rooayn"), "Y") 
					&& ! StringHelper.strEquals(msgVO.getString("rooaesscyn"), "Y")  //희귀난치성산정특례 번호 체크여부 Y 체크안함
					&& ! StringHelper.strEquals(msgVO.getString("rooatdaygenyn"), "Y")){
					//rVO.set("errortype", sMsgtype);
					rVO.set("errortype", "Q");
					rVO.set("errormsg", "희귀난치성산정특례 자격이 없는 환자입니다! \n희귀난치성산정특례 신청여부를 확인하세요!");
					return rVO;
				}
			}
		//6. 중증화상 체크
			if( StringHelper.strEquals(pVO.getString("suppkind"), "61")				//등록중증화상
					|| StringHelper.strEquals(pVO.getString("suppkind"), "62")			//가정간호 등록중증화상
					|| StringHelper.strEquals(pVO.getString("suppkind"), "64")			//차상위2종 가정간호 등록중증화상
					|| StringHelper.strEquals(pVO.getString("suppkind"), "63")	){		//차상위2종 등록중증화상
				
				// 중증화상자격이 없고, 당일 중증화상신청내역도 없을 경우
				if( ! StringHelper.strEquals(msgVO.getString("burnyn"), "Y") && ! StringHelper.strEquals(msgVO.getString("burntdaygenyn"), "Y")){
					rVO.set("errortype", sMsgtype);
					rVO.set("errormsg", "중증화상 자격이 없는 환자입니다! 중증화상 신청여부를 확인하세요!");
					return rVO;
				}
			}
		//7. H 희귀 체크
			if( StringHelper.strEquals(pVO.getString("rareobstflag"), "H")){
				
				// H 희귀 자격이 없는 환자
				if( ! StringHelper.strEquals(msgVO.getString("rareyn"), "Y") ){
					rVO.set("errortype", sMsgtype);
					rVO.set("errormsg", "H 희귀 자격이 없는 환자입니다!");
					return rVO;
				}
			}
		//8. 레진상 완전 틀니 체크
			if( StringHelper.strEquals(pVO.getString("suppkind"), "87")				//레진상 완전 틀니
					|| StringHelper.strEquals(pVO.getString("suppkind"), "88")			//차상위1종 레진상 완전 틀니
					|| StringHelper.strEquals(pVO.getString("suppkind"), "89")	){		//차상위2종 레진상 완전 틀니
				
				// 레진상 완전 틀니 자격이 없고, 당일 레진상 완전 틀니 신청내역도 없을 경우
				if( ! StringHelper.strEquals(msgVO.getString("denturestopyn"), "Y") 
					&& ! StringHelper.strEquals(msgVO.getString("denturesbottomyn"), "Y")
					&& ! StringHelper.strEquals(msgVO.getString("denturestdaygenyn"), "Y")){
					rVO.set("errortype", sMsgtype);
					rVO.set("errormsg", "레진상 완전틀니 자격이 없는 환자입니다! 레진상 완전틀니 신청여부를 확인하세요!");
					return rVO;
				}
			}
			
		//9. 장애인 대불 체크
			String scndinfo = StringHelper.null2string(msgVO.getString("scndsuptrgtman"), "-").substring(0, 1);
			String handicapdd = StringHelper.null2string(msgVO.getString("handicaprrgstdd"), "99991231");
			if(StringHelper.strEquals(pVO.getString("handicaprbookpossnyn"), "Y")){	//장애대상
				if ( StringHelper.strEquals(pVO.getString("insukind"),"22") 			//의료급여2종
					 || ( StringHelper.strEquals(pVO.getString("insukind"),"11") 		//건강보험 차상위 2종
						 && Integer.parseInt(pVO.getString("suppkind")) > 32 
						 && Integer.parseInt(pVO.getString("suppkind")) < 47 )
					){
					
					
					//간강보험 + 차상위2종(F), 의료급여2종 + 장애등록일
					if( (StringHelper.strEquals(pVO.getString("insukind"),"11") && ! StringHelper.strEquals(scndinfo, "F"))
						|| (StringHelper.strEquals(pVO.getString("insukind"),"22") && handicapdd.compareTo(pVO.getString("orddd")) > 0 )
					  ){
						
						//장애대불 발생 환자이면 공단자격에서 장애자격 유무를 체크한다.
						rVO.set("errortype", "Q");
						rVO.set("errormsg", "장애대불 대상환자가 아닙니다.\n공단에 장애등록정보를 확인하세요!");
						return rVO;
					}					
				}
			}
		}
		return rVO;
	}


	
	
	
	/* M005, M006 본인부담의 경우 상병이 중증/희귀가 아닐경우 '-'로 업데이트
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setOwnbflagCheck(ValueObject)
	 */
	public int setOwnbflagCheck(ValueObject pVO) throws LiveException {
		int retCount = 0;
        SqlQuery sql = sqlPage.getQuery("setOwnbflagCheck");
        retCount = executeUpdate(sql,pVO);

		return retCount;
	}
	
	public ValueObject getUncoAmtSMSDetlSpec(ValueObject pVO) throws LiveException {
        ValueObject getVO = null;
        SqlQuery sql = sqlPage.getQuery("getUncoAmtSMSDetlSpec");
        getVO = executeQuery(sql, pVO);

        return getVO;
    }
	
	public ValueObject getUncoAmtSMSMsg(ValueObject pVO) throws LiveException {
        ValueObject getVO = null;
        SqlQuery sql = sqlPage.getQuery("getUncoAmtSMSMsg");
        getVO = executeQuery(sql, pVO);

        return getVO;
    }
	
	public ValueObject getUncoAmtSMSSpec(ValueObject pVO) throws LiveException {
        ValueObject getVO = null;
        SqlQuery sql = sqlPage.getQuery("getUncoAmtSMSSpec");
        getVO = executeQuery(sql, pVO);

        return getVO;
    }
	
	public ValueObject getUncoAmtSMSTrsmSpec(ValueObject pVO) throws LiveException {
        ValueObject getVO = null;
        SqlQuery sql = sqlPage.getQuery("getUncoAmtSMSTrsmSpec");
        getVO = executeQuery(sql, pVO);

        return getVO;
    }
	
	public int setUncoAmtSMSTrsm(ValueObject pVO) throws LiveException {
        int retCount = -1;
        SqlQuery sql = sqlPage.getQuery("setUncoAmtSMSTrsm");
        retCount = executeUpdate(sql, pVO);
        return retCount;
    }
	
	public ValueObject getDiscListChk(ValueObject pVO) throws LiveException {
		ValueObject getVO = null;
		SqlQuery sql = sqlPage.getQuery("getdisclistchk");
		getVO = executeQuery(sql, pVO);
		return getVO;
	}


	public int setSpclcd(ValueObject pVO) throws LiveException {
		int retCount = -1;
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getSpclcd");
		getVO = executeQuery(sql, pVO);
		
		if( getVO.size() > 0 ){
			//특례코드가 입력안되어 있으면 값을 세팅한다.
			if( StringHelper.strEquals( pVO.getString("spclcd"), "") || StringHelper.strEquals( pVO.getString("spclcd"), "-")){
				pVO.set("spclcd", getVO.getString("spclcd"));	
				SqlQuery sql2 = sqlPage.getQuery("setSpclcd");
				retCount = executeUpdate(sql2, pVO);
			}
			
		}        
        
        return retCount;
	}
	
	public ValueObject getCheckWorkUpDiag(ValueObject pVO) throws LiveException {
	    
	    SqlQuery sql = sqlPage.getQuery("getCheckWorkUpDiag");
	    return executeQuery(sql, pVO);
	}
}