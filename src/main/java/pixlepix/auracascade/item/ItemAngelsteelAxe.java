package pixlepix.auracascade.item;

import net.minecraft.init.Items;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import pixlepix.auracascade.registry.BlockRegistry;
import pixlepix.auracascade.registry.CraftingBenchRecipe;
import pixlepix.auracascade.registry.ITTinkererItem;
import pixlepix.auracascade.registry.ThaumicTinkererRecipe;

import java.util.ArrayList;

/**
 * Created by pixlepix on 12/22/14.
 */
public class ItemAngelsteelAxe extends ItemAxe implements ITTinkererItem {
    public ItemAngelsteelAxe(Integer i) {
        super(AngelsteelToolHelper.materials[i.intValue()]);
        this.degree = i.intValue();
    }

    public ItemAngelsteelAxe() {
        this(0);
    }

    @Override
    public ArrayList<Object> getSpecialParameters() {
        return AngelsteelToolHelper.getDegreeList(true);
    }

    public int degree = 0;

    public static final String name = "angelsteelAxe";

    @Override
    public String getItemName() {
        return name + degree;
    }

    @Override
    public boolean shouldRegister() {
        return true;
    }

    @Override
    public boolean shouldDisplayInTab() {
        return degree == 0 || degree == AngelsteelToolHelper.MAX_DEGREE;
    }

    @Override
    public ThaumicTinkererRecipe getRecipeItem() {

        return new CraftingBenchRecipe(new ItemStack(this, 1, degree), "AA ", "AS ", " S ", 'A', new ItemStack(BlockRegistry.getFirstItemFromClass(ItemAngelsteelIngot.class), 1, degree), 'S', new ItemStack(Items.stick));
    }
}
