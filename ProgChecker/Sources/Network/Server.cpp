#include "Server.h"

namespace Network
{

    Server::Server(const std::string& address, const std::string& port)
    {
        if(checkIpV4Address(address))
        {
            LOG_DEBUG(__FILE__, "Building server... Address: \"" + address + "\" is valid.");
            _address = address;
        }
        else
        {
            throw Exceptions::NetworkException("IP address isn't valid. Use ipv4: \"000.000.000.000\".");
        }

        if(checkPort(port))
        {
            LOG_DEBUG(__FILE__, "Building server... Port: \"" + port + "\" is valid.");
            _port = (int)port.c_str();
        }
        else
        {
            throw Exceptions::NetworkException("Incorrect port. Port must be a number.");
        }
    }


    void Server::startServer()
    {
        std::cout << "Server was started!" << std::endl;
    }

    void Server::stopServer()
    {

    }

    bool Server::checkIpV4Address(std::string address)
    {
        boost::regex regEx("(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)");
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