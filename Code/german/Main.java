package de.dnick.blackwords;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
	@Override
	public void onEnable() {
		//Register this plugin
		this.getServer().getPluginManager().registerEvents(this, this);
		
		//Finish
		System.out.print("§7[§4§lBad§a§lWords§7] §aPlugin wurde aktiviert!");
	}
	
	@EventHandler
	public void on(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String msg = e.getMessage();
		
		//Blacklist, wenn du ein Wort hinzufügen willst mache eine neue Zeile und schreibe: blocked.add("YOUR WORD");
		List<String> blocked = new ArrayList<String>();
		blocked.add("bastard");
		blocked.add("bastart");
		blocked.add("bollocks");
		blocked.add("cunt");
		blocked.add("ficker");
		blocked.add("fotze");
		blocked.add("hure");
		blocked.add("hurendaughter");
		blocked.add("hurendaugter");
		blocked.add("hurensohn");
		blocked.add("hurenson");
		blocked.add("huso");
		blocked.add("hurentochter");
		blocked.add("hutensohn");
		blocked.add("misset");
		blocked.add("motherfucker");
		blocked.add("nuttensohn");
		blocked.add("nuttentochter");
		blocked.add("penis");
		blocked.add("prick");
		blocked.add("Scheiße");
		blocked.add("spasst");
		blocked.add("spast");
		blocked.add("spaßt");
		blocked.add("wixer");
		blocked.add("wixxer");
		//--> Ende
		
		for(String block : blocked) {
			if(msg.contains(block)) {
				String replace = "";
				for(int i = 0; i < block.length(); i++) {
					replace = replace + "#"; //Standartmäßig ersetzt mit: #
				}
				if(!(p.hasPermission("badword.exempt"))) { //Standard Ausnahme Berechtigung: badword.exempt
					String newmsg = msg.replace(block, replace);
					e.setMessage(newmsg);
					p.sendMessage("§7[§4§lBad§a§lWords§7] §aDu verwendest unangemessene Wörter in deiner letzten Nachricht! §7[§4Gesperrtes Wort: §a§l" +block+ "§7]"); //Warnung, dass ein Wort geblockt ist (Ohne Berechtigung)
				} else {
					@SuppressWarnings("unused")
					String newmsg = msg.replace(block, replace);
					p.sendMessage("§7[§4§lBad§a§lWords§7] §aDu hast eine besondere Vorbildsfunktion auf diesen Server, darum solltest du dich angemessen verhalten! Wir haben diese Nachricht trotzdem freigegeben, da du eine ausnahme Berechtigung hast. §7[§4Gesperrtes Wort: §a§l" +block+ "§7]"); //Warnung, dass ein Wort geblockt ist (mit Berechtigung)
				}
			}
		}
	}
	
}
