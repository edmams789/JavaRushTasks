package com.javarush.task.task35.task3513;

import java.util.*;

/*
2048 (16)
Осталось совсем немного! У нас есть способ вычислить эффективность любого хода, а также мы можем их сравнивать между собой.

Давай реализуем метод autoMove в классе Model, который будет выбирать лучший из возможных ходов и выполнять его.

Сделаем так:
1) Создадим локальную PriorityQueue с параметром Collections.reverseOrder() (для того, чтобы вверху очереди всегда был максимальный элемент) и размером равным четырем.
2) Заполним PriorityQueue четырьмя объектами типа MoveEfficiency (по одному на каждый вариант хода).
3) Возьмем верхний элемент и выполним ход связанный с ним.

После реализации метода autoMove добавим его вызов в метод keyPressed класса Controller по нажатию на клавишу A (код - KeyEvent.VK_A).

P.S. В качестве факультативного задания можешь почитать про указатели на методы и попробовать передать аргумент в метод getMoveEfficiency используя оператор "::". Для метода left должно получиться getMoveEfficiency(this::left). Альтернативно можешь использовать внутренний анонимный класс.


Требования:
1. В методе autoMove должен быть создан объект типа PriorityQueue с размером равным четырем.
2. В методе autoMove в PriorityQueue должно быть добавлено 4 объекта типа MoveEfficiency с помощью метода offer (по одному на каждый вариант хода).
3. Метод keyPressed класса Controller должен вызывать метод autoMove у модели в случае, если была нажата клавиша с кодом KeyEvent.VK_A.
4. В методе autoMove должен быть выполнен метод move связанный с объектом MoveEfficiency полученном с помощью метода peek или poll.
 */
public class Model { //Model - будет содержать игровую логику и хранить игровое поле.
//3.1. Приватная константа FIELD_WIDTH = 4, определяющая ширину игрового поля.
//В классе Model должно быть создано private static final поле FIELD_WIDTH со значением равным четырем.
    private static final int FIELD_WIDTH = 4;
//3.2. Приватный двумерный массив gameTiles состоящий из объектов класса Tile.
//В классе Model должно быть создано private поле gameTiles типа Tile[][].
//Массив gameTiles должен иметь размерность FIELD_WIDTH x FIELD_WIDTH.
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
//3.3. Конструктор без параметров инициализирующий игровое поле и заполняющий его пустыми плитками.
//Конструктор без параметров класса Model должен заполнять массив gameTiles новыми объектами типа Tile.
    public Model() {
        /*
P.S. Пожалуй стоит весь код из конструктора переместить в метод resetGameTiles, для того, чтобы при необходимости
начать новую игру, не приходилось создавать новую модель, а можно было бы просто вернуться в начальное состояние
вызвав его. Уровень доступа должен быть шире приватного.
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
После реализации функционала добавления новых плиток, добавим в конструктор два вызова метода addTile,
выполняя начальное условие задачи.
        addTile();
        addTile();
         */
//В конструкторе класса Model должен содержаться вызов метода resetGameTiles.
        resetGameTiles();
    }
//Также получение свободных плиток можно вынести в отдельный приватный метод getEmptyTiles, возвращающий список
//свободных плиток в массиве gameTiles.
//Метод getEmptyTiles должен возвращать список пустых плиток в массиве gameTiles.
    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTiles = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                Tile tile = gameTiles[i][j];
                if (tile.isEmpty()) emptyTiles.add(tile);
            }
        }
        return emptyTiles;
    }
//Предлагаю создать приватный метод addTile, который будет смотреть какие плитки пустуют и, если такие имеются,
//менять вес одной из них, выбранной случайным образом, на 2 или 4 (на 9 двоек должна приходиться 1 четверка).
//Метод addTile должен изменять значение случайной пустой плитки в массиве gameTiles на 2 или 4
// с вероятностью 0.9 и 0.1 соответственно.
    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (emptyTiles.size() != 0)
//Получить случайный объект из списка можешь использовав следующее выражение:
//(размерСписка * случайноеЧислоОтНуляДоЕдиницы).
            emptyTiles.get((int) (Math.random() * emptyTiles.size())).value
                    = ((Math.random() < 0.9) ? 2 : 4);
