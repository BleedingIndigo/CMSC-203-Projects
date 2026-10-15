/*
 * Class: CMSC203 
 * Instructor:Ahmed Tarek
 * Description:Write a Java program to encrypt and decrypt a phrase using three different 
 * approaches, each insecure by modern standards
 * Due: 10/14/2026
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here:Yizhu Wang
*/

import java.util.Scanner;

public class Encryption {

    public static String encryptVigenere(String phrase, String keyword) {
        StringBuilder result = new StringBuilder();
        phrase = phrase.toUpperCase();
        keyword = keyword.toUpperCase();
        int keyIndex = 0;

        for (int i = 0; i < phrase.length(); i++) {
            char ch = phrase.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                int p = ch - 'A';
                int k = keyword.charAt(keyIndex % keyword.length()) - 'A';
                result.append((char) ((p + k) % 26 + 'A'));
                keyIndex++;
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static String decryptVigenere(String phrase, String keyword) {
        StringBuilder result = new StringBuilder();
        phrase = phrase.toUpperCase();
        keyword = keyword.toUpperCase();
        int keyIndex = 0;

        for (int i = 0; i < phrase.length(); i++) {
            char ch = phrase.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                int p = ch - 'A';
                int k = keyword.charAt(keyIndex % keyword.length()) - 'A';
                result.append((char) ((p - k + 26) % 26 + 'A'));
                keyIndex++;
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static char[][] createPlayfairMatrix(String keyword) {
        String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        StringBuilder letters = new StringBuilder();
        keyword = keyword.toUpperCase().replace('J', 'I');

        for (int i = 0; i < keyword.length(); i++) {
            char ch = keyword.charAt(i);

            if (ch >= 'A' && ch <= 'Z'
                    && letters.indexOf(String.valueOf(ch)) == -1) {
                letters.append(ch);
            }
        }

        for (int i = 0; i < alphabet.length(); i++) {
            char ch = alphabet.charAt(i);

            if (letters.indexOf(String.valueOf(ch)) == -1) {
                letters.append(ch);
            }
        }

        char[][] matrix = new char[5][5];

        for (int i = 0; i < 25; i++) {
            matrix[i / 5][i % 5] = letters.charAt(i);
        }

        return matrix;
    }

    public static String preparePlayfair(String phrase) {
        phrase = phrase.toUpperCase()
                .replace('J', 'I')
                .replaceAll("[^A-Z]", "");

        StringBuilder prepared = new StringBuilder();
        int i = 0;

        while (i < phrase.length()) {
            char first = phrase.charAt(i);
            prepared.append(first);

            if (i + 1 >= phrase.length()) {
                prepared.append('X');
                i++;
            } else if (first == phrase.charAt(i + 1)) {
                prepared.append('X');
                i++;
            } else {
                prepared.append(phrase.charAt(i + 1));
                i += 2;
            }
        }

        return prepared.toString();
    }

    public static int[] findPosition(char[][] matrix, char letter) {
        if (letter == 'J') {
            letter = 'I';
        }

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (matrix[row][col] == letter) {
                    return new int[]{row, col};
                }
            }
        }

        return new int[]{0, 0};
    }

    public static String encryptPlayfair(String phrase, char[][] matrix) {
        phrase = preparePlayfair(phrase);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < phrase.length(); i += 2) {
            char first = phrase.charAt(i);
            char second = phrase.charAt(i + 1);

            int[] p1 = findPosition(matrix, first);
            int[] p2 = findPosition(matrix, second);

            if (p1[0] == p2[0]) {
                result.append(matrix[p1[0]][(p1[1] + 1) % 5]);
                result.append(matrix[p2[0]][(p2[1] + 1) % 5]);
            } else if (p1[1] == p2[1]) {
                result.append(matrix[(p1[0] + 1) % 5][p1[1]]);
                result.append(matrix[(p2[0] + 1) % 5][p2[1]]);
            } else {
                result.append(matrix[p1[0]][p2[1]]);
                result.append(matrix[p2[0]][p1[1]]);
            }
        }

        return result.toString();
    }

    public static String decryptPlayfair(String phrase, char[][] matrix) {
        phrase = phrase.toUpperCase().replaceAll("[^A-Z]", "");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i + 1 < phrase.length(); i += 2) {
            char first = phrase.charAt(i);
            char second = phrase.charAt(i + 1);

            int[] p1 = findPosition(matrix, first);
            int[] p2 = findPosition(matrix, second);

            if (p1[0] == p2[0]) {
                result.append(matrix[p1[0]][(p1[1] + 4) % 5]);
                result.append(matrix[p2[0]][(p2[1] + 4) % 5]);
            } else if (p1[1] == p2[1]) {
                result.append(matrix[(p1[0] + 4) % 5][p1[1]]);
                result.append(matrix[(p2[0] + 4) % 5][p2[1]]);
            } else {
                result.append(matrix[p1[0]][p2[1]]);
                result.append(matrix[p2[0]][p1[1]]);
            }
        }

        return result.toString();
    }

