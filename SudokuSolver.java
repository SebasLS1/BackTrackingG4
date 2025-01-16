public class SudokuSolver {
    private static final int N = 9; // Tamaño del tablero de Sudoku (9x9)

    // Función principal que resuelve el Sudoku usando backtracking
    public boolean resolverSudoku(int[][] tablero) {
        for (int fila = 0; fila < N; fila++) {
            for (int columna = 0; columna < N; columna++) {
                if (tablero[fila][columna] == 0) { // Encontrar celda vacía
                    for (int num = 1; num <= 9; num++) {
                        if (esValido(tablero, fila, columna, num)) {
                            tablero[fila][columna] = num; // Colocar número provisionalmente
                            if (resolverSudoku(tablero)) { 
                                return true; // Si se resuelve, retorna verdadero
                            }
                            tablero[fila][columna] = 0; // Retroceso (backtracking)
                        }
                    }
                    return false; // No se puede resolver con este camino
                }
            }
        }
        return true; // Sudoku completado
    }

    // Validación de si es seguro colocar un número en la celda
    private boolean esValido(int[][] tablero, int fila, int columna, int num) {
        // Validar fila y columna
        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] == num || tablero[i][columna] == num) {
                return false;
            }
        }
        // Validar subcuadro 3x3
        int inicioFila = fila - fila % 3;
        int inicioColumna = columna - columna % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[inicioFila + i][inicioColumna + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    // Método para imprimir el tablero
    public void imprimirTablero(int[][] tablero) {
        for (int fila = 0; fila < N; fila++) {
            for (int columna = 0; columna < N; columna++) {
                System.out.print(tablero[fila][columna] + " ");
            }
            System.out.println();
        }
    }
}
