package HomeLearn.day6;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

class TwoDimensArray {
    // Объявляем переменную arrScan для входного потока
    Scanner arrScan = new Scanner (System.in);
    // Объявляем переменную arrSolute для выходного потока
    PrintStream arrSolute = new PrintStream (System.out);
    // Объявляем переменную numOfElem
    int numOfElem;
    // Объявляем метод main() с аргументами командной строки через public
    // - общедоступный модификатор доступа
    public static void main (String[] argCommStr) throws Exception {
        // Объявляем метод ArraysSolution(), открывающий доступ к управлению
        // над параметрами значений чисел и строк, которые используются в методе
        // OperationWithArrays()
        TwoDimensArray twoDimensArray = new TwoDimensArray();
        twoDimensArray.OperationWithArrays();
    }

    void OperationWithArrays() {
        int x, y;
        boolean horizontal = true, vertical = true, diagonal = true, X_result;
        double[][] inputData;
        // Объявляем переменные baseStr и addStr через метод StringBuilder() в
        // качестве динамических строк для данных любого типа
        StringBuilder baseStr = new StringBuilder();
        StringBuilder addStr = new StringBuilder();
        String separator = " ", approval;
        arrSolute.println ("Введём две переменные:");
        arrSolute.print ("Количество строк - ");
        x = arrScan.nextInt();
        arrSolute.print ("Количество столбцов - ");
        y = arrScan.nextInt();
        inputData = new double[x][y];
        arrSolute.println ("Заполняем массив[" + x + "][" + y +"]:");
        for (numOfElem = 0; numOfElem < inputData.length; numOfElem ++) {
            arrSolute.print ("строка[" + numOfElem + "] = ");
            for (int j = 0; j < inputData[numOfElem].length; j ++) {
                // Разделяем целую и дробную части запятой (*,*) при вводе
                inputData[numOfElem][j] = arrScan.nextDouble();
            }
        }
        // Проверка горизонтальной симметрии, сравниваем первую строку с последней
        // строкой, вторую строку с предпоследней строкой и т. д.
        for (int i = 0, xLines = x - 1; i < x / 2; xLines --, i ++) {
            // Проверка каждой ячейки столбца
            for (int j = 0; j < y; j ++) {
                // проверка, все ли ячейки идентичны
                if (inputData[i][j] != inputData[xLines][j]) {
                    horizontal = false;
                    break;
                }
            }
        }
        for (int j = 0, yColumns = y - 1; j < y / 2; j ++, yColumns --) {
            for (int i = 0; i < x; i ++) {
                if (inputData[i][j] != inputData[i][yColumns]) {
                    vertical = false;
                    break;
                }
            }
        }
        // Проверка диагональной симметрии - сравниваем верхние элементы основной
        // диагонали с нижними элементами основной диагонали, верхние элементы
        // дополнительной диагонали с нижними элементами дополнительной диагонали
        if (x == y) {
            for (int j = 0, yColumns = y - 1, i = 0, xLines = x - 1;
                 j < y; j ++, i ++, yColumns --, xLines --) {
                // Используем метод append() для увеличения строки за счёт новых
                // символов, которые открываются в объекте inputData через цикл
                baseStr.append (separator);
                baseStr.append (inputData[xLines][yColumns]);
                if (inputData[i][j] != inputData[xLines][yColumns]) {
                    diagonal = false;
                    break;
                }
            }
            for (int j = y - 1, yColumns = 0, i = 0, xLines = x - 1;
                 i < x; j --, i ++, yColumns ++, xLines --) {
                addStr.append (separator);
                addStr.append (inputData[xLines][yColumns]);
                if (inputData[i][j] != inputData[xLines][yColumns]) {
                    diagonal = false;
                    break;
                }
            }
        } else diagonal = false;
        String base_1 = String.valueOf (baseStr).trim();
        String add_1 = String.valueOf (addStr).trim();
        // Объявляем массивы строк в переменных baseDiagonal[] и addDiagonal[],
        // разбиваем строки через метод split с помощью регулярного выражения
        String[] baseDiagonal = base_1.split (" ");
        String[] addDiagonal = add_1.split (" ");
        arrSolute.println ("Массивы значений по 2-ум диагоналям:\n"
                + Arrays.toString(baseDiagonal)
                // Используем замену подстрок методом replace()
                .replace ("[", "")
                .replace ("]", "")
                .trim() + "\n" +
                Arrays.toString(addDiagonal)
                        .replace ("[", "")
                        .replace ("]", "")
                        .trim());
        if (diagonal) {
            // Применяем метод equals() для сравнения элементов со схожими
            // индексами в двух массивах, выкидываем true при равенстве
            X_result = Arrays.equals (baseDiagonal, addDiagonal);
        } else X_result = false;
        String formStr_1;
        arrSolute.println ("Вывод всего массива: ");
        for (double[] inputDatum : inputData) {
            formStr_1 = Arrays.toString(inputDatum)
                    .replace ("[", "")
                    .replace ("]", "")
                    .trim();
            arrSolute.println (formStr_1);
        }
        if (horizontal && vertical && diagonal && X_result) {
            approval = "Yes!";
        } else approval = "No!";
        arrSolute.println ("Симметричность:\n"
                + horizontal + "[горизонт] + " + vertical + "[вертикаль]\n+ "
                + diagonal + "[диагональ] + " + X_result + "[центр] = "
                + approval + "[итог]");
    }
}