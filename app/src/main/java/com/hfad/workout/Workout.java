package com.hfad.workout;

public class Workout {

    private String name;
    private String description;

    public Workout(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public static final Workout[] workouts =
            { new Workout("CHOOSE YOUR FAVORITE EXERCISE",
                    " "),
              new Workout("The Limb Loosener",
                      "5 Handstand push-ups\n10 1-legged squats\n15 Pull-ups"),
              new Workout("Core Agony",
                      "100 Pull-ups\n100 Push-ups\n100 Sit-ups\n100 Squats"),
              new Workout("The Wimp Special", "5 Pull-ups\n10 Push-ups\n15 Squats"),

              new Workout("Strength and Length",
                      "500 meter run\n21 x 1.5 pood kettleball swing\n21 x pull-ups"),
              new Workout("Abs Exercise",
                      "100 sit ups\n30crunches\n2 minutes high knees\n30 seconds Russian twists\n30 seconds plank"),

              new Workout("Glutes/Legs",
                      "70 squats\n50 lunges(25 each leg)\n30 second wall sit\n20 donkey kicks(each leg)\n1 minute hip bridges"),
              new Workout("Arms", "10 push-ups\n25 wall push-ups\n2 minute tight arm circles"),
              new Workout("Cardio","50 jumping jacks\n3 minutes hoola hoop\n15-30 minutes on cardio machine"),
              new Workout("Slim Thick Booty",
                      "20 squats x4\n20 lunges x4\n1 minute wall sit x2\n30 jumping squats x4"),
              new Workout("Slim Thick Legs",
                      "2 minute walk sit x2\n30 squats x3\n30 calf raises x3\n50 jumping jacks x3\n10 burpees x2"),
              new Workout("Slim Thick Arms",
                      "5 push ups x3\n10 wall push ups x2\n20 second mermaid twist x2\n45 plank x2"),
              new Workout("Slim Thick Abs",
                      "1 minute plant x2\n50 jumping jacks x3\n1 minute walk sit x2\n10 burpee x3\n30 crunches x2\n30 sit ups x2"),
              new Workout("WEEK WORKOUT",""),
              new Workout("Monday","15 squats X3 || 15 knee push-ups X3\n12 triceps dips X3 || 30 step-ups X3\n16 backwards lungs (8 each leg) X3\n12 overhead triceps || extensions X3"),
              new Workout("Tuesday","16 forward lunges (8 each leg) X3\n15 dumbbell hammer curls X3 || 15 glute bridges X3 || 15 bicep curls X3\n15 dumbbell rows X3\n15 stiff leg deadlifts X3"),
              new Workout("Wednesday","20 Russian twists X3\n30-seconds planks X3\n20 leg raises X3"),
              new Workout("Thursday","15 squats X3 || 15 knee push-ups X3\n12 triceps dips X3 || 30 step ups X3\n16 backward lunges (8 each leg) X3\n 12 overhead tricpes || extension X3"),
              new Workout("Friday","16 forward lunges (6 each leg) X3\n15 dumbbell hammer curls X3\n15 glute bridges X3 || 15 bicep curls X3\n15 dumbbell rows X3 || 15 stiff leg deadlifts X3"),
              new Workout("Saturday","30-45 minutes walking (low-intensity steady state cardio)"),
              new Workout("Sunday","Reset the days")
            };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString( )
    {
        return this.name;
    }
}
