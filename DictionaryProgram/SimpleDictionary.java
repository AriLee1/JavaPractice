import java.io.*;
import java.util.*;

public class SimpleDictionary {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Assignment 6: Dictionary and Sentence Generator");

        while (true) {
            System.out.print("> ");
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");
            if (parts.length == 0)
                continue;
            String command = parts[0];

            if (command.equals("exit")) {
                System.out.println("Program terminated.");
                break;
            } else if (command.equals("read")) {
                if (parts.length < 3) {
                    System.out.println("Error: Usage: read <file> <PartOfSpeech>");
                    continue;
                }
                String filename = parts[1];
                String pos = parts[2].toLowerCase();
                if (!(pos.equals("noun") || pos.equals("verb") || pos.equals("adjective") ||
                        pos.equals("adverb") || pos.equals("conjunction"))) {
                    System.out.println("Error: Part of speech must be noun, verb, adjective, adverb, or conjunction.");
                    continue;
                }
                try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                    String word;
                    while ((word = br.readLine()) != null) {
                        word = word.trim();
                        if (!word.isEmpty()) {
                            // 각 품사에 따라 해당 파일에서 읽은 단어 객체 생성
                            switch (pos) {
                                case "noun":
                                    dictionary.addWord(new Noun(word));
                                    break;
                                case "verb":
                                    dictionary.addWord(new Verb(word));
                                    break;
                                case "adjective":
                                    dictionary.addWord(new Adjective(word));
                                    break;
                                case "adverb":
                                    dictionary.addWord(new Adverb(word));
                                    break;
                                case "conjunction":
                                    dictionary.addWord(new Conjunction(word));
                                    break;
                            }
                        }
                    }
                    System.out.println(
                            Character.toUpperCase(pos.charAt(0)) + pos.substring(1) + " file loaded: " + filename);
                } catch (IOException e) {
                    System.out.println("Error: File not found - " + filename);
                }
            } else if (command.equals("print")) {
                if (parts.length < 2) {
                    System.out.println("Error: Usage: print <file>");
                    continue;
                }
                String outputFilename = parts[1];
                try {
                    dictionary.printDictionaryToFile(outputFilename);
                    System.out.println("Dictionary printed to " + outputFilename);
                } catch (IOException e) {
                    System.out.println("Error writing to file: " + outputFilename);
                }
            } else if (command.equals("generate")) {
                if (parts.length < 2) {
                    System.out.println("Error: Usage: generate <simple|complex>");
                    continue;
                }
                String type = parts[1].toLowerCase();
                SentenceStructure generator;
                if (type.equals("simple")) {
                    generator = new SimpleSentence(dictionary);
                } else if (type.equals("complex")) {
                    generator = new ComplexSentence(dictionary);
                } else {
                    System.out.println("Unknown generation type.");
                    continue;
                }
                String sentence = generator.generateSentence();
                System.out.println("Generated Sentence: " + sentence);
            } else {
                System.out.println("Error: Unknown command.");
            }
        }
        scanner.close();
    }
}
