/**
 * @(#) OutRcptMgt.java
 *수정이력
 *      - 2007. 4. 02 / 최초작성 / 최희경
 */
package himed.his.pam.outordamtmngtmgr.outrcptmgt;

import kr.co.hit.live.exception.LiveException;
import kr.co.hit.live.vo.ValueObject;
import kr.co.hit.live.vo.ValueObjectAssembler;

/**
 *  <P> 외래수납관리 Business Interface의 Interface Class</P>
 *  본 클래스는 외래수납을 관리한다. 
 *  외래수납/조회 및 외래중간금(선수금) 수납/조회 기능을 제공한다.
 *  
 *  @author  최희경
 *  @version 1.0  2007. 4. 02
 */
public interface OutRcptMgt {


    
    /**
     * <p>외래중간금(선수금) 조회</p>
     * 외래중간금(선수금) 조회
     * 
     *
     * @param pVO ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>pid              등록번호 
     * <li>srchcond         조회조건
     * </ul>
     * @return ValueObject
     * <p>outrcptspec    : 출력데이터
     * <ul>
     * <li>rcptflag         수납구분          
     * <li>rcptexecdd       수납일자          
     * <li>rcpttm           수납시간          
     * <li>cashamt          현금금액          
     * <li>cardamt          카드금액          
     * <li>onlineamt        온라인금액        
     * <li>rcptid           수납자ID          
     * <li>remfact          참고사항          
     * <li>rcptdd           영수일자          
     * <li>rcptno           영수증번호        
     * <li>rcptseqno        영수증일련번호    
     * <li>seqno            일련번호          
     * <li>instcd           기관코드          
     * <li>paypsnflag       납부자구분        
     * <li>paypsnrem        납부자참고사항    
     * </ul>
     * @throws LiveException
     */
    public ValueObject getMdlAmtList(ValueObject pVO) 
            throws LiveException;

    /**
     * <p>카드수납금 조회</p>
     * 카드수납금 조회
     * 
     *
     * @param pVO ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>pid              등록번호 
     * <li>ordtype          진료형태
     * <li>preamtyn         선수금여부
     * </ul>
     * @return ValueObject
     * <p>cardlist   : 출력데이터
     * <ul>
     * <li>rcptdd       영수일자       
     * <li>rcptno       영수증번호     
     * <li>rcptseqno    영수증일련번호 
     * <li>seqno        일련번호       
     * <li>instcd       기관코드       
     * <li>rcpstat      수납상태       
     * <li>ordtype      진료형태       
     * <li>keyinptflag  키입력구분     
     * <li>cardcmpycd   카드사코드     
     * <li>cardno       카드번호       
     * <li>aprvflag     승인구분       
     * <li>aprvdd       승인일자       
     * <li>aprvtm       승인시간    
     * <li>aprvno       승인번호       
     * <li>vancd        van코드        
     * <li>allotmm      할부개월수     
     * <li>cardamt      카드금액       
     * <li>valiterm     유효기간       
     * <li>rcptexecdd   수납일자       
     * <li>rcpttm       수납시간       
     * <li>rcptid       수납자ID       
     * <li>remfact      참고사항       
     * </ul>
     * @throws LiveException
     */
    public ValueObject getCardAmtList(ValueObject pVO) 
            throws LiveException;


    /**
     * <p>현금영수증수납금 조회</p>
     * 현금영수증수납금 조회
     * 
     *
     * @param pVO ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>pid              등록번호 
     * <li>ordtype          진료형태
     * <li>preamtyn         선수금여부
     * </ul>
     * @return ValueObject
     * <p>cashlist   : 출력데이터
     * <ul>
     * <li>rcptdd       영수일자         
     * <li>rcptno       영수증번호       
     * <li>rcptseqno    영수증일련번호   
     * <li>seqno        일련번호         
     * <li>instcd       기관코드         
     * <li>rcpstat      수납상태         
     * <li>ordtype      진료형태         
     * <li>qualcnfmflag 키입력구분       
     * <li>qualcnfmno   카드사코드       
     * <li>aprvflag     승인구분         
     * <li>aprvdd       승인일자         
     * <li>aprvtm       승인시간     
     * <li>aprvno       승인번호         
     * <li>cashamt      현금금액         
     * <li>rcptexecdd   수납일자         
     * <li>rcpttm       수납시간         
     * <li>rcptid       수납자ID         
     * <li>remfact      참고사항         
     * </ul>
     * @throws LiveException
     */
    public ValueObject getCashAmtList(ValueObject pVO) 
            throws LiveException;
    
    
    /**
     * <p>온라인입금수납금 조회</p>
     * 온라인입금수납금 조회
     * 
     *
     * @param pVO ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>pid              등록번호 
     * <li>ordtype          진료형태
     * <li>preamtyn         선수금여부
     * </ul>
     * @return ValueObject
     * <p>onlinelist     : 출력데이터
     * <ul>
     * <li>rcptdd       영수일자         
     * <li>rcptno       영수증번호       
     * <li>rcptseqno    영수증일련번호   
     * <li>seqno        일련번호         
     * <li>instcd       기관코드         
     * <li>rcpstat      수납상태         
     * <li>ordtype      진료형태         
     * <li>bankcd       은행코드         
     * <li>acntno       계좌번호         
     * <li>paydd        입금일자         
     * <li>paypsnnm     입금자명         
     * <li>onlineamt    온라인금액       
     * <li>rcptexecdd   수납일자         
     * <li>rcpttm       수납시간         
     * <li>rcptid       수납자ID         
     * <li>remfact      참고사항         
     * </ul>                             
     * @throws LiveException
     */
    public ValueObject getOnlineAmtList(ValueObject pVO) 
            throws LiveException;

    /**
     * <p>외래선수금 잔액 조회</p>
     * 외래선수금 잔액  조회
     * 
     *
     * @param pVO ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>pid              등록번호 
     * <li>srchcond         조회조건
     * </ul>
     * @return ValueObject
     * <p>remamt     : 외래선수금 잔액
     * <ul>
     * <li>remamt           잔액     
     * </ul>
     * @throws LiveException
     */
    public ValueObject getMdlRemAmt(ValueObject pVO) 
            throws LiveException;
    
    /**
     * <p>외래선수금화면 잔액 조회</p>
     * 외래선수금화면 잔액 조회
     * 
     *
     * @param pVO ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>pid              등록번호 
     * <li>srchcond         조회조건
     * </ul>
     * @return ValueObject
     * <p>remamt     : 외래선수금 잔액
     * <ul>
     * <li>remamt           잔액     
     * </ul>
     * @throws LiveException
     */
    public ValueObject getMdlRemAmt2(ValueObject pVO)  throws LiveException;
	

    /**
     * <p>영수증번호 조회</p>
     * 영수증번호 조회
     * 
     *
     * @param pVO ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>rcptdd               영수일자
     * </ul>
     * @return ValueObject
     * <p>rcptno     :          출력데이터
     * <ul>
     * <li>rcptno               영수증번호
     * </ul>
     * @throws LiveException
     */
    public ValueObject getRcptNo(ValueObject pVO) 
            throws LiveException;

    
    
    /**
     * <p>외래중간금(선수금) 수납 처리</p>
     * 외래중간금(선수금) 수납처리
     * 
     *
     * @param pVO ValueObject    
     * <p>req : 입력데이터
     * <ul>
     * <li>pid          등록번호        
     * <li>rcptdd       영수일자        
     * <li>rcptno       영수증번호      
     * <li>rcptseqno    영수증일련번호      
     * <li>seqno        일련번호        
     * <li>instcd       기관코드        
     * <li>rcptstat     수납상태        
     * <li>ordtype      진료형태        
     * <li>rcptflag     수납구분        
     * <li>cashamt      현금금액        
     * <li>cardamt      카드금액        
     * <li>onlineamt    온라인금액      
     * <li>rcptexecdd   수납일자        
     * <li>rcpttm       수납시간        
     * <li>rcptrid      수납자ID        
     * <li>remfact      참고사항        
     * <li>fstrgstrid   최초등록자      
     * <li>fstrgstdt    최초등록일시        
     * <li>lastupdtrid  최종수정자      
     * <li>lastupdtdt   최종수정일시        
     * </ul>
     * @return int
     * @throws LiveException
     */

    public int insMdlAmt(ValueObject pVO) 
            throws LiveException;

    /**
     * <p>온라인입금 수납 처리</p>
     * 온라인입금 수납처리
     * 
     *
     * @param pVO ValueObject    
     * <p>online : 입력데이터
     * <ul>
     * <li>pid          등록번호        
     * <li>rcptdd       영수일자        
     * <li>rcptno       영수증번호      
     * <li>rcptseqno    영수증일련번호   
     * <li>seqno        일련번호        
     * <li>instcd       기관코드        
     * <li>rcptstat     수납상태        
     * <li>ordtype      진료형태        
     * <li>onlineamt    온라인금액       
     * <li>bankcd       은행코드         
     * <li>acntno       계좌번호        
     * <li>paydd        입금일자         
     * <li>paypsnnm     입금자명         
     * <li>rcptexecdd   수납일자        
     * <li>rcpttm       수납시간        
     * <li>rcptrid      수납자ID     
     * <li>preamtyn     선수금여부       
     * <li>innrtretyn   내부처리여부     
     * <li>remfact      참고사항        
     * <li>fstrgstrid   최초등록자      
     * <li>fstrgstdt    최초등록일시     
     * <li>lastupdtrid  최종수정자      
     * <li>lastupdtdt   최종수정일시     
     * </ul>
     * @return int
     * @throws LiveException
     */

    public int insOnlineAmt(ValueObject pVO) 
            throws LiveException;
    
