plugins {
    packetevents.`library-conventions`
}

repositories {
    mavenLocal()
}

dependencies {
    compileOnly(libs.netty)
    implementation(project(":api", "shadow"))
    compileOnly(libs.grimapi)
}