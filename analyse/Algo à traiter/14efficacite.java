/**
 * La classe Efficacite fournit des méthodes pour compresser et décompresser des chaînes de caractères 
 * en utilisant l'algorithme de Run-Length Encoding (RLE).
 */
public class Efficacite {

    /**
     * Compresse une chaîne de caractères en utilisant l'algorithme RLE.
     * 
     * @param in La chaîne de caractères à compresser.
     * @return La chaîne de caractères compressée.
     */
    public static String RLE(String in) {
        StringBuilder result = new StringBuilder();
        for (int i = 0, count = 1; i < in.length(); i++) {
            if (i + 1 < in.length() && in.charAt(i) == in.charAt(i + 1) && count < 9) {
                count++;
            } else {
                result.append(count).append(in.charAt(i));
                count = 1;
            }
        }
        return result.toString();
    }

    /**
     * Compresse une chaîne de caractères en utilisant l'algorithme RLE de manière récursive.
     * 
     * @param in La chaîne de caractères à compresser.
     * @param iteration Le nombre d'itérations de compression.
     * @return La chaîne de caractères compressée après le nombre d'itérations spécifié.
     * @throws AlgoException Si une erreur survient pendant la compression.
     */
    public static String RLE(String in, int iteration) throws AlgoException {
        if (iteration == 1)
            return RLE(in);
        else
            return RLE(RLE(in), iteration - 1);
    }

    /**
     * Décompresse une chaîne de caractères en utilisant l'algorithme RLE.
     * 
     * @param in La chaîne de caractères à décompresser.
     * @return La chaîne de caractères décompressée.
     * @throws AlgoException Si une erreur survient pendant la décompression.
     */
    public static String unRLE(String in) throws AlgoException {
        StringBuilder motRetour = new StringBuilder();
        for (int i = 0; i < in.length(); i++) {
            int nombreDeLettre = Integer.parseInt("" + in.charAt(i));
            i++;
            for (int z = 0; z < nombreDeLettre; z++)
                motRetour.append(in.charAt(i));
        }
        return motRetour.toString();
    }

    /**
     * Décompresse une chaîne de caractères en utilisant l'algorithme RLE de manière récursive.
     * 
     * @param in La chaîne de caractères à décompresser.
     * @param iteration Le nombre d'itérations de décompression.
     * @return La chaîne de caractères décompressée après le nombre d'itérations spécifié.
     * @throws AlgoException Si une erreur survient pendant la décompression.
     */
    public static String unRLE(String in, int iteration) throws AlgoException {
        if (iteration == 1)
            return unRLE(in);
        else
            return unRLE(unRLE(in), iteration - 1);
    }
}
