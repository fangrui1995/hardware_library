package com.hl.hardwareLibrary.utils.sign;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class EncrypRSA {    
public static final String KEY_ALGORITHM = "RSA";   
/**  
* BASE64解密  
*   
* @param key  
* @return  
* @throws Exception  
*/    
public static byte[] decryptBASE64(String key) throws Exception {    
    return (new BASE64Decoder()).decodeBuffer(key);    
}    
/**  
* BASE64加密  
*   
* @param key  
* @return  
* @throws Exception  
*/    
public static String encryptBASE64(byte[] key) throws Exception {    
    return (new BASE64Encoder()).encodeBuffer(key);    
}    
        
    /**  
     * 加密  
     * @param publicKey  
     * @param srcBytes  
     * @return  
     * @throws NoSuchAlgorithmException  
     * @throws NoSuchPaddingException  
     * @throws InvalidKeyException  
     * @throws IllegalBlockSizeException  
     * @throws BadPaddingException  
     */    
    public static byte[] encrypt(RSAPublicKey publicKey,byte[] srcBytes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{    
        if(publicKey!=null){    
            //Cipher负责完成加密或解密工作，基于RSA    
            Cipher cipher = Cipher.getInstance("RSA");    
            //根据公钥，对Cipher对象进行初始化    
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);    
            byte[] resultBytes = cipher.doFinal(srcBytes);    
            return resultBytes;    
        }    
        return null;    
    }    
        
    /**  
     * 解密   
     * @param privateKey  
     * @param srcBytes  
     * @return  
     * @throws NoSuchAlgorithmException  
     * @throws NoSuchPaddingException  
     * @throws InvalidKeyException  
     * @throws IllegalBlockSizeException  
     * @throws BadPaddingException  
     */    
    public byte[] decrypt(RSAPrivateKey privateKey,byte[] srcBytes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{    
        if(privateKey!=null){    
            //Cipher负责完成加密或解密工作，基于RSA    
            Cipher cipher = Cipher.getInstance("RSA");    
            //根据公钥，对Cipher对象进行初始化    
            cipher.init(Cipher.DECRYPT_MODE, privateKey);    
            byte[] resultBytes = cipher.doFinal(srcBytes);    
            return resultBytes;    
        }    
        return null;    
    }

}
