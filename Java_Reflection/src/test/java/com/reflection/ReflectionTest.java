package com.reflection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ReflectionTest {

    @Test
    public void NormalObjectTest() {
        Coupon coupon = new Coupon("First_Sale", 10, 10000, LocalDate.now(), LocalDate.now().plusDays(7));

        coupon.addCouponDate(10);

        assertThat(coupon.getName(), is("First_Sale"));
        assertThat(coupon.getDiscount(), is(10.0));
        assertThat(coupon.getMinPrice(), is(10000));
        assertThat(coupon.getStartDate(), is(LocalDate.now().plusDays(10)));
        assertThat(coupon.getEndDate(), is(LocalDate.now().plusDays(7).plusDays(10)));

        assertThat(coupon.getDiscountAmount(30000), is(3000));
    }

    @Test(expected = ClassNotFoundException.class)
    public void NonPackageReflectionClassNotFoundTest() throws Exception{
        Class<?> couponClass = Class.forName("Coupon");
    }

    @Test
    public void PackageReflectionClassTest() throws Exception{
        Class<?> couponClass = Class.forName("com.reflection.Coupon");
        Class<?> couponClass2 = Coupon.class;

        assertThat(couponClass.getName(), is("com.reflection.Coupon"));
        assertThat(couponClass2.getName(), is(couponClass.getName()));
    }

    @Test
    public void PublicGetFieldsTest() throws Exception{
        Class<?> couponClass = Class.forName("com.reflection.Coupon");
        Field[] fields = couponClass.getFields();

        assertThat(fields.length, is(1));

        Field[] fields2 = Coupon.class.getFields();

        assertThat(fields2.length, is(1));
    }

    @Test
    public void PublicGetFieldTest() throws Exception{
        Class<?> couponClass = Class.forName("com.reflection.Coupon");
        Field field = couponClass.getField("name");

        assertThat(field.getName(), is("name"));

        Field field2 = Coupon.class.getField("name");

        assertThat(field2.getName(), is("name"));
    }

    @Test(expected = NoSuchFieldException.class)
    public void PrivateGetFieldTest() throws Exception{
        Class<?> couponClass = Class.forName("com.reflection.Coupon");
        Field field = couponClass.getField("discount");
    }

    @Test
    public void PublicGetMethodsTest() throws Exception{
        Class<?> couponClass = Class.forName("com.reflection.Coupon");
        Method[] methods = couponClass.getMethods();

        assertThat(methods.length, is(16));

        Method[] methods2 = Coupon.class.getMethods();

        assertThat(methods2.length, is(16));
    }

    @Test
    public void PublicGetMethodTest() throws Exception{
        Class<?> couponClass = Class.forName("com.reflection.Coupon");
        Method method = couponClass.getMethod("getDiscountAmount", int.class);

        assertThat(method.getName(), is("getDiscountAmount"));

        Method method2 = Coupon.class.getMethod("getDiscountAmount", int.class);

        assertThat(method2.getName(), is("getDiscountAmount"));
    }

    @Test(expected = NoSuchMethodException.class)
    public void NonDefineGetMethodTest() throws Exception{
        Class<?> couponClass = Class.forName("com.reflection.Coupon");
        Method method = couponClass.getMethod("testMethod");
    }
}
