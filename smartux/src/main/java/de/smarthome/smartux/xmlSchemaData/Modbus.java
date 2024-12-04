//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v4.0.5 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
//


package de.smarthome.smartux.xmlSchemaData;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für modbus complex type.</p>
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.</p>
 * 
 * <pre>{@code
 * <complexType name="modbus">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <all>
 *         <element name="poller">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <all>
 *                   <element name="address" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   <element name="length" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                   <element name="type" type="{}modbus.type"/>
 *                 </all>
 *               </restriction>
 *             </complexContent>
 *           </complexType>
 *         </element>
 *         <element name="address" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="read.value" type="{}modbus.read.value"/>
 *       </all>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modbus", propOrder = {

})
public class Modbus {

    @XmlElement(required = true)
    protected Modbus.Poller poller;
    protected int address;
    @XmlElement(name = "read.value", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String readValue;

    /**
     * Ruft den Wert der poller-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Modbus.Poller }
     *     
     */
    public Modbus.Poller getPoller() {
        return poller;
    }

    /**
     * Legt den Wert der poller-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Modbus.Poller }
     *     
     */
    public void setPoller(Modbus.Poller value) {
        this.poller = value;
    }

    /**
     * Ruft den Wert der address-Eigenschaft ab.
     * 
     */
    public int getAddress() {
        return address;
    }

    /**
     * Legt den Wert der address-Eigenschaft fest.
     * 
     */
    public void setAddress(int value) {
        this.address = value;
    }

    /**
     * Ruft den Wert der readValue-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReadValue() {
        return readValue;
    }

    /**
     * Legt den Wert der readValue-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReadValue(String value) {
        this.readValue = value;
    }


    /**
     * <p>Java-Klasse für anonymous complex type.</p>
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.</p>
     * 
     * <pre>{@code
     * <complexType>
     *   <complexContent>
     *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       <all>
     *         <element name="address" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         <element name="length" type="{http://www.w3.org/2001/XMLSchema}short"/>
     *         <element name="type" type="{}modbus.type"/>
     *       </all>
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class Poller {

        protected int address;
        protected short length;
        @XmlElement(required = true, defaultValue = "holding")
        @XmlSchemaType(name = "anyURI")
        protected String type;

        /**
         * Ruft den Wert der address-Eigenschaft ab.
         * 
         */
        public int getAddress() {
            return address;
        }

        /**
         * Legt den Wert der address-Eigenschaft fest.
         * 
         */
        public void setAddress(int value) {
            this.address = value;
        }

        /**
         * Ruft den Wert der length-Eigenschaft ab.
         * 
         */
        public short getLength() {
            return length;
        }

        /**
         * Legt den Wert der length-Eigenschaft fest.
         * 
         */
        public void setLength(short value) {
            this.length = value;
        }

        /**
         * Ruft den Wert der type-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getType() {
            return type;
        }

        /**
         * Legt den Wert der type-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setType(String value) {
            this.type = value;
        }

    }

}
