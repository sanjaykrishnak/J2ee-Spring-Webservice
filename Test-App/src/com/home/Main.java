package com.home;

import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String s;
    while ((s = in.readLine()) != null)
    {
      System.out.println(s);
    }
    
    
    Integer noOfDays = Integer.parseInt(args[0]);
    
    int[] number = new int[(args.length-1)];
    
    for(int i = 1;i<args.length;i++)
    {
        number[i-1]=Integer.parseInt(args[i]);
        
    }
    
    // NOw the number array has all the  positive and negative integers
    
    int output = calculateLossAndGain(4,8,number);
    
    if(output > 0)
        System.out.println("Gain" + output);
    else
      System.out.println("0");  
    
    
  }
  
  public static  int calculateLossAndGain(int startDay, int endDay, int[] gainAndLoss)
  {
      int pl = 0;
      for(int i =startDay; i<=endDay; i++)
      {
          pl +=gainAndLoss[i]; 
          
      }
      
      return pl;
      
      
  }
  
}