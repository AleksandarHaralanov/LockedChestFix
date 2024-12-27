package io.github.aleksandarharalanov.lockedchestfix;

import net.minecraft.server.Block;
import org.bukkit.plugin.java.JavaPlugin;

import static io.github.aleksandarharalanov.lockedchestfix.util.LoggerUtil.logInfo;
import static io.github.aleksandarharalanov.lockedchestfix.util.LoggerUtil.logSevere;
import static io.github.aleksandarharalanov.lockedchestfix.util.UpdateUtil.checkForUpdates;

public class LockedChestFix extends JavaPlugin {
    public void onEnable() {
        checkForUpdates(this, "https://api.github.com/repos/AleksandarHaralanov/LockedChestFix/releases/latest");

        try {
            Block.byId[Block.LOCKED_CHEST.id] = null;
            CustomLockedChest custom = new CustomLockedChest(Block.LOCKED_CHEST.id);
            Block.byId[Block.LOCKED_CHEST.id] = custom;
        } catch (Exception e) {
            Block.byId[Block.LOCKED_CHEST.id] = Block.LOCKED_CHEST;
            logSevere(String.format("[%s] Could not register custom block class: %s", getDescription().getName(), e));
        }

        logInfo(String.format("[%s] v%s Enabled.", getDescription().getName(), getDescription().getVersion()));
    }

    public void onDisable() {
        Block.byId[Block.LOCKED_CHEST.id] = Block.LOCKED_CHEST;
        logInfo(String.format("[%s] v%s Disabled.", getDescription().getName(), getDescription().getVersion()));
    }
}
