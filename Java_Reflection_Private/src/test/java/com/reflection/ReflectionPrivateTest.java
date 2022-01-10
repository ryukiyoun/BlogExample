package com.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReflectionPrivateTest {
    @Test
    public void getPrivateConstructsTest() throws Exception {
        Class<?> couponClass = Class.forName("com.reflection.Coupon");
        Constructor<?>[] couponConstruct = couponClass.getDeclaredConstructors();

        assertThat(couponConstruct.length, is(2));

        Constructor<?>[] couponConstruct2 = Coupon.class.getDeclaredConstructors();

        assertThat(couponConstruct2.length, is(2));
    }

    @Test
    public void getPrivateConstructTest() throws Exception {
        Class<?> couponClass = Class.forName("com.reflection.Coupon");
        Constructor<?> couponConstruct = couponClass.getDeclaredConstructor(String.class);
        couponConstruct.setAccessible(true);
        Coupon couponObj = (Coupon)couponConstruct.newInstance("emptyCoupon");

        assertThat(couponObj.getName(), is("emptyCoupon"));

        Constructor<?> couponClassConstruct = Coupon.class.getDeclaredConstructor(String.class);
        couponClassConstruct.setAccessible(true);
        Coupon couponClassObj = (Coupon)couponClassConstruct.newInstance("emptyCouponClass");

        assertThat(couponClassObj.getName(), is("emptyCouponClass"));
    }

    @Test(expected = IllegalAccessException.class)
    public void getPrivateConstructAccessExceptionTest() throws Exception{
            Class<?> couponClass = Class.forName("com.reflection.Coupon");
            Constructor<?> couponConstruct = couponClass.getDeclaredConstructor(String.class);
            Coupon couponObj = (Coupon) couponConstruct.newInstance("emptyCoupon");
    }

    @Test
    public void getPrivateMethodsTest() throws Exception {
        Class<?> couponClass = Class.forName("com.reflection.Coupon");
        Method[] couponMethod = couponClass.getDeclaredMethods();

        assertThat(couponMethod.length, is(8));

        Method[] couponMethod2 = Coupon.class.getDeclaredMethods();

        assertThat(couponMethod2.length, is(8));
    }

    @Test
    public void getPrivateMethodTest() throws Exception {
        Class<?> couponClass = Class.forName("com.reflection.Coupon");
        Method couponMethod = couponClass
                .getDeclaredMethod("changeCoupon", String.class, double.class, int.class);
        couponMethod.setAccessible(true);

        Coupon couponObj = (Coupon)couponClass
                .getConstructor(String.class, double.class, int.class, LocalDate.class, LocalDate.class)
                .newInstance("Time_Sale", 10, 10000, LocalDate.now(), LocalDate.now().plusDays(7));

        couponMethod.invoke(couponObj, "changeCoupon", 50, 100);

        assertThat(couponMethod.getName(), is("changeCoupon"));
        assertThat(couponObj.getName(), is("changeCoupon"));
        assertThat(couponObj.getDiscount(), is(50.0));
        assertThat(couponObj.getMinPrice(), is(100));

        Method couponMethod2 = couponClass
                .getDeclaredMethod("changeCoupon", String.class, double.class, int.class);
        couponMethod2.setAccessible(true);

        Coupon couponObj2 = (Coupon)couponClass
                .getConstructor(String.class, double.class, int.class, LocalDate.class, LocalDate.class)
                .newInstance("Time_Sale", 10, 10000, LocalDate.now(), LocalDate.now().plusDays(7));

        couponMethod.invoke(couponObj2, "changeCoupon", 50, 100);

        assertThat(couponMethod2.getName(), is("changeCoupon"));
        assertThat(couponObj2.getName(), is("changeCoupon"));
        assertThat(couponObj2.getDiscount(), is(50.0));
        assertThat(couponObj2.getMinPrice(), is(100));
    }

    @Test(expected = IllegalAccessException.class)
    public void getPrivateMethodAccessExcepionTest() throws Exception {
        Class<?> couponClass = Class.forName("com.reflection.Coupon");
        Method couponMethod = couponClass
                .getDeclaredMethod("changeCoupon", String.class, double.class, int.class);

        Coupon couponObj = (Coupon)couponClass
                .getConstructor(String.class, double.class, int.class, LocalDate.class, LocalDate.class)
                .newInstance("Time_Sale", 10, 10000, LocalDate.now(), LocalDate.now().plusDays(7));

        couponMethod.invoke(couponObj, "changeCoupon", 50, 100);
    }

    @Test
    public void getPrivateFieldsTest() throws Exception {
        Class<?> couponClass = Class.forName("com.reflection.Coupon");

        Field[] field = couponClass.getDeclaredFields();

        assertThat(field.length, is(5));
    }

    @Test
    public void getPrivateFieldTest() throws Exception {
        Class<?> couponClass = Class.forName("com.reflection.Coupon");

        Object couponObj = couponClass
                .getConstructor(String.class, double.class, int.class, LocalDate.class, LocalDate.class)
                .newInstance("Time_Sale", 10, 10000, LocalDate.now(), LocalDate.now().plusDays(7));

        Field field = couponClass.getDeclaredField("discount");
        field.setAccessible(true);

        double privateDiscount = (double)field.get(couponObj);

        assertThat(privateDiscount, is(10.0));

        Field field2 = Coupon.class.getDeclaredField("discount");
        field2.setAccessible(true);

        double privateDiscount2 = (double)field2.get(couponObj);

        assertThat(privateDiscount2, is(10.0));
    }

    @Test(expected = IllegalAccessException.class)
    public void getPrivateFieldAccessExceptionTest() throws Exception {
        Class<?> couponClass = Class.forName("com.reflection.Coupon");

        Object couponObj = couponClass
                .getConstructor(String.class, double.class, int.class, LocalDate.class, LocalDate.class)
                .newInstance("Time_Sale", 10, 10000, LocalDate.now(), LocalDate.now().plusDays(7));

        Field field = couponClass.getDeclaredField("discount");

        double privateDiscount = (double)field.get(couponObj);
    }
}
