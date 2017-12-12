package nl.mwensveen.adventofcode.year_2017.day_12;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class DigitalPlumber {

    private List<Pipe> pipeList;

    public DigitalPlumber(String input) {
        pipeList = toPipeList(input);
    }

    private List<Pipe> toPipeList(String in) {
        Iterable<String> split = Splitter.on("\n")
            .trimResults()
            .omitEmptyStrings()
            .split(in);
        ArrayList<String> newArrayList = Lists.newArrayList(split);
        List<Pipe> list = newArrayList.stream().map(s -> toPipe(s)).collect(Collectors.toList());
        System.out.println(list);
        return list;
    }

    public int calculate() {
        List<Integer> connectToRoot = determineGroep(Integer.valueOf(0));
        return connectToRoot.size();
    }

    public int calculateGroups() {
        int count = 0;
        List<Integer> connectedInGroup = new ArrayList<>();

        Optional<Pipe> newRoot = pipeList.stream().filter(pipe -> !connectedInGroup.contains(pipe.getBase())).findFirst();
        while (newRoot.isPresent()) {
            List<Integer> connectToRoot = determineGroep(newRoot.get().getBase());
            count++;
            connectedInGroup.addAll(connectToRoot);
            newRoot = pipeList.stream().filter(pipe -> !connectedInGroup.contains(pipe.getBase())).findFirst();
        }
        return count;
    }

    private List<Integer> determineGroep(Integer root) {
        Optional<Pipe> rootPipe = pipeList.stream().filter(p -> p.getBase().equals(root)).findFirst();

        List<Integer> connectToRoot = new ArrayList<>();
        connectToRoot.add(Integer.valueOf(root));

        Set<Integer> newConnections = new HashSet<>();
        newConnections.addAll(rootPipe.get().getConnections());
        connectToRoot.addAll(newConnections);

        while (newConnections.size() > 0) {
            Set<Integer> collect = processNewConnections(connectToRoot, newConnections);

            connectToRoot.addAll(collect);
            newConnections = collect;
        }
        return connectToRoot;
    }

    private Set<Integer> processNewConnections(List<Integer> connectToRoot, Set<Integer> newConnections) {
        // find the connections of the pipes within the newconnections
        // and filter for those connections not already in the connectToRoot list
        Set<Integer> collect = pipeList.stream().filter(pipe -> newConnections.contains(pipe.getBase())).map(Pipe::getConnections).flatMap(List::stream)
            .filter(i -> !connectToRoot.contains(i)).collect(Collectors.toSet());
        return collect;
    }

    private Pipe toPipe(String s) {
        Iterable<String> split = Splitter.on("<->")
            .trimResults()
            .omitEmptyStrings()
            .split(s);
        ArrayList<String> newArrayList = Lists.newArrayList(split);

        String base = newArrayList.get(0);

        Iterable<String> split2 = Splitter.on(",")
            .trimResults()
            .omitEmptyStrings()
            .split(newArrayList.get(1));
        ArrayList<String> connections = Lists.newArrayList(split2);

        return new Pipe(Integer.valueOf(base), connections.stream().map(c -> Integer.valueOf(c)).collect(Collectors.toList()));

    }
}
