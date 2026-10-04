import reports.*;
import java.util.List;

public class Main {
    private static int passed = 0;
    private static int total = 0;

    static final String ATT_TEXT = "ATTENDANCE REPORT | attended=3 | total=4 | rate=75%";
    static final String ATT_HTML = "<html><body><h1>Attendance Report</h1><p>attended: 3</p><p>total: 4</p><p>rate: 75%</p></body></html>";
    static final String GR_TEXT  = "GRADE REPORT | count=3 | average=80";
    static final String GR_HTML  = "<html><body><h1>Grade Report</h1><p>count: 3</p><p>average: 80</p></body></html>";

    public static void main(String[] args) {
        if (args.length == 0 || !args[0].equals("--demo")) {
            System.out.println("Usage: java -cp out Main --demo");
            return;
        }

        check("T1", "AttendanceReport + TextFormatter",
                new AttendanceReport("A1", new TextFormatter(), 3, 4).execute(), ATT_TEXT);
        check("T2", "AttendanceReport + HtmlFormatter",
                new AttendanceReport("A1", new HtmlFormatter(), 3, 4).execute(), ATT_HTML);
        check("T3", "GradeReport + TextFormatter",
                new GradeReport("G1", new TextFormatter(), List.of(70, 80, 90)).execute(), GR_TEXT);
        check("T4", "GradeReport + HtmlFormatter",
                new GradeReport("G1", new HtmlFormatter(), List.of(70, 80, 90)).execute(), GR_HTML);

        System.out.println("SUMMARY: " + passed + "/" + total + " PASS");
    }

    private static void check(String id, String classes, String actual, String expected) {
        boolean ok = actual.equals(expected);
        total++;
        if (ok) passed++;
        System.out.println(id + " " + (ok ? "PASS" : "FAIL")
                + " | " + classes + " | result=" + show(actual));
        if (!ok) {
            System.out.println("  expected=" + show(expected));
        }
    }

    private static String show(String s) {
        return s.replace("\n", "\\n");
    }
    private static void runtimeSwitchCheck() {
        AttendanceReport original = new AttendanceReport("R1", new TextFormatter(), 3, 4);
        Report saved = original;
        String before = original.execute();
        original.setImplementation(new HtmlFormatter());
        String after = original.execute();

        boolean sameObject = (original == saved);
        boolean stateUnchanged = original.getId().equals("R1")
                && original.getAttended() == 3 && original.getTotal() == 4;
        boolean ok = sameObject && stateUnchanged
                && before.equals(ATT_TEXT) && after.equals(ATT_HTML);

        total++;
        if (ok) passed++;
        System.out.println("T5 " + (ok ? "PASS" : "FAIL")
                + " | sameObject=" + sameObject + " | stateUnchanged=" + stateUnchanged);
        System.out.println("  before=" + show(before) + " | after=" + show(after));
        if (!ok) {
            System.out.println("  expectedBefore=" + show(ATT_TEXT)
                    + " | expectedAfter=" + show(ATT_HTML));
        }
    }
}