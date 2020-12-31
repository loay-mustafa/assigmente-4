/* this program improve by loay al-ajramy */
/* in this program every variables name meaning Demonstrates its use */
/* the program print number of permution after print them all */
/*we can divide function to find factorial But to facilitate the reading and understanding of the program I did not divide it*/
/* the program print all permutation we can improve it to print permutation without dublicate*/ 
import java.util.Scanner;
public class StringPermutator2 {
    private static void printPermutationsIterative(String string){
     int [] factorials = new int[string.length()+1];  //Array  to handle factorial of integers
        factorials[0] = 1;
        for (int i = 1; i<=string.length();i++) {
            factorials[i] = factorials[i-1] * i;         //calculate factorials
        }

        for (int i = 0; i < factorials[string.length()]; i++) {
            String onePermutation="";      //  vriable to handle permutation for each loop
            String Temporary = string;      // Temporary variable equal input string
            int positionCode = i;
            for (int position = string.length(); position > 0 ;position--){ 
                /*all permutation have N! of possibilities,
                each number from one to N! hse one permutation.*/
                int selected = positionCode / factorials[position-1];
                onePermutation += Temporary.charAt(selected);
                positionCode = positionCode % factorials[position-1];
                Temporary = Temporary.substring(0,selected) + Temporary.substring(selected+1);
            }
            System.out.println(onePermutation);      // print permutation

        }
            System.out.println("number of permutation is "+ factorials[string.length()]);  // // print the number permutation
  

    }
public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
  while (true){       // loop stoped when user input string 
     System.out.print("Enter value to permutate: ");
     String string = scanner.nextLine();
     if((string == null) || (string.trim().isEmpty())) {  // if user does not input  value will print error and repeat input message
     System.out.println("erorr, you must input  value to permutate  ");
}
      else {
        printPermutationsIterative(string);     // Call a function to find Permutations
         scanner.close();
         break;
}}}}
