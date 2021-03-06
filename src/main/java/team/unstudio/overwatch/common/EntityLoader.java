package team.unstudio.overwatch.common;

import team.unstudio.overwatch.client.render.LandmineRender;
import team.unstudio.overwatch.entity.DartEntity;
import team.unstudio.overwatch.entity.KuangShuZDEntity;
import team.unstudio.overwatch.client.render.DartModelRender;
import team.unstudio.overwatch.client.render.KuangShuZDRrender;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import team.unstudio.overwatch.entity.LandmineEntity;

/**
 * Created by winston_wang on 2017/1/22.
 */
public class EntityLoader {
    public  EntityLoader(FMLInitializationEvent event)
    {
        register(DartEntity.class, "dart");
        register(KuangShuZDEntity.class, "kuangshuzd");
        register(LandmineEntity.class,"landmine");
    }
    @SideOnly(Side.CLIENT)
    public static void registerRenders(){
        RenderingRegistry.registerEntityRenderingHandler(DartEntity.class, new DartModelRender());
        RenderingRegistry.registerEntityRenderingHandler(KuangShuZDEntity.class, new KuangShuZDRrender());
        RenderingRegistry.registerEntityRenderingHandler(LandmineEntity.class, new LandmineRender());
    }
    static int nextEntityID = 0;
    private void register(Class<? extends Entity> entityClass, String name) {
        EntityRegistry.registerModEntity(entityClass, name, ++nextEntityID, OverWatch.instance, 32, 3, true);
    }
}
