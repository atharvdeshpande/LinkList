package linklist.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class LinklistTest {
    private static final Logger logger = LogManager.getLogger(Linklist.class);

    @Test
    void addFirstTest()
    {
        Linklist<Object> l1=new Linklist<>();
        l1.addFirst(20);
        l1.addFirst(21);
        l1.addFirst(22);
        assertEquals(22,l1.delFirst());
        assertEquals(21,l1.delFirst());
        assertEquals(20,l1.delFirst());
    }
    @Test
    void addLastTest()
    {
        Linklist<Object> l1=new Linklist<>();
        l1.addLast(40);
        l1.addLast(42);
        assertEquals(42,l1.delLast());
        assertEquals(40,l1.delLast());
    }
    @Test
    void addTest()
    {
        Linklist<Object> l1=new Linklist<>();
        l1.addFirst(20);
        l1.addFirst(21);
        l1.addFirst(22);
        l1.addLast(40);
        l1.addLast(42);
        l1.add(2,30);
        assertEquals(30,l1.delete(2));
        l1.add(3,90);
        assertEquals(90,l1.delete(3));
    }


}
