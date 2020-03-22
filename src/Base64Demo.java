import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Demo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String data = "\u00ff编码测试";
        String b64 = Base64.getEncoder().encodeToString(data.getBytes("UTF-8"));
        System.out.println(b64);
        String decodeData = new String(Base64.getDecoder().decode(b64));
        System.out.println(decodeData);
    }
}
