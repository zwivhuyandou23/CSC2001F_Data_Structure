# dijkstra testing program makefile
# Zwivhuya Ndou
# 30 April 2023

JAVAC = javac
JAVACDOC = javadoc
.SUFFIXES: .java .class
SRCDIR = src
BINDIR = bin
DOCDIR = doc

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) -sourcepath $(SRCDIR) $< 

classes= LPHashTable.class QPHashTable.class LPAutoTest.class \
	QPAutoTest.class HashTable.class AutoTest.class Monitorable.class

CLASS_FILES = $(classes:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

clean:
	rm $(BINDIR)/*.class
javadoc:
	$(JAVACDOC) -d $(DOCDIR) -sourcepath $(SRCDIR) -classpath $(BINDIR) $(SRCDIR)/*java

run: $(CLASS_FILES)
	java -cp bin LPAutoTest
	java -cp bin QPAutoTest


