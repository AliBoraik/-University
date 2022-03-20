package FB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

public class SocialMedia {
    public List<User> users=new LinkedList<>();

    public SocialMedia() {
    }

    public boolean readUsersFromFiles(String pathFile) {
        try {
            BufferedReader readUsers = new BufferedReader(new FileReader(pathFile));
            readUsers.readLine();
            String inFo;
            while (readUsers.ready()) {
                inFo = readUsers.readLine();
                users.add(readUsers(inFo));
            }
            readUsers.close();
            return true;

        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean readSubscriptionsFromFile(String path) {
        try {
            BufferedReader readSubscriptions = new BufferedReader(new FileReader(path));
            String inFo;
            while (readSubscriptions.ready()) {
                inFo = readSubscriptions.readLine();
                String[] subscriptions = inFo.split(" ");
                User user1 = null;
                User user2 = null;
                for (int i = 0; i <= users.size(); i++) {
                    if (user1 == null) {
                        if (users.get(i).getId() == Integer.parseInt(subscriptions[0])) {
                            user1 = users.get(i);
                        }
                    }
                    if (user2 == null) {
                        if (users.get(i).getId() == Integer.parseInt(subscriptions[1])) {
                            user2 = users.get(i);
                        }
                    }
                    if (user1 != null && user2 != null) {
                        break;
                    }
                }
                assert user1 != null;
                assert user2 != null;
                user1.addSubscriptions(user2);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
            return false;
    }
    private User readUsers(String a) throws ParseException {
        User user;
        String[] info=a.split(",");
        user=new User(Integer.parseInt(info[0]),info[1],info[2],info[3],info[4],
                new SimpleDateFormat("dd.MM.yyyy").parse(info[5]),info[6]);
        return user;
    }
    public  List<User> usersHaveSubFrom(String city){
        List<User> usersHaveSubFromBeijing=new LinkedList<>();
        for (int i = 0; i <users.size() ; i++) {
            List<User> subscription = users.get(i).getSubscriptions();
            for (int j = 0; j < subscription.size(); j++) {
                if (subscription.get(j).getCity().equals("Beijing")) {
                    usersHaveSubFromBeijing.add(users.get(i));
                }
            }
        }
        return usersHaveSubFromBeijing;
    }
}