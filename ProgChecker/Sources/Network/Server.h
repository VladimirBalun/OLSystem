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
#include "Request.h"
#include "Response.h"
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
        typedef boost::asio::ip::tcp::socket Socket;
        typedef boost::asio::ip::tcp TCP;
        typedef boost::asio::ip::address ServerAddress;
        typedef std::unique_ptr<Client> UPtrClient;
        typedef std::unique_ptr<boost::asio::ip::tcp::socket> UPtrSocket;
        typedef std::unique_ptr<SystemChecking::ISystem> UPtrSystemChecking;

        std::unique_ptr<IOService> _ioService;
        std::unique_ptr<ServerAddress> _serverAddress;
        std::unique_ptr<Acceptor> _acceptor;

        std::mutex _mutex;
        std::condition_variable _conditionVar;

        UPtrSystemChecking _systemChecking;
        std::queue<UPtrClient> _clients;
    public:
        Server(UPtrSystemChecking& systemChecking) : _systemChecking(std::move(systemChecking)) {}
        void start(const std::string& ipAddress, int port) override;
    private:
        void init(const std::string& ipAddress, int port);
        void listen();
        void handle();
    };

}

#endif