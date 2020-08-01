
import java.io.*;
import java.util.Scanner;

/*
Complete your details...
Name and Surname: Caleb Johnstone
Student/staff Number: u19030119
*/

/*
 You must complete this class to solve the Chinese Postman problem for any given graph.
 Additional instructions are provided in comments throughout the class.
 */
 
public class Graph
{
	/*
	1. You may not change the signatures of any of the given methods.  You may 
	however add any additional methods and/or fields which you may require to aid 
	you in the completion of this assignment.
	
	2. You will have to design and implement your own Graph class in terms of 
	graph representation.
	
	3. You may add any additional classes and/or methods to your assignment.
	*/

	//number of nodes in the graph
	private int numNodes = 0;

	//adjacency matrix
	private edgeNode[][] adjacencyMatrix;

	//number of edges matrix
	private int[][] numberOfEdges;

	private String route;//

	//array of the node labels
	private String[] nodes;

	//array of the node degrees
	private int[] degrees;

	//numVisited in DFS
	private int numVisited = 0;

	//matrix for number of visits happening at [i, j]
	private int[][] numVisitEdges;
	
	public Graph(String f)
	{
		/*
		The constructor receives the name of the file from which a graph
		is read and constructed.
		*/

		this.reconstructGraph(f);
	}
	
	public Graph clone()
	{
		/*
		The clone method should return a deep copy/clone
		of this graph.
		*/
		Graph newGraph = new Graph(this);
		return newGraph;
	}
		
	public boolean reconstructGraph(String fileName)
	{
		/*
		This method should discard the current graph and construct a new
		graph contained in the file named "fileName". Return true if reconstruction
		was successful.
		*/

		try{
			//use scanner to read in the text file
			File file = new File(fileName);
			Scanner sc;
			sc = new Scanner(file);

			this.numNodes = Integer.parseInt(sc.nextLine());

			//intitialise the nodes array AND the degrees array
			this.nodes = new String[this.numNodes];
			this.degrees = new int[this.numNodes];			

			for(int i = 0; i < this.numNodes; i++){
				this.nodes[i] = null;
				this.degrees[i] = 0;
			}			

			//initialise the adjacency matrix and the number of nodes matrix
			this.adjacencyMatrix = new edgeNode[this.numNodes][this.numNodes];
			this.numberOfEdges = new int[this.numNodes][this.numNodes];

			//set all of the number of nodes to 0 and lists in the adjacencyMatrix to null
			for(int i = 0; i < this.numNodes; i++){
				for(int j = 0; j < this.numNodes; j++){
					this.numberOfEdges[i][j] = 0;
					this.adjacencyMatrix[i][j] = null;
				}			
			}

			//set numVisited to 0
			this.numVisited = 0;

			int nodeCounter = 0;

			//read in the edge info
			while(sc.hasNextLine()){
				String line = sc.nextLine();

				//A,B,2

				//split the line into a string array
				String[] lineValues = line.split(",");

				//stop if get to empty line
				if(lineValues.length == 1){
					break;
				}

				//get the names of the nodes
				String nodeA = lineValues[0];
				String nodeB = lineValues[1];

				//get the index of the nodes in the nodes array
				if(!this.nodeExists(nodeA)){
					this.insertNode(nodeA, nodeCounter++);
				}				

				if(!this.nodeExists(nodeB)){
					this.insertNode(nodeB, nodeCounter++);
				}

				int x = this.getNodeIndex(nodeA);
				int y = this.getNodeIndex(nodeB);

				//get the edge weight
				int weight = Integer.parseInt(lineValues[2]);

				//set the edge weight
				this.setEdgeWeight(x, y, weight);

				//make sure into the other list (if there is one --> will be same list <=> x = y)
				/*if(x != y){
					this.setEdgeWeight(y, x, weight);
				}*/		

				//increase the degrees of both nodes
				this.increaseDegree(x, y);
				

				//DEBUG
				//printAdjacencyMatrix("");
			}//while read from file

			sc.close();

			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}		
	}

