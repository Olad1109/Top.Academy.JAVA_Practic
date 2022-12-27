package HomeLearn.day3;

/*    ДЗ Практика 3.
   Повторить код из занятия - по возможности реализовать
   задания своими способами:
      * реализация Pow() */

public class TestPow {
    // Реализация возвращения double значения первого аргумента,
    // возведённого в степень второго аргумента посредством Math.pow()
    public static void main (String[] args) {
        // Возведение в квадрат переменной x1
        double x1 = 12.4;
        int n1 = 2;
        System.out.printf("Число " + x1 + " в " + n1 + "-ой степени равно " + "%.2f", Math.pow(x1, n1));
        // Возведение в куб переменной x2
        double x2 = 8;
        int n2 = 3;
        System.out.printf("\nЧисло " + x2 + " в " + n2 + "-ей степени равно " + "%.2f", Math.pow(x2, n2));
        // Возведение в 4-ую степень переменной x3
        double x3 = 5.2;
        int n3 = 4;
        System.out.printf("\nЧисло " + x3 + " в " + n3 + "-ой степени равно " + "%.2f", Math.pow(x3, n3));
        // Возведение в 7-ую степень переменной x4
        double x4 = 2;
        int n4 = 7;
        System.out.printf("\nЧисло " + x4 + " в " + n4 + "-ой степени равно " + "%.2f", Math.pow(x4, n4));
		System.out.println("");
    }
}
