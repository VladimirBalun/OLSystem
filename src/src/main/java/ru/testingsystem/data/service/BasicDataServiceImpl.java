package ru.testingsystem.data.service;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testingsystem.data.dao.BasicDataDAO;

@Log4j
@Service
public class BasicDataServiceImpl implements BasicDataService {

    @Autowired
    private BasicDataDAO basicDataDAO;

    public String getTitleTestingSystem() {
        return basicDataDAO.getTitleTestingSystem();
    }

    @Transactional
    public void setTitleTestingSystem(String titleOfTest) {
        basicDataDAO.setTitleTestingSystem(titleOfTest);
        log.debug("Title of Testing System was changed on " + titleOfTest);
    }

    public String getDescriptionTestingSystem() {
        return basicDataDAO.getDescriptionTestingSystem();
    }

    @Transactional
    public void setDescriptionTestingSystem(String descriptionOfTest) {
        basicDataDAO.setDescriptionTestingSystem(descriptionOfTest);
        log.debug("Description of Testing System was changed on " + descriptionOfTest);
    }

    public String getTitleResultOlympiad() {
        return basicDataDAO.getTitleResultOlympiad();
    }

    @Transactional
    public void setTitleResultOlympiad(String titleOfResult) {
        basicDataDAO.setTitleResultOlympiad(titleOfResult);
        log.debug("Title of result Olympiad was changed on " + titleOfResult);
    }

    public String getDescriptionResultOlympiad() {
        return basicDataDAO.getDescriptionResultOlympiad();
    }

    @Transactional
    public void setDescriptionResultOlympiad(String descriptionOfResult) {
        basicDataDAO.setDescriptionResultOlympiad(descriptionOfResult);
        log.debug("Description of result Olympiad was changed on " + descriptionOfResult);
    }

    public String getAddressCollege() {
        return basicDataDAO.getAddressCollege();
    }

    @Transactional
    public void setAddressCollege(String address) {
        basicDataDAO.setAddressCollege(address);
        log.debug("Address of Testing System was changed on " + address);
    }

    public String getPhoneNumberCollege() {
        return basicDataDAO.getPhoneNumberCollege();
    }

    @Transactional
    public void setPhoneNumberCollege(String phoneNumber) {
        basicDataDAO.setPhoneNumberCollege(phoneNumber);
        log.debug("Phone number of Testing System was changed on " + phoneNumber);
    }

    public String getNameCollege() {
        return basicDataDAO.getNameCollege();
    }

    @Transactional
    public void setNameCollege(String nameOfCollege) {
        basicDataDAO.setNameCollege(nameOfCollege);
        log.debug("Name of college for Testing System was changed on " + nameOfCollege);
    }

}