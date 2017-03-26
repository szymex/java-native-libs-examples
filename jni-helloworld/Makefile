JDK_HOME=/usr/lib/jvm/java-8-oracle
SRC_DIR = .
INCLUDES = -I$(SRC_DIR) -I$(JDK_HOME)/include -I$(JDK_HOME)/include/linux

all: headers shared class

headers:
	javah -jni -cp src -d target HelloWorld

class:
	javac src/HelloWorld.java -d target

shared:
	cd target; g++  $(INCLUDES) -fPIC -c -g -Wall ../src/HelloWorld.c
	cd target; g++ -shared -o libHelloWorld.so HelloWorld.o

run:
	cd target;  D_LIBRARY_PATH=. java -Xms10m -Xmx10m HelloWorld


clean:
	cd target; rm -r *