    /**
     * <p>온라인입금 수납 취소처리</p>
     * 온라인입금 수납 취소처리
     * 
     *
     * @param pVO ValueObject    
     * <p>online : 입력데이터
     * <ul>
     * <li>pid          등록번호        
     * <li>rcptdd       영수일자        
     * <li>rcptno       영수증번호      
     * <li>rcptseqno    영수증일련번호     
     * <li>seqno        일련번호        
     * <li>instcd       기관코드        
     * <li>rcptstat     수납상태        
     * <li>ordtype      진료형태        
     * <li>onlineamt    온라인금액         
     * <li>bankcd       은행코드           
     * <li>acntno       계좌번호        
     * <li>paydd        입금일자           
     * <li>paypsnnm     입금자명           
     * <li>rcptexecdd   수납일자        
     * <li>rcpttm       수납시간        
     * <li>rcptrid      수납자ID       
     * <li>preamtyn     선수금여부         
     * <li>innrtretyn   내부처리여부       
     * <li>remfact      참고사항        
     * <li>fstrgstrid   최초등록자      
     * <li>fstrgstdt    최초등록일시       
     * <li>lastupdtrid  최종수정자      
     * <li>lastupdtdt   최종수정일시       
     * </ul>
     * @return int
     * @throws LiveException
     */

    public int insOnlineAmtCncl(ValueObject pVO) 
            throws LiveException;
    
    
    
    /**
     * <p>영수증번호 update</p>
     * 최종 영수증번호를 update처리
     * 
     *
     * @param pVO ValueObject   
     * <p>req : 입력데이터
     * <ul>         
     * <li>rcptdd               영수일자        
     * <li>rcptno               영수증번호   
     * </ul>
     * @return  int
     * @throws LiveException
     */

    public int setRcptNo(ValueObject pVO) 
            throws LiveException;
    
    /**
     * <p>계산내역에 수납정보 update</p>
     * 생성된 수납내역에 대한 계산내역 수납상태,수납정보(일자,순번) update
     * 
     *
     * @param pVO ValueObject   
     * <p>opmi : 입력데이터
     * <ul>         
     * <li>rcptdd           영수일자    
     * <li>rcptexecdd       수납일자    
     * <li>rcptno           영수증번호   
     * <li>rcptseqno        영수일련번호    
     * <li>rcptstat         수납상태    
     * </ul>
     * @return  int
     * @throws LiveException
     */

    public int setOutOrdAmtOsclOtpt(ValueObject pVO) 
            throws LiveException;
    
    /**
     * <p>처방정보에 수납상태 update</p>
     * 처방테이블에 수납 상태 update
     * 
     *
     * @param pVO ValueObject   
     * <p>otpt : 입력데이터
     * <ul>         
     * <li>pid          영수일자    
     * <li>orddd        수납일자    
     * <li>cretno       생성번호     
     * <li>acptseqno    외래등록일련번호
     * <li>calcflag     계산구분    
     * </ul>
     * @return  int
     * @throws LiveException
     */

    public int setOutOrdStat(ValueObject pVO) 
            throws LiveException;
    

    /**
     * <p>외래등록조회(수납화면)</p>
     * 외래등록조회(수납화면)
     * 
     *
     * @param pVO ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>pid          등록번호
     * <li>srchcond     조회조건
     * </ul>
     * @return ValueObject
     * <p>outrgstlist    : 출력데이터
     * <ul>
     * <li>orddd            진료일자    
     * <li>ordtm            진료시간    
     * <li>orddept          진료과      
     * <li>orddr            진료의      
     * <li>fsexamflag       초재진구분  
     * <li>indukind         보험유형    
     * <li>suppkind         보조유형    
     * </ul>
     * @throws LiveException
     */
    public ValueObject getOutRgstList(ValueObject pVO) 
            throws LiveException;

    /**
     * <p>외래등록조회(무인수납)</p>
     * 
     *
     * @param pVO ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>pid              등록번호
     * </ul>
     * @return ValueObject
     * <p>outrgstlist    : 출력데이터
     * <ul>
     * <li>orddd            진료일자    
     * <li>ordtm            진료시간    
     * <li>orddept          진료과      
     * <li>orddr            진료의      
     * <li>fsexamflag       초재진구분  
     * <li>indukind         보험유형    
     * <li>suppkind         보조유형    
     * </ul>
     * @throws LiveException
     */
    public ValueObject getOutRsgtList2(ValueObject pVO) 
            throws LiveException;
    
    /**
     * <p>미수금조회(수납화면)</p>
     * 미수금조회(수납화면)
     * 
     *
     * @param pVO ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>pid              등록번호     
     * </ul>
     * @return ValueObject
     * <p>uncoamt        : 출력데이터
     * <ul>
     * <li>outuncoamt       외래미수금
     * <li>dschuncoamt      퇴원미수금
     * </ul>
     * @throws LiveException
     */
    public ValueObject getUncoAmt(ValueObject pVO) 
            throws LiveException;

        
    /**
     * <p>보관퇴원금조회(수납화면)</p>
     * 보관퇴원금조회(수납화면)
     * 
     *
     * @param pVO ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>pid             등록번호  
     * </ul>
     * @return ValueObject
     * <p>uncoamt        : 출력데이터
     * <ul>
     * <li>outuncoamt      보관퇴원금
     * </ul>
     * @throws LiveException
     */
    public ValueObject getKeepAmt(ValueObject pVO) 
            throws LiveException;


    /**
     * <p>보험정보 조회</p>
     * 보험정보 조회
     * 
     *
     * @param pVO ValueObject
     * <p>req : 보험정보 조회조건
     * <ul>
     * <li>pid                  등록번호 
     * <li>insukind             보험유형
     * <li>insucd               보험자코드
     * <li>appdd                적용일자
     * </ul>
     * @return ValueObject
     * <p>ptin   : 보험정보
     * <ul>
     * <li>insukind     보험유형           
     * <li>insucd       보험자코드         
     * <li>insuno       보험증번호         
     * <li>insdrela     피보험자와의관계   
     * <li>insdnm       피보험자명         
     * <li>insdrrgstno1 피보험자주민번호1  
     * <li>insdrrgstno2 피보험자주민번호2  
     * <li>fromdd       시작일자           
     * <li>todd         종료일자           
     * </ul>
     * @throws LiveException
     */
    public ValueObject getInsuInfo(ValueObject pVO) 
            throws LiveException;

    /**
     * <p>중증정보 조회</p>
     * 중증정보 조회
     * 
     *
     * @param pVO ValueObject
     * <p>req : 중증정보 조회조건
     * <ul>
     * <li>pid              등록번호       
     * <li>insukind         보험유형       
     * <li>insucd           보험자코드     
     * <li>appdd            적용일자       
     * </ul>                               
     * @return ValueObject                 
     * <p>srdg   : 중증정보                
     * <ul>                                
     * <li>pid              등록번호       
     * <li>insuflag         보험구분       
     * <li>suppkind         보조유형       
     * <li>todd             종료일자       
     * <li>fromdd           시작일자       
     * <li>seridiagno       중증번호       
     * <li>apppsnnm         신청자         
     * <li>rela             신청자와의관계 
     * </ul>
     * @throws LiveException
     */
    public ValueObject getSrdgInfo(ValueObject pVO) 
            throws LiveException;
    
    /**
     * <p>자보보험정보 조회</p>
     * 
     *
     * @param pVO ValueObject
     * <p>req : 자보보험정보 조회조건
     * <ul>
     * <li>pid                  등록번호 
     * <li>appdd                적용일자
     * </ul>
     * @return ValueObject
     * <p>aipm   : 자보자격정보
     * <ul>
     * <li>pid                  등록번호
     * </ul>
     * @throws LiveException
     */
    public ValueObject getAipmInfo(ValueObject pVO) 
            throws LiveException;

    /**
     * <p>산재자격정보 조회</p>
     * 
     *
     * @param pVO ValueObject
     * <p>req : 산재보험정보 조회조건
     * <ul>
     * <li>pid                  등록번호 
     * <li>appdd                적용일자
     * </ul>
     * @return ValueObject
     * <p>icpm   : 산재자격정보
     * <ul>
     * <li>pid                  등록번호
     * </ul>
     * @throws LiveException
     */
    public ValueObject getIcpmInfo(ValueObject pVO) 
            throws LiveException;
    

    /**
     * <p>보험정보 조회</p>
     * 보험정보 조회-부담률
     * 
     *
     * @param pVO ValueObject
     * <p>otpt : 보험정보 조회조건
     * <ul>
     * <li>insukind         보험유형 
     * <li>suppkind         보조유형
     * </ul>
     * @return ValueObject
     * <p>tempinsu   : 보험유형에 대한 부담률 조회
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
    public ValueObject getInsuRateInfo(ValueObject pVO) 
            throws LiveException;
    
    
    /**
     * <p>계산정보 조회</p>
     * 계산정보 조회
     * 
     *
     * @param pVO ValueObject
     * <p>req : 환자계산정보 조회조건
     * <ul>
     * <li>pid              등록번호 
     * <li>orddd            진료일자
     * <li>cretno           생성번호
     * <li>acptseqno        외래등록일련번호
     * </ul>
     * @return ValueObject
     * <p>oscl   : 환자 계산정보 조회
     * <ul>
     * <li>pid              등록번호                              
     * <li>orddd            외래등록일자                          
     * <li>cretno           외래등록생성번호                      
     * <li>calcseqno        계산일련번호                          
     * <li>calcscorseqno    계산수행시,계산내역별 일련번호        
     * <li>instcd           기관코드                              
     * <li>calcstat         계산상태                              
     * <li>clamtrgtstat     청구대상상태                          
     * <li>acptseqno        외래등록생성번호별일련번호            
     * <li>orddeptcd        진료과코드                            
     * <li>orddrid          진료의사                              
     * <li>mskind           주부유형                              
     * <li>ordtype          진료형태                              
     * <li>grupcalcscorcd   그룹수가코드                          
     * <li>snglcalcscorcd   싱글수가코드                          
     * <li>grupcalcscorcls  그룹수가분류                          
     * <li>snglcalcscorcls  싱글수가분류                          
     * <li>grupearncls      그룹수익분류                          
     * <li>snglearncls      싱글수익분류                          
     * <li>ordqty           처방지시투여량                        
     * <li>ordtims          처방지시투여횟수                      
     * <li>orddays          처방지시투여일수                      
     * <li>calcqty          계산투여량                            
     * <li>calctims         계산투여횟수                          
     * <li>calcdays         계산투여일수                          
     * <li>matractflag      재료행위구분                          
     * <li>calcpayflag      급여구분                              
     * <li>prcppayflag      처방급여구분                          
     * <li>calcscorpayflag  수가급여구분2                         
     * <li>ansttm           마취시간                              
     * <li>spccd            검체코드                              
     * <li>pntunitcost      점당단가                              
     * <li>calcscorpnt      수가점수                              
     * <li>estmpnt          산정점수                              
     * <li>appunitcost      단가                                  
     * <li>estmamt          산정금액                              
     * ...                                                        
     * <li>fstrgstrid       최초등록자                            
     * <li>fstrgstdt        최초등록일시                          
     * <li>lastupdtrid      최종등록자                            
     * <li>lastupdtdt       최종등록일시                          
     * </ul>
     * @throws LiveException
     */
    public ValueObject getOsclInfo(ValueObject pVO) 
            throws LiveException;

