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
 *                 <attribute name="url" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="refreshTime" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                 <attribute name="username" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="password" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="maxSize" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
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
@XmlRootElement(name = "ical.configuration")
public class IcalConfiguration {

    @XmlElement(required = true)
    protected IcalConfiguration.Bridge bridge;

    /**
     * Ruft den Wert der bridge-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IcalConfiguration.Bridge }
     *     
     */
    public IcalConfiguration.Bridge getBridge() {
        return bridge;
    }

    /**
     * Legt den Wert der bridge-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IcalConfiguration.Bridge }
     *     
     */
    public void setBridge(IcalConfiguration.Bridge value) {
        this.bridge = value;
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
     *       <attribute name="url" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="refreshTime" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
     *       <attribute name="username" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="password" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="maxSize" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
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

        @XmlAttribute(name = "url", required = true)
        protected String url;
        @XmlAttribute(name = "refreshTime", required = true)
        protected short refreshTime;
        @XmlAttribute(name = "username", required = true)
        protected String username;
        @XmlAttribute(name = "password", required = true)
        protected String password;
        @XmlAttribute(name = "maxSize", required = true)
        protected short maxSize;

        /**
         * Ruft den Wert der url-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUrl() {
            return url;
        }

        /**
         * Legt den Wert der url-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUrl(String value) {
            this.url = value;
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
         * Ruft den Wert der maxSize-Eigenschaft ab.
         * 
         */
        public short getMaxSize() {
            return maxSize;
        }

        /**
         * Legt den Wert der maxSize-Eigenschaft fest.
         * 
         */
        public void setMaxSize(short value) {
            this.maxSize = value;
        }

    }

}
