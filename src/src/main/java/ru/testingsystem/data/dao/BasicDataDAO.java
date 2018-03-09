package ru.testingsystem.data.dao;

public interface BasicDataDAO {

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

}