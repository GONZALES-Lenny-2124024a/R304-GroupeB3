package fr.univamu.iut.observerPattern;

/**
 * Allows you to observe an object and update himself when it's notified
 * <Entity> allows you to use this template for using different things
 */
public interface Observer<Entity> {
    /**
     * React to an observable notification
     * @param entity the observable
     */
    void update (Entity entity);
}
