package calcu.model;


import java.util.ArrayList;

public class Integrals {

    public long upperBound;
    public long lowerBound;
    public long polynomialsDegree;
    public ArrayList<Integer> factors = new ArrayList<>();

    public Integrals(long upperBound, long lowerBound, long polynomialsDegree){
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
        this.polynomialsDegree = polynomialsDegree;

    }


}
