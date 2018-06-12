#include "Client.h"

namespace Network
{

    /**
     * The method returns socket for current client.
     * @return smart pointer to client socket.
     */
    Client::SPtrClientSocket Client::getClientSocket() const
    {
        return _socket;
    }

    /**
     * The method sets socket for current client.
     * @param socket smart pointer to client socket.
     */
    void Client::setClientSocket(Client::SPtrClientSocket& socket)
    {
        _socket = socket;
    }

    /**
     * The method returns task of current client.
     * @return smart pointer to task.
     * @see Task
     */
    Client::SPtrTask Client::getTask() const
    {
        return _task;
    }

    /**
     * The method sets task for current client.
     * @param task smart pointer to task.
     * @see Task
     */
    void Client::setTask(Client::SPtrTask& task)
    {
        _task = task;
    }

    /**
     * The method returns text representation of an object.
     * @return text representation of an object.
     */
    std::string Client::toString() const
    {
        return "Client[Address: " + _socket->remote_endpoint().address().to_string() + " - " + "Task: " + _task->toString();
    }

}