package model;

import java.util.ArrayList;

import model.observerPaterne.AbstractListenableModel;
import model.observerPaterne.ModelListener;

public class FormContainer extends AbstractListenableModel implements ModelListener{
    //public ArrayList<IFormes> sideContainerList ;
    private ArrayList<AbstractForm> mainContainerList ;

    public FormContainer() {
        super();
        //this.sideContainerList = new ArrayList<IFormes>();
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
    @Override
    public void somethingHasChanged(Object source) {
        this.fireChange();
    }
    public ArrayList<AbstractForm> getMainContainerList() {
        return this.mainContainerList;
    }
    // public void addFormToSideContainer(IFormes f){
    //     this.sideContainerList.add(f);
    //     this.fireChange();
    // }
    // public void removeFormFromSideContainer(IFormes f){
    //     this.sideContainerList.remove(f);
    //     this.fireChange();
    // }
    // public ArrayList<IFormes> getSideContainerList() {
    //     return sideContainerList;
    // }
}
