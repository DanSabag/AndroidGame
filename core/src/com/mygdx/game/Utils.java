package com.mygdx.game;

import java.util.Random;

public class Utils {
    /* -----------------------------
              Data members
    --------------------------------*/
    private static Random fRandom = new Random();

    /* -----------------------------
                Functions
    --------------------------------*/
    public static int countDigits(int nWidth) {
        if (nWidth / 10 == 0) {
            return (1);
        }

        return (1 + countDigits(nWidth / 10));
    }

//    public static float getGussian(double fMean, double fVariance) {
//        return (float)(fMean + fRandom.nextGaussian() * fVariance);
//    }

    public static int getRandomInteger(int nStart, int nEnd) throws IllegalArgumentException {
        if (nEnd < nStart) {
            throw new IllegalArgumentException("End cannot exceed start.");
        }

        return (nStart + fRandom.nextInt(nEnd));
    }
}
