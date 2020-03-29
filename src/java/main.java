package java;

import java.net.URL;

public class main {

        static public void run () {
            String sourceFileName = "assert/电影.txt";

//            URL fileURL =  this.getClass().getResource(sourceFileName);
//            System.out.println(fileURL);
            System.out.println(main.class.getResource(""));
            System.out.println(main.class.getResource("/"));
//        File fd = new File(sourceFileName)

//        println(fd.readLines())
        }



}
