package com.reflection;

import java.time.LocalDate;

public class Coupon {
    private String name;
    private double discount;
    private int minPrice;
    private LocalDate startDate;
    private LocalDate endDate;

    private Coupon(String name) {
        this.name = name;
    }

    public Coupon(String name, double discount, int minPrice, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.discount = discount;
        this.minPrice = minPrice;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    private void changeCoupon(String name, double discount, int minPrice){
        this.name = name;
        this.discount = discount;
        this.minPrice = minPrice;
    }

    public void addCouponDate(int day) {
        startDate = startDate.plusDays(day);
        endDate = endDate.plusDays(day);
    }

    public int getDiscountAmount(int productPrice) {
        return (int)(productPrice * (discount / 100));
    }

    public String getName() {
        return name;
    }

    public double getDiscount() {
        return discount;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
