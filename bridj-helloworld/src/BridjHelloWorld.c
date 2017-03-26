#include <stdio.h>

void printHello() {
    printf("Hello from C\n");
}

void printText(char* text) {
    printf("Hello from C. %s\n", text);
}

void printByteArray(char* text, int len) {
    printf("Hello from C. (%d) %.*s\n", len, len, text);
}

void printBuffer(char* bytes, int len) {
    printf("Hello from C. (%d) %.*s\n", len, len, bytes);
}
