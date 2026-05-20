package ZegMod.content;

import arc.graphics.Color;
import mindustry.content.Planets;
import mindustry.game.Team;
import mindustry.graphics.g3d.HexSkyMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.graphics.g3d.NoiseMesh;
import mindustry.type.Planet;


public class ZegPlanets {
    public static Planet svitton;

    public static void load() {
        svitton = new Planet("svitton", Planets.sun, 1.8f, 3){{
            alwaysUnlocked = true;
            orbitRadius = 130f;          // 覆盖自动计算值
            orbitSpacing = 1f;
            startSector = 13;
            sectorSeed = 27290;

            minZoom = 0.6f;
            maxZoom = 3f;
            drawOrbit = true;
            tidalLock = true;
            accessible = true;
            visible = true;
            bloom = false;
            updateLighting = false;

            atmosphereRadIn = 0.3f;
            atmosphereRadOut = 0.5f;
            hasAtmosphere = true;
            atmosphereColor = Color.valueOf("3a558030");  // RRGGBBAA，含alpha
            landCloudColor = Color.valueOf("8a95a8");
            iconColor = Color.valueOf("a5dbef");

            allowLaunchSchematics = true;
            allowLaunchToNumbered = false;
            allowLaunchLoadout = false;
            allowSectorInvasion = false;
            allowWaves = true;
            clearSectorOnLose = true;
            prebuildBase = false;

            defaultCore = ZegBlocks.coreZero;  // 替换为你的 core-zero Block 引用

            ruleSetter = r -> {
                r.waveTeam = Team.green;
            };

            // ── mesh ──────────────────────────────────────────────────────────────
            // NoiseMesh 两色构造函数参数顺序：
            // (planet, seed, divisions, radius, octaves, persistence, scale, mag,
            //  color1, color2, colorOct, colorPersistence, colorScale, colorThreshold)
            meshLoader = () -> new MultiMesh(
                    // 极寒深渊/暗冰岩
                    new NoiseMesh(this, 35, 5, 1.30f, 5, 0.85f, 3.5f, 1.6f,
                            Color.valueOf("0a1119"), Color.valueOf("05080d"),
                            1, 0.5f, 1f, 0.25f),
                    // 万年冻土/基岩冰层
                    new NoiseMesh(this, 54, 5, 1.36f, 4, 0.9f, 1.8f, 1.3f,
                            Color.valueOf("1a2a3f"), Color.valueOf("111c2b"),
                            1, 0.5f, 1f, 0.35f),
                    // 压实冰盖/裂隙雪原
                    new NoiseMesh(this, 104, 5, 1.48f, 6, 0.7f, 1.2f, 1.5f,
                            Color.valueOf("4a637a"), Color.valueOf("364b5f"),
                            1, 0.5f, 1f, 0.45f),
                    // 积雪峰顶/高压冰脊
                    new NoiseMesh(this, 80, 5, 1.6f, 8, 0.65f, 1f, 1.2f,
                            Color.valueOf("96b4cc"), Color.valueOf("7293ab"),
                            1, 0.5f, 1f, 0.55f),
                    // 高空霜雾/大气辉光（颜色含alpha）
                    new NoiseMesh(this, 34, 5, 1.68f, 4, 0.5f, 0.8f, 0.8f,
                            Color.valueOf("d8e8f260"), Color.valueOf("a8c0d040"),
                            1, 0.5f, 1f, 0.65f)
            );

            // ── cloudMesh ─────────────────────────────────────────────────────────
            // HexSkyMesh 参数顺序：
            // (planet, seed, speed, radius, divisions, color, octaves, persistence, scl, thresh)
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 0, 2.05f, 0.15f, 5, Color.valueOf("d0d8e4cc"), 6, 0.4f, 1.2f, 0.5f),
                    new HexSkyMesh(this, 0, 1.87f, 0.12f, 5, Color.valueOf("b8c2d1b0"), 6, 0.5f, 1f,  0.4f),
                    new HexSkyMesh(this, 0, 1.60f, 0.10f, 5, Color.valueOf("a0aabfaa"), 8, 0.6f, 1f,  0.35f)
            );

            generator = new SvittonPlanetGenerator();
        }};
    }}