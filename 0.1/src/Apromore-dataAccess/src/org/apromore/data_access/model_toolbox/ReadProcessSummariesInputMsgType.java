
package org.apromore.data_access.model_toolbox;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.cxf.jaxb.JAXBToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;


/**
 * <p>Java class for ReadProcessSummariesInputMsgType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReadProcessSummariesInputMsgType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProcessVersions" type="{http://www.apromore.org/data_access/model_toolbox}ProcessVersionsType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReadProcessSummariesInputMsgType", propOrder = {
    "processVersions"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2010-11-18T04:27:53+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
public class ReadProcessSummariesInputMsgType {

    @XmlElement(name = "ProcessVersions", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2010-11-18T04:27:53+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected ProcessVersionsType processVersions;

    /**
     * Gets the value of the processVersions property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessVersionsType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2010-11-18T04:27:53+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public ProcessVersionsType getProcessVersions() {
        return processVersions;
    }

    /**
     * Sets the value of the processVersions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessVersionsType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2010-11-18T04:27:53+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setProcessVersions(ProcessVersionsType value) {
        this.processVersions = value;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2010-11-18T04:27:53+01:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public String toString() {
        return JAXBToStringBuilder.valueOf(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}