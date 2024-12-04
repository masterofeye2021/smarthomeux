//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v4.0.5 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
//


package de.smarthome.smartux.xmlSchemaData;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für knx complex type.</p>
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.</p>
 * 
 * <pre>{@code
 * <complexType name="knx">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <all>
 *         <element name="add1" type="{}knx.address"/>
 *         <element name="add2" type="{}knx.address"/>
 *         <element name="add3" type="{}knx.address"/>
 *       </all>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "knx", propOrder = {

})
public class Knx {

    @XmlElement(required = true)
    protected KnxAddress add1;
    @XmlElement(required = true)
    protected KnxAddress add2;
    @XmlElement(required = true)
    protected KnxAddress add3;

    /**
     * Ruft den Wert der add1-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link KnxAddress }
     *     
     */
    public KnxAddress getAdd1() {
        return add1;
    }

    /**
     * Legt den Wert der add1-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link KnxAddress }
     *     
     */
    public void setAdd1(KnxAddress value) {
        this.add1 = value;
    }

    /**
     * Ruft den Wert der add2-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link KnxAddress }
     *     
     */
    public KnxAddress getAdd2() {
        return add2;
    }

    /**
     * Legt den Wert der add2-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link KnxAddress }
     *     
     */
    public void setAdd2(KnxAddress value) {
        this.add2 = value;
    }

    /**
     * Ruft den Wert der add3-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link KnxAddress }
     *     
     */
    public KnxAddress getAdd3() {
        return add3;
    }

    /**
     * Legt den Wert der add3-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link KnxAddress }
     *     
     */
    public void setAdd3(KnxAddress value) {
        this.add3 = value;
    }

}
