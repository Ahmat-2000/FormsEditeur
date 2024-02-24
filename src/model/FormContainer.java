package model;

import java.util.ArrayList;

import model.observerPattern.AbstractListenableModel;
import model.observerPattern.ModelListener;

public class FormContainer extends AbstractListenableModel implements ModelListener{
    private ArrayList<AbstractForm> mainContainerList ;

    public FormContainer() {
        super();
        this.mainContainerList = new ArrayList<AbstractForm>();
    }

    public void addFormToMainContainer(AbstractForm f){
        f.addModelListener(this);
        this.mainContainerList.add(f);
        this.fireChange();
    }

    public void removeFormFromMainContainer(IForm f){
        this.mainContainerList.remove(f);
        this.fireChange();
    }
    public void clearMainContainer(){
        this.mainContainerList.clear();
        this.fireChange();
    }
    public void setMainContainerList(ArrayList<AbstractForm> l) {
        this.mainContainerList = l;
        this.fireChange();
    }
    public ArrayList<AbstractForm> copyOfList(){
        ArrayList<AbstractForm> f = new ArrayList<>();
        this.mainContainerList.forEach(el -> f.add(el));
        return f;
    }
    public ArrayList<AbstractForm> getMainContainerList() {
        return this.mainContainerList;
    }
    @Override
    public void somethingHasChanged(Object source) {
        this.fireChange();
    }
}
