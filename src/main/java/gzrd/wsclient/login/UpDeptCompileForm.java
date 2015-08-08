
package gzrd.wsclient.login;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>upDeptCompileForm complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="upDeptCompileForm">
 *   &lt;complexContent>
 *     &lt;extension base="{http://hugeinfo.com.cn}baseForm">
 *       &lt;sequence>
 *         &lt;element name="careerCompileAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="careerCompileAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="comments" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="compileAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="compileAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="customCompileAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="customCompileAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="deptCompileId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="deptId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="elseCustomCompileTotalAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="elseCustomCompileTotalAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="elseLeaderAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="elseLeaderAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="gqCompileAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="gqCompileAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="jjCompileAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="jjCompileAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="leaderAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="leaderAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="leaderHejiAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="leaderHejiAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="leaderPrefAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="leaderPrefAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ltfwCompileAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ltfwCompileAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="notLeaderTotalAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="notLeaderTotalAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="orgCompileAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="orgCompileAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="singlelineCompileAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="singlelineCompileAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="xzCompileAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="xzCompileAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="zfCompileAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="zfCompileAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="zfzxCompileAct" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="zfzxCompileAppr" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "upDeptCompileForm", propOrder = {
    "careerCompileAct",
    "careerCompileAppr",
    "comments",
    "compileAct",
    "compileAppr",
    "customCompileAct",
    "customCompileAppr",
    "deptCompileId",
    "deptId",
    "elseCustomCompileTotalAct",
    "elseCustomCompileTotalAppr",
    "elseLeaderAct",
    "elseLeaderAppr",
    "gqCompileAct",
    "gqCompileAppr",
    "jjCompileAct",
    "jjCompileAppr",
    "leaderAct",
    "leaderAppr",
    "leaderHejiAct",
    "leaderHejiAppr",
    "leaderPrefAct",
    "leaderPrefAppr",
    "ltfwCompileAct",
    "ltfwCompileAppr",
    "notLeaderTotalAct",
    "notLeaderTotalAppr",
    "orgCompileAct",
    "orgCompileAppr",
    "singlelineCompileAct",
    "singlelineCompileAppr",
    "xzCompileAct",
    "xzCompileAppr",
    "zfCompileAct",
    "zfCompileAppr",
    "zfzxCompileAct",
    "zfzxCompileAppr"
})
public class UpDeptCompileForm
    extends BaseForm
{

    protected Long careerCompileAct;
    protected Long careerCompileAppr;
    protected Long comments;
    protected Long compileAct;
    protected Long compileAppr;
    protected Long customCompileAct;
    protected Long customCompileAppr;
    protected Long deptCompileId;
    protected Long deptId;
    protected Long elseCustomCompileTotalAct;
    protected Long elseCustomCompileTotalAppr;
    protected Long elseLeaderAct;
    protected Long elseLeaderAppr;
    protected Long gqCompileAct;
    protected Long gqCompileAppr;
    protected Long jjCompileAct;
    protected Long jjCompileAppr;
    protected Long leaderAct;
    protected Long leaderAppr;
    protected Long leaderHejiAct;
    protected Long leaderHejiAppr;
    protected Long leaderPrefAct;
    protected Long leaderPrefAppr;
    protected Long ltfwCompileAct;
    protected Long ltfwCompileAppr;
    protected Long notLeaderTotalAct;
    protected Long notLeaderTotalAppr;
    protected Long orgCompileAct;
    protected Long orgCompileAppr;
    protected Long singlelineCompileAct;
    protected Long singlelineCompileAppr;
    protected Long xzCompileAct;
    protected Long xzCompileAppr;
    protected Long zfCompileAct;
    protected Long zfCompileAppr;
    protected Long zfzxCompileAct;
    protected Long zfzxCompileAppr;

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
     * 获取comments属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getComments() {
        return comments;
    }

    /**
     * 设置comments属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setComments(Long value) {
        this.comments = value;
    }

    /**
     * 获取compileAct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCompileAct() {
        return compileAct;
    }

    /**
     * 设置compileAct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCompileAct(Long value) {
        this.compileAct = value;
    }

    /**
     * 获取compileAppr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCompileAppr() {
        return compileAppr;
    }

    /**
     * 设置compileAppr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCompileAppr(Long value) {
        this.compileAppr = value;
    }

    /**
     * 获取customCompileAct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCustomCompileAct() {
        return customCompileAct;
    }

    /**
     * 设置customCompileAct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCustomCompileAct(Long value) {
        this.customCompileAct = value;
    }

    /**
     * 获取customCompileAppr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCustomCompileAppr() {
        return customCompileAppr;
    }

    /**
     * 设置customCompileAppr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCustomCompileAppr(Long value) {
        this.customCompileAppr = value;
    }

    /**
     * 获取deptCompileId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDeptCompileId() {
        return deptCompileId;
    }

    /**
     * 设置deptCompileId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDeptCompileId(Long value) {
        this.deptCompileId = value;
    }

    /**
     * 获取deptId属性的值。
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
     * 设置deptId属性的值。
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
     * 获取elseCustomCompileTotalAct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getElseCustomCompileTotalAct() {
        return elseCustomCompileTotalAct;
    }

    /**
     * 设置elseCustomCompileTotalAct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setElseCustomCompileTotalAct(Long value) {
        this.elseCustomCompileTotalAct = value;
    }

    /**
     * 获取elseCustomCompileTotalAppr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getElseCustomCompileTotalAppr() {
        return elseCustomCompileTotalAppr;
    }

    /**
     * 设置elseCustomCompileTotalAppr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setElseCustomCompileTotalAppr(Long value) {
        this.elseCustomCompileTotalAppr = value;
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
     * 获取leaderHejiAct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLeaderHejiAct() {
        return leaderHejiAct;
    }

    /**
     * 设置leaderHejiAct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLeaderHejiAct(Long value) {
        this.leaderHejiAct = value;
    }

    /**
     * 获取leaderHejiAppr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLeaderHejiAppr() {
        return leaderHejiAppr;
    }

    /**
     * 设置leaderHejiAppr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLeaderHejiAppr(Long value) {
        this.leaderHejiAppr = value;
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

}
