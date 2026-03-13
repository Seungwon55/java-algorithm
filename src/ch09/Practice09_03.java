package ch09;

public class Practice09_03 {
    public static void main(String[] args) {
        String fullPath = "c:\\jdk1.8\\work\\PathSeparateTest.java";
        String path = "";
        String fileName = "";

        int separate = fullPath.lastIndexOf("\\");   // path, fileName 분리할 index
        path = fullPath.substring(0, separate);
        fileName = fullPath.substring(separate + 1);

        System.out.println("fullPath : " + fullPath);
        System.out.println("path = " + path);
        System.out.println("fileName = " + fileName);
    }
}
