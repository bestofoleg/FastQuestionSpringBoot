package CreationShip.demo.logic.counter;

public interface ICounter <T>
{

    T getCount();
    Boolean isFinalIteration();
    T next();

}
