import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Ander Swartz
 *
 */
public class GraphTester {


	/**
	 * Returns true if a path exists on graph, from startVertex to endVertex; 
	 * otherwise returns false. Uses breadth-first search algorithm.
	 * @param graph
	 * @param startVertex
	 * @param endVertex
	 * @return
	 */
	private static boolean isPathBF(GraphInterface<String> graph,
			String startVertex, 
			String endVertex    ) {

		Queue<String> queue = new ArrayDeque<String>();
		Queue<String> vertexQueue = new ArrayDeque<String>();

		boolean found = false;
		String currVertex;      // vertex being processed
		String adjVertex;       // adjacent to currVertex

		graph.clearMarks();
		graph.markVertex(startVertex);
		queue.add(startVertex);

		do
		{
			currVertex = queue.remove();
			// System.out.println(currVertex);
			if (currVertex.equals(endVertex))
				found = true;
			else
			{
				vertexQueue = graph.getToVertices(currVertex); 
				while (!vertexQueue.isEmpty())
				{
					adjVertex = vertexQueue.remove();
					if (!graph.isMarked(adjVertex))
					{
						graph.markVertex(adjVertex);
						queue.add(adjVertex);
					}
				}
			}
		} while (!queue.isEmpty() && !found);

		return found;
	}


	public static void main(String[] args) {

		UndirectedGraph<String> graph = new UndirectedGraph<>();
		String bob = "Bob";
		String jack = "Jack";
		String cynthia = "Cynthia";
		String alex = "Alex";
		String cathy = "Cathy";
		String george = "George";
		String colleen = "Colleen";
		String kevin = "Kevin";
		graph.addVertex(bob);
		graph.addVertex(jack);
		graph.addVertex(cynthia);
		graph.addVertex(alex);
		graph.addVertex(cathy);
		graph.addVertex(george);
		graph.addVertex(colleen);
		graph.addVertex(kevin);


		graph.addEdge(bob, jack);
		graph.addEdge(bob, cynthia);
		graph.addEdge(bob, alex);
		graph.addEdge(cynthia, alex);
		graph.addEdge(alex, cathy);
		graph.addEdge(kevin,colleen);
		graph.addEdge(kevin,george);


		System.out.println("Bob's friends are "+graph.getToVertices(bob));
		System.out.println("Alex's friends are "+graph.getToVertices(alex));
		System.out.println("George's friends are "+graph.getToVertices(george));
		System.out.println("Are Jack and Cathy indirect friends?: "+(isPathBF(graph,jack,cathy)&&(!graph.edgeExists(jack, cathy))));
		System.out.println("Are Jack and George indirect friends?: "+(isPathBF(graph,jack,george)&&(!graph.edgeExists(jack, george))));

	}


}
