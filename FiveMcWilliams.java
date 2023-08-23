import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FiveMcWilliams {
    public static void main(String[] args) throws Exception {

        int m = ( int) Math . pow (2 , 7) ;
        char [] anticipher = new char [ m ];
        for ( int i = 0; i < m ; i ++)
        {
            anticipher [ i ] = (char)mod(55*(i - 3), m );
        }
        String cipher = read ("cipher.txt") ;
        for ( int i = 0; i < cipher . length () ; i ++)
            System . out . print ( anticipher [ cipher . charAt ( i ) ]) ;
    }
    public static String read ( String path ) {
        String ret = null ;
        try {
            ret = new String ( Files . readAllBytes ( Paths . get ( path ) ) ) ;
        } catch ( IOException e ) {
            e . printStackTrace () ;
        }
        return ret ;
    }
    public static int mod ( int x , int n ) { return (( x % n ) + n ) % n ; }
}

