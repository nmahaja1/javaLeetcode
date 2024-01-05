package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Occ2dArray {
    public static void main(String[] args) {
        char[][] board = {
                {'+', '+', '+', '0', '+', '0', '0'},
                {'0', '0', '+', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '+', '0', '0'},
                {'+', '+', '+', '0', '0', '+', '0'},
                {'0', '0', '0', '0', '0', '0', '0'}
        };

        List<List<Character>> boardList = IntStream.range(0, board.length)
                .mapToObj(row -> IntStream.range(0, board[row].length)
                        .mapToObj(col -> board[row][col])
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        List<Integer> rowsWithAllZeros = IntStream.range(0, boardList.size())
                .filter(row -> boardList.get(row).stream().allMatch(ch -> ch == '0'))
                .boxed()
                .collect(Collectors.toList());

        List<Integer> columnsWithAllZeros = IntStream.range(0, boardList.get(0).size())
                .filter(col -> boardList.stream().allMatch(row -> row.get(col) == '0'))
                .boxed()
                .collect(Collectors.toList());
        System.out.println(boardList);

        System.out.println("Rows with all '0': " + rowsWithAllZeros);
        System.out.println("Columns with all '0': " + columnsWithAllZeros);
    }
}

