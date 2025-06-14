package com.uendel.controller;

import com.uendel.model.Client;
import com.uendel.model.Item;
import com.uendel.model.Order;

public class OrderController {
   public void criarPedidoDeTeste() {
        Client client = new Client("João", "joao@email.com");
        Order order = new Order(client);
        order.addItem(new Item("Notebook", 3500.0, 1));
        order.addItem(new Item("Mouse", 80.0, 2));

        order.printInvoice();
        order.confirmOrder();
    }
}
