//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0-b170531.0717 
//         See <a href="https://jaxb.java.net/">https://jaxb.java.net/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2018.05.24 at 08:39:24 AM MSK 
//


package by.it.poprugo.jd02_09_mine;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the by.it_academy.akhmelev package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: by.it_academy.akhmelev
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Orders }
     *
     */
    public Orders createOrders() {
        return new Orders();
    }

    /**
     * Create an instance of {@link Person }
     *
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link Contract }
     *
     */
    public Contract createContract() {
        return new Contract();
    }

    /**
     * Create an instance of {@link Production }
     *
     */
    public Production createProduction() {
        return new Production();
    }

}
