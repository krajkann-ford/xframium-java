//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.11.03 at 06:41:06 AM EDT 
//


package org.xframium.driver.xsd;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for xTest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="xTest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="description" type="{http://www.xframium.org/xFramiumDriver}xDescription" minOccurs="0"/&gt;
 *         &lt;element name="step" type="{http://www.xframium.org/xFramiumDriver}xStep" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="type" default="XML"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="XML"/&gt;
 *             &lt;enumeration value="BDD"/&gt;
 *             &lt;enumeration value="CSV"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="dataDriver" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="dataProvider" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="tagNames" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="timed" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="threshold" type="{http://www.w3.org/2001/XMLSchema}integer" default="0" /&gt;
 *       &lt;attribute name="active" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *       &lt;attribute name="os" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="contentKeys" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="deviceTags" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "xTest", propOrder = {
    "description",
    "step"
})
public class XTest {

    protected XDescription description;
    protected List<XStep> step;
    @XmlAttribute(name = "type")
    protected String type;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "dataDriver")
    protected String dataDriver;
    @XmlAttribute(name = "dataProvider")
    protected String dataProvider;
    @XmlAttribute(name = "tagNames")
    protected String tagNames;
    @XmlAttribute(name = "linkId")
    protected String linkId;
    @XmlAttribute(name = "timed")
    protected Boolean timed;
    @XmlAttribute(name = "threshold")
    protected BigInteger threshold;
    @XmlAttribute(name = "active")
    protected Boolean active;
    @XmlAttribute(name = "os")
    protected String os;
    @XmlAttribute(name = "contentKeys")
    protected String contentKeys;
    @XmlAttribute(name = "deviceTags")
    protected String deviceTags;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link XDescription }
     *     
     */
    public XDescription getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link XDescription }
     *     
     */
    public void setDescription(XDescription value) {
        this.description = value;
    }

    /**
     * Gets the value of the step property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the step property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStep().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XStep }
     * 
     * 
     */
    public List<XStep> getStep() {
        if (step == null) {
            step = new ArrayList<XStep>();
        }
        return this.step;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        if (type == null) {
            return "XML";
        } else {
            return type;
        }
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
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
     * Gets the value of the dataDriver property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataDriver() {
        return dataDriver;
    }

    /**
     * Sets the value of the dataDriver property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataDriver(String value) {
        this.dataDriver = value;
    }

    /**
     * Gets the value of the dataProvider property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataProvider() {
        return dataProvider;
    }

    /**
     * Sets the value of the dataProvider property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataProvider(String value) {
        this.dataProvider = value;
    }

    /**
     * Gets the value of the tagNames property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTagNames() {
        return tagNames;
    }

    /**
     * Sets the value of the tagNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTagNames(String value) {
        this.tagNames = value;
    }

    /**
     * Gets the value of the linkId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkId() {
        return linkId;
    }

    /**
     * Sets the value of the linkId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkId(String value) {
        this.linkId = value;
    }

    /**
     * Gets the value of the timed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isTimed() {
        if (timed == null) {
            return false;
        } else {
            return timed;
        }
    }

    /**
     * Sets the value of the timed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTimed(Boolean value) {
        this.timed = value;
    }

    /**
     * Gets the value of the threshold property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getThreshold() {
        if (threshold == null) {
            return new BigInteger("0");
        } else {
            return threshold;
        }
    }

    /**
     * Sets the value of the threshold property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setThreshold(BigInteger value) {
        this.threshold = value;
    }

    /**
     * Gets the value of the active property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isActive() {
        if (active == null) {
            return true;
        } else {
            return active;
        }
    }

    /**
     * Sets the value of the active property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setActive(Boolean value) {
        this.active = value;
    }

    /**
     * Gets the value of the os property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOs() {
        return os;
    }

    /**
     * Sets the value of the os property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOs(String value) {
        this.os = value;
    }

    /**
     * Gets the value of the contentKeys property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentKeys() {
        return contentKeys;
    }

    /**
     * Sets the value of the contentKeys property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentKeys(String value) {
        this.contentKeys = value;
    }

    /**
     * Gets the value of the deviceTags property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceTags() {
        return deviceTags;
    }

    /**
     * Sets the value of the deviceTags property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceTags(String value) {
        this.deviceTags = value;
    }

}
