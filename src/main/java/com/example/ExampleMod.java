package com.example;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	public static final String MOD_ID = "modid";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {@Override
    public void onInitialize() {
        // 1. Сначала вызываем регистрацию предметов
        ModItems.registerModItems(); 

        // 2. Сразу под ней вставляем логику "Звона смерти"
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, source, amount) -> {
            if (entity instanceof PlayerEntity player) {
                // Проверяем, держит ли игрок твой Guardian предмет
                if (player.getMainHandStack().getItem() instanceof ExampleGuardianItem) {
                    
                    // Выдаем эффекты
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 100, 5, false, false, true));
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 100, 0, false, false, true));
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 100, 255, false, false, true));

                    return false; // ОТМЕНЯЕМ УРОН
                }
            }
            return true; // В остальных случаях урон разрешен
        });
    }
21:48






		
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
	}
}