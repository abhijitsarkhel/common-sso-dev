package in.indigenous.sso.security.crypto;

import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Component;

@Component
public class AESEncoderDecoder implements EncoderDecoder {

	private String salt;

	private SecretKey secretKey;

	private byte[] ivBytes;

	private static final int ITERATIONS = 65536;

	private static final int KEY_SIZE = 256;

	private static final String PADDING = "AES/CBC/PKCS5Padding";

	private static final String ENCRYPTION_METHOD = "AES";

	private static final String RANDOM_SALT_METHOD = "SHA1PRNG";

	private static final String FACTORY_INSTANCE = "PBKDF2WithHmacSHA1";

	@Override
	public String encode(CharSequence rawPassword) {
		try {
			salt = getSalt();
			byte[] saltBytes = salt.getBytes();
			SecretKeyFactory skf = SecretKeyFactory.getInstance(FACTORY_INSTANCE);
			PBEKeySpec spec = new PBEKeySpec(rawPassword.toString().toCharArray(), saltBytes, ITERATIONS, KEY_SIZE);
			secretKey = skf.generateSecret(spec);
			SecretKeySpec secretSpec = new SecretKeySpec(secretKey.getEncoded(), ENCRYPTION_METHOD);
			Cipher cipher = Cipher.getInstance(PADDING);
			cipher.init(Cipher.ENCRYPT_MODE, secretSpec);
			AlgorithmParameters params = cipher.getParameters();
			ivBytes = params.getParameterSpec(IvParameterSpec.class).getIV();
			byte[] encryptedTextBytes = cipher.doFinal(String.valueOf(rawPassword).getBytes("UTF-8"));
			return DatatypeConverter.printBase64Binary(encryptedTextBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		try {
			byte[] encryptedTextBytes = DatatypeConverter.parseBase64Binary(new String(encodedPassword));
			SecretKeySpec secretSpec = new SecretKeySpec(secretKey.getEncoded(), ENCRYPTION_METHOD);
			Cipher cipher = Cipher.getInstance(PADDING);
			cipher.init(Cipher.DECRYPT_MODE, secretSpec, new IvParameterSpec(ivBytes));
			byte[] decryptedTextBytes = null;
			decryptedTextBytes = cipher.doFinal(encryptedTextBytes);
			return new String(decryptedTextBytes).equals(rawPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private String getSalt() throws NoSuchAlgorithmException {
		SecureRandom sr = SecureRandom.getInstance(RANDOM_SALT_METHOD);
		byte[] salt = new byte[20];
		sr.nextBytes(salt);
		return new String(salt);
	}

}
