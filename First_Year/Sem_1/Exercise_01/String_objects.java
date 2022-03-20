package Exercise_01;

public class String_objects {
    public static void main(String[] args) {
        String name = "Ali";
        System.out.println("1-" + name);

        //  toUpperCase() , toLowerCase()
        System.out.println("2-" + name.toUpperCase());

        System.out.println("3-" + name.toLowerCase());
        //  .Length()
        System.out.println("4-" + name.length());
        // charAt()
        System.out.println("5-" + name.charAt(0));
        System.out.println("6-" + name.charAt(1));
        //  indexOf()     String يحدد رقم العنصر في ال
        System.out.println("7-" + name.indexOf('A'));
        // lastIndexOf()  ياخذ رقم اخر عنصر متكرر

        // concat()
        System.out.println("8-"+name.concat(" Aqel"));
    }
}
