/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Alejandro Greggio
 */
public class ValidDna {

    public static boolean isValidDna(String[] dna) {

        for (int i = 0; i < dna.length; i++) {

            if (dna[i].length() < 4 || dna.length < 4 || dna[i].length() != dna.length) {

                return false;

            }
            if (dna[i].matches(".*[^ATCG].*")) {
                return false;
            }

        }

        return true;
    }

}
