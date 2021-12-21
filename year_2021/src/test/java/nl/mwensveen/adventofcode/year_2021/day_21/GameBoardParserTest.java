package nl.mwensveen.adventofcode.year_2021.day_21;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

public class GameBoardParserTest {

	@Test
	public void testParseGameBoard() {
		List<String> input = Arrays.asList("Player 1 starting position: 4",
				"Player 2 starting position: 8");
		GameBoardParser boardParser = new GameBoardParser();
		Pair<Player, Player> gameBoards = boardParser.parseGameBoard(input);
		assertEquals(4, gameBoards.getValue0().getPosition());
		assertEquals(8, gameBoards.getValue1().getPosition());
	}

}
