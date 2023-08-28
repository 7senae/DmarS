package com.foxy.dmar;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;



public class event implements Listener {
	
	  @EventHandler
	  public void onJoin(PlayerJoinEvent e) {
 e.setJoinMessage(null);

	  }
	  
	  @EventHandler
	  public void onQuit(PlayerQuitEvent e) {
	    e.setQuitMessage(null);


	  }


}
