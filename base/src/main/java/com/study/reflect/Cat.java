package com.study.reflect;

/**
 * @create 2021-11-16-17:31
 */
class Cat{
     private int id;
     public String brand;
     private static double price;

    public Cat() {
    }

    public Cat(int id, String brand) {
        this.id = id;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public static double getPrice() {
        return price;
    }

    public static void setPrice(double price) {
        Cat.price = price;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", brand='" + brand +
                ", price='" + price + '\'' +
                '}';
    }

    public void sell(double prices){
         System.out.println("卖"+prices+"车");
     }
     private void vip(){
         System.out.println("提供VIP服务");
     }

}

