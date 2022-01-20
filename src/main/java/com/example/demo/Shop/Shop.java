package com.example.demo.Shop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Shop {
    @Id
    @SequenceGenerator(
        name = "shop_sequence",
        sequenceName = "shop_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "shop_sequence"
    )
    private long id;
    private String name;
    private String type;
    private boolean deliveryAvailable;
    private String shopCode;

    public Shop(String name, String type, Boolean deliveryAvailable, String shopCode) {
        this.name = name;
        this.type = type;
        this.deliveryAvailable = deliveryAvailable;
        this.shopCode = shopCode;
    }

    public Shop() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isDeliveryAvailable() {
        return deliveryAvailable;
    }

    public void setDeliveryAvailable(boolean deliveryAvailable) {
        this.deliveryAvailable = deliveryAvailable;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", type='" + getType() + "'" +
            ", deliveryAvailable='" + isDeliveryAvailable() + "'" +
            "}";
    }

    
}
