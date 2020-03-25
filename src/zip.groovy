import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


class ZipCompress
{
    private String zipFileName;      // 目的地Zip文件
    private String sourceFileName;   //源文件（带压缩的文件或文件夹）

    public ZipCompress(String zipFileName,String sourceFileName)
    {
        this.zipFileName=zipFileName;
        this.sourceFileName=sourceFileName;
    }

    public void zip() throws Exception
    {
        //File zipFile = new File(zipFileName);
        System.out.println("压缩中...");

        //创建zip输出流
//        ZipOutputStream out = new ZipOutputStream( new FileOutputStream(zipFileName));
        ZipOutputStream out = new ZipOutputStream( new BufferedOutputStream( new FileOutputStream(zipFileName) ) )
        File sourceFile = new File(sourceFileName);

        //调用函数
        compress(out, sourceFile, sourceFile.getName());

        out.close();
        System.out.println("压缩完成");

    }

    public void compress(ZipOutputStream out,File sourceFile,String base) throws Exception
    {
        //如果不是目录（文件夹），即为文件，则先写入目录进入点，之后将文件写入zip文件中
        if(sourceFile.isFile()) {
            out.putNextEntry( new ZipEntry(base) );
            BufferedInputStream bis = new BufferedInputStream( new FileInputStream(sourceFile) );

            System.out.println(base);
            byte[] bytes = new byte[1024];
            int length;
            while(( length = bis.read(bytes) )!=-1) {
                out.write(bytes, 0, length);
            }
            bis.close();

        }
    }
}

sourceFileName = "./src/assert/电影.txt"
zipFilename = "./src/assert/电影.zip"
ZipCompress zipCom = new ZipCompress(zipFilename,sourceFileName);

try{
    zipCom.zip();
}
catch(Exception e){
    e.printStackTrace();
}
