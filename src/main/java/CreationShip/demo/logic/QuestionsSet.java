package CreationShip.demo.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class QuestionsSet
{

    private Set ids;

    public QuestionsSet()
    {
        this.ids = new TreeSet<Long>();
    }

    public Boolean addId(Long id)
    {
        return this.ids.add(id);
    }

    public List<Long> getIdsList()
    {
        return new ArrayList<Long>(this.ids);
    }

}
