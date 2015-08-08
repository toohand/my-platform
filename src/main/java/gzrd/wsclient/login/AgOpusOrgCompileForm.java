
package gzrd.wsclient.login;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>agOpusOrgCompileForm complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="agOpusOrgCompileForm">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="allAllocationAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="allAllocationAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="armyToGoverment" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="beyondOrgCompileAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="beyondOrgCompileAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="borrowPeople" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="careerCompileAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="careerCompileAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="companyManageAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="companyManageAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="compileTotalAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="compileTotalAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="deptAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="deptAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="deptLeaderAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="deptLeaderAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="deptLeaderPrefAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="deptLeaderPrefAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="deptLeaderTotalAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="deptLeaderTotalAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="diffSubsidyAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="diffSubsidyAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="directorClearAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="directorClearAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="dispatchOrgCompileAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="dispatchOrgCompileAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="elseCompileAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="elseCompileAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="elseLeaderAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="elseLeaderAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="elseOrgCompileAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="elseOrgCompileAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="financialAllocationAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="financialAllocationAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="floorwalkerAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="floorwalkerAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="fundBySelfAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="fundBySelfAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="fundCompileTotalAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="fundCompileTotalAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="gqCompileAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="gqCompileAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="hqgwAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="hqgwAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="investigatorAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="investigatorAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="jjCompileAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="jjCompileAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="jjLeaderAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="jjLeaderAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="leaderAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="leaderAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="leaderPrefAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="leaderPrefAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="leaderTotalAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="leaderTotalAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="leaveRetired" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ltfwCompileAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ltfwCompileAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="notLeaderTotalAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="notLeaderTotalAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="notOnline" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="orgCompileAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="orgCompileAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="orgCompileId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="orgId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="overstaffedCause" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ownDefineAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ownDefineAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="prefDirectorClearAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="prefDirectorClearAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="prefFloorwalkerAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="prefFloorwalkerAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="prefInvestigatorAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="prefInvestigatorAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="prefSecAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="prefSecAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="pzjjjgCompileAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="pzjjjgCompileAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="qtryAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="qtryAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="scgrAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="scgrAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="secAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="secAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="singlelineCompileAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="singlelineCompileAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="threeChiefAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="threeChiefAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="totalPositionAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="totalPositionAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="workerChairmanAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="workerChairmanAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="xzCompileAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="xzCompileAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="xzglAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="xzglAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="zfCompileAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="zfCompileAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="zfTeamCompileAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="zfTeamCompileAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="zfzxCompileAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="zfzxCompileAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="zyjsAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="zyjsAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "agOpusOrgCompileForm", propOrder = {
    "allAllocationAct",
    "allAllocationAppr",
    "armyToGoverment",
    "beyondOrgCompileAct",
    "beyondOrgCompileAppr",
    "borrowPeople",
    "careerCompileAct",
    "careerCompileAppr",
    "companyManageAct",
    "companyManageAppr",
    "compileTotalAct",
    "compileTotalAppr",
    "deptAct",
    "deptAppr",
    "deptLeaderAct",
    "deptLeaderAppr",
    "deptLeaderPrefAct",
    "deptLeaderPrefAppr",
    "deptLeaderTotalAct",
    "deptLeaderTotalAppr",
    "diffSubsidyAct",
    "diffSubsidyAppr",
    "directorClearAct",
    "directorClearAppr",
    "dispatchOrgCompileAct",
    "dispatchOrgCompileAppr",
    "elseCompileAct",
    "elseCompileAppr",
    "elseLeaderAct",
    "elseLeaderAppr",
    "elseOrgCompileAct",
    "elseOrgCompileAppr",
    "financialAllocationAct",
    "financialAllocationAppr",
    "floorwalkerAct",
    "floorwalkerAppr",
    "fundBySelfAct",
    "fundBySelfAppr",
    "fundCompileTotalAct",
    "fundCompileTotalAppr",
    "gqCompileAct",
    "gqCompileAppr",
    "hqgwAct",
    "hqgwAppr",
    "investigatorAct",
    "investigatorAppr",
    "jjCompileAct",
    "jjCompileAppr",
    "jjLeaderAct",
    "jjLeaderAppr",
    "leaderAct",
    "leaderAppr",
    "leaderPrefAct",
    "leaderPrefAppr",
    "leaderTotalAct",
    "leaderTotalAppr",
    "leaveRetired",
    "ltfwCompileAct",
    "ltfwCompileAppr",
    "notLeaderTotalAct",
    "notLeaderTotalAppr",
    "notOnline",
    "orgCompileAct",
    "orgCompileAppr",
    "orgCompileId",
    "orgId",
    "overstaffedCause",
    "ownDefineAct",
    "ownDefineAppr",
    "prefDirectorClearAct",
    "prefDirectorClearAppr",
    "prefFloorwalkerAct",
    "prefFloorwalkerAppr",
    "prefInvestigatorAct",
    "prefInvestigatorAppr",
    "prefSecAct",
    "prefSecAppr",
    "pzjjjgCompileAct",
    "pzjjjgCompileAppr",
    "qtryAct",
    "qtryAppr",
    "scgrAct",
    "scgrAppr",
    "secAct",
    "secAppr",
    "singlelineCompileAct",
    "singlelineCompileAppr",
    "threeChiefAct",
    "threeChiefAppr",
    "totalPositionAct",
    "totalPositionAppr",
    "workerChairmanAct",
    "workerChairmanAppr",
    "xzCompileAct",
    "xzCompileAppr",
    "xzglAct",
    "xzglAppr",
    "zfCompileAct",
    "zfCompileAppr",
    "zfTeamCompileAct",
    "zfTeamCompileAppr",
    "zfzxCompileAct",
    "zfzxCompileAppr",
    "zyjsAct",
    "zyjsAppr"
})
public class AgOpusOrgCompileForm {

