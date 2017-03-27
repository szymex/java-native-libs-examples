JDK_HOME=/usr/lib/jvm/java-8-oracle

all: headers shared class

headers:
	javah -jni -cp src -d target HelloWorld

class:
	javac src/HelloWorld.java -d target

shared:
	cd target; g++ -I. -I$(JDK_HOME)/include -I$(JDK_HOME)/include/linux -fPIC -c -g -Wall ../src/HelloWorld.c
	cd target; g++ -shared -o libHelloWorld.so HelloWorld.o

run:
	cd target;  LD_LIBRARY_PATH=. java HelloWorld


clean:
	rm -rf target
