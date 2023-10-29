package com.aurionpro.com;
import java.util.Set;

public class Accounts {

 private int Id;
 private String name;

 public Accounts(int id, String name) {
  super();
  Id = id;
  this.name = name;
 }

 public int getId() {
  return Id;
 }

 public void setId(int id) {
  Id = id;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 @Override
 public String toString() {
  return "Account [Id=" + Id + ", name=" + name + "]";
 }

 @Override
 public int hashCode() {
  final int prime = 31;
  int result = 1;
  result = prime * result + Id;
  return result;
 }

 @Override
 public boolean equals(Object obj) {
  if (this == obj)
   return true;
  if (obj == null)
   return false;
  if (getClass() != obj.getClass())
   return false;
  Accounts other = (Accounts) obj;
  if (Id != other.Id)
   return false;
  return true;
 }
 
 
 
 

 
}