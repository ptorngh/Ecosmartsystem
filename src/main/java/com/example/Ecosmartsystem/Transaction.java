package com.example.Ecosmartsystem;

public class Transaction {

 private int id;
// private Category category;
 private String category;
 private int amount;
 private int date;

 public Transaction() {

 }

 public Transaction(int id, String category, int amount, int date) {
  this.id =  id;
  this.category = category;
  this.amount = amount;
  this.date = date;
 }

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public String getCategory() {
  return category;
 }

 public void setCategory(String category) {
  this.category = category;
 }

 public int getAmount() {
  return amount;
 }

 public void setAmount(int amount) {
  this.amount = amount;
 }

 public int getDate() {
  return date;
 }

 public void setDate(int date) {
  this.date = date;
 }
}

