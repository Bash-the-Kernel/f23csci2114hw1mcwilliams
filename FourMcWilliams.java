import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FourMcWilliams {
    public static void main(String[] args) throws Exception {

        
        long startTime = System.currentTimeMillis();
        byte [] bytes = getFileBytes ("half_gaps.bin") ;
        long [] gaps = new long [ bytes.length ];
        long [] cusum = new long [ gaps.length ];
        for ( int i = 0; i < bytes.length ; i ++)
        {
            gaps [ i ] = Byte . toUnsignedLong ( bytes [ i ]) ;
        }
        for(int i = 0; i < gaps.length; i++)
        {
            if(i!=0) cusum[i] = gaps[i] +cusum[i-1];
            else cusum[i] = gaps[i];
        }
        for(int i = 0; i < cusum.length; i++)
        {
            cusum[i] = 2*cusum[i] + 3;
        }

        long endTime = System.currentTimeMillis();
        double elapsedSeconds = (endTime - startTime) / (1000.0);  // Convert milliseconds to seconds
        System.out.println("\nTime taken: " + elapsedSeconds + " seconds");

        System.out.println("first 15");
        for(int i = 0; i < 15; i++)
        {
            System.out.println(cusum[i]);
        }
        System.out.println("last 5");
        for(int i = cusum.length - 1; i > cusum.length-6; i--)
        {
            System.out.println(cusum[i]);
        }

        

    }
    public static byte [] getFileBytes ( String path ) {
        byte [] bytes = null ;
        try {
            bytes = Files . readAllBytes ( Paths . get ( path ) ) ;
        } catch ( IOException e ) {
            e.printStackTrace () ;
        }
        return bytes ;
    }
}
