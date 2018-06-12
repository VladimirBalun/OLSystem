#ifndef _I_SERVER_H_
#define _I_SERVER_H_

namespace Network
{

    /**
     * The interface of network package. It
     * contains an external API for working
     * with the network.
     */
    struct IServer
    {
        virtual void start(const std::string& address, int port) = 0;
        virtual ~IServer() = default;
    };

}

#endif
