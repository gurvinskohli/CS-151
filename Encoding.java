
import java.util.*;

public class Encoding
{
    public static void morse(int m, int n, String code, Set<String> morseCode){
        if(m == 0 && n == 0){
            morseCode.add(code);
            return;
        }
        if(n == 0){
            morse(m-1,n,code+".",morseCode);
            return;
        }
        if(m == 0){
            morse(m,n-1,code+"-",morseCode);
            return;
        }
        morse(m-1,n,code+".",morseCode);
        morse(m,n-1,code+"-",morseCode);
    }
    public static Set<String> morseCodes(int m, int n)
    {
        Set<String> result = new TreeSet<>();
        morse(m,n,"", result);
        return result;
    }
}
