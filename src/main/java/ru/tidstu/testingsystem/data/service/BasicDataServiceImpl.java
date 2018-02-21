package ru.tidstu.testingsystem.data.service;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.tidstu.testingsystem.data.dao.BasicDataDAO;

@Log4j
public class BasicDataServiceImpl implements BasicDataService {

    @Autowired
    private BasicDataDAO basicDataDAO;

    public String getTitleOfTest() {
        return basicDataDAO.getTitleOfTest();
    }

    @Transactional
    public void setTitleOfTest(String titleOfTest) {
        basicDataDAO.setTitleOfTest(titleOfTest);
        log.debug("Title of Testing System was changed on " + titleOfTest);
    }

    public String getDescriptionOfTest() {
        return basicDataDAO.getDescriptionOfTest();
    }

    @Transactional
    public void setDescriptionOfTest(String descriptionOfTest) {
        basicDataDAO.setDescriptionOfTest(descriptionOfTest);
        log.debug("Description of Testing System was changed on " + descriptionOfTest);
    }

    public String getTitleOfResult() {
        return basicDataDAO.getTitleOfResult();
    }

    @Transactional
    public void setTitleOfResult(String titleOfResult) {
        basicDataDAO.setTitleOfResult(titleOfResult);
        log.debug("Title of result Olympiad was changed on " + titleOfResult);
    }

    public String getDescriptionOfResult() {
        return basicDataDAO.getDescriptionOfResult();
    }

    @Transactional
    public void setDescriptionOfResult(String descriptionOfResult) {
        basicDataDAO.setDescriptionOfResult(descriptionOfResult);
        log.debug("Description of result Olympiad was changed on " + descriptionOfResult);
    }

    public String getAddress() {
        return basicDataDAO.getAddress();
    }

    @Transactional
    public void setAddress(String address) {
        basicDataDAO.setAddress(address);
        log.debug("Address of Testing System was changed on " + address);
    }

    public String getPhoneNumber() {
        return basicDataDAO.getPhoneNumber();
    }

    @Transactional
    public void setPhoneNumber(String phoneNumber) {
        basicDataDAO.setPhoneNumber(phoneNumber);
        log.debug("Phone number of Testing System was changed on " + phoneNumber);
    }

    public String getNameOfCollege() {
        return basicDataDAO.getNameOfCollege();
    }

    @Transactional
    public void setNameOfCollege(String nameOfCollege) {
        basicDataDAO.setNameOfCollege(nameOfCollege);
        log.debug("Name of college for Testing System was changed on " + nameOfCollege);
    }

}