    public static String encryptCaesar(String phrase, int shift) {
        StringBuilder result = new StringBuilder();
        shift = ((shift % 26) + 26) % 26;
        phrase = phrase.toUpperCase();

        for (int i = 0; i < phrase.length(); i++) {
            char ch = phrase.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                result.append((char) ((ch - 'A' + shift) % 26 + 'A'));
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static String decryptCaesar(String phrase, int shift) {
        return encryptCaesar(phrase, -shift);
    }

    public static boolean isValidPhrase(String phrase) {
        return phrase != null
                && !phrase.trim().isEmpty()
                && phrase.matches("(?s).*\\p{L}.*");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean restartNeeded = false;

        System.out.println("VIGENERE CIPHER");
        System.out.print("Enter a phrase: ");
        String phrase = input.nextLine();

        System.out.print("Enter keyword: ");
        String vigenereKey = input.nextLine()
                .toUpperCase()
                .replaceAll("[^A-Z]", "");

        if (!isValidPhrase(phrase) || vigenereKey.isEmpty()) {
            System.out.println("Invalid or blank phrase/keyword.");
            System.out.println("Vigenere Cipher: Please try again.");
            restartNeeded = true;
        } else {
            String encrypted = encryptVigenere(phrase, vigenereKey);
            System.out.println("Encrypted phrase: " + encrypted);
            System.out.println("Decrypted phrase: "
                    + decryptVigenere(encrypted, vigenereKey));
        }

        System.out.println();

        System.out.println("PLAYFAIR CIPHER");
        System.out.print("Enter keyword: ");
        String playfairKey = input.nextLine()
                .toUpperCase()
                .replaceAll("[^A-Z]", "");

        if (!isValidPhrase(phrase) || playfairKey.isEmpty()) {
            System.out.println("Invalid or blank phrase/keyword.");
            System.out.println("Playfair Cipher: Please try again.");
            restartNeeded = true;
        } else {
            char[][] matrix = createPlayfairMatrix(playfairKey);
            String encrypted = encryptPlayfair(phrase, matrix);
            System.out.println("Encrypted phrase: " + encrypted);
            System.out.println("Decrypted phrase: "
                    + decryptPlayfair(encrypted, matrix));
        }

        System.out.println();

        System.out.println("CAESAR CIPHER");
        System.out.print("Enter shift value (0-25): ");
        String shiftInput = input.nextLine().trim();

        try {
            int shift = Integer.parseInt(shiftInput);

            if (!isValidPhrase(phrase) || shift < 0 || shift > 25) {
                System.out.println("Invalid or blank phrase/shift value.");
                System.out.println("Caesar Cipher: Please try again.");
                restartNeeded = true;
            } else {
                String encrypted = encryptCaesar(phrase, shift);
                System.out.println("Encrypted phrase: " + encrypted);
                System.out.println("Decrypted phrase: "
                        + decryptCaesar(encrypted, shift));
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid or blank shift value.");
            System.out.println("Caesar Cipher: Please try again.");
            restartNeeded = true;
        }

        System.out.println();

        if (restartNeeded) {
            System.out.println("One or more inputs were invalid.");
            System.out.println("Please restart the program and enter all values correctly.");
        } else {
            System.out.println("All ciphers completed successfully.");
        }

        input.close();
    }
}