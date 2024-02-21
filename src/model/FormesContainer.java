package model;

import java.util.ArrayList;

import model.observerPaterne.AbstractListenableModel;
import model.observerPaterne.ModelListener;

public class FormesContainer extends AbstractListenableModel implements ModelListener{
    //public ArrayList<IFormes> sideContainerList ;
    private ArrayList<IFormes> mainContainerList ;

    public FormesContainer() {
        super();
        //this.sideContainerList = new ArrayList<IFormes>();
        this.mainContainerList = new ArrayList<IFormes>();
    }

    public void addFormToMainContainer(IFormes f){
        if (f instanceof CercleModel) {
            ((CercleModel)f).addModelListener(this);
        } else {
            ((RectangleModel)f).addModelListener(this);
        }
        this.mainContainerList.add(f);
        this.fireChange();
    }

    public void removeFormFromMainContainer(IFormes f){
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
    public ArrayList<IFormes> getMainContainerList() {
        return mainContainerList;
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
