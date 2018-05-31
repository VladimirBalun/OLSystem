package ru.system.OLSystem.daoUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.system.OLSystem.configuration.DataConfig;
import ru.system.OLSystem.data.entity.DataOlympiad;
import ru.system.OLSystem.data.dao.DataOlympiadRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class DataOlympiadRepositoryTest {

    @Autowired
    private DataOlympiadRepository dataOlympiadRepository;

    @Test
    public void checkingOfExistenceInformationAboutCreatorOlympiad() {
        DataOlympiad dataOlympiad = dataOlympiadRepository.findByName("creatorOlympiad");
        Assert.assertTrue(dataOlympiad != null);
    }

    @Test
    public void checkingOfExistenceInformationAboutDescriptionOlympiad() {
        DataOlympiad dataOlympiad = dataOlympiadRepository.findByName("descriptionEndOlympiad");
        Assert.assertTrue( dataOlympiad != null);
    }

    @Test
    public void checkingOfExistenceInformationAboutDescriptionEndOlympiad() {
        DataOlympiad dataOlympiad = dataOlympiadRepository.findByName("descriptionOlympiad");
        Assert.assertTrue( dataOlympiad != null);
    }

    @Test
    public void checkingOfExistenceInformationAboutLinkToIconOlympiad() {
        DataOlympiad dataOlympiad = dataOlympiadRepository.findByName("linkToIconOlympiad");
        Assert.assertTrue( dataOlympiad != null);
    }

    @Test
    public void successfulCheckingOfExistenceInformationAboutLinkToWebSite(){
        DataOlympiad dataOlympiad = dataOlympiadRepository.findByName("linkToWebSite");
        Assert.assertTrue( dataOlympiad != null);
    }

    @Test
    public void checkingOfExistenceInformationAboutNameOlympiad() {
        DataOlympiad dataOlympiad = dataOlympiadRepository.findByName("nameOlympiad");
        Assert.assertTrue( dataOlympiad != null);
    }

    @Test
    public void checkingOfExistenceInformationAboutNameWebSite() {
        DataOlympiad dataOlympiad = dataOlympiadRepository.findByName("nameWebSite");
        Assert.assertTrue( dataOlympiad != null);
    }

    @Test
    public void checkingOfExistenceInformationAboutNumberCreator() {
        DataOlympiad dataOlympiad = dataOlympiadRepository.findByName("numberCreator");
        Assert.assertTrue( dataOlympiad != null);
    }

    @Test
    public void checkingOfExistenceInformationAboutTitleEndOlympiad() {
        DataOlympiad dataOlympiad = dataOlympiadRepository.findByName( "titleEndOlympiad");
        Assert.assertTrue( dataOlympiad != null);
    }

}
