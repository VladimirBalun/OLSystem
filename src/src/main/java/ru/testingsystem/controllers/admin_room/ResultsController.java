package ru.testingsystem.controllers.admin_room;

import org.springframework.web.bind.annotation.*;
import ru.testingsystem.data.entity.Result;
import ru.testingsystem.data.dao.SortingResults;

import java.util.List;

@RestController
@RequestMapping("/results")
public class ResultsController extends AdminRoomController {

    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public List<Result> sortResultsTest(@RequestParam(value = "name_sort") String methodSorting){
        switch (methodSorting) {
            case "По ФИО":
                return resultsService.getResultsOfUsers(SortingResults.NAME);
            case "По дате проведения":
                return resultsService.getResultsOfUsers(SortingResults.DATE);
            default:
                return resultsService.getResultsOfUsers(SortingResults.RESULT);
        }
    }

}
