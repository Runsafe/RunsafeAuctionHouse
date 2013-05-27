package no.runsafe.auctionhouse.events;

import no.runsafe.auctionhouse.AuctionHandler;
import no.runsafe.framework.event.inventory.IInventoryClosed;
import no.runsafe.framework.server.event.inventory.RunsafeInventoryCloseEvent;

public class CloseInventory implements IInventoryClosed
{
	public CloseInventory(AuctionHandler auctionHandler)
	{
		this.auctionHandler = auctionHandler;
	}

	@Override
	public void OnInventoryClosed(RunsafeInventoryCloseEvent event)
	{
		this.auctionHandler.checkAuctionStart(event.getPlayer());
	}

	private AuctionHandler auctionHandler;
}
