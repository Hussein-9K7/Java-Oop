package assignment1_dictionary;

import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> data;

    public Dictionary() {
        data = new HashMap<>();
    }

    public void addWord(String word, String meaning) {
        data.put(word.toLowerCase(), meaning);
    }

    public String getMeaning(String word) throws Exception {
        String meaning = data.get(word.toLowerCase());
        if (meaning == null) {
            throw new Exception("Word not found in dictionary.");
        }
        return meaning;
    }
}
