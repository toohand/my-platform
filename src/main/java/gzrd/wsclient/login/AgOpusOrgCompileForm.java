
package gzrd.wsclient.login;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>agOpusOrgCompileForm complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取allAllocationAct属性的值。
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
     * 设置allAllocationAct属性的值。
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
     * 获取allAllocationAppr属性的值。
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
     * 设置allAllocationAppr属性的值。
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
     * 获取armyToGoverment属性的值。
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
     * 设置armyToGoverment属性的值。
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
     * 获取beyondOrgCompileAct属性的值。
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
     * 设置beyondOrgCompileAct属性的值。
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
     * 获取beyondOrgCompileAppr属性的值。
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
     * 设置beyondOrgCompileAppr属性的值。
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
     * 获取borrowPeople属性的值。
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
     * 设置borrowPeople属性的值。
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
     * 获取careerCompileAct属性的值。
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
     * 设置careerCompileAct属性的值。
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
     * 获取careerCompileAppr属性的值。
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
     * 设置careerCompileAppr属性的值。
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
     * 获取companyManageAct属性的值。
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
     * 设置companyManageAct属性的值。
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
     * 获取companyManageAppr属性的值。
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
     * 设置companyManageAppr属性的值。
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
     * 获取compileTotalAct属性的值。
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
     * 设置compileTotalAct属性的值。
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
     * 获取compileTotalAppr属性的值。
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
     * 设置compileTotalAppr属性的值。
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
     * 获取deptAct属性的值。
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
     * 设置deptAct属性的值。
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
     * 获取deptAppr属性的值。
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
     * 设置deptAppr属性的值。
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
     * 获取deptLeaderAct属性的值。
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
     * 设置deptLeaderAct属性的值。
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
     * 获取deptLeaderAppr属性的值。
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
     * 设置deptLeaderAppr属性的值。
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
     * 获取deptLeaderPrefAct属性的值。
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
     * 设置deptLeaderPrefAct属性的值。
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
     * 获取deptLeaderPrefAppr属性的值。
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
     * 设置deptLeaderPrefAppr属性的值。
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
     * 获取deptLeaderTotalAct属性的值。
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
     * 设置deptLeaderTotalAct属性的值。
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
     * 获取deptLeaderTotalAppr属性的值。
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
     * 设置deptLeaderTotalAppr属性的值。
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
     * 获取diffSubsidyAct属性的值。
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
     * 设置diffSubsidyAct属性的值。
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
     * 获取diffSubsidyAppr属性的值。
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
     * 设置diffSubsidyAppr属性的值。
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
     * 获取directorClearAct属性的值。
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
     * 设置directorClearAct属性的值。
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
     * 获取directorClearAppr属性的值。
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
     * 设置directorClearAppr属性的值。
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
     * 获取dispatchOrgCompileAct属性的值。
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
     * 设置dispatchOrgCompileAct属性的值。
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
     * 获取dispatchOrgCompileAppr属性的值。
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
     * 设置dispatchOrgCompileAppr属性的值。
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
     * 获取elseCompileAct属性的值。
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
     * 设置elseCompileAct属性的值。
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
     * 获取elseCompileAppr属性的值。
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
     * 设置elseCompileAppr属性的值。
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
     * 获取elseLeaderAct属性的值。
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
     * 设置elseLeaderAct属性的值。
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
     * 获取elseLeaderAppr属性的值。
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
     * 设置elseLeaderAppr属性的值。
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
     * 获取elseOrgCompileAct属性的值。
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
     * 设置elseOrgCompileAct属性的值。
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
     * 获取elseOrgCompileAppr属性的值。
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
     * 设置elseOrgCompileAppr属性的值。
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
     * 获取financialAllocationAct属性的值。
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
     * 设置financialAllocationAct属性的值。
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
     * 获取financialAllocationAppr属性的值。
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
     * 设置financialAllocationAppr属性的值。
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
     * 获取floorwalkerAct属性的值。
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
     * 设置floorwalkerAct属性的值。
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
     * 获取floorwalkerAppr属性的值。
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
     * 设置floorwalkerAppr属性的值。
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
     * 获取fundBySelfAct属性的值。
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
     * 设置fundBySelfAct属性的值。
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
     * 获取fundBySelfAppr属性的值。
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
     * 设置fundBySelfAppr属性的值。
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
     * 获取fundCompileTotalAct属性的值。
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
     * 设置fundCompileTotalAct属性的值。
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
     * 获取fundCompileTotalAppr属性的值。
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
     * 设置fundCompileTotalAppr属性的值。
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
     * 获取gqCompileAct属性的值。
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
     * 设置gqCompileAct属性的值。
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
     * 获取gqCompileAppr属性的值。
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
     * 设置gqCompileAppr属性的值。
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
     * 获取hqgwAct属性的值。
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
     * 设置hqgwAct属性的值。
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
     * 获取hqgwAppr属性的值。
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
     * 设置hqgwAppr属性的值。
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
     * 获取investigatorAct属性的值。
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
     * 设置investigatorAct属性的值。
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
     * 获取investigatorAppr属性的值。
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
     * 设置investigatorAppr属性的值。
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
     * 获取jjCompileAct属性的值。
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
     * 设置jjCompileAct属性的值。
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
     * 获取jjCompileAppr属性的值。
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
     * 设置jjCompileAppr属性的值。
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
     * 获取jjLeaderAct属性的值。
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
     * 设置jjLeaderAct属性的值。
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
     * 获取jjLeaderAppr属性的值。
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
     * 设置jjLeaderAppr属性的值。
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
     * 获取leaderAct属性的值。
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
     * 设置leaderAct属性的值。
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
     * 获取leaderAppr属性的值。
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
     * 设置leaderAppr属性的值。
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
     * 获取leaderPrefAct属性的值。
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
     * 设置leaderPrefAct属性的值。
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
     * 获取leaderPrefAppr属性的值。
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
     * 设置leaderPrefAppr属性的值。
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
     * 获取leaderTotalAct属性的值。
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
     * 设置leaderTotalAct属性的值。
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
     * 获取leaderTotalAppr属性的值。
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
     * 设置leaderTotalAppr属性的值。
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
     * 获取leaveRetired属性的值。
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
     * 设置leaveRetired属性的值。
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
     * 获取ltfwCompileAct属性的值。
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
     * 设置ltfwCompileAct属性的值。
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
     * 获取ltfwCompileAppr属性的值。
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
     * 设置ltfwCompileAppr属性的值。
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
     * 获取notLeaderTotalAct属性的值。
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
     * 设置notLeaderTotalAct属性的值。
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
     * 获取notLeaderTotalAppr属性的值。
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
     * 设置notLeaderTotalAppr属性的值。
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
     * 获取notOnline属性的值。
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
     * 设置notOnline属性的值。
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
     * 获取orgCompileAct属性的值。
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
     * 设置orgCompileAct属性的值。
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
     * 获取orgCompileAppr属性的值。
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
     * 设置orgCompileAppr属性的值。
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
     * 获取orgCompileId属性的值。
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
     * 设置orgCompileId属性的值。
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
     * 获取orgId属性的值。
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
     * 设置orgId属性的值。
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
     * 获取overstaffedCause属性的值。
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
     * 设置overstaffedCause属性的值。
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
     * 获取ownDefineAct属性的值。
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
     * 设置ownDefineAct属性的值。
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
     * 获取ownDefineAppr属性的值。
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
     * 设置ownDefineAppr属性的值。
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
     * 获取prefDirectorClearAct属性的值。
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
     * 设置prefDirectorClearAct属性的值。
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
     * 获取prefDirectorClearAppr属性的值。
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
     * 设置prefDirectorClearAppr属性的值。
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
     * 获取prefFloorwalkerAct属性的值。
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
     * 设置prefFloorwalkerAct属性的值。
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
     * 获取prefFloorwalkerAppr属性的值。
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
     * 设置prefFloorwalkerAppr属性的值。
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
     * 获取prefInvestigatorAct属性的值。
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
     * 设置prefInvestigatorAct属性的值。
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
     * 获取prefInvestigatorAppr属性的值。
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
     * 设置prefInvestigatorAppr属性的值。
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
     * 获取prefSecAct属性的值。
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
     * 设置prefSecAct属性的值。
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
     * 获取prefSecAppr属性的值。
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
     * 设置prefSecAppr属性的值。
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
     * 获取pzjjjgCompileAct属性的值。
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
     * 设置pzjjjgCompileAct属性的值。
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
     * 获取pzjjjgCompileAppr属性的值。
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
     * 设置pzjjjgCompileAppr属性的值。
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
     * 获取qtryAct属性的值。
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
     * 设置qtryAct属性的值。
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
     * 获取qtryAppr属性的值。
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
     * 设置qtryAppr属性的值。
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
     * 获取scgrAct属性的值。
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
     * 设置scgrAct属性的值。
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
     * 获取scgrAppr属性的值。
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
     * 设置scgrAppr属性的值。
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
     * 获取secAct属性的值。
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
     * 设置secAct属性的值。
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
     * 获取secAppr属性的值。
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
     * 设置secAppr属性的值。
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
     * 获取singlelineCompileAct属性的值。
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
     * 设置singlelineCompileAct属性的值。
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
     * 获取singlelineCompileAppr属性的值。
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
     * 设置singlelineCompileAppr属性的值。
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
     * 获取threeChiefAct属性的值。
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
     * 设置threeChiefAct属性的值。
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
     * 获取threeChiefAppr属性的值。
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
     * 设置threeChiefAppr属性的值。
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
     * 获取totalPositionAct属性的值。
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
     * 设置totalPositionAct属性的值。
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
     * 获取totalPositionAppr属性的值。
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
     * 设置totalPositionAppr属性的值。
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
     * 获取workerChairmanAct属性的值。
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
     * 设置workerChairmanAct属性的值。
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
     * 获取workerChairmanAppr属性的值。
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
     * 设置workerChairmanAppr属性的值。
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
     * 获取xzCompileAct属性的值。
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
     * 设置xzCompileAct属性的值。
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
     * 获取xzCompileAppr属性的值。
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
     * 设置xzCompileAppr属性的值。
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
     * 获取xzglAct属性的值。
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
     * 设置xzglAct属性的值。
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
     * 获取xzglAppr属性的值。
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
     * 设置xzglAppr属性的值。
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
     * 获取zfCompileAct属性的值。
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
     * 设置zfCompileAct属性的值。
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
     * 获取zfCompileAppr属性的值。
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
     * 设置zfCompileAppr属性的值。
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
     * 获取zfTeamCompileAct属性的值。
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
     * 设置zfTeamCompileAct属性的值。
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
     * 获取zfTeamCompileAppr属性的值。
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
     * 设置zfTeamCompileAppr属性的值。
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
     * 获取zfzxCompileAct属性的值。
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
     * 设置zfzxCompileAct属性的值。
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
     * 获取zfzxCompileAppr属性的值。
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
     * 设置zfzxCompileAppr属性的值。
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
     * 获取zyjsAct属性的值。
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
     * 设置zyjsAct属性的值。
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
     * 获取zyjsAppr属性的值。
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
     * 设置zyjsAppr属性的值。
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
