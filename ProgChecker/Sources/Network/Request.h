#ifndef _REQUEST_H_
#define _REQUEST_H_

#include <iostream>
#include <sstream>
#include <boost/property_tree/ptree.hpp>
#include <boost/property_tree/json_parser.hpp>

#include "DataObjects/Task.h"
#include "Utils/Logger.h"

namespace Network
{

    /**
     *
     */
    class Request
    {
        typedef std::unique_ptr<Objects::Task> UPtrTask;
        typedef std::shared_ptr<Objects::TestData> SPtrTestData;
    public:
        static UPtrTask parseClientRequest(const std::string& request);
    private:
        static std::vector<SPtrTestData> parseTestData(const boost::property_tree::ptree& root);
    };

}

#endif