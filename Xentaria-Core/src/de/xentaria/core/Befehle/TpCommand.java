package de.xentaria.core.Befehle;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.xentaria.core.Main;

public class TpCommand implements CommandExecutor {

	double x;
	double y;
	double z;
	String world;
	float pitch;
	float yaw;
	
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		
		Player p = (Player)cs;
		
		if(!(p instanceof Player)) {
			p.sendMessage(Main.noplayer);
			return true;
		}
		
		if(!p.hasPermission("xentaria.tp")){
			p.sendMessage(Main.noperm);
			return true;
		} else if(args.length == 1){
			Player ziel = (Player)Bukkit.getPlayer(args[0]);
			p.teleport(ziel);
			Player target = (Player) Bukkit.getPlayer(args[0]);
			target.sendMessage(Main.pre + p.getName() + " hat sich zu dir teleportiert.");
			p.sendMessage(Main.pre + "Du hast dich zu " + target.getName() + " teleportiert.");
			return true;
		} else if (args.length == 2){
			Player ziel = (Player) Bukkit.getPlayer(args[0]);
			Player tp = (Player) Bukkit.getPlayer(args[1]);
			ziel.teleport(tp);
;			Player target = (Player) Bukkit.getPlayer(args[0]);
			target.sendMessage(Main.pre + "Du wurdest zu " + p.getName() + " teleportiert.");
			p.sendMessage(Main.pre + target.getName() + " wurde zu dir teleportiert.");
			return true;
		} else {
			p.sendMessage(Main.pre + "Falsche Argumente! /tp [spieler1] [spieler2]");
			return true;
		}
	}

}
