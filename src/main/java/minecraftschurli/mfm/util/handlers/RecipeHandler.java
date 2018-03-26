package minecraftschurli.mfm.util.handlers;

import minecraftschurli.mfm.init.BlockInit;
import minecraftschurli.mfm.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import net.minecraftforge.registries.GameData;

public class RecipeHandler {
    public static void addStandardRecipes() {

        /* block */
        RecipeHelper.addTwoWayStorageRecipe(cloneStack(BlockInit.BLOCK_VULCANIUM, 1), cloneStack(ItemInit.INGOT_VULCANIUM, 1));
        RecipeHelper.addTwoWayStorageRecipe(cloneStack(BlockInit.BLOCK_KANADIUM, 1), cloneStack(ItemInit.INGOT_KANADIUM, 1));
        RecipeHelper.addTwoWayStorageRecipe(cloneStack(BlockInit.BLOCK_KANDIUM, 1), cloneStack(ItemInit.INGOT_KANDIUM, 1));
        RecipeHelper.addTwoWayStorageRecipe(cloneStack(BlockInit.BLOCK_OP, 1), cloneStack(ItemInit.INGOT_OP, 1));
        RecipeHelper.addTwoWayStorageRecipe(cloneStack(BlockInit.BLOCK_CRYSTAL, 1), cloneStack(ItemInit.GEM_CRYSTAL, 1));
        RecipeHelper.addTwoWayStorageRecipe(cloneStack(BlockInit.BLOCK_STANIUM, 1), cloneStack(ItemInit.GEM_STANIUM, 1));
        RecipeHelper.addTwoWayStorageRecipe(cloneStack(BlockInit.BLOCK_GODIUM, 1), cloneStack(ItemInit.INGOT_GODIUM, 1));

        /* nugget */
        RecipeHelper.addTwoWayStorageRecipe(cloneStack(ItemInit.INGOT_VULCANIUM, 1), cloneStack(ItemInit.NUGGET_VULCANIUM, 1));
        RecipeHelper.addTwoWayStorageRecipe(cloneStack(ItemInit.INGOT_KANADIUM, 1), cloneStack(ItemInit.NUGGET_KANADIUM, 1));
        RecipeHelper.addTwoWayStorageRecipe(cloneStack(ItemInit.INGOT_KANDIUM, 1), cloneStack(ItemInit.NUGGET_KANDIUM, 1));
        RecipeHelper.addTwoWayStorageRecipe(cloneStack(ItemInit.INGOT_OP, 1), cloneStack(ItemInit.NUGGET_OP, 1));

        /*  */
        RecipeHelper.addShapedRecipe(cloneStack(ItemInit.HORSE_ARMOR_GODIUM, 1), "H  ", "CWI", "L L", 'H', cloneStack(ItemInit.HELMET_GODIUM, 1), 'C', cloneStack(ItemInit.CHESTPLATE_GODIUM, 1), 'L', cloneStack(ItemInit.LEGGINGS_GODIUM, 1), 'I', cloneStack(ItemInit.INGOT_GODIUM, 1), 'W', cloneStack(Blocks.WOOL.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.RED).getBlock(), 1));

        /* armor */
        RecipeHelper.addShapedRecipe(cloneStack(ItemInit.BOOTS_OP, 1), "I I", "ICI", 'I', cloneStack(ItemInit.INGOT_OP, 1), 'C', cloneStack(ItemInit.ITEM_CORE, 1));
        RecipeHelper.addShapedRecipe(cloneStack(ItemInit.LEGGINGS_OP, 1), "III", "ICI", "I I", 'I', cloneStack(ItemInit.INGOT_OP, 1), 'C', cloneStack(ItemInit.ITEM_CORE, 1));
        RecipeHelper.addShapedRecipe(cloneStack(ItemInit.CHESTPLATE_OP, 1), "ICI", "IEI", "III", 'I', cloneStack(ItemInit.INGOT_OP, 1), 'C', cloneStack(ItemInit.ITEM_CORE, 1), 'E', cloneStack(Items.ELYTRA, 1));
        RecipeHelper.addShapedRecipe(cloneStack(ItemInit.HELMET_OP, 1), "III", "ICI", 'I', cloneStack(ItemInit.INGOT_OP, 1), 'C', cloneStack(ItemInit.ITEM_CORE, 1));