    /**
     * <p>원외약 존재여부  조회</p>
     * 원외약 존재여부 조회
     * 
     *
     * @param pVO ValueObject
     * <p>otpt : 원외약존재여부 체크
     * <ul>
     * <li>pid              등록번호           
     * <li>orddd            진료일자           
     * <li>cretno           생성번호           
     * <li>acptseqno        외래등록일련번호   
     * </ul>                                   
     * @return ValueObject                     
     * <p>opmi   :          원외약존재여부 체크
     * <ul>                                    
     * <li>pid              등록번호           
     * </ul>
     * @throws LiveException
     */
    public ValueObject getOutOrdExist(ValueObject pVO) 
            throws LiveException;

    /**
     * <p>장애인환자여부  조회</p>
     * 
     *
     * @param pVO ValueObject
     * <p>otpt : 환자정보
     * <ul>
     * <li>pid              등록번호            
     * </ul>                                    
     * @return ValueObject                      
     * <p>opmi   :          장애인환자여부 조회 
     * <ul>                                     
     * <li>handicapyn       장애인환자여부      
     * </ul>
     * @throws LiveException
     */ 
    public ValueObject getHandicapYN(ValueObject pVO)
          throws LiveException;
    
    /**
     * <p>연속처방 외래등록 또는 일반 외래등록의 원 ORDDD  조회 - 약국집계용</p>
     * 
     *
     * @param pVO ValueObject
     * <p>opmi : 환자정보
     * <ul>
     * <li>pid                      등록번호                                                            
     * <li>orddd (actingorddd)      진료일자                                                            
     * <li>cretno                   생성번호                                                            
     * </ul>                                                                                            
     * @return ValueObject                                                                              
     * <p>pharm  :                  연속처방 외래등록 또는 일반 외래등록의 원 ORDDD  조회 - 약국집계용  
     * <ul>                                                                                             
     * <li>orddd                    진료일자                                                            
     * </ul>
     * @throws LiveException
     */ 
    public ValueObject getOrddd(ValueObject pVO)
          throws LiveException;
    
    /**
     * <p>진료비정보 조회</p>
     * 진료비정보 조회
     * 
     *
     * @param pVO ValueObject
     * <p>req : 계산내역에 대한 진료비정보 조회조건
     * <ul>
     * <li>pid          등록번호            
     * <li>orddd        진료일자            
     * <li>cretno       생성번호            
     * <li>acptseqno    외래등록일련번호    
     * </ul>
     * @return ValueObject
     * <p>opmi   : 계산내역에 대한 진료비 정보 조회
     * <ul>
     * <li>pid              등록번호                  
     * <li>orddd            외래등록일자              
     * <li>cretno           외래등록생성번호          
     * <li>totamt           총진료비                  
     * <li>payamt           급여금액                  
     * <li>payownbamt       급여중 본인부담금액       
     * <li>payinsubamt      급여중 보험자부담금액     
     * <li>allownbamt       비보험액(전액본인부담액)  
     * <li>nopyamt          비급여액                  
     * <li>specamt          선택진료비총액            
     * <li>totownbamt       총본인부담액              
     * <li>handcapfund      장애인기금                
     * <li>subtamt          대불액                    
     * <li>bloddiscamt      수혈대체액                
     * <li>discreduamt      감액(할인+감액)           
     * <li>uncoamt          미수액                    
     * <li>precashamt       기현금액                  
     * <li>premdlrcptamt    기선수금                  
     * <li>precardamt       기카드금액                
     * <li>preonlineamt     기온라인금액              
     * <li>mdlrcptamt       선수금                    
     * <li>rcptexptamt      납부할 금액               
     * <li>cardamt          카드금액                  
     * <li>cashamt          현금금액                  
     * <li>onlineamt        통장입금액                
     * <li>paypsnflag       납부자                    
     * <li>payrem           납부자기타사항            
     * <li>instcd           기관코드                  
     * </ul>
     * @throws LiveException
     */
    public ValueObject getOpmiInfoFromOscl(ValueObject pVO) 
            throws LiveException;

    /**
     * <p>진료비정보 조회</p>
     * 진료비정보 조회
     * 
     *
     * @param pVO ValueObject
     * <p>otpt : 외래등록정보
     * <ul>
     * <li>pid              등록번호           
     * <li>orddd            진료일자           
     * <li>cretno           생성번호           
     * <li>acptseqno        외래등록일련번호   
     * </ul>                                   
     * <p>ptin : 보험정보                      
     * <ul>                                    
     * <li>pid              등록번호           
     * <li>insukind         보험유형           
     * <li>suppkind         보조유형           
     * </ul>
     * <p>tempopmi : 계산내역에 대한 진료비정보
     * <ul>
     * <li>opmi_payamt      급여금액 
     * <li>opmi_nopyamt     비급여금액
     * <li>...
     * </ul>
     * @return ValueObject
     * <p>opmi   : 계산내역에 대한 진료비 정보 조회
     * <ul>
     * <li>pid              등록번호                     
     * <li>orddd            외래등록일자                 
     * <li>cretno           외래등록생성번호             
     * <li>totamt           총진료비                     
     * <li>payamt           급여금액                     
     * <li>payownbamt       급여중 본인부담금액          
     * <li>payinsubamt      급여중 보험자부담금액        
     * <li>allownbamt       비보험액(전액본인부담액)     
     * <li>nopyamt          비급여액                     
     * <li>specamt          선택진료비총액               
     * <li>totownbamt       총본인부담액                 
     * <li>handcapfund      장애인기금                   
     * <li>subtamt          대불액                       
     * <li>bloddiscamt      수혈대체액                   
     * <li>discreduamt      감액(할인+감액)              
     * <li>uncoamt          미수액                       
     * <li>precashamt       기현금액                     
     * <li>premdlrcptamt    기선수금                     
     * <li>precardamt       기카드금액                   
     * <li>preonlineamt     기온라인금액                 
     * <li>mdlrcptamt       선수금                       
     * <li>rcptexptamt      납부할 금액                  
     * <li>cardamt          카드금액                     
     * <li>cashamt          현금금액                     
     * <li>onlineamt        통장입금액                   
     * <li>paypsnflag       납부자                       
     * <li>payrem           납부자기타사항               
     * <li>instcd           기관코드                     
     * </ul>
     * @throws LiveException
     */
    public ValueObject getOpmiInfo(ValueObjectAssembler pVOs , String caller) throws LiveException;

    /**
     * <p>진료비정보 금액 조회</p>
     * 각 항목별 금액 조회(총진료비,본인부담금...)
     * 
     *
     * @param pVOs ValueObjectAssembler
     * <p>otpt : 외래등록정보
     * <ul>
     * <li>pid              등록번호         
     * <li>orddd            진료일자         
     * <li>cretno           생성번호         
     * <li>acptseqno        외래등록일련번호 
     * </ul>                                 
     * <p>ptin : 보험정보                    
     * <ul>                                  
     * <li>pid              등록번호         
     * <li>insukind         보험유형         
     * <li>suppkind         보조유형         
     * </ul>
     * <p>tempopmi : 계산내역에 대한 진료비정보
     * <ul>
     * <li>opmi_payamt      급여금액 
     * <li>opmi_nopyamt     비급여금액
     * <li>...
     * </ul>
     * @return ValueObject
     * <p>opmi   : 계산내역에 대한 진료비 정보 조회
     * <ul>
     * <li>pid              등록번호                     
     * <li>orddd            외래등록일자                 
     * <li>cretno           외래등록생성번호             
     * <li>totamt           총진료비                     
     * <li>payamt           급여금액                     
     * <li>payownbamt       급여중 본인부담금액          
     * <li>payinsubamt      급여중 보험자부담금액        
     * <li>allownbamt       비보험액(전액본인부담액)     
     * <li>nopyamt          비급여액                     
     * <li>specamt          선택진료비총액               
     * <li>totownbamt       총본인부담액                 
     * <li>handcapfund      장애인기금                   
     * <li>subtamt          대불액                       
     * <li>bloddiscamt      수혈대체액                   
     * <li>discreduamt      감액(할인+감액)              
     * <li>uncoamt          미수액                       
     * <li>precashamt       기현금액                     
     * <li>premdlrcptamt    기선수금                     
     * <li>precardamt       기카드금액                   
     * <li>preonlineamt     기온라인금액                 
     * <li>mdlrcptamt       선수금                       
     * <li>rcptexptamt      납부할 금액                  
     * <li>cardamt          카드금액                     
     * <li>cashamt          현금금액                     
     * <li>onlineamt        통장입금액                   
     * <li>paypsnflag       납부자                       
     * <li>payrem           납부자기타사항               
     * <li>instcd           기관코드                     
     * </ul>
     * @throws LiveException
     */
    public ValueObject getOpmiAmtInfo(ValueObjectAssembler pVOs , String caller) throws LiveException;
    
    
    /**
     * <p>외래중간금(선수금) 수납 취소 처리</p>
     * 외래중간금(선수금) 수납 취소 처리
     * 
     *
     * @param pVO ValueObject    
     * <p>req : 입력데이터
     * <ul>
     * <li>pid          등록번호        
     * <li>rcptdd       영수일자        
     * <li>rcptno       영수증번호      
     * <li>rcptseqno    영수증일련번호     
     * <li>seqno        일련번호        
     * <li>instcd       기관코드        
     * <li>rcptstat     수납상태        
     * <li>ordtype      진료형태        
     * <li>rcptflag     수납구분        
     * <li>cashamt      현금금액        
     * <li>cardamt      카드금액        
     * <li>onlineamt    온라인금액      
     * <li>rcptexecdd   수납일자        
     * <li>rcpttm       수납시간        
     * <li>rcptrid      수납자ID        
     * <li>remfact      참고사항        
     * <li>fstrgstrid   최초등록자      
     * <li>fstrgstdt    최초등록일시       
     * <li>lastupdtrid  최종수정자      
     * <li>lastupdtdt   최종수정일시       
     * </ul>
     * @return int
     * @throws LiveException
     */
    public int insMdlAmtCncl(ValueObject pVO) 
            throws LiveException;
    

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

