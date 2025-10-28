public abstract class Word {
    protected String text;
    protected String partOfSpeech;

    public Word(String text, String partOfSpeech) {
        this.text = text;
        this.partOfSpeech = partOfSpeech;
    }

    public abstract String getText();

    public abstract String getPartOfSpeech();
}
