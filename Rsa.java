import java.security.*;
import javax.crypto.Cipher;

public class RSAEncryptionExample {
    public static void main(String[] args) throws Exception {
        String originalMessage = "Hello, RSA Encryption!";

        // Generate Key Pair (Public and Private Keys)
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // Key size (bits)
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // Get Public and Private Keys
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // Encryption
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(originalMessage.getBytes());

        // Decryption
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        // Convert the decrypted bytes back to a string
        String decryptedMessage = new String(decryptedBytes);

        // Print results
        System.out.println("Original Message: " + originalMessage);
        System.out.println("Encrypted Message: " + bytesToHex(encryptedBytes));
        System.out.println("Decrypted Message: " + decryptedMessage);
    }

    // Helper method to convert bytes to hexadecimal string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02X", b));
        }
        return result.toString();
    }
}
