#ifndef _LANGUAGES_H_
#define _LANGUAGES_H_

#include <string>
#include <vector>
#include <iostream>
#include <boost/process.hpp>

class Languages
{
public:
    bool checkEnteringLanguage(const std::string& lang);
    bool checkLanguageOnPC(const std::string& lang);
    std::vector<std::string> getAllSupportingLanguages() const;
private:
    std::vector<std::string>_languages = {"Java", "Cpp", "C", "Python"};
};

#endif // _LANGUAGES_H_
