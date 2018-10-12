package CreationShip.demo.logic;

import CreationShip.demo.logic.counter.ICounter;
import CreationShip.demo.logic.counter.SimpleCounter;

import java.util.List;

public class Logic
{

    private ICounter counter;
    private QuestionsSet questionsSet;

    public Logic()
    {
        this.counter = new SimpleCounter();
        this.questionsSet = new QuestionsSet();
    }

    public Logic(ICounter counter, QuestionsSet questionsSet)
    {
        this.counter = counter;
        this.questionsSet = questionsSet;
    }

    public void sendAnswer()
    {
        this.counter.next();
    }

    public Boolean sendQuestion(Long id)
    {
        return this.questionsSet.addId(id);
    }

    public Boolean canSendQuestion()
    {
        return this.counter.isFinalIteration();
    }

    public List<Long> getIdsList()
    {
        return this.questionsSet.getIdsList();
    }

}
