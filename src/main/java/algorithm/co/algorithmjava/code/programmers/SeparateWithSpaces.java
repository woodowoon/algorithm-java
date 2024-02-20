package algorithm.co.algorithmjava.code.programmers;

import java.util.List;

public class SeparateWithSpaces {

    public List<String> solution1(String my_string) {
        return List.of(my_string.split(" "));
    }

    public String[] solution2(String my_string) {
        return my_string.split(" ");
    }
}
