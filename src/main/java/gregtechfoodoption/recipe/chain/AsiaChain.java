package gregtechfoodoption.recipe.chain;

import gregtechfoodoption.GTFOMaterialHandler;
import gregtechfoodoption.item.GTFOMetaItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtechfoodoption.GTFOMaterialHandler.*;
import static gregtechfoodoption.item.GTFOMetaItem.*;
import static gregtechfoodoption.recipe.GTFORecipeMaps.HOTPOT_RECIPES;
import static gregtechfoodoption.recipe.GTFORecipeMaps.MULTICOOKER_RECIPES;

public class AsiaChain {
    public static void init() {
        componentRecipes();
        msgRecipes();
        foodRecipes();
        hotpotRecipes();
    }

    public static void componentRecipes() {
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(BoneChinaClay.getItemStack(8))
                .fluidInputs(Water.getFluid(2000))
                .outputs(UNFIRED_DEEP_BOWL.getStackForm(1))
                .EUt(16)
                .duration(120)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .inputs(UNFIRED_DEEP_BOWL.getStackForm(1))
                .input(dust, Glass, 2)
                .outputs(DEEP_BOWL.getStackForm(1))
                .EUt(120)
                .duration(800)
                .blastFurnaceTemp(1600)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .inputs(DIRTY_DEEP_BOWL.getStackForm(1))
                .fluidInputs(Water.getFluid(4000))
                .outputs(DEEP_BOWL.getStackForm(1))
                .EUt(8)
                .duration(800)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .inputs(DIRTY_DEEP_BOWL.getStackForm(1))
                .fluidInputs(SodiumStearate.getFluid(200))
                .outputs(DEEP_BOWL.getStackForm(1))
                .EUt(16)
                .duration(100)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Steel, 8)
                .input(ring, Steel, 2)
                .input(plate, Rubber, 2)
                .input(screw, Steel, 4)
                .outputs(UNSEASONED_WOK.getStackForm(1))
                .EUt(16)
                .duration(200)
                .buildAndRegister();

        MULTICOOKER_RECIPES.recipeBuilder()
                .inputs(UNSEASONED_WOK.getStackForm(1))
                .fluidInputs(OliveOil.getFluid(300))
                .outputs(WOK.getStackForm(1))
                .EUt(16)
                .duration(400)
                .buildAndRegister();
    }

    public static void msgRecipes() {
        MACERATOR_RECIPES.recipeBuilder()
                .inputs(CASSAVA.getStackForm(1))
                .outputs(CASSAVA_PULP.getItemStack(4))
                .EUt(8)
                .duration(400)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .inputs(CASSAVA_PULP.getItemStack(2))
                .inputs(CornKernel.getItemStack(4))
                .input(dust, Sugar, 6)
                .outputs(MSG_FERMENTATION_MIXTURE.getItemStack(5))
                .EUt(16)
                .duration(400)
                .buildAndRegister();

        FERMENTING_RECIPES.recipeBuilder()
                .inputs(MSG_FERMENTATION_MIXTURE.getItemStack(5))
                .fluidInputs(Water.getFluid(4000))
                .fluidOutputs(MSG_mixture.getFluid(4000))
                .EUt(16)
                .duration(400)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(MSG_mixture.getFluid(4000))
                .fluidOutputs(Water.getFluid(4000))
                .outputs(MSG.getItemStack(1))
                .EUt(16)
                .duration(400)
                .buildAndRegister();
    }

    public static void foodRecipes() {
        CUTTER_RECIPES.recipeBuilder()
                .inputs(TARO.getStackForm(1))
                .outputs(SLICED_TARO.getStackForm(2))
                .EUt(16)
                .duration(400)
                .buildAndRegister();

        MULTICOOKER_RECIPES.recipeBuilder()
                .inputs(SLICED_TARO.getStackForm(1))
                .fluidInputs(Water.getFluid(4000))
                .outputs(BOILED_TARO_SLICES.getStackForm(1))
                .EUt(16)
                .duration(400)
                .buildAndRegister();
    }

    public static void hotpotRecipes() {
        HOTPOT_RECIPES.recipeBuilder()
                .inputs(DRIED_SICHUAN_PEPPER.getStackForm(5))
                .inputs(CHILI_PEPPER.getStackForm(2))
                .fluidInputs(Water.getFluid(3000))
                .fluidOutputs(SichuanHotPot.getFluid(2000))
                .EUt(32)
                .duration(600)
                .buildAndRegister();
    }


}
