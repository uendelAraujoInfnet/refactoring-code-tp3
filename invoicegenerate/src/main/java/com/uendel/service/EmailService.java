package com.uendel.service;

public class EmailService {
  public static void sendEmail(String to, String message){
    System.out.println("Enviando e-mail para " + to + ": " + message);
  }
}
