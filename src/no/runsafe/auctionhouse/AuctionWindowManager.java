package no.runsafe.auctionhouse;

import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.RunsafeServer;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

import java.util.HashMap;
import java.util.List;

public class AuctionWindowManager
{
	public void openAuctionWindow(IPlayer player)
	{
		player.openInventory(this.getWindow(player));
	}

	public List<RunsafeMeta> getItems(IPlayer player)
	{
		return this.getWindow(player).getContents();
	}

	public boolean hasWindow(IPlayer player)
	{
		return this.windows.containsKey(player.getName());
	}

	public void deleteWindow(IPlayer player)
	{
		this.windows.remove(player.getName());
	}

	private RunsafeInventory getWindow(IPlayer player)
	{
		String playerName = player.getName();
		if (!this.windows.containsKey(playerName))
			this.windows.put(playerName, RunsafeServer.Instance.createInventory(null, 9, "Create New Auction"));

		return this.windows.get(playerName);
	}

	private HashMap<String, RunsafeInventory> windows = new HashMap<String, RunsafeInventory>();
}
