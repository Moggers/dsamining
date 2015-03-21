CC= javac
JUCP= -cp .:tests:/usr/share/java/junit.jar:/usr/share/java/hamcrest-core.jar
JUNITTEST= java $(JUCP) org.junit.runner.JUnitCore

all: clean ShipmentOrder.class OrePile.class OreType.class

test: cleantest tests/ShipmentOrderTest.class tests/OrePileTest.class tests/OreTypeTest.class
	$(JUNITTEST) OreTypeTest OrePileTest ShipmentOrderTest  

ShipmentOrder.class:
	$(CC) ShipmentOrder.java

OreType.class:
	$(CC) OreType.java

OrePile.class:
	$(CC) OrePile.java

tests/ShipmentOrderTest.class:
	$(CC) $(JUCP) tests/ShipmentOrderTest.java

tests/OrePileTest.class:
	$(CC) $(JUCP) tests/OrePileTest.java

tests/OreTypeTest.class:
	$(CC) $(JUCP) tests/OreTypeTest.java

clean:
	rm -rf *.class

cleantest:
	rm -rf tests/*.class
