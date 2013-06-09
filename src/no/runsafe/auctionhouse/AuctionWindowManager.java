package no.runsafe.auctionhouse;

import no.runsafe.framework.server.RunsafeServer;
import no.runsafe.framework.server.inventory.RunsafeInventory;
import no.runsafe.framework.server.item.meta.RunsafeMeta;
import no.runsafe.framework.server.player.RunsafePlayer;

import java.util.HashMap;
import java.util.List;

public class AuctionWindowManager
{
	public void openAuctionWindow(RunsafePlayer player)
	{
		player.openInventory(this.getWindow(player));
	}

	public List<RunsafeMeta> getItems(RunsafePlayer player)
	{
		return this.getWindow(player).getContents();
	}

	public boolean hasWindow(RunsafePlayer player)
	{
		return this.windows.containsKey(player.getName());
	}

	public void deleteWindow(RunsafePlayer player)
	{
		this.windows.remove(player.getName());
	}

	private RunsafeInventory getWindow(RunsafePlayer player)
	{
		String playerName = player.getName();
		if (!this.windows.containsKey(playerName))
			this.windows.put(playerName, RunsafeServer.Instance.createInventory(null, 9, "Create New Auction"));

		return this.windows.get(playerName);
	}

	private HashMap<String, RunsafeInventory> windows = new HashMap<String, RunsafeInventory>();
}
