#include "Request.h"

namespace Network
{

    /**
     * This function parses request from client in JSON format.. After parsing,
     * function builds task of client and returns it.
     * @param request request from client in JSON format.
     * @return
     */
    Request::SPtrTask Request::parseRequest(const std::string& request) {
        try
        {
            std::stringstream stream;
            stream << request;
            boost::property_tree::ptree root;
            boost::property_tree::read_json(stream, root);
            std::string textProgram = root.get_child("textProgram").data();
            return std::make_shared<Objects::Task>(textProgram, std::move(parseTestData(root)));
        }
        catch (std::exception& e)
        {
            LOG_WARNING(__FILE__, "Incorrect network request.");
            std::cerr << e.what() << std::endl;
        }
    }

    /**
     * This function parses JSON. After parsing, it builds vector of smart pointers
     * to test data for task.
     * @param root json with test data.
     * @return vector of smart pointers to test data for task.
     */
    std::vector<Request::SPtrTestData> Request::parseTestData(const boost::property_tree::ptree& root)
    {
        std::vector<std::shared_ptr<Objects::TestData>> testData;
        for (const auto &data : root.get_child("testData"))
        {
            std::string inputData;
            std::string outputData;
            for (const auto& element : data.second)
            {
                if(element.first == "inputData")
                {
                    inputData = element.second.get_value<std::string>();
                }
                if(element.first == "outputData")
                {
                    outputData = element.second.get_value<std::string>();
                }
            }
            testData.push_back(std::make_shared<Objects::TestData>(inputData, outputData));
        }
        return testData;
    }

}