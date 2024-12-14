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
 *                 <attribute name="hostname" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="refreshInterval" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                 <attribute name="refreshNtp" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                 <attribute name="serverPort" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                 <attribute name="timeZone" type="{http://www.w3.org/2001/XMLSchema}string" />
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
@XmlRootElement(name = "ntp.configuration")
public class NtpConfiguration {

    @XmlElement(required = true)
    protected NtpConfiguration.Thing thing;

    /**
     * Ruft den Wert der thing-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NtpConfiguration.Thing }
     *     
     */
    public NtpConfiguration.Thing getThing() {
        return thing;
    }

    /**
     * Legt den Wert der thing-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NtpConfiguration.Thing }
     *     
     */
    public void setThing(NtpConfiguration.Thing value) {
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
     *       <attribute name="hostname" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="refreshInterval" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
     *       <attribute name="refreshNtp" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
     *       <attribute name="serverPort" type="{http://www.w3.org/2001/XMLSchema}short" />
     *       <attribute name="timeZone" type="{http://www.w3.org/2001/XMLSchema}string" />
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

        @XmlAttribute(name = "hostname", required = true)
        protected String hostname;
        @XmlAttribute(name = "refreshInterval", required = true)
        protected short refreshInterval;
        @XmlAttribute(name = "refreshNtp", required = true)
        protected short refreshNtp;
        @XmlAttribute(name = "serverPort")
        protected Short serverPort;
        @XmlAttribute(name = "timeZone")
        protected String timeZone;

        /**
         * Ruft den Wert der hostname-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHostname() {
            return hostname;
        }

        /**
         * Legt den Wert der hostname-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHostname(String value) {
            this.hostname = value;
        }

        /**
         * Ruft den Wert der refreshInterval-Eigenschaft ab.
         * 
         */
        public short getRefreshInterval() {
            return refreshInterval;
        }

        /**
         * Legt den Wert der refreshInterval-Eigenschaft fest.
         * 
         */
        public void setRefreshInterval(short value) {
            this.refreshInterval = value;
        }

        /**
         * Ruft den Wert der refreshNtp-Eigenschaft ab.
         * 
         */
        public short getRefreshNtp() {
            return refreshNtp;
        }

        /**
         * Legt den Wert der refreshNtp-Eigenschaft fest.
         * 
         */
        public void setRefreshNtp(short value) {
            this.refreshNtp = value;
        }

        /**
         * Ruft den Wert der serverPort-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Short }
         *     
         */
        public Short getServerPort() {
            return serverPort;
        }

        /**
         * Legt den Wert der serverPort-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Short }
         *     
         */
        public void setServerPort(Short value) {
            this.serverPort = value;
        }

        /**
         * Ruft den Wert der timeZone-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTimeZone() {
            return timeZone;
        }

        /**
         * Legt den Wert der timeZone-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTimeZone(String value) {
            this.timeZone = value;
        }

    }

}
