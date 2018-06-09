#ifndef _ISERVER_H_
#define _ISERVER_H_

#include "Utils/Logger.h"

namespace Network
{

    struct IServer
    {
        virtual void startServer() = 0;
        virtual void stopServer() = 0;
        virtual ~IServer() {}
    };

}

#endif
