/* ===========================================================================
   $File: $
   $Date: $
   $Revision: $
   $Creator: Ross Capdeville $
   $Notice: (C) Copyright 2017 by Ross Capdeville. All Rights Reserved. $
   =========================================================================== */

package alice;

import java.io.BufferedReader; 
import java.io.FileReader; 
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.HashMap;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;


public class AskAlice {
   public static void main(String[] args) 
   {
      HashMap<String, Integer> wordcount = new HashMap<String, Integer>();
      FileInputStream inputStream = null;
      Scanner sc = null;
      try
      {
         inputStream = new FileInputStream("/Users/ross/work/cs110c_ccsf/src/alice/alice-parsed.txt");
      }
         catch (FileNotFoundException e)

         {
            System.out.println ("File not found");
         }
      sc = new Scanner(inputStream, "UTF-8");
      while (sc.hasNextLine())
      {
         String line = sc.nextLine();
         String[] sline = line.split(" ");
         for (String word : sline) 
         {
            if (wordcount.containsKey(word))
            { 
               wordcount.put(word, wordcount.get(word) + 1);
            }
            else
            { 
               wordcount.put(word, 1);
            } 
         }
      }
      System.out.println("Alice: " + wordcount.get("Alice"));
      System.out.println("Rabbit: " + wordcount.get("Rabbit"));
      System.out.println("Cheshire: " + wordcount.get("Cheshire"));
      System.out.println("Mad: " + wordcount.get("Mad"));
      System.out.println("Hatter: " + wordcount.get("Hatter"));

      ArrayList<Integer> values = new ArrayList<Integer>();
      values.addAll(wordcount.values());
      Collections.sort(values, Collections.reverseOrder());

      int max_value = values.get(0);
      String max_key = getKeyFromValue(max_value, wordcount);
  
      System.out.print("'" + max_key  + "' occurs most often ");
      System.out.println("(" + max_value + " times).");

   }
   
   private static String getKeyFromValue(Integer value, HashMap<String,Integer> h)
   {
      for(String key : h.keySet()){
        if(h.get(key).equals(value)){
           return key; 
        }
      }
      return null;
   }
}
