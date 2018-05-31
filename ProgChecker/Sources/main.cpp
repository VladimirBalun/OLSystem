#include <iostream>
#include <memory>

#include "Checking/Program.h"
#include "Checking/Languages.h"
#include "Checking/EResultsChecking.h"
#include "Data/Accesses/JsonUtil.h"

void initial_system_check(const std::string& lang);

int main(int argc, char* argv[]) {

    std::string currLang = argv[1];
    initial_system_check(currLang);

//    Program::setLanguageForPrograms(currLang.c_str());
//    Program program("/home/vova/main", "#include <iostream>\n"
//                                       "#include <string>\n"
//                                       "\n"
//                                       "int main()\n"
//                                       "{\n"
//                                       "\tstd::string buff;\n"
//                                       "\tstd::cin >> buff; \n"
//                                       "\tstd::cout << buff << std::endl; \n"
//                                       "\n"
//                                       "\treturn 0;\n"
//                                       "}");
//    std::vector<std::shared_ptr<TestData>> testData;
//    testData.push_back(std::make_shared<TestData>("23", "23"));
//    std::cout << program.checkProgram(testData) << std::endl;
//    Program program2("/home/vova/second", "#include <iostream>\n"
//                                       "#include <string>\n"
//                                       "\n"
//                                       "int main()\n"
//                                       "{\n"
//                                       "\tstd::string buff;\n"
//                                       "\tstd::cin >> buff;\n"
//                                       "\tstd::cout << buff << std::endl;\n"
//                                       "\treturn 0;\n"
//                                       "}");
//    testData.push_back(std::make_shared<TestData>("29", "29"));
//    std::cout << program2.checkProgram(testData) << std::endl;


    //parseTaskFromJson("Sd");
    std::cout << generateJsonResponse(100) << std::endl;

    return EXIT_SUCCESS;

}

void initial_system_check(const std::string& lang)
{
    Languages languages;
    if (!languages.checkEnteringLanguage(lang))
    {
        std::cerr << "Error." << std::endl;
        exit(USER_ERROR);
    }
    if (!languages.checkLanguageOnPC(lang))
    {
        std::cerr << "Error. Language \""  << lang << "\" doesn't installed in your PC.\n"
                     "You can run script \"languages.sh\" for installing it..." << std::endl;
        exit(USER_ERROR);
    }
}