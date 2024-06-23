plugins {
  id("fabric-loom") version "1.7-SNAPSHOT"
  id("com.github.johnrengelman.shadow") version "8.1.1"
}

version = property("mod_version")!!
group = property("maven_group")!!

base {
  archivesName.set(property("archives_base_name")!! as String)
}

repositories {
  maven("https://maven.fabricmc.net/") {
    name = "Fabric"
  }
  mavenCentral()
  gradlePluginPortal()
  maven(url = "https://s01.oss.sonatype.org/content/repositories/snapshots/") {
    name = "sonatype-oss-snapshots1"
    mavenContent { snapshotsOnly() }
  }
}

loom {
  splitEnvironmentSourceSets()

  mods {
    create("minimotd") {
      sourceSet("main")
    }
  }

}

dependencies {
  // Minecraft
  minecraft("com.mojang:minecraft:${property("minecraft_version")}")
  mappings("net.fabricmc:yarn:${property("yarn_mappings")}:v2")
  modImplementation("net.fabricmc:fabric-loader:${property("loader_version")}")

  // Fabric API

  modImplementation("net.fabricmc.fabric-api:fabric-api:${property("fabric_version")}")

  // Config
  modImplementation(include("org.spongepowered:configurate-hocon:4.1.2")!!)
  modImplementation(include("org.spongepowered:configurate-core:4.1.2")!!)
  modImplementation(include("io.leangen.geantyref:geantyref:1.3.15")!!)
  modImplementation(include("com.typesafe:config:1.4.2")!!)


  implementation("org.checkerframework:checker-qual:3.44.0")

  implementation("net.kyori:adventure-api:4.17.0")
  modImplementation(include("net.kyori:adventure-platform-fabric:5.14.0-SNAPSHOT")!!)

}

tasks {
   processResources {
     inputs.property("version", project.version)
     filesMatching("fabric.mod.json") {
       expand(getProperties())
       expand(mutableMapOf("version" to project.version))
     }
   }

   jar {
     from("LICENSE") {
       rename { "${it}_${project.base.archivesName.get()}"}
     }
   }

  java {
    withSourcesJar()

    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
  }

}

