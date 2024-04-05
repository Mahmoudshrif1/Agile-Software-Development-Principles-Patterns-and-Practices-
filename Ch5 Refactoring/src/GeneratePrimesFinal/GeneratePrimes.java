package GeneratePrimesFinal;

import java.util.Arrays;

/**
 * This class generates prime numbers up to a user-specified
 * maximum. The algorithm used is the Sieve of Eratosthenes.
 * The algorithm is quite simple. Given an array of integers
 * starting at 2. Cross out all multiples of 2. Find the next
 * uncrossed integer, and cross out all of its multiples.
 * Repeat until you have passed the square root of the maximum
 * value.
 *
 * @author Mahmoud Shrif
 * @version 28 March 2024
 */
public class GeneratePrimes {
    private static boolean  crossedOut[];
    private static int[] result;
    private static int len;
    public static int [] generatePrimes(int maxValue){
        if(maxValue<2) return new int[0];
        uncrossIntegersUpTo(maxValue);
        crossOutMultiples();
        putUncrossedIntegersIntoResult();
        return result;
    }
    public static void uncrossIntegersUpTo(int maxValue){
        crossedOut= new boolean[maxValue+1];
        Arrays.fill(crossedOut , false);
        //false means it's a prime //true means is not a prime
    }

    public static void crossOutMultiples(){
        //seive//make sure you start from i=2 cuz you didn't do arr[0] && arr[1] to be false.
        double limit=determineIterationLimit();
        for(int i=2; i<=limit ; i++){
            if(notCrossed(i)){
                crossOutMultiplesOf(i);
            }
        }
    }
    public static int determineIterationLimit(){
        return (int) (Math.sqrt(crossedOut.length));
    }
    public static void crossOutMultiplesOf(int i){
        for(int multiple=i*2; multiple<crossedOut.length; multiple+=i)
            crossedOut[multiple]=true;
    }
    public static boolean notCrossed(int i){
        return crossedOut[i]==false;
    }
    public static void putUncrossedIntegersIntoResult(){
        //must start with 2
        result = new int[numberOfUncrossedIntegers()];
        for(int i=2 , j=0; i<crossedOut.length; i++){
            if(crossedOut[i]==false) result[j++]=i;
        }
    }
    public static int numberOfUncrossedIntegers(){
        //how many prime numbers are out there in our array?
        int numOfPrimes=0;
        //must start with 2 cuz you didn't do arr[0] and arr[1]
        for(int i=2; i<crossedOut.length ; i++){
            if(notCrossed(i)) numOfPrimes++;
        }
        return numOfPrimes;
    }
}