	public int numEdges(String u, String v)
	{
		/*
		This method returns the number of direct edges between u and v vertices.
		If there are no direct edges, return 0.
		In there is 1 or more direct edges, return the number of edges.
		*/
		if(!this.nodeExists(u) || !this.nodeExists(v)){
			return 0;
		}

		return this.numberOfEdges[this.getNodeIndex(u)][this.getNodeIndex(v)];
	}
	
	public int getDegree(String u)
	{
		/*
		This method returns the degree of vertex u.
		*/
		int degree = this.getDegree(this.getNodeIndex(u));
		return (degree > 0) ? degree : 0;
	}

	public void printDegree(String u){
		//System.out.println("degree(" + u + ") = " + this.getDegree(u));
	}	
	
	public boolean changeLabel(String v, String newLabel)
	{
		/*
		Change the label of the vertex v to newLabel.  The method returns true
		if the label change was successful, and false otherwise.
		*/
		if(this.nodeExists(newLabel)){
			return false;
		}
		else{
			this.setNodeLabel(this.getNodeIndex(v), newLabel);
			return true;
		}
	}

	public void printChangeLabel(String v, String newLabel, String graphName){
		this.printAdjacencyMatrix(graphName);
	}

	public String depthFirstTraversal(String v)
	{
		/*
		This method returns a depth first traversal of the graph,
		starting with node v. When there is choice between vertices,
		choose in alphabetical order.
		
		The list must be separated by commas containing no additional 
		white space.
		*/

		//use the DFS algorithm
		if(this.nodeExists(v)){
			String list = "";

			//array for node numbers
			int[] numbers = new int[this.getNumberOfNodes()];

			//for all v| num(v) := 0
			for (int i = 0; i < numbers.length; i++){
				numbers[i] = 0;
			}

			String vertex = v;
			this.numVisited = 0;
			String[] alphaList = this.getAlphabeticalNodeList();

			//there exsits v| num(v) == 0
			while(vertex.length() > 0){
				this.DFS(vertex, numbers, alphaList);//this.getLargestNum(numbers)
				vertex = this.existsZeroNode(numbers);
			}

			//all nodes in G have been visited --> now contruct the list in the order of the numbers
			for(int j = 1; j <= this.getNumberOfNodes(); j++){
				//find the node with num(vertex) == j
				String node = "";

				for(int k = 0; k < numbers.length; k++){
					if(numbers[k] == j){
						node = this.getNodeLabel(k);
						break;
					}
				}

				//append this node label to the list
				list += node + ",";
			}

			if(list.length() == 0){
				return "";
			}

			//remove the comma at the end
			return list.substring(0, list.length()-1);
		}
		else{
			return "";
		}
	}

	private String existsZeroNode(int[] numbers){
		String[] alphaList = this.getAlphabeticalNodeList();

		for(int i = 0; i < numbers.length; i++){
			if(numbers[this.getNodeIndex(alphaList[i])] == 0){
				return alphaList[i];
			}
		}

		return "";
	}

	private int getLargestNum(int[] numbers){
		int max = numbers[0];

		for(int i = 1; i < numbers.length; i++){
			max = Math.max(numbers[i], max);
		}

		return max;
	}

	private void DFS(String v, int[] numbers, String[] alphaList){
		//num(v) := i++
		numbers[this.getNodeIndex(v)] = ++this.numVisited;//numbers[] is || nodes[]

		//get row vector of the lists of edges that have node v as one of the nodes
		edgeNode[] lists = this.adjacencyMatrix[this.getNodeIndex(v)];

		for(int j = 0; j < alphaList.length; j++){
			int nodeIndex = this.getNodeIndex(alphaList[j]);

			if(lists[nodeIndex] != null){
				if(numbers[nodeIndex] == 0){
					this.DFS(alphaList[j], numbers, alphaList);
				}
			}
		}
	}

