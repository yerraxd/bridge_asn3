package reports;

public class TextFormatter implements Formatter {
    public String document(String title, String[] lines) {
        return title + " | " + String.join(" | ", lines);
    }

    @Override
    public String title(String text) {
        return text.toUpperCase();
    }

    @Override
    public String line(String label, String value) {
        return label + "=" + value;
    }
}