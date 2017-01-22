
/** 
 * The Interface for a Fraction 
 *
 * This interface defines a fraction consisting of a numerator and denominator. 
 *
 * @author Ross Capdeville
 * @version Jan 21, 2017
 *
 */

public interface Fraction {

  // Query Operations

  /** 
   * Sets the Numerator 
   *
   * @param d a double representation of the numerator
   */
  void setNum(double d);

  /** 
   * Sets the Denominator
   *
   * @param d a double representation of the denominator
   */
  void setDem(double d);

  /**
   * Returns the Numerator
   *
   * @return the numerator of the Fraction
   */
  double getNum();

  /**
   * Returns the Denominator
   *
   * @return the denominator of the Fraction
   */
  double getDem();

  // Calculation Operations 

  /**
   * Adds the argument to itself
   *
   * @param f a Fraction to be used in the calculation
   * @return the sum of itself and the argument
   */
  Fraction add(Fraction f);

  /**
   * Subtracts the argument from itself
   *
   * @param f a Fraction to be used in the calculation
   * @return the difference of itself and the argument
   */
  Fraction subtract(Fraction f);

  /**
   * Multiplies the argument to itself
   *
   * @param f a Fraction to be used in the calculation
   * @return the product of itself and the argument
   */
  Fraction multiply(Fraction f);

  /**
   * Divides the itself by the argument 
   *
   * @param f a Fraction to be used in the calculation
   * @return the quotient of itself and the argument
   */
  Fraction divide(Fraction f);

  // Utility Operations

  /**
   * Provides the reciprocal of itself
   *
   * @return the reciprocal of itself 
   */
  Fraction reciprocal();

  /**
   * Determines if two fractions are equal by comparing their
   * simplified / reduced forms. 
   *
   * @param f a Fraction to be used in the calculation
   * @return the reciprocal of itself 
   */
  boolean equals(Fraction f);

  /**
   * Returns a string representation of the fraction
   *
   * @return a string representation of the fraction
   */
  String toString();

  /**
   * Reduces the underlying representation of itself to the Least Common Denominator
   */
  void simplify();
}
