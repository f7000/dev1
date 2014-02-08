/**
 * @(#) OutRcptDAO.java
 *수정이력
 * 		- 2007. 4. 02 / 최초작성 / 최희경
 */
package himed.his.pam.outordamtmngtmgr.outrcptmgt.dao;

import kr.co.hit.live.exception.LiveException;
import kr.co.hit.live.vo.ValueObject;

/**
 *  <P> 외래수납 DAO Interface Class</P>
 *  외래수납/외래선수금수납을 데이터베이스에서 조회, 등록 기능을 제공한다.
 *  
 *  @author  최희경
 *  @version 1.0  2007. 4. 02
 */
public interface OutRcptDAO {
	
	/**
	 * <p>외래중간금(선수금)내역 조회</p>
	 * DB 에서 외래중간금(선수금)내역조회.
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>pid 				등록번호 
	 * <li>srchcond 		조회조건
	 * </ul>
	 * @return ValueObject
	 * <p>mdlamtspec : 출력데이터
	 * <ul>
	 * <li>rcptflag 		수납구분       
	 * <li>rcptexecdd		수납일자       
	 * <li>rcpttm			수납시간       
	 * <li>cashamt			현금금액       
	 * <li>cardamt			카드금액       
	 * <li>onlineamt		온라인금액     
	 * <li>rcptid			수납자ID       
	 * <li>remfact			참고사항       
	 * <li>rcptdd			영수일자       
	 * <li>rcptno			영수증번호     
	 * <li>rcptseqno		영수증일련번호 
	 * <li>seqno			일련번호       
	 * <li>instcd			기관코드       
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getMdlAmtList(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>카드수납금 조회</p>
	 * 카드수납금 조회
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>pid 				등록번호 
	 * <li>ordtype 			진료형태
	 * <li>preamtyn			선수금여부
	 * </ul>
	 * @return ValueObject
	 * <p>cardlist	 : 출력데이터
	 * <ul>
	 * <li>rcptdd		영수일자      
	 * <li>rcptno		영수증번호    
	 * <li>rcptseqno	영수증일련번호
	 * <li>seqno		일련번호      
	 * <li>instcd		기관코드      
	 * <li>rcpstat		수납상태      
	 * <li>ordtype		진료형태      
	 * <li>keyinptflag	키입력구분    
	 * <li>cardcmpycd	카드사코드    
	 * <li>cardno		카드번호      
	 * <li>aprvflag		승인구분      
	 * <li>aprvdd		승인일자      
	 * <li>aprvtm		승인시간	
	 * <li>aprvno		승인번호      
	 * <li>vancd		van코드       
	 * <li>allotmm		할부개월수    
	 * <li>cardamt		카드금액      
	 * <li>valiterm		유효기간      
	 * <li>rcptexecdd	수납일자      
	 * <li>rcpttm		수납시간      
	 * <li>rcptid	 	수납자ID      
	 * <li>remfact		참고사항      
	 * </ul>
	 * @throws LiveException
	 */
	public ValueObject getCardAmtList(ValueObject pVO) throws LiveException;


