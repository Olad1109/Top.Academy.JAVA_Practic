package HomeLearn.day3;

import java.util.Stack;

/*    ДЗ Практика 3.
   Повторить код из занятия - по возможности реализовать
   задания своими способами:
      * проверка допустимости круглых скобок */

class ValidParTheses {
    static boolean ValidParent (String x) {
        // Создание переменной Stack для хранения левых
        // закрывающих символов
        Stack<Character> leftCloseSymbols = new Stack<>();
        // Цикл для каждого символа строки
        for (char y : x.toCharArray()) {
            // Если присутствует левый символ
            if (y == '(' || y == '{' || y == '[') leftCloseSymbols.push(y);
            // Условие сочетания символов скобок
            else if (y == ')' && !leftCloseSymbols.isEmpty()
                    && leftCloseSymbols.peek() == '(') {
                leftCloseSymbols.pop();
            } else if (y == '}' && !leftCloseSymbols.isEmpty()
                    && leftCloseSymbols.peek() == '{') {
                leftCloseSymbols.pop();
            } else if (y == ']' && !leftCloseSymbols.isEmpty()
                    && leftCloseSymbols.peek() == '[') {
                leftCloseSymbols.pop();
            }
            // Если ни один из допустимых символов не встречается
            else return false;
        } return leftCloseSymbols.isEmpty();
    }
    public static void main (String[] args) {
        System.out.println (ValidParent("()") + "\n" + ValidParent("([)]")
                + "\n" + ValidParent("{[]}"));
    }
}