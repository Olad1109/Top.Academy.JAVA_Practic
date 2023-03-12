package additional.day4;

/*    ДЗ Практика 4.
   * В каждом слове текста n-ную букву заменить заданным символом.
     Если n больше длины слова, корректировку не выполнять. */

import java.util.Scanner;

class SelectCharacter {
    public static void main (String[] args) {
        // Объявление строки str0
        String str0 = "this challenge's honorificabilitudinitatibus is to take a it's";
        // Объявление строки str1, имеющей целочисленный тип, получаемой из массива символов
        char[] str1 = "this challenge's honorificabilitudinitatibus is to take a it's".toCharArray();
        int num;
        // Объявление переменной nLetter
        int nLetter = 0;
        System.out.println ("Текст до замены n-ной буквы: " + "\n" + str0);
        System.out.print ("Шаг первый, вводим целое число: ");
        // Объявление текстового анализатора Scanner
        Scanner sc = new Scanner(System.in);
        // Включение методов для работы с кодовой точкой 'c'
        String c;
        // Создание цикла с учётом неверного ввода
        while (true) {
            String input = sc.next();
            // Условие для присваивания вводимого значения переменной num
            try {
                num = Integer.parseInt (input);
                System.out.println ("Ввод был правильным, продолжим!");
                break;
            } catch (NumberFormatException ne) {
                // Результат неудачного преобразования строки в числовой тип
                System.err.print ("Сбой, компьютер в шоке, он не узнаёт это число!"
                        + "\nПовторим ввод: ");
            }
        }
        System.out.print ("Шаг первый успешно завершён!" +
                "\nШаг второй, разрешён ввод любого символа: ");
        c = sc.next();
        // Условие для поиска и замены символов посредством их перечисления и записи
        // их в кодовую точку 'c', с целью составления из них строки в переменной str1
        for (int i = 0; i < str1.length; ++ i) {
			// Используем nLetter для проверки наличия пробелов в строке
            if (str1[i] == ' ') {
                nLetter = 0;
            } else if (nLetter ++ == num - 1) {
                str1[i] = c.charAt(0);
            }
        }
        System.out.println ("Шаг второй успешно завершён!" +
                "\nСимвол принят, получаем результат:");
        // Вывод строки, получаемой из массива значений str1[]
        System.out.println (str1);
    }
}
