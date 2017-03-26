all: shared class

class:
	javac -classpath ../lib/jna-4.3.0.jar src/JnaHelloWorld.java -d target

shared:
	mkdir -p target
	gcc -shared -fPIC -o target/libTest.so src/Test.c

run:
	cd target;  java -Xms10m -Xmx10m -cp ../../lib/jna-4.3.0.jar:. JnaHelloWorld


clean:
	rm -rf target
