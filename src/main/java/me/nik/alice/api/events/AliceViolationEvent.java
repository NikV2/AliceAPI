package me.nik.alice.api.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public final class AliceViolationEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final String checkName;
    private final String description;
    private final String type;
    private final String information;
    private final int vl;
    private final int maxVl;
    private final boolean experimental;
    private final boolean alert;
    private boolean cancel = false;

    /**
     * This event will not always be called Async, So beware.
     */
    public AliceViolationEvent(Player player, String checkName, String description, String type, String information, int vl, int maxVl, boolean experimental, boolean alert) {
        super(!Bukkit.isPrimaryThread());
        this.player = player;
        this.checkName = checkName;
        this.description = description;
        this.type = type;
        this.information = information;
        this.vl = vl;
        this.maxVl = maxVl;
        this.experimental = experimental;
        this.alert = alert;
    }

    public boolean isCancelled() {
        return this.cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * @return The check included in this event
     */
    public String getCheck() {
        return checkName;
    }

    /**
     * @return The check's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return The type of the check included in this event
     */
    public String getType() {
        return type;
    }

    /**
     * @return The total violation amount
     */
    public int getVl() {
        return vl;
    }

    /**
     * @return The maximum violation amount
     */
    public int getMaxVl() {
        return maxVl;
    }

    /**
     * @return The information of why the player failed this check
     */
    public String getInformation() {
        return information;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * @return The player involved in this event
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @return Whether or not the check is in an experimental state
     */
    public boolean isExperimental() {
        return experimental;
    }

    /**
     * @return Whether or not an alert will be sent
     */
    public boolean hasAlert() {
        return alert;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}