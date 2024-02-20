package algorithm.co.algorithmjava.code.programmers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeparateWithSpacesTest {

    @ParameterizedTest
    @DisplayName("공백으로 구분하기 1")
    @ValueSource(strings = {"i love you", "programmers"})
    public void 공백으로_구분하기_1_1(String my_string) {
        // given
        SeparateWithSpaces separateWithSpaces = new SeparateWithSpaces();

        // when
        List<String> actualList = separateWithSpaces.solution1(my_string);

        // then
        if (my_string.equals("i love you")) {
            assertEquals(Arrays.asList("i", "love", "you"), actualList);
        } else if (my_string.equals("programmers")) {
            assertEquals(List.of("programmers"), actualList);
        }
    }

    @ParameterizedTest
    @DisplayName("공백으로 구분하기 1_2")
    @ValueSource(strings = {"i love you", "programmers"})
    public void 공백으로_구분하기_1_2(String my_string) {
        // given
        SeparateWithSpaces separateWithSpaces = new SeparateWithSpaces();

        String[] answer1 = {"i", "love", "you"};
        String[] answer2 = {"programmers"};

        // when
        String[] actualList = separateWithSpaces.solution2(my_string);

        // then
        if (my_string.equals("i love you")) {
            assertArrayEquals(answer1, actualList);
        } else if (my_string.equals("programmers")) {
            assertArrayEquals(answer2, actualList);
        }
    }
}
