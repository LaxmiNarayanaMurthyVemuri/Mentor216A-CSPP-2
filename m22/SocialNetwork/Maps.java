import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Hashtable;
import java.util.Arrays;
import java.util.Set;


class SocialNetwork {

	private Hashtable<String, List<String>> network;

	public SocialNetwork() {
		network = new Hashtable<String, List<String>>();

	}

	public void createDataStructure(int line, Scanner scan) {
		while (line > 0) {
			String[] lines = scan.nextLine().replace(".",
				"").split(" is connected to ");
			List<String> friends = new ArrayList<String>();
			String[] tokens = lines[1].split(", ");
			for (int i = 0; i < tokens.length; i++) {
				friends.add(tokens[i]);
			}
			network.put(lines[0], friends);
			line--;
		}
	}

	public void addConnection(String userOne, String userTwo) {
		List<String> friends = network.get(userOne);
		if (friends != null) {
			friends.add(userTwo);
		}
	}

	public List<String> getConnections(String user) {
		return network.get(user);
	}

	public List<String> getCommonConnections(String userOne, String userTwo) {
		List<String> friendsOne = getConnections(userOne);
		List<String> friendsTwo= getConnections(userTwo);
		List<String> friends = new ArrayList<String>();
		for (int i = 0; i < friendsOne.size(); i++) {
			if (friendsTwo.contains(friendsOne.get(i))) {
				friends.add(friendsOne.get(i));
			}
		}
		return friends;
	}

	public String toString() {
		Object[] keys = network.keySet().toArray();
		Arrays.sort(keys);
		String s = "";
		int i;
		for (i = 0; i < keys.length - 1; i++) {
			s += keys[i]+ ": " + network.get(keys[i]) + ", ";
		}
		s += keys[i]+ ": ";
		s += network.get(keys[i]);
		return s;
	}
}


public class Maps {
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
				List<String> friends = obj.getCommonConnections(tokens[1], tokens[2]);		
				if(friends == null) {
					System.out.println("No Common Friends");
				} else {
					System.out.println(friends);
				}
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