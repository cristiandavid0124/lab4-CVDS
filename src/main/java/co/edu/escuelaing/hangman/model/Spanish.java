/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.hangman.model;

import org.springframework.stereotype.Component;

/**
 * @author 2106913
 */
@Component("spanishLanguage")
public class Spanish implements Language {

    @Override
    public String[] getFunctionControllerNames() {
        return new String[]{"Jugar", "Altos Puntajes", "Creditos"};
    }

    @Override
    public String getPointsNameLabel() {
        return "Puntaje: ";
    }

    @Override
    public String getHangmanLabel() {
        return "Ahorcado";
    }

    @Override
    public String[] getBackSkypeButtonLabel() {
        return new String[]{"Atras", "Omitir"};
    }

    @Override
    public String[] getAccesButton() {
        return new String[]{"¡Juego terminado!", "Nuevo Juego", "Menú Principal"};
    }

    @Override
    public String getFinalScorelabel() {
        return "Puntuación Final: ";
    }

}
