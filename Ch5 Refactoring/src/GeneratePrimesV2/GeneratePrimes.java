package GeneratePrimesV2;

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
    private static int[] primes;
    private static int len;
    public static int [] generatePrimes(int maxValue){
        if(maxValue<2) return new int[0];
        initializeSeive(maxValue);
        seive();
        loadPrimes();
        return primes;
    }
    public static void initializeSeive(int maxValue){
        len=maxValue+1;
        arr= new boolean[len];

        Arrays.fill(arr , true);
        arr[0]=false;
        arr[1]=false;
        //true means it's a prime //false means is not a prime
    }

    public static void seive(){
        //seive
        for(int i=0; i*i<len ; i++){
            if(arr[i]){
                for(int j=i*2; j<len; j+=i)
                    arr[j]=false;
            }
        }
    }
    public static void loadPrimes(){
        //how many prime numbers are out there in our array?
        int numOfPrimes=0;
        for(int i=0; i<len ; i++){
            if(arr[i]) numOfPrimes++;
        }
        primes = new int[numOfPrimes];
        for(int i=0 , j=0; i<len; i++){
            if(arr[i]) primes[j++]=i;
        }
    }

}
