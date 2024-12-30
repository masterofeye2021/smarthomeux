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
 *                 <attribute name="baseURL" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="timeout" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                 <attribute name="refresh" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                 <attribute name="bufferSize" type="{http://www.w3.org/2001/XMLSchema}short" default="2048" />
 *                 <attribute name="delay" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                 <attribute name="username" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="password" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="authMode" use="required">
 *                   <simpleType>
 *                     <restriction base="{http://www.w3.org/2001/XMLSchema}anyURI">
 *                       <enumeration value="BASIC"/>
 *                       <enumeration value="BASIC_PREEMPTIVE"/>
 *                       <enumeration value="TOKEN"/>
 *                       <enumeration value="DIGEST"/>
 *                     </restriction>
 *                   </simpleType>
 *                 </attribute>
 *                 <attribute name="stateMethod" use="required">
 *                   <simpleType>
 *                     <restriction base="{http://www.w3.org/2001/XMLSchema}anyURI">
 *                       <enumeration value="GET"/>
 *                       <enumeration value="PUT"/>
 *                       <enumeration value="POST"/>
 *                     </restriction>
 *                   </simpleType>
 *                 </attribute>
 *                 <attribute name="commandMethod" use="required">
 *                   <simpleType>
 *                     <restriction base="{http://www.w3.org/2001/XMLSchema}anyURI">
 *                       <enumeration value="GET"/>
 *                       <enumeration value="PUT"/>
 *                       <enumeration value="POST"/>
 *                     </restriction>
 *                   </simpleType>
 *                 </attribute>
 *                 <attribute name="contentType">
 *                   <simpleType>
 *                     <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       <enumeration value="PUT"/>
 *                       <enumeration value="POST"/>
 *                     </restriction>
 *                   </simpleType>
 *                 </attribute>
 *                 <attribute name="ignoreSSLErrors" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 <attribute name="strictErrorHandling" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
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
@XmlRootElement(name = "door.configuration")
public class DoorConfiguration {

    @XmlElement(required = true)
    protected DoorConfiguration.Thing thing;

    /**
     * Ruft den Wert der thing-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DoorConfiguration.Thing }
     *     
     */
    public DoorConfiguration.Thing getThing() {
        return thing;
    }

