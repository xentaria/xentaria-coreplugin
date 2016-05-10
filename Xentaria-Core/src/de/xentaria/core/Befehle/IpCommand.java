package de.xentaria.core.Befehle;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.xentaria.core.Main;

public class IpCommand implements CommandExecutor {

	private LinkedHashMap<String, String> ips;
	
	public IpCommand(Main main) {
		this.ips = new LinkedHashMap<>();
		for(String s : main.getConfig().getConfigurationSection("Befehle.IP").getKeys(false)){
			this.ips.put(s.toLowerCase(), main.getConfig().getString("Command.IP." + s));
		}
	}
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		
		if(args.length == 1) {
			String s = this.ips.get(args[0].toLowerCase());
			
			if(s == null){
				cs.sendMessage(Main.falsch);
				return false;
			}
			cs.sendMessage("&7Die IP vom &6" + args[0] + " &7lautet &a&l" + s);
		}
		return true;
	}

}
