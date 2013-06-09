package no.runsafe.auctionhouse;

import no.runsafe.auctionhouse.database.AuctionsRepository;
import no.runsafe.framework.server.item.RunsafeItemStack;
import no.runsafe.framework.server.item.meta.RunsafeMeta;
import no.runsafe.framework.server.player.RunsafePlayer;
import org.joda.time.DateTime;

import java.util.List;

public class AuctionHandler
{
	public AuctionHandler(AuctionsRepository auctionsRepository, AuctionWindowManager auctionWindowManager)
	{
		this.auctionsRepository = auctionsRepository;
		this.auctionWindowManager = auctionWindowManager;
	}

	public void checkAuctionStart(RunsafePlayer player)
	{
		if (this.auctionWindowManager.hasWindow(player))
		{
			List<RunsafeMeta> items = this.auctionWindowManager.getItems(player);
			Auction auction = new Auction();
			auction.setPlayer(player);
			auction.setEnding(DateTime.now().plusHours(2)); // TODO: Implement time
			auction.setCurrentBid(5, 5, 5); // TODO: Implement current bid
			auction.setBuyoutPrice(10, 10, 10); // TODO: Implement buyout price

			for (RunsafeMeta item : items)
			{
				auction.setItem(item);
				this.auctionsRepository.storeAuction(auction);
			}
		}
	}

	private AuctionsRepository auctionsRepository;
	private AuctionWindowManager auctionWindowManager;
}
