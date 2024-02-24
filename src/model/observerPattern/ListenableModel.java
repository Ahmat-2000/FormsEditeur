package model.observerPattern;

public interface ListenableModel {
    void addModelListener(ModelListener l);
    void removeModelListener(ModelListener l);
}
