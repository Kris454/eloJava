#include "Paleta.h"
 JNIEXPORT void JNICALL 
  Java_Paleta_printText (JNIEnv *env, jobject obj, jobject c) 
{
    jclass    cls = (*env)->GetObjectClass(env, c);   
    jmethodID mid = (*env)->GetStaticMethodID(env, cls, "values", "()[LKolor;");
       jobjectArray joa = (*env)->CallStaticObjectMethod(env, c, mid);
        int len = (*env)->GetArrayLength(env, joa);
        jfieldID  fidr = (*env)->GetFieldID(env, cls, "r", "D");
       jfieldID  fidg = (*env)->GetFieldID(env, cls, "g", "D");
       jfieldID  fidb = (*env)->GetFieldID(env, cls, "b", "D");
       printf("Enum type  'Kolor' contains %d   elements \n", len);
       jmethodID nazwy = (*env)->GetMethodID(env, cls, "name", "()Ljava/lang/String;");
        jdouble ra = (*env)->GetDoubleField(env, c, fidr);
       jdouble ga = (*env)->GetDoubleField(env, c, fidg);
       jdouble ba = (*env)->GetDoubleField(env, c, fidb);
 for(int i=0; i<len; i++)
    {
       jobject elem = (*env)->GetObjectArrayElement(env, joa, i);
       jstring jstr  = (*env)->CallObjectMethod(env, elem, nazwy);
       const char* str = (*env)->GetStringUTFChars(env, jstr, NULL);
       jdouble r = (*env)->GetDoubleField(env, elem, fidr);
       jdouble g = (*env)->GetDoubleField(env, elem, fidg);
       jdouble b = (*env)->GetDoubleField(env, elem, fidb);
       if(ra == r && g == ga && ba == b ){
       printf(" ->%s  %f %f %f-< \n", str,r,g,b);}
         printf("%s  %f %f %f \n", str,r,g,b);
    }
       return;
}

