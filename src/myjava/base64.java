package myjava;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;

import java.io.UnsupportedEncodingException;

public class base64 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String testbase64 = "1郑启华";
        byte[] bList1 = Base64.decodeBase64(testbase64);

        for(Object b : bList1) {
            System.out.println(b);
        }





        byte[] blist3 = StringUtils.getBytesUtf8(testbase64);
//        for(Object b : blist3) {
//            System.out.println(b);
//        }
    }
}
