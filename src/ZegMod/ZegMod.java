package ZegMod;

import ZegMod.content.*;
import mindustry.mod.Mod;

public class ZegMod extends Mod {
    
    public ZegMod() {
        super();
    }
    
    @Override
    public void loadContent() {
        // Load your content here (blocks, items, units, etc.)
        ZegItems.load();
        ZegUnitType.load();
        ZegBlocks.load();
        ZegPlanets.load();
        ZegTechTree.load();
    }
}
