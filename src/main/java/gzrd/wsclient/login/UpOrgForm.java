
package gzrd.wsclient.login;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>upOrgForm complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="upOrgForm">
 *   &lt;complexContent>
 *     &lt;extension base="{http://hugeinfo.com.cn}baseForm">
 *       &lt;sequence>
 *         &lt;element name="adminOrgAppAdmins" type="{http://hugeinfo.com.cn}agOpusPositionUserForm" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="adminOrgDWAppAdmins" type="{http://hugeinfo.com.cn}agOpusPositionUserForm" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="adminOrgVAppAdmins" type="{http://hugeinfo.com.cn}agOpusPositionUserForm" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="approvalNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="areaId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bwbOrgSortId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bwbParentOrgId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bwbParentOrgShortNameFirst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="careerOrgType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="chiefOrgId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="childIsCheck" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="children" type="{http://hugeinfo.com.cn}upOrgForm" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="companyNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="compileForm" type="{http://hugeinfo.com.cn}agOpusOrgCompileForm" minOccurs="0"/>
 *         &lt;element name="complaintTel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="createTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="creator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="delFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deptList" type="{http://hugeinfo.com.cn}upDepartmentForm" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="foundTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fundForm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fundFormLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="groupId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="isCheck" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isHasXz" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isLeaf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isPub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isReferGwy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isStationOrg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isVirtual" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="linkMan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="linkTel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loginOrgBiaoti" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgCompileNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgFunc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgLevel" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="orgName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="orgProperty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgPropertyLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgProvince" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgRank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgRankLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgSeq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgSort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgSortId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="orgSortNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="orgSysSort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgSysSortLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgTypeLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgUnitType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgWebUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgZipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="organizationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parentGroupId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parentOrgId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shortNameFirst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shortNameSecond" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shortNameThird" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uasFlowId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uasOrgId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="updateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="updator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "upOrgForm", propOrder = {
    "adminOrgAppAdmins",
    "adminOrgDWAppAdmins",
    "adminOrgVAppAdmins",
    "approvalNumber",
    "areaId",
    "bwbOrgSortId",
    "bwbParentOrgId",
    "bwbParentOrgShortNameFirst",
    "careerOrgType",
    "chiefOrgId",
    "childIsCheck",
    "children",
    "companyNumber",
    "compileForm",
    "complaintTel",
    "createTime",
    "creator",
    "delFlag",
    "deptList",
    "foundTime",
    "fundForm",
    "fundFormLabel",
    "groupId",
    "id",
    "isCheck",
    "isHasXz",
    "isLeaf",
    "isPub",
    "isReferGwy",
    "isStationOrg",
    "isVirtual",
    "linkMan",
    "linkTel",
    "loginOrgBiaoti",
    "orgAddress",
    "orgCity",
    "orgCode",
    "orgCompileNumber",
    "orgEmail",
    "orgFunc",
    "orgLevel",
    "orgName",
    "orgNo",
    "orgProperty",
    "orgPropertyLabel",
    "orgProvince",
    "orgRank",
    "orgRankLabel",
    "orgSeq",
    "orgSort",
    "orgSortId",
    "orgSortNo",
    "orgSysSort",
    "orgSysSortLabel",
    "orgType",
    "orgTypeLabel",
    "orgUnitType",
    "orgWebUrl",
    "orgZipCode",
    "organizationCode",
    "parentGroupId",
    "parentOrgId",
    "remark",
    "shortNameFirst",
    "shortNameSecond",
    "shortNameThird",
    "uasFlowId",
    "uasOrgId",
    "updateTime",
    "updator"
})
public class UpOrgForm
    extends BaseForm
{

    @XmlElement(nillable = true)
    protected List<AgOpusPositionUserForm> adminOrgAppAdmins;
    @XmlElement(nillable = true)
    protected List<AgOpusPositionUserForm> adminOrgDWAppAdmins;
    @XmlElement(nillable = true)
    protected List<AgOpusPositionUserForm> adminOrgVAppAdmins;
    protected String approvalNumber;
    protected Long areaId;
    protected Long bwbOrgSortId;
    protected Long bwbParentOrgId;
    protected String bwbParentOrgShortNameFirst;
    protected String careerOrgType;
    protected Long chiefOrgId;
    protected String childIsCheck;
    @XmlElement(nillable = true)
    protected List<UpOrgForm> children;
    protected String companyNumber;
    protected AgOpusOrgCompileForm compileForm;
    protected String complaintTel;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createTime;
    protected String creator;
    protected String delFlag;
    @XmlElement(nillable = true)
    protected List<UpDepartmentForm> deptList;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar foundTime;
    protected String fundForm;
    protected String fundFormLabel;
    protected String groupId;
    protected Long id;
    protected String isCheck;
    protected String isHasXz;
    protected String isLeaf;
    protected String isPub;
    protected String isReferGwy;
    protected String isStationOrg;
    protected String isVirtual;
    protected String linkMan;
    protected String linkTel;
    protected String loginOrgBiaoti;
    protected String orgAddress;
    protected String orgCity;
    protected String orgCode;
    protected String orgCompileNumber;
    protected String orgEmail;
    protected String orgFunc;
    protected Long orgLevel;
    protected String orgName;
    protected Long orgNo;
    protected String orgProperty;
    protected String orgPropertyLabel;
    protected String orgProvince;
    protected String orgRank;
    protected String orgRankLabel;
    protected String orgSeq;
    protected String orgSort;
    protected Long orgSortId;
    protected Long orgSortNo;
    protected String orgSysSort;
    protected String orgSysSortLabel;
    protected String orgType;
    protected String orgTypeLabel;
    protected String orgUnitType;
    protected String orgWebUrl;
    protected String orgZipCode;
    protected String organizationCode;
    protected String parentGroupId;
    protected Long parentOrgId;
    protected String remark;
    protected String shortNameFirst;
    protected String shortNameSecond;
    protected String shortNameThird;
    protected String uasFlowId;
    protected String uasOrgId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updateTime;
    protected String updator;

    /**
     * Gets the value of the adminOrgAppAdmins property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adminOrgAppAdmins property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdminOrgAppAdmins().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link gzrd.wsclient.login.AgOpusPositionUserForm }
     * 
     * 
     */
    public List<AgOpusPositionUserForm> getAdminOrgAppAdmins() {
        if (adminOrgAppAdmins == null) {
            adminOrgAppAdmins = new ArrayList<AgOpusPositionUserForm>();
        }
        return this.adminOrgAppAdmins;
    }

    /**
     * Gets the value of the adminOrgDWAppAdmins property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adminOrgDWAppAdmins property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdminOrgDWAppAdmins().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link gzrd.wsclient.login.AgOpusPositionUserForm }
     * 
     * 
     */
    public List<AgOpusPositionUserForm> getAdminOrgDWAppAdmins() {
        if (adminOrgDWAppAdmins == null) {
            adminOrgDWAppAdmins = new ArrayList<AgOpusPositionUserForm>();
        }
        return this.adminOrgDWAppAdmins;
    }

    /**
     * Gets the value of the adminOrgVAppAdmins property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adminOrgVAppAdmins property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdminOrgVAppAdmins().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link gzrd.wsclient.login.AgOpusPositionUserForm }
     * 
     * 
     */
    public List<AgOpusPositionUserForm> getAdminOrgVAppAdmins() {
        if (adminOrgVAppAdmins == null) {
            adminOrgVAppAdmins = new ArrayList<AgOpusPositionUserForm>();
        }
        return this.adminOrgVAppAdmins;
    }

    /**
     * ��ȡapprovalNumber���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApprovalNumber() {
        return approvalNumber;
    }

    /**
     * ����approvalNumber���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApprovalNumber(String value) {
        this.approvalNumber = value;
    }

    /**
     * ��ȡareaId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAreaId() {
        return areaId;
    }

    /**
     * ����areaId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAreaId(Long value) {
        this.areaId = value;
    }

    /**
     * ��ȡbwbOrgSortId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBwbOrgSortId() {
        return bwbOrgSortId;
    }

    /**
     * ����bwbOrgSortId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBwbOrgSortId(Long value) {
        this.bwbOrgSortId = value;
    }

    /**
     * ��ȡbwbParentOrgId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBwbParentOrgId() {
        return bwbParentOrgId;
    }

    /**
     * ����bwbParentOrgId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBwbParentOrgId(Long value) {
        this.bwbParentOrgId = value;
    }

    /**
     * ��ȡbwbParentOrgShortNameFirst���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBwbParentOrgShortNameFirst() {
        return bwbParentOrgShortNameFirst;
    }

    /**
     * ����bwbParentOrgShortNameFirst���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBwbParentOrgShortNameFirst(String value) {
        this.bwbParentOrgShortNameFirst = value;
    }

    /**
     * ��ȡcareerOrgType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCareerOrgType() {
        return careerOrgType;
    }

    /**
     * ����careerOrgType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCareerOrgType(String value) {
        this.careerOrgType = value;
    }

    /**
     * ��ȡchiefOrgId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getChiefOrgId() {
        return chiefOrgId;
    }

    /**
     * ����chiefOrgId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setChiefOrgId(Long value) {
        this.chiefOrgId = value;
    }

    /**
     * ��ȡchildIsCheck���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildIsCheck() {
        return childIsCheck;
    }

    /**
     * ����childIsCheck���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildIsCheck(String value) {
        this.childIsCheck = value;
    }

    /**
     * Gets the value of the children property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the children property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChildren().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UpOrgForm }
     * 
     * 
     */
    public List<UpOrgForm> getChildren() {
        if (children == null) {
            children = new ArrayList<UpOrgForm>();
        }
        return this.children;
    }

    /**
     * ��ȡcompanyNumber���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyNumber() {
        return companyNumber;
    }

    /**
     * ����companyNumber���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyNumber(String value) {
        this.companyNumber = value;
    }

    /**
     * ��ȡcompileForm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link gzrd.wsclient.login.AgOpusOrgCompileForm }
     *     
     */
    public AgOpusOrgCompileForm getCompileForm() {
        return compileForm;
    }

    /**
     * ����compileForm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link gzrd.wsclient.login.AgOpusOrgCompileForm }
     *     
     */
    public void setCompileForm(AgOpusOrgCompileForm value) {
        this.compileForm = value;
    }

    /**
     * ��ȡcomplaintTel���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComplaintTel() {
        return complaintTel;
    }

    /**
     * ����complaintTel���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComplaintTel(String value) {
        this.complaintTel = value;
    }

    /**
     * ��ȡcreateTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link javax.xml.datatype.XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreateTime() {
        return createTime;
    }

    /**
     * ����createTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link javax.xml.datatype.XMLGregorianCalendar }
     *     
     */
    public void setCreateTime(XMLGregorianCalendar value) {
        this.createTime = value;
    }

    /**
     * ��ȡcreator���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreator() {
        return creator;
    }

    /**
     * ����creator���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreator(String value) {
        this.creator = value;
    }

    /**
     * ��ȡdelFlag���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * ����delFlag���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelFlag(String value) {
        this.delFlag = value;
    }

    /**
     * Gets the value of the deptList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deptList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeptList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link gzrd.wsclient.login.UpDepartmentForm }
     * 
     * 
     */
    public List<UpDepartmentForm> getDeptList() {
        if (deptList == null) {
            deptList = new ArrayList<UpDepartmentForm>();
        }
        return this.deptList;
    }

    /**
     * ��ȡfoundTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link javax.xml.datatype.XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFoundTime() {
        return foundTime;
    }

    /**
     * ����foundTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link javax.xml.datatype.XMLGregorianCalendar }
     *     
     */
    public void setFoundTime(XMLGregorianCalendar value) {
        this.foundTime = value;
    }

    /**
     * ��ȡfundForm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFundForm() {
        return fundForm;
    }

    /**
     * ����fundForm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFundForm(String value) {
        this.fundForm = value;
    }

    /**
     * ��ȡfundFormLabel���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFundFormLabel() {
        return fundFormLabel;
    }

    /**
     * ����fundFormLabel���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFundFormLabel(String value) {
        this.fundFormLabel = value;
    }

    /**
     * ��ȡgroupId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * ����groupId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupId(String value) {
        this.groupId = value;
    }

    /**
     * ��ȡid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * ����id���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * ��ȡisCheck���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsCheck() {
        return isCheck;
    }

    /**
     * ����isCheck���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsCheck(String value) {
        this.isCheck = value;
    }

    /**
     * ��ȡisHasXz���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsHasXz() {
        return isHasXz;
    }

    /**
     * ����isHasXz���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsHasXz(String value) {
        this.isHasXz = value;
    }

    /**
     * ��ȡisLeaf���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsLeaf() {
        return isLeaf;
    }

    /**
     * ����isLeaf���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsLeaf(String value) {
        this.isLeaf = value;
    }

    /**
     * ��ȡisPub���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsPub() {
        return isPub;
    }

    /**
     * ����isPub���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsPub(String value) {
        this.isPub = value;
    }

    /**
     * ��ȡisReferGwy���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsReferGwy() {
        return isReferGwy;
    }

    /**
     * ����isReferGwy���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsReferGwy(String value) {
        this.isReferGwy = value;
    }

    /**
     * ��ȡisStationOrg���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsStationOrg() {
        return isStationOrg;
    }

    /**
     * ����isStationOrg���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsStationOrg(String value) {
        this.isStationOrg = value;
    }

    /**
     * ��ȡisVirtual���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsVirtual() {
        return isVirtual;
    }

    /**
     * ����isVirtual���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsVirtual(String value) {
        this.isVirtual = value;
    }

    /**
     * ��ȡlinkMan���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkMan() {
        return linkMan;
    }

    /**
     * ����linkMan���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkMan(String value) {
        this.linkMan = value;
    }

    /**
     * ��ȡlinkTel���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkTel() {
        return linkTel;
    }

    /**
     * ����linkTel���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkTel(String value) {
        this.linkTel = value;
    }

    /**
     * ��ȡloginOrgBiaoti���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginOrgBiaoti() {
        return loginOrgBiaoti;
    }

    /**
     * ����loginOrgBiaoti���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginOrgBiaoti(String value) {
        this.loginOrgBiaoti = value;
    }

    /**
     * ��ȡorgAddress���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgAddress() {
        return orgAddress;
    }

    /**
     * ����orgAddress���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgAddress(String value) {
        this.orgAddress = value;
    }

    /**
     * ��ȡorgCity���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgCity() {
        return orgCity;
    }

    /**
     * ����orgCity���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgCity(String value) {
        this.orgCity = value;
    }

    /**
     * ��ȡorgCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * ����orgCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgCode(String value) {
        this.orgCode = value;
    }

    /**
     * ��ȡorgCompileNumber���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgCompileNumber() {
        return orgCompileNumber;
    }

    /**
     * ����orgCompileNumber���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgCompileNumber(String value) {
        this.orgCompileNumber = value;
    }

    /**
     * ��ȡorgEmail���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgEmail() {
        return orgEmail;
    }

    /**
     * ����orgEmail���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgEmail(String value) {
        this.orgEmail = value;
    }

    /**
     * ��ȡorgFunc���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgFunc() {
        return orgFunc;
    }

    /**
     * ����orgFunc���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgFunc(String value) {
        this.orgFunc = value;
    }

    /**
     * ��ȡorgLevel���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOrgLevel() {
        return orgLevel;
    }

    /**
     * ����orgLevel���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOrgLevel(Long value) {
        this.orgLevel = value;
    }

    /**
     * ��ȡorgName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * ����orgName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgName(String value) {
        this.orgName = value;
    }

    /**
     * ��ȡorgNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOrgNo() {
        return orgNo;
    }

    /**
     * ����orgNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOrgNo(Long value) {
        this.orgNo = value;
    }

    /**
     * ��ȡorgProperty���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgProperty() {
        return orgProperty;
    }

    /**
     * ����orgProperty���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgProperty(String value) {
        this.orgProperty = value;
    }

    /**
     * ��ȡorgPropertyLabel���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgPropertyLabel() {
        return orgPropertyLabel;
    }

    /**
     * ����orgPropertyLabel���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgPropertyLabel(String value) {
        this.orgPropertyLabel = value;
    }

    /**
     * ��ȡorgProvince���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgProvince() {
        return orgProvince;
    }

    /**
     * ����orgProvince���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgProvince(String value) {
        this.orgProvince = value;
    }

    /**
     * ��ȡorgRank���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgRank() {
        return orgRank;
    }

    /**
     * ����orgRank���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgRank(String value) {
        this.orgRank = value;
    }

    /**
     * ��ȡorgRankLabel���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgRankLabel() {
        return orgRankLabel;
    }

    /**
     * ����orgRankLabel���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgRankLabel(String value) {
        this.orgRankLabel = value;
    }

    /**
     * ��ȡorgSeq���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgSeq() {
        return orgSeq;
    }

    /**
     * ����orgSeq���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgSeq(String value) {
        this.orgSeq = value;
    }

    /**
     * ��ȡorgSort���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgSort() {
        return orgSort;
    }

    /**
     * ����orgSort���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgSort(String value) {
        this.orgSort = value;
    }

    /**
     * ��ȡorgSortId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOrgSortId() {
        return orgSortId;
    }

    /**
     * ����orgSortId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOrgSortId(Long value) {
        this.orgSortId = value;
    }

    /**
     * ��ȡorgSortNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOrgSortNo() {
        return orgSortNo;
    }

    /**
     * ����orgSortNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOrgSortNo(Long value) {
        this.orgSortNo = value;
    }

    /**
     * ��ȡorgSysSort���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgSysSort() {
        return orgSysSort;
    }

    /**
     * ����orgSysSort���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgSysSort(String value) {
        this.orgSysSort = value;
    }

    /**
     * ��ȡorgSysSortLabel���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgSysSortLabel() {
        return orgSysSortLabel;
    }

    /**
     * ����orgSysSortLabel���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgSysSortLabel(String value) {
        this.orgSysSortLabel = value;
    }

    /**
     * ��ȡorgType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgType() {
        return orgType;
    }

    /**
     * ����orgType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgType(String value) {
        this.orgType = value;
    }

    /**
     * ��ȡorgTypeLabel���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgTypeLabel() {
        return orgTypeLabel;
    }

    /**
     * ����orgTypeLabel���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgTypeLabel(String value) {
        this.orgTypeLabel = value;
    }

    /**
     * ��ȡorgUnitType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgUnitType() {
        return orgUnitType;
    }

    /**
     * ����orgUnitType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgUnitType(String value) {
        this.orgUnitType = value;
    }

    /**
     * ��ȡorgWebUrl���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgWebUrl() {
        return orgWebUrl;
    }

    /**
     * ����orgWebUrl���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgWebUrl(String value) {
        this.orgWebUrl = value;
    }

    /**
     * ��ȡorgZipCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgZipCode() {
        return orgZipCode;
    }

    /**
     * ����orgZipCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgZipCode(String value) {
        this.orgZipCode = value;
    }

    /**
     * ��ȡorganizationCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganizationCode() {
        return organizationCode;
    }

    /**
     * ����organizationCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganizationCode(String value) {
        this.organizationCode = value;
    }

    /**
     * ��ȡparentGroupId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentGroupId() {
        return parentGroupId;
    }

    /**
     * ����parentGroupId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentGroupId(String value) {
        this.parentGroupId = value;
    }

    /**
     * ��ȡparentOrgId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentOrgId() {
        return parentOrgId;
    }

    /**
     * ����parentOrgId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentOrgId(Long value) {
        this.parentOrgId = value;
    }

    /**
     * ��ȡremark���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemark() {
        return remark;
    }

    /**
     * ����remark���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemark(String value) {
        this.remark = value;
    }

    /**
     * ��ȡshortNameFirst���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortNameFirst() {
        return shortNameFirst;
    }

    /**
     * ����shortNameFirst���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortNameFirst(String value) {
        this.shortNameFirst = value;
    }

    /**
     * ��ȡshortNameSecond���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortNameSecond() {
        return shortNameSecond;
    }

    /**
     * ����shortNameSecond���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortNameSecond(String value) {
        this.shortNameSecond = value;
    }

    /**
     * ��ȡshortNameThird���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortNameThird() {
        return shortNameThird;
    }

    /**
     * ����shortNameThird���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortNameThird(String value) {
        this.shortNameThird = value;
    }

    /**
     * ��ȡuasFlowId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUasFlowId() {
        return uasFlowId;
    }

    /**
     * ����uasFlowId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUasFlowId(String value) {
        this.uasFlowId = value;
    }

    /**
     * ��ȡuasOrgId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUasOrgId() {
        return uasOrgId;
    }

    /**
     * ����uasOrgId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUasOrgId(String value) {
        this.uasOrgId = value;
    }

    /**
     * ��ȡupdateTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link javax.xml.datatype.XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUpdateTime() {
        return updateTime;
    }

    /**
     * ����updateTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link javax.xml.datatype.XMLGregorianCalendar }
     *     
     */
    public void setUpdateTime(XMLGregorianCalendar value) {
        this.updateTime = value;
    }

    /**
     * ��ȡupdator���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdator() {
        return updator;
    }

    /**
     * ����updator���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdator(String value) {
        this.updator = value;
    }

}
