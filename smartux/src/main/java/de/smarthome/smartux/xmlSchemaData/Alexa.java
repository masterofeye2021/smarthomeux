//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v4.0.5 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
//


package de.smarthome.smartux.xmlSchemaData;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für alexa complex type.</p>
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.</p>
 * 
 * <pre>{@code
 * <complexType name="alexa">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <attribute name="inverted">
 *         <simpleType>
 *           <restriction base="{http://www.w3.org/2001/XMLSchema}anyURI">
 *             <enumeration value="true"/>
 *             <enumeration value="false"/>
 *           </restriction>
 *         </simpleType>
 *       </attribute>
 *       <attribute name="primaryControl" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="capabilityNames" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="supportedCommands" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="supportedRange" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="unitOfMeasure" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="actionMappings" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="stateMappings" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="alexa" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "alexa")
public class Alexa {

    @XmlAttribute(name = "inverted")
    protected String inverted;
    @XmlAttribute(name = "primaryControl")
    protected String primaryControl;
    @XmlAttribute(name = "capabilityNames")
    protected String capabilityNames;
    @XmlAttribute(name = "supportedCommands")
    protected String supportedCommands;
    @XmlAttribute(name = "supportedRange")
    protected String supportedRange;
    @XmlAttribute(name = "unitOfMeasure")
    protected String unitOfMeasure;
    @XmlAttribute(name = "actionMappings")
    protected String actionMappings;
    @XmlAttribute(name = "stateMappings")
    protected String stateMappings;
    @XmlAttribute(name = "alexa")
    protected String alexa;

    /**
     * Ruft den Wert der inverted-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInverted() {
        return inverted;
    }

    /**
     * Legt den Wert der inverted-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInverted(String value) {
        this.inverted = value;
    }

    /**
     * Ruft den Wert der primaryControl-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryControl() {
        return primaryControl;
    }

    /**
     * Legt den Wert der primaryControl-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryControl(String value) {
        this.primaryControl = value;
    }

    /**
     * Ruft den Wert der capabilityNames-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapabilityNames() {
        return capabilityNames;
    }

    /**
     * Legt den Wert der capabilityNames-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapabilityNames(String value) {
        this.capabilityNames = value;
    }

    /**
     * Ruft den Wert der supportedCommands-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupportedCommands() {
        return supportedCommands;
    }

    /**
     * Legt den Wert der supportedCommands-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupportedCommands(String value) {
        this.supportedCommands = value;
    }

    /**
     * Ruft den Wert der supportedRange-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupportedRange() {
        return supportedRange;
    }

    /**
     * Legt den Wert der supportedRange-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupportedRange(String value) {
        this.supportedRange = value;
    }

    /**
     * Ruft den Wert der unitOfMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    /**
     * Legt den Wert der unitOfMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitOfMeasure(String value) {
        this.unitOfMeasure = value;
    }

    /**
     * Ruft den Wert der actionMappings-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionMappings() {
        return actionMappings;
    }

    /**
     * Legt den Wert der actionMappings-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionMappings(String value) {
        this.actionMappings = value;
    }

    /**
     * Ruft den Wert der stateMappings-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateMappings() {
        return stateMappings;
    }

    /**
     * Legt den Wert der stateMappings-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateMappings(String value) {
        this.stateMappings = value;
    }

    /**
     * Ruft den Wert der alexa-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlexa() {
        return alexa;
    }

    /**
     * Legt den Wert der alexa-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlexa(String value) {
        this.alexa = value;
    }

}
