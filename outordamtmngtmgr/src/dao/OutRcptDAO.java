/**
 * @(#) OutRcptDAO.java
 *�����̷�
 * 		- 2007. 4. 02 / �����ۼ� / �����
 */
package himed.his.pam.outordamtmngtmgr.outrcptmgt.dao;

import kr.co.hit.live.exception.LiveException;
import kr.co.hit.live.vo.ValueObject;

/**
 *  <P> �ܷ����� DAO Interface Class</P>
 *  �ܷ�����/�ܷ������ݼ����� �����ͺ��̽����� ��ȸ, ��� ����� �����Ѵ�.
 *  
 *  @author  �����
 *  @version 1.0  2007. 4. 02
 */
public interface OutRcptDAO {
	
	/**
	 * <p>�ܷ��߰���(������)���� ��ȸ</p>
	 * DB ���� �ܷ��߰���(������)������ȸ.
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>pid 				��Ϲ�ȣ 
	 * <li>srchcond 		��ȸ����
	 * </ul>
	 * @return ValueObject
	 * <p>mdlamtspec : ��µ�����
	 * <ul>
	 * <li>rcptflag 		��������       
	 * <li>rcptexecdd		��������       
	 * <li>rcpttm			�����ð�       
	 * <li>cashamt			���ݱݾ�       
	 * <li>cardamt			ī��ݾ�       
	 * <li>onlineamt		�¶��αݾ�     
	 * <li>rcptid			������ID       
	 * <li>remfact			�������       
	 * <li>rcptdd			��������       
	 * <li>rcptno			��������ȣ     
	 * <li>rcptseqno		�������Ϸù�ȣ 
	 * <li>seqno			�Ϸù�ȣ       
	 * <li>instcd			����ڵ�       
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getMdlAmtList(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>ī������� ��ȸ</p>
	 * ī������� ��ȸ
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>pid 				��Ϲ�ȣ 
	 * <li>ordtype 			��������
	 * <li>preamtyn			�����ݿ���
	 * </ul>
	 * @return ValueObject
	 * <p>cardlist	 : ��µ�����
	 * <ul>
	 * <li>rcptdd		��������      
	 * <li>rcptno		��������ȣ    
	 * <li>rcptseqno	�������Ϸù�ȣ
	 * <li>seqno		�Ϸù�ȣ      
	 * <li>instcd		����ڵ�      
	 * <li>rcpstat		��������      
	 * <li>ordtype		��������      
	 * <li>keyinptflag	Ű�Է±���    
	 * <li>cardcmpycd	ī����ڵ�    
	 * <li>cardno		ī���ȣ      
	 * <li>aprvflag		���α���      
	 * <li>aprvdd		��������      
	 * <li>aprvtm		���νð�	
	 * <li>aprvno		���ι�ȣ      
	 * <li>vancd		van�ڵ�       
	 * <li>allotmm		�Һΰ�����    
	 * <li>cardamt		ī��ݾ�      
	 * <li>valiterm		��ȿ�Ⱓ      
	 * <li>rcptexecdd	��������      
	 * <li>rcpttm		�����ð�      
	 * <li>rcptid	 	������ID      
	 * <li>remfact		�������      
	 * </ul>
	 * @throws LiveException
	 */
	public ValueObject getCardAmtList(ValueObject pVO) throws LiveException;


