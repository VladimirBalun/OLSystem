#include "Server.h"

namespace Network
{

    void Server::start(const std::string& address, int port)
    {
        if(isValidIpAddress(address))
        {
            LOG_DEBUG(__FILE__, "Building server... Address: \"" + address + "\" is valid.");
            _address = address;
            _port = port;
        }
        else
        {
            throw Exceptions::NetworkException("IP address isn't valid. Use ipv4: \"000.000.000.000\".");
        }

        Address ipAddress = Address::from_string(_address);
        Acceptor acceptor(_ioService, TCP::endpoint(ipAddress, _port));

        // Thread - handler of clients
        std::thread threadCheckingTask([&] {
            while (true)
            {
                std::unique_lock<std::mutex> lock{_mutex};
                _conditionVar.wait(lock);
                handleClient();
                _clients.pop();
            }
        });

        // Thread - listener of connections
        while (true)
        {
            SPtrClientSocket clientSocket(new ClientSocket(_ioService));
            acceptor.accept(*clientSocket);
            char buff[4096];
            size_t length = clientSocket->read_some(boost::asio::buffer(buff));
            std::unique_lock<std::mutex> lock{_mutex};
            _clients.push(nullptr); // test code
            _conditionVar.notify_one();
        }
    }

    /**
     * The method checks the validity of the ipV4 address.
     * @param address ipV4 address.
     * @return valid or invalid ipV4 address.
     */
    bool Server::isValidIpAddress(std::string address)
    {
        boost::regex regEx("(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\"
                           ".(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\"
                           ".(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\"
                           ".(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)");
        boost::smatch resultChecking;
        return boost::regex_match(address, resultChecking, regEx);
    }

    /**
     * The method handles connected clients. Here calls system checking tasks
     * for checking task of client. After result is sent to the client.
     */
    void Server::handleClient()
    {
        std::string response = "testResponse";
        boost::system::error_code ignoredErrorCode;
        boost::asio::write(*_clients.front()->getClientSocket(), boost::asio::buffer(response), ignoredErrorCode);
    }

}