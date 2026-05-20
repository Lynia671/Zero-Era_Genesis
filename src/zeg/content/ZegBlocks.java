package zeg.content;

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
    public static Block coreZero, windPoweredDrill, mechanicalDrill, iceWallCrusher, heavyIceWall, riverIce,
            permafrostWall, permafrostDrill, frozenStoneWall, oreZeroIron;


    public static void load () {
        Attribute attrRawIce = Attribute.add("raw-ice");

        coreZero = new CoreBlock("core-zero"){{
            requirements(Category.effect, BuildVisibility.coreZoneOnly, with(Items.copper, 1000, Items.lead, 800));
            alwaysUnlocked = true;

            isFirstTier = true;
            unitType = UnitTypes.alpha;
            health = 1100;
            itemCapacity = 4000;
            size = 3;

            requiresCoreZone = true;
            incinerateNonBuildable = true;
        }};

        windPoweredDrill = new Drill("wind-powered-drill"){{
            requirements(Category.production, with(ZegItems.zeroIron, 55, Items.lead, 40));

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

        //环境

        frozenStoneWall = new StaticWall("frozen-stone-wall");

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

        permafrostDrill = new BeamDrill("permafrost-drill"){{
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