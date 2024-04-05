package GeneratePrimesV5;

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
    private static boolean  isCrossed[];
    private static int[] result;
    private static int len;
    public static int [] generatePrimes(int maxValue){
        if(maxValue<2) return new int[0];
        initializeArrayOfIntegers(maxValue);
        crossOutMultiples();
        putUncrossedIntegersIntoResult();
        return result;
    }
    public static void initializeArrayOfIntegers(int maxValue){
        isCrossed= new boolean[maxValue+1];
        Arrays.fill(isCrossed , false);
        //false means it's a prime //true means is not a prime
    }

    public static void crossOutMultiples(){
        //seive//make sure you start from i=2 cuz you didn't do arr[0] && arr[1] to be false.
        double maxPrimeFactor=calcMaxPrimeFactor();
        for(int i=2; i<=maxPrimeFactor ; i++){
            if(notCrossed(i)){
                crossOutMultiplesOf(i);
            }
        }
    }
    public static int calcMaxPrimeFactor(){
        return (int) (Math.sqrt(isCrossed.length)+1);
    }
    public static void crossOutMultiplesOf(int i){
        for(int multiple=i*2; multiple<isCrossed.length; multiple+=i)
            isCrossed[multiple]=true;
    }
    public static boolean notCrossed(int i){
        return isCrossed[i]==false;
    }
    public static void putUncrossedIntegersIntoResult(){
        //must start with 2
        result = new int[numberOfUncrossedIntegers()];
        for(int i=2 , j=0; i<isCrossed.length; i++){
            if(isCrossed[i]==false) result[j++]=i;
        }
    }
    public static int numberOfUncrossedIntegers(){
        //how many prime numbers are out there in our isCrosseday?
        int numOfPrimes=0;
        //must start with 2 cuz you didn't do arr[0] and arr[1]
        for(int i=2; i<isCrossed.length ; i++){
            if(isCrossed[i]==false) numOfPrimes++;
        }
        return numOfPrimes;
    }
}
