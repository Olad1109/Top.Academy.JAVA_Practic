package HomeLearn.day3;

import java.util.Stack;

/*    �� �������� 3.
   ��������� ��� �� ������� - �� ����������� �����������
   ������� ������ ���������:
      * �������� ������������ ������� ������ */

public class ValidParTheses {
    public static boolean ValidParent (String x) {
        // �������� ���������� Stack ��� �������� �����
        // ����������� ��������
        Stack<Character> leftCloseSymbols = new Stack<>();
        // ���� ��� ������� ������� ������
        for (char y : x.toCharArray()) {
            // ���� ������������ ����� ������
            if (y == '(' || y == '{' || y == '[') {
                leftCloseSymbols.push(y);
            }
            // ������� ��������� �������� ������
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
            // ���� �� ���� �� ���������� �������� �� �����������
            else {
                return false;
            }
        }
        return leftCloseSymbols.isEmpty();
    }
    public static void main (String[] args) {
        System.out.println(ValidParent("()"));
        System.out.println(ValidParent("([)]"));
        System.out.println(ValidParent("{[]}"));
    }
}
