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
	//KeyGenerator �ṩ�Գ���Կ�������Ĺ��ܣ�֧�ָ����㷨  
    private KeyGenerator keygen;  
    //SecretKey ���𱣴�Գ���Կ  
    private SecretKey deskey;  
    //Cipher������ɼ��ܻ���ܹ���  
    private Cipher c;  
    //���ֽ����鸺�𱣴���ܵĽ��  
    private byte[] cipherByte;  	
    */
	
    private  static String DES = "DES";
    private  static String ENCODE = "GBK";
    private  static String defaultKey = "x1EL7tEKjizKZEl5g6PGUJ9ewnHQca8yvQS9X1EWL9gPkCevCd00xM49wIKfSKGdX1TGLkY2vyTp2I5XRUa8GLifQN4Q2TAHm3EQckCdYuGtOruy82OdcSNnIRwEQZcX";
    
    /*
    public encryptUtils() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException{  
        Security.addProvider(new com.sun.crypto.provider.SunJCE());  
        //ʵ����֧��DES�㷨����Կ������(�㷨���������谴�涨�������׳��쳣) 
        
        keygen = KeyGenerator.getInstance("DES");  
        //������Կ  
        keygen.init(56);
        deskey = keygen.generateKey();
        //����Cipher����,ָ����֧�ֵ�DES�㷨  
        c = Cipher.getInstance("DES");
       
        //byte[] encoded = deskey.getEncoded();  
        //String encodeHexString = Hex.toHexString(encoded);  
        //System.out.println(encodeHexString);
        
    }  */
      
    /** 
     * ���ַ������� 
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
        // ������Կ����Cipher������г�ʼ����ENCRYPT_MODE��ʾ����ģʽ  
        c.init(Cipher.ENCRYPT_MODE, deskey);  
        byte[] src = str.getBytes();  
        // ���ܣ���������cipherByte  
        cipherByte = c.doFinal(src);  
        return cipherByte;  
    }  */
  
    /** 
     * ���ַ������� 
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
        // ������Կ����Cipher������г�ʼ����DECRYPT_MODE��ʾ����ģʽ  
        c.init(Cipher.DECRYPT_MODE, deskey);  
        cipherByte = c.doFinal(buff);  
        return cipherByte;  
    }  */
  
    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // ����һ�������ε������Դ
        SecureRandom sr = new SecureRandom();

        // ��ԭʼ��Կ���ݴ���DESKeySpec����
        DESKeySpec dks = new DESKeySpec(key);

        // ����һ����Կ������Ȼ��������DESKeySpecת����SecretKey����
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher����ʵ����ɼ��ܲ���
        Cipher cipher = Cipher.getInstance(DES);

        // ����Կ��ʼ��Cipher����
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
        // ����һ�������ε������Դ
        SecureRandom sr = new SecureRandom();

        // ��ԭʼ��Կ���ݴ���DESKeySpec����
        DESKeySpec dks = new DESKeySpec(key);

        // ����һ����Կ������Ȼ��������DESKeySpecת����SecretKey����
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher����ʵ����ɽ��ܲ���
        Cipher cipher = Cipher.getInstance(DES);

        // ����Կ��ʼ��Cipher����
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
    	
        String msg ="����";
        byte[] encontent = de1.Encrytor(msg);  
        byte[] decontent = de1.Decryptor(encontent); 
        System.out.println("������:" + msg);  
        System.out.println("���ܺ�:" + new String(encontent));  
        System.out.println("���ܺ�:" + new String(decontent));  
     */
    	
        String data = "����ss����ss����ss����ss����ss����ss����ss����ss";
        System.out.println(encrypt(data));
       //System.out.println(decrypt("EuiST74Maur8PdizFYtyil3FBTx5sfGsWuiST74Maur8PdizFYtyil3FB5x5sfGslKka1CoD+Eo="));
        System.out.println(decrypt(encrypt(data)));
    }  
}
