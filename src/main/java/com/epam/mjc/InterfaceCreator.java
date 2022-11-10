package com.epam.mjc;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        //throw new UnsupportedOperationException("You should implement this method.");
        return x -> x.stream().allMatch(c -> Character.isUpperCase(c.charAt(0)));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> f = new ArrayList<>();
            x.forEach(c -> {if(!f.contains(c)){f.add(c);}});
            x.clear();
            x.addAll(f);
            //x.forEach(System.out::println);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () ->  values.stream().filter(z -> Character.isUpperCase(z.charAt(0)))
                .filter(z -> z.endsWith(".")).filter(z -> z.split(" ").length < 2).collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> { Map<String, Integer> map = new HashMap<>();
            x.stream().forEach(c -> map.put(c,c.length()));
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (x,d) -> {
            List<Integer> h = new ArrayList<>();
            h.addAll(x);
            h.addAll(d);
            return h;
        };
    }
}
