package ZegMod.content;

import arc.math.*;
import arc.util.*;
import mindustry.entities.abilities.*;
import mindustry.gen.*;
import mindustry.type.*;

import static mindustry.Vars.*;   // ← 这行是关键，net 来自这里

public class CompanionAbility extends Ability {

    public UnitType companionType;   // ← 字段必须在类体内声明
    public float[] offsetsX, offsetsY;
    public float respawnTime = 300f;

    private transient Unit[] companions;
    private transient float[] respawnTimers; // 每个子单位的冷却计时器

    public CompanionAbility(UnitType type, float[] offsetsX, float[] offsetsY) {
        this.companionType = type;
        this.offsetsX = offsetsX;
        this.offsetsY = offsetsY;
    }

    @Override
    public void update(Unit unit) {
        if (net.client()) return;

        int count = offsetsX.length;
        if (companions == null) {
            companions = new Unit[count];
            respawnTimers = new float[count];
        }

        for (int i = 0; i < count; i++) {
            Unit c = companions[i];

            if (c == null || !c.isValid()) {
                respawnTimers[i] += Time.delta;
                if (respawnTimers[i] < respawnTime) continue;
                respawnTimers[i] = 0f;

                c = companionType.create(unit.team);
                c.set(unit.x, unit.y);
                c.rotation = unit.rotation;
                c.add();
                companions[i] = c;
            }

            float ox = offsetsX[i], oy = offsetsY[i];
            c.x = unit.x + Angles.trnsx(unit.rotation - 90f, ox, oy);
            c.y = unit.y + Angles.trnsy(unit.rotation - 90f, ox, oy);
            c.rotation = unit.rotation;
            c.vel.setZero();
        }
    }

    @Override
    public void death(Unit unit) {
        if (companions != null) {
            for (Unit c : companions) {
                if (c != null && c.isValid()) c.kill();
            }
        }
    }
}
