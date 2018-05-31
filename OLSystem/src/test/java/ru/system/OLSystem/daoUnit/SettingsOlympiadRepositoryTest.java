package ru.system.OLSystem.daoUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.system.OLSystem.configuration.DataConfig;
import ru.system.OLSystem.data.entity.SettingsOlympiad;
import ru.system.OLSystem.data.dao.SettingsOlympiadRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class SettingsOlympiadRepositoryTest {

    @Autowired
    private SettingsOlympiadRepository settingsOlympiadRepository;

    @Test
    public void checkingOfExistencePropertyAboutProgrammingLanguage() {
        SettingsOlympiad settings = settingsOlympiadRepository.findByName("languageOlympiad");
        Assert.assertTrue( settings != null);
    }

    @Test
    @Rollback
    @Transactional
    public void changingPropertyOfProgrammingLanguage() {
        SettingsOlympiad settings = settingsOlympiadRepository.findByName("languageOlympiad");
        settings.setProperty("new_language");
        settingsOlympiadRepository.save(settings);
        SettingsOlympiad reloadSettings = settingsOlympiadRepository.findByName("languageOlympiad");
        Assert.assertEquals("new_language", reloadSettings.getProperty());
    }

    @Test
    public void checkingOfExistencePropertyAboutTimeOlympiad() {
        SettingsOlympiad settings = settingsOlympiadRepository.findByName("timeOlympiad");
        Assert.assertTrue( settings != null);
    }

    @Test
    @Rollback
    @Transactional
    public void changingPropertyOfTimeOlympiad() {
        SettingsOlympiad settings = settingsOlympiadRepository.findByName("timeOlympiad");
        settings.setProperty("2:00");
        settingsOlympiadRepository.save(settings);
        SettingsOlympiad reloadSettings = settingsOlympiadRepository.findByName("timeOlympiad");
        Assert.assertEquals("2:00", reloadSettings.getProperty());
    }

}
