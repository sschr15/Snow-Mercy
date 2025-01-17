package ladysnake.snowmercy.common;

import ladysnake.snowmercy.common.command.SnowMercyCommand;
import ladysnake.snowmercy.common.init.*;
import ladysnake.snowmercy.common.utils.RandomSpawnCollection;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import software.bernie.geckolib3.GeckoLib;

public class SnowMercy implements ModInitializer {
    public static final String MODID = "snowmercy";
    public static final Identifier WINTER_MURDERLAND_ID = new Identifier(MODID, "winter_murderland");
    public static final RegistryKey<World> WINTER_MURDERLAND = RegistryKey.of(Registry.WORLD_KEY, SnowMercy.WINTER_MURDERLAND_ID);
    private static final RandomSpawnCollection<EntityType<? extends LivingEntity>> SPAWN_CANDIDATES = new RandomSpawnCollection<>();

    public static Identifier id(String path) {
        return new Identifier(MODID, path);
    }

    @Override
    public void onInitialize() {
        GeckoLib.initialize();

        SnowMercyBlocks.init();
        SnowMercyItems.init();
        SnowMercyEntities.init();
        SnowMercyFeatures.init();
        SnowMercySoundEvents.init();
        SnowMercyWaves.init();

        // spawn sculk catalysts around players
//        ServerTickEvents.END_SERVER_TICK.register(server -> {
//            server.getWorlds().forEach(world -> {
//                for (ServerPlayerEntity player : world.getPlayers()) {
//                    if (world.getEntitiesByClass(IceHeartEntity.class, player.getBoundingBox().expand(200f), iceHeartEntity -> true).isEmpty()) {
//                        int radius = 50;
//
//                        BlockPos placePos = player.getBlockPos().add(Math.round(world.random.nextGaussian() * radius), 64, Math.round(world.random.nextGaussian() * radius));
//
//                        while (placePos.getY() > 1 &&
//                                !(world.getBlockState(placePos).isSolidBlock(world, placePos))) {
//                            placePos = placePos.add(0, -1, 0);
//                        }
//
//                        if (world.getBlockState(placePos.add(0, 5, 0)).isAir()) {
//                            IceHeartEntity iceHeartEntity = SnowMercyEntities.HEART_OF_ICE.create(world);
//                            iceHeartEntity.refreshPositionAndAngles(placePos.getX(), placePos.getY()+5, placePos.getZ(), 0, 0);
//                            world.spawnEntity(iceHeartEntity);
//                        }
//                    }
//                }
//            });
//        });
    }
}
