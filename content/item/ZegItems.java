package zeg.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class ZegItems {
    public static Item
            aluminum, bauxite, crystallineLithium;

    public static void load(){
        aluminum = new Item("aluminum", Color.valueOf("dfdfdf")){{  
            hardness = 1;   // int 类型，1.1 需取整  
            cost = 0.95f;
        }};

        bauxite = new Item("bauxite", Color.valueOf("3b393a")){{  
            hardness = 0;      // int 类型，0.1 取整为 0  
            cost = 1.2f;  
        }};

        crystallineLithium = new Item("crystalline-lithium", Color.valueOf("dfdfdf")){{  
            hardness = 3;  
            cost = 0.95f;  
        }};
        
    }
}
