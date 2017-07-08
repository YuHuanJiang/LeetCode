package cloneGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import entity.UndirectedGraphNode;

public class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return node;
        
        UndirectedGraphNode tmp = new UndirectedGraphNode(node.label);
        Map<UndirectedGraphNode, UndirectedGraphNode> container = new HashMap<>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
        
        container.put(node, tmp);
        queue.offer(node);
        UndirectedGraphNode n;
        List<UndirectedGraphNode> neighors;
        while(!queue.isEmpty()) {
        	n = queue.poll();
        	neighors = n.neighbors;
        	
        	for(UndirectedGraphNode neighbour : neighors) {
        		if(!container.containsKey(neighbour)) {
        			UndirectedGraphNode newTmpNode = new UndirectedGraphNode(neighbour.label);
        			container.put(neighbour, newTmpNode);
        			queue.offer(neighbour);
        		}
        		container.get(n).neighbors.add(container.get(neighbour));
        	}
        }
        
        return tmp;
    }
}
