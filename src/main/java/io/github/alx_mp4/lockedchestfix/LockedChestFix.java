package io.github.alx_mp4.lockedchestfix;

import io.github.alx_mp4.lockedchestfix.block.CustomLockedChest;
import io.github.alx_mp4.lockedchestfix.util.log.LogUtil;
import io.github.alx_mp4.lockedchestfix.util.log.UpdateUtil;
import net.minecraft.server.Block;
import org.bukkit.plugin.java.JavaPlugin;

public class LockedChestFix extends JavaPlugin {

    @Override
    public void onEnable() {
        UpdateUtil.checkAvailablePluginUpdates(this, "https://api.github.com/repos/alx-mp4/LockedChestFix/releases/latest");

        try {
            Block.byId[Block.LOCKED_CHEST.id] = null;
            final CustomLockedChest customLockedChest = new CustomLockedChest(Block.LOCKED_CHEST.id);
            Block.byId[Block.LOCKED_CHEST.id] = customLockedChest;
        } catch (Exception e) {
            Block.byId[Block.LOCKED_CHEST.id] = Block.LOCKED_CHEST;
            LogUtil.logConsoleSevere(String.format("[%s] Could not register custom block class: %s", getDescription().getName(), e));
        }

        LogUtil.logConsoleInfo(String.format("[%s] v%s Enabled.", getDescription().getName(), getDescription().getVersion()));
    }

    @Override
    public void onDisable() {
        Block.byId[Block.LOCKED_CHEST.id] = Block.LOCKED_CHEST;
        LogUtil.logConsoleInfo(String.format("[%s] v%s Disabled.", getDescription().getName(), getDescription().getVersion()));
    }
}
