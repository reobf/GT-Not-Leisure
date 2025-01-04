package com.science.gtnl.common.materials;

import static bartworks.util.BWUtil.subscriptNumbers;

import bartworks.system.material.Werkstoff;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TextureSet;

/**
 * Register new material here by Bartworks Material System
 */

public class MaterialPool implements Runnable {

    // ID manager
    public static final int offsetID_01 = 25_000;

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
        "CrudeHexanitrohexaazaisowurtzitane",
        subscriptNumbers("C6H6N12O12"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 2,
        TextureSet.SET_SHINY);

    public static final Werkstoff SilicaGel = new Werkstoff(
        new short[] { 77, 173, 202 },
        "SilicaGel",
        subscriptNumbers(""),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 3,
        TextureSet.SET_SHINY);

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
        "SilicaGelBase",
        subscriptNumbers(""),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 6,
        TextureSet.SET_FLUID);

    public static final Werkstoff FluoroboricAcide = new Werkstoff(
        new short[] { 139, 183, 139 },
        "FluoroboricAcide",
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
        "BoronFluoride",
        subscriptNumbers("BF3"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 11,
        TextureSet.SET_FLUID);

    public static final Werkstoff SodiumTetrafluoroborate = new Werkstoff(
        new short[] { 147, 89, 13 },
        "SodiumTetrafluoroborate",
        subscriptNumbers("NaBF4"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 12,
        TextureSet.SET_SHINY);

    public static final Werkstoff BoronTrioxide = new Werkstoff(
        new short[] { 127, 147, 161 },
        "BoronTrioxide",
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
        "HydrobromicAcid",
        subscriptNumbers("HBr"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 16,
        TextureSet.SET_FLUID);

    public static final Werkstoff SuccinimidylAcetate = new Werkstoff(
        new short[] { 89, 99, 68 },
        "SuccinimidylAcetate",
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
        "SuccinicAnhydride",
        subscriptNumbers("C4H4O3"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 20,
        TextureSet.SET_SHINY);

    public static final Werkstoff HydroxylamineHydrochloride = new Werkstoff(
        new short[] { 66, 49, 23 },
        "HydroxylamineHydrochloride",
        subscriptNumbers("H4NOCl"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 21,
        TextureSet.SET_FLUID);

    public static final Werkstoff BariumChloride = new Werkstoff(
        new short[] { 207, 99, 84 },
        "BariumChloride",
        subscriptNumbers("BaCl2"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 22,
        TextureSet.SET_SHINY);

    public static final Werkstoff HydroxylammoniumSulfate = new Werkstoff(
        new short[] { 117, 114, 104 },
        "HydroxylammoniumSulfate",
        subscriptNumbers("N2H8SO6"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 23,
        TextureSet.SET_SHINY);

    public static final Werkstoff HydroboromicAcid = new Werkstoff(
        new short[] { 66, 49, 23 },
        "HydroboromicAcid",
        subscriptNumbers("HBr"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 24,
        TextureSet.SET_FLUID);

    public static final Werkstoff PotassiumHydroxylaminedisulfonate = new Werkstoff(
        new short[] { 117, 114, 104 },
        "PotassiumHydroxylaminedisulfonate",
        subscriptNumbers("K2NHS2O7"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 25,
        TextureSet.SET_SHINY);

    public static final Werkstoff PotassiumSulfate = new Werkstoff(
        new short[] { 208, 152, 46 },
        "PotassiumHydroxylaminedisulfonate",
        subscriptNumbers("K2SO4"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 26,
        TextureSet.SET_SHINY);

    public static final Werkstoff PotassiumBisulfite = new Werkstoff(
        new short[] { 114, 111, 101 },
        "PotassiumBisulfite",
        subscriptNumbers("KSHO3"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 27,
        TextureSet.SET_SHINY);

    public static final Werkstoff NitrousAcid = new Werkstoff(
        new short[] { 156, 194, 246 },
        "NitrousAcid",
        subscriptNumbers("HNO2"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 28,
        TextureSet.SET_FLUID);

    public static final Werkstoff SodiumNitrite = new Werkstoff(
        new short[] { 114, 111, 101 },
        "SodiumNitrite",
        subscriptNumbers("NaNO2"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 29,
        TextureSet.SET_SHINY);

    public static final Werkstoff CoAcAbCatalyst = new Werkstoff(
        new short[] { 68, 55, 28 },
        "Co/Ac-AbCatalyst",
        subscriptNumbers(""),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 30,
        TextureSet.SET_SHINY);

    public static final Werkstoff SodiumNitrateSolution = new Werkstoff(
        new short[] { 156, 194, 246 },
        "SodiumNitrateSolution",
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
        "AmmoniumChloride",
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
        "BenzylChloride",
        subscriptNumbers("C7H7Cl"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 37,
        TextureSet.SET_FLUID);

    public static final Werkstoff SuccinicAcid = new Werkstoff(
        new short[] { 80, 87, 86 },
        "SuccinicAcid",
        subscriptNumbers("C4H6O4"),
        new Werkstoff.Stats(),
        Werkstoff.Types.MATERIAL,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 38,
        TextureSet.SET_SHINY);

    public static final Werkstoff MaleicAnhydride = new Werkstoff(
        new short[] { 155, 239, 244 },
        "MaleicAnhydride",
        subscriptNumbers("C4H2O3"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 39,
        TextureSet.SET_FLUID);

    public static final Werkstoff SuperMutatedLivingSolder = new Werkstoff(
        new short[] { 177, 95, 248 },
        "SuperMutatedLivingSolder",
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
        "PloyamicAcid",
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
        "PyromelliticDianhydride",
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
        new short[] { 111, 11, 160 },
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

    public static final Werkstoff FluidMana = new Werkstoff(
        new short[] { 98, 183, 227 },
        "FluidMana",
        subscriptNumbers("❃"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 48,
        TextureSet.SET_FLUID);

    public static final Werkstoff DepletedExcitedNaquadah = new Werkstoff(
        new short[] { 15, 2, 2 },
        "DepletedExcitedNaquadah",
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 49,
        TextureSet.SET_FLUID);

    public static final Werkstoff RareEarthHydroxides = new Werkstoff(
        new short[] { 114, 114, 9 },
        "RareEarthHydroxides",
        subscriptNumbers("?OH"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 50,
        TextureSet.SET_FLUID);

    public static final Werkstoff RareEarthChlorides = new Werkstoff(
        new short[] { 165, 161, 103 },
        "RareEarthChlorides",
        subscriptNumbers("?Cl"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 51,
        TextureSet.SET_FLUID);

    public static final Werkstoff RareEarthOxide = new Werkstoff(
        new short[] { 166, 166, 79 },
        "RareEarthOxide",
        subscriptNumbers("?O"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 52,
        TextureSet.SET_FLUID);

    public static final Werkstoff RareEarthMetal = new Werkstoff(
        new short[] { 148, 148, 148 },
        "RareEarthMetal",
        subscriptNumbers("?"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .onlyDust(),
        offsetID_01 + 53,
        TextureSet.SET_FLUID);

    public static final Werkstoff BarnardaCSappy = new Werkstoff(
        new short[] { 49, 49, 100 },
        "BarnardaCSappy",
        subscriptNumbers("?"),
        new Werkstoff.Stats(),
        Werkstoff.Types.ELEMENT,
        new Werkstoff.GenerationFeatures().disable()
            .addCells(),
        offsetID_01 + 54,
        TextureSet.SET_FLUID);

    public static final Werkstoff Periodicium = new Werkstoff(
        new short[] { 60, 74, 243 },
        "Periodicium",
        subscriptNumbers(
            "((H37C67N32O35F61P52S48C64Se53Br56I52)" + "(He32Ne58Ar48Kr35Xe62Rn54)"
                + "(B56Si38Ge30As64Sb68Te31At38)"
                + "(Al35Ga56In66Sn42Tl43Pb46Bi64Po68)"
                + "((Ti49V59Cr60Mn48Fe61Co50Ni66Cu32Zn31)"
                + "(Zr65Nb46Mo36Tc60Ru57Rh50Pd38Ag30Cd47)"
                + "(Hf45Ta37W68Re66Os58Ir43Pt33Au55Hg48))"
                + "(Be44Mg51Ca38Sr35Ba68Ra52)"
                + "(Sc64Y47(La30Ce42Pr63Nd68Pm52Sm56Eu38Gd64))"
                + "(Tb62Dy46Ho35Er66Tm48Yb36Lu55)"
                + "(Li67Na49K68Rb57Cs50Fr52)"
                + "((Bk61Cf43Es38Fm48Md58No30Lr56)"
                + "(Rf45Db53Sg51Bh65Hs31Mt46Ds57Rg54Cn48Nh64Fl44Mc33Lv52Ts41Og58))"
                + "((Ke41Rp56Nq35Nq+54Nq*38Su60Ad66Sp67D55Oh50De63Qt35D*30(IcMa)65If*38Nt42Hy66En64)"
                + "(Gs39TsЖ66TtЖ67〄62Fs⚶45Hy⚶53✢64En⦼53M⎋65⸎46✦◆✦48✧◇✧52Og*52Sh⏧68)"
                + "(⌘☯𓍰 𓍱 𓍲 𓍳 𓍴 𓍵 𓍶 𓍷 𓍸☯⌘66(⚷⚙⚷Ni4Ti6)40Fc⚙37҈30҉33«»67Rt*51۞47Rc62Si*68)"
                + "(Fs61Ef30Ut69Tr66Ms40If53He*43Ai32Or55Vy36⬟⯂⬢⬣⯃⯄32Tt33Cc56Vu58Ao52))???144)"),
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
