package de.xentaria.core.Befehle;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.xentaria.core.Main;

public class SethomeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		
		//File file = File("plugins/Xentaria","Warps.yml");
		//FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		Player p = (Player) cs;
		
		if (args.length == 1) {
			
			String world = p.getWorld().getName();
			double x = p.getLocation().getX();
			double y = p.getLocation().getY();
			double z = p.getLocation().getZ();
			
		} else {
			p.sendMessage(Main.pre + "/sethome [Name]");
		}
		
		return true;
	}

}
