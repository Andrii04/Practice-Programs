package Exam250124.Ex3;

import java.util.HashMap;
import java.util.Map;

public class Ex3 {

    public static <T> Map<T, Integer> contaElementiMatrice(T[][] matrix) {

        Map<T, Integer> elemCounts = new HashMap<>();
        //prima inizializzo la mappa con tutti gli elementi di cui conterò le occorrenze
        for (int i=0; i<matrix.length; i++) {

            for (int j=0; j<matrix[0].length; j++) elemCounts.putIfAbsent(matrix[i][j], 0);
        }

        int startY = matrix.length/2;
        int startX = matrix[0].length/2;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        countElem(matrix, startY, startX, elemCounts, visited);

        return elemCounts;
    }

    public static <T> void countElem(T[][] matrix, int y, int x, Map<T, Integer> elemCounts, boolean[][] visited) {

        if (y<0 || y >= matrix.length || x < 0 || x >= matrix[0].length || visited[y][x]) return;

        elemCounts.put(matrix[y][x], elemCounts.get(matrix[y][x])+1);
        visited[y][x] = true;

        countElem(matrix, y-1, x-1, elemCounts, visited);
        countElem(matrix, y-1, x+1, elemCounts, visited);
        countElem(matrix, y+1, x-1, elemCounts, visited);
        countElem(matrix, y+1, x+1, elemCounts, visited);
        countElem(matrix, y, x+1, elemCounts, visited);
        countElem(matrix, y, x-1, elemCounts, visited);
        countElem(matrix, y+1, x, elemCounts, visited);
        countElem(matrix, y-1, x, elemCounts, visited);
    }
}
//è Importante marcare una cella come visitata e fare in modo che le celle già visitate
//non passino oltre il caso base, altrimenti si fanno chiamate ricorsive inutile e si va in
//Stack Overflow Error, quindi è importante tenere conto delle celle visitate e delle coordinate
//se sbordano o no.