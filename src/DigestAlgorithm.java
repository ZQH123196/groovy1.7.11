import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestAlgorithm {
    public static byte[] digest(String hashAlgorithm,byte[] input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(hashAlgorithm);
        md.update(input);
        return md.digest();
    }

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String data = "摘要算法测试";
        byte[] r1 = digest("MD5", data.getBytes("UTF-8"));
        byte[] r2 = digest("SHA-1", data.getBytes("UTF-8"));
        byte[] r3 = digest("SHA-256", data.getBytes("UTF-8"));

        // sha1 输出 20 个字节
        System.out.println(String.format("MD5 %d 字节:[%x]", r1.length, new BigInteger(1, r1)));
        System.out.println(String.format("SHA-1 %d 字节:[%x]", r2.length, new BigInteger(1, r2)));
        System.out.println(String.format("SHA-256 %d 字节:[%x]", r3.length, new BigInteger(1, r3)));
    }

}
