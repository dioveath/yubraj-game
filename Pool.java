import java.util.*;

public class Pool<T> {

  private final int maxSize;
  private final List<T> freeObjects;
  private final PoolObjectFactory<T> factory;

  public Pool(PoolObjectFactory<T> factory, int maxSize){
    this.factory = factory;
    this.maxSize = maxSize;
    freeObjects = new ArrayList<T>(maxSize);
  }

  public T newObject(){
    T object = null;
    int len = freeObjects.size();
    if(len > 0){
      object = freeObjects.remove(len - 1);
    } else {
      object = factory.createObject();
    }
    return object;
  }

  public void removeObject(T object){
    if(freeObjects.size() < maxSize){
      freeObjects.add(object);
    }
  }

  public interface PoolObjectFactory<T> {
    public T createObject();
  }

}
