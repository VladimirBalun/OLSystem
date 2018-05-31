#ifndef _LOGGER_H
#define _LOGGER_H

#include <string>
#include <iostream>

#define LOG_INFO(NAME_FILE, TEXT) \
		(std::cout << "[INFO]  " << __TIMESTAMP__ << "  " << NAME_FILE << "  " << TEXT << std::endl )

#define LOG_DEBUG(NAME_FILE, TEXT) \
		(std::cout << "[DEBUG]  " << __TIMESTAMP__ << "  " << NAME_FILE << "  " << TEXT << std::endl )

#define LOG_WARNING(NAME_FILE, TEXT) \
		(std::cout << "[WARNING]  " << __TIMESTAMP__ << "  " << NAME_FILE << "  " << TEXT << std::endl )

#define LOG_ERROR(NAME_FILE, TEXT) \
		(std::cout << "[ERROR]  " << __TIMESTAMP__ << "  " << NAME_FILE << "  " << TEXT << std::endl )

#endif // _LOGGER_H
