package ru.testingsystem.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.testingsystem.data.domain.Group;
import ru.testingsystem.data.service.GroupsService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring-context.xml")
public class GroupsServiceTest {

    @Autowired
    private GroupsService groupsService;
    private String testNameGroup = "TestGroup";

    @Test
    public void addGroup(){
        boolean isContain = groupsService.getGroups().contains(new Group("TestGroup"));
        if (!isContain){
            Assert.assertTrue(groupsService.addGroup(testNameGroup));
        } else {
            Assert.assertFalse(groupsService.addGroup(testNameGroup));
        }
    }

    @Test
    public void changeGroup(){
        String newTestNameGroup = "NewTestName";
        boolean isContain = groupsService.getGroups().contains(new Group(newTestNameGroup));
        if (isContain){
            Assert.assertTrue(groupsService.changeNameGroup(testNameGroup, newTestNameGroup));
        } else {
            Assert.assertFalse(groupsService.changeNameGroup(testNameGroup, newTestNameGroup));
        }
        testNameGroup = newTestNameGroup;
    }

    @Test
    public void removeGroup(){
        boolean isContain = groupsService.getGroups().contains(new Group(testNameGroup));
        if (isContain){
            Assert.assertTrue(groupsService.removeGroup(testNameGroup));
        } else {
            Assert.assertFalse(groupsService.removeGroup(testNameGroup));
        }
    }

}
