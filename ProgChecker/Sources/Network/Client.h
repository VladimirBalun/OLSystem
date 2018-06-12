#ifndef _CLIENT_H_
#define _CLIENT_H_

#include <string>
#include <boost/asio.hpp>

#include "DataObjects/Task.h"

namespace Network
{

    /**
     * The class represents client of the network. It
     * contains client socket and its task and result
     * of checking task.
     * @see Task
     */
    class Client
    {
        typedef std::shared_ptr<boost::asio::ip::tcp::socket> SPtrClientSocket;
        typedef std::shared_ptr<Objects::Task> SPtrTask;

        SPtrClientSocket _socket;
        SPtrTask _task;
    public:
        Client(SPtrClientSocket& socket, SPtrTask& task) : _socket(socket), _task(task) {}
        SPtrClientSocket getClientSocket() const;
        void setClientSocket(SPtrClientSocket& socket);
        SPtrTask getTask() const;
        void setTask(SPtrTask& task);
        std::string toString() const;
    };

}

#endif
