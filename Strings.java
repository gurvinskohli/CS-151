public class Strings
{
   public static String uniqueLetters(String str)
   {
      String unique = "";
      for(int x = 0;x < str.length();x++)
      {
         int count = 0;
         char element = str.charAt(x);
         for(int y = 0;y < str.length();y++)
         {
            if(element == str.charAt(y))
            {
               count = count + 1;
            }
         }
         if(count == 1)
         {
            unique += element;
         }
      }
      return unique;
   }
}