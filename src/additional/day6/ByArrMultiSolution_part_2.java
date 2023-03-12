package additional.day6;

import java.util.Arrays;
import java.util.Random;
// Импорт статических объектов из другого класса
import static additional.day6.ByArrMultiSolution_part_1.*;
// Объявляем класс ByArrMultiSolution_part_2
class ByArrMultiSolution_part_2 {

    void NumericSubstitution() {
        int break_Min = 0, limitInt = -1;
        boolean noReplace = true;
        double[] DoubleNum, ResultArr, BreakArr ;
        double RoundVal;
        MultiSolOut.println ("Ввод количества элементов массива:");
        all_elem = MultiSolScan.nextInt();
        DoubleNum = new double[all_elem];
        ResultArr = new double[all_elem];
        BreakArr = new double[all_elem];
        MultiSolOut.println ("Создание массива из " + all_elem + "-и элементов:");
        for (all_elem = 0; all_elem < DoubleNum.length; all_elem ++) {
            DoubleNum[all_elem] = (-2 + (Math.random() * (all_elem + 2)));
            // Возвращение ближайшего значения типа данных long с помощью формулы
            // округления до 3 знаков после запятой через метод round()
            RoundVal = Math.round (DoubleNum[all_elem] * 1000) / 1000.0d;
            if (RoundVal < limitInt) {
                BreakArr[break_Min] = RoundVal;
                DoubleNum[all_elem] = BreakArr[break_Min];
                noReplace = false;
            } else DoubleNum[all_elem] = RoundVal;
        }
        MultiSolOut.println (Arrays.toString(DoubleNum));
        if (noReplace) {
            System.out.println ("Значения меньше " + limitInt + "-го отсутствуют, " +
                    "замена не требуется!\n" + Arrays.toString(DoubleNum));
        } else {
            MultiSolOut.println ("Замена всех отрицательных значений в массиве на " +
                    "их квадрат:");
            for (all_elem = 0; all_elem < DoubleNum.length; all_elem++) {
                if (DoubleNum[all_elem] < 0) {
                    ResultArr[all_elem] = Math.pow(DoubleNum[all_elem], 2);
                } else ResultArr[all_elem] = (DoubleNum[all_elem]);
                RoundVal = Math.round(ResultArr[all_elem] * 1000) / 1000.0d;
                ResultArr[all_elem] = RoundVal;
            }
            MultiSolOut.println (Arrays.toString(ResultArr));
        }
    }

    void DivisionWithRem() {
        int nullVal;
        MultiSolOut.println ("Ввод количества элементов массива:");
        all_elem = MultiSolScan.nextInt();
        arrOfNum = new int[all_elem];
        for (all_elem = 0; all_elem < arrOfNum.length; all_elem ++) {
            arrOfNum[all_elem] = (int) (0 + (Math.random() * (33)));
        }
        MultiSolOut.println ("Выводим массив из " + all_elem + "-и элементов:\n"
                + Arrays.toString(arrOfNum));
        MultiSolOut.println ("Выявление элементов массива, которые делятся\n" +
                "без остатка на крайние элементы: ");
        for (all_elem = 0; all_elem < arrOfNum.length; all_elem ++) {
            if (arrOfNum[all_elem] % arrOfNum[0] == 0) {
                if (arrOfNum[all_elem] % arrOfNum[arrOfNum.length - 1] == 0) {
                    nullVal = 1;
                    MultiSolOut.println ("+" + nullVal + " элемент под индексом " +
                            "[" + all_elem + "]");
                } else {
                    nullVal = -1;
                    MultiSolOut.println (nullVal + " элемент под индексом " +
                            "[" + all_elem + "]");
                }
            } else {
                nullVal = -1;
                MultiSolOut.println (nullVal + " элемент под индексом " +
                        "[" + all_elem + "]");
            }
        }
    }

