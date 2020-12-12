package nl.mwensveen.adventofcode.year_2020.day_12;

import java.util.List;

public class ShipMover {

    public Position moveShip(List<Instruction> input) {
        Position position = new Position(0, 0);
        input.stream().forEach(instr -> move(position, instr));
        return position;
    }

    public Position moveShipAndWaypoint(List<Instruction> instructions, int startEast, int startNorth) {
        Position ship = new Position(0, 0);
        Position waypoint = new Position(-startNorth, startEast);
        instructions.forEach(inst -> moveShipAndWaypoint(ship, waypoint, inst));
        return ship;
    }

    private void moveShipAndWaypoint(Position ship, Position waypoint, Instruction instr) {
        switch (instr.getAction()) {
            case NORTH:
                waypoint.addNorthSouth(-instr.getValue());
                break;
            case EAST:
                waypoint.addWestEast(instr.getValue());
                break;
            case SOUTH:
                waypoint.addNorthSouth(instr.getValue());
                break;
            case WEST:
                waypoint.addWestEast(-instr.getValue());
                break;
            case RIGHT:
                for (int i = 0; i < instr.getValue() / 90; i++) {
                    int ns = waypoint.getNorthSouth();
                    int we = waypoint.getWestEast();
                    waypoint.setWestEast(-ns);
                    waypoint.setNorthSouth(we);
                }
                break;
            case LEFT:
                for (int i = 0; i < instr.getValue() / 90; i++) {
                    int ns = waypoint.getNorthSouth();
                    int we = waypoint.getWestEast();
                    waypoint.setWestEast(ns);
                    waypoint.setNorthSouth(-we);
                }
                break;
            case FORWARD:
                ship.addNorthSouth(waypoint.getNorthSouth() * instr.getValue());
                ship.addWestEast(waypoint.getWestEast() * instr.getValue());
                break;
            default:
                throw new RuntimeException("not processed " + instr.getAction());
        }
    }

    private void move(Position position, Instruction instr) {
        switch (instr.getAction()) {
            case NORTH:
                position.addNorthSouth(-instr.getValue());
                break;
            case EAST:
                position.addWestEast(instr.getValue());
                break;
            case SOUTH:
                position.addNorthSouth(instr.getValue());
                break;
            case WEST:
                position.addWestEast(-instr.getValue());
                break;
            case RIGHT:
                rotateRight(position, instr.getValue());
                break;
            case LEFT:
                rotateLeft(position, instr.getValue());
                break;
            case FORWARD:
                move(position, Instruction.builder().withActions(position.getDirection()).withValue(instr.getValue()).build());
                break;
            default:
                throw new RuntimeException("not processed " + instr.getAction());
        }
    }

    private void rotateLeft(Position position, Integer value) {
        int count = value / 90;
        for (int i = 0; i < count; i++) {
            switch (position.getDirection()) {
                case NORTH:
                    position.setDirection(Direction.WEST);
                    break;
                case EAST:
                    position.setDirection(Direction.NORTH);
                    break;
                case SOUTH:
                    position.setDirection(Direction.EAST);
                    break;
                case WEST:
                    position.setDirection(Direction.SOUTH);
                    break;
                default:
                    throw new RuntimeException("Problem rotating left " + position.getDirection());
            }
        }
    }

    private void rotateRight(Position position, Integer value) {
        int count = value / 90;
        for (int i = 0; i < count; i++) {
            switch (position.getDirection()) {
                case NORTH:
                    position.setDirection(Direction.EAST);
                    break;
                case EAST:
                    position.setDirection(Direction.SOUTH);
                    break;
                case SOUTH:
                    position.setDirection(Direction.WEST);
                    break;
                case WEST:
                    position.setDirection(Direction.NORTH);
                    break;
                default:
                    throw new RuntimeException("Problem rotating left " + position.getDirection());
            }
        }
    }
}
