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
        String result = formatter.title(reportTitle());
        String[][] data = calculate();
        for (int i = 0; i < data.length; i++) {
            result = result + formatter.line(data[i][0], data[i][1]);
        }
        return result;
    }

    protected abstract String reportTitle();

    protected abstract String[][] calculate();
}