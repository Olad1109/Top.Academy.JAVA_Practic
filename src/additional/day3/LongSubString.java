package additional.day3;

/*    ДЗ Практика 3.
   Повторить код из занятия - по возможности реализовать
   задания своими способами:
      * найти самую длинную подстроку без повторяющихся символов */

import java.util.HashMap;
import java.util.Map;

class LongSubString {
    public static String longestSubstring (String s) {
        // Реализация интерфейса Map на основе хеш-таблицы с помощью
        // класса Integer, что бы упаковать значения в объект HashMap<>()
        Map<Integer, Integer> lastPos = new HashMap<>();
        int start = 0, maxStart = 0, maxLen = 0, i = 0;
        // Character оборачивает значение примитивного типа char в объект,
        // который возвращает length()
        for (int cp; i < s.length(); i += Character.charCount(cp)) {
            cp = s.codePointAt(i);
            // присваивание index-а переменной pos в подстроке i строки cp
            Integer pos = lastPos.put(cp, i);
            if (pos != null && pos >= start) {
                if (i > start + maxLen) {
                    maxStart = start;
                    maxLen = i - start;
                }
                start = pos + Character.charCount(cp);
            } // определение набора символов в подстроке
        }
        return (i > start + maxLen ? s.substring(start) :
                s.substring (maxStart, maxStart + maxLen));
    } // возврат результата метода

    public static void main (String[] args) {
        // Проверка на работоспособность интерфейса
        for (String s : new String[] {" 3ycqd2nxepmgh mqlz2 ", " pw wle w ",
                " aX bXldZefg Xh "}) {
            String substr = longestSubstring(s);
            // Исключение лишних пробелов из substr
            substr = substr.replaceAll ("\\s+", "");
            System.out.printf ("%s: %s (%d)%n", s, substr, substr.length());
        }
    }
}
