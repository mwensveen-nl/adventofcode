package nl.mwensveen.adventofcode.year_2022.day_04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssignmentInspectorTest {
    private String input = """
            2-4,6-8
            2-3,4-5
            5-7,7-9
            2-8,3-7
            6-6,4-6
            2-6,4-8
                        """;
    private AssignmentInspector assignmentInspector = new AssignmentInspector();

    @Test
    public void testAssignmentFullyContainsOther() {
        assertTrue(assignmentInspector.assignmentFullyContainsOther("2-8", "3-7"));
        assertTrue(assignmentInspector.assignmentFullyContainsOther("3-7", "2-8"));
        assertFalse(assignmentInspector.assignmentFullyContainsOther("3-9", "2-8"));
    }

    @Test
    public void testCountContainingOther() {
        assertEquals(2, assignmentInspector.countContainingOther(input.lines().toList()));
    }

}
