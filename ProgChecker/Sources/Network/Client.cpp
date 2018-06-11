#include "Client.h"

namespace Network
{

    Client::SPtrClientSocket Client::getClientSocket() const
    {
        return _socket;
    }

    void Client::setClientSocket(Client::SPtrClientSocket& socket)
    {
        _socket = socket;
    }

    Client::SPtrTask Client::getTask() const
    {
        return _task;
    }

    void Client::setTask(Client::SPtrTask& task)
    {
        _task = task;
    }

    int Client::getResultChecking() const
    {
        return _resultChecking;
    }

    void Client::setResultChecking(int resultChecking)
    {
        _resultChecking = resultChecking;
    }

}