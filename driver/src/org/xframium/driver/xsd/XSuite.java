//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.08 at 01:49:02 PM EDT 
//


package org.xframium.driver.xsd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Defines all of the tests and functions
 * 
 * <p>Java class for xSuite complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="xSuite">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="flow" type="{http://www.xframium.org/xFramiumDriver}xFlow" minOccurs="0"/>
 *         &lt;element name="test" type="{http://www.xframium.org/xFramiumDriver}xTest" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="function" type="{http://www.xframium.org/xFramiumDriver}xFunction" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="packages" type="{http://www.xframium.org/xFramiumDriver}xPackages" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="fileName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="provider" default="LOCAL">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="XML"/>
 *             &lt;enumeration value="GHERKIN"/>
 *             &lt;enumeration value="EXCEL"/>
 *             &lt;enumeration value="LOCAL"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "xSuite", propOrder = {
    "flow",
    "test",
    "function",
    "packages"
})
public class XSuite {

    protected XFlow flow;
    protected List<XTest> test;
    protected List<XFunction> function;
    protected XPackages packages;
    @XmlAttribute(name = "fileName")
    protected String fileName;
    @XmlAttribute(name = "provider")
    protected String provider;

    /**
     * Gets the value of the flow property.
     * 
     * @return
     *     possible object is
     *     {@link XFlow }
     *     
     */
    public XFlow getFlow() {
        return flow;
    }

    /**
     * Sets the value of the flow property.
     * 
     * @param value
     *     allowed object is
     *     {@link XFlow }
     *     
     */
    public void setFlow(XFlow value) {
        this.flow = value;
    }

    /**
     * Gets the value of the test property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the test property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XTest }
     * 
     * 
     */
    public List<XTest> getTest() {
        if (test == null) {
            test = new ArrayList<XTest>();
        }
        return this.test;
    }

    /**
     * Gets the value of the function property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the function property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFunction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XFunction }
     * 
     * 
     */
    public List<XFunction> getFunction() {
        if (function == null) {
            function = new ArrayList<XFunction>();
        }
        return this.function;
    }

    /**
     * Gets the value of the packages property.
     * 
     * @return
     *     possible object is
     *     {@link XPackages }
     *     
     */
    public XPackages getPackages() {
        return packages;
    }

    /**
     * Sets the value of the packages property.
     * 
     * @param value
     *     allowed object is
     *     {@link XPackages }
     *     
     */
    public void setPackages(XPackages value) {
        this.packages = value;
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

}
