package reports;

public abstract class Report {
    private final String id;
    private Formatter formatter;

    protected Report(String id, Formatter formatter) {
        this.id = id;
        this.formatter = formatter;
    }

    public void setImplementation(Formatter formatter) {
        this.formatter = formatter;
    }

    public String getId() {
        return id;
    }

    public String execute() {
        String[][] data = calculate();
        String[] lines = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            lines[i] = formatter.line(data[i][0], data[i][1]);
        }
        return formatter.document(formatter.title(reportTitle()), lines);
    }

    protected abstract String reportTitle();

    protected abstract String[][] calculate();
}