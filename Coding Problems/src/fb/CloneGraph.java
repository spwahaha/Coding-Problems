package fb;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return clone(node, map);
    }
    
    private UndirectedGraphNode clone(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map){
        if(node == null) return null;
        if(map.containsKey(node)) return map.get(node);
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        for(UndirectedGraphNode nei : node.neighbors){
            newNode.neighbors.add(clone(nei, map));
        }
		return newNode;
    }
}
