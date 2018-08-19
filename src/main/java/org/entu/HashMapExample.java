package org.entu;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;
import static java.util.Optional.ofNullable;

public class HashMapExample {

    private static Map<Weather, Integer> weathers = new HashMap<>();

    public static void main(String[] args) {
        Random random = new Random(System.currentTimeMillis());

        IntStream.range(0, 1000)
                .mapToObj(index -> new Weather(
                        random.nextBoolean(),
                        random.nextBoolean(),
                        random.nextBoolean(),
                        random.nextBoolean()))
                .forEach(weather -> weathers.compute(weather,
                        (curr, amount) -> ofNullable(amount).orElse(0) + 1));

        System.out.println(weathers);
        System.out.println(weathers.values().stream().reduce(Integer::sum));
        System.out.println("Most frequent weather: " +
                weathers.entrySet()
                        .stream()
                        .max(comparing(Map.Entry::getValue))
                        .orElseThrow(() -> new RuntimeException("Something went wrong"))
                        .getKey());
    }
}

class Weather {
    private boolean windy;
    private boolean raining;
    private boolean snowing;
    private boolean freezing;

    Weather(boolean windy, boolean raining, boolean snowing, boolean freezing) {
        this.windy = windy;
        this.raining = raining;
        this.snowing = snowing;
        this.freezing = freezing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return windy == weather.windy &&
                raining == weather.raining &&
                snowing == weather.snowing &&
                freezing == weather.freezing;
    }

    @Override
    public int hashCode() {
        return Objects.hash(windy, raining, snowing, freezing);
    }

    @Override
    public String toString() {
        return "Weather{" +
                "windy=" + windy +
                ", raining=" + raining +
                ", snowing=" + snowing +
                ", freezing=" + freezing +
                '}';
    }
}
