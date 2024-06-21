package iut.sae.algo;

/*
 * Cette classe fournit des méthodes pour les opérations de codage Run-Length (RLE) et de décodage sur les chaînes.
 */
public class Simplicite {
    /**
     * Effectue un codage de longueur d'exécution sur la chaîne d'entrée.
     *
     * @param in la chaîne d'entrée
     * @return   la chaîne codée 
     */
    public static String RLE(String in) {
        if (in == null || in.isEmpty()) {
            return "";
        }

        StringBuilder res = new StringBuilder();
        int counting = 1;

        for (int i = 1; i < in.length(); i++) {
            if (in.charAt(i) == in.charAt(i - 1)) {
                counting++;
            } else {
                res.append(counting).append(in.charAt(i - 1));
                counting = 1;
            }
        }

        res.append(counting).append(in.charAt(in.length() - 1));
        return res.toString();
    }

    /**
     * Décode une chaîne qui a été codée à l’aide.
     *
     * @param in             la chaîne codée 
     * @return               la chaîne originale décodée
     * @throws AlgoException si la chaîne d'entrée est nulle ou vide
     */
    public static String unRLE(String in) throws AlgoException {
        if (in == null || in.isEmpty()) {
            return "";
        }

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < in.length(); i += 2) {
            int compter = Character.getNumericValue(in.charAt(i));
            char c = in.charAt(i + 1);
            for (int j = 0; j < compter; j++) {
                res.append(c);
            }
        }

        return res.toString();
    }

    /**
     * Exécute sur la chaîne d'entrée de manière itérative un nombre de fois spécifié.
     *
     * @param in             la chaîne d'entrée 
     * @param iteration      le nombre de fois où appliquer RLE de manière itérative
     * @return               la chaîne codée de manière itérative
     * @throws AlgoException si la chaîne d'entrée est nulle ou vide
     */
    public static String RLE(String in, int iteration) throws AlgoException {
        for (int i = 0; i < iteration; i++) {
            in = RLE(in);
        }
        return in;
    }

    /**
     * Décode une chaîne qui a été codée à l'aide de manière itérative un nombre de fois spécifié.
     *
     * @param in             la chaîne codée 
     * @param iteration      le nombre de fois pour appliquer le décodage RLE de manière itérative
     * @return               la chaîne originale décodée de manière itérative
     * @throws AlgoException si la chaîne d'entrée est nulle ou vide
     */
    public static String unRLE(String in, int iteration) throws AlgoException {
        for (int i = 0; i < iteration; i++) {
            in = unRLE(in);
        }
        return in;
    }
}