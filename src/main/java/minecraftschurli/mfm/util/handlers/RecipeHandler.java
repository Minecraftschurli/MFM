package minecraftschurli.mfm.util.handlers;

import minecraftschurli.mfm.init.BlockInit;
import minecraftschurli.mfm.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import net.minecraftforge.registries.GameData;

public class RecipeHandler {
    public static void addStandardRecipes() {
        //block
        RecipeHelper.addTwoWayStorageRecipe(new ItemStack(BlockInit.BLOCK_VULCANIUM), new ItemStack(ItemInit.INGOT_VULCANIUM));
        RecipeHelper.addTwoWayStorageRecipe(new ItemStack(BlockInit.BLOCK_KANADIUM), new ItemStack(ItemInit.INGOT_KANADIUM));
        RecipeHelper.addTwoWayStorageRecipe(new ItemStack(BlockInit.BLOCK_KANDIUM), new ItemStack(ItemInit.INGOT_KANDIUM));
        RecipeHelper.addTwoWayStorageRecipe(new ItemStack(BlockInit.BLOCK_OP), new ItemStack(ItemInit.INGOT_OP));
        RecipeHelper.addTwoWayStorageRecipe(new ItemStack(BlockInit.BLOCK_CRYSTAL), new ItemStack(ItemInit.GEM_CRYSTAL));
        RecipeHelper.addTwoWayStorageRecipe(new ItemStack(BlockInit.BLOCK_STANIUM), new ItemStack(ItemInit.GEM_STANIUM));
        RecipeHelper.addTwoWayStorageRecipe(new ItemStack(BlockInit.BLOCK_GODIUM), new ItemStack(ItemInit.INGOT_GODIUM));

        //nugget
        RecipeHelper.addTwoWayStorageRecipe(new ItemStack(ItemInit.INGOT_VULCANIUM), new ItemStack(ItemInit.NUGGET_VULCANIUM));
        RecipeHelper.addTwoWayStorageRecipe(new ItemStack(ItemInit.INGOT_KANADIUM), new ItemStack(ItemInit.NUGGET_KANADIUM));
        RecipeHelper.addTwoWayStorageRecipe(new ItemStack(ItemInit.INGOT_KANDIUM), new ItemStack(ItemInit.NUGGET_KANDIUM));
        RecipeHelper.addTwoWayStorageRecipe(new ItemStack(ItemInit.INGOT_OP), new ItemStack(ItemInit.NUGGET_OP));

        //smelting
        RecipeHelper.addSmelting(BlockInit.ORE_OVERWORLD_KANDIUM, new ItemStack(ItemInit.INGOT_KANDIUM, 1), 1F);
        RecipeHelper.addSmelting(BlockInit.ORE_NETHER_VULCANIUM, new ItemStack(ItemInit.INGOT_VULCANIUM, 1), 1F);
        RecipeHelper.addSmelting(BlockInit.ORE_OVERWORLD_CRYSTAL, new ItemStack(ItemInit.GEM_CRYSTAL, 1), 1F);
        RecipeHelper.addSmelting(BlockInit.ORE_END_CRYSTAL, new ItemStack(ItemInit.GEM_CRYSTAL, 1), 1F);
        RecipeHelper.addSmelting(BlockInit.ORE_NETHER_STANIUM, new ItemStack(ItemInit.GEM_STANIUM, 1), 1F);
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

            GameRegistry.addSmelting(input, output, xp);
        }

        static void addSmelting(Item input, ItemStack output, float xp) {

            GameRegistry.addSmelting(input, output, xp);
        }

        static void addSmelting(ItemStack input, ItemStack output, float xp) {

            GameRegistry.addSmelting(input, output, xp);
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
