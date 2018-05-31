package ru.system.OLSystem.data.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import ru.system.OLSystem.data.entity.DataOlympiad;
import ru.system.OLSystem.data.entity.SettingsOlympiad;
import ru.system.OLSystem.data.dao.SettingsOlympiadRepository;

import java.util.List;

@Service
public class SettingsOlympiadServiceImpl implements SettingsOlympiadService {

    private final static Logger logger = Logger.getLogger(SettingsOlympiadServiceImpl.class);

    @Autowired
    private SettingsOlympiadRepository settingsOlympiadRepository;

    public List<SettingsOlympiad> getAllSettings() {
        return settingsOlympiadRepository.findAll();
    }

    public boolean changeSettingOlympiad(SettingsOlympiad settingsOlympiad) {
        try {
            settingsOlympiadRepository.save(settingsOlympiad);
            logger.debug("Property of settings \"" + settingsOlympiad.getName() + "\" was changed.");
            return true;
        } catch (DataAccessException e) {
            logger.debug("Property of settings \"" + settingsOlympiad.getName() + "\" wasn't changed. Cause: " + e.getMessage());
            return false;
        }
    }

}
