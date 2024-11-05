package com.science.gtnl.common.materials;

import static bartworks.util.BWUtil.*;
import static bartworks.util.BWUtil.subscriptNumbers;

import bartworks.system.material.Werkstoff;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TextureSet;

/**
 * Register new material here by Bartworks Material System
 */

public class MaterialPool implements Runnable {

    // ID manager
    private static final int offsetID_01 = 20_000;

    public static final Werkstoff Hexanitrohexaazaisowurtzitane = new Werkstoff(
        new short[] { 47, 53, 57 },
        "Hexanitrohexaazaisowurtzitane",
        subscriptNumbers("C6H6N12O12"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 1,
        TextureSet.SET_SHINY);

    public static final Werkstoff CrudeHexanitrohexaazaisowurtzitane = new Werkstoff(
        new short[] { 20, 71, 88 },
        "Crude Hexanitrohexaazaisowurtzitane",
        subscriptNumbers("C6H6N12O12"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 2,
        TextureSet.SET_SHINY);
    // spotless:off

    public static final Werkstoff SilicaGel = new Werkstoff(
        new short[] { 77, 173, 202 },
        "Silica Gel",
        subscriptNumbers(""),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 3,
        TextureSet.SET_SHINY);
    // spotless:off

    public static final Werkstoff Ethylenediamine = new Werkstoff(
        new short[] { 26, 90, 113 },
        "Ethylenediamine",
        subscriptNumbers("C2H8N2"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 4,
        TextureSet.SET_FLUID);

    public static final Werkstoff Ethanolamine = new Werkstoff(
        new short[] { 27, 92, 115 },
        "Ethanolamine",
        subscriptNumbers("C2H7NO"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 5,
        TextureSet.SET_FLUID);

    public static final Werkstoff SilicaGelBase = new Werkstoff(
        new short[] { 55, 146, 119 },
        "Silica Gel Base",
        subscriptNumbers(""),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 6,
        TextureSet.SET_FLUID);

    public static final Werkstoff FluoroboricAcide = new Werkstoff(
        new short[] { 139, 183, 139 },
        "Fluoroboric Acide",
        subscriptNumbers("HBF4"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 7,
        TextureSet.SET_FLUID);

    public static final Werkstoff Tetraacetyldinitrohexaazaisowurtzitane = new Werkstoff(
        new short[] { 57, 3, 52 },
        "Tetraacetyldinitrohexaazaisowurtzitane",
        subscriptNumbers("C14H18N8O6"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 8,
        TextureSet.SET_SHINY);

    public static final Werkstoff NitroniumTetrafluoroborate = new Werkstoff(
        new short[] { 53, 56, 57 },
        "NitroniumTetrafluoroborate",
        subscriptNumbers("NO2BF4"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 9,
        TextureSet.SET_SHINY);

    public static final Werkstoff NitronsoniumTetrafluoroborate = new Werkstoff(
        new short[] { 53, 56, 57 },
        "NitronsoniumTetrafluoroborate",
        subscriptNumbers("NOBF4"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 10,
        TextureSet.SET_SHINY);

    public static final Werkstoff BoronFluoride = new Werkstoff(
        new short[] { 200, 196, 202 },
        "Boron Fluoride",
        subscriptNumbers("BF3"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 11,
        TextureSet.SET_FLUID);

    public static final Werkstoff SodiumTetrafluoroborate = new Werkstoff(
        new short[] { 147, 89, 13 },
        "Sodium Tetrafluoroborate",
        subscriptNumbers("NaBF4"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 12,
        TextureSet.SET_SHINY);

    public static final Werkstoff BoronTrioxide = new Werkstoff(
        new short[] { 127, 147, 161 },
        "Boron Trioxide",
        subscriptNumbers("B2O3"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 13,
        TextureSet.SET_SHINY);

    public static final Werkstoff Dibenzyltetraacetylhexaazaisowurtzitane = new Werkstoff(
        new short[] { 89, 99, 68 },
        "Dibenzyltetraacetylhexaazaisowurtzitane",
        subscriptNumbers("C28H32N6O4"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 14,
        TextureSet.SET_SHINY);

    public static final Werkstoff Benzaldehyde = new Werkstoff(
        new short[] { 142, 89, 27 },
        "Benzaldehyde",
        subscriptNumbers("C7H6O"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 15,
        TextureSet.SET_FLUID);

    public static final Werkstoff HydrobromicAcid = new Werkstoff(
        new short[] { 160, 86, 62 },
        "Hydrobromic Acid",
        subscriptNumbers("HBr"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 16,
        TextureSet.SET_FLUID);

    public static final Werkstoff SuccinimidylAcetate = new Werkstoff(
        new short[] { 89, 99, 68 },
        "Succinimidyl Acetate",
        subscriptNumbers("C6H7NO4"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 17,
        TextureSet.SET_SHINY);

    public static final Werkstoff Hexabenzylhexaazaisowurtzitane = new Werkstoff(
        new short[] { 89, 99, 68 },
        "Hexabenzylhexaazaisowurtzitane",
        subscriptNumbers("C48H48N6"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 18,
        TextureSet.SET_SHINY);

    public static final Werkstoff NHydroxysuccinimide = new Werkstoff(
        new short[] { 109, 100, 113 },
        "N-Hydroxysuccinimide",
        subscriptNumbers("C4H5NO3"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 19,
        TextureSet.SET_SHINY);

    public static final Werkstoff SuccinicAnhydride = new Werkstoff(
        new short[] { 57, 15, 19 },
        "Succinic Anhydride",
        subscriptNumbers("C4H4O3"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 20,
        TextureSet.SET_SHINY);

    public static final Werkstoff HydroxylamineHydrochloride = new Werkstoff(
        new short[] { 66, 49, 23 },
        "Hydroxylamine Hydrochloride",
        subscriptNumbers("H4NOCl"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 21,
        TextureSet.SET_FLUID);

    public static final Werkstoff BariumChloride = new Werkstoff(
        new short[] { 207, 99, 84 },
        "Barium Chloride",
        subscriptNumbers("BaCl2"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 22,
        TextureSet.SET_SHINY);

    public static final Werkstoff HydroxylammoniumSulfate = new Werkstoff(
        new short[] { 117, 114, 104 },
        "Hydroxylammonium Sulfate",
        subscriptNumbers("N2H8SO6"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 23,
        TextureSet.SET_SHINY);

    public static final Werkstoff HydroboromicAcid = new Werkstoff(
        new short[] { 66, 49, 23 },
        "Hydroboromic Acid",
        subscriptNumbers("HBr"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 24,
        TextureSet.SET_FLUID);

    public static final Werkstoff PotassiumHydroxylaminedisulfonate = new Werkstoff(
        new short[] { 117, 114, 104 },
        "Potassium Hydroxylaminedisulfonate",
        subscriptNumbers("K2NHS2O7"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 25,
        TextureSet.SET_SHINY);

    public static final Werkstoff PotassiumSulfate = new Werkstoff(
        new short[] { 208, 152, 46 },
        "Potassium Hydroxylaminedisulfonate",
        subscriptNumbers("K2SO4"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 26,
        TextureSet.SET_SHINY);

    public static final Werkstoff PotassiumBisulfite = new Werkstoff(
        new short[] { 114, 111, 101 },
        "Potassium Bisulfite",
        subscriptNumbers("KSHO3"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 27,
        TextureSet.SET_SHINY);

    public static final Werkstoff NitrousAcid = new Werkstoff(
        new short[] { 156, 194, 246 },
        "Nitrous Acid",
        subscriptNumbers("HNO2"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 28,
        TextureSet.SET_FLUID);

    public static final Werkstoff SodiumNitrite = new Werkstoff(
        new short[] { 114, 111, 101 },
        "Sodium Nitrite",
        subscriptNumbers("NaNO2"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 29,
        TextureSet.SET_SHINY);

    public static final Werkstoff CoAcAbCatalyst = new Werkstoff(
        new short[] { 68, 55, 28 },
        "Co/Ac-Ab Catalyst",
        subscriptNumbers(""),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 30,
        TextureSet.SET_SHINY);

    public static final Werkstoff SodiumNitrateSolution = new Werkstoff(
        new short[] { 156, 194, 246 },
        "Sodium Nitrate Solution",
        subscriptNumbers("(NaNO3)(H2O)"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 31,
        TextureSet.SET_FLUID);

    public static final Werkstoff Benzylamine = new Werkstoff(
        new short[] { 88, 96, 96 },
        "Benzylamine",
        subscriptNumbers("C7H9N"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 32,
        TextureSet.SET_FLUID);

    public static final Werkstoff Glyoxal = new Werkstoff(
        new short[] { 233, 231, 75 },
        "Glyoxal",
        subscriptNumbers("C2H2O2"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 33,
        TextureSet.SET_FLUID);

    public static final Werkstoff Acetonitrile = new Werkstoff(
        new short[] { 80, 86, 86 },
        "Acetonitrile",
        subscriptNumbers("C2H3N"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 34,
        TextureSet.SET_SHINY);

    public static final Werkstoff AmmoniumChloride = new Werkstoff(
        new short[] { 80, 86, 86 },
        "Ammonium Chloride",
        subscriptNumbers("NH4Cl"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 35,
        TextureSet.SET_SHINY);

    public static final Werkstoff Hexamethylenetetramine = new Werkstoff(
        new short[] { 80, 87, 86 },
        "Hexamethylenetetramine",
        subscriptNumbers("C6H12N4"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 36,
        TextureSet.SET_SHINY);

    public static final Werkstoff BenzylChloride = new Werkstoff(
        new short[] { 155, 239, 244 },
        "Benzyl Chloride",
        subscriptNumbers("C7H7Cl"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 37,
        TextureSet.SET_FLUID);

    public static final Werkstoff SuccinicAcid = new Werkstoff(
        new short[] { 80, 87, 86 },
        "Succinic Acid",
        subscriptNumbers("C4H6O4"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 38,
        TextureSet.SET_SHINY);

    public static final Werkstoff MaleicAnhydride = new Werkstoff(
        new short[] { 155, 239, 244 },
        "Maleic Anhydride",
        subscriptNumbers("C4H2O3"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 39,
        TextureSet.SET_FLUID);

    public static final Werkstoff SuperMutatedLivingSolder = new Werkstoff(
        new short[] { 177, 95, 248 },
        "Super Mutated Living Solder",
        subscriptNumbers("??HeOSnCBe??"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 40,
        TextureSet.SET_FLUID);

    public static final Werkstoff Polyimide = new Werkstoff(
        new short[] { 248, 100, 47 },
        "Polyimide",
        subscriptNumbers("C22H12N2O6"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 41,
        TextureSet.SET_FLUID);

    public static final Werkstoff PloyamicAcid = new Werkstoff(
        new short[] { 231, 206, 93 },
        "Ployamic Acid",
        subscriptNumbers("C22H14N2O7"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 42,
        TextureSet.SET_FLUID);

    public static final Werkstoff Oxydianiline = new Werkstoff(
        new short[] { 252, 212, 0 },
        "Oxydianiline",
        subscriptNumbers("C12H12N2O"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 43,
        TextureSet.SET_FLUID);

    public static final Werkstoff PyromelliticDianhydride = new Werkstoff(
        new short[] { 99, 114, 128 },
        "Pyromellitic Dianhydride",
        subscriptNumbers("C10H2O6"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 44,
        TextureSet.SET_SHINY);

    public static final Werkstoff Durene = new Werkstoff(
        new short[] { 99, 114, 128 },
        "Durene",
        subscriptNumbers("C10H14"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 45,
        TextureSet.SET_SHINY);

    public static final Werkstoff Germaniumtungstennitride = new Werkstoff(
        new short[] { 148, 182, 189 },
        "Germaniumtungstennitride",
        subscriptNumbers("Ge3W3N10"),
        new Werkstoff.Stats().setToxic(true),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().addMetalItems()
            .addMolten()
            .addCraftingMetalWorkingItems()
            .addSimpleMetalWorkingItems(),
        offsetID_01 + 46,
        TextureSet.SET_SHINY);

    public static final Werkstoff Polyetheretherketone = new Werkstoff(
        new short[] { 50, 50, 75 },
        "Polyetheretherketone",
        subscriptNumbers("C20H12O3"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().addMetalItems()
            .addMetaSolidifierRecipes()
            .removePrefix(OrePrefixes.ingotHot)
            .removeOres()
            .addMolten(),
        offsetID_01 + 47,
        TextureSet.SET_DULL);

    public static final Werkstoff Periodicium = new Werkstoff(
        new short[] { 60, 74, 243 },
        "Periodicium",
        subscriptNumbers(
            "(HCNOFPSClSeBrI)(HeNeArKrXeRn)(BSiGeAsSbTeAt)(AlGaInSnTlPbBiPo)((TiVCrMnFeCoNiCuZn)(ZrNbMoTcRuRhPdAgCd)(HfTaWReOsIrPtAuHg))(BeMgCaSrBaRa)(ScY(LaCePrNdPmSmEuGd)(TbDyHoErTmYbLu))(LiNaKRbCsFr)((AcThPaUNpPuAmCm)(BkCfEsFmMdNoLr)(LfDbSgBhHsMtDsRgCnNfFlMcLvOg)(KeRpNqNq+Nq*SuAdSpDOhDeQtMaD*IcIf*NtHyEn)(TsЖTtЖ〄Fs⚶Hy⚶✢⸎✦◆✦⌘☯\uD80C\uDF70 \uD80C\uDF71 \uD80C\uDF72 \uD80C\uDF73 \uD80C\uDF74 \uD80C\uDF75 \uD80C\uDF76 \uD80C\uDF77 \uD80C\uDF78☯⌘⚷⚙⚷Ni4Ti6Fc⚙҈҉«»Rt*۞)"),
        new Werkstoff.Stats().setToxic(true),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().addMetalItems()
            .addMolten()
            .addCraftingMetalWorkingItems()
            .addSimpleMetalWorkingItems(),
        offsetID_01 + 200,
        TextureSet.SET_SHINY);

    public static final Werkstoff Stargate = new Werkstoff(
        new short[] { 148, 182, 189 },
        "Stargate",
        subscriptNumbers("\uD81A\uDD55"),
        new Werkstoff.Stats().setToxic(true),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().addMetalItems()
            .addMolten()
            .addCraftingMetalWorkingItems()
            .addSimpleMetalWorkingItems(),
        offsetID_01 + 201,
        TextureSet.SET_SHINY);
    // spotless:off

    public static final Werkstoff.GenerationFeatures gf = new Werkstoff.GenerationFeatures();

    // Bartworks' Material System run on Runnable.class
    @Override
    public void run() {
        for (var prefix : OrePrefixes.values()) {
            gf.addPrefix(prefix);
        }
        gf.removePrefix(OrePrefixes.ore);
    }
}
