package reports;

public class HtmlFormatter implements Formatter {
    @Override
    public String title(String text) {
        return "<h1>" + text + "</h1>";
    }

    @Override
    public String line(String label, String value) {
        return "<p>" + label + ": " + value + "</p>";
    }
}