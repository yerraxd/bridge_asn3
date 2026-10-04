package reports;

public class AttendanceReport extends Report {
    private final int attended;
    private final int total;

    public AttendanceReport(String id, Formatter formatter, int attended, int total) {
        super(id, formatter);
        this.attended = attended;
        this.total = total;
    }

    public int getAttended() { return attended; }
    public int getTotal() { return total; }

    protected String reportTitle() {
        return "Attendance Report";
    }

    protected String[][] calculate() {
        return new String[][] {
                {"attended", String.valueOf(attended)},
                {"total", String.valueOf(total)},
                {"rate", percentage() + "%"}
        };
    }

    private int percentage() {
        return attended * 100 / total;
    }
}