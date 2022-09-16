clean:
	mvn clean

build:
	mvn install

push_dev:
	scp target/ROOT.war nsc-dev:/tmp

push_qa:
	scp target/ROOT.war nsc-qa1:/tmp
	scp target/ROOT.war nsc-qa2:/tmp
