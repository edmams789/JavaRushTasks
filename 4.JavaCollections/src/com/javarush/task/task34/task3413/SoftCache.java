package com.javarush.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/*
Кеш на основании SoftReference
Реализуй логику методов get, put, remove класса SoftCache:

Метод AnyObject get(Long key) должен возвращать объект типа AnyObject из мапы cacheMap по ключу key.
Если такого ключа в cacheMap нет - верни null.

Метод AnyObject put(Long key, AnyObject value) должен добавлять в мапу пару key : value.
Метод должен вернуть null, если в cacheMap по такому ключу ранее не было значения.
Иначе - верни предыдущее значение value по этому ключу.
Не забудь вызвать метод clear() у объекта типа SoftReference<AnyObject>.

Метод AnyObject remove(Long key) должен удалить из мапы cacheMap пару key : value по ключу key.
Метод должен вернуть null, если в cacheMap по такому ключу ранее не было значения.
Иначе - верни предыдущее значение value по этому ключу.
Не забудь вызвать метод clear() у объекта типа SoftReference<AnyObject>.

Не изменяй класс AnyObject.
Метод main не принимает участия в тестировании.


Требования:
1. Класс AnyObject не должен быть изменен.
2. В классе SoftCache должно существовать приватное поле Map<Long, SoftReference<AnyObject>> cacheMap.
3. Реализуй метод get согласно условию.
4. Реализуй метод put согласно условию.
5. Реализуй метод remove согласно условию.
*/
public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.get(key);

        //напишите тут ваш код
        return cacheMap.get(key) == null ? null : softReference.get();
    }

    public AnyObject put(Long key, AnyObject value) {
        SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));
        if (cacheMap.get(key) == null) {
            return null;
        }
        AnyObject anyObjectResult = softReference.get();
            //напишите тут ваш код
            softReference.clear();
            return softReference.get();

    }

    public AnyObject remove(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.remove(key);
        if (cacheMap.get(key) == null) {
            return null;
        }
        AnyObject anyObjectResult = softReference.get();
        //напишите тут ваш код
        softReference.clear();
        return softReference.get();
    }
}
/*
Сделал, но не понял...

В методе get ( ) проверяем softReference на null. Если не равен - возвращаем softReference.get().
Иначе возвращаем null.
В методе put ( ) так же проверяем softReference на null. Если не равен - создаем объект типа AnyObject и
передаем туда значение из softReference. Потом очищаем softReference и возвращаем объект типа AnyObject.
Иначе возвращаем null.

В методе remove ( ) все делаем аналогично методу put ( ).
 */
/*
Для тех кто не понял зачем задача: попробуйте проверить размер cachemap после цикла, попробуйте удалить или добавить новый объект.
А теперь создайте в main обычный hashmap и попытайтесь его заполнить в аналогичном цикле, не выйдет, потому что выкинет исключение.... угадайте какое.
 В случае с нашим cachemap все в порядке, сколько бы памяти под JVM мы не выставляли- программа завершается корректно, все из за того, что GC во время успевает подчистить память по мягким ссылкам.
Чтобы это проверить попробуйте поставить память для программы поменьше, например я сделал такие: -Xms256m -Xmx512m
В итоге цикл завершился корректно и размер cachemap, как и положено 2_500_000 элементов. Однако когда я захотел просмотреть по ключу нужный мне Anyobject, я получил null. Так как объекты были удалены GC, чтобы выделить память. Вот вам и временное хеширование.
Вообщем лучше сами разберитесь, чем читать мой коммент.


Естественно не все объекты будут удалены, если будет не хватать памяти, а только часть. Зависит от того как мало памяти вы выделите под приложение.
Какие объекты остались можно просмотреть в цикле:
for (long i = 0; i < 2_500_000; i++) {
          System.out.println(cache.get(i));
      }


Чтобы посмотреть сколько памяти было занято программой, в конце:
MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
 System.out.println(memoryBean.getHeapMemoryUsage().getUsed()/1024);

 Там же есть метод- посмотреть сколько всего памяти под JVM.
 */