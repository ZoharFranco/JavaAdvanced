package Maman12.ExBNumbers.Numbers;

import java.util.Scanner;

public class Rational implements Comparable<Rational>, Number<Rational> {

    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;

        if (denominator == 0) throw new IllegalArgumentException("Denominator cannot be zero");
        this.denominator = denominator;

    }

    public boolean greaterThan(Rational other) {
        return this.numerator * other.denominator > this.denominator * other.numerator;
    }

    @Override
    public boolean equals(Rational other) {
        return this.numerator * other.denominator == this.denominator * other.numerator;
    }

    @Override
    public Rational plus(Rational other) {
        return new Rational((this.numerator * other.denominator + this.denominator * other.numerator),
                (this.denominator * other.denominator));
    }

    @Override
    public Rational minus(Rational other) {
        return new Rational((this.numerator * other.denominator - this.denominator * other.numerator),
                (this.denominator * other.denominator));
    }

    @Override
    public Rational multiply(Rational other) {
        return new Rational((this.numerator * other.numerator), (this.denominator * other.denominator));
    }

    @Override
    public Rational divide(Rational other) {
        if (other.numerator == 0) throw new ArithmeticException("Cannot divide by zero");
        return new Rational((this.numerator * other.denominator), (this.denominator * other.numerator));
    }

    @Override
    public int compareTo(Rational other) {
        return (this.numerator * other.denominator - this.denominator * other.numerator) / (this.denominator * other.denominator);
    }

    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    public Rational reduce() {


        int largestDivisor = largestDivisor(this.denominator, this.numerator);
        return new Rational(this.numerator / largestDivisor, this.denominator / largestDivisor);
    }

    private static int largestDivisor(int n1, int n2) {
        while (n1 != n2) {
            if (n1 > n2)
                n1 = n1 - n2;
            else
                n2 = n2 - n1;
        }
        return n2;
    }


    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }


    public static Rational createUserRational() {

        int numerator, denominator;
        Scanner scan = new Scanner(System.in);

        System.out.println("Creating rational number");

        System.out.print("Enter an integer for numerator: ");
        try {
            numerator = scan.nextInt();
        } catch (Exception e) {
            System.out.println("** You should input an integer for numerator **\n");
            return createUserRational();
        }

        System.out.print("Enter an integer for denominator: ");
        try {
            denominator = scan.nextInt();
        } catch (Exception e) {
            System.out.println("** You should input an integer for numerator **\n");
            return createUserRational();
        }

        try {
            return new Rational(numerator, denominator);
        } catch (IllegalArgumentException e) {
            System.out.printf("** %s **\n\n", e.getMessage());
            return createUserRational();
        }

    }

    public static void main(String[] args) {
        Rational r1 = createUserRational();
        Rational r2 = createUserRational();

        // Calculations
        System.out.printf("%s + %s = %s\n", r1, r2, r1.plus(r2));
        System.out.printf("%s - %s = %s\n", r1, r2, r1.minus(r2));
        System.out.printf("%s * %s = %s\n", r1, r2, r1.multiply(r2));
        System.out.printf("%s / %s = %s\n", r1, r2, r1.divide(r2));
        System.out.printf("%s == %s\n", r1, r1.reduce());


    }


}
