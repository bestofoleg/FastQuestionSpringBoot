package CreationShip.demo.logic.counter;

public class SimpleCounter implements ICounter<Long>
{
    private Long step;
    private Long count;

    public SimpleCounter()
    {
        this.count = 1L;
        this.step = 3L;
    }

    public SimpleCounter(Long stepSize, Long fstCount)
    {
        this.count = fstCount;
        this.step = stepSize;
    }

    @Override
    public Boolean isFinalIteration()
    {
        return this.count == this.step;
    }

    @Override
    public Long getCount()
    {
        return this.count.longValue();
    }

    @Override
    public Long next()
    {

        if(this.count > this.step)
        {
            this.count = 1L;
            return this.count.longValue();
        }

        return (++this.count).longValue();

    }
}
