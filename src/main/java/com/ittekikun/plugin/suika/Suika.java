package com.ittekikun.plugin.suika;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Suika extends JavaPlugin implements Listener
{
    @Override
    public void onEnable()
    {
        //登録
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event)
    {
        //叩いたブロックがメロンであるかどうか
       if(event.getClickedBlock().getType() == Material.MELON_BLOCK)
        {
            //叩いた時に使ったアイテムが棒（スティック）であるかどうか
            if(event.getMaterial() == Material.STICK)
            {
                //ぶち壊す
                event.getClickedBlock().breakNaturally();
            }
        }
    }

    @EventHandler
    public void onEvent(PlayerMoveEvent event)
    {
        Location location = new Location(event.getTo().getWorld(), event.getTo().getX(), event.getTo().getY() - 1, event.getTo().getZ());

        if(location.getBlock().getType() == Material.MELON_BLOCK)
        {
            location.getBlock().breakNaturally();
        }
    }
}