	public void printDFS(String graphName, String v){
		/*System.out.println("Printing DFS traversal for Graph " + graphName + ", start = " + v);
		System.out.println();
		System.out.println(this.depthFirstTraversal(v));
		System.out.println();*/
	}
	
	public String getOdd()	
	{
		/*
		This method returns a list of all vertices with odd degrees.
		The vertices should be sorted alphabetically. If there are no
		vertices with odd degrees, return an empty string.
		
		The list must be separated by commas containing no additional 
		white space.
		*/

		if(this.isEmpty()){
			return "";
		}

		String list = "";

		//get a sorted list of the node labels --> inserted by appending
		String[] alphaNodeList = this.getAlphabeticalNodeList();

		//traverse the degrees array to find the nodes with odd degress
		for(int i = 0; i < this.numNodes; i++){
			if(this.getDegree(alphaNodeList[i]) % 2 != 0){
				list += alphaNodeList[i] + ",";
			}
		}

		if(list.length() == 0){
			return "";
		}
		else{
			String newList = list.substring(0, list.length()-1);
			return newList;
		}
	}

	public void printOddList(String graphName){
		//System.out.println(graphName + ".getOdd() => " + this.getOdd());
	}

	public String[] getNodeList(){
		return this.nodes;
	}

	public String[] getAlphabeticalNodeList(){
		String[] list = new String[this.getNumberOfNodes()];

		//copy the current contents of nodes
		for(int i = 0; i < this.getNumberOfNodes(); i++){
			list[i] = this.getNodeLabel(i);
		}

		//bubble sort
		for(int i = 0; i < this.getNumberOfNodes()-1; i++){
			for(int j = this.getNumberOfNodes()-1; j > i; j--){
				if(list[j].compareTo(list[j-1]) < 0){
					swap(list, j, j-1);
				}
			}
		}

		return list;
	}

	private void swap(String[] list, int a, int b){
		String temp = list[a];
		list[a] = list[b];
		list[b] = temp;
	}
	
	public String getPath(String u, String v)
	{
		/*
		This method should return the shortest path between two vertices.
		Inputs are the vertex labels, as read from the input file.
		
		The returned string should be the vertex labels, starting with u and
		ending with v. The list must be separated by commas containing no additional 
		white space.
		
		Assumption: both vertices are present in the graph, and a path between 
		them exists.
		*/

		//use Dijkstra's shortest path algorithm
		return this.DijkstraShortestPath(u, v, "path");
	}
	
	public int getChinesePostmanCost()
	{
		/*
		This method should return the cost of the optimal Chinese Postman
		route determined by your algorithm.
		*/

		//does it matter which node we start at for the graph ??? (I don't think it does)
		return Integer.parseInt(this.getChinesePostmanRoute(this.getNodeLabel(0), "cost").toString());
	}
		
	public Graph getChinesePostmanGraph()
	{
		/*
		This method should return your graph with the extra edges as constructed
		during the optimal Chinese postman route calculation.
		*/
		
		//does it matter which node we start at for the graph ??? (I don't think it does)
		return (Graph) this.getChinesePostmanRoute(this.getNodeLabel(0), "graph");
	}
		
		
	public String getChinesePostmanRoute(String v)
	{
		/*
		This method should return the circular optimal Chinese postman path from v 
		back to v. If there are vertices with odd degrees, return "not available".
		Otherwise, return a list of vertices starting and ending in v.
		When there are alternative paths, choose the next vertex in alphabetical order.

		The list must be separated by commas containing no additional 
		white space.
		*/

		if(this.existsOddNodes()){
			return "not available";
		}
		else{
			Graph modifiedGraph = this.clone();//
			return modifiedGraph.getCircuit(v);
		}
	}

