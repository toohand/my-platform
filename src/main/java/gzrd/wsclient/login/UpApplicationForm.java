
package gzrd.wsclient.login;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>upApplicationForm complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="upApplicationForm">
 *   &lt;complexContent>
 *     &lt;extension base="{http://hugeinfo.com.cn}baseForm">
 *       &lt;sequence>
 *         &lt;element name="activeLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="appName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appPos" type="{http://hugeinfo.com.cn}upPositionForm" minOccurs="0"/>
 *         &lt;element name="appType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appTypeLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BAppPos" type="{http://hugeinfo.com.cn}upPositionForm" minOccurs="0"/>
 *         &lt;element name="children" type="{http://hugeinfo.com.cn}upModuleForm" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="delFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isActive" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="orgName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="phoneApp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="roleCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="roles" type="{http://hugeinfo.com.cn}upRoleForm" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="servId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="serverForm" type="{http://hugeinfo.com.cn}agOpusServerForm" minOccurs="0"/>
 *         &lt;element name="sortNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="VAppPos" type="{http://hugeinfo.com.cn}upPositionForm" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "upApplicationForm", propOrder = {
    "activeLabel",
    "appCode",
    "appDesc",
    "appId",
    "appName",
    "appPos",
    "appType",
    "appTypeLabel",
    "appUrl",
    "bAppPos",
    "children",
    "delFlag",
    "isActive",
    "orgId",
    "orgName",
    "phoneApp",
    "remark",
    "roleCode",
    "roles",
    "servId",
    "serverForm",
    "sortNo",
    "vAppPos"
})
public class UpApplicationForm
    extends BaseForm
{

    protected String activeLabel;
    protected String appCode;
    protected String appDesc;
    protected Long appId;
    protected String appName;
    protected UpPositionForm appPos;
    protected String appType;
    protected String appTypeLabel;
    protected String appUrl;
    @XmlElement(name = "BAppPos")
    protected UpPositionForm bAppPos;
    @XmlElement(nillable = true)
    protected List<UpModuleForm> children;
    protected String delFlag;
    protected String isActive;
    protected Long orgId;
    protected String orgName;
    protected String phoneApp;
    protected String remark;
    protected String roleCode;
    @XmlElement(nillable = true)
    protected List<UpRoleForm> roles;
    protected Long servId;
    protected AgOpusServerForm serverForm;
    protected Long sortNo;
    @XmlElement(name = "VAppPos")
    protected UpPositionForm vAppPos;

    /**
     * ��ȡactiveLabel���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActiveLabel() {
        return activeLabel;
    }

    /**
     * ����activeLabel���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActiveLabel(String value) {
        this.activeLabel = value;
    }

    /**
     * ��ȡappCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppCode() {
        return appCode;
    }

    /**
     * ����appCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppCode(String value) {
        this.appCode = value;
    }

    /**
     * ��ȡappDesc���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppDesc() {
        return appDesc;
    }

    /**
     * ����appDesc���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppDesc(String value) {
        this.appDesc = value;
    }

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
     * ��ȡappName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppName() {
        return appName;
    }

    /**
     * ����appName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppName(String value) {
        this.appName = value;
    }

    /**
     * ��ȡappPos���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link UpPositionForm }
     *     
     */
    public UpPositionForm getAppPos() {
        return appPos;
    }

    /**
     * ����appPos���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link UpPositionForm }
     *     
     */
    public void setAppPos(UpPositionForm value) {
        this.appPos = value;
    }

    /**
     * ��ȡappType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppType() {
        return appType;
    }

    /**
     * ����appType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppType(String value) {
        this.appType = value;
    }

    /**
     * ��ȡappTypeLabel���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppTypeLabel() {
        return appTypeLabel;
    }

    /**
     * ����appTypeLabel���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppTypeLabel(String value) {
        this.appTypeLabel = value;
    }

    /**
     * ��ȡappUrl���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppUrl() {
        return appUrl;
    }

    /**
     * ����appUrl���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppUrl(String value) {
        this.appUrl = value;
    }

    /**
     * ��ȡbAppPos���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link UpPositionForm }
     *     
     */
    public UpPositionForm getBAppPos() {
        return bAppPos;
    }

    /**
     * ����bAppPos���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link UpPositionForm }
     *     
     */
    public void setBAppPos(UpPositionForm value) {
        this.bAppPos = value;
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
     * {@link UpModuleForm }
     * 
     * 
     */
    public List<UpModuleForm> getChildren() {
        if (children == null) {
            children = new ArrayList<UpModuleForm>();
        }
        return this.children;
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
     * ��ȡisActive���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsActive() {
        return isActive;
    }

    /**
     * ����isActive���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsActive(String value) {
        this.isActive = value;
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
     * ��ȡphoneApp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneApp() {
        return phoneApp;
    }

    /**
     * ����phoneApp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneApp(String value) {
        this.phoneApp = value;
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
     * ��ȡroleCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * ����roleCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleCode(String value) {
        this.roleCode = value;
    }

    /**
     * Gets the value of the roles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UpRoleForm }
     * 
     * 
     */
    public List<UpRoleForm> getRoles() {
        if (roles == null) {
            roles = new ArrayList<UpRoleForm>();
        }
        return this.roles;
    }

    /**
     * ��ȡservId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getServId() {
        return servId;
    }

    /**
     * ����servId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setServId(Long value) {
        this.servId = value;
    }

    /**
     * ��ȡserverForm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link AgOpusServerForm }
     *     
     */
    public AgOpusServerForm getServerForm() {
        return serverForm;
    }

    /**
     * ����serverForm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link AgOpusServerForm }
     *     
     */
    public void setServerForm(AgOpusServerForm value) {
        this.serverForm = value;
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
     * ��ȡvAppPos���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link UpPositionForm }
     *     
     */
    public UpPositionForm getVAppPos() {
        return vAppPos;
    }

    /**
     * ����vAppPos���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link UpPositionForm }
     *     
     */
    public void setVAppPos(UpPositionForm value) {
        this.vAppPos = value;
    }

}
