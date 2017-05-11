package com.ittekikun.plugin.suika;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
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
    public void onEvent(PlayerInteractEvent event)
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
}