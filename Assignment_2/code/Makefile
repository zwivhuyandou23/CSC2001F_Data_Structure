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

classes=Edge.class Vertex.class Path.class \
	GraphException.class Graph.class makeGraphDataset.class FunctionTest.class test.class

CLASS_FILES = $(classes:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

clean:
	rm $(BINDIR)/*.class
javadoc:
	$(JAVACDOC) -d $(DOCDIR) -sourcepath $(SRCDIR) -classpath $(BINDIR) $(SRCDIR)/*java

run: $(CLASS_FILES)
	java -cp bin test


