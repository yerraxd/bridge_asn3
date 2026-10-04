package reports;

import java.util.List;

public class GradeReport extends Report {
    private final List<Integer> grades;

    public GradeReport(String id, Formatter formatter, List<Integer> grades) {
        super(id, formatter);
        this.grades = List.copyOf(grades);
    }

    public List<Integer> getGrades() { return grades; }

    protected String reportTitle() {
        return "Grade Report";
    }

    protected String[][] calculate() {
        return new String[][] {
                {"count", String.valueOf(grades.size())},
                {"average", String.valueOf(average())}
        };
    }

    private int average() {
        int sum = 0;
        for (int g : grades) {
            sum += g;
        }
        return sum / grades.size();
    }
}