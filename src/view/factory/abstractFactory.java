package view.factory;

import java.util.HashMap;
import java.util.Map;

import model.IForm;
import view.IView;

public abstract class abstractFactory {
    private final Map<String , IView> map = new HashMap<>();
    protected abstract IView newInstance(IForm form);
    public IView getInstance(IForm form){
        IView instance = map.get(form.getName());
        if(instance == null){
            instance = newInstance(form);
            map.put(form.getName(), instance);
        }
        else{
            //Todo
        }
        return instance;
    }
}
