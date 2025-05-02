package assignment1_dictionary;

public class DictionaryController {
    private Dictionary dictionary;

    public DictionaryController() {
        dictionary = new Dictionary();

        // كلمات مضافة مؤقتاً
        dictionary.addWord("java", "A high-level programming language.");
        dictionary.addWord("dictionary", "A resource that lists words and their meanings.");
        dictionary.addWord("cat", "A small domesticated carnivorous mammal.");
    }

    public String searchWord(String word) {
        if (word == null || word.trim().isEmpty()) {
            return "Please enter a word.";
        }
        try {
            return dictionary.getMeaning(word);
        } catch (Exception e) {
            return "Word not found.";
        }
    }
}