    public int insOutOrdAmt(ValueObject pVO) 
            throws LiveException;

    
    /**
     * <p>유형변경 사항 조회 </p>
     * 보험유형, 할인내역, 외래등록내역(초재진구분,선택진료구분,진찰료산정구분 등)
     * 등의 유형변경 사항 체크하여 , 변경된 내역이 있을 경우, 이력추가
     * 
     *
     * @param pVOs ValueObjectAssembler
     * <p>Checkin : 입력데이터
     * <ul>
     * <li>insukind         보험유형                                                                          
     * <li>suppkind         보조유형                                                                          
     * <li>insucd           보험자코드                                                                        
     * <li>disccd           할인코드                                                                          
     * <li>specordyn        선택진료여부                                                                      
     * <li>fsexamflag       초재진구분                                                                        
     * <li>fsexammanlyn     초재진수동부여여부                                                                
     * <li>medamtestmyn     진찰료산정여부                                                                    
     * <li>medamtpostyn     진찰료후불여부                                                                    
     * <li>medamtfreeresn   진찰료면제사유 진찰료 산정여부가 N=미산정,무료일때 미산정 사유(코드군 P1061 참조)               
     * <li>etcordflag       기타진료구분(코드군 P0022 참조) J:주사  M:물리치료, F:가족, N:가정간호            
     * </ul>
     * <p>Ptin : 보험정보
     * <ul>
     * <li>insukind             보험유형
     * <li>suppkind             보조유형
     * <li>insucd               보험자코드
     * <li>....
     * </ul>
     * <p>Ptdc : 감면정보
     * <ul>
     * <li>disccd               할인코드
     * <li>...
     * </ul>
     * @return ValueObject
     * <p>Checkout   :          출력데이터
     * <ul>
     * <li>calcyn               정산여부
     * </ul>
     * @throws LiveException
     */
    public ValueObject insChangeHist(ValueObjectAssembler pVOs) 
            throws LiveException;

    /**
     * <p>환자정보 조회</p>
     * 환자 조회.
     * 
     *
     * @param pVOs ValueObjectAssembler
     * <p>req : 조회조건
     * <ul>
     * <li>srchcond         조회조건 
     * <li>pid              등록번호 
     * <li>hngnm
     * <li>rrgstno1
     * <li>rrgstno2
     * </ul>
     * @return ValueObject
     * <p>ptbs   : 환자정보
     * <ul>
     * <li>pid              등록번호 
     * <li>hngnm            한글이름
     * <li>...
     * </ul>
     * @throws LiveException
     */
    public ValueObject getPatInfo(ValueObject pVOs) 
            throws LiveException;
    
    
    /**
     * <p>상병조회(외래수납화면)</p>
     * 상병조회(외래수납화면)
     * 
     *
     * @param pVO ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>pid          등록번호
     * <li>orddd        진료일자
     * <li>cretno       생성번호
     * </ul>
     * @return ValueObject
     * <p>diag : 출력데이터
     * <ul>
     * <li>diagcd       상병코드
     * <li>diagcdnm     상병명
     * <li>orddd        진료일자
     * <li>chrncsickyn  만성병여부
     * </ul>  
     * @throws LiveException
     */
    public ValueObject getPatDiag(ValueObject pVO) throws LiveException;
    
    /**
     * <p>계산(외래수납화면)</p>
     * 계산(외래수납화면)
     * 
     *
     * @param pVOs ValueObjectAssembler
     * <p>req : 입력데이터
     * <ul>
     * <li>pid          등록번호
     * <li>orddd        진료일자
     * <li>cretno       생성번호
     * </ul>
     * @return ValueObjectAssembler
     * <p> : 출력데이터
     * <ul>
     * <li>diagcd       상병코드
     * <li>diagcdnm     상병명
     * <li>orddd        진료일자
     * <li>chrncsickyn  만성병여부
     * </ul>  
     * @throws LiveException
     */
    public ValueObjectAssembler setOutOrdAmtCalc(ValueObjectAssembler pVOs) throws LiveException;


    /**
     * <p>외래수납내역조회(외래정산화면)</p>
     * 
     *
     * @param pVO ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>pid          등록번호
     * <li>orddd        진료일자
     * <li>cretno       생성번호
     * <li>orddeptcd    진료과
     * <li>orddrid      진료의사
     * <li>srchcond     조회조건
     * </ul>
     * @return ValueObject
     * <p>opmi : 출력데이터
     * <ul>
     * <li>pid          등록번호
     * <li>rcptdd       영수일자
     * <li>....
     * <li>lastupdtdt   최종수정일자
     * </ul>  
     * @throws LiveException
     */
    public ValueObject getopmiList3(ValueObject pVO) 
            throws LiveException;
    
    
    /**
     * <p>수납(외래수납화면)</p>
     * 수납(외래수납화면)
     * 
     *
     * @param pVOs ValueObjectAssembler
     * <p>opmi : 수납정보
     * <ul>
     * <li>opmi_pid     등록번호
     * <li>opmi_rcptdd  영수일자
     * <li>opmi_rcptno  생성번호
     * </ul>
     * @return ValueObjectAssembler
     * <p> : opmi : 수납정보(영수증출력위한)
     * <ul>
     * <li>opmi_pid     등록번호
     * <li>opmi_rcptdd  영수일자
     * <li>opmi_rcptno  생성번호
     * </ul>  
     * @throws LiveException
     */
    public ValueObjectAssembler setOutOrdAmtRcpt(ValueObjectAssembler pVOs) 
            throws LiveException;
    
    
    /**
     * <p>외래등록정보 조회</p>
     * 외래정산화면에서 수납내역 선택시, 해당 외래등록정보 조회
     * 
     *
     * @param pVO ValueObjectAssembler
     * <p>opmi : 외래수납정보
     * <ul>
     * <li>opmi_pid     등록번호 
     * <li>opmi_rcptdd
     * <li>opmi_rcptno
     * <li>opmi_rcptseqno
     * </ul>
     * @return ValueObject
     * <p>otpt   : 외래등록
     * <ul>
     * <li>pid      등록번호 
     * <li>orddd    진료일자
     * <li>...
     * </ul>
     * @throws LiveException
     */
    public ValueObject getOtptInfo(ValueObject pVO) throws LiveException;
    
    /**
     * <p>수익정보 조회</p>
     * 외래정보 키로 수익정보 조회(외래수납)
     * 
     *
     * @param pVO ValueObject
     * <p>otpt : 외래정보
     * <ul>
     * <li>pid                  등록번호 
     * <li>orddd                진료일자
     * <li>cretno               생성번호
     * </ul>
     * @return ValueObject
     * <p>earn   : 환자 수익정보 조회
     * <ul>
     * <li>outcls               외래영수증구분
     * <li>outclsnm             외래등록생성번호
     * <li>payamt               급여
     * <li>nopyamt              비급여
     * <li>specamt              선택진료비
     * </ul>
     * @throws LiveException
     */
    public ValueObject getEarnInfo2(ValueObject pVO) throws LiveException;
    
    /**
     * <p>수익정보 조회</p>
     * 외래정보 키로 수익정보 조회(외래수납)
     * 
     *
     * @param pVO ValueObject
     * <p>otpt : 외래정보
     * <ul>
     * <li>pid                  등록번호 
     * <li>orddd                진료일자
     * <li>cretno               생성번호
     * </ul>
     * @return ValueObject
     * <p>earn   : 환자 수익정보 조회
     * <ul>
     * <li>outcls               외래영수증구분
     * <li>outclsnm             외래등록생성번호
     * <li>payamt               급여
     * <li>nopyamt              비급여
     * <li>specamt              선택진료비
     * </ul>
     * @throws LiveException
     */
    public ValueObject getEarnInfo3(ValueObject pVO) throws LiveException;   
    
    /**
     * <p>수익정보 조회</p>
     * 외래정보 키로 수익정보 SUM조회(외래수납)
     * 
     *
     * @param pVO ValueObject
     * <p>otpt : 외래정보
     * <ul>
     * <li>pid                  등록번호 
     * <li>orddd                진료일자
     * <li>cretno               생성번호
     * </ul>
     * @return ValueObject
     * <p>earn   : 환자 수익정보 조회
     * <ul>
     * <li>outcls               외래영수증구분
     * <li>outclsnm             외래등록생성번호
     * <li>payamt               급여
     * <li>nopyamt              비급여
     * <li>specamt              선택진료비
     * </ul>
     * @throws LiveException
     */
    public ValueObject getEarnInfo4(ValueObject pVO) throws LiveException;
        
    /**
     * <p>외래등록정보 조회</p>
     * 외래정산화면에서 수납내역 선택시, 해당 외래등록정보 조회
     * 
     *
     * @param pVO ValueObject
     * <p>opmi : 외래수납정보
     * <ul>
     * <li>opmi_pid             등록번호 
     * <li>opmi_rcptdd
     * <li>opmi_rcptno
     * <li>opmi_rcptseqno
     * </ul>
     * @return ValueObject
     * <p>otpt   : 외래등록
     * <ul>
     * <li>pid                  등록번호 
     * <li>orddd                진료일자
     * <li>...
     * </ul>
     * @throws LiveException
     */
    public ValueObject getOtptInfo2(ValueObject pVO) 
            throws LiveException;

