package groovy

public class jar {

    static public run () {
        String sourceFileName = "assert/电影.txt"

        URL fileURL =  this.getClass().getResource(sourceFileName)
        println(fileURL)
        println(this.class.getResource(""))
//        File fd = new File(sourceFileName)

//        println(fd.readLines())
    }
}

