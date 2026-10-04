package reports;

public class TextFormatter implements Formatter {
    @Override
    public String title(String text) {
        return text.toUpperCase();
    }

    @Override
    public String line(String label, String value) {
        return label + "=" + value;
    }
}