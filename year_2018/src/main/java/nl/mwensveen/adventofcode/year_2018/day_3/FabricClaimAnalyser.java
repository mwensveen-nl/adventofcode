package nl.mwensveen.adventofcode.year_2018.day_3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FabricClaimAnalyser {

    private final List<FabricClaim> fabricClaims;
    private final Integer totalWide;
    private final Integer totalHeight;
    private int[][] fabric;

    public FabricClaimAnalyser(List<String> claims) {
        fabricClaims = claims.stream().map(FabricClaim::new).collect(Collectors.toList());

        totalWide = fabricClaims.stream().map(fc -> fc.getFromLeft() + fc.getWide()).collect(Collectors.maxBy(Comparator.naturalOrder())).get();
        totalHeight = fabricClaims.stream().map(fc -> fc.getFromTop() + fc.getHeight()).collect(Collectors.maxBy(Comparator.naturalOrder())).get();
        fabric = new int[totalWide.intValue()][totalHeight.intValue()];
        fabricClaims.stream().forEach(this::plotOnFabric);
    }

    public long calculateOverlap() {
        IntStream stream = Arrays.stream(fabric).flatMapToInt(x -> Arrays.stream(x));
        return stream.filter(i -> i > 1).count();
    }

    public Integer findClaimWithoutOverlap() {
        return fabricClaims.stream().filter(this::matchOnFabric).findFirst().get().getId();
    }

    private void plotOnFabric(FabricClaim fc) {
        for (int w = fc.getFromLeft(); w <= fc.getEndFromLeft(); w++) {
            for (int h = fc.getFromTop(); h <= fc.getEndFromTop(); h++) {
                fabric[w][h]++;
            }
        }
    }

    private boolean matchOnFabric(FabricClaim fc) {
        for (int w = fc.getFromLeft(); w <= fc.getEndFromLeft(); w++) {
            for (int h = fc.getFromTop(); h <= fc.getEndFromTop(); h++) {
                if (fabric[w][h] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public Integer getTotalWide() {
        return totalWide;
    }

    public Integer getTotalHeight() {
        return totalHeight;
    }

}
