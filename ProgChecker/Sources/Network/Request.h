#ifndef _REQUEST_H_
#define _REQUEST_H_

#include <iostream>
#include <sstream>
#include <boost/property_tree/ptree.hpp>
#include <boost/property_tree/json_parser.hpp>

#include "DataObjects/Task.h"

namespace Network
{

    /**
     * The class is used for parsing client requests
     * in JSON format.
     */
    class Request
    {
        typedef std::shared_ptr<Objects::Task> SPtrTask;
        typedef std::shared_ptr<Objects::TestData> SPtrTestData;
    public:
        static SPtrTask parseRequest(const std::string& request);
    private:
        static std::vector<SPtrTestData> parseTestData(const boost::property_tree::ptree& root);
    };

}

#endif