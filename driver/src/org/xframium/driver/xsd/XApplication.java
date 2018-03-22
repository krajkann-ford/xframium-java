//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.20 at 02:41:29 PM EDT 
//


package org.xframium.driver.xsd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Defines the application(s) available for testing.  This will define how an application is installed and launched
 * 
 * <p>Java class for xApplication complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="xApplication">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="capability" type="{http://www.xframium.org/xFramiumDriver}xDeviceCapability" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="objectCapability" type="{http://www.xframium.org/xFramiumDriver}xObjectDeviceCapability" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="fileName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="provider" default="LOCAL">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="XML"/>
 *             &lt;enumeration value="SQL"/>
 *             &lt;enumeration value="CSV"/>
 *             &lt;enumeration value="EXCEL"/>
 *             &lt;enumeration value="LOCAL"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="appPackage" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="bundleId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="url" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="iosInstall" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="androidInstall" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}double" default="0.0" />
 *       &lt;attribute name="environment" type="{http://www.w3.org/2001/XMLSchema}string" default="" />
 *       &lt;attribute name="autoStart" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "xApplication", propOrder = {
    "capability",
    "objectCapability"
})
public class XApplication {

    protected List<XDeviceCapability> capability;
    protected List<XObjectDeviceCapability> objectCapability;
    @XmlAttribute(name = "fileName")
    protected String fileName;
    @XmlAttribute(name = "provider")
    protected String provider;
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
    @XmlAttribute(name = "version")
    protected Double version;
    @XmlAttribute(name = "environment")
    protected String environment;
    @XmlAttribute(name = "autoStart")
    protected Boolean autoStart;

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
     * Gets the value of the objectCapability property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the objectCapability property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObjectCapability().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XObjectDeviceCapability }
     * 
     * 
     */
    public List<XObjectDeviceCapability> getObjectCapability() {
        if (objectCapability == null) {
            objectCapability = new ArrayList<XObjectDeviceCapability>();
        }
        return this.objectCapability;
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
     * Gets the value of the provider property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvider() {
        if (provider == null) {
            return "LOCAL";
        } else {
            return provider;
        }
    }

    /**
     * Sets the value of the provider property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvider(String value) {
        this.provider = value;
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

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getVersion() {
        if (version == null) {
            return  0.0D;
        } else {
            return version;
        }
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setVersion(Double value) {
        this.version = value;
    }

    /**
     * Gets the value of the environment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnvironment() {
        if (environment == null) {
            return "";
        } else {
            return environment;
        }
    }

    /**
     * Sets the value of the environment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnvironment(String value) {
        this.environment = value;
    }

    /**
     * Gets the value of the autoStart property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isAutoStart() {
        if (autoStart == null) {
            return true;
        } else {
            return autoStart;
        }
    }

    /**
     * Sets the value of the autoStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutoStart(Boolean value) {
        this.autoStart = value;
    }

}
