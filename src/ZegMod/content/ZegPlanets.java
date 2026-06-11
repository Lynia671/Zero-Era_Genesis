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
        svitton = new Planet("svitton", Planets.sun, 1f, 3){{
            alwaysUnlocked = true;
            orbitRadius = 130f;
            orbitSpacing = 1f;
            startSector = 123;
            sectorSeed = 27290;


            minZoom = 0.6f;
            maxZoom = 3f;
            drawOrbit = true;
            tidalLock = true;
            accessible = true;
            visible = true;
//            bloom = false;
//            updateLighting = false;

            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.3f;
            hasAtmosphere = true;
            atmosphereColor = Color.valueOf("5588ff");
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
                    // 极寒深渊/暗冰岩                                     /*1.30f*/                                             //1.6f
                    new NoiseMesh(this, 35, 5, 0.75f, 5, 0.85f, 1.5f, 1.45f,
                            Color.valueOf("0a1119"), Color.valueOf("05080d"),
                            1, 0.5f, 1f, 0.25f),
                    // 万年冻土/基岩冰层                                    /*1.36f*/                                             //1.3f
                    new NoiseMesh(this, 54, 5, 0.7f, 4, 0.9f, 1.8f, 1.4f,
                            Color.valueOf("1a2a3f"), Color.valueOf("111c2b"),
                            1, 0.5f, 1f, 0.35f),
                    // 压实冰盖/裂隙雪原                                    /*1.48f*/                                             //1.5f
                    new NoiseMesh(this, 104, 5, 0.78f, 6, 0.7f, 1.2f, 1.6f,
                            Color.valueOf("4a637a"), Color.valueOf("364b5f"),
                            1, 0.5f, 1f, 0.45f),
                    // 积雪峰顶/高压冰脊                                    /*1.6f*/                                          //1.2f
                    new NoiseMesh(this, 81, 5, 0.9f, 7, 0.65f, 1f, 1.27f,
                            Color.valueOf("96b4cc"), Color.valueOf("7293ab"),
                            1, 0.5f, 1f, 0.55f),
                    // 表面积雪                                            /*1.68f*/                               //0.8f
                    new NoiseMesh(this, 34, 5, 0.91f, 4, 0.5f, 0.8f, 1.25f,
                            Color.valueOf("d8e8f2"), Color.valueOf("a8c0d0"),
                            1, 0.5f, 1f, 0.65f)
            );

            // ── cloudMesh ─────────────────────────────────────────────────────────
            // HexSkyMesh 参数顺序：
            // (planet, seed, speed, radius, divisions, color, octaves, persistence, scl, thresh)
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 0, 2.05f, 0.15f, 5, Color.valueOf("d0d8e4"), 6, 0.4f, 1.2f, 0.5f),
                    new HexSkyMesh(this, 0, 1.87f, 0.13f, 5, Color.valueOf("d8e8f2"), 6, 0.5f, 1f,  0.4f),
                    new HexSkyMesh(this, 0, 1.30f, 0.10f, 5, Color.valueOf("a8c0d0"), 8, 0.6f, 1f,  0.35f)
            );

            generator = new SvittonPlanetGenerator();
        }};
    }}