//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.23 at 05:11:22 PM EDT 
//


package org.xframium.driver.xsd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for xApplication complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="xApplication"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="capability" type="{http://www.xframium.org/xFramiumDriver}xDeviceCapability" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="fileName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="appPackage" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="bundleId" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="url" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="iosInstall" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="androidInstall" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "xApplication", propOrder = {
    "capability"
})
public class XApplication {

    protected List<XDeviceCapability> capability;
    @XmlAttribute(name = "fileName")
    protected String fileName;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "appPackage")
    protected String appPackage;
    @XmlAttribute(name = "bundleId")
    protected String bundleId;
    @XmlAttribute(name = "url")
    protected String url;
    @XmlAttribute(name = "iosInstall")
    protected String iosInstall;
    @XmlAttribute(name = "androidInstall")
    protected String androidInstall;

    /**
     * Gets the value of the capability property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the capability property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCapability().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XDeviceCapability }
     * 
     * 
     */
    public List<XDeviceCapability> getCapability() {
        if (capability == null) {
            capability = new ArrayList<XDeviceCapability>();
        }
        return this.capability;
    }

    /**
     * Gets the value of the fileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the value of the fileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileName(String value) {
        this.fileName = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the appPackage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppPackage() {
        return appPackage;
    }

    /**
     * Sets the value of the appPackage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppPackage(String value) {
        this.appPackage = value;
    }

    /**
     * Gets the value of the bundleId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBundleId() {
        return bundleId;
    }

    /**
     * Sets the value of the bundleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBundleId(String value) {
        this.bundleId = value;
    }

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the iosInstall property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIosInstall() {
        return iosInstall;
    }

    /**
     * Sets the value of the iosInstall property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIosInstall(String value) {
        this.iosInstall = value;
    }

    /**
     * Gets the value of the androidInstall property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAndroidInstall() {
        return androidInstall;
    }

    /**
     * Sets the value of the androidInstall property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAndroidInstall(String value) {
        this.androidInstall = value;
    }

}
