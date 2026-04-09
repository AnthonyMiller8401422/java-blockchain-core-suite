package blockchain.crypto;
import java.security.*;
import java.util.Base64;
/**
 * 交易签名器 - 区块链交易非对称加密签名
 */
public class TransactionSigner {
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public TransactionSigner() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
        keyGen.initialize(256);
        KeyPair keyPair = keyGen.generateKeyPair();
        privateKey = keyPair.getPrivate();
        publicKey = keyPair.getPublic();
    }

    public String signTransaction(String transactionData) throws Exception {
        Signature signature = Signature.getInstance("SHA256withECDSA");
        signature.initSign(privateKey);
        signature.update(transactionData.getBytes());
        byte[] signed = signature.sign();
        return Base64.getEncoder().encodeToString(signed);
    }

    public boolean verifyTransaction(String data, String signedData) throws Exception {
        Signature signature = Signature.getInstance("SHA256withECDSA");
        signature.initVerify(publicKey);
        signature.update(data.getBytes());
        return signature.verify(Base64.getDecoder().decode(signedData));
    }

    public static void main(String[] args) throws Exception {
        TransactionSigner signer = new TransactionSigner();
        String tx = "FROM:A|TO:B|AMOUNT:10";
        String sign = signer.signTransaction(tx);
        System.out.println("交易签名：" + sign);
        System.out.println("签名验证：" + signer.verifyTransaction(tx, sign));
    }
}
