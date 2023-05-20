
package hangmanexam;
import java.util.ArrayList;
import java.util.Random;

public class Words {
    private ArrayList<Word> listOfWords;
    private Random rand;
    private Word emergencyWord;
    private String[] words;

    public Words() {
        this.listOfWords = new ArrayList<>();
        this.rand = new Random();
        this.emergencyWord = new Word("java");
        this.words = new String[]{"computer", "programming", "java", "python", "software", "Crying", "database","Pulp Fiction",
"Schindler's List","Inception","Fight Club","Forrest Gump","The Matrix","Goodfellas","Parasite","Interstellar",
"City of God","Spirited Away","Saving Private Ryan","The Green Mile","Life Is Beautiful","Seven Samurai","Whiplash","arm",
"back","ears","eyes","face","feet","fingers","foot","hair","hands","head",};
    }

    public void addWordsToListOfWords(String[] customWords) {
        for (String word : customWords) {
            Word newWord = new Word(word);
            listOfWords.add(newWord);
        }
    }

    public Word selectRandomWord() {
        if (this.listOfWords.size() > 0) {
            int upperbound = this.listOfWords.size();
            return this.listOfWords.get(rand.nextInt(upperbound));
        }
        return this.emergencyWord;
    }

    public void resetListOfWords() {
        this.listOfWords.clear();
    }

    public Word getRandomWord() {
        if (listOfWords.size() > 0) {
            int index = rand.nextInt(listOfWords.size());
            return listOfWords.get(index);
        } else {
            int index = rand.nextInt(words.length);
            return new Word(words[index]);
        }
    }
}
