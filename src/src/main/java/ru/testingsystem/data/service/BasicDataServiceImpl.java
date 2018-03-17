package ru.testingsystem.data.service;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.testingsystem.data.entity.BasicData;
import ru.testingsystem.data.repository.BasicDataRepository;

@Log4j
@Service
public class BasicDataServiceImpl implements BasicDataService {

    @Autowired
    private BasicDataRepository basicDataRepository;

    public String getTitleTestingSystem() {
        return basicDataRepository.findByName("titleTestingSystem").getData();
    }

    public void setTitleTestingSystem(String title) {
        BasicData basicData = basicDataRepository.findByName("titleTestingSystem");
        basicData.setData(title);
        basicDataRepository.save(basicData);
        log.debug("Title of Testing System was changed on [" + title + "].");
    }

    public String getDescriptionTestingSystem() {
        return basicDataRepository.findByName("descriptionTestingSystem").getData();
    }

    public void setDescriptionTestingSystem(String description) {
        BasicData basicData = basicDataRepository.findByName("descriptionTestingSystem");
        basicData.setData(description);
        basicDataRepository.save(basicData);
        log.debug("Description of Testing System was changed on " + description + "].");
    }

    public String getTitleResultOlympiad() {
        return basicDataRepository.findByName("titleResultOlympiad").getData();
    }

    public void setTitleResultOlympiad(String titleResult) {
        BasicData basicData = basicDataRepository.findByName("titleResultOlympiad");
        basicData.setData(titleResult);
        basicDataRepository.save(basicData);
        log.debug("Title of result Olympiad was changed on " + titleResult);
    }

    public String getDescriptionResultOlympiad() {
        return basicDataRepository.findByName("descriptionResultOlympiad").getData();
    }

    public void setDescriptionResultOlympiad(String descriptionResult) {
        BasicData basicData = basicDataRepository.findByName("descriptionResultOlympiad");
        basicData.setData(descriptionResult);
        basicDataRepository.save(basicData);
        log.debug("Description of result Olympiad was changed on " + descriptionResult);
    }

    public String getAddressCollege() {
        return basicDataRepository.findByName("addressCollege").getData();
    }

    public void setAddressCollege(String address) {
        BasicData basicData = basicDataRepository.findByName("addressCollege");
        basicData.setData(address);
        basicDataRepository.save(basicData);
        log.debug("Address of Testing System was changed on " + address);
    }

    public String getPhoneNumberCollege() {
        return basicDataRepository.findByName("phoneNumberCollege").getData();
    }

    public void setPhoneNumberCollege(String phoneNumber) {
        BasicData basicData = basicDataRepository.findByName("phoneNumberCollege");
        basicData.setData(phoneNumber);
        basicDataRepository.save(basicData);
        log.debug("Phone number of Testing System was changed on " + phoneNumber);
    }

    public String getNameCollege() {
        return basicDataRepository.findByName("nameCollege").getData();
    }

    public void setNameCollege(String nameCollege) {
        BasicData basicData = basicDataRepository.findByName("nameCollege");
        basicData.setData(nameCollege);
        basicDataRepository.save(basicData);
        log.debug("Name of college for Testing System was changed on " + nameCollege);
    }

    public String getProgrammingLanguageOlympiad(){
        return basicDataRepository.findByName("languageOlympiad").getData();
    }

    public void setProgrammingLanguageOlympiad(String nameLanguage){
        BasicData basicData = basicDataRepository.findByName("languageOlympiad");
        basicData.setData(nameLanguage);
        basicDataRepository.save(basicData);
        log.debug("Programming language for passing Olympiad was changed on  " + nameLanguage);
    }

    public String getTimePassingOlympiad() {
        return basicDataRepository.findByName("timeOlympiad").getData();
    }

    public void setTimePassingOlympiad(String time) {
        BasicData basicData = basicDataRepository.findByName("timeOlympiad");
        basicData.setData(time);
        basicDataRepository.save(basicData);
        log.debug("Time for passing Olympiad was changed on  " + time);
    }

}