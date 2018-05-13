package auto.lib.encrypt;


import java.io.IOException;
import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
//import java.security.Security;
import javax.crypto.BadPaddingException;  
import javax.crypto.Cipher;  
import javax.crypto.IllegalBlockSizeException;  
//import javax.crypto.KeyGenerator;  
//import javax.crypto.NoSuchPaddingException;  
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class DESEncrypt {
	/*
	//KeyGenerator 提供对称密钥生成器的功能，支持各种算法  
    private KeyGenerator keygen;  
    //SecretKey 负责保存对称密钥  
    private SecretKey deskey;  
    //Cipher负责完成加密或解密工作  
    private Cipher c;  
    //该字节数组负责保存加密的结果  
    private byte[] cipherByte;  	
    */
	
    private  static String DES = "DES";
    private  static String ENCODE = "GBK";
    private  static String defaultKey = "x1EL7tEKjizKZEl5g6PGUJ9ewnHQca8yvQS9X1EWL9gPkCevCd00xM49wIKfSKGdX1TGLkY2vyTp2I5XRUa8GLifQN4Q2TAHm3EQckCdYuGtOruy82OdcSNnIRwEQZcX";
    
    /*
    public encryptUtils() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException{  
        Security.addProvider(new com.sun.crypto.provider.SunJCE());  
        //实例化支持DES算法的密钥生成器(算法名称命名需按规定，否则抛出异常) 
        
        keygen = KeyGenerator.getInstance("DES");  
        //生成密钥  
        keygen.init(56);
        deskey = keygen.generateKey();
        //生成Cipher对象,指定其支持的DES算法  
        c = Cipher.getInstance("DES");
       
        //byte[] encoded = deskey.getEncoded();  
        //String encodeHexString = Hex.toHexString(encoded);  
        //System.out.println(encodeHexString);
        
    }  */
      
    /** 
     * 对字符串加密 
     *  
     * @param str 
     * @return 
     * @throws InvalidKeyException 
     * @throws IllegalBlockSizeException 
     * @throws BadPaddingException 
     */  
    /*
    public byte[] Encrytor(String str) throws InvalidKeyException,  
            IllegalBlockSizeException, BadPaddingException {  
        // 根据密钥，对Cipher对象进行初始化，ENCRYPT_MODE表示加密模式  
        c.init(Cipher.ENCRYPT_MODE, deskey);  
        byte[] src = str.getBytes();  
        // 加密，结果保存进cipherByte  
        cipherByte = c.doFinal(src);  
        return cipherByte;  
    }  */
  
    /** 
     * 对字符串解密 
     *  
     * @param buff 
     * @return 
     * @throws InvalidKeyException 
     * @throws IllegalBlockSizeException 
     * @throws BadPaddingException 
     */  
    /*
    public byte[] Decryptor(byte[] buff) throws InvalidKeyException,  
            IllegalBlockSizeException, BadPaddingException {  
        // 根据密钥，对Cipher对象进行初始化，DECRYPT_MODE表示解密模式  
        c.init(Cipher.DECRYPT_MODE, deskey);  
        cipherByte = c.doFinal(buff);  
        return cipherByte;  
    }  */
  
    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }
    public static String encrypt(String data, String key) throws Exception {
    	System.out.println(defaultKey.getBytes(ENCODE));
        byte[] bt = encrypt(data.getBytes(ENCODE), defaultKey.getBytes(ENCODE));
        String strs = new BASE64Encoder().encode(bt);
        return strs;
    }
    public static String encrypt(String data) throws Exception {
    	
        byte[] bt = encrypt(data.getBytes(ENCODE), defaultKey.getBytes(ENCODE));
        String strs = new BASE64Encoder().encode(bt);
        return strs;
    }

    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }
    public static String decrypt(String data, String key) throws IOException,Exception {
		if (data == null)
		    return null;
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] buf = decoder.decodeBuffer(data);
		byte[] bt = decrypt(buf, key.getBytes(ENCODE));
		return new String(bt, ENCODE);
	}
    
    public static String decrypt(String data) throws IOException, Exception {
        if (data == null)
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] buf = decoder.decodeBuffer(data);
        byte[] bt = decrypt(buf, defaultKey.getBytes(ENCODE));
        return new String(bt, ENCODE);
    }
     
    public static void main(String[] args) throws Exception {  
    	/*
    	encryptUtils de1 = new encryptUtils(); 
    	
        String msg ="郭集";
        byte[] encontent = de1.Encrytor(msg);  
        byte[] decontent = de1.Decryptor(encontent); 
        System.out.println("明文是:" + msg);  
        System.out.println("加密后:" + new String(encontent));  
        System.out.println("解密后:" + new String(decontent));  
     */
    	
        String data = "测试ss测试ss测试ss测试ss测试ss测试ss测试ss测试ss";
        System.out.println(encrypt(data));
       //System.out.println(decrypt("EuiST74Maur8PdizFYtyil3FBTx5sfGsWuiST74Maur8PdizFYtyil3FB5x5sfGslKka1CoD+Eo="));
        System.out.println(decrypt(encrypt(data)));
    }  
}
