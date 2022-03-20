package Stream;

import java.io.*;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFromSite {
    public static void main(String[] args) throws IOException {
        URL u = new URL("https://en.wikipedia.org/wiki/Kazan");
        BufferedReader r=new BufferedReader(new InputStreamReader(u.openStream()));
        BufferedWriter out=new BufferedWriter(new FileWriter("src/Stream/f.txt"));
        String input;
        while ((input=r.readLine())!=null){
            out.write(input);
            out.newLine();
        }
        r.close();
        out.close();
        BufferedReader readNewsFromFile=new BufferedReader(new FileReader("src/Stream/f.txt"));
        int i=1;
        String in;
        while ((in=readNewsFromFile.readLine())!=null){
            in=extractURL(in);
            if (!in.equals("-1")){
                saveImage(in,i);
                i++;
            }
        }
        readNewsFromFile.close();
    }

    private static void saveImage(String link,int i) throws IOException {
        URL url = new URL(link);
        InputStream in = new BufferedInputStream(url.openStream());
        ByteArrayOutputStream o = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n;
        while (-1 != (n = in.read(buf))) {
            o.write(buf, 0, n);
        }
        o.close();
        in.close();
        byte[] response = o.toByteArray();
            FileOutputStream output = new FileOutputStream("src/Stream/Images/image" + (i + 1) +".jpg");
            output.write(response);
            output.close();
    }
    public static String extractURL(String str){

        String regex
                = "\\b((?:https?|ftp|file):"
                + "//[-a-zA-Z0-9+&@#/%?="
                + "~_|!:, .;]*[-a-zA-Z0-9+"
                + "&@#/%=~_|])";

        Pattern p = Pattern.compile(
                regex,
                Pattern.CASE_INSENSITIVE);

        Matcher m = p.matcher(str);

        while (m.find()) {


            String url = str.substring(m.start(0), m.end(0));
//            System.out.println(url);
            if (url.endsWith("jpg")) {
                return url;
            }
        }
        return "-1";
    }
}