//Проверь, что метод addTile ничего не изменяет, если метод getEmptyTiles возвращает пустой список.
    }
    //Метод resetGameTiles должен заполнять массив gameTiles новыми плитками и менять значение двух из
// них с помощью двух вызовов метода addTile.
    public void resetGameTiles() {
//P.S. Пожалуй стоит весь код из конструктора переместить в метод resetGameTiles, для того, чтобы при необходимости
//начать новую игру, не приходилось создавать новую модель, а можно было бы просто вернуться в начальное состояние
//вызвав его. Уровень доступа должен быть шире приватного.
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
//Поля score и maxTile должны быть инициализированы нулем при создании новой модели.
        score = 0;
        maxTile = 0;
    }
//Для каждого ряда или столбца, происходят на самом деле две вещи:
//а) Сжатие плиток, таким образом, чтобы все пустые плитки были справа, т.е. ряд {4, 2, 0, 4} становится
//рядом {4, 2, 4, 0}
//б) Слияние плиток одного номинала, т.е. ряд {4, 4, 2, 0} становится рядом {8, 2, 0, 0}.
//Обрати внимание, что ряд {4, 4, 4, 4} превратится в {8, 8, 0, 0}, а {4, 4, 4, 0} в {8, 4, 0, 0}.
//Создай методы compressTiles(Tile[] tiles) и mergeTiles(Tile[] tiles), которые будут реализовывать
//пункты а) и б) соответственно. Использовать мы их будем только внутри класса Model, поэтому уровень
//доступа сделай максимально узким.
//Метод compressTiles должен быть реализован в соответствии с условием задачи.
//Метод compressTiles должен быть приватным.
    private boolean compressTiles(Tile[] tiles) {
//Метод compressTiles должен возвращать true в случае, если им были внесены изменения во входящий массив.
//Метод compressTiles должен возвращать false в случае, если им НЕ были внесены изменения во входящий массив.
        boolean compress = false;
        for (int i = 1; i < tiles.length; i++) {
            for (int j = 1; j < tiles.length; j++) {
                if (tiles[j - 1].isEmpty() && !tiles[j].isEmpty()) {
                    compress = true;
                    tiles[j - 1] = tiles[j];
                    tiles[j] = new Tile();
                }
            }
        }
        return compress;
    }
//P.S. Когда мы будем реализовывать методы движения, сжатие будет всегда выполнено перед слиянием,
//таким образом можешь считать, что в метод mergeTiles всегда передается массив плиток без пустых в середине.
//Метод mergeTiles должен быть реализован в соответствии с условием задачи.
//Метод mergeTiles должен быть приватным.
//Метод mergeTiles должен корректно обновлять значение поля score.
//Метод mergeTiles должен корректно обновлять значение поля maxTile.
    private boolean mergeTiles(Tile[] tiles) {
//3. Метод mergeTiles должен возвращать true в случае, если им были внесены изменения во входящий массив.
//4. Метод mergeTiles должен возвращать false в случае, если им НЕ были внесены изменения во входящий массив.
        boolean merge = false;
        for (int i = 1; i < tiles.length; i++) {
            if ((tiles[i - 1].value == tiles[i].value) && !tiles[i - 1].isEmpty() && !tiles[i].isEmpty()) {
                merge = true;
                tiles[i - 1].value *= 2;
                score += tiles[i - 1].value;
                maxTile = maxTile > tiles[i - 1].value ? maxTile : tiles[i - 1].value;
                tiles[i] = new Tile();
                compressTiles(tiles);
            }
        }
        return merge;
    }
//Также добавь поля score и maxTile типа int, которые должны хранить текущий счет и максимальный вес
//плитки на игровом поле. Счет увеличивается после каждого слияния, например если текущий счет 20 и было
//выполнено слияние ряда {4, 4, 4, 0}, счет должен увеличиться на 8. Уровень доступа к полям должен быть
//шире приватного.
//Проще всего организовать обновление значений этих полей в методе mergeTiles, например так:
//1. Если выполняется условие слияния плиток, проверяем является ли новое значения больше максимального и
//при необходимости меняем значение поля maxTile.
//2. Увеличиваем значение поля score на величину веса плитки образовавшейся в результате слияния.
    public int score;
    public int maxTile;
