public class Adjective extends Word {
    public Adjective(String text) {
        super(text, "adjective");
    }

    public String getText() {
        return text;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }
}
