package com.foxy.dmar;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InvseeCommand implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player))
      return false; 
    Player player = (Player)sender;
    if (!player.hasPermission(Main.permissions.getOrAddDefault("Main", "Main"))) {
      player.sendMessage(ChatColor.translateAlternateColorCodes('&', 
            String.valueOf(Main.messages.getOrAddDefault("prefix", "&8┃ &c&lDmar&4&lMc &8» ")) + Main.messages
            .getOrAddDefault("noPermission", "&cYou are lacking the permission&8: &6%permission%")
            .replace("%permission%", Main.permissions.getOrAddDefault("Main", "Main"))));
      return false;
    } 
    if (args.length != 1) {
      player.sendMessage(ChatColor.translateAlternateColorCodes('&', 
            String.valueOf(Main.messages.getOrAddDefault("prefix", "&8┃ &c&lDmar&4&lMc &8» ")) + Main.messages
            .getOrAddDefault("wrongSyntax", "&cWrong Syntax&8: &7Use&8: &6/invsee &cplayer")));
      return false;
    } 
    Player target = Bukkit.getPlayer(args[0]);
    if (target == null) {
      player.sendMessage(ChatColor.translateAlternateColorCodes('&', 
            String.valueOf(Main.messages.getOrAddDefault("prefix", "&8┃ &6&lDmar&e&lMc &8» ")) + Main.messages
            .getOrAddDefault("notOnline", "&cThe player %player% is not online.")
            .replace("%player%", args[0])));
      return false;
    } 
    player.openInventory((Inventory)target.getInventory());
    return false;
  }
}
