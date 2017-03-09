
public class Box {
	public int xs = 200;
	public int ys = 150;
	public int xe = 500;
	public int ye = 450;
	Boolean czyCosJestWSrodku = false;
	Box(){
		
		
	}

	synchronized boolean enter() throws InterruptedException
    {
        if ( czyCosJestWSrodku )
        {
            this.wait();
            return false;
        }

        czyCosJestWSrodku = true;
        return true;
    }
	synchronized void exit()
    {
		czyCosJestWSrodku = false;
        this.notify();
    }
	
	
}
