public class Gameplay {
public static void main(String[] args){
        RedAstronaut player1 = new RedAstronaut("Bobby", 28, "experiEnced");
        BlueAstronaut player2 = new BlueAstronaut("Bob", 19, 5, 10);
        BlueAstronaut player3 = new BlueAstronaut("Nissi", 22, 8, 45);
        BlueAstronaut player4 = new BlueAstronaut("Bissi");
        BlueAstronaut player5 = new BlueAstronaut("Tissi", 46, 16, 10);
        BlueAstronaut player6 = new BlueAstronaut("McWissi", 21, 4, 52);
        RedAstronaut player7 = new RedAstronaut("Drissel", 20,"ExPert");

        System.out.println(player1.toString());
        System.out.println(player2.toString());
        System.out.println(player3.toString());
        System.out.println(player4.toString());
        System.out.println(player5.toString());
        System.out.println(player6.toString());
        System.out.println(player7.toString());

        player4.emergencyMeeting();
        player1.freeze(player2);
        player3.emergencyMeeting();
        player6.completeTask();
        player6.completeTask();
        player6.completeTask();
        player6.completeTask();
        player1.freeze(player3);
        player7.sabotage(player5);
        player1.sabotage(player3);
        player7.sabotage(player6);
        player1.freeze(player6);
        player7.emergencyMeeting();
        System.out.println("======================================================");
        player7.emergencyMeeting();
        System.out.println("======================================================");
        player7.emergencyMeeting();
        System.out.println("======================================================");
        player7.emergencyMeeting();
        System.out.println("======================================================");
        player2.emergencyMeeting();
        System.out.println("======================================================");
        System.out.println(player1.toString());
        System.out.println(player2.toString());
        System.out.println(player3.toString());
        System.out.println(player4.toString());
        System.out.println(player5.toString());
        System.out.println(player6.toString());
        System.out.println(player7.toString());
}
}
