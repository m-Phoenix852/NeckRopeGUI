package com.ThunderKofy.Commands;

import com.ThunderKofy.NeckRopeGUI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class NeckRopeGUICommands implements CommandExecutor {
    private Plugin plugin;
    public NeckRopeGUICommands(NeckRopeGUI plugin) {this.plugin = plugin;}

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length == 0) {
            if(!sender.hasPermission("NeckRopeGUI.main")) return true;
            sender.sendMessage(ChatColor.GREEN + "NeckRopeGUI from ThunderKofy.");
            sender.sendMessage("Version: " + plugin.getDescription().getVersion());
            sender.sendMessage("Developed by " + ChatColor.YELLOW + "Phoenix852 | ThunderKofy");
            sender.sendMessage("If you have any issues regarding this plugin, join our discord: " + ChatColor.BLUE + plugin.getDescription().getWebsite());
            return true;
        } else if(args[0].equalsIgnoreCase("help")) {
            if(!sender.hasPermission("NeckRopeGUI.help")) return true;
            sender.sendMessage(ChatColor.GREEN + "/NeckRopeGUI" + ChatColor.WHITE + " --> Shows the description of the plugin.");
            sender.sendMessage(ChatColor.GREEN + "/NeckRopeGUI reload" + ChatColor.WHITE + " --> Reloads NeckRopeGUI configurations.");
            sender.sendMessage(ChatColor.GREEN + "/Suicide" + ChatColor.WHITE + " --> Opens up the Suicidal Menu");
            sender.sendMessage(ChatColor.GREEN + "/NeckRopeGUI author" + ChatColor.WHITE + " --> Shows the author description.");
            return true;
        } else if(args[0].equalsIgnoreCase("reload")) {
            if(!sender.hasPermission("NeckRopeGUI.reload")) return true;
            plugin.saveDefaultConfig();
            plugin.reloadConfig();
            sender.sendMessage("[NeckRopeGUI] Config reloaded!");
            return true;
        } else if(args[0].equalsIgnoreCase("author")) {
            if(!sender.hasPermission("NeckRopeGUI.author")) return true;
            sender.sendMessage("Developed by " + ChatColor.YELLOW + "Phoenix852");
            return true;
        } else {
            sender.sendMessage(ChatColor.RED + "Unknown command!");
            sender.sendMessage("To see the list of commands and their description, use the " + ChatColor.YELLOW + " /NeckRopeGUI help " + ChatColor.WHITE + "command!");
        }
        return true;
    }
}
