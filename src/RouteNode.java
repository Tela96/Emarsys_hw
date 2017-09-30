/**
 * Created by akos on 2017.09.29..
 */
public class RouteNode
{
    private String label;
    private RouteNode prevNode;

    public RouteNode(String label, RouteNode prevNode)
    {
        this.label = label;
        this.prevNode = prevNode;
    }

    public RouteNode(String label)
    {
        this.label = label;
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public RouteNode getPrevNode()
    {
        return prevNode;
    }

    public void setPrevNode(RouteNode prevNode)
    {
        this.prevNode = prevNode;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RouteNode routeNode = (RouteNode) o;

        return label.equals(routeNode.label);
    }

    @Override
    public int hashCode()
    {
        return label.hashCode();
    }

    @Override
    public String toString()
    {
        return "RouteNode{" +
                "label='" + label + '\'' +
                ", prevNode=" + prevNode +
                '}';
    }
}
