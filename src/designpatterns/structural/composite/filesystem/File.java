package designpatterns.structural.composite.filesystem;

public class File implements FileSystemComponent {

    private final String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.printf("File: %s\n", name);
    }
}
