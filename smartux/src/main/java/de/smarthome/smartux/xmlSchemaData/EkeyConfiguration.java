//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v4.0.5 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
//


package de.smarthome.smartux.xmlSchemaData;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
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
 *       <all>
 *         <element name="thing">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <attribute name="ipAddress" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="port" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 <attribute name="protocol" use="required">
 *                   <simpleType>
 *                     <restriction base="{http://www.w3.org/2001/XMLSchema}anyURI">
 *                       <enumeration value="RARE"/>
 *                       <enumeration value="MULTI"/>
 *                       <enumeration value="HOME"/>
 *                     </restriction>
 *                   </simpleType>
 *                 </attribute>
 *                 <attribute name="natIp" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="delimiter" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               </restriction>
 *             </complexContent>
 *           </complexType>
 *         </element>
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
@XmlRootElement(name = "ekey.configuration")
public class EkeyConfiguration {

    @XmlElement(required = true)
    protected EkeyConfiguration.Thing thing;

    /**
     * Ruft den Wert der thing-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EkeyConfiguration.Thing }
     *     
     */
    public EkeyConfiguration.Thing getThing() {
        return thing;
    }

    /**
     * Legt den Wert der thing-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EkeyConfiguration.Thing }
     *     
     */
    public void setThing(EkeyConfiguration.Thing value) {
        this.thing = value;
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
     *       <attribute name="ipAddress" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="port" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       <attribute name="protocol" use="required">
     *         <simpleType>
     *           <restriction base="{http://www.w3.org/2001/XMLSchema}anyURI">
     *             <enumeration value="RARE"/>
     *             <enumeration value="MULTI"/>
     *             <enumeration value="HOME"/>
     *           </restriction>
     *         </simpleType>
     *       </attribute>
     *       <attribute name="natIp" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="delimiter" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Thing {

        @XmlAttribute(name = "ipAddress", required = true)
        protected String ipAddress;
        @XmlAttribute(name = "port", required = true)
        protected int port;
        @XmlAttribute(name = "protocol", required = true)
        protected String protocol;
        @XmlAttribute(name = "natIp")
        protected String natIp;
        @XmlAttribute(name = "delimiter", required = true)
        protected String delimiter;

        /**
         * Ruft den Wert der ipAddress-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIpAddress() {
            return ipAddress;
        }

        /**
         * Legt den Wert der ipAddress-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIpAddress(String value) {
            this.ipAddress = value;
        }

        /**
         * Ruft den Wert der port-Eigenschaft ab.
         * 
         */
        public int getPort() {
            return port;
        }

        /**
         * Legt den Wert der port-Eigenschaft fest.
         * 
         */
        public void setPort(int value) {
            this.port = value;
        }

        /**
         * Ruft den Wert der protocol-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getProtocol() {
            return protocol;
        }

        /**
         * Legt den Wert der protocol-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setProtocol(String value) {
            this.protocol = value;
        }

        /**
         * Ruft den Wert der natIp-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNatIp() {
            return natIp;
        }

        /**
         * Legt den Wert der natIp-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNatIp(String value) {
            this.natIp = value;
        }

        /**
         * Ruft den Wert der delimiter-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDelimiter() {
            return delimiter;
        }

        /**
         * Legt den Wert der delimiter-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDelimiter(String value) {
            this.delimiter = value;
        }

    }

}
