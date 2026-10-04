package reports;

public interface Formatter {
    String title(String text);
    String line(String label, String value);
    String document(String title, String[] lines);
}