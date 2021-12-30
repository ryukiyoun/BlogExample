package com.reflection;

import org.junit.Test;

import java.lang.reflect.Method;
import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ReflectionInvokeTest {

    @Test
    public void NormalRunMethodTest() {
        Coupon coupon = new Coupon("First_Sale", 10, 10000, LocalDate.now(), LocalDate.now().plusDays(7));

        coupon.addCouponDate(10);

        assertThat(coupon.getName(), is("First_Sale"));
        assertThat(coupon.getDiscount(), is(10.0));
        assertThat(coupon.getMinPrice(), is(10000));
        assertThat(coupon.getStartDate(), is(LocalDate.now().plusDays(10)));
        assertThat(coupon.getEndDate(), is(LocalDate.now().plusDays(7).plusDays(10)));

        assertThat(coupon.getDiscountAmount(30000), is(3000));
    }

    @Test
    public void ReflectionRunMethodTest() throws Exception{
        Class<?> couponClass = Class.forName("com.reflection.Coupon");

        Method getDiscountMethod = couponClass.getMethod("getDiscountAmount", int.class);

        Object couponObj = couponClass
                .getConstructor(String.class, double.class, int.class, LocalDate.class, LocalDate.class)
                .newInstance("Time_Sale", 10, 10000, LocalDate.now(), LocalDate.now().plusDays(7));

        int amount = (int)getDiscountMethod.invoke(couponObj, 30000);

        assertThat(amount, is(3000));
    }

    @Test
    public void CompareRunMethodTest() throws Exception{
        Coupon coupon = new Coupon("First_Sale", 10, 10000, LocalDate.now(), LocalDate.now().plusDays(7));

        coupon.addCouponDate(10);

        assertThat(coupon.getName(), is("First_Sale"));
        assertThat(coupon.getDiscount(), is(10.0));
        assertThat(coupon.getMinPrice(), is(10000));
        assertThat(coupon.getStartDate(), is(LocalDate.now().plusDays(10)));
        assertThat(coupon.getEndDate(), is(LocalDate.now().plusDays(7).plusDays(10)));

        Class<?> couponClass = Class.forName("com.reflection.Coupon");

        Method getDiscountMethod = couponClass.getMethod("getDiscountAmount", int.class);

        Object couponObj = couponClass
                .getConstructor(String.class, double.class, int.class, LocalDate.class, LocalDate.class)
                .newInstance("Time_Sale", 10, 10000, LocalDate.now(), LocalDate.now().plusDays(7));

        int amount = (int)getDiscountMethod.invoke(couponObj, 30000);

        assertThat(amount, is(coupon.getDiscountAmount(30000)));
        assertThat(coupon.getDiscountAmount(30000), is(amount));
    }
}
