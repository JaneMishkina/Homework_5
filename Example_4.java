
// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.


import java.util.Arrays;

public class Example_4 {
    static int countSolutions = 0;

    public static void main(String[] args) {

        int N = 8;  // Длина стороны шахматной доски.
        char[][] mat = new char[N][N];  // Создание двумерного массива для отслеживания положения ферзей.
        for (int i = 0; i < N; i++)  // Инициализация двумерного массива через знак '-'.
            Arrays.fill(mat[i], 'o');

        nQueen(mat, 0);
        System.out.printf("\n-> Всего решений найдено: %d\n", countSolutions);
    }

    // Функция для проверки, чтобы ферзи не били друг друга.
    private static boolean isSafe(char[][] mat, int r, int c) {
        for (int i = 0; i < r; i++) {  // false, если у ферзей общий столбец '|'.
            if (mat[i][c] == 'x') {
                return false;
            }
        }

        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {  // false, если у ферзей общая диагональ '\'.
            if (mat[i][j] == 'x') {
                return false;
            }
        }

        for (int i = r, j = c; i >= 0 && j < mat.length; i--, j++) {  // false, если у ферзей общая диагональ '/'.
            if (mat[i][j] == 'x') {
                return false;
            }
        }

        return true;
    }

    private static void printSolution(char[][] mat) {
        System.out.println();
        for (char[] chars : mat) {
            System.out.println(Arrays.toString(chars).replaceAll(",", ""));
        }
        countSolutions++;
    }

    private static void nQueen(char[][] mat, int r) {
        if (r == mat.length) {  // Вывод решения на экран, если N ферзей расставлены успешно.
            printSolution(mat);

            return;
        }

        // Перебор всех позиций в текущем ряду 'r' и повторение для каждой допустимой позиции.
        for (int i = 0; i < mat.length; i++) {
            if (isSafe(mat, r, i)) {  // Если никакие два ферзя не угрожают друг другу,
                mat[r][i] = 'x';  // То поставить ферзя на текущую клетку.
                nQueen(mat, r + 1);  // Повторить для следующей строки.
                mat[r][i] = 'o';  // Вернуться назад и убрать ферзя с текущей клетки.
            }
        }
    }

}
