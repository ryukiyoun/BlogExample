package com.jpa.enumable;

public enum ProductType {
    BOOK("BK", "B001"), CD("CD", "C001"), PC("PC", "P001");

    private final String value;
    private final String MCode;

    ProductType(String value, String mCode){
        this.value = value;
        this.MCode = mCode;
    }

    public String getValue(){
        return this.value;
    }

    public String getCode(){
        return this.MCode;
    }
}
