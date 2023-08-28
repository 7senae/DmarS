package com.foxy.dmar;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class commands implements CommandExecutor {
  String prefix = "&8┃ &c&lDmar&4&lMc &8» ";
  
  public static ArrayList<String> vanished;
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage(Main.F("&cSpigot system commands can used by players only."));
      return true;
    } 
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("ping")) {
      if (args.length > 1) {
        p.sendMessage(Main.F(this.prefix + "&cUsage: /Ping, /Ping [Player]"));
        return true;
      } 
      if (args.length == 1) {
        Player target = Bukkit.getPlayerExact(args[0]);
        if (target == null) {
          p.sendMessage(Main.F(this.prefix + "&cPlayer is not in your server."));
          return true;
        } 
        CraftPlayer cp = (CraftPlayer)target;
        p.sendMessage(Main.F(this.prefix + "&f" + target.getDisplayName() + "'s &eping: &6" + (cp.getHandle()).ping));
      } else {
        CraftPlayer cp = (CraftPlayer)p;
        p.sendMessage(Main.F(this.prefix + "&eYour ping is &8» &a" + (cp.getHandle()).ping));
        Actionbar msgd = new Actionbar(Main.color( Main.prefix+ " &aYour Ping " + Main.getPing(p)));
        msgd.send(p);
      } 
    } 
    if (cmd.getName().equalsIgnoreCase("gms") || cmd.getName().equalsIgnoreCase("gmsp") || cmd
      .getName().equalsIgnoreCase("gma") || cmd.getName().equalsIgnoreCase("gmc")) {
      if (p.hasPermission("gamemode.use")) {
        String gm_type = cmd.getName().toLowerCase();
        gm_type = gm_type.replaceAll("gmsp", "SPECTATOR");
        gm_type = gm_type.replaceAll("gms", "SURVIVAL");
        gm_type = gm_type.replaceAll("gmc", "CREATIVE");
        gm_type = gm_type.replaceAll("gma", "ADVENTURE");
        GameMode gm = GameMode.valueOf(gm_type);
        if (args.length == 0) {
          p.setGameMode(gm);
          p.sendMessage(Main.F(this.prefix + "&6You have changed your gamemode to &a" + gm_type + "&f."));
          Actionbar msgd = new Actionbar(Main.color( Main.prefix+ " &aYour have  " + gm_type));
          msgd.send(p);
          return true;
        } 
        Player target = Bukkit.getPlayerExact(args[0]);
        if (target == null) {
          p.sendMessage(Main.F(this.prefix + "&cPlayer is not online."));
          return true;
        } 
        target.setGameMode(gm);
        p.sendMessage(Main.F(this.prefix + "&fYou have changed " + target.getName() + "'s gamemode to &6" + gm_type + "&f."));

        target.sendMessage(Main.F(this.prefix + "&fYour gamemode has been changed to &a" + gm_type + " &fby " + p.getName() + "."));
        return true;
      } 
      p.sendMessage(Main.F("&cYou don`t have Permission"));
    } 
    if (cmd.getName().equalsIgnoreCase("clear")) {
      if (p.hasPermission("clear.use")) {
        if (args.length == 0) {
          p.getInventory().clear();
          p.sendMessage(Main.F(this.prefix + "&aYou have cleared y s..."));
          return true;
        } 
        Player target = Bukkit.getPlayerExact(args[0]);
        if (target == null) {
          p.sendMessage(Main.F(this.prefix + "&cPlayer is not online."));
          return true;
        } 
        target.getInventory().clear();
        p.sendMessage(Main.F(this.prefix + "&aYou have cleared &6" + target.getName() + "&f."));
        target.sendMessage(Main.F(this.prefix + "&aYou have been cleared by &6" + p.getName() + "&f."));
        return true;
      } 
      p.sendMessage(Main.F("&cYou don`t have Permission"));
      return true;
    } 
    if (cmd.getName().equalsIgnoreCase("kill")) {
      if (p.hasPermission("kill.use")) {
        if (args.length == 0) {
          p.setHealth(0.0D);
          p.sendMessage(Main.F(this.prefix + "&aYou have killed your self."));
          return true;
        } 
        Player target = Bukkit.getPlayerExact(args[0]);
        if (target == null) {
          p.sendMessage(Main.F(this.prefix + "&cPlayer is not online."));
          Actionbar msgd = new Actionbar(Main.color( Main.prefix+ " &cPlayer Is not Online"));
          msgd.send(p);
          
          return true;
        } 
        target.setHealth(0.0D);
        p.sendMessage(Main.F(this.prefix + "&aYou have killed &6" + target.getDisplayName() + "&f."));
        target.sendMessage(Main.F(this.prefix + "&aYou have been killed by &6" + p.getDisplayName() + "&f."));
        return true;
      } 
      p.sendMessage(Main.F("&cYou don`t have Permission"));
      return true;
    } 
    if (cmd.getName().equalsIgnoreCase("heal")) {
      if (p.hasPermission("heal.use")) {
        if (args.length == 0) {
          p.setHealth(20.0D);
          p.setFoodLevel(20);
          p.sendMessage(Main.F(this.prefix + "&fYou have healed your self."));
          Actionbar msgd = new Actionbar(Main.color( Main.prefix+ " &aYou have Heald"));
          msgd.send(p);
          return true;
        } 
        Player target = Bukkit.getPlayerExact(args[0]);
        if (target == null) {
          p.sendMessage(Main.F(this.prefix + "&cPlayer is not online."));
          Actionbar msgd = new Actionbar(Main.color( Main.prefix+ " &cPlayer Is not Online"));
          msgd.send(p);
          return true;
        } 
        target.setHealth(20.0D);
        target.setFoodLevel(20);
        p.sendMessage(Main.F(this.prefix + "&aYou have healed &6" + target.getDisplayName() + "&f."));
        target.sendMessage(Main.F(this.prefix + "&aYou have been healed by &6" + p.getDisplayName() + "&f."));
        Actionbar msgd = new Actionbar(Main.color( Main.prefix+ " &aYou have been healed by &6"+ p.getDisplayName()));
        msgd.send(p);
        return true;
      } 
      p.sendMessage(Main.F("&cYou don`t have Permission"));
      return true;
    } 
    if (cmd.getName().equalsIgnoreCase("tp"))
      if (p.hasPermission("tp.use")) {
        if (args.length == 0) {
          p.sendMessage(Main.F(this.prefix + "&cUsage &8» &7/TP (Player) OR /TP (Player) (Player)."));
          return true;
        } 
        if (args.length == 1) {
          Player target = Bukkit.getPlayerExact(args[0]);
          if (target == null) {
            p.sendMessage(Main.F(this.prefix + "&cPlayer is not online."));
            Actionbar msgd = new Actionbar(Main.color( Main.prefix+ " &cPlayer Is not Online"));
            msgd.send(p);
 
            return true;
          } 
          if (p == target) {
            p.sendMessage(Main.F(this.prefix + "&6Why are you trying to teleport to your self"));
            return true;
          } 
          p.teleport((Entity)target);
          p.sendMessage(Main.F(this.prefix + "&6You have teleported to &a" + target.getDisplayName() + "&6."));
          Actionbar msgd = new Actionbar(Main.color( "Main.prefix+ &6You have teleported to &a" + target.getDisplayName() + "&6."));
          msgd.send(p);
          if (!vanished.contains(p.getName()))
          return true;
        } 
        if (args.length == 2) {
          Player target2 = Bukkit.getPlayerExact(args[0]);
          Player target = Bukkit.getPlayerExact(args[1]);
          if (target2 == null) {
            p.sendMessage(Main.F(this.prefix + "&cPlayer is not online."));
            Actionbar msgd = new Actionbar(Main.color( Main.prefix+ " &cPlayer Is not Online"));
            msgd.send(p);
            
            return true;
          } 
          if (target == null) {
            p.sendMessage(Main.F(this.prefix + "&cPlayer 2 is not online."));
            return true;
          } 
          if (target == p && target2 == p) {
            p.sendMessage(Main.F(this.prefix + "&6Why are you trying to teleport you to your self"));
            return true;
          } 
          target2.teleport((Entity)target);
          p.sendMessage(Main.F(this.prefix + "&6You have teleported &a" + target2.getDisplayName() + " &6to &a" + target.getDisplayName() + "&7."));
          Actionbar msgd = new Actionbar(Main.color( Main.prefix+ "&6You have teleported &a" + target2.getDisplayName() + " &6to &a" + target.getDisplayName() + "&7"));
          msgd.send(p);
          if (target != p && 
            !vanished.contains(p.getName()))
            target.sendMessage(Main.F(this.prefix + target2.getDisplayName() + " &fhas been teleported to you by " + p.getDisplayName() + "&f.")); 
          Actionbar msgdd = new Actionbar(Main.color( Main.prefix+ target2.getDisplayName() + " &fhas been teleported to you by " + p.getDisplayName() + "&f"));
          msgdd.send(p);
          return true;
        } 
      } else {
        p.sendMessage(Main.F("&cYou don`t have Permission"));
        return true;
      }  
    if (cmd.getName().equalsIgnoreCase("gamemode") || cmd.getName().equalsIgnoreCase("gm"))
      if (p.hasPermission("gamemode.use")) {
        if (args.length == 0) {
          p.sendMessage(Main.F(this.prefix + "&cUsage &8» &7/GameMode (Mode) OR /GameMode (Mode) (Player)"));
          return true;
        } 
        if (args.length == 1)
          try {
            String gm_type = args[0].toUpperCase();
            gm_type = gm_type.replaceAll("1", "CREATIVE");
            gm_type = gm_type.replaceAll("2", "ADVENTURE");
            gm_type = gm_type.replaceAll("3", "SPECTATOR");
            gm_type = gm_type.replaceAll("0", "SURVIVAL");
            GameMode gm = GameMode.valueOf(gm_type);
            p.setGameMode(gm);
            p.sendMessage(Main.F(this.prefix + "&6You have changed your gamemode to &a" + p.getGameMode().toString().toUpperCase() + "&6."));
            Actionbar msgdd = new Actionbar(Main.color( Main.prefix+ "&6You have changed your gamemode to &a" + p.getGameMode().toString().toUpperCase()));
            msgdd.send(p);
           
            return true;
          } catch (IllegalArgumentException e) {
            p.sendMessage(Main.F(this.prefix + "&cInvalid this Mode."));
            return true;
          }  
        if (args.length == 2) {
          Player target = Bukkit.getPlayerExact(args[1]);
          if (target == null) {
            p.sendMessage(Main.F(this.prefix + "&cPlayer is not online"));
            Actionbar msgd = new Actionbar(Main.color( Main.prefix+ " &cPlayer Is not Online"));
            msgd.send(p);
            return true;
          } 
          try {
            String gm_type = args[0].toUpperCase();
            gm_type = gm_type.replaceAll("1", "CREATIVE");
            gm_type = gm_type.replaceAll("2", "ADVENTURE");
            gm_type = gm_type.replaceAll("3", "SPECTATOR");
            gm_type = gm_type.replaceAll("0", "SURVIVAL");
            GameMode gm = GameMode.valueOf(gm_type);
            target.setGameMode(gm);
            p.sendMessage(Main.F(this.prefix + "&6You have changed &a" + target.getDisplayName() + "'s &6gamemode to &a" + target.getGameMode().toString().toUpperCase() + "&6."));
            target.sendMessage(Main.F(this.prefix + "&6Your gamemode has been changed to &a" + target.getGameMode().toString().toUpperCase() + " &6by  &a" + p.getDisplayName() + " &6."));
            Actionbar msgdd = new Actionbar(Main.color( Main.prefix+ "&6Your gamemode has been changed to &a" + target.getGameMode().toString().toUpperCase() + " &6by  &a" + p.getDisplayName()));
            msgdd.send(target);
            return true;
          } catch (IllegalArgumentException e) {
            p.sendMessage(Main.F(this.prefix + "&cInvalid GameMode type."));
            Actionbar msgd = new Actionbar(Main.color( Main.prefix+ " &cInvalid !"));
            msgd.send(p);
            return true;
          } 
        } 
      } else {
        p.sendMessage(Main.F("&cYou don`t have Permission"));
        return true;
      }  
    if (cmd.getName().equalsIgnoreCase("Day")) {
      if (p.hasPermission("Day.use")) {
        p.getWorld().setStorm(false);
        p.getWorld().setTime(1000L);
        Bukkit.broadcastMessage(Main.F(this.prefix + "&6Have a good day by &a" + p.getDisplayName() + "&a."));
        Actionbar msgd = new Actionbar(Main.color( Main.prefix+ " &aGood Day"));
        msgd.send(p);
        return true;
      } 
      p.sendMessage(Main.F("&cYou don`t have Permission"));
      return true;
    } 
    if (cmd.getName().equalsIgnoreCase("Night")) {
      if (p.hasPermission("Night.use")) {
        p.getWorld().setTime(1300L);
        Bukkit.broadcastMessage(Main.F(this.prefix + "&6Have a good night by &a" + p.getDisplayName() + "&6."));
        Actionbar msgd = new Actionbar(Main.color( Main.prefix+ " &aGood Night"));
        msgd.send(p);
        return true;
      } 
      p.sendMessage(Main.F("&cYou don`t have Permission"));
      return true;
    } 
    
    if(cmd.getName().equalsIgnoreCase("baneeee")) {
    	      if (p.hasPermission("punishdmar.ban")) {
    	          Player target = Bukkit.getPlayerExact(args[0]);
    	          if (args.length == 1) {
    	          Bukkit.broadcastMessage(Main.F(this.prefix + "&6"));
    	          Actionbar msgd = new Actionbar(Main.color( Main.prefix+ " &c"+target.getName()+" Has Banned " ));
    	          msgd.send(p);
    		
    		
    	      }
    	      }
    }
    	
    
    
    if(cmd.getName().equalsIgnoreCase("muteeee")) {
	      if (p.hasPermission("punishdmar.mute")) {
	          Player target = Bukkit.getPlayerExact(args[0]);
	          if (args.length == 1) {
	          Bukkit.broadcastMessage(Main.F(this.prefix + "&6"));
	          Actionbar msgd = new Actionbar(Main.color( Main.prefix+ " &c"+target.getName()+" Has Muted " ));
	          msgd.send(p);
		
		
	      }
	      }
}

  


    
    if (cmd.getName().equalsIgnoreCase("cc") || cmd.getName().equalsIgnoreCase("clearchat")) {
      if (p.hasPermission("clearchat.use")) {
        for (int i = 0; i < 250; i++) {
          for (Player ps : Bukkit.getOnlinePlayers()) {
            if (!ps.hasPermission("clearchat.anti"))
              ps.sendMessage("&8"); 
          } 
        } 
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + " &8┃ "));
        Bukkit.broadcastMessage(Main.F(this.prefix + "&6The chat has been cleared by &a" + p.getDisplayName() + "&6."));
        Actionbar msgd = new Actionbar(Main.color( Main.prefix+ " &aChat Has Cleared !" ));
        msgd.send(p);
        return true;
      } 
      p.sendMessage(Main.F("&cYou don`t have Permission"));
      return true;
    } 
    if (cmd.getName().equalsIgnoreCase("tpall"))
      if (p.hasPermission("tpall.use")) {
        for (Player ps : Bukkit.getOnlinePlayers()) {
          ps.teleport((Entity)p);
          ps.sendMessage(Main.F(this.prefix + "&6You have been teleported to &a" + p.getDisplayName() + "&6."));
          Actionbar msgd = new Actionbar(Main.color( Main.prefix+ " &aDone Tpall !"));
          msgd.send(p);
        } 
      } else {
        p.sendMessage(Main.F("&cYou don`t have Permission"));
        return true;
      }  
    if (cmd.getName().equalsIgnoreCase("Fly")) {
      if (!p.hasPermission("fly.use")) {
        p.sendMessage(Main.F("&cYou don`t have Permission"));
        return true;
      } 
      if (args.length == 0) {
        if (p.getAllowFlight()) {
          p.setAllowFlight(false);
          p.sendMessage(Main.F(this.prefix + "&cYou have disabled your flight mode."));
          return true;
        } 
        p.setAllowFlight(true);
        p.sendMessage(Main.F(this.prefix + "&aYou have enabled your flight mode."));
        Actionbar msgd = new Actionbar(Main.color( Main.prefix+ " &aYour Are Fly"));
        msgd.send(p);
        return true;
      } 
      if (p.hasPermission("Fly.player")) {
        Player target = Bukkit.getPlayerExact(args[0]);
        if (target == null) {
          p.sendMessage(Main.F(this.prefix + "&cPlayer is not online."));
          return true;
        } 
        if (!target.getAllowFlight()) {
          p.sendMessage(Main.F(this.prefix + "&aYou have enabled " + target.getDisplayName() + "'s &afly mode."));
          target.sendMessage(Main.F(this.prefix + "&aYour flight mode has been enabled by &6" + p.getDisplayName() + "&a."));
          Actionbar msgd = new Actionbar(Main.color( Main.prefix+ " &aYour Are Fly" + " by "+ p.getDisplayName()));
          msgd.send(target);
          target.setAllowFlight(true);
          return true;
        } 
        p.sendMessage(Main.F(this.prefix + "&cYou have disabled " + target.getDisplayName() + "'s &cfly mode."));
        target.sendMessage(Main.F(this.prefix + "&cYour flight mode has been disabled by &6" + p.getDisplayName() + "&c."));
        Actionbar msgd = new Actionbar(Main.color( Main.prefix+ " &cYour Aren`t Fly" + " by "+ p.getDisplayName()));
        msgd.send(target);
        target.setAllowFlight(false);
        return true;
      } 
      p.sendMessage(Main.F("&cYou don`t have Permission"));
      return true;
    } 
    return false;
  }
  
  public ItemStack head(String name, String rank) {
    ItemStack PROFILE = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
    SkullMeta profile_meta = (SkullMeta)PROFILE.getItemMeta();
    profile_meta.setOwner(name);
    profile_meta.setDisplayName(Main.F("&e" + name));
    ArrayList<String> profile_lore = new ArrayList<>();
    profile_lore.add(Main.F("&8&m----------------------------"));
    profile_lore.add(Main.F("&1"));
    profile_lore.add(Main.F(rank));
    profile_lore.add(Main.F("&2"));
    profile_lore.add(Main.F("&8&m----------------------------"));
    profile_meta.setLore(profile_lore);
    profile_meta.addEnchant(Enchantment.LURE, 1, true);
    profile_meta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
    PROFILE.setItemMeta((ItemMeta)profile_meta);
    return PROFILE;
  }
}

