package com.rjd.jpa.eclipselink.derby.domain.unidirectional;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String brand;

    public Car() {
    }

    public Car(String brand) {
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", brand=" + brand + '}';
    }

}