//6.5. Метод left должен перемещать элементы массива gameTiles влево в соответствии с правилами игры и
//добавлять плитку с помощью метода addTile, если это необходимо.
//6.6. Метод left НЕ должен изменять массив gameTiles, если перемещение влево невозможно.
//Метод left должен перемещать элементы массива gameTiles влево в соответствии с правилами игры и
//добавлять плитку с помощью метода addTile, если это необходимо.
//Метод left НЕ должен изменять массив gameTiles, если перемещение влево невозможно.
    public void left() {
//При сохранении текущего состояния в стек, обрати внимание на то, чтобы всегда сохранялось актуальное
// состояние и только однажды. Если ты послушал мой совет и реализовал методы right, up, down с помощью
// поворотов и вызова метода left, можешь использовать следующий подход:
//1. В самом начале методов right, up, down вызываем метод saveState с gameTiles в качестве параметра.
//2. В методе left организуем проверку того, вызывался ли уже метод saveState. За это у нас отвечает
// флаг isSaveNeeded, соответственно, если он равен true, выполняем сохранение. После выполнения
// сдвига влево устанавливаем флаг isSaveNeeded равным true.
//12.2. Метод left должен один раз сохранять текущее игровое состояние и счет в соответствующие стеки.
        if (isSaveNeeded) saveState(gameTiles);
        int j = 0;
        for (Tile[] gameTile : gameTiles)
            if (compressTiles(gameTile) | mergeTiles(gameTile)) j++;

        if (j != 0) addTile();

        isSaveNeeded = true;
    }
//7.1. Метод up должен перемещать элементы массива gameTiles вверх в соответствии с правилами игры
// и добавлять плитку с помощью метода addTile, если это необходимо.
//7.2. Метод up НЕ должен изменять массив gameTiles если перемещение вверх невозможно.
    public void up() {
//12.4. Метод up должен один раз сохранять текущее игровое состояние и счет в соответствующие стеки.
        saveState(gameTiles);
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }

//7.3. Метод down должен перемещать элементы массива gameTiles вниз в соответствии с правилами игры и
// добавлять плитку с помощью метода addTile, если это необходимо.
//7.4. Метод down НЕ должен изменять массив gameTiles если перемещение вниз невозможно.
    public void down() {
//12.5. Метод down должен один раз сохранять текущее игровое состояние и счет в соответствующие стеки.
        saveState(gameTiles);
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }
//7.5. Метод right должен перемещать элементы массива gameTiles вправо в соответствии с правилами игры
// и добавлять плитку с помощью метода addTile, если это необходимо.
//7.6. Метод right НЕ должен изменять массив gameTiles если перемещение вправо невозможно.
    public void right() {
//12.3. Метод right должен один раз сохранять текущее игровое состояние и счет в соответствующие стеки.
        saveState(gameTiles);
        rotate();
        rotate();
        left();
        rotate();
        rotate();
    }
    /**
     * классический поворот двумерного массива по часовой стрелке
     */
    private void rotate() {
        Tile[][] rotateGameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                rotateGameTiles[j][FIELD_WIDTH - 1 - i] = gameTiles[i][j];
            }
        }
        gameTiles = rotateGameTiles;
    }
//1. Добавь в класс Model геттер для поля gameTiles.
//В классе Model должен быть реализован корректный геттер для поля gameTiles.

    public Tile[][] getGameTiles() {
        return gameTiles;
    }
//2. Добавь в класс Model метод canMove возвращающий true в случае, если в текущей позиции возможно
// сделать ход так, чтобы состояние игрового поля изменилось. Иначе - false.
//Метод canMove в классе Model должен быть реализован в соответствии с условием задачи.
    public boolean canMove() {
        if (!getEmptyTiles().isEmpty())
            return true;

        for (Tile[] gameTile : gameTiles) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTile[j].value == gameTile[j - 1].value)
                    return true;
            }
        }

        for (int j = 0; j < gameTiles.length; j++) {
            for (int i = 1; i < gameTiles.length; i++) {
                if (gameTiles[i][j].value == gameTiles[i - 1][j].value)
                    return true;
            }
        }

        return false;
    }