	private Object getChinesePostmanRoute(String v, String type){
			//Chinese Postman algorithm

			//1. Find all odd-degree vertices
			String oddList = this.getOdd();
			String[] oddNodes = oddList.split(",");

			//no odd nodes
			if(oddNodes[0].length() == 0){
				if(type.compareTo("cost") == 0){
					return this.getTotalWeight();
				}
				else if(type.compareTo("graph") == 0){
					return this;
				}
			}

			//2. Find all possible non-overlapping pairings of odd vertices
			String[] pairs = this.getNodeCombinations(oddNodes);

			//get the sets of pairings
			String[][] pairsSets = this.getNonOverlappingPairSets(pairs, 0);
			
			//only keep the non-null entries

			//count number of non-null columns
			int columns = 0;
			for(int i = 0; i < pairsSets.length && pairsSets[0][i] != null; i++, columns++);

			int rows = pairsSets[0].length;
			String[][] nonNullPairsSets = new String[rows][columns];

			for(int i = 0; i < rows; i++){
				for(int j = 0; j < columns; j++){
					nonNullPairsSets[i][j] = pairsSets[i][j];
				}
			}

			// --> duplicates do not matter as they have the same total distance so they will not be picked as the minimum total distance <--

			//3. For each pair {u,v}, find the edges that make up the shortest path between u and v AND 4. Choose the set of pairings that minimises total travelling distance
			int minPathSum = 0;
			int minPathSumIndex = 0;

			for(int j = 0; j < columns; j++){
				minPathSum += this.getPathLength(nonNullPairsSets[0][j]);
			}			

			for(int i = 1; i < rows; i++){
				//calculate the path sum
				int currentPathSum = 0;

				for(int j = 0; j < columns; j++){
					currentPathSum += this.getPathLength(nonNullPairsSets[i][j]);
				}

				//new minPathSum
				if(currentPathSum < minPathSum){
					minPathSum = currentPathSum;
					minPathSumIndex = i;
				}
			}

			//5. Create a copy of the original graph, and add to it the edges identified in Step 4
			Graph modifiedGraph = new Graph(this);

			//add the new edges
			for(int i = 0; i < columns; i++){
				String pair = nonNullPairsSets[minPathSumIndex][i];
				String[] pairNodes = pair.split(",");
				String A = pairNodes[0];
				String B = pairNodes[1];

				//add an edge(A,B)
				edgeNode head = modifiedGraph.getEdgeWeights(modifiedGraph.getNodeIndex(A), modifiedGraph.getNodeIndex(B));

				if(head == null){
					//duplicate all edges on the path between A and B
					String shortestPath = this.getPath(A, B);
					String[] shortestPathNodes = shortestPath.split(",");
					
					for(int k = 0; k < shortestPathNodes.length-1; k++){
						//get the nodes for the current edge
						String a = shortestPathNodes[k];
						String b = shortestPathNodes[k+1];

						//get the weight for edge(a,b)
						int abWeight = modifiedGraph.getEdgeWeights(modifiedGraph.getNodeIndex(a), modifiedGraph.getNodeIndex(b)).weight;

						//duplicate the current edge
						modifiedGraph.setEdgeWeight(modifiedGraph.getNodeIndex(a), modifiedGraph.getNodeIndex(b), abWeight);
						modifiedGraph.setEdgeWeight(modifiedGraph.getNodeIndex(b), modifiedGraph.getNodeIndex(a), abWeight);

						//increase the degree of both nodes
						modifiedGraph.increaseDegree(modifiedGraph.getNodeIndex(a), modifiedGraph.getNodeIndex(b));
					}
				}
				else{
					//add the edge that is already there
					modifiedGraph.setEdgeWeight(modifiedGraph.getNodeIndex(A), modifiedGraph.getNodeIndex(B), head.weight);
					modifiedGraph.setEdgeWeight(modifiedGraph.getNodeIndex(B), modifiedGraph.getNodeIndex(A), head.weight);

					//increase the degree of both nodes
					modifiedGraph.increaseDegree(modifiedGraph.getNodeIndex(A), modifiedGraph.getNodeIndex(B));
				}
			}

			//6. The length of an optimal Chinese postman route is the sum of all edges + the total length found in Step 4
			int oldWeight = this.getTotalWeight();
			int addWeights = oldWeight + minPathSum;

			if(type.compareTo("cost") == 0){
				return addWeights;//newTotalWeight
			}
			else if(type.compareTo("graph") == 0){
				return modifiedGraph;
			}
			else{
				return modifiedGraph.getCircuit(v);
			}
	}

