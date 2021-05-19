package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush.
Метод main реализован только для вас и не участвует в тестировании.

Требования:
1. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае,
если список users пустой.
2. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае,
если список users не пустой.
3. Класс Solution.JavaRush не должен поддерживать интерфейс Serializable.
4. Класс Solution.JavaRush должен быть публичным.
5. Класс Solution.JavaRush не должен поддерживать интерфейс Externalizable.
*/
public class Solution {
    public static void main(String[] args) {
//you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream
// according to your file's actual location
//вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream
// в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
//initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут



            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object
            // - проверьте тут, что javaRush и loadedObject равны
if (loadedObject.equals(javaRush)) System.out.println("javaRush и loadedObject равны");
else System.out.println("javaRush и loadedObject не равны");
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            for(User user:users){
                writer.write(user.getFirstName() == null? "null" : user.getFirstName());
                writer.write(";");
                writer.write(user.getLastName() == null? "null" : user.getLastName());
                writer.write(";");
                writer.write(user.getBirthDate() == null? "null" : Long.toString(user.getBirthDate().getTime()));
                writer.write(";");
                writer.write(Boolean.toString(user.isMale()));
                writer.write(";");
                writer.write(user.getCountry() == null? "null" : user.getCountry().getDisplayName());
                writer.write("\n");
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String currentLine;
            User currentUser;
            while (reader.ready()){
                currentLine = reader.readLine();
                String[] str = currentLine.split(";");
                currentUser = new User();
                if(!str[0].equals("null")) currentUser.setFirstName(str[0]);
                if(!str[1].equals("null")) currentUser.setLastName(str[1]);
                if(!str[2].equals("null")) currentUser.setBirthDate(new Date(Long.parseLong(str[2])));
                currentUser.setMale(Boolean.parseBoolean(str[3]));
                switch (str[4]){
                    case "Ukraine": currentUser.setCountry(User.Country.UKRAINE); break;
                    case "Russia":  currentUser.setCountry(User.Country.RUSSIA);  break;
                    case "Other":   currentUser.setCountry(User.Country.OTHER);   break;
                }
                this.users.add(currentUser);
            }
        }

//        public void save(OutputStream outputStream) throws Exception {
//            //implement this method - реализуйте этот метод
//            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
//            if (users != null){
//            for (User user : users){
//                writer.write(user.getFirstName() != null ? user.getFirstName() : "null");
//                writer.write(user.getLastName() != null ? user.getLastName() : "null");
//                writer.write(user.getBirthDate() != null ? Long.toString(user.getBirthDate().getTime()) : "null");
//                writer.write(Boolean.toString(user.isMale()));
//                writer.write(user.getCountry() != null ? user.getCountry().getDisplayName() : "null");
//            }
//        }
//            writer.flush();
//        }
//        public void load(InputStream inputStream) throws Exception {
//            //implement this method - реализуйте этот метод
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//            if (users != null){
//                while (reader.ready()){
//                    User user = new User();
//                    user.setFirstName(reader.readLine());
//                    user.setLastName(reader.readLine());
//                    user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
//                    user.setMale(Boolean.parseBoolean(reader.readLine()));
//
//                    String str = reader.readLine();
//                    if (str.equals("Ukraine")){ user.setCountry(User.Country.UKRAINE);}
//                  //  if (str.equals("Ukraine")){ user.setCountry(User.Country.valueOf(reader.readLine()));}
//                    if (str.equals("Russia")){ user.setCountry(User.Country.RUSSIA);}
//                  //  if (str.equals("Russia")){ user.setCountry(User.Country.valueOf(reader.readLine()));}
//                    if (str.equals("Other")){ user.setCountry(User.Country.OTHER);}
//                  //  if (str.equals("Other")){ user.setCountry(User.Country.valueOf(reader.readLine()));}
//                    users.add(user);
//                }
//                  reader.close();
//            }
//        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;
        }
        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
//Реализация чтения, может кому поможет:
//            if (users != null) {
//                while (reader.ready()) {
//                    User user = new User();
//                    user.setFirstName(reader.readLine());
//                    user.setLastName(reader.readLine());
//                    user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
//                    user.setMale(Boolean.parseBoolean(reader.readLine()));
//                    String str = reader.readLine();
//                    if (str.equals("Ukraine")) { user.setCountry(User.Country.UKRAINE); }
//                    if (str.equals("Russia")) { user.setCountry(User.Country.RUSSIA); }
//                    if (str.equals("Other")) { user.setCountry(User.Country.OTHER);  }
//
//                    users.add(user);
//                }
//                    reader.close();
//                }
//            }

//Правило:
//Date всегда save/load в long(миллисекунды)
//.getTime();
//
//            User user = new User();
//            user.setFirstName("Rubi");
//            user.setLastName("Rail");
//            user.setBirthDate(new Date(1508944516168L));
//            user.setMale(true);
//            user.setCountry(User.Country.OTHER);
//
//            User user1 = new User();
//            user1.setFirstName("Vasa1");
//            user1.setLastName("Peta1");
//            user1.setBirthDate(new Date(1508944516163L));
//            user1.setMale(true);
//            user1.setCountry(User.Country.RUSSIA);
//
//            User user3 = new User();
//            user3.setFirstName("Solo");
//            user3.setLastName("Han");
//            user3.setBirthDate(new Date(1508944516169L));
//            user3.setMale(true);
//            user3.setCountry(User.Country.UKRAINE);