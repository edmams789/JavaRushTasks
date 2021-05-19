package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.FileVisitResult.CONTINUE;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    //2. В классе SearchFileVisitor нужно создать поле foundFiles и геттер для него. Поле должно быть
//сразу инициализировано.
    private List<Path> foundFiles = new ArrayList<>();

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
    //1. В классе SearchFileVisitor нужно создать поля partOfName, partOfContent, minSize, maxSize
//и сеттеры для них.
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;

    public SearchFileVisitor() {
        this.partOfName = null;
        this.partOfContent = null;
        this.minSize = 0;
        this.maxSize = 0;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        String strContent = new String(content);
        boolean isFounded = true;
        if (partOfName != null)
            isFounded = file.getFileName().toString().contains(partOfName);
        if (partOfContent != null && isFounded)
            isFounded = strContent.contains(partOfContent);
        if (maxSize != 0 && minSize != 0 && isFounded)
            isFounded = (long) content.length < maxSize && (long) content.length > minSize;
        else if (maxSize != 0 && isFounded)
            isFounded = (long) content.length < maxSize;
        else if (minSize != 0 && isFounded)
            isFounded = (long) content.length > minSize;
        if (isFounded)
            foundFiles.add(file);
        return super.visitFile(file, attrs);
    }
}