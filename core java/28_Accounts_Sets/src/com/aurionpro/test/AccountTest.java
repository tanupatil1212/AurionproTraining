package com.aurionpro.test;
import com.aurionpro.com.*;
import java.util.HashSet;
import java.util.Set;


public class AccountTest {

 public static void main(String[] args) {
  
   Accounts acc1 = new Accounts(1, "Ram");
   Accounts acc2 = new Accounts(2, "Sita");
   Accounts acc3 = new Accounts(1, "LAxman");
   
   Set<Accounts> account  = new HashSet<>();
   account.add(acc1);
   account.add(acc2);
   account.add(acc3);
   
   System.out.println(account);
 }

}