package com.javarush.task.task22.task2201;

/*
Строки нитей или строковые нити? Вот в чем вопрос
1. Метод getPartOfString должен возвращать подстроку между первой и последней табуляцией.
2. На некорректные данные getPartOfString должен бросить исключение:
а) StringForFirstThreadTooShortException, если имя трэда FIRST_THREAD_NAME.
б) StringForSecondThreadTooShortException, если имя трэда SECOND_THREAD_NAME.
в) RuntimeException в других случаях.
3. Реализуйте логику трех protected методов в OurUncaughtExceptionHandler используя вызовы
соответствующих методов согласно следующим шаблонам:
a) 1# : StringForFirstThreadTooShortException : java.lang.StringIndexOutOfBoundsException:
String index out of range: -1
б) java.lang.StringIndexOutOfBoundsException: String index out of range: -1 :
StringForSecondThreadTooShortException : 2#
в) RuntimeException : java.lang.StringIndexOutOfBoundsException: String index out of range: -1 : 3#

Требования:
1. Метод getPartOfString() должен возвращать подстроку между первой и последней табуляцией строки
string переданной ему в качестве первого параметра.
2. В случае некорректных данных метод getPartOfString() должен бросить исключение
StringForFirstThreadTooShortException, если имя трэда(threadName) Solution.FIRST_THREAD_NAME.
3. В случае некорректных данных метод getPartOfString() должен бросить исключение
StringForSecondThreadTooShortException, если имя трэда(threadName) Solution.SECOND_THREAD_NAME.
4. В случае некорректных данных метод getPartOfString() должен бросить исключение RuntimeException,
если имя трэда(threadName) не Solution.FIRST_THREAD_NAME или Solution.SECOND_THREAD_NAME.
5. Метод getFormattedStringForFirstThread() должен возвращать строку сформированную из переданных
параметров по шаблону указанному в задании.
6. Метод getFormattedStringForSecondThread() должен возвращать строку сформированную из переданных
параметров по шаблону указанному в задании.
7. Метод getFormattedStringForOtherThread() должен возвращать строку сформированную из переданных
параметров по шаблону указанному в задании.
*/
public class Solution {
    public static void main(String[] args) {
        new Solution();
    }

    public static final String FIRST_THREAD_NAME = "1#";
    public static final String SECOND_THREAD_NAME = "2#";

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public Solution() {
        initThreads();
    }

    protected void initThreads() {
        this.thread1 = new Thread(new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(new Task(this, "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(new Task(this, "\t\t"), "3#");

        Thread.setDefaultUncaughtExceptionHandler(new OurUncaughtExceptionHandler());

        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }

    public synchronized String getPartOfString(String string, String threadName) {

        int first = string.indexOf('\t');
        int last = string.lastIndexOf('\t');

        String substr = null;

        try {
            substr = string.substring(first + 1, last);
        } catch (StringIndexOutOfBoundsException e) {
            switch (threadName) {
                case FIRST_THREAD_NAME:
                    StringForFirstThreadTooShortException ex1 = new StringForFirstThreadTooShortException();
                    ex1.initCause(e);
                    throw ex1;
                case SECOND_THREAD_NAME:
                    StringForSecondThreadTooShortException ex2 = new StringForSecondThreadTooShortException();
                    ex2.initCause(e);
                    throw ex2;
                default:
                    RuntimeException ex3 = new RuntimeException();
                    ex3.initCause(e);
                    throw ex3;
            }
        }
        return substr;
    }
}
//как получить имя класса пойманного исключения?
//e.getClass().getSimpleName()

//Да, это жестко. Вот полезные статьи, необходимые для решения:
//1) Сцепленные исключения http://www.linkex.ru/java/linked-exception.php
//2) Перехват необрабатываемых исключений http://javatutor.net/articles/catching-uncaught-exceptions
//Если не поможет - внизу есть чудный совет по решению от Валидатора.
//Действительно очень помогает понять суть происходящего.