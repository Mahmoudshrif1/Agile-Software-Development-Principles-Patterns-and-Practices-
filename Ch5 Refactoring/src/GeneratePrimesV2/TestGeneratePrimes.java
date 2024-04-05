package GeneratePrimesV2;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestGeneratePrimes{

    public static void main(String [] args){
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
}
