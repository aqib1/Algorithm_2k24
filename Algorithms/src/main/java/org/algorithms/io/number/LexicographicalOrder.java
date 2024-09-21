package org.algorithms.io.number;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
// O(n), O(n)
public class LexicographicalOrder {
    public List<Integer> lexicalOrder(int n) {
        return IntStream.range(1, n + 1)
                .boxed()
                .sorted(Comparator.comparing(String::valueOf))
                .toList();
    }

    public List<Integer> lexicalOrderBetter(int n) {
        if (n < 0)
            throw new IllegalArgumentException("Invalid number" );
        if (n == 0) return List.of();

        final var response = new ArrayList<Integer>();

        IntStream.range(1, 10).forEach(
                i -> lexicalOrder(i, n, response)
        );

        return response;

    }

    public void lexicalOrder(int current, int limit, List<Integer> response) {
        if (current > limit) return;

        response.add(current);

        IntStream.range(0, 10)
                .map(i -> (current * 10) + i)
                .forEach(i -> {
                    if (i <= limit)
                        lexicalOrder(i, limit, response);
                });
    }
}
