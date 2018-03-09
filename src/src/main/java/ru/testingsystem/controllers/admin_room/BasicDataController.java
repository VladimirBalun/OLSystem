package ru.testingsystem.controllers.admin_room;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/basicData")
public class BasicDataController extends AdminRoomController {

    @RequestMapping(value = "/changeTitles", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public @ResponseBody String changeBasicTitles(@RequestParam(value = "title_test") String titleTestingSystem,
                                                  @RequestParam(value = "title_result_test") String titleResultTest){
        basicDataService.setTitleTestingSystem(titleTestingSystem);
        basicDataService.setTitleResultOlympiad(titleResultTest);
        return "Данные о заголовках системы тестирования успешно изменены.";
    }

    @RequestMapping(value = "/changeContacts", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public @ResponseBody String changeBasicTitles(@RequestParam(value = "address") String addressCollege,
                                                  @RequestParam(value = "phone_number") String numberCollege,
                                                  @RequestParam(value = "name_college") String nameCollege){
        basicDataService.setAddressCollege(addressCollege);
        basicDataService.setPhoneNumberCollege(numberCollege);
        basicDataService.setNameCollege(nameCollege);
        return "Данные о контактах учебного заведения успешно изменены.";
    }

    @RequestMapping(value = "/changeDescriptions", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public @ResponseBody String changeBasicDescriptions(@RequestParam(value = "description_test") String descriptionTestingSystem,
                                                        @RequestParam(value = "description_result_test") String descriptionResultTest){
        basicDataService.setDescriptionTestingSystem(descriptionTestingSystem);
        basicDataService.setDescriptionResultOlympiad(descriptionResultTest);
        return "Данные о описаниях системы тестирования успешно изменены.";
    }

}
