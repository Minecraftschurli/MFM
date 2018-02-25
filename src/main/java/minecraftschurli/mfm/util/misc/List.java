package minecraftschurli.mfm.util.misc;


import java.util.ArrayList;

public class List<E> extends ArrayList
{

    public List()
    {
        super();
    }

    public List addE(E item)
    {
        super.add(item);
        return this;
    }
}
