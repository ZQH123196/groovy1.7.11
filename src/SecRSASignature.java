import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
public class SecRSASignature {
    PrivateKey sk;//定义私钥
    PublicKey pk;//定义公钥
    //构造方法1：获取公钥/私钥对
    public SecRSASignature() throws GeneralSecurityException{
        KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");//使用RSA
        kpGen.initialize(1024);//初始化为1024字节
        KeyPair kp = kpGen.generateKeyPair();//生成公钥、私钥
        this.sk = kp.getPrivate();
        this.pk = kp.getPublic();
    }
    //构造方法2：从保存的字节中提取公钥/私钥
    public SecRSASignature(byte[] pk,byte[] sk) throws GeneralSecurityException{
        KeyFactory kf = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec pkSpec = new X509EncodedKeySpec(pk);
        this.pk = kf.generatePublic(pkSpec);
        PKCS8EncodedKeySpec skSpec = new PKCS8EncodedKeySpec(sk);
        this.sk = kf.generatePrivate(skSpec);
    }
    //返回私钥的byte数组
    public byte[] getPrivateKey(){
        return this.sk.getEncoded();
    }
    //返回公钥的byte数组
    public byte[] getPublicKey(){
        return this.pk.getEncoded();
    }
    //获取签名
    public byte[] sign(byte[] message) throws GeneralSecurityException{
        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initSign(this.sk);
        signature.update(message);
        return signature.sign();
    }
    //传入message，使用公钥与签名sign进行校验
    public boolean verify(byte[] message,byte[] sign) throws GeneralSecurityException{
        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initVerify(this.pk);
        signature.update(message);
        return signature.verify(sign);
    }
    public static void main(String[] args) throws Exception{
        byte[] message = "Hello，使用SHA1withRSA算法进行数字签名".getBytes("utf-8");
        SecRSASignature rsas = new SecRSASignature();
        byte[] sign = rsas.sign(message);
        System.out.println("sign:"+ Base64.getEncoder().encodeToString(sign));
        //使用原有的message、sign进行校验
        boolean verified1 = rsas.verify(message,sign);
        System.out.println("verify:"+verified1);
        //创建新的SecRSASiginature对象，使用原有的sign与新对象进行校验
        boolean verified2 = new SecRSASignature().verify(message,sign);
        System.out.println("verfied with another public key:"+verified2);
        //修改message信息
        message[0]=100;
        boolean verifed3 = rsas.verify(message,sign);
        System.out.println("verified with changed message: "+verifed3);
    }
}