	/**
	 * <p>현금영수증수납금 조회</p>
	 * 현금영수증수납금 조회
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>pid 			등록번호 
	 * <li>ordtype 		진료형태
	 * <li>preamtyn		선수금여부
	 * </ul>
	 * @return ValueObject
	 * <p>cashlist	 : 출력데이터
	 * <ul>
	 * <li>rcptdd		영수일자       
	 * <li>rcptno		영수증번호     
	 * <li>rcptseqno	영수증일련번호 
	 * <li>seqno		일련번호       
	 * <li>instcd		기관코드       
	 * <li>rcpstat		수납상태       
	 * <li>ordtype		진료형태       
	 * <li>qualcnfmflag	키입력구분     
	 * <li>qualcnfmno 	카드사코드     
	 * <li>aprvflag		승인구분       
	 * <li>aprvdd		승인일자       
	 * <li>aprvtm		승인시간	
	 * <li>aprvno		승인번호       
	 * <li>cashamt		현금금액       
	 * <li>rcptexecdd	수납일자       
	 * <li>rcpttm		수납시간       
	 * <li>rcptid	 	수납자ID       
	 * <li>remfact		참고사항       
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getCashAmtList(ValueObject pVO) throws LiveException;

	
	/**
	 * <p>온라인입금수납금 조회</p>
	 * 온라인입금수납금 조회
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>pid 				등록번호 
	 * <li>ordtype 			진료형태
	 * <li>preamtyn			선수금여부
	 * </ul>
	 * @return ValueObject
	 * <p>onlinelist	 : 출력데이터
	 * <ul>
	 * <li>rcptdd		영수일자       
	 * <li>rcptno		영수증번호     
	 * <li>rcptseqno	영수증일련번호 
	 * <li>seqno		일련번호       
	 * <li>instcd		기관코드       
	 * <li>rcpstat		수납상태       
	 * <li>ordtype		진료형태       
	 * <li>bankcd		은행코드       
	 * <li>acntno		계좌번호       
	 * <li>paydd		입금일자       
	 * <li>paypsnnm		입금자명       
	 * <li>onlineamt	온라인금액     
	 * <li>rcptexecdd	수납일자       
	 * <li>rcpttm		수납시간       
	 * <li>rcptid	 	수납자ID       
	 * <li>remfact		참고사항       
	 * </ul>
	 * @throws LiveException
	 */
	public ValueObject getOnlineAmtList(ValueObject pVO) throws LiveException;

	
	/**
	 * <p>외래선수금 잔액 조회</p>
	 * 외래선수금 잔액 조회
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>pid 			등록번호 
	 * <li>srchcond		조회조건
	 * </ul>
	 * @return ValueObject
	 * <p>remamt	 : 외래선수금 잔액
	 * <ul>
	 * <li>remamt		잔액
	 * </ul>
	 * @throws LiveException
	 */
	public ValueObject getMdlRemAmt(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>외래선수금화면 잔액 조회</p>
	 * 외래선수금화면 잔액 조회
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>pid 			등록번호 
	 * <li>srchcond		조회조건
	 * </ul>
	 * @return ValueObject
	 * <p>remamt	 : 외래선수금 잔액
	 * <ul>
	 * <li>remamt		잔액
	 * </ul>
	 * @throws LiveException
	 */
	public ValueObject getMdlRemAmt2(ValueObject pVO) throws LiveException;


	/**
	 * <p>영수증번호 조회</p>
	 * 영수증번호 조회
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>rcptdd 			영수일자
	 * </ul>
	 * @return ValueObject
	 * <p>rcptno	 : 		출력데이터
	 * <ul>
	 * <li>rcptno			영수증번호
	 * </ul>
	 * @throws LiveException
	 */
	public ValueObject getRcptNo(ValueObject pVO) throws LiveException;
	
	
	/**
	 * <p>외래중간금(선수금) 수납 처리</p>
	 * 외래중간금(선수금) 수납처리
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>pid   		등록번호 	
	 * <li>rcptdd   	영수일자 	
	 * <li>rcptno   	영수증번호 	
	 * <li>rcptseqno   	영수증일련번호	
	 * <li>seqno   		일련번호	
	 * <li>instcd   	기관코드	
	 * <li>rcptstat   	수납상태	
	 * <li>ordtype   	진료형태	
	 * <li>rcptflag   	수납구분	
	 * <li>cashamt   	현금금액	
	 * <li>cardamt   	카드금액	
	 * <li>onlineamt   	온라인금액	
	 * <li>rcptexecdd  	수납일자	
	 * <li>rcpttm   	수납시간	
	 * <li>rcptid   	수납자ID	
	 * <li>remfact   	참고사항	
	 * <li>fstrgstrid   최초등록자	
	 * <li>fstrgstdt   	최초등록일시	
	 * <li>lastupdtrid  최종수정자	
	 * <li>lastupdtdt   최종수정일시    
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */

	public int insMdlAmt(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>온라인입금 수납 처리</p>
	 * 온라인입금 수납처리
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>online : 입력데이터
	 * <ul>
	 * <li>pid   		등록번호 		
	 * <li>rcptdd   	영수일자 		
	 * <li>rcptno   	영수증번호 		
	 * <li>rcptseqno   	영수증일련번호	  
	 * <li>seqno   		일련번호		
	 * <li>instcd   	기관코드		
	 * <li>rcptstat   	수납상태		
	 * <li>ordtype   	진료형태		
	 * <li>onlineamt   	온라인금액        
	 * <li>bankcd		은행코드          
	 * <li>acntno		계좌번호		
	 * <li>paydd		입금일자          
	 * <li>paypsnnm		입금자명          
	 * <li>rcptexecdd  	수납일자		
	 * <li>rcpttm   	수납시간		
	 * <li>rcptrid   	수납자ID	  
	 * <li>preamtyn		선수금여부        
	 * <li>innrtretyn	내부처리여부      
	 * <li>remfact   	참고사항		
	 * <li>fstrgstrid   최초등록자		
	 * <li>fstrgstdt   	최초등록일시	  
	 * <li>lastupdtrid  최종수정자		
	 * <li>lastupdtdt   최종수정일시      
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */

	public int insOnlineAmt(ValueObject pVO) throws LiveException;

	
	/**
	 * <p>온라인입금 수납취소 처리</p>
	 * 온라인입금 수납취소 처리
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>online : 입력데이터
	 * <ul>
	 * <li>pid   		등록번호 		
	 * <li>rcptdd   	영수일자 		
	 * <li>rcptno   	영수증번호 		
	 * <li>rcptseqno   	영수증일련번호	 
	 * <li>seqno   		일련번호		
	 * <li>instcd   	기관코드		
	 * <li>rcptstat   	수납상태		
	 * <li>ordtype   	진료형태		
	 * <li>onlineamt   	온라인금액       
	 * <li>bankcd		은행코드         
	 * <li>acntno		계좌번호		
	 * <li>paydd		입금일자         
	 * <li>paypsnnm		입금자명         
	 * <li>rcptexecdd  	수납일자		
	 * <li>rcpttm   	수납시간		
	 * <li>rcptrid   	수납자ID	 
	 * <li>preamtyn		선수금여부       
	 * <li>innrtretyn	내부처리여부     
	 * <li>remfact   	참고사항		
	 * <li>fstrgstrid   최초등록자		
	 * <li>fstrgstdt   	최초등록일시	 
	 * <li>lastupdtrid  최종수정자		
	 * <li>lastupdtdt   최종수정일시     
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */

	public int setOnlineAmt(ValueObject pVO) throws LiveException;
	
	
	/**
	 * <p>영수증번호 update</p>
	 * 최종 영수증번호를 update처리
	 * 
	 *
	 * @param pVO ValueObject	
	 * <p>req : 입력데이터
	 * <ul>	  		
	 * <li>rcptdd   			영수일자 		
	 * <li>rcptno   			영수증번호	 
 	 * </ul>
	 * @return  int
	 * @throws LiveException
	 */

	public int setRcptNo(ValueObject pVO) throws LiveException;

	/**
	 * <p>영수증번호 update</p>
	 * 최종 영수증번호를 insert처리
	 * 
	 *
	 * @param pVO ValueObject	
	 * <p>req : 입력데이터
	 * <ul>	  		
	 * <li>rcptdd   			영수일자 		
	 * <li>rcptno   			영수증번호	 
 	 * </ul>
	 * @return  int
	 * @throws LiveException
	 */

	public int insRcptNo(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>계산내역에 수납정보 update</p>
	 * 생성된 수납내역에 대한 계산내역 수납상태,수납정보(일자,순번) update
	 * 
	 *
	 * @param pVO ValueObject	
	 * <p>opmi : 입력데이터
	 * <ul>	  		
	 * <li>rcptdd   		영수일자 	
	 * <li>rcptexecdd   	수납일자 	
	 * <li>rcptno   		영수증번호	
	 * <li>rcptseqno   		영수일련번호 	
	 * <li>rcptstat   		수납상태 	
 	 * </ul>
	 * @return  int
	 * @throws LiveException
	 */

	public int setOutOrdAmtOscl(ValueObject pVO) throws LiveException;

	/**
	 * <p>외래등록내역에 수납정보 update</p>
	 * 생성된 수납내역에 대한 외래등록내역 수납상태,수납정보(일자,순번) update
	 * 
	 *
	 * @param pVO ValueObject	
	 * <p>opmi : 입력데이터
	 * <ul>	  		
	 * <li>rcptdd   		영수일자 	
	 * <li>rcptexecdd   	수납일자 	
	 * <li>rcptno   		영수증번호	 
	 * <li>rcptseqno   		영수일련번호 	
	 * <li>rcptstat   		수납상태 	
 	 * </ul>				              
	 * @return  int
	 * @throws LiveException
	 */

	public int setOutOrdAmtOtpt(ValueObject pVO) throws LiveException;

	
	/**
	 * <p>외래처방내역에 처방상태 update</p>
	 * 외래처방내역에 대한 외래등록내역 수납상태,수납정보(일자,순번) update
	 * 
	 *
	 * @param pVO ValueObject	
	 * <p>opmi : 입력데이터
	 * <ul>	  		
	 * <li>rcptdd   		영수일자        	
	 * <li>rcptexecdd   	수납일자 	
	 * <li>rcptno   		영수증번호      	 
	 * <li>rcptseqno   		영수일련번호    	
	 * <li>rcptstat   		수납상태        	
 	 * </ul>				                
	 * @return  int
	 * @throws LiveException
	 */

	public int setOutOrdStat(ValueObject pVO) throws LiveException;
	
	
	/**
	 * <p>외래등록내역 조회(외래수납)</p>
	 * 외래등록내역 조회(외래수납)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>pid 				등록번호
	 * <li>srchcond	조회조건
	 * </ul>
	 * @return ValueObject
	 * <p>rcptno	 : 		출력데이터
	 * <ul>
	 * <li>orddd			진료일자    
	 * <li>ordtm			진료시간    
	 * <li>orddept			진료과      
	 * <li>orddr			진료의      
	 * <li>fsexamflag		초재진구분  
	 * <li>indukind			보험유형    
	 * <li>suppkind			보조유형    
	 * </ul>
	 * @throws LiveException
	 */		
	public ValueObject getOutRgstList(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>외래등록내역 조회(무인수납)</p>
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>pid 				등록번호
	 * </ul>
	 * @return ValueObject
	 * <p>otpt	 : 		출력데이터
	 * <ul>
	 * <li>orddd			진료일자    
	 * <li>ordtm			진료시간    
	 * <li>orddept			진료과      
	 * <li>orddr			진료의      
	 * <li>fsexamflag		초재진구분  
	 * <li>indukind			보험유형    
	 * <li>suppkind			보조유형    
	 * </ul>
	 * @throws LiveException
	 */		
	public ValueObject getOutRgstList2(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>보험정보 조회(수납화면)</p>
	 * 보험정보 조회(수납화면)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 보험정보 조회조건
	 * <ul>
	 * <li>pid 				등록번호 
	 * <li>insukind 		보험유형
	 * <li>insucd			보험자코드
	 * <li>appdd			적용일자
	 * </ul>
	 * @return ValueObject
	 * <p>ptin	 : 보험정보
	 * <ul>
	 * <li>insukind			보험유형         
	 * <li>insucd			보험자코드       
	 * <li>insuno			보험증번호       
	 * <li>insdrela			피보험자와의관계 
	 * <li>insdnm			피보험자명       
	 * <li>insdrrgstno1		피보험자주민번호1
	 * <li>insdrrgstno2		피보험자주민번호2
	 * <li>fromdd			시작일자         
	 * <li>todd				종료일자         
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getInsuInfo(ValueObject pVO) throws LiveException;

	/**
	 * <p>중증정보 조회(수납화면)</p>
	 * 중증정보 조회(수납화면)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 중증정보 조회조건
	 * <ul>
	 * <li>pid 				등록번호 
	 * <li>insukind 		보험유형
	 * <li>insucd			보험자코드
	 * <li>appdd			적용일자
	 * </ul>
	 * @return ValueObject
	 * <p>srdg	 : 중증정보
	 * <ul>
	 * <li>pid     			등록번호
     * <li>insuflag     	보험구분
     * <li>suppkind     	보조유형
     * <li>todd     		종료일자
     * <li>fromdd   		시작일자
     * <li>seridiagno     	중증번호
     * <li>apppsnnm     	신청자
	 * <li>rela     		신청자와의관계
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getSrdgInfo(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>자보자격정보 조회(수납화면)</p>
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 자보자격정보 조회조건
	 * <ul>
	 * <li>pid 				등록번호 
	 * <li>appdd			적용일자
	 * </ul>
	 * @return ValueObject
	 * <p>aipm	 : 자보자격정보
	 * <ul>
	 * <li>pid     			등록번호
     * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getAipmInfo(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>산재자격정보 조회(수납화면)</p>
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 산재자격정보 조회조건
	 * <ul>
	 * <li>pid 				등록번호 
	 * <li>appdd			적용일자
	 * </ul>
	 * @return ValueObject
	 * <p>icpm	 : 산재자격정보
	 * <ul>
	 * <li>pid     			등록번호
     * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getIcpmInfo(ValueObject pVO) throws LiveException;

	
	/**
	 * <p>환자계산정보 조회(수납화면)</p>
	 * 계산정보 조회(수납화면)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 환자계산정보 조회조건
	 * <ul>
	 * <li>pid 				등록번호 
	 * <li>orddd 			진료일자
	 * <li>cretno			생성번호
	 * <li>acptseqno		외래등록일련번호
	 * </ul>
	 * @return ValueObject
	 * <p>oscl	 : 환자 계산정보 조회
	 * <ul>
	 * <li>pid     			등록번호                             
     * <li>orddd     		외래등록일자                         
     * <li>cretno     		외래등록생성번호                     
     * <li>calcseqno   		계산일련번호                         
     * <li>calcscorseqno    계산수행시,계산내역별 일련번호       
     * <li>instcd     		기관코드                             
	 * <li>calcstat			계산상태                             
	 * <li>clamtrgtstat		청구대상상태                         
	 * <li>acptseqno		외래등록생성번호별일련번호           
	 * <li>orddeptcd		진료과코드                           
	 * <li>orddrid			진료의사                             
	 * <li>mskind			주부유형                             
	 * <li>ordtype			진료형태                             
	 * <li>grupcalcscorcd	그룹수가코드                         
	 * <li>snglcalcscorcd	싱글수가코드                         
	 * <li>grupcalcscorcls	그룹수가분류                         
	 * <li>snglcalcscorcls	싱글수가분류                         
	 * <li>grupearncls		그룹수익분류                         
	 * <li>snglearncls		싱글수익분류                         
	 * <li>ordqty			처방지시투여량                       
	 * <li>ordtims			처방지시투여횟수                     
	 * <li>orddays			처방지시투여일수                     
	 * <li>calcqty			계산투여량                           
	 * <li>calctims			계산투여횟수                         
	 * <li>calcdays			계산투여일수                         
	 * <li>matractflag		재료행위구분                         
	 * <li>calcpayflag		급여구분                             
	 * <li>prcppayflag		처방급여구분                         
	 * <li>calcscorpayflag	수가급여구분2                        
	 * <li>ansttm			마취시간                             
	 * <li>spccd			검체코드                             
	 * <li>pntunitcost		점당단가                             
	 * <li>calcscorpnt		수가점수                             
	 * <li>estmpnt			산정점수                             
	 * <li>appunitcost		단가                                 
	 * <li>estmamt			산정금액                             
	 * ...							                     
	 * <li>fstrgstrid		최초등록자                           
	 * <li>fstrgstdt		최초등록일시                         
	 * <li>lastupdtrid		최종등록자                           
	 * <li>lastupdtdt		최종등록일시                         
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getOsclInfo(ValueObject pVO) throws LiveException;

	/**
	 * <p>환자계산정보 조회(수납화면)</p>
	 * 계산정보 조회(수납화면)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>otpt : 원외약존재여부 체크
	 * <ul>
	 * <li>pid 				등록번호 
	 * <li>orddd 			진료일자
	 * <li>cretno			생성번호
	 * <li>acptseqno		외래등록일련번호
	 * </ul>
	 * @return ValueObject
	 * <p>opmi	 : 			원외약존재여부 체크
	 * <ul>
	 * <li>pid     			등록번호
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getOutOrdExist(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>장애인환자여부  조회</p>
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>otpt : 환자정보
	 * <ul>
	 * <li>pid 				등록번호 
	 * </ul>
	 * @return ValueObject
	 * <p>opmi	 : 			장애인환자여부 조회
	 * <ul>
	 * <li>handicapyn     	장애인환자여부
	 * </ul>
	 * @throws LiveException
	 */
	public ValueObject getHandicapYN(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>연속처방 외래등록 또는 일반 외래등록의 원 ORDDD  조회 - 약국집계용</p>
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>opmi : 환자정보
	 * <ul>
	 * <li>pid 					등록번호 
	 * <li>orddd (actingorddd)	진료일자
	 * <li>cretno 				생성번호
	 * </ul>
	 * @return ValueObject
	 * <p>pharm	 : 				연속처방 외래등록 또는 일반 외래등록의 원 ORDDD  조회 - 약국집계용
	 * <ul>
	 * <li>orddd     			ORDDD
	 * </ul>
	 * @throws LiveException
	 */
	public ValueObject getOrddd(ValueObject pVO) throws LiveException;
	
	
	/**
	 * <p>계산내역에 대한 진료비정보 조회(수납화면)</p>
	 * 계산내역에 대한 진료비정보 조회(수납화면)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>otpt : 보험정보 조회조건
	 * <ul>
	 * <li>insukind 		보험유형 
	 * <li>suppkind 		보조유형
	 * </ul>
	 * @return ValueObject
	 * <p>tempinsu	 : 보험유형에 대한 부담률 조회
	 * <ul>
	 * <li>insukind
     * <li>suppkind
     * <li>calcscorappflag
     * <li>ioflag
     * <li>corpactaddrate
     * <li>outpayownbrate
	 * <li>inpayownbrate
	 * <li>medownbrate
	 * <li>ctownbrate
	 * <li>mriownbrate
	 * <li>sonoownbrate
	 * <li>petctownbrate
	 * <li>basemealownbrate
	 * <li>addmealownbrate
	 * <li>drugexptownbrate
	 * <li>fixbaseamt
	 * <li>fixminamt
	 * <li>fixmaxamt
	 * </ul>
	 * @throws LiveException
	 */	
	
	public ValueObject getInsuRateInfo(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>계산내역에 대한 진료비정보 조회(수납화면)</p>
	 * 계산내역에 대한 진료비정보 조회(수납화면)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 계산내역에 대한 진료비 정보 조회조건
	 * <ul>
	 * <li>pid 				등록번호 
	 * <li>orddd 			진료일자
	 * <li>cretno			생성번호
	 * <li>acptseqno		외래등록일련번호
	 * </ul>
	 * @return ValueObject
	 * <p>opmi	 :  계산내역에 대한 진료비 정보 조회
	 * <ul>
     * <li>payamt			급여금액                    
     * <li>nopyamt   		비급여액                    
     * <li>allownbamt 		비보험액(전액본인부담액)    
     * <li>specamt   		선택진료비총액              
     * <li>totownbamt   	총본인부담액                
     * <li>handcapfund   	장애인기금                  
     * <li>subtamt   		대불액                      
     * <li>bloddiscamt   	수혈대체액                  
     * <li>discreduamt   	감액(할인+감액)             
     * <li>uncoamt   		미수액                      
     * <li>precashamt   	기현금액                    
     * <li>premdlrcptamt  	기선수금                    
     * <li>precardamt   	기카드금액                  
     * <li>preonlineamt   	기온라인금액                
     * <li>mdlrcptamt   	선수금                      
     * <li>rcptexptamt   	납부할 금액                 
     * <li>cardamt   		카드금액                    
     * <li>cashamt   		현금금액                    
     * <li>onlineamt   		통장입금액                  
     * <li>paypsnflag   	납부자                      
     * <li>payrem   		납부자기타사항              
     * <li>instcd     		기관코드                    
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getOpmiInfoFromOscl(ValueObject pVO) throws LiveException;
	
	
	/**
	 * <p>기수납금 정보 조회(수납화면)</p>
	 * 기수납금 정보 조회(수납화면)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 기수납금 조회
	 * <ul>
	 * <li>pid 				등록번호 
	 * <li>orddd 			진료일자
	 * <li>cretno			생성번호
	 * <li>acptseqno		외래등록일련번호
	 * </ul>
	 * @return ValueObject
	 * <p>opmi	 :  기수납금조회
	 * <ul>
     * <li>precashamt   	기현금액
     * <li>premdlrcptamt  	기선수금
     * <li>precardamt   	기카드금액
     * <li>preonlineamt   	기온라인금액
     * <li>mdlrcptamt   	선수금
     * <li>instcd     		기관코드
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getPreOpmiInfo(ValueObject pVO) throws LiveException;

	/**
	 * <p>외래중간금(선수금) 수납 취소 처리</p>
	 * 외래중간금(선수금) 수납취소 처리
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>pid   			등록번호 		
	 * <li>rcptdd   		영수일자 		
	 * <li>rcptno   		영수증번호 		
	 * <li>rcptseqno   		영수증일련번호	
	 * <li>seqno   			일련번호		
	 * <li>instcd   		기관코드		
	 * <li>rcptstat   		수납상태		
	 * <li>ordtype   		진료형태		
	 * <li>rcptflag   		수납구분		
	 * <li>cashamt   		현금금액		
	 * <li>cardamt   		카드금액		
	 * <li>onlineamt   		온라인금액		
	 * <li>rcptexecdd  		수납일자		
	 * <li>rcpttm   		수납시간		
	 * <li>rcptid   		수납자ID		
	 * <li>remfact   		참고사항		
	 * <li>fstrgstrid   	최초등록자		
	 * <li>fstrgstdt   		최초등록일시	
	 * <li>lastupdtrid   	최종수정자		
	 * <li>lastupdtdt   	최종수정일시
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */

	public int setMdlAmt(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>외래 수납 처리</p>
	 * 외래 수납처리
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>opmi_pid          
	 * <li>opmi_rcptdd       
	 * <li>opmi_rcptno       
	 * <li>opmi_rcptseqno    
	 * <li>opmi_instcd       
	 * <li>opmi_rcptstat     
	 * <li>opmi_uncorcptflag 
	 * <li>opmi_orddd        
	 * <li>opmi_cretno       
	 * <li>opmi_acptseqno    
	 * <li>opmi_orddeptcd    
	 * <li>opmi_orddrid      
	 * <li>opmi_ordtype      
	 * <li>opmi_mskind       
	 * <li>opmi_insukind     
	 * <li>opmi_suppkind     
	 * <li>opmi_insucd       
	 * <li>opmi_totamt       
	 * <li>opmi_payamt       
	 * <li>opmi_nopyamt      
	 * <li>opmi_allownbamt   
	 * <li>opmi_payownbamt   
	 * <li>opmi_payinsubamt  
	 * <li>opmi_handcapfund  
	 * <li>opmi_ersubtamt    
	 * <li>opmi_procsubtamt  
	 * <li>opmi_subtamt      
	 * <li>opmi_specamt      
	 * <li>opmi_discreduamt  
	 * <li>opmi_discamt      
	 * <li>opmi_reduamt      
	 * <li>opmi_bloddiscamt  
	 * <li>opmi_totownbamt   
	 * <li>opmi_precashamt   
	 * <li>opmi_premdlrcptamt
	 * <li>opmi_precardamt   
	 * <li>opmi_preonlineamt 
	 * <li>opmi_mdlrcptamt   
	 * <li>opmi_uncoamt   	
	 * <li>opmi_cardamt   	
	 * <li>opmi_cashamt   	
	 * <li>opmi_onlineamt    
	 * <li>opmi_rcptexptamt  
	 * <li>opmi_restamt      
	 * <li>opmi_hosindrugno  
	 * <li>opmi_hosoutdrugno 
	 * <li>opmi_calcmthdflag 
	 * <li>opmi_remfact      
	 * <li>opmi_paypsnflag   
	 * <li>opmi_paypsnrem    
	 * <li>opmi_orgrcptdd    
	 * <li>opmi_orgrcptno    
	 * <li>opmi_orgrcptseqno 
	 * <li>opmi_rcptexecdd   
	 * <li>opmi_rcpttm       
	 * <li>opmi_rcptid       
	 * <li>opmi_fstrgstrid   
	 * <li>opmi_fstrgstdt   	
	 * <li>opmi_lastupdtrid  
	 * <li>opmi_lastupdtdt   
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */

	public int insOutOrdAmt(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>유형변경 사항 조회 </p>
	 * 보험유형, 할인내역, 외래등록내역(초재진구분,선택진료구분,진찰료산정구분 등)
	 * 등의 유형변경 사항 체크하여 정산구분 조회(return)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>Checkin : 입력데이터
	 * <ul>
	 * <li>insukind 		보험유형                                                                            
	 * <li>suppkind 		보조유형                                                                            
	 * <li>insucd 			보험자코드                                                                          
	 * <li>disccd 			할인코드                                                                            
	 * <li>specordyn		선택진료여부                                                                        
	 * <li>fsexamflag		초재진구분                                                                          
	 * <li>fsexammanlyn		초재진수동부여여부                                                                  
	 * <li>medamtestmyn	    진찰료산정여부                                                                      
	 * <li>medamtpostyn		진찰료후불여부                                                                      
	 * <li>medamtfreeresn	진찰료면제사유 진찰료 산정여부가 N=미산정,무료일때 미산정 사유(코드군 P1061 참조)				
	 * <li>etcordflag		기타진료구분(코드군 P0022 참조) J:주사  M:물리치료, F:가족, N:가정간호              
	 * </ul>
	 * @return ValueObject
	 * <p>Checkout	 : 		출력데이터
	 * <ul>
	 * <li>calcyn			정산여부
	 * </ul>
	 * @throws LiveException
	 */	
	//public ValueObject getChangelist(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>외래등록내역 이력추가 </p>
	 * 외래등록내역의 이력추가 및 기존내역 이력상태 변경
	 * 
	 * @param pVO ValueObject
	 * <p>pVO : 입력데이터
	 * <ul>
	 * <li>insukind 		보험유형                                                                          
	 * <li>suppkind 		보조유형                                                                          
	 * <li>insucd 			보험자코드                                                                        
	 * <li>disccd 			할인코드                                                                          
	 * <li>specordyn		선택진료여부                                                                      
	 * <li>fsexamflag		초재진구분                                                                        
	 * <li>fsexammanlyn		초재진수동부여여부                                                                
	 * <li>medamtestmyn	    진찰료산정여부                                                                    
	 * <li>medamtpostyn		진찰료후불여부                                                                    
	 * <li>medamtfreeresn	진찰료면제사유 진찰료 산정여부가 N=미산정,무료일때 미산정 사유(코드군 P1061 참조)				
	 * <li>etcordflag		기타진료구분(코드군 P0022 참조) J:주사  M:물리치료, F:가족, N:가정간호            
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */	
	public int insOtptHistAdd(ValueObject pVO) throws LiveException;
	
	
	/**
	 * <p>외래등록내역 이력추가 </p>
	 * 외래등록내역의 이력추가 및 기존내역 이력상태 변경
	 * 
	 * @param pVO ValueObject
	 * <p>pVO : 입력데이터
	 * <ul>
	 * <li>insukind 		보험유형                                                                          
	 * <li>suppkind 		보조유형                                                                          
	 * <li>insucd 			보험자코드                                                                        
	 * <li>disccd 			할인코드                                                                          
	 * <li>specordyn		선택진료여부                                                                      
	 * <li>fsexamflag		초재진구분                                                                        
	 * <li>fsexammanlyn		초재진수동부여여부                                                                
	 * <li>medamtestmyn	    진찰료산정여부                                                                    
	 * <li>medamtpostyn		진찰료후불여부                                                                    
	 * <li>medamtfreeresn	진찰료면제사유 진찰료 산정여부가 N=미산정,무료일때 미산정 사유(코드군 P1061 참조)					
	 * <li>etcordflag		기타진료구분(코드군 P0022 참조) J:주사  M:물리치료, F:가족, N:가정간호            
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */	
	public int insOtptHistAddCancel(ValueObject pVO) throws LiveException;	
	
	
	/**
	 * <p>유형변경 사항 조회 </p>
	 * 보험유형, 할인내역, 외래등록내역(초재진구분,선택진료구분,진찰료산정구분 등)
	 * 등의 유형변경 사항 체크하여 정산구분 조회(return)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>pVO : 입력데이터
	 * <ul>
	 * <li>pid 				등록번호
	 * <li>orddd 			진료일자
	 * <li>cretno 			생성번호
	 * <li>instcd 			기관기호
	 * </ul>
	 * @return ValueObject
	 * <p>retVO	 : 			출력데이터
	 * <ul>
	 * <li>pid 				등록번호
	 * <li>orddd 			진료일자
	 * <li>cretno 			생성번호
	 * <li>instcd 			기관기호
	 * <li>....  
	 * <li>lastupdtrid	    최종수정자ID
	 * <li>lastupdtdt		최종수정일시
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getLastOtpt(ValueObject pVO) throws LiveException;

	/**
	 * <p>보험정보 이력추가 </p>
	 * 새로 입력된 보험정보의 이력추가 및 기존내역 이력상태 변경
	 * 
	 * @param pVO ValueObject
	 * <p>pVO : 입력데이터
	 * <ul>
	 * <li>insukind 			보험유형
	 * <li>suppkind 			보조유형
	 * <li>insucd 				보험자코드
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */	
	public int insPtinHistAdd(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>감면정보 이력추가 </p>
	 * 새로 입력된 감면정보의 이력추가 및 기존내역 이력상태 변경
	 * 
	 * @param pVO ValueObject
	 * <p>pVO : 입력데이터
	 * <ul>
	 * <li>disccd 				할인코드
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */	
	public int insPtdcHistAdd(ValueObject pVO) throws LiveException;
	
	
	/**
	 * <p>환자정보조회(수납화면)</p>
	 * 환자정보조회(수납화면)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>srchcond 		조회조건	 
	 * <li>pid 				등록번호	 
	 * <li>hngnm 			한글이름	 
	 * <li>rrgstno1 		주민번호1	 
	 * <li>rrgstno2 		주민번호2	 
	 * </ul>
	 * @return ValueObject
	 * <p>ptbs		 : 출력데이터
	 * <ul>
	 * <li>pid 				등록번호	 
	 * <li>hngnm 			한글이름	 
	 * <li>...
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getPatInfo(ValueObject pVO) throws LiveException;


	/**
	 * <p>상병조회(외래수납화면)</p>
	 * 상병조회(외래수납화면)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>pid   		등록번호
	 * <li>orddd		진료일자
	 * <li>cretno		생성번호
 	 * </ul>
	 * @return ValueObject
	 * <p>diag : 출력데이터
	 * <ul>
	 * <li>diagcd		상병코드
	 * <li>diagcdnm		상병명
	 * <li>orddd		진료일자
	 * <li>chrncsickyn	만성병여부
	 * </ul>  
	 * @throws LiveException
	 */
	public ValueObject getPatDiag(ValueObject pVO) throws LiveException;
	
	
	/**
	 * <p>외래수납내역조회(외래정산화면)</p>
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>pid   		등록번호
	 * <li>orddd		진료일자
	 * <li>cretno		생성번호
	 * <li>orddeptcd	진료과
	 * <li>orddrid		진료의사
	 * <li>srchcond		조회조건
 	 * </ul>
	 * @return ValueObject
	 * <p>diag : 출력데이터
	 * <ul>
	 * <li>pid					등록번호
	 * <li>rcptdd				영수일자
	 * <li>....
	 * <li>lastupdtdt			최종수정일자
	 * </ul>  
	 * @throws LiveException
	 */
	public ValueObject getopmiList3(ValueObject pVO) throws LiveException;

	
	/**
	 * <p>외래등록내역조회(외래정산화면)</p>
	 * 외래등록내역조회(외래정산화면)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>opmi : 입력데이터
	 * <ul>
	 * <li>opmi_pid   			등록번호
	 * <li>opmi_rcptdd			수납일자(조건 시작일자)
	 * <li>opmi_rcptno			영수증번호
 	 * </ul>
	 * @return ValueObject
	 * <p>otpt : 외래등록
	 * <ul>
	 * <li>otpt_pid				등록번호
	 * <li>otpt_orddd			영수일자
	 * <li>....
	 * <li>lastupdtdt			최종수정일자
	 * </ul>  
	 * @throws LiveException
	 */
	public ValueObject getOtptInfo(ValueObject pVO) throws LiveException;

	
	/**
	 * <p>환자수익정보 조회(외래수납화면)</p>
	 * 외래등록 키로 수익정보 조회(외래수납조회화면)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 환자수익정보 조회조건-수납정보
	 * <ul>
	 * <li>pid 					등록번호 
	 * <li>orddd 				진료일자
	 * <li>cretno				생성번호 
	 * </ul>
	 * @return ValueObject
	 * <p>earn	 : 환자 수익정보 조회
	 * <ul>
	 * <li>outcls     			외래영수증구분
     * <li>outclsnm 			외래등록생성번호
     * <li>payamt   			급여
     * <li>nopyamt   			비급여
     * <li>specamt     			선택진료비
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getEarnInfo2(ValueObject pVO) throws LiveException;	
	
	
	/**
	 * <p>환자수익정보 조회(외래수납화면)</p>
	 * 외래등록 키로 수익정보 조회(외래수납조회화면)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 환자수익정보 조회조건-수납정보
	 * <ul>
	 * <li>pid 					등록번호 
	 * <li>orddd 				진료일자
	 * <li>cretno				생성번호 
	 * </ul>
	 * @return ValueObject
	 * <p>earn	 : 환자 수익정보 조회
	 * <ul>
	 * <li>outcls     			외래영수증구분
     * <li>outclsnm 			외래등록생성번호
     * <li>payamt   			급여
     * <li>nopyamt   			비급여
     * <li>specamt     			선택진료비
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getEarnInfo3(ValueObject pVO) throws LiveException;		
	

	/**
	 * <p>환자수익정보 조회(외래수납화면)</p>
	 * 외래등록 키로 수익정보 조회sum(외래수납조회화면)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 환자수익정보 조회조건-수납정보
	 * <ul>
	 * <li>pid 					등록번호 
	 * <li>orddd 				진료일자
	 * <li>cretno				생성번호 
	 * </ul>
	 * @return ValueObject
	 * <p>earn	 : 환자 수익정보 조회
	 * <ul>
	 * <li>outcls     			외래영수증구분
     * <li>outclsnm 			외래등록생성번호
     * <li>payamt   			급여
     * <li>nopyamt   			비급여
     * <li>specamt     			선택진료비
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getEarnInfo4(ValueObject pVO) throws LiveException;

	/**
	 * <p>외래 수납 DC 내역 생성 </p>
	 * 외래 수납 DC 내역 생성
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>opmi_pid          
	 * <li>opmi_rcptdd       
	 * <li>opmi_rcptno       
	 * <li>opmi_rcptseqno    
	 * <li>opmi_instcd       
	 * <li>opmi_rcptstat     
	 * <li>opmi_uncorcptflag 
	 * <li>opmi_orddd        
	 * <li>opmi_cretno       
	 * <li>opmi_acptseqno    
	 * <li>opmi_orddeptcd    
	 * <li>opmi_orddrid      
	 * <li>opmi_ordtype      
	 * <li>opmi_mskind       
	 * <li>opmi_insukind     
	 * <li>opmi_suppkind     
	 * <li>opmi_insucd       
	 * <li>opmi_totamt       
	 * <li>opmi_payamt       
	 * <li>opmi_nopyamt      
	 * <li>opmi_allownbamt   
	 * <li>opmi_payownbamt   
	 * <li>opmi_payinsubamt  
	 * <li>opmi_handcapfund  
	 * <li>opmi_ersubtamt    
	 * <li>opmi_procsubtamt  
	 * <li>opmi_subtamt      
	 * <li>opmi_specamt      
	 * <li>opmi_discreduamt  
	 * <li>opmi_discamt      
	 * <li>opmi_reduamt      
	 * <li>opmi_bloddiscamt  
	 * <li>opmi_totownbamt   
	 * <li>opmi_precashamt   
	 * <li>opmi_premdlrcptamt
	 * <li>opmi_precardamt   
	 * <li>opmi_preonlineamt 
	 * <li>opmi_mdlrcptamt   
	 * <li>opmi_uncoamt   	
	 * <li>opmi_cardamt   	
	 * <li>opmi_cashamt   	
	 * <li>opmi_onlineamt    
	 * <li>opmi_rcptexptamt  
	 * <li>opmi_restamt      
	 * <li>opmi_hosindrugno  
	 * <li>opmi_hosoutdrugno 
	 * <li>opmi_calcmthdflag 
	 * <li>opmi_remfact      
	 * <li>opmi_paypsnflag   
	 * <li>opmi_paypsnrem    
	 * <li>opmi_orgrcptdd    
	 * <li>opmi_orgrcptno    
	 * <li>opmi_orgrcptseqno 
	 * <li>opmi_rcptexecdd   
	 * <li>opmi_rcpttm       
	 * <li>opmi_rcptid       
	 * <li>opmi_fstrgstrid   
	 * <li>opmi_fstrgstdt   	
	 * <li>opmi_lastupdtrid  
	 * <li>opmi_lastupdtdt   
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insOutOrdAmtDC(ValueObject pVO) throws LiveException;


	/**
	 * <p>외래 계산내역  DC 내역 생성 </p>
	 * 외래 계산 DC 내역 생성
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>opmi_pid          
	 * <li>opmi_rcptdd       
	 * <li>opmi_rcptno       
	 * <li>opmi_rcptseqno    
	 * <li>opmi_instcd       
	 * <li>opmi_rcptstat     
	 * <li>opmi_uncorcptflag 
	 * <li>opmi_orddd        
	 * <li>opmi_cretno       
	 * <li>opmi_acptseqno    
	 * <li>opmi_orddeptcd    
	 * <li>opmi_orddrid      
	 * <li>opmi_ordtype      
	 * <li>opmi_mskind       
	 * <li>opmi_insukind     
	 * <li>opmi_suppkind     
	 * <li>opmi_insucd       
	 * <li>opmi_rcptexecdd   
	 * <li>opmi_rcpttm       
	 * <li>opmi_rcptid       
	 * <li>opmi_fstrgstrid   
	 * <li>opmi_fstrgstdt   	
	 * <li>opmi_lastupdtrid  
	 * <li>opmi_lastupdtdt   
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insOSCLDC(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>기존 외래수납 [변경]상태로 세팅 </p>
	 * 수납상태 수정(Y->C)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>pid   			등록번호 		
	 * <li>rcptdd   		영수일자 		
	 * <li>rcptno   		영수증번호 		
	 * <li>rcptseqno   		영수증일련번호	
	 * <li>seqno   			일련번호		
	 * <li>instcd   		기관코드		
	 * <li>rcptstat   		수납상태		
	 * <li>ordtype   		진료형태		
	 * <li>rcptflag   		수납구분		
	 * <li>fstrgstrid   	최초등록자		
	 * <li>fstrgstdt   		최초등록일시	
	 * <li>lastupdtrid   	최종수정자		
	 * <li>lastupdtdt   	최종수정일시
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int setOutOrdAmtC(ValueObject pVO) throws LiveException;


	/**
	 * <p>외래 계산내역  [변경]  </p>
	 * 외래 계산 [변경] 
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>opmi_pid          
	 * <li>opmi_rcptdd       
	 * <li>opmi_rcptno       
	 * <li>opmi_rcptseqno    
	 * <li>opmi_instcd       
	 * <li>opmi_rcptstat     
	 * <li>opmi_uncorcptflag 
	 * <li>opmi_orddd        
	 * <li>opmi_cretno       
	 * <li>opmi_acptseqno    
	 * <li>opmi_orddeptcd    
	 * <li>opmi_orddrid      
	 * <li>opmi_ordtype      
	 * <li>opmi_mskind       
	 * <li>opmi_insukind     
	 * <li>opmi_suppkind     
	 * <li>opmi_insucd       
	 * <li>opmi_rcptexecdd   
	 * <li>opmi_rcpttm       
	 * <li>opmi_rcptid       
	 * <li>opmi_fstrgstrid   
	 * <li>opmi_fstrgstdt   	
	 * <li>opmi_lastupdtrid  
	 * <li>opmi_lastupdtdt   
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int setOSCLC(ValueObject pVO) throws LiveException;

	
	/**
	 * <p>외래등록내역조회(외래정산화면)</p>
	 * 외래등록내역조회(외래정산화면)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>opmi : 입력데이터
	 * <ul>
	 * <li>opmi_pid   			등록번호
	 * <li>opmi_rcptdd			수납일자(조건 시작일자)
	 * <li>opmi_rcptno			영수증번호
 	 * </ul>
	 * @return ValueObject
	 * <p>otpt : 외래등록
	 * <ul>
	 * <li>otpt_pid				등록번호
	 * <li>otpt_orddd			영수일자
	 * <li>....
	 * <li>lastupdtdt			최종수정일자
	 * </ul>  
	 * @throws LiveException
	 */
	public ValueObject getOtptInfo2(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>외래등록내역조회(외래정산화면)</p>
	 * 외래등록내역조회(외래정산화면)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>opmi : 입력데이터
	 * <ul>
	 * <li>opmi_pid   			등록번호
	 * <li>opmi_rcptdd			수납일자(조건 시작일자)
	 * <li>opmi_rcptno			영수증번호
 	 * </ul>
	 * @return ValueObject
	 * <p>otpt : 외래등록
	 * <ul>
	 * <li>otpt_pid				등록번호
	 * <li>otpt_orddd			영수일자
	 * <li>....
	 * <li>lastupdtdt			최종수정일자
	 * </ul>  
	 * @throws LiveException
	 */
	public ValueObject getOtptInfo3(ValueObject pVO) throws LiveException;
	
	
	/**
	 * <p>처방 조회(외래수납조회화면)</p>
	 * 처방홀드위해 처방조회
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>pid   			등록번호
	 * <li>orddd			진료일자
	 * <li>cretno			외래생성번호
	 * </ul>
	 * @return ValueObject
	 * <p>prcp : 출력데이터
	 * <ul>
	 * <li>calcscorcd		수가코드
	 * <li>calcscorcdnm		수가코드명
	 * </ul>  
	 * @throws LiveException
	 */
	public ValueObject getprcpList2(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>홀드처방일자  조회(외래수납화면)</p>
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>pid   				등록번호
	 * <li>orddd				진료일자
	 * <li>cretno				외래생성번호
	 * </ul>
	 * @return ValueObject
	 * <p>prcp : 출력데이터
	 * <ul>
	 * <li>pid
	 * <li>prcpdd
	 * </ul>  
	 * @throws LiveException
	 */
	//public ValueObject getholdDDList(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>환자 HOLD 처방 조회(외래수납화면)</p>
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>pid   				등록번호
	 * <li>orddd				진료일자
	 * <li>cretno				외래생성번호
	 * </ul>
	 * @return ValueObject
	 * <p>prcp : 출력데이터
	 * <ul>
	 * <li>pid   				등록번호 		
	 * <li>calcscorcd
	 * <li>prcpdd
	 * <li>prcpno
	 * <li>prcphistno
	 * </ul>  
	 * @throws LiveException
	 */
	//public ValueObject getholdList(ValueObject pVO) throws LiveException;
	
	
	/**
	 * <p>청구대상상태  [변경]  </p>
	 * 청구대상상태  [변경] 
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>opmi_pid          
	 * <li>opmi_rcptdd       
	 * <li>opmi_rcptno       
	 * <li>opmi_rcptseqno    
	 * <li>opmi_instcd       
	 * <li>opmi_rcptstat     
	 * <li>opmi_uncorcptflag 
	 * <li>opmi_orddd        
	 * <li>opmi_cretno       
	 * <li>opmi_acptseqno    
	 * <li>opmi_orddeptcd    
	 * <li>opmi_orddrid      
	 * <li>opmi_ordtype      
	 * <li>opmi_mskind       
	 * <li>opmi_insukind     
	 * <li>opmi_suppkind     
	 * <li>opmi_insucd       
	 * <li>opmi_rcptexecdd   
	 * <li>opmi_rcpttm       
	 * <li>opmi_rcptid       
	 * <li>opmi_fstrgstrid   
	 * <li>opmi_fstrgstdt   	
	 * <li>opmi_lastupdtrid  
	 * <li>opmi_lastupdtdt   
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int setClamTrgtStat(ValueObject pVO) throws LiveException;
	
	
	/**
	 * <p>카드 수납 처리</p>
	 * 카드 수납처리
	 *
	 * @param pVO ValueObject
	 * <p>card : 입력데이터
	 * <ul>
	 * <li>pid   		등록번호 		
	 * <li>rcptdd   	영수일자 		
	 * <li>rcptno   	영수증번호 		
	 * <li>rcptseqno   	영수증일련번호	 
	 * <li>seqno   		일련번호		
	 * <li>instcd   	기관코드		
	 * <li>rcptstat   	수납상태		
	 * <li>ordtype   	진료형태		
	 * <li>cardamt   	카드금액         
	 * <li>cardno		카드번호         
	 * <li>aprvflag		승인구분         
	 * <li>aprvno		승인번호         
	 * <li>aprvdd		승인일자         
	 * <li>aprvtm		승인시           
	 * <li>rcptexecdd  	수납일자		
	 * <li>rcpttm   	수납시간		
	 * <li>rcptrid   	수납자ID	 
	 * <li>preamtyn		선수금여부       
	 * <li>innrtretyn	내부처리여부     
	 * <li>remfact   	참고사항		
	 * <li>fstrgstrid   최초등록자		
	 * <li>fstrgstdt   	최초등록일시	 
	 * <li>lastupdtrid  최종수정자		
	 * <li>lastupdtdt   최종수정일시     
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insCardAmt(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>현금영수증 수납 처리</p>
	 * 현금영수증 수납처리
	 *
	 * @param pVO ValueObject
	 * <p>cash : 입력데이터
	 * <ul>
	 * <li>pid   		등록번호 		
	 * <li>rcptdd   	영수일자 		
	 * <li>rcptno   	영수증번호 		
	 * <li>rcptseqno   	영수증일련번호	   
	 * <li>seqno   		일련번호		
	 * <li>instcd   	기관코드		
	 * <li>rcptstat   	수납상태		
	 * <li>ordtype   	진료형태		
	 * <li>cashamt   	현금금액           
	 * <li>qualcnfmflag	자격확인구분       
	 * <li>qualcnfmno	자격확인번         
	 * <li>aprvflag		승인구분           
	 * <li>aprvno		승인번호           
	 * <li>aprvdd		승인일자           
	 * <li>aprvtm		승인시             
	 * <li>rcptexecdd  	수납일자		
	 * <li>rcpttm   	수납시간		
	 * <li>rcptrid   	수납자ID	   
	 * <li>preamtyn		선수금여부         
	 * <li>innrtretyn	내부처리여부       
	 * <li>remfact   	참고사항		
	 * <li>fstrgstrid   최초등록자		
	 * <li>fstrgstdt   	최초등록일시	   
	 * <li>lastupdtrid  최종수정자		
	 * <li>lastupdtdt   최종수정일시       
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insCashAmt(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>미수내역 생성</p>
	 * 미수
	 *
	 * @param pVO ValueObject
	 * <p>unco : 입력데이터
	 * <ul>
	 * <li>pid         	환자의 고유ID                                                                                                
	 * <li>rcptdd       영수증 처리일자                                         
	 * <li>rcptno       영수증번호                                              
	 * <li>rcptseqno    영수증일련번호                                          
	 * <li>seqno        영수증번호별 일련번호                    
	 * <li>instcd       병원별 기관코드                                             
	 * <li>rcptstat     수납상태(코드군 P0049 참조)                             
	 * <li>ordtype      진료형태(외래,입원,응급)                                
	 * <li>orddd        외래등록일자:접수일자,예약일자                          
	 * <li>orddeptcd    진료과코드                                             
	 * <li>orddrid      진료의사,주치의                                         
	 * <li>dschdd       퇴원일자(퇴원미수금일경우)                              
	 * <li>insukind     보험유형                                 
	 * <li>suppkind     보조유형                                 
	 * <li>uncorcptflag 미수정산구분                             
	 * <li>uncocls      미수분류                                 
	 * <li>uncocd       미수코드                                                
	 * <li>uncoamt      미수금액                                                
	 * <li>rcptamt      미수수납금액                                            
	 * <li>debtamt      대손처리금액                                            
	 * <li>endyn        종결여부                                                
	 * <li>clincstdyno  임상시험번호(의사별 과제번호)                          
	 * <li>empid        직원공제미수 추가입력 사항 - 직원사원번호               
	 * <li>rcptexecdd   수납수행일자                                          
	 * <li>rcpttm       수납시간                                                
	 * <li>rcptrid      수납자ID                                                    
	 * <li>apprsn       적용사유                                                
	 * <li>remfact      수납내역에 대한 참고사항                                
	 * <li>fstrgstrid   최초등록자ID                                            
	 * <li>fstrgstdt    최초등록일시                                            
	 * <li>lastupdtrid  최종수정자ID                                            
	 * <li>lastupdtdt   최종수정일시                             
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insUncoAmt(ValueObject pVO) throws LiveException;

	/**
	 * <p>DC 미수내역 생성</p>
	 * 미수
	 *
	 * @param pVO ValueObject
	 * <p>unco : 입력데이터
	 * <ul>
	 * <li>pid         		환자의 고유ID                                                                                                 
	 * <li>orddd          	진료일자                                              
	 * <li>cretno          	생성번호                                                   
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insUncoAmtDC(ValueObject pVO) throws LiveException;
	
	/**
	 * <p> 미수내역 변경</p>
	 * 미수
	 *
	 * @param pVO ValueObject
	 * <p>unco : 입력데이터
	 * <ul>
	 * <li>pid         		환자의 고유ID                                                                                                 
	 * <li>orddd          	진료일자                                              
	 * <li>cretno          	생성번호                                                   
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int setUncoAmtC(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>임의감액내역 생성</p>
	 * 임의감액
	 *
	 * @param pVO ValueObject
	 * <p>dcgm : 입력데이터
	 * <ul>
	 * <li>pid         	환자의 고유ID          
	 * <li>rcptdd       영수증 처리일자        
	 * <li>rcptno       영수증번호             
	 * <li>seqno        영수증번호별 일련번호  
	 * <li>rcptseqno    영수증일련번호         
	 * <li>instcd       병원별 기관코드        
	 * <li>rcptstat     수납상태               
	 * <li>ordtype      진료형태               
	 * <li>discreduflag 할인감액구분           
	 * <li>discreducd   할인감액코드           
	 * <li>discreduamt  할인감액금액           
	 * <li>apprsn       적용사유               
	 * <li>rcptexecdd   수납수행일자           
	 * <li>rcpttm       수납시간               
	 * <li>rcptrid      수납자ID               
	 * <li>remfact      참고사항               
	 * <li>fstrgstrid   최초등록자ID           
	 * <li>fstrgstdt    최초등록일시           
	 * <li>lastupdtrid  최종수정자ID           
	 * <li>lastupdtdt   최종수정일시           
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insDcgmAmt(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>DC 할인,임의감액내역 생성</p>
	 * 할인, 임의감액
	 *
	 * @param pVO ValueObject
	 * <p>dcgm : 입력데이터
	 * <ul>
	 * <li>pid         		환자의 고유ID           
	 * <li>orddd          	진료일자         
	 * <li>cretno          	생성번호
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insDcgmAmtDC(ValueObject pVO) throws LiveException;

	/**
	 * <p>할인,임의감액내역 변경</p>
	 * 할인, 임의감액
	 *
	 * @param pVO ValueObject
	 * <p>dcgm : 입력데이터
	 * <ul>
	 * <li>pid         		환자의 고유ID           
	 * <li>orddd          	진료일자         
	 * <li>cretno          	생성번호
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int setDcgmAmtC(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>헌혈할인역 생성</p>
	 * 헌혈할인
	 *
	 * @param pVO ValueObject
	 * <p>bldc : 입력데이터
	 * <ul>
	 * <li>pid         		환자의 고유ID           
	 * <li>rcptdd          	영수증 처리일자         
	 * <li>rcptno          	영수증번호              
	 * <li>seqno           	영수증번호별 일련번호   
	 * <li>rcptseqno        영수증일련번호          
	 * <li>instcd          	병원별 기관코드         
	 * <li>rcptstat        	수납상태                
	 * <li>ordtype         	진료형태
	 * <li>orddd         	진료일자                
	 * <li>  .....
	 * <li>remfact         	참고사항                
	 * <li>fstrgstrid      	최초등록자ID            
	 * <li>fstrgstdt       	최초등록일시            
	 * <li>lastupdtrid     	최종수정자ID            
	 * <li>lastupdtdt      	최종수정일시
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insBldcAmt(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>DC 헌혈할인내역 생성</p>
	 * 할인, 임의감액
	 *
	 * @param pVO ValueObject
	 * <p>bldc : 입력데이터
	 * <ul>
	 * <li>pid         		환자의 고유ID           
	 * <li>orddd          	진료일자         
	 * <li>cretno          	생성번호
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insBldcAmtDC(ValueObject pVO) throws LiveException;

	/**
	 * <p>헌혈할인내역 변경</p>
	 * 헌혈할인
	 *
	 * @param pVO ValueObject
	 * <p>bldc : 입력데이터
	 * <ul>
	 * <li>pid         		환자의 고유ID           
	 * <li>orddd          	진료일자         
	 * <li>cretno          	생성번호
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int setBldcAmtC(ValueObject pVO) throws LiveException;


	/**
	 * <p>DC 카드내역 생성</p>
	 *
	 * @param pVO ValueObject
	 * <p>card : 입력데이터
	 * <ul>
	 * <li>pid         		환자의 고유ID           
	 * <li>orddd          	진료일자         
	 * <li>cretno          	생성번호
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insCardAmtDC(ValueObject pVO) throws LiveException;

	/**
	 * <p>카드내역 변경</p>
	 *
	 * @param pVO ValueObject
	 * <p>card : 입력데이터
	 * <ul>
	 * <li>pid         		환자의 고유ID           
	 * <li>orddd          	진료일자         
	 * <li>cretno          	생성번호
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int setCardAmtC(ValueObject pVO) throws LiveException;

	/**
	 * <p>기 카드내역 생성</p>
	 *
	 * @param pVO ValueObject
	 * <p>card : 입력데이터
	 * <ul>
	 * <li>pid         		환자의 고유ID           
	 * <li>orddd          	진료일자         
	 * <li>cretno          	생성번호
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insPreCardAmt(ValueObject pVO) throws LiveException;

	
	/**
	 * <p>DC 현금영수증내역 생성</p>
	 *
	 * @param pVO ValueObject
	 * <p>card : 입력데이터
	 * <ul>
	 * <li>pid         		환자의 고유ID           
	 * <li>orddd          	진료일자         
	 * <li>cretno          	생성번호
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insCashAmtDC(ValueObject pVO) throws LiveException;

	/**
	 * <p>현금영수증드내역 변경</p>
	 *
	 * @param pVO ValueObject
	 * <p>card : 입력데이터
	 * <ul>
	 * <li>pid         		환자의 고유ID           
	 * <li>orddd          	진료일자         
	 * <li>cretno          	생성번호
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int setCashAmtC(ValueObject pVO) throws LiveException;

	
	/**
	 * <p>DC 중간금내역 생성</p>
	 *
	 * @param pVO ValueObject
	 * <p>card : 입력데이터
	 * <ul>
	 * <li>pid         		환자의 고유ID           
	 * <li>orddd          	진료일자         
	 * <li>cretno          	생성번호
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insBogjAmtDC(ValueObject pVO) throws LiveException;

	/**
	 * <p>중간금내역 변경</p>
	 *
	 * @param pVO ValueObject
	 * <p>card : 입력데이터
	 * <ul>
	 * <li>pid         		환자의 고유ID           
	 * <li>orddd          	진료일자         
	 * <li>cretno          	생성번호
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int setBogjAmtC(ValueObject pVO) throws LiveException;
	
	
	/**
	 * <p>외래중간금(선수금) 수납취소 처리</p>
	 * 외래중간금(선수금) 수납취소 처리
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>pid   		등록번호 		
	 * <li>rcptdd   	영수일자 		
	 * <li>rcptno   	영수증번호 		
	 * <li>rcptseqno   	영수증일련번호	   
	 * <li>seqno   		일련번호		
	 * <li>instcd   	기관코드		
	 * <li>rcptstat   	수납상태		
	 * <li>ordtype   	진료형태		
	 * <li>rcptflag   	수납구분		
	 * <li>cashamt   	현금금액		
	 * <li>cardamt   	카드금액		
	 * <li>onlineamt   	온라인금액		
	 * <li>rcptexecdd  	수납일자		
	 * <li>rcpttm   	수납시간		
	 * <li>rcptid   	수납자ID		
	 * <li>remfact   	참고사항		
	 * <li>fstrgstrid   최초등록자		
	 * <li>fstrgstdt   	최초등록일시	   
	 * <li>lastupdtrid  최종수정자		
	 * <li>lastupdtdt   최종수정일시       
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insMdlAmtCncl(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>카드 수납취소 처리</p>
	 * 카드 수납취소 내역 생성
	 *
	 * @param pVO ValueObject
	 * <p>card : 입력데이터
	 * <ul>
	 * <li>pid   		등록번호 		
	 * <li>rcptdd   	영수일자 		
	 * <li>rcptno   	영수증번호 		
	 * <li>rcptseqno   	영수증일련번호	   
	 * <li>seqno   		일련번호		
	 * <li>instcd   	기관코드		
	 * <li>rcptstat   	수납상태		
	 * <li>ordtype   	진료형태		
	 * <li>cardamt   	카드금액           
	 * <li>cardno		카드번호           
	 * <li>aprvflag		승인구분           
	 * <li>aprvno		승인번호           
	 * <li>aprvdd		승인일자           
	 * <li>aprvtm		승인시             
	 * <li>rcptexecdd  	수납일자		
	 * <li>rcpttm   	수납시간		
	 * <li>rcptrid   	수납자ID	   
	 * <li>preamtyn		선수금여부         
	 * <li>innrtretyn	내부처리여부       
	 * <li>remfact   	참고사항		
	 * <li>fstrgstrid   최초등록자		
	 * <li>fstrgstdt   	최초등록일시	   
	 * <li>lastupdtrid  최종수정자		
	 * <li>lastupdtdt   최종수정일시       
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insCardAmtCncl(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>현금영수증 수납 처리</p>
	 * 현금영수증 수납취소내역 생성
	 *
	 * @param pVO ValueObject
	 * <p>cash : 입력데이터
	 * <ul>
	 * <li>pid   		등록번호 		
	 * <li>rcptdd   	영수일자 		
	 * <li>rcptno   	영수증번호 		
	 * <li>rcptseqno   	영수증일련번호	    
	 * <li>seqno   		일련번호		
	 * <li>instcd   	기관코드		
	 * <li>rcptstat   	수납상태		
	 * <li>ordtype   	진료형태		
	 * <li>cashamt   	현금금액            
	 * <li>qualcnfmflag	자격확인구분        
	 * <li>qualcnfmno	자격확인번          
	 * <li>aprvflag		승인구분            
	 * <li>aprvno		승인번호            
	 * <li>aprvdd		승인일자            
	 * <li>aprvtm		승인시              
	 * <li>rcptexecdd  	수납일자		
	 * <li>rcpttm   	수납시간		
	 * <li>rcptrid   	수납자ID	    
	 * <li>preamtyn		선수금여부          
	 * <li>innrtretyn	내부처리여부        
	 * <li>remfact   	참고사항		
	 * <li>fstrgstrid   최초등록자		
	 * <li>fstrgstdt   	최초등록일시	    
	 * <li>lastupdtrid  최종수정자		
	 * <li>lastupdtdt   최종수정일시        
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insCashAmtCncl(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>카드 수납 변경 처리</p>
	 * 카드 수납 변경  처리
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>card : 입력데이터
	 * <ul>
	 * <li>pid   		등록번호 		
	 * <li>rcptdd   	영수일자 		
	 * <li>rcptno   	영수증번호 		
	 * <li>rcptseqno   	영수증일련번호	 
	 * <li>seqno   		일련번호		
	 * <li>instcd   	기관코드		
	 * <li>rcptstat   	수납상태		
	 * <li>ordtype   	진료형태		
	 * <li>rcptexecdd  	수납일자		
	 * <li>rcpttm   	수납시간		
	 * <li>rcptrid   	수납자ID	 
	 * <li>preamtyn		선수금여부       
	 * <li>innrtretyn	내부처리여부     
	 * <li>remfact   	참고사항		
	 * <li>fstrgstrid   최초등록자		
	 * <li>fstrgstdt   	최초등록일시	 
	 * <li>lastupdtrid  최종수정자		
	 * <li>lastupdtdt   최종수정일시     
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int setCardAmt(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>현금영수증 수납 변경 처리</p>
	 * 현금영수증 수납 변경  처리
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>cash : 입력데이터
	 * <ul>
	 * <li>pid   		등록번호 	
	 * <li>rcptdd   	영수일자 	
	 * <li>rcptno   	영수증번호 	
	 * <li>rcptseqno   	영수증일련번호
	 * <li>seqno   		일련번호	
	 * <li>instcd   	기관코드	
	 * <li>rcptstat   	수납상태	
	 * <li>ordtype   	진료형태	
	 * <li>rcptexecdd  	수납일자	
	 * <li>rcpttm   	수납시간	
	 * <li>rcptrid   	수납자ID	
	 * <li>preamtyn		선수금여부    
	 * <li>innrtretyn	내부처리여부  
	 * <li>remfact   	참고사항	
	 * <li>fstrgstrid   최초등록자	
	 * <li>fstrgstdt   	최초등록일시	
	 * <li>lastupdtrid  최종수정자	
	 * <li>lastupdtdt   최종수정일시  
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int setCashAmt(ValueObject pVO) throws LiveException;
		

	/**
	 * <p>온라인입금 수납취소  처리</p>
	 * 온라인입금 수납취소 내역 생성
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>online : 입력데이터
	 * <ul>
	 * <li>pid   		등록번호 		
	 * <li>rcptdd   	영수일자 		
	 * <li>rcptno   	영수증번호 		
	 * <li>rcptseqno   	영수증일련번호	    
	 * <li>seqno   		일련번호		
	 * <li>instcd   	기관코드		
	 * <li>rcptstat   	수납상태		
	 * <li>ordtype   	진료형태		
	 * <li>onlineamt   	온라인금액          
	 * <li>bankcd		은행코드            
	 * <li>acntno		계좌번호		
	 * <li>paydd		입금일자            
	 * <li>paypsnnm		입금자명            
	 * <li>rcptexecdd  	수납일자		
	 * <li>rcpttm   	수납시간		
	 * <li>rcptrid   	수납자ID	    
	 * <li>preamtyn		선수금여부          
	 * <li>innrtretyn	내부처리여부        
	 * <li>remfact   	참고사항		
	 * <li>fstrgstrid   최초등록자		
	 * <li>fstrgstdt   	최초등록일시	    
	 * <li>lastupdtrid  최종수정자		
	 * <li>lastupdtdt   최종수정일시        
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insOnlineAmtCncl(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>환자보험정보조회(수납화면)</p>
	 * 키값이 같은내역
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>pid 				등록번호	 
	 * <li>insukind	 
	 * <li>suppkind	 
	 * <li>todd	 
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */	
	public ValueObject getPtin1(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>환자보험정보 이력생성(수납화면)</p>
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>pid 				등록번호	 
	 * <li>insukind	 
	 * <li>suppkind	 
	 * <li>todd	 
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */	
	public int insPtinHist(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>환자보험정보 기존내역 변경(수납화면)</p>
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>pid 				등록번호	 
	 * <li>insukind	 
	 * <li>suppkind	 
	 * <li>todd	 
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */	
	public int setPtinPreHist(ValueObject pVO) throws LiveException;
	

   /**
     * 진료의뢰환자 관리
     *
     * @param pVO ValueObject
	 * @return int
	 * @throws LiveException
	 */
    public int setCNST(ValueObject pVO) throws LiveException;


    /**
	 * <p>Hold/Release 처리</p>
	 * 
	 *
	 * @param pVO ValueObject	
	 * <p>opmi : 입력데이터
	 * <ul>	  		
	 * <li>pid   			등록번호 	
	 * <li>prcpdd   		처방일자 	
	 * <li>prcpno	   		처방번호 	
	 * <li>prcphistno		처방이력번호	 
	 * </ul>
	 * @return  int
	 * @throws LiveException
	 */
	public int setHoldPrcpList(ValueObject pVO) throws LiveException;
	
    
    /**
	 * <p>Release 시, 외래등록내역 추가 처리</p>
	 * 
	 *
	 * @param pVO ValueObject	
	 * <p>opmi : 입력데이터
	 * <ul>	  		
	 * <li>pid   			등록번호 	
	 * <li>orddd   			처방일자 	
	 * <li>cretno	   		처방번호 	
	 * </ul>
	 * @return  int
	 * @throws LiveException
	 */
	public int setAddOTPTFromHold(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>외래등록내역 조회(외래정산)</p>
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>pid 				등록번호
	 * <li>srchcond	조회조건
	 * <li>fromdd			시작일자
	 * <li>todd				종료일자
	 * <li>orddeptcd		진료과
	 * <li>orddrid			진료의사
	 * <li>insukind			보험유형
	 * </ul>
	 * @return ValueObject
	 * <p>otpt	 : 		출력데이터
	 * <ul>
	 * <li>orddd			진료일자
	 * <li>ordtm			진료시간
	 * <li>orddept			진료과
	 * <li>orddr			진료의
	 * <li>fsexamflag		초재진구분
	 * <li>indukind			보험유형
	 * <li>suppkind			보조유형 
	 * </ul>
	 * @throws LiveException
	 */		
	public ValueObject getOtptList(ValueObject pVO) throws LiveException;
    
	
	/**
	 * <p>외래등록내역별 수납내역 리스트</p>
	 * 외뢔등록별 수납내역 
	 * @author 김흥준
     * @version 1.0 2007.04.19
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>pid				환자등록번호
	 * <li>orddd      		진료일자 
	 * <li>cretno 		    생성번호
	 * <li>acptseqno 	    등록일련번호
     * </ul>
	 * @return ValueObject
	 * <p>rcptspeclist : 수납내역 리스트
	 * <ul>
	 * <li>pid              환자등록번호              
	 * <li>rcptdd           영수증일자                
	 * 	<li>rcptno          영수증번호             
	 * <li>rcptseqno        영수증일련변호         
	 * <li>instcd           기관코드                  
	 * <li>rcptstat         수납상태                  
	 * <li>uncorcptflag     미수정산구분           
	 * <li>orddd            진료일자               
	 * <li>cretno           생성번호                  
	 * <li>acptseqno        등록일련번호           
	 * <li>orddeptcd        진료과코드             
	 * <li>orddrid          진료의ID               
	 * <li>ordtype          진료형태               
	 * <li>mskind           주부유형               
	 * <li>insukind         부험유형               
	 * <li>suppkind         보조유형               
	 * <li>insucd           보험자코드             
	 * <li>payamt           급여금액               
	 * <li>allownbamt       전액본인부담액         
	 * <li>nopyamt          비급여액               
	 * <li>payownbamt       급여본인부담액         
	 * <li>payinsubamt      급여보험자부담액       
	 * <li>handcapfund      장애기금               
	 * <li>procsubtamt      의료급여대불액         
	 * <li>ersubtamt        응급대불액             
	 * <li>specamt          선택진료료             
	 * <li>discamt          할인액                 
	 * <li>reduamt          감액                   
	 * <li>bloddiscamt      혈액할인액             
	 * <li>totownbamt       총본인부담액           
	 * <li>premdlrcptamt    기중간수납금           
	 * <li>precardamt       기카드금액             
	 * <li>precashamt       기현금금액             
	 * <li>preonlineamt     기온라인금액           
	 * <li>mdlrcptamt       중간수납금             
	 * <li>uncoamt          미수금액               
	 * <li>cardamt          카드금액               
	 * 	<li>cashamt         현금금액               
	 * <li>onlineamt        온라인금액             
	 * <li>restamt          절사액                 
	 * <li>hosindrugno      원내투약번호           
	 * <li>hosoutdrugno     원외투약번호           
	 * <li>calcmthdflag     계산방법구분           
	 * <li>remfact          참고사항               
	 * <li>paypsnflag       원영수증일자           
	 * <li>paypsnrem        원영수증번호           
	 * <li>orgrcptdd        원영수증일련번호       
	 * <li>orgrcptno        납부자구분             
	 * <li>orgrcptseqno     납부자참고사항         
	 * <li>rcptexecdd       수납일자               
	 * <li>rcpttm           수납시간                  
	 * <li>rcptrid          수납자ID                  
	 * <li>fstrgstrid       최초등록자ID              
	 * <li>fstrgstdt        최초등록일시              
	 * <li>lastupdtrid      최종수정자ID           
	 * <li>lastupdtdt       최종수정일시	       
	 * </ul>
	 * @throws LiveException
	 */
	public ValueObject getOutRcptSpec(ValueObject pVO) throws LiveException;	
	

	/**
	 * <p>수납처리시 액팅처리  </p>
	 * 혈액은행 혈액료: 수혈,헌혈 액팅처리  
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>opmi_pid          
	 * <li>opmi_rcptdd       
	 * <li>opmi_rcptno       
	 * <li>opmi_rcptseqno    
	 * <li>opmi_instcd
	 * <li>opmi_rcptexecdd   
	 * <li>opmi_rcpttm       
	 * <li>opmi_rcptid
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int setActing(ValueObject pVO) throws LiveException;


	/**
	 * <p>수납처리시 계산내역에 액팅처리  </p>
	 * 혈액은행 혈액료: 수혈,헌혈 액팅처리  
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>opmi_pid          
	 * <li>opmi_rcptdd       
	 * <li>opmi_rcptno       
	 * <li>opmi_rcptseqno    
	 * <li>opmi_instcd
	 * <li>opmi_rcptexecdd   
	 * <li>opmi_rcpttm       
	 * <li>opmi_rcptid       
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int setActingOscl(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>VAN정보만 있는 카드내역 조회</p>
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>
	 * <ul>
	 * <li>pid 									등록번호 
	 * <li>fromdd								시작일자
	 * <li>todd 								종료일자
	 * </ul>
	 * @return ValueObject
	 * </ul>
	 * @throws LiveException
	 */
	public ValueObject getonlycvanList(ValueObject pVO) throws LiveException;


	/**
	 * <p>요율변경내역 조회</p>
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>
	 * <ul>
	 * <li>pid 									등록번호 
	 * </ul>
	 * @return ValueObject
	 * </ul>
	 * @throws LiveException
	 */
	public ValueObject getupdtrateList(ValueObject pVO) throws LiveException;
	
	
	/**
	 * <p>당일투석진료내역</p>
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>
	 * <ul>
	 * <li>pid 									등록번호 
	 * </ul>
	 * @return ValueObject
	 * </ul>
	 * @throws LiveException
	 */
	public ValueObject getupdtrateList1(ValueObject pVO) throws LiveException;	
	
	
	/**
	 * <p>요율변경내역 변경</p>
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>
	 * <ul>
	 * <li>pid 									등록번호 
	 * <li>orddd 								진료일자 
	 * <li>cretno 								생성번호 
	 * </ul>
	 * @return ValueObject
	 * </ul>
	 * @throws LiveException
	 */
	public int setupdtrateList(ValueObject pVO) throws LiveException;

	/**
	 * <p>환자계산정보 조회(수납화면)</p>
	 * 계산정보 조회(수납화면)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 환자계산정보 조회조건
	 * <ul>
	 * <li>pid 				등록번호 
	 * <li>orddd 			진료일자
	 * <li>cretno			생성번호
	 * <li>acptseqno		외래등록일련번호
	 * </ul>
	 * @return ValueObject
	 * <p>oscl	 : 환자 계산정보 조회
	 * <ul>
	 * <li>pid     			등록번호                        
     * <li>orddd     		외래등록일자                    
     * <li>cretno     		외래등록생성번호                
     * <li>calcseqno   		계산일련번호                    
     * <li>calcscorseqno    계산수행시,계산내역별 일련번호  
     * <li>instcd     		기관코드                        
	 * <li>calcstat			계산상태                        
	 * <li>clamtrgtstat		청구대상상태                    
	 * <li>acptseqno		외래등록생성번호별일련번호      
	 * <li>orddeptcd		진료과코드                      
	 * <li>orddrid			진료의사                        
	 * <li>mskind			주부유형                        
	 * <li>ordtype			진료형태                        
	 * <li>grupcalcscorcd	그룹수가코드                    
	 * <li>snglcalcscorcd	싱글수가코드                    
	 * <li>grupcalcscorcls	그룹수가분류                    
	 * <li>snglcalcscorcls	싱글수가분류                    
	 * <li>grupearncls		그룹수익분류                    
	 * <li>snglearncls		싱글수익분류                    
	 * <li>ordqty			처방지시투여량                  
	 * <li>ordtims			처방지시투여횟수                
	 * <li>orddays			처방지시투여일수                
	 * <li>calcqty			계산투여량                      
	 * <li>calctims			계산투여횟수                    
	 * <li>calcdays			계산투여일수                    
	 * <li>matractflag		재료행위구분                    
	 * <li>calcpayflag		급여구분                        
	 * <li>prcppayflag		처방급여구분                    
	 * <li>calcscorpayflag	수가급여구분2                   
	 * <li>ansttm			마취시간                        
	 * <li>spccd			검체코드                        
	 * <li>pntunitcost		점당단가                        
	 * <li>calcscorpnt		수가점수                        
	 * <li>estmpnt			산정점수                        
	 * <li>appunitcost		단가                            
	 * <li>estmamt			산정금액                        
	 * ...							                
	 * <li>fstrgstrid		최초등록자                      
	 * <li>fstrgstdt		최초등록일시                    
	 * <li>lastupdtrid		최종등록자                      
	 * <li>lastupdtdt		최종등록일시                    
	 * </ul>				                                
	 * @throws LiveException
	 */	
	public ValueObject getEarnOsclInfo(ValueObject pVO) throws LiveException;		
	
	
	/**
	 * <p>외래처방내역에 처방급비정보변경 update</p> 
	 *
	 * @param pVO ValueObject	
	 * <p>opmi : 입력데이터
	 * <ul>	  		
	 * <li>rcptdd   		영수일자 	
	 * <li>rcptexecdd   	수납일자 	
	 * <li>rcptno   		영수증번호	 
	 * <li>rcptseqno   		영수일련번호 	
	 * <li>rcptstat   		수납상태 	
 	 * </ul>
	 * @return  int
	 * @throws LiveException
	 */
	public int setOprcPayFlag(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>외래등록내역의 이력추가 및 기존내역 이력상태 변경</p> 
	 *
	 * @param pVO ValueObject	
	 * <p>pVO : 입력데이터
	 * <ul>	  		
	 * <li>histstat 이력상태 	
	 * <li>pid 환자번호 	
	 * <li>orddd 진료일자	 
	 * <li>cretno 순번 	
	 * <li>instcd 기관코드 	
 	 * </ul>
	 * @return  int
	 * @throws LiveException
	 */
	public int insOtptHistSuppkindAdd(ValueObject pVO) throws LiveException;	
	
  
	/**
	 * <p>멀티건 유형변경 사항 조회 </p>
	 * 보험유형, 할인내역, 외래등록내역(초재진구분,선택진료구분,진찰료산정구분 등)
	 * 등의 유형변경 사항 체크하여 정산구분 조회(return)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>Checkin : 입력데이터
	 * <ul>
	 * <li>insukind 		보험유형                                                                          
	 * <li>suppkind 		보조유형                                                                          
	 * <li>insucd 			보험자코드                                                                        
	 * <li>disccd 			할인코드                                                                          
	 * <li>specordyn		선택진료여부                                                                      
	 * <li>fsexamflag		초재진구분                                                                        
	 * <li>fsexammanlyn		초재진수동부여여부                                                                
	 * <li>medamtestmyn	    진찰료산정여부                                                                    
	 * <li>medamtpostyn		진찰료후불여부                                                                    
	 * <li>medamtfreeresn	진찰료면제사유 진찰료 산정여부가 N=미산정,무료일때 미산정 사유(코드군 P1061 참조)				
	 * <li>etcordflag		기타진료구분(코드군 P0022 참조) J:주사  M:물리치료, F:가족, N:가정간호            
	 * </ul>												                  
	 * @return ValueObject									                  
	 * <p>Checkout	 : 		출력데이터                                                                        
	 * <ul>													                  
	 * <li>calcyn			정산여부                                                                          
	 * </ul>
	 * @throws LiveException
	 */	
	//public ValueObject getMultiChangelist(ValueObject pVO) throws LiveException;    



	/**
	 * <p>멀티건 외래등록내역 이력추가 </p>
	 * 외래등록내역의 이력추가 및 기존내역 이력상태 변경
	 * 
	 * @param pVO ValueObject
	 * <p>pVO : 입력데이터
	 * <ul>
	 * <li>insukind 		보험유형                                                                          
	 * <li>suppkind 		보조유형                                                                          
	 * <li>insucd 			보험자코드                                                                        
	 * <li>disccd 			할인코드                                                                          
	 * <li>specordyn		선택진료여부                                                                      
	 * <li>fsexamflag		초재진구분                                                                        
	 * <li>fsexammanlyn		초재진수동부여여부                                                                
	 * <li>medamtestmyn	    진찰료산정여부                                                                    
	 * <li>medamtpostyn		진찰료후불여부                                                                    
	 * <li>medamtfreeresn	진찰료면제사유 진찰료 산정여부가 N=미산정,무료일때 미산정 사유(코드군 P1061 참조)				
	 * <li>etcordflag		기타진료구분(코드군 P0022 참조) J:주사  M:물리치료, F:가족, N:가정간호            
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */	
	public int insMultiOtptHistAdd(ValueObject pVO) throws LiveException;	


	/**
	 * <p>기현금영수증내역생성 </p>
	 * 실시정산 수납
	 * 
	 * @param pVO ValueObject
	 * <p>pVO : 입력데이터
	 * <ul>
	 * <li>opmi_pid 환자번호
	 * <li>opmi_orddd 진료일자
	 * <li>opmi_cretno 순번
	 * <li>instcd 기관코드
	 * <li>opmi_rcptexecdd 영수일자
	 * <li>opmi_rcpttm 수납시간
	 * <li>opmi_rcptrid 수납자
	 * <li>opmi_rcptno 수납번호
	 * <li>opmi_rcptseqno 순번
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */	
	public int insPreCashAmt(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>기중간금액 내역생성 </p>
	 * 실시정산 수납
	 * 
	 * @param pVO ValueObject
	 * <p>pVO : 입력데이터
	 * <ul>
	 * <li>opmi_pid 환자번호
	 * <li>opmi_orddd 진료일자
	 * <li>opmi_cretno 순번
	 * <li>instcd 기관코드
	 * <li>opmi_rcptexecdd 영수일자
	 * <li>opmi_rcpttm 수납시간
	 * <li>opmi_rcptrid 수납자
	 * <li>opmi_rcptno 수납번호
	 * <li>opmi_rcptseqno 순번
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */	
	public int insPreBogjAmt(ValueObject pVO) throws LiveException;


	/**
	 * <p>환자진료의뢰서 입력</p>
	 * 
	 * 
	 * @param pVO ValueObject
	 * <p>pVO : 입력데이터.
	 * <ul>
     * <li>pid 환자번호
     * <li>orddd 진료일자
     * <li>orddeptcd 진료과
     * <li>insukind 보험정보
     * <li>ordreqformflag 진료의뢰서 종류
     * <li>etcordflag 기타구분
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insOutOrdCnst(ValueObject pVO) throws LiveException;


	/**
     * <p> 외래미시행처방 미시행 오더를 조회한다.</p>
     * @author 
     * @param pVO ValueObject
     * <ul>
     * <li>pid 등록번호
     * <li>orddd 처방일
     * <li>prcphopedd 실시희망일
     * <li>orddeptcd 진료과
     * <li>orddrid 주치의
     * <li>insukind 보험유형
     * <li>chk2 시행처방포함여부
     * <li>instcd 기관코드
     * </ul>
     * @return ValueObject
     * <ul>
     * <li>update rowStatus
     * <li>spclchange 특정내역 변경여부
     * <li>pid 등록번호
     * <li>grupsnglyn 그룹여부
     * <li>calcscorcd 처방코드
     * <li>edicd EDI코드
     * <li>ordnm 처방명
     * <li>payflagcd 급
     * <li>execprcpqty 투여랑
     * <li>execprcptims 횟수
     * <li>execprcpdayno 일수
     * <li>orddd 외래등록일자
     * <li>cretno 외래등록 생성번호
     * <li>prcphopedd 실시희망일
     * <li>actorddd 실시희망일
     * <li>exectm 실시시간
     * <li>execprcpstatcd 실시상태
     * <li>judgendflag 통합심사
     * <li>ioflag 외래구분
     * <li>orddeptcd 진료과
     * <li>orddrid 주치의
     * <li>diagyn 상병
     * <li>unitflag 단위구분
     * <li>spclcd 특정코드
     * <li>spclspec 특정내역
     * <li>prcpdd 처방일자
     * <li>prcptm 처방일시
     * <li>prcpno 처방번호
     * <li>prcphistno 처방이력번호
     * <li>execprcpseqno 실시처방일련번호
     * <li>instcd 기관코드
     * <li>spclmemoflag 특정메모구분
     * <li>remfact 참고사항
     * <li>spclyn 저장여부
     * <li>seqno 일련번호
     * <li>insukind 보험유형
     * <li>rsrvtm 예약일시
     * <li>payflagyn 급비변경여부
     * <li>hosinhosoutflag 원내원외구분
     * </ul>
     * @throws LiveException
     */
	public ValueObject getOutUnExecPrcpOrdRef(ValueObject pVO) throws LiveException;
	
	
	
	/**
     * <p> 입원 오더를 조회한다.</p>
     * @author 
     * @param pVO ValueObject
     * <ul>
     * <li>pid 등록번호
     * <li>orddd 처방일
     * <li>prcphopedd 실시희망일
     * <li>orddeptcd 진료과
     * <li>orddrid 주치의
     * <li>insukind 보험유형
     * <li>chk2 시행처방포함여부
     * <li>instcd 기관코드
     * </ul>
     * @return ValueObject
     * <ul>
     * <li>update rowStatus
     * <li>spclchange 특정내역 변경여부
     * <li>pid 등록번호
     * <li>grupsnglyn 그룹여부
     * <li>calcscorcd 처방코드
     * <li>edicd EDI코드
     * <li>ordnm 처방명
     * <li>payflagcd 급
     * <li>execprcpqty 투여랑
     * <li>execprcptims 횟수
     * <li>execprcpdayno 일수
     * <li>orddd 외래등록일자
     * <li>cretno 외래등록 생성번호
     * <li>prcphopedd 실시희망일
     * <li>actorddd 실시희망일
     * <li>exectm 실시시간
     * <li>execprcpstatcd 실시상태
     * <li>judgendflag 통합심사
     * <li>ioflag 외래구분
     * <li>orddeptcd 진료과
     * <li>orddrid 주치의
     * <li>diagyn 상병
     * <li>unitflag 단위구분
     * <li>spclcd 특정코드
     * <li>spclspec 특정내역
     * <li>prcpdd 처방일자
     * <li>prcptm 처방일시
     * <li>prcpno 처방번호
     * <li>prcphistno 처방이력번호
     * <li>execprcpseqno 실시처방일련번호
     * <li>instcd 기관코드
     * <li>spclmemoflag 특정메모구분
     * <li>remfact 참고사항
     * <li>spclyn 저장여부
     * <li>seqno 일련번호
     * <li>insukind 보험유형
     * <li>rsrvtm 예약일시
     * <li>payflagyn 급비변경여부
     * <li>hosinhosoutflag 원내원외구분
     * </ul>
     * @throws LiveException
     */
	public ValueObject getInUnExecPrcpOrdRef(ValueObject pVO) throws LiveException;
	


	/**
     * <p> 외래미시행처방 환자정보를 조회한다.</p>
     * @author 
     * @param pVO ValueObject
     * <ul>
     * <li>pid 등록번호
     * <li>instcd 기관코드
     * </ul>
     * @return ValueObject
     * <ul>
     * <li>pid 등록번호
     * <li>patnm 사용자명
     * </ul>
     * @throws LiveException
     */
	public ValueObject getPayPatInfo(ValueObject pVO) throws LiveException;
	

	/**
     * <p> 외래미시행 처방 내역을 조회한다.</p>
     * @author 
     * @param pVO ValueObject
     * <ul>
     * <li>pid 등록번호
     * <li>orddeptcd 진료과
     * <li>chk 타과포함여부
     * <li>chk2 시행처방포함여부
     * <li>fromdd 시작일
     * <li>todd 종료일
     * <li>instcd 기관코드
     * <li>sysdate 현재일자
     * </ul>
     * @return ValueObject
     * <ul>
     * <li>pid 등록번호
     * <li>instcd 기관코드
     * <li>orddd 처방일
     * <li>prcphopedd 실시희망일
     * <li>orddeptcd 진료과코드
     * <li>orddeptnm 진료과명
     * <li>orddrid 주치의코드
     * <li>orddrnm 주치의명
     * <li>insukind 보험유형
     * <li>cretno 생성번호
     * </ul>
     * @throws LiveException
     */    
	public ValueObject getOutUnExecPrcpRef(ValueObject pVO) throws LiveException;
	
	
	
	/**
     * <p>입원 처방 내역을 조회한다.</p>
     * @author 
     * @param pVO ValueObject
     * <ul>
     * <li>pid 등록번호
     * <li>orddeptcd 진료과
     * <li>chk 타과포함여부
     * <li>chk2 시행처방포함여부
     * <li>fromdd 시작일
     * <li>todd 종료일
     * <li>instcd 기관코드
     * <li>sysdate 현재일자
     * </ul>
     * @return ValueObject
     * <ul>
     * <li>pid 등록번호
     * <li>instcd 기관코드
     * <li>orddd 처방일
     * <li>prcphopedd 실시희망일
     * <li>orddeptcd 진료과코드
     * <li>orddeptnm 진료과명
     * <li>orddrid 주치의코드
     * <li>orddrnm 주치의명
     * <li>insukind 보험유형
     * <li>cretno 생성번호
     * </ul>
     * @throws LiveException
     */    
	public ValueObject getInUnExecPrcpRef(ValueObject pVO) throws LiveException;
	


	/**
     * <p> 외래미시행처방 미시행 오더 통합심사 완료 여부를 변경한다.</p>
     * @author 
     * @param pVO ValueObject
     * <ul>
     * <li>status 상태
     * <li>prcpdd 처방일자
     * <li>prcpno 처방번호
     * <li>prcphistno 처방이력번호
     * <li>execprcpseqno 실시처방일련번호
     * <li>judgendflag 통합심사여부
     * <li>instcd 기관코드
     * </ul>
     * @return int 수정건수
     * @throws LiveException
     */
	public int setJudgEnd(ValueObject pVO) throws LiveException;


	/**
     * <p> 처방 급비구분코드를 수정한다.</p>
     * @author 
     * @param pVO ValueObject
     * <ul>
     * <li>prcpdd 처방일자
     * <li>prcpno 처방일련번호
     * <li>prcphistno 처방이력번호
     * <li>payflagcd 급비구분코드
     * <li>chngid 수정자ID
     * <li>instcd 기관코드
     * </ul>
     * @return int 수정건수
     * @throws LiveException
     */
	public int setOrdPayFlag(ValueObject pVO) throws LiveException;
	
	
	
	/**
     * <p> 처방 급비구분코드를 수정한다.</p>
     * @author 
     * @param pVO ValueObject
     * <ul>
     * <li>prcpdd 처방일자
     * <li>prcpno 처방일련번호
     * <li>prcphistno 처방이력번호
     * <li>payflagcd 급비구분코드
     * <li>chngid 수정자ID
     * <li>instcd 기관코드
     * </ul>
     * @return int 수정건수
     * @throws LiveException
     */
	public int setInOrdPayFlag(ValueObject pVO) throws LiveException;


	/**
     * <p> 외래미시행처방 미시행 오더 특정 내역을 삭제한다.</p>
     * @author 
     * @param pVO ValueObject
     * <ul>
     * <li>delpid 등록번호
     * <li>delorddd 외래등록일자
     * <li>delcretno 외래등록 생성번호
     * <li>deledicd EDI코드
     * <li>delspclcd 특정코드
     * <li>instcd 기관코드
     * </ul>
     * @return int 삭제건수
     * @throws LiveException
     */
	public int delOutClcj(ValueObject pVO) throws LiveException;	


    /**
     * <p> 외래미시행처방 미시행 오더 특정 내역을 입력한다.</p>
     * @author 
     * @param pVO ValueObject
     * <ul>
     * <li>inspid 등록번호
     * <li>insorddd 외래등록일자
     * <li>inscretno 외래등록 생성번호
     * <li>prcpdd 처방일자
     * <li>prcpno 처방번호
     * <li>prcphistno 처방이력번호
     * <li>execprcpseqno 실시처방일련번호
     * <li>unitflag 통합심사
     * <li>spclmemoflag 특정메모구분
     * <li>edicd EDI코드
     * <li>spclcd 특정코드
     * <li>spclspec 특정내역
     * <li>remfact 참고사항
     * <li>grupsnglyn 그룹싱글여부
     * <li>calcscorcd 처방코드
     * <li>lastupdtrid 최종수정자ID
     * <li>instcd 기관코드
     * </ul>
     * @return int 입력건수
     * @throws LiveException
     */
	public int insOutClcj(ValueObject pVO) throws LiveException;


	/**
	 * <p> 처방 급비구분코드 수정 후, 외래환자 접수 이력정보를 생성한다. </p>
	 * @author
	 * @param pVO ValueObject
	 * <ul>
	 * <li>pid 환자번호
	 * <li>orddd 접수일자
	 * <li>cretno 생성번호
	 * <li>instcd 기관코드
	 * <li>fstrgstrid 최초생성자ID
	 * <li>lastupdtrid 최종수정자ID
	 * </ul>
	 * @return int 입력건수
	 * @throws LiveException
	 */	   
	public int setOutPatInfoHist(ValueObject pVO) throws LiveException;
	
	
	/**
	 * <p> 처방 급비구분코드 수정 후, 입원 소급일자 생성한다. </p>
	 * @author
	 * @param pVO ValueObject
	 * <ul>
	 * <li>pid 환자번호
	 * <li>orddd 접수일자
	 * <li>cretno 생성번호
	 * <li>instcd 기관코드
	 * <li>fstrgstrid 최초생성자ID
	 * <li>lastupdtrid 최종수정자ID
	 * </ul>
	 * @return int 입력건수
	 * @throws LiveException
	 */	   
	public int setInPatInfoHist(ValueObject pVO) throws LiveException;


    /**
     * 외래수납
     * 계산취소시 마지막 otpt를 hist테이블에서 구한다.
     * 2008.06.26. updated by 조영상
     * @param pVO ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getPreOtptHist(ValueObject pVO) throws LiveException;


	/**
     * 외래수납
     * 외래수납 계산취소 OTPT에 계산구분 변경
     * 2008.06.26. updated by 조영상
     * @param pVO ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int setOtptCalcflag(ValueObject pVO) throws LiveException;


	/**
     * 외래수납
     * 외래수납 계산취소 OSCL 삭제
     * 2008.07.01. updated by 조영상
     * @param pVO ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int delOsclCancel(ValueObject pVO) throws LiveException;


    /*
     * 현금영수증 디폴트 승인번호
     * 2007.07.04. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getPidInfoCshb(ValueObject pVO) throws LiveException;


    /*
     * 의사소견서관리팝업 조회
     * 2007.07.07. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getDrcmList(ValueObject pVO) throws LiveException;


    /*
     * 의사소견서관리팝업 저장
     * 2007.07.07. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int insDrcmList(ValueObject pVO) throws LiveException;


    /*
     * 의사소견서관리팝업 삭제
     * 2007.07.07. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int delDrcmList(ValueObject pVO) throws LiveException;

	
    /*
     * 환자처방내역조회
     * 2007.07.08. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getExopList(ValueObject pVO) throws LiveException;

	/*
     * 계산내역 조회
     * 2008.07.14. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getOsclList(ValueObject pVO ) throws LiveException;

	/*
     * 외래수납시 등록내역조회
     * 2008.07.23. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getRcptOtptList(ValueObject pVO) throws LiveException;

    /*
     * 방문간호지시서팝업 조회
     * 2007.07.07. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getHocmList(ValueObject pVO) throws LiveException;

    /*
     * 방문간호지시서팝업 저장
     * 2007.07.07. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int insHocmList(ValueObject pVO) throws LiveException;

    /*
     * 방문간호지시서팝업 삭제
     * 2007.07.07. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int delHocmList(ValueObject pVO) throws LiveException;


    /*
     * 의사면허번호조회
     * 2007.07.07. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public ValueObject getUsrdlicnsno(ValueObject pVO) throws LiveException;


    /*
     * 임상연구번호 가져오기
     * 2007.07.28. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getOscl_clincstdyno(ValueObject pVO) throws LiveException;


    /*
     * 계산시 홀드처방 유무 확인
     * 2007.08.01. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getHoldExop(ValueObject pVO) throws LiveException;


    /*
     * 계산시 미수납 처방 유무 확인
     * 2009.04.01. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getUnRcptExop(ValueObject pVO) throws LiveException;

	/*
     * B형 수직감염 처리
     * 2007.08.04. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getVtcltrsCheck(ValueObject pVO) throws LiveException;

    /*
     * 자보한도환자분리팝업
     * 외래등록내역조회
     * @author cys
     * @param pVOs ValueObject
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getOtptCarInsu(ValueObject pVO) throws LiveException;

    /*
     * 자보한도환자분리팝업
     * 처방내역조회
     * @author cys
     * @param pVOs ValueObject
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getOprcCarInsu(ValueObject pVO) throws LiveException;

    /*
     * 자보한도환자분리팝업
     * 외래처방 부유형 분리
     * @author cys
     * @param pVOs ValueObject
     * @return ValueObject
     * @throws LiveException
     */
	public int setOprcCarInsu(ValueObject pVO) throws LiveException;

    /*
     * 자보한도환자분리팝업
     * 외래등록 미계산상태로 변경
     * @author cys
     * @param pVOs ValueObject
     * @return ValueObject
     * @throws LiveException
     */
	public int setOtptCarFlag(ValueObject pVO) throws LiveException;

	/**
     * <p> 외래수납시 문자메세지 이력테이블 삭제.</p>
     * @author 
     * @param pVO ValueObject
     * <ul>
     * <li>pid 등록번호
     * <li>orddd 외래등록일자
     * <li>cretno 외래등록 생성번호
     * <li>instcd 기관코드
     * </ul>
     * @return int 삭제건수
     * @throws LiveException
     */
	public int delOutOrdSmsq(ValueObject pVO) throws LiveException;	

    /**
     * <p>외래수납 정산 수납내역 클릭시 수납내역조회</p>
     * 
     * 
     * @author 
     * @param pVO ValueObject
     * <p>otpt : 입력데이터
     * <ul>
     * <li>pid 등록번호
     * <li>orddd 진료일자
     * <li>ordtm 진료시간
     * <li>orddeptcd 진료과
     * <li>orddrid 진료의사
     * <li>fsexamflag 초재진구분
     * <li>insukind 보험유형
     * <li>suppkind 보조유형
     * <li>calcflag 계산구분
     * <li>cretno 외래등록생성번호
     * <li>acptseqno 외래등록이력번호
     * <li>orgorddd 원진료일자
     * <li>orgcretno 원생성번호
     * <li>calcbaseflag 계산기준구분
     * <li>calcyn 정산여부
     * <li>dutdeptcd 근무부서코드
     * <li>centcd 센터코드
     * <li>supdeptcd 상위부서코드
     * <li>mskind 주부유형
     * <li>insucd 보험자코드
     * <li>suppkindresn 보조유형사유
     * <li>specordyn 선택진료여부
     * <li>holiflag 공휴일구분
     * <li>fsexammanlyn 초재진수동부여여부
     * <li>ordtype 진료형태
     * <li>brateflag 부담률구분
     * <li>medamtestmyn 진찰료산정여부
     * <li>medamtpostyn 진찰료후불여부
     * <li>medamtfreeresn 진찰료면제사유
     * <li>rsrvflag 예약구분
     * <li>etcordflag 기타진료구분
     * <li>disccd 할인코드
     * <li>hosoutexptresncd 원외예외사유코드
     * <li>clincstdyacptflag 임상연구접수구분
     * <li>clincstdyno 임상연구번호
     * <li>chrtlendyn 챠트대출여부
     * <li>specorddescyn 선택진료설명여부
     * <li>ordreqdescyn 진료의뢰서설명여부
     * <li>ordreqhospgrde 진료의뢰서설명병원등급
     * <li>insuchrgyn 보험회사담당자여부
     * <li>nursacptyn 간호접수여부
     * <li>nursacptdt 간호접수일시
     * <li>dracptyn 의사접수여부
     * <li>dracptdt 의사접수일시
     * <li>prcpgenryn 처방발생여부
     * <li>prcpnotoccrresn 처방미발생사유
     * <li>estmspclappyn 산정특례적용여부
     * <li>elbulbodstat 전광판상태
     * <li>elbulbodstatdt 전광판상태입력일시
     * <li>calcmthdflag 계산방법구분
     * <li>dnoracptyn 공여자접수여부
     * <li>rqstflag 협력의뢰구분
     * <li>rqsthospcd 협력의뢰병원
     * <li>rqstdrid 협력의뢰의사
     * <li>ermngtamtcalcyn 응급의학관리료산정여부
     * <li>erbrthflag 응급분만구분
     * <li>erchospath 응급내원경로
     * <li>erorddeptcd 응급주진료과
     * <li>erjudgstat 응급심사상태
     * <li>eroutrmnotidt 응급퇴실통보일시
     * <li>eroutrmdt 응급퇴실일시
     * <li>lastrcptendyn 최종수납여부
     * <li>inflag 당일입원구분
     * <li>tranindd 전환입원일자
     * <li>rcptdd 영수일자
     * <li>rcptno 영수증번호
     * <li>rcptseqno 영수증일련번호
     * <li>telrsrvrem 전화예약참고사항
     * <li>bforddd 이전진료일자
     * <li>bfordtm 이전진료시간
     * <li>bforddeptcd 이전진료과
     * <li>bforddrid 이전진료의
     * <li>updtcnclresn 변경취소사유
     * <li>fstacptid 최초접수자
     * <li>fstacptdt 최초접수일시
     * <li>fstrgstrid 최초등록자
     * <li>fstrgstdt 최초등록일시
     * <li>lastupdtrid 최종등록자
     * <li>lastupdtdt 최종등록일시
     * <li>checkflag 체크구분
     * <li>instcd 기관기호
     * </ul>
     * @return ValueObject
     * <p>h_opmi/opmi : 출력데이터
     * <ul>
     * <li>opmi_hidden 
     * <li>opmi_pid 환자번호
     * <li>opmi_rcptdd 영수증일자
     * <li>opmi_rcptno 영수증번호
     * <li>opmi_rcptseqno 영수증일련번호
     * <li>opmi_instcd 병원별기관코드
     * <li>opmi_rcptstat 수납상태
     * <li>opmi_uncorcptflag 미수정산구분
     * <li>opmi_orddd 외래등록일자
     * <li>opmi_cretno 외래등록생성번호
     * <li>opmi_acptseqno 외래등록일련번호
     * <li>opmi_orddeptcd 진료과코드
     * <li>opmi_orddrid 진료의ID
     * <li>opmi_ordtype 진료형태
     * <li>opmi_mskind 주부유형
     * <li>opmi_insukind 보험유형
     * <li>opmi_suppkind 보조유형
     * <li>opmi_insucd 보험자코드
     * <li>opmi_totamt 급여금액
     * <li>opmi_payamt 비보험액
     * <li>opmi_nopyamt 비급여액
     * <li>opmi_allownbamt 급여본인부담
     * <li>opmi_totnopyamt 총비급여
     * <li>opmi_payownbamt 본인부담액
     * <li>opmi_payinsubamt 보험자부담액
     * <li>opmi_handcapfund 장애기금
     * <li>opmi_ersubtamt 의료급여대불액
     * <li>opmi_procsubtamt 응급대불액
     * <li>opmi_subtamt 
     * <li>opmi_specamt 선택진료
     * <li>opmi_discreduamt 할인액
     * <li>opmi_discamt 감액
     * <li>opmi_reduamt 
     * <li>opmi_bloddiscamt 혈액할인액
     * <li>opmi_totownbamt 총본인부담액
     * <li>opmi_totownbamt2 총본인부담액
     * <li>opmi_precashamt 기현금금액
     * <li>opmi_premdlrcptamt 기중간수납금
     * <li>opmi_precardamt 기카드금액
     * <li>opmi_preonlineamt 기온라인금액
     * <li>opmi_mdlrcptamt 중간수납금
     * <li>opmi_uncoamt 미수금액
     * <li>opmi_cardamt 카드금액
     * <li>opmi_cashamt 현금금액
     * <li>opmi_onlineamt 온라인금액
     * <li>opmi_rcptexptamt 실수납액
     * <li>opmi_restamt 절사액
     * <li>opmi_hosindrugno 원내투약번호
     * <li>opmi_hosoutdrugno 원외투약번호
     * <li>opmi_calcmthdflag P:정액,D:DRG,N:개별,H:종검
     * <li>opmi_remfact 참고사항
     * <li>opmi_paypsnflag 납부자구분
     * <li>opmi_paypsnrem 납부자참고사항
     * <li>opmi_paydepoamt 납부자 입금금액
     * <li>opmi_orgrcptdd 원 영수증일자
     * <li>opmi_orgrcptno 원 영수증번호
     * <li>opmi_orgrcptseqno 원 영수증일련번호
     * <li>opmi_rcptexecdd 수납수행일자
     * <li>opmi_rcpttm 수납시간
     * <li>opmi_rcptrid 수납자ID
     * <li>opmi_fstrgstrid 최초등록자ID
     * <li>opmi_fstrgstdt 최초등록일시
     * <li>opmi_lastupdtrid 최종수정자ID
     * <li>opmi_lastupdtdt 최종수정일시
     * <li>opmi_outpayownbrate 부담율
     * <li>opmi_nopyinsubamt 비급여보험자부담액
     * <li>opmi_nopyownbamt 비급여본인부담액
     * <li>opmi_allowninsubamt 전액본인보험자부담액
     * <li>opmi_allownownbamt 전액본인본인부담액
     * <li>opmi_specinsubamt 선택진료료본인부담액
     * <li>opmi_specownbamt 선택진료료본인부담액
     * <li>opmi_totnopyownbamt 총비급여본인부담
     * <li>opmi_totnopyinsubamt 총비급여보험자부담
     * <li>opmi_heallifeamtclamamt 건강생활유지비청구액
     * <li>opmi_labamt 
     * <li>opmi_clincstdyno 임상연구코드
     * <li>opmi_orgorddd 원진료일자
     * <li>opmi_orgcretno 원등록생성번호
     * </ul>
     * @throws LiveException
     */
    public ValueObject getOutJOpmiList(ValueObject pVO) throws LiveException;

    /**
     * <p>최대생성순번구하기</p>
     * 
     * 
     * @author 
     * @param pVO ValueObject
     * <p>otpt : 입력데이터
     * <ul>
     * <li>pid 등록번호
     * <li>orddd 진료일자
     * </ul>
     * @return ValueObject
     * <p>h_opmi/opmi : 출력데이터
     * <ul>
     * <li>opmi_acptseqno 외래등록일련번호
     * </ul>
     * @throws LiveException
     */
    public ValueObject getOtptMaxAcptseqno(ValueObject pVO) throws LiveException;

    /**
     * <p>건강생활유지비조회</p>
     * 수납화면에서 불러오기
     * @param pVOs ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>pid
     * <li>orddd
     * <li>cretno
     * </ul>
     * @return ValueObject
     * @throws LiveException
     */
    public ValueObject getMsg4LifeAmt(ValueObject pVO) throws LiveException;

    /**
     * <p>건강생활유지비조회</p>
     * 수납서버에서 불러오기
     * @param pVOs ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>pid
     * <li>orddd
     * <li>cretno
     * </ul>
     * @return ValueObject
     * @throws LiveException
     */
    public ValueObject getPreLifeAmt(ValueObject pVO) throws LiveException;
    
    
    /**
     * <p>실시정산 지원금 조회</p>
     * 수납서버에서 불러오기
     * @param pVOs ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>pid
     * <li>orddd
     * <li>cretno
     * </ul>
     * @return ValueObject
     * @throws LiveException
     */
    public ValueObject getExeSuppAmt(ValueObject pVO) throws LiveException;

    /**
     * <p>장애기금  조회</p>
     * 수납서버에서 불러오기
     * @param pVOs ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>pid
     * <li>orddd
     * <li>cretno
     * </ul>
     * @return ValueObject
     * @throws LiveException
     */
    public ValueObject getExeHandcapFund(ValueObject pVO) throws LiveException;
    
	/**
	 * <p>카드수납내역 조회</p>
	 * 카드수납내역 조회(외래수납변경 화면)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>fromdd			시작일자 
	 * <li>todd 			종료일자 
	 * <li>pid 				등록번호 
	 * <li>orddeptcd 		진료과
	 * <li>insukind			보험유형
	 * <li>cardno			카드번호			
	 * </ul>
	 * @return ValueObject
	 * <p>cardl		 : 출력데이터
	 * <ul>
	 * <li>rcptdd		영수일자      
	 * <li>rcptno		영수증번호    
	 * <li>rcptseqno	영수증일련번호
	 * <li>seqno		일련번호      
	 * <li>instcd		기관코드      
	 * <li>rcpstat		수납상태      
	 * <li>ordtype		진료형태      
	 * <li>keyinptflag	키입력구분    
	 * <li>cardcmpycd	카드사코드    
	 * <li>cardno		카드번호      
	 * <li>aprvflag		승인구분      
	 * <li>aprvdd		승인일자      
	 * <li>aprvtm		승인시간	
	 * <li>aprvno		승인번호      
	 * <li>vancd		van코드       
	 * <li>allotmm		할부개월수    
	 * <li>cardamt		카드금액      
	 * <li>valiterm		유효기간      
	 * <li>rcptexecdd	수납일자      
	 * <li>rcpttm		수납시간      
	 * <li>rcptid	 	수납자ID      
	 * <li>remfact		참고사항      
	 * </ul>
	 * @throws LiveException
	 */
	public ValueObject getcardList(ValueObject pVO) throws LiveException;


	/**
	 * <p>현금영수증수납내역 조회</p>
	 * 현금영수증수납내역 조회(외래수납변경 화면)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>fromdd			시작일자 
	 * <li>todd 			종료일자 
	 * <li>pid 				등록번호 
	 * <li>orddeptcd 		진료과  
	 * <li>insukind			보험유형
	 * <li>cardno			자격번호	
	 * </ul>
	 * @return ValueObject
	 * <p>cashlist	 : 출력데이터
	 * <ul>
	 * <li>rcptdd		영수일자      
	 * <li>rcptno		영수증번호    
	 * <li>rcptseqno	영수증일련번호
	 * <li>seqno		일련번호      
	 * <li>instcd		기관코드      
	 * <li>rcpstat		수납상태      
	 * <li>ordtype		진료형태      
	 * <li>qualcnfmflag	키입력구분    
	 * <li>qualcnfmno 	카드사코드    
	 * <li>aprvflag		승인구분      
	 * <li>aprvdd		승인일자      
	 * <li>aprvtm		승인시간	
	 * <li>aprvno		승인번호      
	 * <li>cashamt		현금금액      
	 * <li>rcptexecdd	수납일자      
	 * <li>rcpttm		수납시간      
	 * <li>rcptid	 	수납자ID      
	 * <li>remfact		참고사항      
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getcashList(ValueObject pVO) throws LiveException;

	
	/**
	 * <p>온라인입금수납금 조회</p>
	 * 온라인입금수납금 조회
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>fromdd			시작일자 
	 * <li>todd 			종료일자 
	 * <li>pid 				등록번호 
	 * <li>orddeptcd 		진료과
	 * <li>insukind			보험유형
	 * <li>cardno			입금자		
	 * </ul>
	 * @return ValueObject
	 * <p>onlinelist	 : 출력데이터
	 * <ul>
	 * <li>rcptdd		영수일자      
	 * <li>rcptno		영수증번호    
	 * <li>rcptseqno	영수증일련번호
	 * <li>seqno		일련번호      
	 * <li>instcd		기관코드      
	 * <li>rcpstat		수납상태      
	 * <li>ordtype		진료형태      
	 * <li>bankcd		은행코드      
	 * <li>acntno		계좌번호      
	 * <li>paydd		입금일자      
	 * <li>paypsnnm		입금자명      
	 * <li>onlineamt	온라인금액    
	 * <li>rcptexecdd	수납일자      
	 * <li>rcpttm		수납시간      
	 * <li>rcptid	 	수납자ID      
	 * <li>remfact		참고사항      
	 * </ul>
	 * @throws LiveException
	 */
	public ValueObject getonlnList(ValueObject pVO) throws LiveException;

	/*
     * 기수혈대체
     * 2008.07.16. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getbldcList(ValueObject pVO) throws LiveException;

	/*
     * 기 감면내역조회
     * 2008.09.18. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getdcgmList(ValueObject pVO) throws LiveException;

	/*
     * 기 감면내역조회 0원수납용
     * 2009.06.12. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	//public ValueObject getdcgmList_zero(ValueObject pVO) throws LiveException;

	/*
     * 기 미수내역조회
     * 2008.09.19. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getuncoList(ValueObject pVO) throws LiveException;

	/*
     * 일반의-특진의 변경
     * 2008.09.22. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int setSpecOrdChng(ValueObject pVO) throws LiveException;

	/*
     * 외래수납 환자재원정보
     * 2008.09.22. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getInptInfo(ValueObject pVO) throws LiveException;

	/*
     * 외래수납 환자 가퇴원정보
     * 2009.07.01. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getInptInfo_c(ValueObject pVO) throws LiveException;

	/*
     * 외래수납 중증시 보조유형변경
     * 2008.09.23. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int setOtptSrdg(ValueObject pVO) throws LiveException;

	/*
     * 외래수납 산정특례시 보조유형변경
     * 2009.03.04. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int setOtptEstm(ValueObject pVO) throws LiveException;

	/*
     * 의사소견서 단일처방시 진찰료면제
     * 2008.09.28. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int setOtpt_drcm(ValueObject pVO) throws LiveException;


	//공단조회
	public int setPatInsu(ValueObject pVO) throws LiveException;


	//공단조회
	public int insPatInsu(ValueObject pVO) throws LiveException;


	/*
     * VAN 이중승인 여부 체크
     * 2008.10.14. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public ValueObject getEmtyVanCk(ValueObject pVO) throws LiveException;

	
    /*
     * 환자연속처방내역조회
     * 2008.10.15. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getExopActList(ValueObject pVO) throws LiveException;
	
	
	/*
     * 장기이식환자정보 조회
     * 2011.12.02
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getTranInfo(ValueObject pVO) throws LiveException;


	/**
	 * <p>환자보험정보조회(수납화면)</p>
	 * 키값이 같은내역
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>pid 				등록번호	 
	 * <li>insukind	 
	 * <li>suppkind	 
	 * <li>todd	 
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */	
	public ValueObject getPtin2(ValueObject pVO) throws LiveException;


    /*
     * 보험정보 max키구해오기
     * 2008.10.15. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getPtin_maxseqno(ValueObject pVO) throws LiveException;


    /*
     * 보험정보 변경
     * 2008.10.15. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int setPtinUpdate(ValueObject pVO) throws LiveException;


	//외래등록정보 홀드상태로 변경
	public int setOtptHoldFlag(ValueObject pVO) throws LiveException;
	
	//외래보험내역 상태변경
	public ValueObject getLastPtin(ValueObject pVO) throws LiveException;


    /*
     * 기수납금 처리된 미수건 사유정보에 업데이트
     * 2008.11.12. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int setUncoEndApprsn(ValueObject pVO) throws LiveException;


    /*
     * 외래수납 환자 인적정보 변경
     * 2008.11.20. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int setPtbsInfo(ValueObject pVO) throws LiveException;


	/**
	 * <p>외래수납 예약건 계산호출</p>
	 * 외래수납 예약건 계산호출
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>pid 			등록번호 
	 * <li>srchcond		조회조건
	 * </ul>
	 * @return ValueObject
	 * <p>remamt	 : 외래선수금 잔액
	 * <ul>
	 * <li>remamt		잔액
	 * </ul>
	 * @throws LiveException
	 */
	public ValueObject getCallCalc_Otpt(ValueObject pVO) throws LiveException;
	
	
	
	/**
	 * <p>본인부담구분 체크</p>
	 * M005, M006 본인부담의 경우 상병이 중증/희귀가 아닐경우 '-'로 업데이트
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>pid 			등록번호 
	 * <li>srchcond		조회조건
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int setOwnbflagCheck(ValueObject pVO) throws LiveException;
	
	
	
	/**
	 * <p>본인부담구분 체크</p>
	 * M005, M006 본인부담의 경우 상병이 중증/희귀가 아닐경우 체크
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : 입력데이터
	 * <ul>
	 * <li>pid 			등록번호 
	 * <li>srchcond		조회조건
	 * </ul>
	 * @return ValueObject
	 * @throws LiveException
	 */
	public ValueObject getOwnbflagCheckInfo(ValueObject pVO) throws LiveException;


    /**
     * <p>OSCL의 Y(수납),R(계산) 내역 조회 </p>
     *
     * @param pVOs ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>pid                 등록번호         
     * <li>orddd            진료일자        
     * <li>cretno           생성번호   
     * </ul>
     * @return ValueObject
     * <p>oscl_r , oscl_y   : OSCL의 Y(수납),R(계산) 내역 조회
	 * <ul>
	 * <li>hidden                                     	
	 * <li>pid	환자번호                                                            
	 * <li>orddd	진료일자                                                          
	 * <li>cretno	생성번호                                                           
	 * <li>calcseqno	계산일련번호                                                  
	 * <li>calcscorseqno	계산내역별일련번호                                   
	 * <li>instcd	기관코드                                                       
	 * <li>calcstat	계산상태                                                      
	 * <li>clamtrgtstat	청구대상상태                                             
	 * <li>acptseqno	외래등록생성번호별일련번호                         
	 * <li>orddeptcd	진료과코드                                                    
	 * <li>orddrid	진료의사                                                          
	 * <li>mskind	주부유형                                                          
	 * <li>ordtype	진료형태                                                         
	 * <li>grupcalcscorcd	그룹수가코드                                               
	 * <li>snglcalcscorcd	싱글수가코드                                                
	 * <li>grupcalcscorcls	처방수가분류                                               
	 * <li>snglcalcscorcls	계산수가분류                                                
	 * <li>grupearncls	그룹수익구분코드                                           
	 * <li>snglearncls          	싱글수익구분코드                                               
	 * <li>ordqty                	처방지시투여량                                                    
	 * <li>ordtims               	처방지시투여횟수                                                
	 * <li>orddays              	처방지시투여일수                                                
	 * <li>calcqty               	계산투여량                                                          
	 * <li>calctims              	계산투여횟수                                                       
	 * <li>calcdays             	계산투여일수                                                      
	 * <li>matractflag        	재료행위구분                                                     
	 * <li>calcpayflag         	계산급여구분                                                     
	 * <li>prcppayflag        	처방급여구분                                                    
	 * <li>calcscorpayflag   	수가급여구분                                                   
	 * <li>ansttm                	마취시간                                                              
	 * <li>spccd                 	검체코드                                                              
	 * <li>pntunitcost         	점당단가                                                            
	 * <li>calcscorpnt         	수가점수                                                           
	 * <li>estmpnt              	산정점수                                                             
	 * <li>calcamt               	계산금액                                                             
	 * <li>hospaddamt         	계산액  * 병원가산율                                         
	 * <li>specamt              	지정액                                                                
	 * <li>payamt               	급여금액                                                             
	 * <li>allownbamt         	전액본인부담액                                                 
	 * <li>nopyamt              	비급여액                                                            
	 * <li>payownbrate       	본인부담율                                                      
	 * <li>payinsubamt        	급여보험자부담액                                             
	 * <li>payownbamt        	급여본인부담액                                                
	 * <li>paydiscamt         	급여할인금액                                                     
	 * <li>nopydiscamt        	비급여할인금액                                                 
	 * <li>specdiscamt        	선택진료할인금액                                              
	 * <li>hosoutexptresncd	원외예외사유코드                                           
	 * <li>hosoutdrugno       	원외처방전번호                                                 
	 * <li>specyn                	선택진료여부                                                       
	 * <li>execdeptcd         	실시부서코드                                                    
	 * <li>execdd               	실시일자                                                             
	 * <li>exectm               	실시시간                                                             
	 * <li>execenddd          	수익마감일자                                                     
	 * <li>execendtm          	수익마감시간                                                     
	 * <li>clamspclcd          	청구특정코드                                                     
	 * <li>clamkey              	청구키                                                                
	 * <li>clamcretdd         	청구생성일자                                                     
	 * <li>clamcretyn          	청구생성여부                                                     
	 * <li>estmcls               	산정분류                                                              
	 * <li>estmmeancd          	산정구분에따른의미코드                                     
	 * <li>estmcd                	산정코드                                                             
	 * <li>readdrid             	판독의ID                                                           
	 * <li>clincstdyno         	임상시험번호                                                     
	 * <li>exitprvntdrugyn  	퇴장방지의약품여부                                        
	 * <li>exitprvntdrugamt	퇴장방지의약품금액                                        
	 * <li>trustaddrate       	위탁가산률                                                       
	 * <li>bothaddyn          	양측촬영가산처리                                              
	 * <li>prcpdd               	처방일자                                                             
	 * <li>prcpno                	처방번호                                                             
	 * <li>prcphistno          	처방이력번호                                                     
	 * <li>execprcpseqno    	실시처방일련번호                                            
	 * <li>cvrtinprcpdeptcd      	전환입원처방진료과코드                                  
	 * <li>cvrtinprcpdrid    	전환입원처방진료의ID                                      
	 * <li>rcptdd                	영수증 처리일자                                                   
	 * <li>rcptno                	영수증번호                                                          
	 * <li>rcptseqno           	영수증일련번호                                                  
	 * <li>rcptexecdd         	실수납일자                                                       
	 * <li>rcpttm                	실수납시간                                                          
	 * <li>fstrgstrid           	최초등록자                                                         
	 * <li>fstrgstdt            	최초등록일시                                                      
	 * <li>lastupdtrid         	최종수정자                                                         
	 * <li>lastupdtdt          	최종수정일시                                                      
	 * <li>holdyn                	HOLD여부                                                           
	 * <li>snglcalcscorcdnm 	수가한글명                                    
  	 * <li>owntotamt           	본인부담총액                                                     
 	 * <li>execprcpstatcd   	처방상태                                                         
	 * <li>execprcphistcd 	변경이력   
     * </ul>
     * @throws LiveException
     */
    public ValueObject getOsclRY(ValueObject pVO) throws LiveException;

	//0원 수납 인터페이스 - 대상 otpt가져오기
	public ValueObject getIFOAmtZeroOtpt(ValueObject pVO) throws LiveException;

	//0원 수납 인터페이스 - 진찰료 sum
	public ValueObject getIFOAmtZeroOscl(ValueObject pVO) throws LiveException;

	//0원 수납 인터페이스 - 0원수납 대상 물리치료 리스트 가져오기
	public ValueObject getMjquList(ValueObject pVO) throws LiveException;

    //0원 수납 인터페이스 - 0원수납 대상 테이블 종료처리
	public int setOutOrdEndMjqu(ValueObject pVO) throws LiveException;

	//연속처방 수납대상 팝업 - 조회
	public ValueObject getPopupMjquList(ValueObject pVO) throws LiveException;

	//계산취소 외래처방테이블 상태값 롤백
	public int setRollBackExop(ValueObject pVO) throws LiveException;

	//환자별 중증 조회
	public ValueObject getSrdg(ValueObject pVO) throws LiveException;

	//0원수납용 미수 수납내역 조회
	public ValueObject getuncoList2(ValueObject pVO) throws LiveException;

	//병원 정보코드 조회
	public ValueObject getHospcd(ValueObject pVO) throws LiveException;

	//수납vip 대기자조회
	public ValueObject getVipStandList(ValueObject pVO) throws LiveException;

	//당일 자격조회 유무 체크
	public ValueObject getMmsg2Check(ValueObject pVO) throws LiveException;

	//연속처방 수납대상 팝업 - 처방리스트
	public ValueObject getPopupMjexList(ValueObject pVO) throws LiveException;

	//연속처방 유무 체크
	public ValueObject getChkOtptMJ(ValueObject pVO) throws LiveException;

    //원무공통코드 (desc조회)
	public ValueObject getPmcmCode(ValueObject pVO) throws LiveException;

	//원무공통코드 (cdid조회)
	public ValueObject getPmcmCodeNm(ValueObject pVO) throws LiveException;

    //ZBCMCODE 공통코드조회
    public ValueObject getZbcmCode(ValueObject pVO) throws LiveException;
    
    //과거처방반환, 대체처방 내역 table 수납 여부 상태 처리 
	public int setOPCGStat(ValueObject pVO) throws LiveException;

    /**
     * <p>건강검진 내역 조회</p>
     *
     * @param pVO ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>pid    등록번호 
     * </ul>
     * @return ValueObject
     * <ul>
     * <li>pid    등록번호
     * <li>orddd   진료일자
     * </ul>
     * @throws LiveException
     */
    public ValueObject getCheckMediExamInfo(ValueObject pVO) throws LiveException;

    /**
     * <p>응급실 내역 조회</p>
     *
     * @param pVO ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>pid    등록번호 
     * </ul>
     * @return ValueObject
     * <ul>
     * <li>pid    등록번호
     * <li>orddd   진료일자
     * </ul>
     * @throws LiveException
     */
    public ValueObject getCheckERInfo(ValueObject pVO) throws LiveException;

    //view인 대상 수가코드 체크[_,= 문자포함]
	public ValueObject getViewCalcChk(ValueObject pVO) throws LiveException;

    //oscl이 Y인건 조회해서 R로 만든다
	public int setOsclY_dump(ValueObject pVO) throws LiveException;

    //실시정산용 실시일자테이블 입력
	public int setOutOrdActr(ValueObject pVO) throws LiveException;

    //실시정산용 실시일자테이블 삭제
	public int delOutOrdActr(ValueObject pVO) throws LiveException;

    //실시정산 대상환자 조회
	public ValueObject getPopupActrList(ValueObject pVO) throws LiveException;

	//실시정산 대상환자 팝업 - 처방리스트
	public ValueObject getPopupActrExopList(ValueObject pVO) throws LiveException;

	//성가병원 예방접종미수 체크
	public ValueObject getPrvntMedc(ValueObject pVO) throws LiveException;
	
	//선천성대사이상검사 선천성대사이상 [inborn errors of metabolism] 미수 평생1회
	public ValueObject getInbornError(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>타과 유형변경 관련 otpt 조회</p>
	 *
	 * @param pVO ValueObject
	 * <p>pVO : 입력데이터
	 * <ul>
	 * <li>pid 				등록번호
	 * <li>orddd 			진료일자
	 * <li>sessinstcd 			기관기호
	 * </ul>
	 * @return ValueObject
	 * <p>retVO	 : 			출력데이터
	 * <ul>
	 * <li>pid 				등록번호
	 * <li>orddd 			진료일자
	 * <li>cretno 			생성번호
	 * <li>instcd 			기관기호
	 * <li>....  
	 * <li>lastupdtrid	    최종수정자ID
	 * <li>lastupdtdt		최종수정일시
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getOrdOTPTRef(ValueObject pVO) throws LiveException;

    //장애인수첩소지여부 체크
    public ValueObject getHndcCnt(ValueObject pVO) throws LiveException;

    //미수 입금여부 체크
    public ValueObject getUncoStatYCnt(ValueObject pVO) throws LiveException;

    //수납할 재증명 유무 체크
    public ValueObject getChkCertList(ValueObject pVO) throws LiveException;

    //수납시 ONLN 통장입금액 CD생성
    public int insOnlnAmtDC(ValueObject pVO) throws LiveException;

    //수납시 ONLN 통장입금액 CD생성
    public int setOnlnAmtC(ValueObject pVO) throws LiveException;
    
    //외국인 체크 후 oecd 여부 체크
    public ValueObject getPatOectChk(ValueObject pVO) throws LiveException;
    
	/**
	 * 진료의뢰내역 조회
	 * 
	 * @param pVO ValueObject
	 * <ul>
     * <li>cnst_pid 환자등록번호
     * <li>cnst_todd 종료일자
     * <li>cnst_fromdd 시작일자
     * </ul>
	 * @return ValueObject
	 * <ul>
     * <li>cnst_pid 환자등록번호
     * <li>cnst_orddeptcd 진료과코드
     * <li>cnst_insuflag 보험구분보호/보험구분
     * <li>cnst_ordreqkind 진료의뢰서 종류
     * <li>cnst_todd 종료일자
     * <li>cnst_seqno 일련번호
     * <li>cnst_instcd 기관코드
     * <li>cnst_histstat 이력상태
     * <li>cnst_fromdd 시작일자
     * <li>cnst_reqformhospnm 의뢰병원명
     * <li>cnst_reqformdrnm 의뢰의사명
     * <li>cnst_remfact 참고사항
     * <li>cnst_fstrgstrid 최초등록자ID
     * <li>cnst_fstrgstdt 최초등록일시
     * <li>cnst_lastupdtrid 최종수정자ID
     * <li>cnst_lastupdtdt 최종수정일시
     * </ul>
	 * @throws LiveException
	 */
	public ValueObject getCNST1(ValueObject pVO) throws LiveException;       
    
	//원외처방전 출력 2010/06/11 cys
	public ValueObject getHosoOutOrderList(ValueObject pVO) throws LiveException;	
    
	/**
     * <p>타병원 투석 처리</p>
     * 
     * @param pVOs ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>pid
     * <li>orddd
     * <li>crento
     * <li>instcd
     * </ul>
     * @return ValueObject
     * <p>
     * <ul>
     * <li>     
     * </ul>
     * @throws LiveException
     */
	public int setSuppkindsubyn(ValueObject pVO) throws LiveException;

	//외래선수금화면 미수잔액 가져오기 20110127 cys
	public ValueObject getUncoRemAmt(ValueObject pVO) throws LiveException;
    
    //처방특진여부 N으로 변경 20110401 cys
    public int setChngSpecN(ValueObject pVO) throws LiveException;

    //처방특진여부 원복 20110401 cys
    public int setChngSpecR(ValueObject pVO) throws LiveException;

    //특진여부 원복시 취소대장 삭제20110415 cys
    public int setDelSpltList1(ValueObject pVO) throws LiveException;

	//재활의학과 미예약환자 경고메세지 체크 20110426 cys
	public ValueObject getChkEtcM(ValueObject pVO) throws LiveException;
	
	//건보, 의보 자격 정보 조회
	public ValueObject checkInsuInfo(ValueObject pVO) throws LiveException;
	
	public ValueObject getUncoAmtSMSDetlSpec(ValueObject pVO) throws LiveException;
    
    public ValueObject getUncoAmtSMSMsg(ValueObject pVO) throws LiveException;
    
    public ValueObject getUncoAmtSMSSpec(ValueObject pVO) throws LiveException;
    
    public ValueObject getUncoAmtSMSTrsmSpec(ValueObject pVO) throws LiveException;
    
    public int setUncoAmtSMSTrsm(ValueObject pVO) throws LiveException;
    
    public ValueObject getDiscListChk(ValueObject pVO) throws LiveException;
    
    public int setSpclcd(ValueObject pVO) throws LiveException;
    
    /**
     * 장기기증 WorkUp 환자 상병체크
     * 
     * @param pVO
     * @return ValueObject
     * @throws LiveException
     */
    public ValueObject getCheckWorkUpDiag(ValueObject pVO) throws LiveException;
}