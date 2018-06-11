#include "Server.h"

namespace Network
{

    Server::Server(UPtrSystemChecking& systemChecking) : _systemChecking(std::move(systemChecking))
    {
//        if(checkIpV4Address(address))
//        {
//            LOG_DEBUG(__FILE__, "Building server... Address: \"" + address + "\" is valid.");
//            _address = address;
//        }
//        else
//        {
//            throw Exceptions::NetworkException("IP address isn't valid. Use ipv4: \"000.000.000.000\".");
//        }
//
//        if(checkPort(port))
//        {
//            LOG_DEBUG(__FILE__, "Building server... Port: \"" + port + "\" is valid.");
//            _port = (int)port.c_str();
//        }
//        else
//        {
//            throw Exceptions::NetworkException("Incorrect port. Port must be a number.");
//        }
    }

    void Server::start()
    {
        IOService ioService;
        Address ipAddress = Address::from_string(_address);
        Acceptor acceptor(ioService, TCP::endpoint(ipAddress, 13));
        // Thread for checking tasks
        std::thread threadCheckingTask([&] {
            while (true)
            {
                std::unique_lock<std::mutex> lock{_mutex};
                _conditionVar.wait(lock);
                std::string message = "Message from handler";
                boost::system::error_code ignoredErrorCode;
                boost::asio::write(*_clients.front()->getClientSocket(), boost::asio::buffer(message), ignoredErrorCode);
                _clients.pop();
            }
        });
        // Thread for listening connections with clients
        while (true)
        {
            SPtrClientSocket clientSocket(new ClientSocket(ioService));
            acceptor.accept(*clientSocket);
            char buff[4096];
            size_t length = clientSocket->read_some(boost::asio::buffer(buff));

            // Test Code
            std::vector<std::shared_ptr<Objects::TestData>> testData;
            testData.push_back(std::make_shared<Objects::TestData>("34", "34"));
            testData.push_back(std::make_shared<Objects::TestData>("45", "45"));
            testData.push_back(std::make_shared<Objects::TestData>("67", "67"));
            std::shared_ptr<Objects::Task> task = std::make_shared<Objects::Task>("text", testData);
            for(const auto& it : task->getTestDataForTask())
            {
                std::cout << it->getInputData() << " : " << it->getOutputData() << std::endl;
            }

            std::unique_lock<std::mutex> lock{_mutex};
            _clients.push(std::make_unique<Network::Client>(clientSocket, task));
            _conditionVar.notify_one();
        }
    }

    bool Server::checkIpV4Address(std::string address)
    {
        boost::regex regEx("(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\"
                           ".(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\"
                           ".(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\"
                           ".(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)");
        boost::smatch resultChecking;
        return boost::regex_match(address, resultChecking, regEx);
    }

    bool Server::checkPort(std::string port)
    {
        for (auto symbol : port)
        {
            if (!isdigit(symbol))
            {
                return false;
            }
        }
        return true;
    }

}