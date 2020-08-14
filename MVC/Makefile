ANT	= env LC_ALL=ja_JP.UTF-8 ant
ARCHIVE	= $(shell basename `pwd`)
SOURCES	= $(shell find . -name "*.java")
STYLE_YAML	= clang-format-for-java.yaml
STYLE_CONF	= _clang-format

all:
	$(ANT) all

clean:
	$(ANT) clean

test:
	$(ANT) test

install:
	$(ANT) install

doc:
	$(ANT) doc

#zip:
#	$(ANT) zip
zip: clean
	(cd ../ ; zip -r ./$(ARCHIVE).zip ./$(ARCHIVE)/ --exclude='*/.svn/*')

format:
	@rm -f $(STYLE_CONF) ; ln -s $(STYLE_YAML) $(STYLE_CONF)
	for each in $(SOURCES) ; do echo ---[$${each}]--- ; clang-format -style=file $${each} ; echo ; done
	@rm -f $(STYLE_CONF)
