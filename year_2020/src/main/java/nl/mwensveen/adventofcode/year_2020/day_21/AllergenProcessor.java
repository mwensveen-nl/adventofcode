package nl.mwensveen.adventofcode.year_2020.day_21;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AllergenProcessor {

    public List<String> findIngredentsOfAllergens(List<Allergen> input) {
        List<Allergen> oneList = determineAllergens(input);
        return oneList.stream().map(a -> a.getPossibleCode().get(0)).collect(Collectors.toList());

    }

    public List<Allergen> findAllergens(List<Allergen> input) {
        return determineAllergens(input);
    }

    private List<Allergen> determineAllergens(List<Allergen> input) {
        List<Allergen> oneList = input.stream().filter(a -> a.getPossibleCode().size() == 1).collect(Collectors.toList());
        List<Allergen> multipleList = input.stream().filter(a -> a.getPossibleCode().size() != 1).collect(Collectors.toList());
        List<String> allCodes = input.stream().map(Allergen::getPossibleCode).flatMap(Collection::stream).collect(Collectors.toList());

        while (multipleList.size() > 0) {
            process(oneList, multipleList);
            oneList.addAll(multipleList.stream().filter(a -> a.getPossibleCode().size() == 1).collect(Collectors.toList()));
            oneList = oneList.stream().distinct().collect(Collectors.toList());
            multipleList = multipleList.stream().filter(a -> a.getPossibleCode().size() != 1).collect(Collectors.toList());
        }
        return oneList;
    }

    private void process(List<Allergen> oneList, List<Allergen> multipleList) {
        Multimap<String, Allergen> multiMap = ArrayListMultimap.create();
        multipleList.forEach(a -> multiMap.put(a.getName(), a));
        List<String> identifiedCodes = oneList.stream().map(a -> a.getPossibleCode().get(0)).collect(Collectors.toList());
        multiMap.keySet().forEach(name -> check(name, multiMap, identifiedCodes));
    }

    private void check(String name, Multimap<String, Allergen> multiMap, List<String> identifiedCodes) {
        Collection<Allergen> allergens = multiMap.get(name);
        allergens.forEach(a -> check(a, allergens, identifiedCodes));
    }

    private void check(Allergen a, Collection<Allergen> allergens, List<String> identifiedCode) {
        a.setPossibleCode(a.getPossibleCode().stream().filter(code -> !identifiedCode.contains(code)).collect(Collectors.toList()));
        allergens.stream().filter(allergen -> !allergen.equals(a)).forEach(allergen -> a.setPossibleCode(check(a, allergen)));
    }

    private List<String> check(Allergen a, Allergen other) {
        return a.getPossibleCode().stream().filter(other.getPossibleCode()::contains).collect(Collectors.toList());
    }
}