	private String getCircuit(String v){
		if(getNumberOfNodes() == 0 || !this.nodeExists(v)){
			return "hi " + v;
		}

		int[] edgeCount = new int[getNumberOfNodes()];

		for(int i = 0; i < getNumberOfNodes(); i++){
			edgeCount[i] = getDegree(i);
		}

		//current path --> contains nodeIndexes of nodes in the path
		edgeNode currentPath = null;

		int number = getTotalNumEdges()+1;//getNumberOfNodes()+1
		String[] circuit = new String[number];
		int circuitCounter = 0;

		currentPath = new edgeNode(this.getNodeIndex(v), null);
		int currentNode = this.getNodeIndex(v);

		while(currentPath != null){
			//if remaining edge
			if(edgeCount[currentNode] > 0){
				//push node
				edgeNode newNode = new edgeNode(currentNode, currentPath);
				currentPath = newNode;

				//find next vertex
				int nextNode = -1;
				
				String[] alphaList = getAlphabeticalNodeList();

				for(int k = 0; k < getNumberOfNodes(); k++){
					if(getEdgeWeights(currentNode, getNodeIndex(alphaList[k])) != null){
						nextNode = getNodeIndex(alphaList[k]);
						break;
					}
				}

				if(nextNode == -1){
					break;//
				}

				//remove edge
				edgeCount[currentNode]--;
				edgeCount[nextNode]--;

				adjacencyMatrix[currentNode][nextNode] = adjacencyMatrix[currentNode][nextNode].next;
				adjacencyMatrix[nextNode][currentNode] = adjacencyMatrix[nextNode][currentNode].next;

				currentNode = nextNode;
			}
			else{
				//add to circuit
				circuit[circuitCounter++] = this.getNodeLabel(currentNode);

				//backtracking
				currentNode = currentPath.weight;
				currentPath = currentPath.next;
			}
		}

		//print the circuit in reverse
		this.route = "";

		for(int i = circuit.length-1; i > 0; i--){
			this.route += circuit[i] + ",";
		}

		this.route += circuit[0];

		return this.route;
	}

	public int getTotalWeight(){
		int totalEdgeWeight = 0;

		for(int j = 0; j < this.getNumberOfNodes(); j++){
			for(int i = j; i < this.getNumberOfNodes(); i++){
				edgeNode ptr = this.getEdgeWeights(i, j);

				while(ptr != null){
					totalEdgeWeight += ptr.weight;
					ptr = ptr.next;
				}
			}
		}

		return totalEdgeWeight;
	}

	private int getTotalNumEdges(){
		int edgeCount = 0;

		for(int j = 0; j < this.getNumberOfNodes(); j++){
			for(int i = j; i < this.getNumberOfNodes(); i++){
				edgeCount += this.numEdges(this.getNodeLabel(j), this.getNodeLabel(i));
			}
		}

		return edgeCount;
	}

	public int getPathLength(String pair){
		String[] pairNodes = pair.split(",");
		String A = pairNodes[0];
		String B = pairNodes[1];

		//get the distance B (which is the destination node)
		return Integer.parseInt(this.DijkstraShortestPath(A, B, "distance"));		
	}

	private boolean existsOddNodes(){
		String oddList = this.getOdd();

		return (oddList.length() != 0);
	}

