
import org.apache.commons.codec.binary.Base64

import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// 正则匹配

sourceFileName = "./src/assert/电影.txt"

File sourceFile = new File(sourceFileName);
//FileInputStream fis = new FileInputStream(sourceFile);
BufferedReader bfr = new BufferedReader( new FileReader(sourceFile) );
StringBuffer sbf = new StringBuffer();
String tmpStr = null;
while ( ( tmpStr = bfr.readLine() ) != null ) {
    sbf.append(tmpStr);
}


String inCompressStr = sbf.toString(); // 还要去 \r\n
println("inCompressStr:[$inCompressStr]")

ByteArrayOutputStream out = new ByteArrayOutputStream();

ZipOutputStream zipOut = new ZipOutputStream( out );
// 写入数据以及 zip 的头尾
zipOut.putNextEntry(new ZipEntry("0"));
zipOut.write(inCompressStr.getBytes());
zipOut.closeEntry();
// 数据已经写入 out
byte[] compressedData = out.toByteArray();

out.close();
zipOut.close()

Base64.encodeBase64String(compressedData);
