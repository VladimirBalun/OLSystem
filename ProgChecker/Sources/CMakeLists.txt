set (DATA_OBJECTS_PATH DataObjects)
set (DATA_OBJECTS ${DATA_OBJECTS_PATH}/TestData.h
                  ${DATA_OBJECTS_PATH}/TestData.cpp
                  ${DATA_OBJECTS_PATH}/Task.h
                  ${DATA_OBJECTS_PATH}/Task.cpp)

set (EXCEPTIONS_PATH Exceptions)
set (EXCEPTIONS ${EXCEPTIONS_PATH}/IException.h
                ${EXCEPTIONS_PATH}/SystemChecking/SystemCheckingException.h
                ${EXCEPTIONS_PATH}/SystemChecking/NonExistLanguageException.h
                ${EXCEPTIONS_PATH}/SystemChecking/NonExistProgramException.h
                ${EXCEPTIONS_PATH}/Network/NetworkException.h)

set (NETWORK_PATH Network)
set (NETWORK ${NETWORK_PATH}/IServer.h
             ${NETWORK_PATH}/Server.h
             ${NETWORK_PATH}/Server.cpp
             ${NETWORK_PATH}/Client.h
             ${NETWORK_PATH}/Client.cpp
             ${NETWORK_PATH}/Response.h
             ${NETWORK_PATH}/Response.cpp
             ${NETWORK_PATH}/Request.h
             ${NETWORK_PATH}/Request.cpp)

set (COMPILERS_PATH SystemChecking/Programs/Compilers)
set (COMPILERS ${COMPILERS_PATH}/ICompiler.h
               ${COMPILERS_PATH}/CppC.h
               ${COMPILERS_PATH}/CppC.cpp)

set (INTERPRETERS_PATH SystemChecking/Programs/Interpreters)
set (INTERPRETERS ${INTERPRETERS_PATH}/IInterpreter.h
                  ${INTERPRETERS_PATH}/Python.h
                  ${INTERPRETERS_PATH}/Python.cpp)

set (PROGRAMS_PATH SystemChecking/Programs)
set (PROGRAMS ${COMPILERS}
              ${INTERPRETERS}
              ${PROGRAMS_PATH}/IProgram.h
              ${PROGRAMS_PATH}/CreatorPrograms.h
              ${PROGRAMS_PATH}/CreatorPrograms.cpp)

set (SYSTEM_CHECKING_PATH SystemChecking)
set (SYSTEM_CHECKING ${PROGRAMS}
                     ${SYSTEM_CHECKING_PATH}/ISystem.h
                     ${SYSTEM_CHECKING_PATH}/System.h
                     ${SYSTEM_CHECKING_PATH}/System.cpp
                     ${SYSTEM_CHECKING_PATH}/EResultChecking.h)

set (UTILS_PATH Utils)
set (UTILS ${UTILS_PATH}/Logger.h
           ${UTILS_PATH}/Terminal.h
           ${UTILS_PATH}/Terminal.cpp
           ${UTILS_PATH}/FileSystem.h
           ${UTILS_PATH}/FileSystem.cpp)

set (SOURCES main.cpp ${DATA_OBJECTS} ${EXCEPTIONS} ${NETWORK} ${UTILS} ${SYSTEM_CHECKING})

if (WIN32)

	set (BOOST_PATH E:/Libraries/Boost)
	set (Boost_INCLUDE_DIR ${BOOST_PATH}/include)
	set (LIBRARIES ${BOOST_PATH}/lib/libboost_filesystem-vc141-mt-gd-x32-1_67.lib 
				   ${BOOST_PATH}/lib/libboost_system-vc141-mt-gd-x32-1_67.lib
                   ${BOOST_PATH}/lib/libboost_date_time-vc141-mt-gd-x32-1_67.lib
				   ${BOOST_PATH}/lib/libboost_regex-vc141-mt-gd-x32-1_67.lib)

elseif (UNIX)

    set (LIBRARIES -lboost_system -lboost_filesystem -lboost_regex -lboost_date_time)

endif()

add_executable(${PROJECT_NAME} ${SOURCES})
target_include_directories (${PROJECT_NAME} PRIVATE ${Boost_INCLUDE_DIR})
target_link_libraries (${PROJECT_NAME} ${LIBRARIES})