//Если ты успел какое-то время поиграть в 2048, то заметил, что порой очень хочется иметь возможность
//отменить последний ход.
//Давай создадим в классе Model два стека, в одном будем хранить предыдущие состояния игрового поля,
//а в другом предыдущие счета. Назовем их previousStates и previousScores. Инициализировать можешь прямо
//в строке объявления или в конструкторе. Используй стандартную реализацию стека (java.util.Stack).
//11.1. В классе Model должны быть объявлены и инициализированы приватные поля previousStates,
// previousScores, isSaveNeeded.
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
//Добавим boolean поле isSaveNeeded = true, оно нам понадобится в будущем.
    private boolean isSaveNeeded = true;
//Хранилище состояний у нас есть, теперь реализуем два метода для работы с ними.
//Приватный метод saveState с одним параметром типа Tile[][] будет сохранять текущее
//игровое состояние и счет в стеки с помощью метода push и устанавливать флаг isSaveNeeded равным false.
    private void saveState(Tile[][] tiles) {
//11.3. После вызова метода saveState веса плиток в массиве который находится на вершине стека должны
// совпадать с весами плиток массива полученного в качестве параметра.
        Tile[][] newTile = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                newTile[i][j] = new Tile();
            }
        }
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                newTile[i][j].value = tiles[i][j].value;
            }
        }
//11.2. Метод saveState должен сохранять в стек previousStates новый объект типа Tile[][] с помощью метода push.
        previousStates.push(newTile);
//11.4. Метод saveState должен сохранять в стек previousScores текущее значение поля score с помощью метода push.
        previousScores.push(score);
//11.5. Метод saveState должен устанавливать флаг isSaveNeeded равным false.
//Обрати внимание на то, что при сохранении массива gameTiles необходимо создать новый массив и
// заполнить его новыми объектами типа Tile перед сохранением в стек.
        this.isSaveNeeded = false;
//11.8. Каждый вызов метода saveState должен увеличивать количество элементов в стеках на единицу.
    }
//Публичный метод rollback будет устанавливать текущее игровое состояние равным последнему
// находящемуся в стеках с помощью метода pop.
    public void rollback() {
//Перед восстановлением игрового состояния с помощью метода rollback не забудь проверить что стеки не
// пусты, чтобы избежать возникновения исключения EmptyStackException.
//11.7. Метод rollback не должен модифицировать текущее игровое состояние в случае, если хотя бы один из
// стеков пуст.
        if (previousScores.isEmpty() | previousStates.isEmpty()) return;
//11.6. Метод rollback должен восстанавливать поля score и gameTiles из соответствующих стеков, если они
// не пусты.
        score = previousScores.pop();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j].value = previousStates.peek()[i][j].value;
            }
        }
//В методе rollback достаточно просто выполнить присваивание (gameTiles = previousStates.pop()) и
// то же для счета, нет необходимости в глубоком копировании.
        gameTiles = previousStates.pop();
//11.9. Каждый вызов метода rollback должен уменьшать количество элементов в стеках на единицу, до тех
// пор пока это возможно.
    }
//Начнем с простого, реализуем метод randomMove в классе Model, который будет вызывать один из методов движения
//случайным образом. Можешь реализовать это вычислив целочисленное n = ((int) (Math.random() * 100)) % 4.
//Это число будет содержать целое псевдослучайное число в диапазоне [0..3], по каждому из которых можешь
//вызывать один из методов left, right, up, down.
//13.1. У класса Model должен быть метод void randomMove().
    public void randomMove() {
//13.3. Метод randomMove должен использовать статический метод random класса Math.
        int n = ((int) (Math.random() * 100)) % 4;

        switch (n) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
        }
    }
//P.S. Проверку корректности работы метода randomMove оставляю полностью под твою ответственность,
//проверю только наличие вызова метода Math.random().

