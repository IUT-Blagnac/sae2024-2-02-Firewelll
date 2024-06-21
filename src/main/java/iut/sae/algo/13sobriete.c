#include <stdio.h>

void R(char *s, char *r) {
    for (int n; *s; *r++ = n + 48, *r++ = *s++) {
        for (n = 1; *s == s[1] && n < 9; n++, s++);
    }
    *r = 0;
}

void unR(char *r, char *s) {
    while (*r) {
        int count = *r++ - '0';
        char current_char = *r++;
        memset(s, current_char, count);
        s += count;
    }
    *s = '\0';
}

// Fonction récursive RLE
void R_recursive(char *s, char *r) {
    if (*s == '\0') {
        *r = '\0';
        return;
    }
    int n = 1;
    while (*(s + 1) && *s == *(s + 1) && n < 9) {
        n++;
        s++;
    }
    *r++ = n + '0';
    *r++ = *s++;
    R_recursive(s, r);
}

// Fonction récursive unRLE
void unR_recursive(char *r, char *s) {
    if (*r == '\0') {
        *s = '\0';
        return;
    }
    int count = *r++ - '0';
    char current_char = *r++;
    memset(s, current_char, count);
    unR_recursive(r, s + count);
}