package ThisOneMod.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class ThisItems {
    public static Item
            aluminum;

    public static void load(){
        aluminum = new Item("aluminum", Color.valueOf("dfdfdf")){{  
            hardness = 1;   // int 类型，1.1 需取整  
            cost = 0.95f;
        }};

        
    }
}
