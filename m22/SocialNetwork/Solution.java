import java.util.Scanner;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args)throws Exception {
		SocialNetwork obj = new SocialNetwork();
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(" ");
			switch (tokens[0]) {
				case "Create":
					obj.createDataStructure(
						Integer.parseInt(tokens[1]), scan);
				break;

				case "Network":
					System.out.println(obj);
				break;

				case "addConnections":
					obj.addConnection(tokens[1], tokens[2]);
				break;

				case "CommonConnections":
					System.out.println(
						obj.getCommonConnections(tokens[1], tokens[2]));
				break;

				case "getConnections":
				List<String> frnds = obj.getConnections(tokens[1]);
				if (frnds != null) {
					System.out.println(frnds);
				} else {
					System.out.println("Not a user in Network");
				}
				break;
			}
		}
		
	}
}


class User {
	private String username;
	private List<String> friends;

	User(String uname, List<String> friendsList) {
		this.username = uname;
		this.friends = friendsList;
	}

	public String getUserName() {
		return this.username;
	}

	public List<String> getFriends() {
		return this.friends;
	}
}

class SocialNetwork {
	private List<User> network;

	SocialNetwork() {
		network = new List<User>();
	}

	public void createDataStructure(int line, Scanner scan) {
		for (int j = 0; j < line; j++) {
			String[] lines = scan.nextLine().replace(".",
				"").split(" is connected to ");
			List<String> friends = new List<String>();
			String[] tokens = lines[1].split(", ");
			for (int i = 0; i < tokens.length; i++) {
				friends.add(tokens[i]);
			}
			network.add(new User(lines[0], friends));
		}
	}

	private int getIndexByName(String username) {
		for (int i = 0; i < network.size(); i++) {
			if (network.get(i).getUserName().equals(username)) {
				return i;
			}
		}
		return -1;
	}

	public void addConnection(String userOne, String userTwo) {
		int indexOne = getIndexByName(userOne);
		int indexTwo = getIndexByName(userTwo);
		if (indexOne != -1 && indexTwo != -1) {
			network.get(indexOne).getFriends().add(userTwo);
		} else {
			System.out.println("Not a user in Network");
		}
	}

	public List<String> getConnections(String user) {
		int index = getIndexByName(user);
		if ( index != -1) {
			return network.get(index).getFriends();
		}
		return null;
	}

	public List<String> getCommonConnections(String userOne, String userTwo) {
		List<String> friendsOne = getConnections(userOne);
		List<String> friendsTwo= getConnections(userTwo);
		List<String> friends = new List<String>();
		if (friendsOne != null && friendsTwo != null) {
			for (int i = 0; i < friendsOne.size(); i++) {
				if (friendsTwo.contains(friendsOne.get(i))) {
					friends.add(friendsOne.get(i));
				}
			}
		}
		return friends;
	}

	public String toString() {
		String[] keys = new String[network.size()];
		for (int i = 0; i < network.size(); i++) {
			keys[i] = network.get(i).getUserName();
		}
		Arrays.sort(keys);
		String s = "";
		int j;
		for (j = 0; j < keys.length - 1; j++) {
			s += keys[j] + ": " + getConnections(keys[j]) + ", ";
		}
		s += keys[j] + ": ";
		s += getConnections(keys[j]);
		return s;
	}
}
