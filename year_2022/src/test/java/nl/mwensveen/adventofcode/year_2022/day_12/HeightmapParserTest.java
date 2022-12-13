package nl.mwensveen.adventofcode.year_2022.day_12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HeightmapParserTest {
	private String input = """
			Sabqponm
			abcryxxl
			accszExk
			acctuvwj
			abdefghi
					""";

	@Test
	public void testParseIntStringHeightmap() {
		HeightmapParser parser = new HeightmapParser();
		Heightmap heightmap = parser.parse(input.lines().toList());
		assertEquals(0, heightmap.getStartRow());
		assertEquals(0, heightmap.getStartCol());
		assertEquals(2, heightmap.getEndRow());
		assertEquals(5, heightmap.getEndCol());

		assertEquals('a', heightmap.getCoordinates().get(0, 0).getElevation());
		assertEquals('b', heightmap.getCoordinates().get(1, 1).getElevation());
		assertEquals('z', heightmap.getCoordinates().get(2, 5).getElevation());
	}

}
