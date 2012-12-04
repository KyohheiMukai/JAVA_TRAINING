package ch17.ex17_05;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;

public final class ResourceManager {

	final ReferenceQueue<Object> queue;
	final Map<Reference<?>, Resource> refs;
	boolean shutdown = false;

	public ResourceManager(){
		queue = new ReferenceQueue<Object>();
		refs = new HashMap<Reference<?>, Resource>();

		// リソースの初期化
	}

	public synchronized void shutdown(){
		if(!shutdown){
			shutdown = true;
		}
	}

	public synchronized Resource getResource(Object key) {
		if(shutdown)
			throw new IllegalStateException();
		Resource res = new ResourceImpl(key);
		Reference<?> ref = new PhantomReference<Object>(key, queue);
		refs.put(ref, res);
		return res;
	}

	private static class ResourceImpl implements Resource {

		int keyHash;
		boolean needsRelease = false;

		ResourceImpl(Object key) {
			keyHash = System.identityHashCode(key);

			//外部リソースの設定

			needsRelease = true;
		}

		@Override
		public void use(Object key, Object... args) {
			if(System.identityHashCode(args) != keyHash)
				throw new IllegalArgumentException("wrong key");

			//リソースの仕様

		}

		@Override
		public void release() {

			if(needsRelease)
				needsRelease = false;

		}

	}

}
