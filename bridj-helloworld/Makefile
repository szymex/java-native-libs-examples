all: shared class

class:
	javac -classpath ../lib/bridj-0.7.0-unix-only.jar src/BridjHelloWorld.java -d target

shared:
	mkdir -p target
	gcc -shared -fPIC -o target/libBridjHelloWorld.so src/BridjHelloWorld.c

run:
	cd target;  java -cp ../../lib/bridj-0.7.0-unix-only.jar:. BridjHelloWorld


clean:
	rm -rf target
