#ifndef _LOGGER_H_
#define _LOGGER_H_

	#include <iostream>

	/**
	 *  Collection of macro for logging Logging works when the program is started in debug mode.
	 *  LOG_INFO - for various kinds of alerts during program execution.
	 *  LOG_DEBUG - for tracing individual parts of the program.
	 *  LOG_WARNING - for minor mistakes.
	 *  LOG_ERROR - for serious problems in which the program must complete its work.
	 */
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