    protected Long allAllocationAct;
    protected Long allAllocationAppr;
    protected Long armyToGoverment;
    protected Long beyondOrgCompileAct;
    protected Long beyondOrgCompileAppr;
    protected Long borrowPeople;
    protected Long careerCompileAct;
    protected Long careerCompileAppr;
    protected Long companyManageAct;
    protected Long companyManageAppr;
    protected Long compileTotalAct;
    protected Long compileTotalAppr;
    protected Long deptAct;
    protected Long deptAppr;
    protected Long deptLeaderAct;
    protected Long deptLeaderAppr;
    protected Long deptLeaderPrefAct;
    protected Long deptLeaderPrefAppr;
    protected Long deptLeaderTotalAct;
    protected Long deptLeaderTotalAppr;
    protected Long diffSubsidyAct;
    protected Long diffSubsidyAppr;
    protected Long directorClearAct;
    protected Long directorClearAppr;
    protected Long dispatchOrgCompileAct;
    protected Long dispatchOrgCompileAppr;
    protected Long elseCompileAct;
    protected Long elseCompileAppr;
    protected Long elseLeaderAct;
    protected Long elseLeaderAppr;
    protected Long elseOrgCompileAct;
    protected Long elseOrgCompileAppr;
    protected Long financialAllocationAct;
    protected Long financialAllocationAppr;
    protected Long floorwalkerAct;
    protected Long floorwalkerAppr;
    protected Long fundBySelfAct;
    protected Long fundBySelfAppr;
    protected Long fundCompileTotalAct;
    protected Long fundCompileTotalAppr;
    protected Long gqCompileAct;
    protected Long gqCompileAppr;
    protected Long hqgwAct;
    protected Long hqgwAppr;
    protected Long investigatorAct;
    protected Long investigatorAppr;
    protected Long jjCompileAct;
    protected Long jjCompileAppr;
    protected Long jjLeaderAct;
    protected Long jjLeaderAppr;
    protected Long leaderAct;
    protected Long leaderAppr;
    protected Long leaderPrefAct;
    protected Long leaderPrefAppr;
    protected Long leaderTotalAct;
    protected Long leaderTotalAppr;
    protected Long leaveRetired;
    protected Long ltfwCompileAct;
    protected Long ltfwCompileAppr;
    protected Long notLeaderTotalAct;
    protected Long notLeaderTotalAppr;
    protected Long notOnline;
    protected Long orgCompileAct;
    protected Long orgCompileAppr;
    protected Long orgCompileId;
    protected Long orgId;
    protected String overstaffedCause;
    protected Long ownDefineAct;
    protected Long ownDefineAppr;
    protected Long prefDirectorClearAct;
    protected Long prefDirectorClearAppr;
    protected Long prefFloorwalkerAct;
    protected Long prefFloorwalkerAppr;
    protected Long prefInvestigatorAct;
    protected Long prefInvestigatorAppr;
    protected Long prefSecAct;
    protected Long prefSecAppr;
    protected Long pzjjjgCompileAct;
    protected Long pzjjjgCompileAppr;
    protected Long qtryAct;
    protected Long qtryAppr;
    protected Long scgrAct;
    protected Long scgrAppr;
    protected Long secAct;
    protected Long secAppr;
    protected Long singlelineCompileAct;
    protected Long singlelineCompileAppr;
    protected Long threeChiefAct;
    protected Long threeChiefAppr;
    protected Long totalPositionAct;
    protected Long totalPositionAppr;
    protected Long workerChairmanAct;
    protected Long workerChairmanAppr;
    protected Long xzCompileAct;
    protected Long xzCompileAppr;
    protected Long xzglAct;
    protected Long xzglAppr;
    protected Long zfCompileAct;
    protected Long zfCompileAppr;
    protected Long zfTeamCompileAct;
    protected Long zfTeamCompileAppr;
    protected Long zfzxCompileAct;
    protected Long zfzxCompileAppr;
    protected Long zyjsAct;
    protected Long zyjsAppr;

