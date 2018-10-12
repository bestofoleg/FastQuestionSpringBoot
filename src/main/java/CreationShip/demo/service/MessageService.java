package CreationShip.demo.service;

import CreationShip.demo.dao.MessageDaoImpl;
import CreationShip.demo.dao.QuestionDaoImpl;
import CreationShip.demo.logic.Logic;
import CreationShip.demo.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService implements ISerivce<Message>
{

    @Autowired
    private MessageDaoImpl messageDao;

    @Autowired
    private QuestionDaoImpl questionDao;

    public MessageService(){}

    @Transactional
    public List<Message> getMyMessages(HttpSession session)
    {
        Logic logic = (Logic) session.getAttribute("Logic");

        if(logic == null)
            return new ArrayList<Message>();

        List<Long> idsList = logic.getIdsList();
        List<Message> messages = new ArrayList<>();

        for(Long id : idsList)
        {
            messages.addAll(this.messageDao.getByQuestion(this.questionDao.getById(id)));
        }

        return messages;
    }

    @Override
    @Transactional
    public List<Message> getAll()
    {
        return this.messageDao.getAll();
    }

    @Override
    @Transactional
    public Message getById(Long id)
    {
        return this.messageDao.getById(id);
    }

    @Override
    @Transactional
    public Message saveOrUpdate(Message message)
    {
        return this.messageDao.saveOrUpdate(message);
    }

    @Transactional
    public Message saveOrUpdate(Message message, HttpSession session)
    {

        if(!message.getMessage().isEmpty())
        {
            Logic logic = (Logic) session.getAttribute("Logic");

            if(logic == null)
            {
                logic = new Logic();
            }

            logic.sendAnswer();

            session.setAttribute("Logic", logic);

            return this.messageDao.saveOrUpdate(message);
        }

        return null;

    }

    @Override
    @Transactional
    public Message remove(Message message)
    {
        System.out.println("Метод remove класса MessageService не реализован!");
        throw new NotImplementedException();
    }

}
