package ru.system.OLSystem.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.system.OLSystem.data.entity.DataOlympiad;

public interface DataOlympiadRepository extends JpaRepository<DataOlympiad, Long>{

    DataOlympiad findByName(String name);

}
