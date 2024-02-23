package designpatterns.structural.composite.filesystem;

import java.util.ArrayList;
import java.util.List;

public class FileDirectory implements FileSystemComponent {
    private final String name;
    private List<FileSystemComponent> children;

    public FileDirectory(String name) {
        this.name = name;
        children = new ArrayList<>();
    }

    public void addChild(FileSystemComponent child) {
        children.add(child);
    }

    @Override
    public void print() {
        System.out.printf("Directory: %s\n", name);
        for (FileSystemComponent child : children) {
            child.print();
        }
        System.out.println();
    }
}