        RecipeHelper.addShapedRecipe(cloneStack(ItemInit.BOOTS_VULCANIUM, 1), "I I", "I I", 'I', cloneStack(ItemInit.INGOT_VULCANIUM, 1));
        RecipeHelper.addShapedRecipe(cloneStack(ItemInit.LEGGINGS_VULCANIUM, 1), "III", "I I", "I I", 'I', cloneStack(ItemInit.INGOT_VULCANIUM, 1));
        RecipeHelper.addShapedRecipe(cloneStack(ItemInit.CHESTPLATE_VULCANIUM, 1), "I I", "ISI", "III", 'I', cloneStack(ItemInit.INGOT_VULCANIUM, 1), 'S', cloneStack(ItemInit.GEM_FIRE, 1));
        RecipeHelper.addShapedRecipe(cloneStack(ItemInit.HELMET_VULCANIUM, 1), "III", "I I", 'I', cloneStack(ItemInit.INGOT_VULCANIUM, 1));

        RecipeHelper.addShapedRecipe(cloneStack(ItemInit.BOOTS_KANDIUM, 1), "I I", "I I", 'I', cloneStack(ItemInit.INGOT_KANDIUM, 1));
        RecipeHelper.addShapedRecipe(cloneStack(ItemInit.LEGGINGS_KANDIUM, 1), "III", "I I", "I I", 'I', cloneStack(ItemInit.INGOT_KANDIUM, 1));
        RecipeHelper.addShapedRecipe(cloneStack(ItemInit.CHESTPLATE_KANDIUM, 1), "I I", "III", "III", 'I', cloneStack(ItemInit.INGOT_KANDIUM, 1));
        RecipeHelper.addShapedRecipe(cloneStack(ItemInit.HELMET_KANDIUM, 1), "III", "I I", 'I', cloneStack(ItemInit.INGOT_KANDIUM, 1));

        RecipeHelper.addShapedRecipe(cloneStack(ItemInit.BOOTS_KANADIUM, 1), "I I", "I I", 'I', cloneStack(ItemInit.INGOT_KANADIUM, 1));
        RecipeHelper.addShapedRecipe(cloneStack(ItemInit.LEGGINGS_KANADIUM, 1), "III", "I I", "I I", 'I', cloneStack(ItemInit.INGOT_KANADIUM, 1));
        RecipeHelper.addShapedRecipe(cloneStack(ItemInit.CHESTPLATE_KANADIUM, 1), "I I", "IKI", "III", 'I', cloneStack(ItemInit.INGOT_KANADIUM, 1), 'K', cloneStack(ItemInit.CHESTPLATE_KANDIUM, 1));
        RecipeHelper.addShapedRecipe(cloneStack(ItemInit.HELMET_KANADIUM, 1), "III", "I I", 'I', cloneStack(ItemInit.INGOT_KANADIUM, 1));

        RecipeHelper.addShapedRecipe(cloneStack(ItemInit.BOOTS_GODIUM, 1), "I I", "I I", 'I', cloneStack(ItemInit.INGOT_GODIUM, 1));
        RecipeHelper.addShapedRecipe(cloneStack(ItemInit.LEGGINGS_GODIUM, 1), "III", "I I", "I I", 'I', cloneStack(ItemInit.INGOT_GODIUM, 1));
        RecipeHelper.addShapedRecipe(cloneStack(ItemInit.CHESTPLATE_GODIUM, 1), "I I", "VOK", "III", 'I', cloneStack(ItemInit.INGOT_GODIUM, 1), 'V', cloneStack(ItemInit.CHESTPLATE_VULCANIUM, 1), 'O', cloneStack(ItemInit.CHESTPLATE_OP, 1), 'K', cloneStack(ItemInit.CHESTPLATE_KANADIUM, 1));
        RecipeHelper.addShapedRecipe(cloneStack(ItemInit.HELMET_GODIUM, 1), "III", "I I", 'I', cloneStack(ItemInit.INGOT_GODIUM, 1));

