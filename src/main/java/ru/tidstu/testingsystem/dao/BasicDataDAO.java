package ru.tidstu.testingsystem.dao;

public interface BasicDataDAO {

    public String getTitleOfTest();

    public void setTitleOfTest(String titleOfTest);

    public String getDescriptionOfTest();

    public void setDescriptionOfTest(String descriptionOfTest);

    public String getTitleOfResult();

    public void setTitleOfResult(String titleOfResult);

    public String getDescriptionOfResult();

    public void setDescriptionOfResult(String descriptionOfResult);

    public String getAddress();

    public void setAddress(String address);

    public String getPhoneNumber();

    public void setPhoneNumber(String phoneNumber);

    public String getNameOfCollege();

    public void setNameOfCollege(String nameOfCollege);

}