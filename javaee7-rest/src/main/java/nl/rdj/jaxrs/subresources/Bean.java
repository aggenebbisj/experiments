package nl.rdj.jaxrs.subresources;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Bean {
    private String name;
    
    @XmlElement(name="foo")    
    private boolean b;

    public Bean() {
        // Required by JAXB
    }
    
    public Bean(String name, boolean b) {
        this.name = name;
        this.b = b;
    }
    
}
