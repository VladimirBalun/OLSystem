#include "JsonUtil.h"

Task parseTaskFromJson(const std::string& jsonTask)
{
    std::stringstream ss;
    ss << "{ \"root\": { \"values\": [1, 2, 3, 4, 5 ] } }";

    boost::property_tree::ptree pt;
    boost::property_tree::read_json(ss, pt);

    BOOST_FOREACH(boost::property_tree::ptree::value_type &v, pt.get_child("root.values"))
                {
                    assert(v.first.empty()); // array elements have no names
                    std::cout << v.second.data() << std::endl;
                }
}

std::string generateJsonResponse(const size_t& result)
{
    boost::property_tree::ptree root;
    root.put("resultChecking", "100");
    std::string resultJson;
    boost::property_tree::write_json(resultJson, root);
    return resultJson;
}