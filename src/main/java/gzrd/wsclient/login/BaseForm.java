
package gzrd.wsclient.login;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>baseForm complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="baseForm">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "baseForm")
@XmlSeeAlso({
    UpModuleForm.class,
    UpPositionForm.class,
    UpFunctionForm.class,
    UpRoleForm.class,
    UpDepartmentForm.class,
    UpOrgForm.class,
    AgOpusServerForm.class,
    UpApplicationForm.class,
    UpDeptCompileForm.class
})
public abstract class BaseForm {


}
