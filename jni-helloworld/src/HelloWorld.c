#include "HelloWorld.h"
#include <jni.h>
#include <stdio.h>

JNIEXPORT void JNICALL Java_HelloWorld_print (JNIEnv *env, jobject obj) {
  printf("Hello from JNI library!\n");
}

JNIEXPORT void JNICALL Java_HelloWorld_printText (JNIEnv *env, jobject obj, jstring text) {

  const char *strText= (env)->GetStringUTFChars(text,JNI_FALSE);

  printf("Hello again. %s\n", strText);
}

JNIEXPORT void JNICALL Java_HelloWorld_printByteArray (JNIEnv *env, jobject obj, jbyteArray buffer) {

  signed char *bufferPtr = (env)->GetByteArrayElements(buffer, NULL);
  jsize lengthOfArray = (env)->GetArrayLength(buffer);

  printf("Hello again. Byte array(%d): %s\n", lengthOfArray, bufferPtr);

  (env)->ReleaseByteArrayElements(buffer, bufferPtr, 0);
}


JNIEXPORT void JNICALL Java_HelloWorld_printBuffer (JNIEnv *env, jobject obj, jobject buffer) {

  char *iBuf= (char *)env->GetDirectBufferAddress(buffer);
  jlong len = env->GetDirectBufferCapacity(buffer);

  printf("Hello again. Byte buffer(%ld): %s\n", len, iBuf);
}

