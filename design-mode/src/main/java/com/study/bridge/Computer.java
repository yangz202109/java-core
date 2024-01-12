package com.study.bridge;

/**
 * 抽象的电脑类
 */
public abstract class Computer {
    //自带品牌
    protected Brand brand;

    public Computer(Brand brand) {
        this.brand = brand;
    }

    public void info() {
        brand.info();
    }
}

//台式类
class Destktop extends Computer {

    public Destktop(Brand brand) {
        super(brand);
    }

    @Override
    public void info() {
        super.info();
    }
}

//平板类
class Laptop extends Computer {
    public Laptop(Brand brand) {
        super(brand);
    }

    @Override
    public void info() {
        super.info();
    }
}