	private String[] getNodeCombinations(String[] nodes){
		int n = (nodes.length*(nodes.length-1))/2;

		String[] pairs = new String[n];
		int pairCounter = 0;

		for(int i = 0; i < nodes.length; i++){
			for(int j = 0; j < nodes.length; j++){
				if(i != j){//not edge to itself
					//check if the pair has not been found before
					boolean found = false;

					//arrange pair alphabetically
					String u = nodes[i];
					String v = nodes[j];

					String a = (u.compareTo(v) < 0) ? u : v;
					String b = (u.compareTo(v) < 0) ? v : u;

					String pair = a + "," + b;

					for(int k = 0; k < pairCounter && !found; k++){
						if(pairs[k].compareTo(pair) == 0){
							found = true;
						}
					}

					//not already added to the pairs[]
					if(!found){
						pairs[pairCounter++] = pair;
					}
				}
			}
		}

		return pairs;
	}

	private String[][] getNonOverlappingPairSets(String[] pairs, int actualLength){
		int number = (actualLength > 0) ? actualLength : pairs.length;
		String[][] pairsSets = new String[number][number];//will not be completely full

		//initialise to null
		for(int i = 0 ; i < number; i++){
			pairsSets[i] = null;
		}

		//for each pair construct an array containing pairs = {itself as (u,v) U all pairs that do not contain u or v}
		for(int i = 0; i < number; i++){
			//construct the array
			pairsSets[i] = new String[number];//will not be completely full
			
			//add itself
			pairsSets[i][0] = pairs[i];
			int pairCounter = 1;

			//add all pairs that do not contain u or v from any pair (u, v) in pairsSets[i]
			for(int j = 0; j < number; j++){
				String[] pairNodes = pairs[j].split(",");
				String A = pairNodes[0];
				String B = pairNodes[1];

				boolean found = false;

				for(int k = 0; k < pairCounter && !found; k++){
					//check if the pair does not contain u or v
					String[] currentValidPair = pairsSets[i][k].split(",");
					String u = currentValidPair[0];
					String v = currentValidPair[1];					

					//(u,v) is mutually exclusive to (A,B)
					if(((A.compareTo(u) == 0 || A.compareTo(v) == 0) || (B.compareTo(u) == 0 || B.compareTo(v) == 0))){
						found = true;
					}
				}

				if(!found){
					//add the pair to the array
					pairsSets[i][pairCounter++] = pairs[j];
				}
			}
		}

		return pairsSets;
	}

	//helper functions

	//isEmpty
	private boolean isEmpty(){
		return (this.numNodes == 0);
	}

	//copy constructor
	public Graph(Graph other){
		//copy the number of nodes
		this.numNodes = other.getNumberOfNodes();

		//copy the nodes array AND copy the degrees array
		this.nodes = new String[this.numNodes];
		this.degrees = new int[this.numNodes];

		for(int i = 0; i < this.numNodes; i++){
			this.insertNode(other.getNodeLabel(i), i);
			this.setDegree(i, other.getDegree(i));
		}

		//copy the adjacency matrix and the number of nodes matrix
		this.adjacencyMatrix = new edgeNode[this.numNodes][this.numNodes];
		this.numberOfEdges = new int[this.numNodes][this.numNodes];

		for(int i = 0; i < this.numNodes; i++){
			for(int j = 0; j < this.numNodes; j++){
				this.numberOfEdges[i][j] = 0;
				this.setEdgeWeights(i, j, other.getEdgeWeights(i, j));
			}
		}

		//set numVisited to 0
		this.numVisited = 0;
	}

	//get the number of nodes
	public int getNumberOfNodes(){
		return this.numNodes;
	}

	private void setEdgeWeights(int x, int y, edgeNode head){
		this.adjacencyMatrix[x][y] = null;

		edgeNode ptr = head;

		while(ptr != null){
			this.setEdgeWeight(x, y, ptr.weight);
			ptr = ptr.next;
		}
	}

