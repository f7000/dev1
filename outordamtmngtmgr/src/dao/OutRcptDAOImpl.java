/**
 * @(#) OutRcptDAOImpl.java
 *�����̷�
 * 		- 2007. 4. 02 / �����ۼ� / �����
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
 *  <P> �ܷ����� DAO Interface�� ���� Class</P>
 *  �� Ŭ������ �ܷ������� �����ϴ� OutRcptDAO Interface�� ����Ŭ�����̴�. 
 *  
 *  @author  �����
 *  @version 1.0  2007. 4. 02
 */
public class OutRcptDAOImpl extends JdbcQueryDAO implements OutRcptDAO {

	private SqlQueryPage sqlPage = null;

	protected static final Log log = LogFactory.getLog(OutRcptDAOImpl.class);
	
	/**
	 * ����� SQL ���� ���ǵ� SQL XML ���� ��θ� �����ϴ�
	 * Setter Method
	 * @param path SQL XML ������ ��� ���
	 */
	public void setSql(String path) {
		sqlPage = getQueryPage(path);
	}

	
	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getMdlAmtList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getMdlAmtList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getMdlAmtList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getCardAmtList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getCardAmtList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getCardAmtList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	
	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getCashAmtList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getCashAmtList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getCashAmtList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getOnlineAmtList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOnlineAmtList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOnlineAmtList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getMdlRemAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getMdlRemAmt(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getMdlRemAmt");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getMdlRemAmt2(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getMdlRemAmt2(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getMdlRemAmt2");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getRcptNo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getRcptNo(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getRcptNo");
				
		getVO = executeQuery(sql, pVO);
		
		return getVO;
	}

	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insMdlAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insMdlAmt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insMdlAmt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insOnlineAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insOnlineAmt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insOnlineAmt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}
	
	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setMdlAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int setOnlineAmt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setOnlineAmt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	
	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setRcptNo(kr.co.hit.live.vo.ValueObject)
	 */
	public int setRcptNo(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setRcptNo");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insRcptNo(kr.co.hit.live.vo.ValueObject)
	 */
	public int insRcptNo(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insRcptNo");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setOutOrdAmtOscl(kr.co.hit.live.vo.ValueObject)
	 */
	public int setOutOrdAmtOscl(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setOutOrdAmtOscl");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}
	
	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setOutOrdAmtOtpt(kr.co.hit.live.vo.ValueObject)
	 */
	public int setOutOrdAmtOtpt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setOutOrdAmtOtpt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}
	
	/*
	 *  (��Javadoc)
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
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getOutRgstList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOutRgstList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOutRgstList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getOutRgstList2(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOutRgstList2(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOutRgstList2");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	
	/* ����������ȸ
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getInsuInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getInsuInfo(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getInsuInfo");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	
	/* ����������ȸ
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getSrdgInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getSrdgInfo(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getSrdgInfo");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}


	/* �ں��ڰ����� ��ȸ
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getAipmInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getAipmInfo(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getAipmInfo");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	/* �����ڰ����� ��ȸ
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getIcpmInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getIcpmInfo(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getIcpmInfo");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	
	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getOsclInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOsclInfo(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOsclInfo");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	/* ���ܾ����翩�� ��ȸ
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getOutOrdExist(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOutOrdExist(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOutOrdExist");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	/* �����ȯ�ڿ��� ��ȸ
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getHandicapYN(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getHandicapYN(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getHandicapYN");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	/* ����ó�� �ܷ���� �Ǵ� �Ϲ� �ܷ������ �� ORDDD  ��ȸ - �౹�����
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getHandicapYN(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOrddd(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOrddd");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getInsuRateInf(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getInsuRateInfo(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getInsuRateInfo");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	
	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getOpmiInfoFromOscl(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOpmiInfoFromOscl(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOpmiInfoFromOscl");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getPreOpmiInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getPreOpmiInfo(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getPreOpmiInfo");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}


	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setMdlAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int setMdlAmt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setMdlAmt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}
	
	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insMdlAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insOutOrdAmt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insOutOrdAmt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}
	
	/*
	 *  (��Javadoc)
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
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insMdlAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insOtptHistAdd(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		
		/*
		//�ܷ���� �̷��߰�.
		SqlQuery sql = sqlPage.getQuery("insOtptHist");
		retCount = executeUpdate(sql,pVO);

		//�������� Histstat : R => C
		SqlQuery sql2 = sqlPage.getQuery("setOtptPreHist");
		retCount = executeUpdate(sql2,pVO);
		*/

		//�ܷ���� �̷��߰�
		SqlQuery sql2 = sqlPage.getQuery("setOtptAddHist");
		retCount = executeUpdate(sql2,pVO);

		return retCount;

	}
	
	
	/* M005, M006 ���κδ��� ��� ���� ����/��Ͱ� �ƴҰ�� üũ
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getOwnbflagCheckInfo(ValueObject)
	 */
	public ValueObject getOwnbflagCheckInfo(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOwnbflagCheckInfo");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	
	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insMdlAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insOtptHistAddCancel(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		
		if (StringHelper.strEquals(pVO.getString("workgubn"),"Y")) {	
			
			/*
			//�ܷ���� �̷��߰�
			SqlQuery sql = sqlPage.getQuery("insOtptHistCancel");
			retCount = executeUpdate(sql,pVO);
	
			if (retCount == 0) {
				pVO.set("histstat","R");								
				SqlQuery sql1 = sqlPage.getQuery("setOtptPreHistCancel");
				retCount = executeUpdate(sql1,pVO);			
				
			} else if (retCount > 0) {
				//�������� Histstat : R => C
				pVO.set("histstat","C");									
				SqlQuery sql2 = sqlPage.getQuery("setOtptPreHist");
				retCount = executeUpdate(sql2,pVO);
			}
			*/
				pVO.set("histstat","R");								
				SqlQuery sql1 = sqlPage.getQuery("setOtptPreHistCancel");
				retCount = executeUpdate(sql1,pVO);	

		} else {
			//�ܷ���� �̷��߰�

//			System.out.println("-----�̵���20080123--calcstat--->"+pVO.getString("calcstat"));	
//			System.out.println("-----�̵���20080123--pid--->"+pVO.getString("pid"));			
//			System.out.println("-----�̵���20080123--calcstat--->"+pVO.getString("orddd"));			
//			System.out.println("-----�̵���20080123--calcstat--->"+pVO.getString("cretno"));
//			System.out.println("-----�̵���20080123--calcstat--->"+pVO.getString("acptseqno"));
//			System.out.println("-----�̵���20080123--calcstat--->"+pVO.getString("instcd"));		
			
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
	 *  (��Javadoc)
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
		//�ۼ���
		//�������� �̷��߰�
		ValueObject insVO 		= pVO;	//�ű�
		ValueObject preinsVO 	= pVO;	//�������� �űԻ���
		ValueObject presetVO 	= pVO;	//�������� C update
		
		//System.out.println("------�����,�������� �Է� �׽�Ʈ 1111-----------");
		
		//�������� �� ����Ⱓ�� ���ԵǴ� ���� ������ �ִ��� üũ
		//������, add�� �ʿ����, ������,add
		 SqlQuery sql = sqlPage.getQuery("getPtinHist");		
		 getVO = executeQuery(sql, pVO);
		 
		 //System.out.println("------�����,�������� �Է� �׽�Ʈ 2222-----------");
		 if (getVO.size()>0) {
			 
			 //System.out.println("------�����,�������� �Է� �׽�Ʈ AAAA-----------");
		 	
		 	//���� R �γ��� Copy �ϵ�, ���� �����Ŵ - (fromdd-1)���������� ������ update ��Ű�� insert
			preinsVO.set("ptin_histstat","Y"); 	
			SqlQuery sql2 = sqlPage.getQuery("insPtinPreHist");
		 	retCount = executeUpdate(sql2,preinsVO);
		 	
		 	//System.out.println("------�����,�������� �Է� �׽�Ʈ CCCC-----------");
		 	
		 	//�������� R->C
		 	SqlQuery sql1 = sqlPage.getQuery("setPtinPreHist");
		 	presetVO.set("ptin_histstat","C");
		 	retCount = executeUpdate(sql1,presetVO);
		 	//System.out.println("------�����,�������� �Է� �׽�Ʈ DDDD-----------");
		 	
		 	//�űԳ��� insert
		 	//���������� insert
		 	 insVO.set("ptin_histstat","Y"); 	
		 	SqlQuery sql3 = sqlPage.getQuery("insPtinHist");
		 	retCount = executeUpdate(sql3,insVO);
		 	//System.out.println("------�����,�������� �Է� �׽�Ʈ EEEE-----------");
		 	
		 
		 }
		 else {
			 
			 //System.out.println("------�����,�������� �Է� �׽�Ʈ BBBB-----------");
			 insVO.set("ptin_histstat","Y"); 	
		 	SqlQuery sql2 = sqlPage.getQuery("insPtinHist");
		 	retCount = executeUpdate(sql2,insVO);
		 
		 } 
		  
		
		//�������� Histstat : R => C
		//���� ���������� ����, ���������� ���� ���, Y=>C update
		 //SqlQuery sql2 = sqlPage.getQuery("setPtinPreHist");
		 //retCount = executeUpdate(sql2,pVO);
		
		 //SqlQuery sql = sqlPage.getQuery("insPtinHist");
		 //retCount = executeUpdate(sql,pVO);
		
		
		return retCount;

	}

	public int insPtdcHistAdd(ValueObject pVO) throws LiveException {		
		int retCount = -1;
//		�ۼ���
		/*
		//�������� �̷��߰�
		SqlQuery sql = sqlPage.getQuery("insOtptHist");
		retCount = executeUpdate(sql,pVO);
		
		//�������� Histstat : R => C
		SqlQuery sql2 = sqlPage.getQuery("setOtptPreHist");
		retCount = executeUpdate(sql2,pVO);
		*/
		return retCount;

	}

	
	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getPatInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getPatInfo(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getPatInfo");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	
	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getPatDiag(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getPatDiag(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getPatDiag");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}


	/* �ܷ��������� ��ȸ- �ܷ����Ű ��������
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getopmiList3(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getopmiList3(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getopmiList3");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	
	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getOtptInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOtptInfo(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOtptInfo");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	
	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getEarnInfo2(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getEarnInfo2(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getEarnInfo2");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	
	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getEarnInfo3(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getEarnInfo3(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getEarnInfo3");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}	
	
	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getEarnInfo2(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getEarnInfo4(ValueObject pVO) throws LiveException {		
		ValueObject getVO = new ValueObject();
		ValueObject tmpVO = new ValueObject();
		
		//SqlQuery sql = sqlPage.getQuery("getEarnInfo4");
		
		//2013-02-12 �ܷ���� �ӵ� Ʃ��! ����Ű�� ��ȸ�ؼ� �ݾ��� ���ϵ��� ����.
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

	
	/* �ܷ� ���� DC ���� ����
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insMdlAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insOutOrdAmtDC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insOutOrdAmtDC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}
	
	/* �ܷ� ��곻��  DC ���� ����
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insMdlAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insOSCLDC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insOSCLDC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	
	/* ���� �ܷ����� [����]���·� ����
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insMdlAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int setOutOrdAmtC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setOutOrdAmtC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}
	
	/* ���� �ܷ���� [����]���� 
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insMdlAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int setOSCLC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setOSCLC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}	

	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getOtptInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOtptInfo2(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOtptInfo2");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getOtptInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOtptInfo3(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOtptInfo3");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	
	/* ó�� ��ȸ(ó��Ȧ�� ���� ó����ȸ-�ܷ�����ȭ��)
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getprcpList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getprcpList2(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getprcpList2");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	/* ó�� ��ȸ(ó��Ȧ�� ���� ó����ȸ-�ܷ�����ȭ��)
	 *  (��Javadoc)
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

	/* ó�� ��ȸ(ó��Ȧ�� ���� ó����ȸ-�ܷ�����ȭ��)
	 *  (��Javadoc)
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
	
	
	/* û�������� [����] 
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insMdlAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int setClamTrgtStat(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setClamTrgtStat");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}	
	
	/* ī��������� ����
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insOnlineAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insCardAmt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insCardAmt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	
	/* ���ݿ������������� ����
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insCashAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insCashAmt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insCashAmt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}
	
	
	/* �̼����� ����
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insUncoAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insUncoAmt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insUncoAmt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}	
	
	/* DC �̼����� ����  
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insUncoAmtDC(kr.co.hit.live.vo.ValueObject)
	 */
	public int insUncoAmtDC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insUncoAmtDC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}	

	/* �̼����� ����
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insUncoAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int setUncoAmtC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setUncoAmtC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}	
	
	
	/* ����,���׳��� ����
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insDcgmAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insDcgmAmt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insDcgmAmt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}		

	/* DC ����,���׳��� ����
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insDcgmAmtDC(kr.co.hit.live.vo.ValueObject)
	 */
	public int insDcgmAmtDC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insDcgmAmtDC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	/* ����,���׳��� ����
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setDcgmAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int setDcgmAmtC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setDcgmAmtC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}		

	/* ������ ����,���׳��� ����
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insBldcAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insBldcAmt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insBldcAmt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}		

	/* DC ������ ����,���׳��� ����
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insBldcAmtDC(kr.co.hit.live.vo.ValueObject)
	 */
	public int insBldcAmtDC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insBldcAmtDC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	/* ������ ����,���׳��� ����
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setBldcAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int setBldcAmtC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setBldcAmtC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}		
	
	/* ī�� DC ���� ����(�����)
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insCardAmtDC(kr.co.hit.live.vo.ValueObject)
	 */
	public int insCardAmtDC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insCardAmtDC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	/* ī�� ���� ����
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setCardAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int setCardAmtC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setCardAmtC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}		

	/* �� ī�� ���� ����(�����)
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insPreCardAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insPreCardAmt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insPreCardAmt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}
	
	
	/* ���ݿ����� DC ���� ����(�����)
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insCashAmtDC(kr.co.hit.live.vo.ValueObject)
	 */
	public int insCashAmtDC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insCashAmtDC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	/* ���ݿ����� ���� ����
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setCashAmtC(kr.co.hit.live.vo.ValueObject)
	 */
	public int setCashAmtC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setCashAmtC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}		

	/* �߰��� DC ���� ����(�����)
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insBogjAmtDC(kr.co.hit.live.vo.ValueObject)
	 */
	public int insBogjAmtDC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insBogjAmtDC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	/* �߰��� ���� ����
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setBogjAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int setBogjAmtC(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setBogjAmtC");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}		
	
	
	/* �ܷ������� ��ҳ��� ����
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insMdlAmtCncl(kr.co.hit.live.vo.ValueObject)
	 */
	public int insMdlAmtCncl(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insMdlAmtCncl");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}
	
	/* ī�������ҳ��� ����
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insCardAmtCncl(kr.co.hit.live.vo.ValueObject)
	 */
	public int insCardAmtCncl(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insCardAmtCncl");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	
	/* ���ݿ�����������ҳ��� ����
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insCashAmtCncl(kr.co.hit.live.vo.ValueObject)
	 */
	public int insCashAmtCncl(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insCashAmtCncl");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	/* ī��������� ����
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setCardAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int setCardAmt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setCardAmt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	
	/* ���ݿ��������μ������� ����
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setCashAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int setCashAmt(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setCashAmt");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}
	
	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insOnlineAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insOnlineAmtCncl(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("insOnlineAmtCncl");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}
	
	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getPtin1(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getPtin1(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getPtin1");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insPtinHist(kr.co.hit.live.vo.ValueObject)
	 */
	public int insPtinHist(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		
		//�������� �̷��߰�
		SqlQuery sql = sqlPage.getQuery("insPtinHist");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	/*
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setPtinPreHist(kr.co.hit.live.vo.ValueObject)
	 */
	public int setPtinPreHist(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		
		//�������� �̷��߰�
		SqlQuery sql = sqlPage.getQuery("setPtinPreHist");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}
	
    /**
     * �����Ƿ�ȯ�� ����
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
	 *  (��Javadoc)
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
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setAddOTPTFromHold(kr.co.hit.live.vo.ValueObject)
	 */
	public int setAddOTPTFromHold(ValueObject pVO) throws LiveException {		
		int retCount1 = -1;
		int retCount2 = -1;
		
		//Release �� �ܷ���� �߰�
		SqlQuery sql = sqlPage.getQuery("setAddOTPTFromHold");		
		retCount1 = executeUpdate(sql,pVO);
		
		//���� �ܷ���ϳ��� C Update
		SqlQuery sql2 = sqlPage.getQuery("setCOTPTFromHold");		
		retCount2 = executeUpdate(sql2,pVO);		
			
		return retCount1;
	}

	/*
	 *  (��Javadoc)�ܷ������
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getOtptList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getOtptList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getOtptList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	
	/* ȯ�ڻ󼼳�����ȸ_�ܷ���ϸ���Ʈ_������������Ʈ  ��ȸ
	 *  (��Javadoc)
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
	 *  (��Javadoc) ���������� ����ó��(�������� ���׷�-����,����
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setActing(kr.co.hit.live.vo.ValueObject)
	 */
	public int setActing(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setActing");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	/*
	 *  (��Javadoc) ���������� ��곻�� ����ó��(�������� ���׷�-����,����
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setActing(kr.co.hit.live.vo.ValueObject)
	 */
	public int setActingOscl(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setActingOscl");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	
	/* VAN���������� �ִ� ī�峻�� ��ȸ
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getprcpList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getonlycvanList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getonlycvanList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	

	/* �������泻�� ��ȸ
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getupdtrateList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getupdtrateList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getupdtrateList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	

	/* �����������᳻��
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getupdtrateList1(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getupdtrateList1(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getupdtrateList1");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}	
	
	/* �������泻�� ����
	 *  (��Javadoc)
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
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getEarnOsclInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getEarnOsclInfo(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getEarnOsclInfo");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}		
	
	
	/**
	 * �ܷ�ó�泻���� ó��޺��������� Update
	 * @author �̵���
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
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insMdlAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public int insOtptHistSuppkindAdd(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		
		//�������� Histstat : R => C
		SqlQuery sql2 = sqlPage.getQuery("setOtptPreHist");
		retCount = executeUpdate(sql2,pVO);
		
		return retCount;
	}	
	

	/*
	 *  (��Javadoc)
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
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#insMultiOtptHistAdd(kr.co.hit.live.vo.ValueObject)
	 */
	public int insMultiOtptHistAdd(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		
		//�ܷ���� �̷��߰�
		SqlQuery sql = sqlPage.getQuery("insMultiOtptHist");
		retCount = executeUpdate(sql,pVO);

		//�������� Histstat : R => C
		SqlQuery sql2 = sqlPage.getQuery("setOtptPreHist");
		retCount = executeUpdate(sql2,pVO);
		
		return retCount;
	}	
	
	
     /**
     * �����ݿ�������������
     * 2008.03.19. updated by ������
     * �ǽ����� ����
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
     * ���߰��ݾ� ��������
     * 2008.03.19. updated by ������
     * �ǽ����� ����
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
     * ȯ�������Ƿڼ� �Է�.
     * 2008.05.20. updated by ������
     * 
     * @param pVO ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int insOutOrdCnst(ValueObject pVO) throws LiveException {
		
		int retCount = -1;
		
		//cnst���̺� �ߺ�üũ
		SqlQuery sql1 = sqlPage.getQuery("getOutOrdCnst");
		retCount = executeUpdate(sql1,pVO);
		
		//cnst���̺� ������ ����
		if(retCount == 0) {
			SqlQuery sql2 = sqlPage.getQuery("insOutOrdCnst");
			retCount = executeUpdate(sql2,pVO);
		}

		return retCount;
	}


    /**
     * �ܷ��޺񺯰�
     * �ܷ��̽���ó�� �̽��� ���� ��ȸ
     * 2008.06.26. updated by ������
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
     * �ܷ��޺񺯰�
     * �ܷ��̽���ó�� ȯ�� ��ȸ
     * 2008.06.26. updated by ������
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
     * �ܷ��޺񺯰�
     * �ܷ��̽��� ó�� ���� ��ȸ
     * 2008.06.26. updated by ������
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
     * �ܷ��޺񺯰�
     * �ܷ��̽���ó�� �̽��� ���սɻ� �Ϸ� ���θ� ����
     * 2008.06.26. updated by ������
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
     * �ܷ��޺񺯰�
     * �ܷ��̽���ó�� - ó�� �޺񱸺��ڵ� ���� ó��
     * 2008.06.26. updated by ������
     * @param pVO ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int setOrdPayFlag(ValueObject pVO) throws LiveException {
		int retCounts = 0;
		
		// 1.PAM.PIJHOPRC ����
		SqlQuery sql1 = sqlPage.getQuery("delordpayflag1");
		retCounts = executeUpdate(sql1,pVO);
		
		// 2. EMR.MMOHOPRC ���������� �޺񱸺��ڵ带 �����Ѵ�.		
		SqlQuery sql2 = sqlPage.getQuery("setordpayflag2");
		retCounts = executeUpdate(sql2,pVO);
		
		//no charge ó��
		if( StringHelper.strEquals(pVO.getString("calcflag"), pVO.getString("calcflag_old"))){
			SqlQuery sql3 = sqlPage.getQuery("setordpayflag4");
			retCounts = executeUpdate(sql3,pVO);
		}
		
		// 3. EMR.MMOHOPRC �� ������ �����͸� PAM.PIJHOPRC �����丮 ���̺� ��������Ѵ�. 
		SqlQuery sql3 = sqlPage.getQuery("setordpayflag3");
		retCounts = executeUpdate(sql3,pVO);
		
		return retCounts;
	}
	
	
	
	/* (non-Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setInOrdPayFlag(kr.co.hit.live.vo.ValueObject)
	 */
	public int setInOrdPayFlag(ValueObject pVO) throws LiveException {
		int retCounts = 0;
		
		// 1.PAM.PIJHIPRC ����
//		SqlQuery sql1 = sqlPage.getQuery("delInordpayflag1");
//		retCounts = executeUpdate(sql1,pVO);
		
		// 2. EMR.MMOHIPRC ���������� �޺񱸺��ڵ带 �����Ѵ�.
		SqlQuery sql2 = sqlPage.getQuery("setInordpayflag2");
		retCounts = executeUpdate(sql2,pVO);
		
		// 3. EMR.MMOHIPRC �� ������ �����͸� PAM.PIJHIPRC �����丮 ���̺� ��������Ѵ�. 
//		SqlQuery sql3 = sqlPage.getQuery("setInordpayflag3");
//		retCounts = executeUpdate(sql3,pVO);
		
		return retCounts;
	}


    /**
     * �ܷ��޺񺯰�
     * �ܷ��̽���ó�� �̽��� ���� Ư�� ������ ����
     * 2008.06.26. updated by ������
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
     * �ܷ��޺񺯰�
     * �ܷ��̽���ó�� �̽��� ���� Ư�� ������ �߰�
     * 2008.06.26. updated by ������
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
     * �ܷ��޺񺯰�
     * �ܷ��̽���ó�� - ó�� �޺񱸺��ڵ� ���� ��, �ܷ�ȯ�� ���� �̷������� �����Ѵ�.
     * 2008.06.26. updated by ������
     * @param pVO ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int setOutPatInfoHist(ValueObject pVO) throws LiveException {

		int retCounts = 0;
		
		// 1. PAM.PMOHOTPT �������͸� �����Ͽ� �߰��Ѵ�
		//SqlQuery sql1 = sqlPage.getQuery("setoutpatinfohist1");
		//retCounts = executeUpdate(sql1,pVO);
		
		// 2. PAM.PMOHOTPT ���������� HISTSTAT �� CALCFLAG �� �����Ѵ�.
		//SqlQuery sql2 = sqlPage.getQuery("setoutpatinfohist2");
		//retCounts = executeUpdate(sql2,pVO);

		// 3. PAM.PMOHOTPT CALCFLAG �� �����Ѵ�.
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
     * �ܷ�����
     * �����ҽ� ������ otpt�� hist���̺��� ���Ѵ�.
     * 2008.06.26. updated by ������
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
     * �ܷ�����
     * �ܷ����� ������ OTPT�� ��걸�� ����
     * 2008.06.26. updated by ������
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
     * �ܷ�����
     * �ܷ����� ������ OSCL ����
     * 2008.07.01. updated by ������
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
     * ���ݿ����� ����Ʈ ���ι�ȣ
     * 2007.07.04. updated by ������
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
     * �ǻ�Ұ߼������˾� ��ȸ
     * 2007.07.07. updated by ������
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
     * �ǻ�Ұ߼������˾� ����
     * 2007.07.07. updated by ������
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
     * �ǻ�Ұ߼������˾� ����
     * 2007.07.07. updated by ������
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
     * ȯ��ó�泻����ȸ
     * 2007.07.08. updated by ������
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
     * ��곻�� ��ȸ
     * 2008.07.14. updated by ������
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
     * �ܷ������� ��ϳ�����ȸ
     * 2008.07.23. updated by ������
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
     * �湮��ȣ���ü��˾� ��ȸ
     * 2007.07.07. updated by ������
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
     * �湮��ȣ���ü��˾� ����
     * 2007.07.07. updated by ������
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
     * �湮��ȣ���ü��˾� ����
     * 2007.07.07. updated by ������
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
     * �ǻ�����ȣ��ȸ
     * 2007.07.07. updated by ������
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
     * �ӻ󿬱���ȣ ��������
     * 2007.07.28. updated by ������
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
     * ���� Ȧ��ó�� ���� Ȯ��
     * 2007.08.01. updated by ������
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
     * ���� �̼��� ó�� ���� Ȯ��
     * 2009.04.01. updated by ������
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
     * B�� �������� ó��
     * 2007.08.04. updated by ������
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
     * �ں��ѵ�ȯ�ںи��˾�
     * �ܷ���ϳ�����ȸ
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
     * �ں��ѵ�ȯ�ںи��˾�
     * ó�泻����ȸ
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
     * �ں��ѵ�ȯ�ںи��˾�
     * �ܷ�ó�� ������ �и�
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
     * �ں��ѵ�ȯ�ںи��˾�
     * �ܷ���� �̰����·� ����
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
     * �ܷ�����
     * �ܷ������� ���ڸ޼��� �̷����̺� ����.
     * 2008.06.26. updated by ������
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
	 * �ܷ����� 2008/1/23 ������
	 * ���� �������� Ŭ���� ����������ȸ
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
	 * �ܷ�����
	 * �ִ�����������ϱ�
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
	 * �ǰ���Ȱ��������ȸ
	 * ����ȭ�鿡�� �ҷ�����
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
	 * �ǰ���Ȱ��������ȸ
	 * ������������ �ҷ�����
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
	
	
	/* �ǽ����� ������ ��ȸ
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getExeSuppAmt(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getExeSuppAmt(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getExeSuppAmt");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	/* ��ֱ��  ��ȸ
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getExeHandcapFund(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getExeHandcapFund(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getExeHandcapFund");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	/*ī��������� ��ȸ
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getcardList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getcardList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getcardList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	
	/*���ݿ��������� �������� ��ȸ
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getcashList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getcashList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getcashList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	/*�����Ա� �������� ��ȸ
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getonlnList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getonlnList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getonlnList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	/* �� ������ü
	 * (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getbldcList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getbldcList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getbldcList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
 
	/* �� ���鳻����ȸ
	 * (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getdcgmList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getdcgmList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getdcgmList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	/* �� ���鳻����ȸ 0��������
	 * (��Javadoc)
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

	/* �� �̼�������ȸ
	 * (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getuncoList(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getuncoList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getuncoList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}


	/*
     * �Ϲ���-Ư���� ����
     * 2008.09.22 updated by ������
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
     * �ܷ����� ȯ���������
     * 2008.09.22. updated by ������
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
     * �ܷ����� ȯ�� ���������
     * 2009.07.01. updated by ������
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
     * �ܷ����� ������ ������������
     * 2008.09.23. updated by ������
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
     * �ܷ����� ����Ư�ʽ� ������������
     * 2009.03.04. updated by ������
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
     * �ǻ�Ұ߼� ����ó��� ���������
     * 2008.09.28. updated by ������
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


	//������ȸ
	public int setPatInsu(ValueObject pVO) throws LiveException {
		int retCount = -1;

		SqlQuery sql = sqlPage.getQuery("setPatInsu");  
		retCount = executeUpdate(sql,pVO);
		return retCount;
	}

	//������ȸ
	public int insPatInsu(ValueObject pVO) throws LiveException {
		int retCount = -1;

		SqlQuery sql = sqlPage.getQuery("insPatInsu");  
		retCount = executeUpdate(sql,pVO);
		return retCount;
	}

	/*
     * VAN ���߽��� ���� üũ
     * 2008.10.14. updated by ������
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
     * ȯ�ڿ���ó�泻����ȸ
     * 2008.10.15. updated by ������
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
	
	
	/* ����̽�ȯ�� ���� ��ȸ
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getTranInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getTranInfo(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getTranInfo");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}


	/*
	 *  ȯ�ں���������ȸ  Ű���� ��������
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getPtin1(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getPtin2(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getPtin2");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}


    /*
     * �������� maxŰ���ؿ���
     * 2008.10.15. updated by ������
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
     * �������� ����
     * 2008.10.15. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int setPtinUpdate(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		
		//�������� �̷��߰�
		SqlQuery sql = sqlPage.getQuery("setPtinUpdate");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}


	//�ܷ�������� Ȧ����·� ����
	public int setOtptHoldFlag(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		
		//�������� �̷��߰�
		SqlQuery sql = sqlPage.getQuery("setOtptHoldFlag");
		retCount = executeUpdate(sql,pVO);
		return retCount;

	}


    /*
     * �ܷ����賻�� ���º���
     * 2008.10.16. updated by ������
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
     * ������� ó���� �̼��� ���������� ������Ʈ
     * 2008.11.12. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int setUncoEndApprsn(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		
		//�������� �̷��߰�
		SqlQuery sql = sqlPage.getQuery("setUncoEndApprsn");
		retCount = executeUpdate(sql,pVO);
		return retCount;

	}


    /*
     * �ܷ����� ȯ�� �������� ����
     * 2008.11.20. updated by ������
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
     * �ܷ����� ����� ���ȣ��
     * 2008.11.25. updated by ������
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

	/* ó�溯�泻����ȸ �˾� 
     * OSCL�� Y(����),R(���) ���� ��ȸ 
     * @author �̼��� 
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

    //0�� ���� �������̽� - ��� otpt��������
	public ValueObject getIFOAmtZeroOtpt(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getIFOAmtZeroOtpt");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

    //0�� ���� �������̽� - ������ sum
	public ValueObject getIFOAmtZeroOscl(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getIFOAmtZeroOscl");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

   //0�� ���� �������̽� - 0������ ��� ����ġ�� ����Ʈ ��������
	public ValueObject getMjquList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getMjquList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	//0�� ���� �������̽� - 0������ ��� ���̺� ����ó��
	public int setOutOrdEndMjqu(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		
		SqlQuery sql = sqlPage.getQuery("setOutOrdEndMjqu");
		retCount = executeUpdate(sql,pVO);
		return retCount;

	}
	
	//����ó���ȯ, ��üó�� ���� table ���� ���� ���� ó�� 
	public int setOPCGStat(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		
		SqlQuery sql = sqlPage.getQuery("setOPCGStat");
		retCount = executeUpdate(sql,pVO);
		return retCount;

	}

	//����ó�� ������� �˾� - ��ȸ
	public ValueObject getPopupMjquList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getPopupMjquList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	//������ �ܷ�ó�����̺� ���°� �ѹ�
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

	//ȯ�ں� ���� ��ȸ
	public ValueObject getSrdg(ValueObject pVO) throws LiveException {

		ValueObject rVO = new ValueObject();

		SqlQuery sql = sqlPage.getQuery("getSrdg");
		rVO = executeQuery(sql,pVO);
		return rVO;
	}

	/* 0�������� �̼� �������� ��ȸ
	 * (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getuncoList2(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getuncoList2(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getuncoList2");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	//���� �����ڵ� ��ȸ
	public ValueObject getHospcd(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getHospcd");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	//����vip �������ȸ
	public ValueObject getVipStandList(ValueObject pVO) throws LiveException {

		ValueObject rVO = new ValueObject();

		SqlQuery sql = sqlPage.getQuery("getVipStandList");
		rVO = executeQuery(sql,pVO);
		return rVO;
	}

	//���� �ڰ���ȸ ���� üũ
	public ValueObject getMmsg2Check(ValueObject pVO) throws LiveException {

		ValueObject rVO = new ValueObject();

		SqlQuery sql = sqlPage.getQuery("getMmsg2Check");
		rVO = executeQuery(sql,pVO);
		return rVO;
	}

	//����ó�� ������� �˾� - ó�渮��Ʈ
	public ValueObject getPopupMjexList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getPopupMjexList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	//����ó�� ���� üũ
	public ValueObject getChkOtptMJ(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getChkOtptMJ");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

    //���������ڵ� (desc��ȸ)
	public ValueObject getPmcmCode(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getPmcmCode");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

   //���������ڵ� (cdid��ȸ)
	public ValueObject getPmcmCodeNm(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getPmcmCodeNm");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

   //ZBCMCODE �����ڵ���ȸ
    public ValueObject getZbcmCode(ValueObject pVO) throws LiveException {      
        ValueObject getVO = null;
        
        SqlQuery sql = sqlPage.getQuery("getZbcmCode");
        
        getVO = executeQuery(sql, pVO);

        return getVO;
    }


    /*
     *  (��Javadoc)
     * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getCheckMediExamInfo(kr.co.hit.live.vo.ValueObject)
     * �ǰ����� ���� ��ȸ
     */
    public ValueObject getCheckMediExamInfo(ValueObject pVO) throws LiveException {  
    	ValueObject getVO = null;
 
    	SqlQuery sql = sqlPage.getQuery("getCheckMediExamInfo");
 
    	getVO = executeQuery(sql, pVO);
    	return getVO;
    } 

    /*
     *  (��Javadoc)
     * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getCheckERInfo(kr.co.hit.live.vo.ValueObject)
     * ���޽� ���� ��ȸ
     */
    public ValueObject getCheckERInfo(ValueObject pVO) throws LiveException {  
    	ValueObject getVO = null;
     
    	SqlQuery sql = sqlPage.getQuery("getCheckERInfo");
     
    	getVO = executeQuery(sql, pVO);
    	return getVO;
    } 

	//view�� ��� �����ڵ� üũ[_,= ��������]
	public ValueObject getViewCalcChk(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getViewCalcChk");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	//oscl�� Y�ΰ� ��ȸ�ؼ� R�� �����
	public int setOsclY_dump(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		
		SqlQuery sql = sqlPage.getQuery("setOsclY_dump");
		retCount = executeUpdate(sql,pVO);
		return retCount;

	}

    //�ǽ������ �ǽ��������̺� �Է�
	
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

	//�ǽ����� ���ȯ�� ��ȸ
	public ValueObject getPopupActrList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getPopupActrList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	//�ǽ����� ���ȯ�� �˾� - ó�渮��Ʈ
	public ValueObject getPopupActrExopList(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getPopupActrExopList");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}

	//�������� ���������̼� üũ
	public ValueObject getPrvntMedc(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getPrvntMedc");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
	
	/* ��õ������̻�˻� ��õ������̻� [inborn errors of metabolism] �̼� ���1ȸ
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getInbornError(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject getInbornError(ValueObject pVO) throws LiveException {		
		ValueObject getVO = null;
		
		SqlQuery sql = sqlPage.getQuery("getInbornError");
		
		getVO = executeQuery(sql, pVO);

		return getVO;
	}
	
    /*
     *  (��Javadoc)
     * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getOrdOTPTRef(kr.co.hit.live.vo.ValueObject)
     * Ÿ�� �������� ���� otpt ��ȸ
     */
    public ValueObject getOrdOTPTRef(ValueObject pVO) throws LiveException {  
    	ValueObject getVO = null;
     
    	SqlQuery sql = sqlPage.getQuery("getOrdOTPTRef");
     
    	getVO = executeQuery(sql, pVO);
    	return getVO;
    } 

    //����μ�ø�������� üũ
    public ValueObject getHndcCnt(ValueObject pVO) throws LiveException {       
        ValueObject getVO = null;
        
        SqlQuery sql = sqlPage.getQuery("getHndcCnt");
        
        getVO = executeQuery(sql, pVO);

        return getVO;
    }

    //�̼� �Աݿ��� üũ
    public ValueObject getUncoStatYCnt(ValueObject pVO) throws LiveException {       
        ValueObject getVO = null;
        
        SqlQuery sql = sqlPage.getQuery("getUncoStatYCnt");
        
        getVO = executeQuery(sql, pVO);

        return getVO;
    }

    //������ ������ ���� üũ
    public ValueObject getChkCertList(ValueObject pVO) throws LiveException {       
        ValueObject getVO = null;
        
        SqlQuery sql = sqlPage.getQuery("getChkCertList");
        
        getVO = executeQuery(sql, pVO);

        return getVO;
    }

    //������ ONLN �����Աݾ� CD����
    public int insOnlnAmtDC(ValueObject pVO) throws LiveException {     
        int retCount = -1;
        SqlQuery sql = sqlPage.getQuery("insOnlnAmtDC");
        retCount = executeUpdate(sql,pVO);
        
        return retCount;

    }

    //������ ONLN �����Աݾ� CD����
    public int setOnlnAmtC(ValueObject pVO) throws LiveException {      
        int retCount = -1;
        SqlQuery sql = sqlPage.getQuery("setOnlnAmtC");
        retCount = executeUpdate(sql,pVO);
        
        return retCount;

    }   
    
    /*
     *  (��Javadoc)
     * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#getPatOectChk(kr.co.hit.live.vo.ValueObject)
     * ȯ�� �ܱ��� oecd ����
     */
    public ValueObject getPatOectChk(ValueObject pVO) throws LiveException {  
    	ValueObject getVO = null;
 
    	SqlQuery sql = sqlPage.getQuery("getPatOectChk");
 
    	getVO = executeQuery(sql, pVO);
    	return getVO;
    } 
  
	/*
	 * �����Ƿڳ��� ��ȸ
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
	 * ����ó���� ���
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
	 *  (��Javadoc)
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#setSuppkindsubyn(kr.co.hit.live.vo.ValueObject)
	 * Ÿ���� ���� ó��
	 */
	public int setSuppkindsubyn(ValueObject pVO) throws LiveException {		
		int retCount = -1;
		SqlQuery sql = sqlPage.getQuery("setSuppkindsubyn");
		retCount = executeUpdate(sql,pVO);
		
		return retCount;

	}

	//�ܷ�������ȭ�� �̼��ܾ� �������� 20110127 cys
	public ValueObject getUncoRemAmt(ValueObject pVO) throws LiveException {
		ValueObject rVO = new ValueObject();

		SqlQuery sql = sqlPage.getQuery("getUncoRemAmt");  
		rVO = executeQuery(sql,pVO);
		return rVO;
	}

    //ó��Ư������ N���� ���� 20110401 cys
	public int setChngSpecN(ValueObject pVO) throws LiveException {
		
		int[] retCounts = null;
		SqlQuery sql = sqlPage.getQuery("setChngSpecN");
		retCounts = executeBatch(sql,pVO);
		
		return retCounts.length;
	}

    //ó��Ư������ ���� 20110401 cys
	public int setChngSpecR(ValueObject pVO) throws LiveException {
		
		int[] retCounts = null;
		SqlQuery sql = sqlPage.getQuery("setChngSpecR");
		retCounts = executeBatch(sql,pVO);
		
		return retCounts.length;
	}

	//Ư������ ������ ��Ҵ��� ����20110415 cys
	public int setDelSpltList1(ValueObject pVO) throws LiveException {
        
        int retCount = 0;
        SqlQuery sql = sqlPage.getQuery("setDelSpltList1");
        retCount = executeUpdate(sql,pVO);

		return retCount;
	}

	//��Ȱ���а� �̿���ȯ�� ���޼��� üũ 20110426 cys
	public ValueObject getChkEtcM(ValueObject pVO) throws LiveException {
		ValueObject rVO = new ValueObject();

		SqlQuery sql = sqlPage.getQuery("getChkEtcM");  
		rVO = executeQuery(sql,pVO);
		return rVO;
	}


	/* �Ǻ�, �Ǻ� �ڰ� ���� ��ȸ
	 * @see himed.his.pam.outordamtmngtmgr.outrcptmgt.dao.OutRcptDAO#checkInsuInfo(kr.co.hit.live.vo.ValueObject)
	 */
	public ValueObject checkInsuInfo(ValueObject pVO) throws LiveException {
		ValueObject rVO = new ValueObject();
		
		//1. ���� �ڰ���ȸ ���� ��ȸ
		SqlQuery sql = sqlPage.getQuery("getMsg2Info");  
		ValueObject msgVO = executeQuery(sql,pVO);
		
		//2. ���� �ڰ���ȸ ���� ����! ����!!
		if( msgVO.size() < 1 ){
			rVO.set("errortype", "A");
			rVO.set("errormsg", "���� �ڰ���ȸ�� ���� �ʾҽ��ϴ�. �ڰ� ��ȸ�� �Ͻ� �� �����ϼ���!");
		}else{
			
			//�����޼��� ó���� Q/E ���п���
			String sMsgtype = msgVO.getString("errortype");
			
			//�������� ���� üũ
			String sInsukind;
			if( StringHelper.strEquals(msgVO.getString("qualflag"), "7")){			//�Ƿ�޿� 1��
				sInsukind = "21";
			}else if( StringHelper.strEquals(msgVO.getString("qualflag"), "8")){	//�Ƿ�޿� 2��
				sInsukind = "22";
			}else{
				sInsukind = "11";
			}
			
		//3.1 ���� ���� ��ġ ���� üũ
			if( ! StringHelper.strEquals(pVO.getString("insukind"), sInsukind)){
				rVO.set("errortype", sMsgtype);
				rVO.set("errormsg", "���������� ���� �ڰݰ� ��ġ ���� �ʽ��ϴ�! Ȯ�� �� �ٽ� �����ϼ���!");
				return rVO;
			}
		//3.2 �޿��������� üũ
			if( StringHelper.strEquals(msgVO.getString("paylimityn"), "Y")){
				rVO.set("errortype", sMsgtype);
				rVO.set("errormsg", "�޿��������ڸ� Ȯ���ϼ���! ["+ msgVO.getString("paylimdd")+"] ���� �޿����ѵ� ȯ���Դϴ�!");
				return rVO;
			}
		//3.3 �ⱹ�ڿ��� üũ
			if( StringHelper.strEquals(msgVO.getString("dcntrypsnyn"), "Y")){
				rVO.set("errortype", sMsgtype);
				rVO.set("errormsg", "�ⱹ���θ� Ȯ���ϼ���! �ⱹ ������ ���� �޿� ���� ������Դϴ�!");
				return rVO;
			}
		//4. �����ڰ� üũ.
			if( StringHelper.strEquals(pVO.getString("suppkind"), "06")				//��Ͼ�
					|| StringHelper.strEquals(pVO.getString("suppkind"), "11")			//������ȣ ��Ͼ�
					|| StringHelper.strEquals(pVO.getString("suppkind"), "38")			//������2�� ������ȣ ��Ͼ�
					|| StringHelper.strEquals(pVO.getString("suppkind"), "40")	){		//������2�� ��Ͼ�
				
				// �����ڰ��� ����, ���� ������û������ ���� ���
				if( ! StringHelper.strEquals(msgVO.getString("srdgyn"), "Y") && ! StringHelper.strEquals(msgVO.getString("srdgtdaygenyn"), "Y")){
					rVO.set("errortype", sMsgtype);
					rVO.set("errormsg", "�����ڰ��� ���� ȯ���Դϴ�! ���� ��û���θ� Ȯ���ϼ���!");
					return rVO;
				}
			}
		//AIDS ȯ�ڴ� Ư�ʽ�û�� ���� üũ�� �Ǹ� ������ �ȵ�.
		//5. ��ͳ�ġ����Ư�� üũ
			if( StringHelper.strEquals(pVO.getString("suppkind"), "50")				//��ͳ�ġ������Ư��
					|| StringHelper.strEquals(pVO.getString("suppkind"), "51")			//������ȣ ��ͳ�ġ������Ư��
					|| StringHelper.strEquals(pVO.getString("suppkind"), "46")){		//������2�� ��ͳ�ġ������Ư��
				
				// ����ڰ��� ����, ���� ��ͽ�û������ ���� ���
				if( ! StringHelper.strEquals(msgVO.getString("rooayn"), "Y") 
					&& ! StringHelper.strEquals(msgVO.getString("rooaesscyn"), "Y")  //��ͳ�ġ������Ư�� ��ȣ üũ���� Y üũ����
					&& ! StringHelper.strEquals(msgVO.getString("rooatdaygenyn"), "Y")){
					//rVO.set("errortype", sMsgtype);
					rVO.set("errortype", "Q");
					rVO.set("errormsg", "��ͳ�ġ������Ư�� �ڰ��� ���� ȯ���Դϴ�! \n��ͳ�ġ������Ư�� ��û���θ� Ȯ���ϼ���!");
					return rVO;
				}
			}
		//6. ����ȭ�� üũ
			if( StringHelper.strEquals(pVO.getString("suppkind"), "61")				//�������ȭ��
					|| StringHelper.strEquals(pVO.getString("suppkind"), "62")			//������ȣ �������ȭ��
					|| StringHelper.strEquals(pVO.getString("suppkind"), "64")			//������2�� ������ȣ �������ȭ��
					|| StringHelper.strEquals(pVO.getString("suppkind"), "63")	){		//������2�� �������ȭ��
				
				// ����ȭ���ڰ��� ����, ���� ����ȭ���û������ ���� ���
				if( ! StringHelper.strEquals(msgVO.getString("burnyn"), "Y") && ! StringHelper.strEquals(msgVO.getString("burntdaygenyn"), "Y")){
					rVO.set("errortype", sMsgtype);
					rVO.set("errormsg", "����ȭ�� �ڰ��� ���� ȯ���Դϴ�! ����ȭ�� ��û���θ� Ȯ���ϼ���!");
					return rVO;
				}
			}
		//7. H ��� üũ
			if( StringHelper.strEquals(pVO.getString("rareobstflag"), "H")){
				
				// H ��� �ڰ��� ���� ȯ��
				if( ! StringHelper.strEquals(msgVO.getString("rareyn"), "Y") ){
					rVO.set("errortype", sMsgtype);
					rVO.set("errormsg", "H ��� �ڰ��� ���� ȯ���Դϴ�!");
					return rVO;
				}
			}
		//8. ������ ���� Ʋ�� üũ
			if( StringHelper.strEquals(pVO.getString("suppkind"), "87")				//������ ���� Ʋ��
					|| StringHelper.strEquals(pVO.getString("suppkind"), "88")			//������1�� ������ ���� Ʋ��
					|| StringHelper.strEquals(pVO.getString("suppkind"), "89")	){		//������2�� ������ ���� Ʋ��
				
				// ������ ���� Ʋ�� �ڰ��� ����, ���� ������ ���� Ʋ�� ��û������ ���� ���
				if( ! StringHelper.strEquals(msgVO.getString("denturestopyn"), "Y") 
					&& ! StringHelper.strEquals(msgVO.getString("denturesbottomyn"), "Y")
					&& ! StringHelper.strEquals(msgVO.getString("denturestdaygenyn"), "Y")){
					rVO.set("errortype", sMsgtype);
					rVO.set("errormsg", "������ ����Ʋ�� �ڰ��� ���� ȯ���Դϴ�! ������ ����Ʋ�� ��û���θ� Ȯ���ϼ���!");
					return rVO;
				}
			}
			
		//9. ����� ��� üũ
			String scndinfo = StringHelper.null2string(msgVO.getString("scndsuptrgtman"), "-").substring(0, 1);
			String handicapdd = StringHelper.null2string(msgVO.getString("handicaprrgstdd"), "99991231");
			if(StringHelper.strEquals(pVO.getString("handicaprbookpossnyn"), "Y")){	//��ִ��
				if ( StringHelper.strEquals(pVO.getString("insukind"),"22") 			//�Ƿ�޿�2��
					 || ( StringHelper.strEquals(pVO.getString("insukind"),"11") 		//�ǰ����� ������ 2��
						 && Integer.parseInt(pVO.getString("suppkind")) > 32 
						 && Integer.parseInt(pVO.getString("suppkind")) < 47 )
					){
					
					
					//�������� + ������2��(F), �Ƿ�޿�2�� + ��ֵ����
					if( (StringHelper.strEquals(pVO.getString("insukind"),"11") && ! StringHelper.strEquals(scndinfo, "F"))
						|| (StringHelper.strEquals(pVO.getString("insukind"),"22") && handicapdd.compareTo(pVO.getString("orddd")) > 0 )
					  ){
						
						//��ִ�� �߻� ȯ���̸� �����ڰݿ��� ����ڰ� ������ üũ�Ѵ�.
						rVO.set("errortype", "Q");
						rVO.set("errormsg", "��ִ�� ���ȯ�ڰ� �ƴմϴ�.\n���ܿ� ��ֵ�������� Ȯ���ϼ���!");
						return rVO;
					}					
				}
			}
		}
		return rVO;
	}


	
	
	
	/* M005, M006 ���κδ��� ��� ���� ����/��Ͱ� �ƴҰ�� '-'�� ������Ʈ
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
			//Ư���ڵ尡 �Է¾ȵǾ� ������ ���� �����Ѵ�.
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