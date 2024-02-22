package view.state;

import java.awt.event.MouseAdapter;
import java.util.HashMap;

public abstract class ViewStateFactory {
    
    public static final HashMap<String , MouseAdapter> VIEWSTATELIST = new HashMap<>(); 

    /* public static MouseAdapter getInstance(String name){
        MouseAdapter m = VIEWSTATELIST.get(name);
        if (m == null) {
            m = new MouseAdapter();
        } else {
            return m;
        }
    } */
}
