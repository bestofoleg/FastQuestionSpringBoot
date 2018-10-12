package CreationShip.demo.controller;

import CreationShip.demo.logic.Logic;
import CreationShip.demo.models.Message;
import CreationShip.demo.models.Question;
import CreationShip.demo.service.MessageService;
import CreationShip.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class LogicController
{

    @Autowired
    private MessageService messageService;

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "getMyMessages", method = RequestMethod.GET)
    @ResponseBody
    public List<Message> getMyMessages(HttpSession session)
    {
        return this.messageService.getMyMessages(session);
    }

    @RequestMapping(value = "getQuestionStatus", method = RequestMethod.GET)
    @ResponseBody
    public Boolean getQuestionStatus(HttpSession session)
    {
        Logic logic = (Logic) session.getAttribute("Logic");

        if(logic == null)
            return false;

        return logic.canSendQuestion();
    }

    @RequestMapping(value = "addAnswer", method = RequestMethod.POST)
    @ResponseBody
    public Message addAnswer(Message message, HttpSession session)
    {
        return this.messageService.saveOrUpdate(message, session);
    }

    @RequestMapping(value = "addQuestion", method = RequestMethod.POST)
    @ResponseBody
    public Question addQuestion(Question question, HttpSession session)
    {
        return this.questionService.saveOrUpdate(question, session);
    }

    @RequestMapping(value = "getQuestionForm", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getQuestionFrom()
    {
        return new ModelAndView("QuestionForm.html");
    }

    @RequestMapping(value = "getAnswerForm", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAnswerFrom()
    {
        return new ModelAndView("AnswerForm.html");
    }
}
