package no.runsafe.auctionhouse.commands;

import no.runsafe.auctionhouse.AuctionWindowManager;
import no.runsafe.framework.api.command.argument.IArgumentList;
import no.runsafe.framework.api.command.player.PlayerCommand;
import no.runsafe.framework.api.player.IPlayer;

import java.util.Map;

public class NewAuction extends PlayerCommand
{
	public NewAuction(AuctionWindowManager auctionWindowManager)
	{
		super("auction", "Creates a new auction", "runsafe.auction.create");
		this.auctionWindowManager = auctionWindowManager;
	}

	@Override
	public String OnExecute(IPlayer executor, IArgumentList parameters)
	{
		this.auctionWindowManager.openAuctionWindow(executor);
		return null;
	}

	private AuctionWindowManager auctionWindowManager;
}
