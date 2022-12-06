package nl.mwensveen.adventofcode.year_2022.day_04;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class AssignmentInspector {

    public long countContainingOther(List<String> input) {
        return input.stream().map(s -> s.split(",")).filter(split -> assignmentFullyContainsOther(split[0], split[1])).count();
    }

    public long countOverlapOther(List<String> input) {
        return input.stream().map(s -> s.split(",")).filter(split -> assignmentOverlapOther(split[0], split[1])).count();
    }

    public boolean assignmentFullyContainsOther(String assignmentOne, String assignmentTwo) {
        List<Integer> listOne = toList(assignmentOne);
        List<Integer> listTwo = toList(assignmentTwo);

        return listOne.containsAll(listTwo) || listTwo.containsAll(listOne);
    }

    public boolean assignmentOverlapOther(String assignmentOne, String assignmentTwo) {
        List<Integer> listOne = toList(assignmentOne);
        List<Integer> listTwo = toList(assignmentTwo);

        Optional<Integer> first = listOne.stream().filter(s -> listTwo.contains(s)).findFirst();
        return first.isPresent();
    }

    private List<Integer> toList(String assignmentOne) {
        String[] split = assignmentOne.split("-");
        return IntStream.rangeClosed(Integer.parseInt(split[0]), Integer.parseInt(split[1])).mapToObj(Integer::valueOf).toList();
    }
}
