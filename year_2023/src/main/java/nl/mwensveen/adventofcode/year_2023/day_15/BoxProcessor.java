package nl.mwensveen.adventofcode.year_2023.day_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.IntStream;

public class BoxProcessor {

    private HashAlgorithm hashAlgorithm = new HashAlgorithm();

    public long process(String input) {
        String[] strings = input.split(",");
        Map<Integer, List<Lens>> boxes = new HashMap<>();
        Arrays.stream(strings).map(Lens::parse).forEach(lens -> addToBoxes(boxes, lens));

        return boxes.entrySet().stream().mapToLong(this::calculateBox).sum();
    }

    private void addToBoxes(Map<Integer, List<Lens>> boxes, Lens lens) {
        addToBoxes(boxes, lens, hashAlgorithm.calculateHash(lens.getLabel()));
    }

    private void addToBoxes(Map<Integer, List<Lens>> boxes, Lens lens, int labelHash) {
        if (!boxes.containsKey(labelHash)) {
            boxes.put(labelHash, new ArrayList<>());
        }
        List<Lens> box = boxes.get(labelHash);
        if (box.contains(lens)) {
            int indexOf = box.indexOf(lens);
            if (lens.getFocal().isEmpty()) {
                box.remove(indexOf);
            } else {
                box.get(indexOf).setFocal(lens.getFocal());
            }
        } else {
            if (lens.getFocal().isPresent()) {
                box.add(lens);
            }
        }
    }

    private long calculateBox(Entry<Integer, List<Lens>> e) {
        int boxNr = e.getKey();
        List<Lens> lenses = e.getValue();
        return IntStream.rangeClosed(1, lenses.size()).mapToLong(i -> (1 + boxNr) * i * lenses.get(i - 1).getFocal().get()).sum();
    }
}
