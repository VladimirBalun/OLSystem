#include "Checking/Compilers/CCompiler.h"

#include <boost/test/unit_test.hpp>

#define BOOST_TEST_MODULE TestCompilerC

BOOST_AUTO_TEST_CASE(successfulCompilation)
{

    BOOST_CHECK_EQUAL(0, 0);
}