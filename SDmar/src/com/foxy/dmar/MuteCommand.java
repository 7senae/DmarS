package com.foxy.dmar;


import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MuteCommand implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (cmd.getName().equalsIgnoreCase("tmute") && 
      sender instanceof Player) {
      Player player = (Player)sender;
      if (player.hasPermission("punishdmar.mute"))
        if (args.length == 0) {
          player.sendMessage("§c§lDmar§4§lMc §8» §cUsage: /tmute <player>");
        } else {
          Player target = Bukkit.getPlayerExact(args[0]);
          if (target instanceof Player) {
            TextComponent mute7message = new TextComponent("§8?      ");
            mute7message.setColor(ChatColor.GRAY);
            TextComponent mute7 = new TextComponent("§8  ");
            mute7.setColor(ChatColor.GREEN);
            mute7.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "Click to Mute")).create()));
            mute7.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tempmute " + target.getName() + " 8h " + "&2&lBad&a&lWord"));
            mute7.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/muteeee " + target.getName()));
            player.spigot().sendMessage((BaseComponent)mute7message);
            TextComponent mute1message = new TextComponent("§8● §c§lDmar§4§lMc §8» §7Swearing ");
            mute1message.setColor(ChatColor.GRAY);
            TextComponent mute1 = new TextComponent(" §8● §eClick Here §8●");
            mute1.setColor(ChatColor.GREEN);
            mute1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cMute to " + target.getName())).create()));
            mute1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tempmute " + target.getName() + " 1d " + "&cSwearing"));
            mute1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/muteeee " + target.getName()));

            player.spigot().sendMessage((BaseComponent)mute1message);
            TextComponent mute2message = new TextComponent("§8● §c§lDmar§4§lMc §8» §7Swearing Server ");
            mute2message.setColor(ChatColor.GRAY);
            TextComponent mute2 = new TextComponent(" §8● §eClick Here §8●");
            mute2.setColor(ChatColor.GREEN);
            mute2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cMute to " + target.getName())).create()));
            mute2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tempmute " + target.getName() + " 2d " + "&cSwearing Server"));
            mute2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/muteeee " + target.getName()));

            player.spigot().sendMessage((BaseComponent)mute2message);
            TextComponent mute3message = new TextComponent("§8● §c§lDmar§4§lMc §8» §7Disrespect");
            mute3message.setColor(ChatColor.GRAY);
            TextComponent mute3 = new TextComponent(" §8● §eClick Here §8●");
            mute3.setColor(ChatColor.GREEN);
            mute3.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cMute to " + target.getName())).create()));
            mute3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tempmute " + target.getName() + " 12h " + "&cDisrespect"));
            mute3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/muteeee " + target.getName()));

            player.spigot().sendMessage((BaseComponent)mute3message);
            TextComponent mute4message = new TextComponent("§8● §c§lDmar§4§lMc §8» §7Toxic");
            mute4message.setColor(ChatColor.GRAY);
            TextComponent mute4 = new TextComponent(" §8● §eClick Here §8●");
            mute4.setColor(ChatColor.GREEN);
            mute4.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cMute to " + target.getName())).create()));
            mute4.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tempmute " + target.getName() + " 6h " + "&cToxic"));
            mute4.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/muteeee " + target.getName()));
            player.spigot().sendMessage((BaseComponent)mute4message);
            TextComponent mute5message = new TextComponent("§8● §c§lDmar§4§lMc §8» §7Spam");
            mute5message.setColor(ChatColor.GRAY);
            TextComponent mute5 = new TextComponent(" §8● §eClick Here §8●");
            mute5.setColor(ChatColor.GREEN);
            mute5.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cMute to " + target.getName())).create()));
            mute5.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tempmute " + target.getName() + " 12h " + "&cSpam"));
            mute5.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/muteeee " + target.getName()));
            player.spigot().sendMessage((BaseComponent)mute5message);
            TextComponent mute8message = new TextComponent("§8● §c§lDmar§4§lMc §8» §7Annoy Others");
            mute8message.setColor(ChatColor.GRAY);
            TextComponent mute8 = new TextComponent(" §8● §eClick Here §8●");
            mute8.setColor(ChatColor.GREEN);
            mute8.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cMute to " + target.getName())).create()));
            mute8.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tempmute " + target.getName() + " 12h " + "&cAnnoy Others"));
            mute8.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/muteeee " + target.getName()));
            player.spigot().sendMessage((BaseComponent)mute8message);
            TextComponent mute9message = new TextComponent("§8● §c§lDmar§4§lMc §8» §7Share Name Server");
            mute9message.setColor(ChatColor.GRAY);
            TextComponent mute9 = new TextComponent(" §8● §eClick Here §8●");
            mute9.setColor(ChatColor.GREEN);
            mute9.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cMute to " + target.getName())).create()));
            mute9.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tempmute " + target.getName() + " 12h " + "&cShare Name Server"));
            mute9.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/muteeee " + target.getName()));
            player.spigot().sendMessage((BaseComponent)mute9message);
            TextComponent mute10message = new TextComponent("§8● §c§lDmar§4§lMc §8» §7Alts");
            mute10message.setColor(ChatColor.GRAY);
            TextComponent mute10 = new TextComponent(" §8● §eClick Here §8●");
            mute10.setColor(ChatColor.GREEN);
            mute10.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cMute to " + target.getName())).create()));
            mute10.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tempmuteip " + target.getName() + " 30d " + "&cAlts"));
            mute10.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/muteeee " + target.getName()));

            player.spigot().sendMessage((BaseComponent)mute10message);
            TextComponent mute6message = new TextComponent("§8●     ");
            mute6message.setColor(ChatColor.GRAY);
            TextComponent mute6 = new TextComponent("§8 ");
            mute6.setColor(ChatColor.GREEN);
            mute6.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cMute to " + target.getName())).create()));
            mute6.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tempmute " + target.getName() + " 8h " + "&2&lBad&a&lWord"));
            mute6.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/muteeee " + target.getName()));
            player.spigot().sendMessage((BaseComponent)mute6message);
            mute7message.addExtra((BaseComponent)mute7);
            mute1message.addExtra((BaseComponent)mute1);
            mute2message.addExtra((BaseComponent)mute2);
            mute3message.addExtra((BaseComponent)mute3);
            mute4message.addExtra((BaseComponent)mute4);
            mute5message.addExtra((BaseComponent)mute5);
            mute8message.addExtra((BaseComponent)mute8);
            mute9message.addExtra((BaseComponent)mute9);
            mute10message.addExtra((BaseComponent)mute10);
            mute6message.addExtra((BaseComponent)mute6);
          } 
        }  
    } 
    return false;
  }
}
