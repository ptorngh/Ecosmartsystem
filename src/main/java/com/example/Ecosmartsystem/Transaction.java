package com.example.Ecosmartsystem;

public class Transaction {

 private int id;
 private int categoryid;
 private int amount;
 private int date;

 public Transaction() {
 }

 public Transaction(int id, int categoryid, int amount, int date) {
  this.id =  id;
  this.categoryid = categoryid;
  this.amount = amount;
  this.date = date;
 }

  public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public int getCategoryid() {
  return categoryid;
 }

 public void setCategoryid(int categoryid) {
  this.categoryid = categoryid;
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