    /**
     * ��ȡallAllocationAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAllAllocationAct() {
        return allAllocationAct;
    }

    /**
     * ����allAllocationAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAllAllocationAct(Long value) {
        this.allAllocationAct = value;
    }

    /**
     * ��ȡallAllocationAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAllAllocationAppr() {
        return allAllocationAppr;
    }

    /**
     * ����allAllocationAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAllAllocationAppr(Long value) {
        this.allAllocationAppr = value;
    }

    /**
     * ��ȡarmyToGoverment���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getArmyToGoverment() {
        return armyToGoverment;
    }

    /**
     * ����armyToGoverment���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setArmyToGoverment(Long value) {
        this.armyToGoverment = value;
    }

    /**
     * ��ȡbeyondOrgCompileAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBeyondOrgCompileAct() {
        return beyondOrgCompileAct;
    }

    /**
     * ����beyondOrgCompileAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBeyondOrgCompileAct(Long value) {
        this.beyondOrgCompileAct = value;
    }

    /**
     * ��ȡbeyondOrgCompileAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBeyondOrgCompileAppr() {
        return beyondOrgCompileAppr;
    }

    /**
     * ����beyondOrgCompileAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBeyondOrgCompileAppr(Long value) {
        this.beyondOrgCompileAppr = value;
    }

    /**
     * ��ȡborrowPeople���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBorrowPeople() {
        return borrowPeople;
    }

    /**
     * ����borrowPeople���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBorrowPeople(Long value) {
        this.borrowPeople = value;
    }

    /**
     * ��ȡcareerCompileAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCareerCompileAct() {
        return careerCompileAct;
    }

    /**
     * ����careerCompileAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCareerCompileAct(Long value) {
        this.careerCompileAct = value;
    }

    /**
     * ��ȡcareerCompileAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCareerCompileAppr() {
        return careerCompileAppr;
    }

    /**
     * ����careerCompileAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCareerCompileAppr(Long value) {
        this.careerCompileAppr = value;
    }

    /**
     * ��ȡcompanyManageAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCompanyManageAct() {
        return companyManageAct;
    }

    /**
     * ����companyManageAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCompanyManageAct(Long value) {
        this.companyManageAct = value;
    }

    /**
     * ��ȡcompanyManageAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCompanyManageAppr() {
        return companyManageAppr;
    }

    /**
     * ����companyManageAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCompanyManageAppr(Long value) {
        this.companyManageAppr = value;
    }

    /**
     * ��ȡcompileTotalAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCompileTotalAct() {
        return compileTotalAct;
    }

    /**
     * ����compileTotalAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCompileTotalAct(Long value) {
        this.compileTotalAct = value;
    }

    /**
     * ��ȡcompileTotalAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCompileTotalAppr() {
        return compileTotalAppr;
    }

    /**
     * ����compileTotalAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCompileTotalAppr(Long value) {
        this.compileTotalAppr = value;
    }

    /**
     * ��ȡdeptAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDeptAct() {
        return deptAct;
    }

    /**
     * ����deptAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDeptAct(Long value) {
        this.deptAct = value;
    }

    /**
     * ��ȡdeptAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDeptAppr() {
        return deptAppr;
    }

    /**
     * ����deptAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDeptAppr(Long value) {
        this.deptAppr = value;
    }

    /**
     * ��ȡdeptLeaderAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDeptLeaderAct() {
        return deptLeaderAct;
    }

    /**
     * ����deptLeaderAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDeptLeaderAct(Long value) {
        this.deptLeaderAct = value;
    }

    /**
     * ��ȡdeptLeaderAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDeptLeaderAppr() {
        return deptLeaderAppr;
    }

    /**
     * ����deptLeaderAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDeptLeaderAppr(Long value) {
        this.deptLeaderAppr = value;
    }

    /**
     * ��ȡdeptLeaderPrefAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDeptLeaderPrefAct() {
        return deptLeaderPrefAct;
    }

    /**
     * ����deptLeaderPrefAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDeptLeaderPrefAct(Long value) {
        this.deptLeaderPrefAct = value;
    }

    /**
     * ��ȡdeptLeaderPrefAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDeptLeaderPrefAppr() {
        return deptLeaderPrefAppr;
    }

    /**
     * ����deptLeaderPrefAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDeptLeaderPrefAppr(Long value) {
        this.deptLeaderPrefAppr = value;
    }

    /**
     * ��ȡdeptLeaderTotalAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDeptLeaderTotalAct() {
        return deptLeaderTotalAct;
    }

    /**
     * ����deptLeaderTotalAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDeptLeaderTotalAct(Long value) {
        this.deptLeaderTotalAct = value;
    }

    /**
     * ��ȡdeptLeaderTotalAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDeptLeaderTotalAppr() {
        return deptLeaderTotalAppr;
    }

    /**
     * ����deptLeaderTotalAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDeptLeaderTotalAppr(Long value) {
        this.deptLeaderTotalAppr = value;
    }

    /**
     * ��ȡdiffSubsidyAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDiffSubsidyAct() {
        return diffSubsidyAct;
    }

    /**
     * ����diffSubsidyAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDiffSubsidyAct(Long value) {
        this.diffSubsidyAct = value;
    }

    /**
     * ��ȡdiffSubsidyAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDiffSubsidyAppr() {
        return diffSubsidyAppr;
    }

    /**
     * ����diffSubsidyAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDiffSubsidyAppr(Long value) {
        this.diffSubsidyAppr = value;
    }

    /**
     * ��ȡdirectorClearAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDirectorClearAct() {
        return directorClearAct;
    }

    /**
     * ����directorClearAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDirectorClearAct(Long value) {
        this.directorClearAct = value;
    }

    /**
     * ��ȡdirectorClearAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDirectorClearAppr() {
        return directorClearAppr;
    }

    /**
     * ����directorClearAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDirectorClearAppr(Long value) {
        this.directorClearAppr = value;
    }

    /**
     * ��ȡdispatchOrgCompileAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDispatchOrgCompileAct() {
        return dispatchOrgCompileAct;
    }

    /**
     * ����dispatchOrgCompileAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDispatchOrgCompileAct(Long value) {
        this.dispatchOrgCompileAct = value;
    }

    /**
     * ��ȡdispatchOrgCompileAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDispatchOrgCompileAppr() {
        return dispatchOrgCompileAppr;
    }

    /**
     * ����dispatchOrgCompileAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDispatchOrgCompileAppr(Long value) {
        this.dispatchOrgCompileAppr = value;
    }

    /**
     * ��ȡelseCompileAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getElseCompileAct() {
        return elseCompileAct;
    }

    /**
     * ����elseCompileAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setElseCompileAct(Long value) {
        this.elseCompileAct = value;
    }

    /**
     * ��ȡelseCompileAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getElseCompileAppr() {
        return elseCompileAppr;
    }

    /**
     * ����elseCompileAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setElseCompileAppr(Long value) {
        this.elseCompileAppr = value;
    }

    /**
     * ��ȡelseLeaderAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getElseLeaderAct() {
        return elseLeaderAct;
    }

    /**
     * ����elseLeaderAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setElseLeaderAct(Long value) {
        this.elseLeaderAct = value;
    }

    /**
     * ��ȡelseLeaderAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getElseLeaderAppr() {
        return elseLeaderAppr;
    }

    /**
     * ����elseLeaderAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setElseLeaderAppr(Long value) {
        this.elseLeaderAppr = value;
    }

    /**
     * ��ȡelseOrgCompileAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getElseOrgCompileAct() {
        return elseOrgCompileAct;
    }

    /**
     * ����elseOrgCompileAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setElseOrgCompileAct(Long value) {
        this.elseOrgCompileAct = value;
    }

    /**
     * ��ȡelseOrgCompileAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getElseOrgCompileAppr() {
        return elseOrgCompileAppr;
    }

    /**
     * ����elseOrgCompileAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setElseOrgCompileAppr(Long value) {
        this.elseOrgCompileAppr = value;
    }

    /**
     * ��ȡfinancialAllocationAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFinancialAllocationAct() {
        return financialAllocationAct;
    }

    /**
     * ����financialAllocationAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFinancialAllocationAct(Long value) {
        this.financialAllocationAct = value;
    }

    /**
     * ��ȡfinancialAllocationAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFinancialAllocationAppr() {
        return financialAllocationAppr;
    }

    /**
     * ����financialAllocationAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFinancialAllocationAppr(Long value) {
        this.financialAllocationAppr = value;
    }

    /**
     * ��ȡfloorwalkerAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFloorwalkerAct() {
        return floorwalkerAct;
    }

    /**
     * ����floorwalkerAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFloorwalkerAct(Long value) {
        this.floorwalkerAct = value;
    }

    /**
     * ��ȡfloorwalkerAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFloorwalkerAppr() {
        return floorwalkerAppr;
    }

    /**
     * ����floorwalkerAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFloorwalkerAppr(Long value) {
        this.floorwalkerAppr = value;
    }

    /**
     * ��ȡfundBySelfAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFundBySelfAct() {
        return fundBySelfAct;
    }

    /**
     * ����fundBySelfAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFundBySelfAct(Long value) {
        this.fundBySelfAct = value;
    }

    /**
     * ��ȡfundBySelfAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFundBySelfAppr() {
        return fundBySelfAppr;
    }

    /**
     * ����fundBySelfAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFundBySelfAppr(Long value) {
        this.fundBySelfAppr = value;
    }

    /**
     * ��ȡfundCompileTotalAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFundCompileTotalAct() {
        return fundCompileTotalAct;
    }

    /**
     * ����fundCompileTotalAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFundCompileTotalAct(Long value) {
        this.fundCompileTotalAct = value;
    }

    /**
     * ��ȡfundCompileTotalAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFundCompileTotalAppr() {
        return fundCompileTotalAppr;
    }

    /**
     * ����fundCompileTotalAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFundCompileTotalAppr(Long value) {
        this.fundCompileTotalAppr = value;
    }

    /**
     * ��ȡgqCompileAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getGqCompileAct() {
        return gqCompileAct;
    }

    /**
     * ����gqCompileAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setGqCompileAct(Long value) {
        this.gqCompileAct = value;
    }

    /**
     * ��ȡgqCompileAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getGqCompileAppr() {
        return gqCompileAppr;
    }

    /**
     * ����gqCompileAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setGqCompileAppr(Long value) {
        this.gqCompileAppr = value;
    }

    /**
     * ��ȡhqgwAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getHqgwAct() {
        return hqgwAct;
    }

    /**
     * ����hqgwAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setHqgwAct(Long value) {
        this.hqgwAct = value;
    }

    /**
     * ��ȡhqgwAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getHqgwAppr() {
        return hqgwAppr;
    }

    /**
     * ����hqgwAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setHqgwAppr(Long value) {
        this.hqgwAppr = value;
    }

    /**
     * ��ȡinvestigatorAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInvestigatorAct() {
        return investigatorAct;
    }

    /**
     * ����investigatorAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInvestigatorAct(Long value) {
        this.investigatorAct = value;
    }

    /**
     * ��ȡinvestigatorAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInvestigatorAppr() {
        return investigatorAppr;
    }

    /**
     * ����investigatorAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInvestigatorAppr(Long value) {
        this.investigatorAppr = value;
    }

    /**
     * ��ȡjjCompileAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getJjCompileAct() {
        return jjCompileAct;
    }

    /**
     * ����jjCompileAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setJjCompileAct(Long value) {
        this.jjCompileAct = value;
    }

    /**
     * ��ȡjjCompileAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getJjCompileAppr() {
        return jjCompileAppr;
    }

    /**
     * ����jjCompileAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setJjCompileAppr(Long value) {
        this.jjCompileAppr = value;
    }

    /**
     * ��ȡjjLeaderAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getJjLeaderAct() {
        return jjLeaderAct;
    }

    /**
     * ����jjLeaderAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setJjLeaderAct(Long value) {
        this.jjLeaderAct = value;
    }

    /**
     * ��ȡjjLeaderAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getJjLeaderAppr() {
        return jjLeaderAppr;
    }

    /**
     * ����jjLeaderAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setJjLeaderAppr(Long value) {
        this.jjLeaderAppr = value;
    }

    /**
     * ��ȡleaderAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLeaderAct() {
        return leaderAct;
    }

    /**
     * ����leaderAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLeaderAct(Long value) {
        this.leaderAct = value;
    }

    /**
     * ��ȡleaderAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLeaderAppr() {
        return leaderAppr;
    }

    /**
     * ����leaderAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLeaderAppr(Long value) {
        this.leaderAppr = value;
    }

    /**
     * ��ȡleaderPrefAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLeaderPrefAct() {
        return leaderPrefAct;
    }

    /**
     * ����leaderPrefAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLeaderPrefAct(Long value) {
        this.leaderPrefAct = value;
    }

    /**
     * ��ȡleaderPrefAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLeaderPrefAppr() {
        return leaderPrefAppr;
    }

    /**
     * ����leaderPrefAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLeaderPrefAppr(Long value) {
        this.leaderPrefAppr = value;
    }

    /**
     * ��ȡleaderTotalAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLeaderTotalAct() {
        return leaderTotalAct;
    }

    /**
     * ����leaderTotalAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLeaderTotalAct(Long value) {
        this.leaderTotalAct = value;
    }

    /**
     * ��ȡleaderTotalAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLeaderTotalAppr() {
        return leaderTotalAppr;
    }

    /**
     * ����leaderTotalAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLeaderTotalAppr(Long value) {
        this.leaderTotalAppr = value;
    }

    /**
     * ��ȡleaveRetired���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLeaveRetired() {
        return leaveRetired;
    }

    /**
     * ����leaveRetired���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLeaveRetired(Long value) {
        this.leaveRetired = value;
    }

    /**
     * ��ȡltfwCompileAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLtfwCompileAct() {
        return ltfwCompileAct;
    }

    /**
     * ����ltfwCompileAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLtfwCompileAct(Long value) {
        this.ltfwCompileAct = value;
    }

    /**
     * ��ȡltfwCompileAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLtfwCompileAppr() {
        return ltfwCompileAppr;
    }

    /**
     * ����ltfwCompileAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLtfwCompileAppr(Long value) {
        this.ltfwCompileAppr = value;
    }

    /**
     * ��ȡnotLeaderTotalAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNotLeaderTotalAct() {
        return notLeaderTotalAct;
    }

    /**
     * ����notLeaderTotalAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNotLeaderTotalAct(Long value) {
        this.notLeaderTotalAct = value;
    }

    /**
     * ��ȡnotLeaderTotalAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNotLeaderTotalAppr() {
        return notLeaderTotalAppr;
    }

    /**
     * ����notLeaderTotalAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNotLeaderTotalAppr(Long value) {
        this.notLeaderTotalAppr = value;
    }

    /**
     * ��ȡnotOnline���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNotOnline() {
        return notOnline;
    }

    /**
     * ����notOnline���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNotOnline(Long value) {
        this.notOnline = value;
    }

    /**
     * ��ȡorgCompileAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOrgCompileAct() {
        return orgCompileAct;
    }

    /**
     * ����orgCompileAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOrgCompileAct(Long value) {
        this.orgCompileAct = value;
    }

    /**
     * ��ȡorgCompileAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOrgCompileAppr() {
        return orgCompileAppr;
    }

    /**
     * ����orgCompileAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOrgCompileAppr(Long value) {
        this.orgCompileAppr = value;
    }

    /**
     * ��ȡorgCompileId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOrgCompileId() {
        return orgCompileId;
    }

    /**
     * ����orgCompileId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOrgCompileId(Long value) {
        this.orgCompileId = value;
    }

    /**
     * ��ȡorgId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * ����orgId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOrgId(Long value) {
        this.orgId = value;
    }

    /**
     * ��ȡoverstaffedCause���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOverstaffedCause() {
        return overstaffedCause;
    }

    /**
     * ����overstaffedCause���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOverstaffedCause(String value) {
        this.overstaffedCause = value;
    }

    /**
     * ��ȡownDefineAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOwnDefineAct() {
        return ownDefineAct;
    }

    /**
     * ����ownDefineAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOwnDefineAct(Long value) {
        this.ownDefineAct = value;
    }

    /**
     * ��ȡownDefineAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOwnDefineAppr() {
        return ownDefineAppr;
    }

    /**
     * ����ownDefineAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOwnDefineAppr(Long value) {
        this.ownDefineAppr = value;
    }

    /**
     * ��ȡprefDirectorClearAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrefDirectorClearAct() {
        return prefDirectorClearAct;
    }

    /**
     * ����prefDirectorClearAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrefDirectorClearAct(Long value) {
        this.prefDirectorClearAct = value;
    }

    /**
     * ��ȡprefDirectorClearAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrefDirectorClearAppr() {
        return prefDirectorClearAppr;
    }

    /**
     * ����prefDirectorClearAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrefDirectorClearAppr(Long value) {
        this.prefDirectorClearAppr = value;
    }

    /**
     * ��ȡprefFloorwalkerAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrefFloorwalkerAct() {
        return prefFloorwalkerAct;
    }

    /**
     * ����prefFloorwalkerAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrefFloorwalkerAct(Long value) {
        this.prefFloorwalkerAct = value;
    }

    /**
     * ��ȡprefFloorwalkerAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrefFloorwalkerAppr() {
        return prefFloorwalkerAppr;
    }

    /**
     * ����prefFloorwalkerAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrefFloorwalkerAppr(Long value) {
        this.prefFloorwalkerAppr = value;
    }

    /**
     * ��ȡprefInvestigatorAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrefInvestigatorAct() {
        return prefInvestigatorAct;
    }

    /**
     * ����prefInvestigatorAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrefInvestigatorAct(Long value) {
        this.prefInvestigatorAct = value;
    }

    /**
     * ��ȡprefInvestigatorAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrefInvestigatorAppr() {
        return prefInvestigatorAppr;
    }

    /**
     * ����prefInvestigatorAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrefInvestigatorAppr(Long value) {
        this.prefInvestigatorAppr = value;
    }

    /**
     * ��ȡprefSecAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrefSecAct() {
        return prefSecAct;
    }

    /**
     * ����prefSecAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrefSecAct(Long value) {
        this.prefSecAct = value;
    }

    /**
     * ��ȡprefSecAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrefSecAppr() {
        return prefSecAppr;
    }

    /**
     * ����prefSecAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrefSecAppr(Long value) {
        this.prefSecAppr = value;
    }

    /**
     * ��ȡpzjjjgCompileAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPzjjjgCompileAct() {
        return pzjjjgCompileAct;
    }

    /**
     * ����pzjjjgCompileAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPzjjjgCompileAct(Long value) {
        this.pzjjjgCompileAct = value;
    }

    /**
     * ��ȡpzjjjgCompileAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPzjjjgCompileAppr() {
        return pzjjjgCompileAppr;
    }

    /**
     * ����pzjjjgCompileAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPzjjjgCompileAppr(Long value) {
        this.pzjjjgCompileAppr = value;
    }

    /**
     * ��ȡqtryAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getQtryAct() {
        return qtryAct;
    }

    /**
     * ����qtryAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setQtryAct(Long value) {
        this.qtryAct = value;
    }

    /**
     * ��ȡqtryAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getQtryAppr() {
        return qtryAppr;
    }

    /**
     * ����qtryAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setQtryAppr(Long value) {
        this.qtryAppr = value;
    }

    /**
     * ��ȡscgrAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getScgrAct() {
        return scgrAct;
    }

    /**
     * ����scgrAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setScgrAct(Long value) {
        this.scgrAct = value;
    }

    /**
     * ��ȡscgrAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getScgrAppr() {
        return scgrAppr;
    }

    /**
     * ����scgrAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setScgrAppr(Long value) {
        this.scgrAppr = value;
    }

    /**
     * ��ȡsecAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSecAct() {
        return secAct;
    }

    /**
     * ����secAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSecAct(Long value) {
        this.secAct = value;
    }

    /**
     * ��ȡsecAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSecAppr() {
        return secAppr;
    }

    /**
     * ����secAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSecAppr(Long value) {
        this.secAppr = value;
    }

    /**
     * ��ȡsinglelineCompileAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSinglelineCompileAct() {
        return singlelineCompileAct;
    }

    /**
     * ����singlelineCompileAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSinglelineCompileAct(Long value) {
        this.singlelineCompileAct = value;
    }

    /**
     * ��ȡsinglelineCompileAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSinglelineCompileAppr() {
        return singlelineCompileAppr;
    }

    /**
     * ����singlelineCompileAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSinglelineCompileAppr(Long value) {
        this.singlelineCompileAppr = value;
    }

    /**
     * ��ȡthreeChiefAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getThreeChiefAct() {
        return threeChiefAct;
    }

    /**
     * ����threeChiefAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setThreeChiefAct(Long value) {
        this.threeChiefAct = value;
    }

    /**
     * ��ȡthreeChiefAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getThreeChiefAppr() {
        return threeChiefAppr;
    }

    /**
     * ����threeChiefAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setThreeChiefAppr(Long value) {
        this.threeChiefAppr = value;
    }

    /**
     * ��ȡtotalPositionAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTotalPositionAct() {
        return totalPositionAct;
    }

    /**
     * ����totalPositionAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTotalPositionAct(Long value) {
        this.totalPositionAct = value;
    }

    /**
     * ��ȡtotalPositionAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTotalPositionAppr() {
        return totalPositionAppr;
    }

    /**
     * ����totalPositionAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTotalPositionAppr(Long value) {
        this.totalPositionAppr = value;
    }

    /**
     * ��ȡworkerChairmanAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getWorkerChairmanAct() {
        return workerChairmanAct;
    }

    /**
     * ����workerChairmanAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setWorkerChairmanAct(Long value) {
        this.workerChairmanAct = value;
    }

    /**
     * ��ȡworkerChairmanAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getWorkerChairmanAppr() {
        return workerChairmanAppr;
    }

    /**
     * ����workerChairmanAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setWorkerChairmanAppr(Long value) {
        this.workerChairmanAppr = value;
    }

    /**
     * ��ȡxzCompileAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getXzCompileAct() {
        return xzCompileAct;
    }

    /**
     * ����xzCompileAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setXzCompileAct(Long value) {
        this.xzCompileAct = value;
    }

    /**
     * ��ȡxzCompileAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getXzCompileAppr() {
        return xzCompileAppr;
    }

    /**
     * ����xzCompileAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setXzCompileAppr(Long value) {
        this.xzCompileAppr = value;
    }

    /**
     * ��ȡxzglAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getXzglAct() {
        return xzglAct;
    }

    /**
     * ����xzglAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setXzglAct(Long value) {
        this.xzglAct = value;
    }

    /**
     * ��ȡxzglAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getXzglAppr() {
        return xzglAppr;
    }

    /**
     * ����xzglAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setXzglAppr(Long value) {
        this.xzglAppr = value;
    }

    /**
     * ��ȡzfCompileAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getZfCompileAct() {
        return zfCompileAct;
    }

    /**
     * ����zfCompileAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setZfCompileAct(Long value) {
        this.zfCompileAct = value;
    }

    /**
     * ��ȡzfCompileAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getZfCompileAppr() {
        return zfCompileAppr;
    }

    /**
     * ����zfCompileAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setZfCompileAppr(Long value) {
        this.zfCompileAppr = value;
    }

    /**
     * ��ȡzfTeamCompileAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getZfTeamCompileAct() {
        return zfTeamCompileAct;
    }

    /**
     * ����zfTeamCompileAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setZfTeamCompileAct(Long value) {
        this.zfTeamCompileAct = value;
    }

    /**
     * ��ȡzfTeamCompileAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getZfTeamCompileAppr() {
        return zfTeamCompileAppr;
    }

    /**
     * ����zfTeamCompileAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setZfTeamCompileAppr(Long value) {
        this.zfTeamCompileAppr = value;
    }

    /**
     * ��ȡzfzxCompileAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getZfzxCompileAct() {
        return zfzxCompileAct;
    }

    /**
     * ����zfzxCompileAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setZfzxCompileAct(Long value) {
        this.zfzxCompileAct = value;
    }

    /**
     * ��ȡzfzxCompileAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getZfzxCompileAppr() {
        return zfzxCompileAppr;
    }

    /**
     * ����zfzxCompileAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setZfzxCompileAppr(Long value) {
        this.zfzxCompileAppr = value;
    }

    /**
     * ��ȡzyjsAct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getZyjsAct() {
        return zyjsAct;
    }

    /**
     * ����zyjsAct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setZyjsAct(Long value) {
        this.zyjsAct = value;
    }

    /**
     * ��ȡzyjsAppr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getZyjsAppr() {
        return zyjsAppr;
    }

    /**
     * ����zyjsAppr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setZyjsAppr(Long value) {
        this.zyjsAppr = value;
    }

}
