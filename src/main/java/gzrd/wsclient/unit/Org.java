
package gzrd.wsclient.unit;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Org complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Org">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="approvalNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="children" type="{http://hugeinfo.com.cn}Org" maxOccurs="unbounded" minOccurs="0" form="qualified"/>
 *         &lt;element name="complaintTel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="deptList" type="{http://hugeinfo.com.cn}Dept" maxOccurs="unbounded" minOccurs="0" form="qualified"/>
 *         &lt;element name="foundTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0" form="qualified"/>
 *         &lt;element name="fundForm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0" form="qualified"/>
 *         &lt;element name="isLeaf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="isStationOrg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="linkMan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="linkTel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="orgAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="orgCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="orgCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="orgEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="orgFunc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="orgName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="orgNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0" form="qualified"/>
 *         &lt;element name="orgProperty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="orgProvince" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="orgRank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="orgSortId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0" form="qualified"/>
 *         &lt;element name="orgSortName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="orgSortNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0" form="qualified"/>
 *         &lt;element name="orgSysSort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="orgType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="orgWebUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="orgZipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="organizationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="parentOrgId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0" form="qualified"/>
 *         &lt;element name="shortNameFirst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="shortNameSecond" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="shortNameThird" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="uasFlowId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="uasOrgId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Org", propOrder = {
    "approvalNumber",
    "children",
    "complaintTel",
    "deptList",
    "foundTime",
    "fundForm",
    "id",
    "isLeaf",
    "isStationOrg",
    "linkMan",
    "linkTel",
    "orgAddress",
    "orgCity",
    "orgCode",
    "orgEmail",
    "orgFunc",
    "orgName",
    "orgNo",
    "orgProperty",
    "orgProvince",
    "orgRank",
    "orgSortId",
    "orgSortName",
    "orgSortNo",
    "orgSysSort",
    "orgType",
    "orgWebUrl",
    "orgZipCode",
    "organizationCode",
    "parentOrgId",
    "shortNameFirst",
    "shortNameSecond",
    "shortNameThird",
    "uasFlowId",
    "uasOrgId"
})
public class Org {

    protected String approvalNumber;
    protected List<Org> children;
    protected String complaintTel;
    protected List<Dept> deptList;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar foundTime;
    protected String fundForm;
    protected Long id;
    protected String isLeaf;
    protected String isStationOrg;
    protected String linkMan;
    protected String linkTel;
    protected String orgAddress;
    protected String orgCity;
    protected String orgCode;
    protected String orgEmail;
    protected String orgFunc;
    protected String orgName;
    protected Long orgNo;
    protected String orgProperty;
    protected String orgProvince;
    protected String orgRank;
    protected Long orgSortId;
    protected String orgSortName;
    protected Long orgSortNo;
    protected String orgSysSort;
    protected String orgType;
    protected String orgWebUrl;
    protected String orgZipCode;
    protected String organizationCode;
    protected Long parentOrgId;
    protected String shortNameFirst;
    protected String shortNameSecond;
    protected String shortNameThird;
    protected String uasFlowId;
    protected String uasOrgId;

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
     * {@link Org }
     * 
     * 
     */
    public List<Org> getChildren() {
        if (children == null) {
            children = new ArrayList<Org>();
        }
        return this.children;
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
     * {@link gzrd.wsclient.unit.Dept }
     * 
     * 
     */
    public List<Dept> getDeptList() {
        if (deptList == null) {
            deptList = new ArrayList<Dept>();
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
     * ��ȡorgSortName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgSortName() {
        return orgSortName;
    }

    /**
     * ����orgSortName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgSortName(String value) {
        this.orgSortName = value;
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

}
