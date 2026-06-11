package ZegMod.content;

import arc.graphics.Color;
import mindustry.type.Item;
import mindustry.world.meta.Attribute;

public class ZegItems {

    public static final Attribute attrRawIce = Attribute.add("raw-ice");
    public static Item
            aluminum, bauxite, crystallineLithium, permafrost, rawIce, zeroIron;

    public static void load(){

        aluminum = new Item("aluminum", Color.valueOf("dfdfdf")){{  
            hardness = 1;   // int 类型，1.1 需取整  
            cost = 0.95f;
            alwaysUnlocked = true;
        }};

        bauxite = new Item("bauxite", Color.valueOf("3b393a")){{  
            hardness = 0;      // int 类型，0.1 取整为 0  
            cost = 1.2f;  
        }};

        crystallineLithium = new Item("crystalline-lithium", Color.valueOf("dfdfdf")){{  
            hardness = 3;  
            cost = 0.95f;  
        }};

        permafrost = new Item("Permafrost", Color.valueOf("a0d8ff")){{
            hardness = 1;
            cost = 0.1f;  
        }};

        rawIce = new Item("raw-ice", Color.valueOf("a0d8ff")){{  
            hardness = 2;  
            cost = 0.1f;  
        }};

        zeroIron = new Item("zero-iron", Color.valueOf("435a68")){{  
            hardness = 4;  
            cost = 0.6f;  
        }};
        
    }
}
