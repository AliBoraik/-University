package Map;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String text = "abababaaa";
        Map<Character, Integer> numbers = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            if (numbers.containsKey(text.charAt(i))) {
                int h = numbers.get(text.charAt(i));
                h++;
                numbers.replace(text.charAt(i), h);
            } else {
                numbers.put(text.charAt(i), 1);
            }
        }
        System.out.println(numbers);
    }
}
