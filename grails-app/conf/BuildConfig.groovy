grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
grails.project.war.file = "target/${appName}.war"

grails.plugin.location."metridoc-core" = "../metridoc-grails/metridoc-grails-core" 
grails.plugin.location."metridoc-illiad" = "../metridoc-grails/metridoc-grails-illiad" 
grails.plugin.location."metridoc-funds" = "../metridoc-grails/metridoc-grails-funds" 
grails.plugin.location."metridoc-bd" = "../metridoc-grails/metridoc-grails-bd" 
grails.plugin.location."metridoc-rid" = "../metridoc-grails/metridoc-grails-rid"

grails.project.fork = [
        // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
        //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

        // configure settings for the test-app JVM, uses the daemon by default
        test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
        // configure settings for the run-app JVM
        run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
        // configure settings for the run-war JVM
        war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
        // configure settings for the Console UI JVM
        console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven" // or ivy

grails.project.dependency.resolution = {
    inherits("global")
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        grailsCentral()

        if (System.getProperty("grails.env") != "production") {
            mavenLocal()
        }


        mavenCentral()
        mavenRepo "http://dl.bintray.com/upennlib/metridoc"
        mavenRepo "http://dl.bintray.com/upennlib/maven"
        mavenRepo "http://jcenter.bintray.com/"
        mavenRepo "https://metridoc.googlecode.com/svn/maven/repository"
        //Temporarily allow production mavenLocal() because counter 0.5 is having trouble with bintray
        //mavenLocal()
    }

    plugins {/*
        println "using development dependencies"
        String metridocVersion = new URL("https://raw.github.com/metridoc/metridoc-grails/master/VERSION").getText().trim()
        compile ":metridoc-core:${metridocVersion}"
        compile (":metridoc-illiad:${metridocVersion}")
        compile (":metridoc-rid:${metridocVersion}")
        compile (":metridoc-bd:${metridocVersion}")
        compile (":metridoc-funds:${metridocVersion}")*/

        if (System.getProperty("grails.env") != "production") {
            println "using development dependencies"
            String metridocVersion = new URL("https://raw.github.com/metridoc/metridoc-grails/master/VERSION").getText().trim()
            compile ":metridoc-core:${metridocVersion}"
            compile (":metridoc-illiad:${metridocVersion}")
            compile (":metridoc-rid:${metridocVersion}")
            compile (":metridoc-bd:${metridocVersion}")
            compile (":metridoc-funds:${metridocVersion}")

        }
        else {
            println "using production dependencies"
            def getVersion = {String module ->
                def metadata = new XmlSlurper().parse("http://dl.bintray.com/upennlib/metridoc/org/grails/plugins/${module}/maven-metadata.xml")
                return metadata.versioning.latest.text()
            }
            compile ":metridoc-core:${getVersion('metridoc-core')}"
            compile(":metridoc-illiad:${getVersion('metridoc-illiad')}")
            compile(":metridoc-rid:${getVersion('metridoc-rid')}")
            compile(":metridoc-bd:${getVersion('metridoc-bd')}")
            compile(":metridoc-funds:${getVersion('metridoc-bd')}")
        }

        compile (":metridoc-counter:0.6") {
            excludes "metridoc-core"
        }
        runtime ":hibernate:3.6.10.6"
        compile ":google-visualization:0.6.2"
        build ":tomcat:7.0.47"
        build ":squeaky-clean:0.2"
    }
}
