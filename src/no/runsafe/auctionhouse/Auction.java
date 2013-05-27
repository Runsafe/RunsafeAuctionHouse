package no.runsafe.auctionhouse;

import no.runsafe.framework.server.player.RunsafePlayer;
import org.joda.time.DateTime;

public class Auction
{
	public Auction(int ID)
	{
		this.ID = ID;
	}

	public int getID()
	{
		return this.ID;
	}

	public void setPlayer(RunsafePlayer player)
	{
		this.owner = player;
	}

	public RunsafePlayer getPlayer()
	{
		return this.owner;
	}

	public DateTime getEnding()
	{
		return this.ends;
	}

	public void setEnding(DateTime ending)
	{
		this.ends = ending;
	}

	public void setCurrentBid(int low, int med, int high)
	{
		this.currentBid = new int[] {low, med, high};
	}

	public void setBuyoutPrice(int low, int med, int high)
	{
		this.buyoutPrice = new int[] {low, med, high};
	}

	public int[] getCurrentBid()
	{
		return this.currentBid;
	}

	public int[] getBuyoutPrice()
	{
		return this.buyoutPrice;
	}

	private int ID;
	private RunsafePlayer owner;
	private DateTime ends;
	private int[] currentBid;
	private int[] buyoutPrice;
}
