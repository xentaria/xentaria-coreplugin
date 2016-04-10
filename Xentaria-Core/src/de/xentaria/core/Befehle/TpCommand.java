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
		} else if(args.length == 0){
			Player spieler = Bukkit.getPlayer(args[0]);
			double x = spieler.getLocation().getX();
			double y = spieler.getLocation().getY();
			double z = spieler.getLocation().getZ();
			String world = spieler.getLocation().getWorld().getName();
			float yaw = spieler.getLocation().getYaw();
			float pitch = spieler.getLocation().getPitch();
			
			Location tp = new Location(world, x, y, z, yaw, pitch);
			
			p.teleport(tp);
			
			
			
		}
		
		
		return true;
	}

}