    /**
     * Legt den Wert der thing-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DoorConfiguration.Thing }
     *     
     */
    public void setThing(DoorConfiguration.Thing value) {
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
     *       <attribute name="baseURL" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="timeout" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
     *       <attribute name="refresh" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
     *       <attribute name="bufferSize" type="{http://www.w3.org/2001/XMLSchema}short" default="2048" />
     *       <attribute name="delay" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
     *       <attribute name="username" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="password" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="authMode" use="required">
     *         <simpleType>
     *           <restriction base="{http://www.w3.org/2001/XMLSchema}anyURI">
     *             <enumeration value="BASIC"/>
     *             <enumeration value="BASIC_PREEMPTIVE"/>
     *             <enumeration value="TOKEN"/>
     *             <enumeration value="DIGEST"/>
     *           </restriction>
     *         </simpleType>
     *       </attribute>
     *       <attribute name="stateMethod" use="required">
     *         <simpleType>
     *           <restriction base="{http://www.w3.org/2001/XMLSchema}anyURI">
     *             <enumeration value="GET"/>
     *             <enumeration value="PUT"/>
     *             <enumeration value="POST"/>
     *           </restriction>
     *         </simpleType>
     *       </attribute>
     *       <attribute name="commandMethod" use="required">
     *         <simpleType>
     *           <restriction base="{http://www.w3.org/2001/XMLSchema}anyURI">
     *             <enumeration value="GET"/>
     *             <enumeration value="PUT"/>
     *             <enumeration value="POST"/>
     *           </restriction>
     *         </simpleType>
     *       </attribute>
     *       <attribute name="contentType">
     *         <simpleType>
     *           <restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             <enumeration value="PUT"/>
     *             <enumeration value="POST"/>
     *           </restriction>
     *         </simpleType>
     *       </attribute>
     *       <attribute name="ignoreSSLErrors" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       <attribute name="strictErrorHandling" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
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

        @XmlAttribute(name = "baseURL", required = true)
        protected String baseURL;
        @XmlAttribute(name = "timeout", required = true)
        protected short timeout;
        @XmlAttribute(name = "refresh", required = true)
        protected short refresh;
        @XmlAttribute(name = "bufferSize")
        protected Short bufferSize;
        @XmlAttribute(name = "delay", required = true)
        protected short delay;
        @XmlAttribute(name = "username")
        protected String username;
        @XmlAttribute(name = "password")
        protected String password;
        @XmlAttribute(name = "authMode", required = true)
        protected String authMode;
        @XmlAttribute(name = "stateMethod", required = true)
        protected String stateMethod;
        @XmlAttribute(name = "commandMethod", required = true)
        protected String commandMethod;
        @XmlAttribute(name = "contentType")
        protected String contentType;
        @XmlAttribute(name = "ignoreSSLErrors", required = true)
        protected boolean ignoreSSLErrors;
        @XmlAttribute(name = "strictErrorHandling", required = true)
        protected boolean strictErrorHandling;

        /**
         * Ruft den Wert der baseURL-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBaseURL() {
            return baseURL;
        }

        /**
         * Legt den Wert der baseURL-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBaseURL(String value) {
            this.baseURL = value;
        }

        /**
         * Ruft den Wert der timeout-Eigenschaft ab.
         * 
         */
        public short getTimeout() {
            return timeout;
        }

        /**
         * Legt den Wert der timeout-Eigenschaft fest.
         * 
         */
        public void setTimeout(short value) {
            this.timeout = value;
        }

        /**
         * Ruft den Wert der refresh-Eigenschaft ab.
         * 
         */
        public short getRefresh() {
            return refresh;
        }

        /**
         * Legt den Wert der refresh-Eigenschaft fest.
         * 
         */
        public void setRefresh(short value) {
            this.refresh = value;
        }

        /**
         * Ruft den Wert der bufferSize-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Short }
         *     
         */
        public short getBufferSize() {
            if (bufferSize == null) {
                return ((short) 2048);
            } else {
                return bufferSize;
            }
        }

        /**
         * Legt den Wert der bufferSize-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Short }
         *     
         */
        public void setBufferSize(Short value) {
            this.bufferSize = value;
        }

        /**
         * Ruft den Wert der delay-Eigenschaft ab.
         * 
         */
        public short getDelay() {
            return delay;
        }

        /**
         * Legt den Wert der delay-Eigenschaft fest.
         * 
         */
        public void setDelay(short value) {
            this.delay = value;
        }

        /**
         * Ruft den Wert der username-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUsername() {
            return username;
        }

        /**
         * Legt den Wert der username-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUsername(String value) {
            this.username = value;
        }

        /**
         * Ruft den Wert der password-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPassword() {
            return password;
        }

        /**
         * Legt den Wert der password-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPassword(String value) {
            this.password = value;
        }

        /**
         * Ruft den Wert der authMode-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAuthMode() {
            return authMode;
        }

        /**
         * Legt den Wert der authMode-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAuthMode(String value) {
            this.authMode = value;
        }

        /**
         * Ruft den Wert der stateMethod-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStateMethod() {
            return stateMethod;
        }

        /**
         * Legt den Wert der stateMethod-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStateMethod(String value) {
            this.stateMethod = value;
        }

        /**
         * Ruft den Wert der commandMethod-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCommandMethod() {
            return commandMethod;
        }

        /**
         * Legt den Wert der commandMethod-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCommandMethod(String value) {
            this.commandMethod = value;
        }

        /**
         * Ruft den Wert der contentType-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContentType() {
            return contentType;
        }

        /**
         * Legt den Wert der contentType-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContentType(String value) {
            this.contentType = value;
        }

        /**
         * Ruft den Wert der ignoreSSLErrors-Eigenschaft ab.
         * 
         */
        public boolean isIgnoreSSLErrors() {
            return ignoreSSLErrors;
        }

        /**
         * Legt den Wert der ignoreSSLErrors-Eigenschaft fest.
         * 
         */
        public void setIgnoreSSLErrors(boolean value) {
            this.ignoreSSLErrors = value;
        }

        /**
         * Ruft den Wert der strictErrorHandling-Eigenschaft ab.
         * 
         */
        public boolean isStrictErrorHandling() {
            return strictErrorHandling;
        }

        /**
         * Legt den Wert der strictErrorHandling-Eigenschaft fest.
         * 
         */
        public void setStrictErrorHandling(boolean value) {
            this.strictErrorHandling = value;
        }

    }

}
