package nl.mwensveen.adventofcode.year_2019.day_06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrbitCountChecksumCalculator {

    public int calculateCheckSum(List<String> inputs) {
        Map<String, Orbit> orbitMap = new HashMap<>();
        inputs.stream().forEach(s -> processOrbit(s, orbitMap));

        Orbit comOrbit = orbitMap.get("COM");
        int count = countSatellites(comOrbit, 0);
        return count;
    }

    public int calculateMinimalTransfers(List<String> inputs) {
        Map<String, Orbit> orbitMap = new HashMap<>();
        inputs.stream().forEach(s -> processOrbit(s, orbitMap));
        List<String> youToCom = listToCom(orbitMap, "YOU");
        List<String> sanToCom = listToCom(orbitMap, "SAN");

        int youIndex = youToCom.size() - 1;
        int sanIndex = sanToCom.size() - 1;
        String youName = youToCom.get(youIndex);
        String sanName = sanToCom.get(sanIndex);
        while (youName.equals(sanName)) {
            youToCom.remove(youIndex);
            sanToCom.remove(sanIndex);
            youIndex = youToCom.size() - 1;
            sanIndex = sanToCom.size() - 1;
            youName = youToCom.get(youIndex);
            sanName = sanToCom.get(sanIndex);
        }

        return youToCom.size() + sanToCom.size() - 2;
    }

    private List<String> listToCom(Map<String, Orbit> orbitMap, String startName) {
        List<String> listToCom = new ArrayList<>();
        Orbit baseOrbit = orbitMap.get(startName);
        String name = baseOrbit.getName();
        while (!"COM".equals(name)) {
            listToCom.add(name);
            baseOrbit = baseOrbit.getBase();
            name = baseOrbit.getName();
        }
        listToCom.add(name);
        return listToCom;
    }

    private int countSatellites(Orbit baseOrbit, int count) {
        int newCount = count;
        List<Orbit> satellites = baseOrbit.getSatellites();
        for (Orbit orbit : satellites) {
            newCount += countSatellites(orbit, count + 1);
        }
        return newCount;
    }

    private void processOrbit(String s, Map<String, Orbit> orbitMap) {
        OrbitEntry entry = new OrbitEntry(s);
        Orbit baseOrbit = getOrbit(orbitMap, entry.getBase());
        Orbit satelliteOrbit = getOrbit(orbitMap, entry.getSatellite());
        baseOrbit.addSatellite(satelliteOrbit);
        satelliteOrbit.setBase(baseOrbit);
    }

    private Orbit getOrbit(Map<String, Orbit> orbitMap, String key) {
        Orbit orbit = orbitMap.get(key);
        if (orbit == null) {
            orbit = new Orbit(key);
            orbitMap.put(key, orbit);
        }
        return orbit;
    }
}
