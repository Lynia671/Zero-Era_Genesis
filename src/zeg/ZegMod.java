package ThisOneMod;

import example.ZegBlocks;
import example.ZegItems;
import example.ZegPlanets;
import mindustry.mod.Mod;

public class ZegMod extends Mod {
    
    public ZegMod() {
        super();
    }
    
    @Override
    public void loadContent() {
        // Load your content here (blocks, items, units, etc.)
        ZegItems.load();
        ZegBlocks.load();
        ZegPlanets.load();
        ZegItems.load();
    }
}
