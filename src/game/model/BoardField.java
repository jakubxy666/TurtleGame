package game.model;

public class BoardField {
    private boolean visible;
    private boolean visited = false;

    public BoardField(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
