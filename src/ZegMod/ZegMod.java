package ZegMod;

import ZegMod.content.ZegBlocks;
import ZegMod.content.ZegItems;
import ZegMod.content.ZegPlanets;
import ZegMod.content.ZegTechTree;
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
        ZegTechTree.load();
    }
}
