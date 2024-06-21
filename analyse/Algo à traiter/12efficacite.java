public class Algo {

    public static String RLE(String chaine) {
        if (chaine == null || chaine.isEmpty()) {
            return "";
        }

        StringBuilder resultat = new StringBuilder();
        int compteur = 1;
        char premierCaractere = chaine.charAt(0);

        for (int i = 1; i < chaine.length(); i++) {
            if (chaine.charAt(i) == premierCaractere) {
                compteur++;
                if (compteur == 9) {
                    resultat.append(9).append(premierCaractere);
                    compteur = 0;
                }
            } else {
                if (compteur > 0) {
                    resultat.append(compteur).append(premierCaractere);
                }
                premierCaractere = chaine.charAt(i);
                compteur = 1;
            }
        }

        if (compteur > 0) {
            resultat.append(compteur).append(premierCaractere);
        }

        return resultat.toString();
    }

    public static String unRLE(String chaine) {
        if (chaine == null || chaine.isEmpty()) {
            return "";
        }

        StringBuilder resultat = new StringBuilder();
        int i = 0;

        while (i < chaine.length()) {
            char caractere = chaine.charAt(i);
            if (Character.isDigit(caractere)) {
                int nombre = Character.getNumericValue(caractere);
                char caractereSuivant = chaine.charAt(i + 1);
                for (int j = 0; j < nombre; j++) {
                    resultat.append(caractereSuivant);
                }
                i += 2;
            } else {
                resultat.append(caractere);
                i++;
            }
        }

        return resultat.toString();
    }

    public static String RLE_Recursif(String chaine, int iteration) {
        String resultat = chaine;
        for (int i = 0; i < iteration; i++) {
            resultat = RLE(resultat);
        }
        return resultat;
    }

    public static String unRLE_Recursif(String chaine, int iteration) {
        String resultat = chaine;
        for (int i = 0; i < iteration; i++) {
            resultat = unRLE(resultat);
        }
        return resultat;
    }

    public static void main(String[] args) {
        String compressed = RLE("wwwwwwwwwwww");
        System.out.println("Compressed: " + compressed);  // Output: "9w3w"

        String decompressed = unRLE(compressed);
        System.out.println("Decompressed: " + decompressed);  // Output: "wwwwwwwwwwww"
    }
}
