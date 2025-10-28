import java.io.*;
import java.util.*;

public class Dictionary {
    private Map<String, List<Word>> words = new HashMap<>();

    public Dictionary() {
        words.put("noun", new ArrayList<>());
        words.put("verb", new ArrayList<>());
        words.put("adjective", new ArrayList<>());
        words.put("adverb", new ArrayList<>());
        words.put("conjunction", new ArrayList<>());
    }

    public void addWord(Word word) {
        List<Word> list = words.get(word.getPartOfSpeech());
        if (list != null) {
            list.add(word);
        }
    }

    public void printDictionaryToFile(String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            String[] order = { "noun", "verb", "adjective", "adverb", "conjunction" };
            for (String pos : order) {
                for (Word word : words.get(pos)) {
                    writer.println("Word: " + word.getText() + ", Part of Speech: " + word.getPartOfSpeech());
                }
            }
        }
    }

    // 무작위 단어 선택 메서드
    public Word getRandomWord(String pos) {
        List<Word> list = words.get(pos);
        if (list != null && !list.isEmpty()) {
            Random rand = new Random();
            return list.get(rand.nextInt(list.size()));
        }
        // 단어가 없을 경우 기본 단어 리턴
        switch (pos) {
            case "noun":
                return new Noun("thing");
            case "verb":
                return new Verb("does");
            case "adjective":
                return new Adjective("interesting");
            case "adverb":
                return new Adverb("quickly");
            case "conjunction":
                return new Conjunction("and");
            default:
                return new Noun("thing");
        }
    }
}
