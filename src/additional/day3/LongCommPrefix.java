package additional.day3;

/*    ДЗ Практика 3.
   Повторить код из занятия - по возможности реализовать
   задания своими способами:
      * поиск самого длинного общего префикса */

class LongCommPrefix {
    public static void main (String[] args) {
        // Строки символов, созданные с помощью класса String
        String s1 = "Julia Had a Little Lamb";
        String s2 = "Julia Had a Big Lamb";
        int minStrLen;
        minStrLen = s2.length(); // возвращение длины этой строки
        // Предоставление API, совместимое со StringBuilder
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < minStrLen; i ++) {
            // Возвращение значения char по указанному индексу
            if (s1.charAt(i) ==  s2.charAt(i)) {
                output.append (s1.charAt(i));
            } else break;
        }
        System.out.println (output);
    }
}
