package drawing;

public interface Observable {
    public void addObserver (Observer o);
    public void removeObserver (Observer o);
    public void notifyObservers ();
    //public int getState ();
    //public void setState (int state);
}
