
# binary search tree tiktok program makefile
# Zwivhuya Ndou
# 12 April 2023

JAVAC=/usr/bin/javac
JAVA=/usr/bin/java

.SUFFIXES: .java .class

SRCDIR = src
BINDIR = bin

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES: TikTok.class Profile.class \
         BinarySearchTree.class BinaryTreeNode.class \
         Account.class Posts.class

CLASS_FILES=$(CLASSES:%.class= $(BINDIR)/%.class)

default: $(CLASS_FILES)

clean:
	rm $(BINDIR)/*.class

run: $(CLASS_FILES)
	$(JAVA) -cp bin TikTok


