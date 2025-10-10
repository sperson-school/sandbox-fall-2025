package org.example.sandbox.comparable;

public class Fruit implements Comparable<Fruit> {
    private String name;
    private String color;
    private double weight;
    private double price;
    private int quantity;

    // Private constructor for builder
    private Fruit(Builder builder) {
        this.name = builder.name;
        this.color = builder.color;
        this.weight = builder.weight;
        this.price = builder.price;
        this.quantity = builder.quantity;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private String color;
        private double weight;
        private double price;
        private int quantity;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder weight(double weight) {
            this.weight = weight;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Fruit build() {
            return new Fruit(this);
        }
    }

    public Fruit(String name, String color, double weight, double price, int quantity) {
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.price = price;
        this.quantity = quantity;

    }

    public Fruit() {
        this.name = "Apple";
        this.color = "Red";
        this.weight = 1.0;
        this.price = 1.0;
        this.quantity = 1;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public int compareTo(Fruit that) {
        return this.name.compareTo(that.name);
    }
}
