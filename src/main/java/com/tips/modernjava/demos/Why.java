package com.tips.modernjava.demos;

import java.util.Arrays;
import java.util.Comparator;


public class Why {

    public static void main(String[] args) {


        class Product {
            private String name;
            private int price;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public Product(String name, int price) {
                this.name = name;
                this.price = price;
            }

            @Override
            public String toString() {
                return "whylambda.Product{" +
                        "name='" + name + '\'' +
                        ", price=" + price +
                        '}';
            }
        }

        Product p1 = new Product("samsung", 250000);
        Product p2 = new Product("itel", 78000);
        Product p3 = new Product("xaomi", 120000);

        Product[] productArray = {p1, p2, p3};


        Arrays.sort(productArray, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });


        // with lambda expression
        Arrays.sort(productArray, (o1, o2) -> o1.getPrice() - o2.getPrice());


        System.out.printf("Sorted products : %s",
                Arrays.toString(productArray));

    }
}
