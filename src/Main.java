import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kelime: ");
        String word = scanner.nextLine();

        Map<Character, Integer> charCounts = new HashMap<>();

        //String verinin her karakterini ayrırarak map'e key olarak char ları ve value olarak da tekrar sayılarını ekliyor.
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            int count = charCounts.getOrDefault(currentChar, 0);
            charCounts.put(currentChar, count + 1);
        }

        int maxCount = 0;
        char maxChar = '\0';
        int equalsCharCounts = 0;

        //Map içerisinde bulunan her verinin value değerini önce count'a atıyor eğer maxCounttan büyükse maxCount'a eşitliyor
        //Eğer zaten eşitse equalsCharCounts'a eşitliyor.
        for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
            char currentChar = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount) {
                maxCount = count;
                maxChar = currentChar;
            } else if (count == maxCount) {
                equalsCharCounts = count;
            }
        }

        if (maxCount > equalsCharCounts) {
            System.out.println(maxChar + " harfinden " + maxCount + " tane var.");
        } else {
            System.out.println("Eşitlik durumu mevcut.");
        }
    }
}
