package reports;

public class HtmlFormatter implements Formatter {
    public String document(String title, String[] lines) {
        return "<html><body>" + title + String.join("", lines) + "</body></html>";
    }
    @Override
    public String title(String text) {
        return "<h1>" + text + "</h1>";
    }

    @Override
    public String line(String label, String value) {
        return "<p>" + label + ": " + value + "</p>";
    }
}