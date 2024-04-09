package gregtech.common.metatileentities.multi.electric;

import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.client.renderer.texture.Textures;

import gregtech.common.blocks.BlockMetalCasing;

import gregtechfoodoption.client.GTFOClientHandler;
import gregtechfoodoption.client.GTFOGuiTextures;
import gregtechfoodoption.recipe.GTFORecipeMaps;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;

import org.jetbrains.annotations.NotNull;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.recipes.RecipeMaps;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.MetaBlocks;

import static gregtech.api.unification.material.Materials.Steel;
public class MetaTileEntityHotpot extends RecipeMapMultiblockController {

    public MetaTileEntityHotpot(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GTFORecipeMaps.HOTPOT_RECIPES);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity metaTileEntityHolder) {
        return new MetaTileEntityHotpot(this.metaTileEntityId);
    }

    @Override
    protected @NotNull BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("HXXXH", "HIIIH", "HIIIH", "HIIIH", "HXXXH")
                .aisle("XXXXX", "X X X", "X X X", "X X X", "X H X")
                .aisle("XXXXX", "X X X", "X X X", "X X X", "X H X")
                .aisle("XXXXX", "X X X", "X X X", "X X X", "X H X")
                .aisle("HXSXH", "HXXXH", "HXXXH", "HXXXH", "HXXXH")
                .where('S', selfPredicate())
                .where('X', states(getCasingState()))
                .where('H', states(getCasingState2()))
                .where('I', autoAbilities())
                .build();
    }

    private static IBlockState getCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID);
    }

    private static IBlockState getCasingState2() {
        return MetaBlocks.FRAMES.get(Steel).getBlock(Steel);
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.SOLID_STEEL_CASING;
    }

    @Override
    protected @NotNull OrientedOverlayRenderer getFrontOverlay() {
        return GTFOClientHandler.HOTPOT_OVERLAY;
    }
}
