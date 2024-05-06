FROM bellsoft/liberica-openjdk-alpine:17.0.8

WORKDIR /home/selenium-docker

Add target/docker-resources ./

ENTRYPOINT java -Dselenium.grid.enabled=true \
        -Dselenium.gird.hubHost=${HUB_HOST} \
        -Dbrowser=${BROWSER} \
        -cp 'libs/*' org.testng.TestNG -threadcount ${THREAD_COUNT} test-suites/${TEST_SUITE}