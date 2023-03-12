package additional.day6;
// Импорт стандартных библиотек JAVA
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
// Объявляем класс ByArrMultiSolution_part_1 с указанием на расширение в
// классе ByArrMultiSolution_part_2
class ByArrMultiSolution_part_1 extends ByArrMultiSolution_part_2 {
    // Объявляем переменную MultiSolScan для входного потока
    static Scanner MultiSolScan = new Scanner (System.in);
    // Объявляем переменную MultiSolOut для выходного потока
    static PrintStream MultiSolOut = new PrintStream (System.out);
    // Объявляем переменную all_elem, отвечающую за количество элементов массива
    static int all_elem;
    // Объявляем переменную arrOfNum, отвечающую за значения элементов массива
    static int[] arrOfNum;
    // Объявляем метод main() с аргументами командной строки через public
    // - общедоступный модификатор доступа
    public static void main (String[] argCommStr) throws Exception {
        // Объявляем метод ByArrMultiSolution_part_1(), открывающий доступ к управлению
        // над параметрами значений чисел и строк, которые используются в методе
        // TaskSelection()
        ByArrMultiSolution_part_1 byArrMultiSol = new ByArrMultiSolution_part_1();
        byArrMultiSol.TaskSelection();
    }
    // Объявляем пустой (void), по умолчанию, метод TaskSelection()
    void TaskSelection() {
        MultiSolOut.println ("""
                Работа с массивами:\s
                [evenFibs][randEdge][YesOrNo][unique][arrCount][arrLetter]
                [numSubst][divWithRem][arrOfStr][arrSymmetry][exit]""");
        // Создаём цикл рабочего меню
        while (true) {
            MultiSolOut.println ("Вводим одну из команд: ");
            // Устанавливаем switch - оператор выбора case-ов, запускающий
            // нужную часть кода, доступ к которой открывается, в данном случае,
            // через переменную MultiSolScan и метод next()
            switch (MultiSolScan.next()) {
                case "evenFibs" -> EvenNumFibonacci();
                case "randEdge" -> RandEdges();
                case "YesOrNo" -> YesOrNoArray();
                case "unique" -> UniqueOfNum();
                case "arrCount" -> ArrayCounter();
                case "arrLetter" -> ArrayLetters();
                case "numSubst" -> NumericSubstitution();
                case "divWithRem" -> DivisionWithRem();
                case "arrOfStr" -> ArrayOfStrings();
                case "arrSymmetry" -> ArraySymmetry();
                case "exit" -> {
                    MultiSolOut.println ("Выход из программы!");
                    return;
                }
            }
        }
    }
    // Объявляем метод EvenNumFibonacci()
    void EvenNumFibonacci() {
        all_elem = 15;
        // Объявляем переменные примитивного типа int
        int even_elem = 0, FirstNum = 0, SecondNum = 1, temp;
        // Используем переменную all_elem в качестве индекса массивов FibArray,
        // FibArrayEvens, evens
        int[] FibArray = new int[all_elem], FibArrayEvens = new int[all_elem],
                evens = new int[even_elem];
        // Создаём цикл for с предусловием, которое увеличит значение all_elem,
        // но вернёт исходное значение после завершения цикла
        for (all_elem = 0; all_elem < FibArray.length; all_elem ++) {
            temp = FirstNum + SecondNum;
            FirstNum = SecondNum;
            if (temp == 1) {
                FirstNum = 0;
                FibArray[all_elem] = FirstNum;
                FirstNum = SecondNum;
            } else FibArray[all_elem] = FirstNum;
            SecondNum = temp;
            // Проверка на чётность
            if (FibArray[all_elem] % 2 == 0) {
                // Увеличиваем количество элементов массива FibArrayEvens[]
                FibArrayEvens[even_elem ++] = FibArray[all_elem];
                // Используем метод copyOf(), копирующий указанный массив,
                // усекая или дополняя нулями, чтобы копия имела длину,
                // указанную в переменной even_elem
                evens = Arrays.copyOf (FibArrayEvens, even_elem);
            }
        }
        MultiSolOut.println ("Выводим массив из " + all_elem + "-и элементов, " +
                "используя числа Фибоначчи:\n" + Arrays.toString(FibArray) + "\n" +
                "Получаем новый массив из чётных чисел:\n" + Arrays.toString(evens));
    }

