
public interface Fraction {
    void setNum(double d);
    void setDem(double d);
    double getNum();
    double getDem();
    Fraction add(Fraction f);
    Fraction subtract(Fraction f);
    Fraction multiply(Fraction f);
    Fraction divide(Fraction f);
    Fraction reciprocal();
    boolean equals(Fraction f);
    String toString();
    void simplify();
}
