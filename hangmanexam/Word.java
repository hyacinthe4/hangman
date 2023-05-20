/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmanexam;

public class Word {

    private String word;
    private char[] lettersInWord;
    
    

    public Word(String word) {
        this.word = word;
    }

    Word() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
    public void splitWordToLetters() {
        /*
        Splits the word into letters for comparison against letter clicked on keyboard
         */

        this.lettersInWord = this.word.toCharArray();
    }

    public char[] getLettersInWord() {
        return this.lettersInWord;
    }

    public String getWord() {
        return this.word;
    }
}
