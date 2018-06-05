package kh.com.khmerside.khmersideprocomm.crypto.assyncronous;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

public class KhmerSideRsaCipher {
private File privateKey;
	
	public KhmerSideRsaCipher(File privateKey) {
		this.privateKey=privateKey;
	}
	/**
	 * 
	 * @param cipherText
	 * @param transformation
	 * @param encoding 
	 * @return
	 * @throws IOException
	 * @throws GeneralSecurityException
	 */

	private final String decrypt(String cipherText, String transformation, String encoding) throws IOException, GeneralSecurityException {
		
		FileInputStream fileInputStream= new FileInputStream(privateKey);
    	    	
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(IOUtils.toByteArray(fileInputStream));
 
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(Cipher.DECRYPT_MODE, KeyFactory.getInstance("RSA").generatePrivate(pkcs8EncodedKeySpec));
        
        return new String(cipher.doFinal(Base64.decodeBase64(cipherText)), encoding);
    }
    
	/**
	 * 
	 * @param cipherText 
	 * @return Return original plain text if normal process, otherwise return error message
	 * @throws IOException
	 * @throws GeneralSecurityException
	 */
    public final String myDecrypt(String cipherText) throws IOException, GeneralSecurityException {
    	return decrypt(cipherText,"RSA/ECB/PKCS1Padding", "UTF-8");
    }
}
