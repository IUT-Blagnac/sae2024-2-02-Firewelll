package iut.sae.algo;

public class Simplicite {
    
    public static String RLE(String in) {
        if (in == null || in.isEmpty()) {
            return "";
        }
        StringBuilder resultat = new StringBuilder();
        int cpt = 1;
        for (int i = 1; i < in.length(); i++) {
            if (in.charAt(i) != in.charAt(i - 1) || cpt >= 9) {
                resultat.append(cpt).append(in.charAt(i - 1));
                cpt = 1;
            } else {
                cpt++;
            }
        }
        resultat.append(cpt).append(in.charAt(in.length() - 1));
        return resultat.toString();
    }

    
    public static String RLE(String in, int iteration) throws AlgoException {
        if (iteration < 1) {
            throw new AlgoException("Iteration doit être >= 1");
        }
        String resultat = in;
        for (int i = 0; i < iteration; i++) {
            resultat = RLE(resultat);
        }
        return resultat;
    }

    
    public static String unRLE(String in) throws AlgoException {
        if (in == null || in.isEmpty()) {
            return "";
        }
        StringBuilder resultat = new StringBuilder();
        int cpt = 0;
        for (char c : in.toCharArray()) {
            if (Character.isDigit(c)) {
                cpt = cpt * 10 + Character.getNumericValue(c);
            } else {
                for (int i = 0; i < cpt; i++) {
                    resultat.append(c);
                }
                cpt = 0;
            }
        }
        return resultat.toString();
    }

  
    public static String unRLE(String in, int iteration) throws AlgoException {
        if (iteration < 1) throw new AlgoException("Iteration devrait être >= 1");
        String result = in;
        for (int i = 0; i < iteration; i++) {
            result = unRLE(result);
        }
        return result;
    }
}
