package com.study.builder.demo01;

/**
 * 产品 (房子)
 */
public class Product {
    private String procedure1;
    private String procedure2;
    private String procedure3;

    public String getProcedure1() {
        return procedure1;
    }

    public void setProcedure1(String procedure1) {
        this.procedure1 = procedure1;
    }

    public String getProcedure2() {
        return procedure2;
    }

    public void setProcedure2(String procedure2) {
        this.procedure2 = procedure2;
    }

    public String getProcedure3() {
        return procedure3;
    }

    public void setProcedure3(String procedure3) {
        this.procedure3 = procedure3;
    }

    @Override
    public String toString() {
        return "Product{" +
                "procedure1='" + procedure1 + '\'' +
                ", procedure2='" + procedure2 + '\'' +
                ", procedure3='" + procedure3 + '\'' +
                '}';
    }
}
