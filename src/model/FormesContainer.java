package model;

import java.util.ArrayList;

import model.observerPaterne.AbstractListenableModel;

/**
 *
 * @author 21912949
 */
public class FormesContainer extends AbstractListenableModel{
    public ArrayList<IFormes> sideContainerList ;
    public ArrayList<IFormes> mainContainerList ;

    public FormesContainer() {
        super();
        this.sideContainerList = new ArrayList<IFormes>();
        this.mainContainerList = new ArrayList<IFormes>();
    }

    public void addFormToSideContainer(IFormes f){
        this.sideContainerList.add(f);
        this.fireChange();
    }
    public void removeFormFromSideContainer(IFormes f){
        this.sideContainerList.remove(f);
        this.fireChange();
    }

    public void addFormToMainContainer(IFormes f){
        this.mainContainerList.add(f);
        this.fireChange();
    }
    public void removeFormFromMainContainer(IFormes f){
        this.mainContainerList.remove(f);
        this.fireChange();
    }
    public ArrayList<IFormes> getMainContainerList() {
        return mainContainerList;
    }
    public ArrayList<IFormes> getSideContainerList() {
        return sideContainerList;
    }
}
