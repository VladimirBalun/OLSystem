#ifndef _CLIENT_H
#define _CLIENT_H

#include <boost/asio.hpp>

#include "DataObjects/Task.h"

namespace Network
{

    class Client
    {
    public:
        typedef boost::asio::ip::tcp::socket ClientSocket;
        typedef std::shared_ptr<boost::asio::ip::tcp::socket> SPtrClientSocket;
        typedef std::shared_ptr<Objects::Task> SPtrTask;
        Client(SPtrClientSocket& socket, SPtrTask& task) : _socket(socket), _task(task) {};
        SPtrClientSocket getClientSocket() const;
        void setClientSocket(SPtrClientSocket& socket);
        SPtrTask getTask() const;
        void setTask(SPtrTask& task);
        int getResultChecking() const;
        void setResultChecking(int resultChecking);
    private:
        SPtrClientSocket _socket;
        SPtrTask _task;
        int _resultChecking;
    };

}

#endif