    /**
     * <p>외래등록정보 조회</p>
     * 외래정산화면에서 수납내역 선택시, 해당 외래등록정보 조회
     * 
     *
     * @param pVO ValueObject
     * <p>opmi : 외래수납정보
     * <ul>
     * <li>opmi_pid             등록번호 
     * <li>opmi_rcptdd
     * <li>opmi_rcptno
     * <li>opmi_rcptseqno
     * </ul>
     * @return ValueObject
     * <p>otpt   : 외래등록
     * <ul>
     * <li>pid                  등록번호 
     * <li>orddd                진료일자
     * <li>...
     * </ul>
     * @throws LiveException
     */
    public ValueObject getOtptInfo3(ValueObject pVO) 
            throws LiveException;
    

    /**
     * <p>환자처방 조회</p>
     * 환자처방 조회(외래수납화면)
     * 
     *
     * @param pVO ValueObject
     * <p>req : 조회조건
     * <ul>
     * <li>pid              등록번호 
     * <li>orddd
     * <li>cretno
     * </ul>
     * @return ValueObject
     * <p>prcp  : 처방정보
     * <ul>
     * <li>calcscorcd       수가코드 
     * <li>calcscorcdnm     수가코드명
     * <li>...
     * </ul>
     * @throws LiveException
     */
    public ValueObject getprcpList2(ValueObject pVOs) 
            throws LiveException;

    /**
     * <p>홀드처방일자  조회</p>
     * 홀드처방일자  조회(외래수납화면)
     * 
     *
     * @param pVO ValueObject
     * <p>req : 조회조건
     * <ul>
     * <li>pid              등록번호 
     * <li>orddd
     * <li>cretno
     * </ul>
     * @return ValueObject
     * <p>holddd  : 처방정보
     * <ul>
     * <li>prcp_pid             
     * <li>prcp_prcpdd      처방일자
     * <li>...
     * </ul>
     * @throws LiveException
     */
    //public ValueObject getholdDDList(ValueObject pVO) throws LiveException;

    /**
     * <p>환자 HOLD 처방 조회</p>
     * 홀드처방일자  조회(외래수납화면)
     * 
     *
     * @param pVO ValueObject
     * <p>req : 조회조건
     * <ul>
     * <li>pid                  등록번호 
     * <li>orddd
     * <li>cretno
     * </ul>
     * @return ValueObject
     * <p>holddd  : 처방정보
     * <ul>
     * <li>pid                  등록번호        
     * <li>calcscorcd
     * <li>prcpdd
     * <li>prcpno
     * <li>prcphistno
     * <li>...
     * </ul>
     * @throws LiveException
     */
    //public ValueObject getholdList(ValueObject pVO) throws LiveException;
    
    
    /**
     * <p>외래중간금수납(외래선수금화면)</p>
     * 외래중간금수납(외래선수금화면)
     * 
     *
     * @param pVOs ValueObjectAssembler
     * <p>bogj: 수납정보
     * <ul>
     * <li>bogj_pid             등록번호
     * <li>bogj_rcptdd          영수일자
     * <li>bogj_rcptno          생성번호
     * </ul>
     * @return ValueObjectAssembler
     * <p> : bogj : 수납정보(영수증출력위한)
     * <ul>
     * <li>bogj_pid             등록번호
     * <li>bogj_rcptdd          영수일자
     * <li>bogj_rcptno          생성번호
     * </ul>  
     * @throws LiveException
     */
    public ValueObjectAssembler setMdlAmtRcpt(ValueObjectAssembler pVOs) 
            throws LiveException;

    /**
     * <p>카드 수납 처리</p>
     * 카드 수납처리
     *
     * @param pVO ValueObject    
     * <p>card : 입력데이터
     * <ul>
     * <li>pid          등록번호        
     * <li>rcptdd       영수일자        
     * <li>rcptno       영수증번호      
     * <li>rcptseqno    영수증일련번호      
     * <li>seqno        일련번호        
     * <li>instcd       기관코드        
     * <li>rcptstat     수납상태        
     * <li>ordtype      진료형태        
     * <li>cardamt      카드금액            
     * <li>cardno       카드번호            
     * <li>aprvflag     승인구분            
     * <li>aprvno       승인번호            
     * <li>aprvdd       승인일자            
     * <li>aprvtm       승인시              
     * <li>rcptexecdd   수납일자        
     * <li>rcpttm       수납시간        
     * <li>rcptrid      수납자ID        
     * <li>preamtyn     선수금여부          
     * <li>innrtretyn   내부처리여부        
     * <li>remfact      참고사항        
     * <li>fstrgstrid   최초등록자      
     * <li>fstrgstdt    최초등록일시        
     * <li>lastupdtrid  최종수정자      
     * <li>lastupdtdt   최종수정일시        
     * </ul>
     * @return int
     * @throws LiveException
     */

    public int insCardAmt(ValueObject pVO) 
            throws LiveException;
        
    /**
     * <p>현금영수증 수납 처리</p>
     * 현금영수증 수납처리
     *
     * @param pVO ValueObject    
     * <p>cash : 입력데이터
     * <ul>
     * <li>pid          등록번호        
     * <li>rcptdd       영수일자        
     * <li>rcptno       영수증번호      
     * <li>rcptseqno    영수증일련번호    
     * <li>seqno        일련번호        
     * <li>instcd       기관코드        
     * <li>rcptstat     수납상태        
     * <li>ordtype      진료형태        
     * <li>cashamt      현금금액          
     * <li>qualcnfmflag 자격확인구분      
     * <li>qualcnfmno   자격확인번        
     * <li>aprvflag     승인구분          
     * <li>aprvno       승인번호          
     * <li>aprvdd       승인일자          
     * <li>aprvtm       승인시            
     * <li>rcptexecdd   수납일자        
     * <li>rcpttm       수납시간        
     * <li>rcptrid      수납자ID      
     * <li>preamtyn     선수금여부        
     * <li>innrtretyn   내부처리여부      
     * <li>remfact      참고사항        
     * <li>fstrgstrid   최초등록자      
     * <li>fstrgstdt    최초등록일시      
     * <li>lastupdtrid  최종수정자      
     * <li>lastupdtdt   최종수정일시      
     * </ul>
     * @return int
     * @throws LiveException
     */

    public int insCashAmt(ValueObject pVO) 
            throws LiveException;
    

    /**
     * <p>외래중간금수납(외래선수금화면)</p>
     * 외래중간금수납(외래선수금화면)
     * 
     *
     * @param pVOs ValueObjectAssembler
     * <p>bogj: 수납정보
     * <ul>
     * <li>bogj_pid             등록번호
     * <li>bogj_rcptdd          영수일자
     * <li>bogj_rcptno          생성번호
     * </ul>
     * @return ValueObjectAssembler
     * <p> : bogj : 수납정보(영수증출력위한)
     * <ul>
     * <li>bogj_pid             등록번호
     * <li>bogj_rcptdd          영수일자
     * <li>bogj_rcptno          생성번호
     * </ul>  
     * @throws LiveException
     */
    public ValueObjectAssembler setMdlAmtRcptCncl(ValueObjectAssembler pVOs) 
            throws LiveException;
    
    
    /**
     * <p>현금영수증 수납취소 처리</p>
     * 현금영수증 수납취소 처리
     *
     * @param pVO ValueObject    
     * <p>cash : 입력데이터
     * <ul>
     * <li>pid          등록번호        
     * <li>rcptdd       영수일자        
     * <li>rcptno       영수증번호      
     * <li>rcptseqno    영수증일련번호      
     * <li>seqno        일련번호        
     * <li>instcd       기관코드        
     * <li>rcptstat     수납상태        
     * <li>ordtype      진료형태        
     * <li>cashamt      현금금액            
     * <li>qualcnfmflag 자격확인구분        
     * <li>qualcnfmno   자격확인번          
     * <li>aprvflag     승인구분            
     * <li>aprvno       승인번호            
     * <li>aprvdd       승인일자            
     * <li>aprvtm       승인시              
     * <li>rcptexecdd   수납일자        
     * <li>rcpttm       수납시간        
     * <li>rcptrid      수납자ID        
     * <li>preamtyn     선수금여부          
     * <li>innrtretyn   내부처리여부        
     * <li>remfact      참고사항        
     * <li>fstrgstrid   최초등록자      
     * <li>fstrgstdt    최초등록일시        
     * <li>lastupdtrid  최종수정자      
     * <li>lastupdtdt   최종수정일시        
     * </ul>
     * @return int
     * @throws LiveException
     */

    public int insCashAmtCncl(ValueObject pVO) 
            throws LiveException;
    
    /**
     * <p>카드 수납 취소 처리</p>
     * 카드 수납 취소 처리
     *
     * @param pVO ValueObject    
     * <p>card : 입력데이터
     * <ul>
     * <li>pid          등록번호    
     * <li>rcptdd       영수일자    
     * <li>rcptno       영수증번호  
     * <li>rcptseqno    영수증일련번호
     * <li>seqno        일련번호    
     * <li>instcd       기관코드    
     * <li>rcptstat     수납상태    
     * <li>ordtype      진료형태    
     * <li>cardamt      카드금액      
     * <li>cardno       카드번호      
     * <li>aprvflag     승인구분      
     * <li>aprvno       승인번호      
     * <li>aprvdd       승인일자      
     * <li>aprvtm       승인시        
     * <li>rcptexecdd   수납일자    
     * <li>rcpttm       수납시간    
     * <li>rcptrid      수납자ID    
     * <li>preamtyn     선수금여부    
     * <li>innrtretyn   내부처리여부  
     * <li>remfact      참고사항    
     * <li>fstrgstrid   최초등록자  
     * <li>fstrgstdt    최초등록일시    
     * <li>lastupdtrid  최종수정자  
     * <li>lastupdtdt   최종수정일시  
     * </ul>
     * @return int
     * @throws LiveException
     */

    public int insCardAmtCncl(ValueObject pVO) 
            throws LiveException;
    
