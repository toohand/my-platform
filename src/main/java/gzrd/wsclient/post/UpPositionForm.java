
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
 * <p>upPositionForm complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="upPositionForm">
 *   &lt;complexContent>
 *     &lt;extension base="{http://hugeinfo.com.cn}baseForm">
 *       &lt;sequence>
 *         &lt;element name="canManDepts" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="children" type="{http://hugeinfo.com.cn}upPositionForm" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="createTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="creator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="delFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="departmentForm" type="{http://hugeinfo.com.cn}upDepartmentForm" minOccurs="0"/>
 *         &lt;element name="dept" type="{http://hugeinfo.com.cn}agOpusDepartment" minOccurs="0"/>
 *         &lt;element name="deptId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="deptListJson" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deptName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="editeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="isAgent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isDeptLeader" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isEditorCreate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isPub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="no" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="noInCity" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="noInOrg" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="opusUserPosition" type="{http://hugeinfo.com.cn}agOpusUserPosition" minOccurs="0"/>
 *         &lt;element name="orgForm" type="{http://hugeinfo.com.cn}upOrgForm" minOccurs="0"/>
 *         &lt;element name="orgId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="orgLeaderOrder" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="orgName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parentPosId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parentPositions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="posFunction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="posName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="posType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sonPosId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sonPositions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uasDeptId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uasFlowId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uasOrgId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uasPosId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="updateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="updater" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="user" type="{http://hugeinfo.com.cn}agOpusUser" minOccurs="0"/>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "upPositionForm", propOrder = {
    "canManDepts",
    "children",
    "createTime",
    "creator",
    "delFlag",
    "departmentForm",
    "dept",
    "deptId",
    "deptListJson",
    "deptName",
    "description",
    "editeType",
    "email",
    "id",
    "isAgent",
    "isDeptLeader",
    "isEditorCreate",
    "isPub",
    "no",
    "noInCity",
    "noInOrg",
    "opusUserPosition",
    "orgForm",
    "orgId",
    "orgLeaderOrder",
    "orgName",
    "parentPosId",
    "parentPositions",
    "posFunction",
    "posName",
    "posType",
    "rank",
    "remark",
    "sonPosId",
    "sonPositions",
    "uasDeptId",
    "uasFlowId",
    "uasOrgId",
    "uasPosId",
    "updateTime",
    "updater",
    "user",
    "userName"
})
public class UpPositionForm
    extends BaseForm
{

    protected String canManDepts;
    @XmlElement(nillable = true)
    protected List<UpPositionForm> children;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createTime;
    protected String creator;
    protected String delFlag;
    protected UpDepartmentForm departmentForm;
    protected AgOpusDepartment dept;
    protected Long deptId;
    protected String deptListJson;
    protected String deptName;
    protected String description;
    protected String editeType;
    protected String email;
    protected Long id;
    protected String isAgent;
    protected String isDeptLeader;
    protected String isEditorCreate;
    protected String isPub;
    protected Long no;
    protected Long noInCity;
    protected Long noInOrg;
    protected AgOpusUserPosition opusUserPosition;
    protected UpOrgForm orgForm;
    protected Long orgId;
    protected Long orgLeaderOrder;
    protected String orgName;
    protected String parentPosId;
    protected String parentPositions;
    protected String posFunction;
    protected String posName;
    protected String posType;
    protected String rank;
    protected String remark;
    protected String sonPosId;
    protected String sonPositions;
    protected String uasDeptId;
    protected String uasFlowId;
    protected String uasOrgId;
    protected String uasPosId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updateTime;
    protected String updater;
    protected AgOpusUser user;
    protected String userName;

    /**
     * ��ȡcanManDepts���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCanManDepts() {
        return canManDepts;
    }

    /**
     * ����canManDepts���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCanManDepts(String value) {
        this.canManDepts = value;
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
     * {@link UpPositionForm }
     * 
     * 
     */
    public List<UpPositionForm> getChildren() {
        if (children == null) {
            children = new ArrayList<UpPositionForm>();
        }
        return this.children;
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
     * ��ȡdepartmentForm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link gzrd.wsclient.post.UpDepartmentForm }
     *     
     */
    public UpDepartmentForm getDepartmentForm() {
        return departmentForm;
    }

    /**
     * ����departmentForm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link gzrd.wsclient.post.UpDepartmentForm }
     *     
     */
    public void setDepartmentForm(UpDepartmentForm value) {
        this.departmentForm = value;
    }

    /**
     * ��ȡdept���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link gzrd.wsclient.post.AgOpusDepartment }
     *     
     */
    public AgOpusDepartment getDept() {
        return dept;
    }

    /**
     * ����dept���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link gzrd.wsclient.post.AgOpusDepartment }
     *     
     */
    public void setDept(AgOpusDepartment value) {
        this.dept = value;
    }

    /**
     * ��ȡdeptId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * ����deptId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDeptId(Long value) {
        this.deptId = value;
    }

    /**
     * ��ȡdeptListJson���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptListJson() {
        return deptListJson;
    }

    /**
     * ����deptListJson���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptListJson(String value) {
        this.deptListJson = value;
    }

    /**
     * ��ȡdeptName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * ����deptName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeptName(String value) {
        this.deptName = value;
    }

    /**
     * ��ȡdescription���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * ����description���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * ��ȡediteType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEditeType() {
        return editeType;
    }

    /**
     * ����editeType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEditeType(String value) {
        this.editeType = value;
    }

    /**
     * ��ȡemail���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * ����email���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
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
     * ��ȡisAgent���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsAgent() {
        return isAgent;
    }

    /**
     * ����isAgent���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsAgent(String value) {
        this.isAgent = value;
    }

    /**
     * ��ȡisDeptLeader���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsDeptLeader() {
        return isDeptLeader;
    }

    /**
     * ����isDeptLeader���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsDeptLeader(String value) {
        this.isDeptLeader = value;
    }

    /**
     * ��ȡisEditorCreate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsEditorCreate() {
        return isEditorCreate;
    }

    /**
     * ����isEditorCreate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsEditorCreate(String value) {
        this.isEditorCreate = value;
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
     * ��ȡno���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNo() {
        return no;
    }

    /**
     * ����no���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNo(Long value) {
        this.no = value;
    }

    /**
     * ��ȡnoInCity���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNoInCity() {
        return noInCity;
    }

    /**
     * ����noInCity���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNoInCity(Long value) {
        this.noInCity = value;
    }

    /**
     * ��ȡnoInOrg���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNoInOrg() {
        return noInOrg;
    }

    /**
     * ����noInOrg���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNoInOrg(Long value) {
        this.noInOrg = value;
    }

    /**
     * ��ȡopusUserPosition���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link gzrd.wsclient.post.AgOpusUserPosition }
     *     
     */
    public AgOpusUserPosition getOpusUserPosition() {
        return opusUserPosition;
    }

    /**
     * ����opusUserPosition���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link gzrd.wsclient.post.AgOpusUserPosition }
     *     
     */
    public void setOpusUserPosition(AgOpusUserPosition value) {
        this.opusUserPosition = value;
    }

    /**
     * ��ȡorgForm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link UpOrgForm }
     *     
     */
    public UpOrgForm getOrgForm() {
        return orgForm;
    }

    /**
     * ����orgForm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link UpOrgForm }
     *     
     */
    public void setOrgForm(UpOrgForm value) {
        this.orgForm = value;
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
     * ��ȡorgLeaderOrder���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOrgLeaderOrder() {
        return orgLeaderOrder;
    }

    /**
     * ����orgLeaderOrder���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOrgLeaderOrder(Long value) {
        this.orgLeaderOrder = value;
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
     * ��ȡparentPosId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentPosId() {
        return parentPosId;
    }

    /**
     * ����parentPosId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentPosId(String value) {
        this.parentPosId = value;
    }

    /**
     * ��ȡparentPositions���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentPositions() {
        return parentPositions;
    }

    /**
     * ����parentPositions���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentPositions(String value) {
        this.parentPositions = value;
    }

    /**
     * ��ȡposFunction���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosFunction() {
        return posFunction;
    }

    /**
     * ����posFunction���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosFunction(String value) {
        this.posFunction = value;
    }

    /**
     * ��ȡposName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosName() {
        return posName;
    }

    /**
     * ����posName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosName(String value) {
        this.posName = value;
    }

    /**
     * ��ȡposType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosType() {
        return posType;
    }

    /**
     * ����posType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosType(String value) {
        this.posType = value;
    }

    /**
     * ��ȡrank���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRank() {
        return rank;
    }

    /**
     * ����rank���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRank(String value) {
        this.rank = value;
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
     * ��ȡsonPosId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSonPosId() {
        return sonPosId;
    }

    /**
     * ����sonPosId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSonPosId(String value) {
        this.sonPosId = value;
    }

    /**
     * ��ȡsonPositions���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSonPositions() {
        return sonPositions;
    }

    /**
     * ����sonPositions���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSonPositions(String value) {
        this.sonPositions = value;
    }

    /**
     * ��ȡuasDeptId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUasDeptId() {
        return uasDeptId;
    }

    /**
     * ����uasDeptId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUasDeptId(String value) {
        this.uasDeptId = value;
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
     * ��ȡuasPosId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUasPosId() {
        return uasPosId;
    }

    /**
     * ����uasPosId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUasPosId(String value) {
        this.uasPosId = value;
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
     * ��ȡupdater���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdater() {
        return updater;
    }

    /**
     * ����updater���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdater(String value) {
        this.updater = value;
    }

    /**
     * ��ȡuser���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link AgOpusUser }
     *     
     */
    public AgOpusUser getUser() {
        return user;
    }

    /**
     * ����user���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link AgOpusUser }
     *     
     */
    public void setUser(AgOpusUser value) {
        this.user = value;
    }

    /**
     * ��ȡuserName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * ����userName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

}
