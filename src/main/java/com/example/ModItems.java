package java

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item DEAD_RINGER  = new GuardianItem(new Item.Settings().maxCount(1));

    public static void register() {

        Registry.register(Registries.Item, new Identifler("example", "dead_ringer"), DEAD_RINGER);
    }
}