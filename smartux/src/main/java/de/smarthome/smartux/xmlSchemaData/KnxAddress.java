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
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für knx.address complex type.</p>
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.</p>
 * 
 * <pre>{@code
 * <complexType name="knx.address">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <all>
 *         <element name="main.ga">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <all>
 *                   <element name="main" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                   <element name="middle" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                   <element name="sub" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                 </all>
 *                 <attribute name="is.readable" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *               </restriction>
 *             </complexContent>
 *           </complexType>
 *         </element>
 *         <element name="listening.ga" minOccurs="0">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <all>
 *                   <element name="main" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                   <element name="middle" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                   <element name="sub" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                 </all>
 *                 <attribute name="is.readable" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
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
@XmlType(name = "knx.address", propOrder = {

})
public class KnxAddress {

    @XmlElement(name = "main.ga", required = true)
    protected KnxAddress.MainGa mainGa;
    @XmlElement(name = "listening.ga")
    protected KnxAddress.ListeningGa listeningGa;

    /**
     * Ruft den Wert der mainGa-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link KnxAddress.MainGa }
     *     
     */
    public KnxAddress.MainGa getMainGa() {
        return mainGa;
    }

    /**
     * Legt den Wert der mainGa-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link KnxAddress.MainGa }
     *     
     */
    public void setMainGa(KnxAddress.MainGa value) {
        this.mainGa = value;
    }

    /**
     * Ruft den Wert der listeningGa-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link KnxAddress.ListeningGa }
     *     
     */
    public KnxAddress.ListeningGa getListeningGa() {
        return listeningGa;
    }

    /**
     * Legt den Wert der listeningGa-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link KnxAddress.ListeningGa }
     *     
     */
    public void setListeningGa(KnxAddress.ListeningGa value) {
        this.listeningGa = value;
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
     *         <element name="main" type="{http://www.w3.org/2001/XMLSchema}short"/>
     *         <element name="middle" type="{http://www.w3.org/2001/XMLSchema}short"/>
     *         <element name="sub" type="{http://www.w3.org/2001/XMLSchema}short"/>
     *       </all>
     *       <attribute name="is.readable" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
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
    public static class ListeningGa {

        protected short main;
        protected short middle;
        protected short sub;
        @XmlAttribute(name = "is.readable")
        protected Boolean isReadable;

        /**
         * Ruft den Wert der main-Eigenschaft ab.
         * 
         */
        public short getMain() {
            return main;
        }

        /**
         * Legt den Wert der main-Eigenschaft fest.
         * 
         */
        public void setMain(short value) {
            this.main = value;
        }

        /**
         * Ruft den Wert der middle-Eigenschaft ab.
         * 
         */
        public short getMiddle() {
            return middle;
        }

        /**
         * Legt den Wert der middle-Eigenschaft fest.
         * 
         */
        public void setMiddle(short value) {
            this.middle = value;
        }

        /**
         * Ruft den Wert der sub-Eigenschaft ab.
         * 
         */
        public short getSub() {
            return sub;
        }

        /**
         * Legt den Wert der sub-Eigenschaft fest.
         * 
         */
        public void setSub(short value) {
            this.sub = value;
        }

        /**
         * Ruft den Wert der isReadable-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isIsReadable() {
            if (isReadable == null) {
                return true;
            } else {
                return isReadable;
            }
        }

        /**
         * Legt den Wert der isReadable-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setIsReadable(Boolean value) {
            this.isReadable = value;
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
     *       <all>
     *         <element name="main" type="{http://www.w3.org/2001/XMLSchema}short"/>
     *         <element name="middle" type="{http://www.w3.org/2001/XMLSchema}short"/>
     *         <element name="sub" type="{http://www.w3.org/2001/XMLSchema}short"/>
     *       </all>
     *       <attribute name="is.readable" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
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
    public static class MainGa {

        protected short main;
        protected short middle;
        protected short sub;
        @XmlAttribute(name = "is.readable")
        protected Boolean isReadable;

        /**
         * Ruft den Wert der main-Eigenschaft ab.
         * 
         */
        public short getMain() {
            return main;
        }

        /**
         * Legt den Wert der main-Eigenschaft fest.
         * 
         */
        public void setMain(short value) {
            this.main = value;
        }

        /**
         * Ruft den Wert der middle-Eigenschaft ab.
         * 
         */
        public short getMiddle() {
            return middle;
        }

        /**
         * Legt den Wert der middle-Eigenschaft fest.
         * 
         */
        public void setMiddle(short value) {
            this.middle = value;
        }

        /**
         * Ruft den Wert der sub-Eigenschaft ab.
         * 
         */
        public short getSub() {
            return sub;
        }

        /**
         * Legt den Wert der sub-Eigenschaft fest.
         * 
         */
        public void setSub(short value) {
            this.sub = value;
        }

        /**
         * Ruft den Wert der isReadable-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isIsReadable() {
            if (isReadable == null) {
                return false;
            } else {
                return isReadable;
            }
        }

        /**
         * Legt den Wert der isReadable-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setIsReadable(Boolean value) {
            this.isReadable = value;
        }

    }

}
