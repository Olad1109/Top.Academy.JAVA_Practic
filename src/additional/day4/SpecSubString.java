package additional.day4;

/*    ДЗ Практика 4.
   * Создать программу, которая в заданном тексте после символа T
     (под определённом индексом) будет вставлять заданную подстроку */

import java.util.Stack;

class SpecSubString {
    public static void main (String[] args) {
        // Объявление строк str1, str2, str3, символа t, и подстроки Top
        String str1 = "have a file with a big list of strings which is of the form";
        String str2, str3;
        char chT1 = 't';
        String substringTop = "Top";
        // Создание переменной indexT1
        int indexT1 = 26;
        System.out.println ("Строка до замены символа " + chT1 + ": " + "\n" + str1);
        // Переменной str2 присвоена сумма из подстрок, использующих методы, 
        // реализующие параметры, в которых указывается индекс в переменной indexT1
        str2 = str1.substring (0, indexT1) + substringTop + str1.substring (indexT1 + 1);
        System.out.println ("Строка после замены символа " + chT1 + " под индексом " + indexT1);
        // Печать текущей строки
        System.out.println (str2);
        // Создание строки str3 и вызов метода для замены символа t
        str3 = str1.replaceAll ("t", substringTop);
        System.out.println ("Строка после замены всех символов " + chT1 + ": ");
        // Печать нового значения
        System.out.println (str3);
        System.out.println ("Новый стек, построенный из индексов всех символов " + chT1 + ": ");
        Stack<Integer> intStackTAll = new Stack<>();
        // Вызов метода indexOf() для получения первого значения переменной indexTop
        int indexTop = str1.indexOf (chT1);
            // Создаём цикл для получения индексов всех вхождений переменной indexTop в строку
            while (indexTop != -1) {
                intStackTAll.push (indexTop);
                indexTop = str1.indexOf (chT1, indexTop + 1);
            }
        // Вывод массива, состоящего из значений indexTop
        System.out.println (intStackTAll);
    }
}
