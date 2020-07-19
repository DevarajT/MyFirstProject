//$Id$
package myPost.beans.list;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum SortingAlgorithm {
SELECTIONSORT("selection"),
BUBBLESORT("bubble");

private String name;

public String getName() {
	return name;
}

SortingAlgorithm(String name) {
	this.name = name;
}

private static final Map<String,SortingAlgorithm> ENUM_MAP;


// Build an immutable map of String name to enum pairs.
// Any Map impl can be used.

static {
    Map<String,SortingAlgorithm> map = new HashMap<String, SortingAlgorithm>();
    for (SortingAlgorithm instance : SortingAlgorithm.values()) {
        map.put(instance.getName(),instance);
    }
    ENUM_MAP = Collections.unmodifiableMap(map);
}

public static SortingAlgorithm get (String name) {
    return ENUM_MAP.get(name);
}


}
