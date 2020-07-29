package forest;

public class Example {
    public static void main(String[] args) {
        String abc = "1000";
        System.out.println(abc);

        System.out.println(toNumber(abc)*2);

    }
    public static Integer toNumber(String aString) {
        return Integer.valueOf(aString);
    }
}