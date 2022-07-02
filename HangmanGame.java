import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class HangmanGame {
    
    private String word;
    private StringBuilder playerword;

    private TreeSet<Character> guesses;

    static String words_txt = "C://Users//mail2//SoftDevII//Hangman-GUI/words.txt";

    private static String wordPicker() throws IOException {
        Integer id = 0;
        File wordsfile = new File(words_txt);
        Scanner scanner = new Scanner(wordsfile);
        HashMap<Integer, String> map = new HashMap<>();
        Random random = new Random();
        while (scanner.hasNext() != false) {
            map.put(id, scanner.nextLine());
            id++;
        }
        int wordID = random.nextInt(id - 1);
        scanner.close();
        return map.get(wordID);
    }

    public HangmanGame() throws IOException {
        this.word = wordPicker();
        this.playerword = new StringBuilder();
        this.guesses = new TreeSet<>();
        for (char c : word.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                playerword.append("_");
            }
        }
    }

    public void makeGuess(char c) { 
        
        int max = 10;
        int guess_count = 0;
        if (guesses.contains(c)) {
            System.out.println("Guess invalid try again");
        }
        else{
            guesses.add(c);
        }
        for (int i = 0; i < word.length(); i++) {
            char s = word.charAt(i);
            if (s == c) {
                guess_count++;
                playerword.setCharAt(i, c);
            }
        }    

    }

    public StringBuilder getPlayerword() {
        return playerword;
    }

    public String getWord() {
        return word;
    }

    public TreeSet<Character> getGuesses() {
        return guesses;
    }

    public static void main(String[] args) throws IOException {
        HangmanGame hGame = new HangmanGame();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Word: " + hGame.getWord() + " players guesses: " + hGame.getPlayerword());
        while(true){
            if(scanner.hasNext()){
                String character = scanner.next();
                char[] ch = character.toCharArray();
                hGame.makeGuess(ch[0]);
            }
            
            if(!new String(hGame.getPlayerword()).contains("_")){
                break;
            };
            System.out.println(hGame.getPlayerword());
            System.out.println(hGame.getGuesses());
        }
        System.out.println(hGame.getPlayerword());
        System.out.println(hGame.getGuesses());
        scanner.close();



    }
}
