package ru.testingsystem.data.dao;

public interface BasicDataDAO {

    String getTitleOfTest();

    void setTitleOfTest(String titleOfTest);

    String getDescriptionOfTest();

    void setDescriptionOfTest(String descriptionOfTest);

    String getTitleOfResult();

    void setTitleOfResult(String titleOfResult);

    String getDescriptionOfResult();

    void setDescriptionOfResult(String descriptionOfResult);

    String getAddress();

    void setAddress(String address);

    String getPhoneNumber();

    void setPhoneNumber(String phoneNumber);

    String getNameOfCollege();

    void setNameOfCollege(String nameOfCollege);

}