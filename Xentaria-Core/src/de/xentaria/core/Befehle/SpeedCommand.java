package de.xentaria.core.Befehle;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.xentaria.core.Main;

public class SpeedCommand implements CommandExecutor {

	String flug = "Deine Fluggeschwindigkeit wurde geändert auf: ";
	String gehen = "Deine Gehgeschwindigkeit wurde geändert auf: ";
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		
		
		Player p = (Player) cs;
		
		if(!(p.hasPermission("xentaria.speed"))) {
			p.sendMessage(Main.noperm);
			return true;
		} else if(args.length != 1) {
			return false;
		} else {
			if(args[0].equals("1")) {
				if(p.isFlying()){
					p.setFlySpeed((float) 0.1);
					p.sendMessage(Main.pre + flug + args[0]);
					return true;
				} else if(p.isOnGround()) {
					p.setWalkSpeed((float) 0.1);
					p.sendMessage(Main.pre + gehen + args[0]);
					return true;
				}
			} else if(args[0].equals("2")) {
				if(p.isFlying()){
					p.setFlySpeed((float) 0.2);
					p.sendMessage(Main.pre + flug + args[0]);
					return true;
				} else if(p.isOnGround()) {
					p.setWalkSpeed((float) 0.2);
					p.sendMessage(Main.pre + gehen + args[0]);
					return true;
				}
			} else if(args[0].equals("3")) {
				if(p.isFlying()){
					p.setFlySpeed((float) 0.3);
					p.sendMessage(Main.pre + flug + args[0]);
					return true;
				} else if(p.isOnGround()) {
					p.setWalkSpeed((float) 0.3);
					p.sendMessage(Main.pre + gehen + args[0]);
					return true;
				}
			} else if(args[0].equals("4" )){
				if(p.isFlying()){
					p.setFlySpeed((float) 0.4);
					p.sendMessage(Main.pre + flug + args[0]);
					return true;
				} else if(p.isOnGround()) {
					p.setWalkSpeed((float) 0.4);
					p.sendMessage(Main.pre + gehen + args[0]);
					return true;
				}
			} else if(args[0].equals("5")){
					if(p.isFlying()){
						p.setFlySpeed((float) 0.5);
						p.sendMessage(Main.pre + flug + args[0]);
						return true;
					} else if(p.isOnGround()) {
						p.setWalkSpeed((float) 0.5);
						p.sendMessage(Main.pre + gehen + args[0]);
						return true;
					}
			} else if(args[0].equals("6")){
				if(p.isFlying()){
					p.setFlySpeed((float) 0.6);
					p.sendMessage(Main.pre + flug + args[0]);
					return true;
				} else if(p.isOnGround()) {
					p.setWalkSpeed((float) 0.6);
					p.sendMessage(Main.pre + gehen + args[0]);
					return true;
				}
			} else if(args[0].equals("7")){
				if(p.isFlying()){
					p.setFlySpeed((float) 0.7);
					p.sendMessage(Main.pre + flug + args[0]);
					return true;
				} else if(p.isOnGround()) {
					p.setWalkSpeed((float) 0.7);
					p.sendMessage(Main.pre + gehen + args[0]);
					return true;
				}
			} else if(args[0].equals("8")){
				if(p.isFlying()){
					p.setFlySpeed((float) 0.8);
					p.sendMessage(Main.pre + flug + args[0]);
					return true;
				} else if(p.isOnGround()) {
					p.setWalkSpeed((float) 0.8);
					p.sendMessage(Main.pre + gehen + args[0]);
					return true;
				}
			} else if(args[0].equals("9")){
				if(p.isFlying()){
					p.setFlySpeed((float) 0.9);
					p.sendMessage(Main.pre + flug + args[0]);
					return true;
				} else if(p.isOnGround()) {
					p.setWalkSpeed((float) 0.9);
					p.sendMessage(Main.pre + gehen + args[0]);
					return true;
				}
			} else if(args[0].equals("10")){
				if(p.isFlying()){
					p.setFlySpeed((float) 1.0);
					p.sendMessage(Main.pre + flug + args[0]);
					return true;
				} else if(p.isOnGround()) {
					p.setWalkSpeed((float) 1.0);
					p.sendMessage(Main.pre + gehen + args[0]);
					return true;
				}
			} else if(args[0].equalsIgnoreCase("normal")){
				if(p.isFlying()){
					p.setFlySpeed((float) 0.2);
					p.sendMessage(Main.pre + flug + args[0]);
					return true;
				} else if(p.isOnGround()) {
					p.setWalkSpeed((float) 0.2);
					p.sendMessage(Main.pre + gehen + args[0]);
					return true;
				}
			} else {
				p.sendMessage(Main.pre + "Bitte gib eine Zahl von 1 bis 10 ein!");
				return true;
			} 
		}
		return true;
	}

}
