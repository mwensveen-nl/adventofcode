package nl.mwensveen.adventofcode.year_2021.day_04;

import com.google.common.collect.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BingoGame {

    Integer playGameToWin(List<String> input) {
        InputParser inputParser = new InputParser();
        List<Integer> numbers = inputParser.parseFirstRow(input.get(0));
        List<Table<Long, Long, Integer>> boards = inputParser.parseOtherInput(input.subList(1, input.size()));

        for (Integer number : numbers) {
            for (Table<Long, Long, Integer> board : boards) {
                if (checkBoard(board, number)) {
                    int remainder = getBoardRemainder(board);
                    return remainder * number;
                }
            }
        }
        return null;
    }

    Integer playGameToLose(List<String> input) {
        InputParser inputParser = new InputParser();
        List<Integer> numbers = inputParser.parseFirstRow(input.get(0));
        List<Table<Long, Long, Integer>> boards = inputParser.parseOtherInput(input.subList(1, input.size()));

        for (Integer number : numbers) {
            List<Table<Long, Long, Integer>> boardsInPlay = new ArrayList<Table<Long, Long, Integer>>();
            boardsInPlay.addAll(boards);
            for (Table<Long, Long, Integer> board : boards) {
                if (checkBoard(board, number)) {
                    if (boardsInPlay.size() == 1) {
                        int remainder = getBoardRemainder(boardsInPlay.get(0));
                        return remainder * number;
                    } else
                        boardsInPlay.remove(board);
                }
            }
            boards = boardsInPlay;
        }
        return null;
    }

    private int getBoardRemainder(Table<Long, Long, Integer> board) {
        return board.values().stream().filter(i -> i >= 0).collect(Collectors.summingInt(i -> i));
    }

    private boolean checkBoard(Table<Long, Long, Integer> board, Integer number) {
        int rowSize = board.rowKeySet().size();
        boolean found = false;
        long foundRow = 0;
        long foundColumn = 0;
        for (long r = 0; r < rowSize && !found; r++) {
            Map<Long, Integer> row = board.row(r);
            long columSize = row.keySet().size();
            for (long c = 0; c < columSize && !found; c++) {
                if (board.get(r, c).equals(number)) {
                    board.put(r, c, -1);
                    found = true;
                    foundRow = r;
                    foundColumn = c;
                }
            }
        }

        if (found) {
            return checkWin(board, foundRow, foundColumn);
        }
        return false;
    }

    private boolean checkWin(Table<Long, Long, Integer> board, long foundRow, long foundColumn) {
        Map<Long, Integer> row = board.row(foundRow);
        boolean found = row.values().stream().anyMatch(i -> i >= 0);
        if (found) {
            Map<Long, Integer> column = board.column(foundColumn);
            found = column.values().stream().anyMatch(i -> i >= 0);

        }
        return !found;
    }
}
