import java.util.Scanner;

public class Assignment5_StringManipulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== GRADED ASSIGNMENT 5: STRING MANIPULATION ===");
            System.out.println("Выберите задание (1-8) или 0 для выхода:");
            System.out.println("1 — Count Vowels");
            System.out.println("2 — Reverse a String");
            System.out.println("3 — Check Palindrome");
            System.out.println("4 — Count Words in a Sentence");
            System.out.println("5 — Remove All Spaces");
            System.out.println("6 — Capitalize First Letter of Each Word");
            System.out.println("7 — Find the Most Frequent Character");
            System.out.println("8 — Check Anagrams");
            System.out.print("Ваш выбор: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите число!");
                continue;
            }

            switch (choice) {
                case 1 -> task1(scanner);
                case 2 -> task2(scanner);
                case 3 -> task3(scanner);
                case 4 -> task4(scanner);
                case 5 -> task5(scanner);
                case 6 -> task6(scanner);
                case 7 -> task7(scanner);
                case 8 -> task8(scanner);
                case 0 -> {
                    System.out.println("До свидания! Удачи со сдачей задания :)");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
    }

    // ===================== TASK 1 =====================
    private static void task1(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

       
        int count = 0;
        String lowerInput = input.toLowerCase();
        for (int i = 0; i < lowerInput.length(); i++) {
            char ch = lowerInput.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }

        System.out.println("Number of vowels: " + count);
    }

    // ===================== TASK 2 =====================
    private static void task2(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        
        String reversed = new StringBuilder(input).reverse().toString();

        System.out.println(reversed);
    }

    // ===================== TASK 3 =====================
    private static void task3(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        boolean isPalindrome = cleaned.equals(reversed);

        System.out.println(isPalindrome ? "Yes" : "No");
    }

    // ===================== TASK 4 =====================
    private static void task4(Scanner scanner) {
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

  
        int wordCount = 0;
        String trimmed = sentence.trim();
        if (!trimmed.isEmpty()) {
            wordCount = trimmed.split("\\s+").length;
        }

        System.out.println("Number of words: " + wordCount);
    }

    // ===================== TASK 5 =====================
    private static void task5(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

  
        String noSpaces = input.replaceAll("\\s+", "");

        System.out.println(noSpaces);
    }

    // ===================== TASK 6 =====================
    private static void task6(Scanner scanner) {
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

   
        StringBuilder sb = new StringBuilder();
        boolean capitalizeNext = true;
        for (char c : sentence.toCharArray()) {
            if (Character.isWhitespace(c)) {
                capitalizeNext = true;
                sb.append(c);
            } else if (capitalizeNext) {
                sb.append(Character.toUpperCase(c));
                capitalizeNext = false;
            } else {
                sb.append(c);
            }
        }
        String result = sb.toString();

        System.out.println(result);
    }

    // ===================== TASK 7 =====================
    private static void task7(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

   
        int[] freq = new int[256];
        for (char c : input.toCharArray()) {
            freq[c]++;
        }
        char mostFrequent = ' ';
        int maxFreq = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                mostFrequent = (char) i;
            }
        }

        System.out.println("The most frequent character is: " + mostFrequent);
    }

    // ===================== TASK 8 =====================
    private static void task8(Scanner scanner) {
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();

       
        String s1 = str1.replaceAll("\\s+", "").toLowerCase();
        String s2 = str2.replaceAll("\\s+", "").toLowerCase();
        
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        java.util.Arrays.sort(arr1);
        java.util.Arrays.sort(arr2);
        
        boolean areAnagrams = java.util.Arrays.equals(arr1, arr2);

        System.out.println(areAnagrams ? "Yes" : "No");
    }
}