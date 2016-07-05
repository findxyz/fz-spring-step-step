package com.utils.security;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by fz on 2016/7/4.
 */
public class RSAUtil {

    private static final String KEY_ALGORITHM = "RSA";

    private static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    private static final int MAX_BLOCK = 128;

    private static final int ENCRYPT_MODE = Cipher.ENCRYPT_MODE;

    private static final int DECRYPT_MODE = Cipher.DECRYPT_MODE;

    public static class RetKeyPair {

        private String base64PubKey;

        private String base64PriKey;

        RetKeyPair(String base64PubKey, String base64PriKey) {
            this.base64PubKey = base64PubKey;
            this.base64PriKey = base64PriKey;
        }

        public String getBase64PubKey() {
            return base64PubKey;
        }

        public String getBase64PriKey() {
            return base64PriKey;
        }
    }

    // 生成公私匙
    public static RetKeyPair generateKeyPair() throws Exception {

        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        return new RetKeyPair(Base64.encodeBase64String(publicKey.getEncoded()), Base64.encodeBase64String(privateKey.getEncoded()));
    }

    // 私匙签名
    public static String sign(byte[] data, String privateKey) throws Exception {

        byte[] keyBytes = Base64.decodeBase64(privateKey);
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateK = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(privateK);
        signature.update(data);
        return Base64.encodeBase64String(signature.sign());
    }

    // 公匙校验签名
    public static boolean verify(byte[] data, String publicKey, String sign) throws Exception {

        byte[] keyBytes = Base64.decodeBase64(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicK = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(publicK);
        signature.update(data);
        return signature.verify(Base64.decodeBase64(sign));
    }

    // 获取公匙加解密法
    private static Cipher getPubCipher(String publicKey, int mode) throws Exception {

        byte[] keyBytes = Base64.decodeBase64(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicK = keyFactory.generatePublic(x509KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(mode, publicK);
        return cipher;
    }

    // 获取私匙加解密法
    private static Cipher getPriCipher(String privateKey, int mode) throws Exception {

        byte[] keyBytes = Base64.decodeBase64(privateKey);
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateK = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(mode, privateK);
        return cipher;
    }

    private static byte[] retData(byte[] originData, Cipher cipher) throws Exception {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // 对数据分段加解密
        int i = 0;
        int offSet = 0;
        int inputLen = originData.length;
        byte[] cache;
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_BLOCK) {
                cache = cipher.doFinal(originData, offSet, MAX_BLOCK);
            } else {
                cache = cipher.doFinal(originData, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_BLOCK;
        }
        byte[] retData = out.toByteArray();
        out.close();
        return retData;
    }

    // 公匙加密
    public static byte[] encryptByPublicKey(byte[] data, String publicKey) throws Exception {

        return retData(data, getPubCipher(publicKey, ENCRYPT_MODE));
    }

    // 公匙解密数据
    public static byte[] decryptByPublicKey(byte[] data, String publicKey) throws Exception {

        return retData(data, getPubCipher(publicKey, DECRYPT_MODE));
    }

    // 私匙加密
    public static byte[] encryptByPrivateKey(byte[] data, String privateKey) throws Exception {

        return retData(data, getPriCipher(privateKey, ENCRYPT_MODE));
    }

    // 私匙解密数据
    public static byte[] decryptByPrivateKey(byte[] data, String privateKey) throws Exception {

        return retData(data, getPriCipher(privateKey, DECRYPT_MODE));
    }

}
