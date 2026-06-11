package ZegMod.content;

import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.units.AIController;
import mindustry.gen.LegsUnit;
import mindustry.gen.Sounds;
import mindustry.graphics.Layer;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

public class ZegUnitType {
    public static UnitType
            delta, epsilon, zeta, eta, chaos, pulse;
    public static void load() {
        //核心机
        delta = new UnitType("delta"){{
            constructor = LegsUnit::create;
            // "德尔塔" 和 description 写在 bundle.properties 中
            health = 135;
            speed = 1.8f;
            drag = 0.12f;
            itemCapacity = 150;
            mineSpeed = 4f;
            mineTier = 2;
            buildSpeed = 2.5f;
            payloadCapacity = 0f;
            alwaysUnlocked = true;

            // 腿部设置
            legCount = 4;           // 腿的数量
            legLength = 8f;         // 腿的长度（根据单位大小调整）
            legForwardScl = 1f;   // 腿向前伸展的比例
            legMoveSpace = 1f;    // 腿移动间距
            hovering = true;        // 悬浮在地面上（不受地形影响）
            groundLayer = Layer.legUnit;

            weapons.add(new Weapon("delta-weapon"){{
                reload = 9f;
                range = 105f;
                alternate = true;
                shootSound = Sounds.shoot;
                // shootCone = 5f; // 默认值
                recoil = 1f;

                bullet = new BasicBulletType(5f, 25){{
                    lifetime = 25f;
                    width = 7f;
                    height = 9f;
                    // hitEffect = Fx.hitBulletSmall; // 默认值
                    despawnEffect = Fx.blastExplosion; // hitSmallExplosion 不存在，按需替换
                }};
            }});
        }};

        epsilon = new UnitType("epsilon"){{
            constructor = LegsUnit::create;

            health = 185f;
            armor = 3f;
            hitSize = 2f;

            speed = 2f;
            //boostMultiplier = 1.5f;

            itemCapacity = 200;
            mineSpeed = 4.5f;
            mineTier = 2;
            buildSpeed = 3f;
            payloadCapacity = 0f;
            alwaysUnlocked = true;

            // 腿部设置
            legCount = 6;           // 腿的数量
            legGroupSize = 3;
            legLength = 9f;         // 腿的长度（根据单位大小调整）
            legForwardScl = 1f;   // 腿向前伸展的比例
            legMoveSpace = 1f;    // 腿移动间距
            hovering = true;        // 悬浮在地面上（不受地形影响）
            groundLayer = Layer.legUnit;


            weapons.add(new Weapon("epsilon-weapon"){{
                reload = 8f;
                range = 140f;
                mirror = false;
                shootSound = Sounds.shootFuse;
                shootCone = 5f;
                recoil = 1f;

                bullet = new BasicBulletType(6f, 35){{
                    lifetime = 24f;
                    width = 8f;
                    height = 10f;
                    hitEffect = Fx.blastExplosion;
                    despawnEffect = Fx.blastExplosion;
                }};
            }});
        }};

        zeta = new UnitType("zeta"){{
            constructor = LegsUnit::create;

            health = 200f;
            armor = 6f;
            hitSize = 3f;

            speed = 2.5f;

            itemCapacity = 400;
            mineSpeed = 5f;
            mineTier = 3;
            buildSpeed = 3.2f;
            payloadCapacity = 0f;
            alwaysUnlocked = true;

            // 腿部设置
            legCount = 8;           // 腿的数量
            legGroupSize = 4;
            legLength = 16f;         // 腿的长度（根据单位大小调整）
            legForwardScl = 2f;   // 腿向前伸展的比例
            legMoveSpace = 2f;    // 腿移动间距
            hovering = true;        // 悬浮在地面上（不受地形影响）
            groundLayer = Layer.legUnit;

            abilities.add(new CompanionAbility(
                    pulse,
                    new float[]{-20f, 20f},  // X 偏移（左/右）
                    new float[]{0f, 0f}      // Y 偏移（前/后）
            ));
        }};
/*
        eta = new UnitType("eta"){{

        }};

        chaos = new UnitType("chaos"){{

        }};
*/
        //其他单位
        pulse = new UnitType("pulse"){{
            health = 320f;
            speed = 2.5f;
            armor = 15;

            alwaysUnlocked = true;
            // 禁止玩家/逻辑控制
            playerControllable = false;
            logicControllable = false;
            // 不占用单位上限
            useUnitCap = false;
            // 禁用物理碰撞，防止卡住父单位
            physics = false;
            // 不被敌人瞄准(可选)
            targetable = true;
            hittable = true;
            // 不在数据库显示
            hidden = true;
            // 设置一个什么都不做的AI
            aiController = AIController::new;

            //其他属性和武器
            weapons.add(new Weapon("pulse-weapons"){{
                alwaysUnlocked = true;

                reload = 9f;
                range = 140f;
                mirror = false;
                shootSound = Sounds.shootFuse;
                shootCone = 5f;
                recoil = 1f;

                bullet = new BasicBulletType(5f, 50){{
                    lifetime = 24f;
                    width = 8f;
                    height = 10f;
                    hitEffect = Fx.blastExplosion;
                    despawnEffect = Fx.blastExplosion;
                }};
            }});

        }};

    }
}
