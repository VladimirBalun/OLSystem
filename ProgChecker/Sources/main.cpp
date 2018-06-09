#include <iostream>

#include "Utils/FileSystem.h"
#include "SystemChecking/System.h"
#include "Exceptions/SystemCheckingException.h"
#include "Network/Server.h"
#include "Exceptions/NetworkException.h"

std::unique_ptr<SystemChecking::ISystem> create_checking_system(const std::string& language, const std::string& compilerOrInterpreter);
std::unique_ptr<Network::IServer> create_server(const std::string& address, const std::string& port);

int main(int argc, char* argv[])
{
    #define COUNT_CMD_ARGUMENTS 4 // 1-[PROGRAMMING_LANGUAGE] 2-[COMPILER_OR_INTERPRETER] 3-[ADDRESS] 4-[PORT]
    if(argc < COUNT_CMD_ARGUMENTS)
    {
        std::string tutorialRunningProgram = Utils::read_file("Resources/TutorialRunningProgram.txt");
        std::cout << tutorialRunningProgram << std::endl;
        LOG_ERROR(__FILE__, "Incorrect input parameters for program.");
        return EXIT_FAILURE;
    }

    std::unique_ptr<SystemChecking::ISystem> checkingSystem = create_checking_system(argv[1], argv[2]);
    std::unique_ptr<Network::IServer> server = create_server(argv[3], argv[4]);
    server->startServer();

    return EXIT_SUCCESS;
}

std::unique_ptr<SystemChecking::ISystem> create_checking_system(const std::string& language, const std::string& compilerOrInterpreter)
{
    try
    {
        return std::make_unique<SystemChecking::System>(language, compilerOrInterpreter);
    }
    catch (Exceptions::SystemCheckingException &e)
    {
        std::cerr << e.what() << std::endl;
        LOG_ERROR(__FILE__, e.what());
        exit(EXIT_FAILURE);
    }
}

std::unique_ptr<Network::IServer> create_server(const std::string& address, const std::string& port)
{
    try
    {
        return std::make_unique<Network::Server>(address, port);
    }
    catch (Exceptions::NetworkException &e)
    {
        std::cerr << e.what() << std::endl;
        LOG_ERROR(__FILE__, e.what());
        exit(EXIT_FAILURE);
    }
}