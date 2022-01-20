package com.example.demo.BookingOrder;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class BookingOrder {
    @Id
    @SequenceGenerator(
        name = "booking_order_sequence",
        sequenceName = "booking_order_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "booking_order_sequence"
    )
    private long id;
    
    //TODO
    //Learn foreign keys and continue... 

    private String shopId;
    private String studentRegNo;
    private LocalDate placedAt;
    private LocalDate startTime;
    private LocalDate endTime;


    public BookingOrder() {
    }

    public BookingOrder( String shopId, String studentRegNo, LocalDate placedAt, LocalDate startTime, LocalDate endTime) {
        this.shopId = shopId;
        this.studentRegNo = studentRegNo;
        this.placedAt = placedAt;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    public long getId() {
        return this.id;
    }

    public String getShopId() {
        return this.shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getStudentRegNo() {
        return this.studentRegNo;
    }

    public void setStudentRegNo(String studentRegNo) {
        this.studentRegNo = studentRegNo;
    }

    public LocalDate getPlacedAt() {
        return this.placedAt;
    }

    public void setPlacedAt(LocalDate placedAt) {
        this.placedAt = placedAt;
    }

    public LocalDate getStartTime() {
        return this.startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return this.endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }


}