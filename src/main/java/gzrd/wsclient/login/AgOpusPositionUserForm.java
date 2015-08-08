
package gzrd.wsclient.login;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>agOpusPositionUserForm complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="agOpusPositionUserForm">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="apps" type="{http://hugeinfo.com.cn}upApplicationForm" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="isMain" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="position" type="{http://hugeinfo.com.cn}agOpusPosition" minOccurs="0"/>
 *         &lt;element name="roleCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="user" type="{http://hugeinfo.com.cn}agOpusUser" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "agOpusPositionUserForm", propOrder = {
    "apps",
    "isMain",
    "position",
    "roleCount",
    "user"
})
public class AgOpusPositionUserForm {

    @XmlElement(nillable = true)
    protected List<UpApplicationForm> apps;
    protected String isMain;
    protected AgOpusPosition position;
    protected Long roleCount;
    protected AgOpusUser user;

    /**
     * Gets the value of the apps property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the apps property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApps().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UpApplicationForm }
     * 
     * 
     */
    public List<UpApplicationForm> getApps() {
        if (apps == null) {
            apps = new ArrayList<UpApplicationForm>();
        }
        return this.apps;
    }

    /**
     * ��ȡisMain���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsMain() {
        return isMain;
    }

    /**
     * ����isMain���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsMain(String value) {
        this.isMain = value;
    }

    /**
     * ��ȡposition���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link AgOpusPosition }
     *     
     */
    public AgOpusPosition getPosition() {
        return position;
    }

    /**
     * ����position���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link AgOpusPosition }
     *     
     */
    public void setPosition(AgOpusPosition value) {
        this.position = value;
    }

    /**
     * ��ȡroleCount���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRoleCount() {
        return roleCount;
    }

    /**
     * ����roleCount���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRoleCount(Long value) {
        this.roleCount = value;
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

}
