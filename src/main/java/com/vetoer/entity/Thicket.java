package com.vetoer.entity;

/**
 * 丛林实体类
 */
public class Thicket {
    private int thicket_id;
    private String name;
    private String siteType;
    private String addressType;
    private String address;
    private double price;
    private int  state;
    private int recommed;

    public Thicket() {
    }

    public Thicket(int thicket_id, String name, String siteType, String addressType, String address, double price, int state, int recommed) {
        this.thicket_id = thicket_id;
        this.name = name;
        this.siteType = siteType;
        this.addressType = addressType;
        this.address = address;
        this.price = price;
        this.state = state;
        this.recommed = recommed;
    }

    public int getThicket_id() {

        return thicket_id;
    }

    public void setThicket_id(int thicket_id) {
        this.thicket_id = thicket_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getRecommed() {
        return recommed;
    }

    public void setRecommed(int recommed) {
        this.recommed = recommed;
    }

    @Override
    public String toString() {
        return "Thicket{" +
                "thicket_id=" + thicket_id +
                ", name='" + name + '\'' +
                ", siteType='" + siteType + '\'' +
                ", addressType='" + addressType + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", state=" + state +
                ", recommed=" + recommed +
                '}';
    }
}
