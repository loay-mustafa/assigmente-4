/* this program improve by loay al-ajramy */
/* in this program every variables name meaning Demonstrates its use */
/* the program print number of permution after print them all */
/*we can divide function to find factorial But to facilitate the reading and understanding of the program I did not divide it*/
/* the program print all permutation we can improve it to print permutation without dublicate*/ 

import java.util.*;

public class StringPermutator2 {
    
    private static List<String> PrintPermutationsIterative(String string){
        List<String> list=new ArrayList<String>();

     int [] factorials = new int[string.length()+1];  //Array  to handle factorial of integers
        factorials[0] = 1;
        for (int i = 1; i<=string.length();i++) {
            factorials[i] = factorials[i-1] * i;         //calculate factorials
        }

        for (int i = 0; i < factorials[string.length()]; i++) {
            String onePermutation="";      //  vriable to handle permutation for each loop
            String temporary = string;      // Temporary variable equal input string
            int positionCode = i;
            for (int position = string.length(); position > 0 ;position--){ 
                /*all permutation have N! of possibilities,
                each number from one to N! hse one permutation.*/
                int selected = positionCode / factorials[position-1];
                onePermutation += temporary.charAt(selected);
                positionCode = positionCode % factorials[position-1];
                temporary = temporary.substring(0,selected) + temporary.substring(selected+1);
            }
             list.add(onePermutation);     // print permutation

        }
            System.out.println("number of permutation is "+ factorials[string.length()]);  // // print the number permutation
  return list;

    }
    static boolean cheakPermutations(List<String> list, String string){
             char ch1[] = string.toCharArray(); // convert input string to character array
             Arrays.sort(ch1);                  //sort input string character array
for (int i = 0; i < list.size(); i++){         // loop for Extract Permutation from the list

    char ch2[]=list.get(i).toCharArray();        // convert Permutation to character array
    Arrays.sort(ch2);                            //sort Permutation character array
    for (int j = 0; j<ch1.length; j++){           // loop for cheak if Permutation equal the input string
    if (ch1[j] != ch2[j]) {                 
        return false;}                               // return false if there uncorrect Permutation
  
    } }
       return true;                                // true if all Permutation True
     }
public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 List<String> list=new ArrayList<String>();
  while (true){       // loop stoped when user input string 
     System.out.print("Enter value to permutate: ");
     String string = scanner.nextLine();
     if((string == null) || (string.trim().isEmpty())) {  // if user does not input  value will print error and repeat input message
     System.out.println("erorr, you must input  value to permutate  ");
}
      else {
          
        list=PrintPermutationsIterative(string); 
            System.out.println(list.toString());
            System.out.println(cheakPermutations(list, string));
        // Call a function to find Permutations
         scanner.close();
         break;
}}}}
