# este makefile nao esta feito ainda, so comecei a organizar
# nao sei se vou usar nmake (Microsoft) ou make (MKS)
P1JAR = p1.jar

all: compila

compila:
	javac -classpath ".;junit.jar" p1\util\*.java p1\io\*.java p1\aplic\geral\*.java p1\aplic\banco\*.java p1\aplic\cartas\*.java p1\testes\*.java p1\aplic\cartastestes\*.java

jar: $(OBJETOS)

testa:
	java -classpath ".;c:\jdk1.2\jre\lib\rt.jar;c:\jsdk2.0\lib\jsdk.jar;C:\Arquivos de programas\junit2.1\junit.jar" junit.ui.LoadingTestRunner p1.testes.TestaTudo
doc:
	javadoc -public -version -author -use -d doc p1.util p1.io p1.aplic.geral p1.aplic.banco p1.aplic.cartas

limpa:

*******************************************************************************************************************
aqui (em baixo) esta um exemplo de um makefile para nmake da microsoft
nao sei o makefile default do nmake. talvez seja makefile mesmo
*******************************************************************************************************************
CLASSDIR=classes
CLASSPATH= $(CLASSDIR);..\infobus.jar;..\lib\methodtracer.jar
LIBDIR= lib
LIBFROMCLASSDIR= ..\lib

# To support platforms with 32 character filename limits.
# 	Replaced MakeAppletDialog with MakeAppDlg
# 	Replaced ObjectInputStreamWithLoader with ObjectInputStreamLoader

CLASSFILES= \
	$(CLASSDIR)\sun\beanbox\JarAccess.class \
	$(CLASSDIR)\sun\beanbox\JarEntrySource.class \
	$(CLASSDIR)\sun\beanbox\MakeAppDlg.class \
	$(CLASSDIR)\sun\beanbox\ClassCompiler.class \
	$(CLASSDIR)\sun\beanbox\AppletClassGenerator.class \
	$(CLASSDIR)\sun\beanbox\AppletGenerator.class \
	$(CLASSDIR)\sun\beanbox\IndentedStream.class \
	$(CLASSDIR)\sun\beanbox\BeanBox.class \
	$(CLASSDIR)\sun\beanbox\BeanBoxFrame.class \
	$(CLASSDIR)\sun\beanbox\Report.class \
	$(CLASSDIR)\sun\beanbox\StartFrame.class \
	$(CLASSDIR)\sun\beanbox\AboutDialog.class \
	$(CLASSDIR)\sun\beanbox\ErrorDialog.class \
	$(CLASSDIR)\sun\beanbox\MessageDialog.class \
	$(CLASSDIR)\sun\beanbox\WindowCloser.class \
	$(CLASSDIR)\sun\beanbox\CustomizerDialog.class \
	$(CLASSDIR)\sun\beanbox\HookupManager.class \
	$(CLASSDIR)\sun\beanbox\PropertyHookupManager.class \
	$(CLASSDIR)\sun\beanbox\PropertyNameDialog.class \
	$(CLASSDIR)\sun\beanbox\PropertyCanvas.class \
	$(CLASSDIR)\sun\beanbox\PropertyDialog.class \
	$(CLASSDIR)\sun\beanbox\PropertyText.class \
	$(CLASSDIR)\sun\beanbox\PropertySelector.class \
	$(CLASSDIR)\sun\beanbox\PropertySheet.class \
	$(CLASSDIR)\sun\beanbox\ToolBox.class \
	$(CLASSDIR)\sun\beanbox\FileExtension.class \
	$(CLASSDIR)\sun\beanbox\Timer.class \
	$(CLASSDIR)\sun\beanbox\OurLabel.class \
	$(CLASSDIR)\sun\beanbox\EventTargetDialog.class \
	$(CLASSDIR)\sun\beanbox\EditedAdaptor.class \
	$(CLASSDIR)\sun\beanbox\Wrapper.class \
	$(CLASSDIR)\sun\beanbox\WrapperPropertyEventInfo.class \
	$(CLASSDIR)\sun\beanbox\WrapperEventInfo.class \
	$(CLASSDIR)\sun\beanbox\SimpleClassLoader.class \
	$(CLASSDIR)\sun\beanbox\InputStreamProducer.class \
	$(CLASSDIR)\sun\beanbox\JarLoader.class \
	$(CLASSDIR)\sun\beanbox\ObjectInputStreamLoader.class \
	$(CLASSDIR)\sun\beanbox\JarInfo.class \
	$(CLASSDIR)\sun\beanbox\DoOnBean.class \
	$(CLASSDIR)\sun\beanbox\Manifest.class \
	$(CLASSDIR)\sun\beanbox\MessageHeader.class \
	$(CLASSDIR)\sun\beanbox\simpleresource\Handler.class \
	$(CLASSDIR)\sun\beanbox\simpleresource\SimpleResourceConnection.class \
	$(CLASSDIR)\sun\beanbox\IBSupport.class

SUPPORTFILES= \
	$(CLASSDIR)\sunw\beanbox\AppletSupport.class \
	$(CLASSDIR)\sunw\beanbox\PropertyHookup.class

all: $(CLASSDIR) $(CLASSFILES) supportjar

$(CLASSDIR):
	mkdir $(CLASSDIR)

supportjar: $(LIBDIR) $(SUPPORTFILES) $(LIBDIR)\support.jar

$(LIBDIR):
	mkdir $(LIBDIR)

$(LIBDIR)\support.jar: $(SUPPORTFILES)
	cd classes
	jar cvf $(LIBFROMCLASSDIR)\support.jar sunw\beanbox\*.class

.SUFFIXES: .java .class .jar .mf

{sun\beanbox}.java{$(CLASSDIR)\sun\beanbox}.class :
	set CLASSPATH=$(CLASSPATH);.
	javac -d $(CLASSDIR) $<

{sunw\beanbox}.java{$(CLASSDIR)\sunw\beanbox}.class :
	set CLASSPATH=$(CLASSPATH);.
	javac -d $(CLASSDIR) $<

{sun\beanbox\simpleresource}.java{$(CLASSDIR)\sun\beanbox\simpleresource}.class :
	set CLASSPATH=$(CLASSPATH);.
	javac -d $(CLASSDIR) $<

run:
	set CLASSPATH=classes
	java sun.beanbox.BeanBoxFrame

jdb:
	set CLASSPATH=$(CLASSPATH)
	jdb sun.beanbox.BeanBoxFrame

report:
	set CLASSPATH=$(CLASSPATH)
	java sun.beanbox.Report sun.beanbox.BeanBox

clean: FORCE	
!if "$(OS)" == "Windows_NT"
        @if exist classes/$(NULL) rmdir /s/q classes
        @if exist lib/$(NULL) rmdir /s/q lib
        @if exist tmp/$(NULL) rmdir /s/q tmp
!else
	-deltree/y classes
	-deltree/y lib
	-deltree/y tmp
!endif

FORCE:
