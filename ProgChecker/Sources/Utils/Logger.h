#ifndef _LOGGER_H_
#define _LOGGER_H_

	#include <iostream>

	#if defined(_DEBUG) || defined(NDEBUG)

		#define LOG_INFO(NAME_FILE, TEXT) \
				( std::cout << "[INFO] " << __TIMESTAMP__ << "  " << NAME_FILE << "  " << TEXT << std::endl )

		#define LOG_DEBUG(NAME_FILE, TEXT) \
				( std::cout << "[DEBUG] " << __TIMESTAMP__ << "  " << NAME_FILE << "  " << TEXT << std::endl )

		#define LOG_WARNING(NAME_FILE, TEXT) \
				( std::cerr << "[WARNING] " << __TIMESTAMP__ << "  " << NAME_FILE << "  " << TEXT << std::endl )

		#define LOG_ERROR(NAME_FILE, TEXT) \
				( std::cerr << "[ERROR] " << __TIMESTAMP__ << "  " << NAME_FILE << "  " << TEXT << std::endl )

	#else

		#define LOG_INFO(NAME_FILE, TEXT) \
			((void)0)

		#define LOG_DEBUG(NAME_FILE, TEXT) \
			((void)0)

		#define LOG_WARNING(NAME_FILE, TEXT) \
			((void)0)

		#define LOG_ERROR(NAME_FILE, TEXT) \
			((void)0)

	#endif

#endif
