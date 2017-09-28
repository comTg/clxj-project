package com.vetoer.entity;

public class Validation {
    private String phone;
    private String validatecode;

    public Validation() {
    }

    public Validation(String phone, String validatecode) {

        this.phone = phone;
        this.validatecode = validatecode;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getValidatecode() {
        return validatecode;
    }

    public void setValidatecode(String validatecode) {
        this.validatecode = validatecode;
    }

    @Override
    public String toString() {
        return "Validation{" +
                "phone='" + phone + '\'' +
                ", validatecode='" + validatecode + '\'' +
                '}';
    }
}