    void RandEdges() {
        all_elem = 30;
        arrOfNum = new int[all_elem];
        int min = arrOfNum[0], max = arrOfNum[0];
        for (all_elem = 0; all_elem < arrOfNum.length; all_elem ++) {
            // Используем метод random() класса Math для получения случайных чисел
            // от -70 до 50
            arrOfNum[all_elem] = (int) (-70 + (Math.random() * (50 + 70)));
            if (min > arrOfNum[all_elem]) min = arrOfNum[all_elem];
            if (max < arrOfNum[all_elem]) max = arrOfNum[all_elem];
        }
        MultiSolOut.println ("Выводим массив из " + all_elem + "-и элементов:\n"
                + Arrays.toString(arrOfNum) + "\n" + "Минимальный элемент: " + min
                + "\n" + "Максимальный элемент: " + max);
    }

    void YesOrNoArray() {
        // Объявляем переменную логического типа
        boolean allEqual;
        MultiSolOut.println ("Ввод количества элементов массива:");
        // Читаем с клавиатуры размер массива для присвоения его значения
        // переменной all_elem
        all_elem = MultiSolScan.nextInt();
        arrOfNum = new int[all_elem];
        MultiSolOut.println ("Заполняем массив:");
        for (all_elem = 0; all_elem < arrOfNum.length; all_elem ++) {
            arrOfNum[all_elem] = MultiSolScan.nextInt();
        }
        MultiSolOut.println ("Заданный массив:\n" + Arrays.toString(arrOfNum));
        // Получение похожих элементов потока, и их подсчёт в потоке
        allEqual = (Arrays.stream(arrOfNum).distinct().count() == 1);
        MultiSolOut.println ("Результат проверки на сходство всех элементов: ");
        if (allEqual) {
            MultiSolOut.print ("Yes\n");
        } else MultiSolOut.print ("No\n");
    }

    void UniqueOfNum() {
        all_elem = 10;
        arrOfNum = new int[all_elem];
        int addVar;
        boolean flag;
        for (all_elem = 0; all_elem < arrOfNum.length; all_elem ++) {
            arrOfNum[all_elem] = (int) (-10 + (Math.random() * (10 + 10)));
            if (all_elem == arrOfNum.length - 1) {
                MultiSolOut.println ("Результат генерации массива из " +
                        arrOfNum.length + "-и элементов:\n" +
                        Arrays.toString(arrOfNum) + "\n" +
                        "Вывод уникальных значений[индексов]:");
            }
        }
        for (all_elem = 0; all_elem < arrOfNum.length; all_elem ++) {
            flag = true;
            for (addVar = 0; addVar < arrOfNum.length; addVar ++) {
                if (arrOfNum[all_elem] == arrOfNum[addVar] && all_elem != addVar) {
                    flag = false;
                    break;
                }
            }
            if (flag && all_elem < arrOfNum.length - 1) {
                MultiSolOut.print (arrOfNum[all_elem] + "[" + all_elem + "], ");
            } else if (flag) MultiSolOut.print (arrOfNum[all_elem] +
                    "[" + all_elem + "]");
        }
        MultiSolOut.println ("\nВывод значений, которые повторяются:");
        // Алгоритм сортировки по возрастанию
        Arrays.sort (arrOfNum);
        int sum = 0, counter = 0;
        for (all_elem = 0; all_elem < arrOfNum.length; all_elem ++) {
            if (arrOfNum[0] == arrOfNum[arrOfNum.length - 1]) {
                if (counter > 1) MultiSolOut.println (arrOfNum[0] +
                        " (переменная) * " + counter + " (количество)");
                // Используем break, что бы прервать действия суб-условия
                break;
            } else {
                if (all_elem == (arrOfNum.length - 1)) {
                    sum += arrOfNum[arrOfNum.length - 1];
                    counter ++;
                    if (counter > 1) MultiSolOut.println ((sum / counter) +
                            " (переменная) * " + counter + " (количество)");
                    break;
                } else {
                    if (arrOfNum[all_elem] == arrOfNum[all_elem + 1]) {
                        sum += arrOfNum[all_elem];
                        counter ++;
                    } else if (arrOfNum[all_elem] != arrOfNum[all_elem + 1]) {
                        sum += arrOfNum[all_elem];
                        counter ++;
                        if (counter > 1 ) MultiSolOut.println ((sum / counter) +
                                " (переменная) * " + counter + " (количество)");
                        sum = 0;
                        counter = 0;
                    }
                }
            }
        }
    }

