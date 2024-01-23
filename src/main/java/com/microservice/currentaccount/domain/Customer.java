package com.microservice.currentaccount.domain;

public class Customer {

    private Integer id;
    private String businessName;
    private String cuit;
    private String email;

    public Customer() {}

    public Integer getId() {
        return id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public String getCuit() {
        return cuit;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", businessName=" + businessName + ", cuit=" + cuit + ", email=" + email + "]";
    }

}
