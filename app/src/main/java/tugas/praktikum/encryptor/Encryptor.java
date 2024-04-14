package tugas.praktikum.encryptor;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;

public class Encryptor {
    // Algoritma kriptografi yang digunakan
    private final static String algorithm = "AES";
    // Transformasi untuk enkripsi dan dekripsi AES
    private final static String transformation = "AES/ECB/PKCS5Padding";

    // Method untuk menghasilkan kunci acak menggunakan algoritma AES
    public static String generateKey() throws NoSuchAlgorithmException {
        KeyGenerator key = KeyGenerator.getInstance(algorithm);
        SecretKey secret = key.generateKey();
        // Encode kunci menjadi string menggunakan Base64
        String encodedKey = Base64.getEncoder().encodeToString(secret.getEncoded());
        return encodedKey;
    }

    // Method untuk melakukan enkripsi teks menggunakan kunci yang diberikan
    public static String encrypt(String plainText, String key) throws Exception {
        // Decode kunci yang diberikan dari string menjadi byte array
        byte[] decodedKey = Base64.getDecoder().decode(key);
        // Buat kunci dari byte array yang telah didecode
        SecretKey originalKey = new SecretKeySpec(decodedKey, 0,
                decodedKey.length, algorithm);
        // Inisialisasi objek Cipher untuk melakukan enkripsi
        Cipher cipher = Cipher.getInstance(transformation);
        // Set mode enkripsi dan inisialisasi dengan kunci yang telah dibuat
        cipher.init(Cipher.ENCRYPT_MODE, originalKey);
        // Lakukan enkripsi pada teks yang diberikan dan konversi hasilnya ke string
        // Base64
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
        return encryptedText;
    }

    // Method untuk melakukan dekripsi teks yang telah dienkripsi menggunakan kunci
    // yang diberikan
    public static String decrypt(String encodedText, String key) throws Exception {
        // Decode kunci yang diberikan dari string menjadi byte array
        byte[] decodedKey = Base64.getDecoder().decode(key);
        // Buat kunci dari byte array yang telah didecode
        SecretKey originalKey = new SecretKeySpec(decodedKey, 0,
                decodedKey.length, algorithm);
        // Inisialisasi objek Cipher untuk melakukan dekripsi
        Cipher cipher = Cipher.getInstance(transformation);
        // Set mode dekripsi dan inisialisasi dengan kunci yang telah dibuat
        cipher.init(Cipher.DECRYPT_MODE, originalKey);
        // Decode teks yang telah dienkripsi dari string menjadi byte array
        byte[] encryptedBytes = Base64.getDecoder().decode(encodedText);
        // Lakukan dekripsi pada teks yang telah dienkripsi dan konversi hasilnya ke
        // string
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decryptedText = new String(decryptedBytes,
                StandardCharsets.UTF_8);
        return decryptedText;
    }
}
