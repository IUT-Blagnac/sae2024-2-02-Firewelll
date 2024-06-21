#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

/**
 * Fonction permet de prendre une chaîne de caractères en entrée et retourne cette chaîne de caractères encodée en RLE
 */
char* RLE(const char* s) {

    // si longueur de chaine est vide alors on retourne une chaine vide
    if (strlen(s) == 0) {
        return "";
    }

    // on alloue la mémoire pour le message encodé en RLE
    int tailleMsgEncode = strlen(s) * 4;
    char* msgEncoder = malloc(tailleMsgEncode);

    // on initialsie les variables
    int cptRepet = 1;
    char posAct = s[0];
    int parCpt = 0;

    // boucle for qui se repète pour chaque caractère dans le message.
    for (int c = 1; s[c] != '\0'; c++) {
        
        char posSuiv = s[c];

        // Si le caractère actuel est le même que le prochain caractère, par exemple, si on a [AA]HHHTTT
        if (posSuiv == posAct) {

            // on incrémente le compteur de répétition
            cptRepet++;

            // si le compteur de caractères qui se répètent dépasse 9 alors on doit le diviser en plusieurs groupes de 9
            if (cptRepet > 9)  {

                // on ajoute le 9 pour indiquer qu'il y a 9 caractères qui se répètent
                msgEncoder[parCpt++] = '9';
                // on ajoute le caractère qui se répète
                msgEncoder[parCpt++] = posAct;
                // on décrémente le compteur de répétition de 9
                cptRepet -= 9;
            }
        } else {
            // si le caractère actuel est différent du prochain caractère, par exemple, si on a [AA]HHHTTT
            msgEncoder[parCpt++] = '0' + cptRepet;

            // on ajoute le caractère qui se répète
            msgEncoder[parCpt++] = posAct;
            
            // on met à jour le caractère actuel
            posAct = posSuiv;

            // on réinitialise le compteur de répétition
            cptRepet = 1;
        }
    }

    // on ajoute le nombre de caractères qui se répètent
    msgEncoder[parCpt++] = '0' + cptRepet;

    // on ajoute le caractère qui se répète
    msgEncoder[parCpt++] = posAct;

    // on ajoute le caractère de fin de chaine
    msgEncoder[parCpt] = '\0';

    // on retourne le message encodé en RLE
    return msgEncoder;
}

/**
 * Fonction permet de prendre une chaîne de caractères en entrée et retourne cette chaîne de caractères encodée en RLE
 */
char* RLE_recursif(const char* s, int iterations) {

    // si le nombre de répétitions est inférieur à 1 alors exception
    if (iterations < 1) {
        return NULL;
    }

    // on alloue la mémoire pour le message encodé en RLE
    char* msgEncoder = strdup(s);

    // boucle pour encoder le message n fois
    for (int i = 0; i < iterations; i++) {
        char* msgCode = RLE(msgEncoder);
        free(msgEncoder);
        msgEncoder = msgCode;
    }

    return msgEncoder;
}

/**
 * Fonction permet de prendre une chaîne de caractères encodée en RLE en entrée et retourne cette chaîne de caractères décodée
 */
char* unRLE(const char* s) {
    if (strlen(s) == 0) {
        return "";
    }

    // On calcule la taille du message décodé
    int tailleMsgDecode = 0;

    // boucle pour calculer la taille du message décodé (Merci YF !)
    for (int i = 0; s[i] != '\0'; i++) {
        if (isdigit(s[i])) {
            tailleMsgDecode += s[i];
        }
    }


    char* resMsgDecode = malloc(tailleMsgDecode);

    int parCpt = 0;

    // Boucle for qui se repète pour chaque caractère dans le message.
    for (int i = 0; s[i] != '\0'; i++) {

        // Si le ieme caractère est un chiffre alors on le convertit en un entier et le stocke dans cptRepet
        if (isdigit(s[i])) {

            // on convertit le caractère en entier, cela va nous permettre de savoir combien de fois on doit répéter le caractère suivant donc si on a 5A alors AAAAA
            int cptRepet = s[i] - '0';
            // on passe au caractère suivant
            i++;

            // on stocke le caractère suivant dans carSt
            char carSt = s[i];

            // on ajoute le caractère carSt cptRepet fois dans le message décodé 
            for (int j = 0; j < cptRepet; j++) {
                resMsgDecode[parCpt++] = carSt;
            }
        }
    }

    return resMsgDecode;
}

/**
 * Fonction pour décoder récursivement une chaîne en RLE
 */
char* unRLE_recursif(const char* s, int iterations) {

    // si le nombre de répétitions est inférieur à 1 alors NULL
    if (iterations < 1) {
        return NULL;
    }

    // on alloue la mémoire pour le message décodé
    char* resMsgDecode = strdup(s);

    // boucle pour décoder le message n fois
    for (int i = 0; i < iterations; i++) {
        char* decoded_message = unRLE(s);
        free(resMsgDecode);
        resMsgDecode = decoded_message;
    }

    return resMsgDecode;
}