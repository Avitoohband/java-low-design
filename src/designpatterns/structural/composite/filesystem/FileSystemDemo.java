package designpatterns.structural.composite.filesystem;

public class FileSystemDemo {
    public static void main(String[] args) {
        FileDirectory dir1 = new FileDirectory("C");
        FileDirectory dir2 = new FileDirectory("Avi");
        FileDirectory dir3 = new FileDirectory("Documents");
        File file1 = new File("text1.txt");
        File file2 = new File("text2.txt");

        dir1.addChild(file1);
        dir1.addChild(dir2);
        dir2.addChild(dir3);
        dir3.addChild(file2);

        dir1.print();
    }
}
