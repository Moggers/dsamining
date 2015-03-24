CC= javac
export CLASSPATH=.:tests:lib/junit.jar:lib/hamcrest-core.jar
JUNITTEST= java org.junit.runner.JUnitCore

all: clean ShipmentOrder.class OrePile.class OreType.class OrePileIO.class DSAStack.class

test: cleantest tests/ShipmentOrderTest.class tests/OrePileTest.class tests/OreTypeTest.class tests/DSAStackTest.class
	$(JUNITTEST) OreTypeTest OrePileTest ShipmentOrderTest DSAStackTest

OrePileIO.class:
	 $(CC) OrePileIO.java

ShipmentOrder.class: OrePile.class
	 $(CC) ShipmentOrder.java

OreType.class:
	 $(CC) OreType.java

OrePile.class: OreType.class
	 $(CC) OrePile.java

DSAStack.class:
	 $(CC) DSAStack.java

tests/ShipmentOrderTest.class:
	 $(CC) tests/ShipmentOrderTest.java

tests/OrePileTest.class:
	 $(CC) tests/OrePileTest.java

tests/OreTypeTest.class:
	 $(CC) tests/OreTypeTest.java

tests/DSAStackTest.class:
	 $(CC) tests/DSAStackTest.java


clean:
	rm -rf *.class

cleantest:
	rm -rf tests/*.class
