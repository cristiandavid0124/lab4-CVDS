/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.hangman.model.dictionary;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author 2106913
 */
@Component("frenchDictionary")
public class FrenchDictionaryDataSource extends HangmanDictionary {

    static private String words[] = {
            "TOUS",
            "AVOIR",
            "APRÈS",
            "TRÈS",
            "VOILÀ"
    };

    public FrenchDictionaryDataSource() {
        setAvalariableWords(Arrays.asList(words));
    }

    public List<String> getAvailableWords() {
        return Arrays.asList(words);
    }

    @Override
    public List<Character> createCharacterSet() {
        List<Character> result = super.createCharacterSet();
        result.add((char) 192);
        result.add((char) 200);
        result.add((char) 204);
        result.add((char) 210);
        result.add((char) 217);
        return result;
    }

}
