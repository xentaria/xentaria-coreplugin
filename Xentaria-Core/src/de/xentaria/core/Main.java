package de.xentaria.core;

import java.io.File;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import de.xentaria.core.Befehle.ChatClear;
import de.xentaria.core.Befehle.FarmenCommand;
import de.xentaria.core.Befehle.FlyCommand;
import de.xentaria.core.Befehle.GameMode;
import de.xentaria.core.Befehle.HealCommand;
import de.xentaria.core.Befehle.HelpCmd;
import de.xentaria.core.Befehle.IpCommand;
import de.xentaria.core.Befehle.SpeedCommand;
import de.xentaria.core.Befehle.TpCommand;
import de.xentaria.core.Befehle.WetterCommand;
import de.xentaria.core.Listener.GamemodeEvent;
import de.xentaria.core.Listener.Joinlistener;
import de.xentaria.core.Listener.PlugListener;
import de.xentaria.core.Listener.PluginListener;
import de.xentaria.core.Listener.ReloadNachricht;
import de.xentaria.core.Listener.RespawnListener;
import de.xentaria.core.Manager.Warpmanager;
import net.milkbowl.vault.permission.Permission;

public class Main extends JavaPlugin{

	public static String pre = "�7[�4Xentaria.de�7] �b";
	public static String farbe = "�b ";
	public static String noperm = pre + "�bDaf�r hast du keine Berechtigungen!";
	public static String noplayer = "Du bist eine Konsole. Die darf das nicht :/";
	public static String falsch = pre + "�bDu hast den Command falsch genutzt!";
	public static Permission permission = null;
	public Main plugin;
    private boolean vault;
	public static Warpmanager wmgr;
	
	@Override
	public void onDisable() {
		
				
		System.out.println("[Xentaria.de] Das Plugin wurde deaktiviert!");
	}
	
	
	@Override
	public void onEnable(){
		System.out.println("[Xentaria.de] > Wird geladen...");
		new File("plugins/Xentaria").mkdirs();
		new File("plugins/Xentaria/Spieler").mkdirs();
		new File("plugins/Xentaria/Homes").mkdirs();
		new File("plugins/Xentaria/Spawns").mkdirs();
		new File("plugins/Xentaria/Permissions").mkdirs();
		new File("plugins/Xentaria/Money").mkdirs();
		if(!setupPermissions()){
			System.out.println("[Xentaria.de] Das Plugin ben�tigt Vault!");
			Bukkit.getPluginManager().disablePlugin(this);
		}
		
		registerCommands();
		registerEvents();
		
		this.vault = (Bukkit.getPluginManager().getPlugin("Vault") != null);
		super.onEnable();
		saveDefaultConfig();
		System.out.println("[Xentaria.de] > Geladen... ");		
		
		getCommand("cc").setExecutor(new ChatClear());
		//getCommand("setspawn").setExecutor(new Setspawn());
		//getCommand("spawn").setExecutor(new Spawn());
		//getCommand("gamemode").setExecutor(new GameMode());
		//getCommand("home").setExecutor(new HomeCommand());
		//getCommand("sethome").setExecutor(new SethomeCommand());
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("sun").setExecutor(new WetterCommand());
		getCommand("fly").setExecutor(new FlyCommand());
		getCommand("speed").setExecutor(new SpeedCommand());
		getCommand("teleport").setExecutor(new TpCommand());
		getCommand("farmen").setExecutor(new FarmenCommand());
		getCommand("ip").setExecutor(new IpCommand(this));
		//getCommand("warp").setExecutor(new WarpCommand());
		//getCommand("setwarp").setExecutor(new SetwarpCommand());
		//getCommand("delwarp").setExecutor(new DelwarpCommand());
		PluginManager pm = Bukkit.getPluginManager();
		//pm.registerEvents(new PluginListener(), this);
		pm.registerEvents(new ReloadNachricht(), this);
		pm.registerEvents(new HelpCmd(), this);
		pm.registerEvents(new Joinlistener(), this);
		//pm.registerEvents(new GamemodeEvent(), this);
		pm.registerEvents(new PlugListener(), this);
		pm.registerEvents(new GameMode(), this);
	}

	
	 public void registerEvents() {
	}


	public void registerCommands() {

	}


	public static File getPlayerFile(UUID arg0) {
	      File file = new File("plugins/Xentaria/Spieler", arg0.toString() + ".yml");
	      return file;
	   }
	   
	   public static YamlConfiguration getPlayerCfg(UUID arg0) {
	      YamlConfiguration playerscfg = YamlConfiguration.loadConfiguration(getPlayerFile(arg0));
	      return playerscfg;
	   }
	   
	   public static boolean existPlayerFile(UUID arg0) {
	      if(getPlayerFile(arg0).exists()) {
	         return true;
	      } else {
	         return false;
	      }
	   }
	   
	   private boolean setupPermissions()
	    {
	        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
	        if (permissionProvider != null) {
	            permission = permissionProvider.getProvider();
	        }
	        return (permission != null);
	    }
	   
}
