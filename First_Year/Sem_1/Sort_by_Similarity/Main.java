package Exercises.Sort_by_Similarity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader fr = new BufferedReader(new FileReader("src/main/java/Exercises/Sort_by_Similarity/words"));
        String sort="aedh";
        StringBuilder s = new StringBuilder();
        while (fr.ready()) {
            s.append(fr.readLine()).append(",");
        }
        String[] w = s.toString().split(",");
        System.out.println("All words before sort = "+ Arrays.toString(w));
        System.out.println("Sort by: "+sort);
        quickSortBySimilarity(sort, w);
    }
    public static void quickSortBySimilarity(String sl, String[] words) {
        int first=0;
        for (int i = 0; i < sl.length(); i++) {
            for (int j = 0; j < words.length ; j++) {
                if (sl.charAt(i)==words[j].charAt(0)){
                    String w=words[first];
                    words[first]=words[j];
                    words[j]=w;
                    first++;
                }
            }
        }
        System.out.println("All worlds after sort = "+Arrays.toString(words));
    }

}

