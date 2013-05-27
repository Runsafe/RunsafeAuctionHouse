package no.runsafe.auctionhouse;

import no.runsafe.framework.server.RunsafeServer;
import no.runsafe.framework.server.inventory.RunsafeInventory;
import no.runsafe.framework.server.player.RunsafePlayer;

import java.util.HashMap;

public class AuctionWindowManager
{
	public void openAuctionWindow(RunsafePlayer player)
	{
		String playerName = player.getName();
		if (!this.windows.containsKey(playerName))
			this.windows.put(playerName, RunsafeServer.Instance.createInventory(null, 9, "Create New Auction"));

		player.openInventory(this.windows.get(playerName));
	}

	private HashMap<String, RunsafeInventory> windows = new HashMap<String, RunsafeInventory>();
}
