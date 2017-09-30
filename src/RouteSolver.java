import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by akos on 2017.09.29..
 */
public class RouteSolver
{

    public List<RouteNode> figureRoute(List<RouteNode> nodes)
    {
        /* It takes the list of nodes, passes it to determine the root node.
        Assuming the nodes without a pre-requisite are not to be sorted.
        if route is null, the input is not proper
        */List<RouteNode> sortedRoute = new ArrayList<>();
        int routeLength = nodes.size();

        RouteNode lastSorted = determineRootNode(nodes);
        nodes.remove(lastSorted);
        sortedRoute.add(lastSorted);

        int indexOfNode = 0;
        RouteNode current;
        while(sortedRoute.size() <= routeLength)
        {
            if (nodes.size() == 0)
            {
                return sortedRoute;
            }
            current = nodes.get(indexOfNode);
            if(current.getPrevNode() != null)
            {
                if (lastSorted.equals(current.getPrevNode()))
                {
                    lastSorted = current;
                    sortedRoute.add(current);
                    indexOfNode++;
                    nodes.remove(current);
                }
            }
            else
                {
                    lastSorted = current;
                    sortedRoute.add(current);
                    nodes.remove(current);
                    indexOfNode++;
                }
            indexOfNode ++;
            if (indexOfNode > nodes.size()-1)
            {
                indexOfNode = 0;
            }
        }

        return sortedRoute;
    }

    public RouteNode determineRootNode(List<RouteNode> nodes)
    {
        // get the first node that have no pre requisite.
        for (RouteNode node:nodes)
        {
            if (node.getPrevNode() == null)
            {
                return node;
            }
        }
        //Lets the user know about the problem
        System.out.println("Cannot determine root node. Wrong input. Exiting");
        // if every node has a pre requisite, then the input is not proper. The method then returns null;
        System.exit(-1);
        return null;
    }

}
