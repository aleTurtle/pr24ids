package it.unicam.progettoids2324.entities;


    public enum ContestState {
        CREATED,
        OPEN,
        CLOSED;

        public static ContestState fromString(String state) {
            return switch (state) {
                case "CREATED" -> CREATED;
                case "OPEN" -> OPEN;
                case "CLOSED" -> CLOSED;
                default -> throw new IllegalArgumentException("Invalid contest state");
            };
        }
    }


