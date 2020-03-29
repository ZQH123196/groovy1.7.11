
import org.apache.commons.codec.binary.Base64

import java.io.FileInputStream
import java.nio.file.attribute.FileTime
import java.util.concurrent.TimeUnit;
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
t = new ZipEntry("0")
t.setTime(10086);
fileTime = FileTime.fromMillis(10086L);
t.setCreationTime(fileTime);
t.setLastAccessTime(fileTime);
t.setLastModifiedTime(fileTime);


zipOut.putNextEntry(t);



//zipOut.write(inCompressStr.getBytes());

t.setTime(10086);
fileTime = FileTime.fromMillis(10086L);
t.setCreationTime(fileTime);
t.setLastAccessTime(fileTime);
t.setLastModifiedTime(fileTime);



zipOut.closeEntry();


//println(t.getLastModifiedTime())



// 数据已经写入 out
byte[] compressedData = out.toByteArray();

out.close();
zipOut.close()

result = Base64.encodeBase64String(compressedData);

println("[$result]")