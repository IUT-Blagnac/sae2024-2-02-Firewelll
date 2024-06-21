#include "algo.h"
#include "unity.h"
#include <string.h>
#include <time.h>

void setUp(void) {}

void tearDown(void) {}

void test_RLE() {
  char *resultat;

  resultat = RLE("");
  TEST_ASSERT_EQUAL_STRING("", resultat);
  free(resultat);

  resultat = RLE("abc");
  TEST_ASSERT_EQUAL_STRING("1a1b1c", resultat);
  free(resultat);

  resultat = RLE("abbccc");
  TEST_ASSERT_EQUAL_STRING("1a2b3c", resultat);
  free(resultat);

  resultat = RLE("aaabaa");
  TEST_ASSERT_EQUAL_STRING("3a1b2a", resultat);
  free(resultat);

  resultat = RLE("aAa");
  TEST_ASSERT_EQUAL_STRING("1a1A1a", resultat);
  free(resultat);

  resultat = RLE("WWWWWWWWWWWWW");
  TEST_ASSERT_EQUAL_STRING("9W4W", resultat);
  free(resultat);
}

void test_RLERecursif() {
  char *resultat;

  resultat = RLE_R("", 1);
  TEST_ASSERT_EQUAL_STRING("", resultat);
  free(resultat);

  resultat = RLE_R("", 3);
  TEST_ASSERT_EQUAL_STRING("", resultat);
  free(resultat);

  resultat = RLE_R("abc", 1);
  TEST_ASSERT_EQUAL_STRING("1a1b1c", resultat);
  free(resultat);

  resultat = RLE_R("abbccc", 1);
  TEST_ASSERT_EQUAL_STRING("1a2b3c", resultat);
  free(resultat);

  resultat = RLE_R("aaabaa", 1);
  TEST_ASSERT_EQUAL_STRING("3a1b2a", resultat);
  free(resultat);

  resultat = RLE_R("aAa", 1);
  TEST_ASSERT_EQUAL_STRING("1a1A1a", resultat);
  free(resultat);

  resultat = RLE_R("abc", 2);
  TEST_ASSERT_EQUAL_STRING("111a111b111c", resultat);
  free(resultat);

  resultat = RLE_R("abc", 3);
  TEST_ASSERT_EQUAL_STRING("311a311b311c", resultat);
  free(resultat);
}

void test_unRLE() {
  char *resultat;

  resultat = unRLE("");
  TEST_ASSERT_EQUAL_STRING("", resultat);
  free(resultat);

  resultat = unRLE("1a1b1c");
  TEST_ASSERT_EQUAL_STRING("abc", resultat);
  free(resultat);

  resultat = unRLE("1a2b3c");
  TEST_ASSERT_EQUAL_STRING("abbccc", resultat);
  free(resultat);

  resultat = unRLE("3a1b2a");
  TEST_ASSERT_EQUAL_STRING("aaabaa", resultat);
  free(resultat);

  resultat = unRLE("1a1A1a");
  TEST_ASSERT_EQUAL_STRING("aAa", resultat);
  free(resultat);

  resultat = unRLE("9W4W");
  TEST_ASSERT_EQUAL_STRING("WWWWWWWWWWWWW", resultat);
  free(resultat);
}

void test_unRLERecursif() {
  char *resultat;

  resultat = unRLE_R("", 1);
  TEST_ASSERT_EQUAL_STRING("", resultat);
  free(resultat);

  resultat = unRLE_R("", 3);
  TEST_ASSERT_EQUAL_STRING("", resultat);
  free(resultat);

  resultat = unRLE_R("1a1b1c", 1);
  TEST_ASSERT_EQUAL_STRING("abc", resultat);
  free(resultat);

  resultat = unRLE_R("1a2b3c", 1);
  TEST_ASSERT_EQUAL_STRING("abbccc", resultat);
  free(resultat);

  resultat = unRLE_R("3a1b2a", 1);
  TEST_ASSERT_EQUAL_STRING("aaabaa", resultat);
  free(resultat);

  resultat = unRLE_R("1a1A1a", 1);
  TEST_ASSERT_EQUAL_STRING("aAa", resultat);
  free(resultat);

  resultat = unRLE_R("111a111b111c", 2);
  TEST_ASSERT_EQUAL_STRING("abc", resultat);
  free(resultat);

  resultat = unRLE_R("311a311b311c", 3);
  TEST_ASSERT_EQUAL_STRING("abc", resultat);
  free(resultat);
}

void test_10Caractere() {
  char *resultat;

  resultat = RLE("aaaaaaaaaa");
  TEST_ASSERT_EQUAL_STRING("9a1a", resultat);
  free(resultat);

  resultat = unRLE("9a1a");
  TEST_ASSERT_EQUAL_STRING("aaaaaaaaaa", resultat);
  free(resultat);
}

void test_RLERecursifGrand() {
  char *resultat;

  resultat = RLE_R("WWWWWWWWWWWWW", 5);
  TEST_ASSERT_EQUAL_STRING("13211913211W13211413211W", resultat);
  free(resultat);
}

void testPerfRLE() {
  char *resultat;
  const char *entre= "Testtt";

  clock_t debut = clock();
  resultatat = RLE(entre);
  free(resultatat);
  clock_t fin = clock();
  double temps = ((double)(fin - debut)) / CLOCKS_PER_SEC;

  printf("Temps : %f secondes\n",
         temps);
}

void testPerfUNRLE() {
  char *resultat;
  const char *entre= "9A9A9A9A9A9A9A9A9A9A";

  clock_t debut = clock();
  for (int i = 0; i < 1000000; i++) {
    resultat = unRLE(entre);
    free(resultat);
  }
  clock_t fin = clock();
  double temps = ((double)(fin - debut)) / CLOCKS_PER_SEC;

  printf("Temps : %f secondes\n",
         temps);
}

int main(void) {
  UNITY_BEGIN();
  RUN_TEST(test_RLE);
  RUN_TEST(test_RLERecursif);
  RUN_TEST(test_unRLE);
  RUN_TEST(test_unRLERecursif);
  RUN_TEST(test_10Caractere);
  RUN_TEST(test_RLERecursifGrand);
  testPerfRLE();
  testPerfUNRLE();
  return UNITY_END();
}