    /**
     * 환자진료의뢰내역 입력
     *
     * @param pVOs ValueObjectAssembler
     * <p>req : 입력데이터
     * <ul>
     * <li>cnst_pid  등록번호
     * <li>cnst_orddeptcd_before 과코드
     * <li>cnst_insuflag_before 보험구분
     * <li>cnst_ordreqkind_before 의뢰구분
     * <li>cnst_todd_before 종료일
     * <li>cnst_seqno_before 순번
     * </ul>
     * @return void
     * @throws LiveException
     */
    public void setCnst(ValueObjectAssembler pVOs) throws LiveException;

    
    /**
     * <p>Hold/Release 처리</p>
     * 
     *
     * @param pVO ValueObject   
     * <p>hold : 입력데이터
     * <ul>         
     * <li>pid      영수일자    
     * <li>orddd    수납일자    
     * <li>prcpdd   처방일자     
     * <li>prcpno   처방번호    
     * <li>prcphistno   처방이력번호    
     * </ul>
     * @return  int
     * @throws LiveException
     */
    public int setHoldPrcpList(ValueObject pVO) throws LiveException;
    

    /**
     * <p>외래등록조회(외래정산화면)</p>
     * 
     *
     * @param pVO ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>pid          등록번호  
     * <li>srchcond     조회조건  
     * <li>fromdd       시작일자  
     * <li>todd         종료일자  
     * <li>orddeptcd    진료과    
     * <li>orddrid      진료의사  
     * <li>insukind     보험유형  
     * </ul>
     * @return ValueObject
     * <p>otpt               : 출력데이터
     * <ul>
     * <li>orddd        진료일자    
     * <li>ordtm        진료시간    
     * <li>orddept      진료과      
     * <li>orddr        진료의      
     * <li>fsexamflag   초재진구분  
     * <li>indukind     보험유형    
     * <li>suppkind     보조유형    
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
     * <li>pid              환자등록번호
     * <li>orddd            진료일자 
     * <li>cretno           생성번호
     * <li>acptseqno        등록일련번호
     * </ul>
     * @return ValueObject
     * <p>rcptspeclist : 수납내역 리스트
     * <ul>
     * <li>pid              환자등록번호                     
     * <li>rcptdd           영수증일자                       
     *  <li>rcptno          영수증번호                   
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
     *  <li>cashamt         현금금액                     
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
     * <p>보험정보 이력추가 </p>
     * 입력된 보험사항에 대해 변경사항이 있는 경우 이력추가
     * 
     *
     * @param pVO ValueObject
     * <p>Ptin : 보험정보
     * <ul>
     * <li>insukind             보험유형
     * <li>suppkind             보조유형
     * <li>insucd               보험자코드
     * <li>....
     * </ul>     
     * @return int
     * @throws LiveException
     */
    public int insPtinHistAdd(ValueObject pVO) throws LiveException;
    
    
    /**
     * <p>무인수납 환자 체크(환자기본정보에 대한 체크)</p>
     * @author 최희경
     * @version 1.0 2007.09.07
     * 
     *
     * @param pVO ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>pid              등록번호 
     * <li>instcd           기관코드
     * </ul>
     * @return ValueObject
     * <p>check
     * <ul>
     * <li>error            에러코드(정상 0000)
     * <li>errortype        에러타입 
     * <li>errormsg         에러메시지
     * </ul>
     * @throws LiveException
     */
    public ValueObject getCheckPatInfo(ValueObject pVO) throws LiveException;
    
    /**
     * <p>무인수납 환자 체크(외래등록정보에 대한 체크)</p>
     * @author 최희경
     * @version 1.0 2007.09.07
     * 
     *
     * @param pVO ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>pid              등록번호 
     * <li>instcd           기관코드
     * </ul>
     * @return ValueObject
     * <p>check
     * <ul>
     * <li>error            에러코드(정상 0000)
     * <li>errortype        에러타입 
     * <li>errormsg         에러메시지
     * </ul>
     * @throws LiveException
     */
    public ValueObject getCheckOTPTInfo(ValueObject pVO) throws LiveException;
    
    /**
     * VAN 승인정보만 있는 카드내역 조회
     * @author 최희경
     * @param pVO ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>
     * </ul>
     * @return ValueObject
     * <p>
     * <ul>
     * <li>
     * </ul>
     * @throws LiveException
     */ 
    public ValueObject getonlycvanList(ValueObject pVO) throws LiveException;

    
    /**
     * 요율변경내역 조회
     * @author 최희경
     * @param pVO ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>
     * </ul>
     * @return ValueObject
     * <p>
     * <ul>
     * <li>
     * </ul>
     * @throws LiveException
     */ 
    public ValueObject getupdtrateList(ValueObject pVO) throws LiveException;

    /**
     * 당일투석진료내역
     * @author 이동재
     * @param pVO ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>
     * </ul>
     * @return ValueObject
     * <p>
     * <ul>
     * <li>
     * </ul>
     * @throws LiveException
     */ 
    public ValueObject getupdtrateList1(ValueObject pVO) throws LiveException;  
    
    /**
     * <p>요율변경내역 변경</p>
     * 
     *
     * @param pVO ValueObject   
     * <p>hold : 입력데이터
     * <ul>         
     * <li>pid                  영수일자    
     * <li>orddd            진료일자    
     * <li>cretno               생성번호     
     * </ul>
     * @return  int
     * @throws LiveException
     */
    public int setupdtrateList(ValueObject pVO) throws LiveException;
    
    /**
     * <p>계산정보 조회</p>
     * 계산정보 조회
     * 
     *
     * @param pVO ValueObject
     * <p>req : 환자계산정보 조회조건
     * <ul>
     * <li>pid              등록번호 
     * <li>orddd            진료일자
     * <li>cretno           생성번호
     * <li>acptseqno        외래등록일련번호
     * </ul>
     * @return ValueObject
     * <p>oscl   : 환자 계산정보 조회
     * <ul>
     * <li>pid              등록번호                           
     * <li>orddd            외래등록일자                       
     * <li>cretno           외래등록생성번호                   
     * <li>calcseqno        계산일련번호                       
     * <li>calcscorseqno    계산수행시,계산내역별 일련번호     
     * <li>instcd           기관코드                           
     * <li>calcstat         계산상태                           
     * <li>clamtrgtstat     청구대상상태                       
     * <li>acptseqno        외래등록생성번호별일련번호         
     * <li>orddeptcd        진료과코드                         
     * <li>orddrid          진료의사                           
     * <li>mskind           주부유형                           
     * <li>ordtype          진료형태                           
     * <li>grupcalcscorcd   그룹수가코드                       
     * <li>snglcalcscorcd   싱글수가코드                       
     * <li>grupcalcscorcls  그룹수가분류                       
     * <li>snglcalcscorcls  싱글수가분류                       
     * <li>grupearncls      그룹수익분류                       
     * <li>snglearncls      싱글수익분류                       
     * <li>ordqty           처방지시투여량                     
     * <li>ordtims          처방지시투여횟수                   
     * <li>orddays          처방지시투여일수                   
     * <li>calcqty          계산투여량                         
     * <li>calctims         계산투여횟수                       
     * <li>calcdays         계산투여일수                       
     * <li>matractflag      재료행위구분                       
     * <li>calcpayflag      급여구분                           
     * <li>prcppayflag      처방급여구분                       
     * <li>calcscorpayflag  수가급여구분2                      
     * <li>ansttm           마취시간                           
     * <li>spccd            검체코드                           
     * <li>pntunitcost      점당단가                           
     * <li>calcscorpnt      수가점수                           
     * <li>estmpnt          산정점수                           
     * <li>appunitcost      단가                               
     * <li>estmamt          산정금액                           
     * ...                                             
     * <li>fstrgstrid       최초등록자                         
     * <li>fstrgstdt        최초등록일시                       
     * <li>lastupdtrid      최종등록자                         
     * <li>lastupdtdt       최종등록일시                       
     * </ul>
     * @throws LiveException
     */
    public ValueObject getEarnOsclInfo(ValueObject pVO) throws LiveException;   
    
    
    /**
     * <p>외래처방내역에 처방급비정보변경 update</p> 
     *
     * @param pVOs ValueObject  
     * <p>opmi : 입력데이터
     * <ul>         
     * <li>rcptdd           영수일자        
     * <li>rcptexecdd       수납일자    
     * <li>rcptno           영수증번호       
     * <li>rcptseqno        영수일련번호    
     * <li>rcptstat         수납상태        
     * </ul>
     * @return  int
     * @throws LiveException
     */
    public ValueObject setOprcPayFlag(ValueObject pVO) throws LiveException;    
  
	
    /**
     * <p>환자진료의뢰서 입력</p> 
     *
     * @param pVOs ValueObject  
     * <p>opmi : 입력데이터
     * <ul>         
     * <li>pid 환자번호.
     * <li>orddd 진료일자
     * <li>orddeptcd 진료과
     * <li>insukind 보험정보
     * <li>ordreqformflag 진료의뢰서 종류
     * <li>etcordflag 기타구분      
     * </ul>
     * @return  int
     * @throws LiveException
     */
    public int setOutOrdCnst(ValueObject pVO) throws LiveException;  


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
     * </ul>
     * @return int 수정건수
     * @throws LiveException
     */
	public int setOrdPayFlag(ValueObject pVO) throws LiveException;
	
	
	/**
     * <p> 입원 처방 급비구분코드를 수정한다.</p>
     * @author 
     * @param pVO ValueObject
     * <ul>
     * <li>prcpdd 처방일자
     * <li>prcpno 처방일련번호
     * <li>prcphistno 처방이력번호
     * <li>payflagcd 급비구분코드
     * </ul>
     * @return int 수정건수
     * @throws LiveException
     */
	public int setInOrdPayFlag(ValueObject pVO) throws LiveException;
	
	
	/**
     * <p> 입원 처방 급비구분코드를 수정한다. 소급일자 등록</p>
     * @author 
     * @param pVO ValueObject
     * <ul>
     * <li>prcpdd 처방일자
     * <li>prcpno 처방일련번호
     * <li>prcphistno 처방이력번호
     * <li>payflagcd 급비구분코드
     * </ul>
     * @return int 수정건수
     * @throws LiveException
     */
	public int setInPatInfoHist(ValueObject pVO) throws LiveException;


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
	 * </ul>
	 * @return int 입력건수
	 * @throws LiveException
	 */	   
	public int setOutPatInfoHist(ValueObject pVO) throws LiveException;


