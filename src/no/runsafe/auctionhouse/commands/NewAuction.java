package no.runsafe.auctionhouse.commands;

import no.runsafe.auctionhouse.AuctionWindowManager;
import no.runsafe.framework.command.player.PlayerCommand;
import no.runsafe.framework.server.player.RunsafePlayer;

import java.util.HashMap;

public class NewAuction extends PlayerCommand
{
	public NewAuction(AuctionWindowManager auctionWindowManager)
	{
		super("auction", "Creates a new auction", "runsafe.auction.create");
		this.auctionWindowManager = auctionWindowManager;
	}

	@Override
	public String OnExecute(RunsafePlayer executor, HashMap<String, String> parameters)
	{
		this.auctionWindowManager.openAuctionWindow(executor);
		return null;
	}

	private AuctionWindowManager auctionWindowManager;
}
