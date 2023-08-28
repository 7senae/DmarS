package com.foxy.dmar;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import net.minecraft.server.v1_8_R3.EntityPlayer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
	  public static String prefix = "§8┃ §c§lDmar§4§lMc §8» §7 ";

  
  public static YAMLFile permissions = new YAMLFile("plugins/SystemDmar", "permissions.yml");
  
  public static YAMLFile messages = new YAMLFile("plugins/SystemDmar", "messages.yml");
  public int port;
  
  public void onDisable() {
    saveConfig();

  }
  public static String color(String s) {
	    return ChatColor.translateAlternateColorCodes('&', s);
	  }
  public static int getPing(Player p) {

      EntityPlayer player = ((CraftPlayer) p).getHandle();
      return player.ping;

   }
	  
  public void onEnable() {
    Bukkit.getConsoleSender().sendMessage(F("&aDmarSYSTEM by Foxy"));
    onRegister();
    loadConfig();
    Bukkit.getConsoleSender().sendMessage(F("&aDmarSYSTEM by Foxy has been loaded "));
  }
  
  public void loadConfig() {
    getConfig().options().copyDefaults(true);
    saveConfig();
  }
  
  public static String F(String e) {
    return ChatColor.translateAlternateColorCodes('&', e);
  }
  
  public void onRegister() {
    PluginManager pm = Bukkit.getPluginManager();
    pm.registerEvents(new Chat(), (Plugin)this);
    pm.registerEvents(new event(), (Plugin)this);
    getCommand("tp").setExecutor((CommandExecutor)new commands());
    getCommand("gmc").setExecutor((CommandExecutor)new commands());
    getCommand("gms").setExecutor((CommandExecutor)new commands());
    getCommand("gma").setExecutor((CommandExecutor)new commands());
    getCommand("gmsp").setExecutor((CommandExecutor)new commands());
    getCommand("clear").setExecutor((CommandExecutor)new commands());
    getCommand("kill").setExecutor((CommandExecutor)new commands());
    getCommand("heal").setExecutor((CommandExecutor)new commands());
    getCommand("gamemode").setExecutor((CommandExecutor)new commands());
    getCommand("fly").setExecutor((CommandExecutor)new commands());
    getCommand("Day").setExecutor((CommandExecutor)new commands());
    getCommand("Night").setExecutor((CommandExecutor)new commands());
    getCommand("cc").setExecutor((CommandExecutor)new commands());
    getCommand("clearchat").setExecutor((CommandExecutor)new commands());
    getCommand("gm").setExecutor((CommandExecutor)new commands());
    getCommand("tpall").setExecutor((CommandExecutor)new commands());
    getCommand("ping").setExecutor((CommandExecutor)new commands());
    getCommand("discord").setExecutor((CommandExecutor)new Vanish());
    getCommand("tban").setExecutor((CommandExecutor)new BanCommand());
    getCommand("tmute").setExecutor((CommandExecutor)new MuteCommand());
    getCommand("invsee").setExecutor((CommandExecutor)new InvseeCommand());
    getCommand("baneeee").setExecutor((CommandExecutor)new commands());
    getCommand("muteeee").setExecutor((CommandExecutor)new commands());



  }

  

}
