✅ Option 1: Enable Incremental Annotation Processing

    Go to:
    File → Settings → Build, Execution, Deployment → Compiler → Annotation Processors

    Ensure these are set:

        ✅ Enable annotation processing (must be checked)

        ✅ Obtain processors from project classpath

        ✅ Use compiler: javac

    Then go to:
    File → Settings → Build Tools → Gradle → Build and run using

        Set to: IntelliJ IDEA (not Gradle)

    Rebuild the project fully:
    Build → Rebuild Project