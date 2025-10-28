public class Verb extends Word {
    public Verb(String text) {
        super(text, "verb");
    }

    public String getText() {
        return text;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }
}