	/**
	 * <p>���ݿ����������� ��ȸ</p>
	 * ���ݿ����������� ��ȸ
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>pid 			��Ϲ�ȣ 
	 * <li>ordtype 		��������
	 * <li>preamtyn		�����ݿ���
	 * </ul>
	 * @return ValueObject
	 * <p>cashlist	 : ��µ�����
	 * <ul>
	 * <li>rcptdd		��������       
	 * <li>rcptno		��������ȣ     
	 * <li>rcptseqno	�������Ϸù�ȣ 
	 * <li>seqno		�Ϸù�ȣ       
	 * <li>instcd		����ڵ�       
	 * <li>rcpstat		��������       
	 * <li>ordtype		��������       
	 * <li>qualcnfmflag	Ű�Է±���     
	 * <li>qualcnfmno 	ī����ڵ�     
	 * <li>aprvflag		���α���       
	 * <li>aprvdd		��������       
	 * <li>aprvtm		���νð�	
	 * <li>aprvno		���ι�ȣ       
	 * <li>cashamt		���ݱݾ�       
	 * <li>rcptexecdd	��������       
	 * <li>rcpttm		�����ð�       
	 * <li>rcptid	 	������ID       
	 * <li>remfact		�������       
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getCashAmtList(ValueObject pVO) throws LiveException;

	
	/**
	 * <p>�¶����Աݼ����� ��ȸ</p>
	 * �¶����Աݼ����� ��ȸ
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>pid 				��Ϲ�ȣ 
	 * <li>ordtype 			��������
	 * <li>preamtyn			�����ݿ���
	 * </ul>
	 * @return ValueObject
	 * <p>onlinelist	 : ��µ�����
	 * <ul>
	 * <li>rcptdd		��������       
	 * <li>rcptno		��������ȣ     
	 * <li>rcptseqno	�������Ϸù�ȣ 
	 * <li>seqno		�Ϸù�ȣ       
	 * <li>instcd		����ڵ�       
	 * <li>rcpstat		��������       
	 * <li>ordtype		��������       
	 * <li>bankcd		�����ڵ�       
	 * <li>acntno		���¹�ȣ       
	 * <li>paydd		�Ա�����       
	 * <li>paypsnnm		�Ա��ڸ�       
	 * <li>onlineamt	�¶��αݾ�     
	 * <li>rcptexecdd	��������       
	 * <li>rcpttm		�����ð�       
	 * <li>rcptid	 	������ID       
	 * <li>remfact		�������       
	 * </ul>
	 * @throws LiveException
	 */
	public ValueObject getOnlineAmtList(ValueObject pVO) throws LiveException;

	
	/**
	 * <p>�ܷ������� �ܾ� ��ȸ</p>
	 * �ܷ������� �ܾ� ��ȸ
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>pid 			��Ϲ�ȣ 
	 * <li>srchcond		��ȸ����
	 * </ul>
	 * @return ValueObject
	 * <p>remamt	 : �ܷ������� �ܾ�
	 * <ul>
	 * <li>remamt		�ܾ�
	 * </ul>
	 * @throws LiveException
	 */
	public ValueObject getMdlRemAmt(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>�ܷ�������ȭ�� �ܾ� ��ȸ</p>
	 * �ܷ�������ȭ�� �ܾ� ��ȸ
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>pid 			��Ϲ�ȣ 
	 * <li>srchcond		��ȸ����
	 * </ul>
	 * @return ValueObject
	 * <p>remamt	 : �ܷ������� �ܾ�
	 * <ul>
	 * <li>remamt		�ܾ�
	 * </ul>
	 * @throws LiveException
	 */
	public ValueObject getMdlRemAmt2(ValueObject pVO) throws LiveException;


	/**
	 * <p>��������ȣ ��ȸ</p>
	 * ��������ȣ ��ȸ
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>rcptdd 			��������
	 * </ul>
	 * @return ValueObject
	 * <p>rcptno	 : 		��µ�����
	 * <ul>
	 * <li>rcptno			��������ȣ
	 * </ul>
	 * @throws LiveException
	 */
	public ValueObject getRcptNo(ValueObject pVO) throws LiveException;
	
	
	/**
	 * <p>�ܷ��߰���(������) ���� ó��</p>
	 * �ܷ��߰���(������) ����ó��
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>pid   		��Ϲ�ȣ 	
	 * <li>rcptdd   	�������� 	
	 * <li>rcptno   	��������ȣ 	
	 * <li>rcptseqno   	�������Ϸù�ȣ	
	 * <li>seqno   		�Ϸù�ȣ	
	 * <li>instcd   	����ڵ�	
	 * <li>rcptstat   	��������	
	 * <li>ordtype   	��������	
	 * <li>rcptflag   	��������	
	 * <li>cashamt   	���ݱݾ�	
	 * <li>cardamt   	ī��ݾ�	
	 * <li>onlineamt   	�¶��αݾ�	
	 * <li>rcptexecdd  	��������	
	 * <li>rcpttm   	�����ð�	
	 * <li>rcptid   	������ID	
	 * <li>remfact   	�������	
	 * <li>fstrgstrid   ���ʵ����	
	 * <li>fstrgstdt   	���ʵ���Ͻ�	
	 * <li>lastupdtrid  ����������	
	 * <li>lastupdtdt   ���������Ͻ�    
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */

	public int insMdlAmt(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>�¶����Ա� ���� ó��</p>
	 * �¶����Ա� ����ó��
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>online : �Էµ�����
	 * <ul>
	 * <li>pid   		��Ϲ�ȣ 		
	 * <li>rcptdd   	�������� 		
	 * <li>rcptno   	��������ȣ 		
	 * <li>rcptseqno   	�������Ϸù�ȣ	  
	 * <li>seqno   		�Ϸù�ȣ		
	 * <li>instcd   	����ڵ�		
	 * <li>rcptstat   	��������		
	 * <li>ordtype   	��������		
	 * <li>onlineamt   	�¶��αݾ�        
	 * <li>bankcd		�����ڵ�          
	 * <li>acntno		���¹�ȣ		
	 * <li>paydd		�Ա�����          
	 * <li>paypsnnm		�Ա��ڸ�          
	 * <li>rcptexecdd  	��������		
	 * <li>rcpttm   	�����ð�		
	 * <li>rcptrid   	������ID	  
	 * <li>preamtyn		�����ݿ���        
	 * <li>innrtretyn	����ó������      
	 * <li>remfact   	�������		
	 * <li>fstrgstrid   ���ʵ����		
	 * <li>fstrgstdt   	���ʵ���Ͻ�	  
	 * <li>lastupdtrid  ����������		
	 * <li>lastupdtdt   ���������Ͻ�      
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */

	public int insOnlineAmt(ValueObject pVO) throws LiveException;

	
	/**
	 * <p>�¶����Ա� ������� ó��</p>
	 * �¶����Ա� ������� ó��
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>online : �Էµ�����
	 * <ul>
	 * <li>pid   		��Ϲ�ȣ 		
	 * <li>rcptdd   	�������� 		
	 * <li>rcptno   	��������ȣ 		
	 * <li>rcptseqno   	�������Ϸù�ȣ	 
	 * <li>seqno   		�Ϸù�ȣ		
	 * <li>instcd   	����ڵ�		
	 * <li>rcptstat   	��������		
	 * <li>ordtype   	��������		
	 * <li>onlineamt   	�¶��αݾ�       
	 * <li>bankcd		�����ڵ�         
	 * <li>acntno		���¹�ȣ		
	 * <li>paydd		�Ա�����         
	 * <li>paypsnnm		�Ա��ڸ�         
	 * <li>rcptexecdd  	��������		
	 * <li>rcpttm   	�����ð�		
	 * <li>rcptrid   	������ID	 
	 * <li>preamtyn		�����ݿ���       
	 * <li>innrtretyn	����ó������     
	 * <li>remfact   	�������		
	 * <li>fstrgstrid   ���ʵ����		
	 * <li>fstrgstdt   	���ʵ���Ͻ�	 
	 * <li>lastupdtrid  ����������		
	 * <li>lastupdtdt   ���������Ͻ�     
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */

	public int setOnlineAmt(ValueObject pVO) throws LiveException;
	
	
	/**
	 * <p>��������ȣ update</p>
	 * ���� ��������ȣ�� updateó��
	 * 
	 *
	 * @param pVO ValueObject	
	 * <p>req : �Էµ�����
	 * <ul>	  		
	 * <li>rcptdd   			�������� 		
	 * <li>rcptno   			��������ȣ	 
 	 * </ul>
	 * @return  int
	 * @throws LiveException
	 */

	public int setRcptNo(ValueObject pVO) throws LiveException;

	/**
	 * <p>��������ȣ update</p>
	 * ���� ��������ȣ�� insertó��
	 * 
	 *
	 * @param pVO ValueObject	
	 * <p>req : �Էµ�����
	 * <ul>	  		
	 * <li>rcptdd   			�������� 		
	 * <li>rcptno   			��������ȣ	 
 	 * </ul>
	 * @return  int
	 * @throws LiveException
	 */

	public int insRcptNo(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>��곻���� �������� update</p>
	 * ������ ���������� ���� ��곻�� ��������,��������(����,����) update
	 * 
	 *
	 * @param pVO ValueObject	
	 * <p>opmi : �Էµ�����
	 * <ul>	  		
	 * <li>rcptdd   		�������� 	
	 * <li>rcptexecdd   	�������� 	
	 * <li>rcptno   		��������ȣ	
	 * <li>rcptseqno   		�����Ϸù�ȣ 	
	 * <li>rcptstat   		�������� 	
 	 * </ul>
	 * @return  int
	 * @throws LiveException
	 */

	public int setOutOrdAmtOscl(ValueObject pVO) throws LiveException;

	/**
	 * <p>�ܷ���ϳ����� �������� update</p>
	 * ������ ���������� ���� �ܷ���ϳ��� ��������,��������(����,����) update
	 * 
	 *
	 * @param pVO ValueObject	
	 * <p>opmi : �Էµ�����
	 * <ul>	  		
	 * <li>rcptdd   		�������� 	
	 * <li>rcptexecdd   	�������� 	
	 * <li>rcptno   		��������ȣ	 
	 * <li>rcptseqno   		�����Ϸù�ȣ 	
	 * <li>rcptstat   		�������� 	
 	 * </ul>				              
	 * @return  int
	 * @throws LiveException
	 */

	public int setOutOrdAmtOtpt(ValueObject pVO) throws LiveException;

	
	/**
	 * <p>�ܷ�ó�泻���� ó����� update</p>
	 * �ܷ�ó�泻���� ���� �ܷ���ϳ��� ��������,��������(����,����) update
	 * 
	 *
	 * @param pVO ValueObject	
	 * <p>opmi : �Էµ�����
	 * <ul>	  		
	 * <li>rcptdd   		��������        	
	 * <li>rcptexecdd   	�������� 	
	 * <li>rcptno   		��������ȣ      	 
	 * <li>rcptseqno   		�����Ϸù�ȣ    	
	 * <li>rcptstat   		��������        	
 	 * </ul>				                
	 * @return  int
	 * @throws LiveException
	 */

	public int setOutOrdStat(ValueObject pVO) throws LiveException;
	
	
	/**
	 * <p>�ܷ���ϳ��� ��ȸ(�ܷ�����)</p>
	 * �ܷ���ϳ��� ��ȸ(�ܷ�����)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>pid 				��Ϲ�ȣ
	 * <li>srchcond	��ȸ����
	 * </ul>
	 * @return ValueObject
	 * <p>rcptno	 : 		��µ�����
	 * <ul>
	 * <li>orddd			��������    
	 * <li>ordtm			����ð�    
	 * <li>orddept			�����      
	 * <li>orddr			������      
	 * <li>fsexamflag		����������  
	 * <li>indukind			��������    
	 * <li>suppkind			��������    
	 * </ul>
	 * @throws LiveException
	 */		
	public ValueObject getOutRgstList(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>�ܷ���ϳ��� ��ȸ(���μ���)</p>
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>pid 				��Ϲ�ȣ
	 * </ul>
	 * @return ValueObject
	 * <p>otpt	 : 		��µ�����
	 * <ul>
	 * <li>orddd			��������    
	 * <li>ordtm			����ð�    
	 * <li>orddept			�����      
	 * <li>orddr			������      
	 * <li>fsexamflag		����������  
	 * <li>indukind			��������    
	 * <li>suppkind			��������    
	 * </ul>
	 * @throws LiveException
	 */		
	public ValueObject getOutRgstList2(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>�������� ��ȸ(����ȭ��)</p>
	 * �������� ��ȸ(����ȭ��)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �������� ��ȸ����
	 * <ul>
	 * <li>pid 				��Ϲ�ȣ 
	 * <li>insukind 		��������
	 * <li>insucd			�������ڵ�
	 * <li>appdd			��������
	 * </ul>
	 * @return ValueObject
	 * <p>ptin	 : ��������
	 * <ul>
	 * <li>insukind			��������         
	 * <li>insucd			�������ڵ�       
	 * <li>insuno			��������ȣ       
	 * <li>insdrela			�Ǻ����ڿ��ǰ��� 
	 * <li>insdnm			�Ǻ����ڸ�       
	 * <li>insdrrgstno1		�Ǻ������ֹι�ȣ1
	 * <li>insdrrgstno2		�Ǻ������ֹι�ȣ2
	 * <li>fromdd			��������         
	 * <li>todd				��������         
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getInsuInfo(ValueObject pVO) throws LiveException;

	/**
	 * <p>�������� ��ȸ(����ȭ��)</p>
	 * �������� ��ȸ(����ȭ��)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �������� ��ȸ����
	 * <ul>
	 * <li>pid 				��Ϲ�ȣ 
	 * <li>insukind 		��������
	 * <li>insucd			�������ڵ�
	 * <li>appdd			��������
	 * </ul>
	 * @return ValueObject
	 * <p>srdg	 : ��������
	 * <ul>
	 * <li>pid     			��Ϲ�ȣ
     * <li>insuflag     	���豸��
     * <li>suppkind     	��������
     * <li>todd     		��������
     * <li>fromdd   		��������
     * <li>seridiagno     	������ȣ
     * <li>apppsnnm     	��û��
	 * <li>rela     		��û�ڿ��ǰ���
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getSrdgInfo(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>�ں��ڰ����� ��ȸ(����ȭ��)</p>
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �ں��ڰ����� ��ȸ����
	 * <ul>
	 * <li>pid 				��Ϲ�ȣ 
	 * <li>appdd			��������
	 * </ul>
	 * @return ValueObject
	 * <p>aipm	 : �ں��ڰ�����
	 * <ul>
	 * <li>pid     			��Ϲ�ȣ
     * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getAipmInfo(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>�����ڰ����� ��ȸ(����ȭ��)</p>
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �����ڰ����� ��ȸ����
	 * <ul>
	 * <li>pid 				��Ϲ�ȣ 
	 * <li>appdd			��������
	 * </ul>
	 * @return ValueObject
	 * <p>icpm	 : �����ڰ�����
	 * <ul>
	 * <li>pid     			��Ϲ�ȣ
     * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getIcpmInfo(ValueObject pVO) throws LiveException;

	
	/**
	 * <p>ȯ�ڰ������ ��ȸ(����ȭ��)</p>
	 * ������� ��ȸ(����ȭ��)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : ȯ�ڰ������ ��ȸ����
	 * <ul>
	 * <li>pid 				��Ϲ�ȣ 
	 * <li>orddd 			��������
	 * <li>cretno			������ȣ
	 * <li>acptseqno		�ܷ�����Ϸù�ȣ
	 * </ul>
	 * @return ValueObject
	 * <p>oscl	 : ȯ�� ������� ��ȸ
	 * <ul>
	 * <li>pid     			��Ϲ�ȣ                             
     * <li>orddd     		�ܷ��������                         
     * <li>cretno     		�ܷ���ϻ�����ȣ                     
     * <li>calcseqno   		����Ϸù�ȣ                         
     * <li>calcscorseqno    �������,��곻���� �Ϸù�ȣ       
     * <li>instcd     		����ڵ�                             
	 * <li>calcstat			������                             
	 * <li>clamtrgtstat		û��������                         
	 * <li>acptseqno		�ܷ���ϻ�����ȣ���Ϸù�ȣ           
	 * <li>orddeptcd		������ڵ�                           
	 * <li>orddrid			�����ǻ�                             
	 * <li>mskind			�ֺ�����                             
	 * <li>ordtype			��������                             
	 * <li>grupcalcscorcd	�׷�����ڵ�                         
	 * <li>snglcalcscorcd	�̱ۼ����ڵ�                         
	 * <li>grupcalcscorcls	�׷�����з�                         
	 * <li>snglcalcscorcls	�̱ۼ����з�                         
	 * <li>grupearncls		�׷���ͺз�                         
	 * <li>snglearncls		�̱ۼ��ͺз�                         
	 * <li>ordqty			ó������������                       
	 * <li>ordtims			ó����������Ƚ��                     
	 * <li>orddays			ó�����������ϼ�                     
	 * <li>calcqty			���������                           
	 * <li>calctims			�������Ƚ��                         
	 * <li>calcdays			��������ϼ�                         
	 * <li>matractflag		�����������                         
	 * <li>calcpayflag		�޿�����                             
	 * <li>prcppayflag		ó��޿�����                         
	 * <li>calcscorpayflag	�����޿�����2                        
	 * <li>ansttm			����ð�                             
	 * <li>spccd			��ü�ڵ�                             
	 * <li>pntunitcost		����ܰ�                             
	 * <li>calcscorpnt		��������                             
	 * <li>estmpnt			��������                             
	 * <li>appunitcost		�ܰ�                                 
	 * <li>estmamt			�����ݾ�                             
	 * ...							                     
	 * <li>fstrgstrid		���ʵ����                           
	 * <li>fstrgstdt		���ʵ���Ͻ�                         
	 * <li>lastupdtrid		���������                           
	 * <li>lastupdtdt		��������Ͻ�                         
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getOsclInfo(ValueObject pVO) throws LiveException;

	/**
	 * <p>ȯ�ڰ������ ��ȸ(����ȭ��)</p>
	 * ������� ��ȸ(����ȭ��)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>otpt : ���ܾ����翩�� üũ
	 * <ul>
	 * <li>pid 				��Ϲ�ȣ 
	 * <li>orddd 			��������
	 * <li>cretno			������ȣ
	 * <li>acptseqno		�ܷ�����Ϸù�ȣ
	 * </ul>
	 * @return ValueObject
	 * <p>opmi	 : 			���ܾ����翩�� üũ
	 * <ul>
	 * <li>pid     			��Ϲ�ȣ
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getOutOrdExist(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>�����ȯ�ڿ���  ��ȸ</p>
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>otpt : ȯ������
	 * <ul>
	 * <li>pid 				��Ϲ�ȣ 
	 * </ul>
	 * @return ValueObject
	 * <p>opmi	 : 			�����ȯ�ڿ��� ��ȸ
	 * <ul>
	 * <li>handicapyn     	�����ȯ�ڿ���
	 * </ul>
	 * @throws LiveException
	 */
	public ValueObject getHandicapYN(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>����ó�� �ܷ���� �Ǵ� �Ϲ� �ܷ������ �� ORDDD  ��ȸ - �౹�����</p>
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>opmi : ȯ������
	 * <ul>
	 * <li>pid 					��Ϲ�ȣ 
	 * <li>orddd (actingorddd)	��������
	 * <li>cretno 				������ȣ
	 * </ul>
	 * @return ValueObject
	 * <p>pharm	 : 				����ó�� �ܷ���� �Ǵ� �Ϲ� �ܷ������ �� ORDDD  ��ȸ - �౹�����
	 * <ul>
	 * <li>orddd     			ORDDD
	 * </ul>
	 * @throws LiveException
	 */
	public ValueObject getOrddd(ValueObject pVO) throws LiveException;
	
	
	/**
	 * <p>��곻���� ���� ��������� ��ȸ(����ȭ��)</p>
	 * ��곻���� ���� ��������� ��ȸ(����ȭ��)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>otpt : �������� ��ȸ����
	 * <ul>
	 * <li>insukind 		�������� 
	 * <li>suppkind 		��������
	 * </ul>
	 * @return ValueObject
	 * <p>tempinsu	 : ���������� ���� �δ�� ��ȸ
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
	 * <p>��곻���� ���� ��������� ��ȸ(����ȭ��)</p>
	 * ��곻���� ���� ��������� ��ȸ(����ȭ��)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : ��곻���� ���� ����� ���� ��ȸ����
	 * <ul>
	 * <li>pid 				��Ϲ�ȣ 
	 * <li>orddd 			��������
	 * <li>cretno			������ȣ
	 * <li>acptseqno		�ܷ�����Ϸù�ȣ
	 * </ul>
	 * @return ValueObject
	 * <p>opmi	 :  ��곻���� ���� ����� ���� ��ȸ
	 * <ul>
     * <li>payamt			�޿��ݾ�                    
     * <li>nopyamt   		��޿���                    
     * <li>allownbamt 		�����(���׺��κδ��)    
     * <li>specamt   		����������Ѿ�              
     * <li>totownbamt   	�Ѻ��κδ��                
     * <li>handcapfund   	����α��                  
     * <li>subtamt   		��Ҿ�                      
     * <li>bloddiscamt   	������ü��                  
     * <li>discreduamt   	����(����+����)             
     * <li>uncoamt   		�̼���                      
     * <li>precashamt   	�����ݾ�                    
     * <li>premdlrcptamt  	�⼱����                    
     * <li>precardamt   	��ī��ݾ�                  
     * <li>preonlineamt   	��¶��αݾ�                
     * <li>mdlrcptamt   	������                      
     * <li>rcptexptamt   	������ �ݾ�                 
     * <li>cardamt   		ī��ݾ�                    
     * <li>cashamt   		���ݱݾ�                    
     * <li>onlineamt   		�����Աݾ�                  
     * <li>paypsnflag   	������                      
     * <li>payrem   		�����ڱ�Ÿ����              
     * <li>instcd     		����ڵ�                    
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getOpmiInfoFromOscl(ValueObject pVO) throws LiveException;
	
	
	/**
	 * <p>������� ���� ��ȸ(����ȭ��)</p>
	 * ������� ���� ��ȸ(����ȭ��)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : ������� ��ȸ
	 * <ul>
	 * <li>pid 				��Ϲ�ȣ 
	 * <li>orddd 			��������
	 * <li>cretno			������ȣ
	 * <li>acptseqno		�ܷ�����Ϸù�ȣ
	 * </ul>
	 * @return ValueObject
	 * <p>opmi	 :  ���������ȸ
	 * <ul>
     * <li>precashamt   	�����ݾ�
     * <li>premdlrcptamt  	�⼱����
     * <li>precardamt   	��ī��ݾ�
     * <li>preonlineamt   	��¶��αݾ�
     * <li>mdlrcptamt   	������
     * <li>instcd     		����ڵ�
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getPreOpmiInfo(ValueObject pVO) throws LiveException;

	/**
	 * <p>�ܷ��߰���(������) ���� ��� ó��</p>
	 * �ܷ��߰���(������) ������� ó��
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>pid   			��Ϲ�ȣ 		
	 * <li>rcptdd   		�������� 		
	 * <li>rcptno   		��������ȣ 		
	 * <li>rcptseqno   		�������Ϸù�ȣ	
	 * <li>seqno   			�Ϸù�ȣ		
	 * <li>instcd   		����ڵ�		
	 * <li>rcptstat   		��������		
	 * <li>ordtype   		��������		
	 * <li>rcptflag   		��������		
	 * <li>cashamt   		���ݱݾ�		
	 * <li>cardamt   		ī��ݾ�		
	 * <li>onlineamt   		�¶��αݾ�		
	 * <li>rcptexecdd  		��������		
	 * <li>rcpttm   		�����ð�		
	 * <li>rcptid   		������ID		
	 * <li>remfact   		�������		
	 * <li>fstrgstrid   	���ʵ����		
	 * <li>fstrgstdt   		���ʵ���Ͻ�	
	 * <li>lastupdtrid   	����������		
	 * <li>lastupdtdt   	���������Ͻ�
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */

	public int setMdlAmt(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>�ܷ� ���� ó��</p>
	 * �ܷ� ����ó��
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
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
	 * <p>�������� ���� ��ȸ </p>
	 * ��������, ���γ���, �ܷ���ϳ���(����������,�������ᱸ��,������������� ��)
	 * ���� �������� ���� üũ�Ͽ� ���걸�� ��ȸ(return)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>Checkin : �Էµ�����
	 * <ul>
	 * <li>insukind 		��������                                                                            
	 * <li>suppkind 		��������                                                                            
	 * <li>insucd 			�������ڵ�                                                                          
	 * <li>disccd 			�����ڵ�                                                                            
	 * <li>specordyn		�������Ῡ��                                                                        
	 * <li>fsexamflag		����������                                                                          
	 * <li>fsexammanlyn		�����������ο�����                                                                  
	 * <li>medamtestmyn	    �������������                                                                      
	 * <li>medamtpostyn		�������ĺҿ���                                                                      
	 * <li>medamtfreeresn	������������� ������ �������ΰ� N=�̻���,�����϶� �̻��� ����(�ڵ屺 P1061 ����)				
	 * <li>etcordflag		��Ÿ���ᱸ��(�ڵ屺 P0022 ����) J:�ֻ�  M:����ġ��, F:����, N:������ȣ              
	 * </ul>
	 * @return ValueObject
	 * <p>Checkout	 : 		��µ�����
	 * <ul>
	 * <li>calcyn			���꿩��
	 * </ul>
	 * @throws LiveException
	 */	
	//public ValueObject getChangelist(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>�ܷ���ϳ��� �̷��߰� </p>
	 * �ܷ���ϳ����� �̷��߰� �� �������� �̷»��� ����
	 * 
	 * @param pVO ValueObject
	 * <p>pVO : �Էµ�����
	 * <ul>
	 * <li>insukind 		��������                                                                          
	 * <li>suppkind 		��������                                                                          
	 * <li>insucd 			�������ڵ�                                                                        
	 * <li>disccd 			�����ڵ�                                                                          
	 * <li>specordyn		�������Ῡ��                                                                      
	 * <li>fsexamflag		����������                                                                        
	 * <li>fsexammanlyn		�����������ο�����                                                                
	 * <li>medamtestmyn	    �������������                                                                    
	 * <li>medamtpostyn		�������ĺҿ���                                                                    
	 * <li>medamtfreeresn	������������� ������ �������ΰ� N=�̻���,�����϶� �̻��� ����(�ڵ屺 P1061 ����)				
	 * <li>etcordflag		��Ÿ���ᱸ��(�ڵ屺 P0022 ����) J:�ֻ�  M:����ġ��, F:����, N:������ȣ            
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */	
	public int insOtptHistAdd(ValueObject pVO) throws LiveException;
	
	
	/**
	 * <p>�ܷ���ϳ��� �̷��߰� </p>
	 * �ܷ���ϳ����� �̷��߰� �� �������� �̷»��� ����
	 * 
	 * @param pVO ValueObject
	 * <p>pVO : �Էµ�����
	 * <ul>
	 * <li>insukind 		��������                                                                          
	 * <li>suppkind 		��������                                                                          
	 * <li>insucd 			�������ڵ�                                                                        
	 * <li>disccd 			�����ڵ�                                                                          
	 * <li>specordyn		�������Ῡ��                                                                      
	 * <li>fsexamflag		����������                                                                        
	 * <li>fsexammanlyn		�����������ο�����                                                                
	 * <li>medamtestmyn	    �������������                                                                    
	 * <li>medamtpostyn		�������ĺҿ���                                                                    
	 * <li>medamtfreeresn	������������� ������ �������ΰ� N=�̻���,�����϶� �̻��� ����(�ڵ屺 P1061 ����)					
	 * <li>etcordflag		��Ÿ���ᱸ��(�ڵ屺 P0022 ����) J:�ֻ�  M:����ġ��, F:����, N:������ȣ            
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */	
	public int insOtptHistAddCancel(ValueObject pVO) throws LiveException;	
	
	
	/**
	 * <p>�������� ���� ��ȸ </p>
	 * ��������, ���γ���, �ܷ���ϳ���(����������,�������ᱸ��,������������� ��)
	 * ���� �������� ���� üũ�Ͽ� ���걸�� ��ȸ(return)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>pVO : �Էµ�����
	 * <ul>
	 * <li>pid 				��Ϲ�ȣ
	 * <li>orddd 			��������
	 * <li>cretno 			������ȣ
	 * <li>instcd 			�����ȣ
	 * </ul>
	 * @return ValueObject
	 * <p>retVO	 : 			��µ�����
	 * <ul>
	 * <li>pid 				��Ϲ�ȣ
	 * <li>orddd 			��������
	 * <li>cretno 			������ȣ
	 * <li>instcd 			�����ȣ
	 * <li>....  
	 * <li>lastupdtrid	    ����������ID
	 * <li>lastupdtdt		���������Ͻ�
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getLastOtpt(ValueObject pVO) throws LiveException;

	/**
	 * <p>�������� �̷��߰� </p>
	 * ���� �Էµ� ���������� �̷��߰� �� �������� �̷»��� ����
	 * 
	 * @param pVO ValueObject
	 * <p>pVO : �Էµ�����
	 * <ul>
	 * <li>insukind 			��������
	 * <li>suppkind 			��������
	 * <li>insucd 				�������ڵ�
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */	
	public int insPtinHistAdd(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>�������� �̷��߰� </p>
	 * ���� �Էµ� ���������� �̷��߰� �� �������� �̷»��� ����
	 * 
	 * @param pVO ValueObject
	 * <p>pVO : �Էµ�����
	 * <ul>
	 * <li>disccd 				�����ڵ�
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */	
	public int insPtdcHistAdd(ValueObject pVO) throws LiveException;
	
	
	/**
	 * <p>ȯ��������ȸ(����ȭ��)</p>
	 * ȯ��������ȸ(����ȭ��)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>srchcond 		��ȸ����	 
	 * <li>pid 				��Ϲ�ȣ	 
	 * <li>hngnm 			�ѱ��̸�	 
	 * <li>rrgstno1 		�ֹι�ȣ1	 
	 * <li>rrgstno2 		�ֹι�ȣ2	 
	 * </ul>
	 * @return ValueObject
	 * <p>ptbs		 : ��µ�����
	 * <ul>
	 * <li>pid 				��Ϲ�ȣ	 
	 * <li>hngnm 			�ѱ��̸�	 
	 * <li>...
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getPatInfo(ValueObject pVO) throws LiveException;


	/**
	 * <p>����ȸ(�ܷ�����ȭ��)</p>
	 * ����ȸ(�ܷ�����ȭ��)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>pid   		��Ϲ�ȣ
	 * <li>orddd		��������
	 * <li>cretno		������ȣ
 	 * </ul>
	 * @return ValueObject
	 * <p>diag : ��µ�����
	 * <ul>
	 * <li>diagcd		���ڵ�
	 * <li>diagcdnm		�󺴸�
	 * <li>orddd		��������
	 * <li>chrncsickyn	����������
	 * </ul>  
	 * @throws LiveException
	 */
	public ValueObject getPatDiag(ValueObject pVO) throws LiveException;
	
	
	/**
	 * <p>�ܷ�����������ȸ(�ܷ�����ȭ��)</p>
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>pid   		��Ϲ�ȣ
	 * <li>orddd		��������
	 * <li>cretno		������ȣ
	 * <li>orddeptcd	�����
	 * <li>orddrid		�����ǻ�
	 * <li>srchcond		��ȸ����
 	 * </ul>
	 * @return ValueObject
	 * <p>diag : ��µ�����
	 * <ul>
	 * <li>pid					��Ϲ�ȣ
	 * <li>rcptdd				��������
	 * <li>....
	 * <li>lastupdtdt			������������
	 * </ul>  
	 * @throws LiveException
	 */
	public ValueObject getopmiList3(ValueObject pVO) throws LiveException;

	
	/**
	 * <p>�ܷ���ϳ�����ȸ(�ܷ�����ȭ��)</p>
	 * �ܷ���ϳ�����ȸ(�ܷ�����ȭ��)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>opmi : �Էµ�����
	 * <ul>
	 * <li>opmi_pid   			��Ϲ�ȣ
	 * <li>opmi_rcptdd			��������(���� ��������)
	 * <li>opmi_rcptno			��������ȣ
 	 * </ul>
	 * @return ValueObject
	 * <p>otpt : �ܷ����
	 * <ul>
	 * <li>otpt_pid				��Ϲ�ȣ
	 * <li>otpt_orddd			��������
	 * <li>....
	 * <li>lastupdtdt			������������
	 * </ul>  
	 * @throws LiveException
	 */
	public ValueObject getOtptInfo(ValueObject pVO) throws LiveException;

	
	/**
	 * <p>ȯ�ڼ������� ��ȸ(�ܷ�����ȭ��)</p>
	 * �ܷ���� Ű�� �������� ��ȸ(�ܷ�������ȸȭ��)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : ȯ�ڼ������� ��ȸ����-��������
	 * <ul>
	 * <li>pid 					��Ϲ�ȣ 
	 * <li>orddd 				��������
	 * <li>cretno				������ȣ 
	 * </ul>
	 * @return ValueObject
	 * <p>earn	 : ȯ�� �������� ��ȸ
	 * <ul>
	 * <li>outcls     			�ܷ�����������
     * <li>outclsnm 			�ܷ���ϻ�����ȣ
     * <li>payamt   			�޿�
     * <li>nopyamt   			��޿�
     * <li>specamt     			���������
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getEarnInfo2(ValueObject pVO) throws LiveException;	
	
	
	/**
	 * <p>ȯ�ڼ������� ��ȸ(�ܷ�����ȭ��)</p>
	 * �ܷ���� Ű�� �������� ��ȸ(�ܷ�������ȸȭ��)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : ȯ�ڼ������� ��ȸ����-��������
	 * <ul>
	 * <li>pid 					��Ϲ�ȣ 
	 * <li>orddd 				��������
	 * <li>cretno				������ȣ 
	 * </ul>
	 * @return ValueObject
	 * <p>earn	 : ȯ�� �������� ��ȸ
	 * <ul>
	 * <li>outcls     			�ܷ�����������
     * <li>outclsnm 			�ܷ���ϻ�����ȣ
     * <li>payamt   			�޿�
     * <li>nopyamt   			��޿�
     * <li>specamt     			���������
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getEarnInfo3(ValueObject pVO) throws LiveException;		
	

	/**
	 * <p>ȯ�ڼ������� ��ȸ(�ܷ�����ȭ��)</p>
	 * �ܷ���� Ű�� �������� ��ȸsum(�ܷ�������ȸȭ��)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : ȯ�ڼ������� ��ȸ����-��������
	 * <ul>
	 * <li>pid 					��Ϲ�ȣ 
	 * <li>orddd 				��������
	 * <li>cretno				������ȣ 
	 * </ul>
	 * @return ValueObject
	 * <p>earn	 : ȯ�� �������� ��ȸ
	 * <ul>
	 * <li>outcls     			�ܷ�����������
     * <li>outclsnm 			�ܷ���ϻ�����ȣ
     * <li>payamt   			�޿�
     * <li>nopyamt   			��޿�
     * <li>specamt     			���������
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getEarnInfo4(ValueObject pVO) throws LiveException;

	/**
	 * <p>�ܷ� ���� DC ���� ���� </p>
	 * �ܷ� ���� DC ���� ����
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
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
	 * <p>�ܷ� ��곻��  DC ���� ���� </p>
	 * �ܷ� ��� DC ���� ����
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
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
	 * <p>���� �ܷ����� [����]���·� ���� </p>
	 * �������� ����(Y->C)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>pid   			��Ϲ�ȣ 		
	 * <li>rcptdd   		�������� 		
	 * <li>rcptno   		��������ȣ 		
	 * <li>rcptseqno   		�������Ϸù�ȣ	
	 * <li>seqno   			�Ϸù�ȣ		
	 * <li>instcd   		����ڵ�		
	 * <li>rcptstat   		��������		
	 * <li>ordtype   		��������		
	 * <li>rcptflag   		��������		
	 * <li>fstrgstrid   	���ʵ����		
	 * <li>fstrgstdt   		���ʵ���Ͻ�	
	 * <li>lastupdtrid   	����������		
	 * <li>lastupdtdt   	���������Ͻ�
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int setOutOrdAmtC(ValueObject pVO) throws LiveException;


	/**
	 * <p>�ܷ� ��곻��  [����]  </p>
	 * �ܷ� ��� [����] 
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
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
	 * <p>�ܷ���ϳ�����ȸ(�ܷ�����ȭ��)</p>
	 * �ܷ���ϳ�����ȸ(�ܷ�����ȭ��)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>opmi : �Էµ�����
	 * <ul>
	 * <li>opmi_pid   			��Ϲ�ȣ
	 * <li>opmi_rcptdd			��������(���� ��������)
	 * <li>opmi_rcptno			��������ȣ
 	 * </ul>
	 * @return ValueObject
	 * <p>otpt : �ܷ����
	 * <ul>
	 * <li>otpt_pid				��Ϲ�ȣ
	 * <li>otpt_orddd			��������
	 * <li>....
	 * <li>lastupdtdt			������������
	 * </ul>  
	 * @throws LiveException
	 */
	public ValueObject getOtptInfo2(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>�ܷ���ϳ�����ȸ(�ܷ�����ȭ��)</p>
	 * �ܷ���ϳ�����ȸ(�ܷ�����ȭ��)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>opmi : �Էµ�����
	 * <ul>
	 * <li>opmi_pid   			��Ϲ�ȣ
	 * <li>opmi_rcptdd			��������(���� ��������)
	 * <li>opmi_rcptno			��������ȣ
 	 * </ul>
	 * @return ValueObject
	 * <p>otpt : �ܷ����
	 * <ul>
	 * <li>otpt_pid				��Ϲ�ȣ
	 * <li>otpt_orddd			��������
	 * <li>....
	 * <li>lastupdtdt			������������
	 * </ul>  
	 * @throws LiveException
	 */
	public ValueObject getOtptInfo3(ValueObject pVO) throws LiveException;
	
	
	/**
	 * <p>ó�� ��ȸ(�ܷ�������ȸȭ��)</p>
	 * ó��Ȧ������ ó����ȸ
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>pid   			��Ϲ�ȣ
	 * <li>orddd			��������
	 * <li>cretno			�ܷ�������ȣ
	 * </ul>
	 * @return ValueObject
	 * <p>prcp : ��µ�����
	 * <ul>
	 * <li>calcscorcd		�����ڵ�
	 * <li>calcscorcdnm		�����ڵ��
	 * </ul>  
	 * @throws LiveException
	 */
	public ValueObject getprcpList2(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>Ȧ��ó������  ��ȸ(�ܷ�����ȭ��)</p>
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>pid   				��Ϲ�ȣ
	 * <li>orddd				��������
	 * <li>cretno				�ܷ�������ȣ
	 * </ul>
	 * @return ValueObject
	 * <p>prcp : ��µ�����
	 * <ul>
	 * <li>pid
	 * <li>prcpdd
	 * </ul>  
	 * @throws LiveException
	 */
	//public ValueObject getholdDDList(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>ȯ�� HOLD ó�� ��ȸ(�ܷ�����ȭ��)</p>
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>pid   				��Ϲ�ȣ
	 * <li>orddd				��������
	 * <li>cretno				�ܷ�������ȣ
	 * </ul>
	 * @return ValueObject
	 * <p>prcp : ��µ�����
	 * <ul>
	 * <li>pid   				��Ϲ�ȣ 		
	 * <li>calcscorcd
	 * <li>prcpdd
	 * <li>prcpno
	 * <li>prcphistno
	 * </ul>  
	 * @throws LiveException
	 */
	//public ValueObject getholdList(ValueObject pVO) throws LiveException;
	
	
	/**
	 * <p>û��������  [����]  </p>
	 * û��������  [����] 
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
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
	 * <p>ī�� ���� ó��</p>
	 * ī�� ����ó��
	 *
	 * @param pVO ValueObject
	 * <p>card : �Էµ�����
	 * <ul>
	 * <li>pid   		��Ϲ�ȣ 		
	 * <li>rcptdd   	�������� 		
	 * <li>rcptno   	��������ȣ 		
	 * <li>rcptseqno   	�������Ϸù�ȣ	 
	 * <li>seqno   		�Ϸù�ȣ		
	 * <li>instcd   	����ڵ�		
	 * <li>rcptstat   	��������		
	 * <li>ordtype   	��������		
	 * <li>cardamt   	ī��ݾ�         
	 * <li>cardno		ī���ȣ         
	 * <li>aprvflag		���α���         
	 * <li>aprvno		���ι�ȣ         
	 * <li>aprvdd		��������         
	 * <li>aprvtm		���ν�           
	 * <li>rcptexecdd  	��������		
	 * <li>rcpttm   	�����ð�		
	 * <li>rcptrid   	������ID	 
	 * <li>preamtyn		�����ݿ���       
	 * <li>innrtretyn	����ó������     
	 * <li>remfact   	�������		
	 * <li>fstrgstrid   ���ʵ����		
	 * <li>fstrgstdt   	���ʵ���Ͻ�	 
	 * <li>lastupdtrid  ����������		
	 * <li>lastupdtdt   ���������Ͻ�     
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insCardAmt(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>���ݿ����� ���� ó��</p>
	 * ���ݿ����� ����ó��
	 *
	 * @param pVO ValueObject
	 * <p>cash : �Էµ�����
	 * <ul>
	 * <li>pid   		��Ϲ�ȣ 		
	 * <li>rcptdd   	�������� 		
	 * <li>rcptno   	��������ȣ 		
	 * <li>rcptseqno   	�������Ϸù�ȣ	   
	 * <li>seqno   		�Ϸù�ȣ		
	 * <li>instcd   	����ڵ�		
	 * <li>rcptstat   	��������		
	 * <li>ordtype   	��������		
	 * <li>cashamt   	���ݱݾ�           
	 * <li>qualcnfmflag	�ڰ�Ȯ�α���       
	 * <li>qualcnfmno	�ڰ�Ȯ�ι�         
	 * <li>aprvflag		���α���           
	 * <li>aprvno		���ι�ȣ           
	 * <li>aprvdd		��������           
	 * <li>aprvtm		���ν�             
	 * <li>rcptexecdd  	��������		
	 * <li>rcpttm   	�����ð�		
	 * <li>rcptrid   	������ID	   
	 * <li>preamtyn		�����ݿ���         
	 * <li>innrtretyn	����ó������       
	 * <li>remfact   	�������		
	 * <li>fstrgstrid   ���ʵ����		
	 * <li>fstrgstdt   	���ʵ���Ͻ�	   
	 * <li>lastupdtrid  ����������		
	 * <li>lastupdtdt   ���������Ͻ�       
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insCashAmt(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>�̼����� ����</p>
	 * �̼�
	 *
	 * @param pVO ValueObject
	 * <p>unco : �Էµ�����
	 * <ul>
	 * <li>pid         	ȯ���� ����ID                                                                                                
	 * <li>rcptdd       ������ ó������                                         
	 * <li>rcptno       ��������ȣ                                              
	 * <li>rcptseqno    �������Ϸù�ȣ                                          
	 * <li>seqno        ��������ȣ�� �Ϸù�ȣ                    
	 * <li>instcd       ������ ����ڵ�                                             
	 * <li>rcptstat     ��������(�ڵ屺 P0049 ����)                             
	 * <li>ordtype      ��������(�ܷ�,�Կ�,����)                                
	 * <li>orddd        �ܷ��������:��������,��������                          
	 * <li>orddeptcd    ������ڵ�                                             
	 * <li>orddrid      �����ǻ�,��ġ��                                         
	 * <li>dschdd       �������(����̼����ϰ��)                              
	 * <li>insukind     ��������                                 
	 * <li>suppkind     ��������                                 
	 * <li>uncorcptflag �̼����걸��                             
	 * <li>uncocls      �̼��з�                                 
	 * <li>uncocd       �̼��ڵ�                                                
	 * <li>uncoamt      �̼��ݾ�                                                
	 * <li>rcptamt      �̼������ݾ�                                            
	 * <li>debtamt      ���ó���ݾ�                                            
	 * <li>endyn        ���Ῡ��                                                
	 * <li>clincstdyno  �ӻ�����ȣ(�ǻ纰 ������ȣ)                          
	 * <li>empid        ���������̼� �߰��Է� ���� - ���������ȣ               
	 * <li>rcptexecdd   ������������                                          
	 * <li>rcpttm       �����ð�                                                
	 * <li>rcptrid      ������ID                                                    
	 * <li>apprsn       �������                                                
	 * <li>remfact      ���������� ���� �������                                
	 * <li>fstrgstrid   ���ʵ����ID                                            
	 * <li>fstrgstdt    ���ʵ���Ͻ�                                            
	 * <li>lastupdtrid  ����������ID                                            
	 * <li>lastupdtdt   ���������Ͻ�                             
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insUncoAmt(ValueObject pVO) throws LiveException;

	/**
	 * <p>DC �̼����� ����</p>
	 * �̼�
	 *
	 * @param pVO ValueObject
	 * <p>unco : �Էµ�����
	 * <ul>
	 * <li>pid         		ȯ���� ����ID                                                                                                 
	 * <li>orddd          	��������                                              
	 * <li>cretno          	������ȣ                                                   
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insUncoAmtDC(ValueObject pVO) throws LiveException;
	
	/**
	 * <p> �̼����� ����</p>
	 * �̼�
	 *
	 * @param pVO ValueObject
	 * <p>unco : �Էµ�����
	 * <ul>
	 * <li>pid         		ȯ���� ����ID                                                                                                 
	 * <li>orddd          	��������                                              
	 * <li>cretno          	������ȣ                                                   
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int setUncoAmtC(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>���ǰ��׳��� ����</p>
	 * ���ǰ���
	 *
	 * @param pVO ValueObject
	 * <p>dcgm : �Էµ�����
	 * <ul>
	 * <li>pid         	ȯ���� ����ID          
	 * <li>rcptdd       ������ ó������        
	 * <li>rcptno       ��������ȣ             
	 * <li>seqno        ��������ȣ�� �Ϸù�ȣ  
	 * <li>rcptseqno    �������Ϸù�ȣ         
	 * <li>instcd       ������ ����ڵ�        
	 * <li>rcptstat     ��������               
	 * <li>ordtype      ��������               
	 * <li>discreduflag ���ΰ��ױ���           
	 * <li>discreducd   ���ΰ����ڵ�           
	 * <li>discreduamt  ���ΰ��ױݾ�           
	 * <li>apprsn       �������               
	 * <li>rcptexecdd   ������������           
	 * <li>rcpttm       �����ð�               
	 * <li>rcptrid      ������ID               
	 * <li>remfact      �������               
	 * <li>fstrgstrid   ���ʵ����ID           
	 * <li>fstrgstdt    ���ʵ���Ͻ�           
	 * <li>lastupdtrid  ����������ID           
	 * <li>lastupdtdt   ���������Ͻ�           
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insDcgmAmt(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>DC ����,���ǰ��׳��� ����</p>
	 * ����, ���ǰ���
	 *
	 * @param pVO ValueObject
	 * <p>dcgm : �Էµ�����
	 * <ul>
	 * <li>pid         		ȯ���� ����ID           
	 * <li>orddd          	��������         
	 * <li>cretno          	������ȣ
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insDcgmAmtDC(ValueObject pVO) throws LiveException;

	/**
	 * <p>����,���ǰ��׳��� ����</p>
	 * ����, ���ǰ���
	 *
	 * @param pVO ValueObject
	 * <p>dcgm : �Էµ�����
	 * <ul>
	 * <li>pid         		ȯ���� ����ID           
	 * <li>orddd          	��������         
	 * <li>cretno          	������ȣ
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int setDcgmAmtC(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>�������ο� ����</p>
	 * ��������
	 *
	 * @param pVO ValueObject
	 * <p>bldc : �Էµ�����
	 * <ul>
	 * <li>pid         		ȯ���� ����ID           
	 * <li>rcptdd          	������ ó������         
	 * <li>rcptno          	��������ȣ              
	 * <li>seqno           	��������ȣ�� �Ϸù�ȣ   
	 * <li>rcptseqno        �������Ϸù�ȣ          
	 * <li>instcd          	������ ����ڵ�         
	 * <li>rcptstat        	��������                
	 * <li>ordtype         	��������
	 * <li>orddd         	��������                
	 * <li>  .....
	 * <li>remfact         	�������                
	 * <li>fstrgstrid      	���ʵ����ID            
	 * <li>fstrgstdt       	���ʵ���Ͻ�            
	 * <li>lastupdtrid     	����������ID            
	 * <li>lastupdtdt      	���������Ͻ�
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insBldcAmt(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>DC �������γ��� ����</p>
	 * ����, ���ǰ���
	 *
	 * @param pVO ValueObject
	 * <p>bldc : �Էµ�����
	 * <ul>
	 * <li>pid         		ȯ���� ����ID           
	 * <li>orddd          	��������         
	 * <li>cretno          	������ȣ
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insBldcAmtDC(ValueObject pVO) throws LiveException;

	/**
	 * <p>�������γ��� ����</p>
	 * ��������
	 *
	 * @param pVO ValueObject
	 * <p>bldc : �Էµ�����
	 * <ul>
	 * <li>pid         		ȯ���� ����ID           
	 * <li>orddd          	��������         
	 * <li>cretno          	������ȣ
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int setBldcAmtC(ValueObject pVO) throws LiveException;


	/**
	 * <p>DC ī�峻�� ����</p>
	 *
	 * @param pVO ValueObject
	 * <p>card : �Էµ�����
	 * <ul>
	 * <li>pid         		ȯ���� ����ID           
	 * <li>orddd          	��������         
	 * <li>cretno          	������ȣ
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insCardAmtDC(ValueObject pVO) throws LiveException;

	/**
	 * <p>ī�峻�� ����</p>
	 *
	 * @param pVO ValueObject
	 * <p>card : �Էµ�����
	 * <ul>
	 * <li>pid         		ȯ���� ����ID           
	 * <li>orddd          	��������         
	 * <li>cretno          	������ȣ
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int setCardAmtC(ValueObject pVO) throws LiveException;

	/**
	 * <p>�� ī�峻�� ����</p>
	 *
	 * @param pVO ValueObject
	 * <p>card : �Էµ�����
	 * <ul>
	 * <li>pid         		ȯ���� ����ID           
	 * <li>orddd          	��������         
	 * <li>cretno          	������ȣ
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insPreCardAmt(ValueObject pVO) throws LiveException;

	
	/**
	 * <p>DC ���ݿ��������� ����</p>
	 *
	 * @param pVO ValueObject
	 * <p>card : �Էµ�����
	 * <ul>
	 * <li>pid         		ȯ���� ����ID           
	 * <li>orddd          	��������         
	 * <li>cretno          	������ȣ
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insCashAmtDC(ValueObject pVO) throws LiveException;

	/**
	 * <p>���ݿ������峻�� ����</p>
	 *
	 * @param pVO ValueObject
	 * <p>card : �Էµ�����
	 * <ul>
	 * <li>pid         		ȯ���� ����ID           
	 * <li>orddd          	��������         
	 * <li>cretno          	������ȣ
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int setCashAmtC(ValueObject pVO) throws LiveException;

	
	/**
	 * <p>DC �߰��ݳ��� ����</p>
	 *
	 * @param pVO ValueObject
	 * <p>card : �Էµ�����
	 * <ul>
	 * <li>pid         		ȯ���� ����ID           
	 * <li>orddd          	��������         
	 * <li>cretno          	������ȣ
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insBogjAmtDC(ValueObject pVO) throws LiveException;

	/**
	 * <p>�߰��ݳ��� ����</p>
	 *
	 * @param pVO ValueObject
	 * <p>card : �Էµ�����
	 * <ul>
	 * <li>pid         		ȯ���� ����ID           
	 * <li>orddd          	��������         
	 * <li>cretno          	������ȣ
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int setBogjAmtC(ValueObject pVO) throws LiveException;
	
	
	/**
	 * <p>�ܷ��߰���(������) ������� ó��</p>
	 * �ܷ��߰���(������) ������� ó��
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>pid   		��Ϲ�ȣ 		
	 * <li>rcptdd   	�������� 		
	 * <li>rcptno   	��������ȣ 		
	 * <li>rcptseqno   	�������Ϸù�ȣ	   
	 * <li>seqno   		�Ϸù�ȣ		
	 * <li>instcd   	����ڵ�		
	 * <li>rcptstat   	��������		
	 * <li>ordtype   	��������		
	 * <li>rcptflag   	��������		
	 * <li>cashamt   	���ݱݾ�		
	 * <li>cardamt   	ī��ݾ�		
	 * <li>onlineamt   	�¶��αݾ�		
	 * <li>rcptexecdd  	��������		
	 * <li>rcpttm   	�����ð�		
	 * <li>rcptid   	������ID		
	 * <li>remfact   	�������		
	 * <li>fstrgstrid   ���ʵ����		
	 * <li>fstrgstdt   	���ʵ���Ͻ�	   
	 * <li>lastupdtrid  ����������		
	 * <li>lastupdtdt   ���������Ͻ�       
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insMdlAmtCncl(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>ī�� ������� ó��</p>
	 * ī�� ������� ���� ����
	 *
	 * @param pVO ValueObject
	 * <p>card : �Էµ�����
	 * <ul>
	 * <li>pid   		��Ϲ�ȣ 		
	 * <li>rcptdd   	�������� 		
	 * <li>rcptno   	��������ȣ 		
	 * <li>rcptseqno   	�������Ϸù�ȣ	   
	 * <li>seqno   		�Ϸù�ȣ		
	 * <li>instcd   	����ڵ�		
	 * <li>rcptstat   	��������		
	 * <li>ordtype   	��������		
	 * <li>cardamt   	ī��ݾ�           
	 * <li>cardno		ī���ȣ           
	 * <li>aprvflag		���α���           
	 * <li>aprvno		���ι�ȣ           
	 * <li>aprvdd		��������           
	 * <li>aprvtm		���ν�             
	 * <li>rcptexecdd  	��������		
	 * <li>rcpttm   	�����ð�		
	 * <li>rcptrid   	������ID	   
	 * <li>preamtyn		�����ݿ���         
	 * <li>innrtretyn	����ó������       
	 * <li>remfact   	�������		
	 * <li>fstrgstrid   ���ʵ����		
	 * <li>fstrgstdt   	���ʵ���Ͻ�	   
	 * <li>lastupdtrid  ����������		
	 * <li>lastupdtdt   ���������Ͻ�       
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insCardAmtCncl(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>���ݿ����� ���� ó��</p>
	 * ���ݿ����� ������ҳ��� ����
	 *
	 * @param pVO ValueObject
	 * <p>cash : �Էµ�����
	 * <ul>
	 * <li>pid   		��Ϲ�ȣ 		
	 * <li>rcptdd   	�������� 		
	 * <li>rcptno   	��������ȣ 		
	 * <li>rcptseqno   	�������Ϸù�ȣ	    
	 * <li>seqno   		�Ϸù�ȣ		
	 * <li>instcd   	����ڵ�		
	 * <li>rcptstat   	��������		
	 * <li>ordtype   	��������		
	 * <li>cashamt   	���ݱݾ�            
	 * <li>qualcnfmflag	�ڰ�Ȯ�α���        
	 * <li>qualcnfmno	�ڰ�Ȯ�ι�          
	 * <li>aprvflag		���α���            
	 * <li>aprvno		���ι�ȣ            
	 * <li>aprvdd		��������            
	 * <li>aprvtm		���ν�              
	 * <li>rcptexecdd  	��������		
	 * <li>rcpttm   	�����ð�		
	 * <li>rcptrid   	������ID	    
	 * <li>preamtyn		�����ݿ���          
	 * <li>innrtretyn	����ó������        
	 * <li>remfact   	�������		
	 * <li>fstrgstrid   ���ʵ����		
	 * <li>fstrgstdt   	���ʵ���Ͻ�	    
	 * <li>lastupdtrid  ����������		
	 * <li>lastupdtdt   ���������Ͻ�        
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insCashAmtCncl(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>ī�� ���� ���� ó��</p>
	 * ī�� ���� ����  ó��
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>card : �Էµ�����
	 * <ul>
	 * <li>pid   		��Ϲ�ȣ 		
	 * <li>rcptdd   	�������� 		
	 * <li>rcptno   	��������ȣ 		
	 * <li>rcptseqno   	�������Ϸù�ȣ	 
	 * <li>seqno   		�Ϸù�ȣ		
	 * <li>instcd   	����ڵ�		
	 * <li>rcptstat   	��������		
	 * <li>ordtype   	��������		
	 * <li>rcptexecdd  	��������		
	 * <li>rcpttm   	�����ð�		
	 * <li>rcptrid   	������ID	 
	 * <li>preamtyn		�����ݿ���       
	 * <li>innrtretyn	����ó������     
	 * <li>remfact   	�������		
	 * <li>fstrgstrid   ���ʵ����		
	 * <li>fstrgstdt   	���ʵ���Ͻ�	 
	 * <li>lastupdtrid  ����������		
	 * <li>lastupdtdt   ���������Ͻ�     
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int setCardAmt(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>���ݿ����� ���� ���� ó��</p>
	 * ���ݿ����� ���� ����  ó��
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>cash : �Էµ�����
	 * <ul>
	 * <li>pid   		��Ϲ�ȣ 	
	 * <li>rcptdd   	�������� 	
	 * <li>rcptno   	��������ȣ 	
	 * <li>rcptseqno   	�������Ϸù�ȣ
	 * <li>seqno   		�Ϸù�ȣ	
	 * <li>instcd   	����ڵ�	
	 * <li>rcptstat   	��������	
	 * <li>ordtype   	��������	
	 * <li>rcptexecdd  	��������	
	 * <li>rcpttm   	�����ð�	
	 * <li>rcptrid   	������ID	
	 * <li>preamtyn		�����ݿ���    
	 * <li>innrtretyn	����ó������  
	 * <li>remfact   	�������	
	 * <li>fstrgstrid   ���ʵ����	
	 * <li>fstrgstdt   	���ʵ���Ͻ�	
	 * <li>lastupdtrid  ����������	
	 * <li>lastupdtdt   ���������Ͻ�  
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int setCashAmt(ValueObject pVO) throws LiveException;
		

	/**
	 * <p>�¶����Ա� �������  ó��</p>
	 * �¶����Ա� ������� ���� ����
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>online : �Էµ�����
	 * <ul>
	 * <li>pid   		��Ϲ�ȣ 		
	 * <li>rcptdd   	�������� 		
	 * <li>rcptno   	��������ȣ 		
	 * <li>rcptseqno   	�������Ϸù�ȣ	    
	 * <li>seqno   		�Ϸù�ȣ		
	 * <li>instcd   	����ڵ�		
	 * <li>rcptstat   	��������		
	 * <li>ordtype   	��������		
	 * <li>onlineamt   	�¶��αݾ�          
	 * <li>bankcd		�����ڵ�            
	 * <li>acntno		���¹�ȣ		
	 * <li>paydd		�Ա�����            
	 * <li>paypsnnm		�Ա��ڸ�            
	 * <li>rcptexecdd  	��������		
	 * <li>rcpttm   	�����ð�		
	 * <li>rcptrid   	������ID	    
	 * <li>preamtyn		�����ݿ���          
	 * <li>innrtretyn	����ó������        
	 * <li>remfact   	�������		
	 * <li>fstrgstrid   ���ʵ����		
	 * <li>fstrgstdt   	���ʵ���Ͻ�	    
	 * <li>lastupdtrid  ����������		
	 * <li>lastupdtdt   ���������Ͻ�        
 	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insOnlineAmtCncl(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>ȯ�ں���������ȸ(����ȭ��)</p>
	 * Ű���� ��������
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>pid 				��Ϲ�ȣ	 
	 * <li>insukind	 
	 * <li>suppkind	 
	 * <li>todd	 
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */	
	public ValueObject getPtin1(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>ȯ�ں������� �̷»���(����ȭ��)</p>
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>pid 				��Ϲ�ȣ	 
	 * <li>insukind	 
	 * <li>suppkind	 
	 * <li>todd	 
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */	
	public int insPtinHist(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>ȯ�ں������� �������� ����(����ȭ��)</p>
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>pid 				��Ϲ�ȣ	 
	 * <li>insukind	 
	 * <li>suppkind	 
	 * <li>todd	 
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */	
	public int setPtinPreHist(ValueObject pVO) throws LiveException;
	

   /**
     * �����Ƿ�ȯ�� ����
     *
     * @param pVO ValueObject
	 * @return int
	 * @throws LiveException
	 */
    public int setCNST(ValueObject pVO) throws LiveException;


    /**
	 * <p>Hold/Release ó��</p>
	 * 
	 *
	 * @param pVO ValueObject	
	 * <p>opmi : �Էµ�����
	 * <ul>	  		
	 * <li>pid   			��Ϲ�ȣ 	
	 * <li>prcpdd   		ó������ 	
	 * <li>prcpno	   		ó���ȣ 	
	 * <li>prcphistno		ó���̷¹�ȣ	 
	 * </ul>
	 * @return  int
	 * @throws LiveException
	 */
	public int setHoldPrcpList(ValueObject pVO) throws LiveException;
	
    
    /**
	 * <p>Release ��, �ܷ���ϳ��� �߰� ó��</p>
	 * 
	 *
	 * @param pVO ValueObject	
	 * <p>opmi : �Էµ�����
	 * <ul>	  		
	 * <li>pid   			��Ϲ�ȣ 	
	 * <li>orddd   			ó������ 	
	 * <li>cretno	   		ó���ȣ 	
	 * </ul>
	 * @return  int
	 * @throws LiveException
	 */
	public int setAddOTPTFromHold(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>�ܷ���ϳ��� ��ȸ(�ܷ�����)</p>
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>pid 				��Ϲ�ȣ
	 * <li>srchcond	��ȸ����
	 * <li>fromdd			��������
	 * <li>todd				��������
	 * <li>orddeptcd		�����
	 * <li>orddrid			�����ǻ�
	 * <li>insukind			��������
	 * </ul>
	 * @return ValueObject
	 * <p>otpt	 : 		��µ�����
	 * <ul>
	 * <li>orddd			��������
	 * <li>ordtm			����ð�
	 * <li>orddept			�����
	 * <li>orddr			������
	 * <li>fsexamflag		����������
	 * <li>indukind			��������
	 * <li>suppkind			�������� 
	 * </ul>
	 * @throws LiveException
	 */		
	public ValueObject getOtptList(ValueObject pVO) throws LiveException;
    
	
	/**
	 * <p>�ܷ���ϳ����� �������� ����Ʈ</p>
	 * �܏O��Ϻ� �������� 
	 * @author ������
     * @version 1.0 2007.04.19
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>pid				ȯ�ڵ�Ϲ�ȣ
	 * <li>orddd      		�������� 
	 * <li>cretno 		    ������ȣ
	 * <li>acptseqno 	    ����Ϸù�ȣ
     * </ul>
	 * @return ValueObject
	 * <p>rcptspeclist : �������� ����Ʈ
	 * <ul>
	 * <li>pid              ȯ�ڵ�Ϲ�ȣ              
	 * <li>rcptdd           ����������                
	 * 	<li>rcptno          ��������ȣ             
	 * <li>rcptseqno        �������Ϸú�ȣ         
	 * <li>instcd           ����ڵ�                  
	 * <li>rcptstat         ��������                  
	 * <li>uncorcptflag     �̼����걸��           
	 * <li>orddd            ��������               
	 * <li>cretno           ������ȣ                  
	 * <li>acptseqno        ����Ϸù�ȣ           
	 * <li>orddeptcd        ������ڵ�             
	 * <li>orddrid          ������ID               
	 * <li>ordtype          ��������               
	 * <li>mskind           �ֺ�����               
	 * <li>insukind         ��������               
	 * <li>suppkind         ��������               
	 * <li>insucd           �������ڵ�             
	 * <li>payamt           �޿��ݾ�               
	 * <li>allownbamt       ���׺��κδ��         
	 * <li>nopyamt          ��޿���               
	 * <li>payownbamt       �޿����κδ��         
	 * <li>payinsubamt      �޿������ںδ��       
	 * <li>handcapfund      ��ֱ��               
	 * <li>procsubtamt      �Ƿ�޿���Ҿ�         
	 * <li>ersubtamt        ���޴�Ҿ�             
	 * <li>specamt          ���������             
	 * <li>discamt          ���ξ�                 
	 * <li>reduamt          ����                   
	 * <li>bloddiscamt      �������ξ�             
	 * <li>totownbamt       �Ѻ��κδ��           
	 * <li>premdlrcptamt    ���߰�������           
	 * <li>precardamt       ��ī��ݾ�             
	 * <li>precashamt       �����ݱݾ�             
	 * <li>preonlineamt     ��¶��αݾ�           
	 * <li>mdlrcptamt       �߰�������             
	 * <li>uncoamt          �̼��ݾ�               
	 * <li>cardamt          ī��ݾ�               
	 * 	<li>cashamt         ���ݱݾ�               
	 * <li>onlineamt        �¶��αݾ�             
	 * <li>restamt          �����                 
	 * <li>hosindrugno      ���������ȣ           
	 * <li>hosoutdrugno     ���������ȣ           
	 * <li>calcmthdflag     ���������           
	 * <li>remfact          �������               
	 * <li>paypsnflag       ������������           
	 * <li>paypsnrem        ����������ȣ           
	 * <li>orgrcptdd        ���������Ϸù�ȣ       
	 * <li>orgrcptno        �����ڱ���             
	 * <li>orgrcptseqno     �������������         
	 * <li>rcptexecdd       ��������               
	 * <li>rcpttm           �����ð�                  
	 * <li>rcptrid          ������ID                  
	 * <li>fstrgstrid       ���ʵ����ID              
	 * <li>fstrgstdt        ���ʵ���Ͻ�              
	 * <li>lastupdtrid      ����������ID           
	 * <li>lastupdtdt       ���������Ͻ�	       
	 * </ul>
	 * @throws LiveException
	 */
	public ValueObject getOutRcptSpec(ValueObject pVO) throws LiveException;	
	

	/**
	 * <p>����ó���� ����ó��  </p>
	 * �������� ���׷�: ����,���� ����ó��  
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
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
	 * <p>����ó���� ��곻���� ����ó��  </p>
	 * �������� ���׷�: ����,���� ����ó��  
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
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
	 * <p>VAN������ �ִ� ī�峻�� ��ȸ</p>
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>
	 * <ul>
	 * <li>pid 									��Ϲ�ȣ 
	 * <li>fromdd								��������
	 * <li>todd 								��������
	 * </ul>
	 * @return ValueObject
	 * </ul>
	 * @throws LiveException
	 */
	public ValueObject getonlycvanList(ValueObject pVO) throws LiveException;


	/**
	 * <p>�������泻�� ��ȸ</p>
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>
	 * <ul>
	 * <li>pid 									��Ϲ�ȣ 
	 * </ul>
	 * @return ValueObject
	 * </ul>
	 * @throws LiveException
	 */
	public ValueObject getupdtrateList(ValueObject pVO) throws LiveException;
	
	
	/**
	 * <p>�����������᳻��</p>
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>
	 * <ul>
	 * <li>pid 									��Ϲ�ȣ 
	 * </ul>
	 * @return ValueObject
	 * </ul>
	 * @throws LiveException
	 */
	public ValueObject getupdtrateList1(ValueObject pVO) throws LiveException;	
	
	
	/**
	 * <p>�������泻�� ����</p>
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>
	 * <ul>
	 * <li>pid 									��Ϲ�ȣ 
	 * <li>orddd 								�������� 
	 * <li>cretno 								������ȣ 
	 * </ul>
	 * @return ValueObject
	 * </ul>
	 * @throws LiveException
	 */
	public int setupdtrateList(ValueObject pVO) throws LiveException;

	/**
	 * <p>ȯ�ڰ������ ��ȸ(����ȭ��)</p>
	 * ������� ��ȸ(����ȭ��)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : ȯ�ڰ������ ��ȸ����
	 * <ul>
	 * <li>pid 				��Ϲ�ȣ 
	 * <li>orddd 			��������
	 * <li>cretno			������ȣ
	 * <li>acptseqno		�ܷ�����Ϸù�ȣ
	 * </ul>
	 * @return ValueObject
	 * <p>oscl	 : ȯ�� ������� ��ȸ
	 * <ul>
	 * <li>pid     			��Ϲ�ȣ                        
     * <li>orddd     		�ܷ��������                    
     * <li>cretno     		�ܷ���ϻ�����ȣ                
     * <li>calcseqno   		����Ϸù�ȣ                    
     * <li>calcscorseqno    �������,��곻���� �Ϸù�ȣ  
     * <li>instcd     		����ڵ�                        
	 * <li>calcstat			������                        
	 * <li>clamtrgtstat		û��������                    
	 * <li>acptseqno		�ܷ���ϻ�����ȣ���Ϸù�ȣ      
	 * <li>orddeptcd		������ڵ�                      
	 * <li>orddrid			�����ǻ�                        
	 * <li>mskind			�ֺ�����                        
	 * <li>ordtype			��������                        
	 * <li>grupcalcscorcd	�׷�����ڵ�                    
	 * <li>snglcalcscorcd	�̱ۼ����ڵ�                    
	 * <li>grupcalcscorcls	�׷�����з�                    
	 * <li>snglcalcscorcls	�̱ۼ����з�                    
	 * <li>grupearncls		�׷���ͺз�                    
	 * <li>snglearncls		�̱ۼ��ͺз�                    
	 * <li>ordqty			ó������������                  
	 * <li>ordtims			ó����������Ƚ��                
	 * <li>orddays			ó�����������ϼ�                
	 * <li>calcqty			���������                      
	 * <li>calctims			�������Ƚ��                    
	 * <li>calcdays			��������ϼ�                    
	 * <li>matractflag		�����������                    
	 * <li>calcpayflag		�޿�����                        
	 * <li>prcppayflag		ó��޿�����                    
	 * <li>calcscorpayflag	�����޿�����2                   
	 * <li>ansttm			����ð�                        
	 * <li>spccd			��ü�ڵ�                        
	 * <li>pntunitcost		����ܰ�                        
	 * <li>calcscorpnt		��������                        
	 * <li>estmpnt			��������                        
	 * <li>appunitcost		�ܰ�                            
	 * <li>estmamt			�����ݾ�                        
	 * ...							                
	 * <li>fstrgstrid		���ʵ����                      
	 * <li>fstrgstdt		���ʵ���Ͻ�                    
	 * <li>lastupdtrid		���������                      
	 * <li>lastupdtdt		��������Ͻ�                    
	 * </ul>				                                
	 * @throws LiveException
	 */	
	public ValueObject getEarnOsclInfo(ValueObject pVO) throws LiveException;		
	
	
	/**
	 * <p>�ܷ�ó�泻���� ó��޺��������� update</p> 
	 *
	 * @param pVO ValueObject	
	 * <p>opmi : �Էµ�����
	 * <ul>	  		
	 * <li>rcptdd   		�������� 	
	 * <li>rcptexecdd   	�������� 	
	 * <li>rcptno   		��������ȣ	 
	 * <li>rcptseqno   		�����Ϸù�ȣ 	
	 * <li>rcptstat   		�������� 	
 	 * </ul>
	 * @return  int
	 * @throws LiveException
	 */
	public int setOprcPayFlag(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>�ܷ���ϳ����� �̷��߰� �� �������� �̷»��� ����</p> 
	 *
	 * @param pVO ValueObject	
	 * <p>pVO : �Էµ�����
	 * <ul>	  		
	 * <li>histstat �̷»��� 	
	 * <li>pid ȯ�ڹ�ȣ 	
	 * <li>orddd ��������	 
	 * <li>cretno ���� 	
	 * <li>instcd ����ڵ� 	
 	 * </ul>
	 * @return  int
	 * @throws LiveException
	 */
	public int insOtptHistSuppkindAdd(ValueObject pVO) throws LiveException;	
	
  
	/**
	 * <p>��Ƽ�� �������� ���� ��ȸ </p>
	 * ��������, ���γ���, �ܷ���ϳ���(����������,�������ᱸ��,������������� ��)
	 * ���� �������� ���� üũ�Ͽ� ���걸�� ��ȸ(return)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>Checkin : �Էµ�����
	 * <ul>
	 * <li>insukind 		��������                                                                          
	 * <li>suppkind 		��������                                                                          
	 * <li>insucd 			�������ڵ�                                                                        
	 * <li>disccd 			�����ڵ�                                                                          
	 * <li>specordyn		�������Ῡ��                                                                      
	 * <li>fsexamflag		����������                                                                        
	 * <li>fsexammanlyn		�����������ο�����                                                                
	 * <li>medamtestmyn	    �������������                                                                    
	 * <li>medamtpostyn		�������ĺҿ���                                                                    
	 * <li>medamtfreeresn	������������� ������ �������ΰ� N=�̻���,�����϶� �̻��� ����(�ڵ屺 P1061 ����)				
	 * <li>etcordflag		��Ÿ���ᱸ��(�ڵ屺 P0022 ����) J:�ֻ�  M:����ġ��, F:����, N:������ȣ            
	 * </ul>												                  
	 * @return ValueObject									                  
	 * <p>Checkout	 : 		��µ�����                                                                        
	 * <ul>													                  
	 * <li>calcyn			���꿩��                                                                          
	 * </ul>
	 * @throws LiveException
	 */	
	//public ValueObject getMultiChangelist(ValueObject pVO) throws LiveException;    



	/**
	 * <p>��Ƽ�� �ܷ���ϳ��� �̷��߰� </p>
	 * �ܷ���ϳ����� �̷��߰� �� �������� �̷»��� ����
	 * 
	 * @param pVO ValueObject
	 * <p>pVO : �Էµ�����
	 * <ul>
	 * <li>insukind 		��������                                                                          
	 * <li>suppkind 		��������                                                                          
	 * <li>insucd 			�������ڵ�                                                                        
	 * <li>disccd 			�����ڵ�                                                                          
	 * <li>specordyn		�������Ῡ��                                                                      
	 * <li>fsexamflag		����������                                                                        
	 * <li>fsexammanlyn		�����������ο�����                                                                
	 * <li>medamtestmyn	    �������������                                                                    
	 * <li>medamtpostyn		�������ĺҿ���                                                                    
	 * <li>medamtfreeresn	������������� ������ �������ΰ� N=�̻���,�����϶� �̻��� ����(�ڵ屺 P1061 ����)				
	 * <li>etcordflag		��Ÿ���ᱸ��(�ڵ屺 P0022 ����) J:�ֻ�  M:����ġ��, F:����, N:������ȣ            
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */	
	public int insMultiOtptHistAdd(ValueObject pVO) throws LiveException;	


	/**
	 * <p>�����ݿ������������� </p>
	 * �ǽ����� ����
	 * 
	 * @param pVO ValueObject
	 * <p>pVO : �Էµ�����
	 * <ul>
	 * <li>opmi_pid ȯ�ڹ�ȣ
	 * <li>opmi_orddd ��������
	 * <li>opmi_cretno ����
	 * <li>instcd ����ڵ�
	 * <li>opmi_rcptexecdd ��������
	 * <li>opmi_rcpttm �����ð�
	 * <li>opmi_rcptrid ������
	 * <li>opmi_rcptno ������ȣ
	 * <li>opmi_rcptseqno ����
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */	
	public int insPreCashAmt(ValueObject pVO) throws LiveException;
	

	/**
	 * <p>���߰��ݾ� �������� </p>
	 * �ǽ����� ����
	 * 
	 * @param pVO ValueObject
	 * <p>pVO : �Էµ�����
	 * <ul>
	 * <li>opmi_pid ȯ�ڹ�ȣ
	 * <li>opmi_orddd ��������
	 * <li>opmi_cretno ����
	 * <li>instcd ����ڵ�
	 * <li>opmi_rcptexecdd ��������
	 * <li>opmi_rcpttm �����ð�
	 * <li>opmi_rcptrid ������
	 * <li>opmi_rcptno ������ȣ
	 * <li>opmi_rcptseqno ����
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */	
	public int insPreBogjAmt(ValueObject pVO) throws LiveException;


	/**
	 * <p>ȯ�������Ƿڼ� �Է�</p>
	 * 
	 * 
	 * @param pVO ValueObject
	 * <p>pVO : �Էµ�����.
	 * <ul>
     * <li>pid ȯ�ڹ�ȣ
     * <li>orddd ��������
     * <li>orddeptcd �����
     * <li>insukind ��������
     * <li>ordreqformflag �����Ƿڼ� ����
     * <li>etcordflag ��Ÿ����
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int insOutOrdCnst(ValueObject pVO) throws LiveException;


	/**
     * <p> �ܷ��̽���ó�� �̽��� ������ ��ȸ�Ѵ�.</p>
     * @author 
     * @param pVO ValueObject
     * <ul>
     * <li>pid ��Ϲ�ȣ
     * <li>orddd ó����
     * <li>prcphopedd �ǽ������
     * <li>orddeptcd �����
     * <li>orddrid ��ġ��
     * <li>insukind ��������
     * <li>chk2 ����ó�����Կ���
     * <li>instcd ����ڵ�
     * </ul>
     * @return ValueObject
     * <ul>
     * <li>update rowStatus
     * <li>spclchange Ư������ ���濩��
     * <li>pid ��Ϲ�ȣ
     * <li>grupsnglyn �׷쿩��
     * <li>calcscorcd ó���ڵ�
     * <li>edicd EDI�ڵ�
     * <li>ordnm ó���
     * <li>payflagcd ��
     * <li>execprcpqty ������
     * <li>execprcptims Ƚ��
     * <li>execprcpdayno �ϼ�
     * <li>orddd �ܷ��������
     * <li>cretno �ܷ���� ������ȣ
     * <li>prcphopedd �ǽ������
     * <li>actorddd �ǽ������
     * <li>exectm �ǽýð�
     * <li>execprcpstatcd �ǽû���
     * <li>judgendflag ���սɻ�
     * <li>ioflag �ܷ�����
     * <li>orddeptcd �����
     * <li>orddrid ��ġ��
     * <li>diagyn ��
     * <li>unitflag ��������
     * <li>spclcd Ư���ڵ�
     * <li>spclspec Ư������
     * <li>prcpdd ó������
     * <li>prcptm ó���Ͻ�
     * <li>prcpno ó���ȣ
     * <li>prcphistno ó���̷¹�ȣ
     * <li>execprcpseqno �ǽ�ó���Ϸù�ȣ
     * <li>instcd ����ڵ�
     * <li>spclmemoflag Ư���޸𱸺�
     * <li>remfact �������
     * <li>spclyn ���忩��
     * <li>seqno �Ϸù�ȣ
     * <li>insukind ��������
     * <li>rsrvtm �����Ͻ�
     * <li>payflagyn �޺񺯰濩��
     * <li>hosinhosoutflag �������ܱ���
     * </ul>
     * @throws LiveException
     */
	public ValueObject getOutUnExecPrcpOrdRef(ValueObject pVO) throws LiveException;
	
	
	
	/**
     * <p> �Կ� ������ ��ȸ�Ѵ�.</p>
     * @author 
     * @param pVO ValueObject
     * <ul>
     * <li>pid ��Ϲ�ȣ
     * <li>orddd ó����
     * <li>prcphopedd �ǽ������
     * <li>orddeptcd �����
     * <li>orddrid ��ġ��
     * <li>insukind ��������
     * <li>chk2 ����ó�����Կ���
     * <li>instcd ����ڵ�
     * </ul>
     * @return ValueObject
     * <ul>
     * <li>update rowStatus
     * <li>spclchange Ư������ ���濩��
     * <li>pid ��Ϲ�ȣ
     * <li>grupsnglyn �׷쿩��
     * <li>calcscorcd ó���ڵ�
     * <li>edicd EDI�ڵ�
     * <li>ordnm ó���
     * <li>payflagcd ��
     * <li>execprcpqty ������
     * <li>execprcptims Ƚ��
     * <li>execprcpdayno �ϼ�
     * <li>orddd �ܷ��������
     * <li>cretno �ܷ���� ������ȣ
     * <li>prcphopedd �ǽ������
     * <li>actorddd �ǽ������
     * <li>exectm �ǽýð�
     * <li>execprcpstatcd �ǽû���
     * <li>judgendflag ���սɻ�
     * <li>ioflag �ܷ�����
     * <li>orddeptcd �����
     * <li>orddrid ��ġ��
     * <li>diagyn ��
     * <li>unitflag ��������
     * <li>spclcd Ư���ڵ�
     * <li>spclspec Ư������
     * <li>prcpdd ó������
     * <li>prcptm ó���Ͻ�
     * <li>prcpno ó���ȣ
     * <li>prcphistno ó���̷¹�ȣ
     * <li>execprcpseqno �ǽ�ó���Ϸù�ȣ
     * <li>instcd ����ڵ�
     * <li>spclmemoflag Ư���޸𱸺�
     * <li>remfact �������
     * <li>spclyn ���忩��
     * <li>seqno �Ϸù�ȣ
     * <li>insukind ��������
     * <li>rsrvtm �����Ͻ�
     * <li>payflagyn �޺񺯰濩��
     * <li>hosinhosoutflag �������ܱ���
     * </ul>
     * @throws LiveException
     */
	public ValueObject getInUnExecPrcpOrdRef(ValueObject pVO) throws LiveException;
	


	/**
     * <p> �ܷ��̽���ó�� ȯ�������� ��ȸ�Ѵ�.</p>
     * @author 
     * @param pVO ValueObject
     * <ul>
     * <li>pid ��Ϲ�ȣ
     * <li>instcd ����ڵ�
     * </ul>
     * @return ValueObject
     * <ul>
     * <li>pid ��Ϲ�ȣ
     * <li>patnm ����ڸ�
     * </ul>
     * @throws LiveException
     */
	public ValueObject getPayPatInfo(ValueObject pVO) throws LiveException;
	

	/**
     * <p> �ܷ��̽��� ó�� ������ ��ȸ�Ѵ�.</p>
     * @author 
     * @param pVO ValueObject
     * <ul>
     * <li>pid ��Ϲ�ȣ
     * <li>orddeptcd �����
     * <li>chk Ÿ�����Կ���
     * <li>chk2 ����ó�����Կ���
     * <li>fromdd ������
     * <li>todd ������
     * <li>instcd ����ڵ�
     * <li>sysdate ��������
     * </ul>
     * @return ValueObject
     * <ul>
     * <li>pid ��Ϲ�ȣ
     * <li>instcd ����ڵ�
     * <li>orddd ó����
     * <li>prcphopedd �ǽ������
     * <li>orddeptcd ������ڵ�
     * <li>orddeptnm �������
     * <li>orddrid ��ġ���ڵ�
     * <li>orddrnm ��ġ�Ǹ�
     * <li>insukind ��������
     * <li>cretno ������ȣ
     * </ul>
     * @throws LiveException
     */    
	public ValueObject getOutUnExecPrcpRef(ValueObject pVO) throws LiveException;
	
	
	
	/**
     * <p>�Կ� ó�� ������ ��ȸ�Ѵ�.</p>
     * @author 
     * @param pVO ValueObject
     * <ul>
     * <li>pid ��Ϲ�ȣ
     * <li>orddeptcd �����
     * <li>chk Ÿ�����Կ���
     * <li>chk2 ����ó�����Կ���
     * <li>fromdd ������
     * <li>todd ������
     * <li>instcd ����ڵ�
     * <li>sysdate ��������
     * </ul>
     * @return ValueObject
     * <ul>
     * <li>pid ��Ϲ�ȣ
     * <li>instcd ����ڵ�
     * <li>orddd ó����
     * <li>prcphopedd �ǽ������
     * <li>orddeptcd ������ڵ�
     * <li>orddeptnm �������
     * <li>orddrid ��ġ���ڵ�
     * <li>orddrnm ��ġ�Ǹ�
     * <li>insukind ��������
     * <li>cretno ������ȣ
     * </ul>
     * @throws LiveException
     */    
	public ValueObject getInUnExecPrcpRef(ValueObject pVO) throws LiveException;
	


	/**
     * <p> �ܷ��̽���ó�� �̽��� ���� ���սɻ� �Ϸ� ���θ� �����Ѵ�.</p>
     * @author 
     * @param pVO ValueObject
     * <ul>
     * <li>status ����
     * <li>prcpdd ó������
     * <li>prcpno ó���ȣ
     * <li>prcphistno ó���̷¹�ȣ
     * <li>execprcpseqno �ǽ�ó���Ϸù�ȣ
     * <li>judgendflag ���սɻ翩��
     * <li>instcd ����ڵ�
     * </ul>
     * @return int �����Ǽ�
     * @throws LiveException
     */
	public int setJudgEnd(ValueObject pVO) throws LiveException;


	/**
     * <p> ó�� �޺񱸺��ڵ带 �����Ѵ�.</p>
     * @author 
     * @param pVO ValueObject
     * <ul>
     * <li>prcpdd ó������
     * <li>prcpno ó���Ϸù�ȣ
     * <li>prcphistno ó���̷¹�ȣ
     * <li>payflagcd �޺񱸺��ڵ�
     * <li>chngid ������ID
     * <li>instcd ����ڵ�
     * </ul>
     * @return int �����Ǽ�
     * @throws LiveException
     */
	public int setOrdPayFlag(ValueObject pVO) throws LiveException;
	
	
	
	/**
     * <p> ó�� �޺񱸺��ڵ带 �����Ѵ�.</p>
     * @author 
     * @param pVO ValueObject
     * <ul>
     * <li>prcpdd ó������
     * <li>prcpno ó���Ϸù�ȣ
     * <li>prcphistno ó���̷¹�ȣ
     * <li>payflagcd �޺񱸺��ڵ�
     * <li>chngid ������ID
     * <li>instcd ����ڵ�
     * </ul>
     * @return int �����Ǽ�
     * @throws LiveException
     */
	public int setInOrdPayFlag(ValueObject pVO) throws LiveException;


	/**
     * <p> �ܷ��̽���ó�� �̽��� ���� Ư�� ������ �����Ѵ�.</p>
     * @author 
     * @param pVO ValueObject
     * <ul>
     * <li>delpid ��Ϲ�ȣ
     * <li>delorddd �ܷ��������
     * <li>delcretno �ܷ���� ������ȣ
     * <li>deledicd EDI�ڵ�
     * <li>delspclcd Ư���ڵ�
     * <li>instcd ����ڵ�
     * </ul>
     * @return int �����Ǽ�
     * @throws LiveException
     */
	public int delOutClcj(ValueObject pVO) throws LiveException;	


    /**
     * <p> �ܷ��̽���ó�� �̽��� ���� Ư�� ������ �Է��Ѵ�.</p>
     * @author 
     * @param pVO ValueObject
     * <ul>
     * <li>inspid ��Ϲ�ȣ
     * <li>insorddd �ܷ��������
     * <li>inscretno �ܷ���� ������ȣ
     * <li>prcpdd ó������
     * <li>prcpno ó���ȣ
     * <li>prcphistno ó���̷¹�ȣ
     * <li>execprcpseqno �ǽ�ó���Ϸù�ȣ
     * <li>unitflag ���սɻ�
     * <li>spclmemoflag Ư���޸𱸺�
     * <li>edicd EDI�ڵ�
     * <li>spclcd Ư���ڵ�
     * <li>spclspec Ư������
     * <li>remfact �������
     * <li>grupsnglyn �׷�̱ۿ���
     * <li>calcscorcd ó���ڵ�
     * <li>lastupdtrid ����������ID
     * <li>instcd ����ڵ�
     * </ul>
     * @return int �Է°Ǽ�
     * @throws LiveException
     */
	public int insOutClcj(ValueObject pVO) throws LiveException;


	/**
	 * <p> ó�� �޺񱸺��ڵ� ���� ��, �ܷ�ȯ�� ���� �̷������� �����Ѵ�. </p>
	 * @author
	 * @param pVO ValueObject
	 * <ul>
	 * <li>pid ȯ�ڹ�ȣ
	 * <li>orddd ��������
	 * <li>cretno ������ȣ
	 * <li>instcd ����ڵ�
	 * <li>fstrgstrid ���ʻ�����ID
	 * <li>lastupdtrid ����������ID
	 * </ul>
	 * @return int �Է°Ǽ�
	 * @throws LiveException
	 */	   
	public int setOutPatInfoHist(ValueObject pVO) throws LiveException;
	
	
	/**
	 * <p> ó�� �޺񱸺��ڵ� ���� ��, �Կ� �ұ����� �����Ѵ�. </p>
	 * @author
	 * @param pVO ValueObject
	 * <ul>
	 * <li>pid ȯ�ڹ�ȣ
	 * <li>orddd ��������
	 * <li>cretno ������ȣ
	 * <li>instcd ����ڵ�
	 * <li>fstrgstrid ���ʻ�����ID
	 * <li>lastupdtrid ����������ID
	 * </ul>
	 * @return int �Է°Ǽ�
	 * @throws LiveException
	 */	   
	public int setInPatInfoHist(ValueObject pVO) throws LiveException;


    /**
     * �ܷ�����
     * �����ҽ� ������ otpt�� hist���̺��� ���Ѵ�.
     * 2008.06.26. updated by ������
     * @param pVO ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getPreOtptHist(ValueObject pVO) throws LiveException;


	/**
     * �ܷ�����
     * �ܷ����� ������ OTPT�� ��걸�� ����
     * 2008.06.26. updated by ������
     * @param pVO ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int setOtptCalcflag(ValueObject pVO) throws LiveException;


	/**
     * �ܷ�����
     * �ܷ����� ������ OSCL ����
     * 2008.07.01. updated by ������
     * @param pVO ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int delOsclCancel(ValueObject pVO) throws LiveException;


    /*
     * ���ݿ����� ����Ʈ ���ι�ȣ
     * 2007.07.04. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getPidInfoCshb(ValueObject pVO) throws LiveException;


    /*
     * �ǻ�Ұ߼������˾� ��ȸ
     * 2007.07.07. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getDrcmList(ValueObject pVO) throws LiveException;


    /*
     * �ǻ�Ұ߼������˾� ����
     * 2007.07.07. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int insDrcmList(ValueObject pVO) throws LiveException;


    /*
     * �ǻ�Ұ߼������˾� ����
     * 2007.07.07. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int delDrcmList(ValueObject pVO) throws LiveException;

	
    /*
     * ȯ��ó�泻����ȸ
     * 2007.07.08. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getExopList(ValueObject pVO) throws LiveException;

	/*
     * ��곻�� ��ȸ
     * 2008.07.14. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getOsclList(ValueObject pVO ) throws LiveException;

	/*
     * �ܷ������� ��ϳ�����ȸ
     * 2008.07.23. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getRcptOtptList(ValueObject pVO) throws LiveException;

    /*
     * �湮��ȣ���ü��˾� ��ȸ
     * 2007.07.07. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getHocmList(ValueObject pVO) throws LiveException;

    /*
     * �湮��ȣ���ü��˾� ����
     * 2007.07.07. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int insHocmList(ValueObject pVO) throws LiveException;

    /*
     * �湮��ȣ���ü��˾� ����
     * 2007.07.07. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int delHocmList(ValueObject pVO) throws LiveException;


    /*
     * �ǻ�����ȣ��ȸ
     * 2007.07.07. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public ValueObject getUsrdlicnsno(ValueObject pVO) throws LiveException;


    /*
     * �ӻ󿬱���ȣ ��������
     * 2007.07.28. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getOscl_clincstdyno(ValueObject pVO) throws LiveException;


    /*
     * ���� Ȧ��ó�� ���� Ȯ��
     * 2007.08.01. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getHoldExop(ValueObject pVO) throws LiveException;


    /*
     * ���� �̼��� ó�� ���� Ȯ��
     * 2009.04.01. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getUnRcptExop(ValueObject pVO) throws LiveException;

	/*
     * B�� �������� ó��
     * 2007.08.04. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getVtcltrsCheck(ValueObject pVO) throws LiveException;

    /*
     * �ں��ѵ�ȯ�ںи��˾�
     * �ܷ���ϳ�����ȸ
     * @author cys
     * @param pVOs ValueObject
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getOtptCarInsu(ValueObject pVO) throws LiveException;

    /*
     * �ں��ѵ�ȯ�ںи��˾�
     * ó�泻����ȸ
     * @author cys
     * @param pVOs ValueObject
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getOprcCarInsu(ValueObject pVO) throws LiveException;

    /*
     * �ں��ѵ�ȯ�ںи��˾�
     * �ܷ�ó�� ������ �и�
     * @author cys
     * @param pVOs ValueObject
     * @return ValueObject
     * @throws LiveException
     */
	public int setOprcCarInsu(ValueObject pVO) throws LiveException;

    /*
     * �ں��ѵ�ȯ�ںи��˾�
     * �ܷ���� �̰����·� ����
     * @author cys
     * @param pVOs ValueObject
     * @return ValueObject
     * @throws LiveException
     */
	public int setOtptCarFlag(ValueObject pVO) throws LiveException;

	/**
     * <p> �ܷ������� ���ڸ޼��� �̷����̺� ����.</p>
     * @author 
     * @param pVO ValueObject
     * <ul>
     * <li>pid ��Ϲ�ȣ
     * <li>orddd �ܷ��������
     * <li>cretno �ܷ���� ������ȣ
     * <li>instcd ����ڵ�
     * </ul>
     * @return int �����Ǽ�
     * @throws LiveException
     */
	public int delOutOrdSmsq(ValueObject pVO) throws LiveException;	

    /**
     * <p>�ܷ����� ���� �������� Ŭ���� ����������ȸ</p>
     * 
     * 
     * @author 
     * @param pVO ValueObject
     * <p>otpt : �Էµ�����
     * <ul>
     * <li>pid ��Ϲ�ȣ
     * <li>orddd ��������
     * <li>ordtm ����ð�
     * <li>orddeptcd �����
     * <li>orddrid �����ǻ�
     * <li>fsexamflag ����������
     * <li>insukind ��������
     * <li>suppkind ��������
     * <li>calcflag ��걸��
     * <li>cretno �ܷ���ϻ�����ȣ
     * <li>acptseqno �ܷ�����̷¹�ȣ
     * <li>orgorddd ����������
     * <li>orgcretno ��������ȣ
     * <li>calcbaseflag �����ر���
     * <li>calcyn ���꿩��
     * <li>dutdeptcd �ٹ��μ��ڵ�
     * <li>centcd �����ڵ�
     * <li>supdeptcd �����μ��ڵ�
     * <li>mskind �ֺ�����
     * <li>insucd �������ڵ�
     * <li>suppkindresn ������������
     * <li>specordyn �������Ῡ��
     * <li>holiflag �����ϱ���
     * <li>fsexammanlyn �����������ο�����
     * <li>ordtype ��������
     * <li>brateflag �δ������
     * <li>medamtestmyn �������������
     * <li>medamtpostyn �������ĺҿ���
     * <li>medamtfreeresn �������������
     * <li>rsrvflag ���౸��
     * <li>etcordflag ��Ÿ���ᱸ��
     * <li>disccd �����ڵ�
     * <li>hosoutexptresncd ���ܿ��ܻ����ڵ�
     * <li>clincstdyacptflag �ӻ󿬱���������
     * <li>clincstdyno �ӻ󿬱���ȣ
     * <li>chrtlendyn íƮ���⿩��
     * <li>specorddescyn �������ἳ����
     * <li>ordreqdescyn �����Ƿڼ�������
     * <li>ordreqhospgrde �����Ƿڼ����������
     * <li>insuchrgyn ����ȸ�����ڿ���
     * <li>nursacptyn ��ȣ��������
     * <li>nursacptdt ��ȣ�����Ͻ�
     * <li>dracptyn �ǻ���������
     * <li>dracptdt �ǻ������Ͻ�
     * <li>prcpgenryn ó��߻�����
     * <li>prcpnotoccrresn ó��̹߻�����
     * <li>estmspclappyn ����Ư�����뿩��
     * <li>elbulbodstat �����ǻ���
     * <li>elbulbodstatdt �����ǻ����Է��Ͻ�
     * <li>calcmthdflag ���������
     * <li>dnoracptyn ��������������
     * <li>rqstflag �����Ƿڱ���
     * <li>rqsthospcd �����Ƿں���
     * <li>rqstdrid �����Ƿ��ǻ�
     * <li>ermngtamtcalcyn �������а������������
     * <li>erbrthflag ���޺и�����
     * <li>erchospath ���޳������
     * <li>erorddeptcd �����������
     * <li>erjudgstat ���޽ɻ����
     * <li>eroutrmnotidt ��������뺸�Ͻ�
     * <li>eroutrmdt ��������Ͻ�
     * <li>lastrcptendyn ������������
     * <li>inflag �����Կ�����
     * <li>tranindd ��ȯ�Կ�����
     * <li>rcptdd ��������
     * <li>rcptno ��������ȣ
     * <li>rcptseqno �������Ϸù�ȣ
     * <li>telrsrvrem ��ȭ�����������
     * <li>bforddd ������������
     * <li>bfordtm ��������ð�
     * <li>bforddeptcd ���������
     * <li>bforddrid ����������
     * <li>updtcnclresn ������һ���
     * <li>fstacptid ����������
     * <li>fstacptdt ���������Ͻ�
     * <li>fstrgstrid ���ʵ����
     * <li>fstrgstdt ���ʵ���Ͻ�
     * <li>lastupdtrid ���������
     * <li>lastupdtdt ��������Ͻ�
     * <li>checkflag üũ����
     * <li>instcd �����ȣ
     * </ul>
     * @return ValueObject
     * <p>h_opmi/opmi : ��µ�����
     * <ul>
     * <li>opmi_hidden 
     * <li>opmi_pid ȯ�ڹ�ȣ
     * <li>opmi_rcptdd ����������
     * <li>opmi_rcptno ��������ȣ
     * <li>opmi_rcptseqno �������Ϸù�ȣ
     * <li>opmi_instcd ����������ڵ�
     * <li>opmi_rcptstat ��������
     * <li>opmi_uncorcptflag �̼����걸��
     * <li>opmi_orddd �ܷ��������
     * <li>opmi_cretno �ܷ���ϻ�����ȣ
     * <li>opmi_acptseqno �ܷ�����Ϸù�ȣ
     * <li>opmi_orddeptcd ������ڵ�
     * <li>opmi_orddrid ������ID
     * <li>opmi_ordtype ��������
     * <li>opmi_mskind �ֺ�����
     * <li>opmi_insukind ��������
     * <li>opmi_suppkind ��������
     * <li>opmi_insucd �������ڵ�
     * <li>opmi_totamt �޿��ݾ�
     * <li>opmi_payamt �����
     * <li>opmi_nopyamt ��޿���
     * <li>opmi_allownbamt �޿����κδ�
     * <li>opmi_totnopyamt �Ѻ�޿�
     * <li>opmi_payownbamt ���κδ��
     * <li>opmi_payinsubamt �����ںδ��
     * <li>opmi_handcapfund ��ֱ��
     * <li>opmi_ersubtamt �Ƿ�޿���Ҿ�
     * <li>opmi_procsubtamt ���޴�Ҿ�
     * <li>opmi_subtamt 
     * <li>opmi_specamt ��������
     * <li>opmi_discreduamt ���ξ�
     * <li>opmi_discamt ����
     * <li>opmi_reduamt 
     * <li>opmi_bloddiscamt �������ξ�
     * <li>opmi_totownbamt �Ѻ��κδ��
     * <li>opmi_totownbamt2 �Ѻ��κδ��
     * <li>opmi_precashamt �����ݱݾ�
     * <li>opmi_premdlrcptamt ���߰�������
     * <li>opmi_precardamt ��ī��ݾ�
     * <li>opmi_preonlineamt ��¶��αݾ�
     * <li>opmi_mdlrcptamt �߰�������
     * <li>opmi_uncoamt �̼��ݾ�
     * <li>opmi_cardamt ī��ݾ�
     * <li>opmi_cashamt ���ݱݾ�
     * <li>opmi_onlineamt �¶��αݾ�
     * <li>opmi_rcptexptamt �Ǽ�����
     * <li>opmi_restamt �����
     * <li>opmi_hosindrugno ���������ȣ
     * <li>opmi_hosoutdrugno ���������ȣ
     * <li>opmi_calcmthdflag P:����,D:DRG,N:����,H:����
     * <li>opmi_remfact �������
     * <li>opmi_paypsnflag �����ڱ���
     * <li>opmi_paypsnrem �������������
     * <li>opmi_paydepoamt ������ �Աݱݾ�
     * <li>opmi_orgrcptdd �� ����������
     * <li>opmi_orgrcptno �� ��������ȣ
     * <li>opmi_orgrcptseqno �� �������Ϸù�ȣ
     * <li>opmi_rcptexecdd ������������
     * <li>opmi_rcpttm �����ð�
     * <li>opmi_rcptrid ������ID
     * <li>opmi_fstrgstrid ���ʵ����ID
     * <li>opmi_fstrgstdt ���ʵ���Ͻ�
     * <li>opmi_lastupdtrid ����������ID
     * <li>opmi_lastupdtdt ���������Ͻ�
     * <li>opmi_outpayownbrate �δ���
     * <li>opmi_nopyinsubamt ��޿������ںδ��
     * <li>opmi_nopyownbamt ��޿����κδ��
     * <li>opmi_allowninsubamt ���׺��κ����ںδ��
     * <li>opmi_allownownbamt ���׺��κ��κδ��
     * <li>opmi_specinsubamt ��������ẻ�κδ��
     * <li>opmi_specownbamt ��������ẻ�κδ��
     * <li>opmi_totnopyownbamt �Ѻ�޿����κδ�
     * <li>opmi_totnopyinsubamt �Ѻ�޿������ںδ�
     * <li>opmi_heallifeamtclamamt �ǰ���Ȱ������û����
     * <li>opmi_labamt 
     * <li>opmi_clincstdyno �ӻ󿬱��ڵ�
     * <li>opmi_orgorddd ����������
     * <li>opmi_orgcretno ����ϻ�����ȣ
     * </ul>
     * @throws LiveException
     */
    public ValueObject getOutJOpmiList(ValueObject pVO) throws LiveException;

    /**
     * <p>�ִ�����������ϱ�</p>
     * 
     * 
     * @author 
     * @param pVO ValueObject
     * <p>otpt : �Էµ�����
     * <ul>
     * <li>pid ��Ϲ�ȣ
     * <li>orddd ��������
     * </ul>
     * @return ValueObject
     * <p>h_opmi/opmi : ��µ�����
     * <ul>
     * <li>opmi_acptseqno �ܷ�����Ϸù�ȣ
     * </ul>
     * @throws LiveException
     */
    public ValueObject getOtptMaxAcptseqno(ValueObject pVO) throws LiveException;

    /**
     * <p>�ǰ���Ȱ��������ȸ</p>
     * ����ȭ�鿡�� �ҷ�����
     * @param pVOs ValueObject
     * <p>req : �Էµ�����
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
     * <p>�ǰ���Ȱ��������ȸ</p>
     * ������������ �ҷ�����
     * @param pVOs ValueObject
     * <p>req : �Էµ�����
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
     * <p>�ǽ����� ������ ��ȸ</p>
     * ������������ �ҷ�����
     * @param pVOs ValueObject
     * <p>req : �Էµ�����
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
     * <p>��ֱ��  ��ȸ</p>
     * ������������ �ҷ�����
     * @param pVOs ValueObject
     * <p>req : �Էµ�����
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
	 * <p>ī��������� ��ȸ</p>
	 * ī��������� ��ȸ(�ܷ��������� ȭ��)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>fromdd			�������� 
	 * <li>todd 			�������� 
	 * <li>pid 				��Ϲ�ȣ 
	 * <li>orddeptcd 		�����
	 * <li>insukind			��������
	 * <li>cardno			ī���ȣ			
	 * </ul>
	 * @return ValueObject
	 * <p>cardl		 : ��µ�����
	 * <ul>
	 * <li>rcptdd		��������      
	 * <li>rcptno		��������ȣ    
	 * <li>rcptseqno	�������Ϸù�ȣ
	 * <li>seqno		�Ϸù�ȣ      
	 * <li>instcd		����ڵ�      
	 * <li>rcpstat		��������      
	 * <li>ordtype		��������      
	 * <li>keyinptflag	Ű�Է±���    
	 * <li>cardcmpycd	ī����ڵ�    
	 * <li>cardno		ī���ȣ      
	 * <li>aprvflag		���α���      
	 * <li>aprvdd		��������      
	 * <li>aprvtm		���νð�	
	 * <li>aprvno		���ι�ȣ      
	 * <li>vancd		van�ڵ�       
	 * <li>allotmm		�Һΰ�����    
	 * <li>cardamt		ī��ݾ�      
	 * <li>valiterm		��ȿ�Ⱓ      
	 * <li>rcptexecdd	��������      
	 * <li>rcpttm		�����ð�      
	 * <li>rcptid	 	������ID      
	 * <li>remfact		�������      
	 * </ul>
	 * @throws LiveException
	 */
	public ValueObject getcardList(ValueObject pVO) throws LiveException;


	/**
	 * <p>���ݿ������������� ��ȸ</p>
	 * ���ݿ������������� ��ȸ(�ܷ��������� ȭ��)
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>fromdd			�������� 
	 * <li>todd 			�������� 
	 * <li>pid 				��Ϲ�ȣ 
	 * <li>orddeptcd 		�����  
	 * <li>insukind			��������
	 * <li>cardno			�ڰݹ�ȣ	
	 * </ul>
	 * @return ValueObject
	 * <p>cashlist	 : ��µ�����
	 * <ul>
	 * <li>rcptdd		��������      
	 * <li>rcptno		��������ȣ    
	 * <li>rcptseqno	�������Ϸù�ȣ
	 * <li>seqno		�Ϸù�ȣ      
	 * <li>instcd		����ڵ�      
	 * <li>rcpstat		��������      
	 * <li>ordtype		��������      
	 * <li>qualcnfmflag	Ű�Է±���    
	 * <li>qualcnfmno 	ī����ڵ�    
	 * <li>aprvflag		���α���      
	 * <li>aprvdd		��������      
	 * <li>aprvtm		���νð�	
	 * <li>aprvno		���ι�ȣ      
	 * <li>cashamt		���ݱݾ�      
	 * <li>rcptexecdd	��������      
	 * <li>rcpttm		�����ð�      
	 * <li>rcptid	 	������ID      
	 * <li>remfact		�������      
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getcashList(ValueObject pVO) throws LiveException;

	
	/**
	 * <p>�¶����Աݼ����� ��ȸ</p>
	 * �¶����Աݼ����� ��ȸ
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>fromdd			�������� 
	 * <li>todd 			�������� 
	 * <li>pid 				��Ϲ�ȣ 
	 * <li>orddeptcd 		�����
	 * <li>insukind			��������
	 * <li>cardno			�Ա���		
	 * </ul>
	 * @return ValueObject
	 * <p>onlinelist	 : ��µ�����
	 * <ul>
	 * <li>rcptdd		��������      
	 * <li>rcptno		��������ȣ    
	 * <li>rcptseqno	�������Ϸù�ȣ
	 * <li>seqno		�Ϸù�ȣ      
	 * <li>instcd		����ڵ�      
	 * <li>rcpstat		��������      
	 * <li>ordtype		��������      
	 * <li>bankcd		�����ڵ�      
	 * <li>acntno		���¹�ȣ      
	 * <li>paydd		�Ա�����      
	 * <li>paypsnnm		�Ա��ڸ�      
	 * <li>onlineamt	�¶��αݾ�    
	 * <li>rcptexecdd	��������      
	 * <li>rcpttm		�����ð�      
	 * <li>rcptid	 	������ID      
	 * <li>remfact		�������      
	 * </ul>
	 * @throws LiveException
	 */
	public ValueObject getonlnList(ValueObject pVO) throws LiveException;

	/*
     * �������ü
     * 2008.07.16. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getbldcList(ValueObject pVO) throws LiveException;

	/*
     * �� ���鳻����ȸ
     * 2008.09.18. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getdcgmList(ValueObject pVO) throws LiveException;

	/*
     * �� ���鳻����ȸ 0��������
     * 2009.06.12. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	//public ValueObject getdcgmList_zero(ValueObject pVO) throws LiveException;

	/*
     * �� �̼�������ȸ
     * 2008.09.19. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getuncoList(ValueObject pVO) throws LiveException;

	/*
     * �Ϲ���-Ư���� ����
     * 2008.09.22. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int setSpecOrdChng(ValueObject pVO) throws LiveException;

	/*
     * �ܷ����� ȯ���������
     * 2008.09.22. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getInptInfo(ValueObject pVO) throws LiveException;

	/*
     * �ܷ����� ȯ�� ���������
     * 2009.07.01. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getInptInfo_c(ValueObject pVO) throws LiveException;

	/*
     * �ܷ����� ������ ������������
     * 2008.09.23. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int setOtptSrdg(ValueObject pVO) throws LiveException;

	/*
     * �ܷ����� ����Ư�ʽ� ������������
     * 2009.03.04. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int setOtptEstm(ValueObject pVO) throws LiveException;

	/*
     * �ǻ�Ұ߼� ����ó��� ���������
     * 2008.09.28. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public int setOtpt_drcm(ValueObject pVO) throws LiveException;


	//������ȸ
	public int setPatInsu(ValueObject pVO) throws LiveException;


	//������ȸ
	public int insPatInsu(ValueObject pVO) throws LiveException;


	/*
     * VAN ���߽��� ���� üũ
     * 2008.10.14. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return int
     * @throws LiveException
     */
	public ValueObject getEmtyVanCk(ValueObject pVO) throws LiveException;

	
    /*
     * ȯ�ڿ���ó�泻����ȸ
     * 2008.10.15. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getExopActList(ValueObject pVO) throws LiveException;
	
	
	/*
     * ����̽�ȯ������ ��ȸ
     * 2011.12.02
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getTranInfo(ValueObject pVO) throws LiveException;


	/**
	 * <p>ȯ�ں���������ȸ(����ȭ��)</p>
	 * Ű���� ��������
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>pid 				��Ϲ�ȣ	 
	 * <li>insukind	 
	 * <li>suppkind	 
	 * <li>todd	 
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */	
	public ValueObject getPtin2(ValueObject pVO) throws LiveException;


    /*
     * �������� maxŰ���ؿ���
     * 2008.10.15. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public ValueObject getPtin_maxseqno(ValueObject pVO) throws LiveException;


    /*
     * �������� ����
     * 2008.10.15. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int setPtinUpdate(ValueObject pVO) throws LiveException;


	//�ܷ�������� Ȧ����·� ����
	public int setOtptHoldFlag(ValueObject pVO) throws LiveException;
	
	//�ܷ����賻�� ���º���
	public ValueObject getLastPtin(ValueObject pVO) throws LiveException;


    /*
     * ������� ó���� �̼��� ���������� ������Ʈ
     * 2008.11.12. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int setUncoEndApprsn(ValueObject pVO) throws LiveException;


    /*
     * �ܷ����� ȯ�� �������� ����
     * 2008.11.20. updated by ������
     * 
     * @param pVOs ValueObject {}
     * @return ValueObject
     * @throws LiveException
     */
	public int setPtbsInfo(ValueObject pVO) throws LiveException;


	/**
	 * <p>�ܷ����� ����� ���ȣ��</p>
	 * �ܷ����� ����� ���ȣ��
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>pid 			��Ϲ�ȣ 
	 * <li>srchcond		��ȸ����
	 * </ul>
	 * @return ValueObject
	 * <p>remamt	 : �ܷ������� �ܾ�
	 * <ul>
	 * <li>remamt		�ܾ�
	 * </ul>
	 * @throws LiveException
	 */
	public ValueObject getCallCalc_Otpt(ValueObject pVO) throws LiveException;
	
	
	
	/**
	 * <p>���κδ㱸�� üũ</p>
	 * M005, M006 ���κδ��� ��� ���� ����/��Ͱ� �ƴҰ�� '-'�� ������Ʈ
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>pid 			��Ϲ�ȣ 
	 * <li>srchcond		��ȸ����
	 * </ul>
	 * @return int
	 * @throws LiveException
	 */
	public int setOwnbflagCheck(ValueObject pVO) throws LiveException;
	
	
	
	/**
	 * <p>���κδ㱸�� üũ</p>
	 * M005, M006 ���κδ��� ��� ���� ����/��Ͱ� �ƴҰ�� üũ
	 * 
	 *
	 * @param pVO ValueObject
	 * <p>req : �Էµ�����
	 * <ul>
	 * <li>pid 			��Ϲ�ȣ 
	 * <li>srchcond		��ȸ����
	 * </ul>
	 * @return ValueObject
	 * @throws LiveException
	 */
	public ValueObject getOwnbflagCheckInfo(ValueObject pVO) throws LiveException;


    /**
     * <p>OSCL�� Y(����),R(���) ���� ��ȸ </p>
     *
     * @param pVOs ValueObject
     * <p>req : �Էµ�����
     * <ul>
     * <li>pid                 ��Ϲ�ȣ         
     * <li>orddd            ��������        
     * <li>cretno           ������ȣ   
     * </ul>
     * @return ValueObject
     * <p>oscl_r , oscl_y   : OSCL�� Y(����),R(���) ���� ��ȸ
	 * <ul>
	 * <li>hidden                                     	
	 * <li>pid	ȯ�ڹ�ȣ                                                            
	 * <li>orddd	��������                                                          
	 * <li>cretno	������ȣ                                                           
	 * <li>calcseqno	����Ϸù�ȣ                                                  
	 * <li>calcscorseqno	��곻�����Ϸù�ȣ                                   
	 * <li>instcd	����ڵ�                                                       
	 * <li>calcstat	������                                                      
	 * <li>clamtrgtstat	û��������                                             
	 * <li>acptseqno	�ܷ���ϻ�����ȣ���Ϸù�ȣ                         
	 * <li>orddeptcd	������ڵ�                                                    
	 * <li>orddrid	�����ǻ�                                                          
	 * <li>mskind	�ֺ�����                                                          
	 * <li>ordtype	��������                                                         
	 * <li>grupcalcscorcd	�׷�����ڵ�                                               
	 * <li>snglcalcscorcd	�̱ۼ����ڵ�                                                
	 * <li>grupcalcscorcls	ó������з�                                               
	 * <li>snglcalcscorcls	�������з�                                                
	 * <li>grupearncls	�׷���ͱ����ڵ�                                           
	 * <li>snglearncls          	�̱ۼ��ͱ����ڵ�                                               
	 * <li>ordqty                	ó������������                                                    
	 * <li>ordtims               	ó����������Ƚ��                                                
	 * <li>orddays              	ó�����������ϼ�                                                
	 * <li>calcqty               	���������                                                          
	 * <li>calctims              	�������Ƚ��                                                       
	 * <li>calcdays             	��������ϼ�                                                      
	 * <li>matractflag        	�����������                                                     
	 * <li>calcpayflag         	���޿�����                                                     
	 * <li>prcppayflag        	ó��޿�����                                                    
	 * <li>calcscorpayflag   	�����޿�����                                                   
	 * <li>ansttm                	����ð�                                                              
	 * <li>spccd                 	��ü�ڵ�                                                              
	 * <li>pntunitcost         	����ܰ�                                                            
	 * <li>calcscorpnt         	��������                                                           
	 * <li>estmpnt              	��������                                                             
	 * <li>calcamt               	���ݾ�                                                             
	 * <li>hospaddamt         	����  * ����������                                         
	 * <li>specamt              	������                                                                
	 * <li>payamt               	�޿��ݾ�                                                             
	 * <li>allownbamt         	���׺��κδ��                                                 
	 * <li>nopyamt              	��޿���                                                            
	 * <li>payownbrate       	���κδ���                                                      
	 * <li>payinsubamt        	�޿������ںδ��                                             
	 * <li>payownbamt        	�޿����κδ��                                                
	 * <li>paydiscamt         	�޿����αݾ�                                                     
	 * <li>nopydiscamt        	��޿����αݾ�                                                 
	 * <li>specdiscamt        	�����������αݾ�                                              
	 * <li>hosoutexptresncd	���ܿ��ܻ����ڵ�                                           
	 * <li>hosoutdrugno       	����ó������ȣ                                                 
	 * <li>specyn                	�������Ῡ��                                                       
	 * <li>execdeptcd         	�ǽúμ��ڵ�                                                    
	 * <li>execdd               	�ǽ�����                                                             
	 * <li>exectm               	�ǽýð�                                                             
	 * <li>execenddd          	���͸�������                                                     
	 * <li>execendtm          	���͸����ð�                                                     
	 * <li>clamspclcd          	û��Ư���ڵ�                                                     
	 * <li>clamkey              	û��Ű                                                                
	 * <li>clamcretdd         	û����������                                                     
	 * <li>clamcretyn          	û����������                                                     
	 * <li>estmcls               	�����з�                                                              
	 * <li>estmmeancd          	�������п������ǹ��ڵ�                                     
	 * <li>estmcd                	�����ڵ�                                                             
	 * <li>readdrid             	�ǵ���ID                                                           
	 * <li>clincstdyno         	�ӻ�����ȣ                                                     
	 * <li>exitprvntdrugyn  	��������Ǿ�ǰ����                                        
	 * <li>exitprvntdrugamt	��������Ǿ�ǰ�ݾ�                                        
	 * <li>trustaddrate       	��Ź�����                                                       
	 * <li>bothaddyn          	�����Կ�����ó��                                              
	 * <li>prcpdd               	ó������                                                             
	 * <li>prcpno                	ó���ȣ                                                             
	 * <li>prcphistno          	ó���̷¹�ȣ                                                     
	 * <li>execprcpseqno    	�ǽ�ó���Ϸù�ȣ                                            
	 * <li>cvrtinprcpdeptcd      	��ȯ�Կ�ó��������ڵ�                                  
	 * <li>cvrtinprcpdrid    	��ȯ�Կ�ó��������ID                                      
	 * <li>rcptdd                	������ ó������                                                   
	 * <li>rcptno                	��������ȣ                                                          
	 * <li>rcptseqno           	�������Ϸù�ȣ                                                  
	 * <li>rcptexecdd         	�Ǽ�������                                                       
	 * <li>rcpttm                	�Ǽ����ð�                                                          
	 * <li>fstrgstrid           	���ʵ����                                                         
	 * <li>fstrgstdt            	���ʵ���Ͻ�                                                      
	 * <li>lastupdtrid         	����������                                                         
	 * <li>lastupdtdt          	���������Ͻ�                                                      
	 * <li>holdyn                	HOLD����                                                           
	 * <li>snglcalcscorcdnm 	�����ѱ۸�                                    
  	 * <li>owntotamt           	���κδ��Ѿ�                                                     
 	 * <li>execprcpstatcd   	ó�����                                                         
	 * <li>execprcphistcd 	�����̷�   
     * </ul>
     * @throws LiveException
     */
    public ValueObject getOsclRY(ValueObject pVO) throws LiveException;

	//0�� ���� �������̽� - ��� otpt��������
	public ValueObject getIFOAmtZeroOtpt(ValueObject pVO) throws LiveException;

	//0�� ���� �������̽� - ������ sum
	public ValueObject getIFOAmtZeroOscl(ValueObject pVO) throws LiveException;

	//0�� ���� �������̽� - 0������ ��� ����ġ�� ����Ʈ ��������
	public ValueObject getMjquList(ValueObject pVO) throws LiveException;

    //0�� ���� �������̽� - 0������ ��� ���̺� ����ó��
	public int setOutOrdEndMjqu(ValueObject pVO) throws LiveException;

	//����ó�� ������� �˾� - ��ȸ
	public ValueObject getPopupMjquList(ValueObject pVO) throws LiveException;

	//������ �ܷ�ó�����̺� ���°� �ѹ�
	public int setRollBackExop(ValueObject pVO) throws LiveException;

	//ȯ�ں� ���� ��ȸ
	public ValueObject getSrdg(ValueObject pVO) throws LiveException;

	//0�������� �̼� �������� ��ȸ
	public ValueObject getuncoList2(ValueObject pVO) throws LiveException;

	//���� �����ڵ� ��ȸ
	public ValueObject getHospcd(ValueObject pVO) throws LiveException;

	//����vip �������ȸ
	public ValueObject getVipStandList(ValueObject pVO) throws LiveException;

	//���� �ڰ���ȸ ���� üũ
	public ValueObject getMmsg2Check(ValueObject pVO) throws LiveException;

	//����ó�� ������� �˾� - ó�渮��Ʈ
	public ValueObject getPopupMjexList(ValueObject pVO) throws LiveException;

	//����ó�� ���� üũ
	public ValueObject getChkOtptMJ(ValueObject pVO) throws LiveException;

    //���������ڵ� (desc��ȸ)
	public ValueObject getPmcmCode(ValueObject pVO) throws LiveException;

	//���������ڵ� (cdid��ȸ)
	public ValueObject getPmcmCodeNm(ValueObject pVO) throws LiveException;

    //ZBCMCODE �����ڵ���ȸ
    public ValueObject getZbcmCode(ValueObject pVO) throws LiveException;
    
    //����ó���ȯ, ��üó�� ���� table ���� ���� ���� ó�� 
	public int setOPCGStat(ValueObject pVO) throws LiveException;

    /**
     * <p>�ǰ����� ���� ��ȸ</p>
     *
     * @param pVO ValueObject
     * <p>req : �Էµ�����
     * <ul>
     * <li>pid    ��Ϲ�ȣ 
     * </ul>
     * @return ValueObject
     * <ul>
     * <li>pid    ��Ϲ�ȣ
     * <li>orddd   ��������
     * </ul>
     * @throws LiveException
     */
    public ValueObject getCheckMediExamInfo(ValueObject pVO) throws LiveException;

    /**
     * <p>���޽� ���� ��ȸ</p>
     *
     * @param pVO ValueObject
     * <p>req : �Էµ�����
     * <ul>
     * <li>pid    ��Ϲ�ȣ 
     * </ul>
     * @return ValueObject
     * <ul>
     * <li>pid    ��Ϲ�ȣ
     * <li>orddd   ��������
     * </ul>
     * @throws LiveException
     */
    public ValueObject getCheckERInfo(ValueObject pVO) throws LiveException;

    //view�� ��� �����ڵ� üũ[_,= ��������]
	public ValueObject getViewCalcChk(ValueObject pVO) throws LiveException;

    //oscl�� Y�ΰ� ��ȸ�ؼ� R�� �����
	public int setOsclY_dump(ValueObject pVO) throws LiveException;

    //�ǽ������ �ǽ��������̺� �Է�
	public int setOutOrdActr(ValueObject pVO) throws LiveException;

    //�ǽ������ �ǽ��������̺� ����
	public int delOutOrdActr(ValueObject pVO) throws LiveException;

    //�ǽ����� ���ȯ�� ��ȸ
	public ValueObject getPopupActrList(ValueObject pVO) throws LiveException;

	//�ǽ����� ���ȯ�� �˾� - ó�渮��Ʈ
	public ValueObject getPopupActrExopList(ValueObject pVO) throws LiveException;

	//�������� ���������̼� üũ
	public ValueObject getPrvntMedc(ValueObject pVO) throws LiveException;
	
	//��õ������̻�˻� ��õ������̻� [inborn errors of metabolism] �̼� ���1ȸ
	public ValueObject getInbornError(ValueObject pVO) throws LiveException;
	
	/**
	 * <p>Ÿ�� �������� ���� otpt ��ȸ</p>
	 *
	 * @param pVO ValueObject
	 * <p>pVO : �Էµ�����
	 * <ul>
	 * <li>pid 				��Ϲ�ȣ
	 * <li>orddd 			��������
	 * <li>sessinstcd 			�����ȣ
	 * </ul>
	 * @return ValueObject
	 * <p>retVO	 : 			��µ�����
	 * <ul>
	 * <li>pid 				��Ϲ�ȣ
	 * <li>orddd 			��������
	 * <li>cretno 			������ȣ
	 * <li>instcd 			�����ȣ
	 * <li>....  
	 * <li>lastupdtrid	    ����������ID
	 * <li>lastupdtdt		���������Ͻ�
	 * </ul>
	 * @throws LiveException
	 */	
	public ValueObject getOrdOTPTRef(ValueObject pVO) throws LiveException;

    //����μ�ø�������� üũ
    public ValueObject getHndcCnt(ValueObject pVO) throws LiveException;

    //�̼� �Աݿ��� üũ
    public ValueObject getUncoStatYCnt(ValueObject pVO) throws LiveException;

    //������ ������ ���� üũ
    public ValueObject getChkCertList(ValueObject pVO) throws LiveException;

    //������ ONLN �����Աݾ� CD����
    public int insOnlnAmtDC(ValueObject pVO) throws LiveException;

    //������ ONLN �����Աݾ� CD����
    public int setOnlnAmtC(ValueObject pVO) throws LiveException;
    
    //�ܱ��� üũ �� oecd ���� üũ
    public ValueObject getPatOectChk(ValueObject pVO) throws LiveException;
    
	/**
	 * �����Ƿڳ��� ��ȸ
	 * 
	 * @param pVO ValueObject
	 * <ul>
     * <li>cnst_pid ȯ�ڵ�Ϲ�ȣ
     * <li>cnst_todd ��������
     * <li>cnst_fromdd ��������
     * </ul>
	 * @return ValueObject
	 * <ul>
     * <li>cnst_pid ȯ�ڵ�Ϲ�ȣ
     * <li>cnst_orddeptcd ������ڵ�
     * <li>cnst_insuflag ���豸�к�ȣ/���豸��
     * <li>cnst_ordreqkind �����Ƿڼ� ����
     * <li>cnst_todd ��������
     * <li>cnst_seqno �Ϸù�ȣ
     * <li>cnst_instcd ����ڵ�
     * <li>cnst_histstat �̷»���
     * <li>cnst_fromdd ��������
     * <li>cnst_reqformhospnm �Ƿں�����
     * <li>cnst_reqformdrnm �Ƿ��ǻ��
     * <li>cnst_remfact �������
     * <li>cnst_fstrgstrid ���ʵ����ID
     * <li>cnst_fstrgstdt ���ʵ���Ͻ�
     * <li>cnst_lastupdtrid ����������ID
     * <li>cnst_lastupdtdt ���������Ͻ�
     * </ul>
	 * @throws LiveException
	 */
	public ValueObject getCNST1(ValueObject pVO) throws LiveException;       
    
	//����ó���� ��� 2010/06/11 cys
	public ValueObject getHosoOutOrderList(ValueObject pVO) throws LiveException;	
    
	/**
     * <p>Ÿ���� ���� ó��</p>
     * 
     * @param pVOs ValueObject
     * <p>req : �Էµ�����
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

	//�ܷ�������ȭ�� �̼��ܾ� �������� 20110127 cys
	public ValueObject getUncoRemAmt(ValueObject pVO) throws LiveException;
    
    //ó��Ư������ N���� ���� 20110401 cys
    public int setChngSpecN(ValueObject pVO) throws LiveException;

    //ó��Ư������ ���� 20110401 cys
    public int setChngSpecR(ValueObject pVO) throws LiveException;

    //Ư������ ������ ��Ҵ��� ����20110415 cys
    public int setDelSpltList1(ValueObject pVO) throws LiveException;

	//��Ȱ���а� �̿���ȯ�� ���޼��� üũ 20110426 cys
	public ValueObject getChkEtcM(ValueObject pVO) throws LiveException;
	
	//�Ǻ�, �Ǻ� �ڰ� ���� ��ȸ
	public ValueObject checkInsuInfo(ValueObject pVO) throws LiveException;
	
	public ValueObject getUncoAmtSMSDetlSpec(ValueObject pVO) throws LiveException;
    
    public ValueObject getUncoAmtSMSMsg(ValueObject pVO) throws LiveException;
    
    public ValueObject getUncoAmtSMSSpec(ValueObject pVO) throws LiveException;
    
    public ValueObject getUncoAmtSMSTrsmSpec(ValueObject pVO) throws LiveException;
    
    public int setUncoAmtSMSTrsm(ValueObject pVO) throws LiveException;
    
    public ValueObject getDiscListChk(ValueObject pVO) throws LiveException;
    
    public int setSpclcd(ValueObject pVO) throws LiveException;
    
    /**
     * ������ WorkUp ȯ�� ��üũ
     * 
     * @param pVO
     * @return ValueObject
     * @throws LiveException
     */
    public ValueObject getCheckWorkUpDiag(ValueObject pVO) throws LiveException;
}