    void ArrayOfStrings() {
        // Реализация строк символов через имя объекта (экземпляра) типа String в
        // виде объявления одномерных массивов
        String[] arrWords, retVal_filter, retVal_final;
        int Condition, subCondition, WordLength, NumOfSpace, indexSeparation;
        MultiSolOut.println ("Ввод количества элементов массива:");
        all_elem = MultiSolScan.nextInt();
        arrWords = new String[all_elem];
        // Заполнение случайными значениями
        Random rand = new Random();
        MultiSolOut.println ("Создание массива из " + all_elem + "-и элементов:");
        for (Condition = 0; Condition < all_elem; Condition ++) {
            WordLength = (int) (1 + (Math.random() * (8)));
            StringBuilder sb = new StringBuilder (WordLength);
            for (subCondition = 0; subCondition < WordLength; subCondition ++) {
                // Сгенерировать букву между начальной и конечной буквой
                char tmp = (char) ('a' + rand.nextInt('z' - 'a'));
                sb.append(tmp); // добавление в строку
            }
            arrWords[Condition] = sb.toString();
        }
        MultiSolOut.println (Arrays.toString(arrWords) +
                "\nПревращение массива строк в строку:");
        String formattedString = Arrays.toString(arrWords)
                // Удаление лишних символов
                .replace(", ", "")
                .replace("[", "")
                .replace("]", "")
                .trim();
        MultiSolOut.println (formattedString);
        // Используем генератор псевдослучайных чисел в для получения случайного
        // количества пробелов в заданной строке в пределах от 1 до 5
        NumOfSpace = (int) (1 + (Math.random() * (6 - 1)));
        char getA_space = ' ';
        String ReplaceSymbol = String.valueOf (getA_space), str_1, str_2;
        for (Condition = 0; Condition < NumOfSpace; Condition ++) {
            indexSeparation = (int) (1 + (Math.random() * (formattedString.length() - 1)));
            // Возвращение строки, которая является подстрокой этой строки до указанного
            // индекса в переменной indexSeparation
            str_1 = formattedString.substring (0, indexSeparation - 1);
            str_2 = formattedString.substring (indexSeparation - 1);
            formattedString = str_1 + ReplaceSymbol + str_2;
        }
        MultiSolOut.print ("Результат добавления случайных пробелов:\n" +
                formattedString + "\nДелим строку вокруг регулярного выражения в ");
        if (NumOfSpace == 1) {
            MultiSolOut.println (NumOfSpace + "-ом месте:");
        } else if (NumOfSpace > 1 && NumOfSpace < 5) {
            MultiSolOut.println (NumOfSpace + "-х местах:");
        } else MultiSolOut.println (NumOfSpace + "-и местах:");
        retVal_filter = formattedString.split (" ");
        all_elem = retVal_filter.length;
        for (Condition = 0; Condition < all_elem; ++ Condition) {
            // Сравнение этой строки с объектом, указанном в методе equals()
            if (retVal_filter[Condition].equals("")) retVal_filter[Condition] = null;
        }
        retVal_final = retVal_filter;
        for (String retVal : retVal_filter) MultiSolOut.println (retVal);
        MultiSolOut.println ("Получаем новый массив из полученных подстрок:\n" +
                Arrays.toString(retVal_final));
    }

    void ArraySymmetry() {
        int x, y;
        boolean horizontal = true, vertical = true;
        String approval;
        double[][] inputData;
        MultiSolOut.println ("Введём две переменные:");
        MultiSolOut.print ("Количество строк - ");
        x = MultiSolScan.nextInt();
        MultiSolOut.print ("Количество столбцов - ");
        y = MultiSolScan.nextInt();
        inputData = new double[x][y];
        MultiSolOut.println ("Заполняем массив[" + x + "][" + y +"]:");
        for (all_elem = 0; all_elem < inputData.length; all_elem ++) {
            MultiSolOut.print ("строка[" + all_elem + "] = ");
            for (int j = 0; j < inputData[all_elem].length; j ++) {
                // Разделяем целую и дробную части запятой (*,*) при вводе
                inputData[all_elem][j] = MultiSolScan.nextDouble();
            }
        }
        // Проверка горизонтальной симметрии, сравниваем первую строку с последней
        // строкой, вторую строку с предпоследней строкой и т. д.
        for (int i = 0, kLines = x - 1; i < x / 2; i ++, kLines --) {
            // Проверка каждой ячейки столбца
            for (int j = 0; j < y; j ++) {
                // проверка, все ли ячейки идентичны
                if (inputData[i][j] != inputData[kLines][j]) {
                    horizontal = false;
                    break;
                }
            }
        }
        for (int j = 0, kColumns = y - 1; j < y / 2; j ++, kColumns --) {
            for (int i = 0; i < x; i ++) {
                if (inputData[i][j] != inputData[i][kColumns]) {
                    vertical = false;
                    break;
                }
            }
        }
        String formStr_1;
            for (double[] inputDatum : inputData) {
                formStr_1 = Arrays.toString(inputDatum)
                        .replace("[", "")
                        .replace("]", "")
                        .trim();
                MultiSolOut.println (formStr_1);
            }
        if (horizontal && vertical) {
            approval = "Yes!";
        } else approval = "No!";
        MultiSolOut.println ("Симметрия по горизонтали: " + horizontal +
                "\nСимметрия по вертикали: " + vertical +
                "\nСимметрия в целом: " + approval);
    }
}