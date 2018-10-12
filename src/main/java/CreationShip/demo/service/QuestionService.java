package CreationShip.demo.service;

import CreationShip.demo.dao.QuestionDaoImpl;
import CreationShip.demo.logic.Logic;
import CreationShip.demo.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class QuestionService implements ISerivce<Question>
{

    @Autowired
    private QuestionDaoImpl questionDao;

    public QuestionService(){}

    @Override
    @Transactional(readOnly = true)
    public List<Question> getAll()
    {
        return questionDao.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Question getById(Long id)
    {
        return questionDao.getById(id);
    }

    @Override
    @Transactional
    public Question saveOrUpdate(Question question)
    {
        return questionDao.saveOrUpdate(question);
    }

    @Transactional
    public Question saveOrUpdate(Question question, HttpSession session)
    {
        Logic logic = (Logic) session.getAttribute("Logic");

        if(!question.getQuestion().isEmpty())
        {
            if(logic == null)
                return null;

            if(logic.canSendQuestion())
                logic.sendQuestion(question.getId());
            else
                return null;

            session.setAttribute("Logic", logic);

            return questionDao.saveOrUpdate(question);
        }

        return null;
    }

    @Override
    @Transactional
    public Question remove(Question question)
    {
        return questionDao.remove(question);
    }

    @Transactional(readOnly = true)
    public List<Question> getRandomQuestion(int count)
    {
        return questionDao.getRandomQuestion(count);
    }

    @Transactional(readOnly = true)
    public List<Question> getRandomQuestionByLanguage(int count, String lang)
    {
        return questionDao.getRandomQuestionByLanguage(count,lang);
    }

}
