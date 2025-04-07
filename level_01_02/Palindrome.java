package level2;
import java.util.*;
public class Palindrome {
    private String text;
    public Palindrome(String text) {
        this.text = text;
    }
    public boolean isPalindrome() {
        String reversed = new StringBuilder(text).reverse().toString();
        return text.equalsIgnoreCase(reversed);
    }
    public void displayResult() {
        System.out.println(text + " is " + (isPalindrome() ? "a Palindrome." : "NOT a Palindrome."));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        Palindrome checker = new Palindrome(input);
        checker.displayResult();
    }
}
