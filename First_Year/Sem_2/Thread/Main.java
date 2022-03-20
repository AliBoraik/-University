package Thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        // 1 - given an array of n integer, count his max in m threads

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int threads=2;
        System.out.println("sum = "+getSumByThreads(arr,threads));

        // 2 - given a file. Make n copies of file, use m threads

        String path="src/Thread/text.txt";
        String nameFile="src/Thread/";
        copyFile(path,nameFile,threads);

        // 3 - URLDownloader - download files with m threads at the moment

        URL url=new URL("https://honestreporting.ca/?gclid=EAIaIQobChMIkPPA7onM8AIVpwSiAx20XQ_WEAAYAyAAEgJ1T_D_BwE");
        String extension = "pdf";
        URLDownloaderWithThreads(url,threads,extension);
        

    }

    private static void URLDownloaderWithThreads(URL url, int threads,String extension) throws IOException, InterruptedException {
        BufferedReader r = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        List<String> urlsOfExtension=new ArrayList<>();
        while ((line=r.readLine())!=null){
            line = line.toLowerCase();
            Pattern p = Pattern.compile("\"[^\"]+\\." + extension + "\"");
            Matcher m = p.matcher(line);
            while (m.find()) {
                String s = m.group();
                urlsOfExtension.add(s.substring(1, s.length() - 1));
            }
        }
        if (urlsOfExtension.size()!=0) {
            int length = urlsOfExtension.size();
            int left = 0;
            int right = length / threads;
            ArrayList<DownloadWithThread> thread = new ArrayList<>();
            List<String> u;
            for (int i = 0; i < threads - 1; i++) {
                u = urlsOfExtension.subList(left, right);
                thread.add(new DownloadWithThread(u, left, extension));
                left = right + 1;
                right = left + (length / threads);
            }
            u = urlsOfExtension.subList(left, length - 1);
            thread.add(new DownloadWithThread(u, left, extension));

            for (DownloadWithThread s : thread) {
                s.start();
            }
            for (DownloadWithThread s : thread) {
                s.join();
            }
        }

    }

    private static void copyFile(String path, String nameFile,int threads) throws InterruptedException {
        ArrayList<CopyByThread> thread = new ArrayList<>();
        for (int i = 0; i < threads; i++) {
            thread.add(new CopyByThread(path,(nameFile+i+".txt")));
        }
        for (CopyByThread s:thread) {
            s.start();
        }
        for (CopyByThread s:thread) {
            s.join();
        }

    }

    private static int getSumByThreads(int[] arr,int threads) throws InterruptedException {
        int length = arr.length;
        int left = 0;
        int right = length / threads;
        ArrayList<SumInThread> thread = new ArrayList<>();
        for (int i = 0; i < threads-1; i++) {
            thread.add( new SumInThread(arr, left, right));
            left = right + 1;
            right = left + length / threads;
        }
        thread.add(new SumInThread(arr,left,length-1));
        for (SumInThread s:thread) {
            s.start();
        }
        for (SumInThread s:thread) {
            s.join();
        }
        int sum = 0;
        for (SumInThread s : thread) {
            sum += s.getSum();
        }
        return sum;
    }
}
