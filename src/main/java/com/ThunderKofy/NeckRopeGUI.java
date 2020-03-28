package com.ThunderKofy;

import com.ThunderKofy.Commands.NeckRopeGUICommandsTabCompleter;
import com.ThunderKofy.Events.SuicideSelectEvent;
import com.ThunderKofy.Commands.NeckRopeGUICommands;
import com.ThunderKofy.Commands.SuicideCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class NeckRopeGUI extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Thanks for having me as a plugin at your server :)");
        getServer().getPluginManager().registerEvents(new SuicideSelectEvent(this), this);
        getCommand("neckropegui").setExecutor(new NeckRopeGUICommands(this));
        getCommand("neckropegui").setTabCompleter(new NeckRopeGUICommandsTabCompleter());
        getCommand("suicide").setExecutor(new SuicideCommand());
        saveDefaultConfig();
    }
    @Override
    public void onDisable() {
        getLogger().info("Goodbye!");
    }
}
