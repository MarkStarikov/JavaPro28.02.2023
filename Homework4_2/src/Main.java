public class Main {
    public static void main(String[] args) {
        Participant[] participants = {
                new Human(401, 2, "Petro"),
                new Cat(30, 1, "Murchik"),
                new Bot(500, 4, "T-1000")
        };
        Obstacle[] obstacles = {
                new Treadmill(400, 0,"Treadmill model-5"),
                new Wall(0, 3,"Wall model-23"),
        };
        startCompetition(participants, obstacles);

    }


    public static void startCompetition (Participant[] participants, Obstacle[] obstacles) {
        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                if (!obstacle.toOvercome(participant)) {
                    if (!obstacle.toOvercome(participant) && obstacle.getLength() < participant.getMaxParameterDistance()){
                        System.out.println("Participant " + participant.getName() + " did not pass the obstacle " + obstacle.getName() + " at the distance " + obstacle.chekingObstacle(participant) + " Passed 400 m " );
                        break;
                    }
                    System.out.println("Participant " + participant.getName() + " did not pass the obstacle " + obstacle.getName() + " at the distance " + obstacle.chekingObstacle(participant) + " Passed " +obstacle.getHight()+ " m");
                    break;
                }
                System.out.println("Participant " + participant.getName() + "  passed the obstacle " + obstacle.getName() + " at the distance " + obstacle.chekingObstacle(participant)+ " m");

                /*if (!obstacle.toOvercome(participant)) {
                    System.out.println("Participant " + participant + " did not pass the obstacle " + obstacle + " at the high " + obstacle.getHight() + ". Passed " + obstacle.getLength());
                    break;
                }
                else {
                    System.out.println("Participant " + participant + "  passed the obstacle " + obstacle + " at the high " + obstacle.getHight());
                } */

            }
        }

    }

}