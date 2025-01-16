public class Main {
    public static void main(String[] args) {
        // Tablero de Sudoku de ejemplo con celdas vacías representadas con 0
        int[][] tablero = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        SudokuSolver solver = new SudokuSolver();
        System.out.println("Tablero original:");
        solver.imprimirTablero(tablero);
        
        if (solver.resolverSudoku(tablero)) {
            System.out.println("\nSudoku resuelto:");
            solver.imprimirTablero(tablero);
        } else {
            System.out.println("No se encontró solución.");
        }
    }
}
