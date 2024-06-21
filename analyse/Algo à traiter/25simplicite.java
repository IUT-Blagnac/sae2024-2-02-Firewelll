package iut.sae.algo;


public class Simplicite {
    public static String RLE(String in){
        
        // Cas chaîne vide
        if(in == null || in.isEmpty()) {
            return "";
        }

        int cpt = 0; // Compteur de caractères
        char dernierChar = in.charAt(0); // Dernier caractère
        StringBuilder resultat = new StringBuilder(); // Résultat

        for(int i = 0; i < in.length(); i++) { // Parcours de la chaîne
            if(in.charAt(i) == dernierChar) { // Si le caractère i est le même que le dernier
                if (cpt >= 9) { // Si le compteur est supérieur ou égal à 9
                    resultat.append(cpt).append(dernierChar); // On ajoute 9 et le dernier caractère au résultat
                    cpt = 0; // On réinitialise le compteur
                }
                cpt++; // On incrémente le compteur 
            } else { // Sinon
                resultat.append(cpt).append(dernierChar); // On ajoute le compteur et le dernier caractère au résultat
                dernierChar = in.charAt(i); // On met à jour le dernier caractère
                cpt = 1; // On réinitialise le compteur
            }
        }

        resultat.append(cpt).append(dernierChar); // On ajoute le dernier compteur et le dernier caractère au résultat
        
        return resultat.toString(); // On retourne le résultat
    }

    public static String RLE(String in, int iteration) throws AlgoException{
        
        // Cas chaîne vide
        if(in == null || in.isEmpty()) {
            return "";
        }

        if(iteration <= 0) { // Si l'itération est inférieure ou égale à 0
            throw new AlgoException("L'itération doit être supérieure à 0"); // On lance une exception
        }

        String resultat = in; // Résultat

        for(int i = 0; i < iteration; i++) { // Parcours des itérations
            resultat = RLE(resultat); // On applique l'algorithme RLE
        }

        return resultat; // On retourne le résultat
    }

    public static String unRLE(String in) throws AlgoException{
        
        // Cas chaîne vide
        if(in == null || in.isEmpty()) {
            return "";
        }

        StringBuilder resultat = new StringBuilder(); // Résultat
        
        for(int i =0; i < in.length(); i++) { // Parcours de la chaîne
            if(Character.isDigit(in.charAt(i))) { // Si le caractère i est un chiffre
                int nbFois = Character.getNumericValue(in.charAt(i)); // On récupère le chiffre
                if(nbFois >= 9){ // Si le chiffre est supérieur ou égal à 9
                    for(int j = 0; j < 9; j++) { // On ajoute le caractère suivant au résultat 9 fois
                        resultat.append(in.charAt(i+1)); 
                    }
                    for(int j = 0; j < nbFois-9; j++) { // On ajoute le caractère suivant au résultat (nbFois-9) fois
                        resultat.append(in.charAt(i+1));
                    }
                } else { // Sinon si le chiffre est inférieur à 9
                    for(int j = 0; j < nbFois; j++) { // On ajoute le caractère suivant au résultat nbFois fois
                        resultat.append(in.charAt(i+1));
                    }
                }
            } 
        }

        return resultat.toString(); // On retourne le résultat
    }

    public static String unRLE(String in, int iteration) throws AlgoException{

        // Cas chaîne vide
        if(in == null || in.isEmpty()) {
            return "";
        }

        if(iteration <= 0) { // Si l'itération est inférieure ou égale à 0
            throw new AlgoException("L'itération doit être supérieure à 0"); // On lance une exception
        }

        String resultat = in; // Résultat

        for(int i = 0; i < iteration; i++) { // Parcours des itérations
            resultat = unRLE(resultat); // On applique l'algorithme unRLE
        }

        return resultat; // On retourne le résultat
    }
}

