package HomeLearn.day3;

/*    �� �������� 3.
   ��������� ��� �� ������� - �� ����������� �����������
   ������� ������ ���������:
      * ����� ������ �������� ������ �������� */
public class LongCommPrefix {
    public static void main(String[] args){
        // ������ ��������, ��������� � ������� ������ String
        String s1 = "Julia Had a Little Lamb";
        String s2 = "Julia Had a Big Lamb";
        int minStrLen;
        minStrLen = s2.length(); // ����������� ����� ���� ������
        // �������������� API, ����������� �� StringBuilder
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < minStrLen; i ++) {
            // ����������� �������� char �� ���������� �������
            if (s1.charAt(i) ==  s2.charAt(i)) {
                output.append(s1.charAt(i));
            } else {
                break;
            }
        }
        System.out.println(output);
    }
}