	/**
     * <p>외래수납 계산취소</p>
     * 
     * 
     *
     * @param pVOs ValueObjectAssembler
     * <p>req : 입력데이터
     * <ul>
     * <li>pid          등록번호
     * <li>orddd        진료일자
     * <li>cretno       생성번호
     * </ul>
     * @return ValueObjectAssembler
     * <p> : 출력데이터
     * <ul>
     * <li>diagcd       상병코드
     * <li>diagcdnm     상병명
     * <li>orddd        진료일자
     * <li>chrncsickyn  만성병여부
     * </ul>  
     * @throws LiveException
     */
    public int setOutOrdCalcCancel(ValueObjectAssembler pVOs) throws LiveException;


    /**
     * <p>외래수납 환자 기초정보</p>
     * 현금영수증디폴트승인번호
     * 
     *
     * @param pVOs ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>pid 등록번호 
     * </ul>
     * @return ValueObject
     * <p>
     * <ul>
     * <li>cshb_qualcnfmno  승인번호          
     * </ul>
     * @throws LiveException
     */
	public ValueObjectAssembler getPidInfo(ValueObject pVO) throws LiveException;


    /**
     * <p>외래수납</p>
     * 외래수납 필수 체크사항
     * 
     *
     * @param pVOs ValueObject
     * <p>req : 입력데이터
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
	public ValueObject outOrd_Check(ValueObjectAssembler pVOs , String caller , String instcd , String userId) throws LiveException ;  


	/**
     * <p>의사소견서관리팝업 조회</p>
     * 
     * @param pVOs ValueObject
     * <p>req : 입력데이터
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
	public ValueObject getDrcmList(ValueObject pVO) throws LiveException ; 


	/**
     * <p>의사소견서관리팝업 저장</p>
     * 
     * @param pVOs ValueObject
     * <p>req : 입력데이터
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
	public ValueObject setDrcmList(ValueObject pVO) throws LiveException ; 


	/**
     * <p>외래수납 디테일 테이블 가져오기</p>
     * 
     * @param pVOs ValueObject
     * <p>req : 입력데이터
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
	public ValueObject getOtptDetailTB(ValueObject pVO) throws LiveException ; 

	/**
     * <p>방문간호지시서팝업 조회</p>
     * 
     * @param pVOs ValueObject
     * <p>req : 입력데이터
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
	public ValueObject getHocmList(ValueObject pVO) throws LiveException ; 


	/**
     * <p>방문간호지시서팝업 저장</p>
     * 
     * @param pVOs ValueObject
     * <p>req : 입력데이터
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
	public ValueObject setHocmList(ValueObject pVO) throws LiveException ; 


	/**
     * <p의사면허번호조회</p>
     * 
     * @param pVOs ValueObject
     * <p>req : 입력데이터
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
	public ValueObject getUsrdlicnsno(ValueObject pVO) throws LiveException ; 


	/**
     * <p자보한도환자분리팝업</p>
     * 외래등록내역조회
     * @param pVOs ValueObject
     * <p>req : 입력데이터
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
	public ValueObject getOtptCarInsu(ValueObject pVO) throws LiveException ; 


	/**
     * <p자보한도환자분리팝업</p>
     * 처방내역조회
     * @param pVOs ValueObject
     * <p>req : 입력데이터
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
	public ValueObject getOprcCarInsu(ValueObject pVO) throws LiveException ; 


    /*
     * 자보한도환자분리팝업
     * 처방내역분리
     * @author cys
     * @param pVOs ValueObject
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject setOprcCarInsu(ValueObject pVO) throws LiveException ;


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
     *
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
     * <p>카드내역 조회</p>
     * 카드내역 조회
     * 
     *
     * @param pVO ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>fromdd           시작일자  
     * <li>todd             종료일자  
     * <li>pid              등록번호  
     * <li>orddeptcd        진료과    
     * <li>insukind         보험유형  
     * <li>cardno           카드번호  
     * </ul>
     * @return ValueObject
     * <p>card          : 출력데이터
     * <ul>
     * <li>rcptdd       영수일자        
     * <li>rcptno       영수증번호      
     * <li>rcptseqno    영수증일련번호  
     * <li>seqno        일련번호        
     * <li>instcd       기관코드        
     * <li>rcpstat      수납상태        
     * <li>ordtype      진료형태        
     * <li>keyinptflag  키입력구분      
     * <li>cardcmpycd   카드사코드      
     * <li>cardno       카드번호        
     * <li>aprvflag     승인구분        
     * <li>aprvdd       승인일자        
     * <li>aprvtm       승인시간    
     * <li>aprvno       승인번호        
     * <li>vancd        van코드         
     * <li>allotmm      할부개월수      
     * <li>cardamt      카드금액        
     * <li>valiterm     유효기간        
     * <li>rcptexecdd   수납일자        
     * <li>rcpttm       수납시간        
     * <li>rcptid       수납자ID        
     * <li>remfact      참고사항        
     * </ul>
     * @throws LiveException
     */
    public ValueObject getcardList(ValueObject pVO) throws LiveException;
    
    /**
     * <p>현금영수증수납내역 조회</p>
     * 현금영수증수납내역 조회
     * 
     *
     * @param pVO ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>fromdd           시작일자                          
     * <li>todd             종료일자                          
     * <li>pid              등록번호                          
     * <li>orddeptcd        진료과                            
     * <li>insukind         보험유형                          
     * <li>cardno           카드번호(현금영수증 자격확인번호) 
     * </ul>
     * @return ValueObject
     * <p>cash           : 출력데이터
     * <ul>
     * <li>rcptdd       영수일자        
     * <li>rcptno       영수증번호      
     * <li>rcptseqno    영수증일련번호  
     * <li>seqno        일련번호        
     * <li>instcd       기관코드        
     * <li>rcpstat      수납상태        
     * <li>ordtype      진료형태        
     * <li>qualcnfmflag 키입력구분      
     * <li>qualcnfmno   카드사코드      
     * <li>aprvflag     승인구분        
     * <li>aprvdd       승인일자        
     * <li>aprvtm       승인시간    
     * <li>aprvno       승인번호        
     * <li>cashamt      현금금액        
     * <li>rcptexecdd   수납일자        
     * <li>rcpttm       수납시간        
     * <li>rcptid       수납자ID        
     * <li>remfact      참고사항        
     * </ul>
     * @throws LiveException
     */
    public ValueObject getcashList(ValueObject pVO) throws LiveException;

    /**
     * <p>온라인입금수납내역 조회</p>
     * 온라인입금수납내역 조회
     * 
     *
     * @param pVO ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>fromdd           시작일자
     * <li>todd             종료일자
     * <li>pid              등록번호
     * <li>orddeptcd        진료과  
     * <li>insukind         보험유형
     * <li>cardno           입금자      
     * </ul>
     * @return ValueObject
     * <p>onlinelist     : 출력데이터
     * <ul>
     * <li>rcptdd       영수일자        
     * <li>rcptno       영수증번호      
     * <li>rcptseqno    영수증일련번호  
     * <li>seqno        일련번호        
     * <li>instcd       기관코드        
     * <li>rcpstat      수납상태        
     * <li>ordtype      진료형태        
     * <li>bankcd       은행코드        
     * <li>acntno       계좌번호        
     * <li>paydd        입금일자        
     * <li>paypsnnm     입금자명        
     * <li>onlineamt    온라인금액      
     * <li>rcptexecdd   수납일자        
     * <li>rcpttm       수납시간        
     * <li>rcptid       수납자ID        
     * <li>remfact      참고사항        
     * </ul>
     * @throws LiveException
     */
    public ValueObject getonlnList(ValueObject pVO) throws LiveException;

    /**
     * <p>수혈대체내역 조회</p>
     * 기수혈대체
     * 
     *
     * @param pVO ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>fromdd           시작일자
     * <li>todd             종료일자
     * <li>pid              등록번호
     * <li>orddeptcd        진료과  
     * <li>insukind         보험유형
     * <li>cardno           입금자      
     * </ul>
     * @return ValueObject
     * <p>onlinelist     : 출력데이터
     * <ul>
     * <li>bldc_pid                    환자의고유ID             
	 * <li>bldc_hngnm                  환자성명				 
	 * <li>bldc_rcptdd                 영수일자                 
	 * <li>bldc_rcptno                 영수번호                 
	 * <li>bldc_rcptseqno              영수일련번호             
	 * <li>bldc_seqno                  영수증일련번호           
	 * <li>bldc_instcd                 기관코드                 
	 * <li>bldc_rcptstat               수납상태                 
	 * <li>bldc_ordtype                진료형태                 
	 * <li>bldc_orddd                  진룡리자                 
	 * <li>bldc_orddeptcd              진료과코드               
	 * <li>bldc_orddrid                진료의사,주치의          
	 * <li>bldc_grupcalcscorcd         그룹수가코드             
	 * <li>bldc_snglcalcscorcd         싱글수가코드             
     * <li>bldc_appdd                  적용일자                 
	 * <li>bldc_calcqty                계산투여량               
	 * <li>bldc_calctims               계산투여횟수             
	 * <li>bldc_calcdays               계산투여일수             
	 * <li>bldc_calcamt                적용단가*1회량*횟수*일수 
	 * <li>bldc_disccnt                할인개수                 
	 * <li>bldc_discamt                할인금액                 
	 * <li>bldc_apprsn                 적용사유                 
	 * <li>bldc_rcptexecdd             수납수행일자             
	 * <li>bldc_rcpttm                 수납시간                 
	 * <li>bldc_rcptrid                수납자ID                 
	 * <li>bldc_calcseqno              계산일련번호             
	 * <li>bldc_calcscorseqno          수가별일련번호           
	 * <li>bldc_remfact                참고사항                 
	 * <li>bldc_fstrgstrid             최초등록자ID             
	 * <li>bldc_fstrgstdt              최초등록일시             
	 * <li>bldc_lastupdtrid            최종수정자ID             
	 * <li>bldc_lastupdtdt             최종수정일시             
	 * <li>bldc_orddd_org              외래등록일자_org         
	 * <li>bldc_orddeptcd_org          진료과코드_org           
	 * <li>bldc_orddrid_org            진료의ID_org             
	 * <li>bldc_rcptdd_org             영수일자_org             
	 * <li>bldc_rcptno_org             영수번호_org             
	 * <li>bldc_rcptseqno_org          영수순번_org                 
     * </ul>
     * @throws LiveException
     */
    public ValueObject getbldcList(ValueObject pVO) throws LiveException;

