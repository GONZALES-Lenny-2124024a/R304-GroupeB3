package fr.univamu.iut.observerPattern;

/**
 * Can be observable by observers and inform them of a change in state
 * @author LennyGonzales
 */
public interface Observable {
    /**
     * Add an observer to the observable
     * @param observer the observer to add
     */
    void addObserver(Observer observer);

    /**
     * Delete an observer to the observable
     * @param observer the observer to delete
     */
    void removeObserver(Observer observer);

    /**
     * Notify all the observers
     */
    void notifyAllObservers();
}
