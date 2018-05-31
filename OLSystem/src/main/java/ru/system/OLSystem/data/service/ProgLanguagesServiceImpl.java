package ru.system.OLSystem.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.system.OLSystem.data.dao.ProgLanguageRepository;
import ru.system.OLSystem.data.entity.ProgLanguage;

import java.util.List;

@Service
public class ProgLanguagesServiceImpl implements ProgLanguagesService {

    @Autowired
    private ProgLanguageRepository progLanguageRepository;

    public List<ProgLanguage> getAllProgrammingLanguages() {
        return progLanguageRepository.findAll();
    }

}