    void ArrayCounter() {
        MultiSolOut.println ("Ввод количества элементов массива:");
        all_elem = MultiSolScan.nextInt();
        arrOfNum = new int[all_elem];
        int lastValueCount = 1;
        MultiSolOut.println ("Создание массива из " + all_elem +
                "-и элементов:");
        for (all_elem = 0; all_elem < arrOfNum.length; all_elem ++) {
            arrOfNum[all_elem] = (int) (3 + (Math.random() * (13 - 3)));
        }
        MultiSolOut.println (Arrays.toString(arrOfNum) + "\n" +
                "Вывод значений, и количество их вывода:");
        Arrays.sort (arrOfNum);
        for (all_elem = 1; all_elem < arrOfNum.length; all_elem ++) {
            if (arrOfNum[all_elem] == arrOfNum[all_elem - 1]) {
                lastValueCount ++;
            } else {
                if (lastValueCount > 1) {
                    MultiSolOut.println (arrOfNum[all_elem - 1] +
                            " (переменная) * " + lastValueCount +
                            " (количество)");
                    lastValueCount = 1;
                } else {
                    lastValueCount = 1;
                    MultiSolOut.println (arrOfNum[all_elem - 1] +
                            " (переменная) * " + lastValueCount +
                            " (количество)");
                }
            }
        }
        if (all_elem == arrOfNum.length)
            MultiSolOut.println (arrOfNum[all_elem - 1] + " (переменная) * "
                    + lastValueCount + " (количество)");
    }

    void ArrayLetters() {
        // Объявляем массив символьного типа
        char[] alphabet;
        int letter_index, repNum = 3;
        // Объявляем строку uppers
        String uppers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String all = uppers + uppers.toLowerCase();
        MultiSolOut.println ("Ввод количества элементов массива:");
        all_elem = MultiSolScan.nextInt();
        alphabet = new char[all_elem];
        // Создаём генератор случайных чисел
        Random rand = new Random();
        MultiSolOut.println ("Создание массива из " + all_elem + "-и элементов:");
        for (letter_index = 0; letter_index < all_elem; ++ letter_index) {
            int position = rand.nextInt(all.length());
            // Возвращение значения char по указанному индексу
            alphabet[letter_index] = all.charAt(position);
        }
        MultiSolOut.println (Arrays.toString(alphabet) +
                "\nСортировка буквенных символов из данного массива:");
        Arrays.sort (alphabet);
        String sorted = new String (alphabet);
        MultiSolOut.println (sorted + "\nВывод букв, которые повторяются больше " +
                repNum + "-х раз:");
        if (sorted.length() > 0) {
            char previousChar = sorted.charAt(0);
            int count = 1;
            for (letter_index = 1; letter_index < sorted.length(); letter_index ++) {
                if (sorted.charAt(letter_index) == previousChar) {
                    count ++;
                } else { // повторное столкновение с символом
                    if (count > repNum) {
                        // Проход через это условие символа свыше значения
                        // переменной repNum
                        MultiSolOut.println (sorted.charAt(letter_index - 1) +
                                " (переменная) * " + count + " (количество)");
                    }
                    count = 1;
                    previousChar = sorted.charAt (letter_index);
                }
            }
            // Результат обработки символа через несколько циклов
            if (count > repNum) {
                MultiSolOut.println (sorted.charAt(sorted.length() - 1) +
                        " (переменная) * " + count + " (количество)");
            }
        }
    }
}