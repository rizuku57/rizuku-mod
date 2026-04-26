public class ExampleGuardianItem extends Item {
    public ExampleGuardianItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof PlayerEntity player) {
            // Если предмет НЕ выбран в руке (selected == false)
            if (!selected) {
                // Проверяем, есть ли эффекты от этого предмета
                if (player.hasStatusEffect(StatusEffects.INVISIBILITY)) {
                    player.removeStatusEffect(StatusEffects.INVISIBILITY);
                    player.removeStatusEffect(StatusEffects.RESISTANCE);
                    player.removeStatusEffect(StatusEffects.WEAKNESS);
                }
            }
        }
    }
}
21:37





