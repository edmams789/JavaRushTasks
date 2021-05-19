package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
Обеспечь возможность клонирования объекта класса Solution используя глубокое клонирование.
Данные в карте users также должны быть клонированы.
Не забудь о методах equals и hashCode для корректного добавления элементов типа User в HashMap.


Требования:
1. Класс Solution должен поддерживать интерфейс Cloneable.
2. Класс User должен поддерживать интерфейс Cloneable.
3. В классе User должен быть корректно реализован метод clone.
4. В классе Solution должен быть корректно реализован метод clone.
*/
public class Solution implements Cloneable {

    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));

        Solution clone = new Solution();

        clone = (Solution) solution.clone();

        System.out.println(solution);
        System.out.println(clone);

        System.out.println(solution.users);
        System.out.println(clone.users);
    }

    protected Map<String, User> users = new LinkedHashMap<>();

        @Override
    protected Solution clone() {
    Solution solution = new Solution();
    for (Map.Entry<String, User> pair : users.entrySet()){
        solution.users.put(pair.getKey(), pair.getValue());
    }
    return solution;
}
    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

//        public Object clone() {
//            User user = new User(age, name);
//            user.age = age;
//            user.name = name;
//            return user;
//        }
        @Override
    protected User clone() throws CloneNotSupportedException {
    return (User) super.clone();
}
    }


    }
//    protected Solution clone() throws CloneNotSupportedException {
//        Solution solution = new Solution();
//        for (Map.Entry<String, User> pair: users.entrySet()) {
//            solution.users.put(pair.getKey(), pair.getValue());
//        }
//        return solution;
//    }
//
//    protected User clone() throws CloneNotSupportedException {
//        return (User)super.clone();
//    }

//class B implements Cloneable {
//   @Override
//   protected Object clone() throws CloneNotSupportedException {
//      return super.clone();
//   }
//}
//
//class A implements Cloneable {
//    private List<B> list = new ArrayList<>();
//
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//       A clone = (A) super.clone();
//       clone.list = new ArrayList<>(list.size());
//       for (B b : list)
//           clone.list.add((B) b.clone());
//
//       return clone;
//    }
//}