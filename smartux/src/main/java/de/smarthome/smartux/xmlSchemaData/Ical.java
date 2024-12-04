//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v4.0.5 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
//


package de.smarthome.smartux.xmlSchemaData;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für anonymous complex type.</p>
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.</p>
 * 
 * <pre>{@code
 * <complexType>
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <attribute name="maxEvents" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       <attribute name="refreshTime" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       <attribute name="datetimeUnit" use="required">
 *         <simpleType>
 *           <restriction base="{http://www.w3.org/2001/XMLSchema}anyURI">
 *             <enumeration value="MINUTE"/>
 *             <enumeration value="HOUR"/>
 *             <enumeration value="DAY"/>
 *             <enumeration value="WEEK"/>
 *           </restriction>
 *         </simpleType>
 *       </attribute>
 *       <attribute name="datetimeStart" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="datetimeEnd" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="textEventField" use="required">
 *         <simpleType>
 *           <restriction base="{http://www.w3.org/2001/XMLSchema}anyURI">
 *             <pattern value="SUMMARY"/>
 *             <pattern value="DESCRIPTION"/>
 *             <pattern value="COMMENT"/>
 *             <pattern value="CONTACT"/>
 *             <pattern value="LOCATION"/>
 *           </restriction>
 *         </simpleType>
 *       </attribute>
 *       <attribute name="textEventValue" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="textValueType" use="required">
 *         <simpleType>
 *           <restriction base="{http://www.w3.org/2001/XMLSchema}anyURI">
 *             <enumeration value="TEXT"/>
 *             <enumeration value="REGEX"/>
 *           </restriction>
 *         </simpleType>
 *       </attribute>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "ical")
public class Ical {

    @XmlAttribute(name = "maxEvents", required = true)
    protected short maxEvents;
    @XmlAttribute(name = "refreshTime", required = true)
    protected short refreshTime;
    @XmlAttribute(name = "datetimeUnit", required = true)
    protected String datetimeUnit;
    @XmlAttribute(name = "datetimeStart", required = true)
    protected String datetimeStart;
    @XmlAttribute(name = "datetimeEnd", required = true)
    protected String datetimeEnd;
    @XmlAttribute(name = "textEventField", required = true)
    protected String textEventField;
    @XmlAttribute(name = "textEventValue", required = true)
    protected String textEventValue;
    @XmlAttribute(name = "textValueType", required = true)
    protected String textValueType;

    /**
     * Ruft den Wert der maxEvents-Eigenschaft ab.
     * 
     */
    public short getMaxEvents() {
        return maxEvents;
    }

    /**
     * Legt den Wert der maxEvents-Eigenschaft fest.
     * 
     */
    public void setMaxEvents(short value) {
        this.maxEvents = value;
    }

    /**
     * Ruft den Wert der refreshTime-Eigenschaft ab.
     * 
     */
    public short getRefreshTime() {
        return refreshTime;
    }

    /**
     * Legt den Wert der refreshTime-Eigenschaft fest.
     * 
     */
    public void setRefreshTime(short value) {
        this.refreshTime = value;
    }

    /**
     * Ruft den Wert der datetimeUnit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatetimeUnit() {
        return datetimeUnit;
    }

    /**
     * Legt den Wert der datetimeUnit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatetimeUnit(String value) {
        this.datetimeUnit = value;
    }

    /**
     * Ruft den Wert der datetimeStart-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatetimeStart() {
        return datetimeStart;
    }

    /**
     * Legt den Wert der datetimeStart-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatetimeStart(String value) {
        this.datetimeStart = value;
    }

    /**
     * Ruft den Wert der datetimeEnd-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatetimeEnd() {
        return datetimeEnd;
    }

    /**
     * Legt den Wert der datetimeEnd-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatetimeEnd(String value) {
        this.datetimeEnd = value;
    }

    /**
     * Ruft den Wert der textEventField-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextEventField() {
        return textEventField;
    }

    /**
     * Legt den Wert der textEventField-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextEventField(String value) {
        this.textEventField = value;
    }

    /**
     * Ruft den Wert der textEventValue-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextEventValue() {
        return textEventValue;
    }

    /**
     * Legt den Wert der textEventValue-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextEventValue(String value) {
        this.textEventValue = value;
    }

    /**
     * Ruft den Wert der textValueType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextValueType() {
        return textValueType;
    }

    /**
     * Legt den Wert der textValueType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextValueType(String value) {
        this.textValueType = value;
    }

}
