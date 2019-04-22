package game;

public class Messaging 
{
	/***
	 * Prepares a move message to be sent to the server.
	 * @param endLocation
	 * @param characterName
	 * @param clientID
	 * @return
	 */
	public static String sendPlayerMove(Location endLocation, String characterName, int clientID )
	{
		return "101," + endLocation.getLocation()[0] + "," + endLocation.getLocation()[1] + "," + characterName + "," + clientID;
	}
	
	/***
	 * Convert the player move message to an array.
	 * @param message
	 * @return
	 */
	public static String[] receivePlayerMove(String message)
	{
		return message.split(",");
	}
	
	/***
	 * Used to update clients when another client moves.
	 * @param endLocation
	 * @param characterName
	 * @return
	 */
	public static String updateClientsOnMove(Location endLocation, String characterName)
	{
		return "000," + characterName + " moved to " + endLocation.getLocation().toString(); 
	}
	
	/***
	 * Prepares a suggestion message to send to the server.
	 * @param character The character BEING ACCUSED
	 * @param weapon
	 * @param characterName The character ACCUSING
	 * @param clientID
	 * @return
	 */
	public static String sendSuggestion(String character, String weapon, String characterName, int clientID)
	{
		return "201," + character + "," + weapon + "," + characterName + "," + clientID;
	}
	
	public static String[] receiveSuggestion(String message)
	{
		return message.split(",");
	}
	
	public static String updateClientsOnSuggestion(String character, String weapon, String room, String characterName)
	{
		return "000," + characterName + " is suggesting " + character + " with the " + weapon + " in the " + room + ".";
	}
	
	/***
	 * Prepares an accusation message to send to the server.
	 * @param character
	 * @param weapon
	 * @param room
	 * @param characterName
	 * @param clientID
	 * @return
	 */
	public static String sendAccusation(String character, String weapon, String room, String characterName, int clientID)
	{
		return "301," + character + "," + weapon + "," + characterName + "," + clientID;
	}
	
	public static String[] receiveAccusation(String message)
	{
		return message.split(",");
	}
	
	public static String updateClientsOnAccusation(String character, String weapon, String room, String characterName)
	{
		return "000," + characterName + " is suggesting " + character + " with the " + weapon + " in the " + room + ".";
	}
	
	/***
	 * Prepares a refute accusation message to send to the server.
	 * @param character
	 * @param refuteType
	 * @param refuteValue
	 * @param clientID
	 * @return
	 */
	public static String sendRefuteAccusation(String character, String refuteType, String refuteValue, int clientID)
	{
		return "302," + character + "," + refuteType + "," + refuteValue + "," + clientID;
	}
	
	public static String[] receiveRefuteAccusation(String message)
	{
		return message.split(",");
	}
	
	/***
	 * Updates clients on refute accusation.
	 * @param character  The character refuting the accusation/suggestion.
	 * @param refuteValue
	 * @return
	 */
	public static String updateClientsOnRefuteAccusation(String character, String refuteValue)
	{
		return "000," + character + " is refuting " + refuteValue;
	}
	
	/***
	 * Updates clients on an incorrect accusation.  It's assumed that the server will never tell the particular client its their turn again.
	 * @param character
	 * @return
	 */
	public static String updateClientsOnIncorrectAccusation(String character)
	{
		return "000," + character + " made an incorrect accusation!  They lose!";
	}
	
	public static String sendCorrectAccusationMessage(String character)
	{
		return "401," + character + " made a correct accusation!  They win the game!";
	}
	
}
