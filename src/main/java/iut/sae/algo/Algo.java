package iut.sae.algo;


public class Algo{
    /**
     * Compresse une chaîne de caractères 
     *
     * @param in la chaîne de caractères à compresser
     * @return la chaîne compressée
     */
    public static String RLE(String in){
        String res ="";
        int i=0;
        int frequence =1;
        while(i<in.length()-1 && in!="") {
            if (in.charAt(i)==in.charAt(i+1)){
                frequence++;
            }else{
                res=res+frequence+in.charAt(i);
                frequence=1;
            }
            if (frequence>9) {
                res=res+9+in.charAt(i);
                frequence=1;
            }
            i++;
        }
        if (in!=""){
            res=res+frequence+in.charAt(i);
        }

        return res;
    
    }

     /**
     * Compresse une chaîne de caractères en utilisant l'algorithme de Run-Length Encoding (RLE) de manière récursive.
     *
     * @param in la chaîne de caractères à compresser
     * @param iteration le nombre d'itérations de compression
     * @return la chaîne compressée après le nombre d'itérations spécifié
     * @throws AlgoException si une erreur se produit lors de la compression
     */
    public static String RLE(String in, int iteration) throws AlgoException{
        if (iteration==1){
            return RLE(in);
        }else{
            return RLE(RLE(in, iteration-1));
        } 
    }

    /**
     * Décompresse une chaîne de caractères 
     *
     * @param in la chaîne de caractères à décompresser
     * @return la chaîne décompressée
     * @throws AlgoException si une erreur se produit lors de la décompression
     */
    public static String unRLE(String in) throws AlgoException{
        String res ="";
        int i=0;
        while(i<in.length()-1 && in!=""){
            int nbc=Integer.parseInt(String.valueOf(in.charAt(i)));
            for(int j= 0; j<nbc; j++){
                res=res+in.charAt(i+1);
            }
            i=i+2;
        }
        return res;

    }

    /**
     * Décompresse une chaîne de caractères en utilisant l'algorithme de Run-Length Encoding (RLE) de manière récursive.
     *
     * @param in la chaîne de caractères à décompresser
     * @param iteration le nombre d'itérations de décompression
     * @return la chaîne décompressée après le nombre d'itérations spécifié
     * @throws AlgoException si une erreur se produit lors de la décompression
     */
    public static String unRLE(String in, int iteration) throws AlgoException{
        if (iteration==1){
            return unRLE(in);
        }else{
            return unRLE(unRLE(in,iteration-1));
        }
    }
}

