import java.util.Scanner;
public class StringPermutator {
public static int [] CalculateFactorialsArray(int stringLength) {
int [] factorialArray = new int[stringLength+1]; // Array of integers to handle factorial of integers
factorialArray[0] = 1;
for (int i = 1; i<=stringLength;i++) {
factorialArray[i] = factorialArray[i-1] * i; /* Calculate the factorial for each integer
from 1 to the length of given String, each number from 1 to string.length! encodes a permutation */
}
return factorialArray;
}
public static void GetOnePermutation(int positionCode , int [] factorialsArray , String string) {
String onePermutation=""; // Local String variable to handle one permutation for each loop
String temp = string; /* Temporary String variable equals the given String,
used in finding permutation operation */
for (int position = string.length(); position > 0; position--){ /* Counter from String length to 0,
to split the needed character of the given String to find each permutation */
int selected = positionCode / factorialsArray[position-1]; /* Selected index of character from
the given String */
onePermutation += temp.charAt(selected); /* Add the character from the given String to the
variable which handles one permutation each loop */
positionCode = positionCode % factorialsArray[position-1]; /* Guarantee that the value of
positionCode
to be within the string indexes */
temp = temp.substring(0,selected) + temp.substring(selected+1); /* Exclude the added character
to (onePermutation) from (temp) value, to continue finding out the permutation */
}
System.out.println(onePermutation);
}
public static void GetPermutationsOfGivenString(String string) {
int [] factorials = CalculateFactorialsArray(string.length()); // split the function which finds the factorial array
int numberOfPermutations = factorials[string.length()]; // enhance the code readability
for (int i = 0; i < numberOfPermutations; i++) { /* Counter to print out the permutations
of the given String */
int positionCode = i; /* Initialized before each loop to hold the number of permutation */
GetOnePermutation(positionCode,factorials,string);
}
}
public static void main(String[] args) {
System.out.print("Enter string to permutate: ");
Scanner scanner = new Scanner(System.in);
String string = scanner.nextLine();
scanner.close();

if((string == null) || (string.trim().isEmpty())) {
System.out.println("erorr, you must input string value ");
}
else GetPermutationsOfGivenString(string);
}
}
