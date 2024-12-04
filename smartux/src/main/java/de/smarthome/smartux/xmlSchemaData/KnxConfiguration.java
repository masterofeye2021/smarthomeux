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
 *         <element name="bridge">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" default="TUNNEL" />
 *                 <attribute name="ip.address" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="port.number" type="{http://www.w3.org/2001/XMLSchema}string" default="3671" />
 *                 <attribute name="local.ip" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="reading.pause" type="{http://www.w3.org/2001/XMLSchema}short" default="50" />
 *                 <attribute name="response.timeout" type="{http://www.w3.org/2001/XMLSchema}short" default="10" />
 *                 <attribute name="read.retries.limit" type="{http://www.w3.org/2001/XMLSchema}short" default="3" />
 *                 <attribute name="auto.reconnect.period" type="{http://www.w3.org/2001/XMLSchema}short" default="60" />
 *               </restriction>
 *             </complexContent>
 *           </complexType>
 *         </element>
 *         <element name="tunnel">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <attribute name="address" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="fetch" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *                 <attribute name="ping.interval" type="{http://www.w3.org/2001/XMLSchema}short" default="300" />
 *                 <attribute name="read.interval" type="{http://www.w3.org/2001/XMLSchema}short" default="3600" />
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
@XmlRootElement(name = "knx.configuration")
public class KnxConfiguration {

    @XmlElement(required = true)
    protected KnxConfiguration.Bridge bridge;
    @XmlElement(required = true)
    protected KnxConfiguration.Tunnel tunnel;

    /**
     * Ruft den Wert der bridge-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link KnxConfiguration.Bridge }
     *     
     */
    public KnxConfiguration.Bridge getBridge() {
        return bridge;
    }

    /**
     * Legt den Wert der bridge-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link KnxConfiguration.Bridge }
     *     
     */
    public void setBridge(KnxConfiguration.Bridge value) {
        this.bridge = value;
    }

    /**
     * Ruft den Wert der tunnel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link KnxConfiguration.Tunnel }
     *     
     */
    public KnxConfiguration.Tunnel getTunnel() {
        return tunnel;
    }

    /**
     * Legt den Wert der tunnel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link KnxConfiguration.Tunnel }
     *     
     */
    public void setTunnel(KnxConfiguration.Tunnel value) {
        this.tunnel = value;
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
     *       <attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" default="TUNNEL" />
     *       <attribute name="ip.address" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="port.number" type="{http://www.w3.org/2001/XMLSchema}string" default="3671" />
     *       <attribute name="local.ip" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="reading.pause" type="{http://www.w3.org/2001/XMLSchema}short" default="50" />
     *       <attribute name="response.timeout" type="{http://www.w3.org/2001/XMLSchema}short" default="10" />
     *       <attribute name="read.retries.limit" type="{http://www.w3.org/2001/XMLSchema}short" default="3" />
     *       <attribute name="auto.reconnect.period" type="{http://www.w3.org/2001/XMLSchema}short" default="60" />
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Bridge {

        @XmlAttribute(name = "type")
        protected String type;
        @XmlAttribute(name = "ip.address")
        protected String ipAddress;
        @XmlAttribute(name = "port.number")
        protected String portNumber;
        @XmlAttribute(name = "local.ip")
        protected String localIp;
        @XmlAttribute(name = "reading.pause")
        protected Short readingPause;
        @XmlAttribute(name = "response.timeout")
        protected Short responseTimeout;
        @XmlAttribute(name = "read.retries.limit")
        protected Short readRetriesLimit;
        @XmlAttribute(name = "auto.reconnect.period")
        protected Short autoReconnectPeriod;

        /**
         * Ruft den Wert der type-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getType() {
            if (type == null) {
                return "TUNNEL";
            } else {
                return type;
            }
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
         * Ruft den Wert der portNumber-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPortNumber() {
            if (portNumber == null) {
                return "3671";
            } else {
                return portNumber;
            }
        }

        /**
         * Legt den Wert der portNumber-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPortNumber(String value) {
            this.portNumber = value;
        }

        /**
         * Ruft den Wert der localIp-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLocalIp() {
            return localIp;
        }

        /**
         * Legt den Wert der localIp-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLocalIp(String value) {
            this.localIp = value;
        }

        /**
         * Ruft den Wert der readingPause-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Short }
         *     
         */
        public short getReadingPause() {
            if (readingPause == null) {
                return ((short) 50);
            } else {
                return readingPause;
            }
        }

        /**
         * Legt den Wert der readingPause-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Short }
         *     
         */
        public void setReadingPause(Short value) {
            this.readingPause = value;
        }

        /**
         * Ruft den Wert der responseTimeout-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Short }
         *     
         */
        public short getResponseTimeout() {
            if (responseTimeout == null) {
                return ((short) 10);
            } else {
                return responseTimeout;
            }
        }

        /**
         * Legt den Wert der responseTimeout-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Short }
         *     
         */
        public void setResponseTimeout(Short value) {
            this.responseTimeout = value;
        }

        /**
         * Ruft den Wert der readRetriesLimit-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Short }
         *     
         */
        public short getReadRetriesLimit() {
            if (readRetriesLimit == null) {
                return ((short) 3);
            } else {
                return readRetriesLimit;
            }
        }

        /**
         * Legt den Wert der readRetriesLimit-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Short }
         *     
         */
        public void setReadRetriesLimit(Short value) {
            this.readRetriesLimit = value;
        }

        /**
         * Ruft den Wert der autoReconnectPeriod-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Short }
         *     
         */
        public short getAutoReconnectPeriod() {
            if (autoReconnectPeriod == null) {
                return ((short) 60);
            } else {
                return autoReconnectPeriod;
            }
        }

        /**
         * Legt den Wert der autoReconnectPeriod-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Short }
         *     
         */
        public void setAutoReconnectPeriod(Short value) {
            this.autoReconnectPeriod = value;
        }

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
     *       <attribute name="address" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="fetch" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
     *       <attribute name="ping.interval" type="{http://www.w3.org/2001/XMLSchema}short" default="300" />
     *       <attribute name="read.interval" type="{http://www.w3.org/2001/XMLSchema}short" default="3600" />
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Tunnel {

        @XmlAttribute(name = "address")
        protected String address;
        @XmlAttribute(name = "fetch")
        protected Boolean fetch;
        @XmlAttribute(name = "ping.interval")
        protected Short pingInterval;
        @XmlAttribute(name = "read.interval")
        protected Short readInterval;

        /**
         * Ruft den Wert der address-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAddress() {
            return address;
        }

        /**
         * Legt den Wert der address-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAddress(String value) {
            this.address = value;
        }

        /**
         * Ruft den Wert der fetch-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isFetch() {
            if (fetch == null) {
                return true;
            } else {
                return fetch;
            }
        }

        /**
         * Legt den Wert der fetch-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setFetch(Boolean value) {
            this.fetch = value;
        }

        /**
         * Ruft den Wert der pingInterval-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Short }
         *     
         */
        public short getPingInterval() {
            if (pingInterval == null) {
                return ((short) 300);
            } else {
                return pingInterval;
            }
        }

        /**
         * Legt den Wert der pingInterval-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Short }
         *     
         */
        public void setPingInterval(Short value) {
            this.pingInterval = value;
        }

        /**
         * Ruft den Wert der readInterval-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Short }
         *     
         */
        public short getReadInterval() {
            if (readInterval == null) {
                return ((short) 3600);
            } else {
                return readInterval;
            }
        }

        /**
         * Legt den Wert der readInterval-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Short }
         *     
         */
        public void setReadInterval(Short value) {
            this.readInterval = value;
        }

    }

}
