
package gzrd.wsclient.login;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>upModuleForm complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="upModuleForm">
 *   &lt;complexContent>
 *     &lt;extension base="{http://hugeinfo.com.cn}baseForm">
 *       &lt;sequence>
 *         &lt;element name="appId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="application" type="{http://hugeinfo.com.cn}upApplicationForm" minOccurs="0"/>
 *         &lt;element name="children" type="{http://hugeinfo.com.cn}upModuleForm" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="functions" type="{http://hugeinfo.com.cn}upFunctionForm" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="isBeginGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isDzzwSetup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isLeaf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="moduleCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="moduleId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="moduleLevel" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="moduleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="moduleSeq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="moduleType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="moduleTypeLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="moduleUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parentModule" type="{http://hugeinfo.com.cn}upModuleForm" minOccurs="0"/>
 *         &lt;element name="parentModuleId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="parentModuleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shortCut" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sortNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "upModuleForm", propOrder = {
    "appId",
    "application",
    "children",
    "functions",
    "isBeginGroup",
    "isDzzwSetup",
    "isLeaf",
    "moduleCode",
    "moduleId",
    "moduleLevel",
    "moduleName",
    "moduleSeq",
    "moduleType",
    "moduleTypeLabel",
    "moduleUrl",
    "parentModule",
    "parentModuleId",
    "parentModuleName",
    "remark",
    "shortCut",
    "sortNo",
    "subCount"
})
public class UpModuleForm
    extends BaseForm
{

    protected Long appId;
    protected UpApplicationForm application;
    @XmlElement(nillable = true)
    protected List<UpModuleForm> children;
    @XmlElement(nillable = true)
    protected List<UpFunctionForm> functions;
    protected String isBeginGroup;
    protected String isDzzwSetup;
    protected String isLeaf;
    protected String moduleCode;
    protected Long moduleId;
    protected Integer moduleLevel;
    protected String moduleName;
    protected String moduleSeq;
    protected String moduleType;
    protected String moduleTypeLabel;
    protected String moduleUrl;
    protected UpModuleForm parentModule;
    protected Long parentModuleId;
    protected String parentModuleName;
    protected String remark;
    protected String shortCut;
    protected String sortNo;
    protected Integer subCount;

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
     *     {@link gzrd.wsclient.login.UpApplicationForm }
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
     *     {@link gzrd.wsclient.login.UpApplicationForm }
     *     
     */
    public void setApplication(UpApplicationForm value) {
        this.application = value;
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
     * Gets the value of the functions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the functions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFunctions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link gzrd.wsclient.login.UpFunctionForm }
     * 
     * 
     */
    public List<UpFunctionForm> getFunctions() {
        if (functions == null) {
            functions = new ArrayList<UpFunctionForm>();
        }
        return this.functions;
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
     * ��ȡisDzzwSetup���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsDzzwSetup() {
        return isDzzwSetup;
    }

    /**
     * ����isDzzwSetup���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsDzzwSetup(String value) {
        this.isDzzwSetup = value;
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
     * ��ȡmoduleCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModuleCode() {
        return moduleCode;
    }

    /**
     * ����moduleCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModuleCode(String value) {
        this.moduleCode = value;
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
     * ��ȡmoduleLevel���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getModuleLevel() {
        return moduleLevel;
    }

    /**
     * ����moduleLevel���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setModuleLevel(Integer value) {
        this.moduleLevel = value;
    }

    /**
     * ��ȡmoduleName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * ����moduleName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModuleName(String value) {
        this.moduleName = value;
    }

    /**
     * ��ȡmoduleSeq���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModuleSeq() {
        return moduleSeq;
    }

    /**
     * ����moduleSeq���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModuleSeq(String value) {
        this.moduleSeq = value;
    }

    /**
     * ��ȡmoduleType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModuleType() {
        return moduleType;
    }

    /**
     * ����moduleType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModuleType(String value) {
        this.moduleType = value;
    }

    /**
     * ��ȡmoduleTypeLabel���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModuleTypeLabel() {
        return moduleTypeLabel;
    }

    /**
     * ����moduleTypeLabel���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModuleTypeLabel(String value) {
        this.moduleTypeLabel = value;
    }

    /**
     * ��ȡmoduleUrl���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModuleUrl() {
        return moduleUrl;
    }

    /**
     * ����moduleUrl���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModuleUrl(String value) {
        this.moduleUrl = value;
    }

    /**
     * ��ȡparentModule���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link UpModuleForm }
     *     
     */
    public UpModuleForm getParentModule() {
        return parentModule;
    }

    /**
     * ����parentModule���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link UpModuleForm }
     *     
     */
    public void setParentModule(UpModuleForm value) {
        this.parentModule = value;
    }

    /**
     * ��ȡparentModuleId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentModuleId() {
        return parentModuleId;
    }

    /**
     * ����parentModuleId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentModuleId(Long value) {
        this.parentModuleId = value;
    }

    /**
     * ��ȡparentModuleName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentModuleName() {
        return parentModuleName;
    }

    /**
     * ����parentModuleName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentModuleName(String value) {
        this.parentModuleName = value;
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
     *     {@link String }
     *     
     */
    public String getSortNo() {
        return sortNo;
    }

    /**
     * ����sortNo���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSortNo(String value) {
        this.sortNo = value;
    }

    /**
     * ��ȡsubCount���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSubCount() {
        return subCount;
    }

    /**
     * ����subCount���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSubCount(Integer value) {
        this.subCount = value;
    }

}
