package HomeLearn.day5;

/*    ДЗ Практика 5.
   * Создать программу по нахождению искомого числа X в массиве целых чисел,
   * используя алгоритм линейного поиска */

import java.util.Scanner;

class LineSearchAlg {
    // Объявление Scanner в переменной forLineSearch
    static Scanner forLineSearch = new Scanner (System.in);
    // Объявляем метод numberSearch() для применения алгоритма линейного
    // поиска double-значений
    static int numberSearch (double[] arr, double numElementX) {
        for (int index = 0; index < arr.length; index ++) {
            if (arr[index] == numElementX) return index;
        } return -1;
    }
    // Объявляем метод main() с аргументами командной строки
    public static void main (String[] argCommStr) {
        double[] doubles = {89.5, 57, 91.2, 47.5, 95.1, 3.12, 27};
        double numElementX;
        int index;
        // Создание цикла с учётом неверного ввода
        while (true) {
            System.out.println ("Вводим число (*.*) в переменной " +
                    "numElementX:");
            String input = forLineSearch.next();
            // Создаём условие для присвоения вводимого значения переменной
            // numElementX
            try {
                numElementX = Double.parseDouble(input);
                // Возврат значения индекса в переменную index
                index = LineSearchAlg.numberSearch (doubles, numElementX);
                System.out.println ("Результат анализа введённого числа:");
                if (index == -1) {
                    System.out.println ("число " + numElementX +
                            " отсутствует в массиве");
                } else {
                    System.out.println ("число " + numElementX +
                            " присутствует в массиве под индексом " + index
                            + "\nЗадача выполнена!");
                    break; // возврат к предусловию while (true)
                }
            } catch (NumberFormatException ne) {
                // результат неудачного преобразования строки в числовой тип
                System.out.print ("Ввод некорректен!\n");
            }
        }
    }
}