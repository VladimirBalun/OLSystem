#ifndef _RESPONSE_H_
#define _RESPONSE_H_

#include <iostream>
#include <sstream>
#include <boost/property_tree/ptree.hpp>
#include <boost/property_tree/json_parser.hpp>

namespace Network
{

    /**
     *
     */
    struct Response
    {
        static std::string createNetworkResponse(int result);
    };

}

#endif
