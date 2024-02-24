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
 * @author hcadavid Modified by fchaves
 */
@Component("englishDictionary")
public class EnglishDictionaryDataSource extends HangmanDictionary {

    static private String words[] = {
            "PLAYER",
            "BALL",
            "SOCCER",
            "RAGE",
            "GAME"
    };

    public EnglishDictionaryDataSource() {
        setAvalariableWords(Arrays.asList(words));
    }

    public List<String> getAvailableWords() {
        return Arrays.asList(words);
    }
}
