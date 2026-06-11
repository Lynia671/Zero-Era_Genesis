package ZegMod.content;

import mindustry.world.blocks.storage.CoreBlock;

public class PowerCoreBlock extends CoreBlock {

    /** 每 tick 发电量（单位/tick），60 tick = 1 秒 */
    public float powerProduction = 3f;

    public PowerCoreBlock(String name) {
        super(name);
        // 加入电网，并标记为输出电力
        hasPower = true;
        outputsPower = true;
        consumesPower = false;
    }

    public class PowerCoreBuild extends CoreBuild {

        /** 发电效率，1.0 = 100%，可根据条件动态修改 */
        public float productionEfficiency = 1f;

        @Override
        public float getPowerProduction() {
            // enabled 为 false 时（被禁用）不发电
            return enabled ? powerProduction * productionEfficiency : 0f;
        }
    }
}