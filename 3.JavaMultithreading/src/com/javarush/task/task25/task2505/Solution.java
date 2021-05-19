package com.javarush.task.task25.task2505;

/* 
Без дураков
1. Создай private class MyUncaughtExceptionHandler, который на перехват исключения должен подождать
половину секунды, а затем вывести на экран secretKey, имя трэда и сообщение возникшего исключения.
Используй String.format(...).

Пример:
super secret key, Thread-0, it's an example

2. Разберись в последовательности выполняемого кода и обеспечь логирование возникновения исключения в п.1.
3. Метод main в тестировании не участвует.

Требования:
1. Создай private class MyUncaughtExceptionHandler с конструктором по-умолчанию в классе MyThread.
2. Во время перехвата исключения, MyUncaughtExceptionHandler должен вызвать Thread.sleep(500).
3. Затем, MyUncaughtExceptionHandler должен выводить в консоль secretKey, имя трэда и сообщение
возникшего исключения.
4. Для вывода сообщения используй String.format(...).
5. Нужно обеспечить логирование возникновения исключения.
*/
//public class DumpTest {
public class Solution {
//  public static void main(final String args[]) throws Exception {
    public static void main(String[] args) {
//    Thread.UncaughtExceptionHandler handler = new StackWindow("Show Exception Stack", 400, 200);
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            //public void setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            setDaemon(true);
        }
        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }
        private class MyUncaughtExceptionHandler {
            public void setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler eh) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e){

                }
            }


        }

    }

}

//public class DumpTest {
//  public static void main(final String args[]) throws Exception {
//    Thread.UncaughtExceptionHandler handler = new StackWindow("Show Exception Stack", 400, 200);
//    Thread.setDefaultUncaughtExceptionHandler(handler);
//    new Thread() {
//      public void run() {
//        System.out.println(1 / 0);
//      }
//    }.start();
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    System.out.print("Press Enter for next exception");
//    br.readLine();
//    new Thread() {
//      public void run() {
//        System.out.println(args[0]);
//      }
//    }.start();
//    System.out.print("Press Enter to end");
//    br.readLine();
//    System.exit(0);
//  }
//}