        /*  */
        RecipeHelper.addShapedRecipe(cloneStack(ItemInit.HANDLE, 1), "   ", "I  ", "RI ", 'R', "rodIron", 'I', "ingotIron");
        RecipeHelper.addShapedRecipe(cloneStack(ItemInit.GEM_FIRE, 1), " S ", "SGS", " S ", 'S', cloneStack(ItemInit.GEM_STANIUM, 1), 'G', cloneStack(ItemInit.GEM_CRYSTAL, 1));
        RecipeHelper.addShapedRecipe(cloneStack(ItemInit.GEM_SEADIAMOND, 1), " S ", "SDS", " S ", 'S', cloneStack(Items.PRISMARINE_SHARD, 1), 'D', cloneStack(Items.DIAMOND, 1));
        RecipeHelper.addShapedRecipe(cloneStack(ItemInit.ITEM_CORE, 1), " D ", "DND", " D ", 'N', cloneStack(Items.NETHER_STAR, 1), 'D', cloneStack(Blocks.DIAMOND_BLOCK, 1));
        RecipeHelper.addShapedRecipe(cloneStack(ItemInit.ITEM_WHIRLEWIND, 1), "CL ", "L L", " LI", 'C', cloneStack(ItemInit.ITEM_CORE, 1), 'I', cloneStack(ItemInit.INGOT_OP, 1), 'L', cloneStack(Items.LEATHER, 1));
        RecipeHelper.addShapedRecipe(cloneStack(ItemInit.SHIELD_GODIUM, 1), "III", "ISI", " I ", 'I', cloneStack(ItemInit.INGOT_GODIUM, 1), 'S', cloneStack(Items.SHIELD, 1));

