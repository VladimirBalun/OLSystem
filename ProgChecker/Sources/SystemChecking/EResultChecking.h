#ifndef _E_RESULT_CHECKING_H_
#define _E_RESULT_CHECKING_H_

namespace SystemChecking
{

    /**
     * The enumeration for results of checking tasks.
     * 100 - Successful program execution.
     * 101 - Error while compiling the program (for compiled languages).
     * 102 - Error during program execution.
     * 103 - Security error related to the application and the entire system.
     * 104 - Unknown error.
     */
    enum EResultChecking
    {
        SUCCESSFUL_CHECKING = 100,
        COMPILATION_ERROR = 101,
        RUN_TIME_ERROR = 102,
        SECURITY_ERROR = 103,
        UNKNOWN_ERROR = 104,
    };

}

#endif