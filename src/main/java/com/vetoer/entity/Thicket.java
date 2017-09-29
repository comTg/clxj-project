package com.vetoer.entity;

/**
 * 丛林实体类
 */
public class Thicket {
    private int thicketId;
    private String name;
    private String siteType;
    private String addressType;
    private String address;
    private double price;
    private int  state;
    private int recommed;
    private int type;  // 1 表示丛林,0表示闲居
    private ThicketAdmin thicketAdmin;

    public Thicket() {
    }

    public Thicket(int thicketId, String name, String siteType, String addressType, String address, double price, int state, int recommed,int type) {
        this.thicketId = thicketId;
        this.name = name;
        this.siteType = siteType;
        this.addressType = addressType;
        this.address = address;
        this.price = price;
        this.state = state;
        this.recommed = recommed;
        this.type = type;
    }

    public Thicket(int thicketId, String name, String siteType, String addressType, String address, double price, int state, int recommed, int type, ThicketAdmin thicketAdmin) {
        this.thicketId = thicketId;
        this.name = name;
        this.siteType = siteType;
        this.addressType = addressType;
        this.address = address;
        this.price = price;
        this.state = state;
        this.recommed = recommed;
        this.type = type;
        this.thicketAdmin = thicketAdmin;
    }

    public int getThicketId() {

        return thicketId;
    }

    public void setThicketId(int thicketId) {
        this.thicketId = thicketId;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ThicketAdmin getThicketAdmin() {
        return thicketAdmin;
    }

    public void setThicketAdmin(ThicketAdmin thicketAdmin) {
        this.thicketAdmin = thicketAdmin;
    }

    public void setRecommed(int recommed) {

        this.recommed = recommed;
    }

    @Override
    public String toString() {
        return "Thicket{" +
                "thicketId=" + thicketId +
                ", name='" + name + '\'' +
                ", siteType='" + siteType + '\'' +
                ", addressType='" + addressType + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", state=" + state +
                ", recommed=" + recommed +
                ", type=" + type +
                ", thicketAdmin=" + thicketAdmin +
                '}';
    }
}
