package myjava;


import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipCompressJava {
    public static void main(String[] args) throws IOException {
        String data1 = "123412333333";
        System.out.println(data1);
        String de = decompresss(data1);
        System.out.println(de);

        String out = compress(de);
        System.out.println(out);

    }

    public static final String compress(String str) throws IOException {
        ByteArrayOutputStream out = null;
        ZipOutputStream zout = null;
        byte[] compressed = null;

        out = new ByteArrayOutputStream();
        zout = new ZipOutputStream(out);
        zout.write(str.getBytes());
        zout.closeEntry();
        compressed = out.toByteArray();
        out.close();
        zout.close();
        return  Base64.encodeBase64String(compressed);
    }

    public static final String decompresss(String str) throws IOException {
        byte[] compressed = Base64.decodeBase64(str);

        ByteArrayOutputStream out = null;
        ByteArrayInputStream inb = null; // todo in -> inb
        ZipInputStream zin = null;
        String decompressed = null;

        out = new ByteArrayOutputStream();
        inb = new ByteArrayInputStream(compressed);
        zin = new ZipInputStream(inb);
        ZipEntry entry = zin.getNextEntry();
        byte[] buffer = new byte[1024];
        int offset = -1;
        while ( (offset = zin.read(buffer)) != -1 ) {
            out.write(buffer, 0, offset);
        }
        decompressed = out.toString();

        out.close();
        inb.close();
        zin.close();

        return decompressed;
    }
}
