public class efficacite1 {
        /**
     * Run Length Encoding algorithme classique 
     * @param in chaîne à compresser en entrée 
     * @return retourne la chaîne compressée
     */
    public static String RLE(String in){
        if (in == "") {
            return in;
        }
        
        int cptC = 1; // compteur de caractères 
        int sizeChaineIn = in.length(); // taille chaîne en entrée 
        StringBuilder chaineCompressee = new StringBuilder(); // chaîne finale 


        // parcours de la chaîne en entrée
        for (int i = 0; i < sizeChaineIn; i++) {
            if (i != sizeChaineIn - 1) {
                // cas usuels (si je ne suis pas à la dernière lettre)
                if (in.charAt(i) == in.charAt(i+1)) {
                    cptC++;
                    // limiter à des paquets de 9 
                    if (cptC == 9) {
                        chaineCompressee.append(cptC).append(in.charAt(i));  
                        cptC = 1;
                        i++; // régler le décalage des paquets de 9 (parce qu'on regarde le i + 1 dans la comparaison de char)
                    }
                } else {
                    chaineCompressee.append(cptC).append(in.charAt(i));   
                    cptC = 1;
                }
            } else {
                // cas de la dernière lettre 
                chaineCompressee.append(cptC).append(in.charAt(i));    
            }
        }
        return chaineCompressee.toString(); // toString pour retourner une chaîne de caractères
    }

    /**
     * Run Length Encoding avec itérations (récursif)
     * @param in chaîne à compresser en entrée 
     * @param iteration le nombre de fois qu'il faut compresser le message en entrée 
     * @return retourne la chaîne compressée récursivement
     * @throws AlgoException
     */
    public static String RLE(String in, int iteration) throws AlgoException{
  
        int cptC = 1; // compteur de caractères 
        int sizeChaineIn = in.length(); // taille chaîne en entrée 
        StringBuilder chaineCompressee = new StringBuilder(); // chaîne finale 

        // cas de sortie de récursivité
        if (iteration == 0 || in == "") {
            return in;
        }

        // exceptions users
        if (iteration <= 0) {
            throw new AlgoException("Le nombre d'itérations ne peut pas être négatif ou nul ! ");
        }


        // parcours de la chaîne en entrée
        for (int i = 0; i < sizeChaineIn; i++) {
            if (i != sizeChaineIn - 1) {
                // cas usuels (si je ne suis pas à la dernière lettre)
                if (in.charAt(i) == in.charAt(i+1)) {
                    cptC++;
                    // limiter à des paquets de 9 
                    if (cptC == 9) {
                        chaineCompressee.append(cptC).append(in.charAt(i));  
                        cptC = 1;
                        i++; // régler le décalage des paquets de 9 (parce qu'on regarde le i + 1 dans la comparaison de char)
                    }
                } else {
                    chaineCompressee.append(cptC).append(in.charAt(i));   
                    cptC = 1;
                }
            } else {
                // cas de la dernière lettre 
                chaineCompressee.append(cptC).append(in.charAt(i));    
            }
        }
        return RLE(chaineCompressee.toString(), iteration-1); // appel récursif
    }
}
