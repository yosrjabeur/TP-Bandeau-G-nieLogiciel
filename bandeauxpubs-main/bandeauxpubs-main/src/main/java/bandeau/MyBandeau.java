package bandeau;

public class MyBandeau extends Bandeau {

    private boolean iAmFree = true;
    private static int bandeauCount = 0;
    private final int myNumber;

    public MyBandeau(){
        myNumber = ++bandeauCount;
    }

    synchronized public void start() throws InterruptedException{
        while (!iAmFree) {
            wait();
        }
        iAmFree = false;
        System.out.println("Bandeau " + myNumber + " is taken");
    }

    synchronized public void end(){
        System.out.println("Bandeau " + myNumber + " is free");
        iAmFree = true;
        notifyAll();
    }
}