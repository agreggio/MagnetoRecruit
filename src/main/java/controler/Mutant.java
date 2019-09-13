
package controler;




/**
 *
 * @author Alejandro Greggio
 */
public class Mutant {

    static public boolean isMutant(String[] dna) {
       
       

        int totalDna = 0;

        for (int i = 0; i < dna.length; i++) {
            for (int j = 0; j < dna[i].length(); j++) {

                // Control Horizontal
                if (j < dna[i].length() - 3) {
                    if (isEqual(dna[i].charAt(j), dna[i].charAt(j + 1), dna[i].charAt(j + 2), dna[i].charAt(j + 3))) {
                        totalDna++;
                    }
                }
                // Control Vertical
                if (i < dna.length - 3) {
                    // vertical check
                    if (isEqual(dna[i].charAt(j), dna[i + 1].charAt(j), dna[i + 2].charAt(j), dna[i + 3].charAt(j))) {
                        totalDna++;
                    }
                }
                
                //Control Diagonal
                if (i < dna.length - 3 && j < dna[i].length() - 3) {
                    if (isEqual(dna[i].charAt(j), dna[i + 1].charAt(j + 1), dna[i + 2].charAt(j + 2), dna[i + 3].charAt(j + 3))) {
                        totalDna++;
                    }
                }

                //Control Diagonal Invertido
                if (i >= 3 && j < dna[i].length() - 3) {         
                    if (isEqual(dna[i].charAt(j), dna[i - 1].charAt(j + 1), dna[i - 2].charAt(j + 2), dna[i - 3].charAt(j + 3))) {
                        totalDna++;
                    }
                }
                
                if (totalDna > 1) {
                    return true;
                }

            }

        }

        return false;
    }
    
     public static boolean isEqual(char a, char b, char c, char d) {
        return a == b && b == c && c == d;
    }

}
