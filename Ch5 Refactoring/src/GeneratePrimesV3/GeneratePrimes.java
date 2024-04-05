package GeneratePrimesV3;

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
    private static boolean  arr[];
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
        arr= new boolean[maxValue+1];

        Arrays.fill(arr , true);
        arr[0]=false;
        arr[1]=false;
        //true means it's a prime //false means is not a prime
    }

    public static void crossOutMultiples(){
        //seive
        for(int i=0; i*i<arr.length ; i++){
            if(arr[i]){
                for(int j=i*2; j<arr.length; j+=i)
                    arr[j]=false;
            }
        }
    }
    public static void putUncrossedIntegersIntoResult(){
        //how many prime numbers are out there in our array?
        int numOfPrimes=0;
        for(int i=0; i<arr.length ; i++){
            if(arr[i]) numOfPrimes++;
        }
        result = new int[numOfPrimes];
        for(int i=0 , j=0; i<arr.length; i++){
            if(arr[i]) result[j++]=i;
        }
    }

}
