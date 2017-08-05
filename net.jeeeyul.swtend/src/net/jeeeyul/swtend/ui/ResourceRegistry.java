package net.jeeeyul.swtend.ui;

import java.util.HashMap;
import java.util.Map;

import net.jeeeyul.swtend.sam.Function1;

import org.eclipse.core.runtime.Assert;
import org.eclipse.swt.graphics.Resource;

public class ResourceRegistry<K, T extends Resource> {
	private Map<K, T> data = new HashMap<K, T>();
	private Function1<K, T> resourceFactory;

	public ResourceRegistry() {
	}

	public ResourceRegistry(Function1<K, T> factory) {
		this.resourceFactory = factory;
	}

	private T create(K key) {
		Assert.isNotNull(resourceFactory, "Resource factory was not set.");
		return resourceFactory.apply(key);
	}

	public void dispose() {
		for (T each : data.values()) {
			if (each != null && !each.isDisposed()) {
				each.dispose();
			}
		}
		data.clear();
	}

	public T get(K key) {
		T result = data.get(key);
		if (result == null || result.isDisposed()) {
			result = create(key);
			data.put(key, result);
		}
		return result;
	}

	public Function1<K, T> getResourceFactory() {
		return resourceFactory;
	}

	public void setResourceFactory(Function1<K, T> resourceFactory) {
		this.resourceFactory = resourceFactory;
	}

}
