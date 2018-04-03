package ru.testingsystem.data.service;

import ru.testingsystem.data.entity.ProgrammingLanguage;

import java.util.List;

public interface BasicDataService {

    List<ProgrammingLanguage> getAllProgrammingLanguagesOlympiad();

    String getTitleTestingSystem();

    void setTitleTestingSystem(String titleOfTest);

    String getDescriptionTestingSystem();

    void setDescriptionTestingSystem(String descriptionOfTest);

    String getTitleResultOlympiad();

    void setTitleResultOlympiad(String titleOfResult);

    String getDescriptionResultOlympiad();

    void setDescriptionResultOlympiad(String descriptionOfResult);

    String getAddressCollege();

    void setAddressCollege(String address);

    String getPhoneNumberCollege();

    void setPhoneNumberCollege(String phoneNumber);

    String getNameCollege();

    void setNameCollege(String nameOfCollege);

    String getProgrammingLanguageOlympiad();

    void setProgrammingLanguageOlympiad(String nameLanguage);

    String getTimePassingOlympiad();

    void setTimePassingOlympiad(String time);

}
