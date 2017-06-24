package com.mygdx.game.Providers;

/**
 * Created by dan on 18/06/17.
 */
public class Utils {
    public static int countDigits(int nWidth) {
        if (nWidth / 10 == 0) {
            return (1);
        }

        return (1 + countDigits(nWidth / 10));

    }
}
