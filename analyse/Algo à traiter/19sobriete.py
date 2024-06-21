##################################################
#               Sobriete / Python                #
##################################################

def encodage_rle(texte):

    resultat = ""

    compteur = 0

    precedent = None

    for caractere in texte:

        if caractere != precedent:

            if precedent is not None:

                resultat += str(compteur) + precedent

            compteur = 1

            precedent = caractere

        else:

            compteur += 1

            if compteur > 9:

                resultat += "9" + precedent

                compteur -= 9

    if precedent is not None:
        
        resultat += str(compteur) + precedent
    
    return resultat

##################################################
#               Sobriete / Python                #
##################################################