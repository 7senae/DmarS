package com.foxy.dmar;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

	public class Actionbar {
		  private PacketPlayOutChat packet;
		  
		  public Actionbar(String text) {
		    PacketPlayOutChat packet = new PacketPlayOutChat(IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + text + "\"}"), (byte)2);
		    this.packet = packet;
		  }
		  
		  public void send(Player p) {
		    (((CraftPlayer)p).getHandle()).playerConnection.sendPacket((Packet)this.packet);
		  }
}
