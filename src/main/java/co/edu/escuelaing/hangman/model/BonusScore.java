package co.edu.escuelaing.hangman.model;

import org.springframework.stereotype.Component;

@Component("bonusScore")
public class BonusScore implements GameScore{


    public BonusScore() {
    }

    /** Calcula el puntaje de acuerdo a las letras correctas e incorrectas.
     *
     * @pre  inicia con 0 puntos.
     * @post El minimo puntaje es 0.
     * @param correctCount Cantidad de letras correctas.
     * @param incorrectCount Cantidad de letras incorrectas.
     * @return Puntaje con bonificacion de 10 puntos por cada letra correcta
     * y penalizacion de 5 puntos por cada letra incorrecta.
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount) throws IllegalArgumentException {
        if (correctCount < 0 || incorrectCount < 0){
            throw new IllegalArgumentException("Ningun contador puede ser negativo.");
        }
        int score = 0;
        score += correctCount*10;
        score -= incorrectCount*5;
        return score <= 0 ? 0 : score;
    }

}
