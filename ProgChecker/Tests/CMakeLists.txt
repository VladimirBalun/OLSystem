cmake_minimum_required (VERSION 3.8)

set(PATH_SRC ${CMAKE_SOURCE_DIR}/Sources)
include_directories (${PATH_SRC})

#add_library (libTestCompilerC STATIC ${PATH_SRC}/Checking/ICompiler.h
#                                 ${PATH_SRC}/Checking/CCompiler.h
#                                 ${PATH_SRC}/Checking/CCompiler.cpp
#                                 ${PATH_SRC}/Checking/Terminal.h
#                                 ${PATH_SRC}/Checking/Terminal.cpp)

add_library (libTestCompilerCpp STATIC ${PATH_SRC}/Checking/ICompiler.h
                                   ${PATH_SRC}/Checking/CppCompiler.h
                                    ${PATH_SRC}/Checking/CppCompiler.cpp
                                    ${PATH_SRC}/Checking/Terminal.h
                                    ${PATH_SRC}/Checking/Terminal.cpp)
target_link_libraries (libTestCompilerCpp -lboost_system lboost_filesystem lboost_regex lboost_date_time)


SET(TESTS TestCompilerCpp)
add_definitions (-DBOOST_TEST_DYN_LINK)

find_package (Boost COMPONENTS unit_test_framework REQUIRED)

foreach (_test ${TESTS})
    add_executable (${_test} ${_test}.cpp)
    target_link_libraries (lib${_test} ${Boost_LIBRARIES})
    add_test (NAME ${_test} COMMAND ${_test})
endforeach ()

