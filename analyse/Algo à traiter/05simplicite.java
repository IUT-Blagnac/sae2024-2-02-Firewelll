package iut.sae.algo;

public class Algo {
    public static String RLE(String in) {
        if (in.equals("")) return "";
        String resultat = "";
        char precedent;
        int compteur = 0;
        precedent = in.charAt(0);
        for (char c : in.toCharArray()) {
            if (c == precedent && compteur != 9) {
                compteur++;
                continue;
            }
            resultat += "" + compteur + precedent;
            compteur = 1;
            precedent = c;
        }
        resultat += "" + compteur + precedent;
        return resultat;
    }

    public static String RLE(String in, int iteration) throws AlgoException {

        String encoded = in;

        for (int i = 0; i < iteration; i++) {
            encoded = RLE(encoded);
        }

        return encoded;
    }

    public static String unRLE(String in) throws AlgoException {
        String resultat = "";
        for (int i = 0; i < in.length(); i += 2) {

            String caractere = String.valueOf(in.charAt(i + 1));

            int nbFoisARepetier = Integer.parseInt(String.valueOf(in.charAt(i)));

            resultat += caractere.repeat(nbFoisARepetier);
        }
        return resultat;
    }

    public static String unRLE(String in, int iteration) throws AlgoException {

        String decoded = in;

        for (int i = 0; i < iteration; i++) {
            decoded = unRLE(decoded);
        }

        return decoded;
    }
}
