package com.foxy.dmar;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


public class Chat implements Listener {
	  LuckPerms luckPerms = LuckPermsProvider.get();

	     
	  @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
	  public void chat(AsyncPlayerChatEvent e) {
	    Player p = e.getPlayer();
	    e.setCancelled(true);
	    String displayNameGroup = this.luckPerms.getGroupManager().getGroup(this.luckPerms.getUserManager().getUser(p.getName()).getPrimaryGroup()).getDisplayName();
	    String Message2 = e.getMessage();
	    String suffix = this.luckPerms.getGroupManager().getGroup(this.luckPerms.getUserManager().getUser(p.getName()).getPrimaryGroup()).getCachedData().getMetaData().getSuffix();
	    if (suffix == null || suffix.equalsIgnoreCase("null"))
	      suffix = "&7"; 
	    TextComponent component = new TextComponent(Main.color( " &8┃ " + suffix + p.getDisplayName()));
	    component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(Main.color("&eName &8» &9" + suffix + p.getDisplayName() + " \n&6Rank &8» &f" +suffix +displayNameGroup + " \n&aPing &8» &a" + Main.getPing(p) + " &7ms"))).create()));
	    component.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "" + p.getName()));

	    TextComponent component2 = new TextComponent(Main.color(" &8» &7"));
	    TextComponent component3 = new TextComponent();
	    component3.setText(("§7" + Message2));
	    for (Player ps : Bukkit.getOnlinePlayers()) {
	          if (Message2.contains(ps.getName())) {
	          Message2 = Message2.replaceAll(ps.getName(), Main.color("&8" + ps.getDisplayName() + "&r")); 
	        if (!ps.getName().equals(p.getName())) {
	          ps.playSound(ps.getLocation(), Sound.ORB_PICKUP, 1.0F, 1.0F);
	          ps.sendMessage(Main.color("&8┃ &c&lDmar&4&lMc &8» " + suffix + p.getDisplayName() + " &3has mentioned you!"));
	        } 
	      } 
	    }
	    for (Player ps2 : Bukkit.getOnlinePlayers()) {
	      ps2.spigot().sendMessage(new BaseComponent[] { (BaseComponent)component, (BaseComponent)component2, (BaseComponent)component3 });
	    } 
	  }



}
