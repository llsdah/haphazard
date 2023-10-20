plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    // embedded tomcat
    implementation("org.apache.tomcat.embed:tomcat-embed-core:8.5.42")
    implementation ("org.apache.tomcat.embed:tomcat-embed-jasper:8.5.42")

    // logback-classic
    implementation ("ch.qos.logback:logback-classic:1.2.3")

    testImplementation ("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.test {
    useJUnitPlatform()
}