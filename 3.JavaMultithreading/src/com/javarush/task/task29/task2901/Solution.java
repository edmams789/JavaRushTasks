package com.javarush.task.task29.task2901;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

/* 
Рефакторинг в соответствии с Naming and Code Convention
Исправить код в соответствии с Naming and Code Convention (Shift+F6 для рефакторинга).

Требования:
1. Переименуй константу defaultFileName в соответствии с Naming and Code Convention.
2. Переименуй метод getFileLoaded() в соответствии с Naming and Code Convention.
3. Переименуй метод DownloadFileContent() в соответствии с Naming and Code Convention.
4. Переименуй метод isexpectedline() в соответствии с Naming and Code Convention.
5. Переименуй параметр expectedline метода принимающего String в соответствии с Naming and Code Convention.
*/
public class Solution {
    public static final String DEFAULT_FILE_NAME = "C:/tmp/strange_file_name.tmp";

    private final String localFileName;
    private List<String> contentAslines;
    private boolean fileLoaded;

    public Solution(String firstFileName) {
        localFileName = firstFileName == null ? DEFAULT_FILE_NAME : firstFileName;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = Solution.class.getResource("Solution.java").getPath();

        Solution solution = new Solution(fileName);
        solution.downloadFileContent();
        if (solution.isFileLoaded()) {
            System.out.println(solution.hasExpectedLine("public class Solution {"));   // Expected true
            System.out.println(solution.hasExpectedLine(" public class Solution {"));  // Expected false
        }
    }

    public boolean isFileLoaded() {
        return fileLoaded;
    }

    public void downloadFileContent() {
        try {
            contentAslines = Files.readAllLines((new File(localFileName)).toPath(), Charset.defaultCharset());
            fileLoaded = true;
        } catch (IOException e) {
            System.out.println("Unsuccessful. What a surprise!");
        }
    }

    public boolean hasExpectedLine(String expectedLine) {
        return contentAslines.contains(expectedLine);
    }
}
//не оч понял почему в случае с boolean в первом случае is, а во втором has.

//В случае isfileexpectedline
//has - это глагол "иметь" приминим к существительным-объектам, таким как FileExpectedLine - это обьъект. Все существительные-объекты снабжаются  has.
//
//В случае isLoaded
//is - это существительное-объект применим к глаголам таким как Loaded. Loaded это настоящее завершонное
// время он похож на существительное но всё таки глагол.
//
//Если написать isfileexpectedline мы ставим два существительных вместе, что есть нонсенс.
// Аналогично hasLoaded два глагола в кучке.
//
//Так же и в русском языке. Для формирования предложения нужно подлежащее и сказуемое, тоесть существительное
// и глагол. из двух глаголов и существительных в одном предложении смысла связать не получится.