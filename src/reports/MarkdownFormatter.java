package reports;

public class MarkdownFormatter implements Formatter {
    public String title(String text) {
        return "# " + text;
    }

    public String line(String label, String value) {
        return "- " + label + ": " + value;
    }

    public String document(String title, String[] lines) {
        return title + "\n" + String.join("\n", lines);
    }
}