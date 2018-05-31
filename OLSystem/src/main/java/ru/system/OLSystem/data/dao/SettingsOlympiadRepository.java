package ru.system.OLSystem.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.system.OLSystem.data.entity.SettingsOlympiad;

public interface SettingsOlympiadRepository extends JpaRepository<SettingsOlympiad, Long> {

    SettingsOlympiad findByName(String name);
}
