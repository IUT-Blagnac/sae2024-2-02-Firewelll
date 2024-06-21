#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* RLE(char* in) {
    if (in == NULL || strlen(in) == 0) {
        return "";
    }

    int len = (int)strlen(in);
    char* result = (char*)malloc(sizeof(char) * (len * 2 + 1)); // Allouer de l'espace pour le pire cas
    int resultIndex = 0;
    char prec = in[0];
    int cpt = 1;

    for (int i = 1; i < len; i++) {
        if (in[i] == prec) {
            if (cpt == 9) {
                result[resultIndex++] = '9';
                result[resultIndex++] = prec;
                cpt = 1;
            } else {
                cpt++;
            }
        } else {
            result[resultIndex++] = cpt + '0';
            result[resultIndex++] = prec;
            prec = in[i];
            cpt = 1;
        }
    }

    result[resultIndex++] = cpt + '0';
    result[resultIndex++] = prec;
    result[resultIndex] = '\0';

    return result;
}

char* RLE(char* in, int iteration) {
    if (in == NULL || strlen(in) == 0) {
        return "";
    }

    if (iteration < 1) {
        return NULL;
    }

    char* result = (char*)malloc(sizeof(char) * (strlen(in) * 2 + 1)); // Allouer de l'espace pour le pire cas
    strcpy(result, in);

    for (int i = 0; i < iteration; i++) {
        char* temp = RLE(result);
        free(result);
        result = temp;
    }

    return result;
}


char* unRLE(char* in) {
  // Vérifier les cas de base
  if (in == NULL || strlen(in) == 0) {
      return "";
  }
  // Initialiser les variables
  int len = (int)strlen(in);
  char* result = (char*)malloc(sizeof(char) * len + 1); // Allouer de l'espace pour le pire cas
  int resultIndex = 0;
  int count = 0;
  // Parcourir la chaîne d'entrée
  for (int i = 0; i < len; i++) {
      if (isdigit(in[i])) {          // Nombre de répétitions
          count = in[i] - '0';
          i++; // Passer au caractère suivant
          char repeatChar = in[i];
          // Ajouter le caractère répété
          for (int j = 0; j < count; j++) {
              result[resultIndex++] = repeatChar;
          }
      }
  }
  result[resultIndex] = '\0';
  return result;
}

char* unRLEIterative(char* input, int iteration) {
    if (input == NULL || strlen(input) == 0) {
        return "";
    }

    if (iteration < 1) {
        return NULL;
    }

    char* result = strdup(input);
    for (int i = 0; i < iteration; i++) {
        char* temp = unRLE(result);
        free(result);
        result = temp;
    }

    return result;
}


