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
        typedef boost::asio::ip::tcp::socket Socket;
        typedef std::unique_ptr<boost::asio::ip::tcp::socket> UPtrSocket;
        typedef std::shared_ptr<Objects::Task> SPtrTask;

        UPtrSocket _socket;
        SPtrTask _task;
    public:
        Client(UPtrSocket& socket, SPtrTask& task) : _socket(std::move(socket)), _task(task) {}
        Socket* getClientSocket() const;
        void setClientSocket(UPtrSocket& socket);
        SPtrTask getTask() const;
        void setTask(SPtrTask& task);
        std::string toString() const;
    };

}

#endif
