package linklist.example;

public class Linklist<t> {
    class Node{
        t value;
        Node left;
        Node(t value)
        {
            this.value=value;
        }
    }
    private Node head;
    private Node tail;
    public void AddFirst(t value)
    {
        if(isempty())
        {
            head=new Node(value);
            tail=head;
            return;
        }
        Node n=new Node(value);
        n.left=head;
        head=n;
    }
    public void AddLast(t value)
    {
        if(isempty())
        {
            head=new Node(value);
            tail=head;
            return;
        }
        Node n=new Node(value);
        tail.left=n;
        tail=n;
    }
    public void add(int pos,t value)
    {
        if(pos==1){
            AddFirst(value);
        }
        Node current=head;
        int c=1;
        while(c<(pos-1))
        {
            c++;
            current=current.left;
        }
        Node n=new Node(value);
        n.left=current.left;
        current.left=n;
    }
    public t DelFirst(){
        if(isempty()){
            System.out.println("List is Empty");
        }
        Node current=head;
        head=head.left;
        current.left=null;
        if(isempty())
        {
            tail=null;
        }
        return current.value;
    }
    public t DelLast(){
        if(isempty()){
            System.out.println("List is Empty");
        }
        if (head==tail)
        {
            t val=head.value;
            head=null;
            tail=null;
            return val;
        }
        Node current=head;
        Node prev=null;
        while (current.left != null)
        {
            prev=current;
            current=current.left;
        }
        prev.left=null;
        tail=prev;
        return current.value;
    }

    public t delete(int pos)
    {
        if(isempty()){
            System.out.println("List is Empty");
        }
        if (pos==1)
        {
            DelFirst();
        }
        Node current=head;
        Node pre=null;
        int c=1;
        while(c<pos)
        {
            c++;
            pre=current;
            current=current.left;
        }
        pre.left=current.left;
        current.left=null;
        return current.value;
    }

    public boolean isempty(){
        return head==null;
    }
}
