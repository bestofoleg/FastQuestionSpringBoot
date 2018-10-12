package CreationShip.demo.controller;

import CreationShip.demo.models.Question;
import CreationShip.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionController
{

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "getRandomQuestionByLanguage", method = RequestMethod.POST)
    @ResponseBody
    public Question getRandomQuestionByLanguage(@RequestParam("lang") String lang)
    {
        return questionService.getRandomQuestionByLanguage(1, lang).get(0);
    }

}
