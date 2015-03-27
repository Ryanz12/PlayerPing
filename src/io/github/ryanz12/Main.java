package io.github.ryanz12;

import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class Main extends Plugin implements Listener{
	@Override
	public void onEnable(){
		this.getProxy().getPluginManager().registerListener(this, this);
	}
	
	@EventHandler
	public void onPing(ProxyPingEvent e){
		ServerPing ping = e.getResponse();
		ping.getPlayers().setMax(ping.getPlayers().getOnline()+1);
		e.setResponse(ping);
	}
	
	@Override public void onDisable(){}
}
