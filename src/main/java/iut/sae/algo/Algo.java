package iut.sae.algo;

public class Algo {
    /**
     * Effectue une compression RLE (Run-Length Encoding) sur la chaîne d'entrée.
     *
     * @param in La chaîne d'entrée à compresser.
     * @return La chaîne compressée en utilisant RLE.
     */
    public static String RLE(String in) {
        // Si la chaîne est vide, retourner directement.
        if (in.length() < 1)
            return in;

        // Initialiser le compteur pour les caractères répétés
        int compteur = 0;
        // Stocker le premier caractère de la chaîne
        char last = in.charAt(0);
        // Utiliser StringBuilder pour construire le résultat compressé
        StringBuilder resultat = new StringBuilder();

        // Parcourir chaque caractère de la chaîne d'entrée
        for (int i = 0; i < in.length(); i++) {
            // Si le caractère actuel est le même que le précédent
            if (in.charAt(i) == last) {
                compteur++;
                // Si le compteur atteint 9, ajouter au résultat et réinitialiser
                if (compteur == 9) {
                    resultat.append(compteur).append(last);
                    compteur = 1; // Réinitialiser le compteur pour le nouveau segment
                }
            } else {
                // Ajouter le compteur et le dernier caractère au résultat
                resultat.append(compteur).append(last);
                // Réinitialiser le compteur pour le nouveau caractère
                compteur = 1;
                last = in.charAt(i); // Mettre à jour le dernier caractère
            }
        }

        // Ajouter les derniers caractères comptés au résultat
        return resultat + "" + compteur + "" + last;
    }

    /**
     * Effectue plusieurs itérations de compression RLE.
     *
     * @param in La chaîne d'entrée à compresser.
     * @param iteration Le nombre d'itérations de compression à effectuer.
     * @return La chaîne compressée après les itérations spécifiées.
     * @throws AlgoException Si une erreur se produit durant la compression.
     */
    public static String RLE(String in, int iteration) throws AlgoException {
        // Initialiser le résultat avec la chaîne d'entrée
        String resultat = in;
        // Effectuer la compression pour le nombre d'itérations spécifié
        for (int i = 0; i < iteration; i++)
            resultat = RLE(resultat);
        return resultat;
    }

    /**
     * Décompresse une chaîne encodée en RLE.
     *
     * @param in La chaîne compressée en RLE à décompresser.
     * @return La chaîne décompressée.
     * @throws AlgoException Si une erreur se produit durant la décompression.
     */
    public static String unRLE(String in) throws AlgoException {
        // Utiliser StringBuilder pour construire le résultat décompressé
        StringBuilder decode = new StringBuilder();
        // Parcourir la chaîne deux caractères à la fois
        for (int i = 0; i < in.length() - 1; i += 2) {
            // Obtenir le nombre de répétitions (premier caractère)
            int count = Integer.parseInt(String.valueOf(in.charAt(i)));
            // Obtenir le caractère à répéter (deuxième caractère)
            char c = in.charAt(i + 1);
            // Ajouter le caractère au résultat le nombre de fois indiqué par le compteur
            for (int j = 0; j < count; j++)
                decode.append(c);
        }
        return decode + "";
    }

    /**
     * Effectue plusieurs itérations de décompression RLE.
     *
     * @param in La chaîne compressée à décompresser.
     * @param iteration Le nombre d'itérations de décompression à effectuer.
     * @return La chaîne décompressée après les itérations spécifiées.
     * @throws AlgoException Si une erreur se produit durant la décompression.
     */
    public static String unRLE(String in, int iteration) throws AlgoException {
        // Initialiser le résultat avec la chaîne d'entrée
        String decode = in;
        // Effectuer la décompression pour le nombre d'itérations spécifié
        for (int i = 0; i < iteration; i++) {
            decode = unRLE(decode);
        }
        return decode;
    }
}
