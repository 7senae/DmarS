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


public class BanCommand implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (cmd.getName().equalsIgnoreCase("tban") && 
      sender instanceof Player) {
      Player player = (Player)sender;
      if (player.hasPermission("punishdmar.ban"))
        if (args.length == 0) {
          player.sendMessage(ChatColor.RED + "§c§lDmar§4§lMc §8» §cUsage: /tban <player>");
        } else {
          Player target = Bukkit.getPlayerExact(args[0]);
          if (target instanceof Player) {
            TextComponent ban8message = new TextComponent("§8●     ");
            ban8message.setColor(ChatColor.GRAY);
            TextComponent ban8 = new TextComponent("§8 ");
            ban8.setColor(ChatColor.GREEN);
            ban8.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cBan to " + target.getName())).create()));
            ban8.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tempban " + target.getName() + " 3d " + "&c&lGlitchs"));
            ban8.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/baneeee " + target.getName()));
            player.spigot().sendMessage((BaseComponent)ban8message);
            TextComponent ban9message = new TextComponent("§8● §c§lDmar§4§lMc §8» §7History §c" + target.getName());
            ban9message.setColor(ChatColor.GRAY);
            TextComponent ban9 = new TextComponent("§8● §eClick Here §8●");
            ban9.setColor(ChatColor.GREEN);
            ban9.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cHistory " + target.getName())).create()));
            ban9.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/history " + target.getName() + " "));
            ban9.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/baneeee " + target.getName()));

            player.spigot().sendMessage((BaseComponent)ban9message);
            TextComponent ban1message = new TextComponent("§8● §c§lDmar§4§lMc §8» §7Banned Hacking ");
            ban1message.setColor(ChatColor.GRAY);
            TextComponent ban1 = new TextComponent("§8● §eClick Here §8●");
            ban1.setColor(ChatColor.GREEN);
            ban1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cBan to " + target.getName())).create()));
            ban1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tempban " + target.getName() + " 3d " + "&cHacking"));
            ban1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/baneeee " + target.getName()));

            player.spigot().sendMessage((BaseComponent)ban1message);
            TextComponent ban2message = new TextComponent("§8● §c§lDmar§4§lMc §8» §7Adv ");
            ban1message.setColor(ChatColor.GRAY);
            TextComponent ban2 = new TextComponent("§8● §eClick Here §8●");
            ban2.setColor(ChatColor.GREEN);
            ban2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cBan to " + target.getName())).create()));
            ban2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tempban " + target.getName() + " 3d " + "&cAdv"));
            ban2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/baneeee " + target.getName()));

            player.spigot().sendMessage((BaseComponent)ban2message);
            TextComponent ban3message = new TextComponent("§8● §c§lDmar§4§lMc §8» §7Swearing Report ");
            ban1message.setColor(ChatColor.GRAY);
            TextComponent ban3 = new TextComponent("§8● §eClick Here §8●");
            ban3.setColor(ChatColor.GREEN);
            ban3.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cBan to " + target.getName())).create()));
            ban3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tempban " + target.getName() + " 1d " + "&cSwearing Report"));
            ban3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/baneeee " + target.getName()));

            player.spigot().sendMessage((BaseComponent)ban3message);
            TextComponent ban4message = new TextComponent("§8● §c§lDmar§4§lMc §8» §7Swearing HelpOp ");
            ban1message.setColor(ChatColor.GRAY);
            TextComponent ban4 = new TextComponent("§8● §eClick Here §8●");
            ban4.setColor(ChatColor.GREEN);
            ban4.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cBan to " + target.getName())).create()));
            ban4.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tempban " + target.getName() + " 1d " + "&cSwearing HelpOp"));
            ban4.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/baneeee " + target.getName()));

            player.spigot().sendMessage((BaseComponent)ban4message);
            TextComponent ban5message = new TextComponent("§8● §c§lDmar§4§lMc §8» §7Disrespect Report ");
            ban1message.setColor(ChatColor.GRAY);
            TextComponent ban5 = new TextComponent("§8● §eClick Here §8●");
            ban5.setColor(ChatColor.GREEN);
            ban5.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cBan to " + target.getName())).create()));
            ban5.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tempban " + target.getName() + " 12h " + "&c&lDisrespect Report"));
            ban5.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/baneeee " + target.getName()));

            player.spigot().sendMessage((BaseComponent)ban5message);
            TextComponent ban6message = new TextComponent("§8● §c§lDmar§4§lMc §8» §7Spamming Report ");
            ban1message.setColor(ChatColor.GRAY);
            TextComponent ban6 = new TextComponent("§8● §eClick Here §8●");
            ban6.setColor(ChatColor.GREEN);
            ban6.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cBan to " + target.getName())).create()));
            ban6.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tempban " + target.getName() + " 12h " + "&cSpamming Report"));
            ban6.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/baneeee " + target.getName()));

            player.spigot().sendMessage((BaseComponent)ban6message);
            TextComponent ban10message = new TextComponent("§8● §c§lDmar§4§lMc §8» §7Max Team ");
            ban1message.setColor(ChatColor.GRAY);
            TextComponent ban10 = new TextComponent("§8● §eClick Here §8●");
            ban10.setColor(ChatColor.GREEN);
            ban10.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cBan to " + target.getName())).create()));
            ban10.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tempban " + target.getName() + " 1d " + "&cMaxTeam"));
            ban10.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/baneeee " + target.getName()));

            player.spigot().sendMessage((BaseComponent)ban10message);
            TextComponent ban11message = new TextComponent("§8● §c§lDmar§4§lMc §8» §7Farm or FreeKill ");
            ban1message.setColor(ChatColor.GRAY);
            TextComponent ban11 = new TextComponent("§8● §eClick Here §8●");
            ban11.setColor(ChatColor.GREEN);
            ban11.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cBan to " + target.getName())).create()));
            ban11.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tempban " + target.getName() + " 1d " + "&cFarm or FreeKill"));
            ban11.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/baneeee " + target.getName()));
            player.spigot().sendMessage((BaseComponent)ban11message);
            TextComponent ban12message = new TextComponent("§8● §c§lDmar§4§lMc §8» §7BadName ");
            ban1message.setColor(ChatColor.GRAY);
            TextComponent ban12 = new TextComponent("§8● §eClick Here §8●");
            ban12.setColor(ChatColor.GREEN);
            ban12.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cBan to " + target.getName())).create()));
            ban12.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tempban " + target.getName() + " 30d " + "&cBadName"));
            ban12.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/baneeee " + target.getName()));
            player.spigot().sendMessage((BaseComponent)ban12message);
            TextComponent ban13message = new TextComponent("§8● §c§lDmar§4§lMc §8» §7BadSkin ");
            ban13message.setColor(ChatColor.GRAY);
            TextComponent ban13 = new TextComponent("§8● §eClick Here §8●");
            ban13.setColor(ChatColor.GREEN);
            ban13.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cBan to " + target.getName())).create()));
            ban13.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tempban " + target.getName() + " 1d " + "&cBadSkin"));
            ban13.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/baneeee " + target.getName()));
            player.spigot().sendMessage((BaseComponent)ban13message);
            TextComponent ban14message = new TextComponent("§8● §c§lDmar§4§lMc §8» §7Alts ");
            ban14message.setColor(ChatColor.GRAY);
            TextComponent ban14 = new TextComponent("§8● §eClick Here §8●");
            ban14.setColor(ChatColor.GREEN);
            ban14.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cBan to " + target.getName())).create()));
            ban14.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/banip " + target.getName() + " &cAlts"));
            ban14.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/baneeee " + target.getName()));

            player.spigot().sendMessage((BaseComponent)ban14message);
            TextComponent ban15message = new TextComponent("§8● §c§lDmar§4§lMc §8» §7Swearing Party ");
            ban15message.setColor(ChatColor.GRAY);
            TextComponent ban15 = new TextComponent("§8● §eClick Here §8●");
            ban15.setColor(ChatColor.GREEN);
            ban15.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cBan to " + target.getName())).create()));
            ban15.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tempban " + target.getName() + " 1d " + "&cSwearing Party"));
            ban15.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/baneeee " + target.getName()));

            player.spigot().sendMessage((BaseComponent)ban15message);
            TextComponent ban16message = new TextComponent("§8● §c§lDmar§4§lMc §8» §7Disrespect Party ");
            ban16message.setColor(ChatColor.GRAY);
            TextComponent ban16 = new TextComponent("§8● §eClick Here §8●");
            ban16.setColor(ChatColor.GREEN);
            ban16.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cBan to " + target.getName())).create()));
            ban16.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tempban " + target.getName() + " 1d " + "&cDisrespect Party"));
            ban16.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/baneeee " + target.getName()));

            player.spigot().sendMessage((BaseComponent)ban16message);
            TextComponent ban17message = new TextComponent("§8● §c§lDmar§4§lMc §8» §7Spam Join_Leave ");
            ban17message.setColor(ChatColor.GRAY);
            TextComponent ban17 = new TextComponent("§8● §eClick Here §8●");
            ban17.setColor(ChatColor.GREEN);
            ban17.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cBan to " + target.getName())).create()));
            ban17.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tempban " + target.getName() + " 1d " + "&cSpam Join_Leave"));
            ban17.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/baneeee " + target.getName()));

            player.spigot().sendMessage((BaseComponent)ban17message);
            TextComponent ban18message = new TextComponent("§8● §c§lDmar§4§lMc §8» §7BadName Clan ");
            ban18message.setColor(ChatColor.GRAY);
            TextComponent ban18 = new TextComponent("§8● §eClick Here §8●");
            ban18.setColor(ChatColor.GREEN);
            ban18.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cBan to " + target.getName())).create()));
            ban18.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tempban " + target.getName() + " 3d " + "&cBadName Clan"));
            ban18.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/baneeee " + target.getName()));

            player.spigot().sendMessage((BaseComponent)ban18message);
            TextComponent ban19message = new TextComponent("§8● §c§lDmar§4§lMc §8» §7useless Report ");
            ban19message.setColor(ChatColor.GRAY);
            TextComponent ban19 = new TextComponent("§8● §eClick Here §8●");
            ban19.setColor(ChatColor.GREEN);
            ban19.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cBan to " + target.getName())).create()));
            ban19.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tempban " + target.getName() + " 12h " + "&cuseless Report"));
            ban19.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/baneeee " + target.getName()));
            player.spigot().sendMessage((BaseComponent)ban19message);
            TextComponent ban20message = new TextComponent("§8● §c§lDmar§4§lMc §8» §7Crash ");
            ban20message.setColor(ChatColor.GRAY);
            TextComponent ban20 = new TextComponent("§8● §eClick Here §8●");
            ban20.setColor(ChatColor.GREEN);
            ban20.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cBan to " + target.getName())).create()));
            ban20.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/banip " + target.getName() + "&cCrashServer"));
            ban20.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/baneeee " + target.getName()));
            player.spigot().sendMessage((BaseComponent)ban20message);
            TextComponent ban7message = new TextComponent("§8●      ");
            ban7message.setColor(ChatColor.GRAY);
            TextComponent ban7 = new TextComponent("§8");
            ban7.setColor(ChatColor.GREEN);
            ban7.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(ChatColor.GREEN + "§cBan to " + target.getName())).create()));
            ban7.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tempban " + target.getName() + " 3d " + "&c&lGlitchs"));
            ban7.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/baneeee " + target.getName()));
            player.spigot().sendMessage((BaseComponent)ban7message);
            ban9message.addExtra((BaseComponent)ban9);
            ban8message.addExtra((BaseComponent)ban8);
            ban1message.addExtra((BaseComponent)ban1);
            ban2message.addExtra((BaseComponent)ban2);
            ban3message.addExtra((BaseComponent)ban3);
            ban4message.addExtra((BaseComponent)ban4);
            ban5message.addExtra((BaseComponent)ban5);
            ban6message.addExtra((BaseComponent)ban6);
            ban10message.addExtra((BaseComponent)ban10);
            ban11message.addExtra((BaseComponent)ban11);
            ban12message.addExtra((BaseComponent)ban12);
            ban13message.addExtra((BaseComponent)ban13);
            ban14message.addExtra((BaseComponent)ban14);
            ban15message.addExtra((BaseComponent)ban15);
            ban16message.addExtra((BaseComponent)ban16);
            ban17message.addExtra((BaseComponent)ban17);
            ban18message.addExtra((BaseComponent)ban18);
            ban19message.addExtra((BaseComponent)ban19);
            ban20message.addExtra((BaseComponent)ban20);
            ban7message.addExtra((BaseComponent)ban7);
          } 
        }  
    } 
    return false;
  }
}
