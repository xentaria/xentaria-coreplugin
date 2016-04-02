package de.xentaria.core.Befehle;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import de.xentaria.core.Main;

public class ChatClear implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {

		if(cs instanceof ConsoleCommandSender) {
			System.out.println("Consolen koennen nicht gesauebert werden");
			return true;
		}
		Player p = (Player) cs;
		
		if(!(p.hasPermission("xentaria.cleaner"))){
			p.sendMessage(Main.noperm);
			return true;
		}
		
		
		if(args.length == 0) {
			for(int i = 0; i != 200; i++){
				Bukkit.broadcastMessage("");
			}
			Bukkit.broadcastMessage(Main.pre + "Der Chat wurde von §c" + p.getName() + Main.farbe + "gesäubert");
		} else if(args.length == 1) {
			if(!(p.hasPermission("xentaria.cleaner.other"))){
				p.sendMessage(Main.noperm);
				return true;
			}
			try{
				Player andererSpieler = Bukkit.getPlayer(args[0]);
				for(int i = 0; i != 200; i++){
					andererSpieler.sendMessage("");
				}
				andererSpieler.sendMessage(Main.pre + "Dein eigener Chat wurde von §c" + p.getName() + Main.farbe + "gesäubert");
				p.sendMessage(Main.pre + "Du hast den Chat von §c" + andererSpieler.getName() + Main.farbe + "gesäubert.");
			} catch (NullPointerException e){
				p.sendMessage(Main.pre + "Der angegebene Spieler ist offline: §7" + args[0]);
			}
		} else {
			p.sendMessage(Main.pre + "Bitte benutze /cc [Spieler]");
		}
		return true;
	}
	
	

}
