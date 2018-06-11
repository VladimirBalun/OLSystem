#ifndef _SERVER_H_
#define _SERVER_H_

#include <iostream>
#include <queue>
#include <thread>
#include <chrono>
#include <mutex>
#include <boost/regex.hpp>
#include <boost/asio.hpp>
#include <boost/bind.hpp>

#include "IServer.h"
#include "Utils/Logger.h"
#include "Exceptions/NetworkException.h"
#include "SystemChecking/ISystem.h"
#include "Network/Client.h"

namespace Network
{

    class Server : public IServer
    {
    public:
        typedef boost::asio::io_service IOService;
        typedef boost::asio::ip::tcp::acceptor Acceptor;
        typedef boost::asio::ip::tcp::socket ClientSocket;
        typedef std::shared_ptr<boost::asio::ip::tcp::socket> SPtrClientSocket;
        typedef boost::asio::ip::tcp TCP;
        typedef boost::asio::ip::address Address;
        typedef std::unique_ptr<SystemChecking::ISystem> UPtrSystemChecking;

        Server(UPtrSystemChecking& systemChecking);
        void start() override;
    private:
        bool checkIpV4Address(std::string address);
        bool checkPort(std::string port);
    private:
        int _port;
        std::string _address = "127.0.0.1";
        std::mutex _mutex;
        std::condition_variable _conditionVar;
        UPtrSystemChecking _systemChecking;
        std::queue<std::unique_ptr<Network::Client>> _clients;
    };

}

#endif
