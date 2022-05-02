package linklist.example;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Objects;

public class Linklist<V> {
    private static class Node<V>{
        V value;
        Node<V> left;
        Node(V value)
        {
            this.value=value;
        }
    }
    public static final String EMPTY ="List is empty";
    private static final Logger logger = LogManager.getLogger(Linklist.class);
    private Node<V> head;
    private Node<V> tail;
    public void addFirst(V value)
    {
        if(isEmpty())
        {
            head=new Node<>(value);
            tail=head;
            return;
        }
        Node<V> n=new Node<>(value);
        n.left=head;
        head=n;
    }
    public void addLast(V value)
    {
        if(isEmpty())
        {
            head=new Node<>(value);
            tail=head;
            return;
        }
        Node<V> n=new Node<>(value);
        tail.left=n;
        tail=n;
    }
    public void add(int pos, V value)
    {
        if(pos==1){
            addFirst(value);
        }
        Node<V> current=head;
        int c=1;
        while(c<(pos-1))
        {
            c++;
            current=current.left;
        }
        Node<V> n=new Node<>(value);
        n.left=current.left;
        current.left=n;
    }
    public V delFirst(){
        if(isEmpty()){
            logger.info(EMPTY);
        }
        Node<V> current=head;
        head=head.left;
        current.left=null;
        if(isEmpty())
        {
            tail=null;
        }
        return current.value;
    }
    public V delLast(){
        if(isEmpty()){
            logger.info(EMPTY);
        }
        if (head==tail)
        {
            V val=head.value;
            head=null;
            tail=null;
            return val;
        }
        Node<V> current=head;
        Node<V> prev=null;
        while (current.left != null)
        {
            prev=current;
            current=current.left;
        }
        Objects.requireNonNull(prev).left=null;
        tail=prev;
        return current.value;
    }

    public V delete(int pos)
    {
        if(isEmpty()){
            logger.info(EMPTY);
        }
        if (pos==1)
        {
            return delFirst();
        }
        Node<V> current=head;
        Node<V> pre=null;
        int c=1;
        while(current.left != null)
        {
            c++;
            pre=current;
            current=current.left;
            if(c==pos)
            {
                break;
            }
        }
        if (c==pos) {
            Objects.requireNonNull(pre).left = current.left;
            current.left = null;
            return current.value;
        }
        else {
            return null;
        }
    }

    public boolean isEmpty(){
        return head==null;
    }
}
