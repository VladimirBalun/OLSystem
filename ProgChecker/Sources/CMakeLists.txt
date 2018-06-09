set (SOURCES main.cpp
             Network/Server.cpp
             SystemChecking/System.cpp
             SystemChecking/Programs/CreatorPrograms.cpp
             SystemChecking/Programs/Interpreters/Python.cpp
        SystemChecking/Programs/Compilers/CppC.cpp
             Objects/TestData.cpp
             Objects/Task.cpp
             Utils/Terminal.cpp
             Utils/FileSystem.cpp)


set (HEADERS Exceptions/IException.h
             Exceptions/IOException.h
             Exceptions/SystemCheckingException.h
             Exceptions/NetworkException.h
             Network/IServer.h
             Network/Server.h
             SystemChecking/ISystem.h SystemChecking/Programs/Interpreters/Python.h
             SystemChecking/Programs/Interpreters/IInterpreter.h
        SystemChecking/Programs/Compilers/CppC.h
             SystemChecking/Programs/Compilers/ICompiler.h
             SystemChecking/System.h
			 SystemChecking/EResultChecking.h
             SystemChecking/Programs/IProgram.h
             SystemChecking/Programs/CreatorPrograms.h
             Objects/TestData.h
             Objects/Task.h
             Utils/Logger.h
             Utils/Terminal.h
             Utils/FileSystem.h)

if (WIN32)

	set (BOOST_PATH E:/Libraries/Boost)
	set (Boost_INCLUDE_DIR ${BOOST_PATH}/include)
	set (LIBRARIES ${BOOST_PATH}/lib/libboost_filesystem-vc141-mt-gd-x32-1_67.lib 
				   ${BOOST_PATH}/lib/libboost_system-vc141-mt-gd-x32-1_67.lib
				   ${BOOST_PATH}/lib/libboost_regex-vc141-mt-gd-x32-1_67.lib)

elseif (UNIX)

    set (LIBRARIES -lboost_system -lboost_filesystem -lboost_regex -lboost_date_time)

endif()

add_executable(${PROJECT_NAME} ${SOURCES} ${HEADERS})
target_include_directories (${PROJECT_NAME} PRIVATE ${Boost_INCLUDE_DIR})
target_link_libraries (${PROJECT_NAME} ${LIBRARIES})