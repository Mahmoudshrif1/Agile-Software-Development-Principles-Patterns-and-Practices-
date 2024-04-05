package GeneratePrimesFinal;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestGeneratePrimes{

    public static void main(String [] args){
//        int[] arr1= GeneratePrimes.generatePrimes(2) ;
//        System.out.println(arr1[0] +" "+ arr1.length);
    }

    @Test
    public void runTests(){
        int[] nullArray= GeneratePrimes.generatePrimes(0) ;
        assertEquals(nullArray.length , 0);

        int[] arr1= GeneratePrimes.generatePrimes(2) ;
        assertEquals(arr1.length, 1);
        assertEquals( arr1[0],2);

        int[] arr2= GeneratePrimes.generatePrimes(3) ;
        assertEquals(arr2.length, 2);
        assertEquals( arr2[0],2);
        assertEquals( arr2[1],3);

        int[] arr3= GeneratePrimes.generatePrimes(100) ;
        assertEquals(arr3.length, 25);
        assertEquals( arr3[24],97);

    }
    @Test
    public void testExhaustive(){
        /*//OLD
        int [] primes;
        for(int i=0; i<=500 ; i++){
            primes=GeneratePrimes.generatePrimes(i);
            for(int j=0; j<primes.length; j++){
                for(int k=2; k<primes[j]; k++){
                    assert(primes[j]%k!=0);
                }
            }
        }

         */
        for(int i=0; i<=500; i++)
        verifyPrimeList(GeneratePrimes.generatePrimes(i));
    }
    public void verifyPrimeList(int arr[]){
        for(int i=0; i<arr.length; i++){
            verifyPrime(arr[i]);
        }
    }
    public void verifyPrime(int num){
        for(int i=2; i<num; i++)
            assert(num%i!=0);
    }

}
