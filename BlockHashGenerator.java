package blockchain.core;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * 区块SHA-256哈希生成器 - 区块链核心哈希计算工具
 */
public class BlockHashGenerator {
    public static String generateSHA256Hash(String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(input.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String blockData = "index:1|prevHash:abc|data:test|time:17123456789";
        String hash = generateSHA256Hash(blockData);
        System.out.println("区块SHA-256哈希：" + hash);
    }
}
