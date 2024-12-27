package io.github.aleksandarharalanov.lockedchestfix;

import net.minecraft.server.Block;
import net.minecraft.server.BlockLockedChest;
import net.minecraft.server.StepSound;
import net.minecraft.server.World;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class CustomLockedChest extends BlockLockedChest {

    public CustomLockedChest(int i) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException {
        super(i);
        Method m = Block.class.getDeclaredMethod("c", float.class);
        m.setAccessible(true);
        m.invoke(this, 0.0F);
        m = Block.class.getDeclaredMethod("a", float.class);
        m.setAccessible(true);
        m.invoke(this, 1.0F);
        m = Block.class.getDeclaredMethod("a", StepSound.class);
        m.setAccessible(true);
        m.invoke(this, Block.e);
        m = Block.class.getDeclaredMethod("a", String.class);
        m.setAccessible(true);
        m.invoke(this, "lockedchest");
        m = Block.class.getDeclaredMethod("a", boolean.class);
        m.setAccessible(true);
        m.invoke(this, Boolean.TRUE);
        m = Block.class.getDeclaredMethod("g");
        m.setAccessible(true);
        m.invoke(this);
    }

    public void a(World world, int i, int j, int k, Random random) {}
}