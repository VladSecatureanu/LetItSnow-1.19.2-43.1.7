package net.sec.letitsnow;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.sec.letitsnow.world.biomemods.ModBiomeModifiers;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(LetItSnow.MOD_ID)
public class LetItSnow
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "letitsnow";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public LetItSnow()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBiomeModifiers.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
}
