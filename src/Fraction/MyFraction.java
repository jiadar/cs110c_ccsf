/*
 * Ross Capdeville
 * Jan 21, 2017
 *
 * Implements the Fraction Interface
 *
 */

import java.util.logging.*;

/** MyFraction implements the Fraction interface */

public class MyFraction implements Fraction {

   // Use this to get some logging as necessary in the unit test output
   private static final Logger lmsg = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

   // Prof. said to use double instead of int during class
   private double num;
   private double dem;

   // Instantiate a new fraction with a numerator and denominator 
   public MyFraction(double num, double dem) {
      this.num=num;
      this.dem=dem;
   }

   public void setNum(double num) {
      this.num=num;
   }

   public void setDem(double dem) {
      this.dem=dem;
   }

   public double getNum() {
      return num;
   }

   public double getDem() {
      return dem; 
   }    

   public String toString() {
      return(num + "/" + dem);
   }

   public Fraction add(Fraction f) {
      MyFraction result=new MyFraction(0,0);
      int mylcm=lcm((int)this.getDem(), (int)f.getDem());
      result.setDem(mylcm);
      result.setNum(this.getNum()*mylcm/this.getDem() + f.getNum()*mylcm/f.getDem());
      result.simplify();
      return result;
   }

   public Fraction subtract(Fraction f) {
      MyFraction result=new MyFraction(0,0);
      int mylcm=lcm((int)this.getDem(), (int)f.getDem());
      result.setDem(mylcm); 
      result.setNum(this.getNum()*mylcm/this.getDem() - f.getNum()*mylcm/f.getDem());
      result.simplify();
      return result;
   }

   public Fraction multiply(Fraction f) {
      MyFraction result=new MyFraction(0,0);
      result.setNum(this.getNum()*f.getNum());
      result.setDem(this.getDem()*f.getDem());
      result.simplify();
      return result;
   }

   public Fraction divide(Fraction f) {
      MyFraction result=new MyFraction(0,0);
      result.setNum(this.getNum()*f.getDem());
      result.setDem(this.getDem()*f.getNum());
      result.simplify();
      return result;
   }

   public Fraction reciprocal() {
      MyFraction result=new MyFraction(0,0);
      double tmp = this.getNum();
      result.setNum(this.getDem());
      result.setDem(tmp);
      return result;
   }

   /** 
    * Simplify a copy of myself and the argument, and compare them for
    * equality
    */
   public boolean equals(Fraction f) {
      MyFraction f1=new MyFraction(this.getNum(),this.getDem());
      MyFraction f2=new MyFraction(f.getNum(), f.getDem());
      f1.simplify();
      f2.simplify();
      return f1.getNum()==f2.getNum() && f1.getDem() == f2.getDem() ? true : false;
   }

   public void simplify() {
      int n = (int)num;
      int d = (int)dem;
      if (n<0 && d<0) {
         n*=-1;
         d*=-1;
      }
      int mygcd=gcd(n,d);
      num=(double)n/mygcd;
      dem=(double)d/mygcd;
   }

   private static int lcm(int a, int b) {
      return Math.abs(a*b)/gcd(a,b);
   }

   private static int gcd(int a, int b) {
      while (b != 0) {
         int mod = a % b;
         a = b;
         b = mod;
      }
      return a;
   }
}
