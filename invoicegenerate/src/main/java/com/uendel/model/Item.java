package com.uendel.model;

public class Item {

  private final String name;
  private final double price;
  private final int quantity;

  public Item(String name, double price, int quantity) {
    if(price < 0 || quantity <= 0){
      throw new IllegalArgumentException("Price and Quantity can't be negative or zero");
    }

    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public String getName(){
    return name;
  }

  public double getSubtotal() {
    return price * quantity;
  }

  public String getLineDescription(){
    return quantity + " x " + name + " - R$ " + price;
  }

}
