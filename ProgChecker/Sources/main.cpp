#include <iostream>

#include "Utils/FileSystem.h"
#include "SystemChecking/System.h"
#include "Network/Server.h"
#include "Exceptions/SystemChecking/SystemCheckingException.h"
#include "Exceptions/Network/NetworkException.h"

int main(int argc, char* argv[])
{
    const int COUNT_CMD_ARGUMENTS = 3; // 0-[ProgChecker] 1-[PROGRAMMING_LANGUAGE] 2-[COMPILER_OR_INTERPRETER]
    if(argc < COUNT_CMD_ARGUMENTS)
    {
        std::string tutorialRunningProgram = Utils::read_file("Resources/TutorialRunningProgram.txt");
        std::cout << tutorialRunningProgram << std::endl;
        LOG_ERROR(__FILE__, "Incorrect input parameters for program.");
        return EXIT_FAILURE;
    }

    try
    {
        typedef std::unique_ptr<SystemChecking::ISystem> UPtrISystemChecking;
        typedef std::unique_ptr<Network::IServer> UPtrIServer;

        UPtrISystemChecking systemChecking = std::make_unique<SystemChecking::System>(argv[1], argv[2]);
        UPtrIServer server = std::make_unique<Network::Server>(systemChecking);
        server->start("127.0.0.1", 13); // test contacts
    }
    catch(Exceptions::NetworkException& e)
    {
        std::cerr << e.what() << std::endl;
        LOG_ERROR(__FILE__, e.what());
        return EXIT_FAILURE;
    }
    catch (Exceptions::SystemCheckingException& e)
    {
        std::cerr << e.what() << std::endl;
        LOG_ERROR(__FILE__, e.what());
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}