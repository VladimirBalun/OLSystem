#ifndef _JSON_UTIL_H
#define _JSON_UTIL_H

#include <string>
#include <cassert>
#include <exception>
#include <iostream>
#include <sstream>
#include <boost/foreach.hpp>
#include <boost/property_tree/ptree.hpp>
#include <boost/property_tree/json_parser.hpp>

#include "../Entity/Task.h"
#include "../Entity/TestData.h"

Task parseTaskFromJson(const std::stringstream& jsonTask);
std::string generateJsonResponse(const size_t& result);

#endif // _JSON_UTIL_H
