package ru.testingsystem.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.testingsystem.data.entity.BasicData;
import ru.testingsystem.data.entity.ProgrammingLanguage;
import ru.testingsystem.data.repository.BasicDataRepository;
import ru.testingsystem.data.repository.ProgrammingLanguageRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class BasicDataServiceImpl implements BasicDataService {

    @Autowired
    private BasicDataRepository basicDataRepository;
    @Autowired
    private ProgrammingLanguageRepository programmingLanguageRepository;

    public List<ProgrammingLanguage> getAllProgrammingLanguagesOlympiad() {
        return programmingLanguageRepository.findAll();
    }

    public String getTitleTestingSystem() {
        return basicDataRepository.findByName("titleTestingSystem").getData();
    }

    public void setTitleTestingSystem(String title) {
        BasicData basicData = basicDataRepository.findByName("titleTestingSystem");
        basicData.setData(title);
        basicDataRepository.save(basicData);
    }

    public String getDescriptionTestingSystem() {
        return basicDataRepository.findByName("descriptionTestingSystem").getData();
    }

    public void setDescriptionTestingSystem(String description) {
        BasicData basicData = basicDataRepository.findByName("descriptionTestingSystem");
        basicData.setData(description);
        basicDataRepository.save(basicData);
    }

    public String getTitleResultOlympiad() {
        return basicDataRepository.findByName("titleResultOlympiad").getData();
    }

    public void setTitleResultOlympiad(String titleResult) {
        BasicData basicData = basicDataRepository.findByName("titleResultOlympiad");
        basicData.setData(titleResult);
        basicDataRepository.save(basicData);
    }

    public String getDescriptionResultOlympiad() {
        return basicDataRepository.findByName("descriptionResultOlympiad").getData();
    }

    public void setDescriptionResultOlympiad(String descriptionResult) {
        BasicData basicData = basicDataRepository.findByName("descriptionResultOlympiad");
        basicData.setData(descriptionResult);
        basicDataRepository.save(basicData);
    }

    public String getAddressCollege() {
        return basicDataRepository.findByName("addressCollege").getData();
    }

    public void setAddressCollege(String address) {
        BasicData basicData = basicDataRepository.findByName("addressCollege");
        basicData.setData(address);
        basicDataRepository.save(basicData);
    }

    public String getPhoneNumberCollege() {
        return basicDataRepository.findByName("phoneNumberCollege").getData();
    }

    public void setPhoneNumberCollege(String phoneNumber) {
        BasicData basicData = basicDataRepository.findByName("phoneNumberCollege");
        basicData.setData(phoneNumber);
        basicDataRepository.save(basicData);
    }

    public String getNameCollege() {
        return basicDataRepository.findByName("nameCollege").getData();
    }

    public void setNameCollege(String nameCollege) {
        BasicData basicData = basicDataRepository.findByName("nameCollege");
        basicData.setData(nameCollege);
        basicDataRepository.save(basicData);
    }

    public String getProgrammingLanguageOlympiad(){
        return basicDataRepository.findByName("languageOlympiad").getData();
    }

    public void setProgrammingLanguageOlympiad(String nameLanguage){
        BasicData basicData = basicDataRepository.findByName("languageOlympiad");
        basicData.setData(nameLanguage);
        basicDataRepository.save(basicData);
    }

    public String getTimePassingOlympiad() {
        return basicDataRepository.findByName("timeOlympiad").getData();
    }

    public void setTimePassingOlympiad(String time) {
        BasicData basicData = basicDataRepository.findByName("timeOlympiad");
        basicData.setData(time);
        basicDataRepository.save(basicData);
    }

}