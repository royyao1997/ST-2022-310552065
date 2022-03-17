import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueTest {

    @ParameterizedTest(name="#{index} - Test with Argument={0}, {1}")
    @MethodSource("getParameters")
    public void PriorityQueue_RunTest(int[] random_array, int[] correct_array) {
        PriorityQueue<Integer> pq = new java.util.PriorityQueue<Integer>();
        for (int i = 0;i < random_array.length;i++) {
            pq.add(random_array[i]);
        }
        int[] result = new int[random_array.length];
        for (int i = 0;i < random_array.length;i++) {
            result[i] = pq.poll();
        }

        assertArrayEquals(correct_array, result);

    }

    public static Stream<Arguments> getParameters() {
        return Stream.of(
                Arguments.of(new int[] {2, 5, 3}, new int[] {2, 3, 5}),
                Arguments.of(new int[] {6, 8, 2, 0}, new int[] {0, 2, 6, 8}),
                Arguments.of(new int[] {-8, 6, 2, -4}, new int[] {-8, -4, 2, 6}),
                Arguments.of(new int[] {7, 9, 5, 8, -1}, new int[] {-1, 5, 7, 8, 9}),
                Arguments.of(new int[] {1, 5, 9, -4}, new int[] {-4, 1, 5, 9})
        );


    }

    @Test
    public void initialCapacityTest_IllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new PriorityQueue(-1, null);
        });
    }

    @Test
    public void addNullTest_NullPointerException() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new PriorityQueue().add(null);
        });
    }

    @Test
    public void forEachTest_NullPointerException() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new PriorityQueue().forEach(null);
        });
    }
}