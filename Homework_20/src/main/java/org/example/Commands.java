package org.example;
    enum Commands{
        GET_RANDOM_QUESTION_BY_TOPIC("G1 (Get random question by topic)"),
        GET_RANDOM_QUESTION("G2 (Get random question among all questions)"),
        ADD_QUESTION("A1 (Add questions)"),
        REMOVE_QUESTION("R1 (Remove selected questions)"),
        GET_TOPIC("G3 (Get topics)"),
        ADD_TOPIC("A2 (Add topics)");
        String command;
        Commands(String command){
            this.command = command;
        }

}
