package Year2023.Maman12.ExBNumbers.Numbers;

public interface Number<T extends Number> {

    public boolean greaterThan(T other);

    public boolean equals(T other);

    public T plus(T other);

    public T minus(T other);

    public T multiply(T other);


    public T divide(T other);

    public int compareTo(T other);

    public String toString();

    public T reduce();


}