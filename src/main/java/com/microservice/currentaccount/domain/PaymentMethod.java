package com.microservice.currentaccount.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "method_type", discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "method_type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Cash.class, name = "cash"),
    @JsonSubTypes.Type(value = Check.class, name = "check"),
    @JsonSubTypes.Type(value = Transfer.class, name = "transfer"),
})
public abstract class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private String observation;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getObservation() {
        return observation;
    }
    public void setObservation(String observation) {
        this.observation = observation;
    }

    @Override
    public String toString() {
        return "PaymentMethod [id=" + id + ", observation=" + observation + ", ";
    }

}
