package co.edu.escuelaing.hangman.model;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class GameScoreTest {
    /*
    Original Score test
    Clases de equivalencia:
    - Dado 0 correctas y 0 incorrectas (inicio del juego), el puntaje debe ser 100
    - Se debe penalizar cada incorrecta con 10 puntos
    - Si el número de incorrectas es mayor o igual a 10, el puntaje debe ser 0
    - Si el número de correctas es mayor o igual a 0, el puntaje no debe cambiar (no se bonifican las correctas)
    - El numero de correctas no puede ser negativo
    - El número de incorrectas no puede ser negativo
     */
    @Test
    public void OriginalScore_Should_ScoreEqual100_When_GameStart() {
        //Given
        OriginalScore originalScore = new OriginalScore();
        int correctCount = 0;
        int incorrectCount = 0;

        //When
        int score = originalScore.calculateScore(correctCount, incorrectCount);

        //Then
        Assert.assertEquals(100, score);
    }

    @Test
    public void OriginalScore_Should_Penalize_When_IncorrectGuess() {
        //Given
        OriginalScore originalScore = new OriginalScore();
        int correctCount = 0;
        int incorrectCount = 1;

        //When
        int score = originalScore.calculateScore(correctCount, incorrectCount);

        //Then
        Assert.assertEquals(90, score);
    }

    @Test
    public void OriginalScore_Should_MinimalScore0_When_IncorrectGuess() {
        //Given
        OriginalScore originalScore = new OriginalScore();
        int correctCount = 0;
        int incorrectCountLimit = 10;
        int incorrectCountGreater = 11;
        int incorrectCountLess = 9;

        //When
        int scoreLimit = originalScore.calculateScore(correctCount, incorrectCountLimit);
        int scoreGreater = originalScore.calculateScore(correctCount, incorrectCountGreater);
        int scoreLess = originalScore.calculateScore(correctCount, incorrectCountLess);

        //Then
        Assert.assertEquals(0, scoreLimit);
        Assert.assertEquals(0, scoreGreater);
        Assert.assertEquals(10, scoreLess);
    }

    @Test
    public void OriginalScore_Should_NotChange_When_CorrectGuess() {
        //Given
        OriginalScore originalScore = new OriginalScore();
        int correctCount = 1;
        int incorrectCount = 0;

        //When
        int score = originalScore.calculateScore(correctCount, incorrectCount);

        //Then
        Assert.assertEquals(100, score);
    }

    @Test
    public void OriginalScore_Should_ThrowException_When_CorrectCountLessThan0() {
        //Given
        OriginalScore originalScore = new OriginalScore();
        int correctCount = -1;
        int incorrectCount = 0;

        //When & Assert
        Assert.assertThrows(IllegalArgumentException.class, () -> originalScore.calculateScore(correctCount, incorrectCount));
    }

    @Test
    public void OriginalScore_Should_ThrowException_When_IncorrectCountLessThan0() {
        //Given
        OriginalScore originalScore = new OriginalScore();
        int correctCount = 0;
        int incorrectCount = -1;

        //When & Assert
        Assert.assertThrows(IllegalArgumentException.class, () -> originalScore.calculateScore(correctCount, incorrectCount));
    }

    /*
    Bonus Score test
    Clases de equivalencia:
    - Dado 0 correctas y 0 incorrectas (inicio del juego), el puntaje debe ser 0
    - Dado 0 correctas y 1 incorrecta, el puntaje debe ser 0 (puntaje mínimo 0)
    - Se debe penalizar cada incorrecta con 5 puntos
    - Si el número de correctas es mayor a 0, se bonifica cada correcta con 10 puntos
    - El numero de correctas no puede ser negativo
    - El número de incorrectas no puede ser negativo
     */

    @Test
    public void BonusScore_Should_ScoreEqual0_When_GameStart() {
        //Given
        BonusScore bonusScore = new BonusScore();
        int correctCount = 0;
        int incorrectCount = 0;

        //When
        int score = bonusScore.calculateScore(correctCount, incorrectCount);

        //Then
        Assert.assertEquals(0, score);
    }

    @Test
    public void BonusScore_Should_Penalize_When_IncorrectGuess() {
        //Given
        BonusScore bonusScore = new BonusScore();
        int correctCount = 1;
        int incorrectCount = 1;

        //When
        int score = bonusScore.calculateScore(correctCount, incorrectCount);

        //Then
        Assert.assertEquals(5, score);
    }

    @Test
    public void BonusScore_Should_Bonus_When_CorrectGuess() {
        //Given
        BonusScore bonusScore = new BonusScore();
        int correctCount = 1;
        int incorrectCount = 0;

        //When
        int score = bonusScore.calculateScore(correctCount, incorrectCount);

        //Then
        Assert.assertEquals(10, score);
    }

    @Test
    public void BonusScore_Should_MinimalScore0_When_IncorrectGuess() {
        //Given
        BonusScore bonusScore = new BonusScore();
        int correctCount = 0;
        int incorrectCount = 1;

        //When
        int score = bonusScore.calculateScore(correctCount, incorrectCount);

        //Then
        Assert.assertEquals(0, score);
    }

    @Test
    public void BonusScore_Should_ThrowException_When_CorrectCountLessThan0() {
        //Given
        BonusScore bonusScore = new BonusScore();
        int correctCount = -1;
        int incorrectCount = 0;

        //When & Assert
        Assert.assertThrows(IllegalArgumentException.class, () -> bonusScore.calculateScore(correctCount, incorrectCount));
    }

    @Test
    public void BonusScore_Should_ThrowException_When_IncorrectCountLessThan0() {
        //Given
        BonusScore bonusScore = new BonusScore();
        int correctCount = 0;
        int incorrectCount = -1;

        //When & Assert
        Assert.assertThrows(IllegalArgumentException.class, () -> bonusScore.calculateScore(correctCount, incorrectCount));
    }

    /*
    Power Score test
    Clases de equivalencia:
    - Dado 0 correctas y 0 incorrectas (inicio del juego), el puntaje debe ser 0
    - Dado 0 correctas y 1 incorrecta, el puntaje debe ser 0 (puntaje mínimo 0)
    - Se debe penalizar cada incorrecta con 8 puntos
    - Si el número de correctas es mayor a 0, se bonifica la i-ésima correcta con 5^i
    - El numero de correctas no puede ser negativo
    - El número de incorrectas no puede ser negativo
    - El puntaje máximo es 500
     */

    @Test
    public void PowerScore_Should_ScoreEqual0_When_GameStart() {
        //Given
        PowerScore powerScore = new PowerScore();
        int correctCount = 0;
        int incorrectCount = 0;

        //When
        int score = powerScore.calculateScore(correctCount, incorrectCount);

        //Then
        Assert.assertEquals(0, score);
    }

    @Test
    public void PowerScore_Should_Penalize_When_IncorrectGuess() {
        //Given
        PowerScore powerScore = new PowerScore();
        int correctCount = 2;
        int incorrectCount = 1;

        //When
        int score = powerScore.calculateScore(correctCount, incorrectCount);

        //Then
        Assert.assertEquals(22, score);
    }

    @Test
    public void PowerScore_Should_Bonus_When_CorrectGuess() {
        //Given
        PowerScore powerScore = new PowerScore();
        int correctCount1 = 1;
        int correctCount2 = 2;
        int correctCount3 = 3;
        int incorrectCount = 0;

        //When
        int score1 = powerScore.calculateScore(correctCount1, incorrectCount);
        int score2 = powerScore.calculateScore(correctCount2, incorrectCount);
        int score3 = powerScore.calculateScore(correctCount3, incorrectCount);

        //Then
        Assert.assertEquals(5, score1);
        Assert.assertEquals(30, score2);
        Assert.assertEquals(155, score3);
    }

    @Test
    public void PowerScore_Should_MinimalScore0_When_IncorrectGuess() {
        //Given
        PowerScore powerScore = new PowerScore();
        int correctCount = 0;
        int incorrectCount = 1;

        //When
        int score = powerScore.calculateScore(correctCount, incorrectCount);

        //Then
        Assert.assertEquals(0, score);
    }

    @Test
    public void PowerScore_Should_ThrowException_When_CorrectCountLessThan0() {
        //Given
        PowerScore powerScore = new PowerScore();
        int correctCount = -1;
        int incorrectCount = 0;

        //When & Assert
        Assert.assertThrows(IllegalArgumentException.class, () -> powerScore.calculateScore(correctCount, incorrectCount));
    }

    @Test
    public void PowerScore_Should_ThrowException_When_IncorrectCountLessThan0() {
        //Given
        PowerScore powerScore = new PowerScore();
        int correctCount = 0;
        int incorrectCount = -1;

        //When & Assert
        Assert.assertThrows(IllegalArgumentException.class, () -> powerScore.calculateScore(correctCount, incorrectCount));
    }


}
