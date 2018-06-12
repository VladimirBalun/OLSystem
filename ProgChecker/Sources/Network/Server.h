#ifndef _SERVER_H_
#define _SERVER_H_

#include <thread>
#include <chrono>
#include <mutex>
#include <iostream>
#include <queue>
#include <boost/regex.hpp>
#include <boost/asio.hpp>

#include "IServer.h"
#include "Utils/Logger.h"
#include "Exceptions/Network/NetworkException.h"
#include "SystemChecking/ISystem.h"
#include "Network/Client.h"

namespace Network
{

    /**
     *
     */
    class Server : public IServer
    {
        typedef boost::asio::io_service IOService;
        typedef boost::asio::ip::tcp::acceptor Acceptor;
        typedef boost::asio::ip::tcp::socket ClientSocket;
        typedef std::shared_ptr<boost::asio::ip::tcp::socket> SPtrClientSocket;
        typedef boost::asio::ip::tcp TCP;
        typedef boost::asio::ip::address Address;
        typedef std::unique_ptr<SystemChecking::ISystem> UPtrSystemChecking;

        int _port;
        std::string _address;
        IOService _ioService;

        std::mutex _mutex;
        std::condition_variable _conditionVar;

        UPtrSystemChecking _systemChecking;
        std::queue<std::unique_ptr<Network::Client>> _clients;
    public:
        Server(UPtrSystemChecking& systemChecking) : _systemChecking(std::move(systemChecking)) {}
        void start(const std::string& address, int port) override;
    private:
        bool isValidIpAddress(std::string address);
        void handleClient();
    };

}

#endif
