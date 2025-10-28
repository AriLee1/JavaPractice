public class Noun extends Word {
    public Noun(String text) {
        super(text, "noun");
    }

    public String getText() {
        return text;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }
}
