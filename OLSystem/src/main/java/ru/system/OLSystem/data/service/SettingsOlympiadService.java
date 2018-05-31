package ru.system.OLSystem.data.service;

import ru.system.OLSystem.data.entity.SettingsOlympiad;

import java.util.List;

public interface SettingsOlympiadService {

    List<SettingsOlympiad> getAllSettings();

    boolean changeSettingOlympiad(SettingsOlympiad settingsOlympiad);

}
