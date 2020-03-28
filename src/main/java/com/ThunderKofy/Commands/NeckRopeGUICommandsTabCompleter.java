package com.ThunderKofy.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class NeckRopeGUICommandsTabCompleter implements TabCompleter {
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        if(args.length == 1) {
            List<String> list = new ArrayList<String>();
            list.add("help");
            list.add("reload");
            list.add("author");
            return list;
        }
        return null;
    }
}
