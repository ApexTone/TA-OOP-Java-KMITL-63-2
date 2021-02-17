package Lab06;

/*
* Testcase
* Extra dequeue after empty
* extending array
* negative queue size
* edge case (queue size=8)
* */

public class MyQueue {
    private int[] queue;
    private int size;

    public MyQueue(){
        this(8);
    }
    public MyQueue(int size) {
        if(size <= 0){
            System.err.println("Size must be a positive integer. Set to default size.(8).");
            size = 8;
        }
        this.queue = new int[size];
        this.size = 0;
    }

    public void enqueue(int value){
        if(this.size == this.queue.length){
            System.out.printf("Resizing from %d to %d\n",this.queue.length, this.queue.length*2);
            int[] newQueue = new int[this.queue.length*2];
            for(int i=0;i<this.queue.length;i++){
                newQueue[i] = this.queue[i];
            }
            this.queue = newQueue;
        }
        this.queue[this.size++] = value;
    }
    public int dequeue(){
        if(!this.empty()){
            int value = this.queue[0];
            for(int i=1;i<size;i++){
                this.queue[i-1] = this.queue[i];
            }
            size--;
            return value;
        }
        System.err.println("Popping from empty queue!");
        return -1;

    }
    public boolean empty(){
        return this.size == 0;
    }
    public int getSize(){
        return this.size;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        for(int i=0;i<8;i++){
            queue.enqueue(i);
        }
        for(int i=0;i<8;i++){
            System.out.println(queue.dequeue());
        }
        System.out.println(queue.dequeue());
    }
}
