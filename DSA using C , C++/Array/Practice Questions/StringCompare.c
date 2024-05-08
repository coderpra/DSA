#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct String string;
struct String
{
    char *str;
};

char getDiff(string real, string get)
{
    char answer = '\0';
    while (*(real.str) != '\0')
    {
        if (*(real.str) != *(get.str))
        {
            answer = *(real.str);
            break;
        }
        (real.str)++;
        (get.str)++;
    }
    return answer;
}

int main()
{
    string actual;
    string notActual;
    char flag;

    actual.str = (char *)malloc(100 * sizeof(char));
    notActual.str = (char *)malloc(100 * sizeof(char));

    scanf("%s", actual.str);
    scanf("%s", notActual.str);
    printf("%c", getDiff(actual, notActual));

    free(actual.str);
    free(notActual.str);

    return 0;
}
