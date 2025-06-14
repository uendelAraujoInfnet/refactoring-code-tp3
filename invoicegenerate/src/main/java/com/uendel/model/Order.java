package com.uendel.model;

import java.util.ArrayList;
import java.util.List;

import com.uendel.service.EmailService;

public class Order {

  private final Client client;
  private final List<Item> items = new ArrayList<>();
  private final double discountRace = 0.1;

  public Order(Client client) {
    this.client = client;
  }

  public void addItem(Item item){
    items.add(item);
  }

  public double getSubtotal() {
    return items.stream().mapToDouble(Item::getSubtotal).sum();
  }

  public double getDiscount(){
    return DiscountPolicy.calculateDiscount(getSubtotal(), discountRace);
  }

  public double getTotal(){
    return getSubtotal() - getDiscount();
  }

  public void printInvoice(){
    System.out.println("Cliente: " + client.getName());
    items.forEach(item -> System.out.println(item.getLineDescription()));
    System.out.printf("Subtotal: R$%.2f%n", getSubtotal());
    System.out.printf("Desconto: R$%.2f%n", getDiscount());
    System.out.printf("Total final: R$%.2f%n", getTotal());
  }

  public void confirmOrder(){
    String message = String.format("Olá %s, o seu pedido foi recebido! Total: R$%.2f . Obrigado pela compra.", client.getName(), getTotal());
    
    EmailService.sendEmail(client.getEmail(), message);
  }
}