//Далее перейдем в класс Model и реализуем два метода:
//1) boolean hasBoardChanged - будет возвращать true, в случае, если вес плиток в массиве gameTiles
//отличается от веса плиток в верхнем массиве стека previousStates. Обрати внимание на то, что мы не
//должны удалять из стека верхний элемент, используй метод peek.
//15.3. Метод hasBoardChanged должен быть реализован в соответствии с условием задачи.
    public boolean hasBoardChanged() {
        int sum1 = 0;
        int sum2 = 0;
        if (!previousStates.isEmpty()) {
            Tile[][] prevGameTiles = previousStates.peek();
            for (int i = 0; i < FIELD_WIDTH; i++) {
                for (int j = 0; j < FIELD_WIDTH; j++) {
                    sum1 += gameTiles[i][j].value;
                    sum2 += prevGameTiles[i][j].value;
                }
            }
        }
        return sum1 != sum2;
        }

//2) MoveEfficiency getMoveEfficiency(Move move) - принимает один параметр типа move, и возвращает объект
//типа MoveEfficiency описывающий эффективность переданного хода. Несколько советов:
//15.4. Метод getMoveEfficiency должен возвращать эффективность хода полученного в качестве параметра.
    public MoveEfficiency getMoveEfficiency(Move move) {
//в) выполнить ход можно вызвав метод move на объекте полученном в качестве параметра.
        move.move();
        MoveEfficiency moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        if (!hasBoardChanged())
//б) в случае, если ход не меняет состояние игрового поля, количество пустых плиток и счет у объекта
//MoveEfficiency сделай равными -1 и 0 соответственно;
            moveEfficiency = new MoveEfficiency(-1, 0, move);
//а) не забудь вызывать метод rollback, чтобы восстановить корректное игровое состояние;
        rollback();
//15.5. Если ход, переданный в метод getMoveEfficiency не меняет игровое поле, должен быть возвращен объект
//с количеством пустых клеток равным -1.
        return moveEfficiency;
//15.6. Метод getMoveEfficiency не должен менять вес плиток в массиве gameTiles и счет.
    }

//Давай реализуем метод autoMove в классе Model, который будет выбирать лучший из возможных ходов и
// выполнять его.
//
//Сделаем так:
//1) Создадим локальную PriorityQueue с параметром Collections.reverseOrder() (для того, чтобы вверху
// очереди всегда был максимальный элемент) и размером равным четырем.
    public void autoMove() {
//16.1. В методе autoMove должен быть создан объект типа PriorityQueue с размером равным четырем.
        PriorityQueue<MoveEfficiency> moveEfficiencies =
                new PriorityQueue<>(4, Collections.reverseOrder());
//2) Заполним PriorityQueue четырьмя объектами типа MoveEfficiency (по одному на каждый вариант хода).
//16.2. В методе autoMove в PriorityQueue должно быть добавлено 4 объекта типа MoveEfficiency с помощью
// метода offer (по одному на каждый вариант хода).
        moveEfficiencies.offer(getMoveEfficiency(this::left));
        moveEfficiencies.offer(getMoveEfficiency(this::up));
        moveEfficiencies.offer(getMoveEfficiency(this::right));
        moveEfficiencies.offer(getMoveEfficiency(this::down));
//3) Возьмем верхний элемент и выполним ход связанный с ним.
//16.4. В методе autoMove должен быть выполнен метод move связанный с объектом MoveEfficiency полученном
// с помощью метода peek или poll.
        moveEfficiencies.peek().getMove().move();
//После реализации метода autoMove добавим его вызов в метод keyPressed класса Controller по нажатию
// на клавишу A (код - KeyEvent.VK_A).
//16.3. Метод keyPressed класса Controller должен вызывать метод autoMove у модели в случае, если была
// нажата клавиша с кодом KeyEvent.VK_A.
    }

//P.S. В качестве факультативного задания можешь почитать про указатели на методы и попробовать передать
// аргумент в метод getMoveEfficiency используя оператор "::". Для метода left должно получиться
// getMoveEfficiency(this::left). Альтернативно можешь использовать внутренний анонимный класс.
}


