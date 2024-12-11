package nl.mwensveen.adventofcode.year_2024.day_09;

import com.google.common.collect.Streams;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DiskMapFileProcessor {

    public long process(String input) {
        List<FileSpec> list = new ArrayList<>(Streams.mapWithIndex(input.chars(), (c, i) -> {
            Integer number = Integer.valueOf(Character.toString(c));
            return new FileSpec(number, i % 2 == 0 ? Long.valueOf(i / 2).intValue() : Integer.MIN_VALUE);
        })
                .filter(fs -> fs.getCount() != 0)
                .toList().reversed());

        for (int i = 0; i < list.size(); i++) {
            FileSpec fsToMove = list.get(i);
            if (fsToMove.getNumber() == Integer.MIN_VALUE) {
                continue;
            }
            for (int j = list.size() - 1; j >= 0; j--) {
                FileSpec freeSpace = list.get(j);
                if (fsToMove == freeSpace) {
                    break;
                }
                if (freeSpace.getNumber() == Integer.MIN_VALUE) {
                    if (fsToMove.getCount() == freeSpace.getCount()) {
                        freeSpace.setNumber(fsToMove.getNumber());
                        fsToMove.setNumber(Integer.MIN_VALUE);
                        break;
                    } else if (fsToMove.getCount() < freeSpace.getCount()) {
                        int freeCount = freeSpace.getCount();
                        freeSpace.setCount(freeCount - fsToMove.getCount());
                        FileSpec newFs = new FileSpec(fsToMove.getCount(), fsToMove.getNumber());
                        list.add(j + 1, newFs);
                        fsToMove.setNumber(Integer.MIN_VALUE);
                        break;
                    }
                }
            }
        }
        AtomicInteger blockId = new AtomicInteger(0);

        return list.reversed().stream().mapToLong(fs -> checkSum(fs, blockId)).sum();
    }

    private long checkSum(FileSpec fs, AtomicInteger blockId) {
        long cs = 0;
        int number = fs.getNumber();
        if (number == Integer.MIN_VALUE) {
            number = 0;
        }
        for (int i = 1; i <= fs.getCount(); i++) {
            int b = blockId.getAndIncrement();
            cs += b * number;
        }
        return cs;
    }
}
