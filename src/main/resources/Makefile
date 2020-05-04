build: compile test

compile:
	javac lexer/*.java
	javac symbols/*.java
	javac inter/*.java
	javac parser/*.java
	javac main/*.java

test:
	@for i in `(cd tests; ls *.t | sed -e 's/.t$$//')`;\
		do echo $$i.t;\
		java Main <tests/$$i.t >tmp/$$i.i;\
		diff tests/$$i.i tmp/$$i.i;\
	done

test1:
	echo tests/block1.t; java Main < tests/block1.t > tmp/block1.i; diff tests/block1.i tmp/block1.i;

clean:
	(cd lexer; rm *.class)
	(cd symbols; rm *.class)
	(cd inter; rm *.class)
	(cd parser; rm *.class)
	(cd main; rm *.class)

yacc:
	/usr/ccs/bin/yacc -v doc/front.y
	rm y.tab.c
	mv y.output doc
