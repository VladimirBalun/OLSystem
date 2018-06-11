#ifndef _ISERVER_H_
#define _ISERVER_H_

namespace Network
{

    struct IServer
    {
        virtual void start() = 0;
        virtual ~IServer() {}
    };

}

#endif
