# binary search tree tiktok program makefile
# Zwivhuya Ndou
# 12 April 2023

JAVAC = /usr/bin/javac
JAVACDOC = /usr/bin/javadoc
.SUFFIXES: .java .class
SRCDIR = src
BINDIR = bin
DOCDIR = doc

$(BINDIR)/%.class: $(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR) -cp $(BINDIR) $<

classes = Vertex.class Edge.class Path.class GraphException.class Graph.class makeGrapghDataset.class FunctionTest.class test.class

CLASS_FILES = $(classes:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

clean:
	rm $(BINDIR)/*.class
javadoc:
	$(JAVAC) -d $(DOCDIR) -sourcepath $(SRCDIR) -classpath $(BINDIR) $(SRCDIR)/*java

run: $(CLASS_FILES)
	java -cp bin TikTok