	//set edge weight value for the adjacency matrix
	private void setEdgeWeight(int x, int y, int value){
		//insert into the adjancency matrix list
		this.insertEdgeWeight(x, y, value);

		//increase the number of edges between u and v
		this.numberOfEdges[x][y]++;
	}

	private void insertEdgeWeight(int x, int y, int value){
		edgeNode head = this.adjacencyMatrix[x][y];

		if(head == null){
			this.adjacencyMatrix[x][y] = new edgeNode(value, null);
			return;
		}

		edgeNode ptr = head;

		while(ptr.next != null && (ptr.next).weight < value){
			ptr = ptr.next;
		}

		if(ptr == head && head.weight >= value){
			this.adjacencyMatrix[x][y] = new edgeNode(value, head);		
		}
		else{			
			ptr.next = new edgeNode(value, ptr.next);
		}
	}

	//get edge weight head for the adjacency matrix
	public edgeNode getEdgeWeights(int x, int y){
		return this.adjacencyMatrix[x][y];
	}

	public void printNumberOfEdges(String A, String B){
		//System.out.println("numEdges(" + A + ", " + B + ") => " + this.numEdges(A, B));
	}

	//print adjacency matrix
	public void printAdjacencyMatrix(String name){
		System.out.println();
		System.out.println("Printing " + name);
		System.out.println();
		System.out.print("Nodes: ");

		for(int i = 0; i < this.numNodes; i++){
			System.out.print(this.nodes[i] + "  ");
		}

		System.out.println();
		System.out.println();

		/*for(int i = 0; i < this.numNodes; i++){
			System.out.print(this.nodes[i] + ":  ");

			for(int j = 0; j < this.numNodes; j++){
				if(this.adjacencyMatrix[i][j] != null){
					System.out.print(this.nodes[j] + this.getEdgeWeightList(this.adjacencyMatrix[i][j]) + "  ");
				}							
			}			

			System.out.println();
			System.out.println();
		}*/
	}

	private String getEdgeWeightList(edgeNode head){
		if(head == null){
			return "[]";
		}
		else{
			String list = "[";
			
			edgeNode ptr = head;

			while(ptr.next != null){
				list += ptr.weight + ", ";
				ptr = ptr.next;
			}

			list += ptr.weight + "]";
			return list;
		}
	}

	//get node label
	public String getNodeLabel(int x){
		return this.nodes[x];
	}

	public void setNodeLabel(int x, String label){
		this.nodes[x] = label;
	}

	//get node index
	public int getNodeIndex(String label){
		for(int i = 0; i < this.numNodes; i++){
			if(this.nodes[i] != null && this.nodes[i].equals(label)){
				return i;
			}
		}

		return -1;
	}

	//node exists
	private boolean nodeExists(String label){
		for(int i = 0; i < this.numNodes; i++){
			if(this.nodes[i] != null && this.nodes[i].equals(label)){
				return true;
			}
		}

		return false;
	}

	//insert node label
	private void insertNode(String label, int nodeCounter){
		//set the label at the new last spot
		this.setNodeLabel(nodeCounter, label);
	}
	
	//get the degree of a node using the index
	private int getDegree(int x){
		if(x < 0 || x >= this.getNumberOfNodes()){
			return -1;
		}

		return this.degrees[x];
	}

	//set the degree
	private void setDegree(int x, int d){
		this.degrees[x] = d;
	}

	//increase the degree of two nodes when reading in edge info
	private void increaseDegree(int x, int y){
		this.degrees[x]++;
		this.degrees[y]++;
	}

	private void decreaseDegrees(String v, String u){
		this.degrees[this.getNodeIndex(v)]--;
		this.degrees[this.getNodeIndex(u)]--;
	}

