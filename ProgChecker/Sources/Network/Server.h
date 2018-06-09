#ifndef _SERVER_H_
#define _SERVER_H_

#include <iostream>
#include <queue>
#include <boost/regex.hpp>

#include "IServer.h"
#include "Exceptions/NetworkException.h"

namespace Network
{

    class Server : public IServer
    {
    public:
        Server(const std::string& address, const std::string& port);
        void startServer() override;
        void stopServer() override;
    private:
        bool checkIpV4Address(std::string address);
        bool checkPort(std::string port);
    private:
        std::string _address;
        int _port;
        std::queue<std::string> _clients;
    };

}

#endif
