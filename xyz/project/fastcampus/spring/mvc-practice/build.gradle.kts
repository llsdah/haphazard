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
    implementation ("com.zaxxer:HikariCP:5.0.1")
    implementation ("org.springframework:spring-jdbc:5.3.22")
    implementation ("com.h2database:h2:2.1.214")

    implementation("javax.servlet:javax.servlet-api:4.0.1")

    //JSP
    implementation("javax.servlet:jstl:1.2")


    implementation("org.reflections:reflections:0.10.2")
    implementation ("ch.qos.logback:logback-classic:1.2.3")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation("org.assertj:assertj-core:3.23.1")

}

tasks.test {
    useJUnitPlatform()
}