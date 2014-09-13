package nl.rdj.beer.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Beer {
    
    private String brand;

    public Beer() {
        // Required by JAXB
    }
    
    public Beer(String brand) {
        this.brand = brand;
    }
    
}
