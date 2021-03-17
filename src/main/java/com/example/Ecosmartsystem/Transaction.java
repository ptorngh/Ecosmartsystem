package com.example.Ecosmartsystem;

public class Transaction {

 private Category category;
 private int amount;
 private int date;

 public Transaction() {

 }

 public Transaction(Category category, int amount, int date) {
  this.category = category;
  this.amount = amount;
  this.date = date;
 }

 public Category getCategory() {
  return category;
 }

 public void setCategory(Category category) {
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

