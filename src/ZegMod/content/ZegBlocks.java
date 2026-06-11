package ZegMod.content;

import mindustry.content.Items;
import mindustry.content.UnitTypes;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.environment.StaticWall;
import mindustry.world.blocks.production.BeamDrill;
import mindustry.world.blocks.production.Drill;
import mindustry.world.blocks.production.WallCrafter;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawRegion;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.BuildVisibility;

import static mindustry.type.ItemStack.with;

public class ZegBlocks {
    public static Block coreOne, coreTwo, coreThree, coreFour, coreFive, windPoweredDrill, mechanicalDrill, iceWallCrusher, heavyIceWall, riverIce,
            permafrostWall, laserDrillingMachine, frozenStoneWall, oreZeroIron;
    public static void load () {
        Attribute attrRawIce = Attribute.add("raw-ice");

        coreOne = new CoreBlock("core-one"){{
            requirements(Category.effect, BuildVisibility.coreZoneOnly, with(Items.copper, 1000, Items.lead, 800));
            alwaysUnlocked = true;

            isFirstTier = true;
            unitType = ZegUnitType.delta;
            health = 2000;
            itemCapacity = 4000;
            size = 3;

            requiresCoreZone = false;
            incinerateNonBuildable = true;
        }};

        coreTwo = new CoreBlock("core-two"){{
            requirements(Category.effect, BuildVisibility.coreZoneOnly, with(Items.copper, 2000, Items.lead, 1800));
            alwaysUnlocked = false;

            unitType = ZegUnitType.epsilon;
            health = 4000;
            itemCapacity = 8000;
            size = 4;

            requiresCoreZone = false;
            incinerateNonBuildable = true;
        }};

        coreThree = new CoreBlock("core-three"){{
            requirements(Category.effect, BuildVisibility.coreZoneOnly, with(Items.copper, 4000, Items.lead, 3500));
            alwaysUnlocked = false;

            unitType = ZegUnitType.zeta;
            health = 6000;
            armor = 4;
            itemCapacity = 10000;
            size = 5;

            requiresCoreZone = false;
            incinerateNonBuildable = true;
        }};

        coreFour = new PowerCoreBlock("core-four"){{
            requirements(Category.effect, BuildVisibility.coreZoneOnly, with(Items.copper, 5000, Items.lead, 4000));
            alwaysUnlocked = false;

            unitType = ZegUnitType.delta;
            health = 8000;
            armor = 8;
            itemCapacity = 14000;
            size = 6;
            powerProduction = 5f; // 每 tick 5 单位电力 = 300/秒

            requiresCoreZone = false;
            incinerateNonBuildable = true;
        }};

        coreFive = new PowerCoreBlock("core-five"){{
            requirements(Category.effect, BuildVisibility.coreZoneOnly, with(Items.copper, 5000, Items.lead, 4000));
            alwaysUnlocked = false;

            unitType = ZegUnitType.delta;
            health = 10000;
            armor = 16;
            itemCapacity = 18000;
            size = 7;
            powerProduction = 7f;

            requiresCoreZone = false;
            incinerateNonBuildable = true;
        }};

        //环境

        frozenStoneWall = new StaticWall("frozen-stone-wall"){};

        //可获取资源的环境

        permafrostWall = new StaticWall("permafrost-wall"){{
            itemDrop = ZegItems.permafrost;
            // variants = 2; // 默认已是 2，可省略
        }};

        heavyIceWall = new StaticWall("heavy-ice-wall"){{
            // variants = 2; // 已是 StaticWall 构造函数的默认值，可省略
            attributes.set(attrRawIce, 1f);  // 让 WallCrafter 能在此工作
        }};

        riverIce = new OreBlock("river-ice", ZegItems.rawIce){{
            variants = 1;  // JSON 中 variant: "1"，只有1个变体
        }};

        oreZeroIron = new OreBlock("zero-iron", ZegItems.zeroIron);

        //获取资源的

        windPoweredDrill = new Drill("wind-powered-drill"){{
            requirements(Category.production, with(ZegItems.zeroIron, 155, Items.lead, 40));

            size = 3;
            health = 600;
            tier = 3;
            drillTime = 100f;
            hardnessDrillMultiplier = 22f;
            rotateSpeed = 9f;
            liquidCapacity = 10f;
            buildTime = 19.1f;

            shownPlanets.add(ZegPlanets.svitton);
        }};

        mechanicalDrill = new Drill("mechanical-drill"){{
            requirements(Category.production, with(ZegItems.zeroIron, 35, Items.lead, 40));

            size = 3;
            health = 600;
            tier = 2;
            drillTime = 100f;
            hardnessDrillMultiplier = 30f;
            rotateSpeed = 3f;
            liquidCapacity = 10f;
            buildTime = 17.1f;

            shownPlanets.add(ZegPlanets.svitton);
        }};

        iceWallCrusher = new WallCrafter("ice-wall-crusher"){{
            requirements(Category.production, with(ZegItems.zeroIron, 30, Items.lead, 25));

            size = 2;
            health = 590;
            drillTime = 80f;
            liquidCapacity = 10f;
            buildTime = 41.6f;

            attribute = ZegItems.attrRawIce;  // 自定义 Attribute
            output = ZegItems.rawIce;

            shownPlanets.add(ZegPlanets.svitton);
        }};

        laserDrillingMachine = new BeamDrill("laser-drilling-machine"){{
            requirements(Category.production, with(ZegItems.zeroIron, 30, Items.lead, 25));

            size = 2;
            health = 590;
            drillTime = 80f;
            tier = 2; // permafrost.hardness 需要 <= 这个值
            range = 5; // 光束射程（格数）

            shownPlanets.add(ZegPlanets.svitton);
        }};


    }
}