	/**
	 * 외래수납 2008/9/18 조영상
	 * 기 감면내역조회
	 * @author cys
	 * @param pVOs ValueObjectAssembler
	 * @return ValueObjectAssembler
	 * @throws LiveException
	 */
    public ValueObject getdcgmList(ValueObject pVO) throws LiveException;

	/**
	 * 외래수납 2008/9/19 조영상
	 * 기 미수내역조회
	 * @author cys
	 * @param pVOs ValueObjectAssembler
	 * @return ValueObjectAssembler
	 * @throws LiveException
	 */
    public ValueObject getuncoList(ValueObject pVO) throws LiveException;

	/**
	 * 외래수납 2008/9/22 조영상
	 * 환자재원정보
	 * @author cys
	 * @param pVOs ValueObjectAssembler
	 * @return ValueObjectAssembler
	 * @throws LiveException
	 */
    //public ValueObject getInptInfo(ValueObject pVO) throws LiveException;

	/**
     * 외래수납 중증시 보조유형변경
     * 2008.09.23. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int setOtptSrdg(ValueObject pVO) throws LiveException;

	/**
     * 외래수납 산정특례시 보조유형변경
     * 2008.09.23. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int setOtptEstm(ValueObject pVO) throws LiveException;

	/**
     * 외래수납 환자 인적정보 변경
     * 2008.11.20. updated by 조영상
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int setPtbsInfo(ValueObject pVO) throws LiveException;


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
    public ValueObject getOsclRY(ValueObject pVO) 
            throws LiveException;

	//0원 수납 인터페이스 - 진료비0원인지 체크
	public int getIFOAmtZeroCheck(ValueObject pVO) throws LiveException;

	//0원 수납 인터페이스 - 0원 수납처리
	public int setIFOAmtZeroRcpt(ValueObject pVO, String sUserId) throws LiveException;

	//0원 수납 인터페이스 - 0원수납 대상 물리치료 리스트 가져오기
	public ValueObject getMjquList(ValueObject pVO) throws LiveException;

	//0원 수납 인터페이스 - 실행
	public int setIFOAmtZeroRun(ValueObject pVO, String sUserId) throws LiveException;

	//0원 수납 인터페이스 - 선수금 환불
	public int setIFOAmtZeroRun_refund(ValueObject pVO, String sUserId) throws LiveException;

    //연속처방 수납대상 팝업 - 조회
    public ValueObjectAssembler getPopupMjquList(ValueObject pVO) throws LiveException;

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
	public ValueObject fSrdgInfoVeri_check(ValueObject pVO , String code, ValueObject srdgVO) throws LiveException;
	
	/**
     * <p>20090701 2.희귀난친성산정특례 고시적용</p>
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
	public ValueObject fRooaInfoVeri_check(ValueObject pVO , String code, String suppkind, String srchflag, ValueObject srdgVO) throws LiveException;

    //병원 정보코드 조회
    public ValueObject getHospcd(ValueObject pVO) throws LiveException;

    //수납vip 대기자조회
    public ValueObject getVipStandList(ValueObject pVO) throws LiveException;

    //당일 자격조회 유무 체크
    public ValueObject getMmsg2Check(ValueObject pVO) throws LiveException;

    //차상위환자 변환처리(업데이트 안함)
    public ValueObject getChgScnd(ValueObject pVO) throws LiveException;

    //차상위환자 여부체크
    public ValueObject getChkScnd(ValueObject pVO) throws LiveException;

    //차상위환자 변환처리(업데이트 포함)
    public int setOtptScnd(ValueObject pVO) throws LiveException;

    //연속처방 유무 체크
    public ValueObject getChkOtptMJ(ValueObject pVO) throws LiveException;

    //화면우측에 진료비 보여주기
    public ValueObject setSumOrdAmt(ValueObject pVO) throws LiveException;
    
	/**
     * <p>선택진료 등록 여부를 조회</p>
     *
     *@author 
     * @param pVO ValueObject
     * <p>req : 입력데이터
     * <ul>
     * <li>pid 등록번호
     * <li>orddd 진료일자
     * <li>orddrid 진료의
     * <li>orddeptcd 진료과코드
     * <li>instcd 기관기호
     * </ul>
     * @return ValueObject
     * <p>result : 출력데이터
     * <ul>
     * <li>rgstyn 등록여부
     * </ul>
     * @throws LiveException
     */
	public ValueObject getSpecOrdAppYN(ValueObject pVO) throws LiveException;

    //원무공통코드 (desc조회)
    public ValueObject getPmcmCode(ValueObject pVO) throws LiveException;

    //원무공통코드 (cdid조회)
    public ValueObject getPmcmCodeNm(String cdid) throws LiveException;

    //원무공통코드 (cdid조회)
    public ValueObject getPmcmCodeNm(String cdgrupid , String cdid) throws LiveException;

    //원무공통코드 (cdid조회)
    public ValueObject getPmcmCodeNm(String cdgrupid , String cdid , String sessinstcd) throws LiveException;

    //ZBCMCODE 공통코드조회
    public ValueObject getZbcmCode(String cdgrupid , String cdid) throws LiveException;

    //자보 , 산재 정보 조회
    public ValueObject checkJaboSanjaeInfo(ValueObject pVO) throws LiveException;
    
    //건보, 의보 자격 정보 조회
    public ValueObject checkInsuInfo(ValueObject pVO) throws LiveException;

    //중증체크 (무인수납,외래 수납버튼누를시 사용)
    public ValueObject  getChk_Srdg(ValueObject pVO) throws LiveException;
    
    //20090701 2.희귀난친성산정특례 고시적용
    public ValueObject  getChk_Rooa(ValueObject pVO, String sFlag) throws LiveException;

    //view인 대상 수가코드 체크[_,= 문자포함]
    public ValueObject getViewCalcChk(ValueObject pVO) throws LiveException;

    //실시정산용 실시일자테이블 입력
    public int setOutOrdActr(ValueObject pVO) throws LiveException;

    //실시정산용 실시일자테이블 삭제
    public int delOutOrdActr(ValueObject pVO) throws LiveException;

    //실시정산수납대상건 처방리스트
    public ValueObjectAssembler getPopupActrList(ValueObject pVO) throws LiveException;
    
    //실시정산수납대상건 처방리스트
    public ValueObject getPopupActrKiosk(ValueObject pVO) throws LiveException;
    
    //요율변경내역 조회
    public ValueObjectAssembler fUpdtRate_check(ValueObject pVO) throws LiveException;
    
    //장애인수첩소지여부 체크
    public ValueObject getHndcCnt(ValueObject pVO) throws LiveException;

    //환자연속처방내역조회 cys 20091015
    public ValueObject getExopActList(ValueObject pVO) throws LiveException;
    
    //장기이식환자여부 체크
    public ValueObject getTranInfo(ValueObject pVO) throws LiveException;

    //취소처리 케이스 체크 cys 20091110
    public boolean getCnclCase_Chk(ValueObject pVO) throws LiveException;
    
    //외래 환불금 선수금 처리
    public int insRtnBogj(ValueObject pVO) throws LiveException;

    //약국용 인터페이스 호출
    public ValueObjectAssembler getCallPharmlib(ValueObject pVO) throws LiveException;

    /**
     * <p>진료의뢰서 조회 pamcomn</p>
     * 
     * @author 
     * @param pVOs ValueObjectAssembler
     * <p>req : 입력데이터
     * <ul>
	 * <li>cnst_pid 환자등록번호	
	 * <ul>
     *  @return ValueObjectAssembler
	 * <p>
	 * <ul>
     * <li>cnst_pid 환자등록번호
     * <li>cnst_orddeptcd 진료과코드
     * <li>cnst_insuflag 보호/보험구분
     * <li>cnst_ordreqkind 진료의뢰서 종류
     * <li>cnst_todd 종료일자
     * <li>cnst_seqno 일련번호
     * <li>cnst_instcd 기관코드
     * <li>cnst_histstat 이력상태
     * <li>cnst_fromdd 시작일자
     * <li>cnst_reqformhospnm 의뢰병원명
     * <li>cnst_reqformdrnm 의뢰의사명
     * <li>cnst_remfact 비고
     * <li>cnst_fstrgstrid 최초등록자ID
     * <li>cnst_fstrgstdt 최초등록일시
     * <li>cnst_lastupdtrid 최종수정자ID
     * <li>cnst_lastupdtdt 최종수정일시
     * </ul>
     * @return ValueObjectAssembler
     * @throws LiveException
     */
	public ValueObject getCnst(ValueObject pVOs) throws LiveException;    
 
	//원무수납에서 원외처방전 출력기능
	public ValueObject getHosoOutOrderList(ValueObject pVOs) throws LiveException; 
    
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

    //처방특진여부 N으로 변경 20110401 cys
    public int setChngSpecN(ValueObject pVO) throws LiveException;

    //처방특진여부 원복 20110401 cys
    public int setChngSpecR(ValueObject pVO) throws LiveException;
    
    public ValueObject getUncoAmtSMSDetlSpec(ValueObject pVO) throws LiveException;
    
    public ValueObject getUncoAmtSMSMsg(ValueObject pVO) throws LiveException;
    
    public ValueObject getUncoAmtSMSSpec(ValueObject pVO) throws LiveException;
    
    public ValueObject getUncoAmtSMSTrsmSpec(ValueObject pVO) throws LiveException;
    
    public int setUncoAmtSMSTrsm(ValueObject pVO) throws LiveException;
    
    public ValueObject getDiscListChk(ValueObject pVO) throws LiveException;
    
    /**
     * 장기기증 WorkUp 환자 상병체크
     * 
     * @param pVO
     * @return ValueObject
     * @throws LiveException
     */
    public ValueObject getCheckWorkUpDiag(ValueObject pVO) throws LiveException;
}


