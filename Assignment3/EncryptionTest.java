

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EncryptionTest {

    @Test
    public void testVigenereEncryption() {
        String phrase = "ATTACKATDAWN";
        String keyword = "LEMON";

        String encrypted = Encryption.encryptVigenere(phrase, keyword);

        assertEquals("LXFOPVEFRNHR", encrypted);
    }

    @Test
    public void testVigenereDecryption() {
        String encrypted = "LXFOPVEFRNHR";
        String keyword = "LEMON";

        String decrypted = Encryption.decryptVigenere(encrypted, keyword);

        assertEquals("ATTACKATDAWN", decrypted);
    }

    @Test
    public void testPlayfairEncryption() {
        String phrase = "INSTRUMENTS";
        String keyword = "MONARCHY";

        char[][] matrix = Encryption.createPlayfairMatrix(keyword);
        String encrypted = Encryption.encryptPlayfair(phrase, matrix);

        assertEquals("GATLMZCLRQXA", encrypted);
    }

    @Test
    public void testPlayfairDecryption() {
        String encrypted = "GATLMZCLRQXA";
        String keyword = "MONARCHY";

        char[][] matrix = Encryption.createPlayfairMatrix(keyword);
        String decrypted = Encryption.decryptPlayfair(encrypted, matrix);

        assertEquals("INSTRUMENTSX", decrypted);
    }

    @Test
    public void testCaesarEncryption() {
        String phrase = "HELLO";
        int shift = 3;

        String encrypted = Encryption.encryptCaesar(phrase, shift);

        assertEquals("KHOOR", encrypted);
    }

    @Test
    public void testCaesarDecryption() {
        String encrypted = "KHOOR";
        int shift = 3;

        String decrypted = Encryption.decryptCaesar(encrypted, shift);

        assertEquals("HELLO", decrypted);
    }
}