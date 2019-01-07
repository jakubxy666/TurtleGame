package game.model;

public enum MoveType {
    Up, Down, Left, Right, RLeft, RRight;

    public static MoveType forward(Orientation o){
        switch (o){
            case N:
                return Up;
            case W:
                return Left;
            case S:
                return Down;
            case E:
                return Right;
            default:
                return null;
        }
        //return null;
    }

    public static MoveType rotate(Orientation from, Orientation to){
        if (from == Orientation.E && to == Orientation.N) return RLeft;
        if (from == Orientation.N && to == Orientation.E) return RRight;

        if (from.ordinal() < to.ordinal()){
            return RLeft;
        } else return RRight;
    }
}
