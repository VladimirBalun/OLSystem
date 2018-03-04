package ru.tidstu.testingsystem.controllers.admin_room;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.tidstu.testingsystem.data.entity.Result;
import ru.tidstu.testingsystem.data.dao.SortingResults;

import java.util.List;

@Controller
@RequestMapping("/results")
public class ResultsController extends AdminRoomController {

    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public @ResponseBody List<Result> sortResultsTest(@RequestParam(value = "name_sort") String methodSorting){
        if(methodSorting.equals("По ФИО")){
            return resultsService.getResultsOfUsers(SortingResults.NAME);
        } else if(methodSorting.equals("По дате проведения")){
            return resultsService.getResultsOfUsers(SortingResults.DATE);
        } else {
            return resultsService.getResultsOfUsers(SortingResults.RESULT);
        }
    }

}
