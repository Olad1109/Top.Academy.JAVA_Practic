package HomeLearn.day3;

/*    ДЗ Практика 3.
   Повторить код из занятия - по возможности реализовать
   задания своими способами:
      * перестановка слов в строке в обратную сторону */

class ReverseWord {
    // Класс reverse для разворота строки
    static void reverse (char[] str, int start, int theEnd) {
        // Временная переменная для хранения символов
        char temp;
        while (start <= theEnd) {
            // Замена первого и последнего символа
            temp = str[start];
            str[start] = str[theEnd];
            str[theEnd] = temp;
            start ++;
            theEnd --;
        }
    }
    // Функция для смены слов местами
    static char[] reverseWords (char[] n) {
        int start = 0;
        for (int theEnd = 0; theEnd < n.length; theEnd ++) {
            // Пробел является условием для замены предыдущего слова между
            // индексами start и end - 1
            if (n[theEnd] == ' ') {
                    reverse(n, start, theEnd);
                    start = theEnd + 1;
            }
        }
        // Перестановка последнего слова
        reverse (n, start, n.length - 1);
        // Разворот всей строки
        reverse (n, 0, n.length - 1);
        return n;
    }
    public static void main (String[] args) {
        String n = "ряд слов, букв или иных знаков ";
        // Вызов функции
        char[] x = reverseWords (n.toCharArray());
        System.out.print (x);
    }
}
