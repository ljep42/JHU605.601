package game;

public class Messaging 
{
	/***
	 * 
	 * @param character Character to move
	 * @param startLocation	Starting Location
	 * @param endLocation Ending Location
	 * @return String to send to Server
	 */
	public static String buildMove(String character, String startLocation, String endLocation)
	{
		String rs = "";
		rs = character + "," + startLocation + "," + endLocation; 
		return rs;
	}
	
	/***
	 * 
	 * @param message Message received from the client.
	 * @return Array with details concerning the move (Character, Starting Location, Ending Location)
	 */
	public static String[] readMove(String message)
	{
		String[] ra = message.split(",");
		return ra;
	}
}