	//get the shortest path
	private String DijkstraShortestPath(String u, String v, String type){
		if(u.compareTo(v) == 0){
			if(type.compareTo("path") == 0){
				return u;
			}
			else{
				//distance(u,u) == 0
				return "0";
			}			
		}

		//find the shortest path
		
		//distance[] || nodes[]
		Integer[] distances = new Integer[this.getNumberOfNodes()];

		//initialise distances
		for(int i = 0; i < distances.length; i++){
			distances[i] = null; //instead of Infinity
		}

		distances[this.getNodeIndex(u)] = 75;//

		//predecessor[] || nodes[]
		String[] predecessor = new String[this.getNumberOfNodes()];

		//initialise the predecessors
		for(int i = 0; i < predecessor.length; i++){
			predecessor[i] = null;
		}

		//visited[] || nodes[]
		boolean[] visited = new boolean[this.getNumberOfNodes()];

		for(int i = 0; i < visited.length; i++){
			visited[i] = false;
		}

		String currentNode = u;

		while(this.existsUnvisited(visited)){
			//set currentNode
			//currentNode = this.getSmallestDistanceNode(distances, visited, u);

			System.out.println("currentNode: " + currentNode);

			//remove currentNode from unvisited "bucket"
			visited[this.getNodeIndex(currentNode)] = true;

			//row vector containing the lists of edges connecting to currentNode
			edgeNode[] lists = this.adjacencyMatrix[this.getNodeIndex(currentNode)];

			//for every node
			for(int i = 0; i < lists.length; i++){
				//check if the node is a neighbour
				if(lists[i] != null){
					//check if the neighbour is unvisited
					//if(!visited[i]){
						System.out.println("adjacent node: " + this.getNodeLabel(i));

						//newDist := curr.dist + lengthOfShortestEdge(curr, neighbour n)
						if(distances[this.getNodeIndex(currentNode)] == null){
							continue;
						}

						Integer distanceValue = distances[this.getNodeIndex(currentNode)];

						edgeNode ptr = lists[i];						
						int edgeWeight = ptr.weight;

						Integer newDistance = distanceValue + Integer.valueOf(edgeWeight);

						//if longer path
						if(distances[i] == null || newDistance.compareTo(distances[i]) > 0){
							distances[i] = newDistance;
							predecessor[i] = currentNode;
						}//if longer path
					//}//if unvisited
				}//if neighbour
			}//for each node is nodes[]

			currentNode = this.getSmallestDistanceNode(distances, visited, u);//after ???
			System.out.println();
		}

		if(type.compareTo("path") == 0){
			//construct the shortest path string
			String path = "";
			currentNode = v;

			while(currentNode.compareTo(u) != 0){
				path = "," + currentNode + path;
				currentNode = predecessor[this.getNodeIndex(currentNode)];	
			}

			path = u + path;

			return path;
		}
		else{
			//type is "distance" --> return the distance as a string
			return Integer.toString(distances[this.getNodeIndex(v)]);
		}
	}

	private String getSmallestDistanceNode(Integer[] distances, boolean[] visited, String u){
		Integer minDistance = 0;
		String minDistNode = u;

		//get max distance
		for(int i = 0; i < distances.length; i++){
			if(distances[i] != null && !visited[i]){
				if(distances[i].compareTo(minDistance) > 0){
					minDistance = distances[i];
					minDistNode = this.getNodeLabel(i);
				}				
			}
		}

		/*for(int i = 0; i < distances.length; i++){
			//has a distance and has not been visited yet
			if(distances[i] != null && !visited[i] && distances[i].compareTo(0) > 0){
				if(distances[i].compareTo(minDistance) < 0 || (distances[i].compareTo(minDistance) == 0 && this.getNodeLabel(i).compareTo(minDistNode) < 0)){
					minDistance = distances[i];
					minDistNode = this.getNodeLabel(i);
				}
			}			
		}*/

		return minDistNode;
	}	

	private boolean existsUnvisited(boolean[] visited){
		for(int i = 0; i < visited.length; i++){
			if(!visited[i]){
				return true;
			}
		}

		return false;
	}
}
