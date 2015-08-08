
package gzrd.wsclient.unit;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SortOrg complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="SortOrg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bwbOrgSortId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0" form="qualified"/>
 *         &lt;element name="orgDTOList" type="{http://hugeinfo.com.cn}Org" maxOccurs="unbounded" minOccurs="0" form="qualified"/>
 *         &lt;element name="orgSortName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SortOrg", propOrder = {
    "bwbOrgSortId",
    "orgDTOList",
    "orgSortName"
})
public class SortOrg {

    protected Long bwbOrgSortId;
    protected List<Org> orgDTOList;
    protected String orgSortName;

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
     * Gets the value of the orgDTOList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orgDTOList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrgDTOList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Org }
     * 
     * 
     */
    public List<Org> getOrgDTOList() {
        if (orgDTOList == null) {
            orgDTOList = new ArrayList<Org>();
        }
        return this.orgDTOList;
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

}
