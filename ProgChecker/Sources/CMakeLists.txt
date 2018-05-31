set (SOURCES main.cpp
        Utils/Server.cpp
        Data/Accesses/FileSystem.cpp
        Checking/Compilers/CCompiler.cpp
        Checking/Compilers/CppCompiler.cpp Checking/Languages.cpp Checking/Terminal.cpp Data/Entity/TestData.cpp Checking/Program.cpp Data/Accesses/JsonUtil.cpp)

set (HEADERS Utils/Server.h
        Data/Accesses/FileSystem.h
        Checking/Compilers/CCompiler.h
        Checking/Compilers/ICompiler.h
        Utils/Logger.h Checking/Compilers/CppCompiler.h Checking/EResultsChecking.h Checking/Languages.h Checking/Terminal.h Exceptions/IException.h Exceptions/IOException.h Data/Entity/TestData.h Checking/Program.h Data/Accesses/JsonUtil.h Data/Entity/Task.cpp Data/Entity/Task.h)

if (WIN32)


elseif (UNIX)

    set (LIBRARIES -lboost_system -lboost_filesystem -lboost_regex -lboost_date_time)


endif()


add_executable(${PROJECT_NAME} ${SOURCES} ${HEADERS})
target_include_directories (${PROJECT_NAME} PRIVATE ${Boost_INCLUDE_DIR})
target_link_libraries (${PROJECT_NAME} ${LIBRARIES})