        /* smelting */
        RecipeHelper.addSmelting(BlockInit.ORE_OVERWORLD_KANDIUM, cloneStack(ItemInit.INGOT_KANDIUM, 1), 1F);
        RecipeHelper.addSmelting(BlockInit.ORE_NETHER_VULCANIUM, cloneStack(ItemInit.INGOT_VULCANIUM, 1), 1F);
        RecipeHelper.addSmelting(BlockInit.ORE_OVERWORLD_CRYSTAL, cloneStack(ItemInit.GEM_CRYSTAL, 1), 1F);
        RecipeHelper.addSmelting(BlockInit.ORE_END_CRYSTAL, cloneStack(ItemInit.GEM_CRYSTAL, 1), 1F);
        RecipeHelper.addSmelting(BlockInit.ORE_NETHER_STANIUM, cloneStack(ItemInit.GEM_STANIUM, 1), 1F);
    }

    public static ItemStack cloneStack(Item item, int stackSize) {

        if (item == null) {
            return ItemStack.EMPTY;
        }
        return new ItemStack(item, stackSize);
    }

    public static ItemStack cloneStack(Block block, int stackSize) {

        if (block == null) {
            return ItemStack.EMPTY;
        }
        return new ItemStack(block, stackSize);
    }

    public static ItemStack cloneStack(ItemStack stack, int stackSize) {

        if (stack.isEmpty()) {
            return ItemStack.EMPTY;
        }
        ItemStack retStack = stack.copy();
        retStack.setCount(stackSize);

        return retStack;
    }

    public static ItemStack cloneStack(ItemStack stack) {

        return stack.isEmpty() ? ItemStack.EMPTY : stack.copy();
    }

    public static class RecipeHelper {

        /* GENERAL */
        static void addShapedRecipe(ItemStack output, Object... input) {

            ResourceLocation location = getNameForRecipe(output);
            CraftingHelper.ShapedPrimer primer = CraftingHelper.parseShaped(input);
            ShapedRecipes recipe = new ShapedRecipes(output.getItem().getRegistryName().toString(), primer.width, primer.height, primer.input, output);
            recipe.setRegistryName(location);
            GameData.register_impl(recipe);
        }

        public static void addShapedOreRecipe(ItemStack output, Object... input) {

            ResourceLocation location = getNameForRecipe(output);
            ShapedOreRecipe recipe = new ShapedOreRecipe(location, output, input);
            recipe.setRegistryName(location);
            GameData.register_impl(recipe);
        }

        public static void addShapelessRecipe(ItemStack output, Object... input) {

            ResourceLocation location = getNameForRecipe(output);
            ShapelessRecipes recipe = new ShapelessRecipes(location.getResourceDomain(), output, buildInput(input));
            recipe.setRegistryName(location);
            GameData.register_impl(recipe);
        }

        public static void addShapelessOreRecipe(ItemStack output, Object... input) {

            ResourceLocation location = getNameForRecipe(output);
            ShapelessOreRecipe recipe = new ShapelessOreRecipe(location, output, input);
            recipe.setRegistryName(location);
            GameData.register_impl(recipe);
        }

        /* STORAGE */
        static void addStorageRecipe(ItemStack one, String nine) {

            addShapedRecipe(one, "XXX", "XXX", "XXX", 'X', nine);
        }

        static void addStorageRecipe(ItemStack one, ItemStack nine) {

            addShapedRecipe(one, "XXX", "XXX", "XXX", 'X', cloneStack(nine, 1));
        }

        static void addSmallStorageRecipe(ItemStack one, String four) {

            addShapedRecipe(one, "XX", "XX", 'X', four);
        }

        static void addSmallStorageRecipe(ItemStack one, ItemStack four) {

            addShapedRecipe(cloneStack(one), "XX", "XX", 'X', cloneStack(four, 1));
        }

        static void addReverseStorageRecipe(ItemStack nine, String one) {

            addShapelessRecipe(cloneStack(nine, 9), one);
        }

        static void addReverseStorageRecipe(ItemStack nine, ItemStack one) {

            addShapelessRecipe(cloneStack(nine, 9), cloneStack(one, 1));
        }

        static void addSmallReverseStorageRecipe(ItemStack four, String one) {

            addShapelessRecipe(cloneStack(four, 4), one);
        }

        static void addSmallReverseStorageRecipe(ItemStack four, ItemStack one) {

            addShapelessRecipe(cloneStack(four, 4), cloneStack(one, 1));
        }

        public static void addTwoWayStorageRecipe(ItemStack one, ItemStack nine) {

            addStorageRecipe(one, nine);
            addReverseStorageRecipe(nine, one);
        }

        public static void addTwoWayStorageRecipe(ItemStack one, String one_ore, ItemStack nine, String nine_ore) {

            addStorageRecipe(one, nine_ore);
            addReverseStorageRecipe(nine, one_ore);
        }

        public static void addSmallTwoWayStorageRecipe(ItemStack one, ItemStack four) {

            addSmallStorageRecipe(one, four);
            addSmallReverseStorageRecipe(four, one);
        }

        public static void addSmallTwoWayStorageRecipe(ItemStack one, String one_ore, ItemStack four, String four_ore) {

            addSmallStorageRecipe(one, four_ore);
            addSmallReverseStorageRecipe(four, one_ore);
        }

        /* TOOLS */
        public static void addAxeRecipe(ItemStack axe, ItemStack headMat, ItemStack handleMat) {

            addShapedRecipe(axe, "XX ", "XS ", " S ", 'X', cloneStack(headMat, 1), 'S', cloneStack(handleMat, 1));
            addShapedRecipe(axe, " XX", " SX", " S ", 'X', cloneStack(headMat, 1), 'S', cloneStack(handleMat, 1));
        }

        public static void addAxeRecipe(ItemStack axe, String headMat, String handleMat) {

            addShapedRecipe(axe, "XX ", "XS ", " S ", 'X', headMat, 'S', handleMat);
            addShapedRecipe(axe, " XX", " SX", " S ", 'X', headMat, 'S', handleMat);
        }

        public static void addPickaxeRecipe(ItemStack axe, ItemStack headMat, ItemStack handleMat) {

            addShapedRecipe(axe, "XXX", " S ", " S ", 'X', cloneStack(headMat, 1), 'S', cloneStack(handleMat, 1));
        }

        public static void addPickaxeRecipe(ItemStack axe, String headMat, String handleMat) {

            addShapedRecipe(axe, "XXX", " S ", " S ", 'X', headMat, 'S', handleMat);
        }

        public static void addSwordRecipe(ItemStack axe, ItemStack headMat, ItemStack handleMat) {

            addShapedRecipe(axe, "X", "X", "S", 'X', cloneStack(headMat, 1), 'S', cloneStack(handleMat, 1));
        }

        public static void addSwordRecipe(ItemStack axe, String headMat, String handleMat) {

            addShapedRecipe(axe, "X", "X", "S", 'X', headMat, 'S', handleMat);
        }

        public static void addShovelRecipe(ItemStack axe, ItemStack headMat, ItemStack handleMat) {

            addShapedRecipe(axe, " X ", " S ", " S ", 'X', cloneStack(headMat, 1), 'S', cloneStack(handleMat, 1));
        }

        public static void addShovelRecipe(ItemStack axe, String headMat, String handleMat) {

            addShapedRecipe(axe, " X ", " S ", " S ", 'X', headMat, 'S', handleMat);
        }

        /* HELPERS */
        static ResourceLocation getNameForRecipe(ItemStack output) {

            ModContainer activeContainer = Loader.instance().activeModContainer();
            ResourceLocation baseLoc = new ResourceLocation(activeContainer.getModId(), output.getItem().getRegistryName().getResourcePath());
            ResourceLocation recipeLoc = baseLoc;
            int index = 0;
            while (CraftingManager.REGISTRY.containsKey(recipeLoc)) {
                index++;
                recipeLoc = new ResourceLocation(activeContainer.getModId(), baseLoc.getResourcePath() + "_" + index);
            }
            return recipeLoc;
        }

        static NonNullList<Ingredient> buildInput(Object[] input) {

            NonNullList<Ingredient> list = NonNullList.create();

            for (Object obj : input) {
                if (obj instanceof Ingredient) {
                    list.add((Ingredient) obj);
                } else {
                    Ingredient ingredient = CraftingHelper.getIngredient(obj);

                    if (ingredient == null) {
                        ingredient = Ingredient.EMPTY;
                    }
                    list.add(ingredient);
                }
            }
            return list;
        }

        /* SMELTING */
        static void addSmelting(Block input, ItemStack output, float xp) {
            FurnaceRecipes.instance().addSmeltingRecipeForBlock(input, output, xp);
        }

        static void addSmelting(Item input, ItemStack output, float xp) {
            FurnaceRecipes.instance().addSmelting(input, output, xp);
        }

        static void addSmelting(ItemStack input, ItemStack output, float xp) {
            FurnaceRecipes.instance().addSmeltingRecipe(input, output, xp);
        }

        public static void addSmelting(ItemStack input, ItemStack output) {

            addSmelting(input, output, 0F);
        }

        public static void addSmelting(Item input, ItemStack output) {

            addSmelting(input, output, 0F);
        }

        public static void addSmelting(Block input, ItemStack output) {

            addSmelting(input, output, 0F);
        }

    }
}
