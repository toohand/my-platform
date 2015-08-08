
package gzrd.wsclient.post;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>upFunctionForm complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="upFunctionForm">
 *   &lt;complexContent>
 *     &lt;extension base="{http://hugeinfo.com.cn}baseForm">
 *       &lt;sequence>
 *         &lt;element name="appId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="application" type="{http://hugeinfo.com.cn}upApplicationForm" minOccurs="0"/>
 *         &lt;element name="checked" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="childList" type="{http://hugeinfo.com.cn}upFunctionForm" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="funcCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="funcDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="funcId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="funcName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="funcType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="funcTypeLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="funcUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="groupName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="groupSortNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isBeginGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isCheck" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isMenu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="menuNames" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="module" type="{http://hugeinfo.com.cn}upModuleForm" minOccurs="0"/>
 *         &lt;element name="moduleId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="operationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="operationUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parentFuncId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="phoneFunction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shortCut" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sortNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="urlType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "upFunctionForm", propOrder = {
    "appId",
    "application",
    "checked",
    "childList",
    "funcCode",
    "funcDesc",
    "funcId",
    "funcName",
    "funcType",
    "funcTypeLabel",
    "funcUrl",
    "groupName",
    "groupSortNo",
    "isBeginGroup",
    "isCheck",
    "isGroup",
    "isMenu",
    "menuNames",
    "module",
    "moduleId",
    "operationDate",
    "operationUser",
    "parentFuncId",
    "phoneFunction",
    "remark",
    "shortCut",
    "sortNo",
    "urlType"
})
public class UpFunctionForm
    extends BaseForm
{

    protected Long appId;
    protected UpApplicationForm application;
    protected String checked;
    @XmlElement(nillable = true)
    protected List<UpFunctionForm> childList;
    protected String funcCode;
    protected String funcDesc;
    protected Long funcId;
    protected String funcName;
    protected String funcType;
    protected String funcTypeLabel;
    protected String funcUrl;
    protected String groupName;
    protected String groupSortNo;
    protected String isBeginGroup;
    protected String isCheck;
    protected String isGroup;
    protected String isMenu;
    protected String menuNames;
    protected UpModuleForm module;
    protected Long moduleId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar operationDate;
    protected String operationUser;
    protected Long parentFuncId;
    protected String phoneFunction;
    protected String remark;
    protected String shortCut;
    protected Long sortNo;
    protected String urlType;

    /**
     * ��ȡappId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAppId() {
        return appId;
    }

    /**
     * ����appId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAppId(Long value) {
        this.appId = value;
    }

    /**
     * ��ȡapplication���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link gzrd.wsclient.post.UpApplicationForm }
     *     
     */
    public UpApplicationForm getApplication() {
        return application;
    }

    /**
     * ����application���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link gzrd.wsclient.post.UpApplicationForm }
     *     
     */
    public void setApplication(UpApplicationForm value) {
        this.application = value;
    }

    /**
     * ��ȡchecked���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChecked() {
        return checked;
    }

    /**
     * ����checked���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChecked(String value) {
        this.checked = value;
    }

    /**
     * Gets the value of the childList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the childList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChildList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UpFunctionForm }
     * 
     * 
     */
    public List<UpFunctionForm> getChildList() {
        if (childList == null) {
            childList = new ArrayList<UpFunctionForm>();
        }
        return this.childList;
    }

    /**
     * ��ȡfuncCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuncCode() {
        return funcCode;
    }

    /**
     * ����funcCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuncCode(String value) {
        this.funcCode = value;
    }

    /**
     * ��ȡfuncDesc���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuncDesc() {
        return funcDesc;
    }

    /**
     * ����funcDesc���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuncDesc(String value) {
        this.funcDesc = value;
    }

    /**
     * ��ȡfuncId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFuncId() {
        return funcId;
    }

    /**
     * ����funcId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFuncId(Long value) {
        this.funcId = value;
    }

    /**
     * ��ȡfuncName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuncName() {
        return funcName;
    }

    /**
     * ����funcName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuncName(String value) {
        this.funcName = value;
    }

    /**
     * ��ȡfuncType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuncType() {
        return funcType;
    }

    /**
     * ����funcType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuncType(String value) {
        this.funcType = value;
    }

    /**
     * ��ȡfuncTypeLabel���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuncTypeLabel() {
        return funcTypeLabel;
    }

    /**
     * ����funcTypeLabel���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuncTypeLabel(String value) {
        this.funcTypeLabel = value;
    }

    /**
     * ��ȡfuncUrl���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuncUrl() {
        return funcUrl;
    }

    /**
     * ����funcUrl���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuncUrl(String value) {
        this.funcUrl = value;
    }

    /**
     * ��ȡgroupName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * ����groupName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupName(String value) {
        this.groupName = value;
    }

    /**
     * ��ȡgroupSortNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupSortNo() {
        return groupSortNo;
    }

    /**
     * ����groupSortNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupSortNo(String value) {
        this.groupSortNo = value;
    }

    /**
     * ��ȡisBeginGroup���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsBeginGroup() {
        return isBeginGroup;
    }

    /**
     * ����isBeginGroup���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsBeginGroup(String value) {
        this.isBeginGroup = value;
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
     * ��ȡisGroup���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsGroup() {
        return isGroup;
    }

    /**
     * ����isGroup���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsGroup(String value) {
        this.isGroup = value;
    }

    /**
     * ��ȡisMenu���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsMenu() {
        return isMenu;
    }

    /**
     * ����isMenu���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsMenu(String value) {
        this.isMenu = value;
    }

    /**
     * ��ȡmenuNames���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMenuNames() {
        return menuNames;
    }

    /**
     * ����menuNames���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMenuNames(String value) {
        this.menuNames = value;
    }

    /**
     * ��ȡmodule���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link UpModuleForm }
     *     
     */
    public UpModuleForm getModule() {
        return module;
    }

    /**
     * ����module���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link UpModuleForm }
     *     
     */
    public void setModule(UpModuleForm value) {
        this.module = value;
    }

    /**
     * ��ȡmoduleId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getModuleId() {
        return moduleId;
    }

    /**
     * ����moduleId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setModuleId(Long value) {
        this.moduleId = value;
    }

    /**
     * ��ȡoperationDate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link javax.xml.datatype.XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOperationDate() {
        return operationDate;
    }

    /**
     * ����operationDate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link javax.xml.datatype.XMLGregorianCalendar }
     *     
     */
    public void setOperationDate(XMLGregorianCalendar value) {
        this.operationDate = value;
    }

    /**
     * ��ȡoperationUser���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationUser() {
        return operationUser;
    }

    /**
     * ����operationUser���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationUser(String value) {
        this.operationUser = value;
    }

    /**
     * ��ȡparentFuncId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentFuncId() {
        return parentFuncId;
    }

    /**
     * ����parentFuncId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentFuncId(Long value) {
        this.parentFuncId = value;
    }

    /**
     * ��ȡphoneFunction���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneFunction() {
        return phoneFunction;
    }

    /**
     * ����phoneFunction���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneFunction(String value) {
        this.phoneFunction = value;
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
     * ��ȡshortCut���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortCut() {
        return shortCut;
    }

    /**
     * ����shortCut���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortCut(String value) {
        this.shortCut = value;
    }

    /**
     * ��ȡsortNo���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSortNo() {
        return sortNo;
    }

    /**
     * ����sortNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSortNo(Long value) {
        this.sortNo = value;
    }

    /**
     * ��ȡurlType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlType() {
        return urlType;
    }

    /**
     * ����urlType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlType(String value) {
        this.urlType = value;
    }

}
