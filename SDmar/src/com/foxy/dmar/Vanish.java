package com.foxy.dmar;


import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Vanish implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (cmd.getName().equalsIgnoreCase("discord") && 
      sender instanceof Player) {
      Player player = (Player)sender;
      TextComponent top7message = new TextComponent("§8┃      ");
      top7message.setColor(ChatColor.GRAY);
      TextComponent top7 = new TextComponent("§8  ");
      top7.setColor(ChatColor.GREEN);
      top7.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "Click to top")).create()));
      top7.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/s"));
      player.spigot().sendMessage((BaseComponent)top7message);
      TextComponent top1message = new TextComponent("§8┃ §e§lDmar§6§lMc §8»  §7Discord ");
      top1message.setColor(ChatColor.GRAY);
      TextComponent top1 = new TextComponent("§8┃ §eClick Here §8┃");
      top1.setColor(ChatColor.GREEN);
      top1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cTop Kills ")).create()));
      top1.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.gg/EPRPzceZfB"));
      player.spigot().sendMessage((BaseComponent)top1message);
      TextComponent top6message = new TextComponent("§8┃     ");
      top6message.setColor(ChatColor.GRAY);
      TextComponent top6 = new TextComponent("§8 ");
      top6.setColor(ChatColor.GREEN);
      top6.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§ctop to ")).create()));
      top6.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/v"));
      player.spigot().sendMessage((BaseComponent)top6message);
      top7message.addExtra((BaseComponent)top7);
      top1message.addExtra((BaseComponent)top1);
      top6message.addExtra((BaseComponent)top6);
    } 
    return false;
  }
}