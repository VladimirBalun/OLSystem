cmake_minimum_required (VERSION 3.8)

set(PATH_SRC ${CMAKE_SOURCE_DIR}/Sources)
include_directories (${PATH_SRC})

add_library (libTestTerminal STATIC ${PATH_SRC}/Utils/Terminal.h ${PATH_SRC}/Utils/Terminal.cpp)

SET(TESTS TestTerminal)

if (WIN32)

    set (BOOST_PATH E:/Libraries/Boost)
    set (Boost_INCLUDE_DIR ${BOOST_PATH}/include)
    set (LIBRARIES ${BOOST_PATH}/lib/libboost_unit_test_framework-vc141-mt-gd-x32-1_67.lib)

elseif (UNIX)

    set (LIBRARIES -lboost_unit_test_framework -lboost_filesystem -lboost_system)

endif()

foreach (_test ${TESTS})
    add_executable (${_test} ${_test}.cpp)
    target_include_directories (${_test} PRIVATE ${Boost_INCLUDE_DIR})
    target_link_libraries (lib${_test} ${LIBRARIES})
    add_test (NAME ${_test} COMMAND ${_test})
endforeach ()

