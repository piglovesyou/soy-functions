#######################################################################
#
#
#
#######################################################################

USAGE_TEXT="\n
    ---- Usage ---- \n\n\
    ./run.sh setup \n\t\
        Fetch Closure Template project and othre libraries. \n\
    ./run.sh build \n\t\
        Run javac and create class files of Java code. \n\
    ./run.sh test \n\t\
        Run all tests. \n\
    ./run.sh example-js \n\t\
        Create js template file from example soy file.
        \n"
INPUT_SOURCES_PATH=./java/src
INPUT_TEST_PATH=./java/tests
OUT_CLASSPATH=./build/classes
OUT_TEST_CLASSPATH=./build/tests
CLOSURE_TEMPLATES=./closure-templates
CLASS_PATH="${CLOSURE_TEMPLATES}/build/classes:${CLOSURE_TEMPLATES}/java/lib/*:${OUT_CLASSPATH}:./java/lib/*:./build/tests"



case $1 in
    setup)
        mkdir -p ./java/lib
        rm -rf $CLOSURE_TEMPLATES
        svn checkout http://closure-templates.googlecode.com/svn/trunk/ $CLOSURE_TEMPLATES
        wget -O ./java/lib/junit.jar http://search.maven.org/remotecontent?filepath=junit/junit/4.11/junit-4.11.jar
        wget -O ./java/lib/hamcrest-core.jar http://search.maven.org/remotecontent?filepath=org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar
        cd $CLOSURE_TEMPLATES
        ant
        ant SoyToJsSrcCompiler 
        ;;
    build)
        mkdir -p $OUT_CLASSPATH
        javac \
            -J-Dfile.encoding=UTF-8 \
            -sourcepath $INPUT_SOURCES_PATH \
            -classpath $CLASS_PATH \
            -d $OUT_CLASSPATH \
            ${INPUT_SOURCES_PATH}/net/stakam/soy/FunctionsModule.java
        ;;
    test)
        mkdir -p $OUT_TEST_CLASSPATH
        javac \
            -J-Dfile.encoding=UTF-8 \
            -sourcepath $INPUT_TEST_PATH \
            -classpath $CLASS_PATH \
            -d $OUT_TEST_CLASSPATH \
            ${INPUT_TEST_PATH}/net/stakam/TestSuite.java
        java \
            -classpath $CLASS_PATH \
            net.stakam.TestSuite
        ;;
    example-js)
        mkdir -p ./example/jsoutput
        java \
            -classpath $CLASS_PATH \
            com.google.template.soy.SoyToJsSrcCompiler \
            --pluginModules net.stakam.soy.FunctionsModule \
            --srcs ./example/soy/main.soy \
            --allowExternalCalls false \
            --shouldProvideRequireSoyNamespaces \
            --shouldGenerateJsdoc \
            --outputPathFormat ./example/jsoutput/main.js
        ;;
    example-java)
        mkdir -p ./example/javaoutput
        # TODO: Write.
        ;;
    *)
        echo -e $USAGE_TEXT
        ;;
esac
