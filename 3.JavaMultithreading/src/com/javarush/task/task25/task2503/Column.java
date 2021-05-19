package com.javarush.task.task25.task2503;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public enum Column implements Columnable {
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
//4. Метод Column.configureColumns реализован. Менять его не нужно.
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке
     * (см. метод configureColumns)
     *
     * Используется поле realOrder.
     *
     * @return список колонок
     */

//5. Метод Column.getVisibleColumns должен возвращать список отображаемых колонок в скофигурированом порядке.
    public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();
        for (int i = 0; i < realOrder.length; i++){
            if (realOrder[i] != -1){
                result.add(Column.values()[i]);
            }
        }
        result.sort((column, t1) -> (realOrder[column.ordinal()] >= realOrder[t1.ordinal()])? 1: -1);
        return result;
    }
//6. Метод Column.getColumnName должен возвращать полное имя колонки.
    @Override
    public String getColumnName() {
        return columnName;
    }
//7. Метод Column.isShown должен возвращать true, если колонка видимая, иначе false.
    @Override
    public boolean isShown() {
        if (getVisibleColumns().contains(this)) {
            return true;
        }
        return false;
    }
//8. Метод Column.hide должен скрывать колонку и сдвигать индексы остальных отображаемых колонок.
    @Override
    public void hide() {
        realOrder[this.ordinal()] = -1; //new
        Column.getVisibleColumns();

    }
}
//public static List<Column> getVisibleColumns() {
//        List<Column> result = new LinkedList<>();
//        for (int i = 0; i < realOrder.length ; i++) {
//            if(realOrder[i] != -1)
//                result.add(Column.values()[i]);
//        }
//        result.sort((column, t1) -> (realOrder[column.ordinal()] >= realOrder[t1.ordinal()])? 1: -1);
//        return result;
//    }

//Вот мое мегарешение метода getVisibleColumns()! Никаких treeMap не надо)
//public static List<Column> getVisibleColumns() {
//        List<Column> result = new LinkedList<>();
//        for (int i = 0; i < realOrder.length; i++) {
//            if(realOrder[i] != -1) {
//                result.add(values()[i]);
//            }
//        }
//        result.sort(new Comparator<Column>() {
//            @Override
//            public int compare(Column o1, Column o2) {
//                if (realOrder[o1.ordinal()] > realOrder[o2.ordinal()]) { return 1; }
//                if (realOrder[o1.ordinal()] < realOrder[o2.ordinal()]) { return -1; }
//                else return 0;
//            }
//        });
//        return result;
//    }

//если перевести в лямбды, то еще короче и проще
//Collections.sort(result, Comparator.comparing(column -> realOrder[column.ordinal()]));

//Если еще есть силы, то подумайте над решением. Уж очень интересно.
//А если уже просто хочется решить - я накидал подсказок.
//
//Долго тупил над решением.
//Но когда прошел проверку - хочется забыть решение и поломать голову заново.
//Интересно было корректно реализовать метод hide()
//
//Подход такой:
//1. Имплментим что нужно.
//2. Реализовываем пустые методы.
//3. getVisibleColumns() реализовываем так, чтоб возвращал энумы в порядке переданном в configureColumns(). Как и другие комментаторы использовал TreeMap.
//Попробуйте поменять порядок переданных параметров, снова проверяем что возвращает  getVisibleColumns()
//Если все ок, тогда беремся за hide()
//4. В hide() просто выполняем метод configureColumns(), в параметры которого прокидываем  array из getVisibleColumns() с вычетом скрытой ячейки. Это и будет имитация удаления колонки.
//
//В требованиях написанно "hide() должен скрывать колонку и сдвигать индексы остальных отображаемых колонок." На самом деле метод configureColumns() и меняет индекс.
//
//5. Задача успешно прошла тестирование!

//Задача на внимательность. Но несложная. Обратите внимание, что getColumnName возвращает не name()
// и не toString(), а поле, которое инициализируется в конструкторе. А также на логику метода
// getVisibleColumns (видимые колонки должны быть расположены в списке в порядке,
// заданном в массиве realOrder).

//фух.....еле добил эту задачку. Кому она так же трудно дается(из-за уверений валидатора что
// с getVisibleColumns() все в порядке, а вот с hide() проблемы) хочу сказать что:
//1)в hide() достаточно лишь скрыть колонку, сдвигать ничего не надо!
//2)Лучше внимательно посмотреть что выводит программа, когда в realOrder больше чем одна скрытая колонка,
// и исправить ИМЕННО логику getVisibleColumns(), всем удачи!)

//Требования:
//1. Интерфейс Columnable менять нельзя.
//2. Класс Column должен реализовывать интерфейс Columnable.
//3. Создавать дополнительные поля в классе Column нельзя.

//@Override
//	public void hide() {
//		int i = this.ordinal();
//		realOrder[i] = -1;
//		Column.getVisibleColumns();
//	}

//Так короче:
//
//@Override
//public void hide()
//{
//    realOrder[(ordinal())] = -1;

//да, но так не работает

//"hide() должен скрывать колонку и сдвигать индексы остальных отображаемых колонок."
//
//Вот это я понимаю так: метод hide() в 2 строки выставляет -1 в realOrder после проверки что элемент
// isShown, соответственно после повторного запуска Column.getVisibleColumns(), в котором проверяется,
// что realOrder[i] != -1 колонка исчезает из заново созданного  List<Column> result (через TreeMap)
//И для верности надо потестить на удаление нескольких колонок.
//
//Решено с 1-й попытки, но сначала было все непонятно.
