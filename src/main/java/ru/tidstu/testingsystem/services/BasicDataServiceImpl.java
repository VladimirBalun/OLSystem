package ru.tidstu.testingsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.tidstu.testingsystem.dao.BasicDataDAO;

public class BasicDataServiceImpl implements BasicDataService {

    @Autowired
    private BasicDataDAO basicDataDAO;

    public String getTitleOfTest() {
        return basicDataDAO.getTitleOfTest();
    }

    @Transactional
    public void setTitleOfTest(String titleOfTest) {
        basicDataDAO.setTitleOfTest(titleOfTest);
    }

    public String getDescriptionOfTest() {
        return basicDataDAO.getDescriptionOfTest();
    }

    @Transactional
    public void setDescriptionOfTest(String descriptionOfTest) {
        basicDataDAO.setDescriptionOfTest(descriptionOfTest);
    }

    public String getTitleOfResult() {
        return basicDataDAO.getTitleOfResult();
    }

    @Transactional
    public void setTitleOfResult(String titleOfResult) {
        basicDataDAO.setTitleOfResult(titleOfResult);
    }

    public String getDescriptionOfResult() {
        return basicDataDAO.getDescriptionOfResult();
    }

    @Transactional
    public void setDescriptionOfResult(String descriptionOfResult) {
        basicDataDAO.setDescriptionOfResult(descriptionOfResult);
    }

    public String getAddress() {
        return basicDataDAO.getAddress();
    }

    @Transactional
    public void setAddress(String address) {
        basicDataDAO.setAddress(address);
    }

    public String getPhoneNumber() {
        return basicDataDAO.getPhoneNumber();
    }

    @Transactional
    public void setPhoneNumber(String phoneNumber) {
        basicDataDAO.setPhoneNumber(phoneNumber);
    }

    public String getNameOfCollege() {
        return basicDataDAO.getNameOfCollege();
    }

    @Transactional
    public void setNameOfCollege(String nameOfCollege) {
        basicDataDAO.setNameOfCollege(nameOfCollege);
    }

}