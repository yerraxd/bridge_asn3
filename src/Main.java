import reports.*;

public class Main {
    public static void main(String[] args) {
        Report r = new AttendanceReport("R1", new TextFormatter(), 3, 4);
        System.out.println(r.execute());
        r.setImplementation(new HtmlFormatter());
        System.out.println(r.execute());
    }
}